//package net.kuko.fisch;
//
//import net.minecraft.client.Minecraft;
//import net.minecraftforge.common.MinecraftForge;
//
//import java.util.UUID;
//
//@Mod(modid = "zombiedbcinfection", name = "Zombie DBC Infection", version = "1.0")
//public class ZombieDBCInfection {
//
//    public static final long TRANSFORM_TIME = 20 * 60 * 3; // 3 minutos
//
//    @Mod.EventHandler
//    public void preInit(FMLPreInitializationEvent e) {
//        MinecraftForge.EVENT_BUS.register(this);
//    }
//
//
//    /* =========================
//       INFECCIÓN POR MORDEDURA
//       ========================= */
//    @SubscribeEvent
//    public void onPlayerBitten(LivingHurtEvent event) {
//        if (event.entityLiving instanceof EntityPlayer &&
//                event.source.getEntity() instanceof EntityZombie) {
//
//            EntityPlayer player = (EntityPlayer) event.entityLiving;
//
//            if (!player.getEntityData().getBoolean("dbcInfected")) {
//                player.getEntityData().setBoolean("dbcInfected", true);
//                player.getEntityData().setLong("dbcInfectTime",
//                        player.worldObj.getTotalWorldTime());
//            }
//        }
//    }
//
//    /* =========================
//       CONTROL DE TIEMPO
//       ========================= */
//    @SubscribeEvent
//    public void onPlayerTick(LivingEvent.LivingUpdateEvent event) {
//        if (!(event.entityLiving instanceof EntityPlayer)) return;
//
//        EntityPlayer player = (EntityPlayer) event.entityLiving;
//        NBTTagCompound data = player.getEntityData();
//
//        if (data.getBoolean("dbcInfected")) {
//            long t = data.getLong("dbcInfectTime");
//            long now = player.worldObj.getTotalWorldTime();
//
//            if (now - t >= TRANSFORM_TIME) {
//                transform(player);
//            }
//        }
//    }
//
//
//    /* =========================
//       TRANSFORMACIÓN FINAL
//       ========================= */
//    private void transform(EntityPlayer player) {
//        if (player.worldObj.isRemote) return;
//
//        World world = player.worldObj;
//
//        EntityInfectedDBC zombie =
//                new EntityInfectedDBC(world, player);
//
//        zombie.setPosition(player.posX, player.posY, player.posZ);
//        world.spawnEntityInWorld(zombie);
//
//        player.attackEntityFrom(DamageSource.outOfWorld, Float.MAX_VALUE);
//    }
//
//    /* ============================================================
//       ENTIDAD FAKE PLAYER (ZOMBIE CON PODERES DBC REALES)
//       ============================================================ */
//    public static class EntityInfectedDBC extends EntityPlayer {
//
//        public EntityInfectedDBC(World world, EntityPlayer original) {
//            super(world, new GameProfile(
//                    UUID.randomUUID(),
//                    original.getCommandSenderName() + "_INFECTED"));
//
//            copyDBCData(original, this);
//            copyEquipment(original);
//
//            this.setHealth(this.getMaxHealth());
//
//            this.tasks.addTask(0, new EntityAISwimming(this));
//            this.tasks.addTask(1, new EntityAIAttackOnCollide(
//                    this, EntityPlayer.class, 1.2D, false));
//            this.tasks.addTask(2, new EntityAIWander(this, 0.8D));
//            this.tasks.addTask(3, new EntityAILookIdle(this));
//        }
//
//        @Override
//        public boolean isAIEnabled() {
//            return true;
//        }
//
//        @Override
//        public void onLivingUpdate() {
//            super.onLivingUpdate();
//
//            // Transformación automática
//            if (this.getHealth() < this.getMaxHealth() / 2) {
//                this.getEntityData().setByte("jrmcForm", (byte) 1); // SSJ
//            }
//
//            // Forzar ataque de ki
//            this.getEntityData().setBoolean("jrmcKame", true);
//        }
//
//        /* =========================
//           COPIAR DATOS DBC
//           ========================= */
//        private static void copyDBCData(EntityPlayer from, EntityPlayer to) {
//            NBTTagCompound f = from.getEntityData();
//            NBTTagCompound t = to.getEntityData();
//
//            if (f.hasKey("JRMCore")) {
//                t.setTag("JRMCore",
//                        f.getCompoundTag("JRMCore").copy());
//            }
//
//            String[] keys = {
//                    "jrmcRace", "jrmcClass", "jrmcPowerLvl",
//                    "jrmcEnergy", "jrmcStamina",
//                    "jrmcStr", "jrmcDex", "jrmcCon",
//                    "jrmcWil", "jrmcMind",
//                    "jrmcForm", "jrmcSkills"
//            };
//
//            for (String k : keys) {
//                if (f.hasKey(k)) {
//                    t.setTag(k, f.getTag(k).copy());
//                }
//            }
//        }
//
//        /* =========================
//           COPIAR ARMAS Y ARMADURA
//           ========================= */
//        private void copyEquipment(EntityPlayer p) {
//            for (int i = 0; i < 4; i++) {
//                if (p.getCurrentArmor(i) != null)
//                    this.setCurrentItemOrArmor(i + 1,
//                            p.getCurrentArmor(i).copy());
//            }
//
//            if (p.getHeldItem() != null)
//                this.setCurrentItemOrArmor(0,
//                        p.getHeldItem().copy());
//        }
//
//        @Override
//        public void addChatMessage(net.minecraft.util.IChatComponent p_145747_1_) {}
//    }
//}
//
