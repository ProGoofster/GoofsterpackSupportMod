package com.jakeberryman.goofsterpack.block.blockGeneratorData;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class StoneType {

    private String stoneType;
    private float hardness = 3;
    private float blastResistance = 3;

    private MapColor mapColor = MapColor.STONE;
    private SoundType sound = SoundType.STONE;
    private NoteBlockInstrument instrument = NoteBlockInstrument.BASEDRUM;
    private TagKey<Block> toolTypeTag = BlockTags.MINEABLE_WITH_PICKAXE;

    public StoneType(String stoneType) {
        this.stoneType = stoneType;
    }

    public StoneType setStoneType(String stoneType) {
        this.stoneType = stoneType;
        return this;
    }

    public StoneType setStrength(float hardness, float blastResistance) {
        this.hardness = hardness;
        this.blastResistance = blastResistance;
        return this;
    }

    public StoneType setHardness(float hardness) {
        this.hardness = hardness;
        return this;
    }

    public StoneType setBlastResistance(float blastResistance) {
        this.blastResistance = blastResistance;
        return this;
    }

    public StoneType setMapColor(MapColor mapColor) {
        this.mapColor = mapColor;
        return this;
    }

    public StoneType setSound(SoundType sound) {
        this.sound = sound;
        return this;
    }

    public StoneType setInstrument(NoteBlockInstrument instrument) {
        this.instrument = instrument;
        return this;
    }

    public StoneType setToolTypeTag(TagKey<Block> toolTypeTag) {
        this.toolTypeTag = toolTypeTag;
        return this;
    }

    public String getStoneType() {
        return stoneType;
    }

    public float getHardness() {
        return hardness;
    }

    public float getBlastResistance() {
        return blastResistance;
    }

    public MapColor getMapColor() {
        return mapColor;
    }

    public SoundType getSound() {
        return sound;
    }

    public NoteBlockInstrument getInstrument() {
        return instrument;
    }

    public TagKey<Block> getToolTypeTag() {
        return toolTypeTag;
    }
}