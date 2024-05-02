/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : IfSchemaVO.java
*@FileTitle : IfSchemaVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.07
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2011.10.07 최종혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.servicesio.webdo.vo;

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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IfSchemaVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IfSchemaVO> models = new ArrayList<IfSchemaVO>();
	
	/* Column Info */
	private String usrPhnNo = null;
	/* Column Info */
	private String actCustCtyNm = null;
	/* Column Info */
	private String actCustZipCd = null;
	/* Column Info */
	private String actCustN1stAddr = null;
	/* Column Info */
	private String actCustSteNm = null;
	/* Column Info */
	private String doRmk = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cntcPsonPhnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntcPsonFaxNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String fctryNm = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String ifSysKndCd = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IfSchemaVO() {}

	public IfSchemaVO(String ibflag, String pagerows, String blNo, String ifSysKndCd, String fctryNm, String actCustN1stAddr, String actCustCtyNm, String actCustSteNm, String actCustZipCd, String cntcPsonNm, String cntcPsonPhnNo, String cntcPsonFaxNo, String usrEml, String usrPhnNo, String creOfcCd, String eqNo, String doRmk, String creUsrId, String updUsrId) {
		this.usrPhnNo = usrPhnNo;
		this.actCustCtyNm = actCustCtyNm;
		this.actCustZipCd = actCustZipCd;
		this.actCustN1stAddr = actCustN1stAddr;
		this.actCustSteNm = actCustSteNm;
		this.doRmk = doRmk;
		this.blNo = blNo;
		this.cntcPsonPhnNo = cntcPsonPhnNo;
		this.pagerows = pagerows;
		this.cntcPsonFaxNo = cntcPsonFaxNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.fctryNm = fctryNm;
		this.creOfcCd = creOfcCd;
		this.cntcPsonNm = cntcPsonNm;
		this.ifSysKndCd = ifSysKndCd;
		this.usrEml = usrEml;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("usr_phn_no", getUsrPhnNo());
		this.hashColumns.put("act_cust_cty_nm", getActCustCtyNm());
		this.hashColumns.put("act_cust_zip_cd", getActCustZipCd());
		this.hashColumns.put("act_cust_n1st_addr", getActCustN1stAddr());
		this.hashColumns.put("act_cust_ste_nm", getActCustSteNm());
		this.hashColumns.put("do_rmk", getDoRmk());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cntc_pson_phn_no", getCntcPsonPhnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntc_pson_fax_no", getCntcPsonFaxNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("fctry_nm", getFctryNm());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("if_sys_knd_cd", getIfSysKndCd());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("usr_phn_no", "usrPhnNo");
		this.hashFields.put("act_cust_cty_nm", "actCustCtyNm");
		this.hashFields.put("act_cust_zip_cd", "actCustZipCd");
		this.hashFields.put("act_cust_n1st_addr", "actCustN1stAddr");
		this.hashFields.put("act_cust_ste_nm", "actCustSteNm");
		this.hashFields.put("do_rmk", "doRmk");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cntc_pson_phn_no", "cntcPsonPhnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntc_pson_fax_no", "cntcPsonFaxNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("fctry_nm", "fctryNm");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("if_sys_knd_cd", "ifSysKndCd");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return usrPhnNo
	 */
	public String getUsrPhnNo() {
		return this.usrPhnNo;
	}
	
	/**
	 * Column Info
	 * @return actCustCtyNm
	 */
	public String getActCustCtyNm() {
		return this.actCustCtyNm;
	}
	
	/**
	 * Column Info
	 * @return actCustZipCd
	 */
	public String getActCustZipCd() {
		return this.actCustZipCd;
	}
	
	/**
	 * Column Info
	 * @return actCustN1stAddr
	 */
	public String getActCustN1stAddr() {
		return this.actCustN1stAddr;
	}
	
	/**
	 * Column Info
	 * @return actCustSteNm
	 */
	public String getActCustSteNm() {
		return this.actCustSteNm;
	}
	
	/**
	 * Column Info
	 * @return doRmk
	 */
	public String getDoRmk() {
		return this.doRmk;
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
	 * @return cntcPsonPhnNo
	 */
	public String getCntcPsonPhnNo() {
		return this.cntcPsonPhnNo;
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
	 * @return cntcPsonFaxNo
	 */
	public String getCntcPsonFaxNo() {
		return this.cntcPsonFaxNo;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return fctryNm
	 */
	public String getFctryNm() {
		return this.fctryNm;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return ifSysKndCd
	 */
	public String getIfSysKndCd() {
		return this.ifSysKndCd;
	}
	
	/**
	 * Column Info
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
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
	 * @param usrPhnNo
	 */
	public void setUsrPhnNo(String usrPhnNo) {
		this.usrPhnNo = usrPhnNo;
	}
	
	/**
	 * Column Info
	 * @param actCustCtyNm
	 */
	public void setActCustCtyNm(String actCustCtyNm) {
		this.actCustCtyNm = actCustCtyNm;
	}
	
	/**
	 * Column Info
	 * @param actCustZipCd
	 */
	public void setActCustZipCd(String actCustZipCd) {
		this.actCustZipCd = actCustZipCd;
	}
	
	/**
	 * Column Info
	 * @param actCustN1stAddr
	 */
	public void setActCustN1stAddr(String actCustN1stAddr) {
		this.actCustN1stAddr = actCustN1stAddr;
	}
	
	/**
	 * Column Info
	 * @param actCustSteNm
	 */
	public void setActCustSteNm(String actCustSteNm) {
		this.actCustSteNm = actCustSteNm;
	}
	
	/**
	 * Column Info
	 * @param doRmk
	 */
	public void setDoRmk(String doRmk) {
		this.doRmk = doRmk;
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
	 * @param cntcPsonPhnNo
	 */
	public void setCntcPsonPhnNo(String cntcPsonPhnNo) {
		this.cntcPsonPhnNo = cntcPsonPhnNo;
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
	 * @param cntcPsonFaxNo
	 */
	public void setCntcPsonFaxNo(String cntcPsonFaxNo) {
		this.cntcPsonFaxNo = cntcPsonFaxNo;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param fctryNm
	 */
	public void setFctryNm(String fctryNm) {
		this.fctryNm = fctryNm;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param ifSysKndCd
	 */
	public void setIfSysKndCd(String ifSysKndCd) {
		this.ifSysKndCd = ifSysKndCd;
	}
	
	/**
	 * Column Info
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUsrPhnNo(JSPUtil.getParameter(request, prefix + "usr_phn_no", ""));
		setActCustCtyNm(JSPUtil.getParameter(request, prefix + "act_cust_cty_nm", ""));
		setActCustZipCd(JSPUtil.getParameter(request, prefix + "act_cust_zip_cd", ""));
		setActCustN1stAddr(JSPUtil.getParameter(request, prefix + "act_cust_n1st_addr", ""));
		setActCustSteNm(JSPUtil.getParameter(request, prefix + "act_cust_ste_nm", ""));
		setDoRmk(JSPUtil.getParameter(request, prefix + "do_rmk", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCntcPsonPhnNo(JSPUtil.getParameter(request, prefix + "cntc_pson_phn_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntcPsonFaxNo(JSPUtil.getParameter(request, prefix + "cntc_pson_fax_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setFctryNm(JSPUtil.getParameter(request, prefix + "fctry_nm", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
		setIfSysKndCd(JSPUtil.getParameter(request, prefix + "if_sys_knd_cd", ""));
		setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IfSchemaVO[]
	 */
	public IfSchemaVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IfSchemaVO[]
	 */
	public IfSchemaVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IfSchemaVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] usrPhnNo = (JSPUtil.getParameter(request, prefix	+ "usr_phn_no", length));
			String[] actCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "act_cust_cty_nm", length));
			String[] actCustZipCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_zip_cd", length));
			String[] actCustN1stAddr = (JSPUtil.getParameter(request, prefix	+ "act_cust_n1st_addr", length));
			String[] actCustSteNm = (JSPUtil.getParameter(request, prefix	+ "act_cust_ste_nm", length));
			String[] doRmk = (JSPUtil.getParameter(request, prefix	+ "do_rmk", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cntcPsonPhnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_phn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntcPsonFaxNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_fax_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] fctryNm = (JSPUtil.getParameter(request, prefix	+ "fctry_nm", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] ifSysKndCd = (JSPUtil.getParameter(request, prefix	+ "if_sys_knd_cd", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new IfSchemaVO();
				if (usrPhnNo[i] != null)
					model.setUsrPhnNo(usrPhnNo[i]);
				if (actCustCtyNm[i] != null)
					model.setActCustCtyNm(actCustCtyNm[i]);
				if (actCustZipCd[i] != null)
					model.setActCustZipCd(actCustZipCd[i]);
				if (actCustN1stAddr[i] != null)
					model.setActCustN1stAddr(actCustN1stAddr[i]);
				if (actCustSteNm[i] != null)
					model.setActCustSteNm(actCustSteNm[i]);
				if (doRmk[i] != null)
					model.setDoRmk(doRmk[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cntcPsonPhnNo[i] != null)
					model.setCntcPsonPhnNo(cntcPsonPhnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntcPsonFaxNo[i] != null)
					model.setCntcPsonFaxNo(cntcPsonFaxNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (fctryNm[i] != null)
					model.setFctryNm(fctryNm[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (ifSysKndCd[i] != null)
					model.setIfSysKndCd(ifSysKndCd[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIfSchemaVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IfSchemaVO[]
	 */
	public IfSchemaVO[] getIfSchemaVOs(){
		IfSchemaVO[] vos = (IfSchemaVO[])models.toArray(new IfSchemaVO[models.size()]);
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
		this.usrPhnNo = this.usrPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCtyNm = this.actCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustZipCd = this.actCustZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustN1stAddr = this.actCustN1stAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSteNm = this.actCustSteNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doRmk = this.doRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonPhnNo = this.cntcPsonPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonFaxNo = this.cntcPsonFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctryNm = this.fctryNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSysKndCd = this.ifSysKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
