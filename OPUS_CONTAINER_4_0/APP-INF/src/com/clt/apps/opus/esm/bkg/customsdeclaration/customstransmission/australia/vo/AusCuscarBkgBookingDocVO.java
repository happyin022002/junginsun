/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AusCuscarBkgBookingDocVO.java
*@FileTitle : AusCuscarBkgBookingDocVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.28  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo;

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

public class AusCuscarBkgBookingDocVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AusCuscarBkgBookingDocVO> models = new ArrayList<AusCuscarBkgBookingDocVO>();
	
	/* Column Info */
	private String preFlg = null;
	/* Column Info */
	private String totCntr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fpInd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AusCuscarBkgBookingDocVO() {}

	public AusCuscarBkgBookingDocVO(String ibflag, String pagerows, String blNo, String fpInd, String totCntr, String pckQty, String preFlg) {
		this.preFlg = preFlg;
		this.totCntr = totCntr;
		this.ibflag = ibflag;
		this.fpInd = fpInd;
		this.pckQty = pckQty;
		this.blNo = blNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pre_flg", getPreFlg());
		this.hashColumns.put("tot_cntr", getTotCntr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fp_ind", getFpInd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pre_flg", "preFlg");
		this.hashFields.put("tot_cntr", "totCntr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fp_ind", "fpInd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return preFlg
	 */
	public String getPreFlg() {
		return this.preFlg;
	}
	
	/**
	 * Column Info
	 * @return totCntr
	 */
	public String getTotCntr() {
		return this.totCntr;
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
	 * @return fpInd
	 */
	public String getFpInd() {
		return this.fpInd;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @param preFlg
	 */
	public void setPreFlg(String preFlg) {
		this.preFlg = preFlg;
	}
	
	/**
	 * Column Info
	 * @param totCntr
	 */
	public void setTotCntr(String totCntr) {
		this.totCntr = totCntr;
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
	 * @param fpInd
	 */
	public void setFpInd(String fpInd) {
		this.fpInd = fpInd;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
		setPreFlg(JSPUtil.getParameter(request, prefix + "pre_flg", ""));
		setTotCntr(JSPUtil.getParameter(request, prefix + "tot_cntr", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFpInd(JSPUtil.getParameter(request, prefix + "fp_ind", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AusCuscarBkgBookingDocVO[]
	 */
	public AusCuscarBkgBookingDocVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AusCuscarBkgBookingDocVO[]
	 */
	public AusCuscarBkgBookingDocVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AusCuscarBkgBookingDocVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] preFlg = (JSPUtil.getParameter(request, prefix	+ "pre_flg", length));
			String[] totCntr = (JSPUtil.getParameter(request, prefix	+ "tot_cntr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fpInd = (JSPUtil.getParameter(request, prefix	+ "fp_ind", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AusCuscarBkgBookingDocVO();
				if (preFlg[i] != null)
					model.setPreFlg(preFlg[i]);
				if (totCntr[i] != null)
					model.setTotCntr(totCntr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fpInd[i] != null)
					model.setFpInd(fpInd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAusCuscarBkgBookingDocVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AusCuscarBkgBookingDocVO[]
	 */
	public AusCuscarBkgBookingDocVO[] getAusCuscarBkgBookingDocVOs(){
		AusCuscarBkgBookingDocVO[] vos = (AusCuscarBkgBookingDocVO[])models.toArray(new AusCuscarBkgBookingDocVO[models.size()]);
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
		this.preFlg = this.preFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCntr = this.totCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fpInd = this.fpInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
