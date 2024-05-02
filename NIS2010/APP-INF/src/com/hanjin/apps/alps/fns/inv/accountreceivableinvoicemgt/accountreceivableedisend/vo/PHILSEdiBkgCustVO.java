/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PHILSEdiBkgCustVO.java
*@FileTitle : PHILSEdiBkgCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

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

public class PHILSEdiBkgCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PHILSEdiBkgCustVO> models = new ArrayList<PHILSEdiBkgCustVO>();
	
	/* Column Info */
	private String cneeCd = null;
	/* Column Info */
	private String ntfyZipCd = null;
	/* Column Info */
	private String ntfyCityNm = null;
	/* Column Info */
	private String cneeCityNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cneeCntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cneeStatCd = null;
	/* Column Info */
	private String ntfyStatCd = null;
	/* Column Info */
	private String shprCd = null;
	/* Column Info */
	private String shprZipCd = null;
	/* Column Info */
	private String ntfyCntCd = null;
	/* Column Info */
	private String cnee5 = null;
	/* Column Info */
	private String cnee3 = null;
	/* Column Info */
	private String cnee4 = null;
	/* Column Info */
	private String cnee1 = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String shpr2 = null;
	/* Column Info */
	private String shpr1 = null;
	/* Column Info */
	private String cnee2 = null;
	/* Column Info */
	private String shpr5 = null;
	/* Column Info */
	private String ntfyCd = null;
	/* Column Info */
	private String shpr4 = null;
	/* Column Info */
	private String shpr3 = null;
	/* Column Info */
	private String ntfy5 = null;
	/* Column Info */
	private String cneeZipCd = null;
	/* Column Info */
	private String ntfy4 = null;
	/* Column Info */
	private String shprStatCd = null;
	/* Column Info */
	private String shprCityNm = null;
	/* Column Info */
	private String ntfy3 = null;
	/* Column Info */
	private String ntfy2 = null;
	/* Column Info */
	private String ntfy1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PHILSEdiBkgCustVO() {}

	public PHILSEdiBkgCustVO(String ibflag, String pagerows, String shpr1, String shpr2, String shpr3, String shpr4, String shpr5, String shprCityNm, String shprStatCd, String shprZipCd, String shprCntCd, String shprCd, String cnee1, String cnee2, String cnee3, String cnee4, String cnee5, String cneeCityNm, String cneeStatCd, String cneeZipCd, String cneeCntCd, String cneeCd, String ntfy1, String ntfy2, String ntfy3, String ntfy4, String ntfy5, String ntfyCityNm, String ntfyStatCd, String ntfyZipCd, String ntfyCntCd, String ntfyCd) {
		this.cneeCd = cneeCd;
		this.ntfyZipCd = ntfyZipCd;
		this.ntfyCityNm = ntfyCityNm;
		this.cneeCityNm = cneeCityNm;
		this.pagerows = pagerows;
		this.cneeCntCd = cneeCntCd;
		this.ibflag = ibflag;
		this.cneeStatCd = cneeStatCd;
		this.ntfyStatCd = ntfyStatCd;
		this.shprCd = shprCd;
		this.shprZipCd = shprZipCd;
		this.ntfyCntCd = ntfyCntCd;
		this.cnee5 = cnee5;
		this.cnee3 = cnee3;
		this.cnee4 = cnee4;
		this.cnee1 = cnee1;
		this.shprCntCd = shprCntCd;
		this.shpr2 = shpr2;
		this.shpr1 = shpr1;
		this.cnee2 = cnee2;
		this.shpr5 = shpr5;
		this.ntfyCd = ntfyCd;
		this.shpr4 = shpr4;
		this.shpr3 = shpr3;
		this.ntfy5 = ntfy5;
		this.cneeZipCd = cneeZipCd;
		this.ntfy4 = ntfy4;
		this.shprStatCd = shprStatCd;
		this.shprCityNm = shprCityNm;
		this.ntfy3 = ntfy3;
		this.ntfy2 = ntfy2;
		this.ntfy1 = ntfy1;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnee_cd", getCneeCd());
		this.hashColumns.put("ntfy_zip_cd", getNtfyZipCd());
		this.hashColumns.put("ntfy_city_nm", getNtfyCityNm());
		this.hashColumns.put("cnee_city_nm", getCneeCityNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnee_cnt_cd", getCneeCntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnee_stat_cd", getCneeStatCd());
		this.hashColumns.put("ntfy_stat_cd", getNtfyStatCd());
		this.hashColumns.put("shpr_cd", getShprCd());
		this.hashColumns.put("shpr_zip_cd", getShprZipCd());
		this.hashColumns.put("ntfy_cnt_cd", getNtfyCntCd());
		this.hashColumns.put("cnee5", getCnee5());
		this.hashColumns.put("cnee3", getCnee3());
		this.hashColumns.put("cnee4", getCnee4());
		this.hashColumns.put("cnee1", getCnee1());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("shpr2", getShpr2());
		this.hashColumns.put("shpr1", getShpr1());
		this.hashColumns.put("cnee2", getCnee2());
		this.hashColumns.put("shpr5", getShpr5());
		this.hashColumns.put("ntfy_cd", getNtfyCd());
		this.hashColumns.put("shpr4", getShpr4());
		this.hashColumns.put("shpr3", getShpr3());
		this.hashColumns.put("ntfy5", getNtfy5());
		this.hashColumns.put("cnee_zip_cd", getCneeZipCd());
		this.hashColumns.put("ntfy4", getNtfy4());
		this.hashColumns.put("shpr_stat_cd", getShprStatCd());
		this.hashColumns.put("shpr_city_nm", getShprCityNm());
		this.hashColumns.put("ntfy3", getNtfy3());
		this.hashColumns.put("ntfy2", getNtfy2());
		this.hashColumns.put("ntfy1", getNtfy1());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnee_cd", "cneeCd");
		this.hashFields.put("ntfy_zip_cd", "ntfyZipCd");
		this.hashFields.put("ntfy_city_nm", "ntfyCityNm");
		this.hashFields.put("cnee_city_nm", "cneeCityNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnee_cnt_cd", "cneeCntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnee_stat_cd", "cneeStatCd");
		this.hashFields.put("ntfy_stat_cd", "ntfyStatCd");
		this.hashFields.put("shpr_cd", "shprCd");
		this.hashFields.put("shpr_zip_cd", "shprZipCd");
		this.hashFields.put("ntfy_cnt_cd", "ntfyCntCd");
		this.hashFields.put("cnee5", "cnee5");
		this.hashFields.put("cnee3", "cnee3");
		this.hashFields.put("cnee4", "cnee4");
		this.hashFields.put("cnee1", "cnee1");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("shpr2", "shpr2");
		this.hashFields.put("shpr1", "shpr1");
		this.hashFields.put("cnee2", "cnee2");
		this.hashFields.put("shpr5", "shpr5");
		this.hashFields.put("ntfy_cd", "ntfyCd");
		this.hashFields.put("shpr4", "shpr4");
		this.hashFields.put("shpr3", "shpr3");
		this.hashFields.put("ntfy5", "ntfy5");
		this.hashFields.put("cnee_zip_cd", "cneeZipCd");
		this.hashFields.put("ntfy4", "ntfy4");
		this.hashFields.put("shpr_stat_cd", "shprStatCd");
		this.hashFields.put("shpr_city_nm", "shprCityNm");
		this.hashFields.put("ntfy3", "ntfy3");
		this.hashFields.put("ntfy2", "ntfy2");
		this.hashFields.put("ntfy1", "ntfy1");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cneeCd
	 */
	public String getCneeCd() {
		return this.cneeCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyZipCd
	 */
	public String getNtfyZipCd() {
		return this.ntfyZipCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyCityNm
	 */
	public String getNtfyCityNm() {
		return this.ntfyCityNm;
	}
	
	/**
	 * Column Info
	 * @return cneeCityNm
	 */
	public String getCneeCityNm() {
		return this.cneeCityNm;
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
	 * @return cneeCntCd
	 */
	public String getCneeCntCd() {
		return this.cneeCntCd;
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
	 * @return cneeStatCd
	 */
	public String getCneeStatCd() {
		return this.cneeStatCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyStatCd
	 */
	public String getNtfyStatCd() {
		return this.ntfyStatCd;
	}
	
	/**
	 * Column Info
	 * @return shprCd
	 */
	public String getShprCd() {
		return this.shprCd;
	}
	
	/**
	 * Column Info
	 * @return shprZipCd
	 */
	public String getShprZipCd() {
		return this.shprZipCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyCntCd
	 */
	public String getNtfyCntCd() {
		return this.ntfyCntCd;
	}
	
	/**
	 * Column Info
	 * @return cnee5
	 */
	public String getCnee5() {
		return this.cnee5;
	}
	
	/**
	 * Column Info
	 * @return cnee3
	 */
	public String getCnee3() {
		return this.cnee3;
	}
	
	/**
	 * Column Info
	 * @return cnee4
	 */
	public String getCnee4() {
		return this.cnee4;
	}
	
	/**
	 * Column Info
	 * @return cnee1
	 */
	public String getCnee1() {
		return this.cnee1;
	}
	
	/**
	 * Column Info
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
	}
	
	/**
	 * Column Info
	 * @return shpr2
	 */
	public String getShpr2() {
		return this.shpr2;
	}
	
	/**
	 * Column Info
	 * @return shpr1
	 */
	public String getShpr1() {
		return this.shpr1;
	}
	
	/**
	 * Column Info
	 * @return cnee2
	 */
	public String getCnee2() {
		return this.cnee2;
	}
	
	/**
	 * Column Info
	 * @return shpr5
	 */
	public String getShpr5() {
		return this.shpr5;
	}
	
	/**
	 * Column Info
	 * @return ntfyCd
	 */
	public String getNtfyCd() {
		return this.ntfyCd;
	}
	
	/**
	 * Column Info
	 * @return shpr4
	 */
	public String getShpr4() {
		return this.shpr4;
	}
	
	/**
	 * Column Info
	 * @return shpr3
	 */
	public String getShpr3() {
		return this.shpr3;
	}
	
	/**
	 * Column Info
	 * @return ntfy5
	 */
	public String getNtfy5() {
		return this.ntfy5;
	}
	
	/**
	 * Column Info
	 * @return cneeZipCd
	 */
	public String getCneeZipCd() {
		return this.cneeZipCd;
	}
	
	/**
	 * Column Info
	 * @return ntfy4
	 */
	public String getNtfy4() {
		return this.ntfy4;
	}
	
	/**
	 * Column Info
	 * @return shprStatCd
	 */
	public String getShprStatCd() {
		return this.shprStatCd;
	}
	
	/**
	 * Column Info
	 * @return shprCityNm
	 */
	public String getShprCityNm() {
		return this.shprCityNm;
	}
	
	/**
	 * Column Info
	 * @return ntfy3
	 */
	public String getNtfy3() {
		return this.ntfy3;
	}
	
	/**
	 * Column Info
	 * @return ntfy2
	 */
	public String getNtfy2() {
		return this.ntfy2;
	}
	
	/**
	 * Column Info
	 * @return ntfy1
	 */
	public String getNtfy1() {
		return this.ntfy1;
	}
	

	/**
	 * Column Info
	 * @param cneeCd
	 */
	public void setCneeCd(String cneeCd) {
		this.cneeCd = cneeCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyZipCd
	 */
	public void setNtfyZipCd(String ntfyZipCd) {
		this.ntfyZipCd = ntfyZipCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyCityNm
	 */
	public void setNtfyCityNm(String ntfyCityNm) {
		this.ntfyCityNm = ntfyCityNm;
	}
	
	/**
	 * Column Info
	 * @param cneeCityNm
	 */
	public void setCneeCityNm(String cneeCityNm) {
		this.cneeCityNm = cneeCityNm;
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
	 * @param cneeCntCd
	 */
	public void setCneeCntCd(String cneeCntCd) {
		this.cneeCntCd = cneeCntCd;
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
	 * @param cneeStatCd
	 */
	public void setCneeStatCd(String cneeStatCd) {
		this.cneeStatCd = cneeStatCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyStatCd
	 */
	public void setNtfyStatCd(String ntfyStatCd) {
		this.ntfyStatCd = ntfyStatCd;
	}
	
	/**
	 * Column Info
	 * @param shprCd
	 */
	public void setShprCd(String shprCd) {
		this.shprCd = shprCd;
	}
	
	/**
	 * Column Info
	 * @param shprZipCd
	 */
	public void setShprZipCd(String shprZipCd) {
		this.shprZipCd = shprZipCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyCntCd
	 */
	public void setNtfyCntCd(String ntfyCntCd) {
		this.ntfyCntCd = ntfyCntCd;
	}
	
	/**
	 * Column Info
	 * @param cnee5
	 */
	public void setCnee5(String cnee5) {
		this.cnee5 = cnee5;
	}
	
	/**
	 * Column Info
	 * @param cnee3
	 */
	public void setCnee3(String cnee3) {
		this.cnee3 = cnee3;
	}
	
	/**
	 * Column Info
	 * @param cnee4
	 */
	public void setCnee4(String cnee4) {
		this.cnee4 = cnee4;
	}
	
	/**
	 * Column Info
	 * @param cnee1
	 */
	public void setCnee1(String cnee1) {
		this.cnee1 = cnee1;
	}
	
	/**
	 * Column Info
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
	}
	
	/**
	 * Column Info
	 * @param shpr2
	 */
	public void setShpr2(String shpr2) {
		this.shpr2 = shpr2;
	}
	
	/**
	 * Column Info
	 * @param shpr1
	 */
	public void setShpr1(String shpr1) {
		this.shpr1 = shpr1;
	}
	
	/**
	 * Column Info
	 * @param cnee2
	 */
	public void setCnee2(String cnee2) {
		this.cnee2 = cnee2;
	}
	
	/**
	 * Column Info
	 * @param shpr5
	 */
	public void setShpr5(String shpr5) {
		this.shpr5 = shpr5;
	}
	
	/**
	 * Column Info
	 * @param ntfyCd
	 */
	public void setNtfyCd(String ntfyCd) {
		this.ntfyCd = ntfyCd;
	}
	
	/**
	 * Column Info
	 * @param shpr4
	 */
	public void setShpr4(String shpr4) {
		this.shpr4 = shpr4;
	}
	
	/**
	 * Column Info
	 * @param shpr3
	 */
	public void setShpr3(String shpr3) {
		this.shpr3 = shpr3;
	}
	
	/**
	 * Column Info
	 * @param ntfy5
	 */
	public void setNtfy5(String ntfy5) {
		this.ntfy5 = ntfy5;
	}
	
	/**
	 * Column Info
	 * @param cneeZipCd
	 */
	public void setCneeZipCd(String cneeZipCd) {
		this.cneeZipCd = cneeZipCd;
	}
	
	/**
	 * Column Info
	 * @param ntfy4
	 */
	public void setNtfy4(String ntfy4) {
		this.ntfy4 = ntfy4;
	}
	
	/**
	 * Column Info
	 * @param shprStatCd
	 */
	public void setShprStatCd(String shprStatCd) {
		this.shprStatCd = shprStatCd;
	}
	
	/**
	 * Column Info
	 * @param shprCityNm
	 */
	public void setShprCityNm(String shprCityNm) {
		this.shprCityNm = shprCityNm;
	}
	
	/**
	 * Column Info
	 * @param ntfy3
	 */
	public void setNtfy3(String ntfy3) {
		this.ntfy3 = ntfy3;
	}
	
	/**
	 * Column Info
	 * @param ntfy2
	 */
	public void setNtfy2(String ntfy2) {
		this.ntfy2 = ntfy2;
	}
	
	/**
	 * Column Info
	 * @param ntfy1
	 */
	public void setNtfy1(String ntfy1) {
		this.ntfy1 = ntfy1;
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
		setCneeCd(JSPUtil.getParameter(request, prefix + "cnee_cd", ""));
		setNtfyZipCd(JSPUtil.getParameter(request, prefix + "ntfy_zip_cd", ""));
		setNtfyCityNm(JSPUtil.getParameter(request, prefix + "ntfy_city_nm", ""));
		setCneeCityNm(JSPUtil.getParameter(request, prefix + "cnee_city_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCneeCntCd(JSPUtil.getParameter(request, prefix + "cnee_cnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCneeStatCd(JSPUtil.getParameter(request, prefix + "cnee_stat_cd", ""));
		setNtfyStatCd(JSPUtil.getParameter(request, prefix + "ntfy_stat_cd", ""));
		setShprCd(JSPUtil.getParameter(request, prefix + "shpr_cd", ""));
		setShprZipCd(JSPUtil.getParameter(request, prefix + "shpr_zip_cd", ""));
		setNtfyCntCd(JSPUtil.getParameter(request, prefix + "ntfy_cnt_cd", ""));
		setCnee5(JSPUtil.getParameter(request, prefix + "cnee5", ""));
		setCnee3(JSPUtil.getParameter(request, prefix + "cnee3", ""));
		setCnee4(JSPUtil.getParameter(request, prefix + "cnee4", ""));
		setCnee1(JSPUtil.getParameter(request, prefix + "cnee1", ""));
		setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
		setShpr2(JSPUtil.getParameter(request, prefix + "shpr2", ""));
		setShpr1(JSPUtil.getParameter(request, prefix + "shpr1", ""));
		setCnee2(JSPUtil.getParameter(request, prefix + "cnee2", ""));
		setShpr5(JSPUtil.getParameter(request, prefix + "shpr5", ""));
		setNtfyCd(JSPUtil.getParameter(request, prefix + "ntfy_cd", ""));
		setShpr4(JSPUtil.getParameter(request, prefix + "shpr4", ""));
		setShpr3(JSPUtil.getParameter(request, prefix + "shpr3", ""));
		setNtfy5(JSPUtil.getParameter(request, prefix + "ntfy5", ""));
		setCneeZipCd(JSPUtil.getParameter(request, prefix + "cnee_zip_cd", ""));
		setNtfy4(JSPUtil.getParameter(request, prefix + "ntfy4", ""));
		setShprStatCd(JSPUtil.getParameter(request, prefix + "shpr_stat_cd", ""));
		setShprCityNm(JSPUtil.getParameter(request, prefix + "shpr_city_nm", ""));
		setNtfy3(JSPUtil.getParameter(request, prefix + "ntfy3", ""));
		setNtfy2(JSPUtil.getParameter(request, prefix + "ntfy2", ""));
		setNtfy1(JSPUtil.getParameter(request, prefix + "ntfy1", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PHILSEdiBkgCustVO[]
	 */
	public PHILSEdiBkgCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PHILSEdiBkgCustVO[]
	 */
	public PHILSEdiBkgCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PHILSEdiBkgCustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cneeCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cd", length));
			String[] ntfyZipCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_zip_cd", length));
			String[] ntfyCityNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_city_nm", length));
			String[] cneeCityNm = (JSPUtil.getParameter(request, prefix	+ "cnee_city_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cneeCntCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cneeStatCd = (JSPUtil.getParameter(request, prefix	+ "cnee_stat_cd", length));
			String[] ntfyStatCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_stat_cd", length));
			String[] shprCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cd", length));
			String[] shprZipCd = (JSPUtil.getParameter(request, prefix	+ "shpr_zip_cd", length));
			String[] ntfyCntCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_cnt_cd", length));
			String[] cnee5 = (JSPUtil.getParameter(request, prefix	+ "cnee5", length));
			String[] cnee3 = (JSPUtil.getParameter(request, prefix	+ "cnee3", length));
			String[] cnee4 = (JSPUtil.getParameter(request, prefix	+ "cnee4", length));
			String[] cnee1 = (JSPUtil.getParameter(request, prefix	+ "cnee1", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] shpr2 = (JSPUtil.getParameter(request, prefix	+ "shpr2", length));
			String[] shpr1 = (JSPUtil.getParameter(request, prefix	+ "shpr1", length));
			String[] cnee2 = (JSPUtil.getParameter(request, prefix	+ "cnee2", length));
			String[] shpr5 = (JSPUtil.getParameter(request, prefix	+ "shpr5", length));
			String[] ntfyCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_cd", length));
			String[] shpr4 = (JSPUtil.getParameter(request, prefix	+ "shpr4", length));
			String[] shpr3 = (JSPUtil.getParameter(request, prefix	+ "shpr3", length));
			String[] ntfy5 = (JSPUtil.getParameter(request, prefix	+ "ntfy5", length));
			String[] cneeZipCd = (JSPUtil.getParameter(request, prefix	+ "cnee_zip_cd", length));
			String[] ntfy4 = (JSPUtil.getParameter(request, prefix	+ "ntfy4", length));
			String[] shprStatCd = (JSPUtil.getParameter(request, prefix	+ "shpr_stat_cd", length));
			String[] shprCityNm = (JSPUtil.getParameter(request, prefix	+ "shpr_city_nm", length));
			String[] ntfy3 = (JSPUtil.getParameter(request, prefix	+ "ntfy3", length));
			String[] ntfy2 = (JSPUtil.getParameter(request, prefix	+ "ntfy2", length));
			String[] ntfy1 = (JSPUtil.getParameter(request, prefix	+ "ntfy1", length));
			
			for (int i = 0; i < length; i++) {
				model = new PHILSEdiBkgCustVO();
				if (cneeCd[i] != null)
					model.setCneeCd(cneeCd[i]);
				if (ntfyZipCd[i] != null)
					model.setNtfyZipCd(ntfyZipCd[i]);
				if (ntfyCityNm[i] != null)
					model.setNtfyCityNm(ntfyCityNm[i]);
				if (cneeCityNm[i] != null)
					model.setCneeCityNm(cneeCityNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cneeCntCd[i] != null)
					model.setCneeCntCd(cneeCntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cneeStatCd[i] != null)
					model.setCneeStatCd(cneeStatCd[i]);
				if (ntfyStatCd[i] != null)
					model.setNtfyStatCd(ntfyStatCd[i]);
				if (shprCd[i] != null)
					model.setShprCd(shprCd[i]);
				if (shprZipCd[i] != null)
					model.setShprZipCd(shprZipCd[i]);
				if (ntfyCntCd[i] != null)
					model.setNtfyCntCd(ntfyCntCd[i]);
				if (cnee5[i] != null)
					model.setCnee5(cnee5[i]);
				if (cnee3[i] != null)
					model.setCnee3(cnee3[i]);
				if (cnee4[i] != null)
					model.setCnee4(cnee4[i]);
				if (cnee1[i] != null)
					model.setCnee1(cnee1[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (shpr2[i] != null)
					model.setShpr2(shpr2[i]);
				if (shpr1[i] != null)
					model.setShpr1(shpr1[i]);
				if (cnee2[i] != null)
					model.setCnee2(cnee2[i]);
				if (shpr5[i] != null)
					model.setShpr5(shpr5[i]);
				if (ntfyCd[i] != null)
					model.setNtfyCd(ntfyCd[i]);
				if (shpr4[i] != null)
					model.setShpr4(shpr4[i]);
				if (shpr3[i] != null)
					model.setShpr3(shpr3[i]);
				if (ntfy5[i] != null)
					model.setNtfy5(ntfy5[i]);
				if (cneeZipCd[i] != null)
					model.setCneeZipCd(cneeZipCd[i]);
				if (ntfy4[i] != null)
					model.setNtfy4(ntfy4[i]);
				if (shprStatCd[i] != null)
					model.setShprStatCd(shprStatCd[i]);
				if (shprCityNm[i] != null)
					model.setShprCityNm(shprCityNm[i]);
				if (ntfy3[i] != null)
					model.setNtfy3(ntfy3[i]);
				if (ntfy2[i] != null)
					model.setNtfy2(ntfy2[i]);
				if (ntfy1[i] != null)
					model.setNtfy1(ntfy1[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPHILSEdiBkgCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PHILSEdiBkgCustVO[]
	 */
	public PHILSEdiBkgCustVO[] getPHILSEdiBkgCustVOs(){
		PHILSEdiBkgCustVO[] vos = (PHILSEdiBkgCustVO[])models.toArray(new PHILSEdiBkgCustVO[models.size()]);
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
		this.cneeCd = this.cneeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyZipCd = this.ntfyZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCityNm = this.ntfyCityNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCityNm = this.cneeCityNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCntCd = this.cneeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeStatCd = this.cneeStatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyStatCd = this.ntfyStatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCd = this.shprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprZipCd = this.shprZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCntCd = this.ntfyCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee5 = this.cnee5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee3 = this.cnee3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee4 = this.cnee4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee1 = this.cnee1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr2 = this.shpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr1 = this.shpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee2 = this.cnee2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr5 = this.shpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCd = this.ntfyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr4 = this.shpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr3 = this.shpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy5 = this.ntfy5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeZipCd = this.cneeZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy4 = this.ntfy4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprStatCd = this.shprStatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCityNm = this.shprCityNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy3 = this.ntfy3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2 = this.ntfy2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1 = this.ntfy1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
