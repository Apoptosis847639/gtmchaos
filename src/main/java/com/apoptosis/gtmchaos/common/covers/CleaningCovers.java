package com.apoptosis.gtmchaos.common.covers;

import com.gregtechceu.gtceu.api.capability.ICleanroomReceiver;
import com.gregtechceu.gtceu.api.capability.ICoverable;
import com.gregtechceu.gtceu.api.cover.CoverBehavior;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.ICleanroomProvider;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.api.machine.multiblock.DummyCleanroom;
import lombok.Getter;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

import java.util.Collections;

public class CleaningCovers extends CoverBehavior {
    private final ICleanroomProvider DUMMY_CLEANROOM;

    @Getter
    private final CleanroomType cleanroomType;

    public CleaningCovers(CoverDefinition definition, ICoverable coverHolder, Direction attachedSide, CleanroomType cleanroomType) {
        super(definition, coverHolder, attachedSide);
        this.cleanroomType = cleanroomType;
        DUMMY_CLEANROOM = DummyCleanroom.createForTypes(Collections.singletonList(cleanroomType));
    }

    @Override
    public void onAttached(ItemStack itemStack, ServerPlayer player) {
        var machine = MetaMachine.getMachine(coverHolder.getLevel(), coverHolder.getPos());
        if(machine instanceof ICleanroomReceiver receiver) {
            receiver.setCleanroom(DUMMY_CLEANROOM);
        }
    }

    @Override
    public void onRemoved() {
        var machine = MetaMachine.getMachine(coverHolder.getLevel(), coverHolder.getPos());
        if(machine instanceof ICleanroomReceiver receiver) {
            receiver.setCleanroom(null);
        }
    }
}
