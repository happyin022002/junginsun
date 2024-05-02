/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialSOCheckDBDAOsearchOtherSOCheckListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.01.04 양봉준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialSOCheckDBDAOsearchOtherSOCheckListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Special S/O of Transport에서 Other S/O sheet조회
	  * </pre>
	  */
	public SpecialSOCheckDBDAOsearchOtherSOCheckListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_so_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_so_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : SpecialSOCheckDBDAOsearchOtherSOCheckListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT 	DISTINCT" ).append("\n"); 
		query.append("A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ SO_NO 					," ).append("\n"); 
		query.append("A.EQ_NO														," ).append("\n"); 
		query.append("A.EQ_TPSZ_CD												," ).append("\n"); 
		query.append("DECODE(A.TRSP_BND_CD, 'I','In','O','Out',A.TRSP_BND_CD)	TRSP_BND_CD	," ).append("\n"); 
		query.append("DECODE(A.CGO_TP_CD, 'F','Full','M','Empty',	A.CGO_TP_CD) CGO_TP_CD	," ).append("\n"); 
		query.append("A.CNTR_WGT													," ).append("\n"); 
		query.append("A.WGT_MEAS_UT_CD											," ).append("\n"); 
		query.append("A.TRSP_COST_DTL_MOD_CD										," ).append("\n"); 
		query.append("A.TRSP_CRR_MOD_CD											," ).append("\n"); 
		query.append("A.CMDT_CD													," ).append("\n"); 
		query.append("DECODE(A.CUST_NOMI_TRKR_FLG, 'Y', 'CNT', 'HJS')	CUST_NOMI_TRKR_FLG_NM," ).append("\n"); 
		query.append("A.CUST_CNT_CD||A.CUST_SEQ	cust_cnt_cd_seq					," ).append("\n"); 
		query.append("A.TRSP_OTR_COST_MON_DT										," ).append("\n"); 
		query.append("SUBSTR(A.FM_NOD_CD,1,5) FM_LOC_VALUE						," ).append("\n"); 
		query.append("SUBSTR(A.FM_NOD_CD,6,2) FM_YARD_VALUE 						," ).append("\n"); 
		query.append("SUBSTR(A.VIA_NOD_CD,1,5) VIA_LOC_VALUE						," ).append("\n"); 
		query.append("SUBSTR(A.VIA_NOD_CD,6,2) VIA_YARD_VALUE 					," ).append("\n"); 
		query.append("SUBSTR(A.TO_NOD_CD,1,5) TO_LOC_VALUE						," ).append("\n"); 
		query.append("SUBSTR(A.TO_NOD_CD,6,2) TO_YARD_VALUE 						," ).append("\n"); 
		query.append("SUBSTR(A.DOR_NOD_CD,1,5) DR_LOC_VALUE						," ).append("\n"); 
		query.append("SUBSTR(A.DOR_NOD_CD,6,2) DR_YARD_VALUE 						," ).append("\n"); 
		query.append("A.ACT_CUST_CNT_CD||A.ACT_CUST_SEQ ACT_CUST_CNT_CD_SEQ  		," ).append("\n"); 
		query.append("A.DOR_DE_ADDR												," ).append("\n"); 
		query.append("A.VNDR_SEQ													," ).append("\n"); 
		query.append("B.VNDR_ABBR_NM												," ).append("\n"); 
		query.append("A.CURR_CD													," ).append("\n"); 
		query.append("A.BZC_AMT													," ).append("\n"); 
		query.append("A.NEGO_AMT													," ).append("\n"); 
		query.append("A.FUEL_SCG_AMT												," ).append("\n"); 
		query.append("A.ETC_ADD_AMT												," ).append("\n"); 
		query.append("NVL(A.BZC_AMT+A.NEGO_AMT+A.FUEL_SCG_AMT+A.ETC_ADD_AMT, 0) TOTAL_AMT," ).append("\n"); 
		query.append("A.REF_BKG_NO												," ).append("\n"); 
		query.append("--A.REF_BKG_NO_SPLIT											," ).append("\n"); 
		query.append("A.REF_BL_NO													," ).append("\n"); 
		query.append("A.TRSP_PURP_RSN" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD A										," ).append("\n"); 
		query.append("MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND	A.TRSP_SO_TP_CD = 'O'" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD  = @[so_ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${io_bound}!='A')" ).append("\n"); 
		query.append("AND NVL(A.TRSP_BND_CD, 'N/A')	= NVL(@[io_bound], NVL(A.TRSP_BND_CD, 'N/A'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${so_month}!='' && ${so_month}!='YYYYMM')" ).append("\n"); 
		query.append("AND TO_CHAR(A.LOCL_CRE_DT, 'YYYYMM')  = @[so_month]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ((${fm_so_date}!='') && (${to_so_date}!='')&& (${fm_so_date}!='YYYYMMDD')&& (${to_so_date}!='YYYYMMDD'))" ).append("\n"); 
		query.append("AND A.LOCL_CRE_DT >= TO_DATE(NVL( @[fm_so_date], @[to_so_date]),'YYYYMMDD')" ).append("\n"); 
		query.append("AND A.LOCL_CRE_DT <= TO_DATE(NVL( @[to_so_date], @[fm_so_date]),'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("ORDER BY A.EQ_NO" ).append("\n"); 

	}
}