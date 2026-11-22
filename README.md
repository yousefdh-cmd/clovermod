# Clover Mod (مود البرسيم)

Minecraft **1.21.1** · **NeoForge** · requires **Extended Crafting** (7.0.x)

All clovers are crafted only on the **Ultimate 9x9 table** (81 items, shapeless). Right click to use (the clover is consumed).

| Clover | Recipe (81x) | Effects |
|---|---|---|
| Three-leaf | Wheat Seeds | Speed I (10 s) |
| Four-leaf | Three-leaf | Luck I + Hero of the Village I (30 min) |
| Five-leaf | Four-leaf | Luck II + Hero I (30 min) + Regeneration I (5 min) + Absorption II (5 min) |
| Six-leaf | Five-leaf | Luck III + Hero II (30 min) + Regeneration II (5 min) + Absorption IV (5 min) |
| Seven-leaf | Six-leaf | Luck IV + Hero III (30 min) + Regeneration III (10 min) + Absorption VI (10 min) |

## Build
Push to GitHub: the workflow in `.github/workflows/build.yml` builds the jar (Actions > build > Artifacts).
Locally: install Gradle 8.10+ and Java 21, then run `gradle build`. The jar is in `build/libs/`.

## Textures
Replace the 16x16 PNGs in `src/main/resources/assets/clovermod/textures/item/` (keep the same file names).

## Edit effects
`src/main/java/com/clovermod/ModItems.java` (effect, seconds, level).
