/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomMnrDispBuyrDtlPartVO.java
*@FileTitle : CustomMnrDispBuyrDtlPartVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.11.13 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo;
 
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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrDispBuyrDtlPartVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrDispBuyrDtlPartVO> models = new ArrayList<CustomMnrDispBuyrDtlPartVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String partUtAmt = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String mnrDispCfmStsCd = null;
	/* Column Info */
	private String mnrDispDtlRmk = null;
	/* Column Info */
	private String confirmSt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mnrPrnrCntCd = null;
	/* Column Info */
	private String dispQty = null;
	/* Column Info */
	private String dispCfmQty = null;
	/* Column Info */
	private String dispDtlSeq = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrPrnrSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dispUtTpCd = null;
	/* Column Info */
	private String mnrDispCfmUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mnrPrnrId = null;
	/* Column Info */
	private String mnrDispCfmDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomMnrDispBuyrDtlPartVO() {}

	public CustomMnrDispBuyrDtlPartVO(String ibflag, String pagerows, String updDt, String partUtAmt, String dispNo, String mnrDispCfmStsCd, String mnrDispDtlRmk, String confirmSt, String vndrLglEngNm, String creDt, String mnrPrnrCntCd, String dispQty, String dispCfmQty, String dispDtlSeq, String mnrPrnrSeq, String creUsrId, String dispUtTpCd, String mnrDispCfmUsrId, String updUsrId, String mnrDispCfmDt, String mnrPrnrId, String eqTpszCd) {
		this.updDt = updDt;
		this.partUtAmt = partUtAmt;
		this.dispNo = dispNo;
		this.mnrDispCfmStsCd = mnrDispCfmStsCd;
		this.mnrDispDtlRmk = mnrDispDtlRmk;
		this.confirmSt = confirmSt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.creDt = creDt;
		this.mnrPrnrCntCd = mnrPrnrCntCd;
		this.dispQty = dispQty;
		this.dispCfmQty = dispCfmQty;
		this.dispDtlSeq = dispDtlSeq;
		this.eqTpszCd = eqTpszCd;
		this.pagerows = pagerows;
		this.mnrPrnrSeq = mnrPrnrSeq;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.dispUtTpCd = dispUtTpCd;
		this.mnrDispCfmUsrId = mnrDispCfmUsrId;
		this.updUsrId = updUsrId;
		this.mnrPrnrId = mnrPrnrId;
		this.mnrDispCfmDt = mnrDispCfmDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("part_ut_amt", getPartUtAmt());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("mnr_disp_cfm_sts_cd", getMnrDispCfmStsCd());
		this.hashColumns.put("mnr_disp_dtl_rmk", getMnrDispDtlRmk());
		this.hashColumns.put("confirm_st", getConfirmSt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mnr_prnr_cnt_cd", getMnrPrnrCntCd());
		this.hashColumns.put("disp_qty", getDispQty());
		this.hashColumns.put("disp_cfm_qty", getDispCfmQty());
		this.hashColumns.put("disp_dtl_seq", getDispDtlSeq());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_prnr_seq", getMnrPrnrSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("disp_ut_tp_cd", getDispUtTpCd());
		this.hashColumns.put("mnr_disp_cfm_usr_id", getMnrDispCfmUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mnr_prnr_id", getMnrPrnrId());
		this.hashColumns.put("mnr_disp_cfm_dt", getMnrDispCfmDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("part_ut_amt", "partUtAmt");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("mnr_disp_cfm_sts_cd", "mnrDispCfmStsCd");
		this.hashFields.put("mnr_disp_dtl_rmk", "mnrDispDtlRmk");
		this.hashFields.put("confirm_st", "confirmSt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mnr_prnr_cnt_cd", "mnrPrnrCntCd");
		this.hashFields.put("disp_qty", "dispQty");
		this.hashFields.put("disp_cfm_qty", "dispCfmQty");
		this.hashFields.put("disp_dtl_seq", "dispDtlSeq");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_prnr_seq", "mnrPrnrSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("disp_ut_tp_cd", "dispUtTpCd");
		this.hashFields.put("mnr_disp_cfm_usr_id", "mnrDispCfmUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mnr_prnr_id", "mnrPrnrId");
		this.hashFields.put("mnr_disp_cfm_dt", "mnrDispCfmDt");
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
	 * @return partUtAmt
	 */
	public String getPartUtAmt() {
		return this.partUtAmt;
	}
	
	/**
	 * Column Info
	 * @return dispNo
	 */
	public String getDispNo() {
		return this.dispNo;
	}
	
	/**
	 * Column Info
	 * @return mnrDispCfmStsCd
	 */
	public String getMnrDispCfmStsCd() {
		return this.mnrDispCfmStsCd;
	}
	
	/**
	 * Column Info
	 * @return mnrDispDtlRmk
	 */
	public String getMnrDispDtlRmk() {
		return this.mnrDispDtlRmk;
	}
	
	/**
	 * Column Info
	 * @return confirmSt
	 */
	public String getConfirmSt() {
		return this.confirmSt;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
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
	 * @return mnrPrnrCntCd
	 */
	public String getMnrPrnrCntCd() {
		return this.mnrPrnrCntCd;
	}
	
	/**
	 * Column Info
	 * @return dispQty
	 */
	public String getDispQty() {
		return this.dispQty;
	}
	
	/**
	 * Column Info
	 * @return dispCfmQty
	 */
	public String getDispCfmQty() {
		return this.dispCfmQty;
	}
	
	/**
	 * Column Info
	 * @return dispDtlSeq
	 */
	public String getDispDtlSeq() {
		return this.dispDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @return mnrPrnrSeq
	 */
	public String getMnrPrnrSeq() {
		return this.mnrPrnrSeq;
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
	 * @return dispUtTpCd
	 */
	public String getDispUtTpCd() {
		return this.dispUtTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnrDispCfmUsrId
	 */
	public String getMnrDispCfmUsrId() {
		return this.mnrDispCfmUsrId;
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
	 * @return mnrPrnrId
	 */
	public String getMnrPrnrId() {
		return this.mnrPrnrId;
	}
	
	/**
	 * Column Info
	 * @return mnrDispCfmDt
	 */
	public String getMnrDispCfmDt() {
		return this.mnrDispCfmDt;
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
	 * @param partUtAmt
	 */
	public void setPartUtAmt(String partUtAmt) {
		this.partUtAmt = partUtAmt;
	}
	
	/**
	 * Column Info
	 * @param dispNo
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}
	
	/**
	 * Column Info
	 * @param mnrDispCfmStsCd
	 */
	public void setMnrDispCfmStsCd(String mnrDispCfmStsCd) {
		this.mnrDispCfmStsCd = mnrDispCfmStsCd;
	}
	
	/**
	 * Column Info
	 * @param mnrDispDtlRmk
	 */
	public void setMnrDispDtlRmk(String mnrDispDtlRmk) {
		this.mnrDispDtlRmk = mnrDispDtlRmk;
	}
	
	/**
	 * Column Info
	 * @param confirmSt
	 */
	public void setConfirmSt(String confirmSt) {
		this.confirmSt = confirmSt;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
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
	 * @param mnrPrnrCntCd
	 */
	public void setMnrPrnrCntCd(String mnrPrnrCntCd) {
		this.mnrPrnrCntCd = mnrPrnrCntCd;
	}
	
	/**
	 * Column Info
	 * @param dispQty
	 */
	public void setDispQty(String dispQty) {
		this.dispQty = dispQty;
	}
	
	/**
	 * Column Info
	 * @param dispCfmQty
	 */
	public void setDispCfmQty(String dispCfmQty) {
		this.dispCfmQty = dispCfmQty;
	}
	
	/**
	 * Column Info
	 * @param dispDtlSeq
	 */
	public void setDispDtlSeq(String dispDtlSeq) {
		this.dispDtlSeq = dispDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
	 * @param mnrPrnrSeq
	 */
	public void setMnrPrnrSeq(String mnrPrnrSeq) {
		this.mnrPrnrSeq = mnrPrnrSeq;
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
	 * @param dispUtTpCd
	 */
	public void setDispUtTpCd(String dispUtTpCd) {
		this.dispUtTpCd = dispUtTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnrDispCfmUsrId
	 */
	public void setMnrDispCfmUsrId(String mnrDispCfmUsrId) {
		this.mnrDispCfmUsrId = mnrDispCfmUsrId;
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
	 * @param mnrPrnrId
	 */
	public void setMnrPrnrId(String mnrPrnrId) {
		this.mnrPrnrId = mnrPrnrId;
	}
	
	/**
	 * Column Info
	 * @param mnrDispCfmDt
	 */
	public void setMnrDispCfmDt(String mnrDispCfmDt) {
		this.mnrDispCfmDt = mnrDispCfmDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setPartUtAmt(JSPUtil.getParameter(request, "part_ut_amt", ""));
		setDispNo(JSPUtil.getParameter(request, "disp_no", ""));
		setMnrDispCfmStsCd(JSPUtil.getParameter(request, "mnr_disp_cfm_sts_cd", ""));
		setMnrDispDtlRmk(JSPUtil.getParameter(request, "mnr_disp_dtl_rmk", ""));
		setConfirmSt(JSPUtil.getParameter(request, "confirm_st", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setMnrPrnrCntCd(JSPUtil.getParameter(request, "mnr_prnr_cnt_cd", ""));
		setDispQty(JSPUtil.getParameter(request, "disp_qty", ""));
		setDispCfmQty(JSPUtil.getParameter(request, "disp_cfm_qty", ""));
		setDispDtlSeq(JSPUtil.getParameter(request, "disp_dtl_seq", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMnrPrnrSeq(JSPUtil.getParameter(request, "mnr_prnr_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDispUtTpCd(JSPUtil.getParameter(request, "disp_ut_tp_cd", ""));
		setMnrDispCfmUsrId(JSPUtil.getParameter(request, "mnr_disp_cfm_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setMnrPrnrId(JSPUtil.getParameter(request, "mnr_prnr_id", ""));
		setMnrDispCfmDt(JSPUtil.getParameter(request, "mnr_disp_cfm_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrDispBuyrDtlPartVO[]
	 */
	public CustomMnrDispBuyrDtlPartVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrDispBuyrDtlPartVO[]
	 */
	public CustomMnrDispBuyrDtlPartVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrDispBuyrDtlPartVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] partUtAmt = (JSPUtil.getParameter(request, prefix	+ "part_ut_amt", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] mnrDispCfmStsCd = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_cfm_sts_cd", length));
			String[] mnrDispDtlRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_dtl_rmk", length));
			String[] confirmSt = (JSPUtil.getParameter(request, prefix	+ "confirm_st", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mnrPrnrCntCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_cnt_cd", length));
			String[] dispQty = (JSPUtil.getParameter(request, prefix	+ "disp_qty", length));
			String[] dispCfmQty = (JSPUtil.getParameter(request, prefix	+ "disp_cfm_qty", length));
			String[] dispDtlSeq = (JSPUtil.getParameter(request, prefix	+ "disp_dtl_seq", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrPrnrSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dispUtTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_ut_tp_cd", length));
			String[] mnrDispCfmUsrId = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_cfm_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mnrPrnrId = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_id", length));
			String[] mnrDispCfmDt = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_cfm_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrDispBuyrDtlPartVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (partUtAmt[i] != null)
					model.setPartUtAmt(partUtAmt[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (mnrDispCfmStsCd[i] != null)
					model.setMnrDispCfmStsCd(mnrDispCfmStsCd[i]);
				if (mnrDispDtlRmk[i] != null)
					model.setMnrDispDtlRmk(mnrDispDtlRmk[i]);
				if (confirmSt[i] != null)
					model.setConfirmSt(confirmSt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mnrPrnrCntCd[i] != null)
					model.setMnrPrnrCntCd(mnrPrnrCntCd[i]);
				if (dispQty[i] != null)
					model.setDispQty(dispQty[i]);
				if (dispCfmQty[i] != null)
					model.setDispCfmQty(dispCfmQty[i]);
				if (dispDtlSeq[i] != null)
					model.setDispDtlSeq(dispDtlSeq[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrPrnrSeq[i] != null)
					model.setMnrPrnrSeq(mnrPrnrSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dispUtTpCd[i] != null)
					model.setDispUtTpCd(dispUtTpCd[i]);
				if (mnrDispCfmUsrId[i] != null)
					model.setMnrDispCfmUsrId(mnrDispCfmUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mnrPrnrId[i] != null)
					model.setMnrPrnrId(mnrPrnrId[i]);
				if (mnrDispCfmDt[i] != null)
					model.setMnrDispCfmDt(mnrDispCfmDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrDispBuyrDtlPartVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrDispBuyrDtlPartVO[]
	 */
	public CustomMnrDispBuyrDtlPartVO[] getCustomMnrDispBuyrDtlPartVOs(){
		CustomMnrDispBuyrDtlPartVO[] vos = (CustomMnrDispBuyrDtlPartVO[])models.toArray(new CustomMnrDispBuyrDtlPartVO[models.size()]);
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
		this.partUtAmt = this.partUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispCfmStsCd = this.mnrDispCfmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispDtlRmk = this.mnrDispDtlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.confirmSt = this.confirmSt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrCntCd = this.mnrPrnrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispQty = this.dispQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispCfmQty = this.dispCfmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispDtlSeq = this.dispDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrSeq = this.mnrPrnrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispUtTpCd = this.dispUtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispCfmUsrId = this.mnrDispCfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrId = this.mnrPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispCfmDt = this.mnrDispCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
