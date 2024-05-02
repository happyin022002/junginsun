/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchRequestListVO.java
*@FileTitle : SearchRequestListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.01
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2013.08.01 채창호 
* 1.0 Creation
* ***********************************************************
* 2013.08.13 채창호 [CHM-201325598]Split 02-EQR T/F 관련 LEGACY 연계 방안 및 일정
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo;

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
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchRequestListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRequestListVO> models = new ArrayList<SearchRequestListVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String totallist = null;
	/* Column Info */
	private String qtyo5 = null;
	/* Column Info */
	private String qtya2 = null;
	/* Column Info */
	private String qtyo2 = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String qtyo4 = null;
	/* Column Info */
	private String lcc = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String qtya4 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String qtys4 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String qtys2 = null;
	/* Column Info */
	private String qtydx = null;
	/* Column Info */
	private String qtyd9 = null;
	/* Column Info */
	private String qtyp4 = null;
	/* Column Info */
	private String reqno = null;
	/* Column Info */
	private String qtyd7 = null;
	/* Column Info */
	private String qtyp2 = null;
	/* Column Info */
	private String qtyd4 = null;
	/* Column Info */
	private String qtyf2 = null;
	/* Column Info */
	private String qtyd5 = null;
	/* Column Info */
	private String qtyd1 = null;
	/* Column Info */
	private String qtyd2 = null;
	/* Column Info */
	private String qtyd3 = null;
	/* Column Info */
	private String qtyf4 = null;
	/* Column Info */
	private String qtya5 = null;
	/* Column Info */
	private String qtyf5 = null;
	/* Column Info */
	private String qtyt2 = null;
	/* Column Info */
	private String qtyt4 = null;
	/* Column Info */
	private String term = null;
	/* Column Info */
	private String qtyr2 = null;
	/* Column Info */
	private String qtyr5 = null;
	/* Column Info */
	private String titlelist = null;
	/* Column Info */
	private String qtyr8 = null;
	/* Column Info */
	private String qtyr9 = null;
	/* Column Info */
	private String ordYr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchRequestListVO() {}

	public SearchRequestListVO(String ibflag, String pagerows, String qtyd2, String qtyd1, String qtyd4, String qtyd5, String qtyd7, String qtyr2, String qtyr5, String qtyr9, String qtyo2, String qtys2, String qtyo4, String qtyo5, String qtys4, String qtyf2, String qtya2, String qtyf4, String qtya5, String qtya4, String qtyf5, String qtyp2, String qtyp4, String qtyt2, String qtyt4, String qtyd3, String qtydx, String qtyd9, String qtyr8, String reqno, String creDt, String lcc, String total, String term, String titlelist, String remark, String totallist 
			   , String ordYr) {
		this.total = total;
		this.totallist = totallist;
		this.qtyo5 = qtyo5;
		this.qtya2 = qtya2;
		this.qtyo2 = qtyo2;
		this.remark = remark;
		this.qtyo4 = qtyo4;
		this.lcc = lcc;
		this.creDt = creDt;
		this.qtya4 = qtya4;
		this.pagerows = pagerows;
		this.qtys4 = qtys4;
		this.ibflag = ibflag;
		this.qtys2 = qtys2;
		this.qtydx = qtydx;
		this.qtyd9 = qtyd9;
		this.qtyp4 = qtyp4;
		this.reqno = reqno;
		this.qtyd7 = qtyd7;
		this.qtyp2 = qtyp2;
		this.qtyd4 = qtyd4;
		this.qtyf2 = qtyf2;
		this.qtyd5 = qtyd5;
		this.qtyd1 = qtyd1;
		this.qtyd2 = qtyd2;
		this.qtyd3 = qtyd3;
		this.qtyf4 = qtyf4;
		this.qtya5 = qtya5;
		this.qtyf5 = qtyf5;
		this.qtyt2 = qtyt2;
		this.qtyt4 = qtyt4;
		this.term = term;
		this.qtyr2 = qtyr2;
		this.qtyr5 = qtyr5;
		this.titlelist = titlelist;
		this.qtyr8 = qtyr8;
		this.qtyr9 = qtyr9;
		this.ordYr = ordYr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("totallist", getTotallist());
		this.hashColumns.put("qtyo5", getQtyo5());
		this.hashColumns.put("qtya2", getQtya2());
		this.hashColumns.put("qtyo2", getQtyo2());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("qtyo4", getQtyo4());
		this.hashColumns.put("lcc", getLcc());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("qtya4", getQtya4());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("qtys4", getQtys4());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("qtys2", getQtys2());
		this.hashColumns.put("qtydx", getQtydx());
		this.hashColumns.put("qtyd9", getQtyd9());
		this.hashColumns.put("qtyp4", getQtyp4());
		this.hashColumns.put("reqno", getReqno());
		this.hashColumns.put("qtyd7", getQtyd7());
		this.hashColumns.put("qtyp2", getQtyp2());
		this.hashColumns.put("qtyd4", getQtyd4());
		this.hashColumns.put("qtyf2", getQtyf2());
		this.hashColumns.put("qtyd5", getQtyd5());
		this.hashColumns.put("qtyd1", getQtyd1());
		this.hashColumns.put("qtyd2", getQtyd2());
		this.hashColumns.put("qtyd3", getQtyd3());
		this.hashColumns.put("qtyf4", getQtyf4());
		this.hashColumns.put("qtya5", getQtya5());
		this.hashColumns.put("qtyf5", getQtyf5());
		this.hashColumns.put("qtyt2", getQtyt2());
		this.hashColumns.put("qtyt4", getQtyt4());
		this.hashColumns.put("term", getTerm());
		this.hashColumns.put("qtyr2", getQtyr2());
		this.hashColumns.put("qtyr5", getQtyr5());
		this.hashColumns.put("titlelist", getTitlelist());
		this.hashColumns.put("qtyr8", getQtyr8());
		this.hashColumns.put("qtyr9", getQtyr9());
		this.hashColumns.put("ord_yr", getOrdYr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("totallist", "totallist");
		this.hashFields.put("qtyo5", "qtyo5");
		this.hashFields.put("qtya2", "qtya2");
		this.hashFields.put("qtyo2", "qtyo2");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("qtyo4", "qtyo4");
		this.hashFields.put("lcc", "lcc");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("qtya4", "qtya4");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("qtys4", "qtys4");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("qtys2", "qtys2");
		this.hashFields.put("qtydx", "qtydx");
		this.hashFields.put("qtyd9", "qtyd9");
		this.hashFields.put("qtyp4", "qtyp4");
		this.hashFields.put("reqno", "reqno");
		this.hashFields.put("qtyd7", "qtyd7");
		this.hashFields.put("qtyp2", "qtyp2");
		this.hashFields.put("qtyd4", "qtyd4");
		this.hashFields.put("qtyf2", "qtyf2");
		this.hashFields.put("qtyd5", "qtyd5");
		this.hashFields.put("qtyd1", "qtyd1");
		this.hashFields.put("qtyd2", "qtyd2");
		this.hashFields.put("qtyd3", "qtyd3");
		this.hashFields.put("qtyf4", "qtyf4");
		this.hashFields.put("qtya5", "qtya5");
		this.hashFields.put("qtyf5", "qtyf5");
		this.hashFields.put("qtyt2", "qtyt2");
		this.hashFields.put("qtyt4", "qtyt4");
		this.hashFields.put("term", "term");
		this.hashFields.put("qtyr2", "qtyr2");
		this.hashFields.put("qtyr5", "qtyr5");
		this.hashFields.put("titlelist", "titlelist");
		this.hashFields.put("qtyr8", "qtyr8");
		this.hashFields.put("qtyr9", "qtyr9");
		this.hashFields.put("ord_yr", "ordYr");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return totallist
	 */
	public String getTotallist() {
		return this.totallist;
	}
	
	/**
	 * Column Info
	 * @return qtyo5
	 */
	public String getQtyo5() {
		return this.qtyo5;
	}
	
	/**
	 * Column Info
	 * @return qtya2
	 */
	public String getQtya2() {
		return this.qtya2;
	}
	
	/**
	 * Column Info
	 * @return qtyo2
	 */
	public String getQtyo2() {
		return this.qtyo2;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return qtyo4
	 */
	public String getQtyo4() {
		return this.qtyo4;
	}
	
	/**
	 * Column Info
	 * @return lcc
	 */
	public String getLcc() {
		return this.lcc;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return qtya4
	 */
	public String getQtya4() {
		return this.qtya4;
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
	 * @return qtys4
	 */
	public String getQtys4() {
		return this.qtys4;
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
	 * @return qtys2
	 */
	public String getQtys2() {
		return this.qtys2;
	}
	
	/**
	 * Column Info
	 * @return qtydx
	 */
	public String getQtydx() {
		return this.qtydx;
	}
	
	/**
	 * Column Info
	 * @return qtyd9
	 */
	public String getQtyd9() {
		return this.qtyd9;
	}
	
	/**
	 * Column Info
	 * @return qtyp4
	 */
	public String getQtyp4() {
		return this.qtyp4;
	}
	
	/**
	 * Column Info
	 * @return reqno
	 */
	public String getReqno() {
		return this.reqno;
	}
	
	/**
	 * Column Info
	 * @return qtyd7
	 */
	public String getQtyd7() {
		return this.qtyd7;
	}
	
	/**
	 * Column Info
	 * @return qtyp2
	 */
	public String getQtyp2() {
		return this.qtyp2;
	}
	
	/**
	 * Column Info
	 * @return qtyd4
	 */
	public String getQtyd4() {
		return this.qtyd4;
	}
	
	/**
	 * Column Info
	 * @return qtyf2
	 */
	public String getQtyf2() {
		return this.qtyf2;
	}
	
	/**
	 * Column Info
	 * @return qtyd5
	 */
	public String getQtyd5() {
		return this.qtyd5;
	}
	
	/**
	 * Column Info
	 * @return qtyd1
	 */
	public String getQtyd1() {
		return this.qtyd1;
	}
	
	/**
	 * Column Info
	 * @return qtyd2
	 */
	public String getQtyd2() {
		return this.qtyd2;
	}
	
	/**
	 * Column Info
	 * @return qtyd3
	 */
	public String getQtyd3() {
		return this.qtyd3;
	}
	
	/**
	 * Column Info
	 * @return qtyf4
	 */
	public String getQtyf4() {
		return this.qtyf4;
	}
	
	/**
	 * Column Info
	 * @return qtya5
	 */
	public String getQtya5() {
		return this.qtya5;
	}	
	
	/**
	 * Column Info
	 * @return qtyf5
	 */
	public String getQtyf5() {
		return this.qtyf5;
	}
	
	/**
	 * Column Info
	 * @return qtyt2
	 */
	public String getQtyt2() {
		return this.qtyt2;
	}
	
	/**
	 * Column Info
	 * @return qtyt4
	 */
	public String getQtyt4() {
		return this.qtyt4;
	}
	
	/**
	 * Column Info
	 * @return term
	 */
	public String getTerm() {
		return this.term;
	}
	
	/**
	 * Column Info
	 * @return qtyr2
	 */
	public String getQtyr2() {
		return this.qtyr2;
	}
	
	/**
	 * Column Info
	 * @return qtyr5
	 */
	public String getQtyr5() {
		return this.qtyr5;
	}
	
	/**
	 * Column Info
	 * @return titlelist
	 */
	public String getTitlelist() {
		return this.titlelist;
	}
	
	/**
	 * Column Info
	 * @return qtyr8
	 */
	public String getQtyr8() {
		return this.qtyr8;
	}
	
	/**
	 * Column Info
	 * @return qtyr9
	 */
	public String getQtyr9() {
		return this.qtyr9;
	}
	

	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param totallist
	 */
	public void setTotallist(String totallist) {
		this.totallist = totallist;
	}
	
	/**
	 * Column Info
	 * @param qtyo5
	 */
	public void setQtyo5(String qtyo5) {
		this.qtyo5 = qtyo5;
	}
	
	/**
	 * Column Info
	 * @param qtya2
	 */
	public void setQtya2(String qtya2) {
		this.qtya2 = qtya2;
	}
	
	/**
	 * Column Info
	 * @param qtyo2
	 */
	public void setQtyo2(String qtyo2) {
		this.qtyo2 = qtyo2;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param qtyo4
	 */
	public void setQtyo4(String qtyo4) {
		this.qtyo4 = qtyo4;
	}
	
	/**
	 * Column Info
	 * @param lcc
	 */
	public void setLcc(String lcc) {
		this.lcc = lcc;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param qtya4
	 */
	public void setQtya4(String qtya4) {
		this.qtya4 = qtya4;
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
	 * @param qtys4
	 */
	public void setQtys4(String qtys4) {
		this.qtys4 = qtys4;
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
	 * @param qtys2
	 */
	public void setQtys2(String qtys2) {
		this.qtys2 = qtys2;
	}
	
	/**
	 * Column Info
	 * @param qtydx
	 */
	public void setQtydx(String qtydx) {
		this.qtydx = qtydx;
	}
	
	/**
	 * Column Info
	 * @param qtyd9
	 */
	public void setQtyd9(String qtyd9) {
		this.qtyd9 = qtyd9;
	}
	
	/**
	 * Column Info
	 * @param qtyp4
	 */
	public void setQtyp4(String qtyp4) {
		this.qtyp4 = qtyp4;
	}
	
	/**
	 * Column Info
	 * @param reqno
	 */
	public void setReqno(String reqno) {
		this.reqno = reqno;
	}
	
	/**
	 * Column Info
	 * @param qtyd7
	 */
	public void setQtyd7(String qtyd7) {
		this.qtyd7 = qtyd7;
	}
	
	/**
	 * Column Info
	 * @param qtyp2
	 */
	public void setQtyp2(String qtyp2) {
		this.qtyp2 = qtyp2;
	}
	
	/**
	 * Column Info
	 * @param qtyd4
	 */
	public void setQtyd4(String qtyd4) {
		this.qtyd4 = qtyd4;
	}
	
	/**
	 * Column Info
	 * @param qtyf2
	 */
	public void setQtyf2(String qtyf2) {
		this.qtyf2 = qtyf2;
	}
	
	/**
	 * Column Info
	 * @param qtyd5
	 */
	public void setQtyd5(String qtyd5) {
		this.qtyd5 = qtyd5;
	}
	
	/**
	 * Column Info
	 * @param qtyd1
	 */
	public void setQtyd1(String qtyd1) {
		this.qtyd1 = qtyd1;
	}	
	
	/**
	 * Column Info
	 * @param qtyd2
	 */
	public void setQtyd2(String qtyd2) {
		this.qtyd2 = qtyd2;
	}
	
	/**
	 * Column Info
	 * @param qtyd3
	 */
	public void setQtyd3(String qtyd3) {
		this.qtyd3 = qtyd3;
	}
	
	/**
	 * Column Info
	 * @param qtyf4
	 */
	public void setQtyf4(String qtyf4) {
		this.qtyf4 = qtyf4;
	}
	
	/**
	 * Column Info
	 * @param qtya5
	 */
	public void setQtya5(String qtya5) {
		this.qtya5 = qtya5;
	}	
	
	/**
	 * Column Info
	 * @param qtyf5
	 */
	public void setQtyf5(String qtyf5) {
		this.qtyf5 = qtyf5;
	}
	
	/**
	 * Column Info
	 * @param qtyt2
	 */
	public void setQtyt2(String qtyt2) {
		this.qtyt2 = qtyt2;
	}
	
	/**
	 * Column Info
	 * @param qtyt4
	 */
	public void setQtyt4(String qtyt4) {
		this.qtyt4 = qtyt4;
	}
	
	/**
	 * Column Info
	 * @param term
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	
	/**
	 * Column Info
	 * @param qtyr2
	 */
	public void setQtyr2(String qtyr2) {
		this.qtyr2 = qtyr2;
	}
	
	/**
	 * Column Info
	 * @param qtyr5
	 */
	public void setQtyr5(String qtyr5) {
		this.qtyr5 = qtyr5;
	}
	
	/**
	 * Column Info
	 * @param titlelist
	 */
	public void setTitlelist(String titlelist) {
		this.titlelist = titlelist;
	}
	
	/**
	 * Column Info
	 * @param qtyr8
	 */
	public void setQtyr8(String qtyr8) {
		this.qtyr8 = qtyr8;
	}
	
	/**
	 * Column Info
	 * @param qtyr9
	 */
	public void setQtyr9(String qtyr9) {
		this.qtyr9 = qtyr9;
	}
	
	
	
   /**
	 * @return the ordYr
	 */
	public String getOrdYr() {
		return ordYr;
	}

	/**
	 * @param ordYr the ordYr to set
	 */
	public void setOrdYr(String ordYr) {
		this.ordYr = ordYr;
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
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setTotallist(JSPUtil.getParameter(request, prefix + "totallist", ""));
		setQtyo5(JSPUtil.getParameter(request, prefix + "qtyo5", ""));
		setQtya2(JSPUtil.getParameter(request, prefix + "qtya2", ""));
		setQtyo2(JSPUtil.getParameter(request, prefix + "qtyo2", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setQtyo4(JSPUtil.getParameter(request, prefix + "qtyo4", ""));
		setLcc(JSPUtil.getParameter(request, prefix + "lcc", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setQtya4(JSPUtil.getParameter(request, prefix + "qtya4", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setQtys4(JSPUtil.getParameter(request, prefix + "qtys4", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setQtys2(JSPUtil.getParameter(request, prefix + "qtys2", ""));
		setQtydx(JSPUtil.getParameter(request, prefix + "qtydx", ""));
		setQtyd9(JSPUtil.getParameter(request, prefix + "qtyd9", ""));
		setQtyp4(JSPUtil.getParameter(request, prefix + "qtyp4", ""));
		setReqno(JSPUtil.getParameter(request, prefix + "reqno", ""));
		setQtyd7(JSPUtil.getParameter(request, prefix + "qtyd7", ""));
		setQtyp2(JSPUtil.getParameter(request, prefix + "qtyp2", ""));
		setQtyd4(JSPUtil.getParameter(request, prefix + "qtyd4", ""));
		setQtyf2(JSPUtil.getParameter(request, prefix + "qtyf2", ""));
		setQtyd5(JSPUtil.getParameter(request, prefix + "qtyd5", ""));
		setQtyd1(JSPUtil.getParameter(request, prefix + "qtyd1", ""));
		setQtyd2(JSPUtil.getParameter(request, prefix + "qtyd2", ""));
		setQtyd3(JSPUtil.getParameter(request, prefix + "qtyd3", ""));
		setQtyf4(JSPUtil.getParameter(request, prefix + "qtyf4", ""));
		setQtya5(JSPUtil.getParameter(request, prefix + "qtya5", ""));
		setQtyf5(JSPUtil.getParameter(request, prefix + "qtyf5", ""));
		setQtyt2(JSPUtil.getParameter(request, prefix + "qtyt2", ""));
		setQtyt4(JSPUtil.getParameter(request, prefix + "qtyt4", ""));
		setTerm(JSPUtil.getParameter(request, prefix + "term", ""));
		setQtyr2(JSPUtil.getParameter(request, prefix + "qtyr2", ""));
		setQtyr5(JSPUtil.getParameter(request, prefix + "qtyr5", ""));
		setTitlelist(JSPUtil.getParameter(request, prefix + "titlelist", ""));
		setQtyr8(JSPUtil.getParameter(request, prefix + "qtyr8", ""));
		setQtyr9(JSPUtil.getParameter(request, prefix + "qtyr9", ""));
		setOrdYr(JSPUtil.getParameter(request, prefix + "ord_yr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRequestListVO[]
	 */
	public SearchRequestListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRequestListVO[]
	 */
	public SearchRequestListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRequestListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] totallist = (JSPUtil.getParameter(request, prefix	+ "totallist", length));
			String[] qtyo5 = (JSPUtil.getParameter(request, prefix	+ "qtyo5", length));
			String[] qtya2 = (JSPUtil.getParameter(request, prefix	+ "qtya2", length));
			String[] qtyo2 = (JSPUtil.getParameter(request, prefix	+ "qtyo2", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] qtyo4 = (JSPUtil.getParameter(request, prefix	+ "qtyo4", length));
			String[] lcc = (JSPUtil.getParameter(request, prefix	+ "lcc", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] qtya4 = (JSPUtil.getParameter(request, prefix	+ "qtya4", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] qtys4 = (JSPUtil.getParameter(request, prefix	+ "qtys4", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] qtys2 = (JSPUtil.getParameter(request, prefix	+ "qtys2", length));
			String[] qtydx = (JSPUtil.getParameter(request, prefix	+ "qtydx", length));
			String[] qtyd9 = (JSPUtil.getParameter(request, prefix	+ "qtyd9", length));
			String[] qtyp4 = (JSPUtil.getParameter(request, prefix	+ "qtyp4", length));
			String[] reqno = (JSPUtil.getParameter(request, prefix	+ "reqno", length));
			String[] qtyd7 = (JSPUtil.getParameter(request, prefix	+ "qtyd7", length));
			String[] qtyp2 = (JSPUtil.getParameter(request, prefix	+ "qtyp2", length));
			String[] qtyd4 = (JSPUtil.getParameter(request, prefix	+ "qtyd4", length));
			String[] qtyf2 = (JSPUtil.getParameter(request, prefix	+ "qtyf2", length));
			String[] qtyd5 = (JSPUtil.getParameter(request, prefix	+ "qtyd5", length));
			String[] qtyd1 = (JSPUtil.getParameter(request, prefix	+ "qtyd1", length));
			String[] qtyd2 = (JSPUtil.getParameter(request, prefix	+ "qtyd2", length));
			String[] qtyd3 = (JSPUtil.getParameter(request, prefix	+ "qtyd3", length));
			String[] qtyf4 = (JSPUtil.getParameter(request, prefix	+ "qtyf4", length));
			String[] qtya5 = (JSPUtil.getParameter(request, prefix	+ "qtya5", length));
			String[] qtyf5 = (JSPUtil.getParameter(request, prefix	+ "qtyf5", length));
			String[] qtyt2 = (JSPUtil.getParameter(request, prefix	+ "qtyt2", length));
			String[] qtyt4 = (JSPUtil.getParameter(request, prefix	+ "qtyt4", length));
			String[] term = (JSPUtil.getParameter(request, prefix	+ "term", length));
			String[] qtyr2 = (JSPUtil.getParameter(request, prefix	+ "qtyr2", length));
			String[] qtyr5 = (JSPUtil.getParameter(request, prefix	+ "qtyr5", length));
			String[] titlelist = (JSPUtil.getParameter(request, prefix	+ "titlelist", length));
			String[] qtyr8 = (JSPUtil.getParameter(request, prefix	+ "qtyr8", length));
			String[] qtyr9 = (JSPUtil.getParameter(request, prefix	+ "qtyr9", length));
			String[] ordyr = (JSPUtil.getParameter(request, prefix	+ "ord_yr", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRequestListVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (totallist[i] != null)
					model.setTotallist(totallist[i]);
				if (qtyo5[i] != null)
					model.setQtyo5(qtyo5[i]);
				if (qtya2[i] != null)
					model.setQtya2(qtya2[i]);
				if (qtyo2[i] != null)
					model.setQtyo2(qtyo2[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (qtyo4[i] != null)
					model.setQtyo4(qtyo4[i]);
				if (lcc[i] != null)
					model.setLcc(lcc[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (qtya4[i] != null)
					model.setQtya4(qtya4[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (qtys4[i] != null)
					model.setQtys4(qtys4[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (qtys2[i] != null)
					model.setQtys2(qtys2[i]);
				if (qtydx[i] != null)
					model.setQtydx(qtydx[i]);
				if (qtyd9[i] != null)
					model.setQtyd9(qtyd9[i]);
				if (qtyp4[i] != null)
					model.setQtyp4(qtyp4[i]);
				if (reqno[i] != null)
					model.setReqno(reqno[i]);
				if (qtyd7[i] != null)
					model.setQtyd7(qtyd7[i]);
				if (qtyp2[i] != null)
					model.setQtyp2(qtyp2[i]);
				if (qtyd4[i] != null)
					model.setQtyd4(qtyd4[i]);
				if (qtyf2[i] != null)
					model.setQtyf2(qtyf2[i]);
				if (qtyd5[i] != null)
					model.setQtyd5(qtyd5[i]);
				if (qtyd1[i] != null)
					model.setQtyd1(qtyd1[i]);
				if (qtyd2[i] != null)
					model.setQtyd2(qtyd2[i]);
				if (qtyd3[i] != null)
					model.setQtyd3(qtyd3[i]);
				if (qtyf4[i] != null)
					model.setQtyf4(qtyf4[i]);
				if (qtya5[i] != null)
					model.setQtya5(qtya5[i]);
				if (qtyf5[i] != null)
					model.setQtyf5(qtyf5[i]);
				if (qtyt2[i] != null)
					model.setQtyt2(qtyt2[i]);
				if (qtyt4[i] != null)
					model.setQtyt4(qtyt4[i]);
				if (term[i] != null)
					model.setTerm(term[i]);
				if (qtyr2[i] != null)
					model.setQtyr2(qtyr2[i]);
				if (qtyr5[i] != null)
					model.setQtyr5(qtyr5[i]);
				if (titlelist[i] != null)
					model.setTitlelist(titlelist[i]);
				if (qtyr8[i] != null)
					model.setQtyr8(qtyr8[i]);
				if (qtyr9[i] != null)
					model.setQtyr9(qtyr9[i]);
				if (ordyr[i] != null)
					model.setOrdYr(ordyr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRequestListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRequestListVO[]
	 */
	public SearchRequestListVO[] getSearchRequestListVOs(){
		SearchRequestListVO[] vos = (SearchRequestListVO[])models.toArray(new SearchRequestListVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totallist = this.totallist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyo5 = this.qtyo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtya2 = this.qtya2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyo2 = this.qtyo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyo4 = this.qtyo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lcc = this.lcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtya4 = this.qtya4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtys4 = this.qtys4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtys2 = this.qtys2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtydx = this.qtydx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyd9 = this.qtyd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyp4 = this.qtyp4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqno = this.reqno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyd7 = this.qtyd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyp2 = this.qtyp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyd4 = this.qtyd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyf2 = this.qtyf2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyd5 = this.qtyd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyd1 = this.qtyd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyd2 = this.qtyd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyd3 = this.qtyd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyf4 = this.qtyf4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtya5 = this.qtya5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyf5 = this.qtyf5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyt2 = this.qtyt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyt4 = this.qtyt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.term = this.term .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyr2 = this.qtyr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyr5 = this.qtyr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.titlelist = this.titlelist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyr8 = this.qtyr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyr9 = this.qtyr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordYr = this.ordYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
	}
}
