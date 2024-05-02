/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PoOtherMrnUcrVO.java
*@FileTitle : PoOtherMrnUcrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.27  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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

public class PoOtherMrnUcrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PoOtherMrnUcrVO> models = new ArrayList<PoOtherMrnUcrVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String refSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgRefTpCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String custRefNoCtnt = null;
	/* Page Number */
	private String pagerows = null;
	private String cntrFlg = null;
	private String oldBkgRefTpCd = null;
	private String oldCustRefNoCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PoOtherMrnUcrVO() {}

	public PoOtherMrnUcrVO(String ibflag, String pagerows, String refSeq, String bkgNo, String refNo, String cntrNo, String bkgRefTpCd, String custRefNoCtnt, String cntrFlg, String oldBkgRefTpCd, String oldCustRefNoCtnt) {
		this.bkgNo = bkgNo;
		this.refSeq = refSeq;
		this.ibflag = ibflag;
		this.bkgRefTpCd = bkgRefTpCd;
		this.cntrNo = cntrNo;
		this.refNo = refNo;
		this.custRefNoCtnt = custRefNoCtnt;
		this.pagerows = pagerows;
		this.cntrFlg = cntrFlg;
		this.oldBkgRefTpCd = oldBkgRefTpCd;
		this.oldCustRefNoCtnt = oldCustRefNoCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ref_seq", getRefSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_ref_tp_cd", getBkgRefTpCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("cust_ref_no_ctnt", getCustRefNoCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("old_bkg_ref_tp_cd", getOldBkgRefTpCd());
		this.hashColumns.put("old_cust_ref_no_ctnt", getOldCustRefNoCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ref_seq", "refSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_ref_tp_cd", "bkgRefTpCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("cust_ref_no_ctnt", "custRefNoCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_flg", "cntrFlg");
		this.hashFields.put("old_bkg_ref_tp_cd", "oldBkgRefTpCd");
		this.hashFields.put("old_cust_ref_no_ctnt", "oldCustRefNoCtnt");
		return this.hashFields;
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
	 * @return refSeq
	 */
	public String getRefSeq() {
		return this.refSeq;
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
	 * @return bkgRefTpCd
	 */
	public String getBkgRefTpCd() {
		return this.bkgRefTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return custRefNoCtnt
	 */
	public String getCustRefNoCtnt() {
		return this.custRefNoCtnt;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param refSeq
	 */
	public void setRefSeq(String refSeq) {
		this.refSeq = refSeq;
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
	 * @param bkgRefTpCd
	 */
	public void setBkgRefTpCd(String bkgRefTpCd) {
		this.bkgRefTpCd = bkgRefTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param custRefNoCtnt
	 */
	public void setCustRefNoCtnt(String custRefNoCtnt) {
		this.custRefNoCtnt = custRefNoCtnt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	
	/**
	 * @return the cntrFlg
	 */
	public String getCntrFlg() {
		return cntrFlg;
	}

	/**
	 * @param cntrFlg the cntrFlg to set
	 */
	public void setCntrFlg(String cntrFlg) {
		this.cntrFlg = cntrFlg;
	}

	
	/**
	 * @return the oldBkgRefTpCd
	 */
	public String getOldBkgRefTpCd() {
		return oldBkgRefTpCd;
	}

	/**
	 * @param oldBkgRefTpCd the oldBkgRefTpCd to set
	 */
	public void setOldBkgRefTpCd(String oldBkgRefTpCd) {
		this.oldBkgRefTpCd = oldBkgRefTpCd;
	}

	/**
	 * @return the oldCustRefNoCtnt
	 */
	public String getOldCustRefNoCtnt() {
		return oldCustRefNoCtnt;
	}

	/**
	 * @param oldCustRefNoCtnt the oldCustRefNoCtnt to set
	 */
	public void setOldCustRefNoCtnt(String oldCustRefNoCtnt) {
		this.oldCustRefNoCtnt = oldCustRefNoCtnt;
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
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRefSeq(JSPUtil.getParameter(request, prefix + "ref_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgRefTpCd(JSPUtil.getParameter(request, prefix + "bkg_ref_tp_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
		setCustRefNoCtnt(JSPUtil.getParameter(request, prefix + "cust_ref_no_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntrFlg(JSPUtil.getParameter(request, prefix + "cntr_flg", ""));
		setOldBkgRefTpCd(JSPUtil.getParameter(request, prefix + "old_bkg_ref_tp_cd", ""));
		setOldCustRefNoCtnt(JSPUtil.getParameter(request, prefix + "old_cust_ref_no_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PoOtherMrnUcrVO[]
	 */
	public PoOtherMrnUcrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PoOtherMrnUcrVO[]
	 */
	public PoOtherMrnUcrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PoOtherMrnUcrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] refSeq = (JSPUtil.getParameter(request, prefix	+ "ref_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgRefTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ref_tp_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] custRefNoCtnt = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_flg", length));
			String[] oldBkgRefTpCd = (JSPUtil.getParameter(request, prefix	+ "old_bkg_ref_tp_cd", length));
			String[] oldCustRefNoCtnt = (JSPUtil.getParameter(request, prefix	+ "old_cust_ref_no_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PoOtherMrnUcrVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (refSeq[i] != null)
					model.setRefSeq(refSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgRefTpCd[i] != null)
					model.setBkgRefTpCd(bkgRefTpCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (custRefNoCtnt[i] != null)
					model.setCustRefNoCtnt(custRefNoCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrFlg[i] != null)
					model.setCntrFlg(cntrFlg[i]);
				if (oldBkgRefTpCd[i] != null)
					model.setOldBkgRefTpCd(oldBkgRefTpCd[i]);
				if (oldCustRefNoCtnt[i] != null)
					model.setOldCustRefNoCtnt(oldCustRefNoCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPoOtherMrnUcrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PoOtherMrnUcrVO[]
	 */
	public PoOtherMrnUcrVO[] getPoOtherMrnUcrVOs(){
		PoOtherMrnUcrVO[] vos = (PoOtherMrnUcrVO[])models.toArray(new PoOtherMrnUcrVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refSeq = this.refSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefTpCd = this.bkgRefTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNoCtnt = this.custRefNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFlg = this.cntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldBkgRefTpCd = this.oldBkgRefTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCustRefNoCtnt = this.oldCustRefNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
