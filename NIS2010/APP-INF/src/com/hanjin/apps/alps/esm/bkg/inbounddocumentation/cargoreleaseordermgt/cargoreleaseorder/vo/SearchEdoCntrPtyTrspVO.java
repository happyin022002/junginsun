/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchEdoCntrPtyTrspVO.java
*@FileTitle : SearchEdoCntrPtyTrspVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.11  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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

public class SearchEdoCntrPtyTrspVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SearchEdoCntrPtyTrspVO>  models =	new	ArrayList<SearchEdoCntrPtyTrspVO>();


	/*	Column Info	*/
	private  String	 edoCntrPtyTrspSeq   =  null;
	/*	Column Info	*/
	private  String	 ptyFaxNo   =  null;
	/*	Column Info	*/
	private  String	 edoAckCd   =  null;
	/*	Column Info	*/
	private  String	 ptyNm   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 ptyEml   =  null;
	/*	Column Info	*/
	private  String	 edoRqstNo   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 ptyCntcPsonNm   =  null;
	/*	Column Info	*/
	private  String	 seq   =  null;
	/*	Column Info	*/
	private  String	 actShprPhnNo   =  null;
	/*	Column Info	*/
	private  String	 ptyPhnNo   =  null;
	/*	Column Info	*/
	private  String	 actShprNm   =  null;
	/*	Column Info	*/
	private  String	 ptyBizNo   =  null;
	/*	Column Info	*/
	private  String	 depAreaNm   =  null;
	/*	Column Info	*/
	private  String	 arrAreaNm   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public SearchEdoCntrPtyTrspVO(){}

	public SearchEdoCntrPtyTrspVO(String edoCntrPtyTrspSeq,String ptyFaxNo,String edoAckCd,String ptyNm,String pagerows,String ibflag,String ptyEml,String edoRqstNo,String cntrNo,String ptyCntcPsonNm,String seq,String actShprPhnNo,String ptyPhnNo,String actShprNm,String ptyBizNo,String depAreaNm,String arrAreaNm)	{
		this.edoCntrPtyTrspSeq  = edoCntrPtyTrspSeq ;
		this.ptyFaxNo  = ptyFaxNo ;
		this.edoAckCd  = edoAckCd ;
		this.ptyNm  = ptyNm ;
		this.pagerows  = pagerows ;
		this.ibflag  = ibflag ;
		this.ptyEml  = ptyEml ;
		this.edoRqstNo  = edoRqstNo ;
		this.cntrNo  = cntrNo ;
		this.ptyCntcPsonNm  = ptyCntcPsonNm ;
		this.seq  = seq ;
		this.actShprPhnNo  = actShprPhnNo ;
		this.ptyPhnNo  = ptyPhnNo ;
		this.actShprNm  = actShprNm ;
		this.ptyBizNo  = ptyBizNo ;
		this.depAreaNm  = depAreaNm ;
		this.arrAreaNm  = arrAreaNm ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("edo_cntr_pty_trsp_seq", getEdoCntrPtyTrspSeq());		
		this.hashColumns.put("pty_fax_no", getPtyFaxNo());		
		this.hashColumns.put("edo_ack_cd", getEdoAckCd());		
		this.hashColumns.put("pty_nm", getPtyNm());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("pty_eml", getPtyEml());		
		this.hashColumns.put("edo_rqst_no", getEdoRqstNo());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("pty_cntc_pson_nm", getPtyCntcPsonNm());		
		this.hashColumns.put("seq", getSeq());		
		this.hashColumns.put("act_shpr_phn_no", getActShprPhnNo());		
		this.hashColumns.put("pty_phn_no", getPtyPhnNo());		
		this.hashColumns.put("act_shpr_nm", getActShprNm());		
		this.hashColumns.put("pty_biz_no", getPtyBizNo());		
		this.hashColumns.put("dep_area_nm", getDepAreaNm());		
		this.hashColumns.put("arr_area_nm", getArrAreaNm());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("edo_cntr_pty_trsp_seq", "edoCntrPtyTrspSeq");
		this.hashFields.put("pty_fax_no", "ptyFaxNo");
		this.hashFields.put("edo_ack_cd", "edoAckCd");
		this.hashFields.put("pty_nm", "ptyNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pty_eml", "ptyEml");
		this.hashFields.put("edo_rqst_no", "edoRqstNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pty_cntc_pson_nm", "ptyCntcPsonNm");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("act_shpr_phn_no", "actShprPhnNo");
		this.hashFields.put("pty_phn_no", "ptyPhnNo");
		this.hashFields.put("act_shpr_nm", "actShprNm");
		this.hashFields.put("pty_biz_no", "ptyBizNo");
		this.hashFields.put("dep_area_nm", "depAreaNm");
		this.hashFields.put("arr_area_nm", "arrAreaNm");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  edoCntrPtyTrspSeq
	*/
	public void	setEdoCntrPtyTrspSeq( String	edoCntrPtyTrspSeq ) {
		this.edoCntrPtyTrspSeq =	edoCntrPtyTrspSeq;
	}
 
	/**
	 * Column Info
	 * @return	edoCntrPtyTrspSeq
	 */
	 public	 String	getEdoCntrPtyTrspSeq() {
		 return	this.edoCntrPtyTrspSeq;
	 } 
 	/**
	* Column Info
	* @param  ptyFaxNo
	*/
	public void	setPtyFaxNo( String	ptyFaxNo ) {
		this.ptyFaxNo =	ptyFaxNo;
	}
 
	/**
	 * Column Info
	 * @return	ptyFaxNo
	 */
	 public	 String	getPtyFaxNo() {
		 return	this.ptyFaxNo;
	 } 
 	/**
	* Column Info
	* @param  edoAckCd
	*/
	public void	setEdoAckCd( String	edoAckCd ) {
		this.edoAckCd =	edoAckCd;
	}
 
	/**
	 * Column Info
	 * @return	edoAckCd
	 */
	 public	 String	getEdoAckCd() {
		 return	this.edoAckCd;
	 } 
 	/**
	* Column Info
	* @param  ptyNm
	*/
	public void	setPtyNm( String	ptyNm ) {
		this.ptyNm =	ptyNm;
	}
 
	/**
	 * Column Info
	 * @return	ptyNm
	 */
	 public	 String	getPtyNm() {
		 return	this.ptyNm;
	 } 
 	/**
	* Column Info
	* @param  pagerows
	*/
	public void	setPagerows( String	pagerows ) {
		this.pagerows =	pagerows;
	}
 
	/**
	 * Column Info
	 * @return	pagerows
	 */
	 public	 String	getPagerows() {
		 return	this.pagerows;
	 } 
 	/**
	* Column Info
	* @param  ibflag
	*/
	public void	setIbflag( String	ibflag ) {
		this.ibflag =	ibflag;
	}
 
	/**
	 * Column Info
	 * @return	ibflag
	 */
	 public	 String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  ptyEml
	*/
	public void	setPtyEml( String	ptyEml ) {
		this.ptyEml =	ptyEml;
	}
 
	/**
	 * Column Info
	 * @return	ptyEml
	 */
	 public	 String	getPtyEml() {
		 return	this.ptyEml;
	 } 
 	/**
	* Column Info
	* @param  edoRqstNo
	*/
	public void	setEdoRqstNo( String	edoRqstNo ) {
		this.edoRqstNo =	edoRqstNo;
	}
 
	/**
	 * Column Info
	 * @return	edoRqstNo
	 */
	 public	 String	getEdoRqstNo() {
		 return	this.edoRqstNo;
	 } 
 	/**
	* Column Info
	* @param  cntrNo
	*/
	public void	setCntrNo( String	cntrNo ) {
		this.cntrNo =	cntrNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrNo
	 */
	 public	 String	getCntrNo() {
		 return	this.cntrNo;
	 } 
 	/**
	* Column Info
	* @param  ptyCntcPsonNm
	*/
	public void	setPtyCntcPsonNm( String	ptyCntcPsonNm ) {
		this.ptyCntcPsonNm =	ptyCntcPsonNm;
	}
 
	/**
	 * Column Info
	 * @return	ptyCntcPsonNm
	 */
	 public	 String	getPtyCntcPsonNm() {
		 return	this.ptyCntcPsonNm;
	 } 
 	/**
	* Column Info
	* @param  seq
	*/
	public void	setSeq( String	seq ) {
		this.seq =	seq;
	}
 
	/**
	 * Column Info
	 * @return	seq
	 */
	 public	 String	getSeq() {
		 return	this.seq;
	 } 
 	/**
	* Column Info
	* @param  actShprPhnNo
	*/
	public void	setActShprPhnNo( String	actShprPhnNo ) {
		this.actShprPhnNo =	actShprPhnNo;
	}
 
	/**
	 * Column Info
	 * @return	actShprPhnNo
	 */
	 public	 String	getActShprPhnNo() {
		 return	this.actShprPhnNo;
	 } 
 	/**
	* Column Info
	* @param  ptyPhnNo
	*/
	public void	setPtyPhnNo( String	ptyPhnNo ) {
		this.ptyPhnNo =	ptyPhnNo;
	}
 
	/**
	 * Column Info
	 * @return	ptyPhnNo
	 */
	 public	 String	getPtyPhnNo() {
		 return	this.ptyPhnNo;
	 } 
 	/**
	* Column Info
	* @param  actShprNm
	*/
	public void	setActShprNm( String	actShprNm ) {
		this.actShprNm =	actShprNm;
	}
 
	/**
	 * Column Info
	 * @return	actShprNm
	 */
	 public	 String	getActShprNm() {
		 return	this.actShprNm;
	 } 
 	/**
	* Column Info
	* @param  ptyBizNo
	*/
	public void	setPtyBizNo( String	ptyBizNo ) {
		this.ptyBizNo =	ptyBizNo;
	}
 
	/**
	 * Column Info
	 * @return	ptyBizNo
	 */
	 public	 String	getPtyBizNo() {
		 return	this.ptyBizNo;
	 } 
 	/**
	* Column Info
	* @param  depAreaNm
	*/
	public void	setDepAreaNm( String	depAreaNm ) {
		this.depAreaNm =	depAreaNm;
	}
 
	/**
	 * Column Info
	 * @return	depAreaNm
	 */
	 public	 String	getDepAreaNm() {
		 return	this.depAreaNm;
	 } 
 	/**
	* Column Info
	* @param  arrAreaNm
	*/
	public void	setArrAreaNm( String	arrAreaNm ) {
		this.arrAreaNm =	arrAreaNm;
	}
 
	/**
	 * Column Info
	 * @return	arrAreaNm
	 */
	 public	 String	getArrAreaNm() {
		 return	this.arrAreaNm;
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
		setEdoCntrPtyTrspSeq(JSPUtil.getParameter(request,	prefix + "edo_cntr_pty_trsp_seq", ""));
		setPtyFaxNo(JSPUtil.getParameter(request,	prefix + "pty_fax_no", ""));
		setEdoAckCd(JSPUtil.getParameter(request,	prefix + "edo_ack_cd", ""));
		setPtyNm(JSPUtil.getParameter(request,	prefix + "pty_nm", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPtyEml(JSPUtil.getParameter(request,	prefix + "pty_eml", ""));
		setEdoRqstNo(JSPUtil.getParameter(request,	prefix + "edo_rqst_no", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setPtyCntcPsonNm(JSPUtil.getParameter(request,	prefix + "pty_cntc_pson_nm", ""));
		setSeq(JSPUtil.getParameter(request,	prefix + "seq", ""));
		setActShprPhnNo(JSPUtil.getParameter(request,	prefix + "act_shpr_phn_no", ""));
		setPtyPhnNo(JSPUtil.getParameter(request,	prefix + "pty_phn_no", ""));
		setActShprNm(JSPUtil.getParameter(request,	prefix + "act_shpr_nm", ""));
		setPtyBizNo(JSPUtil.getParameter(request,	prefix + "pty_biz_no", ""));
		setDepAreaNm(JSPUtil.getParameter(request,	prefix + "dep_area_nm", ""));
		setArrAreaNm(JSPUtil.getParameter(request,	prefix + "arr_area_nm", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEdoCntrPtyTrspVO[]
	 */
	public SearchEdoCntrPtyTrspVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchEdoCntrPtyTrspVO[]
	 */
	public SearchEdoCntrPtyTrspVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SearchEdoCntrPtyTrspVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] edoCntrPtyTrspSeq =	(JSPUtil.getParameter(request, prefix +	"edo_cntr_pty_trsp_seq".trim(),	length));
				String[] ptyFaxNo =	(JSPUtil.getParameter(request, prefix +	"pty_fax_no".trim(),	length));
				String[] edoAckCd =	(JSPUtil.getParameter(request, prefix +	"edo_ack_cd".trim(),	length));
				String[] ptyNm =	(JSPUtil.getParameter(request, prefix +	"pty_nm".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] ptyEml =	(JSPUtil.getParameter(request, prefix +	"pty_eml".trim(),	length));
				String[] edoRqstNo =	(JSPUtil.getParameter(request, prefix +	"edo_rqst_no".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] ptyCntcPsonNm =	(JSPUtil.getParameter(request, prefix +	"pty_cntc_pson_nm".trim(),	length));
				String[] seq =	(JSPUtil.getParameter(request, prefix +	"seq".trim(),	length));
				String[] actShprPhnNo =	(JSPUtil.getParameter(request, prefix +	"act_shpr_phn_no".trim(),	length));
				String[] ptyPhnNo =	(JSPUtil.getParameter(request, prefix +	"pty_phn_no".trim(),	length));
				String[] actShprNm =	(JSPUtil.getParameter(request, prefix +	"act_shpr_nm".trim(),	length));
				String[] ptyBizNo =	(JSPUtil.getParameter(request, prefix +	"pty_biz_no".trim(),	length));
				String[] depAreaNm =	(JSPUtil.getParameter(request, prefix +	"dep_area_nm".trim(),	length));
				String[] arrAreaNm =	(JSPUtil.getParameter(request, prefix +	"arr_area_nm".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	SearchEdoCntrPtyTrspVO();
						if ( edoCntrPtyTrspSeq[i] !=	null)
						model.setEdoCntrPtyTrspSeq( edoCntrPtyTrspSeq[i]);
						if ( ptyFaxNo[i] !=	null)
						model.setPtyFaxNo( ptyFaxNo[i]);
						if ( edoAckCd[i] !=	null)
						model.setEdoAckCd( edoAckCd[i]);
						if ( ptyNm[i] !=	null)
						model.setPtyNm( ptyNm[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( ptyEml[i] !=	null)
						model.setPtyEml( ptyEml[i]);
						if ( edoRqstNo[i] !=	null)
						model.setEdoRqstNo( edoRqstNo[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( ptyCntcPsonNm[i] !=	null)
						model.setPtyCntcPsonNm( ptyCntcPsonNm[i]);
						if ( seq[i] !=	null)
						model.setSeq( seq[i]);
						if ( actShprPhnNo[i] !=	null)
						model.setActShprPhnNo( actShprPhnNo[i]);
						if ( ptyPhnNo[i] !=	null)
						model.setPtyPhnNo( ptyPhnNo[i]);
						if ( actShprNm[i] !=	null)
						model.setActShprNm( actShprNm[i]);
						if ( ptyBizNo[i] !=	null)
						model.setPtyBizNo( ptyBizNo[i]);
						if ( depAreaNm[i] !=	null)
						model.setDepAreaNm( depAreaNm[i]);
						if ( arrAreaNm[i] !=	null)
						model.setArrAreaNm( arrAreaNm[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getSearchEdoCntrPtyTrspVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return SearchEdoCntrPtyTrspVO[]
	 */
	public SearchEdoCntrPtyTrspVO[]	 getSearchEdoCntrPtyTrspVOs(){
		SearchEdoCntrPtyTrspVO[] vos = (SearchEdoCntrPtyTrspVO[])models.toArray(new	SearchEdoCntrPtyTrspVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.edoCntrPtyTrspSeq =	this.edoCntrPtyTrspSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyFaxNo =	this.ptyFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoAckCd =	this.edoAckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyNm =	this.ptyNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyEml =	this.ptyEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRqstNo =	this.edoRqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyCntcPsonNm =	this.ptyCntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq =	this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprPhnNo =	this.actShprPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyPhnNo =	this.ptyPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprNm =	this.actShprNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyBizNo =	this.ptyBizNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depAreaNm =	this.depAreaNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrAreaNm =	this.arrAreaNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}