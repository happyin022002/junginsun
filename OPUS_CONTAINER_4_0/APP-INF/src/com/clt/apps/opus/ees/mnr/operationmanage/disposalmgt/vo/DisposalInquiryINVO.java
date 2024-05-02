/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DisposalInquiryINVO.java
*@FileTitle : DisposalInquiryINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.19
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.05.19 함형석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo;

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
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DisposalInquiryINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DisposalInquiryINVO> models = new ArrayList<DisposalInquiryINVO>();
	
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String mnrPrnrCntCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String mnrPrnrSeq = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String invNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnrInvStsCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String eqNoList = null;
	/* Column Info */
	private String dispRlseNo = null;
	/* Column Info */
	private String invOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DisposalInquiryINVO() {}

	public DisposalInquiryINVO(String ibflag, String pagerows, String fromDt, String dispNo, String mnrPrnrCntCd, String custLglEngNm, String mnrPrnrSeq, String toDt, String invNo, String mnrInvStsCd, String custCd, String dispRlseNo, String invOfcCd, String eqNoList) {
		this.fromDt = fromDt;
		this.dispNo = dispNo;
		this.mnrPrnrCntCd = mnrPrnrCntCd;
		this.pagerows = pagerows;
		this.custLglEngNm = custLglEngNm;
		this.mnrPrnrSeq = mnrPrnrSeq;
		this.toDt = toDt;
		this.invNo = invNo;
		this.ibflag = ibflag;
		this.mnrInvStsCd = mnrInvStsCd;
		this.custCd = custCd;
		this.eqNoList = eqNoList;
		this.dispRlseNo = dispRlseNo;
		this.invOfcCd = invOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("mnr_prnr_cnt_cd", getMnrPrnrCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("mnr_prnr_seq", getMnrPrnrSeq());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnr_inv_sts_cd", getMnrInvStsCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("eq_no_list", getEqNoList());
		this.hashColumns.put("disp_rlse_no", getDispRlseNo());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("mnr_prnr_cnt_cd", "mnrPrnrCntCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("mnr_prnr_seq", "mnrPrnrSeq");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_inv_sts_cd", "mnrInvStsCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("eq_no_list", "eqNoList");
		this.hashFields.put("disp_rlse_no", "dispRlseNo");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return dispNo
	 */
	public String getDispNo() {
		return this.dispNo;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrCntCd
	 */
	public String getMnrPrnrCntCd() {
		return this.mnrPrnrCntCd;
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
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrSeq
	 */
	public String getMnrPrnrSeq() {
		return this.mnrPrnrSeq;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return mnrInvStsCd
	 */
	public String getMnrInvStsCd() {
		return this.mnrInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return eqNoList
	 */
	public String getEqNoList() {
		return this.eqNoList;
	}
	
	/**
	 * Column Info
	 * @return dispRlseNo
	 */
	public String getDispRlseNo() {
		return this.dispRlseNo;
	}
	
	/**
	 * Column Info
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
	}
	

	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param dispNo
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrCntCd
	 */
	public void setMnrPrnrCntCd(String mnrPrnrCntCd) {
		this.mnrPrnrCntCd = mnrPrnrCntCd;
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
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrSeq
	 */
	public void setMnrPrnrSeq(String mnrPrnrSeq) {
		this.mnrPrnrSeq = mnrPrnrSeq;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param mnrInvStsCd
	 */
	public void setMnrInvStsCd(String mnrInvStsCd) {
		this.mnrInvStsCd = mnrInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param eqNoList
	 */
	public void setEqNoList(String eqNoList) {
		this.eqNoList = eqNoList;
	}
	
	/**
	 * Column Info
	 * @param dispRlseNo
	 */
	public void setDispRlseNo(String dispRlseNo) {
		this.dispRlseNo = dispRlseNo;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
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
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setDispNo(JSPUtil.getParameter(request, prefix + "disp_no", ""));
		setMnrPrnrCntCd(JSPUtil.getParameter(request, prefix + "mnr_prnr_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setMnrPrnrSeq(JSPUtil.getParameter(request, prefix + "mnr_prnr_seq", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMnrInvStsCd(JSPUtil.getParameter(request, prefix + "mnr_inv_sts_cd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setEqNoList(JSPUtil.getParameter(request, prefix + "eq_no_list", ""));
		setDispRlseNo(JSPUtil.getParameter(request, prefix + "disp_rlse_no", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DisposalInquiryINVO[]
	 */
	public DisposalInquiryINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DisposalInquiryINVO[]
	 */
	public DisposalInquiryINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DisposalInquiryINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] mnrPrnrCntCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] mnrPrnrSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_seq", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnrInvStsCd = (JSPUtil.getParameter(request, prefix	+ "mnr_inv_sts_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] eqNoList = (JSPUtil.getParameter(request, prefix	+ "eq_no_list", length));
			String[] dispRlseNo = (JSPUtil.getParameter(request, prefix	+ "disp_rlse_no", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DisposalInquiryINVO();
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (mnrPrnrCntCd[i] != null)
					model.setMnrPrnrCntCd(mnrPrnrCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (mnrPrnrSeq[i] != null)
					model.setMnrPrnrSeq(mnrPrnrSeq[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnrInvStsCd[i] != null)
					model.setMnrInvStsCd(mnrInvStsCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (eqNoList[i] != null)
					model.setEqNoList(eqNoList[i]);
				if (dispRlseNo[i] != null)
					model.setDispRlseNo(dispRlseNo[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDisposalInquiryINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DisposalInquiryINVO[]
	 */
	public DisposalInquiryINVO[] getDisposalInquiryINVOs(){
		DisposalInquiryINVO[] vos = (DisposalInquiryINVO[])models.toArray(new DisposalInquiryINVO[models.size()]);
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
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrCntCd = this.mnrPrnrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrSeq = this.mnrPrnrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvStsCd = this.mnrInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNoList = this.eqNoList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispRlseNo = this.dispRlseNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
