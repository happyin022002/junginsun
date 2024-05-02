/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AgreementListVO.java
 *@FileTitle : AgreementListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.03.10
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.03.10  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo;

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
public class AgreementListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AgreementListVO>  models =	new	ArrayList<AgreementListVO>();


	/*	Column Info	*/
	private  String	 cntr12Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr3Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr22Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr18Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr25Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr9Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr13Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr8Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr20Qty   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 effDt   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 cntr14Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr26Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr19Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr15Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr17Qty   =  null;
	/*	Column Info	*/
	private  String	 expDt   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 locCdTeuNo   =  null;
	/*	Column Info	*/
	private  String	 cntr2Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr16Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr29Qty   =  null;
	/*	Column Info	*/
	private  String	 typeNm   =  null;
	/*	Column Info	*/
	private  String	 cntr10Qty   =  null;
	/*	Column Info	*/
	private  String	 agmtNo   =  null;
	/*	Column Info	*/
	private  String	 refNo   =  null;
	/*	Column Info	*/
	private  String	 cntr5Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr4Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr30Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr23Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr24Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr11Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr1Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr6Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr28Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr21Qty   =  null;
	/*	Column Info	*/
	private  String	 vndrAbbrNm   =  null;
	/*	Column Info	*/
	private  String	 cntr7Qty   =  null;
	/*	Column Info	*/
	private  String	 cntr27Qty   =  null;
	/*	Column Info	*/
	private  String	 typeCd   =  null;
	/*	Column Info	*/
	private  String	 fstCls   =  null;
	/*	Column Info	*/
	private  String	 sndCls   =  null;
	/*	Column Info	*/
	private  String	 ttl   =  null;
	/*	Column Info	*/
	private  String	 eqLocTpCd   =  null;
	/*	Column Info	*/
	private  String	 locCd   =  null;
	/*	Column Info	*/
	private  String	 yearBuilt   =  null;
	/*	Column Info	*/
	private  String	 effectiveDt   =  null;
	/*	Column Info	*/
	private  String	 expiryDt   =  null;
	/*	Column Info	*/
	private  String	 leaseTerm   =  null;
	/*	Column Info	*/
	private  String	 paymentTerm   =  null;
	/*	Column Info	*/
	private  String	 yearlyDepr   =  null;
	/*	Column Info	*/
	private  String	 maxDepr   =  null;
	/*	Column Info	*/
	private  String	 slbFlg   =  null;
	/*	Column Info	*/
	private  String	 lsePayTpCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public AgreementListVO(){}

	public AgreementListVO(String cntr12Qty,String cntr3Qty,String cntr22Qty,String cntr18Qty,String cntr25Qty,String cntr9Qty,String cntr13Qty,String cntr8Qty,String cntr20Qty,String pagerows,String effDt,String ibflag,String cntr14Qty,String cntr26Qty,String cntr19Qty,String cntr15Qty,String cntr17Qty,String expDt,String lstmCd,String locCdTeuNo,String cntr2Qty,String cntr16Qty,String cntr29Qty,String typeNm,String cntr10Qty,String agmtNo,String refNo,String cntr5Qty,String cntr4Qty,String cntr30Qty,String cntr23Qty,String cntr24Qty,String cntr11Qty,String cntr1Qty,String cntr6Qty,String cntr28Qty,String cntr21Qty,String vndrAbbrNm,String cntr7Qty,String cntr27Qty,String typeCd,String fstCls,String sndCls,String ttl,String eqLocTpCd,String locCd,String yearBuilt,String effectiveDt,String expiryDt,String leaseTerm,String paymentTerm,String yearlyDepr,String maxDepr,String slbFlg,String lsePayTpCd)	{
		this.cntr12Qty  = cntr12Qty ;
		this.cntr3Qty  = cntr3Qty ;
		this.cntr22Qty  = cntr22Qty ;
		this.cntr18Qty  = cntr18Qty ;
		this.cntr25Qty  = cntr25Qty ;
		this.cntr9Qty  = cntr9Qty ;
		this.cntr13Qty  = cntr13Qty ;
		this.cntr8Qty  = cntr8Qty ;
		this.cntr20Qty  = cntr20Qty ;
		this.pagerows  = pagerows ;
		this.effDt  = effDt ;
		this.ibflag  = ibflag ;
		this.cntr14Qty  = cntr14Qty ;
		this.cntr26Qty  = cntr26Qty ;
		this.cntr19Qty  = cntr19Qty ;
		this.cntr15Qty  = cntr15Qty ;
		this.cntr17Qty  = cntr17Qty ;
		this.expDt  = expDt ;
		this.lstmCd  = lstmCd ;
		this.locCdTeuNo  = locCdTeuNo ;
		this.cntr2Qty  = cntr2Qty ;
		this.cntr16Qty  = cntr16Qty ;
		this.cntr29Qty  = cntr29Qty ;
		this.typeNm  = typeNm ;
		this.cntr10Qty  = cntr10Qty ;
		this.agmtNo  = agmtNo ;
		this.refNo  = refNo ;
		this.cntr5Qty  = cntr5Qty ;
		this.cntr4Qty  = cntr4Qty ;
		this.cntr30Qty  = cntr30Qty ;
		this.cntr23Qty  = cntr23Qty ;
		this.cntr24Qty  = cntr24Qty ;
		this.cntr11Qty  = cntr11Qty ;
		this.cntr1Qty  = cntr1Qty ;
		this.cntr6Qty  = cntr6Qty ;
		this.cntr28Qty  = cntr28Qty ;
		this.cntr21Qty  = cntr21Qty ;
		this.vndrAbbrNm  = vndrAbbrNm ;
		this.cntr7Qty  = cntr7Qty ;
		this.cntr27Qty  = cntr27Qty ;
		this.typeCd  = typeCd ;
		this.fstCls  = fstCls ;
		this.sndCls  = sndCls ;
		this.ttl  = ttl ;
		this.eqLocTpCd  = eqLocTpCd ;
		this.locCd  = locCd ;
		this.yearBuilt  = yearBuilt ;
		this.effectiveDt  = effectiveDt ;
		this.expiryDt  = expiryDt ;
		this.leaseTerm  = leaseTerm ;
		this.paymentTerm  = paymentTerm ;
		this.yearlyDepr  = yearlyDepr ;
		this.maxDepr  = maxDepr ;
		this.slbFlg  = slbFlg ;
		this.lsePayTpCd  = lsePayTpCd ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr12_qty", getCntr12Qty());		
		this.hashColumns.put("cntr3_qty", getCntr3Qty());		
		this.hashColumns.put("cntr22_qty", getCntr22Qty());		
		this.hashColumns.put("cntr18_qty", getCntr18Qty());		
		this.hashColumns.put("cntr25_qty", getCntr25Qty());		
		this.hashColumns.put("cntr9_qty", getCntr9Qty());		
		this.hashColumns.put("cntr13_qty", getCntr13Qty());		
		this.hashColumns.put("cntr8_qty", getCntr8Qty());		
		this.hashColumns.put("cntr20_qty", getCntr20Qty());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("eff_dt", getEffDt());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cntr14_qty", getCntr14Qty());		
		this.hashColumns.put("cntr26_qty", getCntr26Qty());		
		this.hashColumns.put("cntr19_qty", getCntr19Qty());		
		this.hashColumns.put("cntr15_qty", getCntr15Qty());		
		this.hashColumns.put("cntr17_qty", getCntr17Qty());		
		this.hashColumns.put("exp_dt", getExpDt());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("loc_cd_teu_no", getLocCdTeuNo());		
		this.hashColumns.put("cntr2_qty", getCntr2Qty());		
		this.hashColumns.put("cntr16_qty", getCntr16Qty());		
		this.hashColumns.put("cntr29_qty", getCntr29Qty());		
		this.hashColumns.put("type_nm", getTypeNm());		
		this.hashColumns.put("cntr10_qty", getCntr10Qty());		
		this.hashColumns.put("agmt_no", getAgmtNo());		
		this.hashColumns.put("ref_no", getRefNo());		
		this.hashColumns.put("cntr5_qty", getCntr5Qty());		
		this.hashColumns.put("cntr4_qty", getCntr4Qty());		
		this.hashColumns.put("cntr30_qty", getCntr30Qty());		
		this.hashColumns.put("cntr23_qty", getCntr23Qty());		
		this.hashColumns.put("cntr24_qty", getCntr24Qty());		
		this.hashColumns.put("cntr11_qty", getCntr11Qty());		
		this.hashColumns.put("cntr1_qty", getCntr1Qty());		
		this.hashColumns.put("cntr6_qty", getCntr6Qty());		
		this.hashColumns.put("cntr28_qty", getCntr28Qty());		
		this.hashColumns.put("cntr21_qty", getCntr21Qty());		
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());		
		this.hashColumns.put("cntr7_qty", getCntr7Qty());		
		this.hashColumns.put("cntr27_qty", getCntr27Qty());		
		this.hashColumns.put("type_cd", getTypeCd());		
		this.hashColumns.put("fst_cls", getFstCls());		
		this.hashColumns.put("snd_cls", getSndCls());		
		this.hashColumns.put("ttl", getTtl());		
		this.hashColumns.put("eq_loc_tp_cd", getEqLocTpCd());		
		this.hashColumns.put("loc_cd", getLocCd());		
		this.hashColumns.put("year_built", getYearBuilt());		
		this.hashColumns.put("effective_dt", getEffectiveDt());		
		this.hashColumns.put("expiry_dt", getExpiryDt());		
		this.hashColumns.put("lease_term", getLeaseTerm());		
		this.hashColumns.put("payment_term", getPaymentTerm());		
		this.hashColumns.put("yearly_depr", getYearlyDepr());		
		this.hashColumns.put("max_depr", getMaxDepr());		
		this.hashColumns.put("slb_flg", getSlbFlg());		
		this.hashColumns.put("lse_pay_tp_cd", getLsePayTpCd());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("cntr12_qty", "cntr12Qty");
		this.hashFields.put("cntr3_qty", "cntr3Qty");
		this.hashFields.put("cntr22_qty", "cntr22Qty");
		this.hashFields.put("cntr18_qty", "cntr18Qty");
		this.hashFields.put("cntr25_qty", "cntr25Qty");
		this.hashFields.put("cntr9_qty", "cntr9Qty");
		this.hashFields.put("cntr13_qty", "cntr13Qty");
		this.hashFields.put("cntr8_qty", "cntr8Qty");
		this.hashFields.put("cntr20_qty", "cntr20Qty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr14_qty", "cntr14Qty");
		this.hashFields.put("cntr26_qty", "cntr26Qty");
		this.hashFields.put("cntr19_qty", "cntr19Qty");
		this.hashFields.put("cntr15_qty", "cntr15Qty");
		this.hashFields.put("cntr17_qty", "cntr17Qty");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("loc_cd_teu_no", "locCdTeuNo");
		this.hashFields.put("cntr2_qty", "cntr2Qty");
		this.hashFields.put("cntr16_qty", "cntr16Qty");
		this.hashFields.put("cntr29_qty", "cntr29Qty");
		this.hashFields.put("type_nm", "typeNm");
		this.hashFields.put("cntr10_qty", "cntr10Qty");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("cntr5_qty", "cntr5Qty");
		this.hashFields.put("cntr4_qty", "cntr4Qty");
		this.hashFields.put("cntr30_qty", "cntr30Qty");
		this.hashFields.put("cntr23_qty", "cntr23Qty");
		this.hashFields.put("cntr24_qty", "cntr24Qty");
		this.hashFields.put("cntr11_qty", "cntr11Qty");
		this.hashFields.put("cntr1_qty", "cntr1Qty");
		this.hashFields.put("cntr6_qty", "cntr6Qty");
		this.hashFields.put("cntr28_qty", "cntr28Qty");
		this.hashFields.put("cntr21_qty", "cntr21Qty");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("cntr7_qty", "cntr7Qty");
		this.hashFields.put("cntr27_qty", "cntr27Qty");
		this.hashFields.put("type_cd", "typeCd");
		this.hashFields.put("fst_cls", "fstCls");
		this.hashFields.put("snd_cls", "sndCls");
		this.hashFields.put("ttl", "ttl");
		this.hashFields.put("eq_loc_tp_cd", "eqLocTpCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("year_built", "yearBuilt");
		this.hashFields.put("effective_dt", "effectiveDt");
		this.hashFields.put("expiry_dt", "expiryDt");
		this.hashFields.put("lease_term", "leaseTerm");
		this.hashFields.put("payment_term", "paymentTerm");
		this.hashFields.put("yearly_depr", "yearlyDepr");
		this.hashFields.put("max_depr", "maxDepr");
		this.hashFields.put("slb_flg", "slbFlg");
		this.hashFields.put("lse_pay_tp_cd", "lsePayTpCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  cntr12Qty
	*/
	public void	setCntr12Qty( String	cntr12Qty ) {
		this.cntr12Qty =	cntr12Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr12Qty
	 */
	 public	 String	getCntr12Qty() {
		 return	this.cntr12Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr3Qty
	*/
	public void	setCntr3Qty( String	cntr3Qty ) {
		this.cntr3Qty =	cntr3Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr3Qty
	 */
	 public	 String	getCntr3Qty() {
		 return	this.cntr3Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr22Qty
	*/
	public void	setCntr22Qty( String	cntr22Qty ) {
		this.cntr22Qty =	cntr22Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr22Qty
	 */
	 public	 String	getCntr22Qty() {
		 return	this.cntr22Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr18Qty
	*/
	public void	setCntr18Qty( String	cntr18Qty ) {
		this.cntr18Qty =	cntr18Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr18Qty
	 */
	 public	 String	getCntr18Qty() {
		 return	this.cntr18Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr25Qty
	*/
	public void	setCntr25Qty( String	cntr25Qty ) {
		this.cntr25Qty =	cntr25Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr25Qty
	 */
	 public	 String	getCntr25Qty() {
		 return	this.cntr25Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr9Qty
	*/
	public void	setCntr9Qty( String	cntr9Qty ) {
		this.cntr9Qty =	cntr9Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr9Qty
	 */
	 public	 String	getCntr9Qty() {
		 return	this.cntr9Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr13Qty
	*/
	public void	setCntr13Qty( String	cntr13Qty ) {
		this.cntr13Qty =	cntr13Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr13Qty
	 */
	 public	 String	getCntr13Qty() {
		 return	this.cntr13Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr8Qty
	*/
	public void	setCntr8Qty( String	cntr8Qty ) {
		this.cntr8Qty =	cntr8Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr8Qty
	 */
	 public	 String	getCntr8Qty() {
		 return	this.cntr8Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr20Qty
	*/
	public void	setCntr20Qty( String	cntr20Qty ) {
		this.cntr20Qty =	cntr20Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr20Qty
	 */
	 public	 String	getCntr20Qty() {
		 return	this.cntr20Qty;
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
	* @param  effDt
	*/
	public void	setEffDt( String	effDt ) {
		this.effDt =	effDt;
	}
 
	/**
	 * Column Info
	 * @return	effDt
	 */
	 public	 String	getEffDt() {
		 return	this.effDt;
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
	* @param  cntr14Qty
	*/
	public void	setCntr14Qty( String	cntr14Qty ) {
		this.cntr14Qty =	cntr14Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr14Qty
	 */
	 public	 String	getCntr14Qty() {
		 return	this.cntr14Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr26Qty
	*/
	public void	setCntr26Qty( String	cntr26Qty ) {
		this.cntr26Qty =	cntr26Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr26Qty
	 */
	 public	 String	getCntr26Qty() {
		 return	this.cntr26Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr19Qty
	*/
	public void	setCntr19Qty( String	cntr19Qty ) {
		this.cntr19Qty =	cntr19Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr19Qty
	 */
	 public	 String	getCntr19Qty() {
		 return	this.cntr19Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr15Qty
	*/
	public void	setCntr15Qty( String	cntr15Qty ) {
		this.cntr15Qty =	cntr15Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr15Qty
	 */
	 public	 String	getCntr15Qty() {
		 return	this.cntr15Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr17Qty
	*/
	public void	setCntr17Qty( String	cntr17Qty ) {
		this.cntr17Qty =	cntr17Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr17Qty
	 */
	 public	 String	getCntr17Qty() {
		 return	this.cntr17Qty;
	 } 
 	/**
	* Column Info
	* @param  expDt
	*/
	public void	setExpDt( String	expDt ) {
		this.expDt =	expDt;
	}
 
	/**
	 * Column Info
	 * @return	expDt
	 */
	 public	 String	getExpDt() {
		 return	this.expDt;
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
	* @param  locCdTeuNo
	*/
	public void	setLocCdTeuNo( String	locCdTeuNo ) {
		this.locCdTeuNo =	locCdTeuNo;
	}
 
	/**
	 * Column Info
	 * @return	locCdTeuNo
	 */
	 public	 String	getLocCdTeuNo() {
		 return	this.locCdTeuNo;
	 } 
 	/**
	* Column Info
	* @param  cntr2Qty
	*/
	public void	setCntr2Qty( String	cntr2Qty ) {
		this.cntr2Qty =	cntr2Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr2Qty
	 */
	 public	 String	getCntr2Qty() {
		 return	this.cntr2Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr16Qty
	*/
	public void	setCntr16Qty( String	cntr16Qty ) {
		this.cntr16Qty =	cntr16Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr16Qty
	 */
	 public	 String	getCntr16Qty() {
		 return	this.cntr16Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr29Qty
	*/
	public void	setCntr29Qty( String	cntr29Qty ) {
		this.cntr29Qty =	cntr29Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr29Qty
	 */
	 public	 String	getCntr29Qty() {
		 return	this.cntr29Qty;
	 } 
 	/**
	* Column Info
	* @param  typeNm
	*/
	public void	setTypeNm( String	typeNm ) {
		this.typeNm =	typeNm;
	}
 
	/**
	 * Column Info
	 * @return	typeNm
	 */
	 public	 String	getTypeNm() {
		 return	this.typeNm;
	 } 
 	/**
	* Column Info
	* @param  cntr10Qty
	*/
	public void	setCntr10Qty( String	cntr10Qty ) {
		this.cntr10Qty =	cntr10Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr10Qty
	 */
	 public	 String	getCntr10Qty() {
		 return	this.cntr10Qty;
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
	* @param  refNo
	*/
	public void	setRefNo( String	refNo ) {
		this.refNo =	refNo;
	}
 
	/**
	 * Column Info
	 * @return	refNo
	 */
	 public	 String	getRefNo() {
		 return	this.refNo;
	 } 
 	/**
	* Column Info
	* @param  cntr5Qty
	*/
	public void	setCntr5Qty( String	cntr5Qty ) {
		this.cntr5Qty =	cntr5Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr5Qty
	 */
	 public	 String	getCntr5Qty() {
		 return	this.cntr5Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr4Qty
	*/
	public void	setCntr4Qty( String	cntr4Qty ) {
		this.cntr4Qty =	cntr4Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr4Qty
	 */
	 public	 String	getCntr4Qty() {
		 return	this.cntr4Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr30Qty
	*/
	public void	setCntr30Qty( String	cntr30Qty ) {
		this.cntr30Qty =	cntr30Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr30Qty
	 */
	 public	 String	getCntr30Qty() {
		 return	this.cntr30Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr23Qty
	*/
	public void	setCntr23Qty( String	cntr23Qty ) {
		this.cntr23Qty =	cntr23Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr23Qty
	 */
	 public	 String	getCntr23Qty() {
		 return	this.cntr23Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr24Qty
	*/
	public void	setCntr24Qty( String	cntr24Qty ) {
		this.cntr24Qty =	cntr24Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr24Qty
	 */
	 public	 String	getCntr24Qty() {
		 return	this.cntr24Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr11Qty
	*/
	public void	setCntr11Qty( String	cntr11Qty ) {
		this.cntr11Qty =	cntr11Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr11Qty
	 */
	 public	 String	getCntr11Qty() {
		 return	this.cntr11Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr1Qty
	*/
	public void	setCntr1Qty( String	cntr1Qty ) {
		this.cntr1Qty =	cntr1Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr1Qty
	 */
	 public	 String	getCntr1Qty() {
		 return	this.cntr1Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr6Qty
	*/
	public void	setCntr6Qty( String	cntr6Qty ) {
		this.cntr6Qty =	cntr6Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr6Qty
	 */
	 public	 String	getCntr6Qty() {
		 return	this.cntr6Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr28Qty
	*/
	public void	setCntr28Qty( String	cntr28Qty ) {
		this.cntr28Qty =	cntr28Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr28Qty
	 */
	 public	 String	getCntr28Qty() {
		 return	this.cntr28Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr21Qty
	*/
	public void	setCntr21Qty( String	cntr21Qty ) {
		this.cntr21Qty =	cntr21Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr21Qty
	 */
	 public	 String	getCntr21Qty() {
		 return	this.cntr21Qty;
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
	* @param  cntr7Qty
	*/
	public void	setCntr7Qty( String	cntr7Qty ) {
		this.cntr7Qty =	cntr7Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr7Qty
	 */
	 public	 String	getCntr7Qty() {
		 return	this.cntr7Qty;
	 } 
 	/**
	* Column Info
	* @param  cntr27Qty
	*/
	public void	setCntr27Qty( String	cntr27Qty ) {
		this.cntr27Qty =	cntr27Qty;
	}
 
	/**
	 * Column Info
	 * @return	cntr27Qty
	 */
	 public	 String	getCntr27Qty() {
		 return	this.cntr27Qty;
	 } 
 	/**
	* Column Info
	* @param  typeCd
	*/
	public void	setTypeCd( String	typeCd ) {
		this.typeCd =	typeCd;
	}
 
	/**
	 * Column Info
	 * @return	typeCd
	 */
	 public	 String	getTypeCd() {
		 return	this.typeCd;
	 } 
 	/**
	* Column Info
	* @param  fstCls
	*/
	public void	setFstCls( String	fstCls ) {
		this.fstCls =	fstCls;
	}
 
	/**
	 * Column Info
	 * @return	fstCls
	 */
	 public	 String	getFstCls() {
		 return	this.fstCls;
	 } 
 	/**
	* Column Info
	* @param  sndCls
	*/
	public void	setSndCls( String	sndCls ) {
		this.sndCls =	sndCls;
	}
 
	/**
	 * Column Info
	 * @return	sndCls
	 */
	 public	 String	getSndCls() {
		 return	this.sndCls;
	 } 
 	/**
	* Column Info
	* @param  ttl
	*/
	public void	setTtl( String	ttl ) {
		this.ttl =	ttl;
	}
 
	/**
	 * Column Info
	 * @return	ttl
	 */
	 public	 String	getTtl() {
		 return	this.ttl;
	 } 
 	/**
	* Column Info
	* @param  eqLocTpCd
	*/
	public void	setEqLocTpCd( String	eqLocTpCd ) {
		this.eqLocTpCd =	eqLocTpCd;
	}
 
	/**
	 * Column Info
	 * @return	eqLocTpCd
	 */
	 public	 String	getEqLocTpCd() {
		 return	this.eqLocTpCd;
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
	* @param  yearBuilt
	*/
	public void	setYearBuilt( String	yearBuilt ) {
		this.yearBuilt =	yearBuilt;
	}
 
	/**
	 * Column Info
	 * @return	yearBuilt
	 */
	 public	 String	getYearBuilt() {
		 return	this.yearBuilt;
	 } 
 	/**
	* Column Info
	* @param  effectiveDt
	*/
	public void	setEffectiveDt( String	effectiveDt ) {
		this.effectiveDt =	effectiveDt;
	}
 
	/**
	 * Column Info
	 * @return	effectiveDt
	 */
	 public	 String	getEffectiveDt() {
		 return	this.effectiveDt;
	 } 
 	/**
	* Column Info
	* @param  expiryDt
	*/
	public void	setExpiryDt( String	expiryDt ) {
		this.expiryDt =	expiryDt;
	}
 
	/**
	 * Column Info
	 * @return	expiryDt
	 */
	 public	 String	getExpiryDt() {
		 return	this.expiryDt;
	 } 
 	/**
	* Column Info
	* @param  leaseTerm
	*/
	public void	setLeaseTerm( String	leaseTerm ) {
		this.leaseTerm =	leaseTerm;
	}
 
	/**
	 * Column Info
	 * @return	leaseTerm
	 */
	 public	 String	getLeaseTerm() {
		 return	this.leaseTerm;
	 } 
 	/**
	* Column Info
	* @param  paymentTerm
	*/
	public void	setPaymentTerm( String	paymentTerm ) {
		this.paymentTerm =	paymentTerm;
	}
 
	/**
	 * Column Info
	 * @return	paymentTerm
	 */
	 public	 String	getPaymentTerm() {
		 return	this.paymentTerm;
	 } 
 	/**
	* Column Info
	* @param  yearlyDepr
	*/
	public void	setYearlyDepr( String	yearlyDepr ) {
		this.yearlyDepr =	yearlyDepr;
	}
 
	/**
	 * Column Info
	 * @return	yearlyDepr
	 */
	 public	 String	getYearlyDepr() {
		 return	this.yearlyDepr;
	 } 
 	/**
	* Column Info
	* @param  maxDepr
	*/
	public void	setMaxDepr( String	maxDepr ) {
		this.maxDepr =	maxDepr;
	}
 
	/**
	 * Column Info
	 * @return	maxDepr
	 */
	 public	 String	getMaxDepr() {
		 return	this.maxDepr;
	 } 
 	/**
	* Column Info
	* @param  slbFlg
	*/
	public void	setSlbFlg( String	slbFlg ) {
		this.slbFlg =	slbFlg;
	}
 
	/**
	 * Column Info
	 * @return	slbFlg
	 */
	 public	 String	getSlbFlg() {
		 return	this.slbFlg;
	 } 
 	/**
	* Column Info
	* @param  lsePayTpCd
	*/
	public void	setLsePayTpCd( String	lsePayTpCd ) {
		this.lsePayTpCd =	lsePayTpCd;
	}
 
	/**
	 * Column Info
	 * @return	lsePayTpCd
	 */
	 public	 String	getLsePayTpCd() {
		 return	this.lsePayTpCd;
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
		setCntr12Qty(JSPUtil.getParameter(request,	prefix + "cntr12_qty", ""));
		setCntr3Qty(JSPUtil.getParameter(request,	prefix + "cntr3_qty", ""));
		setCntr22Qty(JSPUtil.getParameter(request,	prefix + "cntr22_qty", ""));
		setCntr18Qty(JSPUtil.getParameter(request,	prefix + "cntr18_qty", ""));
		setCntr25Qty(JSPUtil.getParameter(request,	prefix + "cntr25_qty", ""));
		setCntr9Qty(JSPUtil.getParameter(request,	prefix + "cntr9_qty", ""));
		setCntr13Qty(JSPUtil.getParameter(request,	prefix + "cntr13_qty", ""));
		setCntr8Qty(JSPUtil.getParameter(request,	prefix + "cntr8_qty", ""));
		setCntr20Qty(JSPUtil.getParameter(request,	prefix + "cntr20_qty", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request,	prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCntr14Qty(JSPUtil.getParameter(request,	prefix + "cntr14_qty", ""));
		setCntr26Qty(JSPUtil.getParameter(request,	prefix + "cntr26_qty", ""));
		setCntr19Qty(JSPUtil.getParameter(request,	prefix + "cntr19_qty", ""));
		setCntr15Qty(JSPUtil.getParameter(request,	prefix + "cntr15_qty", ""));
		setCntr17Qty(JSPUtil.getParameter(request,	prefix + "cntr17_qty", ""));
		setExpDt(JSPUtil.getParameter(request,	prefix + "exp_dt", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setLocCdTeuNo(JSPUtil.getParameter(request,	prefix + "loc_cd_teu_no", ""));
		setCntr2Qty(JSPUtil.getParameter(request,	prefix + "cntr2_qty", ""));
		setCntr16Qty(JSPUtil.getParameter(request,	prefix + "cntr16_qty", ""));
		setCntr29Qty(JSPUtil.getParameter(request,	prefix + "cntr29_qty", ""));
		setTypeNm(JSPUtil.getParameter(request,	prefix + "type_nm", ""));
		setCntr10Qty(JSPUtil.getParameter(request,	prefix + "cntr10_qty", ""));
		setAgmtNo(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
		setRefNo(JSPUtil.getParameter(request,	prefix + "ref_no", ""));
		setCntr5Qty(JSPUtil.getParameter(request,	prefix + "cntr5_qty", ""));
		setCntr4Qty(JSPUtil.getParameter(request,	prefix + "cntr4_qty", ""));
		setCntr30Qty(JSPUtil.getParameter(request,	prefix + "cntr30_qty", ""));
		setCntr23Qty(JSPUtil.getParameter(request,	prefix + "cntr23_qty", ""));
		setCntr24Qty(JSPUtil.getParameter(request,	prefix + "cntr24_qty", ""));
		setCntr11Qty(JSPUtil.getParameter(request,	prefix + "cntr11_qty", ""));
		setCntr1Qty(JSPUtil.getParameter(request,	prefix + "cntr1_qty", ""));
		setCntr6Qty(JSPUtil.getParameter(request,	prefix + "cntr6_qty", ""));
		setCntr28Qty(JSPUtil.getParameter(request,	prefix + "cntr28_qty", ""));
		setCntr21Qty(JSPUtil.getParameter(request,	prefix + "cntr21_qty", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request,	prefix + "vndr_abbr_nm", ""));
		setCntr7Qty(JSPUtil.getParameter(request,	prefix + "cntr7_qty", ""));
		setCntr27Qty(JSPUtil.getParameter(request,	prefix + "cntr27_qty", ""));
		setTypeCd(JSPUtil.getParameter(request,	prefix + "type_cd", ""));
		setFstCls(JSPUtil.getParameter(request,	prefix + "fst_cls", ""));
		setSndCls(JSPUtil.getParameter(request,	prefix + "snd_cls", ""));
		setTtl(JSPUtil.getParameter(request,	prefix + "ttl", ""));
		setEqLocTpCd(JSPUtil.getParameter(request,	prefix + "eq_loc_tp_cd", ""));
		setLocCd(JSPUtil.getParameter(request,	prefix + "loc_cd", ""));
		setYearBuilt(JSPUtil.getParameter(request,	prefix + "year_built", ""));
		setEffectiveDt(JSPUtil.getParameter(request,	prefix + "effective_dt", ""));
		setExpiryDt(JSPUtil.getParameter(request,	prefix + "expiry_dt", ""));
		setLeaseTerm(JSPUtil.getParameter(request,	prefix + "lease_term", ""));
		setPaymentTerm(JSPUtil.getParameter(request,	prefix + "payment_term", ""));
		setYearlyDepr(JSPUtil.getParameter(request,	prefix + "yearly_depr", ""));
		setMaxDepr(JSPUtil.getParameter(request,	prefix + "max_depr", ""));
		setSlbFlg(JSPUtil.getParameter(request,	prefix + "slb_flg", ""));
		setLsePayTpCd(JSPUtil.getParameter(request,	prefix + "lse_pay_tp_cd", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return AgreementListVO[]
	 */
	public AgreementListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return AgreementListVO[]
	 */
	public AgreementListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AgreementListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] cntr12Qty =	(JSPUtil.getParameter(request, prefix +	"cntr12_qty".trim(),	length));
				String[] cntr3Qty =	(JSPUtil.getParameter(request, prefix +	"cntr3_qty".trim(),	length));
				String[] cntr22Qty =	(JSPUtil.getParameter(request, prefix +	"cntr22_qty".trim(),	length));
				String[] cntr18Qty =	(JSPUtil.getParameter(request, prefix +	"cntr18_qty".trim(),	length));
				String[] cntr25Qty =	(JSPUtil.getParameter(request, prefix +	"cntr25_qty".trim(),	length));
				String[] cntr9Qty =	(JSPUtil.getParameter(request, prefix +	"cntr9_qty".trim(),	length));
				String[] cntr13Qty =	(JSPUtil.getParameter(request, prefix +	"cntr13_qty".trim(),	length));
				String[] cntr8Qty =	(JSPUtil.getParameter(request, prefix +	"cntr8_qty".trim(),	length));
				String[] cntr20Qty =	(JSPUtil.getParameter(request, prefix +	"cntr20_qty".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] effDt =	(JSPUtil.getParameter(request, prefix +	"eff_dt".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] cntr14Qty =	(JSPUtil.getParameter(request, prefix +	"cntr14_qty".trim(),	length));
				String[] cntr26Qty =	(JSPUtil.getParameter(request, prefix +	"cntr26_qty".trim(),	length));
				String[] cntr19Qty =	(JSPUtil.getParameter(request, prefix +	"cntr19_qty".trim(),	length));
				String[] cntr15Qty =	(JSPUtil.getParameter(request, prefix +	"cntr15_qty".trim(),	length));
				String[] cntr17Qty =	(JSPUtil.getParameter(request, prefix +	"cntr17_qty".trim(),	length));
				String[] expDt =	(JSPUtil.getParameter(request, prefix +	"exp_dt".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] locCdTeuNo =	(JSPUtil.getParameter(request, prefix +	"loc_cd_teu_no".trim(),	length));
				String[] cntr2Qty =	(JSPUtil.getParameter(request, prefix +	"cntr2_qty".trim(),	length));
				String[] cntr16Qty =	(JSPUtil.getParameter(request, prefix +	"cntr16_qty".trim(),	length));
				String[] cntr29Qty =	(JSPUtil.getParameter(request, prefix +	"cntr29_qty".trim(),	length));
				String[] typeNm =	(JSPUtil.getParameter(request, prefix +	"type_nm".trim(),	length));
				String[] cntr10Qty =	(JSPUtil.getParameter(request, prefix +	"cntr10_qty".trim(),	length));
				String[] agmtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				String[] refNo =	(JSPUtil.getParameter(request, prefix +	"ref_no".trim(),	length));
				String[] cntr5Qty =	(JSPUtil.getParameter(request, prefix +	"cntr5_qty".trim(),	length));
				String[] cntr4Qty =	(JSPUtil.getParameter(request, prefix +	"cntr4_qty".trim(),	length));
				String[] cntr30Qty =	(JSPUtil.getParameter(request, prefix +	"cntr30_qty".trim(),	length));
				String[] cntr23Qty =	(JSPUtil.getParameter(request, prefix +	"cntr23_qty".trim(),	length));
				String[] cntr24Qty =	(JSPUtil.getParameter(request, prefix +	"cntr24_qty".trim(),	length));
				String[] cntr11Qty =	(JSPUtil.getParameter(request, prefix +	"cntr11_qty".trim(),	length));
				String[] cntr1Qty =	(JSPUtil.getParameter(request, prefix +	"cntr1_qty".trim(),	length));
				String[] cntr6Qty =	(JSPUtil.getParameter(request, prefix +	"cntr6_qty".trim(),	length));
				String[] cntr28Qty =	(JSPUtil.getParameter(request, prefix +	"cntr28_qty".trim(),	length));
				String[] cntr21Qty =	(JSPUtil.getParameter(request, prefix +	"cntr21_qty".trim(),	length));
				String[] vndrAbbrNm =	(JSPUtil.getParameter(request, prefix +	"vndr_abbr_nm".trim(),	length));
				String[] cntr7Qty =	(JSPUtil.getParameter(request, prefix +	"cntr7_qty".trim(),	length));
				String[] cntr27Qty =	(JSPUtil.getParameter(request, prefix +	"cntr27_qty".trim(),	length));
				String[] typeCd =	(JSPUtil.getParameter(request, prefix +	"type_cd".trim(),	length));
				String[] fstCls =	(JSPUtil.getParameter(request, prefix +	"fst_cls".trim(),	length));
				String[] sndCls =	(JSPUtil.getParameter(request, prefix +	"snd_cls".trim(),	length));
				String[] ttl =	(JSPUtil.getParameter(request, prefix +	"ttl".trim(),	length));
				String[] eqLocTpCd =	(JSPUtil.getParameter(request, prefix +	"eq_loc_tp_cd".trim(),	length));
				String[] locCd =	(JSPUtil.getParameter(request, prefix +	"loc_cd".trim(),	length));
				String[] yearBuilt =	(JSPUtil.getParameter(request, prefix +	"year_built".trim(),	length));
				String[] effectiveDt =	(JSPUtil.getParameter(request, prefix +	"effective_dt".trim(),	length));
				String[] expiryDt =	(JSPUtil.getParameter(request, prefix +	"expiry_dt".trim(),	length));
				String[] leaseTerm =	(JSPUtil.getParameter(request, prefix +	"lease_term".trim(),	length));
				String[] paymentTerm =	(JSPUtil.getParameter(request, prefix +	"payment_term".trim(),	length));
				String[] yearlyDepr =	(JSPUtil.getParameter(request, prefix +	"yearly_depr".trim(),	length));
				String[] maxDepr =	(JSPUtil.getParameter(request, prefix +	"max_depr".trim(),	length));
				String[] slbFlg =	(JSPUtil.getParameter(request, prefix +	"slb_flg".trim(),	length));
				String[] lsePayTpCd =	(JSPUtil.getParameter(request, prefix +	"lse_pay_tp_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AgreementListVO();
						if ( cntr12Qty[i] !=	null)
						model.setCntr12Qty( cntr12Qty[i]);
						if ( cntr3Qty[i] !=	null)
						model.setCntr3Qty( cntr3Qty[i]);
						if ( cntr22Qty[i] !=	null)
						model.setCntr22Qty( cntr22Qty[i]);
						if ( cntr18Qty[i] !=	null)
						model.setCntr18Qty( cntr18Qty[i]);
						if ( cntr25Qty[i] !=	null)
						model.setCntr25Qty( cntr25Qty[i]);
						if ( cntr9Qty[i] !=	null)
						model.setCntr9Qty( cntr9Qty[i]);
						if ( cntr13Qty[i] !=	null)
						model.setCntr13Qty( cntr13Qty[i]);
						if ( cntr8Qty[i] !=	null)
						model.setCntr8Qty( cntr8Qty[i]);
						if ( cntr20Qty[i] !=	null)
						model.setCntr20Qty( cntr20Qty[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( effDt[i] !=	null)
						model.setEffDt( effDt[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( cntr14Qty[i] !=	null)
						model.setCntr14Qty( cntr14Qty[i]);
						if ( cntr26Qty[i] !=	null)
						model.setCntr26Qty( cntr26Qty[i]);
						if ( cntr19Qty[i] !=	null)
						model.setCntr19Qty( cntr19Qty[i]);
						if ( cntr15Qty[i] !=	null)
						model.setCntr15Qty( cntr15Qty[i]);
						if ( cntr17Qty[i] !=	null)
						model.setCntr17Qty( cntr17Qty[i]);
						if ( expDt[i] !=	null)
						model.setExpDt( expDt[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( locCdTeuNo[i] !=	null)
						model.setLocCdTeuNo( locCdTeuNo[i]);
						if ( cntr2Qty[i] !=	null)
						model.setCntr2Qty( cntr2Qty[i]);
						if ( cntr16Qty[i] !=	null)
						model.setCntr16Qty( cntr16Qty[i]);
						if ( cntr29Qty[i] !=	null)
						model.setCntr29Qty( cntr29Qty[i]);
						if ( typeNm[i] !=	null)
						model.setTypeNm( typeNm[i]);
						if ( cntr10Qty[i] !=	null)
						model.setCntr10Qty( cntr10Qty[i]);
						if ( agmtNo[i] !=	null)
						model.setAgmtNo( agmtNo[i]);
						if ( refNo[i] !=	null)
						model.setRefNo( refNo[i]);
						if ( cntr5Qty[i] !=	null)
						model.setCntr5Qty( cntr5Qty[i]);
						if ( cntr4Qty[i] !=	null)
						model.setCntr4Qty( cntr4Qty[i]);
						if ( cntr30Qty[i] !=	null)
						model.setCntr30Qty( cntr30Qty[i]);
						if ( cntr23Qty[i] !=	null)
						model.setCntr23Qty( cntr23Qty[i]);
						if ( cntr24Qty[i] !=	null)
						model.setCntr24Qty( cntr24Qty[i]);
						if ( cntr11Qty[i] !=	null)
						model.setCntr11Qty( cntr11Qty[i]);
						if ( cntr1Qty[i] !=	null)
						model.setCntr1Qty( cntr1Qty[i]);
						if ( cntr6Qty[i] !=	null)
						model.setCntr6Qty( cntr6Qty[i]);
						if ( cntr28Qty[i] !=	null)
						model.setCntr28Qty( cntr28Qty[i]);
						if ( cntr21Qty[i] !=	null)
						model.setCntr21Qty( cntr21Qty[i]);
						if ( vndrAbbrNm[i] !=	null)
						model.setVndrAbbrNm( vndrAbbrNm[i]);
						if ( cntr7Qty[i] !=	null)
						model.setCntr7Qty( cntr7Qty[i]);
						if ( cntr27Qty[i] !=	null)
						model.setCntr27Qty( cntr27Qty[i]);
						if ( typeCd[i] !=	null)
						model.setTypeCd( typeCd[i]);
						if ( fstCls[i] !=	null)
						model.setFstCls( fstCls[i]);
						if ( sndCls[i] !=	null)
						model.setSndCls( sndCls[i]);
						if ( ttl[i] !=	null)
						model.setTtl( ttl[i]);
						if ( eqLocTpCd[i] !=	null)
						model.setEqLocTpCd( eqLocTpCd[i]);
						if ( locCd[i] !=	null)
						model.setLocCd( locCd[i]);
						if ( yearBuilt[i] !=	null)
						model.setYearBuilt( yearBuilt[i]);
						if ( effectiveDt[i] !=	null)
						model.setEffectiveDt( effectiveDt[i]);
						if ( expiryDt[i] !=	null)
						model.setExpiryDt( expiryDt[i]);
						if ( leaseTerm[i] !=	null)
						model.setLeaseTerm( leaseTerm[i]);
						if ( paymentTerm[i] !=	null)
						model.setPaymentTerm( paymentTerm[i]);
						if ( yearlyDepr[i] !=	null)
						model.setYearlyDepr( yearlyDepr[i]);
						if ( maxDepr[i] !=	null)
						model.setMaxDepr( maxDepr[i]);
						if ( slbFlg[i] !=	null)
						model.setSlbFlg( slbFlg[i]);
						if ( lsePayTpCd[i] !=	null)
						model.setLsePayTpCd( lsePayTpCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAgreementListVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return AgreementListVO[]
	 */
	public AgreementListVO[]	 getAgreementListVOs(){
		AgreementListVO[] vos = (AgreementListVO[])models.toArray(new	AgreementListVO[models.size()]);
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
		this.cntr12Qty =	this.cntr12Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr3Qty =	this.cntr3Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr22Qty =	this.cntr22Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr18Qty =	this.cntr18Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr25Qty =	this.cntr25Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr9Qty =	this.cntr9Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr13Qty =	this.cntr13Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr8Qty =	this.cntr8Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20Qty =	this.cntr20Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt =	this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr14Qty =	this.cntr14Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr26Qty =	this.cntr26Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr19Qty =	this.cntr19Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr15Qty =	this.cntr15Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr17Qty =	this.cntr17Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt =	this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCdTeuNo =	this.locCdTeuNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr2Qty =	this.cntr2Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr16Qty =	this.cntr16Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr29Qty =	this.cntr29Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeNm =	this.typeNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr10Qty =	this.cntr10Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo =	this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo =	this.refNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr5Qty =	this.cntr5Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr4Qty =	this.cntr4Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr30Qty =	this.cntr30Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr23Qty =	this.cntr23Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr24Qty =	this.cntr24Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr11Qty =	this.cntr11Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr1Qty =	this.cntr1Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr6Qty =	this.cntr6Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr28Qty =	this.cntr28Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr21Qty =	this.cntr21Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm =	this.vndrAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr7Qty =	this.cntr7Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr27Qty =	this.cntr27Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeCd =	this.typeCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fstCls =	this.fstCls.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndCls =	this.sndCls.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl =	this.ttl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLocTpCd =	this.eqLocTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd =	this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yearBuilt =	this.yearBuilt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effectiveDt =	this.effectiveDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expiryDt =	this.expiryDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leaseTerm =	this.leaseTerm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paymentTerm =	this.paymentTerm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yearlyDepr =	this.yearlyDepr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxDepr =	this.maxDepr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slbFlg =	this.slbFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsePayTpCd =	this.lsePayTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}