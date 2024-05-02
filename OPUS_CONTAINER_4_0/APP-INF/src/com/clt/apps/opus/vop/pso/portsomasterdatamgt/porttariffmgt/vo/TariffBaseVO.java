/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffBaseVO.java
*@FileTitle : TariffBaseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.09.29 정명훈 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정명훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class TariffBaseVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<TariffBaseVO> models = new ArrayList<TariffBaseVO>();

    /* Column Info */
    private String chgXprSeq = null;

    /* Column Info */
    private String objectCode = null;

    /* Column Info */
    private String rateValue = null;

    /* Column Info */
    private String fomlDesc = null;

    /* Column Info */
    private String methodCode = null;

    /* Column Info */
    private String object = null;

    /* Column Info */
    private String sumOption = null;

    /* Column Info */
    private String objectDsp = null;

    /* Column Info */
    private String rateCode = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String currency = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String portTrfNo = null;

    /* Column Info */
    private String invUse = null;

    /* Column Info */
    private String uom = null;

    /* Column Info */
    private String default2 = null;

    /* Column Info */
    private String fomlSysDesc = null;

    /* Column Info */
    private String ydChgVerSeq = null;

    /* Column Info */
    private String regularValue = null;

    /* Column Info */
    private String psoTrfTpCd = null;

    /* Column Info */
    private String chgXprNo = null;

    /* Column Info */
    private String ydChgNo = null;

    /* Column Info */
    private String uomDsp = null;

    /* Column Info */
    private String psoChgTpCd = null;

    /* Column Info */
    private String formulaNo = null;

    /* Column Info */
    private String idx = null;

    /* Column Info */
    private String condition = null;

    /* Column Info */
    private String objectName = null;

    /* Column Info */
    private String ydChgXprNo = null;

    /* Column Info */
    private String objectCodeDsp = null;

    /* Column Info */
    private String rangeFrom = null;

    /* Column Info */
    private String rangeTo = null;

    /* Column Info */
    private String seq = null;

    /* Column Info */
    private String objListNo = null;

    /* Column Info */
    private String seq2 = null;

    /* Column Info */
    private String trfSeq = null;

    /* Column Info */
    private String condDesc = null;

    /* Column Info */
    private String uk = null;

    /* Column Info */
    private String bm = null;

    /* Column Info */
    private String bmCondition = null;

    /* Column Info */
    private String bmCondDesc = null;

    /* Column Info */
    private String cplsFlg = null;

    /* Column Info */
    private String updMnuNoCond = null;

    /* Column Info */
    private String consAlsNm = null;

    /* Column Info */
    private String updMnuNoCondText = null;

    /* Column Info */
    private String condAlsNm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public TariffBaseVO() {
    }

    public TariffBaseVO(String ibflag, String pagerows, String object, String objectDsp, String objectCode, String objectCodeDsp, String uom, String uomDsp, String chgXprSeq, String fomlDesc, String rateValue, String methodCode, String rateCode, String currency, String portTrfNo, String invUse, String default2, String fomlSysDesc, String ydChgVerSeq, String regularValue, String psoTrfTpCd, String chgXprNo, String ydChgNo, String psoChgTpCd, String formulaNo, String idx, String objectName, String condition, String ydChgXprNo, String rangeFrom, String rangeTo, String seq, String objListNo, String seq2, String condDesc, String trfSeq, String sumOption, String uk, String bm, String bmCondition, String bmCondDesc, String cplsFlg, String updMnuNoCond, String consAlsNm, String updMnuNoCondText, String condAlsNm) {
        this.chgXprSeq = chgXprSeq;
        this.objectCode = objectCode;
        this.rateValue = rateValue;
        this.fomlDesc = fomlDesc;
        this.methodCode = methodCode;
        this.object = object;
        this.sumOption = sumOption;
        this.objectDsp = objectDsp;
        this.rateCode = rateCode;
        this.pagerows = pagerows;
        this.currency = currency;
        this.ibflag = ibflag;
        this.portTrfNo = portTrfNo;
        this.invUse = invUse;
        this.uom = uom;
        this.default2 = default2;
        this.fomlSysDesc = fomlSysDesc;
        this.ydChgVerSeq = ydChgVerSeq;
        this.regularValue = regularValue;
        this.psoTrfTpCd = psoTrfTpCd;
        this.chgXprNo = chgXprNo;
        this.ydChgNo = ydChgNo;
        this.uomDsp = uomDsp;
        this.psoChgTpCd = psoChgTpCd;
        this.formulaNo = formulaNo;
        this.idx = idx;
        this.condition = condition;
        this.objectName = objectName;
        this.ydChgXprNo = ydChgXprNo;
        this.objectCodeDsp = objectCodeDsp;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.seq = seq;
        this.objListNo = objListNo;
        this.seq2 = seq2;
        this.trfSeq = trfSeq;
        this.condDesc = condDesc;
        this.uk = uk;
        this.bm = bm;
        this.bmCondition = bmCondition;
        this.bmCondDesc = bmCondDesc;
        this.cplsFlg = cplsFlg;
        this.updMnuNoCond = updMnuNoCond;
        this.consAlsNm = consAlsNm;
        this.updMnuNoCondText = updMnuNoCondText;
        this.condAlsNm = condAlsNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("chg_xpr_seq", getChgXprSeq());
        this.hashColumns.put("object_code", getObjectCode());
        this.hashColumns.put("rate_value", getRateValue());
        this.hashColumns.put("foml_desc", getFomlDesc());
        this.hashColumns.put("method_code", getMethodCode());
        this.hashColumns.put("object", getObject());
        this.hashColumns.put("sum_option", getSumOption());
        this.hashColumns.put("object_dsp", getObjectDsp());
        this.hashColumns.put("rate_code", getRateCode());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("currency", getCurrency());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("port_trf_no", getPortTrfNo());
        this.hashColumns.put("inv_use", getInvUse());
        this.hashColumns.put("uom", getUom());
        this.hashColumns.put("default2", getDefault2());
        this.hashColumns.put("foml_sys_desc", getFomlSysDesc());
        this.hashColumns.put("yd_chg_ver_seq", getYdChgVerSeq());
        this.hashColumns.put("regular_value", getRegularValue());
        this.hashColumns.put("pso_trf_tp_cd", getPsoTrfTpCd());
        this.hashColumns.put("chg_xpr_no", getChgXprNo());
        this.hashColumns.put("yd_chg_no", getYdChgNo());
        this.hashColumns.put("uom_dsp", getUomDsp());
        this.hashColumns.put("pso_chg_tp_cd", getPsoChgTpCd());
        this.hashColumns.put("formula_no", getFormulaNo());
        this.hashColumns.put("idx", getIdx());
        this.hashColumns.put("condition", getCondition());
        this.hashColumns.put("object_name", getObjectName());
        this.hashColumns.put("yd_chg_xpr_no", getYdChgXprNo());
        this.hashColumns.put("object_code_dsp", getObjectCodeDsp());
        this.hashColumns.put("range_from", getRangeFrom());
        this.hashColumns.put("range_to", getRangeTo());
        this.hashColumns.put("seq", getSeq());
        this.hashColumns.put("obj_list_no", getObjListNo());
        this.hashColumns.put("seq2", getSeq2());
        this.hashColumns.put("trf_seq", getTrfSeq());
        this.hashColumns.put("cond_desc", getCondDesc());
        this.hashColumns.put("uk", getUk());
        this.hashColumns.put("bm", getBm());
        this.hashColumns.put("bm_condition", getBmCondition());
        this.hashColumns.put("bm_cond_desc", getBmCondDesc());
        this.hashColumns.put("cpls_flg", getCplsFlg());
        this.hashColumns.put("upd_mnu_no_cond", getUpdMnuNoCond());
        this.hashColumns.put("cons_als_nm", getConsAlsNm());
        this.hashColumns.put("upd_mnu_no_cond_text", getUpdMnuNoCondText());
        this.hashColumns.put("cond_als_nm", getCondAlsNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("chg_xpr_seq", "chgXprSeq");
        this.hashFields.put("object_code", "objectCode");
        this.hashFields.put("rate_value", "rateValue");
        this.hashFields.put("foml_desc", "fomlDesc");
        this.hashFields.put("method_code", "methodCode");
        this.hashFields.put("object", "object");
        this.hashFields.put("sum_option", "sumOption");
        this.hashFields.put("object_dsp", "objectDsp");
        this.hashFields.put("rate_code", "rateCode");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("currency", "currency");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("port_trf_no", "portTrfNo");
        this.hashFields.put("inv_use", "invUse");
        this.hashFields.put("uom", "uom");
        this.hashFields.put("default2", "default2");
        this.hashFields.put("foml_sys_desc", "fomlSysDesc");
        this.hashFields.put("yd_chg_ver_seq", "ydChgVerSeq");
        this.hashFields.put("regular_value", "regularValue");
        this.hashFields.put("pso_trf_tp_cd", "psoTrfTpCd");
        this.hashFields.put("chg_xpr_no", "chgXprNo");
        this.hashFields.put("yd_chg_no", "ydChgNo");
        this.hashFields.put("uom_dsp", "uomDsp");
        this.hashFields.put("pso_chg_tp_cd", "psoChgTpCd");
        this.hashFields.put("formula_no", "formulaNo");
        this.hashFields.put("idx", "idx");
        this.hashFields.put("condition", "condition");
        this.hashFields.put("object_name", "objectName");
        this.hashFields.put("yd_chg_xpr_no", "ydChgXprNo");
        this.hashFields.put("object_code_dsp", "objectCodeDsp");
        this.hashFields.put("range_from", "rangeFrom");
        this.hashFields.put("range_to", "rangeTo");
        this.hashFields.put("seq", "seq");
        this.hashFields.put("obj_list_no", "objListNo");
        this.hashFields.put("seq2", "seq2");
        this.hashFields.put("trf_seq", "trfSeq");
        this.hashFields.put("cond_desc", "condDesc");
        this.hashFields.put("uk", "uk");
        this.hashFields.put("bm", "bm");
        this.hashFields.put("bm_condition", "bmCondition");
        this.hashFields.put("bm_cond_desc", "bmCondDesc");
        this.hashFields.put("cpls_flg", "cplsFlg");
        this.hashFields.put("upd_mnu_no_cond", "updMnuNoCond");
        this.hashFields.put("cons_als_nm", "consAlsNm");
        this.hashFields.put("upd_mnu_no_cond_text", "updMnuNoCondText");
        this.hashFields.put("cond_als_nm", "condAlsNm");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return chgXprSeq
	 */
    public String getChgXprSeq() {
        return this.chgXprSeq;
    }

    /**
	 * Column Info
	 * @return objectCode
	 */
    public String getObjectCode() {
        return this.objectCode;
    }

    /**
	 * Column Info
	 * @return rateValue
	 */
    public String getRateValue() {
        return this.rateValue;
    }

    /**
	 * Column Info
	 * @return fomlDesc
	 */
    public String getFomlDesc() {
        return this.fomlDesc;
    }

    /**
	 * Column Info
	 * @return methodCode
	 */
    public String getMethodCode() {
        return this.methodCode;
    }

    /**
	 * Column Info
	 * @return object
	 */
    public String getObject() {
        return this.object;
    }

    /**
	 * Column Info
	 * @return sumOption
	 */
    public String getSumOption() {
        return this.sumOption;
    }

    /**
	 * Column Info
	 * @return objectDsp
	 */
    public String getObjectDsp() {
        return this.objectDsp;
    }

    /**
	 * Column Info
	 * @return rateCode
	 */
    public String getRateCode() {
        return this.rateCode;
    }

    /**
	 * Page Number
	 * @return pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 * Column Info
	 * @return currency
	 */
    public String getCurrency() {
        return this.currency;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 * Column Info
	 * @return portTrfNo
	 */
    public String getPortTrfNo() {
        return this.portTrfNo;
    }

    /**
	 * Column Info
	 * @return invUse
	 */
    public String getInvUse() {
        return this.invUse;
    }

    /**
	 * Column Info
	 * @return uom
	 */
    public String getUom() {
        return this.uom;
    }

    /**
	 * Column Info
	 * @return default2
	 */
    public String getDefault2() {
        return this.default2;
    }

    /**
	 * Column Info
	 * @return fomlSysDesc
	 */
    public String getFomlSysDesc() {
        return this.fomlSysDesc;
    }

    /**
	 * Column Info
	 * @return ydChgVerSeq
	 */
    public String getYdChgVerSeq() {
        return this.ydChgVerSeq;
    }

    /**
	 * Column Info
	 * @return regularValue
	 */
    public String getRegularValue() {
        return this.regularValue;
    }

    /**
	 * Column Info
	 * @return psoTrfTpCd
	 */
    public String getPsoTrfTpCd() {
        return this.psoTrfTpCd;
    }

    /**
	 * Column Info
	 * @return chgXprNo
	 */
    public String getChgXprNo() {
        return this.chgXprNo;
    }

    /**
	 * Column Info
	 * @return ydChgNo
	 */
    public String getYdChgNo() {
        return this.ydChgNo;
    }

    /**
	 * Column Info
	 * @return uomDsp
	 */
    public String getUomDsp() {
        return this.uomDsp;
    }

    /**
	 * Column Info
	 * @return psoChgTpCd
	 */
    public String getPsoChgTpCd() {
        return this.psoChgTpCd;
    }

    /**
	 * Column Info
	 * @return formulaNo
	 */
    public String getFormulaNo() {
        return this.formulaNo;
    }

    /**
	 * Column Info
	 * @return idx
	 */
    public String getIdx() {
        return this.idx;
    }

    /**
	 * Column Info
	 * @return condition
	 */
    public String getCondition() {
        return this.condition;
    }

    /**
	 * Column Info
	 * @return objectName
	 */
    public String getObjectName() {
        return this.objectName;
    }

    /**
	 * Column Info
	 * @return ydChgXprNo
	 */
    public String getYdChgXprNo() {
        return this.ydChgXprNo;
    }

    /**
	 * Column Info
	 * @return objectCodeDsp
	 */
    public String getObjectCodeDsp() {
        return this.objectCodeDsp;
    }

    /**
	 * Column Info
	 * @return rangeFrom
	 */
    public String getRangeFrom() {
        return this.rangeFrom;
    }

    /**
	 * Column Info
	 * @return rangeTo
	 */
    public String getRangeTo() {
        return this.rangeTo;
    }

    /**
	 * Column Info
	 * @return seq
	 */
    public String getSeq() {
        return this.seq;
    }

    /**
	 * Column Info
	 * @return objListNo
	 */
    public String getObjListNo() {
        return this.objListNo;
    }

    /**
	 * Column Info
	 * @return seq2
	 */
    public String getSeq2() {
        return this.seq2;
    }

    /**
	 * Column Info
	 * @return trfSeq
	 */
    public String getTrfSeq() {
        return this.trfSeq;
    }

    /**
	 * Column Info
	 * @return condDesc
	 */
    public String getCondDesc() {
        return this.condDesc;
    }

    /**
	 * Column Info
	 * @param chgXprSeq
	 */
    public void setChgXprSeq(String chgXprSeq) {
        this.chgXprSeq = chgXprSeq;
    }

    /**
	 * Column Info
	 * @param objectCode
	 */
    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode;
    }

    /**
	 * Column Info
	 * @param rateValue
	 */
    public void setRateValue(String rateValue) {
        this.rateValue = rateValue;
    }

    /**
	 * Column Info
	 * @param fomlDesc
	 */
    public void setFomlDesc(String fomlDesc) {
        this.fomlDesc = fomlDesc;
    }

    /**
	 * Column Info
	 * @param methodCode
	 */
    public void setMethodCode(String methodCode) {
        this.methodCode = methodCode;
    }

    /**
	 * Column Info
	 * @param object
	 */
    public void setObject(String object) {
        this.object = object;
    }

    /**
	 * Column Info
	 * @param sumOption
	 */
    public void setSumOption(String sumOption) {
        this.sumOption = sumOption;
    }

    /**
	 * Column Info
	 * @param objectDsp
	 */
    public void setObjectDsp(String objectDsp) {
        this.objectDsp = objectDsp;
    }

    /**
	 * Column Info
	 * @param rateCode
	 */
    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @param currency
	 */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * @param portTrfNo
	 */
    public void setPortTrfNo(String portTrfNo) {
        this.portTrfNo = portTrfNo;
    }

    /**
	 * Column Info
	 * @param invUse
	 */
    public void setInvUse(String invUse) {
        this.invUse = invUse;
    }

    /**
	 * Column Info
	 * @param uom
	 */
    public void setUom(String uom) {
        this.uom = uom;
    }

    /**
	 * Column Info
	 * @param default2
	 */
    public void setDefault2(String default2) {
        this.default2 = default2;
    }

    /**
	 * Column Info
	 * @param fomlSysDesc
	 */
    public void setFomlSysDesc(String fomlSysDesc) {
        this.fomlSysDesc = fomlSysDesc;
    }

    /**
	 * Column Info
	 * @param ydChgVerSeq
	 */
    public void setYdChgVerSeq(String ydChgVerSeq) {
        this.ydChgVerSeq = ydChgVerSeq;
    }

    /**
	 * Column Info
	 * @param regularValue
	 */
    public void setRegularValue(String regularValue) {
        this.regularValue = regularValue;
    }

    /**
	 * Column Info
	 * @param psoTrfTpCd
	 */
    public void setPsoTrfTpCd(String psoTrfTpCd) {
        this.psoTrfTpCd = psoTrfTpCd;
    }

    /**
	 * Column Info
	 * @param chgXprNo
	 */
    public void setChgXprNo(String chgXprNo) {
        this.chgXprNo = chgXprNo;
    }

    /**
	 * Column Info
	 * @param ydChgNo
	 */
    public void setYdChgNo(String ydChgNo) {
        this.ydChgNo = ydChgNo;
    }

    /**
	 * Column Info
	 * @param uomDsp
	 */
    public void setUomDsp(String uomDsp) {
        this.uomDsp = uomDsp;
    }

    /**
	 * Column Info
	 * @param psoChgTpCd
	 */
    public void setPsoChgTpCd(String psoChgTpCd) {
        this.psoChgTpCd = psoChgTpCd;
    }

    /**
	 * Column Info
	 * @param formulaNo
	 */
    public void setFormulaNo(String formulaNo) {
        this.formulaNo = formulaNo;
    }

    /**
	 * Column Info
	 * @param idx
	 */
    public void setIdx(String idx) {
        this.idx = idx;
    }

    /**
	 * Column Info
	 * @param condition
	 */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
	 * Column Info
	 * @param objectName
	 */
    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    /**
	 * Column Info
	 * @param ydChgXprNo
	 */
    public void setYdChgXprNo(String ydChgXprNo) {
        this.ydChgXprNo = ydChgXprNo;
    }

    /**
	 * Column Info
	 * @param objectCodeDsp
	 */
    public void setObjectCodeDsp(String objectCodeDsp) {
        this.objectCodeDsp = objectCodeDsp;
    }

    /**
	 * Column Info
	 * @param rangeFrom
	 */
    public void setRangeFrom(String rangeFrom) {
        this.rangeFrom = rangeFrom;
    }

    /**
	 * Column Info
	 * @param rangeTo
	 */
    public void setRangeTo(String rangeTo) {
        this.rangeTo = rangeTo;
    }

    /**
	 * Column Info
	 * @param seq
	 */
    public void setSeq(String seq) {
        this.seq = seq;
    }

    /**
	 * Column Info
	 * @param objListNo
	 */
    public void setObjListNo(String objListNo) {
        this.objListNo = objListNo;
    }

    /**
	 * Column Info
	 * @param seq2
	 */
    public void setSeq2(String seq2) {
        this.seq2 = seq2;
    }

    /**
	 * Column Info
	 * @param trfSeq
	 */
    public void setTrfSeq(String trfSeq) {
        this.trfSeq = trfSeq;
    }

    /**
	 * Column Info
	 * @param condDesc
	 */
    public void setCondDesc(String condDesc) {
        this.condDesc = condDesc;
    }

    public void setCondAlsNm(String condAlsNm) {
        this.condAlsNm = condAlsNm;
    }

    public String getCondAlsNm() {
        return this.condAlsNm;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setChgXprSeq(JSPUtil.getParameter(request, "chg_xpr_seq", ""));
        setObjectCode(JSPUtil.getParameter(request, "object_code", ""));
        setRateValue(JSPUtil.getParameter(request, "rate_value", ""));
        setFomlDesc(JSPUtil.getParameter(request, "foml_desc", ""));
        setMethodCode(JSPUtil.getParameter(request, "method_code", ""));
        setObject(JSPUtil.getParameter(request, "object", ""));
        setSumOption(JSPUtil.getParameter(request, "sum_option", ""));
        setObjectDsp(JSPUtil.getParameter(request, "object_dsp", ""));
        setRateCode(JSPUtil.getParameter(request, "rate_code", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setCurrency(JSPUtil.getParameter(request, "currency", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setPortTrfNo(JSPUtil.getParameter(request, "port_trf_no", ""));
        setInvUse(JSPUtil.getParameter(request, "inv_use", ""));
        setUom(JSPUtil.getParameter(request, "uom", ""));
        setDefault2(JSPUtil.getParameter(request, "default2", ""));
        setFomlSysDesc(JSPUtil.getParameter(request, "foml_sys_desc", ""));
        setYdChgVerSeq(JSPUtil.getParameter(request, "yd_chg_ver_seq", ""));
        setRegularValue(JSPUtil.getParameter(request, "regular_value", ""));
        setPsoTrfTpCd(JSPUtil.getParameter(request, "pso_trf_tp_cd", ""));
        setChgXprNo(JSPUtil.getParameter(request, "chg_xpr_no", ""));
        setYdChgNo(JSPUtil.getParameter(request, "yd_chg_no", ""));
        setUomDsp(JSPUtil.getParameter(request, "uom_dsp", ""));
        setPsoChgTpCd(JSPUtil.getParameter(request, "pso_chg_tp_cd", ""));
        setFormulaNo(JSPUtil.getParameter(request, "formula_no", ""));
        setIdx(JSPUtil.getParameter(request, "idx", ""));
        setCondition(JSPUtil.getParameter(request, "condition", ""));
        setObjectName(JSPUtil.getParameter(request, "object_name", ""));
        setYdChgXprNo(JSPUtil.getParameter(request, "yd_chg_xpr_no", ""));
        setObjectCodeDsp(JSPUtil.getParameter(request, "object_code_dsp", ""));
        setRangeFrom(JSPUtil.getParameter(request, "range_from", ""));
        setRangeTo(JSPUtil.getParameter(request, "range_to", ""));
        setSeq(JSPUtil.getParameter(request, "seq", ""));
        setObjListNo(JSPUtil.getParameter(request, "obj_list_no", ""));
        setSeq2(JSPUtil.getParameter(request, "seq2", ""));
        setTrfSeq(JSPUtil.getParameter(request, "trf_seq", ""));
        setCondDesc(JSPUtil.getParameter(request, "cond_desc", ""));
        setUk(JSPUtil.getParameter(request, "uk", ""));
        setBm(JSPUtil.getParameter(request, "bm", ""));
        setBmCondition(JSPUtil.getParameter(request, "bm_condition", ""));
        setBmCondDesc(JSPUtil.getParameter(request, "bm_cond_desc", ""));
        setCplsFlg(JSPUtil.getParameter(request, "cpls_flg", ""));
        setUpdMnuNoCond(JSPUtil.getParameter(request, "upd_mnu_no_cond", ""));
        setConsAlsNm(JSPUtil.getParameter(request, "cons_als_nm", ""));
        setUpdMnuNoCondText(JSPUtil.getParameter(request, "upd_mnu_no_cond_text", ""));
        setCondAlsNm(JSPUtil.getParameter(request, "cond_als_nm", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TariffBaseVO[]
	 */
    public TariffBaseVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TariffBaseVO[]
	 */
    public TariffBaseVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        TariffBaseVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] chgXprSeq = (JSPUtil.getParameter(request, prefix + "chg_xpr_seq", length));
            String[] objectCode = (JSPUtil.getParameter(request, prefix + "object_code", length));
            String[] rateValue = (JSPUtil.getParameter(request, prefix + "rate_value", length));
            String[] fomlDesc = (JSPUtil.getParameter(request, prefix + "foml_desc", length));
            String[] methodCode = (JSPUtil.getParameter(request, prefix + "method_code", length));
            String[] object = (JSPUtil.getParameter(request, prefix + "object", length));
            String[] sumOption = (JSPUtil.getParameter(request, prefix + "sum_option", length));
            String[] objectDsp = (JSPUtil.getParameter(request, prefix + "object_dsp", length));
            String[] rateCode = (JSPUtil.getParameter(request, prefix + "rate_code", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] currency = (JSPUtil.getParameter(request, prefix + "currency", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] portTrfNo = (JSPUtil.getParameter(request, prefix + "port_trf_no", length));
            String[] invUse = (JSPUtil.getParameter(request, prefix + "inv_use", length));
            String[] uom = (JSPUtil.getParameter(request, prefix + "uom", length));
            String[] default2 = (JSPUtil.getParameter(request, prefix + "default2", length));
            String[] fomlSysDesc = (JSPUtil.getParameter(request, prefix + "foml_sys_desc", length));
            String[] ydChgVerSeq = (JSPUtil.getParameter(request, prefix + "yd_chg_ver_seq", length));
            String[] regularValue = (JSPUtil.getParameter(request, prefix + "regular_value", length));
            String[] psoTrfTpCd = (JSPUtil.getParameter(request, prefix + "pso_trf_tp_cd", length));
            String[] chgXprNo = (JSPUtil.getParameter(request, prefix + "chg_xpr_no", length));
            String[] ydChgNo = (JSPUtil.getParameter(request, prefix + "yd_chg_no", length));
            String[] uomDsp = (JSPUtil.getParameter(request, prefix + "uom_dsp", length));
            String[] psoChgTpCd = (JSPUtil.getParameter(request, prefix + "pso_chg_tp_cd", length));
            String[] formulaNo = (JSPUtil.getParameter(request, prefix + "formula_no", length));
            String[] idx = (JSPUtil.getParameter(request, prefix + "idx", length));
            String[] condition = (JSPUtil.getParameter(request, prefix + "condition", length));
            String[] objectName = (JSPUtil.getParameter(request, prefix + "object_name", length));
            String[] ydChgXprNo = (JSPUtil.getParameter(request, prefix + "yd_chg_xpr_no", length));
            String[] objectCodeDsp = (JSPUtil.getParameter(request, prefix + "object_code_dsp", length));
            String[] rangeFrom = (JSPUtil.getParameter(request, prefix + "range_from", length));
            String[] rangeTo = (JSPUtil.getParameter(request, prefix + "range_to", length));
            String[] seq = (JSPUtil.getParameter(request, prefix + "seq", length));
            String[] objListNo = (JSPUtil.getParameter(request, prefix + "obj_list_no", length));
            String[] seq2 = (JSPUtil.getParameter(request, prefix + "seq2", length));
            String[] trfSeq = (JSPUtil.getParameter(request, prefix + "trf_seq", length));
            String[] condDesc = (JSPUtil.getParameter(request, prefix + "cond_desc", length));
            String[] uk = (JSPUtil.getParameter(request, prefix + "uk", length));
            String[] bm = (JSPUtil.getParameter(request, prefix + "bm", length));
            String[] bmCondition = (JSPUtil.getParameter(request, prefix + "bm_condition", length));
            String[] bmCondDesc = (JSPUtil.getParameter(request, prefix + "bm_cond_desc", length));
            String[] cplsFlg = (JSPUtil.getParameter(request, prefix + "cpls_flg", length));
            String[] updMnuNoCond = (JSPUtil.getParameter(request, prefix + "upd_mnu_no_cond", length));
            String[] consAlsNm = (JSPUtil.getParameter(request, prefix + "cons_als_nm", length));
            String[] updMnuNoCondText = (JSPUtil.getParameter(request, prefix + "upd_mnu_no_cond_text", length));
            String[] condAlsNm = (JSPUtil.getParameter(request, prefix + "cond_als_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new TariffBaseVO();
                if (chgXprSeq[i] != null)
                    model.setChgXprSeq(chgXprSeq[i]);
                if (objectCode[i] != null)
                    model.setObjectCode(objectCode[i]);
                if (rateValue[i] != null)
                    model.setRateValue(rateValue[i]);
                if (fomlDesc[i] != null)
                    model.setFomlDesc(fomlDesc[i]);
                if (methodCode[i] != null)
                    model.setMethodCode(methodCode[i]);
                if (object[i] != null)
                    model.setObject(object[i]);
                if (sumOption[i] != null)
                    model.setSumOption(sumOption[i]);
                if (objectDsp[i] != null)
                    model.setObjectDsp(objectDsp[i]);
                if (rateCode[i] != null)
                    model.setRateCode(rateCode[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (currency[i] != null)
                    model.setCurrency(currency[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (portTrfNo[i] != null)
                    model.setPortTrfNo(portTrfNo[i]);
                if (invUse[i] != null)
                    model.setInvUse(invUse[i]);
                if (uom[i] != null)
                    model.setUom(uom[i]);
                if (default2[i] != null)
                    model.setDefault2(default2[i]);
                if (fomlSysDesc[i] != null)
                    model.setFomlSysDesc(fomlSysDesc[i]);
                if (ydChgVerSeq[i] != null)
                    model.setYdChgVerSeq(ydChgVerSeq[i]);
                if (regularValue[i] != null)
                    model.setRegularValue(regularValue[i]);
                if (psoTrfTpCd[i] != null)
                    model.setPsoTrfTpCd(psoTrfTpCd[i]);
                if (chgXprNo[i] != null)
                    model.setChgXprNo(chgXprNo[i]);
                if (ydChgNo[i] != null)
                    model.setYdChgNo(ydChgNo[i]);
                if (uomDsp[i] != null)
                    model.setUomDsp(uomDsp[i]);
                if (psoChgTpCd[i] != null)
                    model.setPsoChgTpCd(psoChgTpCd[i]);
                if (formulaNo[i] != null)
                    model.setFormulaNo(formulaNo[i]);
                if (idx[i] != null)
                    model.setIdx(idx[i]);
                if (condition[i] != null)
                    model.setCondition(condition[i]);
                if (objectName[i] != null)
                    model.setObjectName(objectName[i]);
                if (ydChgXprNo[i] != null)
                    model.setYdChgXprNo(ydChgXprNo[i]);
                if (objectCodeDsp[i] != null)
                    model.setObjectCodeDsp(objectCodeDsp[i]);
                if (rangeFrom[i] != null)
                    model.setRangeFrom(rangeFrom[i]);
                if (rangeTo[i] != null)
                    model.setRangeTo(rangeTo[i]);
                if (seq[i] != null)
                    model.setSeq(seq[i]);
                if (objListNo[i] != null)
                    model.setObjListNo(objListNo[i]);
                if (seq2[i] != null)
                    model.setSeq2(seq2[i]);
                if (trfSeq[i] != null)
                    model.setTrfSeq(trfSeq[i]);
                if (condDesc[i] != null)
                    model.setCondDesc(condDesc[i]);
                if (uk[i] != null)
                    model.setUk(uk[i]);
                if (bm[i] != null)
                    model.setBm(bm[i]);
                if (bmCondition[i] != null)
                    model.setBmCondition(bmCondition[i]);
                if (bmCondDesc[i] != null)
                    model.setBmCondDesc(bmCondDesc[i]);
                if (cplsFlg[i] != null)
                    model.setCplsFlg(cplsFlg[i]);
                if (updMnuNoCond[i] != null)
                    model.setUpdMnuNoCond(updMnuNoCond[i]);
                if (consAlsNm[i] != null)
                    model.setConsAlsNm(consAlsNm[i]);
                if (updMnuNoCondText[i] != null)
                    model.setUpdMnuNoCondText(updMnuNoCondText[i]);
                if (condAlsNm[i] != null) 
		    		model.setCondAlsNm(condAlsNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getTariffBaseVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return TariffBaseVO[]
	 */
    public TariffBaseVO[] getTariffBaseVOs() {
        TariffBaseVO[] vos = (TariffBaseVO[]) models.toArray(new TariffBaseVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        StringBuffer ret = new StringBuffer();
        Field[] field = this.getClass().getDeclaredFields();
        String space = "";
        try {
            for (int i = 0; i < field.length; i++) {
                String[] arr = null;
                arr = getField(field, i);
                if (arr != null) {
                    for (int j = 0; j < arr.length; j++) {
                        ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
                    }
                } else {
                    ret.append(field[i].getName() + " =  null \n");
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return ret.toString();
    }

    /**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
    private String[] getField(Field[] field, int i) {
        String[] arr = null;
        try {
            arr = (String[]) field[i].get(this);
        } catch (Exception ex) {
            arr = null;
        }
        return arr;
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.chgXprSeq = this.chgXprSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.objectCode = this.objectCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rateValue = this.rateValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fomlDesc = this.fomlDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.methodCode = this.methodCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.object = this.object.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumOption = this.sumOption.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.objectDsp = this.objectDsp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rateCode = this.rateCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currency = this.currency.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portTrfNo = this.portTrfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invUse = this.invUse.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.uom = this.uom.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.default2 = this.default2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fomlSysDesc = this.fomlSysDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydChgVerSeq = this.ydChgVerSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.regularValue = this.regularValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.psoTrfTpCd = this.psoTrfTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgXprNo = this.chgXprNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydChgNo = this.ydChgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.uomDsp = this.uomDsp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.psoChgTpCd = this.psoChgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.formulaNo = this.formulaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idx = this.idx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.condition = this.condition.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.objectName = this.objectName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydChgXprNo = this.ydChgXprNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.objectCodeDsp = this.objectCodeDsp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rangeFrom = this.rangeFrom.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rangeTo = this.rangeTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.seq = this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.objListNo = this.objListNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.seq2 = this.seq2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trfSeq = this.trfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.condDesc = this.condDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.uk = this.uk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bm = this.bm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bmCondition = this.bmCondition.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bmCondDesc = this.bmCondDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cplsFlg = this.cplsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updMnuNoCond = this.updMnuNoCond.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.consAlsNm = this.consAlsNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updMnuNoCondText = this.updMnuNoCondText.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.condAlsNm = this.condAlsNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }

    /**
	 * @return the uk
	 */
    public String getUk() {
        return uk;
    }

    /**
	 * @param uk the uk to set
	 */
    public void setUk(String uk) {
        this.uk = uk;
    }

    /**
	 * @return the bm
	 */
    public String getBm() {
        return bm;
    }

    /**
	 * @param bm the bm to set
	 */
    public void setBm(String bm) {
        this.bm = bm;
    }

    /**
	 * @return the bmCondition
	 */
    public String getBmCondition() {
        return bmCondition;
    }

    /**
	 * @param bmCondition the bmCondition to set
	 */
    public void setBmCondition(String bmCondition) {
        this.bmCondition = bmCondition;
    }

    /**
	 * @return the bmCondDesc
	 */
    public String getBmCondDesc() {
        return bmCondDesc;
    }

    /**
	 * @param bmCondDesc the bmCondDesc to set
	 */
    public void setBmCondDesc(String bmCondDesc) {
        this.bmCondDesc = bmCondDesc;
    }

    /**
	 * @return the cplsFlg
	 */
    public String getCplsFlg() {
        return cplsFlg;
    }

    /**
	 * @param cplsFlg the cplsFlg to set
	 */
    public void setCplsFlg(String cplsFlg) {
        this.cplsFlg = cplsFlg;
    }

    /**
	 * @return the updMnuNoCond
	 */
    public String getUpdMnuNoCond() {
        return updMnuNoCond;
    }

    /**
	 * @param updMnuNoCond the updMnuNoCond to set
	 */
    public void setUpdMnuNoCond(String updMnuNoCond) {
        this.updMnuNoCond = updMnuNoCond;
    }

    /**
	 * @return the consAlsNm
	 */
    public String getConsAlsNm() {
        return consAlsNm;
    }

    /**
	 * @param consAlsNm the consAlsNm to set
	 */
    public void setConsAlsNm(String consAlsNm) {
        this.consAlsNm = consAlsNm;
    }

    public String getUpdMnuNoCondText() {
        return updMnuNoCondText;
    }

    public void setUpdMnuNoCondText(String updMnuNoCondText) {
        this.updMnuNoCondText = updMnuNoCondText;
    }
}
