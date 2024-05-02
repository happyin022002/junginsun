/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CntrConditionVO2.java
*@FileTitle : CntrConditionVO2
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.25 
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
public class CntrConditionVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CntrConditionVO> models = new ArrayList<CntrConditionVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String voyNo = null;

    /* Column Info */
    private String dirCd = null;

    /* Column Info */
    private String excelFlg = null;

    /* Column Info */
    private String preVslCd = null;

    /* Column Info */
    private String preVoyNo = null;

    /* Column Info */
    private String preDirCd = null;

    /* Column Info */
    private String lstPort = null;

    /* Column Info */
    private String searchType = null;

    /* Column Info */
    private String lstClptIndSeq = null;

    /* Column Info */
    private String tpszDatas = null;

    /* Column Info */
    private String ladenTpszDatas = null;

    /* Column Info */
    private String emptyTpszDatas = null;

    /* Column Info */
    private String ladenTpszCd1 = null;

    /* Column Info */
    private String ladenTpszCd2 = null;

    /* Column Info */
    private String ladenTpszCd3 = null;

    /* Column Info */
    private String ladenTpszCd4 = null;

    /* Column Info */
    private String ladenTpszCd5 = null;

    /* Column Info */
    private String ladenTpszCd6 = null;

    /* Column Info */
    private String ladenTpszCd7 = null;

    /* Column Info */
    private String ladenTpszCd8 = null;

    /* Column Info */
    private String ladenTpszCd9 = null;

    /* Column Info */
    private String ladenTpszCd10 = null;

    /* Column Info */
    private String ladenTpszCd11 = null;

    /* Column Info */
    private String ladenTpszCd12 = null;

    /* Column Info */
    private String ladenTpszCd13 = null;

    /* Column Info */
    private String ladenTpszCd14 = null;

    /* Column Info */
    private String ladenTpszCd15 = null;

    /* Column Info */
    private String ladenTpszCd16 = null;

    /* Column Info */
    private String ladenTpszCd17 = null;

    /* Column Info */
    private String ladenTpszCd18 = null;

    /* Column Info */
    private String ladenTpszCd19 = null;

    /* Column Info */
    private String ladenTpszCd20 = null;

    /* Column Info */
    private String ladenTpszCd21 = null;

    /* Column Info */
    private String ladenTpszCd22 = null;

    /* Column Info */
    private String ladenTpszCd23 = null;

    /* Column Info */
    private String ladenTpszCd24 = null;

    /* Column Info */
    private String ladenTpszCd25 = null;

    /* Column Info */
    private String ladenTpszCd26 = null;

    /* Column Info */
    private String ladenTpszCd27 = null;

    /* Column Info */
    private String ladenTpszCd28 = null;

    /* Column Info */
    private String ladenTpszCd29 = null;

    /* Column Info */
    private String ladenTpszCd30 = null;

    /* Column Info */
    private String emptyTpszCd1 = null;

    /* Column Info */
    private String emptyTpszCd2 = null;

    /* Column Info */
    private String emptyTpszCd3 = null;

    /* Column Info */
    private String emptyTpszCd4 = null;

    /* Column Info */
    private String emptyTpszCd5 = null;

    /* Column Info */
    private String emptyTpszCd6 = null;

    /* Column Info */
    private String emptyTpszCd7 = null;

    /* Column Info */
    private String emptyTpszCd8 = null;

    /* Column Info */
    private String emptyTpszCd9 = null;

    /* Column Info */
    private String emptyTpszCd10 = null;

    /* Column Info */
    private String emptyTpszCd11 = null;

    /* Column Info */
    private String emptyTpszCd12 = null;

    /* Column Info */
    private String emptyTpszCd13 = null;

    /* Column Info */
    private String emptyTpszCd14 = null;

    /* Column Info */
    private String emptyTpszCd15 = null;

    /* Column Info */
    private String emptyTpszCd16 = null;

    /* Column Info */
    private String emptyTpszCd17 = null;

    /* Column Info */
    private String emptyTpszCd18 = null;

    /* Column Info */
    private String emptyTpszCd19 = null;

    /* Column Info */
    private String emptyTpszCd20 = null;

    /* Column Info */
    private String emptyTpszCd21 = null;

    /* Column Info */
    private String emptyTpszCd22 = null;

    /* Column Info */
    private String emptyTpszCd23 = null;

    /* Column Info */
    private String emptyTpszCd24 = null;

    /* Column Info */
    private String emptyTpszCd25 = null;

    /* Column Info */
    private String emptyTpszCd26 = null;

    /* Column Info */
    private String emptyTpszCd27 = null;

    /* Column Info */
    private String emptyTpszCd28 = null;

    /* Column Info */
    private String emptyTpszCd29 = null;

    /* Column Info */
    private String emptyTpszCd30 = null;

    /* Column Info */
    private String vslSlanCd = null;

    /* Column Info */
    private String vslSlanNm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public CntrConditionVO() {
    }

    public CntrConditionVO(String ibflag, String pagerows, String slanCd, String vslCd, String voyNo, String dirCd, String excelFlg, String preVslCd, String preVoyNo, String preDirCd, String lstPort, String searchType, String lstClptIndSeq, String tpszDatas, String ladenTpszDatas, String emptyTpszDatas, String ladenTpszCd1, String ladenTpszCd2, String ladenTpszCd3, String ladenTpszCd4, String ladenTpszCd5, String ladenTpszCd6, String ladenTpszCd7, String ladenTpszCd8, String ladenTpszCd9, String ladenTpszCd10, String ladenTpszCd11, String ladenTpszCd12, String ladenTpszCd13, String ladenTpszCd14, String ladenTpszCd15, String ladenTpszCd16, String ladenTpszCd17, String ladenTpszCd18, String ladenTpszCd19, String ladenTpszCd20, String ladenTpszCd21, String ladenTpszCd22, String ladenTpszCd23, String ladenTpszCd24, String ladenTpszCd25, String ladenTpszCd26, String ladenTpszCd27, String ladenTpszCd28, String ladenTpszCd29, String ladenTpszCd30, String emptyTpszCd1, String emptyTpszCd2, String emptyTpszCd3, String emptyTpszCd4, String emptyTpszCd5, String emptyTpszCd6, String emptyTpszCd7, String emptyTpszCd8, String emptyTpszCd9, String emptyTpszCd10, String emptyTpszCd11, String emptyTpszCd12, String emptyTpszCd13, String emptyTpszCd14, String emptyTpszCd15, String emptyTpszCd16, String emptyTpszCd17, String emptyTpszCd18, String emptyTpszCd19, String emptyTpszCd20, String emptyTpszCd21, String emptyTpszCd22, String emptyTpszCd23, String emptyTpszCd24, String emptyTpszCd25, String emptyTpszCd26, String emptyTpszCd27, String emptyTpszCd28, String emptyTpszCd29, String emptyTpszCd30, String vslSlanCd, String vslSlanNm) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.slanCd = slanCd;
        this.vslCd = vslCd;
        this.voyNo = voyNo;
        this.dirCd = dirCd;
        this.excelFlg = excelFlg;
        this.preVslCd = preVslCd;
        this.preVoyNo = preVoyNo;
        this.preDirCd = preDirCd;
        this.lstPort = lstPort;
        this.searchType = searchType;
        this.lstClptIndSeq = lstClptIndSeq;
        this.tpszDatas = tpszDatas;
        this.ladenTpszDatas = ladenTpszDatas;
        this.emptyTpszDatas = emptyTpszDatas;
        this.ladenTpszCd1 = ladenTpszCd1;
        this.ladenTpszCd2 = ladenTpszCd2;
        this.ladenTpszCd3 = ladenTpszCd3;
        this.ladenTpszCd4 = ladenTpszCd4;
        this.ladenTpszCd5 = ladenTpszCd5;
        this.ladenTpszCd6 = ladenTpszCd6;
        this.ladenTpszCd7 = ladenTpszCd7;
        this.ladenTpszCd8 = ladenTpszCd8;
        this.ladenTpszCd9 = ladenTpszCd9;
        this.ladenTpszCd10 = ladenTpszCd10;
        this.ladenTpszCd11 = ladenTpszCd11;
        this.ladenTpszCd12 = ladenTpszCd12;
        this.ladenTpszCd13 = ladenTpszCd13;
        this.ladenTpszCd14 = ladenTpszCd14;
        this.ladenTpszCd15 = ladenTpszCd15;
        this.ladenTpszCd16 = ladenTpszCd16;
        this.ladenTpszCd17 = ladenTpszCd17;
        this.ladenTpszCd18 = ladenTpszCd18;
        this.ladenTpszCd19 = ladenTpszCd19;
        this.ladenTpszCd20 = ladenTpszCd20;
        this.ladenTpszCd21 = ladenTpszCd21;
        this.ladenTpszCd22 = ladenTpszCd22;
        this.ladenTpszCd23 = ladenTpszCd23;
        this.ladenTpszCd24 = ladenTpszCd24;
        this.ladenTpszCd25 = ladenTpszCd25;
        this.ladenTpszCd26 = ladenTpszCd26;
        this.ladenTpszCd27 = ladenTpszCd27;
        this.ladenTpszCd28 = ladenTpszCd28;
        this.ladenTpszCd29 = ladenTpszCd29;
        this.ladenTpszCd30 = ladenTpszCd30;
        this.emptyTpszCd1 = emptyTpszCd1;
        this.emptyTpszCd2 = emptyTpszCd2;
        this.emptyTpszCd3 = emptyTpszCd3;
        this.emptyTpszCd4 = emptyTpszCd4;
        this.emptyTpszCd5 = emptyTpszCd5;
        this.emptyTpszCd6 = emptyTpszCd6;
        this.emptyTpszCd7 = emptyTpszCd7;
        this.emptyTpszCd8 = emptyTpszCd8;
        this.emptyTpszCd9 = emptyTpszCd9;
        this.emptyTpszCd10 = emptyTpszCd10;
        this.emptyTpszCd11 = emptyTpszCd11;
        this.emptyTpszCd12 = emptyTpszCd12;
        this.emptyTpszCd13 = emptyTpszCd13;
        this.emptyTpszCd14 = emptyTpszCd14;
        this.emptyTpszCd15 = emptyTpszCd15;
        this.emptyTpszCd16 = emptyTpszCd16;
        this.emptyTpszCd17 = emptyTpszCd17;
        this.emptyTpszCd18 = emptyTpszCd18;
        this.emptyTpszCd19 = emptyTpszCd19;
        this.emptyTpszCd20 = emptyTpszCd20;
        this.emptyTpszCd21 = emptyTpszCd21;
        this.emptyTpszCd22 = emptyTpszCd22;
        this.emptyTpszCd23 = emptyTpszCd23;
        this.emptyTpszCd24 = emptyTpszCd24;
        this.emptyTpszCd25 = emptyTpszCd25;
        this.emptyTpszCd26 = emptyTpszCd26;
        this.emptyTpszCd27 = emptyTpszCd27;
        this.emptyTpszCd28 = emptyTpszCd28;
        this.emptyTpszCd29 = emptyTpszCd29;
        this.emptyTpszCd30 = emptyTpszCd30;
        this.vslSlanCd = vslSlanCd;
        this.vslSlanNm = vslSlanNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("voy_no", getVoyNo());
        this.hashColumns.put("dir_cd", getDirCd());
        this.hashColumns.put("excel_flg", getExcelFlg());
        this.hashColumns.put("pre_vsl_cd", getPreVslCd());
        this.hashColumns.put("pre_voy_no", getPreVoyNo());
        this.hashColumns.put("pre_dir_cd", getPreDirCd());
        this.hashColumns.put("lst_port", getLstPort());
        this.hashColumns.put("search_type", getSearchType());
        this.hashColumns.put("lst_clpt_ind_seq", getLstClptIndSeq());
        this.hashColumns.put("tpsz_datas", getTpszDatas());
        this.hashColumns.put("laden_tpsz_datas", getLadenTpszDatas());
        this.hashColumns.put("empty_tpsz_datas", getEmptyTpszDatas());
        this.hashColumns.put("laden_tpsz_cd1", getLadenTpszCd1());
        this.hashColumns.put("laden_tpsz_cd2", getLadenTpszCd2());
        this.hashColumns.put("laden_tpsz_cd3", getLadenTpszCd3());
        this.hashColumns.put("laden_tpsz_cd4", getLadenTpszCd4());
        this.hashColumns.put("laden_tpsz_cd5", getLadenTpszCd5());
        this.hashColumns.put("laden_tpsz_cd6", getLadenTpszCd6());
        this.hashColumns.put("laden_tpsz_cd7", getLadenTpszCd7());
        this.hashColumns.put("laden_tpsz_cd8", getLadenTpszCd8());
        this.hashColumns.put("laden_tpsz_cd9", getLadenTpszCd9());
        this.hashColumns.put("laden_tpsz_cd10", getLadenTpszCd10());
        this.hashColumns.put("laden_tpsz_cd11", getLadenTpszCd11());
        this.hashColumns.put("laden_tpsz_cd12", getLadenTpszCd12());
        this.hashColumns.put("laden_tpsz_cd13", getLadenTpszCd13());
        this.hashColumns.put("laden_tpsz_cd14", getLadenTpszCd14());
        this.hashColumns.put("laden_tpsz_cd15", getLadenTpszCd15());
        this.hashColumns.put("laden_tpsz_cd16", getLadenTpszCd16());
        this.hashColumns.put("laden_tpsz_cd17", getLadenTpszCd17());
        this.hashColumns.put("laden_tpsz_cd18", getLadenTpszCd18());
        this.hashColumns.put("laden_tpsz_cd19", getLadenTpszCd19());
        this.hashColumns.put("laden_tpsz_cd20", getLadenTpszCd20());
        this.hashColumns.put("laden_tpsz_cd21", getLadenTpszCd21());
        this.hashColumns.put("laden_tpsz_cd22", getLadenTpszCd22());
        this.hashColumns.put("laden_tpsz_cd23", getLadenTpszCd23());
        this.hashColumns.put("laden_tpsz_cd24", getLadenTpszCd24());
        this.hashColumns.put("laden_tpsz_cd25", getLadenTpszCd25());
        this.hashColumns.put("laden_tpsz_cd26", getLadenTpszCd26());
        this.hashColumns.put("laden_tpsz_cd27", getLadenTpszCd27());
        this.hashColumns.put("laden_tpsz_cd28", getLadenTpszCd28());
        this.hashColumns.put("laden_tpsz_cd29", getLadenTpszCd29());
        this.hashColumns.put("laden_tpsz_cd30", getLadenTpszCd30());
        this.hashColumns.put("empty_tpsz_cd1", getEmptyTpszCd1());
        this.hashColumns.put("empty_tpsz_cd2", getEmptyTpszCd2());
        this.hashColumns.put("empty_tpsz_cd3", getEmptyTpszCd3());
        this.hashColumns.put("empty_tpsz_cd4", getEmptyTpszCd4());
        this.hashColumns.put("empty_tpsz_cd5", getEmptyTpszCd5());
        this.hashColumns.put("empty_tpsz_cd6", getEmptyTpszCd6());
        this.hashColumns.put("empty_tpsz_cd7", getEmptyTpszCd7());
        this.hashColumns.put("empty_tpsz_cd8", getEmptyTpszCd8());
        this.hashColumns.put("empty_tpsz_cd9", getEmptyTpszCd9());
        this.hashColumns.put("empty_tpsz_cd10", getEmptyTpszCd10());
        this.hashColumns.put("empty_tpsz_cd11", getEmptyTpszCd11());
        this.hashColumns.put("empty_tpsz_cd12", getEmptyTpszCd12());
        this.hashColumns.put("empty_tpsz_cd13", getEmptyTpszCd13());
        this.hashColumns.put("empty_tpsz_cd14", getEmptyTpszCd14());
        this.hashColumns.put("empty_tpsz_cd15", getEmptyTpszCd15());
        this.hashColumns.put("empty_tpsz_cd16", getEmptyTpszCd16());
        this.hashColumns.put("empty_tpsz_cd17", getEmptyTpszCd17());
        this.hashColumns.put("empty_tpsz_cd18", getEmptyTpszCd18());
        this.hashColumns.put("empty_tpsz_cd19", getEmptyTpszCd19());
        this.hashColumns.put("empty_tpsz_cd20", getEmptyTpszCd20());
        this.hashColumns.put("empty_tpsz_cd21", getEmptyTpszCd21());
        this.hashColumns.put("empty_tpsz_cd22", getEmptyTpszCd22());
        this.hashColumns.put("empty_tpsz_cd23", getEmptyTpszCd23());
        this.hashColumns.put("empty_tpsz_cd24", getEmptyTpszCd24());
        this.hashColumns.put("empty_tpsz_cd25", getEmptyTpszCd25());
        this.hashColumns.put("empty_tpsz_cd26", getEmptyTpszCd26());
        this.hashColumns.put("empty_tpsz_cd27", getEmptyTpszCd27());
        this.hashColumns.put("empty_tpsz_cd28", getEmptyTpszCd28());
        this.hashColumns.put("empty_tpsz_cd29", getEmptyTpszCd29());
        this.hashColumns.put("empty_tpsz_cd30", getEmptyTpszCd30());
        this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
        this.hashColumns.put("vsl_slan_nm", getVslSlanNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("voy_no", "voyNo");
        this.hashFields.put("dir_cd", "dirCd");
        this.hashFields.put("excel_flg", "excelFlg");
        this.hashFields.put("pre_vsl_cd", "preVslCd");
        this.hashFields.put("pre_voy_no", "preVoyNo");
        this.hashFields.put("pre_dir_cd", "preDirCd");
        this.hashFields.put("lst_port", "lstPort");
        this.hashFields.put("search_type", "searchType");
        this.hashFields.put("pre_clpt_ind_seq", "preClptIndSeq");
        this.hashFields.put("tpsz_datas", "tpszDatas");
        this.hashFields.put("laden_tpsz_datas", "ladenTpszDatas");
        this.hashFields.put("empty_tpsz_datas", "emptyTpszDatas");
        this.hashFields.put("laden_tpsz_cd1", "ladenTpszCd1");
        this.hashFields.put("laden_tpsz_cd2", "ladenTpszCd2");
        this.hashFields.put("laden_tpsz_cd3", "ladenTpszCd3");
        this.hashFields.put("laden_tpsz_cd4", "ladenTpszCd4");
        this.hashFields.put("laden_tpsz_cd5", "ladenTpszCd5");
        this.hashFields.put("laden_tpsz_cd6", "ladenTpszCd6");
        this.hashFields.put("laden_tpsz_cd7", "ladenTpszCd7");
        this.hashFields.put("laden_tpsz_cd8", "ladenTpszCd8");
        this.hashFields.put("laden_tpsz_cd9", "ladenTpszCd9");
        this.hashFields.put("laden_tpsz_cd10", "ladenTpszCd10");
        this.hashFields.put("laden_tpsz_cd11", "ladenTpszCd11");
        this.hashFields.put("laden_tpsz_cd12", "ladenTpszCd12");
        this.hashFields.put("laden_tpsz_cd13", "ladenTpszCd13");
        this.hashFields.put("laden_tpsz_cd14", "ladenTpszCd14");
        this.hashFields.put("laden_tpsz_cd15", "ladenTpszCd15");
        this.hashFields.put("laden_tpsz_cd16", "ladenTpszCd16");
        this.hashFields.put("laden_tpsz_cd17", "ladenTpszCd17");
        this.hashFields.put("laden_tpsz_cd18", "ladenTpszCd18");
        this.hashFields.put("laden_tpsz_cd19", "ladenTpszCd19");
        this.hashFields.put("laden_tpsz_cd20", "ladenTpszCd20");
        this.hashFields.put("laden_tpsz_cd21", "ladenTpszCd21");
        this.hashFields.put("laden_tpsz_cd22", "ladenTpszCd22");
        this.hashFields.put("laden_tpsz_cd23", "ladenTpszCd23");
        this.hashFields.put("laden_tpsz_cd24", "ladenTpszCd24");
        this.hashFields.put("laden_tpsz_cd25", "ladenTpszCd25");
        this.hashFields.put("laden_tpsz_cd26", "ladenTpszCd26");
        this.hashFields.put("laden_tpsz_cd27", "ladenTpszCd27");
        this.hashFields.put("laden_tpsz_cd28", "ladenTpszCd28");
        this.hashFields.put("laden_tpsz_cd29", "ladenTpszCd29");
        this.hashFields.put("laden_tpsz_cd30", "ladenTpszCd30");
        this.hashFields.put("empty_tpsz_cd1", "emptyTpszCd1");
        this.hashFields.put("empty_tpsz_cd2", "emptyTpszCd2");
        this.hashFields.put("empty_tpsz_cd3", "emptyTpszCd3");
        this.hashFields.put("empty_tpsz_cd4", "emptyTpszCd4");
        this.hashFields.put("empty_tpsz_cd5", "emptyTpszCd5");
        this.hashFields.put("empty_tpsz_cd6", "emptyTpszCd6");
        this.hashFields.put("empty_tpsz_cd7", "emptyTpszCd7");
        this.hashFields.put("empty_tpsz_cd8", "emptyTpszCd8");
        this.hashFields.put("empty_tpsz_cd9", "emptyTpszCd9");
        this.hashFields.put("empty_tpsz_cd10", "emptyTpszCd10");
        this.hashFields.put("empty_tpsz_cd11", "emptyTpszCd11");
        this.hashFields.put("empty_tpsz_cd12", "emptyTpszCd12");
        this.hashFields.put("empty_tpsz_cd13", "emptyTpszCd13");
        this.hashFields.put("empty_tpsz_cd14", "emptyTpszCd14");
        this.hashFields.put("empty_tpsz_cd15", "emptyTpszCd15");
        this.hashFields.put("empty_tpsz_cd16", "emptyTpszCd16");
        this.hashFields.put("empty_tpsz_cd17", "emptyTpszCd17");
        this.hashFields.put("empty_tpsz_cd18", "emptyTpszCd18");
        this.hashFields.put("empty_tpsz_cd19", "emptyTpszCd19");
        this.hashFields.put("empty_tpsz_cd20", "emptyTpszCd20");
        this.hashFields.put("empty_tpsz_cd21", "emptyTpszCd21");
        this.hashFields.put("empty_tpsz_cd22", "emptyTpszCd22");
        this.hashFields.put("empty_tpsz_cd23", "emptyTpszCd23");
        this.hashFields.put("empty_tpsz_cd24", "emptyTpszCd24");
        this.hashFields.put("empty_tpsz_cd25", "emptyTpszCd25");
        this.hashFields.put("empty_tpsz_cd26", "emptyTpszCd26");
        this.hashFields.put("empty_tpsz_cd27", "emptyTpszCd27");
        this.hashFields.put("empty_tpsz_cd28", "emptyTpszCd28");
        this.hashFields.put("empty_tpsz_cd29", "emptyTpszCd29");
        this.hashFields.put("empty_tpsz_cd30", "emptyTpszCd30");
        this.hashFields.put("vsl_slan_cd", "vslSlanCd");
        this.hashFields.put("vsl_slan_nm", "vslSlanNm");
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
	 * @param String slanCd
	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * 
	 * @return String slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
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
	 * @param String voyNo
	 */
    public void setVoyNo(String voyNo) {
        this.voyNo = voyNo;
    }

    /**
	 * 
	 * @return String voyNo
	 */
    public String getVoyNo() {
        return this.voyNo;
    }

    /**
	 *
	 * @param String dirCd
	 */
    public void setDirCd(String dirCd) {
        this.dirCd = dirCd;
    }

    /**
	 * 
	 * @return String dirCd
	 */
    public String getDirCd() {
        return this.dirCd;
    }

    /**
	 *
	 * @param String excelFlg
	 */
    public void setExcelFlg(String excelFlg) {
        this.excelFlg = excelFlg;
    }

    /**
	 * 
	 * @return String excelFlg
	 */
    public String getExcelFlg() {
        return this.excelFlg;
    }

    /**
	 *
	 * @param String preVslCd
	 */
    public void setPreVslCd(String preVslCd) {
        this.preVslCd = preVslCd;
    }

    /**
	 * 
	 * @return String preVslCd
	 */
    public String getPreVslCd() {
        return this.preVslCd;
    }

    /**
	 *
	 * @param String preVoyNo
	 */
    public void setPreVoyNo(String preVoyNo) {
        this.preVoyNo = preVoyNo;
    }

    /**
	 * 
	 * @return String preVoyNo
	 */
    public String getPreVoyNo() {
        return this.preVoyNo;
    }

    /**
	 *
	 * @param String preDirCd
	 */
    public void setPreDirCd(String preDirCd) {
        this.preDirCd = preDirCd;
    }

    /**
	 * 
	 * @return String preDirCd
	 */
    public String getPreDirCd() {
        return this.preDirCd;
    }

    /**
	 *
	 * @param String lstPort
	 */
    public void setLstPort(String lstPort) {
        this.lstPort = lstPort;
    }

    /**
	 * 
	 * @return String lstPort
	 */
    public String getLstPort() {
        return this.lstPort;
    }

    /**
	 *
	 * @param String searchType
	 */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    /**
	 * 
	 * @return String searchType
	 */
    public String getSearchType() {
        return this.searchType;
    }

    /**
	 *
	 * @param String preClptIndSeq
	 */
    public void setLstClptIndSeq(String lstClptIndSeq) {
        this.lstClptIndSeq = lstClptIndSeq;
    }

    /**
	 * 
	 * @return String preClptIndSeq
	 */
    public String getLstClptIndSeq() {
        return this.lstClptIndSeq;
    }

    /**
	 *
	 * @param String tpszDatas
	 */
    public void setTpszDatas(String tpszDatas) {
        this.tpszDatas = tpszDatas;
    }

    /**
	 * 
	 * @return String tpszDatas
	 */
    public String getTpszDatas() {
        return this.tpszDatas;
    }

    /**
	 *
	 * @param String ladenTpszDatas
	 */
    public void setLadenTpszDatas(String ladenTpszDatas) {
        this.ladenTpszDatas = ladenTpszDatas;
    }

    /**
	 * 
	 * @return String ladenTpszDatas
	 */
    public String getLadenTpszDatas() {
        return this.ladenTpszDatas;
    }

    /**
	 *
	 * @param String emptyTpszDatas
	 */
    public void setEmptyTpszDatas(String emptyTpszDatas) {
        this.emptyTpszDatas = emptyTpszDatas;
    }

    /**
	 * 
	 * @return String emptyTpszDatas
	 */
    public String getEmptyTpszDatas() {
        return this.emptyTpszDatas;
    }

    /**
	 *
	 * @param String ladenTpszCd1
	 */
    public void setLadenTpszCd1(String ladenTpszCd1) {
        this.ladenTpszCd1 = ladenTpszCd1;
    }

    /**
	 * 
	 * @return String ladenTpszCd1
	 */
    public String getLadenTpszCd1() {
        return this.ladenTpszCd1;
    }

    /**
	 *
	 * @param String ladenTpszCd2
	 */
    public void setLadenTpszCd2(String ladenTpszCd2) {
        this.ladenTpszCd2 = ladenTpszCd2;
    }

    /**
	 * 
	 * @return String ladenTpszCd2
	 */
    public String getLadenTpszCd2() {
        return this.ladenTpszCd2;
    }

    /**
	 *
	 * @param String ladenTpszCd3
	 */
    public void setLadenTpszCd3(String ladenTpszCd3) {
        this.ladenTpszCd3 = ladenTpszCd3;
    }

    /**
	 * 
	 * @return String ladenTpszCd3
	 */
    public String getLadenTpszCd3() {
        return this.ladenTpszCd3;
    }

    /**
	 *
	 * @param String ladenTpszCd4
	 */
    public void setLadenTpszCd4(String ladenTpszCd4) {
        this.ladenTpszCd4 = ladenTpszCd4;
    }

    /**
	 * 
	 * @return String ladenTpszCd4
	 */
    public String getLadenTpszCd4() {
        return this.ladenTpszCd4;
    }

    /**
	 *
	 * @param String ladenTpszCd5
	 */
    public void setLadenTpszCd5(String ladenTpszCd5) {
        this.ladenTpszCd5 = ladenTpszCd5;
    }

    /**
	 * 
	 * @return String ladenTpszCd5
	 */
    public String getLadenTpszCd5() {
        return this.ladenTpszCd5;
    }

    /**
	 *
	 * @param String ladenTpszCd6
	 */
    public void setLadenTpszCd6(String ladenTpszCd6) {
        this.ladenTpszCd6 = ladenTpszCd6;
    }

    /**
	 * 
	 * @return String ladenTpszCd6
	 */
    public String getLadenTpszCd6() {
        return this.ladenTpszCd6;
    }

    /**
	 *
	 * @param String ladenTpszCd7
	 */
    public void setLadenTpszCd7(String ladenTpszCd7) {
        this.ladenTpszCd7 = ladenTpszCd7;
    }

    /**
	 * 
	 * @return String ladenTpszCd7
	 */
    public String getLadenTpszCd7() {
        return this.ladenTpszCd7;
    }

    /**
	 *
	 * @param String ladenTpszCd8
	 */
    public void setLadenTpszCd8(String ladenTpszCd8) {
        this.ladenTpszCd8 = ladenTpszCd8;
    }

    /**
	 * 
	 * @return String ladenTpszCd8
	 */
    public String getLadenTpszCd8() {
        return this.ladenTpszCd8;
    }

    /**
	 *
	 * @param String ladenTpszCd9
	 */
    public void setLadenTpszCd9(String ladenTpszCd9) {
        this.ladenTpszCd9 = ladenTpszCd9;
    }

    /**
	 * 
	 * @return String ladenTpszCd9
	 */
    public String getLadenTpszCd9() {
        return this.ladenTpszCd9;
    }

    /**
	 *
	 * @param String ladenTpszCd10
	 */
    public void setLadenTpszCd10(String ladenTpszCd10) {
        this.ladenTpszCd10 = ladenTpszCd10;
    }

    /**
	 * 
	 * @return String ladenTpszCd10
	 */
    public String getLadenTpszCd10() {
        return this.ladenTpszCd10;
    }

    /**
	 *
	 * @param String ladenTpszCd11
	 */
    public void setLadenTpszCd11(String ladenTpszCd11) {
        this.ladenTpszCd11 = ladenTpszCd11;
    }

    /**
	 * 
	 * @return String ladenTpszCd11
	 */
    public String getLadenTpszCd11() {
        return this.ladenTpszCd11;
    }

    /**
	 *
	 * @param String ladenTpszCd12
	 */
    public void setLadenTpszCd12(String ladenTpszCd12) {
        this.ladenTpszCd12 = ladenTpszCd12;
    }

    /**
	 * 
	 * @return String ladenTpszCd12
	 */
    public String getLadenTpszCd12() {
        return this.ladenTpszCd12;
    }

    /**
	 *
	 * @param String ladenTpszCd13
	 */
    public void setLadenTpszCd13(String ladenTpszCd13) {
        this.ladenTpszCd13 = ladenTpszCd13;
    }

    /**
	 * 
	 * @return String ladenTpszCd13
	 */
    public String getLadenTpszCd13() {
        return this.ladenTpszCd13;
    }

    /**
	 *
	 * @param String ladenTpszCd14
	 */
    public void setLadenTpszCd14(String ladenTpszCd14) {
        this.ladenTpszCd14 = ladenTpszCd14;
    }

    /**
	 * 
	 * @return String ladenTpszCd14
	 */
    public String getLadenTpszCd14() {
        return this.ladenTpszCd14;
    }

    /**
	 *
	 * @param String ladenTpszCd15
	 */
    public void setLadenTpszCd15(String ladenTpszCd15) {
        this.ladenTpszCd15 = ladenTpszCd15;
    }

    /**
	 * 
	 * @return String ladenTpszCd15
	 */
    public String getLadenTpszCd15() {
        return this.ladenTpszCd15;
    }

    /**
	 *
	 * @param String ladenTpszCd16
	 */
    public void setLadenTpszCd16(String ladenTpszCd16) {
        this.ladenTpszCd16 = ladenTpszCd16;
    }

    /**
	 * 
	 * @return String ladenTpszCd16
	 */
    public String getLadenTpszCd16() {
        return this.ladenTpszCd16;
    }

    /**
	 *
	 * @param String ladenTpszCd17
	 */
    public void setLadenTpszCd17(String ladenTpszCd17) {
        this.ladenTpszCd17 = ladenTpszCd17;
    }

    /**
	 * 
	 * @return String ladenTpszCd17
	 */
    public String getLadenTpszCd17() {
        return this.ladenTpszCd17;
    }

    /**
	 *
	 * @param String ladenTpszCd18
	 */
    public void setLadenTpszCd18(String ladenTpszCd18) {
        this.ladenTpszCd18 = ladenTpszCd18;
    }

    /**
	 * 
	 * @return String ladenTpszCd18
	 */
    public String getLadenTpszCd18() {
        return this.ladenTpszCd18;
    }

    /**
	 *
	 * @param String ladenTpszCd19
	 */
    public void setLadenTpszCd19(String ladenTpszCd19) {
        this.ladenTpszCd19 = ladenTpszCd19;
    }

    /**
	 * 
	 * @return String ladenTpszCd19
	 */
    public String getLadenTpszCd19() {
        return this.ladenTpszCd19;
    }

    /**
	 *
	 * @param String ladenTpszCd20
	 */
    public void setLadenTpszCd20(String ladenTpszCd20) {
        this.ladenTpszCd20 = ladenTpszCd20;
    }

    /**
	 * 
	 * @return String ladenTpszCd20
	 */
    public String getLadenTpszCd20() {
        return this.ladenTpszCd20;
    }

    /**
	 *
	 * @param String ladenTpszCd21
	 */
    public void setLadenTpszCd21(String ladenTpszCd21) {
        this.ladenTpszCd21 = ladenTpszCd21;
    }

    /**
	 * 
	 * @return String ladenTpszCd21
	 */
    public String getLadenTpszCd21() {
        return this.ladenTpszCd21;
    }

    /**
	 *
	 * @param String ladenTpszCd22
	 */
    public void setLadenTpszCd22(String ladenTpszCd22) {
        this.ladenTpszCd22 = ladenTpszCd22;
    }

    /**
	 * 
	 * @return String ladenTpszCd22
	 */
    public String getLadenTpszCd22() {
        return this.ladenTpszCd22;
    }

    /**
	 *
	 * @param String ladenTpszCd23
	 */
    public void setLadenTpszCd23(String ladenTpszCd23) {
        this.ladenTpszCd23 = ladenTpszCd23;
    }

    /**
	 * 
	 * @return String ladenTpszCd23
	 */
    public String getLadenTpszCd23() {
        return this.ladenTpszCd23;
    }

    /**
	 *
	 * @param String ladenTpszCd24
	 */
    public void setLadenTpszCd24(String ladenTpszCd24) {
        this.ladenTpszCd24 = ladenTpszCd24;
    }

    /**
	 * 
	 * @return String ladenTpszCd24
	 */
    public String getLadenTpszCd24() {
        return this.ladenTpszCd24;
    }

    /**
	 *
	 * @param String ladenTpszCd25
	 */
    public void setLadenTpszCd25(String ladenTpszCd25) {
        this.ladenTpszCd25 = ladenTpszCd25;
    }

    /**
	 * 
	 * @return String ladenTpszCd25
	 */
    public String getLadenTpszCd25() {
        return this.ladenTpszCd25;
    }

    /**
	 *
	 * @param String ladenTpszCd26
	 */
    public void setLadenTpszCd26(String ladenTpszCd26) {
        this.ladenTpszCd26 = ladenTpszCd26;
    }

    /**
	 * 
	 * @return String ladenTpszCd26
	 */
    public String getLadenTpszCd26() {
        return this.ladenTpszCd26;
    }

    /**
	 *
	 * @param String ladenTpszCd27
	 */
    public void setLadenTpszCd27(String ladenTpszCd27) {
        this.ladenTpszCd27 = ladenTpszCd27;
    }

    /**
	 * 
	 * @return String ladenTpszCd27
	 */
    public String getLadenTpszCd27() {
        return this.ladenTpszCd27;
    }

    /**
	 *
	 * @param String ladenTpszCd28
	 */
    public void setLadenTpszCd28(String ladenTpszCd28) {
        this.ladenTpszCd28 = ladenTpszCd28;
    }

    /**
	 * 
	 * @return String ladenTpszCd28
	 */
    public String getLadenTpszCd28() {
        return this.ladenTpszCd28;
    }

    /**
	 *
	 * @param String ladenTpszCd29
	 */
    public void setLadenTpszCd29(String ladenTpszCd29) {
        this.ladenTpszCd29 = ladenTpszCd29;
    }

    /**
	 * 
	 * @return String ladenTpszCd29
	 */
    public String getLadenTpszCd29() {
        return this.ladenTpszCd29;
    }

    /**
	 *
	 * @param String ladenTpszCd30
	 */
    public void setLadenTpszCd30(String ladenTpszCd30) {
        this.ladenTpszCd30 = ladenTpszCd30;
    }

    /**
	 * 
	 * @return String ladenTpszCd30
	 */
    public String getLadenTpszCd30() {
        return this.ladenTpszCd30;
    }

    /**
	 *
	 * @param String emptyTpszCd1
	 */
    public void setEmptyTpszCd1(String emptyTpszCd1) {
        this.emptyTpszCd1 = emptyTpszCd1;
    }

    /**
	 * 
	 * @return String emptyTpszCd1
	 */
    public String getEmptyTpszCd1() {
        return this.emptyTpszCd1;
    }

    /**
	 *
	 * @param String emptyTpszCd2
	 */
    public void setEmptyTpszCd2(String emptyTpszCd2) {
        this.emptyTpszCd2 = emptyTpszCd2;
    }

    /**
	 * 
	 * @return String emptyTpszCd2
	 */
    public String getEmptyTpszCd2() {
        return this.emptyTpszCd2;
    }

    /**
	 *
	 * @param String emptyTpszCd3
	 */
    public void setEmptyTpszCd3(String emptyTpszCd3) {
        this.emptyTpszCd3 = emptyTpszCd3;
    }

    /**
	 * 
	 * @return String emptyTpszCd3
	 */
    public String getEmptyTpszCd3() {
        return this.emptyTpszCd3;
    }

    /**
	 *
	 * @param String emptyTpszCd4
	 */
    public void setEmptyTpszCd4(String emptyTpszCd4) {
        this.emptyTpszCd4 = emptyTpszCd4;
    }

    /**
	 * 
	 * @return String emptyTpszCd4
	 */
    public String getEmptyTpszCd4() {
        return this.emptyTpszCd4;
    }

    /**
	 *
	 * @param String emptyTpszCd5
	 */
    public void setEmptyTpszCd5(String emptyTpszCd5) {
        this.emptyTpszCd5 = emptyTpszCd5;
    }

    /**
	 * 
	 * @return String emptyTpszCd5
	 */
    public String getEmptyTpszCd5() {
        return this.emptyTpszCd5;
    }

    /**
	 *
	 * @param String emptyTpszCd6
	 */
    public void setEmptyTpszCd6(String emptyTpszCd6) {
        this.emptyTpszCd6 = emptyTpszCd6;
    }

    /**
	 * 
	 * @return String emptyTpszCd6
	 */
    public String getEmptyTpszCd6() {
        return this.emptyTpszCd6;
    }

    /**
	 *
	 * @param String emptyTpszCd7
	 */
    public void setEmptyTpszCd7(String emptyTpszCd7) {
        this.emptyTpszCd7 = emptyTpszCd7;
    }

    /**
	 * 
	 * @return String emptyTpszCd7
	 */
    public String getEmptyTpszCd7() {
        return this.emptyTpszCd7;
    }

    /**
	 *
	 * @param String emptyTpszCd8
	 */
    public void setEmptyTpszCd8(String emptyTpszCd8) {
        this.emptyTpszCd8 = emptyTpszCd8;
    }

    /**
	 * 
	 * @return String emptyTpszCd8
	 */
    public String getEmptyTpszCd8() {
        return this.emptyTpszCd8;
    }

    /**
	 *
	 * @param String emptyTpszCd9
	 */
    public void setEmptyTpszCd9(String emptyTpszCd9) {
        this.emptyTpszCd9 = emptyTpszCd9;
    }

    /**
	 * 
	 * @return String emptyTpszCd9
	 */
    public String getEmptyTpszCd9() {
        return this.emptyTpszCd9;
    }

    /**
	 *
	 * @param String emptyTpszCd10
	 */
    public void setEmptyTpszCd10(String emptyTpszCd10) {
        this.emptyTpszCd10 = emptyTpszCd10;
    }

    /**
	 * 
	 * @return String emptyTpszCd10
	 */
    public String getEmptyTpszCd10() {
        return this.emptyTpszCd10;
    }

    /**
	 *
	 * @param String emptyTpszCd11
	 */
    public void setEmptyTpszCd11(String emptyTpszCd11) {
        this.emptyTpszCd11 = emptyTpszCd11;
    }

    /**
	 * 
	 * @return String emptyTpszCd11
	 */
    public String getEmptyTpszCd11() {
        return this.emptyTpszCd11;
    }

    /**
	 *
	 * @param String emptyTpszCd12
	 */
    public void setEmptyTpszCd12(String emptyTpszCd12) {
        this.emptyTpszCd12 = emptyTpszCd12;
    }

    /**
	 * 
	 * @return String emptyTpszCd12
	 */
    public String getEmptyTpszCd12() {
        return this.emptyTpszCd12;
    }

    /**
	 *
	 * @param String emptyTpszCd13
	 */
    public void setEmptyTpszCd13(String emptyTpszCd13) {
        this.emptyTpszCd13 = emptyTpszCd13;
    }

    /**
	 * 
	 * @return String emptyTpszCd13
	 */
    public String getEmptyTpszCd13() {
        return this.emptyTpszCd13;
    }

    /**
	 *
	 * @param String emptyTpszCd14
	 */
    public void setEmptyTpszCd14(String emptyTpszCd14) {
        this.emptyTpszCd14 = emptyTpszCd14;
    }

    /**
	 * 
	 * @return String emptyTpszCd14
	 */
    public String getEmptyTpszCd14() {
        return this.emptyTpszCd14;
    }

    /**
	 *
	 * @param String emptyTpszCd15
	 */
    public void setEmptyTpszCd15(String emptyTpszCd15) {
        this.emptyTpszCd15 = emptyTpszCd15;
    }

    /**
	 * 
	 * @return String emptyTpszCd15
	 */
    public String getEmptyTpszCd15() {
        return this.emptyTpszCd15;
    }

    /**
	 *
	 * @param String emptyTpszCd16
	 */
    public void setEmptyTpszCd16(String emptyTpszCd16) {
        this.emptyTpszCd16 = emptyTpszCd16;
    }

    /**
	 * 
	 * @return String emptyTpszCd16
	 */
    public String getEmptyTpszCd16() {
        return this.emptyTpszCd16;
    }

    /**
	 *
	 * @param String emptyTpszCd17
	 */
    public void setEmptyTpszCd17(String emptyTpszCd17) {
        this.emptyTpszCd17 = emptyTpszCd17;
    }

    /**
	 * 
	 * @return String emptyTpszCd17
	 */
    public String getEmptyTpszCd17() {
        return this.emptyTpszCd17;
    }

    /**
	 *
	 * @param String emptyTpszCd18
	 */
    public void setEmptyTpszCd18(String emptyTpszCd18) {
        this.emptyTpszCd18 = emptyTpszCd18;
    }

    /**
	 * 
	 * @return String emptyTpszCd18
	 */
    public String getEmptyTpszCd18() {
        return this.emptyTpszCd18;
    }

    /**
	 *
	 * @param String emptyTpszCd19
	 */
    public void setEmptyTpszCd19(String emptyTpszCd19) {
        this.emptyTpszCd19 = emptyTpszCd19;
    }

    /**
	 * 
	 * @return String emptyTpszCd19
	 */
    public String getEmptyTpszCd19() {
        return this.emptyTpszCd19;
    }

    /**
	 *
	 * @param String emptyTpszCd20
	 */
    public void setEmptyTpszCd20(String emptyTpszCd20) {
        this.emptyTpszCd20 = emptyTpszCd20;
    }

    /**
	 * 
	 * @return String emptyTpszCd20
	 */
    public String getEmptyTpszCd20() {
        return this.emptyTpszCd20;
    }

    /**
	 *
	 * @param String emptyTpszCd21
	 */
    public void setEmptyTpszCd21(String emptyTpszCd21) {
        this.emptyTpszCd21 = emptyTpszCd21;
    }

    /**
	 * 
	 * @return String emptyTpszCd21
	 */
    public String getEmptyTpszCd21() {
        return this.emptyTpszCd21;
    }

    /**
	 *
	 * @param String emptyTpszCd22
	 */
    public void setEmptyTpszCd22(String emptyTpszCd22) {
        this.emptyTpszCd22 = emptyTpszCd22;
    }

    /**
	 * 
	 * @return String emptyTpszCd22
	 */
    public String getEmptyTpszCd22() {
        return this.emptyTpszCd22;
    }

    /**
	 *
	 * @param String emptyTpszCd23
	 */
    public void setEmptyTpszCd23(String emptyTpszCd23) {
        this.emptyTpszCd23 = emptyTpszCd23;
    }

    /**
	 * 
	 * @return String emptyTpszCd23
	 */
    public String getEmptyTpszCd23() {
        return this.emptyTpszCd23;
    }

    /**
	 *
	 * @param String emptyTpszCd24
	 */
    public void setEmptyTpszCd24(String emptyTpszCd24) {
        this.emptyTpszCd24 = emptyTpszCd24;
    }

    /**
	 * 
	 * @return String emptyTpszCd24
	 */
    public String getEmptyTpszCd24() {
        return this.emptyTpszCd24;
    }

    /**
	 *
	 * @param String emptyTpszCd25
	 */
    public void setEmptyTpszCd25(String emptyTpszCd25) {
        this.emptyTpszCd25 = emptyTpszCd25;
    }

    /**
	 * 
	 * @return String emptyTpszCd25
	 */
    public String getEmptyTpszCd25() {
        return this.emptyTpszCd25;
    }

    /**
	 *
	 * @param String emptyTpszCd26
	 */
    public void setEmptyTpszCd26(String emptyTpszCd26) {
        this.emptyTpszCd26 = emptyTpszCd26;
    }

    /**
	 * 
	 * @return String emptyTpszCd26
	 */
    public String getEmptyTpszCd26() {
        return this.emptyTpszCd26;
    }

    /**
	 *
	 * @param String emptyTpszCd27
	 */
    public void setEmptyTpszCd27(String emptyTpszCd27) {
        this.emptyTpszCd27 = emptyTpszCd27;
    }

    /**
	 * 
	 * @return String emptyTpszCd27
	 */
    public String getEmptyTpszCd27() {
        return this.emptyTpszCd27;
    }

    /**
	 *
	 * @param String emptyTpszCd28
	 */
    public void setEmptyTpszCd28(String emptyTpszCd28) {
        this.emptyTpszCd28 = emptyTpszCd28;
    }

    /**
	 * 
	 * @return String emptyTpszCd28
	 */
    public String getEmptyTpszCd28() {
        return this.emptyTpszCd28;
    }

    /**
	 *
	 * @param String emptyTpszCd29
	 */
    public void setEmptyTpszCd29(String emptyTpszCd29) {
        this.emptyTpszCd29 = emptyTpszCd29;
    }

    /**
	 * 
	 * @return String emptyTpszCd29
	 */
    public String getEmptyTpszCd29() {
        return this.emptyTpszCd29;
    }

    /**
	 *
	 * @param String emptyTpszCd30
	 */
    public void setEmptyTpszCd30(String emptyTpszCd30) {
        this.emptyTpszCd30 = emptyTpszCd30;
    }

    /**
	 * 
	 * @return String emptyTpszCd30
	 */
    public String getEmptyTpszCd30() {
        return this.emptyTpszCd30;
    }

    public void setVslSlanCd(String vslSlanCd) {
        this.vslSlanCd = vslSlanCd;
    }

    public String getVslSlanCd() {
        return this.vslSlanCd;
    }

    public void setVslSlanNm(String vslSlanNm) {
        this.vslSlanNm = vslSlanNm;
    }

    public String getVslSlanNm() {
        return this.vslSlanNm;
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
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setVoyNo(JSPUtil.getParameter(request, prefix + "voy_no", ""));
        setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
        setExcelFlg(JSPUtil.getParameter(request, prefix + "excel_flg", ""));
        setPreVslCd(JSPUtil.getParameter(request, prefix + "pre_vsl_cd", ""));
        setPreVoyNo(JSPUtil.getParameter(request, prefix + "pre_voy_no", ""));
        setPreDirCd(JSPUtil.getParameter(request, prefix + "pre_dir_cd", ""));
        setLstPort(JSPUtil.getParameter(request, prefix + "lst_port", ""));
        setSearchType(JSPUtil.getParameter(request, prefix + "search_type", ""));
        setLstClptIndSeq(JSPUtil.getParameter(request, prefix + "lst_clpt_ind_seq", ""));
        setTpszDatas(JSPUtil.getParameter(request, prefix + "tpsz_datas", ""));
        setLadenTpszDatas(JSPUtil.getParameter(request, prefix + "laden_tpsz_datas", ""));
        setEmptyTpszDatas(JSPUtil.getParameter(request, prefix + "empty_tpsz_datas", ""));
        setLadenTpszCd1(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd1", ""));
        setLadenTpszCd2(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd2", ""));
        setLadenTpszCd3(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd3", ""));
        setLadenTpszCd4(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd4", ""));
        setLadenTpszCd5(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd5", ""));
        setLadenTpszCd6(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd6", ""));
        setLadenTpszCd7(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd7", ""));
        setLadenTpszCd8(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd8", ""));
        setLadenTpszCd9(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd9", ""));
        setLadenTpszCd10(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd10", ""));
        setLadenTpszCd11(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd11", ""));
        setLadenTpszCd12(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd12", ""));
        setLadenTpszCd13(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd13", ""));
        setLadenTpszCd14(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd14", ""));
        setLadenTpszCd15(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd15", ""));
        setLadenTpszCd16(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd16", ""));
        setLadenTpszCd17(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd17", ""));
        setLadenTpszCd18(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd18", ""));
        setLadenTpszCd19(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd19", ""));
        setLadenTpszCd20(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd20", ""));
        setLadenTpszCd21(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd21", ""));
        setLadenTpszCd22(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd22", ""));
        setLadenTpszCd23(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd23", ""));
        setLadenTpszCd24(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd24", ""));
        setLadenTpszCd25(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd25", ""));
        setLadenTpszCd26(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd26", ""));
        setLadenTpszCd27(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd27", ""));
        setLadenTpszCd28(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd28", ""));
        setLadenTpszCd29(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd29", ""));
        setLadenTpszCd30(JSPUtil.getParameter(request, prefix + "laden_tpsz_cd30", ""));
        setEmptyTpszCd1(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd1", ""));
        setEmptyTpszCd2(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd2", ""));
        setEmptyTpszCd3(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd3", ""));
        setEmptyTpszCd4(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd4", ""));
        setEmptyTpszCd5(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd5", ""));
        setEmptyTpszCd6(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd6", ""));
        setEmptyTpszCd7(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd7", ""));
        setEmptyTpszCd8(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd8", ""));
        setEmptyTpszCd9(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd9", ""));
        setEmptyTpszCd10(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd10", ""));
        setEmptyTpszCd11(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd11", ""));
        setEmptyTpszCd12(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd12", ""));
        setEmptyTpszCd13(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd13", ""));
        setEmptyTpszCd14(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd14", ""));
        setEmptyTpszCd15(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd15", ""));
        setEmptyTpszCd16(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd16", ""));
        setEmptyTpszCd17(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd17", ""));
        setEmptyTpszCd18(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd18", ""));
        setEmptyTpszCd19(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd19", ""));
        setEmptyTpszCd20(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd20", ""));
        setEmptyTpszCd21(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd21", ""));
        setEmptyTpszCd22(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd22", ""));
        setEmptyTpszCd23(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd23", ""));
        setEmptyTpszCd24(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd24", ""));
        setEmptyTpszCd25(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd25", ""));
        setEmptyTpszCd26(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd26", ""));
        setEmptyTpszCd27(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd27", ""));
        setEmptyTpszCd28(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd28", ""));
        setEmptyTpszCd29(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd29", ""));
        setEmptyTpszCd30(JSPUtil.getParameter(request, prefix + "empty_tpsz_cd30", ""));
        setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
        setVslSlanNm(JSPUtil.getParameter(request, prefix + "vsl_slan_nm", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrConditionVO2[]
	 */
    public CntrConditionVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrConditionVO2[]
	 */
    public CntrConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CntrConditionVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] voyNo = (JSPUtil.getParameter(request, prefix + "voy_no", length));
            String[] dirCd = (JSPUtil.getParameter(request, prefix + "dir_cd", length));
            String[] excelFlg = (JSPUtil.getParameter(request, prefix + "excel_flg", length));
            String[] preVslCd = (JSPUtil.getParameter(request, prefix + "pre_vsl_cd", length));
            String[] preVoyNo = (JSPUtil.getParameter(request, prefix + "pre_voy_no", length));
            String[] preDirCd = (JSPUtil.getParameter(request, prefix + "pre_dir_cd", length));
            String[] lstPort = (JSPUtil.getParameter(request, prefix + "lst_port", length));
            String[] searchType = (JSPUtil.getParameter(request, prefix + "search_type", length));
            String[] lstClptIndSeq = (JSPUtil.getParameter(request, prefix + "lst_clpt_ind_seq", length));
            String[] tpszDatas = (JSPUtil.getParameter(request, prefix + "tpsz_datas", length));
            String[] ladenTpszDatas = (JSPUtil.getParameter(request, prefix + "laden_tpsz_datas", length));
            String[] emptyTpszDatas = (JSPUtil.getParameter(request, prefix + "empty_tpsz_datas", length));
            String[] ladenTpszCd1 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd1", length));
            String[] ladenTpszCd2 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd2", length));
            String[] ladenTpszCd3 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd3", length));
            String[] ladenTpszCd4 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd4", length));
            String[] ladenTpszCd5 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd5", length));
            String[] ladenTpszCd6 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd6", length));
            String[] ladenTpszCd7 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd7", length));
            String[] ladenTpszCd8 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd8", length));
            String[] ladenTpszCd9 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd9", length));
            String[] ladenTpszCd10 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd10", length));
            String[] ladenTpszCd11 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd11", length));
            String[] ladenTpszCd12 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd12", length));
            String[] ladenTpszCd13 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd13", length));
            String[] ladenTpszCd14 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd14", length));
            String[] ladenTpszCd15 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd15", length));
            String[] ladenTpszCd16 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd16", length));
            String[] ladenTpszCd17 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd17", length));
            String[] ladenTpszCd18 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd18", length));
            String[] ladenTpszCd19 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd19", length));
            String[] ladenTpszCd20 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd20", length));
            String[] ladenTpszCd21 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd21", length));
            String[] ladenTpszCd22 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd22", length));
            String[] ladenTpszCd23 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd23", length));
            String[] ladenTpszCd24 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd24", length));
            String[] ladenTpszCd25 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd25", length));
            String[] ladenTpszCd26 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd26", length));
            String[] ladenTpszCd27 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd27", length));
            String[] ladenTpszCd28 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd28", length));
            String[] ladenTpszCd29 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd29", length));
            String[] ladenTpszCd30 = (JSPUtil.getParameter(request, prefix + "laden_tpsz_cd30", length));
            String[] emptyTpszCd1 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd1", length));
            String[] emptyTpszCd2 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd2", length));
            String[] emptyTpszCd3 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd3", length));
            String[] emptyTpszCd4 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd4", length));
            String[] emptyTpszCd5 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd5", length));
            String[] emptyTpszCd6 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd6", length));
            String[] emptyTpszCd7 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd7", length));
            String[] emptyTpszCd8 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd8", length));
            String[] emptyTpszCd9 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd9", length));
            String[] emptyTpszCd10 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd10", length));
            String[] emptyTpszCd11 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd11", length));
            String[] emptyTpszCd12 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd12", length));
            String[] emptyTpszCd13 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd13", length));
            String[] emptyTpszCd14 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd14", length));
            String[] emptyTpszCd15 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd15", length));
            String[] emptyTpszCd16 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd16", length));
            String[] emptyTpszCd17 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd17", length));
            String[] emptyTpszCd18 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd18", length));
            String[] emptyTpszCd19 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd19", length));
            String[] emptyTpszCd20 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd20", length));
            String[] emptyTpszCd21 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd21", length));
            String[] emptyTpszCd22 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd22", length));
            String[] emptyTpszCd23 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd23", length));
            String[] emptyTpszCd24 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd24", length));
            String[] emptyTpszCd25 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd25", length));
            String[] emptyTpszCd26 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd26", length));
            String[] emptyTpszCd27 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd27", length));
            String[] emptyTpszCd28 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd28", length));
            String[] emptyTpszCd29 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd29", length));
            String[] emptyTpszCd30 = (JSPUtil.getParameter(request, prefix + "empty_tpsz_cd30", length));
            String[] vslSlanCd = (JSPUtil.getParameter(request, prefix + "vsl_slan_cd", length));
	    	String[] vslSlanNm = (JSPUtil.getParameter(request, prefix + "vsl_slan_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CntrConditionVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (voyNo[i] != null)
                    model.setVoyNo(voyNo[i]);
                if (dirCd[i] != null)
                    model.setDirCd(dirCd[i]);
                if (excelFlg[i] != null)
                    model.setExcelFlg(excelFlg[i]);
                if (preVslCd[i] != null)
                    model.setPreVslCd(preVslCd[i]);
                if (preVoyNo[i] != null)
                    model.setPreVoyNo(preVoyNo[i]);
                if (preDirCd[i] != null)
                    model.setPreDirCd(preDirCd[i]);
                if (lstPort[i] != null)
                    model.setLstPort(lstPort[i]);
                if (searchType[i] != null)
                    model.setSearchType(searchType[i]);
                if (lstClptIndSeq[i] != null)
                    model.setLstClptIndSeq(lstClptIndSeq[i]);
                if (tpszDatas[i] != null)
                    model.setTpszDatas(tpszDatas[i]);
                if (ladenTpszDatas[i] != null)
                    model.setLadenTpszDatas(ladenTpszDatas[i]);
                if (emptyTpszDatas[i] != null)
                    model.setEmptyTpszDatas(emptyTpszDatas[i]);
                if (ladenTpszCd1[i] != null)
                    model.setLadenTpszCd1(ladenTpszCd1[i]);
                if (ladenTpszCd2[i] != null)
                    model.setLadenTpszCd2(ladenTpszCd2[i]);
                if (ladenTpszCd3[i] != null)
                    model.setLadenTpszCd3(ladenTpszCd3[i]);
                if (ladenTpszCd4[i] != null)
                    model.setLadenTpszCd4(ladenTpszCd4[i]);
                if (ladenTpszCd5[i] != null)
                    model.setLadenTpszCd5(ladenTpszCd5[i]);
                if (ladenTpszCd6[i] != null)
                    model.setLadenTpszCd6(ladenTpszCd6[i]);
                if (ladenTpszCd7[i] != null)
                    model.setLadenTpszCd7(ladenTpszCd7[i]);
                if (ladenTpszCd8[i] != null)
                    model.setLadenTpszCd8(ladenTpszCd8[i]);
                if (ladenTpszCd9[i] != null)
                    model.setLadenTpszCd9(ladenTpszCd9[i]);
                if (ladenTpszCd10[i] != null)
                    model.setLadenTpszCd10(ladenTpszCd10[i]);
                if (ladenTpszCd11[i] != null)
                    model.setLadenTpszCd11(ladenTpszCd11[i]);
                if (ladenTpszCd12[i] != null)
                    model.setLadenTpszCd12(ladenTpszCd12[i]);
                if (ladenTpszCd13[i] != null)
                    model.setLadenTpszCd13(ladenTpszCd13[i]);
                if (ladenTpszCd14[i] != null)
                    model.setLadenTpszCd14(ladenTpszCd14[i]);
                if (ladenTpszCd15[i] != null)
                    model.setLadenTpszCd15(ladenTpszCd15[i]);
                if (ladenTpszCd16[i] != null)
                    model.setLadenTpszCd16(ladenTpszCd16[i]);
                if (ladenTpszCd17[i] != null)
                    model.setLadenTpszCd17(ladenTpszCd17[i]);
                if (ladenTpszCd18[i] != null)
                    model.setLadenTpszCd18(ladenTpszCd18[i]);
                if (ladenTpszCd19[i] != null)
                    model.setLadenTpszCd19(ladenTpszCd19[i]);
                if (ladenTpszCd20[i] != null)
                    model.setLadenTpszCd20(ladenTpszCd20[i]);
                if (ladenTpszCd21[i] != null)
                    model.setLadenTpszCd21(ladenTpszCd21[i]);
                if (ladenTpszCd22[i] != null)
                    model.setLadenTpszCd22(ladenTpszCd22[i]);
                if (ladenTpszCd23[i] != null)
                    model.setLadenTpszCd23(ladenTpszCd23[i]);
                if (ladenTpszCd24[i] != null)
                    model.setLadenTpszCd24(ladenTpszCd24[i]);
                if (ladenTpszCd25[i] != null)
                    model.setLadenTpszCd25(ladenTpszCd25[i]);
                if (ladenTpszCd26[i] != null)
                    model.setLadenTpszCd26(ladenTpszCd26[i]);
                if (ladenTpszCd27[i] != null)
                    model.setLadenTpszCd27(ladenTpszCd27[i]);
                if (ladenTpszCd28[i] != null)
                    model.setLadenTpszCd28(ladenTpszCd28[i]);
                if (ladenTpszCd29[i] != null)
                    model.setLadenTpszCd29(ladenTpszCd29[i]);
                if (ladenTpszCd30[i] != null)
                    model.setLadenTpszCd30(ladenTpszCd30[i]);
                if (emptyTpszCd1[i] != null)
                    model.setEmptyTpszCd1(emptyTpszCd1[i]);
                if (emptyTpszCd2[i] != null)
                    model.setEmptyTpszCd2(emptyTpszCd2[i]);
                if (emptyTpszCd3[i] != null)
                    model.setEmptyTpszCd3(emptyTpszCd3[i]);
                if (emptyTpszCd4[i] != null)
                    model.setEmptyTpszCd4(emptyTpszCd4[i]);
                if (emptyTpszCd5[i] != null)
                    model.setEmptyTpszCd5(emptyTpszCd5[i]);
                if (emptyTpszCd6[i] != null)
                    model.setEmptyTpszCd6(emptyTpszCd6[i]);
                if (emptyTpszCd7[i] != null)
                    model.setEmptyTpszCd7(emptyTpszCd7[i]);
                if (emptyTpszCd8[i] != null)
                    model.setEmptyTpszCd8(emptyTpszCd8[i]);
                if (emptyTpszCd9[i] != null)
                    model.setEmptyTpszCd9(emptyTpszCd9[i]);
                if (emptyTpszCd10[i] != null)
                    model.setEmptyTpszCd10(emptyTpszCd10[i]);
                if (emptyTpszCd11[i] != null)
                    model.setEmptyTpszCd11(emptyTpszCd11[i]);
                if (emptyTpszCd12[i] != null)
                    model.setEmptyTpszCd12(emptyTpszCd12[i]);
                if (emptyTpszCd13[i] != null)
                    model.setEmptyTpszCd13(emptyTpszCd13[i]);
                if (emptyTpszCd14[i] != null)
                    model.setEmptyTpszCd14(emptyTpszCd14[i]);
                if (emptyTpszCd15[i] != null)
                    model.setEmptyTpszCd15(emptyTpszCd15[i]);
                if (emptyTpszCd16[i] != null)
                    model.setEmptyTpszCd16(emptyTpszCd16[i]);
                if (emptyTpszCd17[i] != null)
                    model.setEmptyTpszCd17(emptyTpszCd17[i]);
                if (emptyTpszCd18[i] != null)
                    model.setEmptyTpszCd18(emptyTpszCd18[i]);
                if (emptyTpszCd19[i] != null)
                    model.setEmptyTpszCd19(emptyTpszCd19[i]);
                if (emptyTpszCd20[i] != null)
                    model.setEmptyTpszCd20(emptyTpszCd20[i]);
                if (emptyTpszCd21[i] != null)
                    model.setEmptyTpszCd21(emptyTpszCd21[i]);
                if (emptyTpszCd22[i] != null)
                    model.setEmptyTpszCd22(emptyTpszCd22[i]);
                if (emptyTpszCd23[i] != null)
                    model.setEmptyTpszCd23(emptyTpszCd23[i]);
                if (emptyTpszCd24[i] != null)
                    model.setEmptyTpszCd24(emptyTpszCd24[i]);
                if (emptyTpszCd25[i] != null)
                    model.setEmptyTpszCd25(emptyTpszCd25[i]);
                if (emptyTpszCd26[i] != null)
                    model.setEmptyTpszCd26(emptyTpszCd26[i]);
                if (emptyTpszCd27[i] != null)
                    model.setEmptyTpszCd27(emptyTpszCd27[i]);
                if (emptyTpszCd28[i] != null)
                    model.setEmptyTpszCd28(emptyTpszCd28[i]);
                if (emptyTpszCd29[i] != null)
                    model.setEmptyTpszCd29(emptyTpszCd29[i]);
                if (emptyTpszCd30[i] != null)
                    model.setEmptyTpszCd30(emptyTpszCd30[i]);
                if (vslSlanCd[i] != null) 
		    		model.setVslSlanCd(vslSlanCd[i]);
				if (vslSlanNm[i] != null) 
		    		model.setVslSlanNm(vslSlanNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCntrConditionVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CntrConditionVO2[]
	 */
    public CntrConditionVO[] getCntrConditionVOs() {
        CntrConditionVO[] vos = (CntrConditionVO[]) models.toArray(new CntrConditionVO[models.size()]);
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
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.voyNo = this.voyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dirCd = this.dirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.excelFlg = this.excelFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preVslCd = this.preVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preVoyNo = this.preVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preDirCd = this.preDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lstPort = this.lstPort.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.searchType = this.searchType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lstClptIndSeq = this.lstClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tpszDatas = this.tpszDatas.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszDatas = this.ladenTpszDatas.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszDatas = this.emptyTpszDatas.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd1 = this.ladenTpszCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd2 = this.ladenTpszCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd3 = this.ladenTpszCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd4 = this.ladenTpszCd4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd5 = this.ladenTpszCd5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd6 = this.ladenTpszCd6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd7 = this.ladenTpszCd7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd8 = this.ladenTpszCd8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd9 = this.ladenTpszCd9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd10 = this.ladenTpszCd10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd11 = this.ladenTpszCd11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd12 = this.ladenTpszCd12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd13 = this.ladenTpszCd13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd14 = this.ladenTpszCd14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd15 = this.ladenTpszCd15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd16 = this.ladenTpszCd16.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd17 = this.ladenTpszCd17.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd18 = this.ladenTpszCd18.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd19 = this.ladenTpszCd19.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd20 = this.ladenTpszCd20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd21 = this.ladenTpszCd21.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd22 = this.ladenTpszCd22.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd23 = this.ladenTpszCd23.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd24 = this.ladenTpszCd24.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd25 = this.ladenTpszCd25.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd26 = this.ladenTpszCd26.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd27 = this.ladenTpszCd27.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd28 = this.ladenTpszCd28.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd29 = this.ladenTpszCd29.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ladenTpszCd30 = this.ladenTpszCd30.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd1 = this.emptyTpszCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd2 = this.emptyTpszCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd3 = this.emptyTpszCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd4 = this.emptyTpszCd4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd5 = this.emptyTpszCd5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd6 = this.emptyTpszCd6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd7 = this.emptyTpszCd7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd8 = this.emptyTpszCd8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd9 = this.emptyTpszCd9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd10 = this.emptyTpszCd10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd11 = this.emptyTpszCd11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd12 = this.emptyTpszCd12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd13 = this.emptyTpszCd13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd14 = this.emptyTpszCd14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd15 = this.emptyTpszCd15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd16 = this.emptyTpszCd16.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd17 = this.emptyTpszCd17.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd18 = this.emptyTpszCd18.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd19 = this.emptyTpszCd19.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd20 = this.emptyTpszCd20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd21 = this.emptyTpszCd21.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd22 = this.emptyTpszCd22.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd23 = this.emptyTpszCd23.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd24 = this.emptyTpszCd24.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd25 = this.emptyTpszCd25.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd26 = this.emptyTpszCd26.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd27 = this.emptyTpszCd27.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd28 = this.emptyTpszCd28.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd29 = this.emptyTpszCd29.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emptyTpszCd30 = this.emptyTpszCd30.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSlanCd = this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSlanNm = this.vslSlanNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
