/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgChgOfcVO.java
*@FileTitle : BkgChgOfcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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

public class BkgChgOfcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgChgOfcVO> models = new ArrayList<BkgChgOfcVO>();
	
	/* Column Info */
	private String ppdRcvOfcCd = null;
	/* Column Info */
	private String ppdPayrCntCd = null;
	/* Column Info */
	private String bfPpdPayrCntCd = null;
	/* Column Info */
	private String bfPpdRcvOfcCd = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String cltPayrCustSeq = null;
	/* Column Info */
	private String bfCltPayrCntCd = null;
	/* Column Info */
	private String bfCltPayrCustSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cltPayrCntCd = null;
	/* Column Info */
	private String bfCltOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bfPpdPayrCustSeq = null;
	/* Column Info */
	private String ppdPayrCustSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgChgOfcVO() {}

	public BkgChgOfcVO(String ibflag, String pagerows, String bkgNo, String ppdRcvOfcCd, String ppdPayrCntCd, String ppdPayrCustSeq, String cltOfcCd, String cltPayrCntCd, String cltPayrCustSeq, String bfPpdRcvOfcCd, String bfPpdPayrCntCd, String bfPpdPayrCustSeq, String bfCltOfcCd, String bfCltPayrCntCd, String bfCltPayrCustSeq) {
		this.ppdRcvOfcCd = ppdRcvOfcCd;
		this.ppdPayrCntCd = ppdPayrCntCd;
		this.bfPpdPayrCntCd = bfPpdPayrCntCd;
		this.bfPpdRcvOfcCd = bfPpdRcvOfcCd;
		this.cltOfcCd = cltOfcCd;
		this.cltPayrCustSeq = cltPayrCustSeq;
		this.bfCltPayrCntCd = bfCltPayrCntCd;
		this.bfCltPayrCustSeq = bfCltPayrCustSeq;
		this.pagerows = pagerows;
		this.cltPayrCntCd = cltPayrCntCd;
		this.bfCltOfcCd = bfCltOfcCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.bfPpdPayrCustSeq = bfPpdPayrCustSeq;
		this.ppdPayrCustSeq = ppdPayrCustSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ppd_rcv_ofc_cd", getPpdRcvOfcCd());
		this.hashColumns.put("ppd_payr_cnt_cd", getPpdPayrCntCd());
		this.hashColumns.put("bf_ppd_payr_cnt_cd", getBfPpdPayrCntCd());
		this.hashColumns.put("bf_ppd_rcv_ofc_cd", getBfPpdRcvOfcCd());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("clt_payr_cust_seq", getCltPayrCustSeq());
		this.hashColumns.put("bf_clt_payr_cnt_cd", getBfCltPayrCntCd());
		this.hashColumns.put("bf_clt_payr_cust_seq", getBfCltPayrCustSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clt_payr_cnt_cd", getCltPayrCntCd());
		this.hashColumns.put("bf_clt_ofc_cd", getBfCltOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bf_ppd_payr_cust_seq", getBfPpdPayrCustSeq());
		this.hashColumns.put("ppd_payr_cust_seq", getPpdPayrCustSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ppd_rcv_ofc_cd", "ppdRcvOfcCd");
		this.hashFields.put("ppd_payr_cnt_cd", "ppdPayrCntCd");
		this.hashFields.put("bf_ppd_payr_cnt_cd", "bfPpdPayrCntCd");
		this.hashFields.put("bf_ppd_rcv_ofc_cd", "bfPpdRcvOfcCd");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("clt_payr_cust_seq", "cltPayrCustSeq");
		this.hashFields.put("bf_clt_payr_cnt_cd", "bfCltPayrCntCd");
		this.hashFields.put("bf_clt_payr_cust_seq", "bfCltPayrCustSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clt_payr_cnt_cd", "cltPayrCntCd");
		this.hashFields.put("bf_clt_ofc_cd", "bfCltOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bf_ppd_payr_cust_seq", "bfPpdPayrCustSeq");
		this.hashFields.put("ppd_payr_cust_seq", "ppdPayrCustSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ppdRcvOfcCd
	 */
	public String getPpdRcvOfcCd() {
		return this.ppdRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ppdPayrCntCd
	 */
	public String getPpdPayrCntCd() {
		return this.ppdPayrCntCd;
	}
	
	/**
	 * Column Info
	 * @return bfPpdPayrCntCd
	 */
	public String getBfPpdPayrCntCd() {
		return this.bfPpdPayrCntCd;
	}
	
	/**
	 * Column Info
	 * @return bfPpdRcvOfcCd
	 */
	public String getBfPpdRcvOfcCd() {
		return this.bfPpdRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cltOfcCd
	 */
	public String getCltOfcCd() {
		return this.cltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cltPayrCustSeq
	 */
	public String getCltPayrCustSeq() {
		return this.cltPayrCustSeq;
	}
	
	/**
	 * Column Info
	 * @return bfCltPayrCntCd
	 */
	public String getBfCltPayrCntCd() {
		return this.bfCltPayrCntCd;
	}
	
	/**
	 * Column Info
	 * @return bfCltPayrCustSeq
	 */
	public String getBfCltPayrCustSeq() {
		return this.bfCltPayrCustSeq;
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
	 * @return cltPayrCntCd
	 */
	public String getCltPayrCntCd() {
		return this.cltPayrCntCd;
	}
	
	/**
	 * Column Info
	 * @return bfCltOfcCd
	 */
	public String getBfCltOfcCd() {
		return this.bfCltOfcCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return bfPpdPayrCustSeq
	 */
	public String getBfPpdPayrCustSeq() {
		return this.bfPpdPayrCustSeq;
	}
	
	/**
	 * Column Info
	 * @return ppdPayrCustSeq
	 */
	public String getPpdPayrCustSeq() {
		return this.ppdPayrCustSeq;
	}
	

	/**
	 * Column Info
	 * @param ppdRcvOfcCd
	 */
	public void setPpdRcvOfcCd(String ppdRcvOfcCd) {
		this.ppdRcvOfcCd = ppdRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ppdPayrCntCd
	 */
	public void setPpdPayrCntCd(String ppdPayrCntCd) {
		this.ppdPayrCntCd = ppdPayrCntCd;
	}
	
	/**
	 * Column Info
	 * @param bfPpdPayrCntCd
	 */
	public void setBfPpdPayrCntCd(String bfPpdPayrCntCd) {
		this.bfPpdPayrCntCd = bfPpdPayrCntCd;
	}
	
	/**
	 * Column Info
	 * @param bfPpdRcvOfcCd
	 */
	public void setBfPpdRcvOfcCd(String bfPpdRcvOfcCd) {
		this.bfPpdRcvOfcCd = bfPpdRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cltOfcCd
	 */
	public void setCltOfcCd(String cltOfcCd) {
		this.cltOfcCd = cltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cltPayrCustSeq
	 */
	public void setCltPayrCustSeq(String cltPayrCustSeq) {
		this.cltPayrCustSeq = cltPayrCustSeq;
	}
	
	/**
	 * Column Info
	 * @param bfCltPayrCntCd
	 */
	public void setBfCltPayrCntCd(String bfCltPayrCntCd) {
		this.bfCltPayrCntCd = bfCltPayrCntCd;
	}
	
	/**
	 * Column Info
	 * @param bfCltPayrCustSeq
	 */
	public void setBfCltPayrCustSeq(String bfCltPayrCustSeq) {
		this.bfCltPayrCustSeq = bfCltPayrCustSeq;
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
	 * @param cltPayrCntCd
	 */
	public void setCltPayrCntCd(String cltPayrCntCd) {
		this.cltPayrCntCd = cltPayrCntCd;
	}
	
	/**
	 * Column Info
	 * @param bfCltOfcCd
	 */
	public void setBfCltOfcCd(String bfCltOfcCd) {
		this.bfCltOfcCd = bfCltOfcCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param bfPpdPayrCustSeq
	 */
	public void setBfPpdPayrCustSeq(String bfPpdPayrCustSeq) {
		this.bfPpdPayrCustSeq = bfPpdPayrCustSeq;
	}
	
	/**
	 * Column Info
	 * @param ppdPayrCustSeq
	 */
	public void setPpdPayrCustSeq(String ppdPayrCustSeq) {
		this.ppdPayrCustSeq = ppdPayrCustSeq;
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
		setPpdRcvOfcCd(JSPUtil.getParameter(request, prefix + "ppd_rcv_ofc_cd", ""));
		setPpdPayrCntCd(JSPUtil.getParameter(request, prefix + "ppd_payr_cnt_cd", ""));
		setBfPpdPayrCntCd(JSPUtil.getParameter(request, prefix + "bf_ppd_payr_cnt_cd", ""));
		setBfPpdRcvOfcCd(JSPUtil.getParameter(request, prefix + "bf_ppd_rcv_ofc_cd", ""));
		setCltOfcCd(JSPUtil.getParameter(request, prefix + "clt_ofc_cd", ""));
		setCltPayrCustSeq(JSPUtil.getParameter(request, prefix + "clt_payr_cust_seq", ""));
		setBfCltPayrCntCd(JSPUtil.getParameter(request, prefix + "bf_clt_payr_cnt_cd", ""));
		setBfCltPayrCustSeq(JSPUtil.getParameter(request, prefix + "bf_clt_payr_cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCltPayrCntCd(JSPUtil.getParameter(request, prefix + "clt_payr_cnt_cd", ""));
		setBfCltOfcCd(JSPUtil.getParameter(request, prefix + "bf_clt_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setBfPpdPayrCustSeq(JSPUtil.getParameter(request, prefix + "bf_ppd_payr_cust_seq", ""));
		setPpdPayrCustSeq(JSPUtil.getParameter(request, prefix + "ppd_payr_cust_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgChgOfcVO[]
	 */
	public BkgChgOfcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgChgOfcVO[]
	 */
	public BkgChgOfcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgChgOfcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ppdRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "ppd_rcv_ofc_cd", length));
			String[] ppdPayrCntCd = (JSPUtil.getParameter(request, prefix	+ "ppd_payr_cnt_cd", length));
			String[] bfPpdPayrCntCd = (JSPUtil.getParameter(request, prefix	+ "bf_ppd_payr_cnt_cd", length));
			String[] bfPpdRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "bf_ppd_rcv_ofc_cd", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix	+ "clt_ofc_cd", length));
			String[] cltPayrCustSeq = (JSPUtil.getParameter(request, prefix	+ "clt_payr_cust_seq", length));
			String[] bfCltPayrCntCd = (JSPUtil.getParameter(request, prefix	+ "bf_clt_payr_cnt_cd", length));
			String[] bfCltPayrCustSeq = (JSPUtil.getParameter(request, prefix	+ "bf_clt_payr_cust_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cltPayrCntCd = (JSPUtil.getParameter(request, prefix	+ "clt_payr_cnt_cd", length));
			String[] bfCltOfcCd = (JSPUtil.getParameter(request, prefix	+ "bf_clt_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bfPpdPayrCustSeq = (JSPUtil.getParameter(request, prefix	+ "bf_ppd_payr_cust_seq", length));
			String[] ppdPayrCustSeq = (JSPUtil.getParameter(request, prefix	+ "ppd_payr_cust_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgChgOfcVO();
				if (ppdRcvOfcCd[i] != null)
					model.setPpdRcvOfcCd(ppdRcvOfcCd[i]);
				if (ppdPayrCntCd[i] != null)
					model.setPpdPayrCntCd(ppdPayrCntCd[i]);
				if (bfPpdPayrCntCd[i] != null)
					model.setBfPpdPayrCntCd(bfPpdPayrCntCd[i]);
				if (bfPpdRcvOfcCd[i] != null)
					model.setBfPpdRcvOfcCd(bfPpdRcvOfcCd[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (cltPayrCustSeq[i] != null)
					model.setCltPayrCustSeq(cltPayrCustSeq[i]);
				if (bfCltPayrCntCd[i] != null)
					model.setBfCltPayrCntCd(bfCltPayrCntCd[i]);
				if (bfCltPayrCustSeq[i] != null)
					model.setBfCltPayrCustSeq(bfCltPayrCustSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cltPayrCntCd[i] != null)
					model.setCltPayrCntCd(cltPayrCntCd[i]);
				if (bfCltOfcCd[i] != null)
					model.setBfCltOfcCd(bfCltOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bfPpdPayrCustSeq[i] != null)
					model.setBfPpdPayrCustSeq(bfPpdPayrCustSeq[i]);
				if (ppdPayrCustSeq[i] != null)
					model.setPpdPayrCustSeq(ppdPayrCustSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgChgOfcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgChgOfcVO[]
	 */
	public BkgChgOfcVO[] getBkgChgOfcVOs(){
		BkgChgOfcVO[] vos = (BkgChgOfcVO[])models.toArray(new BkgChgOfcVO[models.size()]);
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
		this.ppdRcvOfcCd = this.ppdRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdPayrCntCd = this.ppdPayrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfPpdPayrCntCd = this.bfPpdPayrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfPpdRcvOfcCd = this.bfPpdRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltPayrCustSeq = this.cltPayrCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfCltPayrCntCd = this.bfCltPayrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfCltPayrCustSeq = this.bfCltPayrCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltPayrCntCd = this.cltPayrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfCltOfcCd = this.bfCltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfPpdPayrCustSeq = this.bfPpdPayrCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdPayrCustSeq = this.ppdPayrCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
