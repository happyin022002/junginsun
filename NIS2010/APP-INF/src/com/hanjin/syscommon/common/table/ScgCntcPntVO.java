/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ScgCntcPntVO.java
 *@FileTitle : ScgCntcPntVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2018.01.31
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2018.01.31  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.syscommon.common.table;

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
public class ScgCntcPntVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ScgCntcPntVO>  models =	new	ArrayList<ScgCntcPntVO>();


	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 rgnShpOprCd   =  null;
	/*	Column Info	*/
	private  String	 cntcPsonEmlCtnt   =  null;
	/*	Column Info	*/
	private  String	 deltFlg   =  null;
	/*	Column Info	*/
	private  String	 spclCgoCateCd   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 cntcPsonPhnNo   =  null;
	/*	Column Info	*/
	private  String	 crrCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 vslOprNm   =  null;
	/*	Column Info	*/
	private  String	 cntcPsonFaxNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 slanCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 polCntcEmlFlg   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ScgCntcPntVO(){}

	public ScgCntcPntVO(String updDt,String rgnShpOprCd,String cntcPsonEmlCtnt,String deltFlg,String spclCgoCateCd,String creDt,String cntcPsonPhnNo,String crrCd,String pagerows,String vslOprNm,String cntcPsonFaxNo,String ibflag,String creUsrId,String slanCd,String updUsrId,String polCntcEmlFlg)	{
		this.updDt  = updDt ;
		this.rgnShpOprCd  = rgnShpOprCd ;
		this.cntcPsonEmlCtnt  = cntcPsonEmlCtnt ;
		this.deltFlg  = deltFlg ;
		this.spclCgoCateCd  = spclCgoCateCd ;
		this.creDt  = creDt ;
		this.cntcPsonPhnNo  = cntcPsonPhnNo ;
		this.crrCd  = crrCd ;
		this.pagerows  = pagerows ;
		this.vslOprNm  = vslOprNm ;
		this.cntcPsonFaxNo  = cntcPsonFaxNo ;
		this.ibflag  = ibflag ;
		this.creUsrId  = creUsrId ;
		this.slanCd  = slanCd ;
		this.updUsrId  = updUsrId ;
		this.polCntcEmlFlg  = polCntcEmlFlg ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());		
		this.hashColumns.put("cntc_pson_eml_ctnt", getCntcPsonEmlCtnt());		
		this.hashColumns.put("delt_flg", getDeltFlg());		
		this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("cntc_pson_phn_no", getCntcPsonPhnNo());		
		this.hashColumns.put("crr_cd", getCrrCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("vsl_opr_nm", getVslOprNm());		
		this.hashColumns.put("cntc_pson_fax_no", getCntcPsonFaxNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("slan_cd", getSlanCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("pol_cntc_eml_flg", getPolCntcEmlFlg());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
		this.hashFields.put("cntc_pson_eml_ctnt", "cntcPsonEmlCtnt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cntc_pson_phn_no", "cntcPsonPhnNo");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_opr_nm", "vslOprNm");
		this.hashFields.put("cntc_pson_fax_no", "cntcPsonFaxNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pol_cntc_eml_flg", "polCntcEmlFlg");
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
	* @param  rgnShpOprCd
	*/
	public void	setRgnShpOprCd( String	rgnShpOprCd ) {
		this.rgnShpOprCd =	rgnShpOprCd;
	}
 
	/**
	 * Column Info
	 * @return	rgnShpOprCd
	 */
	 public	 String	getRgnShpOprCd() {
		 return	this.rgnShpOprCd;
	 } 
 	/**
	* Column Info
	* @param  cntcPsonEmlCtnt
	*/
	public void	setCntcPsonEmlCtnt( String	cntcPsonEmlCtnt ) {
		this.cntcPsonEmlCtnt =	cntcPsonEmlCtnt;
	}
 
	/**
	 * Column Info
	 * @return	cntcPsonEmlCtnt
	 */
	 public	 String	getCntcPsonEmlCtnt() {
		 return	this.cntcPsonEmlCtnt;
	 } 
 	/**
	* Column Info
	* @param  deltFlg
	*/
	public void	setDeltFlg( String	deltFlg ) {
		this.deltFlg =	deltFlg;
	}
 
	/**
	 * Column Info
	 * @return	deltFlg
	 */
	 public	 String	getDeltFlg() {
		 return	this.deltFlg;
	 } 
 	/**
	* Column Info
	* @param  spclCgoCateCd
	*/
	public void	setSpclCgoCateCd( String	spclCgoCateCd ) {
		this.spclCgoCateCd =	spclCgoCateCd;
	}
 
	/**
	 * Column Info
	 * @return	spclCgoCateCd
	 */
	 public	 String	getSpclCgoCateCd() {
		 return	this.spclCgoCateCd;
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
	* @param  cntcPsonPhnNo
	*/
	public void	setCntcPsonPhnNo( String	cntcPsonPhnNo ) {
		this.cntcPsonPhnNo =	cntcPsonPhnNo;
	}
 
	/**
	 * Column Info
	 * @return	cntcPsonPhnNo
	 */
	 public	 String	getCntcPsonPhnNo() {
		 return	this.cntcPsonPhnNo;
	 } 
 	/**
	* Column Info
	* @param  crrCd
	*/
	public void	setCrrCd( String	crrCd ) {
		this.crrCd =	crrCd;
	}
 
	/**
	 * Column Info
	 * @return	crrCd
	 */
	 public	 String	getCrrCd() {
		 return	this.crrCd;
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
	* @param  vslOprNm
	*/
	public void	setVslOprNm( String	vslOprNm ) {
		this.vslOprNm =	vslOprNm;
	}
 
	/**
	 * Column Info
	 * @return	vslOprNm
	 */
	 public	 String	getVslOprNm() {
		 return	this.vslOprNm;
	 } 
 	/**
	* Column Info
	* @param  cntcPsonFaxNo
	*/
	public void	setCntcPsonFaxNo( String	cntcPsonFaxNo ) {
		this.cntcPsonFaxNo =	cntcPsonFaxNo;
	}
 
	/**
	 * Column Info
	 * @return	cntcPsonFaxNo
	 */
	 public	 String	getCntcPsonFaxNo() {
		 return	this.cntcPsonFaxNo;
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
	* @param  slanCd
	*/
	public void	setSlanCd( String	slanCd ) {
		this.slanCd =	slanCd;
	}
 
	/**
	 * Column Info
	 * @return	slanCd
	 */
	 public	 String	getSlanCd() {
		 return	this.slanCd;
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
	* @param  polCntcEmlFlg
	*/
	public void	setPolCntcEmlFlg( String	polCntcEmlFlg ) {
		this.polCntcEmlFlg =	polCntcEmlFlg;
	}
 
	/**
	 * Column Info
	 * @return	polCntcEmlFlg
	 */
	 public	 String	getPolCntcEmlFlg() {
		 return	this.polCntcEmlFlg;
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
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setRgnShpOprCd(JSPUtil.getParameter(request,	prefix + "rgn_shp_opr_cd", ""));
		setCntcPsonEmlCtnt(JSPUtil.getParameter(request,	prefix + "cntc_pson_eml_ctnt", ""));
		setDeltFlg(JSPUtil.getParameter(request,	prefix + "delt_flg", ""));
		setSpclCgoCateCd(JSPUtil.getParameter(request,	prefix + "spcl_cgo_cate_cd", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setCntcPsonPhnNo(JSPUtil.getParameter(request,	prefix + "cntc_pson_phn_no", ""));
		setCrrCd(JSPUtil.getParameter(request,	prefix + "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setVslOprNm(JSPUtil.getParameter(request,	prefix + "vsl_opr_nm", ""));
		setCntcPsonFaxNo(JSPUtil.getParameter(request,	prefix + "cntc_pson_fax_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request,	prefix + "slan_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setPolCntcEmlFlg(JSPUtil.getParameter(request,	prefix + "pol_cntc_eml_flg", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgCntcPntVO[]
	 */
	public ScgCntcPntVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgCntcPntVO[]
	 */
	public ScgCntcPntVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ScgCntcPntVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] rgnShpOprCd =	(JSPUtil.getParameter(request, prefix +	"rgn_shp_opr_cd".trim(),	length));
				String[] cntcPsonEmlCtnt =	(JSPUtil.getParameter(request, prefix +	"cntc_pson_eml_ctnt".trim(),	length));
				String[] deltFlg =	(JSPUtil.getParameter(request, prefix +	"delt_flg".trim(),	length));
				String[] spclCgoCateCd =	(JSPUtil.getParameter(request, prefix +	"spcl_cgo_cate_cd".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] cntcPsonPhnNo =	(JSPUtil.getParameter(request, prefix +	"cntc_pson_phn_no".trim(),	length));
				String[] crrCd =	(JSPUtil.getParameter(request, prefix +	"crr_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] vslOprNm =	(JSPUtil.getParameter(request, prefix +	"vsl_opr_nm".trim(),	length));
				String[] cntcPsonFaxNo =	(JSPUtil.getParameter(request, prefix +	"cntc_pson_fax_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] slanCd =	(JSPUtil.getParameter(request, prefix +	"slan_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] polCntcEmlFlg =	(JSPUtil.getParameter(request, prefix +	"pol_cntc_eml_flg".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ScgCntcPntVO();
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( rgnShpOprCd[i] !=	null)
						model.setRgnShpOprCd( rgnShpOprCd[i]);
						if ( cntcPsonEmlCtnt[i] !=	null)
						model.setCntcPsonEmlCtnt( cntcPsonEmlCtnt[i]);
						if ( deltFlg[i] !=	null)
						model.setDeltFlg( deltFlg[i]);
						if ( spclCgoCateCd[i] !=	null)
						model.setSpclCgoCateCd( spclCgoCateCd[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( cntcPsonPhnNo[i] !=	null)
						model.setCntcPsonPhnNo( cntcPsonPhnNo[i]);
						if ( crrCd[i] !=	null)
						model.setCrrCd( crrCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( vslOprNm[i] !=	null)
						model.setVslOprNm( vslOprNm[i]);
						if ( cntcPsonFaxNo[i] !=	null)
						model.setCntcPsonFaxNo( cntcPsonFaxNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( slanCd[i] !=	null)
						model.setSlanCd( slanCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( polCntcEmlFlg[i] !=	null)
						model.setPolCntcEmlFlg( polCntcEmlFlg[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getScgCntcPntVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgCntcPntVO[]
	 */
	public ScgCntcPntVO[]	 getScgCntcPntVOs(){
		ScgCntcPntVO[] vos = (ScgCntcPntVO[])models.toArray(new	ScgCntcPntVO[models.size()]);
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
		this.rgnShpOprCd =	this.rgnShpOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonEmlCtnt =	this.cntcPsonEmlCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg =	this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCateCd =	this.spclCgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonPhnNo =	this.cntcPsonPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd =	this.crrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOprNm =	this.vslOprNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonFaxNo =	this.cntcPsonFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd =	this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCntcEmlFlg =	this.polCntcEmlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}