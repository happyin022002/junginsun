/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchCostCalcListVO.java
*@FileTitle : SearchCostCalcListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.14
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2012.06.01 최종혁 
* 1.0 Creation
* 
* History
* 2013.01.14 CHM-201322300 이혜민 [AOC] Batch creation 시 기준 WGT 입력 기능추가 요청
* 2015.02.03 CHM-201533794 전지예 [AOC] 45' Cost 추가
=========================================================*/

package com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.vo;

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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCostCalcListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCostCalcListVO> models = new ArrayList<SearchCostCalcListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String comboSts = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String batProgKnt = null;
	/* Column Info */
	private String costTrfNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String xchRt = null;
	/* Column Info */
	private String stsNm = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String batProgTtlKnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntNm = null;
	/* Column Info */
	private String usrOfcCd = null;
	/* Column Info */
	private String progRatio = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String ioBndNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String elapseTime = null;
	/* Column Info */
	private String costTrfBatSeq = null;
	/* Column Info */
	private String comboRhq = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String glineTrfNo = null;
	/* Column Info */
	private String cntr40ftCrteWgt = null;
	/* Column Info */
	private String cntr20ftCrteWgt = null;
	/* Column Info */
	private String cntr45ftCrteWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCostCalcListVO() {}

	public SearchCostCalcListVO(String ibflag, String pagerows, String rhqCd, String cntCd, String cntNm, String ioBndCd, String ioBndNm, String costTrfNo, String stsCd, String stsNm, String batProgKnt, String batProgTtlKnt, String progRatio, String currCd, String xchRt, String elapseTime, String creDt, String creUsrId, String creOfcCd, String updDt, String updUsrId, String comboSts, String usrOfcCd, String costTrfBatSeq, String comboRhq, String updOfcCd, String glineTrfNo, String cntr20ftCrteWgt, String cntr40ftCrteWgt, String cntr45ftCrteWgt) {
		this.updDt = updDt;
		this.comboSts = comboSts;
		this.currCd = currCd;
		this.rhqCd = rhqCd;
		this.batProgKnt = batProgKnt;
		this.costTrfNo = costTrfNo;
		this.creDt = creDt;
		this.xchRt = xchRt;
		this.stsNm = stsNm;
		this.ioBndCd = ioBndCd;
		this.batProgTtlKnt = batProgTtlKnt;
		this.pagerows = pagerows;
		this.stsCd = stsCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.cntNm = cntNm;
		this.usrOfcCd = usrOfcCd;
		this.progRatio = progRatio;
		this.creOfcCd = creOfcCd;
		this.cntCd = cntCd;
		this.ioBndNm = ioBndNm;
		this.updUsrId = updUsrId;
		this.elapseTime = elapseTime;
		this.costTrfBatSeq = costTrfBatSeq;
		this.comboRhq = comboRhq;
		this.updOfcCd = updOfcCd;
		this.glineTrfNo = glineTrfNo;
		this.cntr20ftCrteWgt = cntr20ftCrteWgt;
		this.cntr40ftCrteWgt = cntr40ftCrteWgt;
		this.cntr45ftCrteWgt = cntr45ftCrteWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("combo_sts", getComboSts());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("bat_prog_knt", getBatProgKnt());
		this.hashColumns.put("cost_trf_no", getCostTrfNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("xch_rt", getXchRt());
		this.hashColumns.put("sts_nm", getStsNm());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("bat_prog_ttl_knt", getBatProgTtlKnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
		this.hashColumns.put("prog_ratio", getProgRatio());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("io_bnd_nm", getIoBndNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("elapse_time", getElapseTime());
		this.hashColumns.put("cost_trf_bat_seq", getCostTrfBatSeq());
		this.hashColumns.put("combo_rhq", getComboRhq());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("gline_trf_no", getGlineTrfNo());
		this.hashColumns.put("cntr_40ft_crte_wgt", getCntr40ftCrteWgt());
		this.hashColumns.put("cntr_20ft_crte_wgt", getCntr20ftCrteWgt());
		this.hashColumns.put("cntr_45ft_crte_wgt", getCntr45ftCrteWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("combo_sts", "comboSts");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bat_prog_knt", "batProgKnt");
		this.hashFields.put("cost_trf_no", "costTrfNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("xch_rt", "xchRt");
		this.hashFields.put("sts_nm", "stsNm");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("bat_prog_ttl_knt", "batProgTtlKnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		this.hashFields.put("prog_ratio", "progRatio");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("io_bnd_nm", "ioBndNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("elapse_time", "elapseTime");
		this.hashFields.put("cost_trf_bat_seq", "costTrfBatSeq");
		this.hashFields.put("combo_rhq", "comboRhq");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("gline_trf_no", "glineTrfNo");
		this.hashFields.put("cntr_40ft_crte_wgt", "cntr40ftCrteWgt");
		this.hashFields.put("cntr_20ft_crte_wgt", "cntr20ftCrteWgt");
		this.hashFields.put("cntr_45ft_crte_wgt", "cntr45ftCrteWgt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return batProgKnt
	 */
	public String getBatProgKnt() {
		return this.batProgKnt;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return xchRt
	 */
	public String getXchRt() {
		return this.xchRt;
	}
	
	/**
	 * Column Info
	 * @return stsNm
	 */
	public String getStsNm() {
		return this.stsNm;
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
	 * @return batProgTtlKnt
	 */
	public String getBatProgTtlKnt() {
		return this.batProgTtlKnt;
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
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
	}
	
	/**
	 * Column Info
	 * @return usrOfcCd
	 */
	public String getUsrOfcCd() {
		return this.usrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return progRatio
	 */
	public String getProgRatio() {
		return this.progRatio;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
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
	 * @return ioBndNm
	 */
	public String getIoBndNm() {
		return this.ioBndNm;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return elapseTime
	 */
	public String getElapseTime() {
		return this.elapseTime;
	}
	
	/**
	 * Column Info
	 * @return costTrfBatSeq
	 */
	public String getCostTrfBatSeq() {
		return this.costTrfBatSeq;
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
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	
	/**
	 * Column Info
	 * @return glineTrfNo
	 */
	public String getGlineTrfNo() {
		return this.glineTrfNo;
	}
	
	/**
	 * Column Info
	 * @return cntr20ftCrteWgt
	 */
	public String getCntr20ftCrteWgt() {
		return this.cntr20ftCrteWgt;
	}
	/**
	 * Column Info
	 * @return cntr40ftCrteWgt
	 */
	public String getCntr40ftCrteWgt() {
		return this.cntr40ftCrteWgt;
	}
	

	public final String getCntr45ftCrteWgt() {
		return cntr45ftCrteWgt;
	}

	public final void setCntr45ftCrteWgt(String cntr45ftCrteWgt) {
		this.cntr45ftCrteWgt = cntr45ftCrteWgt;
	}

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param batProgKnt
	 */
	public void setBatProgKnt(String batProgKnt) {
		this.batProgKnt = batProgKnt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param xchRt
	 */
	public void setXchRt(String xchRt) {
		this.xchRt = xchRt;
	}
	
	/**
	 * Column Info
	 * @param stsNm
	 */
	public void setStsNm(String stsNm) {
		this.stsNm = stsNm;
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
	 * @param batProgTtlKnt
	 */
	public void setBatProgTtlKnt(String batProgTtlKnt) {
		this.batProgTtlKnt = batProgTtlKnt;
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
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
	}
	
	/**
	 * Column Info
	 * @param usrOfcCd
	 */
	public void setUsrOfcCd(String usrOfcCd) {
		this.usrOfcCd = usrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param progRatio
	 */
	public void setProgRatio(String progRatio) {
		this.progRatio = progRatio;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
	 * @param ioBndNm
	 */
	public void setIoBndNm(String ioBndNm) {
		this.ioBndNm = ioBndNm;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param elapseTime
	 */
	public void setElapseTime(String elapseTime) {
		this.elapseTime = elapseTime;
	}
	
	/**
	 * Column Info
	 * @param costTrfBatSeq
	 */
	public void setCostTrfBatSeq(String costTrfBatSeq) {
		this.costTrfBatSeq = costTrfBatSeq;
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
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param glineTrfNo
	 */
	public void setGlineTrfNo(String glineTrfNo) {
		this.glineTrfNo = glineTrfNo;
	}
	
	/**
	 * Column Info
	 * @param cntr40ftCrteWgt
	 */
	public void setCntr40ftCrteWgt(String cntr40ftCrteWgt) {
		this.cntr40ftCrteWgt = cntr40ftCrteWgt;
	}
	
	/**
	 * Column Info
	 * @param cntr20ftCrteWgt
	 */
	public void setCntr20ftCrteWgt(String cntr20ftCrteWgt) {
		this.cntr20ftCrteWgt = cntr20ftCrteWgt;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setComboSts(JSPUtil.getParameter(request, prefix + "combo_sts", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setBatProgKnt(JSPUtil.getParameter(request, prefix + "bat_prog_knt", ""));
		setCostTrfNo(JSPUtil.getParameter(request, prefix + "cost_trf_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setXchRt(JSPUtil.getParameter(request, prefix + "xch_rt", ""));
		setStsNm(JSPUtil.getParameter(request, prefix + "sts_nm", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setBatProgTtlKnt(JSPUtil.getParameter(request, prefix + "bat_prog_ttl_knt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntNm(JSPUtil.getParameter(request, prefix + "cnt_nm", ""));
		setUsrOfcCd(JSPUtil.getParameter(request, prefix + "usr_ofc_cd", ""));
		setProgRatio(JSPUtil.getParameter(request, prefix + "prog_ratio", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setIoBndNm(JSPUtil.getParameter(request, prefix + "io_bnd_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setElapseTime(JSPUtil.getParameter(request, prefix + "elapse_time", ""));
		setCostTrfBatSeq(JSPUtil.getParameter(request, prefix + "cost_trf_bat_seq", ""));
		setComboRhq(JSPUtil.getParameter(request, prefix + "combo_rhq", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setGlineTrfNo(JSPUtil.getParameter(request, prefix + "gline_trf_no", ""));
		setCntr40ftCrteWgt(JSPUtil.getParameter(request, prefix + "cntr_40ft_crte_wgt", ""));
		setCntr20ftCrteWgt(JSPUtil.getParameter(request, prefix + "cntr_20ft_crte_wgt", ""));
		setCntr45ftCrteWgt(JSPUtil.getParameter(request, prefix + "cntr_45ft_crte_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCostCalcListVO[]
	 */
	public SearchCostCalcListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCostCalcListVO[]
	 */
	public SearchCostCalcListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCostCalcListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] comboSts = (JSPUtil.getParameter(request, prefix	+ "combo_sts", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] batProgKnt = (JSPUtil.getParameter(request, prefix	+ "bat_prog_knt", length));
			String[] costTrfNo = (JSPUtil.getParameter(request, prefix	+ "cost_trf_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] xchRt = (JSPUtil.getParameter(request, prefix	+ "xch_rt", length));
			String[] stsNm = (JSPUtil.getParameter(request, prefix	+ "sts_nm", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] batProgTtlKnt = (JSPUtil.getParameter(request, prefix	+ "bat_prog_ttl_knt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] usrOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd", length));
			String[] progRatio = (JSPUtil.getParameter(request, prefix	+ "prog_ratio", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] ioBndNm = (JSPUtil.getParameter(request, prefix	+ "io_bnd_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] elapseTime = (JSPUtil.getParameter(request, prefix	+ "elapse_time", length));
			String[] costTrfBatSeq = (JSPUtil.getParameter(request, prefix	+ "cost_trf_bat_seq", length));
			String[] comboRhq = (JSPUtil.getParameter(request, prefix	+ "combo_rhq", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] glineTrfNo = (JSPUtil.getParameter(request, prefix	+ "gline_trf_no", length));
			String[] cntr40ftCrteWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_40ft_crte_wgt", length));
			String[] cntr20ftCrteWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_20ft_crte_wgt", length));
			String[] cntr45ftCrteWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_45ft_crte_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCostCalcListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (comboSts[i] != null)
					model.setComboSts(comboSts[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (batProgKnt[i] != null)
					model.setBatProgKnt(batProgKnt[i]);
				if (costTrfNo[i] != null)
					model.setCostTrfNo(costTrfNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (xchRt[i] != null)
					model.setXchRt(xchRt[i]);
				if (stsNm[i] != null)
					model.setStsNm(stsNm[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (batProgTtlKnt[i] != null)
					model.setBatProgTtlKnt(batProgTtlKnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (usrOfcCd[i] != null)
					model.setUsrOfcCd(usrOfcCd[i]);
				if (progRatio[i] != null)
					model.setProgRatio(progRatio[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (ioBndNm[i] != null)
					model.setIoBndNm(ioBndNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (elapseTime[i] != null)
					model.setElapseTime(elapseTime[i]);
				if (costTrfBatSeq[i] != null)
					model.setCostTrfBatSeq(costTrfBatSeq[i]);
				if (comboRhq[i] != null)
					model.setComboRhq(comboRhq[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (glineTrfNo[i] != null)
					model.setGlineTrfNo(glineTrfNo[i]);
				if (cntr40ftCrteWgt[i] != null)
					model.setCntr40ftCrteWgt(cntr40ftCrteWgt[i]);
				if (cntr20ftCrteWgt[i] != null)
					model.setCntr20ftCrteWgt(cntr20ftCrteWgt[i]);
				if (cntr45ftCrteWgt[i] != null)
					model.setCntr45ftCrteWgt(cntr45ftCrteWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCostCalcListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCostCalcListVO[]
	 */
	public SearchCostCalcListVO[] getSearchCostCalcListVOs(){
		SearchCostCalcListVO[] vos = (SearchCostCalcListVO[])models.toArray(new SearchCostCalcListVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboSts = this.comboSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batProgKnt = this.batProgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfNo = this.costTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRt = this.xchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsNm = this.stsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batProgTtlKnt = this.batProgTtlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd = this.usrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progRatio = this.progRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndNm = this.ioBndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elapseTime = this.elapseTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfBatSeq = this.costTrfBatSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboRhq = this.comboRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineTrfNo = this.glineTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr40ftCrteWgt = this.cntr40ftCrteWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20ftCrteWgt = this.cntr20ftCrteWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr45ftCrteWgt = this.cntr45ftCrteWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
