/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualInvoiceIssueParmVO.java
*@FileTitle : ManualInvoiceIssueParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.11.25 문중철 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ManualInvoiceIssueParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManualInvoiceIssueParmVO> models = new ArrayList<ManualInvoiceIssueParmVO>();
	
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String grpbyor = null;
	/* Column Info */
	private String tmpOfcCd = null;
	/* Column Info */
	private String hUserOffice = null;
	/* Column Info */
	private String reasoncd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcFlg = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chkSubOfc = null;
	/* Column Info */
	private String usrRhqOfcCd = null;
	/* Column Info */
	private String selcur = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ManualInvoiceIssueParmVO() {}

	public ManualInvoiceIssueParmVO(String ibflag, String pagerows, String office, String fmDt, String grpbyor, String tmpOfcCd, String hUserOffice, String reasoncd, String ofcFlg, String toDt, String ofcCd, String chkSubOfc, String usrRhqOfcCd, String selcur) {
		this.office = office;
		this.fmDt = fmDt;
		this.grpbyor = grpbyor;
		this.tmpOfcCd = tmpOfcCd;
		this.hUserOffice = hUserOffice;
		this.reasoncd = reasoncd;
		this.pagerows = pagerows;
		this.ofcFlg = ofcFlg;
		this.toDt = toDt;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.chkSubOfc = chkSubOfc;
		this.usrRhqOfcCd = usrRhqOfcCd;
		this.selcur = selcur;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("grpbyor", getGrpbyor());
		this.hashColumns.put("tmp_ofc_cd", getTmpOfcCd());
		this.hashColumns.put("h_user_office", getHUserOffice());
		this.hashColumns.put("reasoncd", getReasoncd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_flg", getOfcFlg());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chk_sub_ofc", getChkSubOfc());
		this.hashColumns.put("usr_rhq_ofc_cd", getUsrRhqOfcCd());
		this.hashColumns.put("selcur", getSelcur());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("grpbyor", "grpbyor");
		this.hashFields.put("tmp_ofc_cd", "tmpOfcCd");
		this.hashFields.put("h_user_office", "hUserOffice");
		this.hashFields.put("reasoncd", "reasoncd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_flg", "ofcFlg");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chk_sub_ofc", "chkSubOfc");
		this.hashFields.put("usr_rhq_ofc_cd", "usrRhqOfcCd");
		this.hashFields.put("selcur", "selcur");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return grpbyor
	 */
	public String getGrpbyor() {
		return this.grpbyor;
	}
	
	/**
	 * Column Info
	 * @return tmpOfcCd
	 */
	public String getTmpOfcCd() {
		return this.tmpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return hUserOffice
	 */
	public String getHUserOffice() {
		return this.hUserOffice;
	}
	
	/**
	 * Column Info
	 * @return reasoncd
	 */
	public String getReasoncd() {
		return this.reasoncd;
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
	 * @return ofcFlg
	 */
	public String getOfcFlg() {
		return this.ofcFlg;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return chkSubOfc
	 */
	public String getChkSubOfc() {
		return this.chkSubOfc;
	}
	
	/**
	 * Column Info
	 * @return usrRhqOfcCd
	 */
	public String getUsrRhqOfcCd() {
		return this.usrRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return selcur
	 */
	public String getSelcur() {
		return this.selcur;
	}
	

	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param grpbyor
	 */
	public void setGrpbyor(String grpbyor) {
		this.grpbyor = grpbyor;
	}
	
	/**
	 * Column Info
	 * @param tmpOfcCd
	 */
	public void setTmpOfcCd(String tmpOfcCd) {
		this.tmpOfcCd = tmpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param hUserOffice
	 */
	public void setHUserOffice(String hUserOffice) {
		this.hUserOffice = hUserOffice;
	}
	
	/**
	 * Column Info
	 * @param reasoncd
	 */
	public void setReasoncd(String reasoncd) {
		this.reasoncd = reasoncd;
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
	 * @param ofcFlg
	 */
	public void setOfcFlg(String ofcFlg) {
		this.ofcFlg = ofcFlg;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param chkSubOfc
	 */
	public void setChkSubOfc(String chkSubOfc) {
		this.chkSubOfc = chkSubOfc;
	}
	
	/**
	 * Column Info
	 * @param usrRhqOfcCd
	 */
	public void setUsrRhqOfcCd(String usrRhqOfcCd) {
		this.usrRhqOfcCd = usrRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param selcur
	 */
	public void setSelcur(String selcur) {
		this.selcur = selcur;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setGrpbyor(JSPUtil.getParameter(request, "grpbyor", ""));
		setTmpOfcCd(JSPUtil.getParameter(request, "tmp_ofc_cd", ""));
		setHUserOffice(JSPUtil.getParameter(request, "h_user_office", ""));
		setReasoncd(JSPUtil.getParameter(request, "reasoncd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcFlg(JSPUtil.getParameter(request, "ofc_flg", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setChkSubOfc(JSPUtil.getParameter(request, "chk_sub_ofc", ""));
		setUsrRhqOfcCd(JSPUtil.getParameter(request, "usr_rhq_ofc_cd", ""));
		setSelcur(JSPUtil.getParameter(request, "selcur", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManualInvoiceIssueParmVO[]
	 */
	public ManualInvoiceIssueParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManualInvoiceIssueParmVO[]
	 */
	public ManualInvoiceIssueParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ManualInvoiceIssueParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] grpbyor = (JSPUtil.getParameter(request, prefix	+ "grpbyor", length));
			String[] tmpOfcCd = (JSPUtil.getParameter(request, prefix	+ "tmp_ofc_cd", length));
			String[] hUserOffice = (JSPUtil.getParameter(request, prefix	+ "h_user_office", length));
			String[] reasoncd = (JSPUtil.getParameter(request, prefix	+ "reasoncd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_flg", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chkSubOfc = (JSPUtil.getParameter(request, prefix	+ "chk_sub_ofc", length));
			String[] usrRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_rhq_ofc_cd", length));
			String[] selcur = (JSPUtil.getParameter(request, prefix	+ "selcur", length));
			
			for (int i = 0; i < length; i++) {
				model = new ManualInvoiceIssueParmVO();
				if (office[i] != null)
					model.setOffice(office[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (grpbyor[i] != null)
					model.setGrpbyor(grpbyor[i]);
				if (tmpOfcCd[i] != null)
					model.setTmpOfcCd(tmpOfcCd[i]);
				if (hUserOffice[i] != null)
					model.setHUserOffice(hUserOffice[i]);
				if (reasoncd[i] != null)
					model.setReasoncd(reasoncd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcFlg[i] != null)
					model.setOfcFlg(ofcFlg[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chkSubOfc[i] != null)
					model.setChkSubOfc(chkSubOfc[i]);
				if (usrRhqOfcCd[i] != null)
					model.setUsrRhqOfcCd(usrRhqOfcCd[i]);
				if (selcur[i] != null)
					model.setSelcur(selcur[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getManualInvoiceIssueParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ManualInvoiceIssueParmVO[]
	 */
	public ManualInvoiceIssueParmVO[] getManualInvoiceIssueParmVOs(){
		ManualInvoiceIssueParmVO[] vos = (ManualInvoiceIssueParmVO[])models.toArray(new ManualInvoiceIssueParmVO[models.size()]);
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
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpbyor = this.grpbyor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpOfcCd = this.tmpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hUserOffice = this.hUserOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reasoncd = this.reasoncd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcFlg = this.ofcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkSubOfc = this.chkSubOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRhqOfcCd = this.usrRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selcur = this.selcur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
