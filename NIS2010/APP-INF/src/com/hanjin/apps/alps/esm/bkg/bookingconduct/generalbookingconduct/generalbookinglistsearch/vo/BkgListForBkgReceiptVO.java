/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgListForBkgReceiptVO.java
*@FileTitle : BkgListForBkgReceiptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.03  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgListForBkgReceiptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgListForBkgReceiptVO> models = new ArrayList<BkgListForBkgReceiptVO>();
	
	/* Column Info */
	private String eml = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String emlDate = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String ffCd = null;
	/* Column Info */
	private String emlErr = null;
	/* Column Info */
	private String cct = null;
	/* Column Info */
	private String faxErr = null;
	/* Column Info */
	private String emlResult = null;
	/* Column Info */
	private String kind = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String shipperName = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String faxDate = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String docCct = null;
	/* Column Info */
	private String eqOfc = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String fax = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String tvvd = null;
	/* Column Info */
	private String contactPic = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String faxResult = null;
	/* Column Info */
	private String shipperCode = null;
	/* Column Info */
	private String bkgStaff = null;
	/* Column Info */
	private String railToCct = null;
	/* Column Info */
	private String railFromCct = null;
	/* Column Info */
	private String vgmCct = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgListForBkgReceiptVO() {}

	public BkgListForBkgReceiptVO(String ibflag, String pagerows, String bkgNo, String status, String kind, String shipperCode, String shipperName, String ffCd, String fax, String eml, String cct, String docCct, String tvvd, String por, String eqOfc, String pol, String pod, String del, String bkgStaff, String contactPic, String faxResult, String faxErr, String faxDate, String emlResult, String emlErr, String emlDate, String remark, String railToCct, String railFromCct, String vgmCct) {
		this.eml = eml;
		this.remark = remark;
		this.emlDate = emlDate;
		this.por = por;
		this.ffCd = ffCd;
		this.emlErr = emlErr;
		this.cct = cct;
		this.faxErr = faxErr;
		this.emlResult = emlResult;
		this.kind = kind;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.shipperName = shipperName;
		this.pol = pol;
		this.faxDate = faxDate;
		this.del = del;
		this.docCct = docCct;
		this.eqOfc = eqOfc;
		this.pod = pod;
		this.fax = fax;
		this.status = status;
		this.tvvd = tvvd;
		this.contactPic = contactPic;
		this.bkgNo = bkgNo;
		this.faxResult = faxResult;
		this.shipperCode = shipperCode;
		this.bkgStaff = bkgStaff;
		this.railToCct = railToCct;
		this.railFromCct = railFromCct;	
		this.vgmCct = vgmCct;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */ 
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eml", getEml());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("eml_date", getEmlDate());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("ff_cd", getFfCd());
		this.hashColumns.put("eml_err", getEmlErr());
		this.hashColumns.put("cct", getCct());
		this.hashColumns.put("fax_err", getFaxErr());
		this.hashColumns.put("eml_result", getEmlResult());
		this.hashColumns.put("kind", getKind());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("shipper_name", getShipperName());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("fax_date", getFaxDate());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("doc_cct", getDocCct());
		this.hashColumns.put("eq_ofc", getEqOfc());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("fax", getFax());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("tvvd", getTvvd());
		this.hashColumns.put("contact_pic", getContactPic());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("fax_result", getFaxResult());
		this.hashColumns.put("shipper_code", getShipperCode());
		this.hashColumns.put("bkg_staff", getBkgStaff());
		this.hashColumns.put("rail_to_cct", getRailToCct());
		this.hashColumns.put("rail_from_cct", getRailFromCct());	
		this.hashColumns.put("vgm_cct", getVgmCct());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eml", "eml");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("eml_date", "emlDate");
		this.hashFields.put("por", "por");
		this.hashFields.put("ff_cd", "ffCd");
		this.hashFields.put("eml_err", "emlErr");
		this.hashFields.put("cct", "cct");
		this.hashFields.put("fax_err", "faxErr");
		this.hashFields.put("eml_result", "emlResult");
		this.hashFields.put("kind", "kind");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("shipper_name", "shipperName");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("fax_date", "faxDate");
		this.hashFields.put("del", "del");
		this.hashFields.put("doc_cct", "docCct");
		this.hashFields.put("eq_ofc", "eqOfc");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("fax", "fax");
		this.hashFields.put("status", "status");
		this.hashFields.put("tvvd", "tvvd");
		this.hashFields.put("contact_pic", "contactPic");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("fax_result", "faxResult");
		this.hashFields.put("shipper_code", "shipperCode");
		this.hashFields.put("bkg_staff", "bkgStaff");
		this.hashFields.put("rail_to_cct", "railToCct");
		this.hashFields.put("rail_from_cct", "railFromCct");
		this.hashFields.put("vgm_cct", "vgmCct");	
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eml
	 */
	public String getEml() {
		return this.eml;
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
	 * @return emlDate
	 */
	public String getEmlDate() {
		return this.emlDate;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return ffCd
	 */
	public String getFfCd() {
		return this.ffCd;
	}
	
	/**
	 * Column Info
	 * @return emlErr
	 */
	public String getEmlErr() {
		return this.emlErr;
	}
	
	/**
	 * Column Info
	 * @return cct
	 */
	public String getCct() {
		return this.cct;
	}
	
	/**
	 * Column Info
	 * @return faxErr
	 */
	public String getFaxErr() {
		return this.faxErr;
	}
	
	/**
	 * Column Info
	 * @return emlResult
	 */
	public String getEmlResult() {
		return this.emlResult;
	}
	
	/**
	 * Column Info
	 * @return kind
	 */
	public String getKind() {
		return this.kind;
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
	 * @return shipperName
	 */
	public String getShipperName() {
		return this.shipperName;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return faxDate
	 */
	public String getFaxDate() {
		return this.faxDate;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return docCct
	 */
	public String getDocCct() {
		return this.docCct;
	}
	
	/**
	 * Column Info
	 * @return eqOfc
	 */
	public String getEqOfc() {
		return this.eqOfc;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return fax
	 */
	public String getFax() {
		return this.fax;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return tvvd
	 */
	public String getTvvd() {
		return this.tvvd;
	}
	
	/**
	 * Column Info
	 * @return contactPic
	 */
	public String getContactPic() {
		return this.contactPic;
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
	 * @return faxResult
	 */
	public String getFaxResult() {
		return this.faxResult;
	}
	
	/**
	 * Column Info
	 * @return shipperCode
	 */
	public String getShipperCode() {
		return this.shipperCode;
	}
	
	/**
	 * Column Info
	 * @return bkgStaff
	 */
	public String getBkgStaff() {
		return this.bkgStaff;
	}
	
	/**
	 * Column Info
	 * @return railToCct
	 */
	public String getRailToCct() {
		return this.railToCct;
	}
	
	/**
	 * Column Info
	 * @return railFromCct
	 */
	public String getRailFromCct() {
		return this.railFromCct;
	}
	
	/**
	 * Column Info
	 * @return vgmCct
	 */
	public String getVgmCct() {
		return vgmCct;
	}


	
	/**
	 * Column Info
	 * @param eml
	 */
	public void setEml(String eml) {
		this.eml = eml;
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
	 * @param emlDate
	 */
	public void setEmlDate(String emlDate) {
		this.emlDate = emlDate;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param ffCd
	 */
	public void setFfCd(String ffCd) {
		this.ffCd = ffCd;
	}
	
	/**
	 * Column Info
	 * @param emlErr
	 */
	public void setEmlErr(String emlErr) {
		this.emlErr = emlErr;
	}
	
	/**
	 * Column Info
	 * @param cct
	 */
	public void setCct(String cct) {
		this.cct = cct;
	}
	
	/**
	 * Column Info
	 * @param faxErr
	 */
	public void setFaxErr(String faxErr) {
		this.faxErr = faxErr;
	}
	
	/**
	 * Column Info
	 * @param emlResult
	 */
	public void setEmlResult(String emlResult) {
		this.emlResult = emlResult;
	}
	
	/**
	 * Column Info
	 * @param kind
	 */
	public void setKind(String kind) {
		this.kind = kind;
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
	 * @param shipperName
	 */
	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param faxDate
	 */
	public void setFaxDate(String faxDate) {
		this.faxDate = faxDate;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param docCct
	 */
	public void setDocCct(String docCct) {
		this.docCct = docCct;
	}
	
	/**
	 * Column Info
	 * @param eqOfc
	 */
	public void setEqOfc(String eqOfc) {
		this.eqOfc = eqOfc;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param tvvd
	 */
	public void setTvvd(String tvvd) {
		this.tvvd = tvvd;
	}
	
	/**
	 * Column Info
	 * @param contactPic
	 */
	public void setContactPic(String contactPic) {
		this.contactPic = contactPic;
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
	 * @param faxResult
	 */
	public void setFaxResult(String faxResult) {
		this.faxResult = faxResult;
	}
	
	/**
	 * Column Info
	 * @param shipperCode
	 */
	public void setShipperCode(String shipperCode) {
		this.shipperCode = shipperCode;
	}
	
	/**
	 * Column Info
	 * @param bkgStaff
	 */
	public void setBkgStaff(String bkgStaff) {
		this.bkgStaff = bkgStaff;
	}
	
	/**
	 * Column Info
	 * @param railToCct
	 */
	public void setRailToCct(String railToCct) {
		this.railToCct = railToCct;
	}
	
	/**
	 * Column Info
	 * @param railFromCct
	 */
	public void setRailFromCct(String railFromCct) {
		this.railFromCct = railFromCct;
	}
	
	/**
	 * Column Info
	 * @return vgmCct
	 */
	public void setVgmCct(String vgmCct) {
		this.vgmCct = vgmCct;
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
		setEml(JSPUtil.getParameter(request, prefix + "eml", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setEmlDate(JSPUtil.getParameter(request, prefix + "eml_date", ""));
		setPor(JSPUtil.getParameter(request, prefix + "por", ""));
		setFfCd(JSPUtil.getParameter(request, prefix + "ff_cd", ""));
		setEmlErr(JSPUtil.getParameter(request, prefix + "eml_err", ""));
		setCct(JSPUtil.getParameter(request, prefix + "cct", ""));
		setFaxErr(JSPUtil.getParameter(request, prefix + "fax_err", ""));
		setEmlResult(JSPUtil.getParameter(request, prefix + "eml_result", ""));
		setKind(JSPUtil.getParameter(request, prefix + "kind", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setShipperName(JSPUtil.getParameter(request, prefix + "shipper_name", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setFaxDate(JSPUtil.getParameter(request, prefix + "fax_date", ""));
		setDel(JSPUtil.getParameter(request, prefix + "del", ""));
		setDocCct(JSPUtil.getParameter(request, prefix + "doc_cct", ""));
		setEqOfc(JSPUtil.getParameter(request, prefix + "eq_ofc", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setFax(JSPUtil.getParameter(request, prefix + "fax", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setTvvd(JSPUtil.getParameter(request, prefix + "tvvd", ""));
		setContactPic(JSPUtil.getParameter(request, prefix + "contact_pic", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setFaxResult(JSPUtil.getParameter(request, prefix + "fax_result", ""));
		setShipperCode(JSPUtil.getParameter(request, prefix + "shipper_code", ""));
		setBkgStaff(JSPUtil.getParameter(request, prefix + "bkg_staff", ""));
		setRailToCct(JSPUtil.getParameter(request, prefix + "rail_to_cct", ""));
		setRailFromCct(JSPUtil.getParameter(request, prefix + "rail_from_cct", ""));
		setVgmCct(JSPUtil.getParameter(request, prefix + "vgm_cct", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgListForBkgReceiptVO[]
	 */
	public BkgListForBkgReceiptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgListForBkgReceiptVO[]
	 */
	public BkgListForBkgReceiptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgListForBkgReceiptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eml = (JSPUtil.getParameter(request, prefix	+ "eml", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] emlDate = (JSPUtil.getParameter(request, prefix	+ "eml_date", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] ffCd = (JSPUtil.getParameter(request, prefix	+ "ff_cd", length));
			String[] emlErr = (JSPUtil.getParameter(request, prefix	+ "eml_err", length));
			String[] cct = (JSPUtil.getParameter(request, prefix	+ "cct", length));
			String[] faxErr = (JSPUtil.getParameter(request, prefix	+ "fax_err", length));
			String[] emlResult = (JSPUtil.getParameter(request, prefix	+ "eml_result", length));
			String[] kind = (JSPUtil.getParameter(request, prefix	+ "kind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] shipperName = (JSPUtil.getParameter(request, prefix	+ "shipper_name", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] faxDate = (JSPUtil.getParameter(request, prefix	+ "fax_date", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] docCct = (JSPUtil.getParameter(request, prefix	+ "doc_cct", length));
			String[] eqOfc = (JSPUtil.getParameter(request, prefix	+ "eq_ofc", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] fax = (JSPUtil.getParameter(request, prefix	+ "fax", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] tvvd = (JSPUtil.getParameter(request, prefix	+ "tvvd", length));
			String[] contactPic = (JSPUtil.getParameter(request, prefix	+ "contact_pic", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] faxResult = (JSPUtil.getParameter(request, prefix	+ "fax_result", length));
			String[] shipperCode = (JSPUtil.getParameter(request, prefix	+ "shipper_code", length));
			String[] bkgStaff = (JSPUtil.getParameter(request, prefix	+ "bkg_staff", length));
			String[] railToCct = (JSPUtil.getParameter(request, prefix	+ "rail_to_cct", length));
			String[] railFromCct = (JSPUtil.getParameter(request, prefix	+ "rail_from_cct", length));
			String[] vgmCct = (JSPUtil.getParameter(request, prefix	+ "vgm_cct", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgListForBkgReceiptVO();
				if (eml[i] != null)
					model.setEml(eml[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (emlDate[i] != null)
					model.setEmlDate(emlDate[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (ffCd[i] != null)
					model.setFfCd(ffCd[i]);
				if (emlErr[i] != null)
					model.setEmlErr(emlErr[i]);
				if (cct[i] != null)
					model.setCct(cct[i]);
				if (faxErr[i] != null)
					model.setFaxErr(faxErr[i]);
				if (emlResult[i] != null)
					model.setEmlResult(emlResult[i]);
				if (kind[i] != null)
					model.setKind(kind[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (shipperName[i] != null)
					model.setShipperName(shipperName[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (faxDate[i] != null)
					model.setFaxDate(faxDate[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (docCct[i] != null)
					model.setDocCct(docCct[i]);
				if (eqOfc[i] != null)
					model.setEqOfc(eqOfc[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (fax[i] != null)
					model.setFax(fax[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (tvvd[i] != null)
					model.setTvvd(tvvd[i]);
				if (contactPic[i] != null)
					model.setContactPic(contactPic[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (faxResult[i] != null)
					model.setFaxResult(faxResult[i]);
				if (shipperCode[i] != null)
					model.setShipperCode(shipperCode[i]);
				if (bkgStaff[i] != null)
					model.setBkgStaff(bkgStaff[i]);
				if (railToCct[i] != null)
					model.setRailToCct(railToCct[i]);
				if (railFromCct[i] != null)
					model.setRailFromCct(railFromCct[i]);
				if (vgmCct[i] != null)
					model.setVgmCct(vgmCct[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgListForBkgReceiptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgListForBkgReceiptVO[]
	 */
	public BkgListForBkgReceiptVO[] getBkgListForBkgReceiptVOs(){
		BkgListForBkgReceiptVO[] vos = (BkgListForBkgReceiptVO[])models.toArray(new BkgListForBkgReceiptVO[models.size()]);
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
		this.eml = this.eml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlDate = this.emlDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCd = this.ffCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlErr = this.emlErr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct = this.cct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxErr = this.faxErr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlResult = this.emlResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind = this.kind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperName = this.shipperName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxDate = this.faxDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docCct = this.docCct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOfc = this.eqOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax = this.fax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvvd = this.tvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contactPic = this.contactPic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxResult = this.faxResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperCode = this.shipperCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStaff = this.bkgStaff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railToCct = this.railToCct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railFromCct = this.railFromCct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCct = this.vgmCct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
