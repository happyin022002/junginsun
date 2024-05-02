/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ContainerTypeSizeCodeVO.java
 *@FileTitle : ContainerTypeSizeCodeVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.08
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.12.08  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo;

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
 * - 愿�젴	Event�먯꽌	�묒꽦,	�쒕쾭�ㅽ뻾�붿껌��PDTO����븷���섑뻾�섎뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class ContainerTypeSizeCodeVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ContainerTypeSizeCodeVO>  models =	new	ArrayList<ContainerTypeSizeCodeVO>();


	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 rptDpSeq   =  null;
	/*	Column Info	*/
	private  String	 isoCntrTpszNm   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszIsoCd   =  null;
	/*	Column Info	*/
	private  String	 aciacDivCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszDesc   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszGrpCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 cntrSzTeuCapa   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ContainerTypeSizeCodeVO(){}

	public ContainerTypeSizeCodeVO(String updDt,String updUsrId,String rptDpSeq,String isoCntrTpszNm,String cntrTpszIsoCd,String aciacDivCd,String cntrTpszDesc,String ibflag,String cntrTpszGrpCd,String cntrTpszCd,String cntrSzTeuCapa,String pagerows,String ofcCd)	{
		this.updDt  = updDt ;
		this.updUsrId  = updUsrId ;
		this.rptDpSeq  = rptDpSeq ;
		this.isoCntrTpszNm  = isoCntrTpszNm ;
		this.cntrTpszIsoCd  = cntrTpszIsoCd ;
		this.aciacDivCd  = aciacDivCd ;
		this.cntrTpszDesc  = cntrTpszDesc ;
		this.ibflag  = ibflag ;
		this.cntrTpszGrpCd  = cntrTpszGrpCd ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.cntrSzTeuCapa  = cntrSzTeuCapa ;
		this.pagerows  = pagerows ;
		this.ofcCd  = ofcCd ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("rpt_dp_seq", getRptDpSeq());		
		this.hashColumns.put("iso_cntr_tpsz_nm", getIsoCntrTpszNm());		
		this.hashColumns.put("cntr_tpsz_iso_cd", getCntrTpszIsoCd());		
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());		
		this.hashColumns.put("cntr_tpsz_desc", getCntrTpszDesc());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cntr_tpsz_grp_cd", getCntrTpszGrpCd());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("cntr_sz_teu_capa", getCntrSzTeuCapa());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rpt_dp_seq", "rptDpSeq");
		this.hashFields.put("iso_cntr_tpsz_nm", "isoCntrTpszNm");
		this.hashFields.put("cntr_tpsz_iso_cd", "cntrTpszIsoCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("cntr_tpsz_desc", "cntrTpszDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tpsz_grp_cd", "cntrTpszGrpCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_sz_teu_capa", "cntrSzTeuCapa");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
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
	* @param  rptDpSeq
	*/
	public void	setRptDpSeq( String	rptDpSeq ) {
		this.rptDpSeq =	rptDpSeq;
	}
 
	/**
	 * Column Info
	 * @return	rptDpSeq
	 */
	 public	 String	getRptDpSeq() {
		 return	this.rptDpSeq;
	 } 
 	/**
	* Column Info
	* @param  isoCntrTpszNm
	*/
	public void	setIsoCntrTpszNm( String	isoCntrTpszNm ) {
		this.isoCntrTpszNm =	isoCntrTpszNm;
	}
 
	/**
	 * Column Info
	 * @return	isoCntrTpszNm
	 */
	 public	 String	getIsoCntrTpszNm() {
		 return	this.isoCntrTpszNm;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszIsoCd
	*/
	public void	setCntrTpszIsoCd( String	cntrTpszIsoCd ) {
		this.cntrTpszIsoCd =	cntrTpszIsoCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszIsoCd
	 */
	 public	 String	getCntrTpszIsoCd() {
		 return	this.cntrTpszIsoCd;
	 } 
 	/**
	* Column Info
	* @param  aciacDivCd
	*/
	public void	setAciacDivCd( String	aciacDivCd ) {
		this.aciacDivCd =	aciacDivCd;
	}
 
	/**
	 * Column Info
	 * @return	aciacDivCd
	 */
	 public	 String	getAciacDivCd() {
		 return	this.aciacDivCd;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszDesc
	*/
	public void	setCntrTpszDesc( String	cntrTpszDesc ) {
		this.cntrTpszDesc =	cntrTpszDesc;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszDesc
	 */
	 public	 String	getCntrTpszDesc() {
		 return	this.cntrTpszDesc;
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
	* @param  cntrTpszGrpCd
	*/
	public void	setCntrTpszGrpCd( String	cntrTpszGrpCd ) {
		this.cntrTpszGrpCd =	cntrTpszGrpCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszGrpCd
	 */
	 public	 String	getCntrTpszGrpCd() {
		 return	this.cntrTpszGrpCd;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd
	*/
	public void	setCntrTpszCd( String	cntrTpszCd ) {
		this.cntrTpszCd =	cntrTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd
	 */
	 public	 String	getCntrTpszCd() {
		 return	this.cntrTpszCd;
	 } 
 	/**
	* Column Info
	* @param  cntrSzTeuCapa
	*/
	public void	setCntrSzTeuCapa( String	cntrSzTeuCapa ) {
		this.cntrSzTeuCapa =	cntrSzTeuCapa;
	}
 
	/**
	 * Column Info
	 * @return	cntrSzTeuCapa
	 */
	 public	 String	getCntrSzTeuCapa() {
		 return	this.cntrSzTeuCapa;
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
	* @param  ofcCd
	*/
	public void	setOfcCd( String	ofcCd ) {
		this.ofcCd =	ofcCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcCd
	 */
	 public	 String	getOfcCd() {
		 return	this.ofcCd;
	 } 

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setRptDpSeq(JSPUtil.getParameter(request,	prefix + "rpt_dp_seq", ""));
		setIsoCntrTpszNm(JSPUtil.getParameter(request,	prefix + "iso_cntr_tpsz_nm", ""));
		setCntrTpszIsoCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_iso_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request,	prefix + "aciac_div_cd", ""));
		setCntrTpszDesc(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_desc", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCntrTpszGrpCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_grp_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setCntrSzTeuCapa(JSPUtil.getParameter(request,	prefix + "cntr_sz_teu_capa", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return ContainerTypeSizeCodeVO[]
	 */
	public ContainerTypeSizeCodeVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return ContainerTypeSizeCodeVO[]
	 */
	public ContainerTypeSizeCodeVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ContainerTypeSizeCodeVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] rptDpSeq =	(JSPUtil.getParameter(request, prefix +	"rpt_dp_seq".trim(),	length));
				String[] isoCntrTpszNm =	(JSPUtil.getParameter(request, prefix +	"iso_cntr_tpsz_nm".trim(),	length));
				String[] cntrTpszIsoCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_iso_cd".trim(),	length));
				String[] aciacDivCd =	(JSPUtil.getParameter(request, prefix +	"aciac_div_cd".trim(),	length));
				String[] cntrTpszDesc =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_desc".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] cntrTpszGrpCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_grp_cd".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] cntrSzTeuCapa =	(JSPUtil.getParameter(request, prefix +	"cntr_sz_teu_capa".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ContainerTypeSizeCodeVO();
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( rptDpSeq[i] !=	null)
						model.setRptDpSeq( rptDpSeq[i]);
						if ( isoCntrTpszNm[i] !=	null)
						model.setIsoCntrTpszNm( isoCntrTpszNm[i]);
						if ( cntrTpszIsoCd[i] !=	null)
						model.setCntrTpszIsoCd( cntrTpszIsoCd[i]);
						if ( aciacDivCd[i] !=	null)
						model.setAciacDivCd( aciacDivCd[i]);
						if ( cntrTpszDesc[i] !=	null)
						model.setCntrTpszDesc( cntrTpszDesc[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( cntrTpszGrpCd[i] !=	null)
						model.setCntrTpszGrpCd( cntrTpszGrpCd[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( cntrSzTeuCapa[i] !=	null)
						model.setCntrSzTeuCapa( cntrSzTeuCapa[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getContainerTypeSizeCodeVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return ContainerTypeSizeCodeVO[]
	 */
	public ContainerTypeSizeCodeVO[]	 getContainerTypeSizeCodeVOs(){
		ContainerTypeSizeCodeVO[] vos = (ContainerTypeSizeCodeVO[])models.toArray(new	ContainerTypeSizeCodeVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class���댁슜��String�쇰줈 蹂�솚
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* �щ㎎�낅맂 臾몄옄�댁뿉���뱀닔臾몄옄 �쒓굅("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptDpSeq =	this.rptDpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isoCntrTpszNm =	this.isoCntrTpszNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszIsoCd =	this.cntrTpszIsoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd =	this.aciacDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszDesc =	this.cntrTpszDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszGrpCd =	this.cntrTpszGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzTeuCapa =	this.cntrSzTeuCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}