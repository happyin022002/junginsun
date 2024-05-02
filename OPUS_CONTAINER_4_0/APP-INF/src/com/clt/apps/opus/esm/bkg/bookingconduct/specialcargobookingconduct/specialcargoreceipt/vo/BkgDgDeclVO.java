/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgDgDeclVO.java
*@FileTitle : BkgDgDeclVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.19  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgDgDeclVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgDgDeclVO> models = new ArrayList<BkgDgDeclVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String dcgoSeq = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String custAddr = null;
	/* Column Info */
	private String dgDeclSeq = null;
	/* Column Info */
	private String custEml = null;
	/* Column Info */
	private String declNm = null;
	/* Column Info */
	private String cntrCgoSeq = null;
	/* Column Info */
	private String cstmsDeclCntCd = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String custFaxNo = null;
	/* Column Info */
	private String custZipId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String dgCntrSeq = null;
	/* Column Info */
	private String custCtyNm = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custSteCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String cntrNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgDgDeclVO() {}

	public BkgDgDeclVO(String ibflag, String pagerows, String bkgNo, String dcgoSeq, String dgDeclSeq, String dgCntrSeq, String cntrCgoSeq, String cntrNo, String bkgCustTpCd, String custCntCd, String custSeq, String custNm, String custAddr, String custCtyNm, String custSteCd, String cstmsDeclCntCd, String custZipId, String phnNo, String custFaxNo, String custEml, String creUsrId, String updUsrId, String declNm) {
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.custNm = custNm;
		this.dcgoSeq = dcgoSeq;
		this.bkgNo = bkgNo;
		this.custAddr = custAddr;
		this.dgDeclSeq = dgDeclSeq;
		this.custEml = custEml;
		this.declNm = declNm;
		this.cntrCgoSeq = cntrCgoSeq;
		this.cstmsDeclCntCd = cstmsDeclCntCd;
		this.phnNo = phnNo;
		this.custFaxNo = custFaxNo;
		this.custZipId = custZipId;
		this.updUsrId = updUsrId;
		this.creUsrId = creUsrId;
		this.dgCntrSeq = dgCntrSeq;
		this.custCtyNm = custCtyNm;
		this.custCntCd = custCntCd;
		this.custSteCd = custSteCd;
		this.custSeq = custSeq;
		this.bkgCustTpCd = bkgCustTpCd;
		this.cntrNo = cntrNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("dcgo_seq", getDcgoSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cust_addr", getCustAddr());
		this.hashColumns.put("dg_decl_seq", getDgDeclSeq());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("decl_nm", getDeclNm());
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
		this.hashColumns.put("cstms_decl_cnt_cd", getCstmsDeclCntCd());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("cust_fax_no", getCustFaxNo());
		this.hashColumns.put("cust_zip_id", getCustZipId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("dg_cntr_seq", getDgCntrSeq());
		this.hashColumns.put("cust_cty_nm", getCustCtyNm());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_ste_cd", getCustSteCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("dcgo_seq", "dcgoSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cust_addr", "custAddr");
		this.hashFields.put("dg_decl_seq", "dgDeclSeq");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("decl_nm", "declNm");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("cstms_decl_cnt_cd", "cstmsDeclCntCd");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("cust_fax_no", "custFaxNo");
		this.hashFields.put("cust_zip_id", "custZipId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dg_cntr_seq", "dgCntrSeq");
		this.hashFields.put("cust_cty_nm", "custCtyNm");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_ste_cd", "custSteCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("cntr_no", "cntrNo");
		return this.hashFields;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return dcgoSeq
	 */
	public String getDcgoSeq() {
		return this.dcgoSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return custAddr
	 */
	public String getCustAddr() {
		return this.custAddr;
	}
	
	/**
	 * Column Info
	 * @return dgDeclSeq
	 */
	public String getDgDeclSeq() {
		return this.dgDeclSeq;
	}
	
	/**
	 * Column Info
	 * @return custEml
	 */
	public String getCustEml() {
		return this.custEml;
	}
	
	/**
	 * Column Info
	 * @return declNm
	 */
	public String getDeclNm() {
		return this.declNm;
	}
	
	/**
	 * Column Info
	 * @return cntrCgoSeq
	 */
	public String getCntrCgoSeq() {
		return this.cntrCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return cstmsDeclCntCd
	 */
	public String getCstmsDeclCntCd() {
		return this.cstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return custFaxNo
	 */
	public String getCustFaxNo() {
		return this.custFaxNo;
	}
	
	/**
	 * Column Info
	 * @return custZipId
	 */
	public String getCustZipId() {
		return this.custZipId;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return dgCntrSeq
	 */
	public String getDgCntrSeq() {
		return this.dgCntrSeq;
	}
	
	/**
	 * Column Info
	 * @return custCtyNm
	 */
	public String getCustCtyNm() {
		return this.custCtyNm;
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
	 * @return custSteCd
	 */
	public String getCustSteCd() {
		return this.custSteCd;
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
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param dcgoSeq
	 */
	public void setDcgoSeq(String dcgoSeq) {
		this.dcgoSeq = dcgoSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param custAddr
	 */
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	
	/**
	 * Column Info
	 * @param dgDeclSeq
	 */
	public void setDgDeclSeq(String dgDeclSeq) {
		this.dgDeclSeq = dgDeclSeq;
	}
	
	/**
	 * Column Info
	 * @param custEml
	 */
	public void setCustEml(String custEml) {
		this.custEml = custEml;
	}
	
	/**
	 * Column Info
	 * @param declNm
	 */
	public void setDeclNm(String declNm) {
		this.declNm = declNm;
	}
	
	/**
	 * Column Info
	 * @param cntrCgoSeq
	 */
	public void setCntrCgoSeq(String cntrCgoSeq) {
		this.cntrCgoSeq = cntrCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param cstmsDeclCntCd
	 */
	public void setCstmsDeclCntCd(String cstmsDeclCntCd) {
		this.cstmsDeclCntCd = cstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param custFaxNo
	 */
	public void setCustFaxNo(String custFaxNo) {
		this.custFaxNo = custFaxNo;
	}
	
	/**
	 * Column Info
	 * @param custZipId
	 */
	public void setCustZipId(String custZipId) {
		this.custZipId = custZipId;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param dgCntrSeq
	 */
	public void setDgCntrSeq(String dgCntrSeq) {
		this.dgCntrSeq = dgCntrSeq;
	}
	
	/**
	 * Column Info
	 * @param custCtyNm
	 */
	public void setCustCtyNm(String custCtyNm) {
		this.custCtyNm = custCtyNm;
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
	 * @param custSteCd
	 */
	public void setCustSteCd(String custSteCd) {
		this.custSteCd = custSteCd;
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
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setDcgoSeq(JSPUtil.getParameter(request, prefix + "dcgo_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCustAddr(JSPUtil.getParameter(request, prefix + "cust_addr", ""));
		setDgDeclSeq(JSPUtil.getParameter(request, prefix + "dg_decl_seq", ""));
		setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
		setDeclNm(JSPUtil.getParameter(request, prefix + "decl_nm", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
		setCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "cstms_decl_cnt_cd", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setCustFaxNo(JSPUtil.getParameter(request, prefix + "cust_fax_no", ""));
		setCustZipId(JSPUtil.getParameter(request, prefix + "cust_zip_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDgCntrSeq(JSPUtil.getParameter(request, prefix + "dg_cntr_seq", ""));
		setCustCtyNm(JSPUtil.getParameter(request, prefix + "cust_cty_nm", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustSteCd(JSPUtil.getParameter(request, prefix + "cust_ste_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgDgDeclVO[]
	 */
	public BkgDgDeclVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgDgDeclVO[]
	 */
	public BkgDgDeclVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgDgDeclVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] dcgoSeq = (JSPUtil.getParameter(request, prefix	+ "dcgo_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] custAddr = (JSPUtil.getParameter(request, prefix	+ "cust_addr", length));
			String[] dgDeclSeq = (JSPUtil.getParameter(request, prefix	+ "dg_decl_seq", length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml", length));
			String[] declNm = (JSPUtil.getParameter(request, prefix	+ "decl_nm", length));
			String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_seq", length));
			String[] cstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_cnt_cd", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] custFaxNo = (JSPUtil.getParameter(request, prefix	+ "cust_fax_no", length));
			String[] custZipId = (JSPUtil.getParameter(request, prefix	+ "cust_zip_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] dgCntrSeq = (JSPUtil.getParameter(request, prefix	+ "dg_cntr_seq", length));
			String[] custCtyNm = (JSPUtil.getParameter(request, prefix	+ "cust_cty_nm", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSteCd = (JSPUtil.getParameter(request, prefix	+ "cust_ste_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgDgDeclVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (dcgoSeq[i] != null)
					model.setDcgoSeq(dcgoSeq[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (custAddr[i] != null)
					model.setCustAddr(custAddr[i]);
				if (dgDeclSeq[i] != null)
					model.setDgDeclSeq(dgDeclSeq[i]);
				if (custEml[i] != null)
					model.setCustEml(custEml[i]);
				if (declNm[i] != null)
					model.setDeclNm(declNm[i]);
				if (cntrCgoSeq[i] != null)
					model.setCntrCgoSeq(cntrCgoSeq[i]);
				if (cstmsDeclCntCd[i] != null)
					model.setCstmsDeclCntCd(cstmsDeclCntCd[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (custFaxNo[i] != null)
					model.setCustFaxNo(custFaxNo[i]);
				if (custZipId[i] != null)
					model.setCustZipId(custZipId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (dgCntrSeq[i] != null)
					model.setDgCntrSeq(dgCntrSeq[i]);
				if (custCtyNm[i] != null)
					model.setCustCtyNm(custCtyNm[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSteCd[i] != null)
					model.setCustSteCd(custSteCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgDgDeclVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgDgDeclVO[]
	 */
	public BkgDgDeclVO[] getBkgDgDeclVOs(){
		BkgDgDeclVO[] vos = (BkgDgDeclVO[])models.toArray(new BkgDgDeclVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSeq = this.dcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr = this.custAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgDeclSeq = this.dgDeclSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.declNm = this.declNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq = this.cntrCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclCntCd = this.cstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custFaxNo = this.custFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custZipId = this.custZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrSeq = this.dgCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtyNm = this.custCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSteCd = this.custSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
