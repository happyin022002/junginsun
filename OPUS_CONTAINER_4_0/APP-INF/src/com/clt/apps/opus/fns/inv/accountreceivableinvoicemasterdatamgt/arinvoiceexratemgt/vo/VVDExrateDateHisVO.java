/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VVDExrateDateHisVO.java
 *@FileTitle : VVDExrateDateHisVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.10
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.12.10  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class VVDExrateDateHisVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<VVDExrateDateHisVO>  models =	new	ArrayList<VVDExrateDateHisVO>();


	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 svcScpCd   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 skdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 skdDirCd   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 vvdCd   =  null;
	/*	Column Info	*/
	private  String	 portCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 xchRtDt   =  null;
	/*	Column Info	*/
	private  String	 hisSeq   =  null;
	/*	Column Info	*/
	private  String	 cngRmk   =  null;
	/*	Column Info	*/
	private  String	 opStsNm   =  null;
	/*	Column Info	*/
	private  String	 fromDt   =  null;
	/*	Column Info	*/
	private  String	 toDt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public VVDExrateDateHisVO(){}

	public VVDExrateDateHisVO(String updDt,String vslCd,String svcScpCd,String creDt,String skdVoyNo,String ioBndCd,String skdDirCd,String arOfcCd,String pagerows,String creUsrId,String ibflag,String vvdCd,String portCd,String updUsrId,String xchRtDt,String hisSeq,String cngRmk,String opStsNm,String fromDt,String toDt)	{
		this.updDt  = updDt ;
		this.vslCd  = vslCd ;
		this.svcScpCd  = svcScpCd ;
		this.creDt  = creDt ;
		this.skdVoyNo  = skdVoyNo ;
		this.ioBndCd  = ioBndCd ;
		this.skdDirCd  = skdDirCd ;
		this.arOfcCd  = arOfcCd ;
		this.pagerows  = pagerows ;
		this.creUsrId  = creUsrId ;
		this.ibflag  = ibflag ;
		this.vvdCd  = vvdCd ;
		this.portCd  = portCd ;
		this.updUsrId  = updUsrId ;
		this.xchRtDt  = xchRtDt ;
		this.hisSeq  = hisSeq ;
		this.cngRmk  = cngRmk ;
		this.opStsNm  = opStsNm ;
		this.fromDt  = fromDt ;
		this.toDt  = toDt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("vvd_cd", getVvdCd());		
		this.hashColumns.put("port_cd", getPortCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("xch_rt_dt", getXchRtDt());		
		this.hashColumns.put("his_seq", getHisSeq());		
		this.hashColumns.put("cng_rmk", getCngRmk());		
		this.hashColumns.put("op_sts_nm", getOpStsNm());		
		this.hashColumns.put("from_dt", getFromDt());		
		this.hashColumns.put("to_dt", getToDt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("xch_rt_dt", "xchRtDt");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("cng_rmk", "cngRmk");
		this.hashFields.put("op_sts_nm", "opStsNm");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("to_dt", "toDt");
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
	* @param  svcScpCd
	*/
	public void	setSvcScpCd( String	svcScpCd ) {
		this.svcScpCd =	svcScpCd;
	}
 
	/**
	 * Column Info
	 * @return	svcScpCd
	 */
	 public	 String	getSvcScpCd() {
		 return	this.svcScpCd;
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
	* @param  skdVoyNo
	*/
	public void	setSkdVoyNo( String	skdVoyNo ) {
		this.skdVoyNo =	skdVoyNo;
	}
 
	/**
	 * Column Info
	 * @return	skdVoyNo
	 */
	 public	 String	getSkdVoyNo() {
		 return	this.skdVoyNo;
	 } 
 	/**
	* Column Info
	* @param  ioBndCd
	*/
	public void	setIoBndCd( String	ioBndCd ) {
		this.ioBndCd =	ioBndCd;
	}
 
	/**
	 * Column Info
	 * @return	ioBndCd
	 */
	 public	 String	getIoBndCd() {
		 return	this.ioBndCd;
	 } 
 	/**
	* Column Info
	* @param  skdDirCd
	*/
	public void	setSkdDirCd( String	skdDirCd ) {
		this.skdDirCd =	skdDirCd;
	}
 
	/**
	 * Column Info
	 * @return	skdDirCd
	 */
	 public	 String	getSkdDirCd() {
		 return	this.skdDirCd;
	 } 
 	/**
	* Column Info
	* @param  arOfcCd
	*/
	public void	setArOfcCd( String	arOfcCd ) {
		this.arOfcCd =	arOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	arOfcCd
	 */
	 public	 String	getArOfcCd() {
		 return	this.arOfcCd;
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
	* @param  vvdCd
	*/
	public void	setVvdCd( String	vvdCd ) {
		this.vvdCd =	vvdCd;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd
	 */
	 public	 String	getVvdCd() {
		 return	this.vvdCd;
	 } 
 	/**
	* Column Info
	* @param  portCd
	*/
	public void	setPortCd( String	portCd ) {
		this.portCd =	portCd;
	}
 
	/**
	 * Column Info
	 * @return	portCd
	 */
	 public	 String	getPortCd() {
		 return	this.portCd;
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
	* @param  xchRtDt
	*/
	public void	setXchRtDt( String	xchRtDt ) {
		this.xchRtDt =	xchRtDt;
	}
 
	/**
	 * Column Info
	 * @return	xchRtDt
	 */
	 public	 String	getXchRtDt() {
		 return	this.xchRtDt;
	 } 
 	/**
	* Column Info
	* @param  hisSeq
	*/
	public void	setHisSeq( String	hisSeq ) {
		this.hisSeq =	hisSeq;
	}
 
	/**
	 * Column Info
	 * @return	hisSeq
	 */
	 public	 String	getHisSeq() {
		 return	this.hisSeq;
	 } 
 	/**
	* Column Info
	* @param  cngRmk
	*/
	public void	setCngRmk( String	cngRmk ) {
		this.cngRmk =	cngRmk;
	}
 
	/**
	 * Column Info
	 * @return	cngRmk
	 */
	 public	 String	getCngRmk() {
		 return	this.cngRmk;
	 } 
 	/**
	* Column Info
	* @param  opStsNm
	*/
	public void	setOpStsNm( String	opStsNm ) {
		this.opStsNm =	opStsNm;
	}
 
	/**
	 * Column Info
	 * @return	opStsNm
	 */
	 public	 String	getOpStsNm() {
		 return	this.opStsNm;
	 } 
 	/**
	* Column Info
	* @param  fromDt
	*/
	public void	setFromDt( String	fromDt ) {
		this.fromDt =	fromDt;
	}
 
	/**
	 * Column Info
	 * @return	fromDt
	 */
	 public	 String	getFromDt() {
		 return	this.fromDt;
	 } 
 	/**
	* Column Info
	* @param  toDt
	*/
	public void	setToDt( String	toDt ) {
		this.toDt =	toDt;
	}
 
	/**
	 * Column Info
	 * @return	toDt
	 */
	 public	 String	getToDt() {
		 return	this.toDt;
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
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request,	prefix + "vvd_cd", ""));
		setPortCd(JSPUtil.getParameter(request,	prefix + "port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setXchRtDt(JSPUtil.getParameter(request,	prefix + "xch_rt_dt", ""));
		setHisSeq(JSPUtil.getParameter(request,	prefix + "his_seq", ""));
		setCngRmk(JSPUtil.getParameter(request,	prefix + "cng_rmk", ""));
		setOpStsNm(JSPUtil.getParameter(request,	prefix + "op_sts_nm", ""));
		setFromDt(JSPUtil.getParameter(request,	prefix + "from_dt", ""));
		setToDt(JSPUtil.getParameter(request,	prefix + "to_dt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VVDExrateDateHisVO[]
	 */
	public VVDExrateDateHisVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return VVDExrateDateHisVO[]
	 */
	public VVDExrateDateHisVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		VVDExrateDateHisVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] vvdCd =	(JSPUtil.getParameter(request, prefix +	"vvd_cd".trim(),	length));
				String[] portCd =	(JSPUtil.getParameter(request, prefix +	"port_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] xchRtDt =	(JSPUtil.getParameter(request, prefix +	"xch_rt_dt".trim(),	length));
				String[] hisSeq =	(JSPUtil.getParameter(request, prefix +	"his_seq".trim(),	length));
				String[] cngRmk =	(JSPUtil.getParameter(request, prefix +	"cng_rmk".trim(),	length));
				String[] opStsNm =	(JSPUtil.getParameter(request, prefix +	"op_sts_nm".trim(),	length));
				String[] fromDt =	(JSPUtil.getParameter(request, prefix +	"from_dt".trim(),	length));
				String[] toDt =	(JSPUtil.getParameter(request, prefix +	"to_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	VVDExrateDateHisVO();
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( svcScpCd[i] !=	null)
						model.setSvcScpCd( svcScpCd[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( skdVoyNo[i] !=	null)
						model.setSkdVoyNo( skdVoyNo[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( skdDirCd[i] !=	null)
						model.setSkdDirCd( skdDirCd[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( vvdCd[i] !=	null)
						model.setVvdCd( vvdCd[i]);
						if ( portCd[i] !=	null)
						model.setPortCd( portCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( xchRtDt[i] !=	null)
						model.setXchRtDt( xchRtDt[i]);
						if ( hisSeq[i] !=	null)
						model.setHisSeq( hisSeq[i]);
						if ( cngRmk[i] !=	null)
						model.setCngRmk( cngRmk[i]);
						if ( opStsNm[i] !=	null)
						model.setOpStsNm( opStsNm[i]);
						if ( fromDt[i] !=	null)
						model.setFromDt( fromDt[i]);
						if ( toDt[i] !=	null)
						model.setToDt( toDt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getVVDExrateDateHisVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return VVDExrateDateHisVO[]
	 */
	public VVDExrateDateHisVO[]	 getVVDExrateDateHisVOs(){
		VVDExrateDateHisVO[] vos = (VVDExrateDateHisVO[])models.toArray(new	VVDExrateDateHisVO[models.size()]);
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
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd =	this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd =	this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtDt =	this.xchRtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq =	this.hisSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngRmk =	this.cngRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opStsNm =	this.opStsNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt =	this.fromDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt =	this.toDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}