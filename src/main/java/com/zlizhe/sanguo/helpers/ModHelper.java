package com.zlizhe.sanguo.helpers;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.localization.CardStrings;

public class ModHelper {

    public static final String MOD_ID = "sanguo";
    public static String makePath(String id) {
        return MOD_ID + ":" + id;
    }
    public static String makeAssetPath(String path) {
        return MOD_ID + "/" + path;
    }

    public static CardStrings getCardStrings(String NAME, String DESCRIPTION) {
        CardStrings cardStrings = new CardStrings();
        cardStrings.NAME = NAME;
        cardStrings.DESCRIPTION = DESCRIPTION;
        return cardStrings;
    }


    // 如果按这个方法实现，在cards文件夹下分别放test_attack.png、test_power.png、test_skill.png即可
    private static String getTmpImgPath(AbstractCard.CardType t) {
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
    private static String getImgPath(AbstractCard.CardType t, String name) {
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