/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PriParaCdDtlVO.java
 *@FileTitle : PriParaCdDtlVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.13
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2014.10.13 jaewonLee 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.pricommon.pricommon.vo;

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
public class PriParaCdDtlVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PriParaCdDtlVO>  models =	new	ArrayList<PriParaCdDtlVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String hrdCdgId = null;
	/*	Column Info	*/
	private String hrdCdgIdSeq = null;
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
	private String creUsrId = null;
	/*	Column Info	*/
	private String creDt = null;
	/*	Column Info	*/
	private String updUsrId = null;
	/*	Column Info	*/
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public PriParaCdDtlVO(){}

	public PriParaCdDtlVO(String ibflag,String pagerows,String hrdCdgId,String hrdCdgIdSeq,String attrCtnt1,String attrCtnt2,String attrCtnt3,String attrCtnt4,String attrCtnt5,String attrCtnt6,String attrCtnt7,String attrCtnt8,String attrCtnt9,String attrCtnt10,String creUsrId,String creDt,String updUsrId,String updDt)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.hrdCdgId = hrdCdgId;
		this.hrdCdgIdSeq = hrdCdgIdSeq;
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
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hrd_cdg_id", getHrdCdgId());
		this.hashColumns.put("hrd_cdg_id_seq", getHrdCdgIdSeq());
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
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hrd_cdg_id", "hrdCdgId");
		this.hashFields.put("hrd_cdg_id_seq", "hrdCdgIdSeq");
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
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
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
	 * @return hrdCdgId
	 */
	public	String getHrdCdgId() {
		return	this.hrdCdgId;
	}

	/**
	 * Column Info
	 * @return hrdCdgIdSeq
	 */
	public	String getHrdCdgIdSeq() {
		return	this.hrdCdgIdSeq;
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
	 * @param  hrdCdgId
 	 */
	public void	setHrdCdgId(String hrdCdgId ) {
		this.hrdCdgId =	hrdCdgId;
	}
 	/**
	 * Column Info
	 * @param  hrdCdgIdSeq
 	 */
	public void	setHrdCdgIdSeq(String hrdCdgIdSeq ) {
		this.hrdCdgIdSeq =	hrdCdgIdSeq;
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
		setHrdCdgId(JSPUtil.getParameter(request,	prefix + "hrd_cdg_id", ""));
		setHrdCdgIdSeq(JSPUtil.getParameter(request,	prefix + "hrd_cdg_id_seq", ""));
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
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriParaCdDtlVO[]
	 */
	public PriParaCdDtlVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PriParaCdDtlVO[]
	 */
	public PriParaCdDtlVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PriParaCdDtlVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] hrdCdgId =	(JSPUtil.getParameter(request, prefix +	"hrd_cdg_id",	length));
			String[] hrdCdgIdSeq =	(JSPUtil.getParameter(request, prefix +	"hrd_cdg_id_seq",	length));
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
			String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id",	length));
			String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt",	length));
			String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id",	length));
			String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	PriParaCdDtlVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( hrdCdgId[i] !=	null)
					model.setHrdCdgId( hrdCdgId[i]);
				if ( hrdCdgIdSeq[i] !=	null)
					model.setHrdCdgIdSeq( hrdCdgIdSeq[i]);
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
				if ( creUsrId[i] !=	null)
					model.setCreUsrId( creUsrId[i]);
				if ( creDt[i] !=	null)
					model.setCreDt( creDt[i]);
				if ( updUsrId[i] !=	null)
					model.setUpdUsrId( updUsrId[i]);
				if ( updDt[i] !=	null)
					model.setUpdDt( updDt[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getPriParaCdDtlVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PriParaCdDtlVO[]
	 */
	public PriParaCdDtlVO[]	 getPriParaCdDtlVOs(){
		PriParaCdDtlVO[] vos = (PriParaCdDtlVO[])models.toArray(new	PriParaCdDtlVO[models.size()]);
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
		this.hrdCdgId =	this.hrdCdgId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hrdCdgIdSeq =	this.hrdCdgIdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}