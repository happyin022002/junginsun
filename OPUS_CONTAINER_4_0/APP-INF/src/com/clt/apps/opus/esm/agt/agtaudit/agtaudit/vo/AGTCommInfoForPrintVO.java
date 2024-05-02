/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTCommInfoForPrint1VO.java
*@FileTitle : AGTCommInfoForPrint1VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.10.22 이호진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AGTCommInfoForPrintVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AGTCommInfoForPrintVO> models = new ArrayList<AGTCommInfoForPrintVO>();
	
	/* Column Info */
	private String hdrCsrNo = null;
	/* Column Info */
	private String hdrPayTo = null;
	/* Column Info */
	private String hdrDesc = null;
	/* Column Info */
	private String hdrAmount = null;
	/* Column Info */
	private String hdrAmt = null;
	/* Column Info */
	private String hdrDueDt = null;
	/* Column Info */
	private String hdrAsaNo = null;
	/* Column Info */
	private String hdrPrpdBy = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hdrOffice = null;
	/* Column Info */
	private String hdrEviTp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hdrTitle = null;
	/* Column Info */
	private String hdrCurrCd = null;
	/* Column Info */
	private String hdrCsrType = null;
	/* Column Info */
	private String hdrInvDt = null;
	/* Column Info */
	private String hdrPayGrp = null;
	/* Column Info */
	private String hdrApprdBy = null;
	
	private String hCsrNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AGTCommInfoForPrintVO() {}

	public AGTCommInfoForPrintVO(String ibflag, String pagerows, String hdrTitle, String hdrCsrNo, String hdrOffice, String hdrPrpdBy, String hdrPayTo, String hdrCsrType, String hdrDesc, String hdrPayGrp, String hdrEviTp, String hdrDueDt, String hdrAsaNo, String hdrInvDt, String hdrCurrCd, String hdrApprdBy, String hdrAmount, String hCsrNo) {
		this.hdrCsrNo = hdrCsrNo;
		this.hdrPayTo = hdrPayTo;
		this.hdrDesc = hdrDesc;
		this.hdrAmount = hdrAmount;
		this.hdrAmt = hdrAmount;
		this.hdrDueDt = hdrDueDt;
		this.hdrAsaNo = hdrAsaNo;
		this.hdrPrpdBy = hdrPrpdBy;
		this.pagerows = pagerows;
		this.hdrOffice = hdrOffice;
		this.hdrEviTp = hdrEviTp;
		this.ibflag = ibflag;
		this.hdrTitle = hdrTitle;
		this.hdrCurrCd = hdrCurrCd;
		this.hdrCsrType = hdrCsrType;
		this.hdrInvDt = hdrInvDt;
		this.hdrPayGrp = hdrPayGrp;
		this.hdrApprdBy = hdrApprdBy;
		this.hCsrNo = hCsrNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hdr_csr_no", getHdrCsrNo());
		this.hashColumns.put("hdr_pay_to", getHdrPayTo());
		this.hashColumns.put("hdr_desc", getHdrDesc());
		this.hashColumns.put("hdr_amount", getHdrAmount());
		this.hashColumns.put("hdr_amt", getHdrAmt());
		this.hashColumns.put("hdr_due_dt", getHdrDueDt());
		this.hashColumns.put("hdr_asa_no", getHdrAsaNo());
		this.hashColumns.put("hdr_prpd_by", getHdrPrpdBy());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hdr_office", getHdrOffice());
		this.hashColumns.put("hdr_evi_tp", getHdrEviTp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hdr_title", getHdrTitle());
		this.hashColumns.put("hdr_curr_cd", getHdrCurrCd());
		this.hashColumns.put("hdr_csr_type", getHdrCsrType());
		this.hashColumns.put("hdr_inv_dt", getHdrInvDt());
		this.hashColumns.put("hdr_pay_grp", getHdrPayGrp());
		this.hashColumns.put("hdr_apprd_by", getHdrApprdBy());
		this.hashColumns.put("h_csrNo", getHCsrNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hdr_csr_no", "hdrCsrNo");
		this.hashFields.put("hdr_pay_to", "hdrPayTo");
		this.hashFields.put("hdr_desc", "hdrDesc");
		this.hashFields.put("hdr_amount", "hdrAmount");
		this.hashFields.put("hdr_amt", "hdrAmt");
		this.hashFields.put("hdr_due_dt", "hdrDueDt");
		this.hashFields.put("hdr_asa_no", "hdrAsaNo");
		this.hashFields.put("hdr_prpd_by", "hdrPrpdBy");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hdr_office", "hdrOffice");
		this.hashFields.put("hdr_evi_tp", "hdrEviTp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hdr_title", "hdrTitle");
		this.hashFields.put("hdr_curr_cd", "hdrCurrCd");
		this.hashFields.put("hdr_csr_type", "hdrCsrType");
		this.hashFields.put("hdr_inv_dt", "hdrInvDt");
		this.hashFields.put("hdr_pay_grp", "hdrPayGrp");
		this.hashFields.put("hdr_apprd_by", "hdrApprdBy");
		this.hashFields.put("h_csrNo", "hCsrNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hdrCsrNo
	 */
	public String getHdrCsrNo() {
		return this.hdrCsrNo;
	}
	
	/**
	 * Column Info
	 * @return hdrPayTo
	 */
	public String getHdrPayTo() {
		return this.hdrPayTo;
	}
	
	/**
	 * Column Info
	 * @return hdrDesc
	 */
	public String getHdrDesc() {
		return this.hdrDesc;
	}
	
	/**
	 * Column Info
	 * @return hdrAmount
	 */
	public String getHdrAmount() {
		return this.hdrAmount;
	}
	
	/**
	 * Column Info
	 * @return hdrAmt
	 */
	public String getHdrAmt() {
		return this.hdrAmt;
	}
	
	/**
	 * Column Info
	 * @return hdrDueDt
	 */
	public String getHdrDueDt() {
		return this.hdrDueDt;
	}
	
	/**
	 * Column Info
	 * @return hdrAsaNo
	 */
	public String getHdrAsaNo() {
		return this.hdrAsaNo;
	}
	
	/**
	 * Column Info
	 * @return hdrPrpdBy
	 */
	public String getHdrPrpdBy() {
		return this.hdrPrpdBy;
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
	 * @return hdrOffice
	 */
	public String getHdrOffice() {
		return this.hdrOffice;
	}
	
	/**
	 * Column Info
	 * @return hdrEviTp
	 */
	public String getHdrEviTp() {
		return this.hdrEviTp;
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
	 * @return hdrTitle
	 */
	public String getHdrTitle() {
		return this.hdrTitle;
	}
	
	/**
	 * Column Info
	 * @return hdrCurrCd
	 */
	public String getHdrCurrCd() {
		return this.hdrCurrCd;
	}
	
	/**
	 * Column Info
	 * @return hdrCsrType
	 */
	public String getHdrCsrType() {
		return this.hdrCsrType;
	}
	
	/**
	 * Column Info
	 * @return hdrInvDt
	 */
	public String getHdrInvDt() {
		return this.hdrInvDt;
	}
	
	/**
	 * Column Info
	 * @return hdrPayGrp
	 */
	public String getHdrPayGrp() {
		return this.hdrPayGrp;
	}
	
	/**
	 * Column Info
	 * @return hdrApprdBy
	 */
	public String getHdrApprdBy() {
		return this.hdrApprdBy;
	}
	

	public String getHCsrNo() {
    	return hCsrNo;
    }

	/**
	 * Column Info
	 * @param hdrCsrNo
	 */
	public void setHdrCsrNo(String hdrCsrNo) {
		this.hdrCsrNo = hdrCsrNo;
	}
	
	/**
	 * Column Info
	 * @param hdrPayTo
	 */
	public void setHdrPayTo(String hdrPayTo) {
		this.hdrPayTo = hdrPayTo;
	}
	
	/**
	 * Column Info
	 * @param hdrDesc
	 */
	public void setHdrDesc(String hdrDesc) {
		this.hdrDesc = hdrDesc;
	}
	
	/**
	 * Column Info
	 * @param hdrAmount
	 */
	public void setHdrAmount(String hdrAmount) {
		this.hdrAmount = hdrAmount;
	}
	
	/**
	 * Column Info
	 * @param hdrAmt
	 */
	public void setHdrAmt(String hdrAmt) {
		this.hdrAmt = hdrAmt;
	}
	
	/**
	 * Column Info
	 * @param hdrDueDt
	 */
	public void setHdrDueDt(String hdrDueDt) {
		this.hdrDueDt = hdrDueDt;
	}
	
	/**
	 * Column Info
	 * @param hdrAsaNo
	 */
	public void setHdrAsaNo(String hdrAsaNo) {
		this.hdrAsaNo = hdrAsaNo;
	}
	
	/**
	 * Column Info
	 * @param hdrPrpdBy
	 */
	public void setHdrPrpdBy(String hdrPrpdBy) {
		this.hdrPrpdBy = hdrPrpdBy;
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
	 * @param hdrOffice
	 */
	public void setHdrOffice(String hdrOffice) {
		this.hdrOffice = hdrOffice;
	}
	
	/**
	 * Column Info
	 * @param hdrEviTp
	 */
	public void setHdrEviTp(String hdrEviTp) {
		this.hdrEviTp = hdrEviTp;
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
	 * @param hdrTitle
	 */
	public void setHdrTitle(String hdrTitle) {
		this.hdrTitle = hdrTitle;
	}
	
	/**
	 * Column Info
	 * @param hdrCurrCd
	 */
	public void setHdrCurrCd(String hdrCurrCd) {
		this.hdrCurrCd = hdrCurrCd;
	}
	
	/**
	 * Column Info
	 * @param hdrCsrType
	 */
	public void setHdrCsrType(String hdrCsrType) {
		this.hdrCsrType = hdrCsrType;
	}
	
	/**
	 * Column Info
	 * @param hdrInvDt
	 */
	public void setHdrInvDt(String hdrInvDt) {
		this.hdrInvDt = hdrInvDt;
	}
	
	/**
	 * Column Info
	 * @param hdrPayGrp
	 */
	public void setHdrPayGrp(String hdrPayGrp) {
		this.hdrPayGrp = hdrPayGrp;
	}
	
	/**
	 * Column Info
	 * @param hdrApprdBy
	 */
	public void setHdrApprdBy(String hdrApprdBy) {
		this.hdrApprdBy = hdrApprdBy;
	}
	
	public void setHCsrNo(String csrNo) {
    	hCsrNo = csrNo;
    }

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setHdrCsrNo(JSPUtil.getParameter(request, "hdr_csr_no", ""));
		setHdrPayTo(JSPUtil.getParameter(request, "hdr_pay_to", ""));
		setHdrDesc(JSPUtil.getParameter(request, "hdr_desc", ""));
		setHdrAmount(JSPUtil.getParameter(request, "hdr_amount", ""));
		setHdrAmt(JSPUtil.getParameter(request, "hdr_amt", ""));
		setHdrDueDt(JSPUtil.getParameter(request, "hdr_due_dt", ""));
		setHdrAsaNo(JSPUtil.getParameter(request, "hdr_asa_no", ""));
		setHdrPrpdBy(JSPUtil.getParameter(request, "hdr_prpd_by", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setHdrOffice(JSPUtil.getParameter(request, "hdr_office", ""));
		setHdrEviTp(JSPUtil.getParameter(request, "hdr_evi_tp", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHdrTitle(JSPUtil.getParameter(request, "hdr_title", ""));
		setHdrCurrCd(JSPUtil.getParameter(request, "hdr_curr_cd", ""));
		setHdrCsrType(JSPUtil.getParameter(request, "hdr_csr_type", ""));
		setHdrInvDt(JSPUtil.getParameter(request, "hdr_inv_dt", ""));
		setHdrPayGrp(JSPUtil.getParameter(request, "hdr_pay_grp", ""));
		setHdrApprdBy(JSPUtil.getParameter(request, "hdr_apprd_by", ""));
		setHCsrNo(JSPUtil.getParameter(request, "h_csrNo", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AGTCommInfoForPrint1VO[]
	 */
	public AGTCommInfoForPrintVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AGTCommInfoForPrint1VO[]
	 */
	public AGTCommInfoForPrintVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AGTCommInfoForPrintVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hdrCsrNo = (JSPUtil.getParameter(request, prefix	+ "hdr_csr_no", length));
			String[] hdrPayTo = (JSPUtil.getParameter(request, prefix	+ "hdr_pay_to", length));
			String[] hdrDesc = (JSPUtil.getParameter(request, prefix	+ "hdr_desc", length));
			String[] hdrAmount = (JSPUtil.getParameter(request, prefix	+ "hdr_amount", length));
			String[] hdrAmt = (JSPUtil.getParameter(request, prefix	+ "hdr_amt", length));
			String[] hdrDueDt = (JSPUtil.getParameter(request, prefix	+ "hdr_due_dt", length));
			String[] hdrAsaNo = (JSPUtil.getParameter(request, prefix	+ "hdr_asa_no", length));
			String[] hdrPrpdBy = (JSPUtil.getParameter(request, prefix	+ "hdr_prpd_by", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hdrOffice = (JSPUtil.getParameter(request, prefix	+ "hdr_office", length));
			String[] hdrEviTp = (JSPUtil.getParameter(request, prefix	+ "hdr_evi_tp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hdrTitle = (JSPUtil.getParameter(request, prefix	+ "hdr_title", length));
			String[] hdrCurrCd = (JSPUtil.getParameter(request, prefix	+ "hdr_curr_cd", length));
			String[] hdrCsrType = (JSPUtil.getParameter(request, prefix	+ "hdr_csr_type", length));
			String[] hdrInvDt = (JSPUtil.getParameter(request, prefix	+ "hdr_inv_dt", length));
			String[] hdrPayGrp = (JSPUtil.getParameter(request, prefix	+ "hdr_pay_grp", length));
			String[] hdrApprdBy = (JSPUtil.getParameter(request, prefix	+ "hdr_apprd_by", length));
			String[] hCsrNo = (JSPUtil.getParameter(request, prefix	+ "h_csrNo", length));
			
			for (int i = 0; i < length; i++) {
				model = new AGTCommInfoForPrintVO();
				if (hdrCsrNo[i] != null)
					model.setHdrCsrNo(hdrCsrNo[i]);
				if (hdrPayTo[i] != null)
					model.setHdrPayTo(hdrPayTo[i]);
				if (hdrDesc[i] != null)
					model.setHdrDesc(hdrDesc[i]);
				if (hdrAmount[i] != null)
					model.setHdrAmount(hdrAmount[i]);
				if (hdrAmt[i] != null)
					model.setHdrAmount(hdrAmt[i]);
				if (hdrDueDt[i] != null)
					model.setHdrDueDt(hdrDueDt[i]);
				if (hdrAsaNo[i] != null)
					model.setHdrAsaNo(hdrAsaNo[i]);
				if (hdrPrpdBy[i] != null)
					model.setHdrPrpdBy(hdrPrpdBy[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hdrOffice[i] != null)
					model.setHdrOffice(hdrOffice[i]);
				if (hdrEviTp[i] != null)
					model.setHdrEviTp(hdrEviTp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hdrTitle[i] != null)
					model.setHdrTitle(hdrTitle[i]);
				if (hdrCurrCd[i] != null)
					model.setHdrCurrCd(hdrCurrCd[i]);
				if (hdrCsrType[i] != null)
					model.setHdrCsrType(hdrCsrType[i]);
				if (hdrInvDt[i] != null)
					model.setHdrInvDt(hdrInvDt[i]);
				if (hdrPayGrp[i] != null)
					model.setHdrPayGrp(hdrPayGrp[i]);
				if (hdrApprdBy[i] != null)
					model.setHdrApprdBy(hdrApprdBy[i]);
				if (hCsrNo[i] != null)
					model.setHCsrNo(hCsrNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAGTCommInfoForPrint1VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AGTCommInfoForPrint1VO[]
	 */
	public AGTCommInfoForPrintVO[] getAGTCommInfoForPrint1VOs(){
		AGTCommInfoForPrintVO[] vos = (AGTCommInfoForPrintVO[])models.toArray(new AGTCommInfoForPrintVO[models.size()]);
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
		this.hdrCsrNo = this.hdrCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPayTo = this.hdrPayTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrDesc = this.hdrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAmount = this.hdrAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAmt = this.hdrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrDueDt = this.hdrDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAsaNo = this.hdrAsaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPrpdBy = this.hdrPrpdBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrOffice = this.hdrOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrEviTp = this.hdrEviTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrTitle = this.hdrTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCurrCd = this.hdrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCsrType = this.hdrCsrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrInvDt = this.hdrInvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPayGrp = this.hdrPayGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrApprdBy = this.hdrApprdBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hCsrNo = this.hCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
