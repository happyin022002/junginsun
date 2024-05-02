/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CondSearchOwnerInvoiceVO.java
 *@FileTitle : CondSearchOwnerInvoiceVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.05.31
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.05.31  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 愿��젴	Event�뿉�꽌	�옉�꽦,	�꽌踰꾩떎�뻾�슂泥��떆	PDTO�쓽 �뿭�븷�쓣 �닔�뻾�븯�뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class CondSearchOwnerInvoiceVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<CondSearchOwnerInvoiceVO>  models =	new	ArrayList<CondSearchOwnerInvoiceVO>();


	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 sheetNo   =  null;
	/*	Column Info	*/
	private  String	 effDt1   =  null;
	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 stlFlg   =  null;
	/*	Column Info	*/
	private  String	 aproFlg   =  null;
	/*	Column Info	*/
	private  String	 locCd   =  null;
	/*	Column Info	*/
	private  String	 effDt2   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 rctFlg   =  null;
	/*	Column Info	*/
	private  String	 dtOpt   =  null;
	/*	Column Info	*/
	private  String	 ldgrDt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public CondSearchOwnerInvoiceVO(){}

	public CondSearchOwnerInvoiceVO(String ibflag,String sheetNo,String effDt1,String vslCd,String stlFlg,String aproFlg,String locCd,String effDt2,String pagerows,String rctFlg,String dtOpt,String ldgrDt)	{
		this.ibflag  = ibflag ;
		this.sheetNo  = sheetNo ;
		this.effDt1  = effDt1 ;
		this.vslCd  = vslCd ;
		this.stlFlg  = stlFlg ;
		this.aproFlg  = aproFlg ;
		this.locCd  = locCd ;
		this.effDt2  = effDt2 ;
		this.pagerows  = pagerows ;
		this.rctFlg  = rctFlg ;
		this.dtOpt  = dtOpt ;
		this.ldgrDt  = ldgrDt ;
	}


	/**
	 * �뀒�씠釉� 而щ읆�뿉 ���옣�븷 媛믪쓣 Hashtable<"column_name", "value">	濡� 諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("sheet_no", getSheetNo());		
		this.hashColumns.put("eff_dt1", getEffDt1());		
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("stl_flg", getStlFlg());		
		this.hashColumns.put("apro_flg", getAproFlg());		
		this.hashColumns.put("loc_cd", getLocCd());		
		this.hashColumns.put("eff_dt2", getEffDt2());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("rct_flg", getRctFlg());		
		this.hashColumns.put("dt_opt", getDtOpt());		
		this.hashColumns.put("ldgr_dt", getLdgrDt());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	���쓳�릺�뒗 硫ㅻ쾭蹂��닔紐낆쓣	���옣�븯�뿬 Hashtable<"column_name", "variable"> 濡� 諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sheet_no", "sheetNo");
		this.hashFields.put("eff_dt1", "effDt1");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("stl_flg", "stlFlg");
		this.hashFields.put("apro_flg", "aproFlg");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("eff_dt2", "effDt2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rct_flg", "rctFlg");
		this.hashFields.put("dt_opt", "dtOpt");
		this.hashFields.put("ldgr_dt", "ldgrDt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  sheetNo
	*/
	public void	setSheetNo( String	sheetNo ) {
		this.sheetNo =	sheetNo;
	}
 
	/**
	 * Column Info
	 * @return	sheetNo
	 */
	 public	 String	getSheetNo() {
		 return	this.sheetNo;
	 } 
 	/**
	* Column Info
	* @param  effDt1
	*/
	public void	setEffDt1( String	effDt1 ) {
		this.effDt1 =	effDt1;
	}
 
	/**
	 * Column Info
	 * @return	effDt1
	 */
	 public	 String	getEffDt1() {
		 return	this.effDt1;
	 } 
 	/**
	* Column Info
	* @param  vslCd
	*/
	public void	setVslCd( String	vslCd ) {
		this.vslCd =	vslCd;
	}
 
	/**
	 * Column Info
	 * @return	vslCd
	 */
	 public	 String	getVslCd() {
		 return	this.vslCd;
	 } 
 	/**
	* Column Info
	* @param  stlFlg
	*/
	public void	setStlFlg( String	stlFlg ) {
		this.stlFlg =	stlFlg;
	}
 
	/**
	 * Column Info
	 * @return	stlFlg
	 */
	 public	 String	getStlFlg() {
		 return	this.stlFlg;
	 } 
 	/**
	* Column Info
	* @param  aproFlg
	*/
	public void	setAproFlg( String	aproFlg ) {
		this.aproFlg =	aproFlg;
	}
 
	/**
	 * Column Info
	 * @return	aproFlg
	 */
	 public	 String	getAproFlg() {
		 return	this.aproFlg;
	 } 
 	/**
	* Column Info
	* @param  locCd
	*/
	public void	setLocCd( String	locCd ) {
		this.locCd =	locCd;
	}
 
	/**
	 * Column Info
	 * @return	locCd
	 */
	 public	 String	getLocCd() {
		 return	this.locCd;
	 } 
 	/**
	* Column Info
	* @param  effDt2
	*/
	public void	setEffDt2( String	effDt2 ) {
		this.effDt2 =	effDt2;
	}
 
	/**
	 * Column Info
	 * @return	effDt2
	 */
	 public	 String	getEffDt2() {
		 return	this.effDt2;
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
	* @param  rctFlg
	*/
	public void	setRctFlg( String	rctFlg ) {
		this.rctFlg =	rctFlg;
	}
 
	/**
	 * Column Info
	 * @return	rctFlg
	 */
	 public	 String	getRctFlg() {
		 return	this.rctFlg;
	 } 
 	/**
	* Column Info
	* @param  dtOpt
	*/
	public void	setDtOpt( String	dtOpt ) {
		this.dtOpt =	dtOpt;
	}
 
	/**
	 * Column Info
	 * @return	dtOpt
	 */
	 public	 String	getDtOpt() {
		 return	this.dtOpt;
	 } 
 	/**
	* Column Info
	* @param  ldgrDt
	*/
	public void	setLdgrDt( String	ldgrDt ) {
		this.ldgrDt =	ldgrDt;
	}
 
	/**
	 * Column Info
	 * @return	ldgrDt
	 */
	 public	 String	getLdgrDt() {
		 return	this.ldgrDt;
	 } 

	/**
	 * Request �쓽 �뜲�씠�꽣瑜� 異붿텧�븯�뿬 VO �쓽	硫ㅻ쾭蹂��닔�뿉 �꽕�젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request �쓽 �뜲�씠�꽣瑜� 異붿텧�븯�뿬 VO �쓽	硫ㅻ쾭蹂��닔�뿉 �꽕�젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setSheetNo(JSPUtil.getParameter(request,	prefix + "sheet_no", ""));
		setEffDt1(JSPUtil.getParameter(request,	prefix + "eff_dt1", ""));
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setStlFlg(JSPUtil.getParameter(request,	prefix + "stl_flg", ""));
		setAproFlg(JSPUtil.getParameter(request,	prefix + "apro_flg", ""));
		setLocCd(JSPUtil.getParameter(request,	prefix + "loc_cd", ""));
		setEffDt2(JSPUtil.getParameter(request,	prefix + "eff_dt2", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setRctFlg(JSPUtil.getParameter(request,	prefix + "rct_flg", ""));
		setDtOpt(JSPUtil.getParameter(request,	prefix + "dt_opt", ""));
		setLdgrDt(JSPUtil.getParameter(request,	prefix + "ldgr_dt", ""));
	}
	
	/**
	 * Request �쓽 �뜲�씠�꽣瑜� VO 諛곗뿴濡� 蹂��솚�븯�뿬 諛섑솚.
	 * @param request
	 * @return CondSearchOwnerInvoiceVO[]
	 */
	public CondSearchOwnerInvoiceVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �꽆�뼱�삩 �뿬�윭 嫄�	DATA瑜� VO Class �뿉 �떞�뒗�떎.
	 * @param request
	 * @param prefix
	 * @return CondSearchOwnerInvoiceVO[]
	 */
	public CondSearchOwnerInvoiceVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		CondSearchOwnerInvoiceVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] sheetNo =	(JSPUtil.getParameter(request, prefix +	"sheet_no".trim(),	length));
				String[] effDt1 =	(JSPUtil.getParameter(request, prefix +	"eff_dt1".trim(),	length));
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] stlFlg =	(JSPUtil.getParameter(request, prefix +	"stl_flg".trim(),	length));
				String[] aproFlg =	(JSPUtil.getParameter(request, prefix +	"apro_flg".trim(),	length));
				String[] locCd =	(JSPUtil.getParameter(request, prefix +	"loc_cd".trim(),	length));
				String[] effDt2 =	(JSPUtil.getParameter(request, prefix +	"eff_dt2".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] rctFlg =	(JSPUtil.getParameter(request, prefix +	"rct_flg".trim(),	length));
				String[] dtOpt =	(JSPUtil.getParameter(request, prefix +	"dt_opt".trim(),	length));
				String[] ldgrDt =	(JSPUtil.getParameter(request, prefix +	"ldgr_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	CondSearchOwnerInvoiceVO();
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( sheetNo[i] !=	null)
						model.setSheetNo( sheetNo[i]);
						if ( effDt1[i] !=	null)
						model.setEffDt1( effDt1[i]);
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( stlFlg[i] !=	null)
						model.setStlFlg( stlFlg[i]);
						if ( aproFlg[i] !=	null)
						model.setAproFlg( aproFlg[i]);
						if ( locCd[i] !=	null)
						model.setLocCd( locCd[i]);
						if ( effDt2[i] !=	null)
						model.setEffDt2( effDt2[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( rctFlg[i] !=	null)
						model.setRctFlg( rctFlg[i]);
						if ( dtOpt[i] !=	null)
						model.setDtOpt( dtOpt[i]);
						if ( ldgrDt[i] !=	null)
						model.setLdgrDt( ldgrDt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getCondSearchOwnerInvoiceVOs();
	}

	/**
	 *  VO 諛곗뿴�쓣 諛섑솚
	 * @return CondSearchOwnerInvoiceVO[]
	 */
	public CondSearchOwnerInvoiceVO[]	 getCondSearchOwnerInvoiceVOs(){
		CondSearchOwnerInvoiceVO[] vos = (CondSearchOwnerInvoiceVO[])models.toArray(new	CondSearchOwnerInvoiceVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class�쓽 �궡�슜�쓣 String�쑝濡� 蹂��솚
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* �룷留룻똿�맂 臾몄옄�뿴�뿉�꽌 �듅�닔臾몄옄 �젣嫄�("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetNo =	this.sheetNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt1 =	this.effDt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlFlg =	this.stlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFlg =	this.aproFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd =	this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt2 =	this.effDt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctFlg =	this.rctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtOpt =	this.dtOpt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldgrDt =	this.ldgrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}