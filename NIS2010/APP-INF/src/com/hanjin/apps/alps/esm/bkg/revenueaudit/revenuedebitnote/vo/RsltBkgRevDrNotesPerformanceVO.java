/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltBkgRevDrNotesPerformanceVO.java
*@FileTitle : RsltBkgRevDrNotesPerformanceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.11.24 이승준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo;

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
 * @author 이승준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltBkgRevDrNotesPerformanceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltBkgRevDrNotesPerformanceVO> models = new ArrayList<RsltBkgRevDrNotesPerformanceVO>();
	
	/* Column Info */
	private String cnt3 = null;
	/* Column Info */
	private String cnt4 = null;
	/* Column Info */
	private String cnt1 = null;
	/* Column Info */
	private String rctOfcCd = null;
	/* Column Info */
	private String cnt2 = null;
	/* Column Info */
	private String respbRhqCd = null;
	/* Column Info */
	private String cnt7 = null;
	/* Column Info */
	private String cnt8 = null;
	/* Column Info */
	private String cnt5 = null;
	/* Column Info */
	private String cnt6 = null;
	/* Column Info */
	private String amt8 = null;
	/* Column Info */
	private String amt9 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String amt1 = null;
	/* Column Info */
	private String amt3 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String amt2 = null;
	/* Column Info */
	private String amt5 = null;
	/* Column Info */
	private String amt4 = null;
	/* Column Info */
	private String amt7 = null;
	/* Column Info */
	private String amt6 = null;
	/* Column Info */
	private String rdnStsCd = null;
	/* Column Info */
	private String cnt9 = null;
	/* Column Info */
	private String rctRhqCd = null;
	/* Column Info */
	private String cnt10 = null;
	/* Column Info */
	private String cnt11 = null;
	/* Column Info */
	private String amt10 = null;
	/* Column Info */
	private String amt11 = null;
	/* Column Info */
	private String rdnIssDtTo = null;
	/* Column Info */
	private String respbOfcCd = null;
	/* Column Info */
	private String rdnIssDtFrom = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltBkgRevDrNotesPerformanceVO() {}

	public RsltBkgRevDrNotesPerformanceVO(String ibflag, String pagerows, String rctRhqCd, String rctOfcCd, String respbRhqCd, String respbOfcCd, String cnt1, String amt1, String cnt2, String amt2, String cnt3, String amt3, String cnt4, String amt4, String cnt5, String amt5, String cnt6, String amt6, String cnt7, String amt7, String cnt8, String amt8, String cnt9, String amt9, String cnt10, String amt10, String cnt11, String amt11, String rdnStsCd, String rdnIssDtFrom, String rdnIssDtTo) {
		this.cnt3 = cnt3;
		this.cnt4 = cnt4;
		this.cnt1 = cnt1;
		this.rctOfcCd = rctOfcCd;
		this.cnt2 = cnt2;
		this.respbRhqCd = respbRhqCd;
		this.cnt7 = cnt7;
		this.cnt8 = cnt8;
		this.cnt5 = cnt5;
		this.cnt6 = cnt6;
		this.amt8 = amt8;
		this.amt9 = amt9;
		this.pagerows = pagerows;
		this.amt1 = amt1;
		this.amt3 = amt3;
		this.ibflag = ibflag;
		this.amt2 = amt2;
		this.amt5 = amt5;
		this.amt4 = amt4;
		this.amt7 = amt7;
		this.amt6 = amt6;
		this.rdnStsCd = rdnStsCd;
		this.cnt9 = cnt9;
		this.rctRhqCd = rctRhqCd;
		this.cnt10 = cnt10;
		this.cnt11 = cnt11;
		this.amt10 = amt10;
		this.amt11 = amt11;
		this.rdnIssDtTo = rdnIssDtTo;
		this.respbOfcCd = respbOfcCd;
		this.rdnIssDtFrom = rdnIssDtFrom;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnt3", getCnt3());
		this.hashColumns.put("cnt4", getCnt4());
		this.hashColumns.put("cnt1", getCnt1());
		this.hashColumns.put("rct_ofc_cd", getRctOfcCd());
		this.hashColumns.put("cnt2", getCnt2());
		this.hashColumns.put("respb_rhq_cd", getRespbRhqCd());
		this.hashColumns.put("cnt7", getCnt7());
		this.hashColumns.put("cnt8", getCnt8());
		this.hashColumns.put("cnt5", getCnt5());
		this.hashColumns.put("cnt6", getCnt6());
		this.hashColumns.put("amt8", getAmt8());
		this.hashColumns.put("amt9", getAmt9());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("amt1", getAmt1());
		this.hashColumns.put("amt3", getAmt3());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("amt2", getAmt2());
		this.hashColumns.put("amt5", getAmt5());
		this.hashColumns.put("amt4", getAmt4());
		this.hashColumns.put("amt7", getAmt7());
		this.hashColumns.put("amt6", getAmt6());
		this.hashColumns.put("rdn_sts_cd", getRdnStsCd());
		this.hashColumns.put("cnt9", getCnt9());
		this.hashColumns.put("rct_rhq_cd", getRctRhqCd());
		this.hashColumns.put("cnt10", getCnt10());
		this.hashColumns.put("cnt11", getCnt11());
		this.hashColumns.put("amt10", getAmt10());
		this.hashColumns.put("amt11", getAmt11());
		this.hashColumns.put("rdn_iss_dt_to", getRdnIssDtTo());
		this.hashColumns.put("respb_ofc_cd", getRespbOfcCd());
		this.hashColumns.put("rdn_iss_dt_from", getRdnIssDtFrom());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnt3", "cnt3");
		this.hashFields.put("cnt4", "cnt4");
		this.hashFields.put("cnt1", "cnt1");
		this.hashFields.put("rct_ofc_cd", "rctOfcCd");
		this.hashFields.put("cnt2", "cnt2");
		this.hashFields.put("respb_rhq_cd", "respbRhqCd");
		this.hashFields.put("cnt7", "cnt7");
		this.hashFields.put("cnt8", "cnt8");
		this.hashFields.put("cnt5", "cnt5");
		this.hashFields.put("cnt6", "cnt6");
		this.hashFields.put("amt8", "amt8");
		this.hashFields.put("amt9", "amt9");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("amt1", "amt1");
		this.hashFields.put("amt3", "amt3");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("amt2", "amt2");
		this.hashFields.put("amt5", "amt5");
		this.hashFields.put("amt4", "amt4");
		this.hashFields.put("amt7", "amt7");
		this.hashFields.put("amt6", "amt6");
		this.hashFields.put("rdn_sts_cd", "rdnStsCd");
		this.hashFields.put("cnt9", "cnt9");
		this.hashFields.put("rct_rhq_cd", "rctRhqCd");
		this.hashFields.put("cnt10", "cnt10");
		this.hashFields.put("cnt11", "cnt11");
		this.hashFields.put("amt10", "amt10");
		this.hashFields.put("amt11", "amt11");
		this.hashFields.put("rdn_iss_dt_to", "rdnIssDtTo");
		this.hashFields.put("respb_ofc_cd", "respbOfcCd");
		this.hashFields.put("rdn_iss_dt_from", "rdnIssDtFrom");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cnt3
	 */
	public String getCnt3() {
		return this.cnt3;
	}
	
	/**
	 * Column Info
	 * @return cnt4
	 */
	public String getCnt4() {
		return this.cnt4;
	}
	
	/**
	 * Column Info
	 * @return cnt1
	 */
	public String getCnt1() {
		return this.cnt1;
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
	 * @return cnt2
	 */
	public String getCnt2() {
		return this.cnt2;
	}
	
	/**
	 * Column Info
	 * @return respbRhqCd
	 */
	public String getRespbRhqCd() {
		return this.respbRhqCd;
	}
	
	/**
	 * Column Info
	 * @return cnt7
	 */
	public String getCnt7() {
		return this.cnt7;
	}
	
	/**
	 * Column Info
	 * @return cnt8
	 */
	public String getCnt8() {
		return this.cnt8;
	}
	
	/**
	 * Column Info
	 * @return cnt5
	 */
	public String getCnt5() {
		return this.cnt5;
	}
	
	/**
	 * Column Info
	 * @return cnt6
	 */
	public String getCnt6() {
		return this.cnt6;
	}
	
	/**
	 * Column Info
	 * @return amt8
	 */
	public String getAmt8() {
		return this.amt8;
	}
	
	/**
	 * Column Info
	 * @return amt9
	 */
	public String getAmt9() {
		return this.amt9;
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
	 * @return amt1
	 */
	public String getAmt1() {
		return this.amt1;
	}
	
	/**
	 * Column Info
	 * @return amt3
	 */
	public String getAmt3() {
		return this.amt3;
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
	 * @return amt2
	 */
	public String getAmt2() {
		return this.amt2;
	}
	
	/**
	 * Column Info
	 * @return amt5
	 */
	public String getAmt5() {
		return this.amt5;
	}
	
	/**
	 * Column Info
	 * @return amt4
	 */
	public String getAmt4() {
		return this.amt4;
	}
	
	/**
	 * Column Info
	 * @return amt7
	 */
	public String getAmt7() {
		return this.amt7;
	}
	
	/**
	 * Column Info
	 * @return amt6
	 */
	public String getAmt6() {
		return this.amt6;
	}
	
	/**
	 * Column Info
	 * @return rdnStsCd
	 */
	public String getRdnStsCd() {
		return this.rdnStsCd;
	}
	
	/**
	 * Column Info
	 * @return cnt9
	 */
	public String getCnt9() {
		return this.cnt9;
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
	 * @return cnt10
	 */
	public String getCnt10() {
		return this.cnt10;
	}
	
	/**
	 * Column Info
	 * @return cnt11
	 */
	public String getCnt11() {
		return this.cnt11;
	}
	
	/**
	 * Column Info
	 * @return amt10
	 */
	public String getAmt10() {
		return this.amt10;
	}
	
	/**
	 * Column Info
	 * @return amt11
	 */
	public String getAmt11() {
		return this.amt11;
	}
	
	/**
	 * Column Info
	 * @return rdnIssDtTo
	 */
	public String getRdnIssDtTo() {
		return this.rdnIssDtTo;
	}
	
	/**
	 * Column Info
	 * @return respbOfcCd
	 */
	public String getRespbOfcCd() {
		return this.respbOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rdnIssDtFrom
	 */
	public String getRdnIssDtFrom() {
		return this.rdnIssDtFrom;
	}
	

	/**
	 * Column Info
	 * @param cnt3
	 */
	public void setCnt3(String cnt3) {
		this.cnt3 = cnt3;
	}
	
	/**
	 * Column Info
	 * @param cnt4
	 */
	public void setCnt4(String cnt4) {
		this.cnt4 = cnt4;
	}
	
	/**
	 * Column Info
	 * @param cnt1
	 */
	public void setCnt1(String cnt1) {
		this.cnt1 = cnt1;
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
	 * @param cnt2
	 */
	public void setCnt2(String cnt2) {
		this.cnt2 = cnt2;
	}
	
	/**
	 * Column Info
	 * @param respbRhqCd
	 */
	public void setRespbRhqCd(String respbRhqCd) {
		this.respbRhqCd = respbRhqCd;
	}
	
	/**
	 * Column Info
	 * @param cnt7
	 */
	public void setCnt7(String cnt7) {
		this.cnt7 = cnt7;
	}
	
	/**
	 * Column Info
	 * @param cnt8
	 */
	public void setCnt8(String cnt8) {
		this.cnt8 = cnt8;
	}
	
	/**
	 * Column Info
	 * @param cnt5
	 */
	public void setCnt5(String cnt5) {
		this.cnt5 = cnt5;
	}
	
	/**
	 * Column Info
	 * @param cnt6
	 */
	public void setCnt6(String cnt6) {
		this.cnt6 = cnt6;
	}
	
	/**
	 * Column Info
	 * @param amt8
	 */
	public void setAmt8(String amt8) {
		this.amt8 = amt8;
	}
	
	/**
	 * Column Info
	 * @param amt9
	 */
	public void setAmt9(String amt9) {
		this.amt9 = amt9;
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
	 * @param amt1
	 */
	public void setAmt1(String amt1) {
		this.amt1 = amt1;
	}
	
	/**
	 * Column Info
	 * @param amt3
	 */
	public void setAmt3(String amt3) {
		this.amt3 = amt3;
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
	 * @param amt2
	 */
	public void setAmt2(String amt2) {
		this.amt2 = amt2;
	}
	
	/**
	 * Column Info
	 * @param amt5
	 */
	public void setAmt5(String amt5) {
		this.amt5 = amt5;
	}
	
	/**
	 * Column Info
	 * @param amt4
	 */
	public void setAmt4(String amt4) {
		this.amt4 = amt4;
	}
	
	/**
	 * Column Info
	 * @param amt7
	 */
	public void setAmt7(String amt7) {
		this.amt7 = amt7;
	}
	
	/**
	 * Column Info
	 * @param amt6
	 */
	public void setAmt6(String amt6) {
		this.amt6 = amt6;
	}
	
	/**
	 * Column Info
	 * @param rdnStsCd
	 */
	public void setRdnStsCd(String rdnStsCd) {
		this.rdnStsCd = rdnStsCd;
	}
	
	/**
	 * Column Info
	 * @param cnt9
	 */
	public void setCnt9(String cnt9) {
		this.cnt9 = cnt9;
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
	 * @param cnt10
	 */
	public void setCnt10(String cnt10) {
		this.cnt10 = cnt10;
	}
	
	/**
	 * Column Info
	 * @param cnt11
	 */
	public void setCnt11(String cnt11) {
		this.cnt11 = cnt11;
	}
	
	/**
	 * Column Info
	 * @param amt10
	 */
	public void setAmt10(String amt10) {
		this.amt10 = amt10;
	}
	
	/**
	 * Column Info
	 * @param amt11
	 */
	public void setAmt11(String amt11) {
		this.amt11 = amt11;
	}
	
	/**
	 * Column Info
	 * @param rdnIssDtTo
	 */
	public void setRdnIssDtTo(String rdnIssDtTo) {
		this.rdnIssDtTo = rdnIssDtTo;
	}
	
	/**
	 * Column Info
	 * @param respbOfcCd
	 */
	public void setRespbOfcCd(String respbOfcCd) {
		this.respbOfcCd = respbOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rdnIssDtFrom
	 */
	public void setRdnIssDtFrom(String rdnIssDtFrom) {
		this.rdnIssDtFrom = rdnIssDtFrom;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCnt3(JSPUtil.getParameter(request, "cnt3", ""));
		setCnt4(JSPUtil.getParameter(request, "cnt4", ""));
		setCnt1(JSPUtil.getParameter(request, "cnt1", ""));
		setRctOfcCd(JSPUtil.getParameter(request, "rct_ofc_cd", ""));
		setCnt2(JSPUtil.getParameter(request, "cnt2", ""));
		setRespbRhqCd(JSPUtil.getParameter(request, "respb_rhq_cd", ""));
		setCnt7(JSPUtil.getParameter(request, "cnt7", ""));
		setCnt8(JSPUtil.getParameter(request, "cnt8", ""));
		setCnt5(JSPUtil.getParameter(request, "cnt5", ""));
		setCnt6(JSPUtil.getParameter(request, "cnt6", ""));
		setAmt8(JSPUtil.getParameter(request, "amt8", ""));
		setAmt9(JSPUtil.getParameter(request, "amt9", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAmt1(JSPUtil.getParameter(request, "amt1", ""));
		setAmt3(JSPUtil.getParameter(request, "amt3", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAmt2(JSPUtil.getParameter(request, "amt2", ""));
		setAmt5(JSPUtil.getParameter(request, "amt5", ""));
		setAmt4(JSPUtil.getParameter(request, "amt4", ""));
		setAmt7(JSPUtil.getParameter(request, "amt7", ""));
		setAmt6(JSPUtil.getParameter(request, "amt6", ""));
		setRdnStsCd(JSPUtil.getParameter(request, "rdn_sts_cd", ""));
		setCnt9(JSPUtil.getParameter(request, "cnt9", ""));
		setRctRhqCd(JSPUtil.getParameter(request, "rct_rhq_cd", ""));
		setCnt10(JSPUtil.getParameter(request, "cnt10", ""));
		setCnt11(JSPUtil.getParameter(request, "cnt11", ""));
		setAmt10(JSPUtil.getParameter(request, "amt10", ""));
		setAmt11(JSPUtil.getParameter(request, "amt11", ""));
		setRdnIssDtTo(JSPUtil.getParameter(request, "rdn_iss_dt_to", ""));
		setRespbOfcCd(JSPUtil.getParameter(request, "respb_ofc_cd", ""));
		setRdnIssDtFrom(JSPUtil.getParameter(request, "rdn_iss_dt_from", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltBkgRevDrNotesPerformanceVO[]
	 */
	public RsltBkgRevDrNotesPerformanceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltBkgRevDrNotesPerformanceVO[]
	 */
	public RsltBkgRevDrNotesPerformanceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltBkgRevDrNotesPerformanceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cnt3 = (JSPUtil.getParameter(request, prefix	+ "cnt3", length));
			String[] cnt4 = (JSPUtil.getParameter(request, prefix	+ "cnt4", length));
			String[] cnt1 = (JSPUtil.getParameter(request, prefix	+ "cnt1", length));
			String[] rctOfcCd = (JSPUtil.getParameter(request, prefix	+ "rct_ofc_cd", length));
			String[] cnt2 = (JSPUtil.getParameter(request, prefix	+ "cnt2", length));
			String[] respbRhqCd = (JSPUtil.getParameter(request, prefix	+ "respb_rhq_cd", length));
			String[] cnt7 = (JSPUtil.getParameter(request, prefix	+ "cnt7", length));
			String[] cnt8 = (JSPUtil.getParameter(request, prefix	+ "cnt8", length));
			String[] cnt5 = (JSPUtil.getParameter(request, prefix	+ "cnt5", length));
			String[] cnt6 = (JSPUtil.getParameter(request, prefix	+ "cnt6", length));
			String[] amt8 = (JSPUtil.getParameter(request, prefix	+ "amt8", length));
			String[] amt9 = (JSPUtil.getParameter(request, prefix	+ "amt9", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] amt1 = (JSPUtil.getParameter(request, prefix	+ "amt1", length));
			String[] amt3 = (JSPUtil.getParameter(request, prefix	+ "amt3", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] amt2 = (JSPUtil.getParameter(request, prefix	+ "amt2", length));
			String[] amt5 = (JSPUtil.getParameter(request, prefix	+ "amt5", length));
			String[] amt4 = (JSPUtil.getParameter(request, prefix	+ "amt4", length));
			String[] amt7 = (JSPUtil.getParameter(request, prefix	+ "amt7", length));
			String[] amt6 = (JSPUtil.getParameter(request, prefix	+ "amt6", length));
			String[] rdnStsCd = (JSPUtil.getParameter(request, prefix	+ "rdn_sts_cd", length));
			String[] cnt9 = (JSPUtil.getParameter(request, prefix	+ "cnt9", length));
			String[] rctRhqCd = (JSPUtil.getParameter(request, prefix	+ "rct_rhq_cd", length));
			String[] cnt10 = (JSPUtil.getParameter(request, prefix	+ "cnt10", length));
			String[] cnt11 = (JSPUtil.getParameter(request, prefix	+ "cnt11", length));
			String[] amt10 = (JSPUtil.getParameter(request, prefix	+ "amt10", length));
			String[] amt11 = (JSPUtil.getParameter(request, prefix	+ "amt11", length));
			String[] rdnIssDtTo = (JSPUtil.getParameter(request, prefix	+ "rdn_iss_dt_to", length));
			String[] respbOfcCd = (JSPUtil.getParameter(request, prefix	+ "respb_ofc_cd", length));
			String[] rdnIssDtFrom = (JSPUtil.getParameter(request, prefix	+ "rdn_iss_dt_from", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltBkgRevDrNotesPerformanceVO();
				if (cnt3[i] != null)
					model.setCnt3(cnt3[i]);
				if (cnt4[i] != null)
					model.setCnt4(cnt4[i]);
				if (cnt1[i] != null)
					model.setCnt1(cnt1[i]);
				if (rctOfcCd[i] != null)
					model.setRctOfcCd(rctOfcCd[i]);
				if (cnt2[i] != null)
					model.setCnt2(cnt2[i]);
				if (respbRhqCd[i] != null)
					model.setRespbRhqCd(respbRhqCd[i]);
				if (cnt7[i] != null)
					model.setCnt7(cnt7[i]);
				if (cnt8[i] != null)
					model.setCnt8(cnt8[i]);
				if (cnt5[i] != null)
					model.setCnt5(cnt5[i]);
				if (cnt6[i] != null)
					model.setCnt6(cnt6[i]);
				if (amt8[i] != null)
					model.setAmt8(amt8[i]);
				if (amt9[i] != null)
					model.setAmt9(amt9[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (amt1[i] != null)
					model.setAmt1(amt1[i]);
				if (amt3[i] != null)
					model.setAmt3(amt3[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (amt2[i] != null)
					model.setAmt2(amt2[i]);
				if (amt5[i] != null)
					model.setAmt5(amt5[i]);
				if (amt4[i] != null)
					model.setAmt4(amt4[i]);
				if (amt7[i] != null)
					model.setAmt7(amt7[i]);
				if (amt6[i] != null)
					model.setAmt6(amt6[i]);
				if (rdnStsCd[i] != null)
					model.setRdnStsCd(rdnStsCd[i]);
				if (cnt9[i] != null)
					model.setCnt9(cnt9[i]);
				if (rctRhqCd[i] != null)
					model.setRctRhqCd(rctRhqCd[i]);
				if (cnt10[i] != null)
					model.setCnt10(cnt10[i]);
				if (cnt11[i] != null)
					model.setCnt11(cnt11[i]);
				if (amt10[i] != null)
					model.setAmt10(amt10[i]);
				if (amt11[i] != null)
					model.setAmt11(amt11[i]);
				if (rdnIssDtTo[i] != null)
					model.setRdnIssDtTo(rdnIssDtTo[i]);
				if (respbOfcCd[i] != null)
					model.setRespbOfcCd(respbOfcCd[i]);
				if (rdnIssDtFrom[i] != null)
					model.setRdnIssDtFrom(rdnIssDtFrom[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltBkgRevDrNotesPerformanceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltBkgRevDrNotesPerformanceVO[]
	 */
	public RsltBkgRevDrNotesPerformanceVO[] getRsltBkgRevDrNotesPerformanceVOs(){
		RsltBkgRevDrNotesPerformanceVO[] vos = (RsltBkgRevDrNotesPerformanceVO[])models.toArray(new RsltBkgRevDrNotesPerformanceVO[models.size()]);
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
		this.cnt3 = this.cnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt4 = this.cnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt1 = this.cnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctOfcCd = this.rctOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt2 = this.cnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbRhqCd = this.respbRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt7 = this.cnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt8 = this.cnt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt5 = this.cnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt6 = this.cnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt8 = this.amt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt9 = this.amt9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt1 = this.amt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt3 = this.amt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt2 = this.amt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt5 = this.amt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt4 = this.amt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt7 = this.amt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt6 = this.amt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnStsCd = this.rdnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt9 = this.cnt9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctRhqCd = this.rctRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt10 = this.cnt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt11 = this.cnt11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt10 = this.amt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt11 = this.amt11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnIssDtTo = this.rdnIssDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbOfcCd = this.respbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnIssDtFrom = this.rdnIssDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
