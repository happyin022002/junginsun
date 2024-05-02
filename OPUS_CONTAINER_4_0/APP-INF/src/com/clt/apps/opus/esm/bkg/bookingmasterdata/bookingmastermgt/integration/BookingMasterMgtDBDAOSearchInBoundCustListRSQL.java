/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchInBoundCustListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOSearchInBoundCustListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  0192 B/L Customer Information in CRM 조회			
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchInBoundCustListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_addr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rows_per_page",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bco_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("curr_page",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchInBoundCustListRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM ( SELECT     UPPER(DELT_FLG) AS DELT_FLG" ).append("\n"); 
		query.append("                ,  UPPER(HISTORY_YN) AS HISTORY_YN" ).append("\n"); 
		query.append("                ,  UPPER(CUST_CNT_CD) AS CUST_CNT_CD" ).append("\n"); 
		query.append("                ,  CUST_SEQ" ).append("\n"); 
		query.append("                ,  UPPER(CODE) AS CODE" ).append("\n"); 
		query.append("                ,  UPPER(CUST_NM) AS CUST_NM" ).append("\n"); 
		query.append("                ,  UPPER(CUST_ADDR) AS CUST_ADDR" ).append("\n"); 
		query.append("                ,  UPPER(OFC_CD) AS OFC_CD" ).append("\n"); 
		query.append("                ,  UPPER(CTY_NM) AS CTY_NM" ).append("\n"); 
		query.append("                ,  UPPER(STE_CD) AS STE_CD" ).append("\n"); 
		query.append("                ,  UPPER(ZIP_CD) AS ZIP_CD" ).append("\n"); 
		query.append("                ,  UPPER(BCO_TYPE) AS BCO_TYPE" ).append("\n"); 
		query.append("                ,  UPPER(CNT_CD) AS CNT_CD" ).append("\n"); 
		query.append("                ,  ROWNUM RNUM" ).append("\n"); 
		query.append("                ,  TOTAL_CNT" ).append("\n"); 
		query.append("                ,  ROWS_PER_PAGE" ).append("\n"); 
		query.append("                ,  CURR_PAGE " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("       FROM (  SELECT /*+RULE*/" ).append("\n"); 
		query.append("					CASE WHEN A.DELT_FLG = 'Y' THEN 'N'" ).append("\n"); 
		query.append("						 WHEN SLS_DELT_EFF_DT IS NOT NULL THEN 'N'" ).append("\n"); 
		query.append("						 ELSE '' END DELT_FLG" ).append("\n"); 
		query.append("					, NVL((SELECT 'Y' FROM BKG_IB_CUST_CNTC C" ).append("\n"); 
		query.append("							WHERE 1=1" ).append("\n"); 
		query.append("							AND C.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("							AND C.CUST_SEQ = B.CUST_SEQ " ).append("\n"); 
		query.append("							AND (C.FAX_NO IS NOT NULL OR C.CNTC_EML IS NOT NULL)" ).append("\n"); 
		query.append("							AND ROWNUM =1),'N') HISTORY_YN" ).append("\n"); 
		query.append("					,  A.CUST_CNT_CD" ).append("\n"); 
		query.append("					,  A.CUST_SEQ" ).append("\n"); 
		query.append("					,  A.CUST_CNT_CD || A.CUST_SEQ CODE" ).append("\n"); 
		query.append("					,  A.CUST_LGL_ENG_NM CUST_NM " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   #if (${cust_nm} != '') " ).append("\n"); 
		query.append("                    , INSTR(A.CUST_LGL_ENG_NM,@[cust_nm]) " ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("					,  B.BZET_ADDR CUST_ADDR" ).append("\n"); 
		query.append("					,  A.OFC_CD" ).append("\n"); 
		query.append("					,  B.CTY_NM" ).append("\n"); 
		query.append("					,  B.STE_CD" ).append("\n"); 
		query.append("					,  B.ZIP_CD" ).append("\n"); 
		query.append("					,  A.CNTR_CUST_TP_CD BCO_TYPE" ).append("\n"); 
		query.append("					,  COUNT(A.CUST_CNT_CD) OVER() TOTAL_CNT" ).append("\n"); 
		query.append("					,  '' ROWS_PER_PAGE" ).append("\n"); 
		query.append("					,  '' CURR_PAGE" ).append("\n"); 
		query.append("					, B.CNT_CD" ).append("\n"); 
		query.append("			FROM  MDM_CUSTOMER  A" ).append("\n"); 
		query.append("				, MDM_CUST_ADDR B" ).append("\n"); 
		query.append("			WHERE A.CUST_CNT_CD = B.CUST_CNT_CD " ).append("\n"); 
		query.append("			AND   A.CUST_SEQ    = B.CUST_SEQ" ).append("\n"); 
		query.append("            AND   A.DELT_FLG ='N'" ).append("\n"); 
		query.append("            AND   A.CNTR_DIV_FLG = 'Y' " ).append("\n"); 
		query.append("            AND   B.PRMRY_CHK_FLG ='Y'  " ).append("\n"); 
		query.append("			AND   B.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("			#if (${cust_seq} != '') " ).append("\n"); 
		query.append("			AND   B.CUST_SEQ    = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${bco_type} == 'FF') " ).append("\n"); 
		query.append("			AND   A.CNTR_CUST_TP_CD = @[bco_type]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${cust_nm} != '')" ).append("\n"); 
		query.append("			AND   UPPER(A.CUST_LGL_ENG_NM)  LIKE '%'||UPPER(@[cust_nm])||'%'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${cust_addr} != '')" ).append("\n"); 
		query.append("			AND   UPPER(B.BZET_ADDR)        LIKE '%'||UPPER(@[cust_addr])||'%'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${cty_nm} != '')" ).append("\n"); 
		query.append("			AND   UPPER(B.CTY_NM)           LIKE '%'||UPPER(@[cty_nm])||'%'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${ste_cd} != '')" ).append("\n"); 
		query.append("			AND   UPPER(B.STE_CD)           LIKE '%'||UPPER(@[ste_cd])||'%'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${zip_cd} != '')" ).append("\n"); 
		query.append("			AND   UPPER(B.ZIP_CD)           LIKE '%'||UPPER(@[zip_cd])||'%'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			#if (${cust_nm} != '') " ).append("\n"); 
		query.append("			ORDER BY DELT_FLG DESC,INSTR(A.CUST_LGL_ENG_NM,@[cust_nm]),CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("	  		#else" ).append("\n"); 
		query.append("			ORDER BY DELT_FLG DESC,CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE RNUM BETWEEN NVL(@[rows_per_page],50) * (NVL(@[curr_page],1) - 1) + 1" ).append("\n"); 
		query.append("           AND     NVL(@[rows_per_page],50) *  NVL(@[curr_page],1)" ).append("\n"); 

	}
}