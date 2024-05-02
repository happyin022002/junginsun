/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SearchMdmHistoryListVO.java
 *@FileTitle : SearchMdmHistoryListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.18
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.12.18  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.vo;
 
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
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class SearchMdmHistoryListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SearchMdmHistoryListVO>  models =	new	ArrayList<SearchMdmHistoryListVO>();


	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 cngSeq   =  null;
	/*	Column Info	*/
	private  String	 n1stKeyColNm   =  null;
	/*	Column Info	*/
	private  String	 colNm   =  null;
	/*	Column Info	*/
	private  String	 n5thKeyColNm   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 n3rdKeyColNm   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 n4thKeyColNm   =  null;
	/*	Column Info	*/
	private  String	 tblNm   =  null;
	/*	Column Info	*/
	private  String	 aftCtnt   =  null;
	/*	Column Info	*/
	private  String	 preCtnt   =  null;
	/*	Column Info	*/
	private  String	 cngDt   =  null;
	/*	Column Info	*/
	private  String	 n2ndKeyColNm   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 fmRqstDt   =  null;
	/*	Column Info	*/
	private  String	 toRqstDt   =  null;
	/* Column Info */
	private int iPage = 1;
	
	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public SearchMdmHistoryListVO(){}

	public SearchMdmHistoryListVO(String updDt,String cngSeq,String n1stKeyColNm,String colNm,String n5thKeyColNm,String creDt,String pagerows,String n3rdKeyColNm,String creUsrId,String ibflag,String n4thKeyColNm,String tblNm,String aftCtnt,String preCtnt,String cngDt,String n2ndKeyColNm,String updUsrId,String fmRqstDt,String toRqstDt)	{
		this.updDt  = updDt ;
		this.cngSeq  = cngSeq ;
		this.n1stKeyColNm  = n1stKeyColNm ;
		this.colNm  = colNm ;
		this.n5thKeyColNm  = n5thKeyColNm ;
		this.creDt  = creDt ;
		this.pagerows  = pagerows ;
		this.n3rdKeyColNm  = n3rdKeyColNm ;
		this.creUsrId  = creUsrId ;
		this.ibflag  = ibflag ;
		this.n4thKeyColNm  = n4thKeyColNm ;
		this.tblNm  = tblNm ;
		this.aftCtnt  = aftCtnt ;
		this.preCtnt  = preCtnt ;
		this.cngDt  = cngDt ;
		this.n2ndKeyColNm  = n2ndKeyColNm ;
		this.updUsrId  = updUsrId ;
		this.fmRqstDt  = fmRqstDt ;
		this.toRqstDt  = toRqstDt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("cng_seq", getCngSeq());		
		this.hashColumns.put("n1st_key_col_nm", getN1stKeyColNm());		
		this.hashColumns.put("col_nm", getColNm());		
		this.hashColumns.put("n5th_key_col_nm", getN5thKeyColNm());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("n3rd_key_col_nm", getN3rdKeyColNm());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("n4th_key_col_nm", getN4thKeyColNm());		
		this.hashColumns.put("tbl_nm", getTblNm());		
		this.hashColumns.put("aft_ctnt", getAftCtnt());		
		this.hashColumns.put("pre_ctnt", getPreCtnt());		
		this.hashColumns.put("cng_dt", getCngDt());		
		this.hashColumns.put("n2nd_key_col_nm", getN2ndKeyColNm());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("fm_rqst_dt", getFmRqstDt());		
		this.hashColumns.put("to_rqst_dt", getToRqstDt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cng_seq", "cngSeq");
		this.hashFields.put("n1st_key_col_nm", "n1stKeyColNm");
		this.hashFields.put("col_nm", "colNm");
		this.hashFields.put("n5th_key_col_nm", "n5thKeyColNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3rd_key_col_nm", "n3rdKeyColNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n4th_key_col_nm", "n4thKeyColNm");
		this.hashFields.put("tbl_nm", "tblNm");
		this.hashFields.put("aft_ctnt", "aftCtnt");
		this.hashFields.put("pre_ctnt", "preCtnt");
		this.hashFields.put("cng_dt", "cngDt");
		this.hashFields.put("n2nd_key_col_nm", "n2ndKeyColNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("fm_rqst_dt", "fmRqstDt");
		this.hashFields.put("to_rqst_dt", "toRqstDt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  updDt
	*/
	public void	setUpdDt( String	updDt ) {
		this.updDt =	updDt;
	}
 
	/**
	 * Column Info
	 * @return	updDt
	 */
	 public	 String	getUpdDt() {
		 return	this.updDt;
	 } 
 	/**
	* Column Info
	* @param  cngSeq
	*/
	public void	setCngSeq( String	cngSeq ) {
		this.cngSeq =	cngSeq;
	}
 
	/**
	 * Column Info
	 * @return	cngSeq
	 */
	 public	 String	getCngSeq() {
		 return	this.cngSeq;
	 } 
 	/**
	* Column Info
	* @param  n1stKeyColNm
	*/
	public void	setN1stKeyColNm( String	n1stKeyColNm ) {
		this.n1stKeyColNm =	n1stKeyColNm;
	}
 
	/**
	 * Column Info
	 * @return	n1stKeyColNm
	 */
	 public	 String	getN1stKeyColNm() {
		 return	this.n1stKeyColNm;
	 } 
 	/**
	* Column Info
	* @param  colNm
	*/
	public void	setColNm( String	colNm ) {
		this.colNm =	colNm;
	}
 
	/**
	 * Column Info
	 * @return	colNm
	 */
	 public	 String	getColNm() {
		 return	this.colNm;
	 } 
 	/**
	* Column Info
	* @param  n5thKeyColNm
	*/
	public void	setN5thKeyColNm( String	n5thKeyColNm ) {
		this.n5thKeyColNm =	n5thKeyColNm;
	}
 
	/**
	 * Column Info
	 * @return	n5thKeyColNm
	 */
	 public	 String	getN5thKeyColNm() {
		 return	this.n5thKeyColNm;
	 } 
 	/**
	* Column Info
	* @param  creDt
	*/
	public void	setCreDt( String	creDt ) {
		this.creDt =	creDt;
	}
 
	/**
	 * Column Info
	 * @return	creDt
	 */
	 public	 String	getCreDt() {
		 return	this.creDt;
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
	* @param  n3rdKeyColNm
	*/
	public void	setN3rdKeyColNm( String	n3rdKeyColNm ) {
		this.n3rdKeyColNm =	n3rdKeyColNm;
	}
 
	/**
	 * Column Info
	 * @return	n3rdKeyColNm
	 */
	 public	 String	getN3rdKeyColNm() {
		 return	this.n3rdKeyColNm;
	 } 
 	/**
	* Column Info
	* @param  creUsrId
	*/
	public void	setCreUsrId( String	creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 
	/**
	 * Column Info
	 * @return	creUsrId
	 */
	 public	 String	getCreUsrId() {
		 return	this.creUsrId;
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
	* @param  n4thKeyColNm
	*/
	public void	setN4thKeyColNm( String	n4thKeyColNm ) {
		this.n4thKeyColNm =	n4thKeyColNm;
	}
 
	/**
	 * Column Info
	 * @return	n4thKeyColNm
	 */
	 public	 String	getN4thKeyColNm() {
		 return	this.n4thKeyColNm;
	 } 
 	/**
	* Column Info
	* @param  tblNm
	*/
	public void	setTblNm( String	tblNm ) {
		this.tblNm =	tblNm;
	}
 
	/**
	 * Column Info
	 * @return	tblNm
	 */
	 public	 String	getTblNm() {
		 return	this.tblNm;
	 } 
 	/**
	* Column Info
	* @param  aftCtnt
	*/
	public void	setAftCtnt( String	aftCtnt ) {
		this.aftCtnt =	aftCtnt;
	}
 
	/**
	 * Column Info
	 * @return	aftCtnt
	 */
	 public	 String	getAftCtnt() {
		 return	this.aftCtnt;
	 } 
 	/**
	* Column Info
	* @param  preCtnt
	*/
	public void	setPreCtnt( String	preCtnt ) {
		this.preCtnt =	preCtnt;
	}
 
	/**
	 * Column Info
	 * @return	preCtnt
	 */
	 public	 String	getPreCtnt() {
		 return	this.preCtnt;
	 } 
 	/**
	* Column Info
	* @param  cngDt
	*/
	public void	setCngDt( String	cngDt ) {
		this.cngDt =	cngDt;
	}
 
	/**
	 * Column Info
	 * @return	cngDt
	 */
	 public	 String	getCngDt() {
		 return	this.cngDt;
	 } 
 	/**
	* Column Info
	* @param  n2ndKeyColNm
	*/
	public void	setN2ndKeyColNm( String	n2ndKeyColNm ) {
		this.n2ndKeyColNm =	n2ndKeyColNm;
	}
 
	/**
	 * Column Info
	 * @return	n2ndKeyColNm
	 */
	 public	 String	getN2ndKeyColNm() {
		 return	this.n2ndKeyColNm;
	 } 
 	/**
	* Column Info
	* @param  updUsrId
	*/
	public void	setUpdUsrId( String	updUsrId ) {
		this.updUsrId =	updUsrId;
	}
 
	/**
	 * Column Info
	 * @return	updUsrId
	 */
	 public	 String	getUpdUsrId() {
		 return	this.updUsrId;
	 } 
 	/**
	* Column Info
	* @param  fmRqstDt
	*/
	public void	setFmRqstDt( String	fmRqstDt ) {
		this.fmRqstDt =	fmRqstDt;
	}
 
	/**
	 * Column Info
	 * @return	fmRqstDt
	 */
	 public	 String	getFmRqstDt() {
		 return	this.fmRqstDt;
	 } 
 	/**
	* Column Info
	* @param  toRqstDt
	*/
	public void	setToRqstDt( String	toRqstDt ) {
		this.toRqstDt =	toRqstDt;
	}
 
	/**
	 * Column Info
	 * @return	toRqstDt
	 */
	 public	 String	getToRqstDt() {
		 return	this.toRqstDt;
	 } 

	public int getIPage() {
		return iPage;
	}

	public void setIPage(int iPage) {
		this.iPage = iPage;
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
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setCngSeq(JSPUtil.getParameter(request,	prefix + "cng_seq", ""));
		setN1stKeyColNm(JSPUtil.getParameter(request,	prefix + "n1st_key_col_nm", ""));
		setColNm(JSPUtil.getParameter(request,	prefix + "col_nm", ""));
		setN5thKeyColNm(JSPUtil.getParameter(request,	prefix + "n5th_key_col_nm", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setN3rdKeyColNm(JSPUtil.getParameter(request,	prefix + "n3rd_key_col_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setN4thKeyColNm(JSPUtil.getParameter(request,	prefix + "n4th_key_col_nm", ""));
		setTblNm(JSPUtil.getParameter(request,	prefix + "tbl_nm", ""));
		setAftCtnt(JSPUtil.getParameter(request,	prefix + "aft_ctnt", ""));
		setPreCtnt(JSPUtil.getParameter(request,	prefix + "pre_ctnt", ""));
		setCngDt(JSPUtil.getParameter(request,	prefix + "cng_dt", ""));
		setN2ndKeyColNm(JSPUtil.getParameter(request,	prefix + "n2nd_key_col_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setFmRqstDt(JSPUtil.getParameter(request,	prefix + "fm_rqst_dt", ""));
		setToRqstDt(JSPUtil.getParameter(request,	prefix + "to_rqst_dt", ""));
		setIPage(JSPUtil.getParameterAsInt(request, prefix + "iPage", 1));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMdmHistoryListVO[]
	 */
	public SearchMdmHistoryListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchMdmHistoryListVO[]
	 */
	public SearchMdmHistoryListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SearchMdmHistoryListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] cngSeq =	(JSPUtil.getParameter(request, prefix +	"cng_seq".trim(),	length));
				String[] n1stKeyColNm =	(JSPUtil.getParameter(request, prefix +	"n1st_key_col_nm".trim(),	length));
				String[] colNm =	(JSPUtil.getParameter(request, prefix +	"col_nm".trim(),	length));
				String[] n5thKeyColNm =	(JSPUtil.getParameter(request, prefix +	"n5th_key_col_nm".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] n3rdKeyColNm =	(JSPUtil.getParameter(request, prefix +	"n3rd_key_col_nm".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] n4thKeyColNm =	(JSPUtil.getParameter(request, prefix +	"n4th_key_col_nm".trim(),	length));
				String[] tblNm =	(JSPUtil.getParameter(request, prefix +	"tbl_nm".trim(),	length));
				String[] aftCtnt =	(JSPUtil.getParameter(request, prefix +	"aft_ctnt".trim(),	length));
				String[] preCtnt =	(JSPUtil.getParameter(request, prefix +	"pre_ctnt".trim(),	length));
				String[] cngDt =	(JSPUtil.getParameter(request, prefix +	"cng_dt".trim(),	length));
				String[] n2ndKeyColNm =	(JSPUtil.getParameter(request, prefix +	"n2nd_key_col_nm".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] fmRqstDt =	(JSPUtil.getParameter(request, prefix +	"fm_rqst_dt".trim(),	length));
				String[] toRqstDt =	(JSPUtil.getParameter(request, prefix +	"to_rqst_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	SearchMdmHistoryListVO();
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( cngSeq[i] !=	null)
						model.setCngSeq( cngSeq[i]);
						if ( n1stKeyColNm[i] !=	null)
						model.setN1stKeyColNm( n1stKeyColNm[i]);
						if ( colNm[i] !=	null)
						model.setColNm( colNm[i]);
						if ( n5thKeyColNm[i] !=	null)
						model.setN5thKeyColNm( n5thKeyColNm[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( n3rdKeyColNm[i] !=	null)
						model.setN3rdKeyColNm( n3rdKeyColNm[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( n4thKeyColNm[i] !=	null)
						model.setN4thKeyColNm( n4thKeyColNm[i]);
						if ( tblNm[i] !=	null)
						model.setTblNm( tblNm[i]);
						if ( aftCtnt[i] !=	null)
						model.setAftCtnt( aftCtnt[i]);
						if ( preCtnt[i] !=	null)
						model.setPreCtnt( preCtnt[i]);
						if ( cngDt[i] !=	null)
						model.setCngDt( cngDt[i]);
						if ( n2ndKeyColNm[i] !=	null)
						model.setN2ndKeyColNm( n2ndKeyColNm[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( fmRqstDt[i] !=	null)
						model.setFmRqstDt( fmRqstDt[i]);
						if ( toRqstDt[i] !=	null)
						model.setToRqstDt( toRqstDt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getSearchMdmHistoryListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return SearchMdmHistoryListVO[]
	 */
	public SearchMdmHistoryListVO[]	 getSearchMdmHistoryListVOs(){
		SearchMdmHistoryListVO[] vos = (SearchMdmHistoryListVO[])models.toArray(new	SearchMdmHistoryListVO[models.size()]);
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
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngSeq =	this.cngSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stKeyColNm =	this.n1stKeyColNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colNm =	this.colNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thKeyColNm =	this.n5thKeyColNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdKeyColNm =	this.n3rdKeyColNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thKeyColNm =	this.n4thKeyColNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tblNm =	this.tblNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftCtnt =	this.aftCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt =	this.preCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngDt =	this.cngDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndKeyColNm =	this.n2ndKeyColNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstDt =	this.fmRqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstDt =	this.toRqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}