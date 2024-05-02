/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArOfcAttributeVO.java
*@FileTitle : ArOfcAttributeVO
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

public class ArOfcAttributeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArOfcAttributeVO> models = new ArrayList<ArOfcAttributeVO>();
	
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String arCurrCd = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String arCtrlOfcCd = null;
	/* Column Info */
	private String arCtrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String subAgnFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String repCustCntCd = null;
	/* Column Info */
	private String arAgnStlCd = null;
	/* Column Info */
	private String repCustSeq = null;
	/* Column Info */
	private String soIfCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArOfcAttributeVO() {}

	public ArOfcAttributeVO(String ibflag, String pagerows, String arHdQtrOfcCd, String arCurrCd, String arCtrCd, String locCd, String rgnCd, String soIfCd, String arAgnStlCd, String arCtrlOfcCd, String repCustCntCd, String repCustSeq, String subAgnFlg) {
		this.rgnCd = rgnCd;
		this.arCurrCd = arCurrCd;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.arCtrlOfcCd = arCtrlOfcCd;
		this.arCtrCd = arCtrCd;
		this.pagerows = pagerows;
		this.subAgnFlg = subAgnFlg;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.repCustCntCd = repCustCntCd;
		this.arAgnStlCd = arAgnStlCd;
		this.repCustSeq = repCustSeq;
		this.soIfCd = soIfCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("ar_curr_cd", getArCurrCd());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("ar_ctrl_ofc_cd", getArCtrlOfcCd());
		this.hashColumns.put("ar_ctr_cd", getArCtrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sub_agn_flg", getSubAgnFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("rep_cust_cnt_cd", getRepCustCntCd());
		this.hashColumns.put("ar_agn_stl_cd", getArAgnStlCd());
		this.hashColumns.put("rep_cust_seq", getRepCustSeq());
		this.hashColumns.put("so_if_cd", getSoIfCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("ar_curr_cd", "arCurrCd");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("ar_ctrl_ofc_cd", "arCtrlOfcCd");
		this.hashFields.put("ar_ctr_cd", "arCtrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sub_agn_flg", "subAgnFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("rep_cust_cnt_cd", "repCustCntCd");
		this.hashFields.put("ar_agn_stl_cd", "arAgnStlCd");
		this.hashFields.put("rep_cust_seq", "repCustSeq");
		this.hashFields.put("so_if_cd", "soIfCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
	}
	
	/**
	 * Column Info
	 * @return arCurrCd
	 */
	public String getArCurrCd() {
		return this.arCurrCd;
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
	 * @return arCtrlOfcCd
	 */
	public String getArCtrlOfcCd() {
		return this.arCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return arCtrCd
	 */
	public String getArCtrCd() {
		return this.arCtrCd;
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
	 * @return subAgnFlg
	 */
	public String getSubAgnFlg() {
		return this.subAgnFlg;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return repCustCntCd
	 */
	public String getRepCustCntCd() {
		return this.repCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return arAgnStlCd
	 */
	public String getArAgnStlCd() {
		return this.arAgnStlCd;
	}
	
	/**
	 * Column Info
	 * @return repCustSeq
	 */
	public String getRepCustSeq() {
		return this.repCustSeq;
	}
	
	/**
	 * Column Info
	 * @return soIfCd
	 */
	public String getSoIfCd() {
		return this.soIfCd;
	}
	

	/**
	 * Column Info
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}
	
	/**
	 * Column Info
	 * @param arCurrCd
	 */
	public void setArCurrCd(String arCurrCd) {
		this.arCurrCd = arCurrCd;
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
	 * @param arCtrlOfcCd
	 */
	public void setArCtrlOfcCd(String arCtrlOfcCd) {
		this.arCtrlOfcCd = arCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param arCtrCd
	 */
	public void setArCtrCd(String arCtrCd) {
		this.arCtrCd = arCtrCd;
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
	 * @param subAgnFlg
	 */
	public void setSubAgnFlg(String subAgnFlg) {
		this.subAgnFlg = subAgnFlg;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param repCustCntCd
	 */
	public void setRepCustCntCd(String repCustCntCd) {
		this.repCustCntCd = repCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param arAgnStlCd
	 */
	public void setArAgnStlCd(String arAgnStlCd) {
		this.arAgnStlCd = arAgnStlCd;
	}
	
	/**
	 * Column Info
	 * @param repCustSeq
	 */
	public void setRepCustSeq(String repCustSeq) {
		this.repCustSeq = repCustSeq;
	}
	
	/**
	 * Column Info
	 * @param soIfCd
	 */
	public void setSoIfCd(String soIfCd) {
		this.soIfCd = soIfCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRgnCd(JSPUtil.getParameter(request, "rgn_cd", ""));
		setArCurrCd(JSPUtil.getParameter(request, "ar_curr_cd", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, "ar_hd_qtr_ofc_cd", ""));
		setArCtrlOfcCd(JSPUtil.getParameter(request, "ar_ctrl_ofc_cd", ""));
		setArCtrCd(JSPUtil.getParameter(request, "ar_ctr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSubAgnFlg(JSPUtil.getParameter(request, "sub_agn_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setRepCustCntCd(JSPUtil.getParameter(request, "rep_cust_cnt_cd", ""));
		setArAgnStlCd(JSPUtil.getParameter(request, "ar_agn_stl_cd", ""));
		setRepCustSeq(JSPUtil.getParameter(request, "rep_cust_seq", ""));
		setSoIfCd(JSPUtil.getParameter(request, "so_if_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArOfcAttributeVO[]
	 */
	public ArOfcAttributeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArOfcAttributeVO[]
	 */
	public ArOfcAttributeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArOfcAttributeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] arCurrCd = (JSPUtil.getParameter(request, prefix	+ "ar_curr_cd", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] arCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ctrl_ofc_cd", length));
			String[] arCtrCd = (JSPUtil.getParameter(request, prefix	+ "ar_ctr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] subAgnFlg = (JSPUtil.getParameter(request, prefix	+ "sub_agn_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] repCustCntCd = (JSPUtil.getParameter(request, prefix	+ "rep_cust_cnt_cd", length));
			String[] arAgnStlCd = (JSPUtil.getParameter(request, prefix	+ "ar_agn_stl_cd", length));
			String[] repCustSeq = (JSPUtil.getParameter(request, prefix	+ "rep_cust_seq", length));
			String[] soIfCd = (JSPUtil.getParameter(request, prefix	+ "so_if_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArOfcAttributeVO();
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (arCurrCd[i] != null)
					model.setArCurrCd(arCurrCd[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (arCtrlOfcCd[i] != null)
					model.setArCtrlOfcCd(arCtrlOfcCd[i]);
				if (arCtrCd[i] != null)
					model.setArCtrCd(arCtrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (subAgnFlg[i] != null)
					model.setSubAgnFlg(subAgnFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (repCustCntCd[i] != null)
					model.setRepCustCntCd(repCustCntCd[i]);
				if (arAgnStlCd[i] != null)
					model.setArAgnStlCd(arAgnStlCd[i]);
				if (repCustSeq[i] != null)
					model.setRepCustSeq(repCustSeq[i]);
				if (soIfCd[i] != null)
					model.setSoIfCd(soIfCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArOfcAttributeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArOfcAttributeVO[]
	 */
	public ArOfcAttributeVO[] getArOfcAttributeVOs(){
		ArOfcAttributeVO[] vos = (ArOfcAttributeVO[])models.toArray(new ArOfcAttributeVO[models.size()]);
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
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCurrCd = this.arCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCtrlOfcCd = this.arCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCtrCd = this.arCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subAgnFlg = this.subAgnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCustCntCd = this.repCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arAgnStlCd = this.arAgnStlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCustSeq = this.repCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soIfCd = this.soIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
