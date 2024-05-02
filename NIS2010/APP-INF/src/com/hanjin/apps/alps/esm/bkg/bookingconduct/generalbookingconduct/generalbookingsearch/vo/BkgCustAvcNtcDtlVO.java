/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgCustAvcNtcDtlVO.java
*@FileTitle : BkgCustAvcNtcDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.12  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCustAvcNtcDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCustAvcNtcDtlVO> models = new ArrayList<BkgCustAvcNtcDtlVO>();
	
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String custName = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String faxSndDt = null;
	/* Column Info */
	private String faxSndGdt = null;
	/* Column Info */
	private String ntcFaxSndId = null;
	/* Column Info */
	private String ntcEml = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String emlSndGdt = null;
	/* Column Info */
	private String ntcEmlSndId = null;
	/* Column Info */
	private String srcDatTpCd = null;
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCustAvcNtcDtlVO() {}

	public BkgCustAvcNtcDtlVO(String ibflag, String pagerows, String blNo, String bkgCustTpCd, String custName, String faxNo, String faxSndDt, String faxSndGdt, String ntcFaxSndId, String ntcEml, String emlSndDt, String emlSndGdt, String ntcEmlSndId, String srcDatTpCd) {
		this.blNo = blNo;
		this.bkgCustTpCd = bkgCustTpCd;
		this.custName = custName;
		this.faxNo = faxNo;
		this.faxSndDt = faxSndDt;
		this.faxSndGdt = faxSndGdt;
		this.ntcFaxSndId = ntcFaxSndId;
		this.ntcEml = ntcEml;
		this.emlSndDt = emlSndDt;
		this.emlSndGdt = emlSndGdt;
		this.ntcEmlSndId = ntcEmlSndId;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.srcDatTpCd = srcDatTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("cust_name", getCustName());
		this.hashColumns.put("pagerows", "pagerows");
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("fax_snd_dt", getFaxSndDt());
		this.hashColumns.put("fax_snd_gdt", getFaxSndGdt());
		this.hashColumns.put("ntc_fax_snd_id", getNtcFaxSndId());
		this.hashColumns.put("ntc_eml", getNtcEml());
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("eml_snd_gdt", getEmlSndGdt());
		this.hashColumns.put("ntc_eml_snd_id", getNtcEmlSndId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("src_dat_tp_cd", getSrcDatTpCd());
		

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("cust_name", "custName");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("fax_snd_dt", "faxSndDt");
		this.hashFields.put("fax_snd_gdt", "faxSndGdt");
		this.hashFields.put("ntc_fax_snd_id", "ntcFaxSndId");
		this.hashFields.put("ntc_eml", "ntcEml");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("eml_snd_gdt", "emlSndGdt");
		this.hashFields.put("ntc_eml_snd_id", "ntcEmlSndId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("src_dat_tp_cd", "srcDatTpCd");
		return this.hashFields;
	}
	
public Collection<BkgCustAvcNtcDtlVO> getModels() {
		return models;
	}

	public void setModels(Collection<BkgCustAvcNtcDtlVO> models) {
		this.models = models;
	}

	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getBkgCustTpCd() {
		return bkgCustTpCd;
	}

	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPagerows() {
		return pagerows;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getFaxSndDt() {
		return faxSndDt;
	}

	public void setFaxSndDt(String faxSndDt) {
		this.faxSndDt = faxSndDt;
	}

	public String getFaxSndGdt() {
		return faxSndGdt;
	}

	public void setFaxSndGdt(String faxSndGdt) {
		this.faxSndGdt = faxSndGdt;
	}

	public String getNtcFaxSndId() {
		return ntcFaxSndId;
	}

	public void setNtcFaxSndId(String ntcFaxSndId) {
		this.ntcFaxSndId = ntcFaxSndId;
	}

	public String getNtcEml() {
		return ntcEml;
	}

	public void setNtcEml(String ntcEml) {
		this.ntcEml = ntcEml;
	}

	public String getEmlSndDt() {
		return emlSndDt;
	}

	public void setEmlSndDt(String emlSndDt) {
		this.emlSndDt = emlSndDt;
	}

	public String getEmlSndGdt() {
		return emlSndGdt;
	}

	public void setEmlSndGdt(String emlSndGdt) {
		this.emlSndGdt = emlSndGdt;
	}

	public String getNtcEmlSndId() {
		return ntcEmlSndId;
	}

	public void setNtcEmlSndId(String ntcEmlSndId) {
		this.ntcEmlSndId = ntcEmlSndId;
	}

	/**
	 * Column Info
	 * @return srcDatTpCd
	 */
	public String getSrcDatTpCd() {
		return this.srcDatTpCd;
	}
	
	/**
	 * Column Info
	 * @param srcDatTpCd
	 */
	public void setSrcDatTpCd(String srcDatTpCd) {
		this.srcDatTpCd = srcDatTpCd;
	}
	
	public String getIbflag() {
		return ibflag;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	public HashMap<String, String> getHashColumns() {
		return hashColumns;
	}

	public void setHashColumns(HashMap<String, String> hashColumns) {
		this.hashColumns = hashColumns;
	}

	public HashMap<String, String> getHashFields() {
		return hashFields;
	}

	public void setHashFields(HashMap<String, String> hashFields) {
		this.hashFields = hashFields;
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
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setCustName(JSPUtil.getParameter(request, prefix + "cust_name", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setFaxSndDt(JSPUtil.getParameter(request, prefix + "fax_snd_dt", ""));
		setFaxSndGdt(JSPUtil.getParameter(request, prefix + "fax_snd_gdt", ""));
		setNtcFaxSndId(JSPUtil.getParameter(request, prefix + "ntc_fax_snd_id", ""));
		setNtcEml(JSPUtil.getParameter(request, prefix + "ntc_eml", ""));
		setEmlSndDt(JSPUtil.getParameter(request, prefix + "eml_snd_dt", ""));
		setEmlSndGdt(JSPUtil.getParameter(request, prefix + "eml_snd_gdt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNtcEmlSndId(JSPUtil.getParameter(request, prefix + "ntc_eml_snd_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrcDatTpCd(JSPUtil.getParameter(request, prefix + "src_dat_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCustAvcNtcDtlVO[]
	 */
	public BkgCustAvcNtcDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCustAvcNtcDtlVO[]
	 */
	public BkgCustAvcNtcDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCustAvcNtcDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] custName = (JSPUtil.getParameter(request, prefix + "cust_name", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] faxSndDt = (JSPUtil.getParameter(request, prefix	+ "fax_snd_dt", length));
			String[] faxSndGdt = (JSPUtil.getParameter(request, prefix	+ "fax_snd_gdt", length));
			String[] ntcFaxSndId = (JSPUtil.getParameter(request, prefix	+ "ntc_fax_snd_id", length));
			String[] ntcEml = (JSPUtil.getParameter(request, prefix	+ "ntc_eml", length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] emlSndGdt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_gdt", length));
			String[] ntcEmlSndId = (JSPUtil.getParameter(request, prefix	+ "ntc_eml_snd_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srcDatTpCd = (JSPUtil.getParameter(request, prefix	+ "src_dat_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCustAvcNtcDtlVO();
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (custName[i] != null)
					model.setCustName(custName[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (faxSndDt[i] != null)
					model.setFaxSndDt(faxSndDt[i]);
				if (faxSndGdt[i] != null)
					model.setFaxSndGdt(faxSndGdt[i]);
				if (ntcFaxSndId[i] != null)
					model.setNtcFaxSndId(ntcFaxSndId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ntcEml[i] != null)
					model.setNtcEml(ntcEml[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (emlSndGdt[i] != null)
					model.setEmlSndGdt(emlSndGdt[i]);
				if (ntcEmlSndId[i] != null)
					model.setNtcEmlSndId(ntcEmlSndId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srcDatTpCd[i] != null)
					model.setSrcDatTpCd(srcDatTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCustAvcNtcDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCustAvcNtcDtlVO[]
	 */
	public BkgCustAvcNtcDtlVO[] getBkgCustAvcNtcDtlVOs(){
		BkgCustAvcNtcDtlVO[] vos = (BkgCustAvcNtcDtlVO[])models.toArray(new BkgCustAvcNtcDtlVO[models.size()]);
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
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custName = this.custName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndDt = this.faxSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndGdt = this.faxSndGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcFaxSndId = this.ntcFaxSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml = this.ntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndGdt = this.emlSndGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEmlSndId = this.ntcEmlSndId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcDatTpCd = this.srcDatTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
