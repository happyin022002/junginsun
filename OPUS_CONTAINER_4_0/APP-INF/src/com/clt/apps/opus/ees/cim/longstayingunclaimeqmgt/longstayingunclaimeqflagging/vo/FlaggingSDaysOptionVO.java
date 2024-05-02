/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : FlaggingSDaysOptionVO.java
 *@FileTitle : FlaggingSDaysOptionVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.06.18
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.06.18  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo;

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
public class FlaggingSDaysOptionVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<FlaggingSDaysOptionVO>  models =	new	ArrayList<FlaggingSDaysOptionVO>();


	/*	Column Info	*/
	private  String	 cntrTpszCd14   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd15   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd16   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd17   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd18   =  null;
	/*	Column Info	*/
	private  String	 subCntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd19   =  null;
	/*	Column Info	*/
	private  String	 bkgBlTypeCode   =  null;
	/*	Column Info	*/
	private  String	 bkgBlTypeCd   =  null;
	/*	Column Info	*/
	private  String	 rccDate   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 locCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 bkgCustTpCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd11   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd10   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd13   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd12   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd27   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd28   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd25   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd26   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd29   =  null;
	/*	Column Info	*/
	private  String	 tabFlag   =  null;
	/*	Column Info	*/
	private  String	 queryStr   =  null;
	/*	Column Info	*/
	private  String	 overStayDays   =  null;
	/*	Column Info	*/
	private  String	 uclmLsDivCd   =  null;
	/*	Column Info	*/
	private  String	 custCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd20   =  null;
	/*	Column Info	*/
	private  String	 fullFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd24   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd23   =  null;
	/*	Column Info	*/
	private  String	 subCnmvStsCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd22   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd21   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd8   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd7   =  null;
	/*	Column Info	*/
	private  String	 cntrUseCoCd   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd2   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd1   =  null;
	/*	Column Info	*/
	private  String	 dmgFlg   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd4   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd3   =  null;
	/*	Column Info	*/
	private  String	 locTypeCode   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd6   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd5   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd30   =  null;
	/*	Column Info	*/
	private  String	 subLocCd   =  null;
	/*	Column Info	*/
	private  String	 totCntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 bkgCustTpCode   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd6   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd5   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd8   =  null;
	/*	Column Info	*/
	private  String	 socCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd7   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd9   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd2   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd1   =  null;
	/*	Column Info	*/
	private  String	 repCmdtCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd4   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd3   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 startStayDays   =  null;
	/*	Column Info	*/
	private  String	 endStayDays   =  null;
	/*	Column Info	*/
	private  String	 mvmtStatusCd   =  null;
	/* Column Info */
	private int iPage = 1;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public FlaggingSDaysOptionVO(){}

	public FlaggingSDaysOptionVO(String cntrTpszCd14,String cntrTpszCd15,String cntrTpszCd16,String cntrTpszCd17,String cntrTpszCd18,String subCntrTpszCd,String cntrTpszCd19,String bkgBlTypeCode,String bkgBlTypeCd,String rccDate,String pagerows,String locCd,String cntrTpszCd,String lstmCd,String bkgCustTpCd,String cntrTpszCd11,String cntrTpszCd10,String cntrTpszCd13,String cntrTpszCd12,String cntrTpszCd27,String cntrTpszCd28,String cntrTpszCd25,String cntrTpszCd26,String cntrTpszCd29,String tabFlag,String queryStr,String overStayDays,String uclmLsDivCd,String custCd,String cntrTpszCd20,String fullFlg,String cntrTpszCd24,String cntrTpszCd23,String subCnmvStsCd,String cntrTpszCd22,String cntrTpszCd21,String cnmvStsCd8,String cnmvStsCd7,String cntrUseCoCd,String cnmvStsCd2,String cnmvStsCd1,String dmgFlg,String cnmvStsCd4,String cnmvStsCd3,String locTypeCode,String cnmvStsCd6,String cnmvStsCd5,String ibflag,String cnmvStsCd,String cntrTpszCd30,String subLocCd,String totCntrTpszCd,String bkgCustTpCode,String cntrTpszCd6,String cntrTpszCd5,String cntrTpszCd8,String socCd,String cntrTpszCd7,String cntrTpszCd9,String cntrTpszCd2,String cntrTpszCd1,String repCmdtCd,String cntrTpszCd4,String cntrTpszCd3,String updDt,String updUsrId,String startStayDays,String endStayDays,String mvmtStatusCd)	{
		this.cntrTpszCd14  = cntrTpszCd14 ;
		this.cntrTpszCd15  = cntrTpszCd15 ;
		this.cntrTpszCd16  = cntrTpszCd16 ;
		this.cntrTpszCd17  = cntrTpszCd17 ;
		this.cntrTpszCd18  = cntrTpszCd18 ;
		this.subCntrTpszCd  = subCntrTpszCd ;
		this.cntrTpszCd19  = cntrTpszCd19 ;
		this.bkgBlTypeCode  = bkgBlTypeCode ;
		this.bkgBlTypeCd  = bkgBlTypeCd ;
		this.rccDate  = rccDate ;
		this.pagerows  = pagerows ;
		this.locCd  = locCd ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.lstmCd  = lstmCd ;
		this.bkgCustTpCd  = bkgCustTpCd ;
		this.cntrTpszCd11  = cntrTpszCd11 ;
		this.cntrTpszCd10  = cntrTpszCd10 ;
		this.cntrTpszCd13  = cntrTpszCd13 ;
		this.cntrTpszCd12  = cntrTpszCd12 ;
		this.cntrTpszCd27  = cntrTpszCd27 ;
		this.cntrTpszCd28  = cntrTpszCd28 ;
		this.cntrTpszCd25  = cntrTpszCd25 ;
		this.cntrTpszCd26  = cntrTpszCd26 ;
		this.cntrTpszCd29  = cntrTpszCd29 ;
		this.tabFlag  = tabFlag ;
		this.queryStr  = queryStr ;
		this.overStayDays  = overStayDays ;
		this.uclmLsDivCd  = uclmLsDivCd ;
		this.custCd  = custCd ;
		this.cntrTpszCd20  = cntrTpszCd20 ;
		this.fullFlg  = fullFlg ;
		this.cntrTpszCd24  = cntrTpszCd24 ;
		this.cntrTpszCd23  = cntrTpszCd23 ;
		this.subCnmvStsCd  = subCnmvStsCd ;
		this.cntrTpszCd22  = cntrTpszCd22 ;
		this.cntrTpszCd21  = cntrTpszCd21 ;
		this.cnmvStsCd8  = cnmvStsCd8 ;
		this.cnmvStsCd7  = cnmvStsCd7 ;
		this.cntrUseCoCd  = cntrUseCoCd ;
		this.cnmvStsCd2  = cnmvStsCd2 ;
		this.cnmvStsCd1  = cnmvStsCd1 ;
		this.dmgFlg  = dmgFlg ;
		this.cnmvStsCd4  = cnmvStsCd4 ;
		this.cnmvStsCd3  = cnmvStsCd3 ;
		this.locTypeCode  = locTypeCode ;
		this.cnmvStsCd6  = cnmvStsCd6 ;
		this.cnmvStsCd5  = cnmvStsCd5 ;
		this.ibflag  = ibflag ;
		this.cnmvStsCd  = cnmvStsCd ;
		this.cntrTpszCd30  = cntrTpszCd30 ;
		this.subLocCd  = subLocCd ;
		this.totCntrTpszCd  = totCntrTpszCd ;
		this.bkgCustTpCode  = bkgCustTpCode ;
		this.cntrTpszCd6  = cntrTpszCd6 ;
		this.cntrTpszCd5  = cntrTpszCd5 ;
		this.cntrTpszCd8  = cntrTpszCd8 ;
		this.socCd  = socCd ;
		this.cntrTpszCd7  = cntrTpszCd7 ;
		this.cntrTpszCd9  = cntrTpszCd9 ;
		this.cntrTpszCd2  = cntrTpszCd2 ;
		this.cntrTpszCd1  = cntrTpszCd1 ;
		this.repCmdtCd  = repCmdtCd ;
		this.cntrTpszCd4  = cntrTpszCd4 ;
		this.cntrTpszCd3  = cntrTpszCd3 ;
		this.updDt  = updDt ;
		this.updUsrId  = updUsrId ; 
		this.startStayDays  = startStayDays ;
		this.endStayDays  = endStayDays ;
		this.mvmtStatusCd  = mvmtStatusCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_tpsz_cd14", getCntrTpszCd14());		
		this.hashColumns.put("cntr_tpsz_cd15", getCntrTpszCd15());		
		this.hashColumns.put("cntr_tpsz_cd16", getCntrTpszCd16());		
		this.hashColumns.put("cntr_tpsz_cd17", getCntrTpszCd17());		
		this.hashColumns.put("cntr_tpsz_cd18", getCntrTpszCd18());		
		this.hashColumns.put("sub_cntr_tpsz_cd", getSubCntrTpszCd());		
		this.hashColumns.put("cntr_tpsz_cd19", getCntrTpszCd19());		
		this.hashColumns.put("bkg_bl_type_code", getBkgBlTypeCode());		
		this.hashColumns.put("bkg_bl_type_cd", getBkgBlTypeCd());		
		this.hashColumns.put("rcc_date", getRccDate());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("loc_cd", getLocCd());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());		
		this.hashColumns.put("cntr_tpsz_cd11", getCntrTpszCd11());		
		this.hashColumns.put("cntr_tpsz_cd10", getCntrTpszCd10());		
		this.hashColumns.put("cntr_tpsz_cd13", getCntrTpszCd13());		
		this.hashColumns.put("cntr_tpsz_cd12", getCntrTpszCd12());		
		this.hashColumns.put("cntr_tpsz_cd27", getCntrTpszCd27());		
		this.hashColumns.put("cntr_tpsz_cd28", getCntrTpszCd28());		
		this.hashColumns.put("cntr_tpsz_cd25", getCntrTpszCd25());		
		this.hashColumns.put("cntr_tpsz_cd26", getCntrTpszCd26());		
		this.hashColumns.put("cntr_tpsz_cd29", getCntrTpszCd29());		
		this.hashColumns.put("tab_flag", getTabFlag());		
		this.hashColumns.put("query_str", getQueryStr());		
		this.hashColumns.put("over_stay_days", getOverStayDays());		
		this.hashColumns.put("uclm_ls_div_cd", getUclmLsDivCd());		
		this.hashColumns.put("cust_cd", getCustCd());		
		this.hashColumns.put("cntr_tpsz_cd20", getCntrTpszCd20());		
		this.hashColumns.put("full_flg", getFullFlg());		
		this.hashColumns.put("cntr_tpsz_cd24", getCntrTpszCd24());		
		this.hashColumns.put("cntr_tpsz_cd23", getCntrTpszCd23());		
		this.hashColumns.put("sub_cnmv_sts_cd", getSubCnmvStsCd());		
		this.hashColumns.put("cntr_tpsz_cd22", getCntrTpszCd22());		
		this.hashColumns.put("cntr_tpsz_cd21", getCntrTpszCd21());		
		this.hashColumns.put("cnmv_sts_cd8", getCnmvStsCd8());		
		this.hashColumns.put("cnmv_sts_cd7", getCnmvStsCd7());		
		this.hashColumns.put("cntr_use_co_cd", getCntrUseCoCd());		
		this.hashColumns.put("cnmv_sts_cd2", getCnmvStsCd2());		
		this.hashColumns.put("cnmv_sts_cd1", getCnmvStsCd1());		
		this.hashColumns.put("dmg_flg", getDmgFlg());		
		this.hashColumns.put("cnmv_sts_cd4", getCnmvStsCd4());		
		this.hashColumns.put("cnmv_sts_cd3", getCnmvStsCd3());		
		this.hashColumns.put("loc_type_code", getLocTypeCode());		
		this.hashColumns.put("cnmv_sts_cd6", getCnmvStsCd6());		
		this.hashColumns.put("cnmv_sts_cd5", getCnmvStsCd5());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());		
		this.hashColumns.put("cntr_tpsz_cd30", getCntrTpszCd30());		
		this.hashColumns.put("sub_loc_cd", getSubLocCd());		
		this.hashColumns.put("tot_cntr_tpsz_cd", getTotCntrTpszCd());		
		this.hashColumns.put("bkg_cust_tp_code", getBkgCustTpCode());		
		this.hashColumns.put("cntr_tpsz_cd6", getCntrTpszCd6());		
		this.hashColumns.put("cntr_tpsz_cd5", getCntrTpszCd5());		
		this.hashColumns.put("cntr_tpsz_cd8", getCntrTpszCd8());		
		this.hashColumns.put("soc_cd", getSocCd());		
		this.hashColumns.put("cntr_tpsz_cd7", getCntrTpszCd7());		
		this.hashColumns.put("cntr_tpsz_cd9", getCntrTpszCd9());		
		this.hashColumns.put("cntr_tpsz_cd2", getCntrTpszCd2());		
		this.hashColumns.put("cntr_tpsz_cd1", getCntrTpszCd1());		
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());		
		this.hashColumns.put("cntr_tpsz_cd4", getCntrTpszCd4());		
		this.hashColumns.put("cntr_tpsz_cd3", getCntrTpszCd3());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("start_stay_days", getStartStayDays());		
		this.hashColumns.put("end_stay_days", getEndStayDays());	
		this.hashColumns.put("mvmt_status_cd", getMvmtStatusCd());
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("cntr_tpsz_cd14", "cntrTpszCd14");
		this.hashFields.put("cntr_tpsz_cd15", "cntrTpszCd15");
		this.hashFields.put("cntr_tpsz_cd16", "cntrTpszCd16");
		this.hashFields.put("cntr_tpsz_cd17", "cntrTpszCd17");
		this.hashFields.put("cntr_tpsz_cd18", "cntrTpszCd18");
		this.hashFields.put("sub_cntr_tpsz_cd", "subCntrTpszCd");
		this.hashFields.put("cntr_tpsz_cd19", "cntrTpszCd19");
		this.hashFields.put("bkg_bl_type_code", "bkgBlTypeCode");
		this.hashFields.put("bkg_bl_type_cd", "bkgBlTypeCd");
		this.hashFields.put("rcc_date", "rccDate");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("cntr_tpsz_cd11", "cntrTpszCd11");
		this.hashFields.put("cntr_tpsz_cd10", "cntrTpszCd10");
		this.hashFields.put("cntr_tpsz_cd13", "cntrTpszCd13");
		this.hashFields.put("cntr_tpsz_cd12", "cntrTpszCd12");
		this.hashFields.put("cntr_tpsz_cd27", "cntrTpszCd27");
		this.hashFields.put("cntr_tpsz_cd28", "cntrTpszCd28");
		this.hashFields.put("cntr_tpsz_cd25", "cntrTpszCd25");
		this.hashFields.put("cntr_tpsz_cd26", "cntrTpszCd26");
		this.hashFields.put("cntr_tpsz_cd29", "cntrTpszCd29");
		this.hashFields.put("tab_flag", "tabFlag");
		this.hashFields.put("query_str", "queryStr");
		this.hashFields.put("over_stay_days", "overStayDays");
		this.hashFields.put("uclm_ls_div_cd", "uclmLsDivCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cntr_tpsz_cd20", "cntrTpszCd20");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("cntr_tpsz_cd24", "cntrTpszCd24");
		this.hashFields.put("cntr_tpsz_cd23", "cntrTpszCd23");
		this.hashFields.put("sub_cnmv_sts_cd", "subCnmvStsCd");
		this.hashFields.put("cntr_tpsz_cd22", "cntrTpszCd22");
		this.hashFields.put("cntr_tpsz_cd21", "cntrTpszCd21");
		this.hashFields.put("cnmv_sts_cd8", "cnmvStsCd8");
		this.hashFields.put("cnmv_sts_cd7", "cnmvStsCd7");
		this.hashFields.put("cntr_use_co_cd", "cntrUseCoCd");
		this.hashFields.put("cnmv_sts_cd2", "cnmvStsCd2");
		this.hashFields.put("cnmv_sts_cd1", "cnmvStsCd1");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("cnmv_sts_cd4", "cnmvStsCd4");
		this.hashFields.put("cnmv_sts_cd3", "cnmvStsCd3");
		this.hashFields.put("loc_type_code", "locTypeCode");
		this.hashFields.put("cnmv_sts_cd6", "cnmvStsCd6");
		this.hashFields.put("cnmv_sts_cd5", "cnmvStsCd5");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("cntr_tpsz_cd30", "cntrTpszCd30");
		this.hashFields.put("sub_loc_cd", "subLocCd");
		this.hashFields.put("tot_cntr_tpsz_cd", "totCntrTpszCd");
		this.hashFields.put("bkg_cust_tp_code", "bkgCustTpCode");
		this.hashFields.put("cntr_tpsz_cd6", "cntrTpszCd6");
		this.hashFields.put("cntr_tpsz_cd5", "cntrTpszCd5");
		this.hashFields.put("cntr_tpsz_cd8", "cntrTpszCd8");
		this.hashFields.put("soc_cd", "socCd");
		this.hashFields.put("cntr_tpsz_cd7", "cntrTpszCd7");
		this.hashFields.put("cntr_tpsz_cd9", "cntrTpszCd9");
		this.hashFields.put("cntr_tpsz_cd2", "cntrTpszCd2");
		this.hashFields.put("cntr_tpsz_cd1", "cntrTpszCd1");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("cntr_tpsz_cd4", "cntrTpszCd4");
		this.hashFields.put("cntr_tpsz_cd3", "cntrTpszCd3");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("start_stay_days", "startStayDays");
		this.hashFields.put("end_stay_days", "endStayDays");
		this.hashFields.put("mvmt_status_cd", "mvmtStatusCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  cntrTpszCd14
	*/
	public void	setCntrTpszCd14( String	cntrTpszCd14 ) {
		this.cntrTpszCd14 =	cntrTpszCd14;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd14
	 */
	 public	 String	getCntrTpszCd14() {
		 return	this.cntrTpszCd14;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd15
	*/
	public void	setCntrTpszCd15( String	cntrTpszCd15 ) {
		this.cntrTpszCd15 =	cntrTpszCd15;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd15
	 */
	 public	 String	getCntrTpszCd15() {
		 return	this.cntrTpszCd15;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd16
	*/
	public void	setCntrTpszCd16( String	cntrTpszCd16 ) {
		this.cntrTpszCd16 =	cntrTpszCd16;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd16
	 */
	 public	 String	getCntrTpszCd16() {
		 return	this.cntrTpszCd16;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd17
	*/
	public void	setCntrTpszCd17( String	cntrTpszCd17 ) {
		this.cntrTpszCd17 =	cntrTpszCd17;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd17
	 */
	 public	 String	getCntrTpszCd17() {
		 return	this.cntrTpszCd17;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd18
	*/
	public void	setCntrTpszCd18( String	cntrTpszCd18 ) {
		this.cntrTpszCd18 =	cntrTpszCd18;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd18
	 */
	 public	 String	getCntrTpszCd18() {
		 return	this.cntrTpszCd18;
	 } 
 	/**
	* Column Info
	* @param  subCntrTpszCd
	*/
	public void	setSubCntrTpszCd( String	subCntrTpszCd ) {
		this.subCntrTpszCd =	subCntrTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	subCntrTpszCd
	 */
	 public	 String	getSubCntrTpszCd() {
		 return	this.subCntrTpszCd;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd19
	*/
	public void	setCntrTpszCd19( String	cntrTpszCd19 ) {
		this.cntrTpszCd19 =	cntrTpszCd19;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd19
	 */
	 public	 String	getCntrTpszCd19() {
		 return	this.cntrTpszCd19;
	 } 
 	/**
	* Column Info
	* @param  bkgBlTypeCode
	*/
	public void	setBkgBlTypeCode( String	bkgBlTypeCode ) {
		this.bkgBlTypeCode =	bkgBlTypeCode;
	}
 
	/**
	 * Column Info
	 * @return	bkgBlTypeCode
	 */
	 public	 String	getBkgBlTypeCode() {
		 return	this.bkgBlTypeCode;
	 } 
 	/**
	* Column Info
	* @param  bkgBlTypeCd
	*/
	public void	setBkgBlTypeCd( String	bkgBlTypeCd ) {
		this.bkgBlTypeCd =	bkgBlTypeCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgBlTypeCd
	 */
	 public	 String	getBkgBlTypeCd() {
		 return	this.bkgBlTypeCd;
	 } 
 	/**
	* Column Info
	* @param  rccDate
	*/
	public void	setRccDate( String	rccDate ) {
		this.rccDate =	rccDate;
	}
 
	/**
	 * Column Info
	 * @return	rccDate
	 */
	 public	 String	getRccDate() {
		 return	this.rccDate;
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
	* @param  bkgCustTpCd
	*/
	public void	setBkgCustTpCd( String	bkgCustTpCd ) {
		this.bkgCustTpCd =	bkgCustTpCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgCustTpCd
	 */
	 public	 String	getBkgCustTpCd() {
		 return	this.bkgCustTpCd;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd11
	*/
	public void	setCntrTpszCd11( String	cntrTpszCd11 ) {
		this.cntrTpszCd11 =	cntrTpszCd11;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd11
	 */
	 public	 String	getCntrTpszCd11() {
		 return	this.cntrTpszCd11;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd10
	*/
	public void	setCntrTpszCd10( String	cntrTpszCd10 ) {
		this.cntrTpszCd10 =	cntrTpszCd10;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd10
	 */
	 public	 String	getCntrTpszCd10() {
		 return	this.cntrTpszCd10;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd13
	*/
	public void	setCntrTpszCd13( String	cntrTpszCd13 ) {
		this.cntrTpszCd13 =	cntrTpszCd13;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd13
	 */
	 public	 String	getCntrTpszCd13() {
		 return	this.cntrTpszCd13;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd12
	*/
	public void	setCntrTpszCd12( String	cntrTpszCd12 ) {
		this.cntrTpszCd12 =	cntrTpszCd12;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd12
	 */
	 public	 String	getCntrTpszCd12() {
		 return	this.cntrTpszCd12;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd27
	*/
	public void	setCntrTpszCd27( String	cntrTpszCd27 ) {
		this.cntrTpszCd27 =	cntrTpszCd27;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd27
	 */
	 public	 String	getCntrTpszCd27() {
		 return	this.cntrTpszCd27;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd28
	*/
	public void	setCntrTpszCd28( String	cntrTpszCd28 ) {
		this.cntrTpszCd28 =	cntrTpszCd28;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd28
	 */
	 public	 String	getCntrTpszCd28() {
		 return	this.cntrTpszCd28;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd25
	*/
	public void	setCntrTpszCd25( String	cntrTpszCd25 ) {
		this.cntrTpszCd25 =	cntrTpszCd25;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd25
	 */
	 public	 String	getCntrTpszCd25() {
		 return	this.cntrTpszCd25;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd26
	*/
	public void	setCntrTpszCd26( String	cntrTpszCd26 ) {
		this.cntrTpszCd26 =	cntrTpszCd26;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd26
	 */
	 public	 String	getCntrTpszCd26() {
		 return	this.cntrTpszCd26;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd29
	*/
	public void	setCntrTpszCd29( String	cntrTpszCd29 ) {
		this.cntrTpszCd29 =	cntrTpszCd29;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd29
	 */
	 public	 String	getCntrTpszCd29() {
		 return	this.cntrTpszCd29;
	 } 
 	/**
	* Column Info
	* @param  tabFlag
	*/
	public void	setTabFlag( String	tabFlag ) {
		this.tabFlag =	tabFlag;
	}
 
	/**
	 * Column Info
	 * @return	tabFlag
	 */
	 public	 String	getTabFlag() {
		 return	this.tabFlag;
	 } 
 	/**
	* Column Info
	* @param  queryStr
	*/
	public void	setQueryStr( String	queryStr ) {
		this.queryStr =	queryStr;
	}
 
	/**
	 * Column Info
	 * @return	queryStr
	 */
	 public	 String	getQueryStr() {
		 return	this.queryStr;
	 } 
 	/**
	* Column Info
	* @param  overStayDays
	*/
	public void	setOverStayDays( String	overStayDays ) {
		this.overStayDays =	overStayDays;
	}
 
	/**
	 * Column Info
	 * @return	overStayDays
	 */
	 public	 String	getOverStayDays() {
		 return	this.overStayDays;
	 } 
 	/**
	* Column Info
	* @param  uclmLsDivCd
	*/
	public void	setUclmLsDivCd( String	uclmLsDivCd ) {
		this.uclmLsDivCd =	uclmLsDivCd;
	}
 
	/**
	 * Column Info
	 * @return	uclmLsDivCd
	 */
	 public	 String	getUclmLsDivCd() {
		 return	this.uclmLsDivCd;
	 } 
 	/**
	* Column Info
	* @param  custCd
	*/
	public void	setCustCd( String	custCd ) {
		this.custCd =	custCd;
	}
 
	/**
	 * Column Info
	 * @return	custCd
	 */
	 public	 String	getCustCd() {
		 return	this.custCd;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd20
	*/
	public void	setCntrTpszCd20( String	cntrTpszCd20 ) {
		this.cntrTpszCd20 =	cntrTpszCd20;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd20
	 */
	 public	 String	getCntrTpszCd20() {
		 return	this.cntrTpszCd20;
	 } 
 	/**
	* Column Info
	* @param  fullFlg
	*/
	public void	setFullFlg( String	fullFlg ) {
		this.fullFlg =	fullFlg;
	}
 
	/**
	 * Column Info
	 * @return	fullFlg
	 */
	 public	 String	getFullFlg() {
		 return	this.fullFlg;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd24
	*/
	public void	setCntrTpszCd24( String	cntrTpszCd24 ) {
		this.cntrTpszCd24 =	cntrTpszCd24;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd24
	 */
	 public	 String	getCntrTpszCd24() {
		 return	this.cntrTpszCd24;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd23
	*/
	public void	setCntrTpszCd23( String	cntrTpszCd23 ) {
		this.cntrTpszCd23 =	cntrTpszCd23;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd23
	 */
	 public	 String	getCntrTpszCd23() {
		 return	this.cntrTpszCd23;
	 } 
 	/**
	* Column Info
	* @param  subCnmvStsCd
	*/
	public void	setSubCnmvStsCd( String	subCnmvStsCd ) {
		this.subCnmvStsCd =	subCnmvStsCd;
	}
 
	/**
	 * Column Info
	 * @return	subCnmvStsCd
	 */
	 public	 String	getSubCnmvStsCd() {
		 return	this.subCnmvStsCd;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd22
	*/
	public void	setCntrTpszCd22( String	cntrTpszCd22 ) {
		this.cntrTpszCd22 =	cntrTpszCd22;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd22
	 */
	 public	 String	getCntrTpszCd22() {
		 return	this.cntrTpszCd22;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd21
	*/
	public void	setCntrTpszCd21( String	cntrTpszCd21 ) {
		this.cntrTpszCd21 =	cntrTpszCd21;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd21
	 */
	 public	 String	getCntrTpszCd21() {
		 return	this.cntrTpszCd21;
	 } 
 	/**
	* Column Info
	* @param  cnmvStsCd8
	*/
	public void	setCnmvStsCd8( String	cnmvStsCd8 ) {
		this.cnmvStsCd8 =	cnmvStsCd8;
	}
 
	/**
	 * Column Info
	 * @return	cnmvStsCd8
	 */
	 public	 String	getCnmvStsCd8() {
		 return	this.cnmvStsCd8;
	 } 
 	/**
	* Column Info
	* @param  cnmvStsCd7
	*/
	public void	setCnmvStsCd7( String	cnmvStsCd7 ) {
		this.cnmvStsCd7 =	cnmvStsCd7;
	}
 
	/**
	 * Column Info
	 * @return	cnmvStsCd7
	 */
	 public	 String	getCnmvStsCd7() {
		 return	this.cnmvStsCd7;
	 } 
 	/**
	* Column Info
	* @param  cntrUseCoCd
	*/
	public void	setCntrUseCoCd( String	cntrUseCoCd ) {
		this.cntrUseCoCd =	cntrUseCoCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrUseCoCd
	 */
	 public	 String	getCntrUseCoCd() {
		 return	this.cntrUseCoCd;
	 } 
 	/**
	* Column Info
	* @param  cnmvStsCd2
	*/
	public void	setCnmvStsCd2( String	cnmvStsCd2 ) {
		this.cnmvStsCd2 =	cnmvStsCd2;
	}
 
	/**
	 * Column Info
	 * @return	cnmvStsCd2
	 */
	 public	 String	getCnmvStsCd2() {
		 return	this.cnmvStsCd2;
	 } 
 	/**
	* Column Info
	* @param  cnmvStsCd1
	*/
	public void	setCnmvStsCd1( String	cnmvStsCd1 ) {
		this.cnmvStsCd1 =	cnmvStsCd1;
	}
 
	/**
	 * Column Info
	 * @return	cnmvStsCd1
	 */
	 public	 String	getCnmvStsCd1() {
		 return	this.cnmvStsCd1;
	 } 
 	/**
	* Column Info
	* @param  dmgFlg
	*/
	public void	setDmgFlg( String	dmgFlg ) {
		this.dmgFlg =	dmgFlg;
	}
 
	/**
	 * Column Info
	 * @return	dmgFlg
	 */
	 public	 String	getDmgFlg() {
		 return	this.dmgFlg;
	 } 
 	/**
	* Column Info
	* @param  cnmvStsCd4
	*/
	public void	setCnmvStsCd4( String	cnmvStsCd4 ) {
		this.cnmvStsCd4 =	cnmvStsCd4;
	}
 
	/**
	 * Column Info
	 * @return	cnmvStsCd4
	 */
	 public	 String	getCnmvStsCd4() {
		 return	this.cnmvStsCd4;
	 } 
 	/**
	* Column Info
	* @param  cnmvStsCd3
	*/
	public void	setCnmvStsCd3( String	cnmvStsCd3 ) {
		this.cnmvStsCd3 =	cnmvStsCd3;
	}
 
	/**
	 * Column Info
	 * @return	cnmvStsCd3
	 */
	 public	 String	getCnmvStsCd3() {
		 return	this.cnmvStsCd3;
	 } 
 	/**
	* Column Info
	* @param  locTypeCode
	*/
	public void	setLocTypeCode( String	locTypeCode ) {
		this.locTypeCode =	locTypeCode;
	}
 
	/**
	 * Column Info
	 * @return	locTypeCode
	 */
	 public	 String	getLocTypeCode() {
		 return	this.locTypeCode;
	 } 
 	/**
	* Column Info
	* @param  cnmvStsCd6
	*/
	public void	setCnmvStsCd6( String	cnmvStsCd6 ) {
		this.cnmvStsCd6 =	cnmvStsCd6;
	}
 
	/**
	 * Column Info
	 * @return	cnmvStsCd6
	 */
	 public	 String	getCnmvStsCd6() {
		 return	this.cnmvStsCd6;
	 } 
 	/**
	* Column Info
	* @param  cnmvStsCd5
	*/
	public void	setCnmvStsCd5( String	cnmvStsCd5 ) {
		this.cnmvStsCd5 =	cnmvStsCd5;
	}
 
	/**
	 * Column Info
	 * @return	cnmvStsCd5
	 */
	 public	 String	getCnmvStsCd5() {
		 return	this.cnmvStsCd5;
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
	* @param  cnmvStsCd
	*/
	public void	setCnmvStsCd( String	cnmvStsCd ) {
		this.cnmvStsCd =	cnmvStsCd;
	}
 
	/**
	 * Column Info
	 * @return	cnmvStsCd
	 */
	 public	 String	getCnmvStsCd() {
		 return	this.cnmvStsCd;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd30
	*/
	public void	setCntrTpszCd30( String	cntrTpszCd30 ) {
		this.cntrTpszCd30 =	cntrTpszCd30;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd30
	 */
	 public	 String	getCntrTpszCd30() {
		 return	this.cntrTpszCd30;
	 } 
 	/**
	* Column Info
	* @param  subLocCd
	*/
	public void	setSubLocCd( String	subLocCd ) {
		this.subLocCd =	subLocCd;
	}
 
	/**
	 * Column Info
	 * @return	subLocCd
	 */
	 public	 String	getSubLocCd() {
		 return	this.subLocCd;
	 } 
 	/**
	* Column Info
	* @param  totCntrTpszCd
	*/
	public void	setTotCntrTpszCd( String	totCntrTpszCd ) {
		this.totCntrTpszCd =	totCntrTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	totCntrTpszCd
	 */
	 public	 String	getTotCntrTpszCd() {
		 return	this.totCntrTpszCd;
	 } 
 	/**
	* Column Info
	* @param  bkgCustTpCode
	*/
	public void	setBkgCustTpCode( String	bkgCustTpCode ) {
		this.bkgCustTpCode =	bkgCustTpCode;
	}
 
	/**
	 * Column Info
	 * @return	bkgCustTpCode
	 */
	 public	 String	getBkgCustTpCode() {
		 return	this.bkgCustTpCode;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd6
	*/
	public void	setCntrTpszCd6( String	cntrTpszCd6 ) {
		this.cntrTpszCd6 =	cntrTpszCd6;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd6
	 */
	 public	 String	getCntrTpszCd6() {
		 return	this.cntrTpszCd6;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd5
	*/
	public void	setCntrTpszCd5( String	cntrTpszCd5 ) {
		this.cntrTpszCd5 =	cntrTpszCd5;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd5
	 */
	 public	 String	getCntrTpszCd5() {
		 return	this.cntrTpszCd5;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd8
	*/
	public void	setCntrTpszCd8( String	cntrTpszCd8 ) {
		this.cntrTpszCd8 =	cntrTpszCd8;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd8
	 */
	 public	 String	getCntrTpszCd8() {
		 return	this.cntrTpszCd8;
	 } 
 	/**
	* Column Info
	* @param  socCd
	*/
	public void	setSocCd( String	socCd ) {
		this.socCd =	socCd;
	}
 
	/**
	 * Column Info
	 * @return	socCd
	 */
	 public	 String	getSocCd() {
		 return	this.socCd;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd7
	*/
	public void	setCntrTpszCd7( String	cntrTpszCd7 ) {
		this.cntrTpszCd7 =	cntrTpszCd7;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd7
	 */
	 public	 String	getCntrTpszCd7() {
		 return	this.cntrTpszCd7;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd9
	*/
	public void	setCntrTpszCd9( String	cntrTpszCd9 ) {
		this.cntrTpszCd9 =	cntrTpszCd9;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd9
	 */
	 public	 String	getCntrTpszCd9() {
		 return	this.cntrTpszCd9;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd2
	*/
	public void	setCntrTpszCd2( String	cntrTpszCd2 ) {
		this.cntrTpszCd2 =	cntrTpszCd2;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd2
	 */
	 public	 String	getCntrTpszCd2() {
		 return	this.cntrTpszCd2;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd1
	*/
	public void	setCntrTpszCd1( String	cntrTpszCd1 ) {
		this.cntrTpszCd1 =	cntrTpszCd1;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd1
	 */
	 public	 String	getCntrTpszCd1() {
		 return	this.cntrTpszCd1;
	 } 
 	/**
	* Column Info
	* @param  repCmdtCd
	*/
	public void	setRepCmdtCd( String	repCmdtCd ) {
		this.repCmdtCd =	repCmdtCd;
	}
 
	/**
	 * Column Info
	 * @return	repCmdtCd
	 */
	 public	 String	getRepCmdtCd() {
		 return	this.repCmdtCd;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd4
	*/
	public void	setCntrTpszCd4( String	cntrTpszCd4 ) {
		this.cntrTpszCd4 =	cntrTpszCd4;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd4
	 */
	 public	 String	getCntrTpszCd4() {
		 return	this.cntrTpszCd4;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd3
	*/
	public void	setCntrTpszCd3( String	cntrTpszCd3 ) {
		this.cntrTpszCd3 =	cntrTpszCd3;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd3
	 */
	 public	 String	getCntrTpszCd3() {
		 return	this.cntrTpszCd3;
	 } 
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
		* @param  startStayDays
		*/
	public void	setStartStayDays( String	startStayDays ) {
		this.startStayDays =	startStayDays;
	}
 
	/**
	 * Column Info
	 * @return	startStayDays
	 */
	 public	 String	getStartStayDays() {
		 return	this.startStayDays;
	 } 
 	/**
	* Column Info
	* @param  endStayDays
	*/
	public void	setEndStayDays( String	endStayDays ) {
		this.endStayDays =	endStayDays;
	}
 
	/**
	 * Column Info
	 * @return	endStayDays
	 */
	 public	 String	getEndStayDays() {
		 return	this.endStayDays;
	 } 
	 
	 /**
	* Column Info
	* @param  mvmtStatusCcd
	*/
	public void	setMvmtStatusCd( String	mvmtStatusCd ) {
		this.mvmtStatusCd =	mvmtStatusCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtStatusCcd
	 */
	 public	 String	getMvmtStatusCd() {
		 return	this.mvmtStatusCd;
	 } 

	 /**
	 * Page No
	 * @param iPage
	 */
	public void setIPage(int iPage) {
		this.iPage = iPage;
	}

	/**
	 * Page No
	 * @param iPage
	 */
	public int getIPage() {
		return iPage;
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
		setCntrTpszCd14(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd14", ""));
		setCntrTpszCd15(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd15", ""));
		setCntrTpszCd16(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd16", ""));
		setCntrTpszCd17(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd17", ""));
		setCntrTpszCd18(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd18", ""));
		setSubCntrTpszCd(JSPUtil.getParameter(request,	prefix + "sub_cntr_tpsz_cd", ""));
		setCntrTpszCd19(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd19", ""));
		setBkgBlTypeCode(JSPUtil.getParameter(request,	prefix + "bkg_bl_type_code", ""));
		setBkgBlTypeCd(JSPUtil.getParameter(request,	prefix + "bkg_bl_type_cd", ""));
		setRccDate(JSPUtil.getParameter(request,	prefix + "rcc_date", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request,	prefix + "loc_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request,	prefix + "bkg_cust_tp_cd", ""));
		setCntrTpszCd11(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd11", ""));
		setCntrTpszCd10(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd10", ""));
		setCntrTpszCd13(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd13", ""));
		setCntrTpszCd12(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd12", ""));
		setCntrTpszCd27(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd27", ""));
		setCntrTpszCd28(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd28", ""));
		setCntrTpszCd25(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd25", ""));
		setCntrTpszCd26(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd26", ""));
		setCntrTpszCd29(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd29", ""));
		setTabFlag(JSPUtil.getParameter(request,	prefix + "tab_flag", ""));
		setQueryStr(JSPUtil.getParameter(request,	prefix + "query_str", ""));
		setOverStayDays(JSPUtil.getParameter(request,	prefix + "over_stay_days", ""));
		setUclmLsDivCd(JSPUtil.getParameter(request,	prefix + "uclm_ls_div_cd", ""));
		setCustCd(JSPUtil.getParameter(request,	prefix + "cust_cd", ""));
		setCntrTpszCd20(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd20", ""));
		setFullFlg(JSPUtil.getParameter(request,	prefix + "full_flg", ""));
		setCntrTpszCd24(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd24", ""));
		setCntrTpszCd23(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd23", ""));
		setSubCnmvStsCd(JSPUtil.getParameter(request,	prefix + "sub_cnmv_sts_cd", ""));
		setCntrTpszCd22(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd22", ""));
		setCntrTpszCd21(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd21", ""));
		setCnmvStsCd8(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd8", ""));
		setCnmvStsCd7(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd7", ""));
		setCntrUseCoCd(JSPUtil.getParameter(request,	prefix + "cntr_use_co_cd", ""));
		setCnmvStsCd2(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd2", ""));
		setCnmvStsCd1(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd1", ""));
		setDmgFlg(JSPUtil.getParameter(request,	prefix + "dmg_flg", ""));
		setCnmvStsCd4(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd4", ""));
		setCnmvStsCd3(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd3", ""));
		setLocTypeCode(JSPUtil.getParameter(request,	prefix + "loc_type_code", ""));
		setCnmvStsCd6(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd6", ""));
		setCnmvStsCd5(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd5", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd", ""));
		setCntrTpszCd30(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd30", ""));
		setSubLocCd(JSPUtil.getParameter(request,	prefix + "sub_loc_cd", ""));
		setTotCntrTpszCd(JSPUtil.getParameter(request,	prefix + "tot_cntr_tpsz_cd", ""));
		setBkgCustTpCode(JSPUtil.getParameter(request,	prefix + "bkg_cust_tp_code", ""));
		setCntrTpszCd6(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd6", ""));
		setCntrTpszCd5(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd5", ""));
		setCntrTpszCd8(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd8", ""));
		setSocCd(JSPUtil.getParameter(request,	prefix + "soc_cd", ""));
		setCntrTpszCd7(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd7", ""));
		setCntrTpszCd9(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd9", ""));
		setCntrTpszCd2(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd2", ""));
		setCntrTpszCd1(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd1", ""));
		setRepCmdtCd(JSPUtil.getParameter(request,	prefix + "rep_cmdt_cd", ""));
		setCntrTpszCd4(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd4", ""));
		setCntrTpszCd3(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd3", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setStartStayDays(JSPUtil.getParameter(request,	prefix + "start_stay_days", ""));
		setEndStayDays(JSPUtil.getParameter(request,	prefix + "end_stay_days", ""));
		setMvmtStatusCd(JSPUtil.getParameter(request,	prefix + "mvmt_status_cd", ""));
		setIPage(JSPUtil.getParameterAsInt(request, prefix + "iPage", 1));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FlaggingSDaysOptionVO[]
	 */
	public FlaggingSDaysOptionVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return FlaggingSDaysOptionVO[]
	 */
	public FlaggingSDaysOptionVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		FlaggingSDaysOptionVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] cntrTpszCd14 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd14".trim(),	length));
				String[] cntrTpszCd15 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd15".trim(),	length));
				String[] cntrTpszCd16 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd16".trim(),	length));
				String[] cntrTpszCd17 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd17".trim(),	length));
				String[] cntrTpszCd18 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd18".trim(),	length));
				String[] subCntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"sub_cntr_tpsz_cd".trim(),	length));
				String[] cntrTpszCd19 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd19".trim(),	length));
				String[] bkgBlTypeCode =	(JSPUtil.getParameter(request, prefix +	"bkg_bl_type_code".trim(),	length));
				String[] bkgBlTypeCd =	(JSPUtil.getParameter(request, prefix +	"bkg_bl_type_cd".trim(),	length));
				String[] rccDate =	(JSPUtil.getParameter(request, prefix +	"rcc_date".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] locCd =	(JSPUtil.getParameter(request, prefix +	"loc_cd".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] bkgCustTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_cust_tp_cd".trim(),	length));
				String[] cntrTpszCd11 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd11".trim(),	length));
				String[] cntrTpszCd10 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd10".trim(),	length));
				String[] cntrTpszCd13 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd13".trim(),	length));
				String[] cntrTpszCd12 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd12".trim(),	length));
				String[] cntrTpszCd27 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd27".trim(),	length));
				String[] cntrTpszCd28 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd28".trim(),	length));
				String[] cntrTpszCd25 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd25".trim(),	length));
				String[] cntrTpszCd26 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd26".trim(),	length));
				String[] cntrTpszCd29 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd29".trim(),	length));
				String[] tabFlag =	(JSPUtil.getParameter(request, prefix +	"tab_flag".trim(),	length));
				String[] queryStr =	(JSPUtil.getParameter(request, prefix +	"query_str".trim(),	length));
				String[] overStayDays =	(JSPUtil.getParameter(request, prefix +	"over_stay_days".trim(),	length));
				String[] uclmLsDivCd =	(JSPUtil.getParameter(request, prefix +	"uclm_ls_div_cd".trim(),	length));
				String[] custCd =	(JSPUtil.getParameter(request, prefix +	"cust_cd".trim(),	length));
				String[] cntrTpszCd20 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd20".trim(),	length));
				String[] fullFlg =	(JSPUtil.getParameter(request, prefix +	"full_flg".trim(),	length));
				String[] cntrTpszCd24 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd24".trim(),	length));
				String[] cntrTpszCd23 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd23".trim(),	length));
				String[] subCnmvStsCd =	(JSPUtil.getParameter(request, prefix +	"sub_cnmv_sts_cd".trim(),	length));
				String[] cntrTpszCd22 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd22".trim(),	length));
				String[] cntrTpszCd21 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd21".trim(),	length));
				String[] cnmvStsCd8 =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd8".trim(),	length));
				String[] cnmvStsCd7 =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd7".trim(),	length));
				String[] cntrUseCoCd =	(JSPUtil.getParameter(request, prefix +	"cntr_use_co_cd".trim(),	length));
				String[] cnmvStsCd2 =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd2".trim(),	length));
				String[] cnmvStsCd1 =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd1".trim(),	length));
				String[] dmgFlg =	(JSPUtil.getParameter(request, prefix +	"dmg_flg".trim(),	length));
				String[] cnmvStsCd4 =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd4".trim(),	length));
				String[] cnmvStsCd3 =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd3".trim(),	length));
				String[] locTypeCode =	(JSPUtil.getParameter(request, prefix +	"loc_type_code".trim(),	length));
				String[] cnmvStsCd6 =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd6".trim(),	length));
				String[] cnmvStsCd5 =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd5".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] cnmvStsCd =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd".trim(),	length));
				String[] cntrTpszCd30 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd30".trim(),	length));
				String[] subLocCd =	(JSPUtil.getParameter(request, prefix +	"sub_loc_cd".trim(),	length));
				String[] totCntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"tot_cntr_tpsz_cd".trim(),	length));
				String[] bkgCustTpCode =	(JSPUtil.getParameter(request, prefix +	"bkg_cust_tp_code".trim(),	length));
				String[] cntrTpszCd6 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd6".trim(),	length));
				String[] cntrTpszCd5 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd5".trim(),	length));
				String[] cntrTpszCd8 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd8".trim(),	length));
				String[] socCd =	(JSPUtil.getParameter(request, prefix +	"soc_cd".trim(),	length));
				String[] cntrTpszCd7 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd7".trim(),	length));
				String[] cntrTpszCd9 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd9".trim(),	length));
				String[] cntrTpszCd2 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd2".trim(),	length));
				String[] cntrTpszCd1 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd1".trim(),	length));
				String[] repCmdtCd =	(JSPUtil.getParameter(request, prefix +	"rep_cmdt_cd".trim(),	length));
				String[] cntrTpszCd4 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd4".trim(),	length));
				String[] cntrTpszCd3 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd3".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] startStayDays =	(JSPUtil.getParameter(request, prefix +	"start_stay_days".trim(),	length));
				String[] endStayDays =	(JSPUtil.getParameter(request, prefix +	"end_stay_days".trim(),	length));
				String[] mvmtStatusCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_status_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	FlaggingSDaysOptionVO();
						if ( cntrTpszCd14[i] !=	null)
						model.setCntrTpszCd14( cntrTpszCd14[i]);
						if ( cntrTpszCd15[i] !=	null)
						model.setCntrTpszCd15( cntrTpszCd15[i]);
						if ( cntrTpszCd16[i] !=	null)
						model.setCntrTpszCd16( cntrTpszCd16[i]);
						if ( cntrTpszCd17[i] !=	null)
						model.setCntrTpszCd17( cntrTpszCd17[i]);
						if ( cntrTpszCd18[i] !=	null)
						model.setCntrTpszCd18( cntrTpszCd18[i]);
						if ( subCntrTpszCd[i] !=	null)
						model.setSubCntrTpszCd( subCntrTpszCd[i]);
						if ( cntrTpszCd19[i] !=	null)
						model.setCntrTpszCd19( cntrTpszCd19[i]);
						if ( bkgBlTypeCode[i] !=	null)
						model.setBkgBlTypeCode( bkgBlTypeCode[i]);
						if ( bkgBlTypeCd[i] !=	null)
						model.setBkgBlTypeCd( bkgBlTypeCd[i]);
						if ( rccDate[i] !=	null)
						model.setRccDate( rccDate[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( locCd[i] !=	null)
						model.setLocCd( locCd[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( bkgCustTpCd[i] !=	null)
						model.setBkgCustTpCd( bkgCustTpCd[i]);
						if ( cntrTpszCd11[i] !=	null)
						model.setCntrTpszCd11( cntrTpszCd11[i]);
						if ( cntrTpszCd10[i] !=	null)
						model.setCntrTpszCd10( cntrTpszCd10[i]);
						if ( cntrTpszCd13[i] !=	null)
						model.setCntrTpszCd13( cntrTpszCd13[i]);
						if ( cntrTpszCd12[i] !=	null)
						model.setCntrTpszCd12( cntrTpszCd12[i]);
						if ( cntrTpszCd27[i] !=	null)
						model.setCntrTpszCd27( cntrTpszCd27[i]);
						if ( cntrTpszCd28[i] !=	null)
						model.setCntrTpszCd28( cntrTpszCd28[i]);
						if ( cntrTpszCd25[i] !=	null)
						model.setCntrTpszCd25( cntrTpszCd25[i]);
						if ( cntrTpszCd26[i] !=	null)
						model.setCntrTpszCd26( cntrTpszCd26[i]);
						if ( cntrTpszCd29[i] !=	null)
						model.setCntrTpszCd29( cntrTpszCd29[i]);
						if ( tabFlag[i] !=	null)
						model.setTabFlag( tabFlag[i]);
						if ( queryStr[i] !=	null)
						model.setQueryStr( queryStr[i]);
						if ( overStayDays[i] !=	null)
						model.setOverStayDays( overStayDays[i]);
						if ( uclmLsDivCd[i] !=	null)
						model.setUclmLsDivCd( uclmLsDivCd[i]);
						if ( custCd[i] !=	null)
						model.setCustCd( custCd[i]);
						if ( cntrTpszCd20[i] !=	null)
						model.setCntrTpszCd20( cntrTpszCd20[i]);
						if ( fullFlg[i] !=	null)
						model.setFullFlg( fullFlg[i]);
						if ( cntrTpszCd24[i] !=	null)
						model.setCntrTpszCd24( cntrTpszCd24[i]);
						if ( cntrTpszCd23[i] !=	null)
						model.setCntrTpszCd23( cntrTpszCd23[i]);
						if ( subCnmvStsCd[i] !=	null)
						model.setSubCnmvStsCd( subCnmvStsCd[i]);
						if ( cntrTpszCd22[i] !=	null)
						model.setCntrTpszCd22( cntrTpszCd22[i]);
						if ( cntrTpszCd21[i] !=	null)
						model.setCntrTpszCd21( cntrTpszCd21[i]);
						if ( cnmvStsCd8[i] !=	null)
						model.setCnmvStsCd8( cnmvStsCd8[i]);
						if ( cnmvStsCd7[i] !=	null)
						model.setCnmvStsCd7( cnmvStsCd7[i]);
						if ( cntrUseCoCd[i] !=	null)
						model.setCntrUseCoCd( cntrUseCoCd[i]);
						if ( cnmvStsCd2[i] !=	null)
						model.setCnmvStsCd2( cnmvStsCd2[i]);
						if ( cnmvStsCd1[i] !=	null)
						model.setCnmvStsCd1( cnmvStsCd1[i]);
						if ( dmgFlg[i] !=	null)
						model.setDmgFlg( dmgFlg[i]);
						if ( cnmvStsCd4[i] !=	null)
						model.setCnmvStsCd4( cnmvStsCd4[i]);
						if ( cnmvStsCd3[i] !=	null)
						model.setCnmvStsCd3( cnmvStsCd3[i]);
						if ( locTypeCode[i] !=	null)
						model.setLocTypeCode( locTypeCode[i]);
						if ( cnmvStsCd6[i] !=	null)
						model.setCnmvStsCd6( cnmvStsCd6[i]);
						if ( cnmvStsCd5[i] !=	null)
						model.setCnmvStsCd5( cnmvStsCd5[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( cnmvStsCd[i] !=	null)
						model.setCnmvStsCd( cnmvStsCd[i]);
						if ( cntrTpszCd30[i] !=	null)
						model.setCntrTpszCd30( cntrTpszCd30[i]);
						if ( subLocCd[i] !=	null)
						model.setSubLocCd( subLocCd[i]);
						if ( totCntrTpszCd[i] !=	null)
						model.setTotCntrTpszCd( totCntrTpszCd[i]);
						if ( bkgCustTpCode[i] !=	null)
						model.setBkgCustTpCode( bkgCustTpCode[i]);
						if ( cntrTpszCd6[i] !=	null)
						model.setCntrTpszCd6( cntrTpszCd6[i]);
						if ( cntrTpszCd5[i] !=	null)
						model.setCntrTpszCd5( cntrTpszCd5[i]);
						if ( cntrTpszCd8[i] !=	null)
						model.setCntrTpszCd8( cntrTpszCd8[i]);
						if ( socCd[i] !=	null)
						model.setSocCd( socCd[i]);
						if ( cntrTpszCd7[i] !=	null)
						model.setCntrTpszCd7( cntrTpszCd7[i]);
						if ( cntrTpszCd9[i] !=	null)
						model.setCntrTpszCd9( cntrTpszCd9[i]);
						if ( cntrTpszCd2[i] !=	null)
						model.setCntrTpszCd2( cntrTpszCd2[i]);
						if ( cntrTpszCd1[i] !=	null)
						model.setCntrTpszCd1( cntrTpszCd1[i]);
						if ( repCmdtCd[i] !=	null)
						model.setRepCmdtCd( repCmdtCd[i]);
						if ( cntrTpszCd4[i] !=	null)
						model.setCntrTpszCd4( cntrTpszCd4[i]);
						if ( cntrTpszCd3[i] !=	null)
						model.setCntrTpszCd3( cntrTpszCd3[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( startStayDays[i] !=	null)
						model.setStartStayDays( startStayDays[i]);
						if ( endStayDays[i] !=	null)
						model.setEndStayDays( endStayDays[i]);
						if ( mvmtStatusCd[i] !=	null)
						model.setMvmtStatusCd( mvmtStatusCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getFlaggingSDaysOptionVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return FlaggingSDaysOptionVO[]
	 */
	public FlaggingSDaysOptionVO[]	 getFlaggingSDaysOptionVOs(){
		FlaggingSDaysOptionVO[] vos = (FlaggingSDaysOptionVO[])models.toArray(new	FlaggingSDaysOptionVO[models.size()]);
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
		this.cntrTpszCd14 =	this.cntrTpszCd14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd15 =	this.cntrTpszCd15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd16 =	this.cntrTpszCd16.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd17 =	this.cntrTpszCd17.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd18 =	this.cntrTpszCd18.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subCntrTpszCd =	this.subCntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd19 =	this.cntrTpszCd19.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBlTypeCode =	this.bkgBlTypeCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBlTypeCd =	this.bkgBlTypeCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccDate =	this.rccDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd =	this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd =	this.bkgCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd11 =	this.cntrTpszCd11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd10 =	this.cntrTpszCd10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd13 =	this.cntrTpszCd13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd12 =	this.cntrTpszCd12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd27 =	this.cntrTpszCd27.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd28 =	this.cntrTpszCd28.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd25 =	this.cntrTpszCd25.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd26 =	this.cntrTpszCd26.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd29 =	this.cntrTpszCd29.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tabFlag =	this.tabFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.queryStr =	this.queryStr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overStayDays =	this.overStayDays.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLsDivCd =	this.uclmLsDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd =	this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd20 =	this.cntrTpszCd20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg =	this.fullFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd24 =	this.cntrTpszCd24.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd23 =	this.cntrTpszCd23.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subCnmvStsCd =	this.subCnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd22 =	this.cntrTpszCd22.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd21 =	this.cntrTpszCd21.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd8 =	this.cnmvStsCd8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd7 =	this.cnmvStsCd7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrUseCoCd =	this.cntrUseCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd2 =	this.cnmvStsCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd1 =	this.cnmvStsCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg =	this.dmgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd4 =	this.cnmvStsCd4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd3 =	this.cnmvStsCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTypeCode =	this.locTypeCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd6 =	this.cnmvStsCd6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd5 =	this.cnmvStsCd5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd =	this.cnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd30 =	this.cntrTpszCd30.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subLocCd =	this.subLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCntrTpszCd =	this.totCntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCode =	this.bkgCustTpCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd6 =	this.cntrTpszCd6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd5 =	this.cntrTpszCd5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd8 =	this.cntrTpszCd8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socCd =	this.socCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd7 =	this.cntrTpszCd7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd9 =	this.cntrTpszCd9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd2 =	this.cntrTpszCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd1 =	this.cntrTpszCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd =	this.repCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd4 =	this.cntrTpszCd4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd3 =	this.cntrTpszCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startStayDays =	this.startStayDays.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endStayDays =	this.endStayDays.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStatusCd =	this.mvmtStatusCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}