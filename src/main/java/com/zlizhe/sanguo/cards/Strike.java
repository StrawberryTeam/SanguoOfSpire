package com.zlizhe.sanguo.cards;

public class Strike extends CustomCard {
    public Strike() {
        super(id, name, img, cost, rawDescription, type, color, rarity, target);
    }

    @Override
    public void upgrade() {

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
    }
}