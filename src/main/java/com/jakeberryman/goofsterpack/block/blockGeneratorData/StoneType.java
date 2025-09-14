package com.jakeberryman.goofsterpack.block.blockGeneratorData;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class StoneType {
    public String stoneType;
    public float hardness = 3;
    public float blastResistance = 3;

    public MapColor mapColor = MapColor.STONE;
    public SoundType sound = SoundType.STONE;
    public NoteBlockInstrument instrument = NoteBlockInstrument.BASEDRUM;
    public TagKey<Block> toolTypeTag;

    public StoneType(String stoneType) {
        this.stoneType = stoneType;
    }

    public StoneType(String stoneType, MapColor mapColor) {
        this(stoneType);
        this.mapColor = mapColor;
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
}