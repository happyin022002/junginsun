/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PriValTmpVO.java
 *@FileTitle : PriValTmpVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.03.16
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2016.03.16 jaewonLee 
 * 1.0 Creation
=========================================================*/

package com.clt.syscommon.common.table;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author jaewonLee
 * @since J2EE 1.6
 * @see	..
 */
public class PriValTmpVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PriValTmpVO>  models =	new	ArrayList<PriValTmpVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String attrCtnt1 = null;
	/*	Column Info	*/
	private String attrCtnt2 = null;
	/*	Column Info	*/
	private String attrCtnt3 = null;
	/*	Column Info	*/
	private String attrCtnt4 = null;
	/*	Column Info	*/
	private String attrCtnt5 = null;
	/*	Column Info	*/
	private String attrCtnt6 = null;
	/*	Column Info	*/
	private String attrCtnt7 = null;
	/*	Column Info	*/
	private String attrCtnt8 = null;
	/*	Column Info	*/
	private String attrCtnt9 = null;
	/*	Column Info	*/
	private String attrCtnt10 = null;
	/*	Column Info	*/
	private String attrCtnt11 = null;
	/*	Column Info	*/
	private String attrCtnt12 = null;
	/*	Column Info	*/
	private String attrCtnt13 = null;
	/*	Column Info	*/
	private String attrCtnt14 = null;
	/*	Column Info	*/
	private String attrCtnt15 = null;
	/*	Column Info	*/
	private String attrCtnt16 = null;
	/*	Column Info	*/
	private String attrCtnt17 = null;
	/*	Column Info	*/
	private String attrCtnt18 = null;
	/*	Column Info	*/
	private String attrCtnt19 = null;
	/*	Column Info	*/
	private String attrCtnt20 = null;
	/*	Column Info	*/
	private String creUsrId = null;
	/*	Column Info	*/
	private String creDt = null;
	/*	Column Info	*/
	private String updUsrId = null;
	/*	Column Info	*/
	private String updDt = null;
	/*	Column Info	*/
	private String edwUpdDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public PriValTmpVO(){}

	public PriValTmpVO(String ibflag,String pagerows,String attrCtnt1,String attrCtnt2,String attrCtnt3,String attrCtnt4,String attrCtnt5,String attrCtnt6,String attrCtnt7,String attrCtnt8,String attrCtnt9,String attrCtnt10,String attrCtnt11,String attrCtnt12,String attrCtnt13,String attrCtnt14,String attrCtnt15,String attrCtnt16,String attrCtnt17,String attrCtnt18,String attrCtnt19,String attrCtnt20,String creUsrId,String creDt,String updUsrId,String updDt,String edwUpdDt)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.attrCtnt1 = attrCtnt1;
		this.attrCtnt2 = attrCtnt2;
		this.attrCtnt3 = attrCtnt3;
		this.attrCtnt4 = attrCtnt4;
		this.attrCtnt5 = attrCtnt5;
		this.attrCtnt6 = attrCtnt6;
		this.attrCtnt7 = attrCtnt7;
		this.attrCtnt8 = attrCtnt8;
		this.attrCtnt9 = attrCtnt9;
		this.attrCtnt10 = attrCtnt10;
		this.attrCtnt11 = attrCtnt11;
		this.attrCtnt12 = attrCtnt12;
		this.attrCtnt13 = attrCtnt13;
		this.attrCtnt14 = attrCtnt14;
		this.attrCtnt15 = attrCtnt15;
		this.attrCtnt16 = attrCtnt16;
		this.attrCtnt17 = attrCtnt17;
		this.attrCtnt18 = attrCtnt18;
		this.attrCtnt19 = attrCtnt19;
		this.attrCtnt20 = attrCtnt20;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.edwUpdDt = edwUpdDt;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("attr_ctnt1", getAttrCtnt1());
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());
		this.hashColumns.put("attr_ctnt3", getAttrCtnt3());
		this.hashColumns.put("attr_ctnt4", getAttrCtnt4());
		this.hashColumns.put("attr_ctnt5", getAttrCtnt5());
		this.hashColumns.put("attr_ctnt6", getAttrCtnt6());
		this.hashColumns.put("attr_ctnt7", getAttrCtnt7());
		this.hashColumns.put("attr_ctnt8", getAttrCtnt8());
		this.hashColumns.put("attr_ctnt9", getAttrCtnt9());
		this.hashColumns.put("attr_ctnt10", getAttrCtnt10());
		this.hashColumns.put("attr_ctnt11", getAttrCtnt11());
		this.hashColumns.put("attr_ctnt12", getAttrCtnt12());
		this.hashColumns.put("attr_ctnt13", getAttrCtnt13());
		this.hashColumns.put("attr_ctnt14", getAttrCtnt14());
		this.hashColumns.put("attr_ctnt15", getAttrCtnt15());
		this.hashColumns.put("attr_ctnt16", getAttrCtnt16());
		this.hashColumns.put("attr_ctnt17", getAttrCtnt17());
		this.hashColumns.put("attr_ctnt18", getAttrCtnt18());
		this.hashColumns.put("attr_ctnt19", getAttrCtnt19());
		this.hashColumns.put("attr_ctnt20", getAttrCtnt20());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("edw_upd_dt", getEdwUpdDt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("attr_ctnt1", "attrCtnt1");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("attr_ctnt3", "attrCtnt3");
		this.hashFields.put("attr_ctnt4", "attrCtnt4");
		this.hashFields.put("attr_ctnt5", "attrCtnt5");
		this.hashFields.put("attr_ctnt6", "attrCtnt6");
		this.hashFields.put("attr_ctnt7", "attrCtnt7");
		this.hashFields.put("attr_ctnt8", "attrCtnt8");
		this.hashFields.put("attr_ctnt9", "attrCtnt9");
		this.hashFields.put("attr_ctnt10", "attrCtnt10");
		this.hashFields.put("attr_ctnt11", "attrCtnt11");
		this.hashFields.put("attr_ctnt12", "attrCtnt12");
		this.hashFields.put("attr_ctnt13", "attrCtnt13");
		this.hashFields.put("attr_ctnt14", "attrCtnt14");
		this.hashFields.put("attr_ctnt15", "attrCtnt15");
		this.hashFields.put("attr_ctnt16", "attrCtnt16");
		this.hashFields.put("attr_ctnt17", "attrCtnt17");
		this.hashFields.put("attr_ctnt18", "attrCtnt18");
		this.hashFields.put("attr_ctnt19", "attrCtnt19");
		this.hashFields.put("attr_ctnt20", "attrCtnt20");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("edw_upd_dt", "edwUpdDt");
		return this.hashFields;
	}

	//	Getters	and	Setters

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public	String getIbflag() {
		return	this.ibflag;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public	String getPagerows() {
		return	this.pagerows;
	}

	/**
	 * Column Info
	 * @return attrCtnt1
	 */
	public	String getAttrCtnt1() {
		return	this.attrCtnt1;
	}

	/**
	 * Column Info
	 * @return attrCtnt2
	 */
	public	String getAttrCtnt2() {
		return	this.attrCtnt2;
	}

	/**
	 * Column Info
	 * @return attrCtnt3
	 */
	public	String getAttrCtnt3() {
		return	this.attrCtnt3;
	}

	/**
	 * Column Info
	 * @return attrCtnt4
	 */
	public	String getAttrCtnt4() {
		return	this.attrCtnt4;
	}

	/**
	 * Column Info
	 * @return attrCtnt5
	 */
	public	String getAttrCtnt5() {
		return	this.attrCtnt5;
	}

	/**
	 * Column Info
	 * @return attrCtnt6
	 */
	public	String getAttrCtnt6() {
		return	this.attrCtnt6;
	}

	/**
	 * Column Info
	 * @return attrCtnt7
	 */
	public	String getAttrCtnt7() {
		return	this.attrCtnt7;
	}

	/**
	 * Column Info
	 * @return attrCtnt8
	 */
	public	String getAttrCtnt8() {
		return	this.attrCtnt8;
	}

	/**
	 * Column Info
	 * @return attrCtnt9
	 */
	public	String getAttrCtnt9() {
		return	this.attrCtnt9;
	}

	/**
	 * Column Info
	 * @return attrCtnt10
	 */
	public	String getAttrCtnt10() {
		return	this.attrCtnt10;
	}

	/**
	 * Column Info
	 * @return attrCtnt11
	 */
	public	String getAttrCtnt11() {
		return	this.attrCtnt11;
	}

	/**
	 * Column Info
	 * @return attrCtnt12
	 */
	public	String getAttrCtnt12() {
		return	this.attrCtnt12;
	}

	/**
	 * Column Info
	 * @return attrCtnt13
	 */
	public	String getAttrCtnt13() {
		return	this.attrCtnt13;
	}

	/**
	 * Column Info
	 * @return attrCtnt14
	 */
	public	String getAttrCtnt14() {
		return	this.attrCtnt14;
	}

	/**
	 * Column Info
	 * @return attrCtnt15
	 */
	public	String getAttrCtnt15() {
		return	this.attrCtnt15;
	}

	/**
	 * Column Info
	 * @return attrCtnt16
	 */
	public	String getAttrCtnt16() {
		return	this.attrCtnt16;
	}

	/**
	 * Column Info
	 * @return attrCtnt17
	 */
	public	String getAttrCtnt17() {
		return	this.attrCtnt17;
	}

	/**
	 * Column Info
	 * @return attrCtnt18
	 */
	public	String getAttrCtnt18() {
		return	this.attrCtnt18;
	}

	/**
	 * Column Info
	 * @return attrCtnt19
	 */
	public	String getAttrCtnt19() {
		return	this.attrCtnt19;
	}

	/**
	 * Column Info
	 * @return attrCtnt20
	 */
	public	String getAttrCtnt20() {
		return	this.attrCtnt20;
	}

	/**
	 * Column Info
	 * @return creUsrId
	 */
	public	String getCreUsrId() {
		return	this.creUsrId;
	}

	/**
	 * Column Info
	 * @return creDt
	 */
	public	String getCreDt() {
		return	this.creDt;
	}

	/**
	 * Column Info
	 * @return updUsrId
	 */
	public	String getUpdUsrId() {
		return	this.updUsrId;
	}

	/**
	 * Column Info
	 * @return updDt
	 */
	public	String getUpdDt() {
		return	this.updDt;
	}

	/**
	 * Column Info
	 * @return edwUpdDt
	 */
	public	String getEdwUpdDt() {
		return	this.edwUpdDt;
	}

 	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
	public void	setIbflag(String ibflag ) {
		this.ibflag =	ibflag;
	}
 	/**
	 * Page Number
	 * @param  pagerows
 	 */
	public void	setPagerows(String pagerows ) {
		this.pagerows =	pagerows;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt1
 	 */
	public void	setAttrCtnt1(String attrCtnt1 ) {
		this.attrCtnt1 =	attrCtnt1;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt2
 	 */
	public void	setAttrCtnt2(String attrCtnt2 ) {
		this.attrCtnt2 =	attrCtnt2;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt3
 	 */
	public void	setAttrCtnt3(String attrCtnt3 ) {
		this.attrCtnt3 =	attrCtnt3;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt4
 	 */
	public void	setAttrCtnt4(String attrCtnt4 ) {
		this.attrCtnt4 =	attrCtnt4;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt5
 	 */
	public void	setAttrCtnt5(String attrCtnt5 ) {
		this.attrCtnt5 =	attrCtnt5;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt6
 	 */
	public void	setAttrCtnt6(String attrCtnt6 ) {
		this.attrCtnt6 =	attrCtnt6;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt7
 	 */
	public void	setAttrCtnt7(String attrCtnt7 ) {
		this.attrCtnt7 =	attrCtnt7;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt8
 	 */
	public void	setAttrCtnt8(String attrCtnt8 ) {
		this.attrCtnt8 =	attrCtnt8;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt9
 	 */
	public void	setAttrCtnt9(String attrCtnt9 ) {
		this.attrCtnt9 =	attrCtnt9;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt10
 	 */
	public void	setAttrCtnt10(String attrCtnt10 ) {
		this.attrCtnt10 =	attrCtnt10;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt11
 	 */
	public void	setAttrCtnt11(String attrCtnt11 ) {
		this.attrCtnt11 =	attrCtnt11;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt12
 	 */
	public void	setAttrCtnt12(String attrCtnt12 ) {
		this.attrCtnt12 =	attrCtnt12;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt13
 	 */
	public void	setAttrCtnt13(String attrCtnt13 ) {
		this.attrCtnt13 =	attrCtnt13;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt14
 	 */
	public void	setAttrCtnt14(String attrCtnt14 ) {
		this.attrCtnt14 =	attrCtnt14;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt15
 	 */
	public void	setAttrCtnt15(String attrCtnt15 ) {
		this.attrCtnt15 =	attrCtnt15;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt16
 	 */
	public void	setAttrCtnt16(String attrCtnt16 ) {
		this.attrCtnt16 =	attrCtnt16;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt17
 	 */
	public void	setAttrCtnt17(String attrCtnt17 ) {
		this.attrCtnt17 =	attrCtnt17;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt18
 	 */
	public void	setAttrCtnt18(String attrCtnt18 ) {
		this.attrCtnt18 =	attrCtnt18;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt19
 	 */
	public void	setAttrCtnt19(String attrCtnt19 ) {
		this.attrCtnt19 =	attrCtnt19;
	}
 	/**
	 * Column Info
	 * @param  attrCtnt20
 	 */
	public void	setAttrCtnt20(String attrCtnt20 ) {
		this.attrCtnt20 =	attrCtnt20;
	}
 	/**
	 * Column Info
	 * @param  creUsrId
 	 */
	public void	setCreUsrId(String creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 	/**
	 * Column Info
	 * @param  creDt
 	 */
	public void	setCreDt(String creDt ) {
		this.creDt =	creDt;
	}
 	/**
	 * Column Info
	 * @param  updUsrId
 	 */
	public void	setUpdUsrId(String updUsrId ) {
		this.updUsrId =	updUsrId;
	}
 	/**
	 * Column Info
	 * @param  updDt
 	 */
	public void	setUpdDt(String updDt ) {
		this.updDt =	updDt;
	}
 	/**
	 * Column Info
	 * @param  edwUpdDt
 	 */
	public void	setEdwUpdDt(String edwUpdDt ) {
		this.edwUpdDt =	edwUpdDt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setAttrCtnt1(JSPUtil.getParameter(request,	prefix + "attr_ctnt1", ""));
		setAttrCtnt2(JSPUtil.getParameter(request,	prefix + "attr_ctnt2", ""));
		setAttrCtnt3(JSPUtil.getParameter(request,	prefix + "attr_ctnt3", ""));
		setAttrCtnt4(JSPUtil.getParameter(request,	prefix + "attr_ctnt4", ""));
		setAttrCtnt5(JSPUtil.getParameter(request,	prefix + "attr_ctnt5", ""));
		setAttrCtnt6(JSPUtil.getParameter(request,	prefix + "attr_ctnt6", ""));
		setAttrCtnt7(JSPUtil.getParameter(request,	prefix + "attr_ctnt7", ""));
		setAttrCtnt8(JSPUtil.getParameter(request,	prefix + "attr_ctnt8", ""));
		setAttrCtnt9(JSPUtil.getParameter(request,	prefix + "attr_ctnt9", ""));
		setAttrCtnt10(JSPUtil.getParameter(request,	prefix + "attr_ctnt10", ""));
		setAttrCtnt11(JSPUtil.getParameter(request,	prefix + "attr_ctnt11", ""));
		setAttrCtnt12(JSPUtil.getParameter(request,	prefix + "attr_ctnt12", ""));
		setAttrCtnt13(JSPUtil.getParameter(request,	prefix + "attr_ctnt13", ""));
		setAttrCtnt14(JSPUtil.getParameter(request,	prefix + "attr_ctnt14", ""));
		setAttrCtnt15(JSPUtil.getParameter(request,	prefix + "attr_ctnt15", ""));
		setAttrCtnt16(JSPUtil.getParameter(request,	prefix + "attr_ctnt16", ""));
		setAttrCtnt17(JSPUtil.getParameter(request,	prefix + "attr_ctnt17", ""));
		setAttrCtnt18(JSPUtil.getParameter(request,	prefix + "attr_ctnt18", ""));
		setAttrCtnt19(JSPUtil.getParameter(request,	prefix + "attr_ctnt19", ""));
		setAttrCtnt20(JSPUtil.getParameter(request,	prefix + "attr_ctnt20", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setEdwUpdDt(JSPUtil.getParameter(request,	prefix + "edw_upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriValTmpVO[]
	 */
	public PriValTmpVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PriValTmpVO[]
	 */
	public PriValTmpVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PriValTmpVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] attrCtnt1 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt1",	length));
			String[] attrCtnt2 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt2",	length));
			String[] attrCtnt3 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt3",	length));
			String[] attrCtnt4 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt4",	length));
			String[] attrCtnt5 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt5",	length));
			String[] attrCtnt6 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt6",	length));
			String[] attrCtnt7 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt7",	length));
			String[] attrCtnt8 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt8",	length));
			String[] attrCtnt9 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt9",	length));
			String[] attrCtnt10 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt10",	length));
			String[] attrCtnt11 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt11",	length));
			String[] attrCtnt12 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt12",	length));
			String[] attrCtnt13 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt13",	length));
			String[] attrCtnt14 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt14",	length));
			String[] attrCtnt15 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt15",	length));
			String[] attrCtnt16 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt16",	length));
			String[] attrCtnt17 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt17",	length));
			String[] attrCtnt18 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt18",	length));
			String[] attrCtnt19 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt19",	length));
			String[] attrCtnt20 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt20",	length));
			String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id",	length));
			String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt",	length));
			String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id",	length));
			String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt",	length));
			String[] edwUpdDt =	(JSPUtil.getParameter(request, prefix +	"edw_upd_dt",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	PriValTmpVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( attrCtnt1[i] !=	null)
					model.setAttrCtnt1( attrCtnt1[i]);
				if ( attrCtnt2[i] !=	null)
					model.setAttrCtnt2( attrCtnt2[i]);
				if ( attrCtnt3[i] !=	null)
					model.setAttrCtnt3( attrCtnt3[i]);
				if ( attrCtnt4[i] !=	null)
					model.setAttrCtnt4( attrCtnt4[i]);
				if ( attrCtnt5[i] !=	null)
					model.setAttrCtnt5( attrCtnt5[i]);
				if ( attrCtnt6[i] !=	null)
					model.setAttrCtnt6( attrCtnt6[i]);
				if ( attrCtnt7[i] !=	null)
					model.setAttrCtnt7( attrCtnt7[i]);
				if ( attrCtnt8[i] !=	null)
					model.setAttrCtnt8( attrCtnt8[i]);
				if ( attrCtnt9[i] !=	null)
					model.setAttrCtnt9( attrCtnt9[i]);
				if ( attrCtnt10[i] !=	null)
					model.setAttrCtnt10( attrCtnt10[i]);
				if ( attrCtnt11[i] !=	null)
					model.setAttrCtnt11( attrCtnt11[i]);
				if ( attrCtnt12[i] !=	null)
					model.setAttrCtnt12( attrCtnt12[i]);
				if ( attrCtnt13[i] !=	null)
					model.setAttrCtnt13( attrCtnt13[i]);
				if ( attrCtnt14[i] !=	null)
					model.setAttrCtnt14( attrCtnt14[i]);
				if ( attrCtnt15[i] !=	null)
					model.setAttrCtnt15( attrCtnt15[i]);
				if ( attrCtnt16[i] !=	null)
					model.setAttrCtnt16( attrCtnt16[i]);
				if ( attrCtnt17[i] !=	null)
					model.setAttrCtnt17( attrCtnt17[i]);
				if ( attrCtnt18[i] !=	null)
					model.setAttrCtnt18( attrCtnt18[i]);
				if ( attrCtnt19[i] !=	null)
					model.setAttrCtnt19( attrCtnt19[i]);
				if ( attrCtnt20[i] !=	null)
					model.setAttrCtnt20( attrCtnt20[i]);
				if ( creUsrId[i] !=	null)
					model.setCreUsrId( creUsrId[i]);
				if ( creDt[i] !=	null)
					model.setCreDt( creDt[i]);
				if ( updUsrId[i] !=	null)
					model.setUpdUsrId( updUsrId[i]);
				if ( updDt[i] !=	null)
					model.setUpdDt( updDt[i]);
				if ( edwUpdDt[i] !=	null)
					model.setEdwUpdDt( edwUpdDt[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getPriValTmpVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PriValTmpVO[]
	 */
	public PriValTmpVO[]	 getPriValTmpVOs(){
		PriValTmpVO[] vos = (PriValTmpVO[])models.toArray(new	PriValTmpVO[models.size()]);
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
	public void	unDataFormat(){
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt1 =	this.attrCtnt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 =	this.attrCtnt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt3 =	this.attrCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt4 =	this.attrCtnt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt5 =	this.attrCtnt5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt6 =	this.attrCtnt6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt7 =	this.attrCtnt7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt8 =	this.attrCtnt8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt9 =	this.attrCtnt9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt10 =	this.attrCtnt10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt11 =	this.attrCtnt11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt12 =	this.attrCtnt12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt13 =	this.attrCtnt13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt14 =	this.attrCtnt14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt15 =	this.attrCtnt15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt16 =	this.attrCtnt16.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt17 =	this.attrCtnt17.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt18 =	this.attrCtnt18.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt19 =	this.attrCtnt19.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt20 =	this.attrCtnt20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edwUpdDt =	this.edwUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}