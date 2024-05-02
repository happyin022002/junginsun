/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchYearSubleaseDetailPlanWeeklyVO.java
*@FileTitle : SearchYearSubleaseDetailPlanWeeklyVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           			modifier date    explanation
* 1		1.0		Lee Byoung Hun		2009.07.15		1.0 최초 생성
*
*@LastModifyDate : 2009.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchYearSubleaseDetailPlanWeeklyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchYearSubleaseDetailPlanWeeklyVO> models = new ArrayList<SearchYearSubleaseDetailPlanWeeklyVO>();
	
	/* Column Info */
	private String s32CntrVolQty = null;
	/* Column Info */
	private String s3ToEccCd = null;
	/* Column Info */
	private String s34CntrVolQty = null;
	/* Column Info */
	private String s311CntrVolQty = null;
	/* Column Info */
	private String s320CntrVolQty = null;
	/* Column Info */
	private String s310CntrVolQty = null;
	/* Column Info */
	private String s331CntrVolQty = null;
	/* Column Info */
	private String s344CntrVolQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String s340CntrVolQty = null;
	/* Column Info */
	private String s352CntrVolQty = null;
	/* Column Info */
	private String s324CntrVolQty = null;
	/* Column Info */
	private String s329CntrVolQty = null;
	/* Column Info */
	private String s341CntrVolQty = null;
	/* Column Info */
	private String s3CntrTpszCd = null;
	/* Column Info */
	private String s348CntrVolQty = null;
	/* Column Info */
	private String s347CntrVolQty = null;
	/* Column Info */
	private String s33CntrVolQty = null;
	/* Column Info */
	private String s328CntrVolQty = null;
	/* Column Info */
	private String s37CntrVolQty = null;
	/* Column Info */
	private String s36CntrVolQty = null;
	/* Column Info */
	private String s322CntrVolQty = null;
	/* Column Info */
	private String s321CntrVolQty = null;
	/* Column Info */
	private String s314CntrVolQty = null;
	/* Column Info */
	private String s335CntrVolQty = null;
	/* Column Info */
	private String s325CntrVolQty = null;
	/* Column Info */
	private String timegap = null;
	/* Column Info */
	private String s330CntrVolQty = null;
	/* Column Info */
	private String s3FmRccCd = null;
	/* Column Info */
	private String s323CntrVolQty = null;
	/* Column Info */
	private String s31CntrVolQty = null;
	/* Column Info */
	private String s316CntrVolQty = null;
	/* Column Info */
	private String s319CntrVolQty = null;
	/* Column Info */
	private String s312CntrVolQty = null;
	/* Column Info */
	private String s38CntrVolQty = null;
	/* Column Info */
	private String s3FmEccCd = null;
	/* Column Info */
	private String s326CntrVolQty = null;
	/* Column Info */
	private String s337CntrVolQty = null;
	/* Column Info */
	private String s317CntrVolQty = null;
	/* Column Info */
	private String s336CntrVolQty = null;
	/* Column Info */
	private String s3DmstRto = null;
	/* Column Info */
	private String s349CntrVolQty = null;
	/* Column Info */
	private String s333CntrVolQty = null;
	/* Column Info */
	private String s334CntrVolQty = null;
	/* Column Info */
	private String s315CntrVolQty = null;
	/* Column Info */
	private String s351CntrVolQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String s332CntrVolQty = null;
	/* Column Info */
	private String s342CntrVolQty = null;
	/* Column Info */
	private String s313CntrVolQty = null;
	/* Column Info */
	private String s338CntrVolQty = null;
	/* Column Info */
	private String s35CntrVolQty = null;
	/* Column Info */
	private String s343CntrVolQty = null;
	/* Column Info */
	private String s3PlnYr = null;
	/* Column Info */
	private String s350CntrVolQty = null;
	/* Column Info */
	private String s318CntrVolQty = null;
	/* Column Info */
	private String s39CntrVolQty = null;
	/* Column Info */
	private String s346CntrVolQty = null;
	/* Column Info */
	private String s353CntrVolQty = null;
	/* Column Info */
	private String s345CntrVolQty = null;
	/* Column Info */
	private String s339CntrVolQty = null;
	/* Column Info */
	private String s327CntrVolQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchYearSubleaseDetailPlanWeeklyVO() {}

	public SearchYearSubleaseDetailPlanWeeklyVO(String ibflag, String pagerows, String s3FmRccCd, String s3FmEccCd, String s3ToEccCd, String s3CntrTpszCd, String s3DmstRto, String s31CntrVolQty, String s32CntrVolQty, String s33CntrVolQty, String s34CntrVolQty, String s35CntrVolQty, String s36CntrVolQty, String s37CntrVolQty, String s38CntrVolQty, String s39CntrVolQty, String s310CntrVolQty, String s311CntrVolQty, String s312CntrVolQty, String s313CntrVolQty, String s314CntrVolQty, String s315CntrVolQty, String s316CntrVolQty, String s317CntrVolQty, String s318CntrVolQty, String s319CntrVolQty, String s320CntrVolQty, String s321CntrVolQty, String s322CntrVolQty, String s323CntrVolQty, String s324CntrVolQty, String s325CntrVolQty, String s326CntrVolQty, String s327CntrVolQty, String s328CntrVolQty, String s329CntrVolQty, String s330CntrVolQty, String s331CntrVolQty, String s332CntrVolQty, String s333CntrVolQty, String s334CntrVolQty, String s335CntrVolQty, String s336CntrVolQty, String s337CntrVolQty, String s338CntrVolQty, String s339CntrVolQty, String s340CntrVolQty, String s341CntrVolQty, String s342CntrVolQty, String s343CntrVolQty, String s344CntrVolQty, String s345CntrVolQty, String s346CntrVolQty, String s347CntrVolQty, String s348CntrVolQty, String s349CntrVolQty, String s350CntrVolQty, String s351CntrVolQty, String s352CntrVolQty, String s353CntrVolQty, String s3PlnYr, String timegap) {
		this.s32CntrVolQty = s32CntrVolQty;
		this.s3ToEccCd = s3ToEccCd;
		this.s34CntrVolQty = s34CntrVolQty;
		this.s311CntrVolQty = s311CntrVolQty;
		this.s320CntrVolQty = s320CntrVolQty;
		this.s310CntrVolQty = s310CntrVolQty;
		this.s331CntrVolQty = s331CntrVolQty;
		this.s344CntrVolQty = s344CntrVolQty;
		this.pagerows = pagerows;
		this.s340CntrVolQty = s340CntrVolQty;
		this.s352CntrVolQty = s352CntrVolQty;
		this.s324CntrVolQty = s324CntrVolQty;
		this.s329CntrVolQty = s329CntrVolQty;
		this.s341CntrVolQty = s341CntrVolQty;
		this.s3CntrTpszCd = s3CntrTpszCd;
		this.s348CntrVolQty = s348CntrVolQty;
		this.s347CntrVolQty = s347CntrVolQty;
		this.s33CntrVolQty = s33CntrVolQty;
		this.s328CntrVolQty = s328CntrVolQty;
		this.s37CntrVolQty = s37CntrVolQty;
		this.s36CntrVolQty = s36CntrVolQty;
		this.s322CntrVolQty = s322CntrVolQty;
		this.s321CntrVolQty = s321CntrVolQty;
		this.s314CntrVolQty = s314CntrVolQty;
		this.s335CntrVolQty = s335CntrVolQty;
		this.s325CntrVolQty = s325CntrVolQty;
		this.timegap = timegap;
		this.s330CntrVolQty = s330CntrVolQty;
		this.s3FmRccCd = s3FmRccCd;
		this.s323CntrVolQty = s323CntrVolQty;
		this.s31CntrVolQty = s31CntrVolQty;
		this.s316CntrVolQty = s316CntrVolQty;
		this.s319CntrVolQty = s319CntrVolQty;
		this.s312CntrVolQty = s312CntrVolQty;
		this.s38CntrVolQty = s38CntrVolQty;
		this.s3FmEccCd = s3FmEccCd;
		this.s326CntrVolQty = s326CntrVolQty;
		this.s337CntrVolQty = s337CntrVolQty;
		this.s317CntrVolQty = s317CntrVolQty;
		this.s336CntrVolQty = s336CntrVolQty;
		this.s3DmstRto = s3DmstRto;
		this.s349CntrVolQty = s349CntrVolQty;
		this.s333CntrVolQty = s333CntrVolQty;
		this.s334CntrVolQty = s334CntrVolQty;
		this.s315CntrVolQty = s315CntrVolQty;
		this.s351CntrVolQty = s351CntrVolQty;
		this.ibflag = ibflag;
		this.s332CntrVolQty = s332CntrVolQty;
		this.s342CntrVolQty = s342CntrVolQty;
		this.s313CntrVolQty = s313CntrVolQty;
		this.s338CntrVolQty = s338CntrVolQty;
		this.s35CntrVolQty = s35CntrVolQty;
		this.s343CntrVolQty = s343CntrVolQty;
		this.s3PlnYr = s3PlnYr;
		this.s350CntrVolQty = s350CntrVolQty;
		this.s318CntrVolQty = s318CntrVolQty;
		this.s39CntrVolQty = s39CntrVolQty;
		this.s346CntrVolQty = s346CntrVolQty;
		this.s353CntrVolQty = s353CntrVolQty;
		this.s345CntrVolQty = s345CntrVolQty;
		this.s339CntrVolQty = s339CntrVolQty;
		this.s327CntrVolQty = s327CntrVolQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s3_2_cntr_vol_qty", getS32CntrVolQty());
		this.hashColumns.put("s3_to_ecc_cd", getS3ToEccCd());
		this.hashColumns.put("s3_4_cntr_vol_qty", getS34CntrVolQty());
		this.hashColumns.put("s3_11_cntr_vol_qty", getS311CntrVolQty());
		this.hashColumns.put("s3_20_cntr_vol_qty", getS320CntrVolQty());
		this.hashColumns.put("s3_10_cntr_vol_qty", getS310CntrVolQty());
		this.hashColumns.put("s3_31_cntr_vol_qty", getS331CntrVolQty());
		this.hashColumns.put("s3_44_cntr_vol_qty", getS344CntrVolQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s3_40_cntr_vol_qty", getS340CntrVolQty());
		this.hashColumns.put("s3_52_cntr_vol_qty", getS352CntrVolQty());
		this.hashColumns.put("s3_24_cntr_vol_qty", getS324CntrVolQty());
		this.hashColumns.put("s3_29_cntr_vol_qty", getS329CntrVolQty());
		this.hashColumns.put("s3_41_cntr_vol_qty", getS341CntrVolQty());
		this.hashColumns.put("s3_cntr_tpsz_cd", getS3CntrTpszCd());
		this.hashColumns.put("s3_48_cntr_vol_qty", getS348CntrVolQty());
		this.hashColumns.put("s3_47_cntr_vol_qty", getS347CntrVolQty());
		this.hashColumns.put("s3_3_cntr_vol_qty", getS33CntrVolQty());
		this.hashColumns.put("s3_28_cntr_vol_qty", getS328CntrVolQty());
		this.hashColumns.put("s3_7_cntr_vol_qty", getS37CntrVolQty());
		this.hashColumns.put("s3_6_cntr_vol_qty", getS36CntrVolQty());
		this.hashColumns.put("s3_22_cntr_vol_qty", getS322CntrVolQty());
		this.hashColumns.put("s3_21_cntr_vol_qty", getS321CntrVolQty());
		this.hashColumns.put("s3_14_cntr_vol_qty", getS314CntrVolQty());
		this.hashColumns.put("s3_35_cntr_vol_qty", getS335CntrVolQty());
		this.hashColumns.put("s3_25_cntr_vol_qty", getS325CntrVolQty());
		this.hashColumns.put("timegap", getTimegap());
		this.hashColumns.put("s3_30_cntr_vol_qty", getS330CntrVolQty());
		this.hashColumns.put("s3_fm_rcc_cd", getS3FmRccCd());
		this.hashColumns.put("s3_23_cntr_vol_qty", getS323CntrVolQty());
		this.hashColumns.put("s3_1_cntr_vol_qty", getS31CntrVolQty());
		this.hashColumns.put("s3_16_cntr_vol_qty", getS316CntrVolQty());
		this.hashColumns.put("s3_19_cntr_vol_qty", getS319CntrVolQty());
		this.hashColumns.put("s3_12_cntr_vol_qty", getS312CntrVolQty());
		this.hashColumns.put("s3_8_cntr_vol_qty", getS38CntrVolQty());
		this.hashColumns.put("s3_fm_ecc_cd", getS3FmEccCd());
		this.hashColumns.put("s3_26_cntr_vol_qty", getS326CntrVolQty());
		this.hashColumns.put("s3_37_cntr_vol_qty", getS337CntrVolQty());
		this.hashColumns.put("s3_17_cntr_vol_qty", getS317CntrVolQty());
		this.hashColumns.put("s3_36_cntr_vol_qty", getS336CntrVolQty());
		this.hashColumns.put("s3_dmst_rto", getS3DmstRto());
		this.hashColumns.put("s3_49_cntr_vol_qty", getS349CntrVolQty());
		this.hashColumns.put("s3_33_cntr_vol_qty", getS333CntrVolQty());
		this.hashColumns.put("s3_34_cntr_vol_qty", getS334CntrVolQty());
		this.hashColumns.put("s3_15_cntr_vol_qty", getS315CntrVolQty());
		this.hashColumns.put("s3_51_cntr_vol_qty", getS351CntrVolQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s3_32_cntr_vol_qty", getS332CntrVolQty());
		this.hashColumns.put("s3_42_cntr_vol_qty", getS342CntrVolQty());
		this.hashColumns.put("s3_13_cntr_vol_qty", getS313CntrVolQty());
		this.hashColumns.put("s3_38_cntr_vol_qty", getS338CntrVolQty());
		this.hashColumns.put("s3_5_cntr_vol_qty", getS35CntrVolQty());
		this.hashColumns.put("s3_43_cntr_vol_qty", getS343CntrVolQty());
		this.hashColumns.put("s3_pln_yr", getS3PlnYr());
		this.hashColumns.put("s3_50_cntr_vol_qty", getS350CntrVolQty());
		this.hashColumns.put("s3_18_cntr_vol_qty", getS318CntrVolQty());
		this.hashColumns.put("s3_9_cntr_vol_qty", getS39CntrVolQty());
		this.hashColumns.put("s3_46_cntr_vol_qty", getS346CntrVolQty());
		this.hashColumns.put("s3_53_cntr_vol_qty", getS353CntrVolQty());
		this.hashColumns.put("s3_45_cntr_vol_qty", getS345CntrVolQty());
		this.hashColumns.put("s3_39_cntr_vol_qty", getS339CntrVolQty());
		this.hashColumns.put("s3_27_cntr_vol_qty", getS327CntrVolQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s3_2_cntr_vol_qty", "s32CntrVolQty");
		this.hashFields.put("s3_to_ecc_cd", "s3ToEccCd");
		this.hashFields.put("s3_4_cntr_vol_qty", "s34CntrVolQty");
		this.hashFields.put("s3_11_cntr_vol_qty", "s311CntrVolQty");
		this.hashFields.put("s3_20_cntr_vol_qty", "s320CntrVolQty");
		this.hashFields.put("s3_10_cntr_vol_qty", "s310CntrVolQty");
		this.hashFields.put("s3_31_cntr_vol_qty", "s331CntrVolQty");
		this.hashFields.put("s3_44_cntr_vol_qty", "s344CntrVolQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s3_40_cntr_vol_qty", "s340CntrVolQty");
		this.hashFields.put("s3_52_cntr_vol_qty", "s352CntrVolQty");
		this.hashFields.put("s3_24_cntr_vol_qty", "s324CntrVolQty");
		this.hashFields.put("s3_29_cntr_vol_qty", "s329CntrVolQty");
		this.hashFields.put("s3_41_cntr_vol_qty", "s341CntrVolQty");
		this.hashFields.put("s3_cntr_tpsz_cd", "s3CntrTpszCd");
		this.hashFields.put("s3_48_cntr_vol_qty", "s348CntrVolQty");
		this.hashFields.put("s3_47_cntr_vol_qty", "s347CntrVolQty");
		this.hashFields.put("s3_3_cntr_vol_qty", "s33CntrVolQty");
		this.hashFields.put("s3_28_cntr_vol_qty", "s328CntrVolQty");
		this.hashFields.put("s3_7_cntr_vol_qty", "s37CntrVolQty");
		this.hashFields.put("s3_6_cntr_vol_qty", "s36CntrVolQty");
		this.hashFields.put("s3_22_cntr_vol_qty", "s322CntrVolQty");
		this.hashFields.put("s3_21_cntr_vol_qty", "s321CntrVolQty");
		this.hashFields.put("s3_14_cntr_vol_qty", "s314CntrVolQty");
		this.hashFields.put("s3_35_cntr_vol_qty", "s335CntrVolQty");
		this.hashFields.put("s3_25_cntr_vol_qty", "s325CntrVolQty");
		this.hashFields.put("timegap", "timegap");
		this.hashFields.put("s3_30_cntr_vol_qty", "s330CntrVolQty");
		this.hashFields.put("s3_fm_rcc_cd", "s3FmRccCd");
		this.hashFields.put("s3_23_cntr_vol_qty", "s323CntrVolQty");
		this.hashFields.put("s3_1_cntr_vol_qty", "s31CntrVolQty");
		this.hashFields.put("s3_16_cntr_vol_qty", "s316CntrVolQty");
		this.hashFields.put("s3_19_cntr_vol_qty", "s319CntrVolQty");
		this.hashFields.put("s3_12_cntr_vol_qty", "s312CntrVolQty");
		this.hashFields.put("s3_8_cntr_vol_qty", "s38CntrVolQty");
		this.hashFields.put("s3_fm_ecc_cd", "s3FmEccCd");
		this.hashFields.put("s3_26_cntr_vol_qty", "s326CntrVolQty");
		this.hashFields.put("s3_37_cntr_vol_qty", "s337CntrVolQty");
		this.hashFields.put("s3_17_cntr_vol_qty", "s317CntrVolQty");
		this.hashFields.put("s3_36_cntr_vol_qty", "s336CntrVolQty");
		this.hashFields.put("s3_dmst_rto", "s3DmstRto");
		this.hashFields.put("s3_49_cntr_vol_qty", "s349CntrVolQty");
		this.hashFields.put("s3_33_cntr_vol_qty", "s333CntrVolQty");
		this.hashFields.put("s3_34_cntr_vol_qty", "s334CntrVolQty");
		this.hashFields.put("s3_15_cntr_vol_qty", "s315CntrVolQty");
		this.hashFields.put("s3_51_cntr_vol_qty", "s351CntrVolQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s3_32_cntr_vol_qty", "s332CntrVolQty");
		this.hashFields.put("s3_42_cntr_vol_qty", "s342CntrVolQty");
		this.hashFields.put("s3_13_cntr_vol_qty", "s313CntrVolQty");
		this.hashFields.put("s3_38_cntr_vol_qty", "s338CntrVolQty");
		this.hashFields.put("s3_5_cntr_vol_qty", "s35CntrVolQty");
		this.hashFields.put("s3_43_cntr_vol_qty", "s343CntrVolQty");
		this.hashFields.put("s3_pln_yr", "s3PlnYr");
		this.hashFields.put("s3_50_cntr_vol_qty", "s350CntrVolQty");
		this.hashFields.put("s3_18_cntr_vol_qty", "s318CntrVolQty");
		this.hashFields.put("s3_9_cntr_vol_qty", "s39CntrVolQty");
		this.hashFields.put("s3_46_cntr_vol_qty", "s346CntrVolQty");
		this.hashFields.put("s3_53_cntr_vol_qty", "s353CntrVolQty");
		this.hashFields.put("s3_45_cntr_vol_qty", "s345CntrVolQty");
		this.hashFields.put("s3_39_cntr_vol_qty", "s339CntrVolQty");
		this.hashFields.put("s3_27_cntr_vol_qty", "s327CntrVolQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return s32CntrVolQty
	 */
	public String getS32CntrVolQty() {
		return this.s32CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s3ToEccCd
	 */
	public String getS3ToEccCd() {
		return this.s3ToEccCd;
	}
	
	/**
	 * Column Info
	 * @return s34CntrVolQty
	 */
	public String getS34CntrVolQty() {
		return this.s34CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s311CntrVolQty
	 */
	public String getS311CntrVolQty() {
		return this.s311CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s320CntrVolQty
	 */
	public String getS320CntrVolQty() {
		return this.s320CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s310CntrVolQty
	 */
	public String getS310CntrVolQty() {
		return this.s310CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s331CntrVolQty
	 */
	public String getS331CntrVolQty() {
		return this.s331CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s344CntrVolQty
	 */
	public String getS344CntrVolQty() {
		return this.s344CntrVolQty;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return s340CntrVolQty
	 */
	public String getS340CntrVolQty() {
		return this.s340CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s352CntrVolQty
	 */
	public String getS352CntrVolQty() {
		return this.s352CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s324CntrVolQty
	 */
	public String getS324CntrVolQty() {
		return this.s324CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s329CntrVolQty
	 */
	public String getS329CntrVolQty() {
		return this.s329CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s341CntrVolQty
	 */
	public String getS341CntrVolQty() {
		return this.s341CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s3CntrTpszCd
	 */
	public String getS3CntrTpszCd() {
		return this.s3CntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return s348CntrVolQty
	 */
	public String getS348CntrVolQty() {
		return this.s348CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s347CntrVolQty
	 */
	public String getS347CntrVolQty() {
		return this.s347CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s33CntrVolQty
	 */
	public String getS33CntrVolQty() {
		return this.s33CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s328CntrVolQty
	 */
	public String getS328CntrVolQty() {
		return this.s328CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s37CntrVolQty
	 */
	public String getS37CntrVolQty() {
		return this.s37CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s36CntrVolQty
	 */
	public String getS36CntrVolQty() {
		return this.s36CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s322CntrVolQty
	 */
	public String getS322CntrVolQty() {
		return this.s322CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s321CntrVolQty
	 */
	public String getS321CntrVolQty() {
		return this.s321CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s314CntrVolQty
	 */
	public String getS314CntrVolQty() {
		return this.s314CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s335CntrVolQty
	 */
	public String getS335CntrVolQty() {
		return this.s335CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s325CntrVolQty
	 */
	public String getS325CntrVolQty() {
		return this.s325CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return timegap
	 */
	public String getTimegap() {
		return this.timegap;
	}
	
	/**
	 * Column Info
	 * @return s330CntrVolQty
	 */
	public String getS330CntrVolQty() {
		return this.s330CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s3FmRccCd
	 */
	public String getS3FmRccCd() {
		return this.s3FmRccCd;
	}
	
	/**
	 * Column Info
	 * @return s323CntrVolQty
	 */
	public String getS323CntrVolQty() {
		return this.s323CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s31CntrVolQty
	 */
	public String getS31CntrVolQty() {
		return this.s31CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s316CntrVolQty
	 */
	public String getS316CntrVolQty() {
		return this.s316CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s319CntrVolQty
	 */
	public String getS319CntrVolQty() {
		return this.s319CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s312CntrVolQty
	 */
	public String getS312CntrVolQty() {
		return this.s312CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s38CntrVolQty
	 */
	public String getS38CntrVolQty() {
		return this.s38CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s3FmEccCd
	 */
	public String getS3FmEccCd() {
		return this.s3FmEccCd;
	}
	
	/**
	 * Column Info
	 * @return s326CntrVolQty
	 */
	public String getS326CntrVolQty() {
		return this.s326CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s337CntrVolQty
	 */
	public String getS337CntrVolQty() {
		return this.s337CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s317CntrVolQty
	 */
	public String getS317CntrVolQty() {
		return this.s317CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s336CntrVolQty
	 */
	public String getS336CntrVolQty() {
		return this.s336CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s3DmstRto
	 */
	public String getS3DmstRto() {
		return this.s3DmstRto;
	}
	
	/**
	 * Column Info
	 * @return s349CntrVolQty
	 */
	public String getS349CntrVolQty() {
		return this.s349CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s333CntrVolQty
	 */
	public String getS333CntrVolQty() {
		return this.s333CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s334CntrVolQty
	 */
	public String getS334CntrVolQty() {
		return this.s334CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s315CntrVolQty
	 */
	public String getS315CntrVolQty() {
		return this.s315CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s351CntrVolQty
	 */
	public String getS351CntrVolQty() {
		return this.s351CntrVolQty;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return s332CntrVolQty
	 */
	public String getS332CntrVolQty() {
		return this.s332CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s342CntrVolQty
	 */
	public String getS342CntrVolQty() {
		return this.s342CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s313CntrVolQty
	 */
	public String getS313CntrVolQty() {
		return this.s313CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s338CntrVolQty
	 */
	public String getS338CntrVolQty() {
		return this.s338CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s35CntrVolQty
	 */
	public String getS35CntrVolQty() {
		return this.s35CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s343CntrVolQty
	 */
	public String getS343CntrVolQty() {
		return this.s343CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s3PlnYr
	 */
	public String getS3PlnYr() {
		return this.s3PlnYr;
	}
	
	/**
	 * Column Info
	 * @return s350CntrVolQty
	 */
	public String getS350CntrVolQty() {
		return this.s350CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s318CntrVolQty
	 */
	public String getS318CntrVolQty() {
		return this.s318CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s39CntrVolQty
	 */
	public String getS39CntrVolQty() {
		return this.s39CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s346CntrVolQty
	 */
	public String getS346CntrVolQty() {
		return this.s346CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s353CntrVolQty
	 */
	public String getS353CntrVolQty() {
		return this.s353CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s345CntrVolQty
	 */
	public String getS345CntrVolQty() {
		return this.s345CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s339CntrVolQty
	 */
	public String getS339CntrVolQty() {
		return this.s339CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s327CntrVolQty
	 */
	public String getS327CntrVolQty() {
		return this.s327CntrVolQty;
	}
	

	/**
	 * Column Info
	 * @param s32CntrVolQty
	 */
	public void setS32CntrVolQty(String s32CntrVolQty) {
		this.s32CntrVolQty = s32CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s3ToEccCd
	 */
	public void setS3ToEccCd(String s3ToEccCd) {
		this.s3ToEccCd = s3ToEccCd;
	}
	
	/**
	 * Column Info
	 * @param s34CntrVolQty
	 */
	public void setS34CntrVolQty(String s34CntrVolQty) {
		this.s34CntrVolQty = s34CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s311CntrVolQty
	 */
	public void setS311CntrVolQty(String s311CntrVolQty) {
		this.s311CntrVolQty = s311CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s320CntrVolQty
	 */
	public void setS320CntrVolQty(String s320CntrVolQty) {
		this.s320CntrVolQty = s320CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s310CntrVolQty
	 */
	public void setS310CntrVolQty(String s310CntrVolQty) {
		this.s310CntrVolQty = s310CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s331CntrVolQty
	 */
	public void setS331CntrVolQty(String s331CntrVolQty) {
		this.s331CntrVolQty = s331CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s344CntrVolQty
	 */
	public void setS344CntrVolQty(String s344CntrVolQty) {
		this.s344CntrVolQty = s344CntrVolQty;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param s340CntrVolQty
	 */
	public void setS340CntrVolQty(String s340CntrVolQty) {
		this.s340CntrVolQty = s340CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s352CntrVolQty
	 */
	public void setS352CntrVolQty(String s352CntrVolQty) {
		this.s352CntrVolQty = s352CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s324CntrVolQty
	 */
	public void setS324CntrVolQty(String s324CntrVolQty) {
		this.s324CntrVolQty = s324CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s329CntrVolQty
	 */
	public void setS329CntrVolQty(String s329CntrVolQty) {
		this.s329CntrVolQty = s329CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s341CntrVolQty
	 */
	public void setS341CntrVolQty(String s341CntrVolQty) {
		this.s341CntrVolQty = s341CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s3CntrTpszCd
	 */
	public void setS3CntrTpszCd(String s3CntrTpszCd) {
		this.s3CntrTpszCd = s3CntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param s348CntrVolQty
	 */
	public void setS348CntrVolQty(String s348CntrVolQty) {
		this.s348CntrVolQty = s348CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s347CntrVolQty
	 */
	public void setS347CntrVolQty(String s347CntrVolQty) {
		this.s347CntrVolQty = s347CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s33CntrVolQty
	 */
	public void setS33CntrVolQty(String s33CntrVolQty) {
		this.s33CntrVolQty = s33CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s328CntrVolQty
	 */
	public void setS328CntrVolQty(String s328CntrVolQty) {
		this.s328CntrVolQty = s328CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s37CntrVolQty
	 */
	public void setS37CntrVolQty(String s37CntrVolQty) {
		this.s37CntrVolQty = s37CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s36CntrVolQty
	 */
	public void setS36CntrVolQty(String s36CntrVolQty) {
		this.s36CntrVolQty = s36CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s322CntrVolQty
	 */
	public void setS322CntrVolQty(String s322CntrVolQty) {
		this.s322CntrVolQty = s322CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s321CntrVolQty
	 */
	public void setS321CntrVolQty(String s321CntrVolQty) {
		this.s321CntrVolQty = s321CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s314CntrVolQty
	 */
	public void setS314CntrVolQty(String s314CntrVolQty) {
		this.s314CntrVolQty = s314CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s335CntrVolQty
	 */
	public void setS335CntrVolQty(String s335CntrVolQty) {
		this.s335CntrVolQty = s335CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s325CntrVolQty
	 */
	public void setS325CntrVolQty(String s325CntrVolQty) {
		this.s325CntrVolQty = s325CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param timegap
	 */
	public void setTimegap(String timegap) {
		this.timegap = timegap;
	}
	
	/**
	 * Column Info
	 * @param s330CntrVolQty
	 */
	public void setS330CntrVolQty(String s330CntrVolQty) {
		this.s330CntrVolQty = s330CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s3FmRccCd
	 */
	public void setS3FmRccCd(String s3FmRccCd) {
		this.s3FmRccCd = s3FmRccCd;
	}
	
	/**
	 * Column Info
	 * @param s323CntrVolQty
	 */
	public void setS323CntrVolQty(String s323CntrVolQty) {
		this.s323CntrVolQty = s323CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s31CntrVolQty
	 */
	public void setS31CntrVolQty(String s31CntrVolQty) {
		this.s31CntrVolQty = s31CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s316CntrVolQty
	 */
	public void setS316CntrVolQty(String s316CntrVolQty) {
		this.s316CntrVolQty = s316CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s319CntrVolQty
	 */
	public void setS319CntrVolQty(String s319CntrVolQty) {
		this.s319CntrVolQty = s319CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s312CntrVolQty
	 */
	public void setS312CntrVolQty(String s312CntrVolQty) {
		this.s312CntrVolQty = s312CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s38CntrVolQty
	 */
	public void setS38CntrVolQty(String s38CntrVolQty) {
		this.s38CntrVolQty = s38CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s3FmEccCd
	 */
	public void setS3FmEccCd(String s3FmEccCd) {
		this.s3FmEccCd = s3FmEccCd;
	}
	
	/**
	 * Column Info
	 * @param s326CntrVolQty
	 */
	public void setS326CntrVolQty(String s326CntrVolQty) {
		this.s326CntrVolQty = s326CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s337CntrVolQty
	 */
	public void setS337CntrVolQty(String s337CntrVolQty) {
		this.s337CntrVolQty = s337CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s317CntrVolQty
	 */
	public void setS317CntrVolQty(String s317CntrVolQty) {
		this.s317CntrVolQty = s317CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s336CntrVolQty
	 */
	public void setS336CntrVolQty(String s336CntrVolQty) {
		this.s336CntrVolQty = s336CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s3DmstRto
	 */
	public void setS3DmstRto(String s3DmstRto) {
		this.s3DmstRto = s3DmstRto;
	}
	
	/**
	 * Column Info
	 * @param s349CntrVolQty
	 */
	public void setS349CntrVolQty(String s349CntrVolQty) {
		this.s349CntrVolQty = s349CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s333CntrVolQty
	 */
	public void setS333CntrVolQty(String s333CntrVolQty) {
		this.s333CntrVolQty = s333CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s334CntrVolQty
	 */
	public void setS334CntrVolQty(String s334CntrVolQty) {
		this.s334CntrVolQty = s334CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s315CntrVolQty
	 */
	public void setS315CntrVolQty(String s315CntrVolQty) {
		this.s315CntrVolQty = s315CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s351CntrVolQty
	 */
	public void setS351CntrVolQty(String s351CntrVolQty) {
		this.s351CntrVolQty = s351CntrVolQty;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param s332CntrVolQty
	 */
	public void setS332CntrVolQty(String s332CntrVolQty) {
		this.s332CntrVolQty = s332CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s342CntrVolQty
	 */
	public void setS342CntrVolQty(String s342CntrVolQty) {
		this.s342CntrVolQty = s342CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s313CntrVolQty
	 */
	public void setS313CntrVolQty(String s313CntrVolQty) {
		this.s313CntrVolQty = s313CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s338CntrVolQty
	 */
	public void setS338CntrVolQty(String s338CntrVolQty) {
		this.s338CntrVolQty = s338CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s35CntrVolQty
	 */
	public void setS35CntrVolQty(String s35CntrVolQty) {
		this.s35CntrVolQty = s35CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s343CntrVolQty
	 */
	public void setS343CntrVolQty(String s343CntrVolQty) {
		this.s343CntrVolQty = s343CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s3PlnYr
	 */
	public void setS3PlnYr(String s3PlnYr) {
		this.s3PlnYr = s3PlnYr;
	}
	
	/**
	 * Column Info
	 * @param s350CntrVolQty
	 */
	public void setS350CntrVolQty(String s350CntrVolQty) {
		this.s350CntrVolQty = s350CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s318CntrVolQty
	 */
	public void setS318CntrVolQty(String s318CntrVolQty) {
		this.s318CntrVolQty = s318CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s39CntrVolQty
	 */
	public void setS39CntrVolQty(String s39CntrVolQty) {
		this.s39CntrVolQty = s39CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s346CntrVolQty
	 */
	public void setS346CntrVolQty(String s346CntrVolQty) {
		this.s346CntrVolQty = s346CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s353CntrVolQty
	 */
	public void setS353CntrVolQty(String s353CntrVolQty) {
		this.s353CntrVolQty = s353CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s345CntrVolQty
	 */
	public void setS345CntrVolQty(String s345CntrVolQty) {
		this.s345CntrVolQty = s345CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s339CntrVolQty
	 */
	public void setS339CntrVolQty(String s339CntrVolQty) {
		this.s339CntrVolQty = s339CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s327CntrVolQty
	 */
	public void setS327CntrVolQty(String s327CntrVolQty) {
		this.s327CntrVolQty = s327CntrVolQty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setS32CntrVolQty(JSPUtil.getParameter(request, "s3_2_cntr_vol_qty", ""));
		setS3ToEccCd(JSPUtil.getParameter(request, "s3_to_ecc_cd", ""));
		setS34CntrVolQty(JSPUtil.getParameter(request, "s3_4_cntr_vol_qty", ""));
		setS311CntrVolQty(JSPUtil.getParameter(request, "s3_11_cntr_vol_qty", ""));
		setS320CntrVolQty(JSPUtil.getParameter(request, "s3_20_cntr_vol_qty", ""));
		setS310CntrVolQty(JSPUtil.getParameter(request, "s3_10_cntr_vol_qty", ""));
		setS331CntrVolQty(JSPUtil.getParameter(request, "s3_31_cntr_vol_qty", ""));
		setS344CntrVolQty(JSPUtil.getParameter(request, "s3_44_cntr_vol_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setS340CntrVolQty(JSPUtil.getParameter(request, "s3_40_cntr_vol_qty", ""));
		setS352CntrVolQty(JSPUtil.getParameter(request, "s3_52_cntr_vol_qty", ""));
		setS324CntrVolQty(JSPUtil.getParameter(request, "s3_24_cntr_vol_qty", ""));
		setS329CntrVolQty(JSPUtil.getParameter(request, "s3_29_cntr_vol_qty", ""));
		setS341CntrVolQty(JSPUtil.getParameter(request, "s3_41_cntr_vol_qty", ""));
		setS3CntrTpszCd(JSPUtil.getParameter(request, "s3_cntr_tpsz_cd", ""));
		setS348CntrVolQty(JSPUtil.getParameter(request, "s3_48_cntr_vol_qty", ""));
		setS347CntrVolQty(JSPUtil.getParameter(request, "s3_47_cntr_vol_qty", ""));
		setS33CntrVolQty(JSPUtil.getParameter(request, "s3_3_cntr_vol_qty", ""));
		setS328CntrVolQty(JSPUtil.getParameter(request, "s3_28_cntr_vol_qty", ""));
		setS37CntrVolQty(JSPUtil.getParameter(request, "s3_7_cntr_vol_qty", ""));
		setS36CntrVolQty(JSPUtil.getParameter(request, "s3_6_cntr_vol_qty", ""));
		setS322CntrVolQty(JSPUtil.getParameter(request, "s3_22_cntr_vol_qty", ""));
		setS321CntrVolQty(JSPUtil.getParameter(request, "s3_21_cntr_vol_qty", ""));
		setS314CntrVolQty(JSPUtil.getParameter(request, "s3_14_cntr_vol_qty", ""));
		setS335CntrVolQty(JSPUtil.getParameter(request, "s3_35_cntr_vol_qty", ""));
		setS325CntrVolQty(JSPUtil.getParameter(request, "s3_25_cntr_vol_qty", ""));
		setTimegap(JSPUtil.getParameter(request, "timegap", ""));
		setS330CntrVolQty(JSPUtil.getParameter(request, "s3_30_cntr_vol_qty", ""));
		setS3FmRccCd(JSPUtil.getParameter(request, "s3_fm_rcc_cd", ""));
		setS323CntrVolQty(JSPUtil.getParameter(request, "s3_23_cntr_vol_qty", ""));
		setS31CntrVolQty(JSPUtil.getParameter(request, "s3_1_cntr_vol_qty", ""));
		setS316CntrVolQty(JSPUtil.getParameter(request, "s3_16_cntr_vol_qty", ""));
		setS319CntrVolQty(JSPUtil.getParameter(request, "s3_19_cntr_vol_qty", ""));
		setS312CntrVolQty(JSPUtil.getParameter(request, "s3_12_cntr_vol_qty", ""));
		setS38CntrVolQty(JSPUtil.getParameter(request, "s3_8_cntr_vol_qty", ""));
		setS3FmEccCd(JSPUtil.getParameter(request, "s3_fm_ecc_cd", ""));
		setS326CntrVolQty(JSPUtil.getParameter(request, "s3_26_cntr_vol_qty", ""));
		setS337CntrVolQty(JSPUtil.getParameter(request, "s3_37_cntr_vol_qty", ""));
		setS317CntrVolQty(JSPUtil.getParameter(request, "s3_17_cntr_vol_qty", ""));
		setS336CntrVolQty(JSPUtil.getParameter(request, "s3_36_cntr_vol_qty", ""));
		setS3DmstRto(JSPUtil.getParameter(request, "s3_dmst_rto", ""));
		setS349CntrVolQty(JSPUtil.getParameter(request, "s3_49_cntr_vol_qty", ""));
		setS333CntrVolQty(JSPUtil.getParameter(request, "s3_33_cntr_vol_qty", ""));
		setS334CntrVolQty(JSPUtil.getParameter(request, "s3_34_cntr_vol_qty", ""));
		setS315CntrVolQty(JSPUtil.getParameter(request, "s3_15_cntr_vol_qty", ""));
		setS351CntrVolQty(JSPUtil.getParameter(request, "s3_51_cntr_vol_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setS332CntrVolQty(JSPUtil.getParameter(request, "s3_32_cntr_vol_qty", ""));
		setS342CntrVolQty(JSPUtil.getParameter(request, "s3_42_cntr_vol_qty", ""));
		setS313CntrVolQty(JSPUtil.getParameter(request, "s3_13_cntr_vol_qty", ""));
		setS338CntrVolQty(JSPUtil.getParameter(request, "s3_38_cntr_vol_qty", ""));
		setS35CntrVolQty(JSPUtil.getParameter(request, "s3_5_cntr_vol_qty", ""));
		setS343CntrVolQty(JSPUtil.getParameter(request, "s3_43_cntr_vol_qty", ""));
		setS3PlnYr(JSPUtil.getParameter(request, "s3_pln_yr", ""));
		setS350CntrVolQty(JSPUtil.getParameter(request, "s3_50_cntr_vol_qty", ""));
		setS318CntrVolQty(JSPUtil.getParameter(request, "s3_18_cntr_vol_qty", ""));
		setS39CntrVolQty(JSPUtil.getParameter(request, "s3_9_cntr_vol_qty", ""));
		setS346CntrVolQty(JSPUtil.getParameter(request, "s3_46_cntr_vol_qty", ""));
		setS353CntrVolQty(JSPUtil.getParameter(request, "s3_53_cntr_vol_qty", ""));
		setS345CntrVolQty(JSPUtil.getParameter(request, "s3_45_cntr_vol_qty", ""));
		setS339CntrVolQty(JSPUtil.getParameter(request, "s3_39_cntr_vol_qty", ""));
		setS327CntrVolQty(JSPUtil.getParameter(request, "s3_27_cntr_vol_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchYearSubleaseDetailPlanWeeklyVO[]
	 */
	public SearchYearSubleaseDetailPlanWeeklyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchYearSubleaseDetailPlanWeeklyVO[]
	 */
	public SearchYearSubleaseDetailPlanWeeklyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchYearSubleaseDetailPlanWeeklyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] s32CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_2_cntr_vol_qty", length));
			String[] s3ToEccCd = (JSPUtil.getParameter(request, prefix	+ "s3_to_ecc_cd", length));
			String[] s34CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_4_cntr_vol_qty", length));
			String[] s311CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_11_cntr_vol_qty", length));
			String[] s320CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_20_cntr_vol_qty", length));
			String[] s310CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_10_cntr_vol_qty", length));
			String[] s331CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_31_cntr_vol_qty", length));
			String[] s344CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_44_cntr_vol_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] s340CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_40_cntr_vol_qty", length));
			String[] s352CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_52_cntr_vol_qty", length));
			String[] s324CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_24_cntr_vol_qty", length));
			String[] s329CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_29_cntr_vol_qty", length));
			String[] s341CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_41_cntr_vol_qty", length));
			String[] s3CntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "s3_cntr_tpsz_cd", length));
			String[] s348CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_48_cntr_vol_qty", length));
			String[] s347CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_47_cntr_vol_qty", length));
			String[] s33CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_3_cntr_vol_qty", length));
			String[] s328CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_28_cntr_vol_qty", length));
			String[] s37CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_7_cntr_vol_qty", length));
			String[] s36CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_6_cntr_vol_qty", length));
			String[] s322CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_22_cntr_vol_qty", length));
			String[] s321CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_21_cntr_vol_qty", length));
			String[] s314CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_14_cntr_vol_qty", length));
			String[] s335CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_35_cntr_vol_qty", length));
			String[] s325CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_25_cntr_vol_qty", length));
			String[] timegap = (JSPUtil.getParameter(request, prefix	+ "timegap", length));
			String[] s330CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_30_cntr_vol_qty", length));
			String[] s3FmRccCd = (JSPUtil.getParameter(request, prefix	+ "s3_fm_rcc_cd", length));
			String[] s323CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_23_cntr_vol_qty", length));
			String[] s31CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_1_cntr_vol_qty", length));
			String[] s316CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_16_cntr_vol_qty", length));
			String[] s319CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_19_cntr_vol_qty", length));
			String[] s312CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_12_cntr_vol_qty", length));
			String[] s38CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_8_cntr_vol_qty", length));
			String[] s3FmEccCd = (JSPUtil.getParameter(request, prefix	+ "s3_fm_ecc_cd", length));
			String[] s326CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_26_cntr_vol_qty", length));
			String[] s337CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_37_cntr_vol_qty", length));
			String[] s317CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_17_cntr_vol_qty", length));
			String[] s336CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_36_cntr_vol_qty", length));
			String[] s3DmstRto = (JSPUtil.getParameter(request, prefix	+ "s3_dmst_rto", length));
			String[] s349CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_49_cntr_vol_qty", length));
			String[] s333CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_33_cntr_vol_qty", length));
			String[] s334CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_34_cntr_vol_qty", length));
			String[] s315CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_15_cntr_vol_qty", length));
			String[] s351CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_51_cntr_vol_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] s332CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_32_cntr_vol_qty", length));
			String[] s342CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_42_cntr_vol_qty", length));
			String[] s313CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_13_cntr_vol_qty", length));
			String[] s338CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_38_cntr_vol_qty", length));
			String[] s35CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_5_cntr_vol_qty", length));
			String[] s343CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_43_cntr_vol_qty", length));
			String[] s3PlnYr = (JSPUtil.getParameter(request, prefix	+ "s3_pln_yr", length));
			String[] s350CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_50_cntr_vol_qty", length));
			String[] s318CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_18_cntr_vol_qty", length));
			String[] s39CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_9_cntr_vol_qty", length));
			String[] s346CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_46_cntr_vol_qty", length));
			String[] s353CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_53_cntr_vol_qty", length));
			String[] s345CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_45_cntr_vol_qty", length));
			String[] s339CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_39_cntr_vol_qty", length));
			String[] s327CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s3_27_cntr_vol_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchYearSubleaseDetailPlanWeeklyVO();
				if (s32CntrVolQty[i] != null)
					model.setS32CntrVolQty(s32CntrVolQty[i]);
				if (s3ToEccCd[i] != null)
					model.setS3ToEccCd(s3ToEccCd[i]);
				if (s34CntrVolQty[i] != null)
					model.setS34CntrVolQty(s34CntrVolQty[i]);
				if (s311CntrVolQty[i] != null)
					model.setS311CntrVolQty(s311CntrVolQty[i]);
				if (s320CntrVolQty[i] != null)
					model.setS320CntrVolQty(s320CntrVolQty[i]);
				if (s310CntrVolQty[i] != null)
					model.setS310CntrVolQty(s310CntrVolQty[i]);
				if (s331CntrVolQty[i] != null)
					model.setS331CntrVolQty(s331CntrVolQty[i]);
				if (s344CntrVolQty[i] != null)
					model.setS344CntrVolQty(s344CntrVolQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (s340CntrVolQty[i] != null)
					model.setS340CntrVolQty(s340CntrVolQty[i]);
				if (s352CntrVolQty[i] != null)
					model.setS352CntrVolQty(s352CntrVolQty[i]);
				if (s324CntrVolQty[i] != null)
					model.setS324CntrVolQty(s324CntrVolQty[i]);
				if (s329CntrVolQty[i] != null)
					model.setS329CntrVolQty(s329CntrVolQty[i]);
				if (s341CntrVolQty[i] != null)
					model.setS341CntrVolQty(s341CntrVolQty[i]);
				if (s3CntrTpszCd[i] != null)
					model.setS3CntrTpszCd(s3CntrTpszCd[i]);
				if (s348CntrVolQty[i] != null)
					model.setS348CntrVolQty(s348CntrVolQty[i]);
				if (s347CntrVolQty[i] != null)
					model.setS347CntrVolQty(s347CntrVolQty[i]);
				if (s33CntrVolQty[i] != null)
					model.setS33CntrVolQty(s33CntrVolQty[i]);
				if (s328CntrVolQty[i] != null)
					model.setS328CntrVolQty(s328CntrVolQty[i]);
				if (s37CntrVolQty[i] != null)
					model.setS37CntrVolQty(s37CntrVolQty[i]);
				if (s36CntrVolQty[i] != null)
					model.setS36CntrVolQty(s36CntrVolQty[i]);
				if (s322CntrVolQty[i] != null)
					model.setS322CntrVolQty(s322CntrVolQty[i]);
				if (s321CntrVolQty[i] != null)
					model.setS321CntrVolQty(s321CntrVolQty[i]);
				if (s314CntrVolQty[i] != null)
					model.setS314CntrVolQty(s314CntrVolQty[i]);
				if (s335CntrVolQty[i] != null)
					model.setS335CntrVolQty(s335CntrVolQty[i]);
				if (s325CntrVolQty[i] != null)
					model.setS325CntrVolQty(s325CntrVolQty[i]);
				if (timegap[i] != null)
					model.setTimegap(timegap[i]);
				if (s330CntrVolQty[i] != null)
					model.setS330CntrVolQty(s330CntrVolQty[i]);
				if (s3FmRccCd[i] != null)
					model.setS3FmRccCd(s3FmRccCd[i]);
				if (s323CntrVolQty[i] != null)
					model.setS323CntrVolQty(s323CntrVolQty[i]);
				if (s31CntrVolQty[i] != null)
					model.setS31CntrVolQty(s31CntrVolQty[i]);
				if (s316CntrVolQty[i] != null)
					model.setS316CntrVolQty(s316CntrVolQty[i]);
				if (s319CntrVolQty[i] != null)
					model.setS319CntrVolQty(s319CntrVolQty[i]);
				if (s312CntrVolQty[i] != null)
					model.setS312CntrVolQty(s312CntrVolQty[i]);
				if (s38CntrVolQty[i] != null)
					model.setS38CntrVolQty(s38CntrVolQty[i]);
				if (s3FmEccCd[i] != null)
					model.setS3FmEccCd(s3FmEccCd[i]);
				if (s326CntrVolQty[i] != null)
					model.setS326CntrVolQty(s326CntrVolQty[i]);
				if (s337CntrVolQty[i] != null)
					model.setS337CntrVolQty(s337CntrVolQty[i]);
				if (s317CntrVolQty[i] != null)
					model.setS317CntrVolQty(s317CntrVolQty[i]);
				if (s336CntrVolQty[i] != null)
					model.setS336CntrVolQty(s336CntrVolQty[i]);
				if (s3DmstRto[i] != null)
					model.setS3DmstRto(s3DmstRto[i]);
				if (s349CntrVolQty[i] != null)
					model.setS349CntrVolQty(s349CntrVolQty[i]);
				if (s333CntrVolQty[i] != null)
					model.setS333CntrVolQty(s333CntrVolQty[i]);
				if (s334CntrVolQty[i] != null)
					model.setS334CntrVolQty(s334CntrVolQty[i]);
				if (s315CntrVolQty[i] != null)
					model.setS315CntrVolQty(s315CntrVolQty[i]);
				if (s351CntrVolQty[i] != null)
					model.setS351CntrVolQty(s351CntrVolQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (s332CntrVolQty[i] != null)
					model.setS332CntrVolQty(s332CntrVolQty[i]);
				if (s342CntrVolQty[i] != null)
					model.setS342CntrVolQty(s342CntrVolQty[i]);
				if (s313CntrVolQty[i] != null)
					model.setS313CntrVolQty(s313CntrVolQty[i]);
				if (s338CntrVolQty[i] != null)
					model.setS338CntrVolQty(s338CntrVolQty[i]);
				if (s35CntrVolQty[i] != null)
					model.setS35CntrVolQty(s35CntrVolQty[i]);
				if (s343CntrVolQty[i] != null)
					model.setS343CntrVolQty(s343CntrVolQty[i]);
				if (s3PlnYr[i] != null)
					model.setS3PlnYr(s3PlnYr[i]);
				if (s350CntrVolQty[i] != null)
					model.setS350CntrVolQty(s350CntrVolQty[i]);
				if (s318CntrVolQty[i] != null)
					model.setS318CntrVolQty(s318CntrVolQty[i]);
				if (s39CntrVolQty[i] != null)
					model.setS39CntrVolQty(s39CntrVolQty[i]);
				if (s346CntrVolQty[i] != null)
					model.setS346CntrVolQty(s346CntrVolQty[i]);
				if (s353CntrVolQty[i] != null)
					model.setS353CntrVolQty(s353CntrVolQty[i]);
				if (s345CntrVolQty[i] != null)
					model.setS345CntrVolQty(s345CntrVolQty[i]);
				if (s339CntrVolQty[i] != null)
					model.setS339CntrVolQty(s339CntrVolQty[i]);
				if (s327CntrVolQty[i] != null)
					model.setS327CntrVolQty(s327CntrVolQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchYearSubleaseDetailPlanWeeklyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchYearSubleaseDetailPlanWeeklyVO[]
	 */
	public SearchYearSubleaseDetailPlanWeeklyVO[] getSearchYearSubleaseDetailPlanWeeklyVOs(){
		SearchYearSubleaseDetailPlanWeeklyVO[] vos = (SearchYearSubleaseDetailPlanWeeklyVO[])models.toArray(new SearchYearSubleaseDetailPlanWeeklyVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.s32CntrVolQty = this.s32CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s3ToEccCd = this.s3ToEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s34CntrVolQty = this.s34CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s311CntrVolQty = this.s311CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s320CntrVolQty = this.s320CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s310CntrVolQty = this.s310CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s331CntrVolQty = this.s331CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s344CntrVolQty = this.s344CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s340CntrVolQty = this.s340CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s352CntrVolQty = this.s352CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s324CntrVolQty = this.s324CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s329CntrVolQty = this.s329CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s341CntrVolQty = this.s341CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s3CntrTpszCd = this.s3CntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s348CntrVolQty = this.s348CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s347CntrVolQty = this.s347CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s33CntrVolQty = this.s33CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s328CntrVolQty = this.s328CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s37CntrVolQty = this.s37CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s36CntrVolQty = this.s36CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s322CntrVolQty = this.s322CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s321CntrVolQty = this.s321CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s314CntrVolQty = this.s314CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s335CntrVolQty = this.s335CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s325CntrVolQty = this.s325CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.timegap = this.timegap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s330CntrVolQty = this.s330CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s3FmRccCd = this.s3FmRccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s323CntrVolQty = this.s323CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s31CntrVolQty = this.s31CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s316CntrVolQty = this.s316CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s319CntrVolQty = this.s319CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s312CntrVolQty = this.s312CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s38CntrVolQty = this.s38CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s3FmEccCd = this.s3FmEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s326CntrVolQty = this.s326CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s337CntrVolQty = this.s337CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s317CntrVolQty = this.s317CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s336CntrVolQty = this.s336CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s3DmstRto = this.s3DmstRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s349CntrVolQty = this.s349CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s333CntrVolQty = this.s333CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s334CntrVolQty = this.s334CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s315CntrVolQty = this.s315CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s351CntrVolQty = this.s351CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s332CntrVolQty = this.s332CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s342CntrVolQty = this.s342CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s313CntrVolQty = this.s313CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s338CntrVolQty = this.s338CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s35CntrVolQty = this.s35CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s343CntrVolQty = this.s343CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s3PlnYr = this.s3PlnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s350CntrVolQty = this.s350CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s318CntrVolQty = this.s318CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s39CntrVolQty = this.s39CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s346CntrVolQty = this.s346CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s353CntrVolQty = this.s353CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s345CntrVolQty = this.s345CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s339CntrVolQty = this.s339CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s327CntrVolQty = this.s327CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
