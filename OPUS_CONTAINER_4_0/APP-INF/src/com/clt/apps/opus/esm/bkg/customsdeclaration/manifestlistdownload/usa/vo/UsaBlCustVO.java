/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaBlCustVO.java
*@FileTitle : UsaBlCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.01
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.06.01 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaBlCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaBlCustVO> models = new ArrayList<UsaBlCustVO>();
	
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String eurCstmsStNm = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String cstmsDeclCntCd = null;
	/* Column Info */
	private String custAddr = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String custCtyNm = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custSteCd = null;
	/* Column Info */
	private String custZipId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UsaBlCustVO() {}

	public UsaBlCustVO(String ibflag, String pagerows, String cntCd, String blNo, String bkgCustTpCd, String custCntCd, String custSeq, String custNm, String custAddr, String phnNo, String faxNo, String custCtyNm, String custSteCd, String cstmsDeclCntCd, String custZipId, String eurCstmsStNm) {
		this.phnNo = phnNo;
		this.eurCstmsStNm = eurCstmsStNm;
		this.custNm = custNm;
		this.cstmsDeclCntCd = cstmsDeclCntCd;
		this.custAddr = custAddr;
		this.custSeq = custSeq;
		this.blNo = blNo;
		this.custCtyNm = custCtyNm;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cntCd = cntCd;
		this.faxNo = faxNo;
		this.bkgCustTpCd = bkgCustTpCd;
		this.custCntCd = custCntCd;
		this.custSteCd = custSteCd;
		this.custZipId = custZipId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("eur_cstms_st_nm", getEurCstmsStNm());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cstms_decl_cnt_cd", getCstmsDeclCntCd());
		this.hashColumns.put("cust_addr", getCustAddr());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cust_cty_nm", getCustCtyNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_ste_cd", getCustSteCd());
		this.hashColumns.put("cust_zip_id", getCustZipId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("eur_cstms_st_nm", "eurCstmsStNm");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cstms_decl_cnt_cd", "cstmsDeclCntCd");
		this.hashFields.put("cust_addr", "custAddr");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cust_cty_nm", "custCtyNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_ste_cd", "custSteCd");
		this.hashFields.put("cust_zip_id", "custZipId");
		return this.hashFields;
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
	 * @return eurCstmsStNm
	 */
	public String getEurCstmsStNm() {
		return this.eurCstmsStNm;
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
	 * @return cstmsDeclCntCd
	 */
	public String getCstmsDeclCntCd() {
		return this.cstmsDeclCntCd;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return custCtyNm
	 */
	public String getCustCtyNm() {
		return this.custCtyNm;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
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
	 * @return custZipId
	 */
	public String getCustZipId() {
		return this.custZipId;
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
	 * @param eurCstmsStNm
	 */
	public void setEurCstmsStNm(String eurCstmsStNm) {
		this.eurCstmsStNm = eurCstmsStNm;
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
	 * @param cstmsDeclCntCd
	 */
	public void setCstmsDeclCntCd(String cstmsDeclCntCd) {
		this.cstmsDeclCntCd = cstmsDeclCntCd;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param custCtyNm
	 */
	public void setCustCtyNm(String custCtyNm) {
		this.custCtyNm = custCtyNm;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
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
	 * @param custZipId
	 */
	public void setCustZipId(String custZipId) {
		this.custZipId = custZipId;
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
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setEurCstmsStNm(JSPUtil.getParameter(request, prefix + "eur_cstms_st_nm", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "cstms_decl_cnt_cd", ""));
		setCustAddr(JSPUtil.getParameter(request, prefix + "cust_addr", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCustCtyNm(JSPUtil.getParameter(request, prefix + "cust_cty_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustSteCd(JSPUtil.getParameter(request, prefix + "cust_ste_cd", ""));
		setCustZipId(JSPUtil.getParameter(request, prefix + "cust_zip_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaBlCustVO[]
	 */
	public UsaBlCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaBlCustVO[]
	 */
	public UsaBlCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaBlCustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] eurCstmsStNm = (JSPUtil.getParameter(request, prefix	+ "eur_cstms_st_nm", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] cstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_cnt_cd", length));
			String[] custAddr = (JSPUtil.getParameter(request, prefix	+ "cust_addr", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] custCtyNm = (JSPUtil.getParameter(request, prefix	+ "cust_cty_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSteCd = (JSPUtil.getParameter(request, prefix	+ "cust_ste_cd", length));
			String[] custZipId = (JSPUtil.getParameter(request, prefix	+ "cust_zip_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaBlCustVO();
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (eurCstmsStNm[i] != null)
					model.setEurCstmsStNm(eurCstmsStNm[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (cstmsDeclCntCd[i] != null)
					model.setCstmsDeclCntCd(cstmsDeclCntCd[i]);
				if (custAddr[i] != null)
					model.setCustAddr(custAddr[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (custCtyNm[i] != null)
					model.setCustCtyNm(custCtyNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSteCd[i] != null)
					model.setCustSteCd(custSteCd[i]);
				if (custZipId[i] != null)
					model.setCustZipId(custZipId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaBlCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaBlCustVO[]
	 */
	public UsaBlCustVO[] getUsaBlCustVOs(){
		UsaBlCustVO[] vos = (UsaBlCustVO[])models.toArray(new UsaBlCustVO[models.size()]);
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
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurCstmsStNm = this.eurCstmsStNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclCntCd = this.cstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr = this.custAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtyNm = this.custCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSteCd = this.custSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custZipId = this.custZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
