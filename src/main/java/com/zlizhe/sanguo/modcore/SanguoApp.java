package com.zlizhe.sanguo.modcore;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.zlizhe.sanguo.cards.Strike;

@SpireInitializer
public class SanguoApp implements EditCardsSubscriber {
    // 构造方法
    public SanguoApp() {
        BaseMod.subscribe(this);
    }

    // 注解需要调用的方法，必须写
    public static void initialize() {
        new SanguoApp();
    }

    // 当basemod开始注册mod卡牌时，便会调用这个函数
    @Override
    public void receiveEditCards() {
        // TODO 这里写添加你卡牌的代码
        BaseMod.addCard(new Strike());
    }
}