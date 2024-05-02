/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionRateAdjustVO.java
*@FileTitle : RFAExceptionRateAdjustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.10  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RFAExceptionRateAdjustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RFAExceptionRateAdjustVO> models = new ArrayList<RFAExceptionRateAdjustVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cvrgCmbSeq = null;
	/* Column Info */
	private String rfaExptRtSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cntrHcRtAmt = null;
	/* Column Info */
	private String n1stCmncVerSeq = null;
	/* Column Info */
	private String cntr45ftRtAmt = null;
	/* Column Info */
	private String cntr20ftRtAmt = null;
	/* Column Info */
	private String ftOvrDys = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rfaExptMapgSeq = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String rfaExptDarNo = null;
	/* Column Info */
	private String rfaExptVerSeq = null;
	/* Column Info */
	private String rfaRqstDtlSeq = null;
	/* Column Info */
	private String cntr40ftRtAmt = null;
	/* Column Info */
	private String ftUndDys = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RFAExceptionRateAdjustVO() {}

	public RFAExceptionRateAdjustVO(String ibflag, String pagerows, String rfaExptDarNo, String rfaExptMapgSeq, String rfaExptVerSeq, String cvrgCmbSeq, String rfaRqstDtlSeq, String rfaExptRtSeq, String ftOvrDys, String ftUndDys, String cntr20ftRtAmt, String cntr40ftRtAmt, String cntrHcRtAmt, String cntr45ftRtAmt, String n1stCmncVerSeq, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd) {
		this.updDt = updDt;
		this.cvrgCmbSeq = cvrgCmbSeq;
		this.rfaExptRtSeq = rfaExptRtSeq;
		this.creDt = creDt;
		this.cntrHcRtAmt = cntrHcRtAmt;
		this.n1stCmncVerSeq = n1stCmncVerSeq;
		this.cntr45ftRtAmt = cntr45ftRtAmt;
		this.cntr20ftRtAmt = cntr20ftRtAmt;
		this.ftOvrDys = ftOvrDys;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.rfaExptMapgSeq = rfaExptMapgSeq;
		this.creOfcCd = creOfcCd;
		this.rfaExptDarNo = rfaExptDarNo;
		this.rfaExptVerSeq = rfaExptVerSeq;
		this.rfaRqstDtlSeq = rfaRqstDtlSeq;
		this.cntr40ftRtAmt = cntr40ftRtAmt;
		this.ftUndDys = ftUndDys;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cvrg_cmb_seq", getCvrgCmbSeq());
		this.hashColumns.put("rfa_expt_rt_seq", getRfaExptRtSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cntr_hc_rt_amt", getCntrHcRtAmt());
		this.hashColumns.put("n1st_cmnc_ver_seq", getN1stCmncVerSeq());
		this.hashColumns.put("cntr_45ft_rt_amt", getCntr45ftRtAmt());
		this.hashColumns.put("cntr_20ft_rt_amt", getCntr20ftRtAmt());
		this.hashColumns.put("ft_ovr_dys", getFtOvrDys());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rfa_expt_mapg_seq", getRfaExptMapgSeq());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("rfa_expt_dar_no", getRfaExptDarNo());
		this.hashColumns.put("rfa_expt_ver_seq", getRfaExptVerSeq());
		this.hashColumns.put("rfa_rqst_dtl_seq", getRfaRqstDtlSeq());
		this.hashColumns.put("cntr_40ft_rt_amt", getCntr40ftRtAmt());
		this.hashColumns.put("ft_und_dys", getFtUndDys());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cvrg_cmb_seq", "cvrgCmbSeq");
		this.hashFields.put("rfa_expt_rt_seq", "rfaExptRtSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cntr_hc_rt_amt", "cntrHcRtAmt");
		this.hashFields.put("n1st_cmnc_ver_seq", "n1stCmncVerSeq");
		this.hashFields.put("cntr_45ft_rt_amt", "cntr45ftRtAmt");
		this.hashFields.put("cntr_20ft_rt_amt", "cntr20ftRtAmt");
		this.hashFields.put("ft_ovr_dys", "ftOvrDys");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rfa_expt_mapg_seq", "rfaExptMapgSeq");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("rfa_expt_dar_no", "rfaExptDarNo");
		this.hashFields.put("rfa_expt_ver_seq", "rfaExptVerSeq");
		this.hashFields.put("rfa_rqst_dtl_seq", "rfaRqstDtlSeq");
		this.hashFields.put("cntr_40ft_rt_amt", "cntr40ftRtAmt");
		this.hashFields.put("ft_und_dys", "ftUndDys");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return cvrgCmbSeq
	 */
	public String getCvrgCmbSeq() {
		return this.cvrgCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return rfaExptRtSeq
	 */
	public String getRfaExptRtSeq() {
		return this.rfaExptRtSeq;
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
	 * @return cntrHcRtAmt
	 */
	public String getCntrHcRtAmt() {
		return this.cntrHcRtAmt;
	}
	
	/**
	 * Column Info
	 * @return n1stCmncVerSeq
	 */
	public String getN1stCmncVerSeq() {
		return this.n1stCmncVerSeq;
	}
	
	/**
	 * Column Info
	 * @return cntr45ftRtAmt
	 */
	public String getCntr45ftRtAmt() {
		return this.cntr45ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return cntr20ftRtAmt
	 */
	public String getCntr20ftRtAmt() {
		return this.cntr20ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ftOvrDys
	 */
	public String getFtOvrDys() {
		return this.ftOvrDys;
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
	 * @return rfaExptMapgSeq
	 */
	public String getRfaExptMapgSeq() {
		return this.rfaExptMapgSeq;
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
	 * @return rfaExptDarNo
	 */
	public String getRfaExptDarNo() {
		return this.rfaExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return rfaExptVerSeq
	 */
	public String getRfaExptVerSeq() {
		return this.rfaExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @return rfaRqstDtlSeq
	 */
	public String getRfaRqstDtlSeq() {
		return this.rfaRqstDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return cntr40ftRtAmt
	 */
	public String getCntr40ftRtAmt() {
		return this.cntr40ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ftUndDys
	 */
	public String getFtUndDys() {
		return this.ftUndDys;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param cvrgCmbSeq
	 */
	public void setCvrgCmbSeq(String cvrgCmbSeq) {
		this.cvrgCmbSeq = cvrgCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param rfaExptRtSeq
	 */
	public void setRfaExptRtSeq(String rfaExptRtSeq) {
		this.rfaExptRtSeq = rfaExptRtSeq;
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
	 * @param cntrHcRtAmt
	 */
	public void setCntrHcRtAmt(String cntrHcRtAmt) {
		this.cntrHcRtAmt = cntrHcRtAmt;
	}
	
	/**
	 * Column Info
	 * @param n1stCmncVerSeq
	 */
	public void setN1stCmncVerSeq(String n1stCmncVerSeq) {
		this.n1stCmncVerSeq = n1stCmncVerSeq;
	}
	
	/**
	 * Column Info
	 * @param cntr45ftRtAmt
	 */
	public void setCntr45ftRtAmt(String cntr45ftRtAmt) {
		this.cntr45ftRtAmt = cntr45ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param cntr20ftRtAmt
	 */
	public void setCntr20ftRtAmt(String cntr20ftRtAmt) {
		this.cntr20ftRtAmt = cntr20ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ftOvrDys
	 */
	public void setFtOvrDys(String ftOvrDys) {
		this.ftOvrDys = ftOvrDys;
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
	 * @param rfaExptMapgSeq
	 */
	public void setRfaExptMapgSeq(String rfaExptMapgSeq) {
		this.rfaExptMapgSeq = rfaExptMapgSeq;
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
	 * @param rfaExptDarNo
	 */
	public void setRfaExptDarNo(String rfaExptDarNo) {
		this.rfaExptDarNo = rfaExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param rfaExptVerSeq
	 */
	public void setRfaExptVerSeq(String rfaExptVerSeq) {
		this.rfaExptVerSeq = rfaExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @param rfaRqstDtlSeq
	 */
	public void setRfaRqstDtlSeq(String rfaRqstDtlSeq) {
		this.rfaRqstDtlSeq = rfaRqstDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param cntr40ftRtAmt
	 */
	public void setCntr40ftRtAmt(String cntr40ftRtAmt) {
		this.cntr40ftRtAmt = cntr40ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ftUndDys
	 */
	public void setFtUndDys(String ftUndDys) {
		this.ftUndDys = ftUndDys;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCvrgCmbSeq(JSPUtil.getParameter(request, "cvrg_cmb_seq", ""));
		setRfaExptRtSeq(JSPUtil.getParameter(request, "rfa_expt_rt_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCntrHcRtAmt(JSPUtil.getParameter(request, "cntr_hc_rt_amt", ""));
		setN1stCmncVerSeq(JSPUtil.getParameter(request, "n1st_cmnc_ver_seq", ""));
		setCntr45ftRtAmt(JSPUtil.getParameter(request, "cntr_45ft_rt_amt", ""));
		setCntr20ftRtAmt(JSPUtil.getParameter(request, "cntr_20ft_rt_amt", ""));
		setFtOvrDys(JSPUtil.getParameter(request, "ft_ovr_dys", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRfaExptMapgSeq(JSPUtil.getParameter(request, "rfa_expt_mapg_seq", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setRfaExptDarNo(JSPUtil.getParameter(request, "rfa_expt_dar_no", ""));
		setRfaExptVerSeq(JSPUtil.getParameter(request, "rfa_expt_ver_seq", ""));
		setRfaRqstDtlSeq(JSPUtil.getParameter(request, "rfa_rqst_dtl_seq", ""));
		setCntr40ftRtAmt(JSPUtil.getParameter(request, "cntr_40ft_rt_amt", ""));
		setFtUndDys(JSPUtil.getParameter(request, "ft_und_dys", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RFAExceptionRateAdjustVO[]
	 */
	public RFAExceptionRateAdjustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RFAExceptionRateAdjustVO[]
	 */
	public RFAExceptionRateAdjustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RFAExceptionRateAdjustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cvrgCmbSeq = (JSPUtil.getParameter(request, prefix	+ "cvrg_cmb_seq", length));
			String[] rfaExptRtSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_rt_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cntrHcRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_hc_rt_amt", length));
			String[] n1stCmncVerSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_ver_seq", length));
			String[] cntr45ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_45ft_rt_amt", length));
			String[] cntr20ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_20ft_rt_amt", length));
			String[] ftOvrDys = (JSPUtil.getParameter(request, prefix	+ "ft_ovr_dys", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rfaExptMapgSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_mapg_seq", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] rfaExptDarNo = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_dar_no", length));
			String[] rfaExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_ver_seq", length));
			String[] rfaRqstDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_rqst_dtl_seq", length));
			String[] cntr40ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_40ft_rt_amt", length));
			String[] ftUndDys = (JSPUtil.getParameter(request, prefix	+ "ft_und_dys", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new RFAExceptionRateAdjustVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cvrgCmbSeq[i] != null)
					model.setCvrgCmbSeq(cvrgCmbSeq[i]);
				if (rfaExptRtSeq[i] != null)
					model.setRfaExptRtSeq(rfaExptRtSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cntrHcRtAmt[i] != null)
					model.setCntrHcRtAmt(cntrHcRtAmt[i]);
				if (n1stCmncVerSeq[i] != null)
					model.setN1stCmncVerSeq(n1stCmncVerSeq[i]);
				if (cntr45ftRtAmt[i] != null)
					model.setCntr45ftRtAmt(cntr45ftRtAmt[i]);
				if (cntr20ftRtAmt[i] != null)
					model.setCntr20ftRtAmt(cntr20ftRtAmt[i]);
				if (ftOvrDys[i] != null)
					model.setFtOvrDys(ftOvrDys[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rfaExptMapgSeq[i] != null)
					model.setRfaExptMapgSeq(rfaExptMapgSeq[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (rfaExptDarNo[i] != null)
					model.setRfaExptDarNo(rfaExptDarNo[i]);
				if (rfaExptVerSeq[i] != null)
					model.setRfaExptVerSeq(rfaExptVerSeq[i]);
				if (rfaRqstDtlSeq[i] != null)
					model.setRfaRqstDtlSeq(rfaRqstDtlSeq[i]);
				if (cntr40ftRtAmt[i] != null)
					model.setCntr40ftRtAmt(cntr40ftRtAmt[i]);
				if (ftUndDys[i] != null)
					model.setFtUndDys(ftUndDys[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRFAExceptionRateAdjustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RFAExceptionRateAdjustVO[]
	 */
	public RFAExceptionRateAdjustVO[] getRFAExceptionRateAdjustVOs(){
		RFAExceptionRateAdjustVO[] vos = (RFAExceptionRateAdjustVO[])models.toArray(new RFAExceptionRateAdjustVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
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
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgCmbSeq = this.cvrgCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptRtSeq = this.rfaExptRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHcRtAmt = this.cntrHcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncVerSeq = this.n1stCmncVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr45ftRtAmt = this.cntr45ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20ftRtAmt = this.cntr20ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftOvrDys = this.ftOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptMapgSeq = this.rfaExptMapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptDarNo = this.rfaExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptVerSeq = this.rfaExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaRqstDtlSeq = this.rfaRqstDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr40ftRtAmt = this.cntr40ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftUndDys = this.ftUndDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
