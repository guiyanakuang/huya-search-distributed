package com.huya.search.index.data.merger.aggr;

import com.huya.search.index.data.function.AggrFun;
import com.huya.search.index.data.merger.DefaultAggrFunUnit;
import org.apache.lucene.index.IndexableField;


/**
 * Created by zhangyiqun1@yy.com on 2017/11/20.
 */
public class LongSumListener extends DefaultAggrFunUnit<Long> {

    public static LongSumListener newInstance(String field) {
        return new LongSumListener(field);
    }

    private long number = 0L;

    private String field;

    private LongSumListener(String field) {
        this.field = field;
    }

    @Override
    public AggrFun getType() {
        return AggrFun.SUM;
    }

    @Override
    public void add(IndexableField field) {
        Number numberValue = field.numericValue();
        if (numberValue != null) {
            number += numberValue.longValue();
        }
        else {
            number += Long.parseLong(field.stringValue());
        }
    }

    @Override
    public IndexableField result() {
        return AggrIndexableField.numberIndexableField(field, number);
    }

    @Override
    public Long getValue() {
        return number;
    }

    @Override
    public void clear() {
        number = 0L;
    }

    @Override
    public LongSumListener clone() {
        return newInstance(field);
    }
}
