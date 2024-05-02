/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CntrSpecListBrieflyVO.java
 *@FileTitle : CntrSpecListBrieflyVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.03.24
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.03.24  
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
public class CntrSpecListBrieflyVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<CntrSpecListBrieflyVO>  models =	new	ArrayList<CntrSpecListBrieflyVO>();


	/*	Column Info	*/
	private  String	 cntrSpecNo   =  null;
	/*	Column Info	*/
	private  String	 lodCapa   =  null;
	/*	Column Info	*/
	private  String	 opnDorWdt   =  null;
	/*	Column Info	*/
	private  String	 toSpecYr   =  null;
	/*	Column Info	*/
	private  String	 minTemp   =  null;
	/*	Column Info	*/
	private  String	 xterLen   =  null;
	/*	Column Info	*/
	private  String	 rfMdlNm   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ttlActQty   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 fromSpecYr   =  null;
	/*	Column Info	*/
	private  String	 aproTirNo   =  null;
	/*	Column Info	*/
	private  String	 aproUicNo   =  null;
	/*	Column Info	*/
	private  String	 tareWgt   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 ttlLotQty   =  null;
	/*	Column Info	*/
	private  String	 opnDorHgt   =  null;
	/*	Column Info	*/
	private  String	 ownCntrFlg   =  null;
	/*	Column Info	*/
	private  String	 interLen   =  null;
	/*	Column Info	*/
	private  String	 lotNo   =  null;
	/*	Column Info	*/
	private  String	 rcLdbHgt   =  null;
	/*	Column Info	*/
	private  String	 agmtNo   =  null;
	/*	Column Info	*/
	private  String	 serRange   =  null;
	/*	Column Info	*/
	private  String	 interWdt   =  null;
	/*	Column Info	*/
	private  String	 interHgt   =  null;
	/*	Column Info	*/
	private  String	 aproTctNo   =  null;
	/*	Column Info	*/
	private  String	 plstFlrFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrHngrRckFlg   =  null;
	/*	Column Info	*/
	private  String	 maxTemp   =  null;
	/*	Column Info	*/
	private  String	 rfMkrSeq   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 tnkCapa   =  null;
	/*	Column Info	*/
	private  String	 aproCscNo   =  null;
	/*	Column Info	*/
	private  String	 fctrySpecNo   =  null;
	/*	Column Info	*/
	private  String	 xterHgt   =  null;
	/*	Column Info	*/
	private  String	 vndrAbbrNm   =  null;
	/*	Column Info	*/
	private  String	 cntrGrsWgt   =  null;
	/*	Column Info	*/
	private  String	 cntrMtrlCd   =  null;
	/*	Column Info	*/
	private  String	 cntrMtrlNm   =  null;
	/*	Column Info	*/
	private  String	 xterWdt   =  null;
	/*	Column Info	*/
	private  String	 rfRfrNo   =  null;
	/*	Column Info	*/
	private  String	 rcLdbCapa   =  null;
	/*	Column Info	*/
	private  String	 rfTpCd   =  null;
	/*	Column Info	*/
	private  String	 yrBuild   =  null;
	/*	Column Info	*/
	private  String	 vndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 hidVndrSeq   =  null;
	/*	Column Info	*/
	private  String	 rfHumidCtrlValCd   =  null;
	/*	Column Info	*/
	private  String	 rfCmprCtnt   =  null;
	/*	Column Info	*/
	private  String	 frackClpsCtnt   =  null;
	/*	Column Info	*/
	private  String	 frackBedTikCtnt   =  null;
	/*	Column Info	*/
	private  String	 opntpRoofOpnCtnt   =  null;
	/*	Column Info	*/
	private  String	 opntpIntrHgtCtnt   =  null;
	/*	Column Info	*/
	private  String	 opntpRearHdrOpnCtnt   =  null;
	/*	Column Info	*/
	private  String	 schSpecNo   =  null;
	/*	Column Info	*/
	private  String	 schTpszCd   =  null;
	/*	Column Info	*/
	private  String	 zeroActiveQty   =  null;
	/*	Column Info	*/
	private  String	 cntrSpecTypeCd   =  null; 

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public CntrSpecListBrieflyVO(){}

	public CntrSpecListBrieflyVO(String cntrSpecNo,String lodCapa,String opnDorWdt,String toSpecYr,String minTemp,String xterLen,String rfMdlNm,String pagerows,String ttlActQty,String ibflag,String cntrTpszCd,String fromSpecYr,String aproTirNo,String aproUicNo,String tareWgt,String lstmCd,String ttlLotQty,String opnDorHgt,String ownCntrFlg,String interLen,String lotNo,String rcLdbHgt,String agmtNo,String serRange,String interWdt,String interHgt,String aproTctNo,String plstFlrFlg,String cntrHngrRckFlg,String maxTemp,String rfMkrSeq,String vndrSeq,String tnkCapa,String aproCscNo,String fctrySpecNo,String xterHgt,String vndrAbbrNm,String cntrGrsWgt,String cntrMtrlCd,String cntrMtrlNm,String xterWdt,String rfRfrNo,String rcLdbCapa,String rfTpCd,String yrBuild,String vndrLglEngNm,String hidVndrSeq,String rfHumidCtrlValCd,String rfCmprCtnt,String frackClpsCtnt,String frackBedTikCtnt,String opntpRoofOpnCtnt,String opntpIntrHgtCtnt,String opntpRearHdrOpnCtnt,String schSpecNo,String schTpszCd,String zeroActiveQty,String cntrSpecTypeCd)	{
		this.cntrSpecNo  = cntrSpecNo ;
		this.lodCapa  = lodCapa ;
		this.opnDorWdt  = opnDorWdt ;
		this.toSpecYr  = toSpecYr ;
		this.minTemp  = minTemp ;
		this.xterLen  = xterLen ;
		this.rfMdlNm  = rfMdlNm ;
		this.pagerows  = pagerows ;
		this.ttlActQty  = ttlActQty ;
		this.ibflag  = ibflag ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.fromSpecYr  = fromSpecYr ;
		this.aproTirNo  = aproTirNo ;
		this.aproUicNo  = aproUicNo ;
		this.tareWgt  = tareWgt ;
		this.lstmCd  = lstmCd ;
		this.ttlLotQty  = ttlLotQty ;
		this.opnDorHgt  = opnDorHgt ;
		this.ownCntrFlg  = ownCntrFlg ;
		this.interLen  = interLen ;
		this.lotNo  = lotNo ;
		this.rcLdbHgt  = rcLdbHgt ;
		this.agmtNo  = agmtNo ;
		this.serRange  = serRange ;
		this.interWdt  = interWdt ;
		this.interHgt  = interHgt ;
		this.aproTctNo  = aproTctNo ;
		this.plstFlrFlg  = plstFlrFlg ;
		this.cntrHngrRckFlg  = cntrHngrRckFlg ;
		this.maxTemp  = maxTemp ;
		this.rfMkrSeq  = rfMkrSeq ;
		this.vndrSeq  = vndrSeq ;
		this.tnkCapa  = tnkCapa ;
		this.aproCscNo  = aproCscNo ;
		this.fctrySpecNo  = fctrySpecNo ;
		this.xterHgt  = xterHgt ;
		this.vndrAbbrNm  = vndrAbbrNm ;
		this.cntrGrsWgt  = cntrGrsWgt ;
		this.cntrMtrlCd  = cntrMtrlCd ;
		this.cntrMtrlNm  = cntrMtrlNm ;
		this.xterWdt  = xterWdt ;
		this.rfRfrNo  = rfRfrNo ;
		this.rcLdbCapa  = rcLdbCapa ;
		this.rfTpCd  = rfTpCd ;
		this.yrBuild  = yrBuild ;
		this.vndrLglEngNm  = vndrLglEngNm ;
		this.hidVndrSeq  = hidVndrSeq ;
		this.rfHumidCtrlValCd  = rfHumidCtrlValCd ;
		this.rfCmprCtnt  = rfCmprCtnt ;
		this.frackClpsCtnt  = frackClpsCtnt ;
		this.frackBedTikCtnt  = frackBedTikCtnt ;
		this.opntpRoofOpnCtnt  = opntpRoofOpnCtnt ;
		this.opntpIntrHgtCtnt  = opntpIntrHgtCtnt ;
		this.opntpRearHdrOpnCtnt  = opntpRearHdrOpnCtnt ;
		this.schSpecNo  = schSpecNo ;
		this.schTpszCd  = schTpszCd ;
		this.zeroActiveQty  = zeroActiveQty ;
		this.cntrSpecTypeCd  = cntrSpecTypeCd ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_spec_no", getCntrSpecNo());		
		this.hashColumns.put("lod_capa", getLodCapa());		
		this.hashColumns.put("opn_dor_wdt", getOpnDorWdt());		
		this.hashColumns.put("to_spec_yr", getToSpecYr());		
		this.hashColumns.put("min_temp", getMinTemp());		
		this.hashColumns.put("xter_len", getXterLen());		
		this.hashColumns.put("rf_mdl_nm", getRfMdlNm());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ttl_act_qty", getTtlActQty());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("from_spec_yr", getFromSpecYr());		
		this.hashColumns.put("apro_tir_no", getAproTirNo());		
		this.hashColumns.put("apro_uic_no", getAproUicNo());		
		this.hashColumns.put("tare_wgt", getTareWgt());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("ttl_lot_qty", getTtlLotQty());		
		this.hashColumns.put("opn_dor_hgt", getOpnDorHgt());		
		this.hashColumns.put("own_cntr_flg", getOwnCntrFlg());		
		this.hashColumns.put("inter_len", getInterLen());		
		this.hashColumns.put("lot_no", getLotNo());		
		this.hashColumns.put("rc_ldb_hgt", getRcLdbHgt());		
		this.hashColumns.put("agmt_no", getAgmtNo());		
		this.hashColumns.put("ser_range", getSerRange());		
		this.hashColumns.put("inter_wdt", getInterWdt());		
		this.hashColumns.put("inter_hgt", getInterHgt());		
		this.hashColumns.put("apro_tct_no", getAproTctNo());		
		this.hashColumns.put("plst_flr_flg", getPlstFlrFlg());		
		this.hashColumns.put("cntr_hngr_rck_flg", getCntrHngrRckFlg());		
		this.hashColumns.put("max_temp", getMaxTemp());		
		this.hashColumns.put("rf_mkr_seq", getRfMkrSeq());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("tnk_capa", getTnkCapa());		
		this.hashColumns.put("apro_csc_no", getAproCscNo());		
		this.hashColumns.put("fctry_spec_no", getFctrySpecNo());		
		this.hashColumns.put("xter_hgt", getXterHgt());		
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());		
		this.hashColumns.put("cntr_grs_wgt", getCntrGrsWgt());		
		this.hashColumns.put("cntr_mtrl_cd", getCntrMtrlCd());		
		this.hashColumns.put("cntr_mtrl_nm", getCntrMtrlNm());		
		this.hashColumns.put("xter_wdt", getXterWdt());		
		this.hashColumns.put("rf_rfr_no", getRfRfrNo());		
		this.hashColumns.put("rc_ldb_capa", getRcLdbCapa());		
		this.hashColumns.put("rf_tp_cd", getRfTpCd());		
		this.hashColumns.put("yr_build", getYrBuild());		
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());		
		this.hashColumns.put("hid_vndr_seq", getHidVndrSeq());		
		this.hashColumns.put("rf_humid_ctrl_val_cd", getRfHumidCtrlValCd());		
		this.hashColumns.put("rf_cmpr_ctnt", getRfCmprCtnt());		
		this.hashColumns.put("frack_clps_ctnt", getFrackClpsCtnt());		
		this.hashColumns.put("frack_bed_tik_ctnt", getFrackBedTikCtnt());		
		this.hashColumns.put("opntp_roof_opn_ctnt", getOpntpRoofOpnCtnt());		
		this.hashColumns.put("opntp_intr_hgt_ctnt", getOpntpIntrHgtCtnt());		
		this.hashColumns.put("opntp_rear_hdr_opn_ctnt", getOpntpRearHdrOpnCtnt());		
		this.hashColumns.put("sch_spec_no", getSchSpecNo());		
		this.hashColumns.put("sch_tpsz_cd", getSchTpszCd());
		this.hashColumns.put("zero_active_qty", getZeroActiveQty());
		this.hashColumns.put("cntr_spec_type_cd", getCntrSpecTypeCd());
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("cntr_spec_no", "cntrSpecNo");
		this.hashFields.put("lod_capa", "lodCapa");
		this.hashFields.put("opn_dor_wdt", "opnDorWdt");
		this.hashFields.put("to_spec_yr", "toSpecYr");
		this.hashFields.put("min_temp", "minTemp");
		this.hashFields.put("xter_len", "xterLen");
		this.hashFields.put("rf_mdl_nm", "rfMdlNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ttl_act_qty", "ttlActQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("from_spec_yr", "fromSpecYr");
		this.hashFields.put("apro_tir_no", "aproTirNo");
		this.hashFields.put("apro_uic_no", "aproUicNo");
		this.hashFields.put("tare_wgt", "tareWgt");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("ttl_lot_qty", "ttlLotQty");
		this.hashFields.put("opn_dor_hgt", "opnDorHgt");
		this.hashFields.put("own_cntr_flg", "ownCntrFlg");
		this.hashFields.put("inter_len", "interLen");
		this.hashFields.put("lot_no", "lotNo");
		this.hashFields.put("rc_ldb_hgt", "rcLdbHgt");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("ser_range", "serRange");
		this.hashFields.put("inter_wdt", "interWdt");
		this.hashFields.put("inter_hgt", "interHgt");
		this.hashFields.put("apro_tct_no", "aproTctNo");
		this.hashFields.put("plst_flr_flg", "plstFlrFlg");
		this.hashFields.put("cntr_hngr_rck_flg", "cntrHngrRckFlg");
		this.hashFields.put("max_temp", "maxTemp");
		this.hashFields.put("rf_mkr_seq", "rfMkrSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("tnk_capa", "tnkCapa");
		this.hashFields.put("apro_csc_no", "aproCscNo");
		this.hashFields.put("fctry_spec_no", "fctrySpecNo");
		this.hashFields.put("xter_hgt", "xterHgt");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("cntr_grs_wgt", "cntrGrsWgt");
		this.hashFields.put("cntr_mtrl_cd", "cntrMtrlCd");
		this.hashFields.put("cntr_mtrl_nm", "cntrMtrlNm");
		this.hashFields.put("xter_wdt", "xterWdt");
		this.hashFields.put("rf_rfr_no", "rfRfrNo");
		this.hashFields.put("rc_ldb_capa", "rcLdbCapa");
		this.hashFields.put("rf_tp_cd", "rfTpCd");
		this.hashFields.put("yr_build", "yrBuild");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("hid_vndr_seq", "hidVndrSeq");
		this.hashFields.put("rf_humid_ctrl_val_cd", "rfHumidCtrlValCd");
		this.hashFields.put("rf_cmpr_ctnt", "rfCmprCtnt");
		this.hashFields.put("frack_clps_ctnt", "frackClpsCtnt");
		this.hashFields.put("frack_bed_tik_ctnt", "frackBedTikCtnt");
		this.hashFields.put("opntp_roof_opn_ctnt", "opntpRoofOpnCtnt");
		this.hashFields.put("opntp_intr_hgt_ctnt", "opntpIntrHgtCtnt");
		this.hashFields.put("opntp_rear_hdr_opn_ctnt", "opntpRearHdrOpnCtnt");
		this.hashFields.put("sch_spec_no", "schSpecNo");
		this.hashFields.put("sch_tpsz_cd", "schTpszCd");
		this.hashFields.put("zero_active_qty", "zeroActiveQty");
		this.hashFields.put("cntr_spec_type_cd", "cntrSpecTypeCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  cntrSpecNo
	*/
	public void	setCntrSpecNo( String	cntrSpecNo ) {
		this.cntrSpecNo =	cntrSpecNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrSpecNo
	 */
	 public	 String	getCntrSpecNo() {
		 return	this.cntrSpecNo;
	 } 
 	/**
	* Column Info
	* @param  lodCapa
	*/
	public void	setLodCapa( String	lodCapa ) {
		this.lodCapa =	lodCapa;
	}
 
	/**
	 * Column Info
	 * @return	lodCapa
	 */
	 public	 String	getLodCapa() {
		 return	this.lodCapa;
	 } 
 	/**
	* Column Info
	* @param  opnDorWdt
	*/
	public void	setOpnDorWdt( String	opnDorWdt ) {
		this.opnDorWdt =	opnDorWdt;
	}
 
	/**
	 * Column Info
	 * @return	opnDorWdt
	 */
	 public	 String	getOpnDorWdt() {
		 return	this.opnDorWdt;
	 } 
 	/**
	* Column Info
	* @param  toSpecYr
	*/
	public void	setToSpecYr( String	toSpecYr ) {
		this.toSpecYr =	toSpecYr;
	}
 
	/**
	 * Column Info
	 * @return	toSpecYr
	 */
	 public	 String	getToSpecYr() {
		 return	this.toSpecYr;
	 } 
 	/**
	* Column Info
	* @param  minTemp
	*/
	public void	setMinTemp( String	minTemp ) {
		this.minTemp =	minTemp;
	}
 
	/**
	 * Column Info
	 * @return	minTemp
	 */
	 public	 String	getMinTemp() {
		 return	this.minTemp;
	 } 
 	/**
	* Column Info
	* @param  xterLen
	*/
	public void	setXterLen( String	xterLen ) {
		this.xterLen =	xterLen;
	}
 
	/**
	 * Column Info
	 * @return	xterLen
	 */
	 public	 String	getXterLen() {
		 return	this.xterLen;
	 } 
 	/**
	* Column Info
	* @param  rfMdlNm
	*/
	public void	setRfMdlNm( String	rfMdlNm ) {
		this.rfMdlNm =	rfMdlNm;
	}
 
	/**
	 * Column Info
	 * @return	rfMdlNm
	 */
	 public	 String	getRfMdlNm() {
		 return	this.rfMdlNm;
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
	* @param  ttlActQty
	*/
	public void	setTtlActQty( String	ttlActQty ) {
		this.ttlActQty =	ttlActQty;
	}
 
	/**
	 * Column Info
	 * @return	ttlActQty
	 */
	 public	 String	getTtlActQty() {
		 return	this.ttlActQty;
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
	* @param  fromSpecYr
	*/
	public void	setFromSpecYr( String	fromSpecYr ) {
		this.fromSpecYr =	fromSpecYr;
	}
 
	/**
	 * Column Info
	 * @return	fromSpecYr
	 */
	 public	 String	getFromSpecYr() {
		 return	this.fromSpecYr;
	 } 
 	/**
	* Column Info
	* @param  aproTirNo
	*/
	public void	setAproTirNo( String	aproTirNo ) {
		this.aproTirNo =	aproTirNo;
	}
 
	/**
	 * Column Info
	 * @return	aproTirNo
	 */
	 public	 String	getAproTirNo() {
		 return	this.aproTirNo;
	 } 
 	/**
	* Column Info
	* @param  aproUicNo
	*/
	public void	setAproUicNo( String	aproUicNo ) {
		this.aproUicNo =	aproUicNo;
	}
 
	/**
	 * Column Info
	 * @return	aproUicNo
	 */
	 public	 String	getAproUicNo() {
		 return	this.aproUicNo;
	 } 
 	/**
	* Column Info
	* @param  tareWgt
	*/
	public void	setTareWgt( String	tareWgt ) {
		this.tareWgt =	tareWgt;
	}
 
	/**
	 * Column Info
	 * @return	tareWgt
	 */
	 public	 String	getTareWgt() {
		 return	this.tareWgt;
	 } 
 	/**
	* Column Info
	* @param  lstmCd
	*/
	public void	setLstmCd( String	lstmCd ) {
		this.lstmCd =	lstmCd;
	}
 
	/**
	 * Column Info
	 * @return	lstmCd
	 */
	 public	 String	getLstmCd() {
		 return	this.lstmCd;
	 } 
 	/**
	* Column Info
	* @param  ttlLotQty
	*/
	public void	setTtlLotQty( String	ttlLotQty ) {
		this.ttlLotQty =	ttlLotQty;
	}
 
	/**
	 * Column Info
	 * @return	ttlLotQty
	 */
	 public	 String	getTtlLotQty() {
		 return	this.ttlLotQty;
	 } 
 	/**
	* Column Info
	* @param  opnDorHgt
	*/
	public void	setOpnDorHgt( String	opnDorHgt ) {
		this.opnDorHgt =	opnDorHgt;
	}
 
	/**
	 * Column Info
	 * @return	opnDorHgt
	 */
	 public	 String	getOpnDorHgt() {
		 return	this.opnDorHgt;
	 } 
 	/**
	* Column Info
	* @param  ownCntrFlg
	*/
	public void	setOwnCntrFlg( String	ownCntrFlg ) {
		this.ownCntrFlg =	ownCntrFlg;
	}
 
	/**
	 * Column Info
	 * @return	ownCntrFlg
	 */
	 public	 String	getOwnCntrFlg() {
		 return	this.ownCntrFlg;
	 } 
 	/**
	* Column Info
	* @param  interLen
	*/
	public void	setInterLen( String	interLen ) {
		this.interLen =	interLen;
	}
 
	/**
	 * Column Info
	 * @return	interLen
	 */
	 public	 String	getInterLen() {
		 return	this.interLen;
	 } 
 	/**
	* Column Info
	* @param  lotNo
	*/
	public void	setLotNo( String	lotNo ) {
		this.lotNo =	lotNo;
	}
 
	/**
	 * Column Info
	 * @return	lotNo
	 */
	 public	 String	getLotNo() {
		 return	this.lotNo;
	 } 
 	/**
	* Column Info
	* @param  rcLdbHgt
	*/
	public void	setRcLdbHgt( String	rcLdbHgt ) {
		this.rcLdbHgt =	rcLdbHgt;
	}
 
	/**
	 * Column Info
	 * @return	rcLdbHgt
	 */
	 public	 String	getRcLdbHgt() {
		 return	this.rcLdbHgt;
	 } 
 	/**
	* Column Info
	* @param  agmtNo
	*/
	public void	setAgmtNo( String	agmtNo ) {
		this.agmtNo =	agmtNo;
	}
 
	/**
	 * Column Info
	 * @return	agmtNo
	 */
	 public	 String	getAgmtNo() {
		 return	this.agmtNo;
	 } 
 	/**
	* Column Info
	* @param  serRange
	*/
	public void	setSerRange( String	serRange ) {
		this.serRange =	serRange;
	}
 
	/**
	 * Column Info
	 * @return	serRange
	 */
	 public	 String	getSerRange() {
		 return	this.serRange;
	 } 
 	/**
	* Column Info
	* @param  interWdt
	*/
	public void	setInterWdt( String	interWdt ) {
		this.interWdt =	interWdt;
	}
 
	/**
	 * Column Info
	 * @return	interWdt
	 */
	 public	 String	getInterWdt() {
		 return	this.interWdt;
	 } 
 	/**
	* Column Info
	* @param  interHgt
	*/
	public void	setInterHgt( String	interHgt ) {
		this.interHgt =	interHgt;
	}
 
	/**
	 * Column Info
	 * @return	interHgt
	 */
	 public	 String	getInterHgt() {
		 return	this.interHgt;
	 } 
 	/**
	* Column Info
	* @param  aproTctNo
	*/
	public void	setAproTctNo( String	aproTctNo ) {
		this.aproTctNo =	aproTctNo;
	}
 
	/**
	 * Column Info
	 * @return	aproTctNo
	 */
	 public	 String	getAproTctNo() {
		 return	this.aproTctNo;
	 } 
 	/**
	* Column Info
	* @param  plstFlrFlg
	*/
	public void	setPlstFlrFlg( String	plstFlrFlg ) {
		this.plstFlrFlg =	plstFlrFlg;
	}
 
	/**
	 * Column Info
	 * @return	plstFlrFlg
	 */
	 public	 String	getPlstFlrFlg() {
		 return	this.plstFlrFlg;
	 } 
 	/**
	* Column Info
	* @param  cntrHngrRckFlg
	*/
	public void	setCntrHngrRckFlg( String	cntrHngrRckFlg ) {
		this.cntrHngrRckFlg =	cntrHngrRckFlg;
	}
 
	/**
	 * Column Info
	 * @return	cntrHngrRckFlg
	 */
	 public	 String	getCntrHngrRckFlg() {
		 return	this.cntrHngrRckFlg;
	 } 
 	/**
	* Column Info
	* @param  maxTemp
	*/
	public void	setMaxTemp( String	maxTemp ) {
		this.maxTemp =	maxTemp;
	}
 
	/**
	 * Column Info
	 * @return	maxTemp
	 */
	 public	 String	getMaxTemp() {
		 return	this.maxTemp;
	 } 
 	/**
	* Column Info
	* @param  rfMkrSeq
	*/
	public void	setRfMkrSeq( String	rfMkrSeq ) {
		this.rfMkrSeq =	rfMkrSeq;
	}
 
	/**
	 * Column Info
	 * @return	rfMkrSeq
	 */
	 public	 String	getRfMkrSeq() {
		 return	this.rfMkrSeq;
	 } 
 	/**
	* Column Info
	* @param  vndrSeq
	*/
	public void	setVndrSeq( String	vndrSeq ) {
		this.vndrSeq =	vndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	vndrSeq
	 */
	 public	 String	getVndrSeq() {
		 return	this.vndrSeq;
	 } 
 	/**
	* Column Info
	* @param  tnkCapa
	*/
	public void	setTnkCapa( String	tnkCapa ) {
		this.tnkCapa =	tnkCapa;
	}
 
	/**
	 * Column Info
	 * @return	tnkCapa
	 */
	 public	 String	getTnkCapa() {
		 return	this.tnkCapa;
	 } 
 	/**
	* Column Info
	* @param  aproCscNo
	*/
	public void	setAproCscNo( String	aproCscNo ) {
		this.aproCscNo =	aproCscNo;
	}
 
	/**
	 * Column Info
	 * @return	aproCscNo
	 */
	 public	 String	getAproCscNo() {
		 return	this.aproCscNo;
	 } 
 	/**
	* Column Info
	* @param  fctrySpecNo
	*/
	public void	setFctrySpecNo( String	fctrySpecNo ) {
		this.fctrySpecNo =	fctrySpecNo;
	}
 
	/**
	 * Column Info
	 * @return	fctrySpecNo
	 */
	 public	 String	getFctrySpecNo() {
		 return	this.fctrySpecNo;
	 } 
 	/**
	* Column Info
	* @param  xterHgt
	*/
	public void	setXterHgt( String	xterHgt ) {
		this.xterHgt =	xterHgt;
	}
 
	/**
	 * Column Info
	 * @return	xterHgt
	 */
	 public	 String	getXterHgt() {
		 return	this.xterHgt;
	 } 
 	/**
	* Column Info
	* @param  vndrAbbrNm
	*/
	public void	setVndrAbbrNm( String	vndrAbbrNm ) {
		this.vndrAbbrNm =	vndrAbbrNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrAbbrNm
	 */
	 public	 String	getVndrAbbrNm() {
		 return	this.vndrAbbrNm;
	 } 
 	/**
	* Column Info
	* @param  cntrGrsWgt
	*/
	public void	setCntrGrsWgt( String	cntrGrsWgt ) {
		this.cntrGrsWgt =	cntrGrsWgt;
	}
 
	/**
	 * Column Info
	 * @return	cntrGrsWgt
	 */
	 public	 String	getCntrGrsWgt() {
		 return	this.cntrGrsWgt;
	 } 
 	/**
	* Column Info
	* @param  cntrMtrlCd
	*/
	public void	setCntrMtrlCd( String	cntrMtrlCd ) {
		this.cntrMtrlCd =	cntrMtrlCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrMtrlCd
	 */
	 public	 String	getCntrMtrlCd() {
		 return	this.cntrMtrlCd;
	 } 
 	/**
	* Column Info
	* @param  cntrMtrlNm
	*/
	public void	setCntrMtrlNm( String	cntrMtrlNm ) {
		this.cntrMtrlNm =	cntrMtrlNm;
	}
 
	/**
	 * Column Info
	 * @return	cntrMtrlNm
	 */
	 public	 String	getCntrMtrlNm() {
		 return	this.cntrMtrlNm;
	 } 
 	/**
	* Column Info
	* @param  xterWdt
	*/
	public void	setXterWdt( String	xterWdt ) {
		this.xterWdt =	xterWdt;
	}
 
	/**
	 * Column Info
	 * @return	xterWdt
	 */
	 public	 String	getXterWdt() {
		 return	this.xterWdt;
	 } 
 	/**
	* Column Info
	* @param  rfRfrNo
	*/
	public void	setRfRfrNo( String	rfRfrNo ) {
		this.rfRfrNo =	rfRfrNo;
	}
 
	/**
	 * Column Info
	 * @return	rfRfrNo
	 */
	 public	 String	getRfRfrNo() {
		 return	this.rfRfrNo;
	 } 
 	/**
	* Column Info
	* @param  rcLdbCapa
	*/
	public void	setRcLdbCapa( String	rcLdbCapa ) {
		this.rcLdbCapa =	rcLdbCapa;
	}
 
	/**
	 * Column Info
	 * @return	rcLdbCapa
	 */
	 public	 String	getRcLdbCapa() {
		 return	this.rcLdbCapa;
	 } 
 	/**
	* Column Info
	* @param  rfTpCd
	*/
	public void	setRfTpCd( String	rfTpCd ) {
		this.rfTpCd =	rfTpCd;
	}
 
	/**
	 * Column Info
	 * @return	rfTpCd
	 */
	 public	 String	getRfTpCd() {
		 return	this.rfTpCd;
	 } 
 	/**
	* Column Info
	* @param  yrBuild
	*/
	public void	setYrBuild( String	yrBuild ) {
		this.yrBuild =	yrBuild;
	}
 
	/**
	 * Column Info
	 * @return	yrBuild
	 */
	 public	 String	getYrBuild() {
		 return	this.yrBuild;
	 } 
 	/**
	* Column Info
	* @param  vndrLglEngNm
	*/
	public void	setVndrLglEngNm( String	vndrLglEngNm ) {
		this.vndrLglEngNm =	vndrLglEngNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrLglEngNm
	 */
	 public	 String	getVndrLglEngNm() {
		 return	this.vndrLglEngNm;
	 } 
 	/**
	* Column Info
	* @param  hidVndrSeq
	*/
	public void	setHidVndrSeq( String	hidVndrSeq ) {
		this.hidVndrSeq =	hidVndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	hidVndrSeq
	 */
	 public	 String	getHidVndrSeq() {
		 return	this.hidVndrSeq;
	 } 
 	/**
	* Column Info
	* @param  rfHumidCtrlValCd
	*/
	public void	setRfHumidCtrlValCd( String	rfHumidCtrlValCd ) {
		this.rfHumidCtrlValCd =	rfHumidCtrlValCd;
	}
 
	/**
	 * Column Info
	 * @return	rfHumidCtrlValCd
	 */
	 public	 String	getRfHumidCtrlValCd() {
		 return	this.rfHumidCtrlValCd;
	 } 
 	/**
	* Column Info
	* @param  rfCmprCtnt
	*/
	public void	setRfCmprCtnt( String	rfCmprCtnt ) {
		this.rfCmprCtnt =	rfCmprCtnt;
	}
 
	/**
	 * Column Info
	 * @return	rfCmprCtnt
	 */
	 public	 String	getRfCmprCtnt() {
		 return	this.rfCmprCtnt;
	 } 
 	/**
	* Column Info
	* @param  frackClpsCtnt
	*/
	public void	setFrackClpsCtnt( String	frackClpsCtnt ) {
		this.frackClpsCtnt =	frackClpsCtnt;
	}
 
	/**
	 * Column Info
	 * @return	frackClpsCtnt
	 */
	 public	 String	getFrackClpsCtnt() {
		 return	this.frackClpsCtnt;
	 } 
 	/**
	* Column Info
	* @param  frackBedTikCtnt
	*/
	public void	setFrackBedTikCtnt( String	frackBedTikCtnt ) {
		this.frackBedTikCtnt =	frackBedTikCtnt;
	}
 
	/**
	 * Column Info
	 * @return	frackBedTikCtnt
	 */
	 public	 String	getFrackBedTikCtnt() {
		 return	this.frackBedTikCtnt;
	 } 
 	/**
	* Column Info
	* @param  opntpRoofOpnCtnt
	*/
	public void	setOpntpRoofOpnCtnt( String	opntpRoofOpnCtnt ) {
		this.opntpRoofOpnCtnt =	opntpRoofOpnCtnt;
	}
 
	/**
	 * Column Info
	 * @return	opntpRoofOpnCtnt
	 */
	 public	 String	getOpntpRoofOpnCtnt() {
		 return	this.opntpRoofOpnCtnt;
	 } 
 	/**
	* Column Info
	* @param  opntpIntrHgtCtnt
	*/
	public void	setOpntpIntrHgtCtnt( String	opntpIntrHgtCtnt ) {
		this.opntpIntrHgtCtnt =	opntpIntrHgtCtnt;
	}
 
	/**
	 * Column Info
	 * @return	opntpIntrHgtCtnt
	 */
	 public	 String	getOpntpIntrHgtCtnt() {
		 return	this.opntpIntrHgtCtnt;
	 } 
 	/**
	* Column Info
	* @param  opntpRearHdrOpnCtnt
	*/
	public void	setOpntpRearHdrOpnCtnt( String	opntpRearHdrOpnCtnt ) {
		this.opntpRearHdrOpnCtnt =	opntpRearHdrOpnCtnt;
	}
 
	/**
	 * Column Info
	 * @return	opntpRearHdrOpnCtnt
	 */
	 public	 String	getOpntpRearHdrOpnCtnt() {
		 return	this.opntpRearHdrOpnCtnt;
	 } 
 	/**
	* Column Info
	* @param  schSpecNo
	*/
	public void	setSchSpecNo( String	schSpecNo ) {
		this.schSpecNo =	schSpecNo;
	}
 
	/**
	 * Column Info
	 * @return	schSpecNo
	 */
	 public	 String	getSchSpecNo() {
		 return	this.schSpecNo;
	 } 
 	/**
	* Column Info
	* @param  schTpszCd
	*/
	public void	setSchTpszCd( String	schTpszCd ) {
		this.schTpszCd =	schTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	schTpszCd
	 */
	 public	 String	getSchTpszCd() {
		 return	this.schTpszCd;
	 } 
	 /**
	* Column Info
	* @param  zeroActiveQty
	*/
	public void	setZeroActiveQty( String	zeroActiveQty ) {
		this.zeroActiveQty =	zeroActiveQty;
	}
 
	/**
	 * Column Info
	 * @return	zeroActiveQty
	 */
	 public	 String	getZeroActiveQty() {
		 return	this.zeroActiveQty;
	 } 
	 /**
	* Column Info
	* @param  cntrSpecTypeCd
	*/
	public void	setCntrSpecTypeCd( String	cntrSpecTypeCd ) {
		this.cntrSpecTypeCd =	cntrSpecTypeCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrSpecTypeCd
	 */
	 public	 String	getCntrSpecTypeCd() {
		 return	this.cntrSpecTypeCd;
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
		setCntrSpecNo(JSPUtil.getParameter(request,	prefix + "cntr_spec_no", ""));
		setLodCapa(JSPUtil.getParameter(request,	prefix + "lod_capa", ""));
		setOpnDorWdt(JSPUtil.getParameter(request,	prefix + "opn_dor_wdt", ""));
		setToSpecYr(JSPUtil.getParameter(request,	prefix + "to_spec_yr", ""));
		setMinTemp(JSPUtil.getParameter(request,	prefix + "min_temp", ""));
		setXterLen(JSPUtil.getParameter(request,	prefix + "xter_len", ""));
		setRfMdlNm(JSPUtil.getParameter(request,	prefix + "rf_mdl_nm", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setTtlActQty(JSPUtil.getParameter(request,	prefix + "ttl_act_qty", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setFromSpecYr(JSPUtil.getParameter(request,	prefix + "from_spec_yr", ""));
		setAproTirNo(JSPUtil.getParameter(request,	prefix + "apro_tir_no", ""));
		setAproUicNo(JSPUtil.getParameter(request,	prefix + "apro_uic_no", ""));
		setTareWgt(JSPUtil.getParameter(request,	prefix + "tare_wgt", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setTtlLotQty(JSPUtil.getParameter(request,	prefix + "ttl_lot_qty", ""));
		setOpnDorHgt(JSPUtil.getParameter(request,	prefix + "opn_dor_hgt", ""));
		setOwnCntrFlg(JSPUtil.getParameter(request,	prefix + "own_cntr_flg", ""));
		setInterLen(JSPUtil.getParameter(request,	prefix + "inter_len", ""));
		setLotNo(JSPUtil.getParameter(request,	prefix + "lot_no", ""));
		setRcLdbHgt(JSPUtil.getParameter(request,	prefix + "rc_ldb_hgt", ""));
		setAgmtNo(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
		setSerRange(JSPUtil.getParameter(request,	prefix + "ser_range", ""));
		setInterWdt(JSPUtil.getParameter(request,	prefix + "inter_wdt", ""));
		setInterHgt(JSPUtil.getParameter(request,	prefix + "inter_hgt", ""));
		setAproTctNo(JSPUtil.getParameter(request,	prefix + "apro_tct_no", ""));
		setPlstFlrFlg(JSPUtil.getParameter(request,	prefix + "plst_flr_flg", ""));
		setCntrHngrRckFlg(JSPUtil.getParameter(request,	prefix + "cntr_hngr_rck_flg", ""));
		setMaxTemp(JSPUtil.getParameter(request,	prefix + "max_temp", ""));
		setRfMkrSeq(JSPUtil.getParameter(request,	prefix + "rf_mkr_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setTnkCapa(JSPUtil.getParameter(request,	prefix + "tnk_capa", ""));
		setAproCscNo(JSPUtil.getParameter(request,	prefix + "apro_csc_no", ""));
		setFctrySpecNo(JSPUtil.getParameter(request,	prefix + "fctry_spec_no", ""));
		setXterHgt(JSPUtil.getParameter(request,	prefix + "xter_hgt", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request,	prefix + "vndr_abbr_nm", ""));
		setCntrGrsWgt(JSPUtil.getParameter(request,	prefix + "cntr_grs_wgt", ""));
		setCntrMtrlCd(JSPUtil.getParameter(request,	prefix + "cntr_mtrl_cd", ""));
		setCntrMtrlNm(JSPUtil.getParameter(request,	prefix + "cntr_mtrl_nm", ""));
		setXterWdt(JSPUtil.getParameter(request,	prefix + "xter_wdt", ""));
		setRfRfrNo(JSPUtil.getParameter(request,	prefix + "rf_rfr_no", ""));
		setRcLdbCapa(JSPUtil.getParameter(request,	prefix + "rc_ldb_capa", ""));
		setRfTpCd(JSPUtil.getParameter(request,	prefix + "rf_tp_cd", ""));
		setYrBuild(JSPUtil.getParameter(request,	prefix + "yr_build", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "vndr_lgl_eng_nm", ""));
		setHidVndrSeq(JSPUtil.getParameter(request,	prefix + "hid_vndr_seq", ""));
		setRfHumidCtrlValCd(JSPUtil.getParameter(request,	prefix + "rf_humid_ctrl_val_cd", ""));
		setRfCmprCtnt(JSPUtil.getParameter(request,	prefix + "rf_cmpr_ctnt", ""));
		setFrackClpsCtnt(JSPUtil.getParameter(request,	prefix + "frack_clps_ctnt", ""));
		setFrackBedTikCtnt(JSPUtil.getParameter(request,	prefix + "frack_bed_tik_ctnt", ""));
		setOpntpRoofOpnCtnt(JSPUtil.getParameter(request,	prefix + "opntp_roof_opn_ctnt", ""));
		setOpntpIntrHgtCtnt(JSPUtil.getParameter(request,	prefix + "opntp_intr_hgt_ctnt", ""));
		setOpntpRearHdrOpnCtnt(JSPUtil.getParameter(request,	prefix + "opntp_rear_hdr_opn_ctnt", ""));
		setSchSpecNo(JSPUtil.getParameter(request,	prefix + "sch_spec_no", ""));
		setSchTpszCd(JSPUtil.getParameter(request,	prefix + "sch_tpsz_cd", ""));
		setZeroActiveQty(JSPUtil.getParameter(request,	prefix + "zero_active_qty", ""));
		setCntrSpecTypeCd(JSPUtil.getParameter(request,	prefix + "cntr_spec_type_cd", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return CntrSpecListBrieflyVO[]
	 */
	public CntrSpecListBrieflyVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return CntrSpecListBrieflyVO[]
	 */
	public CntrSpecListBrieflyVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		CntrSpecListBrieflyVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] cntrSpecNo =	(JSPUtil.getParameter(request, prefix +	"cntr_spec_no".trim(),	length));
				String[] lodCapa =	(JSPUtil.getParameter(request, prefix +	"lod_capa".trim(),	length));
				String[] opnDorWdt =	(JSPUtil.getParameter(request, prefix +	"opn_dor_wdt".trim(),	length));
				String[] toSpecYr =	(JSPUtil.getParameter(request, prefix +	"to_spec_yr".trim(),	length));
				String[] minTemp =	(JSPUtil.getParameter(request, prefix +	"min_temp".trim(),	length));
				String[] xterLen =	(JSPUtil.getParameter(request, prefix +	"xter_len".trim(),	length));
				String[] rfMdlNm =	(JSPUtil.getParameter(request, prefix +	"rf_mdl_nm".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ttlActQty =	(JSPUtil.getParameter(request, prefix +	"ttl_act_qty".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] fromSpecYr =	(JSPUtil.getParameter(request, prefix +	"from_spec_yr".trim(),	length));
				String[] aproTirNo =	(JSPUtil.getParameter(request, prefix +	"apro_tir_no".trim(),	length));
				String[] aproUicNo =	(JSPUtil.getParameter(request, prefix +	"apro_uic_no".trim(),	length));
				String[] tareWgt =	(JSPUtil.getParameter(request, prefix +	"tare_wgt".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] ttlLotQty =	(JSPUtil.getParameter(request, prefix +	"ttl_lot_qty".trim(),	length));
				String[] opnDorHgt =	(JSPUtil.getParameter(request, prefix +	"opn_dor_hgt".trim(),	length));
				String[] ownCntrFlg =	(JSPUtil.getParameter(request, prefix +	"own_cntr_flg".trim(),	length));
				String[] interLen =	(JSPUtil.getParameter(request, prefix +	"inter_len".trim(),	length));
				String[] lotNo =	(JSPUtil.getParameter(request, prefix +	"lot_no".trim(),	length));
				String[] rcLdbHgt =	(JSPUtil.getParameter(request, prefix +	"rc_ldb_hgt".trim(),	length));
				String[] agmtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				String[] serRange =	(JSPUtil.getParameter(request, prefix +	"ser_range".trim(),	length));
				String[] interWdt =	(JSPUtil.getParameter(request, prefix +	"inter_wdt".trim(),	length));
				String[] interHgt =	(JSPUtil.getParameter(request, prefix +	"inter_hgt".trim(),	length));
				String[] aproTctNo =	(JSPUtil.getParameter(request, prefix +	"apro_tct_no".trim(),	length));
				String[] plstFlrFlg =	(JSPUtil.getParameter(request, prefix +	"plst_flr_flg".trim(),	length));
				String[] cntrHngrRckFlg =	(JSPUtil.getParameter(request, prefix +	"cntr_hngr_rck_flg".trim(),	length));
				String[] maxTemp =	(JSPUtil.getParameter(request, prefix +	"max_temp".trim(),	length));
				String[] rfMkrSeq =	(JSPUtil.getParameter(request, prefix +	"rf_mkr_seq".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] tnkCapa =	(JSPUtil.getParameter(request, prefix +	"tnk_capa".trim(),	length));
				String[] aproCscNo =	(JSPUtil.getParameter(request, prefix +	"apro_csc_no".trim(),	length));
				String[] fctrySpecNo =	(JSPUtil.getParameter(request, prefix +	"fctry_spec_no".trim(),	length));
				String[] xterHgt =	(JSPUtil.getParameter(request, prefix +	"xter_hgt".trim(),	length));
				String[] vndrAbbrNm =	(JSPUtil.getParameter(request, prefix +	"vndr_abbr_nm".trim(),	length));
				String[] cntrGrsWgt =	(JSPUtil.getParameter(request, prefix +	"cntr_grs_wgt".trim(),	length));
				String[] cntrMtrlCd =	(JSPUtil.getParameter(request, prefix +	"cntr_mtrl_cd".trim(),	length));
				String[] cntrMtrlNm =	(JSPUtil.getParameter(request, prefix +	"cntr_mtrl_nm".trim(),	length));
				String[] xterWdt =	(JSPUtil.getParameter(request, prefix +	"xter_wdt".trim(),	length));
				String[] rfRfrNo =	(JSPUtil.getParameter(request, prefix +	"rf_rfr_no".trim(),	length));
				String[] rcLdbCapa =	(JSPUtil.getParameter(request, prefix +	"rc_ldb_capa".trim(),	length));
				String[] rfTpCd =	(JSPUtil.getParameter(request, prefix +	"rf_tp_cd".trim(),	length));
				String[] yrBuild =	(JSPUtil.getParameter(request, prefix +	"yr_build".trim(),	length));
				String[] vndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"vndr_lgl_eng_nm".trim(),	length));
				String[] hidVndrSeq =	(JSPUtil.getParameter(request, prefix +	"hid_vndr_seq".trim(),	length));
				String[] rfHumidCtrlValCd =	(JSPUtil.getParameter(request, prefix +	"rf_humid_ctrl_val_cd".trim(),	length));
				String[] rfCmprCtnt =	(JSPUtil.getParameter(request, prefix +	"rf_cmpr_ctnt".trim(),	length));
				String[] frackClpsCtnt =	(JSPUtil.getParameter(request, prefix +	"frack_clps_ctnt".trim(),	length));
				String[] frackBedTikCtnt =	(JSPUtil.getParameter(request, prefix +	"frack_bed_tik_ctnt".trim(),	length));
				String[] opntpRoofOpnCtnt =	(JSPUtil.getParameter(request, prefix +	"opntp_roof_opn_ctnt".trim(),	length));
				String[] opntpIntrHgtCtnt =	(JSPUtil.getParameter(request, prefix +	"opntp_intr_hgt_ctnt".trim(),	length));
				String[] opntpRearHdrOpnCtnt =	(JSPUtil.getParameter(request, prefix +	"opntp_rear_hdr_opn_ctnt".trim(),	length));
				String[] schSpecNo =	(JSPUtil.getParameter(request, prefix +	"sch_spec_no".trim(),	length));
				String[] schTpszCd =	(JSPUtil.getParameter(request, prefix +	"sch_tpsz_cd".trim(),	length));
				String[] zeroActiveQty =	(JSPUtil.getParameter(request, prefix +	"zero_active_qty".trim(),	length));
				String[] cntrSpecTypeCd =	(JSPUtil.getParameter(request, prefix +	"cntr_spec_type_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	CntrSpecListBrieflyVO();
						if ( cntrSpecNo[i] !=	null)
						model.setCntrSpecNo( cntrSpecNo[i]);
						if ( lodCapa[i] !=	null)
						model.setLodCapa( lodCapa[i]);
						if ( opnDorWdt[i] !=	null)
						model.setOpnDorWdt( opnDorWdt[i]);
						if ( toSpecYr[i] !=	null)
						model.setToSpecYr( toSpecYr[i]);
						if ( minTemp[i] !=	null)
						model.setMinTemp( minTemp[i]);
						if ( xterLen[i] !=	null)
						model.setXterLen( xterLen[i]);
						if ( rfMdlNm[i] !=	null)
						model.setRfMdlNm( rfMdlNm[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ttlActQty[i] !=	null)
						model.setTtlActQty( ttlActQty[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( fromSpecYr[i] !=	null)
						model.setFromSpecYr( fromSpecYr[i]);
						if ( aproTirNo[i] !=	null)
						model.setAproTirNo( aproTirNo[i]);
						if ( aproUicNo[i] !=	null)
						model.setAproUicNo( aproUicNo[i]);
						if ( tareWgt[i] !=	null)
						model.setTareWgt( tareWgt[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( ttlLotQty[i] !=	null)
						model.setTtlLotQty( ttlLotQty[i]);
						if ( opnDorHgt[i] !=	null)
						model.setOpnDorHgt( opnDorHgt[i]);
						if ( ownCntrFlg[i] !=	null)
						model.setOwnCntrFlg( ownCntrFlg[i]);
						if ( interLen[i] !=	null)
						model.setInterLen( interLen[i]);
						if ( lotNo[i] !=	null)
						model.setLotNo( lotNo[i]);
						if ( rcLdbHgt[i] !=	null)
						model.setRcLdbHgt( rcLdbHgt[i]);
						if ( agmtNo[i] !=	null)
						model.setAgmtNo( agmtNo[i]);
						if ( serRange[i] !=	null)
						model.setSerRange( serRange[i]);
						if ( interWdt[i] !=	null)
						model.setInterWdt( interWdt[i]);
						if ( interHgt[i] !=	null)
						model.setInterHgt( interHgt[i]);
						if ( aproTctNo[i] !=	null)
						model.setAproTctNo( aproTctNo[i]);
						if ( plstFlrFlg[i] !=	null)
						model.setPlstFlrFlg( plstFlrFlg[i]);
						if ( cntrHngrRckFlg[i] !=	null)
						model.setCntrHngrRckFlg( cntrHngrRckFlg[i]);
						if ( maxTemp[i] !=	null)
						model.setMaxTemp( maxTemp[i]);
						if ( rfMkrSeq[i] !=	null)
						model.setRfMkrSeq( rfMkrSeq[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( tnkCapa[i] !=	null)
						model.setTnkCapa( tnkCapa[i]);
						if ( aproCscNo[i] !=	null)
						model.setAproCscNo( aproCscNo[i]);
						if ( fctrySpecNo[i] !=	null)
						model.setFctrySpecNo( fctrySpecNo[i]);
						if ( xterHgt[i] !=	null)
						model.setXterHgt( xterHgt[i]);
						if ( vndrAbbrNm[i] !=	null)
						model.setVndrAbbrNm( vndrAbbrNm[i]);
						if ( cntrGrsWgt[i] !=	null)
						model.setCntrGrsWgt( cntrGrsWgt[i]);
						if ( cntrMtrlCd[i] !=	null)
						model.setCntrMtrlCd( cntrMtrlCd[i]);
						if ( cntrMtrlNm[i] !=	null)
						model.setCntrMtrlNm( cntrMtrlNm[i]);
						if ( xterWdt[i] !=	null)
						model.setXterWdt( xterWdt[i]);
						if ( rfRfrNo[i] !=	null)
						model.setRfRfrNo( rfRfrNo[i]);
						if ( rcLdbCapa[i] !=	null)
						model.setRcLdbCapa( rcLdbCapa[i]);
						if ( rfTpCd[i] !=	null)
						model.setRfTpCd( rfTpCd[i]);
						if ( yrBuild[i] !=	null)
						model.setYrBuild( yrBuild[i]);
						if ( vndrLglEngNm[i] !=	null)
						model.setVndrLglEngNm( vndrLglEngNm[i]);
						if ( hidVndrSeq[i] !=	null)
						model.setHidVndrSeq( hidVndrSeq[i]);
						if ( rfHumidCtrlValCd[i] !=	null)
						model.setRfHumidCtrlValCd( rfHumidCtrlValCd[i]);
						if ( rfCmprCtnt[i] !=	null)
						model.setRfCmprCtnt( rfCmprCtnt[i]);
						if ( frackClpsCtnt[i] !=	null)
						model.setFrackClpsCtnt( frackClpsCtnt[i]);
						if ( frackBedTikCtnt[i] !=	null)
						model.setFrackBedTikCtnt( frackBedTikCtnt[i]);
						if ( opntpRoofOpnCtnt[i] !=	null)
						model.setOpntpRoofOpnCtnt( opntpRoofOpnCtnt[i]);
						if ( opntpIntrHgtCtnt[i] !=	null)
						model.setOpntpIntrHgtCtnt( opntpIntrHgtCtnt[i]);
						if ( opntpRearHdrOpnCtnt[i] !=	null)
						model.setOpntpRearHdrOpnCtnt( opntpRearHdrOpnCtnt[i]);
						if ( schSpecNo[i] !=	null)
						model.setSchSpecNo( schSpecNo[i]);
						if ( schTpszCd[i] !=	null)
						model.setSchTpszCd( schTpszCd[i]);
						if ( zeroActiveQty[i] !=	null)
						model.setZeroActiveQty( zeroActiveQty[i]);
						if ( cntrSpecTypeCd[i] !=	null)
						model.setCntrSpecTypeCd( cntrSpecTypeCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getCntrSpecListBrieflyVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return CntrSpecListBrieflyVO[]
	 */
	public CntrSpecListBrieflyVO[]	 getCntrSpecListBrieflyVOs(){
		CntrSpecListBrieflyVO[] vos = (CntrSpecListBrieflyVO[])models.toArray(new	CntrSpecListBrieflyVO[models.size()]);
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
		this.cntrSpecNo =	this.cntrSpecNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodCapa =	this.lodCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opnDorWdt =	this.opnDorWdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSpecYr =	this.toSpecYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minTemp =	this.minTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterLen =	this.xterLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMdlNm =	this.rfMdlNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlActQty =	this.ttlActQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromSpecYr =	this.fromSpecYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproTirNo =	this.aproTirNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUicNo =	this.aproUicNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tareWgt =	this.tareWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLotQty =	this.ttlLotQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opnDorHgt =	this.opnDorHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownCntrFlg =	this.ownCntrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interLen =	this.interLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotNo =	this.lotNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcLdbHgt =	this.rcLdbHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo =	this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serRange =	this.serRange.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interWdt =	this.interWdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interHgt =	this.interHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproTctNo =	this.aproTctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plstFlrFlg =	this.plstFlrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckFlg =	this.cntrHngrRckFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxTemp =	this.maxTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMkrSeq =	this.rfMkrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tnkCapa =	this.tnkCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproCscNo =	this.aproCscNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctrySpecNo =	this.fctrySpecNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterHgt =	this.xterHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm =	this.vndrAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrGrsWgt =	this.cntrGrsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMtrlCd =	this.cntrMtrlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMtrlNm =	this.cntrMtrlNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterWdt =	this.xterWdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRfrNo =	this.rfRfrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcLdbCapa =	this.rcLdbCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCd =	this.rfTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrBuild =	this.yrBuild.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm =	this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidVndrSeq =	this.hidVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfHumidCtrlValCd =	this.rfHumidCtrlValCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCmprCtnt =	this.rfCmprCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frackClpsCtnt =	this.frackClpsCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frackBedTikCtnt =	this.frackBedTikCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opntpRoofOpnCtnt =	this.opntpRoofOpnCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opntpIntrHgtCtnt =	this.opntpIntrHgtCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opntpRearHdrOpnCtnt =	this.opntpRearHdrOpnCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schSpecNo =	this.schSpecNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schTpszCd =	this.schTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zeroActiveQty =	this.zeroActiveQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSpecTypeCd =	this.cntrSpecTypeCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}