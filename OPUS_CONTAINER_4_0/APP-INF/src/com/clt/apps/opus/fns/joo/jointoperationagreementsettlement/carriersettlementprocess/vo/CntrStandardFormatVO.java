/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CntrStandardFormatVO.java
*@FileTitle : CntrStandardFormatVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CntrStandardFormatVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CntrStandardFormatVO> models = new ArrayList<CntrStandardFormatVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String ord = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String vpsPortCd = null;

    /* Column Info */
    private String clptSeq = null;

    /* Column Info */
    private String clptIndSeq = null;

    /* Column Info */
    private String type = null;

    /* Column Info */
    private String subOrd = null;

    /* Column Info */
    private String weight = null;

    /* Column Info */
    private String total = null;

    /* Column Info */
    private String fQty1 = null;

    /* Column Info */
    private String fQty2 = null;

    /* Column Info */
    private String fQty3 = null;

    /* Column Info */
    private String fQty4 = null;

    /* Column Info */
    private String fQty5 = null;

    /* Column Info */
    private String fQty6 = null;

    /* Column Info */
    private String fQty7 = null;

    /* Column Info */
    private String fQty8 = null;

    /* Column Info */
    private String fQty9 = null;

    /* Column Info */
    private String fQty10 = null;

    /* Column Info */
    private String fQty11 = null;

    /* Column Info */
    private String fQty12 = null;

    /* Column Info */
    private String fQty13 = null;

    /* Column Info */
    private String fQty14 = null;

    /* Column Info */
    private String fQty15 = null;

    /* Column Info */
    private String fQty16 = null;

    /* Column Info */
    private String fQty17 = null;

    /* Column Info */
    private String fQty18 = null;

    /* Column Info */
    private String fQty19 = null;

    /* Column Info */
    private String fQty20 = null;

    /* Column Info */
    private String fQty21 = null;

    /* Column Info */
    private String fQty22 = null;

    /* Column Info */
    private String fQty23 = null;

    /* Column Info */
    private String fQty24 = null;

    /* Column Info */
    private String fQty25 = null;

    /* Column Info */
    private String fQty26 = null;

    /* Column Info */
    private String fQty27 = null;

    /* Column Info */
    private String fQty28 = null;

    /* Column Info */
    private String fQty29 = null;

    /* Column Info */
    private String fQty30 = null;

    /* Column Info */
    private String eQty1 = null;

    /* Column Info */
    private String eQty2 = null;

    /* Column Info */
    private String eQty3 = null;

    /* Column Info */
    private String eQty4 = null;

    /* Column Info */
    private String eQty5 = null;

    /* Column Info */
    private String eQty6 = null;

    /* Column Info */
    private String eQty7 = null;

    /* Column Info */
    private String eQty8 = null;

    /* Column Info */
    private String eQty9 = null;

    /* Column Info */
    private String eQty10 = null;

    /* Column Info */
    private String eQty11 = null;

    /* Column Info */
    private String eQty12 = null;

    /* Column Info */
    private String eQty13 = null;

    /* Column Info */
    private String eQty14 = null;

    /* Column Info */
    private String eQty15 = null;

    /* Column Info */
    private String eQty16 = null;

    /* Column Info */
    private String eQty17 = null;

    /* Column Info */
    private String eQty18 = null;

    /* Column Info */
    private String eQty19 = null;

    /* Column Info */
    private String eQty20 = null;

    /* Column Info */
    private String eQty21 = null;

    /* Column Info */
    private String eQty22 = null;

    /* Column Info */
    private String eQty23 = null;

    /* Column Info */
    private String eQty24 = null;

    /* Column Info */
    private String eQty25 = null;

    /* Column Info */
    private String eQty26 = null;

    /* Column Info */
    private String eQty27 = null;

    /* Column Info */
    private String eQty28 = null;

    /* Column Info */
    private String eQty29 = null;

    /* Column Info */
    private String eQty30 = null;

    /* Column Info */
    private String voidQty = null;

    /* Column Info */
    private String sumTotalTeu = null;

    /* Column Info */
    private String sumLdnTeu = null;

    /* Column Info */
    private String sumEtyTeu = null;

    /* Column Info */
    private String sumWgtTon = null;

    /* Column Info */
    private String sumWgtTeu = null;

    /* Column Info */
    private String sumTeuByWgt = null;

    /* Column Info */
    private String sumRfPlug = null;

    /* Column Info */
    private String allocSlot = null;

    /* Column Info */
    private String allocRf = null;

    /* Column Info */
    private String bsSlot = null;

    /* Column Info */
    private String bsRf = null;

    /* Column Info */
    private String excTeuTotal = null;

    /* Column Info */
    private String excTeuLdn = null;

    /* Column Info */
    private String excTeuEty = null;

    /* Column Info */
    private String excDwtTeu = null;

    /* Column Info */
    private String excDwtRf = null;

    /* Column Info */
    private String priSlot = null;

    /* Column Info */
    private String priPlug = null;

    /* Column Info */
    private String amtBuyExcSlots = null;

    /* Column Info */
    private String amtUsedPlugs = null;

    /* Column Info */
    private String ibCssmVoyNo = null;

    /* Column Info */
    private String obCssmVoyNo = null;

    /* Column Info */
    private String optionA = null;

    /* Column Info */
    private String optionB = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public CntrStandardFormatVO() {
    }

    public CntrStandardFormatVO(String ibflag, String pagerows, String ord, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String clptSeq, String clptIndSeq, String type, String subOrd, String weight, String total, String fQty1, String fQty2, String fQty3, String fQty4, String fQty5, String fQty6, String fQty7, String fQty8, String fQty9, String fQty10, String fQty11, String fQty12, String fQty13, String fQty14, String fQty15, String fQty16, String fQty17, String fQty18, String fQty19, String fQty20, String fQty21, String fQty22, String fQty23, String fQty24, String fQty25, String fQty26, String fQty27, String fQty28, String fQty29, String fQty30, String eQty1, String eQty2, String eQty3, String eQty4, String eQty5, String eQty6, String eQty7, String eQty8, String eQty9, String eQty10, String eQty11, String eQty12, String eQty13, String eQty14, String eQty15, String eQty16, String eQty17, String eQty18, String eQty19, String eQty20, String eQty21, String eQty22, String eQty23, String eQty24, String eQty25, String eQty26, String eQty27, String eQty28, String eQty29, String eQty30, String voidQty, String sumTotalTeu, String sumLdnTeu, String sumEtyTeu, String sumWgtTon, String sumWgtTeu, String sumTeuByWgt, String sumRfPlug, String allocSlot, String allocRf, String bsSlot, String bsRf, String excTeuTotal, String excTeuLdn, String excTeuEty, String excDwtTeu, String excDwtRf, String priSlot, String priPlug, String amtBuyExcSlots, String amtUsedPlugs, String ibCssmVoyNo, String obCssmVoyNo, String optionA, String optionB) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.ord = ord;
        this.vslCd = vslCd;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.vpsPortCd = vpsPortCd;
        this.clptSeq = clptSeq;
        this.clptIndSeq = clptIndSeq;
        this.type = type;
        this.subOrd = subOrd;
        this.weight = weight;
        this.total = total;
        this.fQty1 = fQty1;
        this.fQty2 = fQty2;
        this.fQty3 = fQty3;
        this.fQty4 = fQty4;
        this.fQty5 = fQty5;
        this.fQty6 = fQty6;
        this.fQty7 = fQty7;
        this.fQty8 = fQty8;
        this.fQty9 = fQty9;
        this.fQty10 = fQty10;
        this.fQty11 = fQty11;
        this.fQty12 = fQty12;
        this.fQty13 = fQty13;
        this.fQty14 = fQty14;
        this.fQty15 = fQty15;
        this.fQty16 = fQty16;
        this.fQty17 = fQty17;
        this.fQty18 = fQty18;
        this.fQty19 = fQty19;
        this.fQty20 = fQty20;
        this.fQty21 = fQty21;
        this.fQty22 = fQty22;
        this.fQty23 = fQty23;
        this.fQty24 = fQty24;
        this.fQty25 = fQty25;
        this.fQty26 = fQty26;
        this.fQty27 = fQty27;
        this.fQty28 = fQty28;
        this.fQty29 = fQty29;
        this.fQty30 = fQty30;
        this.eQty1 = eQty1;
        this.eQty2 = eQty2;
        this.eQty3 = eQty3;
        this.eQty4 = eQty4;
        this.eQty5 = eQty5;
        this.eQty6 = eQty6;
        this.eQty7 = eQty7;
        this.eQty8 = eQty8;
        this.eQty9 = eQty9;
        this.eQty10 = eQty10;
        this.eQty11 = eQty11;
        this.eQty12 = eQty12;
        this.eQty13 = eQty13;
        this.eQty14 = eQty14;
        this.eQty15 = eQty15;
        this.eQty16 = eQty16;
        this.eQty17 = eQty17;
        this.eQty18 = eQty18;
        this.eQty19 = eQty19;
        this.eQty20 = eQty20;
        this.eQty21 = eQty21;
        this.eQty22 = eQty22;
        this.eQty23 = eQty23;
        this.eQty24 = eQty24;
        this.eQty25 = eQty25;
        this.eQty26 = eQty26;
        this.eQty27 = eQty27;
        this.eQty28 = eQty28;
        this.eQty29 = eQty29;
        this.eQty30 = eQty30;
        this.voidQty = voidQty;
        this.sumTotalTeu = sumTotalTeu;
        this.sumLdnTeu = sumLdnTeu;
        this.sumEtyTeu = sumEtyTeu;
        this.sumWgtTon = sumWgtTon;
        this.sumWgtTeu = sumWgtTeu;
        this.sumTeuByWgt = sumTeuByWgt;
        this.sumRfPlug = sumRfPlug;
        this.allocSlot = allocSlot;
        this.allocRf = allocRf;
        this.bsSlot = bsSlot;
        this.bsRf = bsRf;
        this.excTeuTotal = excTeuTotal;
        this.excTeuLdn = excTeuLdn;
        this.excTeuEty = excTeuEty;
        this.excDwtTeu = excDwtTeu;
        this.excDwtRf = excDwtRf;
        this.priSlot = priSlot;
        this.priPlug = priPlug;
        this.amtBuyExcSlots = amtBuyExcSlots;
        this.amtUsedPlugs = amtUsedPlugs;
        this.ibCssmVoyNo = ibCssmVoyNo;
        this.obCssmVoyNo = obCssmVoyNo;
        this.optionA = optionA;
        this.optionB = optionB;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ord", getOrd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("vps_port_cd", getVpsPortCd());
        this.hashColumns.put("clpt_seq", getClptSeq());
        this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
        this.hashColumns.put("type", getType());
        this.hashColumns.put("sub_ord", getSubOrd());
        this.hashColumns.put("weight", getWeight());
        this.hashColumns.put("total", getTotal());
        this.hashColumns.put("f_qty1", getFQty1());
        this.hashColumns.put("f_qty2", getFQty2());
        this.hashColumns.put("f_qty3", getFQty3());
        this.hashColumns.put("f_qty4", getFQty4());
        this.hashColumns.put("f_qty5", getFQty5());
        this.hashColumns.put("f_qty6", getFQty6());
        this.hashColumns.put("f_qty7", getFQty7());
        this.hashColumns.put("f_qty8", getFQty8());
        this.hashColumns.put("f_qty9", getFQty9());
        this.hashColumns.put("f_qty10", getFQty10());
        this.hashColumns.put("f_qty11", getFQty11());
        this.hashColumns.put("f_qty12", getFQty12());
        this.hashColumns.put("f_qty13", getFQty13());
        this.hashColumns.put("f_qty14", getFQty14());
        this.hashColumns.put("f_qty15", getFQty15());
        this.hashColumns.put("f_qty16", getFQty16());
        this.hashColumns.put("f_qty17", getFQty17());
        this.hashColumns.put("f_qty18", getFQty18());
        this.hashColumns.put("f_qty19", getFQty19());
        this.hashColumns.put("f_qty20", getFQty20());
        this.hashColumns.put("f_qty21", getFQty21());
        this.hashColumns.put("f_qty22", getFQty22());
        this.hashColumns.put("f_qty23", getFQty23());
        this.hashColumns.put("f_qty24", getFQty24());
        this.hashColumns.put("f_qty25", getFQty25());
        this.hashColumns.put("f_qty26", getFQty26());
        this.hashColumns.put("f_qty27", getFQty27());
        this.hashColumns.put("f_qty28", getFQty28());
        this.hashColumns.put("f_qty29", getFQty29());
        this.hashColumns.put("f_qty30", getFQty30());
        this.hashColumns.put("e_qty1", getEQty1());
        this.hashColumns.put("e_qty2", getEQty2());
        this.hashColumns.put("e_qty3", getEQty3());
        this.hashColumns.put("e_qty4", getEQty4());
        this.hashColumns.put("e_qty5", getEQty5());
        this.hashColumns.put("e_qty6", getEQty6());
        this.hashColumns.put("e_qty7", getEQty7());
        this.hashColumns.put("e_qty8", getEQty8());
        this.hashColumns.put("e_qty9", getEQty9());
        this.hashColumns.put("e_qty10", getEQty10());
        this.hashColumns.put("e_qty11", getEQty11());
        this.hashColumns.put("e_qty12", getEQty12());
        this.hashColumns.put("e_qty13", getEQty13());
        this.hashColumns.put("e_qty14", getEQty14());
        this.hashColumns.put("e_qty15", getEQty15());
        this.hashColumns.put("e_qty16", getEQty16());
        this.hashColumns.put("e_qty17", getEQty17());
        this.hashColumns.put("e_qty18", getEQty18());
        this.hashColumns.put("e_qty19", getEQty19());
        this.hashColumns.put("e_qty20", getEQty20());
        this.hashColumns.put("e_qty21", getEQty21());
        this.hashColumns.put("e_qty22", getEQty22());
        this.hashColumns.put("e_qty23", getEQty23());
        this.hashColumns.put("e_qty24", getEQty24());
        this.hashColumns.put("e_qty25", getEQty25());
        this.hashColumns.put("e_qty26", getEQty26());
        this.hashColumns.put("e_qty27", getEQty27());
        this.hashColumns.put("e_qty28", getEQty28());
        this.hashColumns.put("e_qty29", getEQty29());
        this.hashColumns.put("e_qty30", getEQty30());
        this.hashColumns.put("void_qty", getVoidQty());
        this.hashColumns.put("sum_total_teu", getSumTotalTeu());
        this.hashColumns.put("sum_ldn_teu", getSumLdnTeu());
        this.hashColumns.put("sum_ety_teu", getSumEtyTeu());
        this.hashColumns.put("sum_wgt_ton", getSumWgtTon());
        this.hashColumns.put("sum_wgt_teu", getSumWgtTeu());
        this.hashColumns.put("sum_teu_by_wgt", getSumTeuByWgt());
        this.hashColumns.put("sum_rf_plug", getSumRfPlug());
        this.hashColumns.put("alloc_slot", getAllocSlot());
        this.hashColumns.put("alloc_rf", getAllocRf());
        this.hashColumns.put("bs_slot", getBsSlot());
        this.hashColumns.put("bs_rf", getBsRf());
        this.hashColumns.put("exc_teu_total", getExcTeuTotal());
        this.hashColumns.put("exc_teu_ldn", getExcTeuLdn());
        this.hashColumns.put("exc_teu_ety", getExcTeuEty());
        this.hashColumns.put("exc_dwt_teu", getExcDwtTeu());
        this.hashColumns.put("exc_dwt_rf", getExcDwtRf());
        this.hashColumns.put("pri_slot", getPriSlot());
        this.hashColumns.put("pri_plug", getPriPlug());
        this.hashColumns.put("amt_buy_exc_slots", getAmtBuyExcSlots());
        this.hashColumns.put("amt_used_plugs", getAmtUsedPlugs());
        this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
        this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
        this.hashColumns.put("option_a", getOptionA());
        this.hashColumns.put("option_b", getOptionB());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ord", "ord");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("vps_port_cd", "vpsPortCd");
        this.hashFields.put("clpt_seq", "clptSeq");
        this.hashFields.put("clpt_ind_seq", "clptIndSeq");
        this.hashFields.put("type", "type");
        this.hashFields.put("sub_ord", "subOrd");
        this.hashFields.put("weight", "weight");
        this.hashFields.put("total", "total");
        this.hashFields.put("f_qty1", "fQty1");
        this.hashFields.put("f_qty2", "fQty2");
        this.hashFields.put("f_qty3", "fQty3");
        this.hashFields.put("f_qty4", "fQty4");
        this.hashFields.put("f_qty5", "fQty5");
        this.hashFields.put("f_qty6", "fQty6");
        this.hashFields.put("f_qty7", "fQty7");
        this.hashFields.put("f_qty8", "fQty8");
        this.hashFields.put("f_qty9", "fQty9");
        this.hashFields.put("f_qty10", "fQty10");
        this.hashFields.put("f_qty11", "fQty11");
        this.hashFields.put("f_qty12", "fQty12");
        this.hashFields.put("f_qty13", "fQty13");
        this.hashFields.put("f_qty14", "fQty14");
        this.hashFields.put("f_qty15", "fQty15");
        this.hashFields.put("f_qty16", "fQty16");
        this.hashFields.put("f_qty17", "fQty17");
        this.hashFields.put("f_qty18", "fQty18");
        this.hashFields.put("f_qty19", "fQty19");
        this.hashFields.put("f_qty20", "fQty20");
        this.hashFields.put("f_qty21", "fQty21");
        this.hashFields.put("f_qty22", "fQty22");
        this.hashFields.put("f_qty23", "fQty23");
        this.hashFields.put("f_qty24", "fQty24");
        this.hashFields.put("f_qty25", "fQty25");
        this.hashFields.put("f_qty26", "fQty26");
        this.hashFields.put("f_qty27", "fQty27");
        this.hashFields.put("f_qty28", "fQty28");
        this.hashFields.put("f_qty29", "fQty29");
        this.hashFields.put("f_qty30", "fQty30");
        this.hashFields.put("e_qty1", "eQty1");
        this.hashFields.put("e_qty2", "eQty2");
        this.hashFields.put("e_qty3", "eQty3");
        this.hashFields.put("e_qty4", "eQty4");
        this.hashFields.put("e_qty5", "eQty5");
        this.hashFields.put("e_qty6", "eQty6");
        this.hashFields.put("e_qty7", "eQty7");
        this.hashFields.put("e_qty8", "eQty8");
        this.hashFields.put("e_qty9", "eQty9");
        this.hashFields.put("e_qty10", "eQty10");
        this.hashFields.put("e_qty11", "eQty11");
        this.hashFields.put("e_qty12", "eQty12");
        this.hashFields.put("e_qty13", "eQty13");
        this.hashFields.put("e_qty14", "eQty14");
        this.hashFields.put("e_qty15", "eQty15");
        this.hashFields.put("e_qty16", "eQty16");
        this.hashFields.put("e_qty17", "eQty17");
        this.hashFields.put("e_qty18", "eQty18");
        this.hashFields.put("e_qty19", "eQty19");
        this.hashFields.put("e_qty20", "eQty20");
        this.hashFields.put("e_qty21", "eQty21");
        this.hashFields.put("e_qty22", "eQty22");
        this.hashFields.put("e_qty23", "eQty23");
        this.hashFields.put("e_qty24", "eQty24");
        this.hashFields.put("e_qty25", "eQty25");
        this.hashFields.put("e_qty26", "eQty26");
        this.hashFields.put("e_qty27", "eQty27");
        this.hashFields.put("e_qty28", "eQty28");
        this.hashFields.put("e_qty29", "eQty29");
        this.hashFields.put("e_qty30", "eQty30");
        this.hashFields.put("void_qty", "voidQty");
        this.hashFields.put("sum_total_teu", "sumTotalTeu");
        this.hashFields.put("sum_ldn_teu", "sumLdnTeu");
        this.hashFields.put("sum_ety_teu", "sumEtyTeu");
        this.hashFields.put("sum_wgt_ton", "sumWgtTon");
        this.hashFields.put("sum_wgt_teu", "sumWgtTeu");
        this.hashFields.put("sum_teu_by_wgt", "sumTeuByWgt");
        this.hashFields.put("sum_rf_plug", "sumRfPlug");
        this.hashFields.put("alloc_slot", "allocSlot");
        this.hashFields.put("alloc_rf", "allocRf");
        this.hashFields.put("bs_slot", "bsSlot");
        this.hashFields.put("bs_rf", "bsRf");
        this.hashFields.put("exc_teu_total", "excTeuTotal");
        this.hashFields.put("exc_teu_ldn", "excTeuLdn");
        this.hashFields.put("exc_teu_ety", "excTeuEty");
        this.hashFields.put("exc_dwt_teu", "excDwtTeu");
        this.hashFields.put("exc_dwt_rf", "excDwtRf");
        this.hashFields.put("pri_slot", "priSlot");
        this.hashFields.put("pri_plug", "priPlug");
        this.hashFields.put("amt_buy_exc_slots", "amtBuyExcSlots");
        this.hashFields.put("amt_used_plugs", "amtUsedPlugs");
        this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
        this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
        this.hashFields.put("option_a", "optionA");
        this.hashFields.put("option_b", "optionB");
        return this.hashFields;
    }

    /**
	 *
	 * @param String ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * 
	 * @return String ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 *
	 * @param String pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * 
	 * @return String pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 *
	 * @param String ord
	 */
    public void setOrd(String ord) {
        this.ord = ord;
    }

    /**
	 * 
	 * @return String ord
	 */
    public String getOrd() {
        return this.ord;
    }

    /**
	 *
	 * @param String vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * 
	 * @return String vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 *
	 * @param String skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * 
	 * @return String skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 *
	 * @param String skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * 
	 * @return String skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
    }

    /**
	 *
	 * @param String vpsPortCd
	 */
    public void setVpsPortCd(String vpsPortCd) {
        this.vpsPortCd = vpsPortCd;
    }

    /**
	 * 
	 * @return String vpsPortCd
	 */
    public String getVpsPortCd() {
        return this.vpsPortCd;
    }

    /**
	 *
	 * @param String clptSeq
	 */
    public void setClptSeq(String clptSeq) {
        this.clptSeq = clptSeq;
    }

    /**
	 * 
	 * @return String clptSeq
	 */
    public String getClptSeq() {
        return this.clptSeq;
    }

    /**
	 *
	 * @param String clptIndSeq
	 */
    public void setClptIndSeq(String clptIndSeq) {
        this.clptIndSeq = clptIndSeq;
    }

    /**
	 * 
	 * @return String clptIndSeq
	 */
    public String getClptIndSeq() {
        return this.clptIndSeq;
    }

    /**
	 *
	 * @param String type
	 */
    public void setType(String type) {
        this.type = type;
    }

    /**
	 * 
	 * @return String type
	 */
    public String getType() {
        return this.type;
    }

    /**
	 *
	 * @param String subOrd
	 */
    public void setSubOrd(String subOrd) {
        this.subOrd = subOrd;
    }

    /**
	 * 
	 * @return String subOrd
	 */
    public String getSubOrd() {
        return this.subOrd;
    }

    /**
	 *
	 * @param String weight
	 */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
	 * 
	 * @return String weight
	 */
    public String getWeight() {
        return this.weight;
    }

    /**
	 *
	 * @param String total
	 */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
	 * 
	 * @return String total
	 */
    public String getTotal() {
        return this.total;
    }

    /**
	 *
	 * @param String fQty1
	 */
    public void setFQty1(String fQty1) {
        this.fQty1 = fQty1;
    }

    /**
	 * 
	 * @return String fQty1
	 */
    public String getFQty1() {
        return this.fQty1;
    }

    /**
	 *
	 * @param String fQty2
	 */
    public void setFQty2(String fQty2) {
        this.fQty2 = fQty2;
    }

    /**
	 * 
	 * @return String fQty2
	 */
    public String getFQty2() {
        return this.fQty2;
    }

    /**
	 *
	 * @param String fQty3
	 */
    public void setFQty3(String fQty3) {
        this.fQty3 = fQty3;
    }

    /**
	 * 
	 * @return String fQty3
	 */
    public String getFQty3() {
        return this.fQty3;
    }

    /**
	 *
	 * @param String fQty4
	 */
    public void setFQty4(String fQty4) {
        this.fQty4 = fQty4;
    }

    /**
	 * 
	 * @return String fQty4
	 */
    public String getFQty4() {
        return this.fQty4;
    }

    /**
	 *
	 * @param String fQty5
	 */
    public void setFQty5(String fQty5) {
        this.fQty5 = fQty5;
    }

    /**
	 * 
	 * @return String fQty5
	 */
    public String getFQty5() {
        return this.fQty5;
    }

    /**
	 *
	 * @param String fQty6
	 */
    public void setFQty6(String fQty6) {
        this.fQty6 = fQty6;
    }

    /**
	 * 
	 * @return String fQty6
	 */
    public String getFQty6() {
        return this.fQty6;
    }

    /**
	 *
	 * @param String fQty7
	 */
    public void setFQty7(String fQty7) {
        this.fQty7 = fQty7;
    }

    /**
	 * 
	 * @return String fQty7
	 */
    public String getFQty7() {
        return this.fQty7;
    }

    /**
	 *
	 * @param String fQty8
	 */
    public void setFQty8(String fQty8) {
        this.fQty8 = fQty8;
    }

    /**
	 * 
	 * @return String fQty8
	 */
    public String getFQty8() {
        return this.fQty8;
    }

    /**
	 *
	 * @param String fQty9
	 */
    public void setFQty9(String fQty9) {
        this.fQty9 = fQty9;
    }

    /**
	 * 
	 * @return String fQty9
	 */
    public String getFQty9() {
        return this.fQty9;
    }

    /**
	 *
	 * @param String fQty10
	 */
    public void setFQty10(String fQty10) {
        this.fQty10 = fQty10;
    }

    /**
	 * 
	 * @return String fQty10
	 */
    public String getFQty10() {
        return this.fQty10;
    }

    /**
	 *
	 * @param String fQty11
	 */
    public void setFQty11(String fQty11) {
        this.fQty11 = fQty11;
    }

    /**
	 * 
	 * @return String fQty11
	 */
    public String getFQty11() {
        return this.fQty11;
    }

    /**
	 *
	 * @param String fQty12
	 */
    public void setFQty12(String fQty12) {
        this.fQty12 = fQty12;
    }

    /**
	 * 
	 * @return String fQty12
	 */
    public String getFQty12() {
        return this.fQty12;
    }

    /**
	 *
	 * @param String fQty13
	 */
    public void setFQty13(String fQty13) {
        this.fQty13 = fQty13;
    }

    /**
	 * 
	 * @return String fQty13
	 */
    public String getFQty13() {
        return this.fQty13;
    }

    /**
	 *
	 * @param String fQty14
	 */
    public void setFQty14(String fQty14) {
        this.fQty14 = fQty14;
    }

    /**
	 * 
	 * @return String fQty14
	 */
    public String getFQty14() {
        return this.fQty14;
    }

    /**
	 *
	 * @param String fQty15
	 */
    public void setFQty15(String fQty15) {
        this.fQty15 = fQty15;
    }

    /**
	 * 
	 * @return String fQty15
	 */
    public String getFQty15() {
        return this.fQty15;
    }

    /**
	 *
	 * @param String fQty16
	 */
    public void setFQty16(String fQty16) {
        this.fQty16 = fQty16;
    }

    /**
	 * 
	 * @return String fQty16
	 */
    public String getFQty16() {
        return this.fQty16;
    }

    /**
	 *
	 * @param String fQty17
	 */
    public void setFQty17(String fQty17) {
        this.fQty17 = fQty17;
    }

    /**
	 * 
	 * @return String fQty17
	 */
    public String getFQty17() {
        return this.fQty17;
    }

    /**
	 *
	 * @param String fQty18
	 */
    public void setFQty18(String fQty18) {
        this.fQty18 = fQty18;
    }

    /**
	 * 
	 * @return String fQty18
	 */
    public String getFQty18() {
        return this.fQty18;
    }

    /**
	 *
	 * @param String fQty19
	 */
    public void setFQty19(String fQty19) {
        this.fQty19 = fQty19;
    }

    /**
	 * 
	 * @return String fQty19
	 */
    public String getFQty19() {
        return this.fQty19;
    }

    /**
	 *
	 * @param String fQty20
	 */
    public void setFQty20(String fQty20) {
        this.fQty20 = fQty20;
    }

    /**
	 * 
	 * @return String fQty20
	 */
    public String getFQty20() {
        return this.fQty20;
    }

    /**
	 *
	 * @param String fQty21
	 */
    public void setFQty21(String fQty21) {
        this.fQty21 = fQty21;
    }

    /**
	 * 
	 * @return String fQty21
	 */
    public String getFQty21() {
        return this.fQty21;
    }

    /**
	 *
	 * @param String fQty22
	 */
    public void setFQty22(String fQty22) {
        this.fQty22 = fQty22;
    }

    /**
	 * 
	 * @return String fQty22
	 */
    public String getFQty22() {
        return this.fQty22;
    }

    /**
	 *
	 * @param String fQty23
	 */
    public void setFQty23(String fQty23) {
        this.fQty23 = fQty23;
    }

    /**
	 * 
	 * @return String fQty23
	 */
    public String getFQty23() {
        return this.fQty23;
    }

    /**
	 *
	 * @param String fQty24
	 */
    public void setFQty24(String fQty24) {
        this.fQty24 = fQty24;
    }

    /**
	 * 
	 * @return String fQty24
	 */
    public String getFQty24() {
        return this.fQty24;
    }

    /**
	 *
	 * @param String fQty25
	 */
    public void setFQty25(String fQty25) {
        this.fQty25 = fQty25;
    }

    /**
	 * 
	 * @return String fQty25
	 */
    public String getFQty25() {
        return this.fQty25;
    }

    /**
	 *
	 * @param String fQty26
	 */
    public void setFQty26(String fQty26) {
        this.fQty26 = fQty26;
    }

    /**
	 * 
	 * @return String fQty26
	 */
    public String getFQty26() {
        return this.fQty26;
    }

    /**
	 *
	 * @param String fQty27
	 */
    public void setFQty27(String fQty27) {
        this.fQty27 = fQty27;
    }

    /**
	 * 
	 * @return String fQty27
	 */
    public String getFQty27() {
        return this.fQty27;
    }

    /**
	 *
	 * @param String fQty28
	 */
    public void setFQty28(String fQty28) {
        this.fQty28 = fQty28;
    }

    /**
	 * 
	 * @return String fQty28
	 */
    public String getFQty28() {
        return this.fQty28;
    }

    /**
	 *
	 * @param String fQty29
	 */
    public void setFQty29(String fQty29) {
        this.fQty29 = fQty29;
    }

    /**
	 * 
	 * @return String fQty29
	 */
    public String getFQty29() {
        return this.fQty29;
    }

    /**
	 *
	 * @param String fQty30
	 */
    public void setFQty30(String fQty30) {
        this.fQty30 = fQty30;
    }

    /**
	 * 
	 * @return String fQty30
	 */
    public String getFQty30() {
        return this.fQty30;
    }

    /**
	 *
	 * @param String eQty1
	 */
    public void setEQty1(String eQty1) {
        this.eQty1 = eQty1;
    }

    /**
	 * 
	 * @return String eQty1
	 */
    public String getEQty1() {
        return this.eQty1;
    }

    /**
	 *
	 * @param String eQty2
	 */
    public void setEQty2(String eQty2) {
        this.eQty2 = eQty2;
    }

    /**
	 * 
	 * @return String eQty2
	 */
    public String getEQty2() {
        return this.eQty2;
    }

    /**
	 *
	 * @param String eQty3
	 */
    public void setEQty3(String eQty3) {
        this.eQty3 = eQty3;
    }

    /**
	 * 
	 * @return String eQty3
	 */
    public String getEQty3() {
        return this.eQty3;
    }

    /**
	 *
	 * @param String eQty4
	 */
    public void setEQty4(String eQty4) {
        this.eQty4 = eQty4;
    }

    /**
	 * 
	 * @return String eQty4
	 */
    public String getEQty4() {
        return this.eQty4;
    }

    /**
	 *
	 * @param String eQty5
	 */
    public void setEQty5(String eQty5) {
        this.eQty5 = eQty5;
    }

    /**
	 * 
	 * @return String eQty5
	 */
    public String getEQty5() {
        return this.eQty5;
    }

    /**
	 *
	 * @param String eQty6
	 */
    public void setEQty6(String eQty6) {
        this.eQty6 = eQty6;
    }

    /**
	 * 
	 * @return String eQty6
	 */
    public String getEQty6() {
        return this.eQty6;
    }

    /**
	 *
	 * @param String eQty7
	 */
    public void setEQty7(String eQty7) {
        this.eQty7 = eQty7;
    }

    /**
	 * 
	 * @return String eQty7
	 */
    public String getEQty7() {
        return this.eQty7;
    }

    /**
	 *
	 * @param String eQty8
	 */
    public void setEQty8(String eQty8) {
        this.eQty8 = eQty8;
    }

    /**
	 * 
	 * @return String eQty8
	 */
    public String getEQty8() {
        return this.eQty8;
    }

    /**
	 *
	 * @param String eQty9
	 */
    public void setEQty9(String eQty9) {
        this.eQty9 = eQty9;
    }

    /**
	 * 
	 * @return String eQty9
	 */
    public String getEQty9() {
        return this.eQty9;
    }

    /**
	 *
	 * @param String eQty10
	 */
    public void setEQty10(String eQty10) {
        this.eQty10 = eQty10;
    }

    /**
	 * 
	 * @return String eQty10
	 */
    public String getEQty10() {
        return this.eQty10;
    }

    /**
	 *
	 * @param String eQty11
	 */
    public void setEQty11(String eQty11) {
        this.eQty11 = eQty11;
    }

    /**
	 * 
	 * @return String eQty11
	 */
    public String getEQty11() {
        return this.eQty11;
    }

    /**
	 *
	 * @param String eQty12
	 */
    public void setEQty12(String eQty12) {
        this.eQty12 = eQty12;
    }

    /**
	 * 
	 * @return String eQty12
	 */
    public String getEQty12() {
        return this.eQty12;
    }

    /**
	 *
	 * @param String eQty13
	 */
    public void setEQty13(String eQty13) {
        this.eQty13 = eQty13;
    }

    /**
	 * 
	 * @return String eQty13
	 */
    public String getEQty13() {
        return this.eQty13;
    }

    /**
	 *
	 * @param String eQty14
	 */
    public void setEQty14(String eQty14) {
        this.eQty14 = eQty14;
    }

    /**
	 * 
	 * @return String eQty14
	 */
    public String getEQty14() {
        return this.eQty14;
    }

    /**
	 *
	 * @param String eQty15
	 */
    public void setEQty15(String eQty15) {
        this.eQty15 = eQty15;
    }

    /**
	 * 
	 * @return String eQty15
	 */
    public String getEQty15() {
        return this.eQty15;
    }

    /**
	 *
	 * @param String eQty16
	 */
    public void setEQty16(String eQty16) {
        this.eQty16 = eQty16;
    }

    /**
	 * 
	 * @return String eQty16
	 */
    public String getEQty16() {
        return this.eQty16;
    }

    /**
	 *
	 * @param String eQty17
	 */
    public void setEQty17(String eQty17) {
        this.eQty17 = eQty17;
    }

    /**
	 * 
	 * @return String eQty17
	 */
    public String getEQty17() {
        return this.eQty17;
    }

    /**
	 *
	 * @param String eQty18
	 */
    public void setEQty18(String eQty18) {
        this.eQty18 = eQty18;
    }

    /**
	 * 
	 * @return String eQty18
	 */
    public String getEQty18() {
        return this.eQty18;
    }

    /**
	 *
	 * @param String eQty19
	 */
    public void setEQty19(String eQty19) {
        this.eQty19 = eQty19;
    }

    /**
	 * 
	 * @return String eQty19
	 */
    public String getEQty19() {
        return this.eQty19;
    }

    /**
	 *
	 * @param String eQty20
	 */
    public void setEQty20(String eQty20) {
        this.eQty20 = eQty20;
    }

    /**
	 * 
	 * @return String eQty20
	 */
    public String getEQty20() {
        return this.eQty20;
    }

    /**
	 *
	 * @param String eQty21
	 */
    public void setEQty21(String eQty21) {
        this.eQty21 = eQty21;
    }

    /**
	 * 
	 * @return String eQty21
	 */
    public String getEQty21() {
        return this.eQty21;
    }

    /**
	 *
	 * @param String eQty22
	 */
    public void setEQty22(String eQty22) {
        this.eQty22 = eQty22;
    }

    /**
	 * 
	 * @return String eQty22
	 */
    public String getEQty22() {
        return this.eQty22;
    }

    /**
	 *
	 * @param String eQty23
	 */
    public void setEQty23(String eQty23) {
        this.eQty23 = eQty23;
    }

    /**
	 * 
	 * @return String eQty23
	 */
    public String getEQty23() {
        return this.eQty23;
    }

    /**
	 *
	 * @param String eQty24
	 */
    public void setEQty24(String eQty24) {
        this.eQty24 = eQty24;
    }

    /**
	 * 
	 * @return String eQty24
	 */
    public String getEQty24() {
        return this.eQty24;
    }

    /**
	 *
	 * @param String eQty25
	 */
    public void setEQty25(String eQty25) {
        this.eQty25 = eQty25;
    }

    /**
	 * 
	 * @return String eQty25
	 */
    public String getEQty25() {
        return this.eQty25;
    }

    /**
	 *
	 * @param String eQty26
	 */
    public void setEQty26(String eQty26) {
        this.eQty26 = eQty26;
    }

    /**
	 * 
	 * @return String eQty26
	 */
    public String getEQty26() {
        return this.eQty26;
    }

    /**
	 *
	 * @param String eQty27
	 */
    public void setEQty27(String eQty27) {
        this.eQty27 = eQty27;
    }

    /**
	 * 
	 * @return String eQty27
	 */
    public String getEQty27() {
        return this.eQty27;
    }

    /**
	 *
	 * @param String eQty28
	 */
    public void setEQty28(String eQty28) {
        this.eQty28 = eQty28;
    }

    /**
	 * 
	 * @return String eQty28
	 */
    public String getEQty28() {
        return this.eQty28;
    }

    /**
	 *
	 * @param String eQty29
	 */
    public void setEQty29(String eQty29) {
        this.eQty29 = eQty29;
    }

    /**
	 * 
	 * @return String eQty29
	 */
    public String getEQty29() {
        return this.eQty29;
    }

    /**
	 *
	 * @param String eQty30
	 */
    public void setEQty30(String eQty30) {
        this.eQty30 = eQty30;
    }

    /**
	 * 
	 * @return String eQty30
	 */
    public String getEQty30() {
        return this.eQty30;
    }

    public void setVoidQty(String voidQty) {
        this.voidQty = voidQty;
    }

    public String getVoidQty() {
        return this.voidQty;
    }

    public void setSumTotalTeu(String sumTotalTeu) {
        this.sumTotalTeu = sumTotalTeu;
    }

    public String getSumTotalTeu() {
        return this.sumTotalTeu;
    }

    public void setSumLdnTeu(String sumLdnTeu) {
        this.sumLdnTeu = sumLdnTeu;
    }

    public String getSumLdnTeu() {
        return this.sumLdnTeu;
    }

    public void setSumEtyTeu(String sumEtyTeu) {
        this.sumEtyTeu = sumEtyTeu;
    }

    public String getSumEtyTeu() {
        return this.sumEtyTeu;
    }

    public void setSumWgtTon(String sumWgtTon) {
        this.sumWgtTon = sumWgtTon;
    }

    public String getSumWgtTon() {
        return this.sumWgtTon;
    }

    public void setSumWgtTeu(String sumWgtTeu) {
        this.sumWgtTeu = sumWgtTeu;
    }

    public String getSumWgtTeu() {
        return this.sumWgtTeu;
    }

    public void setSumTeuByWgt(String sumTeuByWgt) {
        this.sumTeuByWgt = sumTeuByWgt;
    }

    public String getSumTeuByWgt() {
        return this.sumTeuByWgt;
    }

    public void setSumRfPlug(String sumRfPlug) {
        this.sumRfPlug = sumRfPlug;
    }

    public String getSumRfPlug() {
        return this.sumRfPlug;
    }

    public void setAllocSlot(String allocSlot) {
        this.allocSlot = allocSlot;
    }

    public String getAllocSlot() {
        return this.allocSlot;
    }

    public void setAllocRf(String allocRf) {
        this.allocRf = allocRf;
    }

    public String getAllocRf() {
        return this.allocRf;
    }

    public void setBsSlot(String bsSlot) {
        this.bsSlot = bsSlot;
    }

    public String getBsSlot() {
        return this.bsSlot;
    }

    public void setBsRf(String bsRf) {
        this.bsRf = bsRf;
    }

    public String getBsRf() {
        return this.bsRf;
    }

    public void setExcTeuTotal(String excTeuTotal) {
        this.excTeuTotal = excTeuTotal;
    }

    public String getExcTeuTotal() {
        return this.excTeuTotal;
    }

    public void setExcTeuLdn(String excTeuLdn) {
        this.excTeuLdn = excTeuLdn;
    }

    public String getExcTeuLdn() {
        return this.excTeuLdn;
    }

    public void setExcTeuEty(String excTeuEty) {
        this.excTeuEty = excTeuEty;
    }

    public String getExcTeuEty() {
        return this.excTeuEty;
    }

    public void setExcDwtTeu(String excDwtTeu) {
        this.excDwtTeu = excDwtTeu;
    }

    public String getExcDwtTeu() {
        return this.excDwtTeu;
    }

    public void setExcDwtRf(String excDwtRf) {
        this.excDwtRf = excDwtRf;
    }

    public String getExcDwtRf() {
        return this.excDwtRf;
    }

    public void setPriSlot(String priSlot) {
        this.priSlot = priSlot;
    }

    public String getPriSlot() {
        return this.priSlot;
    }

    public void setPriPlug(String priPlug) {
        this.priPlug = priPlug;
    }

    public String getPriPlug() {
        return this.priPlug;
    }

    public void setAmtBuyExcSlots(String amtBuyExcSlots) {
        this.amtBuyExcSlots = amtBuyExcSlots;
    }

    public String getAmtBuyExcSlots() {
        return this.amtBuyExcSlots;
    }

    public void setAmtUsedPlugs(String amtUsedPlugs) {
        this.amtUsedPlugs = amtUsedPlugs;
    }

    public String getAmtUsedPlugs() {
        return this.amtUsedPlugs;
    }

    public void setIbCssmVoyNo(String ibCssmVoyNo) {
        this.ibCssmVoyNo = ibCssmVoyNo;
    }

    public String getIbCssmVoyNo() {
        return this.ibCssmVoyNo;
    }

    public void setObCssmVoyNo(String obCssmVoyNo) {
        this.obCssmVoyNo = obCssmVoyNo;
    }

    public String getObCssmVoyNo() {
        return this.obCssmVoyNo;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionA() {
        return this.optionA;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionB() {
        return this.optionB;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setOrd(JSPUtil.getParameter(request, prefix + "ord", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
        setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
        setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
        setType(JSPUtil.getParameter(request, prefix + "type", ""));
        setSubOrd(JSPUtil.getParameter(request, prefix + "sub_ord", ""));
        setWeight(JSPUtil.getParameter(request, prefix + "weight", ""));
        setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
        setFQty1(JSPUtil.getParameter(request, prefix + "f_qty1", ""));
        setFQty2(JSPUtil.getParameter(request, prefix + "f_qty2", ""));
        setFQty3(JSPUtil.getParameter(request, prefix + "f_qty3", ""));
        setFQty4(JSPUtil.getParameter(request, prefix + "f_qty4", ""));
        setFQty5(JSPUtil.getParameter(request, prefix + "f_qty5", ""));
        setFQty6(JSPUtil.getParameter(request, prefix + "f_qty6", ""));
        setFQty7(JSPUtil.getParameter(request, prefix + "f_qty7", ""));
        setFQty8(JSPUtil.getParameter(request, prefix + "f_qty8", ""));
        setFQty9(JSPUtil.getParameter(request, prefix + "f_qty9", ""));
        setFQty10(JSPUtil.getParameter(request, prefix + "f_qty10", ""));
        setFQty11(JSPUtil.getParameter(request, prefix + "f_qty11", ""));
        setFQty12(JSPUtil.getParameter(request, prefix + "f_qty12", ""));
        setFQty13(JSPUtil.getParameter(request, prefix + "f_qty13", ""));
        setFQty14(JSPUtil.getParameter(request, prefix + "f_qty14", ""));
        setFQty15(JSPUtil.getParameter(request, prefix + "f_qty15", ""));
        setFQty16(JSPUtil.getParameter(request, prefix + "f_qty16", ""));
        setFQty17(JSPUtil.getParameter(request, prefix + "f_qty17", ""));
        setFQty18(JSPUtil.getParameter(request, prefix + "f_qty18", ""));
        setFQty19(JSPUtil.getParameter(request, prefix + "f_qty19", ""));
        setFQty20(JSPUtil.getParameter(request, prefix + "f_qty20", ""));
        setFQty21(JSPUtil.getParameter(request, prefix + "f_qty21", ""));
        setFQty22(JSPUtil.getParameter(request, prefix + "f_qty22", ""));
        setFQty23(JSPUtil.getParameter(request, prefix + "f_qty23", ""));
        setFQty24(JSPUtil.getParameter(request, prefix + "f_qty24", ""));
        setFQty25(JSPUtil.getParameter(request, prefix + "f_qty25", ""));
        setFQty26(JSPUtil.getParameter(request, prefix + "f_qty26", ""));
        setFQty27(JSPUtil.getParameter(request, prefix + "f_qty27", ""));
        setFQty28(JSPUtil.getParameter(request, prefix + "f_qty28", ""));
        setFQty29(JSPUtil.getParameter(request, prefix + "f_qty29", ""));
        setFQty30(JSPUtil.getParameter(request, prefix + "f_qty30", ""));
        setEQty1(JSPUtil.getParameter(request, prefix + "e_qty1", ""));
        setEQty2(JSPUtil.getParameter(request, prefix + "e_qty2", ""));
        setEQty3(JSPUtil.getParameter(request, prefix + "e_qty3", ""));
        setEQty4(JSPUtil.getParameter(request, prefix + "e_qty4", ""));
        setEQty5(JSPUtil.getParameter(request, prefix + "e_qty5", ""));
        setEQty6(JSPUtil.getParameter(request, prefix + "e_qty6", ""));
        setEQty7(JSPUtil.getParameter(request, prefix + "e_qty7", ""));
        setEQty8(JSPUtil.getParameter(request, prefix + "e_qty8", ""));
        setEQty9(JSPUtil.getParameter(request, prefix + "e_qty9", ""));
        setEQty10(JSPUtil.getParameter(request, prefix + "e_qty10", ""));
        setEQty11(JSPUtil.getParameter(request, prefix + "e_qty11", ""));
        setEQty12(JSPUtil.getParameter(request, prefix + "e_qty12", ""));
        setEQty13(JSPUtil.getParameter(request, prefix + "e_qty13", ""));
        setEQty14(JSPUtil.getParameter(request, prefix + "e_qty14", ""));
        setEQty15(JSPUtil.getParameter(request, prefix + "e_qty15", ""));
        setEQty16(JSPUtil.getParameter(request, prefix + "e_qty16", ""));
        setEQty17(JSPUtil.getParameter(request, prefix + "e_qty17", ""));
        setEQty18(JSPUtil.getParameter(request, prefix + "e_qty18", ""));
        setEQty19(JSPUtil.getParameter(request, prefix + "e_qty19", ""));
        setEQty20(JSPUtil.getParameter(request, prefix + "e_qty20", ""));
        setEQty21(JSPUtil.getParameter(request, prefix + "e_qty21", ""));
        setEQty22(JSPUtil.getParameter(request, prefix + "e_qty22", ""));
        setEQty23(JSPUtil.getParameter(request, prefix + "e_qty23", ""));
        setEQty24(JSPUtil.getParameter(request, prefix + "e_qty24", ""));
        setEQty25(JSPUtil.getParameter(request, prefix + "e_qty25", ""));
        setEQty26(JSPUtil.getParameter(request, prefix + "e_qty26", ""));
        setEQty27(JSPUtil.getParameter(request, prefix + "e_qty27", ""));
        setEQty28(JSPUtil.getParameter(request, prefix + "e_qty28", ""));
        setEQty29(JSPUtil.getParameter(request, prefix + "e_qty29", ""));
        setEQty30(JSPUtil.getParameter(request, prefix + "e_qty30", ""));
        setVoidQty(JSPUtil.getParameter(request, prefix + "void_qty", ""));
        setSumTotalTeu(JSPUtil.getParameter(request, prefix + "sum_total_teu", ""));
        setSumLdnTeu(JSPUtil.getParameter(request, prefix + "sum_ldn_teu", ""));
        setSumEtyTeu(JSPUtil.getParameter(request, prefix + "sum_ety_teu", ""));
        setSumWgtTon(JSPUtil.getParameter(request, prefix + "sum_wgt_ton", ""));
        setSumWgtTeu(JSPUtil.getParameter(request, prefix + "sum_wgt_teu", ""));
        setSumTeuByWgt(JSPUtil.getParameter(request, prefix + "sum_teu_by_wgt", ""));
        setSumRfPlug(JSPUtil.getParameter(request, prefix + "sum_rf_plug", ""));
        setAllocSlot(JSPUtil.getParameter(request, prefix + "alloc_slot", ""));
        setAllocRf(JSPUtil.getParameter(request, prefix + "alloc_rf", ""));
        setBsSlot(JSPUtil.getParameter(request, prefix + "bs_slot", ""));
        setBsRf(JSPUtil.getParameter(request, prefix + "bs_rf", ""));
        setExcTeuTotal(JSPUtil.getParameter(request, prefix + "exc_teu_total", ""));
        setExcTeuLdn(JSPUtil.getParameter(request, prefix + "exc_teu_ldn", ""));
        setExcTeuEty(JSPUtil.getParameter(request, prefix + "exc_teu_ety", ""));
        setExcDwtTeu(JSPUtil.getParameter(request, prefix + "exc_dwt_teu", ""));
        setExcDwtRf(JSPUtil.getParameter(request, prefix + "exc_dwt_rf", ""));
        setPriSlot(JSPUtil.getParameter(request, prefix + "pri_slot", ""));
        setPriPlug(JSPUtil.getParameter(request, prefix + "pri_plug", ""));
        setAmtBuyExcSlots(JSPUtil.getParameter(request, prefix + "amt_buy_exc_slots", ""));
        setAmtUsedPlugs(JSPUtil.getParameter(request, prefix + "amt_used_plugs", ""));
        setIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", ""));
        setObCssmVoyNo(JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", ""));
        setOptionA(JSPUtil.getParameter(request, prefix + "option_a", ""));
        setOptionB(JSPUtil.getParameter(request, prefix + "option_b", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrStandardFormatVO[]
	 */
    public CntrStandardFormatVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrStandardFormatVO[]
	 */
    public CntrStandardFormatVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CntrStandardFormatVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ord = (JSPUtil.getParameter(request, prefix + "ord", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] vpsPortCd = (JSPUtil.getParameter(request, prefix + "vps_port_cd", length));
            String[] clptSeq = (JSPUtil.getParameter(request, prefix + "clpt_seq", length));
            String[] clptIndSeq = (JSPUtil.getParameter(request, prefix + "clpt_ind_seq", length));
            String[] type = (JSPUtil.getParameter(request, prefix + "type", length));
            String[] subOrd = (JSPUtil.getParameter(request, prefix + "sub_ord", length));
            String[] weight = (JSPUtil.getParameter(request, prefix + "weight", length));
            String[] total = (JSPUtil.getParameter(request, prefix + "total", length));
            String[] fQty1 = (JSPUtil.getParameter(request, prefix + "f_qty1", length));
            String[] fQty2 = (JSPUtil.getParameter(request, prefix + "f_qty2", length));
            String[] fQty3 = (JSPUtil.getParameter(request, prefix + "f_qty3", length));
            String[] fQty4 = (JSPUtil.getParameter(request, prefix + "f_qty4", length));
            String[] fQty5 = (JSPUtil.getParameter(request, prefix + "f_qty5", length));
            String[] fQty6 = (JSPUtil.getParameter(request, prefix + "f_qty6", length));
            String[] fQty7 = (JSPUtil.getParameter(request, prefix + "f_qty7", length));
            String[] fQty8 = (JSPUtil.getParameter(request, prefix + "f_qty8", length));
            String[] fQty9 = (JSPUtil.getParameter(request, prefix + "f_qty9", length));
            String[] fQty10 = (JSPUtil.getParameter(request, prefix + "f_qty10", length));
            String[] fQty11 = (JSPUtil.getParameter(request, prefix + "f_qty11", length));
            String[] fQty12 = (JSPUtil.getParameter(request, prefix + "f_qty12", length));
            String[] fQty13 = (JSPUtil.getParameter(request, prefix + "f_qty13", length));
            String[] fQty14 = (JSPUtil.getParameter(request, prefix + "f_qty14", length));
            String[] fQty15 = (JSPUtil.getParameter(request, prefix + "f_qty15", length));
            String[] fQty16 = (JSPUtil.getParameter(request, prefix + "f_qty16", length));
            String[] fQty17 = (JSPUtil.getParameter(request, prefix + "f_qty17", length));
            String[] fQty18 = (JSPUtil.getParameter(request, prefix + "f_qty18", length));
            String[] fQty19 = (JSPUtil.getParameter(request, prefix + "f_qty19", length));
            String[] fQty20 = (JSPUtil.getParameter(request, prefix + "f_qty20", length));
            String[] fQty21 = (JSPUtil.getParameter(request, prefix + "f_qty21", length));
            String[] fQty22 = (JSPUtil.getParameter(request, prefix + "f_qty22", length));
            String[] fQty23 = (JSPUtil.getParameter(request, prefix + "f_qty23", length));
            String[] fQty24 = (JSPUtil.getParameter(request, prefix + "f_qty24", length));
            String[] fQty25 = (JSPUtil.getParameter(request, prefix + "f_qty25", length));
            String[] fQty26 = (JSPUtil.getParameter(request, prefix + "f_qty26", length));
            String[] fQty27 = (JSPUtil.getParameter(request, prefix + "f_qty27", length));
            String[] fQty28 = (JSPUtil.getParameter(request, prefix + "f_qty28", length));
            String[] fQty29 = (JSPUtil.getParameter(request, prefix + "f_qty29", length));
            String[] fQty30 = (JSPUtil.getParameter(request, prefix + "f_qty30", length));
            String[] eQty1 = (JSPUtil.getParameter(request, prefix + "e_qty1", length));
            String[] eQty2 = (JSPUtil.getParameter(request, prefix + "e_qty2", length));
            String[] eQty3 = (JSPUtil.getParameter(request, prefix + "e_qty3", length));
            String[] eQty4 = (JSPUtil.getParameter(request, prefix + "e_qty4", length));
            String[] eQty5 = (JSPUtil.getParameter(request, prefix + "e_qty5", length));
            String[] eQty6 = (JSPUtil.getParameter(request, prefix + "e_qty6", length));
            String[] eQty7 = (JSPUtil.getParameter(request, prefix + "e_qty7", length));
            String[] eQty8 = (JSPUtil.getParameter(request, prefix + "e_qty8", length));
            String[] eQty9 = (JSPUtil.getParameter(request, prefix + "e_qty9", length));
            String[] eQty10 = (JSPUtil.getParameter(request, prefix + "e_qty10", length));
            String[] eQty11 = (JSPUtil.getParameter(request, prefix + "e_qty11", length));
            String[] eQty12 = (JSPUtil.getParameter(request, prefix + "e_qty12", length));
            String[] eQty13 = (JSPUtil.getParameter(request, prefix + "e_qty13", length));
            String[] eQty14 = (JSPUtil.getParameter(request, prefix + "e_qty14", length));
            String[] eQty15 = (JSPUtil.getParameter(request, prefix + "e_qty15", length));
            String[] eQty16 = (JSPUtil.getParameter(request, prefix + "e_qty16", length));
            String[] eQty17 = (JSPUtil.getParameter(request, prefix + "e_qty17", length));
            String[] eQty18 = (JSPUtil.getParameter(request, prefix + "e_qty18", length));
            String[] eQty19 = (JSPUtil.getParameter(request, prefix + "e_qty19", length));
            String[] eQty20 = (JSPUtil.getParameter(request, prefix + "e_qty20", length));
            String[] eQty21 = (JSPUtil.getParameter(request, prefix + "e_qty21", length));
            String[] eQty22 = (JSPUtil.getParameter(request, prefix + "e_qty22", length));
            String[] eQty23 = (JSPUtil.getParameter(request, prefix + "e_qty23", length));
            String[] eQty24 = (JSPUtil.getParameter(request, prefix + "e_qty24", length));
            String[] eQty25 = (JSPUtil.getParameter(request, prefix + "e_qty25", length));
            String[] eQty26 = (JSPUtil.getParameter(request, prefix + "e_qty26", length));
            String[] eQty27 = (JSPUtil.getParameter(request, prefix + "e_qty27", length));
            String[] eQty28 = (JSPUtil.getParameter(request, prefix + "e_qty28", length));
            String[] eQty29 = (JSPUtil.getParameter(request, prefix + "e_qty29", length));
            String[] eQty30 = (JSPUtil.getParameter(request, prefix + "e_qty30", length));
            String[] voidQty = (JSPUtil.getParameter(request, prefix + "void_qty", length));
            String[] sumTotalTeu = (JSPUtil.getParameter(request, prefix + "sum_total_teu", length));
            String[] sumLdnTeu = (JSPUtil.getParameter(request, prefix + "sum_ldn_teu", length));
            String[] sumEtyTeu = (JSPUtil.getParameter(request, prefix + "sum_ety_teu", length));
            String[] sumWgtTon = (JSPUtil.getParameter(request, prefix + "sum_wgt_ton", length));
            String[] sumWgtTeu = (JSPUtil.getParameter(request, prefix + "sum_wgt_teu", length));
            String[] sumTeuByWgt = (JSPUtil.getParameter(request, prefix + "sum_teu_by_wgt", length));
            String[] sumRfPlug = (JSPUtil.getParameter(request, prefix + "sum_rf_plug", length));
            String[] allocSlot = (JSPUtil.getParameter(request, prefix + "alloc_slot", length));
            String[] allocRf = (JSPUtil.getParameter(request, prefix + "alloc_rf", length));
            String[] bsSlot = (JSPUtil.getParameter(request, prefix + "bs_slot", length));
            String[] bsRf = (JSPUtil.getParameter(request, prefix + "bs_rf", length));
            String[] excTeuTotal = (JSPUtil.getParameter(request, prefix + "exc_teu_total", length));
            String[] excTeuLdn = (JSPUtil.getParameter(request, prefix + "exc_teu_ldn", length));
            String[] excTeuEty = (JSPUtil.getParameter(request, prefix + "exc_teu_ety", length));
            String[] excDwtTeu = (JSPUtil.getParameter(request, prefix + "exc_dwt_teu", length));
            String[] excDwtRf = (JSPUtil.getParameter(request, prefix + "exc_dwt_rf", length));
            String[] priSlot = (JSPUtil.getParameter(request, prefix + "pri_slot", length));
            String[] priPlug = (JSPUtil.getParameter(request, prefix + "pri_plug", length));
            String[] amtBuyExcSlots = (JSPUtil.getParameter(request, prefix + "amt_buy_exc_slots", length));
            String[] amtUsedPlugs = (JSPUtil.getParameter(request, prefix + "amt_used_plugs", length));
            String[] ibCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", length));
            String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", length));
            String[] optionA = (JSPUtil.getParameter(request, prefix + "option_a", length));
	    	String[] optionB = (JSPUtil.getParameter(request, prefix + "option_b", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CntrStandardFormatVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ord[i] != null)
                    model.setOrd(ord[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (vpsPortCd[i] != null)
                    model.setVpsPortCd(vpsPortCd[i]);
                if (clptSeq[i] != null)
                    model.setClptSeq(clptSeq[i]);
                if (clptIndSeq[i] != null)
                    model.setClptIndSeq(clptIndSeq[i]);
                if (type[i] != null)
                    model.setType(type[i]);
                if (subOrd[i] != null)
                    model.setSubOrd(subOrd[i]);
                if (weight[i] != null)
                    model.setWeight(weight[i]);
                if (total[i] != null)
                    model.setTotal(total[i]);
                if (fQty1[i] != null)
                    model.setFQty1(fQty1[i]);
                if (fQty2[i] != null)
                    model.setFQty2(fQty2[i]);
                if (fQty3[i] != null)
                    model.setFQty3(fQty3[i]);
                if (fQty4[i] != null)
                    model.setFQty4(fQty4[i]);
                if (fQty5[i] != null)
                    model.setFQty5(fQty5[i]);
                if (fQty6[i] != null)
                    model.setFQty6(fQty6[i]);
                if (fQty7[i] != null)
                    model.setFQty7(fQty7[i]);
                if (fQty8[i] != null)
                    model.setFQty8(fQty8[i]);
                if (fQty9[i] != null)
                    model.setFQty9(fQty9[i]);
                if (fQty10[i] != null)
                    model.setFQty10(fQty10[i]);
                if (fQty11[i] != null)
                    model.setFQty11(fQty11[i]);
                if (fQty12[i] != null)
                    model.setFQty12(fQty12[i]);
                if (fQty13[i] != null)
                    model.setFQty13(fQty13[i]);
                if (fQty14[i] != null)
                    model.setFQty14(fQty14[i]);
                if (fQty15[i] != null)
                    model.setFQty15(fQty15[i]);
                if (fQty16[i] != null)
                    model.setFQty16(fQty16[i]);
                if (fQty17[i] != null)
                    model.setFQty17(fQty17[i]);
                if (fQty18[i] != null)
                    model.setFQty18(fQty18[i]);
                if (fQty19[i] != null)
                    model.setFQty19(fQty19[i]);
                if (fQty20[i] != null)
                    model.setFQty20(fQty20[i]);
                if (fQty21[i] != null)
                    model.setFQty21(fQty21[i]);
                if (fQty22[i] != null)
                    model.setFQty22(fQty22[i]);
                if (fQty23[i] != null)
                    model.setFQty23(fQty23[i]);
                if (fQty24[i] != null)
                    model.setFQty24(fQty24[i]);
                if (fQty25[i] != null)
                    model.setFQty25(fQty25[i]);
                if (fQty26[i] != null)
                    model.setFQty26(fQty26[i]);
                if (fQty27[i] != null)
                    model.setFQty27(fQty27[i]);
                if (fQty28[i] != null)
                    model.setFQty28(fQty28[i]);
                if (fQty29[i] != null)
                    model.setFQty29(fQty29[i]);
                if (fQty30[i] != null)
                    model.setFQty30(fQty30[i]);
                if (eQty1[i] != null)
                    model.setEQty1(eQty1[i]);
                if (eQty2[i] != null)
                    model.setEQty2(eQty2[i]);
                if (eQty3[i] != null)
                    model.setEQty3(eQty3[i]);
                if (eQty4[i] != null)
                    model.setEQty4(eQty4[i]);
                if (eQty5[i] != null)
                    model.setEQty5(eQty5[i]);
                if (eQty6[i] != null)
                    model.setEQty6(eQty6[i]);
                if (eQty7[i] != null)
                    model.setEQty7(eQty7[i]);
                if (eQty8[i] != null)
                    model.setEQty8(eQty8[i]);
                if (eQty9[i] != null)
                    model.setEQty9(eQty9[i]);
                if (eQty10[i] != null)
                    model.setEQty10(eQty10[i]);
                if (eQty11[i] != null)
                    model.setEQty11(eQty11[i]);
                if (eQty12[i] != null)
                    model.setEQty12(eQty12[i]);
                if (eQty13[i] != null)
                    model.setEQty13(eQty13[i]);
                if (eQty14[i] != null)
                    model.setEQty14(eQty14[i]);
                if (eQty15[i] != null)
                    model.setEQty15(eQty15[i]);
                if (eQty16[i] != null)
                    model.setEQty16(eQty16[i]);
                if (eQty17[i] != null)
                    model.setEQty17(eQty17[i]);
                if (eQty18[i] != null)
                    model.setEQty18(eQty18[i]);
                if (eQty19[i] != null)
                    model.setEQty19(eQty19[i]);
                if (eQty20[i] != null)
                    model.setEQty20(eQty20[i]);
                if (eQty21[i] != null)
                    model.setEQty21(eQty21[i]);
                if (eQty22[i] != null)
                    model.setEQty22(eQty22[i]);
                if (eQty23[i] != null)
                    model.setEQty23(eQty23[i]);
                if (eQty24[i] != null)
                    model.setEQty24(eQty24[i]);
                if (eQty25[i] != null)
                    model.setEQty25(eQty25[i]);
                if (eQty26[i] != null)
                    model.setEQty26(eQty26[i]);
                if (eQty27[i] != null)
                    model.setEQty27(eQty27[i]);
                if (eQty28[i] != null)
                    model.setEQty28(eQty28[i]);
                if (eQty29[i] != null)
                    model.setEQty29(eQty29[i]);
                if (eQty30[i] != null)
                    model.setEQty30(eQty30[i]);
                if (voidQty[i] != null)
                    model.setVoidQty(voidQty[i]);
                if (sumTotalTeu[i] != null)
                    model.setSumTotalTeu(sumTotalTeu[i]);
                if (sumLdnTeu[i] != null)
                    model.setSumLdnTeu(sumLdnTeu[i]);
                if (sumEtyTeu[i] != null)
                    model.setSumEtyTeu(sumEtyTeu[i]);
                if (sumWgtTon[i] != null)
                    model.setSumWgtTon(sumWgtTon[i]);
                if (sumWgtTeu[i] != null)
                    model.setSumWgtTeu(sumWgtTeu[i]);
                if (sumTeuByWgt[i] != null)
                    model.setSumTeuByWgt(sumTeuByWgt[i]);
                if (sumRfPlug[i] != null)
                    model.setSumRfPlug(sumRfPlug[i]);
                if (allocSlot[i] != null)
                    model.setAllocSlot(allocSlot[i]);
                if (allocRf[i] != null)
                    model.setAllocRf(allocRf[i]);
                if (bsSlot[i] != null)
                    model.setBsSlot(bsSlot[i]);
                if (bsRf[i] != null)
                    model.setBsRf(bsRf[i]);
                if (excTeuTotal[i] != null)
                    model.setExcTeuTotal(excTeuTotal[i]);
                if (excTeuLdn[i] != null)
                    model.setExcTeuLdn(excTeuLdn[i]);
                if (excTeuEty[i] != null)
                    model.setExcTeuEty(excTeuEty[i]);
                if (excDwtTeu[i] != null)
                    model.setExcDwtTeu(excDwtTeu[i]);
                if (excDwtRf[i] != null)
                    model.setExcDwtRf(excDwtRf[i]);
                if (priSlot[i] != null)
                    model.setPriSlot(priSlot[i]);
                if (priPlug[i] != null)
                    model.setPriPlug(priPlug[i]);
                if (amtBuyExcSlots[i] != null)
                    model.setAmtBuyExcSlots(amtBuyExcSlots[i]);
                if (amtUsedPlugs[i] != null)
                    model.setAmtUsedPlugs(amtUsedPlugs[i]);
                if (ibCssmVoyNo[i] != null)
                    model.setIbCssmVoyNo(ibCssmVoyNo[i]);
                if (obCssmVoyNo[i] != null)
                    model.setObCssmVoyNo(obCssmVoyNo[i]);
                if (optionA[i] != null) 
		    		model.setOptionA(optionA[i]);
				if (optionB[i] != null) 
		    		model.setOptionB(optionB[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCntrStandardFormatVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CntrStandardFormatVO[]
	 */
    public CntrStandardFormatVO[] getCntrStandardFormatVOs() {
        CntrStandardFormatVO[] vos = (CntrStandardFormatVO[]) models.toArray(new CntrStandardFormatVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
    public void unDataFormat() {
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ord = this.ord.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsPortCd = this.vpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptSeq = this.clptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptIndSeq = this.clptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.type = this.type.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.subOrd = this.subOrd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.weight = this.weight.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.total = this.total.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty1 = this.fQty1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty2 = this.fQty2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty3 = this.fQty3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty4 = this.fQty4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty5 = this.fQty5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty6 = this.fQty6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty7 = this.fQty7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty8 = this.fQty8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty9 = this.fQty9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty10 = this.fQty10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty11 = this.fQty11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty12 = this.fQty12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty13 = this.fQty13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty14 = this.fQty14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty15 = this.fQty15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty16 = this.fQty16.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty17 = this.fQty17.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty18 = this.fQty18.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty19 = this.fQty19.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty20 = this.fQty20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty21 = this.fQty21.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty22 = this.fQty22.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty23 = this.fQty23.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty24 = this.fQty24.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty25 = this.fQty25.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty26 = this.fQty26.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty27 = this.fQty27.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty28 = this.fQty28.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty29 = this.fQty29.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQty30 = this.fQty30.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty1 = this.eQty1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty2 = this.eQty2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty3 = this.eQty3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty4 = this.eQty4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty5 = this.eQty5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty6 = this.eQty6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty7 = this.eQty7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty8 = this.eQty8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty9 = this.eQty9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty10 = this.eQty10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty11 = this.eQty11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty12 = this.eQty12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty13 = this.eQty13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty14 = this.eQty14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty15 = this.eQty15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty16 = this.eQty16.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty17 = this.eQty17.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty18 = this.eQty18.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty19 = this.eQty19.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty20 = this.eQty20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty21 = this.eQty21.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty22 = this.eQty22.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty23 = this.eQty23.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty24 = this.eQty24.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty25 = this.eQty25.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty26 = this.eQty26.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty27 = this.eQty27.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty28 = this.eQty28.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty29 = this.eQty29.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eQty30 = this.eQty30.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.voidQty = this.voidQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumTotalTeu = this.sumTotalTeu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumLdnTeu = this.sumLdnTeu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumEtyTeu = this.sumEtyTeu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumWgtTon = this.sumWgtTon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumWgtTeu = this.sumWgtTeu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumTeuByWgt = this.sumTeuByWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumRfPlug = this.sumRfPlug.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.allocSlot = this.allocSlot.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.allocRf = this.allocRf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bsSlot = this.bsSlot.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bsRf = this.bsRf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.excTeuTotal = this.excTeuTotal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.excTeuLdn = this.excTeuLdn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.excTeuEty = this.excTeuEty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.excDwtTeu = this.excDwtTeu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.excDwtRf = this.excDwtRf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.priSlot = this.priSlot.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.priPlug = this.priPlug.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.amtBuyExcSlots = this.amtBuyExcSlots.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.amtUsedPlugs = this.amtUsedPlugs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibCssmVoyNo = this.ibCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCssmVoyNo = this.obCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.optionA = this.optionA.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.optionB = this.optionB.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
