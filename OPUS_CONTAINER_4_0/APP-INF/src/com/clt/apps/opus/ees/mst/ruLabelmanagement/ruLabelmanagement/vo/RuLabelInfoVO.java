/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : RuLabelInfoVO.java
 *@FileTitle : RuLabelInfoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.08.12
 *@LastModifier : YoungJin Park
 *@LastVersion : 1.0
 * 2014.08.12 YoungJin Park 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.vo;

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
 * @author YoungJin Park
 * @since J2EE 1.6
 * @see	..
 */
public class RuLabelInfoVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<RuLabelInfoVO>  models =	new	ArrayList<RuLabelInfoVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String ruLabelType = null;
	/*	Column Info	*/
	private String ruLabelValue = null;
	/*	Column Info	*/
	private String sCntrNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public RuLabelInfoVO(){}

	public RuLabelInfoVO(String ibflag,String pagerows,String ruLabelType,String ruLabelValue,String sCntrNo)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.ruLabelType = ruLabelType;
		this.ruLabelValue = ruLabelValue;
		this.sCntrNo = sCntrNo;
		
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ru_label_type", getRuLabelType());
		this.hashColumns.put("ru_label_value", getRuLabelValue());
		this.hashColumns.put("s_cntr_no", getSCntrNo());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ru_label_type", "ruLabelType");
		this.hashFields.put("ru_label_value", "ruLabelValue");
		this.hashFields.put("s_cntr_no", "sCntrNo");
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
	 * @return ruLabelType
	 */
	public	String getRuLabelType() {
		return	this.ruLabelType;
	}

	/**
	 * Column Info
	 * @return ruLabelValue
	 */
	public	String getRuLabelValue() {
		return	this.ruLabelValue;
	}

	/**
	 * Column Info
	 * @return sCntrNo
	 */
	public	String getSCntrNo() {
		return	this.sCntrNo;
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
	 * @param  ruLabelType
 	 */
	public void	setRuLabelType(String ruLabelType ) {
		this.ruLabelType =	ruLabelType;
	}
 	/**
	 * Column Info
	 * @param  ruLabelValue
 	 */
	public void	setRuLabelValue(String ruLabelValue ) {
		this.ruLabelValue =	ruLabelValue;
	}
 	/**
	 * Column Info
	 * @param  sCntrNo
 	 */
	public void	setSCntrNo(String sCntrNo ) {
		this.sCntrNo =	sCntrNo;
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
		setRuLabelType(JSPUtil.getParameter(request,	prefix + "ru_label_type", ""));
		setRuLabelValue(JSPUtil.getParameter(request,	prefix + "ru_label_value", ""));
		setSCntrNo(JSPUtil.getParameter(request,	prefix + "s_cntr_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RuLabelInfoVO[]
	 */
	public RuLabelInfoVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return RuLabelInfoVO[]
	 */
	public RuLabelInfoVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		RuLabelInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] ruLabelType =	(JSPUtil.getParameter(request, prefix +	"ru_label_type",	length));
			String[] ruLabelValue =	(JSPUtil.getParameter(request, prefix +	"ru_label_value",	length));
			String[] sCntrNo =	(JSPUtil.getParameter(request, prefix +	"s_cntr_no",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	RuLabelInfoVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( ruLabelType[i] !=	null)
					model.setRuLabelType( ruLabelType[i]);
				if ( ruLabelValue[i] !=	null)
					model.setRuLabelValue( ruLabelValue[i]);
				if ( sCntrNo[i] !=	null)
					model.setSCntrNo( sCntrNo[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getRuLabelInfoVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return RuLabelInfoVO[]
	 */
	public RuLabelInfoVO[]	 getRuLabelInfoVOs(){
		RuLabelInfoVO[] vos = (RuLabelInfoVO[])models.toArray(new	RuLabelInfoVO[models.size()]);
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
		this.ruLabelType =	this.ruLabelType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ruLabelValue =	this.ruLabelValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrNo =	this.sCntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}