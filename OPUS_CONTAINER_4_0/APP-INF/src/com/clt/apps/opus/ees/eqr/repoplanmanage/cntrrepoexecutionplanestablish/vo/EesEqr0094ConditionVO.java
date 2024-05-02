/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0094ConditionVO.java
*@FileTitle : EesEqr0094ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.20 정은호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0094ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0094ConditionVO> models = new ArrayList<EesEqr0094ConditionVO>();
	
	/* Column Info */
	private String hr = null;
	/* Column Info */
	private String col = null;
	/* Column Info */
	private String yard = null;
	/* Column Info */
	private String bkgnoSplit = null;
	/* Column Info */
	private String refId = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String refCheck = null;
	/* Column Info */
	private String fmEcc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rb = null;
	/* Column Info */
	private String hm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ma = null;
	/* Column Info */
	private String loctype = null;
	/* Column Info */
	private String dm = null;
	/* Column Info */
	private String tpszs = null;
	/* Column Info */
	private String dp = null;
	/* Column Info */
	private String move = null;
	/* Column Info */
	private String targetsheet = null;
	/* Column Info */
	private String currInd = null;
	/* Column Info */
	private String bkgno = null;
	/* Column Info */
	private String toEcc = null;
	/* Column Info */
	private String repoplanId = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String cntrno = null;
	/* Column Info */
	private String loclist = null;
	/* Column Info */
	private String hb = null;
	/* Column Info */
	private String im = null;
	/* Column Info */
	private String row = null;
	/* Column Info */
	private String cntrAll = null;
	/* Column Info */
	private String targetrow = null;
	/* Column Info */
	private String cntrNoList = null;
	/* Column Info */
	private String pf = null;
	/* Column Info */
	private String lease = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String view = null;
	/* Column Info */
	private String trspMode = null;
	
	/* Input Param */
	private String userLcc = "";
	/*	Column Info	*/
	private  String	 rstr_usg_lbl   =  null;
	/*	Column Info	*/
	private  String	 ru_lable_type   =  null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0094ConditionVO() {}

	public EesEqr0094ConditionVO(String ibflag, String pagerows, String refId, String targetsheet, String targetrow, String cntrno, String loctype, String loclist, String tpszs, String lease, String move, String currInd, String dm, String hr, String hb, String rb, String dp, String pf, String im, String ma, String hm, String cntrNo, String cntrNoList, String cntrAll, String repoplanId, String refCheck, String col, String bkgno, String bkgnoSplit, String yard, String agmtNo, String fmEcc, String toEcc, String trspMode, String plnYrwk, String view, String row,String rstr_usg_lbl,String ru_lable_type) {
		this.hr = hr;
		this.col = col;
		this.yard = yard;
		this.bkgnoSplit = bkgnoSplit;
		this.refId = refId;
		this.plnYrwk = plnYrwk;
		this.refCheck = refCheck;
		this.fmEcc = fmEcc;
		this.pagerows = pagerows;
		this.rb = rb;
		this.hm = hm;
		this.ibflag = ibflag;
		this.ma = ma;
		this.loctype = loctype;
		this.dm = dm;
		this.tpszs = tpszs;
		this.dp = dp;
		this.move = move;
		this.targetsheet = targetsheet;
		this.currInd = currInd;
		this.bkgno = bkgno;
		this.toEcc = toEcc;
		this.repoplanId = repoplanId;
		this.agmtNo = agmtNo;
		this.cntrno = cntrno;
		this.loclist = loclist;
		this.hb = hb;
		this.im = im;
		this.row = row;
		this.cntrAll = cntrAll;
		this.targetrow = targetrow;
		this.cntrNoList = cntrNoList;
		this.pf = pf;
		this.lease = lease;
		this.cntrNo = cntrNo;
		this.view = view;
		this.trspMode = trspMode;
		this.rstr_usg_lbl  = rstr_usg_lbl ;
		this.ru_lable_type  = ru_lable_type ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hr", getHr());
		this.hashColumns.put("col", getCol());
		this.hashColumns.put("yard", getYard());
		this.hashColumns.put("bkgno_split", getBkgnoSplit());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("ref_check", getRefCheck());
		this.hashColumns.put("fm_ecc", getFmEcc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rb", getRb());
		this.hashColumns.put("hm", getHm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ma", getMa());
		this.hashColumns.put("locType", getLoctype());
		this.hashColumns.put("dm", getDm());
		this.hashColumns.put("tpszs", getTpszs());
		this.hashColumns.put("dp", getDp());
		this.hashColumns.put("move", getMove());
		this.hashColumns.put("targetsheet", getTargetsheet());
		this.hashColumns.put("curr_ind", getCurrInd());
		this.hashColumns.put("bkgno", getBkgno());
		this.hashColumns.put("to_ecc", getToEcc());
		this.hashColumns.put("repoplan_id", getRepoplanId());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("cntrno", getCntrno());
		this.hashColumns.put("locList", getLoclist());
		this.hashColumns.put("hb", getHb());
		this.hashColumns.put("im", getIm());
		this.hashColumns.put("row", getRow());
		this.hashColumns.put("cntr_all", getCntrAll());
		this.hashColumns.put("targetrow", getTargetrow());
		this.hashColumns.put("cntr_no_list", getCntrNoList());
		this.hashColumns.put("pf", getPf());
		this.hashColumns.put("lease", getLease());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("view", getView());
		this.hashColumns.put("trans_mode", getTrspMode());
		this.hashColumns.put("userLcc", getUserLcc());
		this.hashColumns.put("rstr_usg_lbl", getRstr_usg_lbl());		
		this.hashColumns.put("ru_lable_type", getRu_lable_type());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hr", "hr");
		this.hashFields.put("col", "col");
		this.hashFields.put("yard", "yard");
		this.hashFields.put("bkgno_split", "bkgnoSplit");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("ref_check", "refCheck");
		this.hashFields.put("fm_ecc", "fmEcc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rb", "rb");
		this.hashFields.put("hm", "hm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ma", "ma");
		this.hashFields.put("loctype", "loctype");
		this.hashFields.put("dm", "dm");
		this.hashFields.put("tpszs", "tpszs");
		this.hashFields.put("dp", "dp");
		this.hashFields.put("move", "move");
		this.hashFields.put("targetsheet", "targetsheet");
		this.hashFields.put("curr_ind", "currInd");
		this.hashFields.put("bkgno", "bkgno");
		this.hashFields.put("to_ecc", "toEcc");
		this.hashFields.put("repoplan_id", "repoplanId");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("cntrno", "cntrno");
		this.hashFields.put("loclist", "loclist");
		this.hashFields.put("hb", "hb");
		this.hashFields.put("im", "im");
		this.hashFields.put("row", "row");
		this.hashFields.put("cntr_all", "cntrAll");
		this.hashFields.put("targetrow", "targetrow");
		this.hashFields.put("cntr_no_list", "cntrNoList");
		this.hashFields.put("pf", "pf");
		this.hashFields.put("lease", "lease");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("view", "view");
		this.hashFields.put("trsp_mode", "trspMode");
		this.hashFields.put("userLcc", "userLcc");
		this.hashFields.put("rstr_usg_lbl", "rstr_usg_lbl");
		this.hashFields.put("ru_lable_type", "ru_lable_type");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hr
	 */
	public String getHr() {
		return this.hr;
	}
	
	/**
	 * Column Info
	 * @return col
	 */
	public String getCol() {
		return this.col;
	}
	
	/**
	 * Column Info
	 * @return yard
	 */
	public String getYard() {
		return this.yard;
	}
	
	/**
	 * Column Info
	 * @return bkgnoSplit
	 */
	public String getBkgnoSplit() {
		return this.bkgnoSplit;
	}
	
	/**
	 * Column Info
	 * @return refId
	 */
	public String getRefId() {
		return this.refId;
	}
	
	/**
	 * Column Info
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
	}
	
	/**
	 * Column Info
	 * @return refCheck
	 */
	public String getRefCheck() {
		return this.refCheck;
	}
	
	/**
	 * Column Info
	 * @return fmEcc
	 */
	public String getFmEcc() {
		return this.fmEcc;
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
	 * @return rb
	 */
	public String getRb() {
		return this.rb;
	}
	
	/**
	 * Column Info
	 * @return hm
	 */
	public String getHm() {
		return this.hm;
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
	 * @return ma
	 */
	public String getMa() {
		return this.ma;
	}
	
	/**
	 * Column Info
	 * @return loctype
	 */
	public String getLoctype() {
		return this.loctype;
	}
	
	/**
	 * Column Info
	 * @return dm
	 */
	public String getDm() {
		return this.dm;
	}
	
	/**
	 * Column Info
	 * @return tpszs
	 */
	public String getTpszs() {
		return this.tpszs;
	}
	
	/**
	 * Column Info
	 * @return dp
	 */
	public String getDp() {
		return this.dp;
	}
	
	/**
	 * Column Info
	 * @return move
	 */
	public String getMove() {
		return this.move;
	}
	
	/**
	 * Column Info
	 * @return targetsheet
	 */
	public String getTargetsheet() {
		return this.targetsheet;
	}
	
	/**
	 * Column Info
	 * @return currInd
	 */
	public String getCurrInd() {
		return this.currInd;
	}
	
	/**
	 * Column Info
	 * @return bkgno
	 */
	public String getBkgno() {
		return this.bkgno;
	}
	
	/**
	 * Column Info
	 * @return toEcc
	 */
	public String getToEcc() {
		return this.toEcc;
	}
	
	/**
	 * Column Info
	 * @return repoplanId
	 */
	public String getRepoplanId() {
		return this.repoplanId;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return cntrno
	 */
	public String getCntrno() {
		return this.cntrno;
	}
	
	/**
	 * Column Info
	 * @return loclist
	 */
	public String getLoclist() {
		return this.loclist;
	}
	
	/**
	 * Column Info
	 * @return hb
	 */
	public String getHb() {
		return this.hb;
	}
	
	/**
	 * Column Info
	 * @return im
	 */
	public String getIm() {
		return this.im;
	}
	
	/**
	 * Column Info
	 * @return row
	 */
	public String getRow() {
		return this.row;
	}
	
	/**
	 * Column Info
	 * @return cntrAll
	 */
	public String getCntrAll() {
		return this.cntrAll;
	}
	
	/**
	 * Column Info
	 * @return targetrow
	 */
	public String getTargetrow() {
		return this.targetrow;
	}
	
	/**
	 * Column Info
	 * @return cntrNoList
	 */
	public String getCntrNoList() {
		return this.cntrNoList;
	}
	
	/**
	 * Column Info
	 * @return pf
	 */
	public String getPf() {
		return this.pf;
	}
	
	/**
	 * Column Info
	 * @return lease
	 */
	public String getLease() {
		return this.lease;
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
	 * @return view
	 */
	public String getView() {
		return this.view;
	}
	
	/**
	 * Column Info
	 * @return trspMode
	 */
	public String getTrspMode() {
		return this.trspMode;
	}
	

	/**
	 * Column Info
	 * @param hr
	 */
	public void setHr(String hr) {
		this.hr = hr;
	}
	
	/**
	 * Column Info
	 * @param col
	 */
	public void setCol(String col) {
		this.col = col;
	}
	
	/**
	 * Column Info
	 * @param yard
	 */
	public void setYard(String yard) {
		this.yard = yard;
	}
	
	/**
	 * Column Info
	 * @param bkgnoSplit
	 */
	public void setBkgnoSplit(String bkgnoSplit) {
		this.bkgnoSplit = bkgnoSplit;
	}
	
	/**
	 * Column Info
	 * @param refId
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}
	
	/**
	 * Column Info
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}
	
	/**
	 * Column Info
	 * @param refCheck
	 */
	public void setRefCheck(String refCheck) {
		this.refCheck = refCheck;
	}
	
	/**
	 * Column Info
	 * @param fmEcc
	 */
	public void setFmEcc(String fmEcc) {
		this.fmEcc = fmEcc;
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
	 * @param rb
	 */
	public void setRb(String rb) {
		this.rb = rb;
	}
	
	/**
	 * Column Info
	 * @param hm
	 */
	public void setHm(String hm) {
		this.hm = hm;
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
	 * @param ma
	 */
	public void setMa(String ma) {
		this.ma = ma;
	}
	
	/**
	 * Column Info
	 * @param loctype
	 */
	public void setLoctype(String loctype) {
		this.loctype = loctype;
	}
	
	/**
	 * Column Info
	 * @param dm
	 */
	public void setDm(String dm) {
		this.dm = dm;
	}
	
	/**
	 * Column Info
	 * @param tpszs
	 */
	public void setTpszs(String tpszs) {
		this.tpszs = tpszs;
	}
	
	/**
	 * Column Info
	 * @param dp
	 */
	public void setDp(String dp) {
		this.dp = dp;
	}
	
	/**
	 * Column Info
	 * @param move
	 */
	public void setMove(String move) {
		this.move = move;
	}
	
	/**
	 * Column Info
	 * @param targetsheet
	 */
	public void setTargetsheet(String targetsheet) {
		this.targetsheet = targetsheet;
	}
	
	/**
	 * Column Info
	 * @param currInd
	 */
	public void setCurrInd(String currInd) {
		this.currInd = currInd;
	}
	
	/**
	 * Column Info
	 * @param bkgno
	 */
	public void setBkgno(String bkgno) {
		this.bkgno = bkgno;
	}
	
	/**
	 * Column Info
	 * @param toEcc
	 */
	public void setToEcc(String toEcc) {
		this.toEcc = toEcc;
	}
	
	/**
	 * Column Info
	 * @param repoplanId
	 */
	public void setRepoplanId(String repoplanId) {
		this.repoplanId = repoplanId;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param cntrno
	 */
	public void setCntrno(String cntrno) {
		this.cntrno = cntrno;
	}
	
	/**
	 * Column Info
	 * @param loclist
	 */
	public void setLoclist(String loclist) {
		this.loclist = loclist;
	}
	
	/**
	 * Column Info
	 * @param hb
	 */
	public void setHb(String hb) {
		this.hb = hb;
	}
	
	/**
	 * Column Info
	 * @param im
	 */
	public void setIm(String im) {
		this.im = im;
	}
	
	/**
	 * Column Info
	 * @param row
	 */
	public void setRow(String row) {
		this.row = row;
	}
	
	/**
	 * Column Info
	 * @param cntrAll
	 */
	public void setCntrAll(String cntrAll) {
		this.cntrAll = cntrAll;
	}
	
	/**
	 * Column Info
	 * @param targetrow
	 */
	public void setTargetrow(String targetrow) {
		this.targetrow = targetrow;
	}
	
	/**
	 * Column Info
	 * @param cntrNoList
	 */
	public void setCntrNoList(String cntrNoList) {
		this.cntrNoList = cntrNoList;
	}
	
	/**
	 * Column Info
	 * @param pf
	 */
	public void setPf(String pf) {
		this.pf = pf;
	}
	
	/**
	 * Column Info
	 * @param lease
	 */
	public void setLease(String lease) {
		this.lease = lease;
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
	 * @param view
	 */
	public void setView(String view) {
		this.view = view;
	}
	
	/**
	 * Column Info
	 * @param trspMode
	 */
	public void setTrspMode(String trspMode) {
		this.trspMode = trspMode;
	}
	
	public String getUserLcc() {
		return userLcc;
	}

	public void setUserLcc(String userLcc) {
		this.userLcc = userLcc;
	}
	
	/**
	* Column Info
	* @param  rstr_usg_lbl
	*/
	public void	setRstr_usg_lbl( String	rstr_usg_lbl ) {
		this.rstr_usg_lbl =	rstr_usg_lbl;
	}
 
	/**
	 * Column Info
	 * @return	rstr_usg_lbl
	 */
	 public	 String	getRstr_usg_lbl() {
		 return	this.rstr_usg_lbl;
	 } 
 	/**
	* Column Info
	* @param  ru_lable_type
	*/
	public void	setRu_lable_type( String	ru_lable_type ) {
		this.ru_lable_type =	ru_lable_type;
	}
 
	/**
	 * Column Info
	 * @return	ru_lable_type
	 */
	 public	 String	getRu_lable_type() {
		 return	this.ru_lable_type;
	 } 


	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setHr(JSPUtil.getParameter(request, "hr", ""));
		setCol(JSPUtil.getParameter(request, "col", ""));
		setYard(JSPUtil.getParameter(request, "yard", ""));
		setBkgnoSplit(JSPUtil.getParameter(request, "bkgno_split", ""));
		setRefId(JSPUtil.getParameter(request, "ref_id", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setRefCheck(JSPUtil.getParameter(request, "ref_check", ""));
		setFmEcc(JSPUtil.getParameter(request, "fm_ecc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRb(JSPUtil.getParameter(request, "rb", ""));
		setHm(JSPUtil.getParameter(request, "hm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMa(JSPUtil.getParameter(request, "ma", ""));
		setLoctype(JSPUtil.getParameter(request, "loctype", ""));
		setDm(JSPUtil.getParameter(request, "dm", ""));
		setTpszs(JSPUtil.getParameter(request, "TPSZS", ""));
		setDp(JSPUtil.getParameter(request, "dp", ""));
		setMove(JSPUtil.getParameter(request, "move", ""));
		setTargetsheet(JSPUtil.getParameter(request, "targetSheet", ""));
		setCurrInd(JSPUtil.getParameter(request, "curr_ind", ""));
		setBkgno(JSPUtil.getParameter(request, "bkgno", ""));
		setToEcc(JSPUtil.getParameter(request, "to_ecc", ""));
		setRepoplanId(JSPUtil.getParameter(request, "repoplan_id", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setCntrno(JSPUtil.getParameter(request, "cntrno", ""));
		setLoclist(JSPUtil.getParameter(request, "locList", ""));
		setHb(JSPUtil.getParameter(request, "hb", ""));
		setIm(JSPUtil.getParameter(request, "im", ""));
		setRow(JSPUtil.getParameter(request, "row", ""));
		setCntrAll(JSPUtil.getParameter(request, "cntr_all", ""));
		setTargetrow(JSPUtil.getParameter(request, "targetRow", ""));
		setCntrNoList(JSPUtil.getParameter(request, "cntr_no_list", ""));
		setPf(JSPUtil.getParameter(request, "pf", ""));
		setLease(JSPUtil.getParameter(request, "lease", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setView(JSPUtil.getParameter(request, "view", ""));
		setTrspMode(JSPUtil.getParameter(request, "trsp_mode", ""));
		setRstr_usg_lbl(JSPUtil.getParameter(request,	"rstr_usg_lbl", ""));
		setRu_lable_type(JSPUtil.getParameter(request,	 "ru_lable_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0094ConditionVO[]
	 */
	public EesEqr0094ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0094ConditionVO[]
	 */
	public EesEqr0094ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0094ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hr = (JSPUtil.getParameter(request, prefix	+ "hr", length));
			String[] col = (JSPUtil.getParameter(request, prefix	+ "col", length));
			String[] yard = (JSPUtil.getParameter(request, prefix	+ "yard", length));
			String[] bkgnoSplit = (JSPUtil.getParameter(request, prefix	+ "bkgno_split", length));
			String[] refId = (JSPUtil.getParameter(request, prefix	+ "ref_id", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] refCheck = (JSPUtil.getParameter(request, prefix	+ "ref_check", length));
			String[] fmEcc = (JSPUtil.getParameter(request, prefix	+ "fm_ecc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rb = (JSPUtil.getParameter(request, prefix	+ "rb", length));
			String[] hm = (JSPUtil.getParameter(request, prefix	+ "hm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ma = (JSPUtil.getParameter(request, prefix	+ "ma", length));
			String[] loctype = (JSPUtil.getParameter(request, prefix	+ "loctype", length));
			String[] dm = (JSPUtil.getParameter(request, prefix	+ "dm", length));
			String[] tpszs = (JSPUtil.getParameter(request, prefix	+ "tpszs", length));
			String[] dp = (JSPUtil.getParameter(request, prefix	+ "dp", length));
			String[] move = (JSPUtil.getParameter(request, prefix	+ "move", length));
			String[] targetsheet = (JSPUtil.getParameter(request, prefix	+ "targetsheet", length));
			String[] currInd = (JSPUtil.getParameter(request, prefix	+ "curr_ind", length));
			String[] bkgno = (JSPUtil.getParameter(request, prefix	+ "bkgno", length));
			String[] toEcc = (JSPUtil.getParameter(request, prefix	+ "to_ecc", length));
			String[] repoplanId = (JSPUtil.getParameter(request, prefix	+ "repoplan_id", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] cntrno = (JSPUtil.getParameter(request, prefix	+ "cntrno", length));
			String[] loclist = (JSPUtil.getParameter(request, prefix	+ "loclist", length));
			String[] hb = (JSPUtil.getParameter(request, prefix	+ "hb", length));
			String[] im = (JSPUtil.getParameter(request, prefix	+ "im", length));
			String[] row = (JSPUtil.getParameter(request, prefix	+ "row", length));
			String[] cntrAll = (JSPUtil.getParameter(request, prefix	+ "cntr_all", length));
			String[] targetrow = (JSPUtil.getParameter(request, prefix	+ "targetrow", length));
			String[] cntrNoList = (JSPUtil.getParameter(request, prefix	+ "cntr_no_list", length));
			String[] pf = (JSPUtil.getParameter(request, prefix	+ "pf", length));
			String[] lease = (JSPUtil.getParameter(request, prefix	+ "lease", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] view = (JSPUtil.getParameter(request, prefix	+ "view", length));
			String[] trspMode = (JSPUtil.getParameter(request, prefix	+ "trsp_mode", length));
			String[] rstr_usg_lbl =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl".trim(),	length));
			String[] ru_lable_type =	(JSPUtil.getParameter(request, prefix +	"ru_lable_type".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0094ConditionVO();
				if (hr[i] != null)
					model.setHr(hr[i]);
				if (col[i] != null)
					model.setCol(col[i]);
				if (yard[i] != null)
					model.setYard(yard[i]);
				if (bkgnoSplit[i] != null)
					model.setBkgnoSplit(bkgnoSplit[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (refCheck[i] != null)
					model.setRefCheck(refCheck[i]);
				if (fmEcc[i] != null)
					model.setFmEcc(fmEcc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rb[i] != null)
					model.setRb(rb[i]);
				if (hm[i] != null)
					model.setHm(hm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ma[i] != null)
					model.setMa(ma[i]);
				if (loctype[i] != null)
					model.setLoctype(loctype[i]);
				if (dm[i] != null)
					model.setDm(dm[i]);
				if (tpszs[i] != null)
					model.setTpszs(tpszs[i]);
				if (dp[i] != null)
					model.setDp(dp[i]);
				if (move[i] != null)
					model.setMove(move[i]);
				if (targetsheet[i] != null)
					model.setTargetsheet(targetsheet[i]);
				if (currInd[i] != null)
					model.setCurrInd(currInd[i]);
				if (bkgno[i] != null)
					model.setBkgno(bkgno[i]);
				if (toEcc[i] != null)
					model.setToEcc(toEcc[i]);
				if (repoplanId[i] != null)
					model.setRepoplanId(repoplanId[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (cntrno[i] != null)
					model.setCntrno(cntrno[i]);
				if (loclist[i] != null)
					model.setLoclist(loclist[i]);
				if (hb[i] != null)
					model.setHb(hb[i]);
				if (im[i] != null)
					model.setIm(im[i]);
				if (row[i] != null)
					model.setRow(row[i]);
				if (cntrAll[i] != null)
					model.setCntrAll(cntrAll[i]);
				if (targetrow[i] != null)
					model.setTargetrow(targetrow[i]);
				if (cntrNoList[i] != null)
					model.setCntrNoList(cntrNoList[i]);
				if (pf[i] != null)
					model.setPf(pf[i]);
				if (lease[i] != null)
					model.setLease(lease[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (view[i] != null)
					model.setView(view[i]);
				if (trspMode[i] != null)
					model.setTrspMode(trspMode[i]);
				if ( rstr_usg_lbl[i] !=	null)
					model.setRstr_usg_lbl( rstr_usg_lbl[i]);
				if ( ru_lable_type[i] !=	null)
					model.setRu_lable_type( ru_lable_type[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0094ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0094ConditionVO[]
	 */
	public EesEqr0094ConditionVO[] getEesEqr0094ConditionVOs(){
		EesEqr0094ConditionVO[] vos = (EesEqr0094ConditionVO[])models.toArray(new EesEqr0094ConditionVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.hr = this.hr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col = this.col .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yard = this.yard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgnoSplit = this.bkgnoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refCheck = this.refCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEcc = this.fmEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rb = this.rb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hm = this.hm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ma = this.ma .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loctype = this.loctype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dm = this.dm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszs = this.tpszs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dp = this.dp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.move = this.move .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetsheet = this.targetsheet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currInd = this.currInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgno = this.bkgno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEcc = this.toEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoplanId = this.repoplanId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrno = this.cntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclist = this.loclist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hb = this.hb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.im = this.im .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.row = this.row .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAll = this.cntrAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetrow = this.targetrow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNoList = this.cntrNoList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pf = this.pf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lease = this.lease .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.view = this.view .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspMode = this.trspMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstr_usg_lbl =	this.rstr_usg_lbl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ru_lable_type =	this.ru_lable_type.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
