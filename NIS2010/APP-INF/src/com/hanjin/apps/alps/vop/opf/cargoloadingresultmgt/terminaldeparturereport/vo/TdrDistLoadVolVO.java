/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : TdrDistLoadVolVO.java
 *@FileTitle : TdrDistLoadVolVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2018.02.20
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2018.02.20  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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
 * - 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class TdrDistLoadVolVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<TdrDistLoadVolVO>  models =	new	ArrayList<TdrDistLoadVolVO>();


	/*	Column Info	*/
	private  String	 fullBo20   =  null;
	/*	Column Info	*/
	private  String	 fullBo4h   =  null;
	/*	Column Info	*/
	private  String	 fullBo2h   =  null;
	/*	Column Info	*/
	private  String	 fullBo45   =  null;
	/*	Column Info	*/
	private  String	 fullBo40   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 etTs45   =  null;
	/*	Column Info	*/
	private  String	 fullTs40   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 wt40   =  null;
	/*	Column Info	*/
	private  String	 fullTs20   =  null;
	/*	Column Info	*/
	private  String	 wt45   =  null;
	/*	Column Info	*/
	private  String	 fullTs4h   =  null;
	/*	Column Info	*/
	private  String	 fullTs45   =  null;
	/*	Column Info	*/
	private  String	 etTs40   =  null;
	/*	Column Info	*/
	private  String	 wt2h   =  null;
	/*	Column Info	*/
	private  String	 etTs4h   =  null;
	/*	Column Info	*/
	private  String	 etTs2h   =  null;
	/*	Column Info	*/
	private  String	 etTs20   =  null;
	/*	Column Info	*/
	private  String	 wt4h   =  null;
	/*	Column Info	*/
	private  String	 fullTs2h   =  null;
	/*	Column Info	*/
	private  String	 etBo2h   =  null;
	/*	Column Info	*/
	private  String	 etBo40   =  null;
	/*	Column Info	*/
	private  String	 wt20   =  null;
	/*	Column Info	*/
	private  String	 etBo45   =  null;
	/*	Column Info	*/
	private  String	 etBo20   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 oprCd   =  null;
	/*	Column Info	*/
	private  String	 idxSheet   =  null;
	/*	Column Info	*/
	private  String	 etBo4h   =  null;
	/*	Column Info	*/
	private  String	 fullBoDx   =  null;
	/*	Column Info	*/
	private  String	 fullTsDx   =  null;
	/*	Column Info	*/
	private  String	 etBoDx   =  null;
	/*	Column Info	*/
	private  String	 etTsDx   =  null;
	/*	Column Info	*/
	private  String	 wtDx   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public TdrDistLoadVolVO(){}

	public TdrDistLoadVolVO(String fullBo20,String fullBo4h,String fullBo2h,String fullBo45,String fullBo40,String pagerows,String etTs45,String fullTs40,String ibflag,String wt40,String fullTs20,String wt45,String fullTs4h,String fullTs45,String etTs40,String wt2h,String etTs4h,String etTs2h,String etTs20,String wt4h,String fullTs2h,String etBo2h,String etBo40,String wt20,String etBo45,String etBo20,String podCd,String oprCd,String idxSheet,String etBo4h,String fullBoDx,String fullTsDx,String etBoDx,String etTsDx,String wtDx)	{
		this.fullBo20  = fullBo20 ;
		this.fullBo4h  = fullBo4h ;
		this.fullBo2h  = fullBo2h ;
		this.fullBo45  = fullBo45 ;
		this.fullBo40  = fullBo40 ;
		this.pagerows  = pagerows ;
		this.etTs45  = etTs45 ;
		this.fullTs40  = fullTs40 ;
		this.ibflag  = ibflag ;
		this.wt40  = wt40 ;
		this.fullTs20  = fullTs20 ;
		this.wt45  = wt45 ;
		this.fullTs4h  = fullTs4h ;
		this.fullTs45  = fullTs45 ;
		this.etTs40  = etTs40 ;
		this.wt2h  = wt2h ;
		this.etTs4h  = etTs4h ;
		this.etTs2h  = etTs2h ;
		this.etTs20  = etTs20 ;
		this.wt4h  = wt4h ;
		this.fullTs2h  = fullTs2h ;
		this.etBo2h  = etBo2h ;
		this.etBo40  = etBo40 ;
		this.wt20  = wt20 ;
		this.etBo45  = etBo45 ;
		this.etBo20  = etBo20 ;
		this.podCd  = podCd ;
		this.oprCd  = oprCd ;
		this.idxSheet  = idxSheet ;
		this.etBo4h  = etBo4h ;
		this.fullBoDx  = fullBoDx ;
		this.fullTsDx  = fullTsDx ;
		this.etBoDx  = etBoDx ;
		this.etTsDx  = etTsDx ;
		this.wtDx  = wtDx ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("full_bo_20", getFullBo20());		
		this.hashColumns.put("full_bo_4h", getFullBo4h());		
		this.hashColumns.put("full_bo_2h", getFullBo2h());		
		this.hashColumns.put("full_bo_45", getFullBo45());		
		this.hashColumns.put("full_bo_40", getFullBo40());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("et_ts_45", getEtTs45());		
		this.hashColumns.put("full_ts_40", getFullTs40());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("wt_40", getWt40());		
		this.hashColumns.put("full_ts_20", getFullTs20());		
		this.hashColumns.put("wt_45", getWt45());		
		this.hashColumns.put("full_ts_4h", getFullTs4h());		
		this.hashColumns.put("full_ts_45", getFullTs45());		
		this.hashColumns.put("et_ts_40", getEtTs40());		
		this.hashColumns.put("wt_2h", getWt2h());		
		this.hashColumns.put("et_ts_4h", getEtTs4h());		
		this.hashColumns.put("et_ts_2h", getEtTs2h());		
		this.hashColumns.put("et_ts_20", getEtTs20());		
		this.hashColumns.put("wt_4h", getWt4h());		
		this.hashColumns.put("full_ts_2h", getFullTs2h());		
		this.hashColumns.put("et_bo_2h", getEtBo2h());		
		this.hashColumns.put("et_bo_40", getEtBo40());		
		this.hashColumns.put("wt_20", getWt20());		
		this.hashColumns.put("et_bo_45", getEtBo45());		
		this.hashColumns.put("et_bo_20", getEtBo20());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("opr_cd", getOprCd());		
		this.hashColumns.put("idx_sheet", getIdxSheet());		
		this.hashColumns.put("et_bo_4h", getEtBo4h());		
		this.hashColumns.put("full_bo_dx", getFullBoDx());		
		this.hashColumns.put("full_ts_dx", getFullTsDx());		
		this.hashColumns.put("et_bo_dx", getEtBoDx());		
		this.hashColumns.put("et_ts_dx", getEtTsDx());		
		this.hashColumns.put("wt_dx", getWtDx());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("full_bo_20", "fullBo20");
		this.hashFields.put("full_bo_4h", "fullBo4h");
		this.hashFields.put("full_bo_2h", "fullBo2h");
		this.hashFields.put("full_bo_45", "fullBo45");
		this.hashFields.put("full_bo_40", "fullBo40");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("et_ts_45", "etTs45");
		this.hashFields.put("full_ts_40", "fullTs40");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wt_40", "wt40");
		this.hashFields.put("full_ts_20", "fullTs20");
		this.hashFields.put("wt_45", "wt45");
		this.hashFields.put("full_ts_4h", "fullTs4h");
		this.hashFields.put("full_ts_45", "fullTs45");
		this.hashFields.put("et_ts_40", "etTs40");
		this.hashFields.put("wt_2h", "wt2h");
		this.hashFields.put("et_ts_4h", "etTs4h");
		this.hashFields.put("et_ts_2h", "etTs2h");
		this.hashFields.put("et_ts_20", "etTs20");
		this.hashFields.put("wt_4h", "wt4h");
		this.hashFields.put("full_ts_2h", "fullTs2h");
		this.hashFields.put("et_bo_2h", "etBo2h");
		this.hashFields.put("et_bo_40", "etBo40");
		this.hashFields.put("wt_20", "wt20");
		this.hashFields.put("et_bo_45", "etBo45");
		this.hashFields.put("et_bo_20", "etBo20");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("idx_sheet", "idxSheet");
		this.hashFields.put("et_bo_4h", "etBo4h");
		this.hashFields.put("full_bo_dx", "fullBoDx");
		this.hashFields.put("full_ts_dx", "fullTsDx");
		this.hashFields.put("et_bo_dx", "etBoDx");
		this.hashFields.put("et_ts_dx", "etTsDx");
		this.hashFields.put("wt_dx", "wtDx");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  fullBo20
	*/
	public void	setFullBo20( String	fullBo20 ) {
		this.fullBo20 =	fullBo20;
	}
 
	/**
	 * Column Info
	 * @return	fullBo20
	 */
	 public	 String	getFullBo20() {
		 return	this.fullBo20;
	 } 
 	/**
	* Column Info
	* @param  fullBo4h
	*/
	public void	setFullBo4h( String	fullBo4h ) {
		this.fullBo4h =	fullBo4h;
	}
 
	/**
	 * Column Info
	 * @return	fullBo4h
	 */
	 public	 String	getFullBo4h() {
		 return	this.fullBo4h;
	 } 
 	/**
	* Column Info
	* @param  fullBo2h
	*/
	public void	setFullBo2h( String	fullBo2h ) {
		this.fullBo2h =	fullBo2h;
	}
 
	/**
	 * Column Info
	 * @return	fullBo2h
	 */
	 public	 String	getFullBo2h() {
		 return	this.fullBo2h;
	 } 
 	/**
	* Column Info
	* @param  fullBo45
	*/
	public void	setFullBo45( String	fullBo45 ) {
		this.fullBo45 =	fullBo45;
	}
 
	/**
	 * Column Info
	 * @return	fullBo45
	 */
	 public	 String	getFullBo45() {
		 return	this.fullBo45;
	 } 
 	/**
	* Column Info
	* @param  fullBo40
	*/
	public void	setFullBo40( String	fullBo40 ) {
		this.fullBo40 =	fullBo40;
	}
 
	/**
	 * Column Info
	 * @return	fullBo40
	 */
	 public	 String	getFullBo40() {
		 return	this.fullBo40;
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
	* @param  etTs45
	*/
	public void	setEtTs45( String	etTs45 ) {
		this.etTs45 =	etTs45;
	}
 
	/**
	 * Column Info
	 * @return	etTs45
	 */
	 public	 String	getEtTs45() {
		 return	this.etTs45;
	 } 
 	/**
	* Column Info
	* @param  fullTs40
	*/
	public void	setFullTs40( String	fullTs40 ) {
		this.fullTs40 =	fullTs40;
	}
 
	/**
	 * Column Info
	 * @return	fullTs40
	 */
	 public	 String	getFullTs40() {
		 return	this.fullTs40;
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
	* @param  wt40
	*/
	public void	setWt40( String	wt40 ) {
		this.wt40 =	wt40;
	}
 
	/**
	 * Column Info
	 * @return	wt40
	 */
	 public	 String	getWt40() {
		 return	this.wt40;
	 } 
 	/**
	* Column Info
	* @param  fullTs20
	*/
	public void	setFullTs20( String	fullTs20 ) {
		this.fullTs20 =	fullTs20;
	}
 
	/**
	 * Column Info
	 * @return	fullTs20
	 */
	 public	 String	getFullTs20() {
		 return	this.fullTs20;
	 } 
 	/**
	* Column Info
	* @param  wt45
	*/
	public void	setWt45( String	wt45 ) {
		this.wt45 =	wt45;
	}
 
	/**
	 * Column Info
	 * @return	wt45
	 */
	 public	 String	getWt45() {
		 return	this.wt45;
	 } 
 	/**
	* Column Info
	* @param  fullTs4h
	*/
	public void	setFullTs4h( String	fullTs4h ) {
		this.fullTs4h =	fullTs4h;
	}
 
	/**
	 * Column Info
	 * @return	fullTs4h
	 */
	 public	 String	getFullTs4h() {
		 return	this.fullTs4h;
	 } 
 	/**
	* Column Info
	* @param  fullTs45
	*/
	public void	setFullTs45( String	fullTs45 ) {
		this.fullTs45 =	fullTs45;
	}
 
	/**
	 * Column Info
	 * @return	fullTs45
	 */
	 public	 String	getFullTs45() {
		 return	this.fullTs45;
	 } 
 	/**
	* Column Info
	* @param  etTs40
	*/
	public void	setEtTs40( String	etTs40 ) {
		this.etTs40 =	etTs40;
	}
 
	/**
	 * Column Info
	 * @return	etTs40
	 */
	 public	 String	getEtTs40() {
		 return	this.etTs40;
	 } 
 	/**
	* Column Info
	* @param  wt2h
	*/
	public void	setWt2h( String	wt2h ) {
		this.wt2h =	wt2h;
	}
 
	/**
	 * Column Info
	 * @return	wt2h
	 */
	 public	 String	getWt2h() {
		 return	this.wt2h;
	 } 
 	/**
	* Column Info
	* @param  etTs4h
	*/
	public void	setEtTs4h( String	etTs4h ) {
		this.etTs4h =	etTs4h;
	}
 
	/**
	 * Column Info
	 * @return	etTs4h
	 */
	 public	 String	getEtTs4h() {
		 return	this.etTs4h;
	 } 
 	/**
	* Column Info
	* @param  etTs2h
	*/
	public void	setEtTs2h( String	etTs2h ) {
		this.etTs2h =	etTs2h;
	}
 
	/**
	 * Column Info
	 * @return	etTs2h
	 */
	 public	 String	getEtTs2h() {
		 return	this.etTs2h;
	 } 
 	/**
	* Column Info
	* @param  etTs20
	*/
	public void	setEtTs20( String	etTs20 ) {
		this.etTs20 =	etTs20;
	}
 
	/**
	 * Column Info
	 * @return	etTs20
	 */
	 public	 String	getEtTs20() {
		 return	this.etTs20;
	 } 
 	/**
	* Column Info
	* @param  wt4h
	*/
	public void	setWt4h( String	wt4h ) {
		this.wt4h =	wt4h;
	}
 
	/**
	 * Column Info
	 * @return	wt4h
	 */
	 public	 String	getWt4h() {
		 return	this.wt4h;
	 } 
 	/**
	* Column Info
	* @param  fullTs2h
	*/
	public void	setFullTs2h( String	fullTs2h ) {
		this.fullTs2h =	fullTs2h;
	}
 
	/**
	 * Column Info
	 * @return	fullTs2h
	 */
	 public	 String	getFullTs2h() {
		 return	this.fullTs2h;
	 } 
 	/**
	* Column Info
	* @param  etBo2h
	*/
	public void	setEtBo2h( String	etBo2h ) {
		this.etBo2h =	etBo2h;
	}
 
	/**
	 * Column Info
	 * @return	etBo2h
	 */
	 public	 String	getEtBo2h() {
		 return	this.etBo2h;
	 } 
 	/**
	* Column Info
	* @param  etBo40
	*/
	public void	setEtBo40( String	etBo40 ) {
		this.etBo40 =	etBo40;
	}
 
	/**
	 * Column Info
	 * @return	etBo40
	 */
	 public	 String	getEtBo40() {
		 return	this.etBo40;
	 } 
 	/**
	* Column Info
	* @param  wt20
	*/
	public void	setWt20( String	wt20 ) {
		this.wt20 =	wt20;
	}
 
	/**
	 * Column Info
	 * @return	wt20
	 */
	 public	 String	getWt20() {
		 return	this.wt20;
	 } 
 	/**
	* Column Info
	* @param  etBo45
	*/
	public void	setEtBo45( String	etBo45 ) {
		this.etBo45 =	etBo45;
	}
 
	/**
	 * Column Info
	 * @return	etBo45
	 */
	 public	 String	getEtBo45() {
		 return	this.etBo45;
	 } 
 	/**
	* Column Info
	* @param  etBo20
	*/
	public void	setEtBo20( String	etBo20 ) {
		this.etBo20 =	etBo20;
	}
 
	/**
	 * Column Info
	 * @return	etBo20
	 */
	 public	 String	getEtBo20() {
		 return	this.etBo20;
	 } 
 	/**
	* Column Info
	* @param  podCd
	*/
	public void	setPodCd( String	podCd ) {
		this.podCd =	podCd;
	}
 
	/**
	 * Column Info
	 * @return	podCd
	 */
	 public	 String	getPodCd() {
		 return	this.podCd;
	 } 
 	/**
	* Column Info
	* @param  oprCd
	*/
	public void	setOprCd( String	oprCd ) {
		this.oprCd =	oprCd;
	}
 
	/**
	 * Column Info
	 * @return	oprCd
	 */
	 public	 String	getOprCd() {
		 return	this.oprCd;
	 } 
 	/**
	* Column Info
	* @param  idxSheet
	*/
	public void	setIdxSheet( String	idxSheet ) {
		this.idxSheet =	idxSheet;
	}
 
	/**
	 * Column Info
	 * @return	idxSheet
	 */
	 public	 String	getIdxSheet() {
		 return	this.idxSheet;
	 } 
 	/**
	* Column Info
	* @param  etBo4h
	*/
	public void	setEtBo4h( String	etBo4h ) {
		this.etBo4h =	etBo4h;
	}
 
	/**
	 * Column Info
	 * @return	etBo4h
	 */
	 public	 String	getEtBo4h() {
		 return	this.etBo4h;
	 } 
 	/**
	* Column Info
	* @param  fullBoDx
	*/
	public void	setFullBoDx( String	fullBoDx ) {
		this.fullBoDx =	fullBoDx;
	}
 
	/**
	 * Column Info
	 * @return	fullBoDx
	 */
	 public	 String	getFullBoDx() {
		 return	this.fullBoDx;
	 } 
 	/**
	* Column Info
	* @param  fullTsDx
	*/
	public void	setFullTsDx( String	fullTsDx ) {
		this.fullTsDx =	fullTsDx;
	}
 
	/**
	 * Column Info
	 * @return	fullTsDx
	 */
	 public	 String	getFullTsDx() {
		 return	this.fullTsDx;
	 } 
 	/**
	* Column Info
	* @param  etBoDx
	*/
	public void	setEtBoDx( String	etBoDx ) {
		this.etBoDx =	etBoDx;
	}
 
	/**
	 * Column Info
	 * @return	etBoDx
	 */
	 public	 String	getEtBoDx() {
		 return	this.etBoDx;
	 } 
 	/**
	* Column Info
	* @param  etTsDx
	*/
	public void	setEtTsDx( String	etTsDx ) {
		this.etTsDx =	etTsDx;
	}
 
	/**
	 * Column Info
	 * @return	etTsDx
	 */
	 public	 String	getEtTsDx() {
		 return	this.etTsDx;
	 } 
 	/**
	* Column Info
	* @param  wtDx
	*/
	public void	setWtDx( String	wtDx ) {
		this.wtDx =	wtDx;
	}
 
	/**
	 * Column Info
	 * @return	wtDx
	 */
	 public	 String	getWtDx() {
		 return	this.wtDx;
	 } 

	/**
	 * Request �쓽 �뜲�씠�꽣瑜� 異붿텧�븯�뿬 VO �쓽	硫ㅻ쾭蹂��닔�뿉 �꽕�젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setFullBo20(JSPUtil.getParameter(request,	prefix + "full_bo_20", ""));
		setFullBo4h(JSPUtil.getParameter(request,	prefix + "full_bo_4h", ""));
		setFullBo2h(JSPUtil.getParameter(request,	prefix + "full_bo_2h", ""));
		setFullBo45(JSPUtil.getParameter(request,	prefix + "full_bo_45", ""));
		setFullBo40(JSPUtil.getParameter(request,	prefix + "full_bo_40", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setEtTs45(JSPUtil.getParameter(request,	prefix + "et_ts_45", ""));
		setFullTs40(JSPUtil.getParameter(request,	prefix + "full_ts_40", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setWt40(JSPUtil.getParameter(request,	prefix + "wt_40", ""));
		setFullTs20(JSPUtil.getParameter(request,	prefix + "full_ts_20", ""));
		setWt45(JSPUtil.getParameter(request,	prefix + "wt_45", ""));
		setFullTs4h(JSPUtil.getParameter(request,	prefix + "full_ts_4h", ""));
		setFullTs45(JSPUtil.getParameter(request,	prefix + "full_ts_45", ""));
		setEtTs40(JSPUtil.getParameter(request,	prefix + "et_ts_40", ""));
		setWt2h(JSPUtil.getParameter(request,	prefix + "wt_2h", ""));
		setEtTs4h(JSPUtil.getParameter(request,	prefix + "et_ts_4h", ""));
		setEtTs2h(JSPUtil.getParameter(request,	prefix + "et_ts_2h", ""));
		setEtTs20(JSPUtil.getParameter(request,	prefix + "et_ts_20", ""));
		setWt4h(JSPUtil.getParameter(request,	prefix + "wt_4h", ""));
		setFullTs2h(JSPUtil.getParameter(request,	prefix + "full_ts_2h", ""));
		setEtBo2h(JSPUtil.getParameter(request,	prefix + "et_bo_2h", ""));
		setEtBo40(JSPUtil.getParameter(request,	prefix + "et_bo_40", ""));
		setWt20(JSPUtil.getParameter(request,	prefix + "wt_20", ""));
		setEtBo45(JSPUtil.getParameter(request,	prefix + "et_bo_45", ""));
		setEtBo20(JSPUtil.getParameter(request,	prefix + "et_bo_20", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setOprCd(JSPUtil.getParameter(request,	prefix + "opr_cd", ""));
		setIdxSheet(JSPUtil.getParameter(request,	prefix + "idx_sheet", ""));
		setEtBo4h(JSPUtil.getParameter(request,	prefix + "et_bo_4h", ""));
		setFullBoDx(JSPUtil.getParameter(request,	prefix + "full_bo_dx", ""));
		setFullTsDx(JSPUtil.getParameter(request,	prefix + "full_ts_dx", ""));
		setEtBoDx(JSPUtil.getParameter(request,	prefix + "et_bo_dx", ""));
		setEtTsDx(JSPUtil.getParameter(request,	prefix + "et_ts_dx", ""));
		setWtDx(JSPUtil.getParameter(request,	prefix + "wt_dx", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TdrDistLoadVolVO[]
	 */
	public TdrDistLoadVolVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TdrDistLoadVolVO[]
	 */
	public TdrDistLoadVolVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		TdrDistLoadVolVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] fullBo20 =	(JSPUtil.getParameter(request, prefix +	"full_bo_20".trim(),	length));
				String[] fullBo4h =	(JSPUtil.getParameter(request, prefix +	"full_bo_4h".trim(),	length));
				String[] fullBo2h =	(JSPUtil.getParameter(request, prefix +	"full_bo_2h".trim(),	length));
				String[] fullBo45 =	(JSPUtil.getParameter(request, prefix +	"full_bo_45".trim(),	length));
				String[] fullBo40 =	(JSPUtil.getParameter(request, prefix +	"full_bo_40".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] etTs45 =	(JSPUtil.getParameter(request, prefix +	"et_ts_45".trim(),	length));
				String[] fullTs40 =	(JSPUtil.getParameter(request, prefix +	"full_ts_40".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] wt40 =	(JSPUtil.getParameter(request, prefix +	"wt_40".trim(),	length));
				String[] fullTs20 =	(JSPUtil.getParameter(request, prefix +	"full_ts_20".trim(),	length));
				String[] wt45 =	(JSPUtil.getParameter(request, prefix +	"wt_45".trim(),	length));
				String[] fullTs4h =	(JSPUtil.getParameter(request, prefix +	"full_ts_4h".trim(),	length));
				String[] fullTs45 =	(JSPUtil.getParameter(request, prefix +	"full_ts_45".trim(),	length));
				String[] etTs40 =	(JSPUtil.getParameter(request, prefix +	"et_ts_40".trim(),	length));
				String[] wt2h =	(JSPUtil.getParameter(request, prefix +	"wt_2h".trim(),	length));
				String[] etTs4h =	(JSPUtil.getParameter(request, prefix +	"et_ts_4h".trim(),	length));
				String[] etTs2h =	(JSPUtil.getParameter(request, prefix +	"et_ts_2h".trim(),	length));
				String[] etTs20 =	(JSPUtil.getParameter(request, prefix +	"et_ts_20".trim(),	length));
				String[] wt4h =	(JSPUtil.getParameter(request, prefix +	"wt_4h".trim(),	length));
				String[] fullTs2h =	(JSPUtil.getParameter(request, prefix +	"full_ts_2h".trim(),	length));
				String[] etBo2h =	(JSPUtil.getParameter(request, prefix +	"et_bo_2h".trim(),	length));
				String[] etBo40 =	(JSPUtil.getParameter(request, prefix +	"et_bo_40".trim(),	length));
				String[] wt20 =	(JSPUtil.getParameter(request, prefix +	"wt_20".trim(),	length));
				String[] etBo45 =	(JSPUtil.getParameter(request, prefix +	"et_bo_45".trim(),	length));
				String[] etBo20 =	(JSPUtil.getParameter(request, prefix +	"et_bo_20".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] oprCd =	(JSPUtil.getParameter(request, prefix +	"opr_cd".trim(),	length));
				String[] idxSheet =	(JSPUtil.getParameter(request, prefix +	"idx_sheet".trim(),	length));
				String[] etBo4h =	(JSPUtil.getParameter(request, prefix +	"et_bo_4h".trim(),	length));
				String[] fullBoDx =	(JSPUtil.getParameter(request, prefix +	"full_bo_dx".trim(),	length));
				String[] fullTsDx =	(JSPUtil.getParameter(request, prefix +	"full_ts_dx".trim(),	length));
				String[] etBoDx =	(JSPUtil.getParameter(request, prefix +	"et_bo_dx".trim(),	length));
				String[] etTsDx =	(JSPUtil.getParameter(request, prefix +	"et_ts_dx".trim(),	length));
				String[] wtDx =	(JSPUtil.getParameter(request, prefix +	"wt_dx".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	TdrDistLoadVolVO();
						if ( fullBo20[i] !=	null)
						model.setFullBo20( fullBo20[i]);
						if ( fullBo4h[i] !=	null)
						model.setFullBo4h( fullBo4h[i]);
						if ( fullBo2h[i] !=	null)
						model.setFullBo2h( fullBo2h[i]);
						if ( fullBo45[i] !=	null)
						model.setFullBo45( fullBo45[i]);
						if ( fullBo40[i] !=	null)
						model.setFullBo40( fullBo40[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( etTs45[i] !=	null)
						model.setEtTs45( etTs45[i]);
						if ( fullTs40[i] !=	null)
						model.setFullTs40( fullTs40[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( wt40[i] !=	null)
						model.setWt40( wt40[i]);
						if ( fullTs20[i] !=	null)
						model.setFullTs20( fullTs20[i]);
						if ( wt45[i] !=	null)
						model.setWt45( wt45[i]);
						if ( fullTs4h[i] !=	null)
						model.setFullTs4h( fullTs4h[i]);
						if ( fullTs45[i] !=	null)
						model.setFullTs45( fullTs45[i]);
						if ( etTs40[i] !=	null)
						model.setEtTs40( etTs40[i]);
						if ( wt2h[i] !=	null)
						model.setWt2h( wt2h[i]);
						if ( etTs4h[i] !=	null)
						model.setEtTs4h( etTs4h[i]);
						if ( etTs2h[i] !=	null)
						model.setEtTs2h( etTs2h[i]);
						if ( etTs20[i] !=	null)
						model.setEtTs20( etTs20[i]);
						if ( wt4h[i] !=	null)
						model.setWt4h( wt4h[i]);
						if ( fullTs2h[i] !=	null)
						model.setFullTs2h( fullTs2h[i]);
						if ( etBo2h[i] !=	null)
						model.setEtBo2h( etBo2h[i]);
						if ( etBo40[i] !=	null)
						model.setEtBo40( etBo40[i]);
						if ( wt20[i] !=	null)
						model.setWt20( wt20[i]);
						if ( etBo45[i] !=	null)
						model.setEtBo45( etBo45[i]);
						if ( etBo20[i] !=	null)
						model.setEtBo20( etBo20[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( oprCd[i] !=	null)
						model.setOprCd( oprCd[i]);
						if ( idxSheet[i] !=	null)
						model.setIdxSheet( idxSheet[i]);
						if ( etBo4h[i] !=	null)
						model.setEtBo4h( etBo4h[i]);
						if ( fullBoDx[i] !=	null)
						model.setFullBoDx( fullBoDx[i]);
						if ( fullTsDx[i] !=	null)
						model.setFullTsDx( fullTsDx[i]);
						if ( etBoDx[i] !=	null)
						model.setEtBoDx( etBoDx[i]);
						if ( etTsDx[i] !=	null)
						model.setEtTsDx( etTsDx[i]);
						if ( wtDx[i] !=	null)
						model.setWtDx( wtDx[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getTdrDistLoadVolVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return TdrDistLoadVolVO[]
	 */
	public TdrDistLoadVolVO[]	 getTdrDistLoadVolVOs(){
		TdrDistLoadVolVO[] vos = (TdrDistLoadVolVO[])models.toArray(new	TdrDistLoadVolVO[models.size()]);
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
		this.fullBo20 =	this.fullBo20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullBo4h =	this.fullBo4h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullBo2h =	this.fullBo2h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullBo45 =	this.fullBo45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullBo40 =	this.fullBo40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etTs45 =	this.etTs45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullTs40 =	this.fullTs40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wt40 =	this.wt40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullTs20 =	this.fullTs20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wt45 =	this.wt45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullTs4h =	this.fullTs4h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullTs45 =	this.fullTs45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etTs40 =	this.etTs40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wt2h =	this.wt2h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etTs4h =	this.etTs4h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etTs2h =	this.etTs2h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etTs20 =	this.etTs20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wt4h =	this.wt4h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullTs2h =	this.fullTs2h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etBo2h =	this.etBo2h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etBo40 =	this.etBo40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wt20 =	this.wt20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etBo45 =	this.etBo45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etBo20 =	this.etBo20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd =	this.oprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idxSheet =	this.idxSheet.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etBo4h =	this.etBo4h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullBoDx =	this.fullBoDx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullTsDx =	this.fullTsDx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etBoDx =	this.etBoDx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etTsDx =	this.etTsDx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtDx =	this.wtDx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}