package com.zlizhe.sanguo.cards;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.zlizhe.sanguo.helpers.ModHelper;

public abstract class AbstractCard extends CustomCard {
    // useTmpArt表示是否使用测试卡图，当你卡图不够用时可以使用
    public AbstractCard(
            String ID,
            boolean useTmpArt,
            CardStrings strings,
            int COST,
            CardType TYPE,
            CardColor COLOR,
            CardRarity RARITY,
            CardTarget TARGET) {
        super(ModHelper.makePath(ID), strings.NAME, useTmpArt ? getTmpImgPath(TYPE) : getImgPath(TYPE, ID), COST, strings.DESCRIPTION, TYPE,
                COLOR, RARITY, TARGET);
    }

    // 如果按这个方法实现，在cards文件夹下分别放test_attack.png、test_power.png、test_skill.png即可
    public static String getTmpImgPath(CardType t) {
        String type;
        switch (t) {
            case ATTACK:
                type = "attack";
                break;
            case POWER:
                type = "power";
                break;
            case STATUS:
            case CURSE:
            case SKILL:
                type = "skill";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + t);
        }
        return String.format(ModHelper.makeAssetPath("img/cards/test_%s.png"), type);
    }

    // 如果实现这个方法，只要将相应类型的卡牌丢进相应文件夹即可，如攻击牌卡图添加进img/cards/attack/下
    public static String getImgPath(CardType t, String name) {
        String type;
        switch (t) {
            case ATTACK:
                type = "attack";
                break;
            case POWER:
                type = "power";
                break;
            case STATUS:
                type = "status";
                break;
            case CURSE:
                type = "curse";
                break;
            case SKILL:
                type = "skill";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + t);
        }
        return String.format(ModHelper.makeAssetPath("img/cards/%s/%s.png"), type, name.replace(ModHelper.makePath(""), ""));
    }
}