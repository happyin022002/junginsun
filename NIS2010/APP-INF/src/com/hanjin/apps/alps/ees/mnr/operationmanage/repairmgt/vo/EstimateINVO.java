/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EstimateINVO.java
*@FileTitle : EstimateINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.10
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2011.02.10 서미진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo;

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
 * @author 서미진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EstimateINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EstimateINVO> models = new ArrayList<EstimateINVO>();
	
	/* Column Info */
	private String curOfcCd = null;
	/* Column Info */
	private String fmRqstDt = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String rprStsCd = null;
	/* Column Info */
	private String rprRqstVerNo = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String toRqstDt = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String tmpSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rqstEqNo = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String sorting = null;
	/* Column Info */
	private String estTemp = null;
	/* Column Info */
	private String rqstType = null;
	/* Column Info */
	private String rprRqstSeq = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String rprRqstLstVerFlg = null;
	/* Column Info */
	private String rqstRefNo = null;
	/* Column Info */
	private String popFlag = null;
	/* Column Info */
	private String reqStDt = null;
	/* Column Info */
	private String reqEndDt = null;
	/* Column Info */
	private String dpRqstDt = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EstimateINVO() {}

	public EstimateINVO(String ibflag, String pagerows, String curOfcCd, String fmRqstDt, String costOfcCd, String rprStsCd, String rprRqstVerNo, String agmtSeq, String toRqstDt, String eqKndCd, String aproOfcCd, String tmpSeq, String rqstEqNo, String vndrSeq, String trfNo, String agmtOfcCtyCd, String estTemp, String rqstType, String agmtVerNo, String rprRqstSeq, String rprRqstLstVerFlg, String sorting, String rqstRefNo, String popFlag, String reqStDt, String reqEndDt, String dpRqstDt) {
		this.curOfcCd = curOfcCd;
		this.fmRqstDt = fmRqstDt;
		this.costOfcCd = costOfcCd;
		this.rprStsCd = rprStsCd;
		this.rprRqstVerNo = rprRqstVerNo;
		this.agmtSeq = agmtSeq;
		this.toRqstDt = toRqstDt;
		this.eqKndCd = eqKndCd;
		this.aproOfcCd = aproOfcCd;
		this.tmpSeq = tmpSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rqstEqNo = rqstEqNo;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.trfNo = trfNo;
		this.vndrSeq = vndrSeq;
		this.sorting = sorting;
		this.estTemp = estTemp;
		this.rqstType = rqstType;
		this.rprRqstSeq = rprRqstSeq;
		this.agmtVerNo = agmtVerNo;
		this.rprRqstLstVerFlg = rprRqstLstVerFlg;
		this.rqstRefNo = rqstRefNo;
		this.popFlag = popFlag;
		this.reqStDt = reqStDt;
		this.reqEndDt = reqEndDt;
		this.dpRqstDt = dpRqstDt; 
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cur_ofc_cd", getCurOfcCd());
		this.hashColumns.put("fm_rqst_dt", getFmRqstDt());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("rpr_sts_cd", getRprStsCd());
		this.hashColumns.put("rpr_rqst_ver_no", getRprRqstVerNo());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("to_rqst_dt", getToRqstDt());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("tmp_seq", getTmpSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("sorting", getSorting());
		this.hashColumns.put("est_temp", getEstTemp());
		this.hashColumns.put("rqst_type", getRqstType());
		this.hashColumns.put("rpr_rqst_seq", getRprRqstSeq());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("rpr_rqst_lst_ver_flg", getRprRqstLstVerFlg());
		this.hashColumns.put("rqst_ref_no", getRqstRefNo());
		this.hashColumns.put("pop_flag", getPopFlag());
		this.hashColumns.put("req_st_dt", getReqStDt());
		this.hashColumns.put("req_end_dt", getReqEndDt());
		this.hashColumns.put("dp_rqst_dt", getDpRqstDt());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cur_ofc_cd", "curOfcCd");
		this.hashFields.put("fm_rqst_dt", "fmRqstDt");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("rpr_sts_cd", "rprStsCd");
		this.hashFields.put("rpr_rqst_ver_no", "rprRqstVerNo");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("to_rqst_dt", "toRqstDt");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("tmp_seq", "tmpSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("sorting", "sorting");
		this.hashFields.put("est_temp", "estTemp");
		this.hashFields.put("rqst_type", "rqstType");
		this.hashFields.put("rpr_rqst_seq", "rprRqstSeq");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("rpr_rqst_lst_ver_flg", "rprRqstLstVerFlg");
		this.hashFields.put("rqst_ref_no", "rqstRefNo");
		this.hashFields.put("pop_flag", "popFlag");
		this.hashFields.put("req_st_dt", "reqStDt");
		this.hashFields.put("req_end_dt", "reqEndDt");
		this.hashFields.put("dp_rqst_dt", "dpRqstDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return curOfcCd
	 */
	public String getCurOfcCd() {
		return this.curOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fmRqstDt
	 */
	public String getFmRqstDt() {
		return this.fmRqstDt;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rprStsCd
	 */
	public String getRprStsCd() {
		return this.rprStsCd;
	}
	
	/**
	 * Column Info
	 * @return rprRqstVerNo
	 */
	public String getRprRqstVerNo() {
		return this.rprRqstVerNo;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return toRqstDt
	 */
	public String getToRqstDt() {
		return this.toRqstDt;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return tmpSeq
	 */
	public String getTmpSeq() {
		return this.tmpSeq;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return rqstEqNo
	 */
	public String getRqstEqNo() {
		return this.rqstEqNo;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return sorting
	 */
	public String getSorting() {
		return this.sorting;
	}
	
	/**
	 * Column Info
	 * @return estTemp
	 */
	public String getEstTemp() {
		return this.estTemp;
	}
	
	/**
	 * Column Info
	 * @return rqstType
	 */
	public String getRqstType() {
		return this.rqstType;
	}
	
	/**
	 * Column Info
	 * @return rprRqstSeq
	 */
	public String getRprRqstSeq() {
		return this.rprRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @return rprRqstLstVerFlg
	 */
	public String getRprRqstLstVerFlg() {
		return this.rprRqstLstVerFlg;
	}
	
	/**
	 * Column Info
	 * @return reqStDt
	 */
	public String getReqStDt() {
		return this.reqStDt;
	}
	
	/**
	 * Column Info
	 * @return reqEndDt
	 */
	public String getReqEndDt() {
		return this.reqEndDt;
	}
	
	/**
	 * Column Info
	 * @return dpRqstDt
	 */
	public String getDpRqstDt() {
		return this.dpRqstDt;
	}
	

	/**
	 * Column Info
	 * @param curOfcCd
	 */
	public void setCurOfcCd(String curOfcCd) {
		this.curOfcCd = curOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fmRqstDt
	 */
	public void setFmRqstDt(String fmRqstDt) {
		this.fmRqstDt = fmRqstDt;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rprStsCd
	 */
	public void setRprStsCd(String rprStsCd) {
		this.rprStsCd = rprStsCd;
	}
	
	/**
	 * Column Info
	 * @param rprRqstVerNo
	 */
	public void setRprRqstVerNo(String rprRqstVerNo) {
		this.rprRqstVerNo = rprRqstVerNo;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param toRqstDt
	 */
	public void setToRqstDt(String toRqstDt) {
		this.toRqstDt = toRqstDt;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param tmpSeq
	 */
	public void setTmpSeq(String tmpSeq) {
		this.tmpSeq = tmpSeq;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param rqstEqNo
	 */
	public void setRqstEqNo(String rqstEqNo) {
		this.rqstEqNo = rqstEqNo;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param sorting
	 */
	public void setSorting(String sorting) {
		this.sorting = sorting;
	}
	
	/**
	 * Column Info
	 * @param estTemp
	 */
	public void setEstTemp(String estTemp) {
		this.estTemp = estTemp;
	}
	
	/**
	 * Column Info
	 * @param rqstType
	 */
	public void setRqstType(String rqstType) {
		this.rqstType = rqstType;
	}
	
	/**
	 * Column Info
	 * @param rprRqstSeq
	 */
	public void setRprRqstSeq(String rprRqstSeq) {
		this.rprRqstSeq = rprRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @param rprRqstLstVerFlg
	 */
	public void setRprRqstLstVerFlg(String rprRqstLstVerFlg) {
		this.rprRqstLstVerFlg = rprRqstLstVerFlg;
	}
	
	/**
	 * Column Info
	 * @return rqstRefNo
	 */
	public String getRqstRefNo() {
		return rqstRefNo;
	}
	
	/**
	 * Column Info
	 * @param rqstRefNo
	 */
	public void setRqstRefNo(String rqstRefNo) {
		this.rqstRefNo = rqstRefNo;
	}
	
	/**
	 * Column Info
	 * @return popFlag
	 */
	public String getPopFlag() {
		return popFlag;
	}
	
	/**
	 * Column Info
	 * @param popFlag
	 */
	public void setPopFlag(String popFlag) {
		this.popFlag = popFlag;
	}
	
	/**
	 * Column Info
	 * @param reqStDt
	 */
	public void setReqStDt(String reqStDt) {
		this.reqStDt = reqStDt;
	}
	
	/**
	 * Column Info
	 * @param reqEndDt
	 */
	public void setReqEndDt(String reqEndDt) {
		this.reqEndDt = reqEndDt;
	}
	
	/**
	 * Column Info
	 * @param dpRqstDt
	 */
	public void setDpRqstDt(String dpRqstDt) {
		this.dpRqstDt = dpRqstDt;
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
		setCurOfcCd(JSPUtil.getParameter(request, prefix + "cur_ofc_cd", ""));
		setFmRqstDt(JSPUtil.getParameter(request, prefix + "fm_rqst_dt", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setRprStsCd(JSPUtil.getParameter(request, prefix + "rpr_sts_cd", ""));
		setRprRqstVerNo(JSPUtil.getParameter(request, prefix + "rpr_rqst_ver_no", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setToRqstDt(JSPUtil.getParameter(request, prefix + "to_rqst_dt", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setTmpSeq(JSPUtil.getParameter(request, prefix + "tmp_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRqstEqNo(JSPUtil.getParameter(request, prefix + "rqst_eq_no", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "agmt_ofc_cty_cd", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setSorting(JSPUtil.getParameter(request, prefix + "sorting", ""));
		setEstTemp(JSPUtil.getParameter(request, prefix + "est_temp", ""));
		setRqstType(JSPUtil.getParameter(request, prefix + "rqst_type", ""));
		setRprRqstSeq(JSPUtil.getParameter(request, prefix + "rpr_rqst_seq", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, prefix + "agmt_ver_no", ""));
		setRprRqstLstVerFlg(JSPUtil.getParameter(request, prefix + "rpr_rqst_lst_ver_flg", ""));
		setRqstRefNo(JSPUtil.getParameter(request, prefix + "rqst_ref_no", ""));
		setPopFlag(JSPUtil.getParameter(request, prefix + "pop_flag", ""));
		setReqStDt(JSPUtil.getParameter(request, prefix + "req_st_dt", ""));
		setReqEndDt(JSPUtil.getParameter(request, prefix + "req_end_dt", ""));
		setDpRqstDt(JSPUtil.getParameter(request, prefix + "dp_rqst_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EstimateINVO[]
	 */
	public EstimateINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EstimateINVO[]
	 */
	public EstimateINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EstimateINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] curOfcCd = (JSPUtil.getParameter(request, prefix	+ "cur_ofc_cd", length));
			String[] fmRqstDt = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_dt", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] rprStsCd = (JSPUtil.getParameter(request, prefix	+ "rpr_sts_cd", length));
			String[] rprRqstVerNo = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_ver_no", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] toRqstDt = (JSPUtil.getParameter(request, prefix	+ "to_rqst_dt", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] tmpSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rqstEqNo = (JSPUtil.getParameter(request, prefix	+ "rqst_eq_no", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] sorting = (JSPUtil.getParameter(request, prefix	+ "sorting", length));
			String[] estTemp = (JSPUtil.getParameter(request, prefix	+ "est_temp", length));
			String[] rqstType = (JSPUtil.getParameter(request, prefix	+ "rqst_type", length));
			String[] rprRqstSeq = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_seq", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] rprRqstLstVerFlg = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_lst_ver_flg", length));
			String[] rqstRefNo = (JSPUtil.getParameter(request, prefix	+ "rqst_ref_no", length));
			String[] popFlag = (JSPUtil.getParameter(request, prefix	+ "pop_flag", length));
			String[] reqStDt = (JSPUtil.getParameter(request, prefix	+ "req_st_dt", length));
			String[] reqEndDt = (JSPUtil.getParameter(request, prefix	+ "req_end_dt", length));
			String[] dpRqstDt = (JSPUtil.getParameter(request, prefix	+ "dp_rqst_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new EstimateINVO();
				if (curOfcCd[i] != null)
					model.setCurOfcCd(curOfcCd[i]);
				if (fmRqstDt[i] != null)
					model.setFmRqstDt(fmRqstDt[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (rprStsCd[i] != null)
					model.setRprStsCd(rprStsCd[i]);
				if (rprRqstVerNo[i] != null)
					model.setRprRqstVerNo(rprRqstVerNo[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (toRqstDt[i] != null)
					model.setToRqstDt(toRqstDt[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (tmpSeq[i] != null)
					model.setTmpSeq(tmpSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rqstEqNo[i] != null)
					model.setRqstEqNo(rqstEqNo[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (sorting[i] != null)
					model.setSorting(sorting[i]);
				if (estTemp[i] != null)
					model.setEstTemp(estTemp[i]);
				if (rqstType[i] != null)
					model.setRqstType(rqstType[i]);
				if (rprRqstSeq[i] != null)
					model.setRprRqstSeq(rprRqstSeq[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (rprRqstLstVerFlg[i] != null)
					model.setRprRqstLstVerFlg(rprRqstLstVerFlg[i]);
				if (rqstRefNo[i] != null)
					model.setRqstRefNo(rqstRefNo[i]);
				if (popFlag[i] != null)
					model.setPopFlag(popFlag[i]);
				if (reqStDt[i] != null)
					model.setReqStDt(reqStDt[i]);
				if (reqEndDt[i] != null)
					model.setReqEndDt(reqEndDt[i]);
				if (dpRqstDt[i] != null)
					model.setDpRqstDt(dpRqstDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEstimateINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EstimateINVO[]
	 */
	public EstimateINVO[] getEstimateINVOs(){
		EstimateINVO[] vos = (EstimateINVO[])models.toArray(new EstimateINVO[models.size()]);
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
		this.curOfcCd = this.curOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstDt = this.fmRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprStsCd = this.rprStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstVerNo = this.rprRqstVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstDt = this.toRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpSeq = this.tmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEqNo = this.rqstEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sorting = this.sorting .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estTemp = this.estTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstType = this.rqstType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstSeq = this.rprRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstLstVerFlg = this.rprRqstLstVerFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRefNo = this.rqstRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.popFlag = this.popFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqStDt = this.reqStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqEndDt = this.reqEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpRqstDt = this.dpRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
