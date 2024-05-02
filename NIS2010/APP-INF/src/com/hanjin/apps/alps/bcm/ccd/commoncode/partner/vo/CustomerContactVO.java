/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerContactVO.java
*@FileTitle : CustomerContactVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo;
 
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

public class CustomerContactVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomerContactVO> models = new ArrayList<CustomerContactVO>();
	
	/* Column Info */
	private String custCntcPntSeq = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String eaiIfId = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custEml = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custUrl = null;
	/* Column Info */
	private String custIp = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String intlFaxNo = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String intlPhnNo = null;
	/* Column Info */
	private String prmryChkFlg = null;
	/* Column Info */
	private String payRqstLtrFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomerContactVO() {}

	public CustomerContactVO(String ibflag, String pagerows, String custCntCd, String custSeq, String custCntcPntSeq, String custEml, String custIp, String custUrl, String intlPhnNo, String phnNo, String intlFaxNo, String faxNo, String eaiEvntDt, String eaiIfId, String prmryChkFlg, String payRqstLtrFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.custCntcPntSeq = custCntcPntSeq;
		this.phnNo = phnNo;
		this.eaiIfId = eaiIfId;
		this.eaiEvntDt = eaiEvntDt;
		this.custSeq = custSeq;
		this.custEml = custEml;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.custUrl = custUrl;
		this.custIp = custIp;
		this.faxNo = faxNo;
		this.intlFaxNo = intlFaxNo;
		this.custCntCd = custCntCd;
		this.intlPhnNo = intlPhnNo;
		this.prmryChkFlg = prmryChkFlg;
		this.payRqstLtrFlg = payRqstLtrFlg;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_cntc_pnt_seq", getCustCntcPntSeq());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("eai_if_id", getEaiIfId());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_url", getCustUrl());
		this.hashColumns.put("cust_ip", getCustIp());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("intl_fax_no", getIntlFaxNo());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("intl_phn_no", getIntlPhnNo());
		this.hashColumns.put("prmry_chk_flg", getPrmryChkFlg());
		this.hashColumns.put("pay_rqst_ltr_flg", getPayRqstLtrFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_cntc_pnt_seq", "custCntcPntSeq");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("eai_if_id", "eaiIfId");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_url", "custUrl");
		this.hashFields.put("cust_ip", "custIp");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("intl_fax_no", "intlFaxNo");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("intl_phn_no", "intlPhnNo");
		this.hashFields.put("prmry_chk_flg", "prmryChkFlg");
		this.hashFields.put("pay_rqst_ltr_flg", "payRqstLtrFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custCntcPntSeq
	 */
	public String getCustCntcPntSeq() {
		return this.custCntcPntSeq;
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
	 * @return eaiIfId
	 */
	public String getEaiIfId() {
		return this.eaiIfId;
	}
	
	/**
	 * Column Info
	 * @return eaiEvntDt
	 */
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
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
	 * @return custEml
	 */
	public String getCustEml() {
		return this.custEml;
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
	 * @return custUrl
	 */
	public String getCustUrl() {
		return this.custUrl;
	}
	
	/**
	 * Column Info
	 * @return custIp
	 */
	public String getCustIp() {
		return this.custIp;
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
	 * @return intlFaxNo
	 */
	public String getIntlFaxNo() {
		return this.intlFaxNo;
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
	 * @return intlPhnNo
	 */
	public String getIntlPhnNo() {
		return this.intlPhnNo;
	}
	

	/**
	 * Column Info
	 * @param custCntcPntSeq
	 */
	public void setCustCntcPntSeq(String custCntcPntSeq) {
		this.custCntcPntSeq = custCntcPntSeq;
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
	 * @param eaiIfId
	 */
	public void setEaiIfId(String eaiIfId) {
		this.eaiIfId = eaiIfId;
	}
	
	/**
	 * Column Info
	 * @param eaiEvntDt
	 */
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
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
	 * @param custEml
	 */
	public void setCustEml(String custEml) {
		this.custEml = custEml;
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
	 * @param custUrl
	 */
	public void setCustUrl(String custUrl) {
		this.custUrl = custUrl;
	}
	
	/**
	 * Column Info
	 * @param custIp
	 */
	public void setCustIp(String custIp) {
		this.custIp = custIp;
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
	 * @param intlFaxNo
	 */
	public void setIntlFaxNo(String intlFaxNo) {
		this.intlFaxNo = intlFaxNo;
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
	 * @param intlPhnNo
	 */
	public void setIntlPhnNo(String intlPhnNo) {
		this.intlPhnNo = intlPhnNo;
	}
	
	public String getPrmryChkFlg() {
		return prmryChkFlg;
	}

	public void setPrmryChkFlg(String prmryChkFlg) {
		this.prmryChkFlg = prmryChkFlg;
	}

	public String getPayRqstLtrFlg() {
		return payRqstLtrFlg;
	}

	public void setPayRqstLtrFlg(String payRqstLtrFlg) {
		this.payRqstLtrFlg = payRqstLtrFlg;
	}
	
	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getCreDt() {
		return creDt;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
		setCustCntcPntSeq(JSPUtil.getParameter(request, prefix + "cust_cntc_pnt_seq", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCustUrl(JSPUtil.getParameter(request, prefix + "cust_url", ""));
		setCustIp(JSPUtil.getParameter(request, prefix + "cust_ip", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setIntlFaxNo(JSPUtil.getParameter(request, prefix + "intl_fax_no", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
		setIntlPhnNo(JSPUtil.getParameter(request, prefix + "prmry_chk_flg", ""));
		setIntlPhnNo(JSPUtil.getParameter(request, prefix + "pay_rqst_ltr_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomerContractVO[]
	 */
	public CustomerContactVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomerContractVO[]
	 */
	public CustomerContactVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomerContactVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custCntcPntSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_pnt_seq", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] eaiIfId = (JSPUtil.getParameter(request, prefix	+ "eai_if_id", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custUrl = (JSPUtil.getParameter(request, prefix	+ "cust_url", length));
			String[] custIp = (JSPUtil.getParameter(request, prefix	+ "cust_ip", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] intlFaxNo = (JSPUtil.getParameter(request, prefix	+ "intl_fax_no", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] intlPhnNo = (JSPUtil.getParameter(request, prefix	+ "intl_phn_no", length));
			String[] prmryChkFlg = (JSPUtil.getParameter(request, prefix	+ "prmry_chk_flg", length));
			String[] payRqstLtrFlg = (JSPUtil.getParameter(request, prefix	+ "pay_rqst_ltr_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));

			for (int i = 0; i < length; i++) {
				model = new CustomerContactVO();
				if (custCntcPntSeq[i] != null)
					model.setCustCntcPntSeq(custCntcPntSeq[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (eaiIfId[i] != null)
					model.setEaiIfId(eaiIfId[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custEml[i] != null)
					model.setCustEml(custEml[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custUrl[i] != null)
					model.setCustUrl(custUrl[i]);
				if (custIp[i] != null)
					model.setCustIp(custIp[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (intlFaxNo[i] != null)
					model.setIntlFaxNo(intlFaxNo[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (intlPhnNo[i] != null)
					model.setIntlPhnNo(intlPhnNo[i]);
				if (prmryChkFlg[i] != null)
					model.setPrmryChkFlg(prmryChkFlg[i]);
				if (payRqstLtrFlg[i] != null)
					model.setPayRqstLtrFlg(payRqstLtrFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomerContractVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomerContractVO[]
	 */
	public CustomerContactVO[] getCustomerContractVOs(){
		CustomerContactVO[] vos = (CustomerContactVO[])models.toArray(new CustomerContactVO[models.size()]);
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
		this.custCntcPntSeq = this.custCntcPntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId = this.eaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custUrl = this.custUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custIp = this.custIp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlFaxNo = this.intlFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlPhnNo = this.intlPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prmryChkFlg = this.prmryChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payRqstLtrFlg = this.payRqstLtrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
