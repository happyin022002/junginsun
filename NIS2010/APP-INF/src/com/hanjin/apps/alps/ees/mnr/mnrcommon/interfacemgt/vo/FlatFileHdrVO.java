/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FlatFileHdrVO.java
*@FileTitle : FlatFileHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2009.11.24 이주현 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo;

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
 * @author 이주현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FlatFileHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FlatFileHdrVO> models = new ArrayList<FlatFileHdrVO>();
	
	/* Column Info */
	private String actTransDt = null;
	/* Column Info */
	private String ordDt = null;
	/* Column Info */
	private String curCd = null;
	/* Column Info */
	private String authSendor = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String eqPrefix = null;
	/* Column Info */
	private String ordGrndTot = null;
	/* Column Info */
	private String hjsOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dppCur = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String matTot = null;
	/* Column Info */
	private String msgId = null;
	/* Column Info */
	private String totInvAmt = null;
	/* Column Info */
	private String hanTot = null;
	/* Column Info */
	private String labTot = null;
	/* Column Info */
	private String dpp = null;
	/* Column Info */
	private String ordNo = null;
	/* Column Info */
	private String vendorEdiAddr = null;
	/* Column Info */
	private String ediId = null;
	/* Column Info */
	private String eqType = null;
	/* Column Info */
	private String eqTpsz = null;
	/* Column Info */
	private String msgRvsNo = null;
	/* Column Info */
	private String tax = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String spcfRecpt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FlatFileHdrVO() {}

	public FlatFileHdrVO(String ibflag, String pagerows, String msgId, String ordNo, String msgRvsNo, String refNo, String eqType, String eqPrefix, String eqNo, String hjsOfcCd, String authSendor, String vendorEdiAddr, String spcfRecpt, String actTransDt, String ordDt, String eqTpsz, String curCd, String labTot, String matTot, String hanTot, String tax, String totInvAmt, String ediId, String remark, String ordGrndTot, String dppCur, String dpp) {
		this.actTransDt = actTransDt;
		this.ordDt = ordDt;
		this.curCd = curCd;
		this.authSendor = authSendor;
		this.remark = remark;
		this.eqPrefix = eqPrefix;
		this.ordGrndTot = ordGrndTot;
		this.hjsOfcCd = hjsOfcCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.dppCur = dppCur;
		this.eqNo = eqNo;
		this.matTot = matTot;
		this.msgId = msgId;
		this.totInvAmt = totInvAmt;
		this.hanTot = hanTot;
		this.labTot = labTot;
		this.dpp = dpp;
		this.ordNo = ordNo;
		this.vendorEdiAddr = vendorEdiAddr;
		this.ediId = ediId;
		this.eqType = eqType;
		this.eqTpsz = eqTpsz;
		this.msgRvsNo = msgRvsNo;
		this.tax = tax;
		this.refNo = refNo;
		this.spcfRecpt = spcfRecpt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_trans_dt", getActTransDt());
		this.hashColumns.put("ord_dt", getOrdDt());
		this.hashColumns.put("cur_cd", getCurCd());
		this.hashColumns.put("auth_sendor", getAuthSendor());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("eq_prefix", getEqPrefix());
		this.hashColumns.put("ord_grnd_tot", getOrdGrndTot());
		this.hashColumns.put("hjs_ofc_cd", getHjsOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dpp_cur", getDppCur());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("mat_tot", getMatTot());
		this.hashColumns.put("msg_id", getMsgId());
		this.hashColumns.put("tot_inv_amt", getTotInvAmt());
		this.hashColumns.put("han_tot", getHanTot());
		this.hashColumns.put("lab_tot", getLabTot());
		this.hashColumns.put("dpp", getDpp());
		this.hashColumns.put("ord_no", getOrdNo());
		this.hashColumns.put("vendor_edi_addr", getVendorEdiAddr());
		this.hashColumns.put("edi_id", getEdiId());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("eq_tpsz", getEqTpsz());
		this.hashColumns.put("msg_rvs_no", getMsgRvsNo());
		this.hashColumns.put("tax", getTax());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("spcf_recpt", getSpcfRecpt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_trans_dt", "actTransDt");
		this.hashFields.put("ord_dt", "ordDt");
		this.hashFields.put("cur_cd", "curCd");
		this.hashFields.put("auth_sendor", "authSendor");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("eq_prefix", "eqPrefix");
		this.hashFields.put("ord_grnd_tot", "ordGrndTot");
		this.hashFields.put("hjs_ofc_cd", "hjsOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dpp_cur", "dppCur");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("mat_tot", "matTot");
		this.hashFields.put("msg_id", "msgId");
		this.hashFields.put("tot_inv_amt", "totInvAmt");
		this.hashFields.put("han_tot", "hanTot");
		this.hashFields.put("lab_tot", "labTot");
		this.hashFields.put("dpp", "dpp");
		this.hashFields.put("ord_no", "ordNo");
		this.hashFields.put("vendor_edi_addr", "vendorEdiAddr");
		this.hashFields.put("edi_id", "ediId");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("eq_tpsz", "eqTpsz");
		this.hashFields.put("msg_rvs_no", "msgRvsNo");
		this.hashFields.put("tax", "tax");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("spcf_recpt", "spcfRecpt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return actTransDt
	 */
	public String getActTransDt() {
		return this.actTransDt;
	}
	
	/**
	 * Column Info
	 * @return ordDt
	 */
	public String getOrdDt() {
		return this.ordDt;
	}
	
	/**
	 * Column Info
	 * @return curCd
	 */
	public String getCurCd() {
		return this.curCd;
	}
	
	/**
	 * Column Info
	 * @return authSendor
	 */
	public String getAuthSendor() {
		return this.authSendor;
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
	 * @return eqPrefix
	 */
	public String getEqPrefix() {
		return this.eqPrefix;
	}
	
	/**
	 * Column Info
	 * @return ordGrndTot
	 */
	public String getOrdGrndTot() {
		return this.ordGrndTot;
	}
	
	/**
	 * Column Info
	 * @return hjsOfcCd
	 */
	public String getHjsOfcCd() {
		return this.hjsOfcCd;
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
	 * @return dppCur
	 */
	public String getDppCur() {
		return this.dppCur;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return matTot
	 */
	public String getMatTot() {
		return this.matTot;
	}
	
	/**
	 * Column Info
	 * @return msgId
	 */
	public String getMsgId() {
		return this.msgId;
	}
	
	/**
	 * Column Info
	 * @return totInvAmt
	 */
	public String getTotInvAmt() {
		return this.totInvAmt;
	}
	
	/**
	 * Column Info
	 * @return hanTot
	 */
	public String getHanTot() {
		return this.hanTot;
	}
	
	/**
	 * Column Info
	 * @return labTot
	 */
	public String getLabTot() {
		return this.labTot;
	}
	
	/**
	 * Column Info
	 * @return dpp
	 */
	public String getDpp() {
		return this.dpp;
	}
	
	/**
	 * Column Info
	 * @return ordNo
	 */
	public String getOrdNo() {
		return this.ordNo;
	}
	
	/**
	 * Column Info
	 * @return vendorEdiAddr
	 */
	public String getVendorEdiAddr() {
		return this.vendorEdiAddr;
	}
	
	/**
	 * Column Info
	 * @return ediId
	 */
	public String getEdiId() {
		return this.ediId;
	}
	
	/**
	 * Column Info
	 * @return eqType
	 */
	public String getEqType() {
		return this.eqType;
	}
	
	/**
	 * Column Info
	 * @return eqTpsz
	 */
	public String getEqTpsz() {
		return this.eqTpsz;
	}
	
	/**
	 * Column Info
	 * @return msgRvsNo
	 */
	public String getMsgRvsNo() {
		return this.msgRvsNo;
	}
	
	/**
	 * Column Info
	 * @return tax
	 */
	public String getTax() {
		return this.tax;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return spcfRecpt
	 */
	public String getSpcfRecpt() {
		return this.spcfRecpt;
	}
	

	/**
	 * Column Info
	 * @param actTransDt
	 */
	public void setActTransDt(String actTransDt) {
		this.actTransDt = actTransDt;
	}
	
	/**
	 * Column Info
	 * @param ordDt
	 */
	public void setOrdDt(String ordDt) {
		this.ordDt = ordDt;
	}
	
	/**
	 * Column Info
	 * @param curCd
	 */
	public void setCurCd(String curCd) {
		this.curCd = curCd;
	}
	
	/**
	 * Column Info
	 * @param authSendor
	 */
	public void setAuthSendor(String authSendor) {
		this.authSendor = authSendor;
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
	 * @param eqPrefix
	 */
	public void setEqPrefix(String eqPrefix) {
		this.eqPrefix = eqPrefix;
	}
	
	/**
	 * Column Info
	 * @param ordGrndTot
	 */
	public void setOrdGrndTot(String ordGrndTot) {
		this.ordGrndTot = ordGrndTot;
	}
	
	/**
	 * Column Info
	 * @param hjsOfcCd
	 */
	public void setHjsOfcCd(String hjsOfcCd) {
		this.hjsOfcCd = hjsOfcCd;
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
	 * @param dppCur
	 */
	public void setDppCur(String dppCur) {
		this.dppCur = dppCur;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param matTot
	 */
	public void setMatTot(String matTot) {
		this.matTot = matTot;
	}
	
	/**
	 * Column Info
	 * @param msgId
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	/**
	 * Column Info
	 * @param totInvAmt
	 */
	public void setTotInvAmt(String totInvAmt) {
		this.totInvAmt = totInvAmt;
	}
	
	/**
	 * Column Info
	 * @param hanTot
	 */
	public void setHanTot(String hanTot) {
		this.hanTot = hanTot;
	}
	
	/**
	 * Column Info
	 * @param labTot
	 */
	public void setLabTot(String labTot) {
		this.labTot = labTot;
	}
	
	/**
	 * Column Info
	 * @param dpp
	 */
	public void setDpp(String dpp) {
		this.dpp = dpp;
	}
	
	/**
	 * Column Info
	 * @param ordNo
	 */
	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
	}
	
	/**
	 * Column Info
	 * @param vendorEdiAddr
	 */
	public void setVendorEdiAddr(String vendorEdiAddr) {
		this.vendorEdiAddr = vendorEdiAddr;
	}
	
	/**
	 * Column Info
	 * @param ediId
	 */
	public void setEdiId(String ediId) {
		this.ediId = ediId;
	}
	
	/**
	 * Column Info
	 * @param eqType
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
	}
	
	/**
	 * Column Info
	 * @param eqTpsz
	 */
	public void setEqTpsz(String eqTpsz) {
		this.eqTpsz = eqTpsz;
	}
	
	/**
	 * Column Info
	 * @param msgRvsNo
	 */
	public void setMsgRvsNo(String msgRvsNo) {
		this.msgRvsNo = msgRvsNo;
	}
	
	/**
	 * Column Info
	 * @param tax
	 */
	public void setTax(String tax) {
		this.tax = tax;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param spcfRecpt
	 */
	public void setSpcfRecpt(String spcfRecpt) {
		this.spcfRecpt = spcfRecpt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setActTransDt(JSPUtil.getParameter(request, "act_trans_dt", ""));
		setOrdDt(JSPUtil.getParameter(request, "ord_dt", ""));
		setCurCd(JSPUtil.getParameter(request, "cur_cd", ""));
		setAuthSendor(JSPUtil.getParameter(request, "auth_sendor", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setEqPrefix(JSPUtil.getParameter(request, "eq_prefix", ""));
		setOrdGrndTot(JSPUtil.getParameter(request, "ord_grnd_tot", ""));
		setHjsOfcCd(JSPUtil.getParameter(request, "hjs_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDppCur(JSPUtil.getParameter(request, "dpp_cur", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setMatTot(JSPUtil.getParameter(request, "mat_tot", ""));
		setMsgId(JSPUtil.getParameter(request, "msg_id", ""));
		setTotInvAmt(JSPUtil.getParameter(request, "tot_inv_amt", ""));
		setHanTot(JSPUtil.getParameter(request, "han_tot", ""));
		setLabTot(JSPUtil.getParameter(request, "lab_tot", ""));
		setDpp(JSPUtil.getParameter(request, "dpp", ""));
		setOrdNo(JSPUtil.getParameter(request, "ord_no", ""));
		setVendorEdiAddr(JSPUtil.getParameter(request, "vendor_edi_addr", ""));
		setEdiId(JSPUtil.getParameter(request, "edi_id", ""));
		setEqType(JSPUtil.getParameter(request, "eq_type", ""));
		setEqTpsz(JSPUtil.getParameter(request, "eq_tpsz", ""));
		setMsgRvsNo(JSPUtil.getParameter(request, "msg_rvs_no", ""));
		setTax(JSPUtil.getParameter(request, "tax", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setSpcfRecpt(JSPUtil.getParameter(request, "spcf_recpt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FlatFileHdrVO[]
	 */
	public FlatFileHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FlatFileHdrVO[]
	 */
	public FlatFileHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FlatFileHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] actTransDt = (JSPUtil.getParameter(request, prefix	+ "act_trans_dt", length));
			String[] ordDt = (JSPUtil.getParameter(request, prefix	+ "ord_dt", length));
			String[] curCd = (JSPUtil.getParameter(request, prefix	+ "cur_cd", length));
			String[] authSendor = (JSPUtil.getParameter(request, prefix	+ "auth_sendor", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] eqPrefix = (JSPUtil.getParameter(request, prefix	+ "eq_prefix", length));
			String[] ordGrndTot = (JSPUtil.getParameter(request, prefix	+ "ord_grnd_tot", length));
			String[] hjsOfcCd = (JSPUtil.getParameter(request, prefix	+ "hjs_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dppCur = (JSPUtil.getParameter(request, prefix	+ "dpp_cur", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] matTot = (JSPUtil.getParameter(request, prefix	+ "mat_tot", length));
			String[] msgId = (JSPUtil.getParameter(request, prefix	+ "msg_id", length));
			String[] totInvAmt = (JSPUtil.getParameter(request, prefix	+ "tot_inv_amt", length));
			String[] hanTot = (JSPUtil.getParameter(request, prefix	+ "han_tot", length));
			String[] labTot = (JSPUtil.getParameter(request, prefix	+ "lab_tot", length));
			String[] dpp = (JSPUtil.getParameter(request, prefix	+ "dpp", length));
			String[] ordNo = (JSPUtil.getParameter(request, prefix	+ "ord_no", length));
			String[] vendorEdiAddr = (JSPUtil.getParameter(request, prefix	+ "vendor_edi_addr", length));
			String[] ediId = (JSPUtil.getParameter(request, prefix	+ "edi_id", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			String[] eqTpsz = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz", length));
			String[] msgRvsNo = (JSPUtil.getParameter(request, prefix	+ "msg_rvs_no", length));
			String[] tax = (JSPUtil.getParameter(request, prefix	+ "tax", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] spcfRecpt = (JSPUtil.getParameter(request, prefix	+ "spcf_recpt", length));
			
			for (int i = 0; i < length; i++) {
				model = new FlatFileHdrVO();
				if (actTransDt[i] != null)
					model.setActTransDt(actTransDt[i]);
				if (ordDt[i] != null)
					model.setOrdDt(ordDt[i]);
				if (curCd[i] != null)
					model.setCurCd(curCd[i]);
				if (authSendor[i] != null)
					model.setAuthSendor(authSendor[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (eqPrefix[i] != null)
					model.setEqPrefix(eqPrefix[i]);
				if (ordGrndTot[i] != null)
					model.setOrdGrndTot(ordGrndTot[i]);
				if (hjsOfcCd[i] != null)
					model.setHjsOfcCd(hjsOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dppCur[i] != null)
					model.setDppCur(dppCur[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (matTot[i] != null)
					model.setMatTot(matTot[i]);
				if (msgId[i] != null)
					model.setMsgId(msgId[i]);
				if (totInvAmt[i] != null)
					model.setTotInvAmt(totInvAmt[i]);
				if (hanTot[i] != null)
					model.setHanTot(hanTot[i]);
				if (labTot[i] != null)
					model.setLabTot(labTot[i]);
				if (dpp[i] != null)
					model.setDpp(dpp[i]);
				if (ordNo[i] != null)
					model.setOrdNo(ordNo[i]);
				if (vendorEdiAddr[i] != null)
					model.setVendorEdiAddr(vendorEdiAddr[i]);
				if (ediId[i] != null)
					model.setEdiId(ediId[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (eqTpsz[i] != null)
					model.setEqTpsz(eqTpsz[i]);
				if (msgRvsNo[i] != null)
					model.setMsgRvsNo(msgRvsNo[i]);
				if (tax[i] != null)
					model.setTax(tax[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (spcfRecpt[i] != null)
					model.setSpcfRecpt(spcfRecpt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFlatFileHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FlatFileHdrVO[]
	 */
	public FlatFileHdrVO[] getFlatFileHdrVOs(){
		FlatFileHdrVO[] vos = (FlatFileHdrVO[])models.toArray(new FlatFileHdrVO[models.size()]);
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
		this.actTransDt = this.actTransDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordDt = this.ordDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curCd = this.curCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authSendor = this.authSendor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqPrefix = this.eqPrefix .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordGrndTot = this.ordGrndTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsOfcCd = this.hjsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dppCur = this.dppCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.matTot = this.matTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgId = this.msgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totInvAmt = this.totInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hanTot = this.hanTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.labTot = this.labTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpp = this.dpp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordNo = this.ordNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vendorEdiAddr = this.vendorEdiAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediId = this.ediId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpsz = this.eqTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRvsNo = this.msgRvsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tax = this.tax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcfRecpt = this.spcfRecpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
