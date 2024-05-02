/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgOfcPayIndVO.java
*@FileTitle : BkgOfcPayIndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.23 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgOfcPayIndVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgOfcPayIndVO> models = new ArrayList<BkgOfcPayIndVO>();
	
	/* Column Info */
	private String n3rdFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mArOfcCd = null;
	/* Column Info */
	private String chgSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgOfcPayIndVO() {}

	public BkgOfcPayIndVO(String ibflag, String pagerows, String ofcCd, String ioBndCd, String n3rdFlg, String custCntCd, String custSeq, String arHdQtrOfcCd, String mArOfcCd) {
		this.n3rdFlg = n3rdFlg;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.custSeq = custSeq;
		this.ioBndCd = ioBndCd;
		this.custCntCd = custCntCd;
		this.pagerows = pagerows;
		this.mArOfcCd = mArOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n3rd_flg", getN3rdFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("m_ar_ofc_cd", getMArOfcCd());
		this.hashColumns.put("chg_seq", getChgSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n3rd_flg", "n3rdFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("m_ar_ofc_cd", "mArOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chg_seq", "chgSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return n3rdFlg
	 */
	public String getN3rdFlg() {
		return this.n3rdFlg;
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
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Charge Sequence
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return chgSeq;
	}
	
	/**
	 * Column Info
	 * @param n3rdFlg
	 */
	public void setN3rdFlg(String n3rdFlg) {
		this.n3rdFlg = n3rdFlg;
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
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	
	/**
	 * @return the mArOfcCd
	 */
	public String getMArOfcCd() {
		return mArOfcCd;
	}

	/**
	 * @param arOfcCd the mArOfcCd to set
	 */
	public void setMArOfcCd(String arOfcCd) {
		mArOfcCd = arOfcCd;
	}
	

	/**
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}


	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setN3rdFlg(JSPUtil.getParameter(request, "n3rd_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, "ar_hd_qtr_ofc_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMArOfcCd(JSPUtil.getParameter(request, "m_ar_ofc_cd", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgOfcPayIndVO[]
	 */
	public BkgOfcPayIndVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgOfcPayIndVO[]
	 */
	public BkgOfcPayIndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgOfcPayIndVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n3rdFlg = (JSPUtil.getParameter(request, prefix	+ "n3rd_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mArOfcCd = (JSPUtil.getParameter(request, prefix	+ "m_ar_ofc_cd", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgOfcPayIndVO();
				if (n3rdFlg[i] != null)
					model.setN3rdFlg(n3rdFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mArOfcCd[i] != null)
					model.setMArOfcCd(mArOfcCd[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgOfcPayIndVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgOfcPayIndVO[]
	 */
	public BkgOfcPayIndVO[] getBkgOfcPayIndVOs(){
		BkgOfcPayIndVO[] vos = (BkgOfcPayIndVO[])models.toArray(new BkgOfcPayIndVO[models.size()]);
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
		this.n3rdFlg = this.n3rdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mArOfcCd = this.mArOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
