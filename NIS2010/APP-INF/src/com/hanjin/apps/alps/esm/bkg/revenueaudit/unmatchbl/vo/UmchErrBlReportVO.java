/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UmchErrBlReportVO.java
*@FileTitle : UmchErrBlReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.12  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class UmchErrBlReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UmchErrBlReportVO> models = new ArrayList<UmchErrBlReportVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String over90Dys = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String within45Dys = null;
	/* Column Info */
	private String within90Dys = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String within7Dys = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String within15Dys = null;
	/* Column Info */
	private String within60Dys = null;
	/* Column Info */
	private String within30Dys = null;
	/* Column Info */
	private String rctRhqCd = null;
	/* Column Info */
	private String totalCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UmchErrBlReportVO() {}

	public UmchErrBlReportVO(String ibflag, String pagerows, String rctRhqCd, String bkgOfcCd, String within7Dys, String within15Dys, String within30Dys, String within45Dys, String within60Dys, String within90Dys, String over90Dys, String totalCnt, String bdrFlg) {
		this.bkgOfcCd = bkgOfcCd;
		this.over90Dys = over90Dys;
		this.bdrFlg = bdrFlg;
		this.within45Dys = within45Dys;
		this.within90Dys = within90Dys;
		this.pagerows = pagerows;
		this.within7Dys = within7Dys;
		this.ibflag = ibflag;
		this.within15Dys = within15Dys;
		this.within60Dys = within60Dys;
		this.within30Dys = within30Dys;
		this.rctRhqCd = rctRhqCd;
		this.totalCnt = totalCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("over_90_dys", getOver90Dys());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("within_45_dys", getWithin45Dys());
		this.hashColumns.put("within_90_dys", getWithin90Dys());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("within_7_dys", getWithin7Dys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("within_15_dys", getWithin15Dys());
		this.hashColumns.put("within_60_dys", getWithin60Dys());
		this.hashColumns.put("within_30_dys", getWithin30Dys());
		this.hashColumns.put("rct_rhq_cd", getRctRhqCd());
		this.hashColumns.put("total_cnt", getTotalCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("over_90_dys", "over90Dys");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("within_45_dys", "within45Dys");
		this.hashFields.put("within_90_dys", "within90Dys");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("within_7_dys", "within7Dys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("within_15_dys", "within15Dys");
		this.hashFields.put("within_60_dys", "within60Dys");
		this.hashFields.put("within_30_dys", "within30Dys");
		this.hashFields.put("rct_rhq_cd", "rctRhqCd");
		this.hashFields.put("total_cnt", "totalCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return over90Dys
	 */
	public String getOver90Dys() {
		return this.over90Dys;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return within45Dys
	 */
	public String getWithin45Dys() {
		return this.within45Dys;
	}
	
	/**
	 * Column Info
	 * @return within90Dys
	 */
	public String getWithin90Dys() {
		return this.within90Dys;
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
	 * @return within7Dys
	 */
	public String getWithin7Dys() {
		return this.within7Dys;
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
	 * @return within15Dys
	 */
	public String getWithin15Dys() {
		return this.within15Dys;
	}
	
	/**
	 * Column Info
	 * @return within60Dys
	 */
	public String getWithin60Dys() {
		return this.within60Dys;
	}
	
	/**
	 * Column Info
	 * @return within30Dys
	 */
	public String getWithin30Dys() {
		return this.within30Dys;
	}
	
	/**
	 * Column Info
	 * @return rctRhqCd
	 */
	public String getRctRhqCd() {
		return this.rctRhqCd;
	}
	
	/**
	 * Column Info
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
	}
	

	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param over90Dys
	 */
	public void setOver90Dys(String over90Dys) {
		this.over90Dys = over90Dys;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param within45Dys
	 */
	public void setWithin45Dys(String within45Dys) {
		this.within45Dys = within45Dys;
	}
	
	/**
	 * Column Info
	 * @param within90Dys
	 */
	public void setWithin90Dys(String within90Dys) {
		this.within90Dys = within90Dys;
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
	 * @param within7Dys
	 */
	public void setWithin7Dys(String within7Dys) {
		this.within7Dys = within7Dys;
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
	 * @param within15Dys
	 */
	public void setWithin15Dys(String within15Dys) {
		this.within15Dys = within15Dys;
	}
	
	/**
	 * Column Info
	 * @param within60Dys
	 */
	public void setWithin60Dys(String within60Dys) {
		this.within60Dys = within60Dys;
	}
	
	/**
	 * Column Info
	 * @param within30Dys
	 */
	public void setWithin30Dys(String within30Dys) {
		this.within30Dys = within30Dys;
	}
	
	/**
	 * Column Info
	 * @param rctRhqCd
	 */
	public void setRctRhqCd(String rctRhqCd) {
		this.rctRhqCd = rctRhqCd;
	}
	
	/**
	 * Column Info
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
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
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setOver90Dys(JSPUtil.getParameter(request, prefix + "over_90_dys", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setWithin45Dys(JSPUtil.getParameter(request, prefix + "within_45_dys", ""));
		setWithin90Dys(JSPUtil.getParameter(request, prefix + "within_90_dys", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setWithin7Dys(JSPUtil.getParameter(request, prefix + "within_7_dys", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setWithin15Dys(JSPUtil.getParameter(request, prefix + "within_15_dys", ""));
		setWithin60Dys(JSPUtil.getParameter(request, prefix + "within_60_dys", ""));
		setWithin30Dys(JSPUtil.getParameter(request, prefix + "within_30_dys", ""));
		setRctRhqCd(JSPUtil.getParameter(request, prefix + "rct_rhq_cd", ""));
		setTotalCnt(JSPUtil.getParameter(request, prefix + "total_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UmchErrBlReportVO[]
	 */
	public UmchErrBlReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UmchErrBlReportVO[]
	 */
	public UmchErrBlReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UmchErrBlReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] over90Dys = (JSPUtil.getParameter(request, prefix	+ "over_90_dys", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] within45Dys = (JSPUtil.getParameter(request, prefix	+ "within_45_dys", length));
			String[] within90Dys = (JSPUtil.getParameter(request, prefix	+ "within_90_dys", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] within7Dys = (JSPUtil.getParameter(request, prefix	+ "within_7_dys", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] within15Dys = (JSPUtil.getParameter(request, prefix	+ "within_15_dys", length));
			String[] within60Dys = (JSPUtil.getParameter(request, prefix	+ "within_60_dys", length));
			String[] within30Dys = (JSPUtil.getParameter(request, prefix	+ "within_30_dys", length));
			String[] rctRhqCd = (JSPUtil.getParameter(request, prefix	+ "rct_rhq_cd", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new UmchErrBlReportVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (over90Dys[i] != null)
					model.setOver90Dys(over90Dys[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (within45Dys[i] != null)
					model.setWithin45Dys(within45Dys[i]);
				if (within90Dys[i] != null)
					model.setWithin90Dys(within90Dys[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (within7Dys[i] != null)
					model.setWithin7Dys(within7Dys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (within15Dys[i] != null)
					model.setWithin15Dys(within15Dys[i]);
				if (within60Dys[i] != null)
					model.setWithin60Dys(within60Dys[i]);
				if (within30Dys[i] != null)
					model.setWithin30Dys(within30Dys[i]);
				if (rctRhqCd[i] != null)
					model.setRctRhqCd(rctRhqCd[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUmchErrBlReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UmchErrBlReportVO[]
	 */
	public UmchErrBlReportVO[] getUmchErrBlReportVOs(){
		UmchErrBlReportVO[] vos = (UmchErrBlReportVO[])models.toArray(new UmchErrBlReportVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.over90Dys = this.over90Dys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.within45Dys = this.within45Dys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.within90Dys = this.within90Dys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.within7Dys = this.within7Dys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.within15Dys = this.within15Dys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.within60Dys = this.within60Dys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.within30Dys = this.within30Dys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctRhqCd = this.rctRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
