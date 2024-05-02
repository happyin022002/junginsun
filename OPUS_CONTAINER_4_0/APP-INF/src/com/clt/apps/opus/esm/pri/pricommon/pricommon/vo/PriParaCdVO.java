/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PriParaCdVO.java
 *@FileTitle : PriParaCdVO
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
public class PriParaCdVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PriParaCdVO>  models =	new	ArrayList<PriParaCdVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String hrdCdgId = null;
	/*	Column Info	*/
	private String hrdCdgDesc = null;
	/*	Column Info	*/
	private String attrNm1 = null;
	/*	Column Info	*/
	private String attrNm2 = null;
	/*	Column Info	*/
	private String attrNm3 = null;
	/*	Column Info	*/
	private String attrNm4 = null;
	/*	Column Info	*/
	private String attrNm5 = null;
	/*	Column Info	*/
	private String attrNm6 = null;
	/*	Column Info	*/
	private String attrNm7 = null;
	/*	Column Info	*/
	private String attrNm8 = null;
	/*	Column Info	*/
	private String attrNm9 = null;
	/*	Column Info	*/
	private String attrNm10 = null;
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
	public PriParaCdVO(){}

	public PriParaCdVO(String ibflag,String pagerows,String hrdCdgId,String hrdCdgDesc,String attrNm1,String attrNm2,String attrNm3,String attrNm4,String attrNm5,String attrNm6,String attrNm7,String attrNm8,String attrNm9,String attrNm10,String creUsrId,String creDt,String updUsrId,String updDt)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.hrdCdgId = hrdCdgId;
		this.hrdCdgDesc = hrdCdgDesc;
		this.attrNm1 = attrNm1;
		this.attrNm2 = attrNm2;
		this.attrNm3 = attrNm3;
		this.attrNm4 = attrNm4;
		this.attrNm5 = attrNm5;
		this.attrNm6 = attrNm6;
		this.attrNm7 = attrNm7;
		this.attrNm8 = attrNm8;
		this.attrNm9 = attrNm9;
		this.attrNm10 = attrNm10;
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
		this.hashColumns.put("hrd_cdg_desc", getHrdCdgDesc());
		this.hashColumns.put("attr_nm1", getAttrNm1());
		this.hashColumns.put("attr_nm2", getAttrNm2());
		this.hashColumns.put("attr_nm3", getAttrNm3());
		this.hashColumns.put("attr_nm4", getAttrNm4());
		this.hashColumns.put("attr_nm5", getAttrNm5());
		this.hashColumns.put("attr_nm6", getAttrNm6());
		this.hashColumns.put("attr_nm7", getAttrNm7());
		this.hashColumns.put("attr_nm8", getAttrNm8());
		this.hashColumns.put("attr_nm9", getAttrNm9());
		this.hashColumns.put("attr_nm10", getAttrNm10());
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
		this.hashFields.put("hrd_cdg_desc", "hrdCdgDesc");
		this.hashFields.put("attr_nm1", "attrNm1");
		this.hashFields.put("attr_nm2", "attrNm2");
		this.hashFields.put("attr_nm3", "attrNm3");
		this.hashFields.put("attr_nm4", "attrNm4");
		this.hashFields.put("attr_nm5", "attrNm5");
		this.hashFields.put("attr_nm6", "attrNm6");
		this.hashFields.put("attr_nm7", "attrNm7");
		this.hashFields.put("attr_nm8", "attrNm8");
		this.hashFields.put("attr_nm9", "attrNm9");
		this.hashFields.put("attr_nm10", "attrNm10");
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
	 * @return hrdCdgDesc
	 */
	public	String getHrdCdgDesc() {
		return	this.hrdCdgDesc;
	}

	/**
	 * Column Info
	 * @return attrNm1
	 */
	public	String getAttrNm1() {
		return	this.attrNm1;
	}

	/**
	 * Column Info
	 * @return attrNm2
	 */
	public	String getAttrNm2() {
		return	this.attrNm2;
	}

	/**
	 * Column Info
	 * @return attrNm3
	 */
	public	String getAttrNm3() {
		return	this.attrNm3;
	}

	/**
	 * Column Info
	 * @return attrNm4
	 */
	public	String getAttrNm4() {
		return	this.attrNm4;
	}

	/**
	 * Column Info
	 * @return attrNm5
	 */
	public	String getAttrNm5() {
		return	this.attrNm5;
	}

	/**
	 * Column Info
	 * @return attrNm6
	 */
	public	String getAttrNm6() {
		return	this.attrNm6;
	}

	/**
	 * Column Info
	 * @return attrNm7
	 */
	public	String getAttrNm7() {
		return	this.attrNm7;
	}

	/**
	 * Column Info
	 * @return attrNm8
	 */
	public	String getAttrNm8() {
		return	this.attrNm8;
	}

	/**
	 * Column Info
	 * @return attrNm9
	 */
	public	String getAttrNm9() {
		return	this.attrNm9;
	}

	/**
	 * Column Info
	 * @return attrNm10
	 */
	public	String getAttrNm10() {
		return	this.attrNm10;
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
	 * @param  hrdCdgDesc
 	 */
	public void	setHrdCdgDesc(String hrdCdgDesc ) {
		this.hrdCdgDesc =	hrdCdgDesc;
	}
 	/**
	 * Column Info
	 * @param  attrNm1
 	 */
	public void	setAttrNm1(String attrNm1 ) {
		this.attrNm1 =	attrNm1;
	}
 	/**
	 * Column Info
	 * @param  attrNm2
 	 */
	public void	setAttrNm2(String attrNm2 ) {
		this.attrNm2 =	attrNm2;
	}
 	/**
	 * Column Info
	 * @param  attrNm3
 	 */
	public void	setAttrNm3(String attrNm3 ) {
		this.attrNm3 =	attrNm3;
	}
 	/**
	 * Column Info
	 * @param  attrNm4
 	 */
	public void	setAttrNm4(String attrNm4 ) {
		this.attrNm4 =	attrNm4;
	}
 	/**
	 * Column Info
	 * @param  attrNm5
 	 */
	public void	setAttrNm5(String attrNm5 ) {
		this.attrNm5 =	attrNm5;
	}
 	/**
	 * Column Info
	 * @param  attrNm6
 	 */
	public void	setAttrNm6(String attrNm6 ) {
		this.attrNm6 =	attrNm6;
	}
 	/**
	 * Column Info
	 * @param  attrNm7
 	 */
	public void	setAttrNm7(String attrNm7 ) {
		this.attrNm7 =	attrNm7;
	}
 	/**
	 * Column Info
	 * @param  attrNm8
 	 */
	public void	setAttrNm8(String attrNm8 ) {
		this.attrNm8 =	attrNm8;
	}
 	/**
	 * Column Info
	 * @param  attrNm9
 	 */
	public void	setAttrNm9(String attrNm9 ) {
		this.attrNm9 =	attrNm9;
	}
 	/**
	 * Column Info
	 * @param  attrNm10
 	 */
	public void	setAttrNm10(String attrNm10 ) {
		this.attrNm10 =	attrNm10;
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
		setHrdCdgDesc(JSPUtil.getParameter(request,	prefix + "hrd_cdg_desc", ""));
		setAttrNm1(JSPUtil.getParameter(request,	prefix + "attr_nm1", ""));
		setAttrNm2(JSPUtil.getParameter(request,	prefix + "attr_nm2", ""));
		setAttrNm3(JSPUtil.getParameter(request,	prefix + "attr_nm3", ""));
		setAttrNm4(JSPUtil.getParameter(request,	prefix + "attr_nm4", ""));
		setAttrNm5(JSPUtil.getParameter(request,	prefix + "attr_nm5", ""));
		setAttrNm6(JSPUtil.getParameter(request,	prefix + "attr_nm6", ""));
		setAttrNm7(JSPUtil.getParameter(request,	prefix + "attr_nm7", ""));
		setAttrNm8(JSPUtil.getParameter(request,	prefix + "attr_nm8", ""));
		setAttrNm9(JSPUtil.getParameter(request,	prefix + "attr_nm9", ""));
		setAttrNm10(JSPUtil.getParameter(request,	prefix + "attr_nm10", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriParaCdVO[]
	 */
	public PriParaCdVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PriParaCdVO[]
	 */
	public PriParaCdVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PriParaCdVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] hrdCdgId =	(JSPUtil.getParameter(request, prefix +	"hrd_cdg_id",	length));
			String[] hrdCdgDesc =	(JSPUtil.getParameter(request, prefix +	"hrd_cdg_desc",	length));
			String[] attrNm1 =	(JSPUtil.getParameter(request, prefix +	"attr_nm1",	length));
			String[] attrNm2 =	(JSPUtil.getParameter(request, prefix +	"attr_nm2",	length));
			String[] attrNm3 =	(JSPUtil.getParameter(request, prefix +	"attr_nm3",	length));
			String[] attrNm4 =	(JSPUtil.getParameter(request, prefix +	"attr_nm4",	length));
			String[] attrNm5 =	(JSPUtil.getParameter(request, prefix +	"attr_nm5",	length));
			String[] attrNm6 =	(JSPUtil.getParameter(request, prefix +	"attr_nm6",	length));
			String[] attrNm7 =	(JSPUtil.getParameter(request, prefix +	"attr_nm7",	length));
			String[] attrNm8 =	(JSPUtil.getParameter(request, prefix +	"attr_nm8",	length));
			String[] attrNm9 =	(JSPUtil.getParameter(request, prefix +	"attr_nm9",	length));
			String[] attrNm10 =	(JSPUtil.getParameter(request, prefix +	"attr_nm10",	length));
			String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id",	length));
			String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt",	length));
			String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id",	length));
			String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	PriParaCdVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( hrdCdgId[i] !=	null)
					model.setHrdCdgId( hrdCdgId[i]);
				if ( hrdCdgDesc[i] !=	null)
					model.setHrdCdgDesc( hrdCdgDesc[i]);
				if ( attrNm1[i] !=	null)
					model.setAttrNm1( attrNm1[i]);
				if ( attrNm2[i] !=	null)
					model.setAttrNm2( attrNm2[i]);
				if ( attrNm3[i] !=	null)
					model.setAttrNm3( attrNm3[i]);
				if ( attrNm4[i] !=	null)
					model.setAttrNm4( attrNm4[i]);
				if ( attrNm5[i] !=	null)
					model.setAttrNm5( attrNm5[i]);
				if ( attrNm6[i] !=	null)
					model.setAttrNm6( attrNm6[i]);
				if ( attrNm7[i] !=	null)
					model.setAttrNm7( attrNm7[i]);
				if ( attrNm8[i] !=	null)
					model.setAttrNm8( attrNm8[i]);
				if ( attrNm9[i] !=	null)
					model.setAttrNm9( attrNm9[i]);
				if ( attrNm10[i] !=	null)
					model.setAttrNm10( attrNm10[i]);
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
		return getPriParaCdVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PriParaCdVO[]
	 */
	public PriParaCdVO[]	 getPriParaCdVOs(){
		PriParaCdVO[] vos = (PriParaCdVO[])models.toArray(new	PriParaCdVO[models.size()]);
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
		this.hrdCdgDesc =	this.hrdCdgDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm1 =	this.attrNm1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm2 =	this.attrNm2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm3 =	this.attrNm3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm4 =	this.attrNm4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm5 =	this.attrNm5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm6 =	this.attrNm6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm7 =	this.attrNm7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm8 =	this.attrNm8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm9 =	this.attrNm9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm10 =	this.attrNm10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}