/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomMnrGenCdVO.java
*@FileTitle : CustomMnrGenCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.10.12 김완규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrGenCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrGenCdVO> models = new ArrayList<CustomMnrGenCdVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mnrCdDesc = null;
	/* Column Info */
	private String mnrCdDpSeq = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String mnrOrdTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String pairDpSeq = null;
	/* Column Info */
	private String mnrCdDfltPntNo = null;
	/* Column Info */
	private String mnrCdSeq = null;
	/* Column Info */
	private String mnrCdId = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrCdGrpNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnrCdDpDesc = null;
	/* Column Info */
	private String pairCdDpDesc = null;
	/* Column Info */
	private String pairRefCd = null;
	/* Column Info */
	private String mnrCdGrpTpCd = null;
	/* Column Info */
	private String prntCdId = null;
	/* Column Info */
	private String pairCdId = null;
	/* Column Info */
	private String pairCdDesc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String agmtUseFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrGenCdVO() {}

	public CustomMnrGenCdVO(String ibflag, String pagerows, String mnrCdSeq, String eqKndCd, String mnrCdId, String prntCdId, String mnrCdDpDesc, String mnrCdDesc, String mnrCdDpSeq, String pairCdId, String pairCdDpDesc, String pairCdDesc, String pairRefCd, String pairDpSeq, String mnrCdGrpNo, String mnrCdGrpTpCd, String agmtUseFlg, String deltFlg, String mnrCdDfltPntNo, String mnrOrdTpCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.mnrCdDesc = mnrCdDesc;
		this.mnrCdDpSeq = mnrCdDpSeq;
		this.deltFlg = deltFlg;
		this.mnrOrdTpCd = mnrOrdTpCd;
		this.creDt = creDt;
		this.pairDpSeq = pairDpSeq;
		this.mnrCdDfltPntNo = mnrCdDfltPntNo;
		this.mnrCdSeq = mnrCdSeq;
		this.mnrCdId = mnrCdId;
		this.eqKndCd = eqKndCd;
		this.pagerows = pagerows;
		this.mnrCdGrpNo = mnrCdGrpNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.mnrCdDpDesc = mnrCdDpDesc;
		this.pairCdDpDesc = pairCdDpDesc;
		this.pairRefCd = pairRefCd;
		this.mnrCdGrpTpCd = mnrCdGrpTpCd;
		this.prntCdId = prntCdId;
		this.pairCdId = pairCdId;
		this.pairCdDesc = pairCdDesc;
		this.updUsrId = updUsrId;
		this.agmtUseFlg = agmtUseFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mnr_cd_desc", getMnrCdDesc());
		this.hashColumns.put("mnr_cd_dp_seq", getMnrCdDpSeq());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("mnr_ord_tp_cd", getMnrOrdTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pair_dp_seq", getPairDpSeq());
		this.hashColumns.put("mnr_cd_dflt_pnt_no", getMnrCdDfltPntNo());
		this.hashColumns.put("mnr_cd_seq", getMnrCdSeq());
		this.hashColumns.put("mnr_cd_id", getMnrCdId());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_cd_grp_no", getMnrCdGrpNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnr_cd_dp_desc", getMnrCdDpDesc());
		this.hashColumns.put("pair_cd_dp_desc", getPairCdDpDesc());
		this.hashColumns.put("pair_ref_cd", getPairRefCd());
		this.hashColumns.put("mnr_cd_grp_tp_cd", getMnrCdGrpTpCd());
		this.hashColumns.put("prnt_cd_id", getPrntCdId());
		this.hashColumns.put("pair_cd_id", getPairCdId());
		this.hashColumns.put("pair_cd_desc", getPairCdDesc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("agmt_use_flg", getAgmtUseFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mnr_cd_desc", "mnrCdDesc");
		this.hashFields.put("mnr_cd_dp_seq", "mnrCdDpSeq");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("mnr_ord_tp_cd", "mnrOrdTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pair_dp_seq", "pairDpSeq");
		this.hashFields.put("mnr_cd_dflt_pnt_no", "mnrCdDfltPntNo");
		this.hashFields.put("mnr_cd_seq", "mnrCdSeq");
		this.hashFields.put("mnr_cd_id", "mnrCdId");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_cd_grp_no", "mnrCdGrpNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_cd_dp_desc", "mnrCdDpDesc");
		this.hashFields.put("pair_cd_dp_desc", "pairCdDpDesc");
		this.hashFields.put("pair_ref_cd", "pairRefCd");
		this.hashFields.put("mnr_cd_grp_tp_cd", "mnrCdGrpTpCd");
		this.hashFields.put("prnt_cd_id", "prntCdId");
		this.hashFields.put("pair_cd_id", "pairCdId");
		this.hashFields.put("pair_cd_desc", "pairCdDesc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("agmt_use_flg", "agmtUseFlg");
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
	 * @return mnrCdDesc
	 */
	public String getMnrCdDesc() {
		return this.mnrCdDesc;
	}
	
	/**
	 * Column Info
	 * @return mnrCdDpSeq
	 */
	public String getMnrCdDpSeq() {
		return this.mnrCdDpSeq;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return mnrOrdTpCd
	 */
	public String getMnrOrdTpCd() {
		return this.mnrOrdTpCd;
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
	 * @return pairDpSeq
	 */
	public String getPairDpSeq() {
		return this.pairDpSeq;
	}
	
	/**
	 * Column Info
	 * @return mnrCdDfltPntNo
	 */
	public String getMnrCdDfltPntNo() {
		return this.mnrCdDfltPntNo;
	}
	
	/**
	 * Column Info
	 * @return mnrCdSeq
	 */
	public String getMnrCdSeq() {
		return this.mnrCdSeq;
	}
	
	/**
	 * Column Info
	 * @return mnrCdId
	 */
	public String getMnrCdId() {
		return this.mnrCdId;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @return mnrCdGrpNo
	 */
	public String getMnrCdGrpNo() {
		return this.mnrCdGrpNo;
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
	 * @return mnrCdDpDesc
	 */
	public String getMnrCdDpDesc() {
		return this.mnrCdDpDesc;
	}
	
	/**
	 * Column Info
	 * @return pairCdDpDesc
	 */
	public String getPairCdDpDesc() {
		return this.pairCdDpDesc;
	}
	
	/**
	 * Column Info
	 * @return pairRefCd
	 */
	public String getPairRefCd() {
		return this.pairRefCd;
	}
	
	/**
	 * Column Info
	 * @return mnrCdGrpTpCd
	 */
	public String getMnrCdGrpTpCd() {
		return this.mnrCdGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return prntCdId
	 */
	public String getPrntCdId() {
		return this.prntCdId;
	}
	
	/**
	 * Column Info
	 * @return pairCdId
	 */
	public String getPairCdId() {
		return this.pairCdId;
	}
	
	/**
	 * Column Info
	 * @return pairCdDesc
	 */
	public String getPairCdDesc() {
		return this.pairCdDesc;
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
	 * @return agmtUseFlg
	 */
	public String getAgmtUseFlg() {
		return this.agmtUseFlg;
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
	 * @param mnrCdDesc
	 */
	public void setMnrCdDesc(String mnrCdDesc) {
		this.mnrCdDesc = mnrCdDesc;
	}
	
	/**
	 * Column Info
	 * @param mnrCdDpSeq
	 */
	public void setMnrCdDpSeq(String mnrCdDpSeq) {
		this.mnrCdDpSeq = mnrCdDpSeq;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param mnrOrdTpCd
	 */
	public void setMnrOrdTpCd(String mnrOrdTpCd) {
		this.mnrOrdTpCd = mnrOrdTpCd;
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
	 * @param pairDpSeq
	 */
	public void setPairDpSeq(String pairDpSeq) {
		this.pairDpSeq = pairDpSeq;
	}
	
	/**
	 * Column Info
	 * @param mnrCdDfltPntNo
	 */
	public void setMnrCdDfltPntNo(String mnrCdDfltPntNo) {
		this.mnrCdDfltPntNo = mnrCdDfltPntNo;
	}
	
	/**
	 * Column Info
	 * @param mnrCdSeq
	 */
	public void setMnrCdSeq(String mnrCdSeq) {
		this.mnrCdSeq = mnrCdSeq;
	}
	
	/**
	 * Column Info
	 * @param mnrCdId
	 */
	public void setMnrCdId(String mnrCdId) {
		this.mnrCdId = mnrCdId;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
	 * @param mnrCdGrpNo
	 */
	public void setMnrCdGrpNo(String mnrCdGrpNo) {
		this.mnrCdGrpNo = mnrCdGrpNo;
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
	 * @param mnrCdDpDesc
	 */
	public void setMnrCdDpDesc(String mnrCdDpDesc) {
		this.mnrCdDpDesc = mnrCdDpDesc;
	}
	
	/**
	 * Column Info
	 * @param pairCdDpDesc
	 */
	public void setPairCdDpDesc(String pairCdDpDesc) {
		this.pairCdDpDesc = pairCdDpDesc;
	}
	
	/**
	 * Column Info
	 * @param pairRefCd
	 */
	public void setPairRefCd(String pairRefCd) {
		this.pairRefCd = pairRefCd;
	}
	
	/**
	 * Column Info
	 * @param mnrCdGrpTpCd
	 */
	public void setMnrCdGrpTpCd(String mnrCdGrpTpCd) {
		this.mnrCdGrpTpCd = mnrCdGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param prntCdId
	 */
	public void setPrntCdId(String prntCdId) {
		this.prntCdId = prntCdId;
	}
	
	/**
	 * Column Info
	 * @param pairCdId
	 */
	public void setPairCdId(String pairCdId) {
		this.pairCdId = pairCdId;
	}
	
	/**
	 * Column Info
	 * @param pairCdDesc
	 */
	public void setPairCdDesc(String pairCdDesc) {
		this.pairCdDesc = pairCdDesc;
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
	 * @param agmtUseFlg
	 */
	public void setAgmtUseFlg(String agmtUseFlg) {
		this.agmtUseFlg = agmtUseFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setMnrCdDesc(JSPUtil.getParameter(request, "mnr_cd_desc", ""));
		setMnrCdDpSeq(JSPUtil.getParameter(request, "mnr_cd_dp_seq", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setMnrOrdTpCd(JSPUtil.getParameter(request, "mnr_ord_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPairDpSeq(JSPUtil.getParameter(request, "pair_dp_seq", ""));
		setMnrCdDfltPntNo(JSPUtil.getParameter(request, "mnr_cd_dflt_pnt_no", ""));
		setMnrCdSeq(JSPUtil.getParameter(request, "mnr_cd_seq", ""));
		setMnrCdId(JSPUtil.getParameter(request, "mnr_cd_id", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMnrCdGrpNo(JSPUtil.getParameter(request, "mnr_cd_grp_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMnrCdDpDesc(JSPUtil.getParameter(request, "mnr_cd_dp_desc", ""));
		setPairCdDpDesc(JSPUtil.getParameter(request, "pair_cd_dp_desc", ""));
		setPairRefCd(JSPUtil.getParameter(request, "pair_ref_cd", ""));
		setMnrCdGrpTpCd(JSPUtil.getParameter(request, "mnr_cd_grp_tp_cd", ""));
		setPrntCdId(JSPUtil.getParameter(request, "prnt_cd_id", ""));
		setPairCdId(JSPUtil.getParameter(request, "pair_cd_id", ""));
		setPairCdDesc(JSPUtil.getParameter(request, "pair_cd_desc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setAgmtUseFlg(JSPUtil.getParameter(request, "agmt_use_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrGenCdVO[]
	 */
	public CustomMnrGenCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrGenCdVO[]
	 */
	public CustomMnrGenCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrGenCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mnrCdDesc = (JSPUtil.getParameter(request, prefix	+ "mnr_cd_desc", length));
			String[] mnrCdDpSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_cd_dp_seq", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] mnrOrdTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pairDpSeq = (JSPUtil.getParameter(request, prefix	+ "pair_dp_seq", length));
			String[] mnrCdDfltPntNo = (JSPUtil.getParameter(request, prefix	+ "mnr_cd_dflt_pnt_no", length));
			String[] mnrCdSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_cd_seq", length));
			String[] mnrCdId = (JSPUtil.getParameter(request, prefix	+ "mnr_cd_id", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrCdGrpNo = (JSPUtil.getParameter(request, prefix	+ "mnr_cd_grp_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnrCdDpDesc = (JSPUtil.getParameter(request, prefix	+ "mnr_cd_dp_desc", length));
			String[] pairCdDpDesc = (JSPUtil.getParameter(request, prefix	+ "pair_cd_dp_desc", length));
			String[] pairRefCd = (JSPUtil.getParameter(request, prefix	+ "pair_ref_cd", length));
			String[] mnrCdGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_cd_grp_tp_cd", length));
			String[] prntCdId = (JSPUtil.getParameter(request, prefix	+ "prnt_cd_id", length));
			String[] pairCdId = (JSPUtil.getParameter(request, prefix	+ "pair_cd_id", length));
			String[] pairCdDesc = (JSPUtil.getParameter(request, prefix	+ "pair_cd_desc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] agmtUseFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_use_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrGenCdVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mnrCdDesc[i] != null)
					model.setMnrCdDesc(mnrCdDesc[i]);
				if (mnrCdDpSeq[i] != null)
					model.setMnrCdDpSeq(mnrCdDpSeq[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (mnrOrdTpCd[i] != null)
					model.setMnrOrdTpCd(mnrOrdTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pairDpSeq[i] != null)
					model.setPairDpSeq(pairDpSeq[i]);
				if (mnrCdDfltPntNo[i] != null)
					model.setMnrCdDfltPntNo(mnrCdDfltPntNo[i]);
				if (mnrCdSeq[i] != null)
					model.setMnrCdSeq(mnrCdSeq[i]);
				if (mnrCdId[i] != null)
					model.setMnrCdId(mnrCdId[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrCdGrpNo[i] != null)
					model.setMnrCdGrpNo(mnrCdGrpNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnrCdDpDesc[i] != null)
					model.setMnrCdDpDesc(mnrCdDpDesc[i]);
				if (pairCdDpDesc[i] != null)
					model.setPairCdDpDesc(pairCdDpDesc[i]);
				if (pairRefCd[i] != null)
					model.setPairRefCd(pairRefCd[i]);
				if (mnrCdGrpTpCd[i] != null)
					model.setMnrCdGrpTpCd(mnrCdGrpTpCd[i]);
				if (prntCdId[i] != null)
					model.setPrntCdId(prntCdId[i]);
				if (pairCdId[i] != null)
					model.setPairCdId(pairCdId[i]);
				if (pairCdDesc[i] != null)
					model.setPairCdDesc(pairCdDesc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (agmtUseFlg[i] != null)
					model.setAgmtUseFlg(agmtUseFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrGenCdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrGenCdVO[]
	 */
	public CustomMnrGenCdVO[] getCustomMnrGenCdVOs(){
		CustomMnrGenCdVO[] vos = (CustomMnrGenCdVO[])models.toArray(new CustomMnrGenCdVO[models.size()]);
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
		this.mnrCdDesc = this.mnrCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrCdDpSeq = this.mnrCdDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdTpCd = this.mnrOrdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pairDpSeq = this.pairDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrCdDfltPntNo = this.mnrCdDfltPntNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrCdSeq = this.mnrCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrCdId = this.mnrCdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrCdGrpNo = this.mnrCdGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrCdDpDesc = this.mnrCdDpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pairCdDpDesc = this.pairCdDpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pairRefCd = this.pairRefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrCdGrpTpCd = this.mnrCdGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntCdId = this.prntCdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pairCdId = this.pairCdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pairCdDesc = this.pairCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtUseFlg = this.agmtUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
