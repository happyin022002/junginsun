/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchStatusMonitorVO.java
*@FileTitle : SearchStatusMonitorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchStatusMonitorVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchStatusMonitorVO> models = new ArrayList<SearchStatusMonitorVO>();
	
	/* Column Info */
	private String trfTp = null;
	/* Column Info */
	private String comboSts = null;
	/* Column Info */
	private String itval = null;
	/* Column Info */
	private String cUpdUsrNm = null;
	/* Column Info */
	private String costTrfStsNm = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String cUpdUsrId = null;
	/* Column Info */
	private String pUpdUsrNm = null;
	/* Column Info */
	private String pCreUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cUpdDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String hisData = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String ficPropStsCd = null;
	/* Column Info */
	private String pCreDt = null;
	/* Column Info */
	private String dtTp = null;
	/* Column Info */
	private String pCreUsrNm = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String ihcTrfNo = null;
	/* Column Info */
	private String costTrfNo = null;
	/* Column Info */
	private String cCreUsrNm = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String cCreDt = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String pUpdDt = null;
	/* Column Info */
	private String costTrfStsCd = null;
	/* Column Info */
	private String cCreUsrId = null;
	/* Column Info */
	private String ficPropStsNm = null;
	/* Column Info */
	private String pUpdUsrId = null;
	/* Column Info */
	private String comboRhq = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String ihcTrfTp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchStatusMonitorVO() {}

	public SearchStatusMonitorVO(String ibflag, String pagerows, String rhqCd, String trfTp, String cntCd, String ioBndCd, String itval, String costTrfNo, String costTrfStsCd, String costTrfStsNm, String effFmDt, String effToDt, String cCreDt, String cCreUsrId, String cCreUsrNm, String cUpdDt, String cUpdUsrId, String cUpdUsrNm, String ihcTrfNo, String amdtSeq, String ficPropStsCd, String ficPropStsNm, String effDt, String expDt, String pCreDt, String pCreUsrId, String pCreUsrNm, String pUpdDt, String pUpdUsrId, String pUpdUsrNm, String dtTp, String fmDt, String toDt, String comboSts, String hisData, String comboRhq, String ihcTrfTp) {
		this.trfTp = trfTp;
		this.comboSts = comboSts;
		this.itval = itval;
		this.cUpdUsrNm = cUpdUsrNm;
		this.costTrfStsNm = costTrfStsNm;
		this.amdtSeq = amdtSeq;
		this.cUpdUsrId = cUpdUsrId;
		this.pUpdUsrNm = pUpdUsrNm;
		this.pCreUsrId = pCreUsrId;
		this.pagerows = pagerows;
		this.cUpdDt = cUpdDt;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.hisData = hisData;
		this.cntCd = cntCd;
		this.effFmDt = effFmDt;
		this.expDt = expDt;
		this.ficPropStsCd = ficPropStsCd;
		this.pCreDt = pCreDt;
		this.dtTp = dtTp;
		this.pCreUsrNm = pCreUsrNm;
		this.fmDt = fmDt;
		this.rhqCd = rhqCd;
		this.ihcTrfNo = ihcTrfNo;
		this.costTrfNo = costTrfNo;
		this.cCreUsrNm = cCreUsrNm;
		this.ioBndCd = ioBndCd;
		this.cCreDt = cCreDt;
		this.toDt = toDt;
		this.pUpdDt = pUpdDt;
		this.costTrfStsCd = costTrfStsCd;
		this.cCreUsrId = cCreUsrId;
		this.ficPropStsNm = ficPropStsNm;
		this.pUpdUsrId = pUpdUsrId;
		this.comboRhq = comboRhq;
		this.effToDt = effToDt;
		this.ihcTrfTp = ihcTrfTp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trf_tp", getTrfTp());
		this.hashColumns.put("combo_sts", getComboSts());
		this.hashColumns.put("itval", getItval());
		this.hashColumns.put("c_upd_usr_nm", getCUpdUsrNm());
		this.hashColumns.put("cost_trf_sts_nm", getCostTrfStsNm());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("c_upd_usr_id", getCUpdUsrId());
		this.hashColumns.put("p_upd_usr_nm", getPUpdUsrNm());
		this.hashColumns.put("p_cre_usr_id", getPCreUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("c_upd_dt", getCUpdDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("his_data", getHisData());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("fic_prop_sts_cd", getFicPropStsCd());
		this.hashColumns.put("p_cre_dt", getPCreDt());
		this.hashColumns.put("dt_tp", getDtTp());
		this.hashColumns.put("p_cre_usr_nm", getPCreUsrNm());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("ihc_trf_no", getIhcTrfNo());
		this.hashColumns.put("cost_trf_no", getCostTrfNo());
		this.hashColumns.put("c_cre_usr_nm", getCCreUsrNm());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("c_cre_dt", getCCreDt());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("p_upd_dt", getPUpdDt());
		this.hashColumns.put("cost_trf_sts_cd", getCostTrfStsCd());
		this.hashColumns.put("c_cre_usr_id", getCCreUsrId());
		this.hashColumns.put("fic_prop_sts_nm", getFicPropStsNm());
		this.hashColumns.put("p_upd_usr_id", getPUpdUsrId());
		this.hashColumns.put("combo_rhq", getComboRhq());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("ihc_trf_tp", getIhcTrfTp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trf_tp", "trfTp");
		this.hashFields.put("combo_sts", "comboSts");
		this.hashFields.put("itval", "itval");
		this.hashFields.put("c_upd_usr_nm", "cUpdUsrNm");
		this.hashFields.put("cost_trf_sts_nm", "costTrfStsNm");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("c_upd_usr_id", "cUpdUsrId");
		this.hashFields.put("p_upd_usr_nm", "pUpdUsrNm");
		this.hashFields.put("p_cre_usr_id", "pCreUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("c_upd_dt", "cUpdDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("his_data", "hisData");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("fic_prop_sts_cd", "ficPropStsCd");
		this.hashFields.put("p_cre_dt", "pCreDt");
		this.hashFields.put("dt_tp", "dtTp");
		this.hashFields.put("p_cre_usr_nm", "pCreUsrNm");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("ihc_trf_no", "ihcTrfNo");
		this.hashFields.put("cost_trf_no", "costTrfNo");
		this.hashFields.put("c_cre_usr_nm", "cCreUsrNm");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("c_cre_dt", "cCreDt");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("p_upd_dt", "pUpdDt");
		this.hashFields.put("cost_trf_sts_cd", "costTrfStsCd");
		this.hashFields.put("c_cre_usr_id", "cCreUsrId");
		this.hashFields.put("fic_prop_sts_nm", "ficPropStsNm");
		this.hashFields.put("p_upd_usr_id", "pUpdUsrId");
		this.hashFields.put("combo_rhq", "comboRhq");
		this.hashFields.put("eff_to_dt", "effToDt");
		this.hashFields.put("ihc_trf_tp", "ihcTrfTp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trfTp
	 */
	public String getTrfTp() {
		return this.trfTp;
	}
	
	/**
	 * Column Info
	 * @return comboSts
	 */
	public String getComboSts() {
		return this.comboSts;
	}
	
	/**
	 * Column Info
	 * @return itval
	 */
	public String getItval() {
		return this.itval;
	}
	
	/**
	 * Column Info
	 * @return cUpdUsrNm
	 */
	public String getCUpdUsrNm() {
		return this.cUpdUsrNm;
	}
	
	/**
	 * Column Info
	 * @return costTrfStsNm
	 */
	public String getCostTrfStsNm() {
		return this.costTrfStsNm;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return cUpdUsrId
	 */
	public String getCUpdUsrId() {
		return this.cUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @return pUpdUsrNm
	 */
	public String getPUpdUsrNm() {
		return this.pUpdUsrNm;
	}
	
	/**
	 * Column Info
	 * @return pCreUsrId
	 */
	public String getPCreUsrId() {
		return this.pCreUsrId;
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
	 * @return cUpdDt
	 */
	public String getCUpdDt() {
		return this.cUpdDt;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return hisData
	 */
	public String getHisData() {
		return this.hisData;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return effFmDt
	 */
	public String getEffFmDt() {
		return this.effFmDt;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return ficPropStsCd
	 */
	public String getFicPropStsCd() {
		return this.ficPropStsCd;
	}
	
	/**
	 * Column Info
	 * @return pCreDt
	 */
	public String getPCreDt() {
		return this.pCreDt;
	}
	
	/**
	 * Column Info
	 * @return dtTp
	 */
	public String getDtTp() {
		return this.dtTp;
	}
	
	/**
	 * Column Info
	 * @return pCreUsrNm
	 */
	public String getPCreUsrNm() {
		return this.pCreUsrNm;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return ihcTrfNo
	 */
	public String getIhcTrfNo() {
		return this.ihcTrfNo;
	}
	
	/**
	 * Column Info
	 * @return costTrfNo
	 */
	public String getCostTrfNo() {
		return this.costTrfNo;
	}
	
	/**
	 * Column Info
	 * @return cCreUsrNm
	 */
	public String getCCreUsrNm() {
		return this.cCreUsrNm;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return cCreDt
	 */
	public String getCCreDt() {
		return this.cCreDt;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return pUpdDt
	 */
	public String getPUpdDt() {
		return this.pUpdDt;
	}
	
	/**
	 * Column Info
	 * @return costTrfStsCd
	 */
	public String getCostTrfStsCd() {
		return this.costTrfStsCd;
	}
	
	/**
	 * Column Info
	 * @return cCreUsrId
	 */
	public String getCCreUsrId() {
		return this.cCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return ficPropStsNm
	 */
	public String getFicPropStsNm() {
		return this.ficPropStsNm;
	}
	
	/**
	 * Column Info
	 * @return pUpdUsrId
	 */
	public String getPUpdUsrId() {
		return this.pUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @return comboRhq
	 */
	public String getComboRhq() {
		return this.comboRhq;
	}
	
	/**
	 * Column Info
	 * @return effToDt
	 */
	public String getEffToDt() {
		return this.effToDt;
	}
	
	/**
	 * Column Info
	 * @return ihcTrfTp
	 */
	public String getIhcTrfTp() {
		return this.ihcTrfTp;
	}
	

	/**
	 * Column Info
	 * @param trfTp
	 */
	public void setTrfTp(String trfTp) {
		this.trfTp = trfTp;
	}
	
	/**
	 * Column Info
	 * @param comboSts
	 */
	public void setComboSts(String comboSts) {
		this.comboSts = comboSts;
	}
	
	/**
	 * Column Info
	 * @param itval
	 */
	public void setItval(String itval) {
		this.itval = itval;
	}
	
	/**
	 * Column Info
	 * @param cUpdUsrNm
	 */
	public void setCUpdUsrNm(String cUpdUsrNm) {
		this.cUpdUsrNm = cUpdUsrNm;
	}
	
	/**
	 * Column Info
	 * @param costTrfStsNm
	 */
	public void setCostTrfStsNm(String costTrfStsNm) {
		this.costTrfStsNm = costTrfStsNm;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param cUpdUsrId
	 */
	public void setCUpdUsrId(String cUpdUsrId) {
		this.cUpdUsrId = cUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @param pUpdUsrNm
	 */
	public void setPUpdUsrNm(String pUpdUsrNm) {
		this.pUpdUsrNm = pUpdUsrNm;
	}
	
	/**
	 * Column Info
	 * @param pCreUsrId
	 */
	public void setPCreUsrId(String pCreUsrId) {
		this.pCreUsrId = pCreUsrId;
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
	 * @param cUpdDt
	 */
	public void setCUpdDt(String cUpdDt) {
		this.cUpdDt = cUpdDt;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param hisData
	 */
	public void setHisData(String hisData) {
		this.hisData = hisData;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param effFmDt
	 */
	public void setEffFmDt(String effFmDt) {
		this.effFmDt = effFmDt;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param ficPropStsCd
	 */
	public void setFicPropStsCd(String ficPropStsCd) {
		this.ficPropStsCd = ficPropStsCd;
	}
	
	/**
	 * Column Info
	 * @param pCreDt
	 */
	public void setPCreDt(String pCreDt) {
		this.pCreDt = pCreDt;
	}
	
	/**
	 * Column Info
	 * @param dtTp
	 */
	public void setDtTp(String dtTp) {
		this.dtTp = dtTp;
	}
	
	/**
	 * Column Info
	 * @param pCreUsrNm
	 */
	public void setPCreUsrNm(String pCreUsrNm) {
		this.pCreUsrNm = pCreUsrNm;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param ihcTrfNo
	 */
	public void setIhcTrfNo(String ihcTrfNo) {
		this.ihcTrfNo = ihcTrfNo;
	}
	
	/**
	 * Column Info
	 * @param costTrfNo
	 */
	public void setCostTrfNo(String costTrfNo) {
		this.costTrfNo = costTrfNo;
	}
	
	/**
	 * Column Info
	 * @param cCreUsrNm
	 */
	public void setCCreUsrNm(String cCreUsrNm) {
		this.cCreUsrNm = cCreUsrNm;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param cCreDt
	 */
	public void setCCreDt(String cCreDt) {
		this.cCreDt = cCreDt;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param pUpdDt
	 */
	public void setPUpdDt(String pUpdDt) {
		this.pUpdDt = pUpdDt;
	}
	
	/**
	 * Column Info
	 * @param costTrfStsCd
	 */
	public void setCostTrfStsCd(String costTrfStsCd) {
		this.costTrfStsCd = costTrfStsCd;
	}
	
	/**
	 * Column Info
	 * @param cCreUsrId
	 */
	public void setCCreUsrId(String cCreUsrId) {
		this.cCreUsrId = cCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param ficPropStsNm
	 */
	public void setFicPropStsNm(String ficPropStsNm) {
		this.ficPropStsNm = ficPropStsNm;
	}
	
	/**
	 * Column Info
	 * @param pUpdUsrId
	 */
	public void setPUpdUsrId(String pUpdUsrId) {
		this.pUpdUsrId = pUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @param comboRhq
	 */
	public void setComboRhq(String comboRhq) {
		this.comboRhq = comboRhq;
	}
	
	/**
	 * Column Info
	 * @param effToDt
	 */
	public void setEffToDt(String effToDt) {
		this.effToDt = effToDt;
	}
	
	/**
	 * Column Info
	 * @param ihcTrfTp
	 */
	public void setIhcTrfTp(String ihcTrfTp) {
		this.ihcTrfTp = ihcTrfTp;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setTrfTp(JSPUtil.getParameter(request, prefix + "trf_tp", ""));
		setComboSts(JSPUtil.getParameter(request, prefix + "combo_sts", ""));
		setItval(JSPUtil.getParameter(request, prefix + "itval", ""));
		setCUpdUsrNm(JSPUtil.getParameter(request, prefix + "c_upd_usr_nm", ""));
		setCostTrfStsNm(JSPUtil.getParameter(request, prefix + "cost_trf_sts_nm", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setCUpdUsrId(JSPUtil.getParameter(request, prefix + "c_upd_usr_id", ""));
		setPUpdUsrNm(JSPUtil.getParameter(request, prefix + "p_upd_usr_nm", ""));
		setPCreUsrId(JSPUtil.getParameter(request, prefix + "p_cre_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCUpdDt(JSPUtil.getParameter(request, prefix + "c_upd_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setHisData(JSPUtil.getParameter(request, prefix + "his_data", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setFicPropStsCd(JSPUtil.getParameter(request, prefix + "fic_prop_sts_cd", ""));
		setPCreDt(JSPUtil.getParameter(request, prefix + "p_cre_dt", ""));
		setDtTp(JSPUtil.getParameter(request, prefix + "dt_tp", ""));
		setPCreUsrNm(JSPUtil.getParameter(request, prefix + "p_cre_usr_nm", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setIhcTrfNo(JSPUtil.getParameter(request, prefix + "ihc_trf_no", ""));
		setCostTrfNo(JSPUtil.getParameter(request, prefix + "cost_trf_no", ""));
		setCCreUsrNm(JSPUtil.getParameter(request, prefix + "c_cre_usr_nm", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setCCreDt(JSPUtil.getParameter(request, prefix + "c_cre_dt", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setPUpdDt(JSPUtil.getParameter(request, prefix + "p_upd_dt", ""));
		setCostTrfStsCd(JSPUtil.getParameter(request, prefix + "cost_trf_sts_cd", ""));
		setCCreUsrId(JSPUtil.getParameter(request, prefix + "c_cre_usr_id", ""));
		setFicPropStsNm(JSPUtil.getParameter(request, prefix + "fic_prop_sts_nm", ""));
		setPUpdUsrId(JSPUtil.getParameter(request, prefix + "p_upd_usr_id", ""));
		setComboRhq(JSPUtil.getParameter(request, prefix + "combo_rhq", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setIhcTrfTp(JSPUtil.getParameter(request, prefix + "ihc_trf_tp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchStatusMonitorVO[]
	 */
	public SearchStatusMonitorVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchStatusMonitorVO[]
	 */
	public SearchStatusMonitorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchStatusMonitorVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trfTp = (JSPUtil.getParameter(request, prefix	+ "trf_tp", length));
			String[] comboSts = (JSPUtil.getParameter(request, prefix	+ "combo_sts", length));
			String[] itval = (JSPUtil.getParameter(request, prefix	+ "itval", length));
			String[] cUpdUsrNm = (JSPUtil.getParameter(request, prefix	+ "c_upd_usr_nm", length));
			String[] costTrfStsNm = (JSPUtil.getParameter(request, prefix	+ "cost_trf_sts_nm", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] cUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "c_upd_usr_id", length));
			String[] pUpdUsrNm = (JSPUtil.getParameter(request, prefix	+ "p_upd_usr_nm", length));
			String[] pCreUsrId = (JSPUtil.getParameter(request, prefix	+ "p_cre_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cUpdDt = (JSPUtil.getParameter(request, prefix	+ "c_upd_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] hisData = (JSPUtil.getParameter(request, prefix	+ "his_data", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] ficPropStsCd = (JSPUtil.getParameter(request, prefix	+ "fic_prop_sts_cd", length));
			String[] pCreDt = (JSPUtil.getParameter(request, prefix	+ "p_cre_dt", length));
			String[] dtTp = (JSPUtil.getParameter(request, prefix	+ "dt_tp", length));
			String[] pCreUsrNm = (JSPUtil.getParameter(request, prefix	+ "p_cre_usr_nm", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] ihcTrfNo = (JSPUtil.getParameter(request, prefix	+ "ihc_trf_no", length));
			String[] costTrfNo = (JSPUtil.getParameter(request, prefix	+ "cost_trf_no", length));
			String[] cCreUsrNm = (JSPUtil.getParameter(request, prefix	+ "c_cre_usr_nm", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] cCreDt = (JSPUtil.getParameter(request, prefix	+ "c_cre_dt", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] pUpdDt = (JSPUtil.getParameter(request, prefix	+ "p_upd_dt", length));
			String[] costTrfStsCd = (JSPUtil.getParameter(request, prefix	+ "cost_trf_sts_cd", length));
			String[] cCreUsrId = (JSPUtil.getParameter(request, prefix	+ "c_cre_usr_id", length));
			String[] ficPropStsNm = (JSPUtil.getParameter(request, prefix	+ "fic_prop_sts_nm", length));
			String[] pUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "p_upd_usr_id", length));
			String[] comboRhq = (JSPUtil.getParameter(request, prefix	+ "combo_rhq", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix	+ "eff_to_dt", length));
			String[] ihcTrfTp = (JSPUtil.getParameter(request, prefix	+ "ihc_trf_tp", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchStatusMonitorVO();
				if (trfTp[i] != null)
					model.setTrfTp(trfTp[i]);
				if (comboSts[i] != null)
					model.setComboSts(comboSts[i]);
				if (itval[i] != null)
					model.setItval(itval[i]);
				if (cUpdUsrNm[i] != null)
					model.setCUpdUsrNm(cUpdUsrNm[i]);
				if (costTrfStsNm[i] != null)
					model.setCostTrfStsNm(costTrfStsNm[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (cUpdUsrId[i] != null)
					model.setCUpdUsrId(cUpdUsrId[i]);
				if (pUpdUsrNm[i] != null)
					model.setPUpdUsrNm(pUpdUsrNm[i]);
				if (pCreUsrId[i] != null)
					model.setPCreUsrId(pCreUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cUpdDt[i] != null)
					model.setCUpdDt(cUpdDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (hisData[i] != null)
					model.setHisData(hisData[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (ficPropStsCd[i] != null)
					model.setFicPropStsCd(ficPropStsCd[i]);
				if (pCreDt[i] != null)
					model.setPCreDt(pCreDt[i]);
				if (dtTp[i] != null)
					model.setDtTp(dtTp[i]);
				if (pCreUsrNm[i] != null)
					model.setPCreUsrNm(pCreUsrNm[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (ihcTrfNo[i] != null)
					model.setIhcTrfNo(ihcTrfNo[i]);
				if (costTrfNo[i] != null)
					model.setCostTrfNo(costTrfNo[i]);
				if (cCreUsrNm[i] != null)
					model.setCCreUsrNm(cCreUsrNm[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (cCreDt[i] != null)
					model.setCCreDt(cCreDt[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (pUpdDt[i] != null)
					model.setPUpdDt(pUpdDt[i]);
				if (costTrfStsCd[i] != null)
					model.setCostTrfStsCd(costTrfStsCd[i]);
				if (cCreUsrId[i] != null)
					model.setCCreUsrId(cCreUsrId[i]);
				if (ficPropStsNm[i] != null)
					model.setFicPropStsNm(ficPropStsNm[i]);
				if (pUpdUsrId[i] != null)
					model.setPUpdUsrId(pUpdUsrId[i]);
				if (comboRhq[i] != null)
					model.setComboRhq(comboRhq[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (ihcTrfTp[i] != null)
					model.setIhcTrfTp(ihcTrfTp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchStatusMonitorVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchStatusMonitorVO[]
	 */
	public SearchStatusMonitorVO[] getSearchStatusMonitorVOs(){
		SearchStatusMonitorVO[] vos = (SearchStatusMonitorVO[])models.toArray(new SearchStatusMonitorVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.trfTp = this.trfTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboSts = this.comboSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itval = this.itval .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cUpdUsrNm = this.cUpdUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfStsNm = this.costTrfStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cUpdUsrId = this.cUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pUpdUsrNm = this.pUpdUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCreUsrId = this.pCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cUpdDt = this.cUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisData = this.hisData .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficPropStsCd = this.ficPropStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCreDt = this.pCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtTp = this.dtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCreUsrNm = this.pCreUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcTrfNo = this.ihcTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfNo = this.costTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCreUsrNm = this.cCreUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCreDt = this.cCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pUpdDt = this.pUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfStsCd = this.costTrfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCreUsrId = this.cCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficPropStsNm = this.ficPropStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pUpdUsrId = this.pUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboRhq = this.comboRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcTrfTp = this.ihcTrfTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
