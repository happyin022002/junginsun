/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RsltPropCustInfoVO.java
*@FileTitle : RsltPropCustInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.08
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2011.11.08 서미진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo;

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

public class RsltPropCustInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPropCustInfoVO> models = new ArrayList<RsltPropCustInfoVO>();
	
	/* Column Info */
	private String otiLicNo = null;
	/* Column Info */
	private String otiEffDt = null;
	/* Column Info */
	private String ctrtPtySgnTitNm = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String otiExpDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcCtrtCustTpCd = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtPtyNm = null;
	/* Column Info */
	private String ctrtCustSlsOfcCd = null;
	/* Column Info */
	private String otiNo = null;
	/* Column Info */
	private String otiAmt = null;
	/* Column Info */
	private String ctrtCustValSgm = null;
	/* Column Info */
	private String ctrtPtyAddr = null;
	/* Column Info */
	private String ctrtCustSrepNm = null;
	/* Column Info */
	private String ctrtCustSrepCd = null;
	/* Column Info */
	private String ctrtPtySgnNm = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String ctrtCustValSgmCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPropCustInfoVO() {}

	public RsltPropCustInfoVO(String ibflag, String pagerows, String custCntCd, String custSeq, String prcCtrtCustTpCd, String ctrtPtyNm, String ctrtPtyAddr, String ctrtCustValSgmCd, String ctrtCustValSgm, String ctrtCustSrepCd, String ctrtCustSrepNm, String ctrtCustSlsOfcCd, String ctrtPtySgnNm, String ctrtPtySgnTitNm, String otiNo, String otiEffDt, String otiExpDt, String otiAmt, String otiLicNo, String locCd) {
		this.otiLicNo = otiLicNo;
		this.otiEffDt = otiEffDt;
		this.ctrtPtySgnTitNm = ctrtPtySgnTitNm;
		this.custSeq = custSeq;
		this.otiExpDt = otiExpDt;
		this.pagerows = pagerows;
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.ctrtPtyNm = ctrtPtyNm;
		this.ctrtCustSlsOfcCd = ctrtCustSlsOfcCd;
		this.otiNo = otiNo;
		this.otiAmt = otiAmt;
		this.ctrtCustValSgm = ctrtCustValSgm;
		this.ctrtPtyAddr = ctrtPtyAddr;
		this.ctrtCustSrepNm = ctrtCustSrepNm;
		this.ctrtCustSrepCd = ctrtCustSrepCd;
		this.ctrtPtySgnNm = ctrtPtySgnNm;
		this.custCntCd = custCntCd;
		this.ctrtCustValSgmCd = ctrtCustValSgmCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("oti_lic_no", getOtiLicNo());
		this.hashColumns.put("oti_eff_dt", getOtiEffDt());
		this.hashColumns.put("ctrt_pty_sgn_tit_nm", getCtrtPtySgnTitNm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("oti_exp_dt", getOtiExpDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_ctrt_cust_tp_cd", getPrcCtrtCustTpCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("ctrt_cust_sls_ofc_cd", getCtrtCustSlsOfcCd());
		this.hashColumns.put("oti_no", getOtiNo());
		this.hashColumns.put("oti_amt", getOtiAmt());
		this.hashColumns.put("ctrt_cust_val_sgm", getCtrtCustValSgm());
		this.hashColumns.put("ctrt_pty_addr", getCtrtPtyAddr());
		this.hashColumns.put("ctrt_cust_srep_nm", getCtrtCustSrepNm());
		this.hashColumns.put("ctrt_cust_srep_cd", getCtrtCustSrepCd());
		this.hashColumns.put("ctrt_pty_sgn_nm", getCtrtPtySgnNm());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("ctrt_cust_val_sgm_cd", getCtrtCustValSgmCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("oti_lic_no", "otiLicNo");
		this.hashFields.put("oti_eff_dt", "otiEffDt");
		this.hashFields.put("ctrt_pty_sgn_tit_nm", "ctrtPtySgnTitNm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("oti_exp_dt", "otiExpDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_ctrt_cust_tp_cd", "prcCtrtCustTpCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("ctrt_cust_sls_ofc_cd", "ctrtCustSlsOfcCd");
		this.hashFields.put("oti_no", "otiNo");
		this.hashFields.put("oti_amt", "otiAmt");
		this.hashFields.put("ctrt_cust_val_sgm", "ctrtCustValSgm");
		this.hashFields.put("ctrt_pty_addr", "ctrtPtyAddr");
		this.hashFields.put("ctrt_cust_srep_nm", "ctrtCustSrepNm");
		this.hashFields.put("ctrt_cust_srep_cd", "ctrtCustSrepCd");
		this.hashFields.put("ctrt_pty_sgn_nm", "ctrtPtySgnNm");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("ctrt_cust_val_sgm_cd", "ctrtCustValSgmCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return otiLicNo
	 */
	public String getOtiLicNo() {
		return this.otiLicNo;
	}
	
	/**
	 * Column Info
	 * @return otiEffDt
	 */
	public String getOtiEffDt() {
		return this.otiEffDt;
	}
	
	/**
	 * Column Info
	 * @return ctrtPtySgnTitNm
	 */
	public String getCtrtPtySgnTitNm() {
		return this.ctrtPtySgnTitNm;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return otiExpDt
	 */
	public String getOtiExpDt() {
		return this.otiExpDt;
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
	 * @return prcCtrtCustTpCd
	 */
	public String getPrcCtrtCustTpCd() {
		return this.prcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return ctrtPtyNm
	 */
	public String getCtrtPtyNm() {
		return this.ctrtPtyNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSlsOfcCd
	 */
	public String getCtrtCustSlsOfcCd() {
		return this.ctrtCustSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return otiNo
	 */
	public String getOtiNo() {
		return this.otiNo;
	}
	
	/**
	 * Column Info
	 * @return otiAmt
	 */
	public String getOtiAmt() {
		return this.otiAmt;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustValSgm
	 */
	public String getCtrtCustValSgm() {
		return this.ctrtCustValSgm;
	}
	
	/**
	 * Column Info
	 * @return ctrtPtyAddr
	 */
	public String getCtrtPtyAddr() {
		return this.ctrtPtyAddr;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSrepNm
	 */
	public String getCtrtCustSrepNm() {
		return this.ctrtCustSrepNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSrepCd
	 */
	public String getCtrtCustSrepCd() {
		return this.ctrtCustSrepCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtPtySgnNm
	 */
	public String getCtrtPtySgnNm() {
		return this.ctrtPtySgnNm;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustValSgmCd
	 */
	public String getCtrtCustValSgmCd() {
		return this.ctrtCustValSgmCd;
	}
	

	/**
	 * Column Info
	 * @param otiLicNo
	 */
	public void setOtiLicNo(String otiLicNo) {
		this.otiLicNo = otiLicNo;
	}
	
	/**
	 * Column Info
	 * @param otiEffDt
	 */
	public void setOtiEffDt(String otiEffDt) {
		this.otiEffDt = otiEffDt;
	}
	
	/**
	 * Column Info
	 * @param ctrtPtySgnTitNm
	 */
	public void setCtrtPtySgnTitNm(String ctrtPtySgnTitNm) {
		this.ctrtPtySgnTitNm = ctrtPtySgnTitNm;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param otiExpDt
	 */
	public void setOtiExpDt(String otiExpDt) {
		this.otiExpDt = otiExpDt;
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
	 * @param prcCtrtCustTpCd
	 */
	public void setPrcCtrtCustTpCd(String prcCtrtCustTpCd) {
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param ctrtPtyNm
	 */
	public void setCtrtPtyNm(String ctrtPtyNm) {
		this.ctrtPtyNm = ctrtPtyNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSlsOfcCd
	 */
	public void setCtrtCustSlsOfcCd(String ctrtCustSlsOfcCd) {
		this.ctrtCustSlsOfcCd = ctrtCustSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param otiNo
	 */
	public void setOtiNo(String otiNo) {
		this.otiNo = otiNo;
	}
	
	/**
	 * Column Info
	 * @param otiAmt
	 */
	public void setOtiAmt(String otiAmt) {
		this.otiAmt = otiAmt;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustValSgm
	 */
	public void setCtrtCustValSgm(String ctrtCustValSgm) {
		this.ctrtCustValSgm = ctrtCustValSgm;
	}
	
	/**
	 * Column Info
	 * @param ctrtPtyAddr
	 */
	public void setCtrtPtyAddr(String ctrtPtyAddr) {
		this.ctrtPtyAddr = ctrtPtyAddr;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSrepNm
	 */
	public void setCtrtCustSrepNm(String ctrtCustSrepNm) {
		this.ctrtCustSrepNm = ctrtCustSrepNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSrepCd
	 */
	public void setCtrtCustSrepCd(String ctrtCustSrepCd) {
		this.ctrtCustSrepCd = ctrtCustSrepCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtPtySgnNm
	 */
	public void setCtrtPtySgnNm(String ctrtPtySgnNm) {
		this.ctrtPtySgnNm = ctrtPtySgnNm;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustValSgmCd
	 */
	public void setCtrtCustValSgmCd(String ctrtCustValSgmCd) {
		this.ctrtCustValSgmCd = ctrtCustValSgmCd;
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
		setOtiLicNo(JSPUtil.getParameter(request, prefix + "oti_lic_no", ""));
		setOtiEffDt(JSPUtil.getParameter(request, prefix + "oti_eff_dt", ""));
		setCtrtPtySgnTitNm(JSPUtil.getParameter(request, prefix + "ctrt_pty_sgn_tit_nm", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setOtiExpDt(JSPUtil.getParameter(request, prefix + "oti_exp_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPrcCtrtCustTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_cd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, prefix + "ctrt_pty_nm", ""));
		setCtrtCustSlsOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_sls_ofc_cd", ""));
		setOtiNo(JSPUtil.getParameter(request, prefix + "oti_no", ""));
		setOtiAmt(JSPUtil.getParameter(request, prefix + "oti_amt", ""));
		setCtrtCustValSgm(JSPUtil.getParameter(request, prefix + "ctrt_cust_val_sgm", ""));
		setCtrtPtyAddr(JSPUtil.getParameter(request, prefix + "ctrt_pty_addr", ""));
		setCtrtCustSrepNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_srep_nm", ""));
		setCtrtCustSrepCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_srep_cd", ""));
		setCtrtPtySgnNm(JSPUtil.getParameter(request, prefix + "ctrt_pty_sgn_nm", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCtrtCustValSgmCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_val_sgm_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPropCustInfoVO[]
	 */
	public RsltPropCustInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPropCustInfoVO[]
	 */
	public RsltPropCustInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPropCustInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] otiLicNo = (JSPUtil.getParameter(request, prefix	+ "oti_lic_no", length));
			String[] otiEffDt = (JSPUtil.getParameter(request, prefix	+ "oti_eff_dt", length));
			String[] ctrtPtySgnTitNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_sgn_tit_nm", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] otiExpDt = (JSPUtil.getParameter(request, prefix	+ "oti_exp_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prcCtrtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] ctrtCustSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_sls_ofc_cd", length));
			String[] otiNo = (JSPUtil.getParameter(request, prefix	+ "oti_no", length));
			String[] otiAmt = (JSPUtil.getParameter(request, prefix	+ "oti_amt", length));
			String[] ctrtCustValSgm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_val_sgm", length));
			String[] ctrtPtyAddr = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_addr", length));
			String[] ctrtCustSrepNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_srep_nm", length));
			String[] ctrtCustSrepCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_srep_cd", length));
			String[] ctrtPtySgnNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_sgn_nm", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] ctrtCustValSgmCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_val_sgm_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPropCustInfoVO();
				if (otiLicNo[i] != null)
					model.setOtiLicNo(otiLicNo[i]);
				if (otiEffDt[i] != null)
					model.setOtiEffDt(otiEffDt[i]);
				if (ctrtPtySgnTitNm[i] != null)
					model.setCtrtPtySgnTitNm(ctrtPtySgnTitNm[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (otiExpDt[i] != null)
					model.setOtiExpDt(otiExpDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcCtrtCustTpCd[i] != null)
					model.setPrcCtrtCustTpCd(prcCtrtCustTpCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				if (ctrtCustSlsOfcCd[i] != null)
					model.setCtrtCustSlsOfcCd(ctrtCustSlsOfcCd[i]);
				if (otiNo[i] != null)
					model.setOtiNo(otiNo[i]);
				if (otiAmt[i] != null)
					model.setOtiAmt(otiAmt[i]);
				if (ctrtCustValSgm[i] != null)
					model.setCtrtCustValSgm(ctrtCustValSgm[i]);
				if (ctrtPtyAddr[i] != null)
					model.setCtrtPtyAddr(ctrtPtyAddr[i]);
				if (ctrtCustSrepNm[i] != null)
					model.setCtrtCustSrepNm(ctrtCustSrepNm[i]);
				if (ctrtCustSrepCd[i] != null)
					model.setCtrtCustSrepCd(ctrtCustSrepCd[i]);
				if (ctrtPtySgnNm[i] != null)
					model.setCtrtPtySgnNm(ctrtPtySgnNm[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (ctrtCustValSgmCd[i] != null)
					model.setCtrtCustValSgmCd(ctrtCustValSgmCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPropCustInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPropCustInfoVO[]
	 */
	public RsltPropCustInfoVO[] getRsltPropCustInfoVOs(){
		RsltPropCustInfoVO[] vos = (RsltPropCustInfoVO[])models.toArray(new RsltPropCustInfoVO[models.size()]);
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
		this.otiLicNo = this.otiLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiEffDt = this.otiEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtySgnTitNm = this.ctrtPtySgnTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiExpDt = this.otiExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpCd = this.prcCtrtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSlsOfcCd = this.ctrtCustSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiNo = this.otiNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiAmt = this.otiAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustValSgm = this.ctrtCustValSgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyAddr = this.ctrtPtyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepNm = this.ctrtCustSrepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepCd = this.ctrtCustSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtySgnNm = this.ctrtPtySgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustValSgmCd = this.ctrtCustValSgmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
