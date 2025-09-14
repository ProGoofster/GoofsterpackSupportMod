package com.jakeberryman.goofsterpack.block.customBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootTable;

public class CustomRedStoneOreBlock extends RedStoneOreBlock {
    private final IntProvider xpRange;
    public CustomRedStoneOreBlock(BlockBehaviour.Properties properties, IntProvider xpRange) {
        super(properties);
        this.xpRange = xpRange;
    }

    public CustomRedStoneOreBlock(BlockBehaviour.Properties properties){
        super(properties);
        this.xpRange = ConstantInt.of(0);
    }

    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.level.LevelReader level, net.minecraft.util.RandomSource randomSource, BlockPos pos, int fortuneLevel, int silkTouchLevel) {
        return silkTouchLevel == 0 ? this.xpRange.sample(randomSource) : 0;
    }
}
