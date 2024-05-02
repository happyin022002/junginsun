/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : BkgXterDgCgoVO.java
 *@FileTitle : BkgXterDgCgoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.12.18
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.12.18  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class BkgXterDgCgoVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<BkgXterDgCgoVO>  models =	new	ArrayList<BkgXterDgCgoVO>();


	/*	Column Info	*/
	private  String	 dgRider   =  null;
	/*	Column Info	*/
	private  String	 imdgPckGrpCd   =  null;
	/*	Column Info	*/
	private  String	 flshPntCdoTemp   =  null;
	/*	Column Info	*/
	private  String	 netWgt   =  null;
	/*	Column Info	*/
	private  String	 imdgUnNoSeq   =  null;
	/*	Column Info	*/
	private  String	 dcgoStsCd   =  null;
	/*	Column Info	*/
	private  String	 emerCntcPsonNm   =  null;
	/*	Column Info	*/
	private  String	 cntrCgoSeq   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 spclStwgRqstDesc   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 wgtUtCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 hzdDesc   =  null;
	/*	Column Info	*/
	private  String	 prpShpNm   =  null;
	/*	Column Info	*/
	private  String	 mrnPolutFlg   =  null;
	/*	Column Info	*/
	private  String	 grsWgt   =  null;
	/*	Column Info	*/
	private  String	 imdgUnNo   =  null;
	/*	Column Info	*/
	private  String	 imdgClssCd   =  null;
	/*	Column Info	*/
	private  String	 imdgLmtQtyFlg   =  null;
	/*	Column Info	*/
	private  String	 dgCntrSeq   =  null;
	/*	Column Info	*/
	private  String	 imdgCompGrpCd   =  null;
	/*	Column Info	*/
	private  String	 dcgoSeq   =  null;
	/*	Column Info	*/
	private  String	 emerCntcPhnNoCtnt   =  null;
	/*	Column Info	*/
	private  String	 outImdgPckCd1   =  null;
	/*	Column Info	*/
	private  String	 outImdgPckQty1   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public BkgXterDgCgoVO(){}

	public BkgXterDgCgoVO(String dgRider,String imdgPckGrpCd,String flshPntCdoTemp,String netWgt,String imdgUnNoSeq,String dcgoStsCd,String emerCntcPsonNm,String cntrCgoSeq,String pagerows,String spclStwgRqstDesc,String ibflag,String cntrNo,String wgtUtCd,String cntrTpszCd,String hzdDesc,String prpShpNm,String mrnPolutFlg,String grsWgt,String imdgUnNo,String imdgClssCd,String imdgLmtQtyFlg,String dgCntrSeq,String imdgCompGrpCd,String dcgoSeq,String emerCntcPhnNoCtnt,String outImdgPckCd1,String outImdgPckQty1)	{
		this.dgRider  = dgRider ;
		this.imdgPckGrpCd  = imdgPckGrpCd ;
		this.flshPntCdoTemp  = flshPntCdoTemp ;
		this.netWgt  = netWgt ;
		this.imdgUnNoSeq  = imdgUnNoSeq ;
		this.dcgoStsCd  = dcgoStsCd ;
		this.emerCntcPsonNm  = emerCntcPsonNm ;
		this.cntrCgoSeq  = cntrCgoSeq ;
		this.pagerows  = pagerows ;
		this.spclStwgRqstDesc  = spclStwgRqstDesc ;
		this.ibflag  = ibflag ;
		this.cntrNo  = cntrNo ;
		this.wgtUtCd  = wgtUtCd ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.hzdDesc  = hzdDesc ;
		this.prpShpNm  = prpShpNm ;
		this.mrnPolutFlg  = mrnPolutFlg ;
		this.grsWgt  = grsWgt ;
		this.imdgUnNo  = imdgUnNo ;
		this.imdgClssCd  = imdgClssCd ;
		this.imdgLmtQtyFlg  = imdgLmtQtyFlg ;
		this.dgCntrSeq  = dgCntrSeq ;
		this.imdgCompGrpCd  = imdgCompGrpCd ;
		this.dcgoSeq  = dcgoSeq ;
		this.emerCntcPhnNoCtnt  = emerCntcPhnNoCtnt ;
		this.outImdgPckCd1  = outImdgPckCd1 ;
		this.outImdgPckQty1  = outImdgPckQty1 ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dg_rider", getDgRider());		
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());		
		this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());		
		this.hashColumns.put("net_wgt", getNetWgt());		
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());		
		this.hashColumns.put("dcgo_sts_cd", getDcgoStsCd());		
		this.hashColumns.put("emer_cntc_pson_nm", getEmerCntcPsonNm());		
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("spcl_stwg_rqst_desc", getSpclStwgRqstDesc());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("hzd_desc", getHzdDesc());		
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());		
		this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());		
		this.hashColumns.put("grs_wgt", getGrsWgt());		
		this.hashColumns.put("imdg_un_no", getImdgUnNo());		
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());		
		this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());		
		this.hashColumns.put("dg_cntr_seq", getDgCntrSeq());		
		this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());		
		this.hashColumns.put("dcgo_seq", getDcgoSeq());		
		this.hashColumns.put("emer_cntc_phn_no_ctnt", getEmerCntcPhnNoCtnt());		
		this.hashColumns.put("out_imdg_pck_cd1", getOutImdgPckCd1());		
		this.hashColumns.put("out_imdg_pck_qty1", getOutImdgPckQty1());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("dg_rider", "dgRider");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
		this.hashFields.put("net_wgt", "netWgt");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("dcgo_sts_cd", "dcgoStsCd");
		this.hashFields.put("emer_cntc_pson_nm", "emerCntcPsonNm");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("spcl_stwg_rqst_desc", "spclStwgRqstDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("hzd_desc", "hzdDesc");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
		this.hashFields.put("dg_cntr_seq", "dgCntrSeq");
		this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
		this.hashFields.put("dcgo_seq", "dcgoSeq");
		this.hashFields.put("emer_cntc_phn_no_ctnt", "emerCntcPhnNoCtnt");
		this.hashFields.put("out_imdg_pck_cd1", "outImdgPckCd1");
		this.hashFields.put("out_imdg_pck_qty1", "outImdgPckQty1");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  dgRider
	*/
	public void	setDgRider( String	dgRider ) {
		this.dgRider =	dgRider;
	}
 
	/**
	 * Column Info
	 * @return	dgRider
	 */
	 public	String	getDgRider() {
		 return	this.dgRider;
	 } 
 	/**
	* Column Info
	* @param  imdgPckGrpCd
	*/
	public void	setImdgPckGrpCd( String	imdgPckGrpCd ) {
		this.imdgPckGrpCd =	imdgPckGrpCd;
	}
 
	/**
	 * Column Info
	 * @return	imdgPckGrpCd
	 */
	 public	String	getImdgPckGrpCd() {
		 return	this.imdgPckGrpCd;
	 } 
 	/**
	* Column Info
	* @param  flshPntCdoTemp
	*/
	public void	setFlshPntCdoTemp( String	flshPntCdoTemp ) {
		this.flshPntCdoTemp =	flshPntCdoTemp;
	}
 
	/**
	 * Column Info
	 * @return	flshPntCdoTemp
	 */
	 public	String	getFlshPntCdoTemp() {
		 return	this.flshPntCdoTemp;
	 } 
 	/**
	* Column Info
	* @param  netWgt
	*/
	public void	setNetWgt( String	netWgt ) {
		this.netWgt =	netWgt;
	}
 
	/**
	 * Column Info
	 * @return	netWgt
	 */
	 public	String	getNetWgt() {
		 return	this.netWgt;
	 } 
 	/**
	* Column Info
	* @param  imdgUnNoSeq
	*/
	public void	setImdgUnNoSeq( String	imdgUnNoSeq ) {
		this.imdgUnNoSeq =	imdgUnNoSeq;
	}
 
	/**
	 * Column Info
	 * @return	imdgUnNoSeq
	 */
	 public	String	getImdgUnNoSeq() {
		 return	this.imdgUnNoSeq;
	 } 
 	/**
	* Column Info
	* @param  dcgoStsCd
	*/
	public void	setDcgoStsCd( String	dcgoStsCd ) {
		this.dcgoStsCd =	dcgoStsCd;
	}
 
	/**
	 * Column Info
	 * @return	dcgoStsCd
	 */
	 public	String	getDcgoStsCd() {
		 return	this.dcgoStsCd;
	 } 
 	/**
	* Column Info
	* @param  emerCntcPsonNm
	*/
	public void	setEmerCntcPsonNm( String	emerCntcPsonNm ) {
		this.emerCntcPsonNm =	emerCntcPsonNm;
	}
 
	/**
	 * Column Info
	 * @return	emerCntcPsonNm
	 */
	 public	String	getEmerCntcPsonNm() {
		 return	this.emerCntcPsonNm;
	 } 
 	/**
	* Column Info
	* @param  cntrCgoSeq
	*/
	public void	setCntrCgoSeq( String	cntrCgoSeq ) {
		this.cntrCgoSeq =	cntrCgoSeq;
	}
 
	/**
	 * Column Info
	 * @return	cntrCgoSeq
	 */
	 public	String	getCntrCgoSeq() {
		 return	this.cntrCgoSeq;
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
	 public	String	getPagerows() {
		 return	this.pagerows;
	 } 
 	/**
	* Column Info
	* @param  spclStwgRqstDesc
	*/
	public void	setSpclStwgRqstDesc( String	spclStwgRqstDesc ) {
		this.spclStwgRqstDesc =	spclStwgRqstDesc;
	}
 
	/**
	 * Column Info
	 * @return	spclStwgRqstDesc
	 */
	 public	String	getSpclStwgRqstDesc() {
		 return	this.spclStwgRqstDesc;
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
	 public	String	getIbflag() {
		 return	this.ibflag;
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
	 public	String	getCntrNo() {
		 return	this.cntrNo;
	 } 
 	/**
	* Column Info
	* @param  wgtUtCd
	*/
	public void	setWgtUtCd( String	wgtUtCd ) {
		this.wgtUtCd =	wgtUtCd;
	}
 
	/**
	 * Column Info
	 * @return	wgtUtCd
	 */
	 public	String	getWgtUtCd() {
		 return	this.wgtUtCd;
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
	 public	String	getCntrTpszCd() {
		 return	this.cntrTpszCd;
	 } 
 	/**
	* Column Info
	* @param  hzdDesc
	*/
	public void	setHzdDesc( String	hzdDesc ) {
		this.hzdDesc =	hzdDesc;
	}
 
	/**
	 * Column Info
	 * @return	hzdDesc
	 */
	 public	String	getHzdDesc() {
		 return	this.hzdDesc;
	 } 
 	/**
	* Column Info
	* @param  prpShpNm
	*/
	public void	setPrpShpNm( String	prpShpNm ) {
		this.prpShpNm =	prpShpNm;
	}
 
	/**
	 * Column Info
	 * @return	prpShpNm
	 */
	 public	String	getPrpShpNm() {
		 return	this.prpShpNm;
	 } 
 	/**
	* Column Info
	* @param  mrnPolutFlg
	*/
	public void	setMrnPolutFlg( String	mrnPolutFlg ) {
		this.mrnPolutFlg =	mrnPolutFlg;
	}
 
	/**
	 * Column Info
	 * @return	mrnPolutFlg
	 */
	 public	String	getMrnPolutFlg() {
		 return	this.mrnPolutFlg;
	 } 
 	/**
	* Column Info
	* @param  grsWgt
	*/
	public void	setGrsWgt( String	grsWgt ) {
		this.grsWgt =	grsWgt;
	}
 
	/**
	 * Column Info
	 * @return	grsWgt
	 */
	 public	String	getGrsWgt() {
		 return	this.grsWgt;
	 } 
 	/**
	* Column Info
	* @param  imdgUnNo
	*/
	public void	setImdgUnNo( String	imdgUnNo ) {
		this.imdgUnNo =	imdgUnNo;
	}
 
	/**
	 * Column Info
	 * @return	imdgUnNo
	 */
	 public	String	getImdgUnNo() {
		 return	this.imdgUnNo;
	 } 
 	/**
	* Column Info
	* @param  imdgClssCd
	*/
	public void	setImdgClssCd( String	imdgClssCd ) {
		this.imdgClssCd =	imdgClssCd;
	}
 
	/**
	 * Column Info
	 * @return	imdgClssCd
	 */
	 public	String	getImdgClssCd() {
		 return	this.imdgClssCd;
	 } 
 	/**
	* Column Info
	* @param  imdgLmtQtyFlg
	*/
	public void	setImdgLmtQtyFlg( String	imdgLmtQtyFlg ) {
		this.imdgLmtQtyFlg =	imdgLmtQtyFlg;
	}
 
	/**
	 * Column Info
	 * @return	imdgLmtQtyFlg
	 */
	 public	String	getImdgLmtQtyFlg() {
		 return	this.imdgLmtQtyFlg;
	 } 
 	/**
	* Column Info
	* @param  dgCntrSeq
	*/
	public void	setDgCntrSeq( String	dgCntrSeq ) {
		this.dgCntrSeq =	dgCntrSeq;
	}
 
	/**
	 * Column Info
	 * @return	dgCntrSeq
	 */
	 public	String	getDgCntrSeq() {
		 return	this.dgCntrSeq;
	 } 
 	/**
	* Column Info
	* @param  imdgCompGrpCd
	*/
	public void	setImdgCompGrpCd( String	imdgCompGrpCd ) {
		this.imdgCompGrpCd =	imdgCompGrpCd;
	}
 
	/**
	 * Column Info
	 * @return	imdgCompGrpCd
	 */
	 public	String	getImdgCompGrpCd() {
		 return	this.imdgCompGrpCd;
	 } 
 	/**
	* Column Info
	* @param  dcgoSeq
	*/
	public void	setDcgoSeq( String	dcgoSeq ) {
		this.dcgoSeq =	dcgoSeq;
	}
 
	/**
	 * Column Info
	 * @return	dcgoSeq
	 */
	 public	String	getDcgoSeq() {
		 return	this.dcgoSeq;
	 } 
 	/**
	* Column Info
	* @param  emerCntcPhnNoCtnt
	*/
	public void	setEmerCntcPhnNoCtnt( String	emerCntcPhnNoCtnt ) {
		this.emerCntcPhnNoCtnt =	emerCntcPhnNoCtnt;
	}
 
	/**
	 * Column Info
	 * @return	emerCntcPhnNoCtnt
	 */
	 public	String	getEmerCntcPhnNoCtnt() {
		 return	this.emerCntcPhnNoCtnt;
	 } 
 	/**
	* Column Info
	* @param  outImdgPckCd1
	*/
	public void	setOutImdgPckCd1( String	outImdgPckCd1 ) {
		this.outImdgPckCd1 =	outImdgPckCd1;
	}
 
	/**
	 * Column Info
	 * @return	outImdgPckCd1
	 */
	 public	String	getOutImdgPckCd1() {
		 return	this.outImdgPckCd1;
	 } 
 	/**
	* Column Info
	* @param  outImdgPckQty1
	*/
	public void	setOutImdgPckQty1( String	outImdgPckQty1 ) {
		this.outImdgPckQty1 =	outImdgPckQty1;
	}
 
	/**
	 * Column Info
	 * @return	outImdgPckQty1
	 */
	 public	String	getOutImdgPckQty1() {
		 return	this.outImdgPckQty1;
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
		setDgRider(JSPUtil.getParameter(request,	prefix + "dg_rider", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request,	prefix + "imdg_pck_grp_cd", ""));
		setFlshPntCdoTemp(JSPUtil.getParameter(request,	prefix + "flsh_pnt_cdo_temp", ""));
		setNetWgt(JSPUtil.getParameter(request,	prefix + "net_wgt", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request,	prefix + "imdg_un_no_seq", ""));
		setDcgoStsCd(JSPUtil.getParameter(request,	prefix + "dcgo_sts_cd", ""));
		setEmerCntcPsonNm(JSPUtil.getParameter(request,	prefix + "emer_cntc_pson_nm", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request,	prefix + "cntr_cgo_seq", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setSpclStwgRqstDesc(JSPUtil.getParameter(request,	prefix + "spcl_stwg_rqst_desc", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setWgtUtCd(JSPUtil.getParameter(request,	prefix + "wgt_ut_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setHzdDesc(JSPUtil.getParameter(request,	prefix + "hzd_desc", ""));
		setPrpShpNm(JSPUtil.getParameter(request,	prefix + "prp_shp_nm", ""));
		setMrnPolutFlg(JSPUtil.getParameter(request,	prefix + "mrn_polut_flg", ""));
		setGrsWgt(JSPUtil.getParameter(request,	prefix + "grs_wgt", ""));
		setImdgUnNo(JSPUtil.getParameter(request,	prefix + "imdg_un_no", ""));
		setImdgClssCd(JSPUtil.getParameter(request,	prefix + "imdg_clss_cd", ""));
		setImdgLmtQtyFlg(JSPUtil.getParameter(request,	prefix + "imdg_lmt_qty_flg", ""));
		setDgCntrSeq(JSPUtil.getParameter(request,	prefix + "dg_cntr_seq", ""));
		setImdgCompGrpCd(JSPUtil.getParameter(request,	prefix + "imdg_comp_grp_cd", ""));
		setDcgoSeq(JSPUtil.getParameter(request,	prefix + "dcgo_seq", ""));
		setEmerCntcPhnNoCtnt(JSPUtil.getParameter(request,	prefix + "emer_cntc_phn_no_ctnt", ""));
		setOutImdgPckCd1(JSPUtil.getParameter(request,	prefix + "out_imdg_pck_cd1", ""));
		setOutImdgPckQty1(JSPUtil.getParameter(request,	prefix + "out_imdg_pck_qty1", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgXterDgCgoVO[]
	 */
	public BkgXterDgCgoVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgXterDgCgoVO[]
	 */
	public BkgXterDgCgoVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		BkgXterDgCgoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] dgRider =	(JSPUtil.getParameter(request, prefix +	"dg_rider".trim(),	length));
				String[] imdgPckGrpCd =	(JSPUtil.getParameter(request, prefix +	"imdg_pck_grp_cd".trim(),	length));
				String[] flshPntCdoTemp =	(JSPUtil.getParameter(request, prefix +	"flsh_pnt_cdo_temp".trim(),	length));
				String[] netWgt =	(JSPUtil.getParameter(request, prefix +	"net_wgt".trim(),	length));
				String[] imdgUnNoSeq =	(JSPUtil.getParameter(request, prefix +	"imdg_un_no_seq".trim(),	length));
				String[] dcgoStsCd =	(JSPUtil.getParameter(request, prefix +	"dcgo_sts_cd".trim(),	length));
				String[] emerCntcPsonNm =	(JSPUtil.getParameter(request, prefix +	"emer_cntc_pson_nm".trim(),	length));
				String[] cntrCgoSeq =	(JSPUtil.getParameter(request, prefix +	"cntr_cgo_seq".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] spclStwgRqstDesc =	(JSPUtil.getParameter(request, prefix +	"spcl_stwg_rqst_desc".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] wgtUtCd =	(JSPUtil.getParameter(request, prefix +	"wgt_ut_cd".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] hzdDesc =	(JSPUtil.getParameter(request, prefix +	"hzd_desc".trim(),	length));
				String[] prpShpNm =	(JSPUtil.getParameter(request, prefix +	"prp_shp_nm".trim(),	length));
				String[] mrnPolutFlg =	(JSPUtil.getParameter(request, prefix +	"mrn_polut_flg".trim(),	length));
				String[] grsWgt =	(JSPUtil.getParameter(request, prefix +	"grs_wgt".trim(),	length));
				String[] imdgUnNo =	(JSPUtil.getParameter(request, prefix +	"imdg_un_no".trim(),	length));
				String[] imdgClssCd =	(JSPUtil.getParameter(request, prefix +	"imdg_clss_cd".trim(),	length));
				String[] imdgLmtQtyFlg =	(JSPUtil.getParameter(request, prefix +	"imdg_lmt_qty_flg".trim(),	length));
				String[] dgCntrSeq =	(JSPUtil.getParameter(request, prefix +	"dg_cntr_seq".trim(),	length));
				String[] imdgCompGrpCd =	(JSPUtil.getParameter(request, prefix +	"imdg_comp_grp_cd".trim(),	length));
				String[] dcgoSeq =	(JSPUtil.getParameter(request, prefix +	"dcgo_seq".trim(),	length));
				String[] emerCntcPhnNoCtnt =	(JSPUtil.getParameter(request, prefix +	"emer_cntc_phn_no_ctnt".trim(),	length));
				String[] outImdgPckCd1 =	(JSPUtil.getParameter(request, prefix +	"out_imdg_pck_cd1".trim(),	length));
				String[] outImdgPckQty1 =	(JSPUtil.getParameter(request, prefix +	"out_imdg_pck_qty1".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	BkgXterDgCgoVO();
						if ( dgRider[i] !=	null)
						model.setDgRider( dgRider[i]);
						if ( imdgPckGrpCd[i] !=	null)
						model.setImdgPckGrpCd( imdgPckGrpCd[i]);
						if ( flshPntCdoTemp[i] !=	null)
						model.setFlshPntCdoTemp( flshPntCdoTemp[i]);
						if ( netWgt[i] !=	null)
						model.setNetWgt( netWgt[i]);
						if ( imdgUnNoSeq[i] !=	null)
						model.setImdgUnNoSeq( imdgUnNoSeq[i]);
						if ( dcgoStsCd[i] !=	null)
						model.setDcgoStsCd( dcgoStsCd[i]);
						if ( emerCntcPsonNm[i] !=	null)
						model.setEmerCntcPsonNm( emerCntcPsonNm[i]);
						if ( cntrCgoSeq[i] !=	null)
						model.setCntrCgoSeq( cntrCgoSeq[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( spclStwgRqstDesc[i] !=	null)
						model.setSpclStwgRqstDesc( spclStwgRqstDesc[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( wgtUtCd[i] !=	null)
						model.setWgtUtCd( wgtUtCd[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( hzdDesc[i] !=	null)
						model.setHzdDesc( hzdDesc[i]);
						if ( prpShpNm[i] !=	null)
						model.setPrpShpNm( prpShpNm[i]);
						if ( mrnPolutFlg[i] !=	null)
						model.setMrnPolutFlg( mrnPolutFlg[i]);
						if ( grsWgt[i] !=	null)
						model.setGrsWgt( grsWgt[i]);
						if ( imdgUnNo[i] !=	null)
						model.setImdgUnNo( imdgUnNo[i]);
						if ( imdgClssCd[i] !=	null)
						model.setImdgClssCd( imdgClssCd[i]);
						if ( imdgLmtQtyFlg[i] !=	null)
						model.setImdgLmtQtyFlg( imdgLmtQtyFlg[i]);
						if ( dgCntrSeq[i] !=	null)
						model.setDgCntrSeq( dgCntrSeq[i]);
						if ( imdgCompGrpCd[i] !=	null)
						model.setImdgCompGrpCd( imdgCompGrpCd[i]);
						if ( dcgoSeq[i] !=	null)
						model.setDcgoSeq( dcgoSeq[i]);
						if ( emerCntcPhnNoCtnt[i] !=	null)
						model.setEmerCntcPhnNoCtnt( emerCntcPhnNoCtnt[i]);
						if ( outImdgPckCd1[i] !=	null)
						model.setOutImdgPckCd1( outImdgPckCd1[i]);
						if ( outImdgPckQty1[i] !=	null)
						model.setOutImdgPckQty1( outImdgPckQty1[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getBkgXterDgCgoVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return BkgXterDgCgoVO[]
	 */
	public BkgXterDgCgoVO[]	 getBkgXterDgCgoVOs(){
		BkgXterDgCgoVO[] vos = (BkgXterDgCgoVO[])models.toArray(new	BkgXterDgCgoVO[models.size()]);
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
		this.dgRider =	this.dgRider.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd =	this.imdgPckGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshPntCdoTemp =	this.flshPntCdoTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgt =	this.netWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq =	this.imdgUnNoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoStsCd =	this.dcgoStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emerCntcPsonNm =	this.emerCntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq =	this.cntrCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclStwgRqstDesc =	this.spclStwgRqstDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd =	this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hzdDesc =	this.hzdDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm =	this.prpShpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnPolutFlg =	this.mrnPolutFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt =	this.grsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo =	this.imdgUnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd =	this.imdgClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyFlg =	this.imdgLmtQtyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrSeq =	this.dgCntrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCompGrpCd =	this.imdgCompGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSeq =	this.dcgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emerCntcPhnNoCtnt =	this.emerCntcPhnNoCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckCd1 =	this.outImdgPckCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckQty1 =	this.outImdgPckQty1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}