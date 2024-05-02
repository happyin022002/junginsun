/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UnapplyReceiptListVO.java
*@FileTitle : UnapplyReceiptListVO
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

public class UnapplyReceiptListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UnapplyReceiptListVO> models = new ArrayList<UnapplyReceiptListVO>();
	
	/* Column Info */
	private String rctOfcCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String chqNo = null;
	/* Column Info */
	private String rctRmk = null;
	/* Column Info */
	private String rctAmt = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rctCurrCd = null;
	/* Column Info */
	private String rctCustSeq = null;
	/* Column Info */
	private String rctCustCd = null;
	/* Column Info */
	private String rctDt = null;
	/* Column Info */
	private String unapplAmt = null;
	/* Column Info */
	private String rctCustCntCd = null;
	/* Column Info */
	private String unidenAmt = null;
	/* Column Info */
	private String rctNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UnapplyReceiptListVO() {}

	public UnapplyReceiptListVO(String ibflag, String pagerows, String chqNo, String rctDt, String rctNo, String rctCustCntCd, String rctCustSeq, String rctCustCd, String custNm, String rctOfcCd, String rctCurrCd, String rctAmt, String unidenAmt, String unapplAmt, String rctRmk, String creUsrId, String creUsrNm) {
		this.rctOfcCd = rctOfcCd;
		this.custNm = custNm;
		this.chqNo = chqNo;
		this.rctRmk = rctRmk;
		this.rctAmt = rctAmt;
		this.creUsrNm = creUsrNm;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.rctCurrCd = rctCurrCd;
		this.rctCustSeq = rctCustSeq;
		this.rctCustCd = rctCustCd;
		this.rctDt = rctDt;
		this.unapplAmt = unapplAmt;
		this.rctCustCntCd = rctCustCntCd;
		this.unidenAmt = unidenAmt;
		this.rctNo = rctNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rct_ofc_cd", getRctOfcCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("chq_no", getChqNo());
		this.hashColumns.put("rct_rmk", getRctRmk());
		this.hashColumns.put("rct_amt", getRctAmt());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rct_curr_cd", getRctCurrCd());
		this.hashColumns.put("rct_cust_seq", getRctCustSeq());
		this.hashColumns.put("rct_cust_cd", getRctCustCd());
		this.hashColumns.put("rct_dt", getRctDt());
		this.hashColumns.put("unappl_amt", getUnapplAmt());
		this.hashColumns.put("rct_cust_cnt_cd", getRctCustCntCd());
		this.hashColumns.put("uniden_amt", getUnidenAmt());
		this.hashColumns.put("rct_no", getRctNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rct_ofc_cd", "rctOfcCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("chq_no", "chqNo");
		this.hashFields.put("rct_rmk", "rctRmk");
		this.hashFields.put("rct_amt", "rctAmt");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rct_curr_cd", "rctCurrCd");
		this.hashFields.put("rct_cust_seq", "rctCustSeq");
		this.hashFields.put("rct_cust_cd", "rctCustCd");
		this.hashFields.put("rct_dt", "rctDt");
		this.hashFields.put("unappl_amt", "unapplAmt");
		this.hashFields.put("rct_cust_cnt_cd", "rctCustCntCd");
		this.hashFields.put("uniden_amt", "unidenAmt");
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return chqNo
	 */
	public String getChqNo() {
		return this.chqNo;
	}
	
	/**
	 * Column Info
	 * @return rctRmk
	 */
	public String getRctRmk() {
		return this.rctRmk;
	}
	
	/**
	 * Column Info
	 * @return rctAmt
	 */
	public String getRctAmt() {
		return this.rctAmt;
	}
	
	/**
	 * Column Info
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
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
	 * @return rctCustCd
	 */
	public String getRctCustCd() {
		return this.rctCustCd;
	}
	
	/**
	 * Column Info
	 * @return rctDt
	 */
	public String getRctDt() {
		return this.rctDt;
	}
	
	/**
	 * Column Info
	 * @return unapplAmt
	 */
	public String getUnapplAmt() {
		return this.unapplAmt;
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
	 * @return unidenAmt
	 */
	public String getUnidenAmt() {
		return this.unidenAmt;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param chqNo
	 */
	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}
	
	/**
	 * Column Info
	 * @param rctRmk
	 */
	public void setRctRmk(String rctRmk) {
		this.rctRmk = rctRmk;
	}
	
	/**
	 * Column Info
	 * @param rctAmt
	 */
	public void setRctAmt(String rctAmt) {
		this.rctAmt = rctAmt;
	}
	
	/**
	 * Column Info
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
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
	 * @param rctCustCd
	 */
	public void setRctCustCd(String rctCustCd) {
		this.rctCustCd = rctCustCd;
	}
	
	/**
	 * Column Info
	 * @param rctDt
	 */
	public void setRctDt(String rctDt) {
		this.rctDt = rctDt;
	}
	
	/**
	 * Column Info
	 * @param unapplAmt
	 */
	public void setUnapplAmt(String unapplAmt) {
		this.unapplAmt = unapplAmt;
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
	 * @param unidenAmt
	 */
	public void setUnidenAmt(String unidenAmt) {
		this.unidenAmt = unidenAmt;
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
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setChqNo(JSPUtil.getParameter(request, prefix + "chq_no", ""));
		setRctRmk(JSPUtil.getParameter(request, prefix + "rct_rmk", ""));
		setRctAmt(JSPUtil.getParameter(request, prefix + "rct_amt", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRctCurrCd(JSPUtil.getParameter(request, prefix + "rct_curr_cd", ""));
		setRctCustSeq(JSPUtil.getParameter(request, prefix + "rct_cust_seq", ""));
		setRctCustCd(JSPUtil.getParameter(request, prefix + "rct_cust_cd", ""));
		setRctDt(JSPUtil.getParameter(request, prefix + "rct_dt", ""));
		setUnapplAmt(JSPUtil.getParameter(request, prefix + "unappl_amt", ""));
		setRctCustCntCd(JSPUtil.getParameter(request, prefix + "rct_cust_cnt_cd", ""));
		setUnidenAmt(JSPUtil.getParameter(request, prefix + "uniden_amt", ""));
		setRctNo(JSPUtil.getParameter(request, prefix + "rct_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UnapplyReceiptListVO[]
	 */
	public UnapplyReceiptListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UnapplyReceiptListVO[]
	 */
	public UnapplyReceiptListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UnapplyReceiptListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rctOfcCd = (JSPUtil.getParameter(request, prefix	+ "rct_ofc_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] chqNo = (JSPUtil.getParameter(request, prefix	+ "chq_no", length));
			String[] rctRmk = (JSPUtil.getParameter(request, prefix	+ "rct_rmk", length));
			String[] rctAmt = (JSPUtil.getParameter(request, prefix	+ "rct_amt", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rctCurrCd = (JSPUtil.getParameter(request, prefix	+ "rct_curr_cd", length));
			String[] rctCustSeq = (JSPUtil.getParameter(request, prefix	+ "rct_cust_seq", length));
			String[] rctCustCd = (JSPUtil.getParameter(request, prefix	+ "rct_cust_cd", length));
			String[] rctDt = (JSPUtil.getParameter(request, prefix	+ "rct_dt", length));
			String[] unapplAmt = (JSPUtil.getParameter(request, prefix	+ "unappl_amt", length));
			String[] rctCustCntCd = (JSPUtil.getParameter(request, prefix	+ "rct_cust_cnt_cd", length));
			String[] unidenAmt = (JSPUtil.getParameter(request, prefix	+ "uniden_amt", length));
			String[] rctNo = (JSPUtil.getParameter(request, prefix	+ "rct_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new UnapplyReceiptListVO();
				if (rctOfcCd[i] != null)
					model.setRctOfcCd(rctOfcCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (chqNo[i] != null)
					model.setChqNo(chqNo[i]);
				if (rctRmk[i] != null)
					model.setRctRmk(rctRmk[i]);
				if (rctAmt[i] != null)
					model.setRctAmt(rctAmt[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rctCurrCd[i] != null)
					model.setRctCurrCd(rctCurrCd[i]);
				if (rctCustSeq[i] != null)
					model.setRctCustSeq(rctCustSeq[i]);
				if (rctCustCd[i] != null)
					model.setRctCustCd(rctCustCd[i]);
				if (rctDt[i] != null)
					model.setRctDt(rctDt[i]);
				if (unapplAmt[i] != null)
					model.setUnapplAmt(unapplAmt[i]);
				if (rctCustCntCd[i] != null)
					model.setRctCustCntCd(rctCustCntCd[i]);
				if (unidenAmt[i] != null)
					model.setUnidenAmt(unidenAmt[i]);
				if (rctNo[i] != null)
					model.setRctNo(rctNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUnapplyReceiptListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UnapplyReceiptListVO[]
	 */
	public UnapplyReceiptListVO[] getUnapplyReceiptListVOs(){
		UnapplyReceiptListVO[] vos = (UnapplyReceiptListVO[])models.toArray(new UnapplyReceiptListVO[models.size()]);
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
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chqNo = this.chqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctRmk = this.rctRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAmt = this.rctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCurrCd = this.rctCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustSeq = this.rctCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustCd = this.rctCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDt = this.rctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unapplAmt = this.unapplAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustCntCd = this.rctCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unidenAmt = this.unidenAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctNo = this.rctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
