/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UnapplyReceiptCondVO.java
*@FileTitle : UnapplyReceiptCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.31
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.31  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo;

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

public class UnapplyReceiptCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UnapplyReceiptCondVO> models = new ArrayList<UnapplyReceiptCondVO>();
	
	/* Column Info */
	private String rctOfcCd = null;
	/* Column Info */
	private String rctFromDt = null;
	/* Column Info */
	private String rctToDt = null;
	/* Column Info */
	private String chqNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rctFromAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rctCurrCd = null;
	/* Column Info */
	private String rctCustSeq = null;
	/* Column Info */
	private String rctToAmt = null;
	/* Column Info */
	private String rctCustCntCd = null;
	/* Column Info */
	private String rctNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UnapplyReceiptCondVO() {}

	public UnapplyReceiptCondVO(String ibflag, String pagerows, String rctOfcCd, String rctCustCntCd, String rctCustSeq, String rctFromDt, String rctToDt, String rctNo, String chqNo, String rctFromAmt, String rctToAmt, String creUsrId, String rctCurrCd) {
		this.rctOfcCd = rctOfcCd;
		this.rctFromDt = rctFromDt;
		this.rctToDt = rctToDt;
		this.chqNo = chqNo;
		this.pagerows = pagerows;
		this.rctFromAmt = rctFromAmt;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.rctCurrCd = rctCurrCd;
		this.rctCustSeq = rctCustSeq;
		this.rctToAmt = rctToAmt;
		this.rctCustCntCd = rctCustCntCd;
		this.rctNo = rctNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rct_ofc_cd", getRctOfcCd());
		this.hashColumns.put("rct_from_dt", getRctFromDt());
		this.hashColumns.put("rct_to_dt", getRctToDt());
		this.hashColumns.put("chq_no", getChqNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rct_from_amt", getRctFromAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rct_curr_cd", getRctCurrCd());
		this.hashColumns.put("rct_cust_seq", getRctCustSeq());
		this.hashColumns.put("rct_to_amt", getRctToAmt());
		this.hashColumns.put("rct_cust_cnt_cd", getRctCustCntCd());
		this.hashColumns.put("rct_no", getRctNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rct_ofc_cd", "rctOfcCd");
		this.hashFields.put("rct_from_dt", "rctFromDt");
		this.hashFields.put("rct_to_dt", "rctToDt");
		this.hashFields.put("chq_no", "chqNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rct_from_amt", "rctFromAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rct_curr_cd", "rctCurrCd");
		this.hashFields.put("rct_cust_seq", "rctCustSeq");
		this.hashFields.put("rct_to_amt", "rctToAmt");
		this.hashFields.put("rct_cust_cnt_cd", "rctCustCntCd");
		this.hashFields.put("rct_no", "rctNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rctOfcCd
	 */
	public String getRctOfcCd() {
		return this.rctOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rctFromDt
	 */
	public String getRctFromDt() {
		return this.rctFromDt;
	}
	
	/**
	 * Column Info
	 * @return rctToDt
	 */
	public String getRctToDt() {
		return this.rctToDt;
	}
	
	/**
	 * Column Info
	 * @return chqNo
	 */
	public String getChqNo() {
		return this.chqNo;
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
	 * @return rctFromAmt
	 */
	public String getRctFromAmt() {
		return this.rctFromAmt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return rctCurrCd
	 */
	public String getRctCurrCd() {
		return this.rctCurrCd;
	}
	
	/**
	 * Column Info
	 * @return rctCustSeq
	 */
	public String getRctCustSeq() {
		return this.rctCustSeq;
	}
	
	/**
	 * Column Info
	 * @return rctToAmt
	 */
	public String getRctToAmt() {
		return this.rctToAmt;
	}
	
	/**
	 * Column Info
	 * @return rctCustCntCd
	 */
	public String getRctCustCntCd() {
		return this.rctCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return rctNo
	 */
	public String getRctNo() {
		return this.rctNo;
	}
	

	/**
	 * Column Info
	 * @param rctOfcCd
	 */
	public void setRctOfcCd(String rctOfcCd) {
		this.rctOfcCd = rctOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rctFromDt
	 */
	public void setRctFromDt(String rctFromDt) {
		this.rctFromDt = rctFromDt;
	}
	
	/**
	 * Column Info
	 * @param rctToDt
	 */
	public void setRctToDt(String rctToDt) {
		this.rctToDt = rctToDt;
	}
	
	/**
	 * Column Info
	 * @param chqNo
	 */
	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
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
	 * @param rctFromAmt
	 */
	public void setRctFromAmt(String rctFromAmt) {
		this.rctFromAmt = rctFromAmt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param rctCurrCd
	 */
	public void setRctCurrCd(String rctCurrCd) {
		this.rctCurrCd = rctCurrCd;
	}
	
	/**
	 * Column Info
	 * @param rctCustSeq
	 */
	public void setRctCustSeq(String rctCustSeq) {
		this.rctCustSeq = rctCustSeq;
	}
	
	/**
	 * Column Info
	 * @param rctToAmt
	 */
	public void setRctToAmt(String rctToAmt) {
		this.rctToAmt = rctToAmt;
	}
	
	/**
	 * Column Info
	 * @param rctCustCntCd
	 */
	public void setRctCustCntCd(String rctCustCntCd) {
		this.rctCustCntCd = rctCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param rctNo
	 */
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
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
		setRctOfcCd(JSPUtil.getParameter(request, prefix + "rct_ofc_cd", ""));
		setRctFromDt(JSPUtil.getParameter(request, prefix + "rct_from_dt", ""));
		setRctToDt(JSPUtil.getParameter(request, prefix + "rct_to_dt", ""));
		setChqNo(JSPUtil.getParameter(request, prefix + "chq_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRctFromAmt(JSPUtil.getParameter(request, prefix + "rct_from_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRctCurrCd(JSPUtil.getParameter(request, prefix + "rct_curr_cd", ""));
		setRctCustSeq(JSPUtil.getParameter(request, prefix + "rct_cust_seq", ""));
		setRctToAmt(JSPUtil.getParameter(request, prefix + "rct_to_amt", ""));
		setRctCustCntCd(JSPUtil.getParameter(request, prefix + "rct_cust_cnt_cd", ""));
		setRctNo(JSPUtil.getParameter(request, prefix + "rct_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UnapplyReceiptCondVO[]
	 */
	public UnapplyReceiptCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UnapplyReceiptCondVO[]
	 */
	public UnapplyReceiptCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UnapplyReceiptCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rctOfcCd = (JSPUtil.getParameter(request, prefix	+ "rct_ofc_cd", length));
			String[] rctFromDt = (JSPUtil.getParameter(request, prefix	+ "rct_from_dt", length));
			String[] rctToDt = (JSPUtil.getParameter(request, prefix	+ "rct_to_dt", length));
			String[] chqNo = (JSPUtil.getParameter(request, prefix	+ "chq_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rctFromAmt = (JSPUtil.getParameter(request, prefix	+ "rct_from_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rctCurrCd = (JSPUtil.getParameter(request, prefix	+ "rct_curr_cd", length));
			String[] rctCustSeq = (JSPUtil.getParameter(request, prefix	+ "rct_cust_seq", length));
			String[] rctToAmt = (JSPUtil.getParameter(request, prefix	+ "rct_to_amt", length));
			String[] rctCustCntCd = (JSPUtil.getParameter(request, prefix	+ "rct_cust_cnt_cd", length));
			String[] rctNo = (JSPUtil.getParameter(request, prefix	+ "rct_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new UnapplyReceiptCondVO();
				if (rctOfcCd[i] != null)
					model.setRctOfcCd(rctOfcCd[i]);
				if (rctFromDt[i] != null)
					model.setRctFromDt(rctFromDt[i]);
				if (rctToDt[i] != null)
					model.setRctToDt(rctToDt[i]);
				if (chqNo[i] != null)
					model.setChqNo(chqNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rctFromAmt[i] != null)
					model.setRctFromAmt(rctFromAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rctCurrCd[i] != null)
					model.setRctCurrCd(rctCurrCd[i]);
				if (rctCustSeq[i] != null)
					model.setRctCustSeq(rctCustSeq[i]);
				if (rctToAmt[i] != null)
					model.setRctToAmt(rctToAmt[i]);
				if (rctCustCntCd[i] != null)
					model.setRctCustCntCd(rctCustCntCd[i]);
				if (rctNo[i] != null)
					model.setRctNo(rctNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUnapplyReceiptCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UnapplyReceiptCondVO[]
	 */
	public UnapplyReceiptCondVO[] getUnapplyReceiptCondVOs(){
		UnapplyReceiptCondVO[] vos = (UnapplyReceiptCondVO[])models.toArray(new UnapplyReceiptCondVO[models.size()]);
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
		this.rctOfcCd = this.rctOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctFromDt = this.rctFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctToDt = this.rctToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chqNo = this.chqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctFromAmt = this.rctFromAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCurrCd = this.rctCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustSeq = this.rctCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctToAmt = this.rctToAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustCntCd = this.rctCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctNo = this.rctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
