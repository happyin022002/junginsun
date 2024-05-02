/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BRKGInfoListForPrintVO.java
*@FileTitle : BRKGInfoListForPrintVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.04.15 박성진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BRKGInfoListForPrintVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BRKGInfoListForPrintVO> models = new ArrayList<BRKGInfoListForPrintVO>();
	
	/* Column Info */
	private String amount = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String vendorNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blNos = null;
	/* Column Info */
	private String vendor = null;
	/* Column Info */
	private String ffCntCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String searchDtTo = null;
	/* Column Info */
	private String cur = null;
	/* Column Info */
	private String searchDtFr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BRKGInfoListForPrintVO() {}

	public BRKGInfoListForPrintVO(String ibflag, String pagerows, String amount, String vendorNm, String csrNo, String vendor, String searchDtTo, String seq, String cur, String searchDtFr, String ffCntCd, String blNos) {
		this.amount = amount;
		this.csrNo = csrNo;
		this.vendorNm = vendorNm;
		this.ibflag = ibflag;
		this.blNos = blNos;
		this.vendor = vendor;
		this.ffCntCd = ffCntCd;
		this.seq = seq;
		this.searchDtTo = searchDtTo;
		this.cur = cur;
		this.searchDtFr = searchDtFr;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("vendor_nm", getVendorNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_nos", getBlNos());
		this.hashColumns.put("vendor", getVendor());
		this.hashColumns.put("ff_cnt_cd", getFfCntCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("search_dt_to", getSearchDtTo());
		this.hashColumns.put("cur", getCur());
		this.hashColumns.put("search_dt_fr", getSearchDtFr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("amount", "amount");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("vendor_nm", "vendorNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_nos", "blNos");
		this.hashFields.put("vendor", "vendor");
		this.hashFields.put("ff_cnt_cd", "ffCntCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("search_dt_to", "searchDtTo");
		this.hashFields.put("cur", "cur");
		this.hashFields.put("search_dt_fr", "searchDtFr");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return vendorNm
	 */
	public String getVendorNm() {
		return this.vendorNm;
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
	 * @return blNos
	 */
	public String getBlNos() {
		return this.blNos;
	}
	
	/**
	 * Column Info
	 * @return vendor
	 */
	public String getVendor() {
		return this.vendor;
	}
	
	/**
	 * Column Info
	 * @return ffCntCd
	 */
	public String getFfCntCd() {
		return this.ffCntCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return searchDtTo
	 */
	public String getSearchDtTo() {
		return this.searchDtTo;
	}
	
	/**
	 * Column Info
	 * @return cur
	 */
	public String getCur() {
		return this.cur;
	}
	
	/**
	 * Column Info
	 * @return searchDtFr
	 */
	public String getSearchDtFr() {
		return this.searchDtFr;
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
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param vendorNm
	 */
	public void setVendorNm(String vendorNm) {
		this.vendorNm = vendorNm;
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
	 * @param blNos
	 */
	public void setBlNos(String blNos) {
		this.blNos = blNos;
	}
	
	/**
	 * Column Info
	 * @param vendor
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	/**
	 * Column Info
	 * @param ffCntCd
	 */
	public void setFfCntCd(String ffCntCd) {
		this.ffCntCd = ffCntCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param searchDtTo
	 */
	public void setSearchDtTo(String searchDtTo) {
		this.searchDtTo = searchDtTo;
	}
	
	/**
	 * Column Info
	 * @param cur
	 */
	public void setCur(String cur) {
		this.cur = cur;
	}
	
	/**
	 * Column Info
	 * @param searchDtFr
	 */
	public void setSearchDtFr(String searchDtFr) {
		this.searchDtFr = searchDtFr;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setAmount(JSPUtil.getParameter(request, prefix + "amount", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setVendorNm(JSPUtil.getParameter(request, prefix + "vendor_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBlNos(JSPUtil.getParameter(request, prefix + "bl_nos", ""));
		setVendor(JSPUtil.getParameter(request, prefix + "vendor", ""));
		setFfCntCd(JSPUtil.getParameter(request, prefix + "ff_cnt_cd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setSearchDtTo(JSPUtil.getParameter(request, prefix + "search_dt_to", ""));
		setCur(JSPUtil.getParameter(request, prefix + "cur", ""));
		setSearchDtFr(JSPUtil.getParameter(request, prefix + "search_dt_fr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BRKGInfoListForPrintVO[]
	 */
	public BRKGInfoListForPrintVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BRKGInfoListForPrintVO[]
	 */
	public BRKGInfoListForPrintVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BRKGInfoListForPrintVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] vendorNm = (JSPUtil.getParameter(request, prefix	+ "vendor_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blNos = (JSPUtil.getParameter(request, prefix	+ "bl_nos", length));
			String[] vendor = (JSPUtil.getParameter(request, prefix	+ "vendor", length));
			String[] ffCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] searchDtTo = (JSPUtil.getParameter(request, prefix	+ "search_dt_to", length));
			String[] cur = (JSPUtil.getParameter(request, prefix	+ "cur", length));
			String[] searchDtFr = (JSPUtil.getParameter(request, prefix	+ "search_dt_fr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BRKGInfoListForPrintVO();
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (vendorNm[i] != null)
					model.setVendorNm(vendorNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blNos[i] != null)
					model.setBlNos(blNos[i]);
				if (vendor[i] != null)
					model.setVendor(vendor[i]);
				if (ffCntCd[i] != null)
					model.setFfCntCd(ffCntCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (searchDtTo[i] != null)
					model.setSearchDtTo(searchDtTo[i]);
				if (cur[i] != null)
					model.setCur(cur[i]);
				if (searchDtFr[i] != null)
					model.setSearchDtFr(searchDtFr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBRKGInfoListForPrintVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BRKGInfoListForPrintVO[]
	 */
	public BRKGInfoListForPrintVO[] getBRKGInfoListForPrintVOs(){
		BRKGInfoListForPrintVO[] vos = (BRKGInfoListForPrintVO[])models.toArray(new BRKGInfoListForPrintVO[models.size()]);
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
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vendorNm = this.vendorNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNos = this.blNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vendor = this.vendor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntCd = this.ffCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtTo = this.searchDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cur = this.cur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtFr = this.searchDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
