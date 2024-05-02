/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomMnrDispTrfDtlVO.java
*@FileTitle : CustomMnrDispTrfDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2010.02.08 권영법 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo;

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
 * @author 권영법
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrDispTrfDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrDispTrfDtlVO> models = new ArrayList<CustomMnrDispTrfDtlVO>();
	
	/* Column Info */
	private String tempSeq = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mnrVrfyTpCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String mnrDispTrfSeq = null;
	/* Column Info */
	private String mnrDispTrfTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String mnrDispTrfDtlSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String mnrDispTrfStsCd = null;
	/* Column Info */
	private String mnrDispTrfGrpCd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnrDispTrfStsNm = null;
	/* Column Info */
	private String mnrDispTrfAmt = null;
	/* Column Info */
	private String dtlRmk = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrDispTrfDtlVO() {}

	public CustomMnrDispTrfDtlVO(String ibflag, String pagerows, String tempSeq, String updDt, String mnrVrfyTpCd, String currCd, String mnrDispTrfSeq, String creDt, String ctrlOfcCd, String mnrDispTrfDtlSeq, String eqTpszCd, String mnrDispTrfStsCd, String mnrDispTrfGrpCd, String effDt, String creUsrId, String locCd, String mnrDispTrfStsNm, String mnrDispTrfAmt, String dtlRmk, String updUsrId, String mnrDispTrfTpCd) {
		this.tempSeq = tempSeq;
		this.updDt = updDt;
		this.mnrVrfyTpCd = mnrVrfyTpCd;
		this.currCd = currCd;
		this.mnrDispTrfSeq = mnrDispTrfSeq;
		this.mnrDispTrfTpCd = mnrDispTrfTpCd;
		this.creDt = creDt;
		this.ctrlOfcCd = ctrlOfcCd;
		this.mnrDispTrfDtlSeq = mnrDispTrfDtlSeq;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.mnrDispTrfStsCd = mnrDispTrfStsCd;
		this.mnrDispTrfGrpCd = mnrDispTrfGrpCd;
		this.locCd = locCd;
		this.creUsrId = creUsrId;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.mnrDispTrfStsNm = mnrDispTrfStsNm;
		this.mnrDispTrfAmt = mnrDispTrfAmt;
		this.dtlRmk = dtlRmk;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("temp_seq", getTempSeq());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mnr_vrfy_tp_cd", getMnrVrfyTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("mnr_disp_trf_seq", getMnrDispTrfSeq());
		this.hashColumns.put("mnr_disp_trf_tp_cd", getMnrDispTrfTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("mnr_disp_trf_dtl_seq", getMnrDispTrfDtlSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("mnr_disp_trf_sts_cd", getMnrDispTrfStsCd());
		this.hashColumns.put("mnr_disp_trf_grp_cd", getMnrDispTrfGrpCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnr_disp_trf_sts_nm", getMnrDispTrfStsNm());
		this.hashColumns.put("mnr_disp_trf_amt", getMnrDispTrfAmt());
		this.hashColumns.put("dtl_rmk", getDtlRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("temp_seq", "tempSeq");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mnr_vrfy_tp_cd", "mnrVrfyTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("mnr_disp_trf_seq", "mnrDispTrfSeq");
		this.hashFields.put("mnr_disp_trf_tp_cd", "mnrDispTrfTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("mnr_disp_trf_dtl_seq", "mnrDispTrfDtlSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("mnr_disp_trf_sts_cd", "mnrDispTrfStsCd");
		this.hashFields.put("mnr_disp_trf_grp_cd", "mnrDispTrfGrpCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_disp_trf_sts_nm", "mnrDispTrfStsNm");
		this.hashFields.put("mnr_disp_trf_amt", "mnrDispTrfAmt");
		this.hashFields.put("dtl_rmk", "dtlRmk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tempSeq
	 */
	public String getTempSeq() {
		return this.tempSeq;
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
	 * @return mnrVrfyTpCd
	 */
	public String getMnrVrfyTpCd() {
		return this.mnrVrfyTpCd;
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
	 * @return mnrDispTrfSeq
	 */
	public String getMnrDispTrfSeq() {
		return this.mnrDispTrfSeq;
	}
	
	/**
	 * Column Info
	 * @return mnrDispTrfTpCd
	 */
	public String getMnrDispTrfTpCd() {
		return this.mnrDispTrfTpCd;
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
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mnrDispTrfDtlSeq
	 */
	public String getMnrDispTrfDtlSeq() {
		return this.mnrDispTrfDtlSeq;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return mnrDispTrfStsCd
	 */
	public String getMnrDispTrfStsCd() {
		return this.mnrDispTrfStsCd;
	}
	
	/**
	 * Column Info
	 * @return mnrDispTrfGrpCd
	 */
	public String getMnrDispTrfGrpCd() {
		return this.mnrDispTrfGrpCd;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return mnrDispTrfStsNm
	 */
	public String getMnrDispTrfStsNm() {
		return this.mnrDispTrfStsNm;
	}
	
	/**
	 * Column Info
	 * @return mnrDispTrfAmt
	 */
	public String getMnrDispTrfAmt() {
		return this.mnrDispTrfAmt;
	}
	
	/**
	 * Column Info
	 * @return dtlRmk
	 */
	public String getDtlRmk() {
		return this.dtlRmk;
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
	 * @param tempSeq
	 */
	public void setTempSeq(String tempSeq) {
		this.tempSeq = tempSeq;
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
	 * @param mnrVrfyTpCd
	 */
	public void setMnrVrfyTpCd(String mnrVrfyTpCd) {
		this.mnrVrfyTpCd = mnrVrfyTpCd;
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
	 * @param mnrDispTrfSeq
	 */
	public void setMnrDispTrfSeq(String mnrDispTrfSeq) {
		this.mnrDispTrfSeq = mnrDispTrfSeq;
	}
	
	/**
	 * Column Info
	 * @param mnrDispTrfTpCd
	 */
	public void setMnrDispTrfTpCd(String mnrDispTrfTpCd) {
		this.mnrDispTrfTpCd = mnrDispTrfTpCd;
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
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mnrDispTrfDtlSeq
	 */
	public void setMnrDispTrfDtlSeq(String mnrDispTrfDtlSeq) {
		this.mnrDispTrfDtlSeq = mnrDispTrfDtlSeq;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param mnrDispTrfStsCd
	 */
	public void setMnrDispTrfStsCd(String mnrDispTrfStsCd) {
		this.mnrDispTrfStsCd = mnrDispTrfStsCd;
	}
	
	/**
	 * Column Info
	 * @param mnrDispTrfGrpCd
	 */
	public void setMnrDispTrfGrpCd(String mnrDispTrfGrpCd) {
		this.mnrDispTrfGrpCd = mnrDispTrfGrpCd;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param mnrDispTrfStsNm
	 */
	public void setMnrDispTrfStsNm(String mnrDispTrfStsNm) {
		this.mnrDispTrfStsNm = mnrDispTrfStsNm;
	}
	
	/**
	 * Column Info
	 * @param mnrDispTrfAmt
	 */
	public void setMnrDispTrfAmt(String mnrDispTrfAmt) {
		this.mnrDispTrfAmt = mnrDispTrfAmt;
	}
	
	/**
	 * Column Info
	 * @param dtlRmk
	 */
	public void setDtlRmk(String dtlRmk) {
		this.dtlRmk = dtlRmk;
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
		setTempSeq(JSPUtil.getParameter(request, "temp_seq", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setMnrVrfyTpCd(JSPUtil.getParameter(request, "mnr_vrfy_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setMnrDispTrfSeq(JSPUtil.getParameter(request, "mnr_disp_trf_seq", ""));
		setMnrDispTrfTpCd(JSPUtil.getParameter(request, "mnr_disp_trf_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setMnrDispTrfDtlSeq(JSPUtil.getParameter(request, "mnr_disp_trf_dtl_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setMnrDispTrfStsCd(JSPUtil.getParameter(request, "mnr_disp_trf_sts_cd", ""));
		setMnrDispTrfGrpCd(JSPUtil.getParameter(request, "mnr_disp_trf_grp_cd", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMnrDispTrfStsNm(JSPUtil.getParameter(request, "mnr_disp_trf_sts_nm", ""));
		setMnrDispTrfAmt(JSPUtil.getParameter(request, "mnr_disp_trf_amt", ""));
		setDtlRmk(JSPUtil.getParameter(request, "dtl_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrDispTrfDtlVO[]
	 */
	public CustomMnrDispTrfDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrDispTrfDtlVO[]
	 */
	public CustomMnrDispTrfDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrDispTrfDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tempSeq = (JSPUtil.getParameter(request, prefix	+ "temp_seq", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mnrVrfyTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_vrfy_tp_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] mnrDispTrfSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_seq", length));
			String[] mnrDispTrfTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] mnrDispTrfDtlSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_dtl_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] mnrDispTrfStsCd = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_sts_cd", length));
			String[] mnrDispTrfGrpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_grp_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnrDispTrfStsNm = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_sts_nm", length));
			String[] mnrDispTrfAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_amt", length));
			String[] dtlRmk = (JSPUtil.getParameter(request, prefix	+ "dtl_rmk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrDispTrfDtlVO();
				if (tempSeq[i] != null)
					model.setTempSeq(tempSeq[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mnrVrfyTpCd[i] != null)
					model.setMnrVrfyTpCd(mnrVrfyTpCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (mnrDispTrfSeq[i] != null)
					model.setMnrDispTrfSeq(mnrDispTrfSeq[i]);
				if (mnrDispTrfTpCd[i] != null)
					model.setMnrDispTrfTpCd(mnrDispTrfTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (mnrDispTrfDtlSeq[i] != null)
					model.setMnrDispTrfDtlSeq(mnrDispTrfDtlSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (mnrDispTrfStsCd[i] != null)
					model.setMnrDispTrfStsCd(mnrDispTrfStsCd[i]);
				if (mnrDispTrfGrpCd[i] != null)
					model.setMnrDispTrfGrpCd(mnrDispTrfGrpCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnrDispTrfStsNm[i] != null)
					model.setMnrDispTrfStsNm(mnrDispTrfStsNm[i]);
				if (mnrDispTrfAmt[i] != null)
					model.setMnrDispTrfAmt(mnrDispTrfAmt[i]);
				if (dtlRmk[i] != null)
					model.setDtlRmk(dtlRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrDispTrfDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrDispTrfDtlVO[]
	 */
	public CustomMnrDispTrfDtlVO[] getCustomMnrDispTrfDtlVOs(){
		CustomMnrDispTrfDtlVO[] vos = (CustomMnrDispTrfDtlVO[])models.toArray(new CustomMnrDispTrfDtlVO[models.size()]);
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
		this.tempSeq = this.tempSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrVrfyTpCd = this.mnrVrfyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfSeq = this.mnrDispTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfTpCd = this.mnrDispTrfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfDtlSeq = this.mnrDispTrfDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfStsCd = this.mnrDispTrfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfGrpCd = this.mnrDispTrfGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfStsNm = this.mnrDispTrfStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfAmt = this.mnrDispTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlRmk = this.dtlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
