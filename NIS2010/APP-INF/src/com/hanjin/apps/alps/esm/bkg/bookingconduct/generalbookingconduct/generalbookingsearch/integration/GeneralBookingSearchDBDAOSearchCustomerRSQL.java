/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustomer
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("area_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchCustomerRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT CUST_CD, " ).append("\n"); 
		query.append("  CUST_NM, " ).append("\n"); 
		query.append("  OFC_CD, " ).append("\n"); 
		query.append("  DECODE(SLS_DELT_EFF_DT, NULL, 'Y', 'Y' , 'Y', 'N') USE, " ).append("\n"); 
		query.append("  BZET_ADDR, " ).append("\n"); 
		query.append("  STE_CD, " ).append("\n"); 
		query.append("  ZIP_CD, " ).append("\n"); 
		query.append("  LOC_CD, " ).append("\n"); 
		query.append("  DECODE(RVIS_CNTR_CUST_TP_CD, 'B', 'BCO', 'Non-BCO') RVIS_CNTR_CUST_TP_CD, " ).append("\n"); 
		query.append("  CUST_GRP_ID," ).append("\n"); 
		query.append("  VNDR_SEQ," ).append("\n"); 
		query.append("  CTY_NM," ).append("\n"); 
		query.append("  PHN_NO," ).append("\n"); 
		query.append("  R_BKLST," ).append("\n"); 
		query.append("  BOOKING_ALERT_TO_DATE," ).append("\n"); 
		query.append("  NO_USE," ).append("\n"); 
		query.append("  CASE WHEN SLS_DELT_EFF_DT IS NOT NULL THEN 'No Use'" ).append("\n"); 
		query.append("       WHEN NVL(R_BKLST, 'N') = 'Y' THEN 'Financial Risk'	" ).append("\n"); 
		query.append("	 --WHEN CUST.DELT_FLG = 'Y' THEN 'Delete'		" ).append("\n"); 
		query.append("     --WHEN CUST.VBS_CLSS_CD = '01' THEN 'PREMIUM' Request by Woori hong" ).append("\n"); 
		query.append("       ELSE 'Use' END pb," ).append("\n"); 
		query.append("  LOCATION_CODE" ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("    SELECT  /*+ USE_NL(A D B C F) *//*+ INDEX_ASC(A XPKMDM_CUSTOMER) */ /*+ ORDERED */" ).append("\n"); 
		query.append("      ROWNUM NO, " ).append("\n"); 
		query.append("      A.CUST_CNT_CD||lpad(A.CUST_SEQ, 6, 0) CUST_CD, " ).append("\n"); 
		query.append("      A.CUST_LGL_ENG_NM CUST_NM, " ).append("\n"); 
		query.append("      A.OFC_CD, " ).append("\n"); 
		query.append("      A.SLS_DELT_EFF_DT SLS_DELT_EFF_DT, " ).append("\n"); 
		query.append("      B.BZET_ADDR, " ).append("\n"); 
		query.append("      B.STE_CD, " ).append("\n"); 
		query.append("      B.ZIP_CD, " ).append("\n"); 
		query.append("      A.LOC_CD, " ).append("\n"); 
		query.append("      A.RVIS_CNTR_CUST_TP_CD, " ).append("\n"); 
		query.append("      A.CUST_GRP_ID, " ).append("\n"); 
		query.append("      A.VNDR_SEQ ," ).append("\n"); 
		query.append("      B.CTY_NM," ).append("\n"); 
		query.append("      D.PHN_NO," ).append("\n"); 
		query.append("      C.CUST_RLSE_CTRL_FLG   R_BKLST, " ).append("\n"); 
		query.append("      DECODE(C.CUST_RLSE_CTRL_FLG,'N','No','Y','Yes',NULL,'No',C.CUST_RLSE_CTRL_FLG) BOOKING_ALERT_TO_DATE," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("          WHEN A.DELT_FLG = 'Y' THEN 'Yes'" ).append("\n"); 
		query.append("          WHEN A.SLS_DELT_EFF_DT IS NOT NULL THEN 'Yes'" ).append("\n"); 
		query.append("        ELSE 'No'" ).append("\n"); 
		query.append("        END " ).append("\n"); 
		query.append("        ) AS NO_USE," ).append("\n"); 
		query.append("	  F.LOC_CD || '-' || F.LOC_NM as LOCATION_CODE " ).append("\n"); 
		query.append("    FROM MDM_CUSTOMER A, " ).append("\n"); 
		query.append("      MDM_CUST_CNTC_PNT D," ).append("\n"); 
		query.append("      MDM_CUST_ADDR B ," ).append("\n"); 
		query.append("      MDM_CR_CUST C ," ).append("\n"); 
		query.append("	  MDM_LOCATION F" ).append("\n"); 
		query.append("    WHERE 1 = 1 " ).append("\n"); 
		query.append("      AND A.CUST_CNT_CD = B.CUST_CNT_CD(+) " ).append("\n"); 
		query.append("      AND A.CUST_SEQ = B.CUST_SEQ(+) " ).append("\n"); 
		query.append("      AND A.CUST_CNT_CD = C.CUST_CNT_CD(+) " ).append("\n"); 
		query.append("      AND A.CUST_SEQ = C.CUST_SEQ(+) " ).append("\n"); 
		query.append("      AND A.CUST_CNT_CD = D.CUST_CNT_CD" ).append("\n"); 
		query.append("      AND A.CUST_SEQ = D.CUST_SEQ" ).append("\n"); 
		query.append("      AND B.PRMRY_CHK_FLG(+) = 'Y' " ).append("\n"); 
		query.append("      AND A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("	  AND NVL(NMD_CUST_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("	  AND A.LOC_CD = F.LOC_CD(+)" ).append("\n"); 
		query.append("#if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("        AND A.CUST_CNT_CD = SUBSTR(@[cust_cnt_cd],1,2)" ).append("\n"); 
		query.append("		AND A.CUST_SEQ    = TO_NUMBER(NVL(SUBSTR(@[cust_cnt_cd],3),A.CUST_SEQ))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_nm} != '')" ).append("\n"); 
		query.append("	#if(${include} == 'on')" ).append("\n"); 
		query.append("		AND (REGEXP_REPLACE(UPPER(A.CUST_LGL_ENG_NM),'[^a-zA-Z0-9]','')  LIKE '%'||REGEXP_REPLACE(UPPER(@[cust_nm]),'[^a-zA-Z0-9]','')||'%')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND upper(A.CUST_LGL_ENG_NM) LIKE upper(@[cust_nm]) || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ofc_cd} != '')" ).append("\n"); 
		query.append("		AND A.OFC_CD LIKE @[ofc_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cty_nm} != '') " ).append("\n"); 
		query.append("  and UPPER(B.CTY_NM)  = UPPER(@[cty_nm])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ste_cd} != '') " ).append("\n"); 
		query.append("  and UPPER(B.STE_CD)  = UPPER(@[ste_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${zip_cd} != '') " ).append("\n"); 
		query.append("  and UPPER(B.ZIP_CD)   = UPPER(@[zip_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${area_cd} != '') " ).append("\n"); 
		query.append("  AND SUBSTR(LTRIM(D.PHN_NO,'1-'),0,3)  = @[area_cd]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("No Use : Check 되어 있지 않은 것이 default. Check 되지 않은 상태로 검색하면 No Use Flag 가 있는 Customer 는 검색 결과에 보여주지 않음." ).append("\n"); 
		query.append("         Check 한 상태로 검색하면 No Use Flag 가 있는 Customer를 포함하여 검색 결과에 보여줌.(전체검색)" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("#if (${no_use} == '') " ).append("\n"); 
		query.append("  AND A.SLS_DELT_EFF_DT IS NULL" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bklst} != '') " ).append("\n"); 
		query.append("AND NVL(C.CUST_RLSE_CTRL_FLG, 'N') IN ('N','Y') " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     AND NVL(C.CUST_RLSE_CTRL_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) A " ).append("\n"); 
		query.append("WHERE NO BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 
		query.append("ORDER BY CUST_CD" ).append("\n"); 

	}
}