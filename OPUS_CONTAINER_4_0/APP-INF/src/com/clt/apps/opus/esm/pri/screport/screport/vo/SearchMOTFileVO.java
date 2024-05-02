/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SearchMOTFileVO.java
 *@FileTitle : SearchMOTFileVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.04.21
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2016.04.21 jaewonLee 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.screport.screport.vo;

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
public class SearchMOTFileVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SearchMOTFileVO>  models =	new	ArrayList<SearchMOTFileVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String testExecDt = null;
	/*	Column Info	*/
	private String execDt = null;
	/*	Column Info	*/
	private String toFileDt = null;
	/*	Column Info	*/
	private String frFileDt = null;
	/*	Column Info	*/
	private String inqTpCd = null;
	/*	Column Info	*/
	private String batExeDt = null;
	/*	Column Info	*/
	private String chargeList = null;
	/*	Column Info	*/
	private String colNm = null;
	/*	Column Info	*/
	private String colTitle = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public SearchMOTFileVO(){}

	public SearchMOTFileVO(String ibflag,String pagerows,String testExecDt,String execDt,String toFileDt,String frFileDt,String inqTpCd,String batExeDt,String chargeList,String colNm,String colTitle)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.testExecDt = testExecDt;
		this.execDt = execDt;
		this.toFileDt = toFileDt;
		this.frFileDt = frFileDt;
		this.inqTpCd = inqTpCd;
		this.batExeDt = batExeDt;
		this.chargeList = chargeList;
		this.colNm = colNm;
		this.colTitle = colTitle;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("test_exec_dt", getTestExecDt());
		this.hashColumns.put("exec_dt", getExecDt());
		this.hashColumns.put("to_file_dt", getToFileDt());
		this.hashColumns.put("fr_file_dt", getFrFileDt());
		this.hashColumns.put("inq_tp_cd", getInqTpCd());
		this.hashColumns.put("bat_exe_dt", getBatExeDt());
		this.hashColumns.put("charge_list", getChargeList());
		this.hashColumns.put("col_nm", getColNm());
		this.hashColumns.put("col_title", getColTitle());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("test_exec_dt", "testExecDt");
		this.hashFields.put("exec_dt", "execDt");
		this.hashFields.put("to_file_dt", "toFileDt");
		this.hashFields.put("fr_file_dt", "frFileDt");
		this.hashFields.put("inq_tp_cd", "inqTpCd");
		this.hashFields.put("bat_exe_dt", "batExeDt");
		this.hashFields.put("charge_list", "chargeList");
		this.hashFields.put("col_nm", "colNm");
		this.hashFields.put("col_title", "colTitle");
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
	 * @return testExecDt
	 */
	public	String getTestExecDt() {
		return	this.testExecDt;
	}

	/**
	 * Column Info
	 * @return execDt
	 */
	public	String getExecDt() {
		return	this.execDt;
	}

	/**
	 * Column Info
	 * @return toFileDt
	 */
	public	String getToFileDt() {
		return	this.toFileDt;
	}

	/**
	 * Column Info
	 * @return frFileDt
	 */
	public	String getFrFileDt() {
		return	this.frFileDt;
	}

	/**
	 * Column Info
	 * @return inqTpCd
	 */
	public	String getInqTpCd() {
		return	this.inqTpCd;
	}

	/**
	 * Column Info
	 * @return batExeDt
	 */
	public	String getBatExeDt() {
		return	this.batExeDt;
	}

	/**
	 * Column Info
	 * @return chargeList
	 */
	public	String getChargeList() {
		return	this.chargeList;
	}

	/**
	 * Column Info
	 * @return colNm
	 */
	public	String getColNm() {
		return	this.colNm;
	}

	/**
	 * Column Info
	 * @return colTitle
	 */
	public	String getColTitle() {
		return	this.colTitle;
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
	 * @param  testExecDt
 	 */
	public void	setTestExecDt(String testExecDt ) {
		this.testExecDt =	testExecDt;
	}
 	/**
	 * Column Info
	 * @param  execDt
 	 */
	public void	setExecDt(String execDt ) {
		this.execDt =	execDt;
	}
 	/**
	 * Column Info
	 * @param  toFileDt
 	 */
	public void	setToFileDt(String toFileDt ) {
		this.toFileDt =	toFileDt;
	}
 	/**
	 * Column Info
	 * @param  frFileDt
 	 */
	public void	setFrFileDt(String frFileDt ) {
		this.frFileDt =	frFileDt;
	}
 	/**
	 * Column Info
	 * @param  inqTpCd
 	 */
	public void	setInqTpCd(String inqTpCd ) {
		this.inqTpCd =	inqTpCd;
	}
 	/**
	 * Column Info
	 * @param  batExeDt
 	 */
	public void	setBatExeDt(String batExeDt ) {
		this.batExeDt =	batExeDt;
	}
 	/**
	 * Column Info
	 * @param  chargeList
 	 */
	public void	setChargeList(String chargeList ) {
		this.chargeList =	chargeList;
	}
 	/**
	 * Column Info
	 * @param  colNm
 	 */
	public void	setColNm(String colNm ) {
		this.colNm =	colNm;
	}
 	/**
	 * Column Info
	 * @param  colTitle
 	 */
	public void	setColTitle(String colTitle ) {
		this.colTitle =	colTitle;
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
		setTestExecDt(JSPUtil.getParameter(request,	prefix + "test_exec_dt", ""));
		setExecDt(JSPUtil.getParameter(request,	prefix + "exec_dt", ""));
		setToFileDt(JSPUtil.getParameter(request,	prefix + "to_file_dt", ""));
		setFrFileDt(JSPUtil.getParameter(request,	prefix + "fr_file_dt", ""));
		setInqTpCd(JSPUtil.getParameter(request,	prefix + "inq_tp_cd", ""));
		setBatExeDt(JSPUtil.getParameter(request,	prefix + "bat_exe_dt", ""));
		setChargeList(JSPUtil.getParameter(request,	prefix + "charge_list", ""));
		setColNm(JSPUtil.getParameter(request,	prefix + "col_nm", ""));
		setColTitle(JSPUtil.getParameter(request,	prefix + "col_title", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMOTFileVO[]
	 */
	public SearchMOTFileVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchMOTFileVO[]
	 */
	public SearchMOTFileVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SearchMOTFileVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] testExecDt =	(JSPUtil.getParameter(request, prefix +	"test_exec_dt",	length));
			String[] execDt =	(JSPUtil.getParameter(request, prefix +	"exec_dt",	length));
			String[] toFileDt =	(JSPUtil.getParameter(request, prefix +	"to_file_dt",	length));
			String[] frFileDt =	(JSPUtil.getParameter(request, prefix +	"fr_file_dt",	length));
			String[] inqTpCd =	(JSPUtil.getParameter(request, prefix +	"inq_tp_cd",	length));
			String[] batExeDt =	(JSPUtil.getParameter(request, prefix +	"bat_exe_dt",	length));
			String[] chargeList =	(JSPUtil.getParameter(request, prefix +	"charge_list",	length));
			String[] colNm =	(JSPUtil.getParameter(request, prefix +	"col_nm",	length));
			String[] colTitle =	(JSPUtil.getParameter(request, prefix +	"col_title",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	SearchMOTFileVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( testExecDt[i] !=	null)
					model.setTestExecDt( testExecDt[i]);
				if ( execDt[i] !=	null)
					model.setExecDt( execDt[i]);
				if ( toFileDt[i] !=	null)
					model.setToFileDt( toFileDt[i]);
				if ( frFileDt[i] !=	null)
					model.setFrFileDt( frFileDt[i]);
				if ( inqTpCd[i] !=	null)
					model.setInqTpCd( inqTpCd[i]);
				if ( batExeDt[i] !=	null)
					model.setBatExeDt( batExeDt[i]);
				if ( chargeList[i] !=	null)
					model.setChargeList( chargeList[i]);
				if ( colNm[i] !=	null)
					model.setColNm( colNm[i]);
				if ( colTitle[i] !=	null)
					model.setColTitle( colTitle[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getSearchMOTFileVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return SearchMOTFileVO[]
	 */
	public SearchMOTFileVO[]	 getSearchMOTFileVOs(){
		SearchMOTFileVO[] vos = (SearchMOTFileVO[])models.toArray(new	SearchMOTFileVO[models.size()]);
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
		this.testExecDt =	this.testExecDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.execDt =	this.execDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toFileDt =	this.toFileDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frFileDt =	this.frFileDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inqTpCd =	this.inqTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batExeDt =	this.batExeDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chargeList =	this.chargeList.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colNm =	this.colNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colTitle =	this.colTitle.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}