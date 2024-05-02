/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CombinedVO.java
*@FileTitle : CombinedVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.09.01 박희동 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CombinedVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CombinedVO> models = new ArrayList<CombinedVO>();
	
	/* Column Info */
	private String stlSeq = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String rVvd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String rBsaQty = null;
	/* Column Info */
	private String joStlItmCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String eStlLoclAmt = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String rStlLoclAmt = null;
	/* Column Info */
	private String joStlJbCd = null;
	/* Column Info */
	private String eVvd = null;
	/* Column Info */
	private String cmbCfmFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String eBsaSltPrc = null;
	/* Column Info */
	private String eBsaQty = null;
	/* Column Info */
	private String rBsaSltPrc = null;
	/* Column Info */
	private String stlVvdSeq = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String csrNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CombinedVO() {}

	public CombinedVO(String ibflag, String pagerows, String acctYrmon, String joCrrCd, String rlaneCd, String reDivrCd, String stlVvdSeq, String stlSeq, String joStlItmCd, String joStlJbCd, String loclCurrCd, String cmbCfmFlg, String updUsrId, String rVvd, String rBsaQty, String rBsaSltPrc, String rStlLoclAmt, String eVvd, String eBsaQty, String eBsaSltPrc, String eStlLoclAmt, String remark, String csrNo) {
		this.stlSeq = stlSeq;
		this.loclCurrCd = loclCurrCd;
		this.joCrrCd = joCrrCd;
		this.rVvd = rVvd;
		this.rlaneCd = rlaneCd;
		this.rBsaQty = rBsaQty;
		this.joStlItmCd = joStlItmCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.acctYrmon = acctYrmon;
		this.eStlLoclAmt = eStlLoclAmt;
		this.reDivrCd = reDivrCd;
		this.rStlLoclAmt = rStlLoclAmt;
		this.joStlJbCd = joStlJbCd;
		this.eVvd = eVvd;
		this.cmbCfmFlg = cmbCfmFlg;
		this.updUsrId = updUsrId;
		this.eBsaSltPrc = eBsaSltPrc;
		this.eBsaQty = eBsaQty;
		this.rBsaSltPrc = rBsaSltPrc;
		this.stlVvdSeq = stlVvdSeq;
		this.remark = remark;
		this.csrNo = csrNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("stl_seq", getStlSeq());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("r_vvd", getRVvd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("r_bsa_qty", getRBsaQty());
		this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("e_stl_locl_amt", getEStlLoclAmt());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("r_stl_locl_amt", getRStlLoclAmt());
		this.hashColumns.put("jo_stl_jb_cd", getJoStlJbCd());
		this.hashColumns.put("e_vvd", getEVvd());
		this.hashColumns.put("cmb_cfm_flg", getCmbCfmFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("e_bsa_slt_prc", getEBsaSltPrc());
		this.hashColumns.put("e_bsa_qty", getEBsaQty());
		this.hashColumns.put("r_bsa_slt_prc", getRBsaSltPrc());
		this.hashColumns.put("stl_vvd_seq", getStlVvdSeq());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("csr_no", getCsrNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("stl_seq", "stlSeq");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("r_vvd", "rVvd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("r_bsa_qty", "rBsaQty");
		this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("e_stl_locl_amt", "eStlLoclAmt");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("r_stl_locl_amt", "rStlLoclAmt");
		this.hashFields.put("jo_stl_jb_cd", "joStlJbCd");
		this.hashFields.put("e_vvd", "eVvd");
		this.hashFields.put("cmb_cfm_flg", "cmbCfmFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("e_bsa_slt_prc", "eBsaSltPrc");
		this.hashFields.put("e_bsa_qty", "eBsaQty");
		this.hashFields.put("r_bsa_slt_prc", "rBsaSltPrc");
		this.hashFields.put("stl_vvd_seq", "stlVvdSeq");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("csr_no", "csrNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return stlSeq
	 */
	public String getStlSeq() {
		return this.stlSeq;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return rVvd
	 */
	public String getRVvd() {
		return this.rVvd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return rBsaQty
	 */
	public String getRBsaQty() {
		return this.rBsaQty;
	}
	
	/**
	 * Column Info
	 * @return joStlItmCd
	 */
	public String getJoStlItmCd() {
		return this.joStlItmCd;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return acctYrmon
	 */
	public String getAcctYrmon() {
		return this.acctYrmon;
	}
	
	/**
	 * Column Info
	 * @return eStlLoclAmt
	 */
	public String getEStlLoclAmt() {
		return this.eStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return rStlLoclAmt
	 */
	public String getRStlLoclAmt() {
		return this.rStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return joStlJbCd
	 */
	public String getJoStlJbCd() {
		return this.joStlJbCd;
	}
	
	/**
	 * Column Info
	 * @return eVvd
	 */
	public String getEVvd() {
		return this.eVvd;
	}
	
	/**
	 * Column Info
	 * @return cmbCfmFlg
	 */
	public String getCmbCfmFlg() {
		return this.cmbCfmFlg;
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
	 * @return eBsaSltPrc
	 */
	public String getEBsaSltPrc() {
		return this.eBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @return eBsaQty
	 */
	public String getEBsaQty() {
		return this.eBsaQty;
	}
	
	/**
	 * Column Info
	 * @return rBsaSltPrc
	 */
	public String getRBsaSltPrc() {
		return this.rBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @return stlVvdSeq
	 */
	public String getStlVvdSeq() {
		return this.stlVvdSeq;
	}

	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}

	/**
	 * Column Info
	 * @param stlSeq
	 */
	public void setStlSeq(String stlSeq) {
		this.stlSeq = stlSeq;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param rVvd
	 */
	public void setRVvd(String rVvd) {
		this.rVvd = rVvd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param rBsaQty
	 */
	public void setRBsaQty(String rBsaQty) {
		this.rBsaQty = rBsaQty;
	}
	
	/**
	 * Column Info
	 * @param joStlItmCd
	 */
	public void setJoStlItmCd(String joStlItmCd) {
		this.joStlItmCd = joStlItmCd;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param acctYrmon
	 */
	public void setAcctYrmon(String acctYrmon) {
		this.acctYrmon = acctYrmon;
	}
	
	/**
	 * Column Info
	 * @param eStlLoclAmt
	 */
	public void setEStlLoclAmt(String eStlLoclAmt) {
		this.eStlLoclAmt = eStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param rStlLoclAmt
	 */
	public void setRStlLoclAmt(String rStlLoclAmt) {
		this.rStlLoclAmt = rStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param joStlJbCd
	 */
	public void setJoStlJbCd(String joStlJbCd) {
		this.joStlJbCd = joStlJbCd;
	}
	
	/**
	 * Column Info
	 * @param eVvd
	 */
	public void setEVvd(String eVvd) {
		this.eVvd = eVvd;
	}
	
	/**
	 * Column Info
	 * @param cmbCfmFlg
	 */
	public void setCmbCfmFlg(String cmbCfmFlg) {
		this.cmbCfmFlg = cmbCfmFlg;
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
	 * @param eBsaSltPrc
	 */
	public void setEBsaSltPrc(String eBsaSltPrc) {
		this.eBsaSltPrc = eBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @param eBsaQty
	 */
	public void setEBsaQty(String eBsaQty) {
		this.eBsaQty = eBsaQty;
	}
	
	/**
	 * Column Info
	 * @param rBsaSltPrc
	 */
	public void setRBsaSltPrc(String rBsaSltPrc) {
		this.rBsaSltPrc = rBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @param stlVvdSeq
	 */
	public void setStlVvdSeq(String stlVvdSeq) {
		this.stlVvdSeq = stlVvdSeq;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setStlSeq(JSPUtil.getParameter(request, "stl_seq", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
		setRVvd(JSPUtil.getParameter(request, "r_vvd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setRBsaQty(JSPUtil.getParameter(request, "r_bsa_qty", ""));
		setJoStlItmCd(JSPUtil.getParameter(request, "jo_stl_itm_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAcctYrmon(JSPUtil.getParameter(request, "acct_yrmon", ""));
		setEStlLoclAmt(JSPUtil.getParameter(request, "e_stl_locl_amt", ""));
		setReDivrCd(JSPUtil.getParameter(request, "re_divr_cd", ""));
		setRStlLoclAmt(JSPUtil.getParameter(request, "r_stl_locl_amt", ""));
		setJoStlJbCd(JSPUtil.getParameter(request, "jo_stl_jb_cd", ""));
		setEVvd(JSPUtil.getParameter(request, "e_vvd", ""));
		setCmbCfmFlg(JSPUtil.getParameter(request, "cmb_cfm_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setEBsaSltPrc(JSPUtil.getParameter(request, "e_bsa_slt_prc", ""));
		setEBsaQty(JSPUtil.getParameter(request, "e_bsa_qty", ""));
		setRBsaSltPrc(JSPUtil.getParameter(request, "r_bsa_slt_prc", ""));
		setStlVvdSeq(JSPUtil.getParameter(request, "stl_vvd_seq", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CombinedVO[]
	 */
	public CombinedVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CombinedVO[]
	 */
	public CombinedVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CombinedVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] stlSeq = (JSPUtil.getParameter(request, prefix	+ "stl_seq", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] rVvd = (JSPUtil.getParameter(request, prefix	+ "r_vvd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] rBsaQty = (JSPUtil.getParameter(request, prefix	+ "r_bsa_qty", length));
			String[] joStlItmCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_itm_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] eStlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "e_stl_locl_amt", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] rStlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "r_stl_locl_amt", length));
			String[] joStlJbCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_jb_cd", length));
			String[] eVvd = (JSPUtil.getParameter(request, prefix	+ "e_vvd", length));
			String[] cmbCfmFlg = (JSPUtil.getParameter(request, prefix	+ "cmb_cfm_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] eBsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "e_bsa_slt_prc", length));
			String[] eBsaQty = (JSPUtil.getParameter(request, prefix	+ "e_bsa_qty", length));
			String[] rBsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "r_bsa_slt_prc", length));
			String[] stlVvdSeq = (JSPUtil.getParameter(request, prefix	+ "stl_vvd_seq", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CombinedVO();
				if (stlSeq[i] != null)
					model.setStlSeq(stlSeq[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (rVvd[i] != null)
					model.setRVvd(rVvd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (rBsaQty[i] != null)
					model.setRBsaQty(rBsaQty[i]);
				if (joStlItmCd[i] != null)
					model.setJoStlItmCd(joStlItmCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (eStlLoclAmt[i] != null)
					model.setEStlLoclAmt(eStlLoclAmt[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (rStlLoclAmt[i] != null)
					model.setRStlLoclAmt(rStlLoclAmt[i]);
				if (joStlJbCd[i] != null)
					model.setJoStlJbCd(joStlJbCd[i]);
				if (eVvd[i] != null)
					model.setEVvd(eVvd[i]);
				if (cmbCfmFlg[i] != null)
					model.setCmbCfmFlg(cmbCfmFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (eBsaSltPrc[i] != null)
					model.setEBsaSltPrc(eBsaSltPrc[i]);
				if (eBsaQty[i] != null)
					model.setEBsaQty(eBsaQty[i]);
				if (rBsaSltPrc[i] != null)
					model.setRBsaSltPrc(rBsaSltPrc[i]);
				if (stlVvdSeq[i] != null)
					model.setStlVvdSeq(stlVvdSeq[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCombinedVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CombinedVO[]
	 */
	public CombinedVO[] getCombinedVOs(){
		CombinedVO[] vos = (CombinedVO[])models.toArray(new CombinedVO[models.size()]);
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
		this.stlSeq = this.stlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rVvd = this.rVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rBsaQty = this.rBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlItmCd = this.joStlItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eStlLoclAmt = this.eStlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rStlLoclAmt = this.rStlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlJbCd = this.joStlJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eVvd = this.eVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbCfmFlg = this.cmbCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eBsaSltPrc = this.eBsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eBsaQty = this.eBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rBsaSltPrc = this.rBsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlVvdSeq = this.stlVvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
