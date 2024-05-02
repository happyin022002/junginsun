/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOSearchBareMGSetDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOSearchBareMGSetDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInventoryDBDAOSearchBareMGSetDataRSQL
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOSearchBareMGSetDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromlocation",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tolocation",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOSearchBareMGSetDataRSQL").append("\n"); 
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
		query.append("SELECT A.MGST_NO," ).append("\n"); 
		query.append("       A.MGST_BARE_STS_CD," ).append("\n"); 
		query.append("       B.EQ_TPSZ_CD," ).append("\n"); 
		query.append("       CASE " ).append("\n"); 
		query.append("         WHEN B.EQ_TPSZ_CD = 'UMG' THEN" ).append("\n"); 
		query.append("          (SELECT CHSS_MVMT_STS_CD FROM CGM_EQUIPMENT WHERE EQ_NO = A.CHSS_NO)" ).append("\n"); 
		query.append("         ELSE" ).append("\n"); 
		query.append("          (SELECT CNMV_STS_CD FROM MST_CONTAINER WHERE CNTR_NO = A.CNTR_NO)" ).append("\n"); 
		query.append("       END MVMT," ).append("\n"); 
		query.append("       A.CHSS_NO," ).append("\n"); 
		query.append("       A.CNTR_NO," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("         WHEN B.EQ_TPSZ_CD = 'UMG' THEN" ).append("\n"); 
		query.append("          (SELECT TRUNC(SYSDATE - CHSS_MVMT_DT, 0)" ).append("\n"); 
		query.append("             FROM CGM_EQUIPMENT" ).append("\n"); 
		query.append("            WHERE EQ_NO = A.CHSS_NO)" ).append("\n"); 
		query.append("         ELSE" ).append("\n"); 
		query.append("          (SELECT TRUNC(SYSDATE - CNMV_DT, 0)" ).append("\n"); 
		query.append("             FROM MST_CONTAINER" ).append("\n"); 
		query.append("            WHERE CNTR_NO = A.CNTR_NO)" ).append("\n"); 
		query.append("       END LSDAYS," ).append("\n"); 
		query.append("       C.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("       DECODE(A.EQ_TRSP_MOD_CD, 'T', 'Truck', 'R', 'Rail') AS EQ_TRSP_MOD_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       A.RTN_YD_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.MGST_BARE_EVNT_DT, 'YYYY-MM-DD') MGST_BARE_EVNT_DT," ).append("\n"); 
		query.append("       A.UPD_DT," ).append("\n"); 
		query.append("       A.UPD_USR_ID," ).append("\n"); 
		query.append("       A.BARE_MGST_RMK," ).append("\n"); 
		query.append("       -- HIDDEN" ).append("\n"); 
		query.append("       A.VNDR_SEQ," ).append("\n"); 
		query.append("       A.MGST_BARE_STS_SEQ" ).append("\n"); 
		query.append("FROM CGM_BARE_MGST_REPO A" ).append("\n"); 
		query.append("   , CGM_EQUIPMENT B" ).append("\n"); 
		query.append("   , MDM_VENDOR C" ).append("\n"); 
		query.append("WHERE A.MGST_NO   = B.EQ_NO" ).append("\n"); 
		query.append("AND   B.EQ_KND_CD = 'G' -- HARD CODING, GENSET   " ).append("\n"); 
		query.append("AND   A.DELT_FLG  = 'N'  -- 삭제 안된것만 조회  " ).append("\n"); 
		query.append("AND   A.VNDR_SEQ  = C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND   A.MGST_BARE_EVNT_DT BETWEEN TO_DATE(@[fromdate], 'YYYY-MM-DD') AND TO_DATE(@[todate], 'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if ( ${status} != '' )" ).append("\n"); 
		query.append("AND   A.MGST_BARE_STS_CD = @[status] -- BMP / BMT" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("    #if ( ${fromlocation} != '')" ).append("\n"); 
		query.append("AND   A.ORG_YD_CD IN (" ).append("\n"); 
		query.append("                            SELECT DISTINCT C.YD_CD" ).append("\n"); 
		query.append("                            FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("                                ,MDM_LOCATION B" ).append("\n"); 
		query.append("                                ,MDM_YARD C               	    " ).append("\n"); 
		query.append("                            WHERE A.SCC_CD = B.SCC_CD " ).append("\n"); 
		query.append("                            AND   B.LOC_CD = C.LOC_CD  " ).append("\n"); 
		query.append("                            AND   A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND   B.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                            AND   C.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("	    #if 	( ${fromstatus} == 'R' )" ).append("\n"); 
		query.append("                            AND   A.RCC_CD IN ( @[fromlocation] )" ).append("\n"); 
		query.append("	    #elseif ( ${fromstatus} == 'L' )" ).append("\n"); 
		query.append("                            AND   A.LCC_CD IN ( @[fromlocation] )" ).append("\n"); 
		query.append("	    #elseif ( ${fromstatus} == 'E' ) " ).append("\n"); 
		query.append("                            AND   A.ECC_CD IN ( @[fromlocation] )" ).append("\n"); 
		query.append("	    #elseif ( ${fromstatus} == 'S' )" ).append("\n"); 
		query.append("                            AND   A.SCC_CD IN ( @[fromlocation] )" ).append("\n"); 
		query.append("	    #else" ).append("\n"); 
		query.append("                            AND   C.YD_CD  IN ( @[fromlocation] )      " ).append("\n"); 
		query.append("	    #end                 " ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if ( ${tolocation} != '') " ).append("\n"); 
		query.append("AND   A.RTN_YD_CD IN (" ).append("\n"); 
		query.append("                            SELECT DISTINCT C.YD_CD" ).append("\n"); 
		query.append("                            FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("                                ,MDM_LOCATION B" ).append("\n"); 
		query.append("                                ,MDM_YARD C               	    " ).append("\n"); 
		query.append("                            WHERE A.SCC_CD = B.SCC_CD " ).append("\n"); 
		query.append("                            AND   B.LOC_CD = C.LOC_CD  " ).append("\n"); 
		query.append("                            AND   A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND   B.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                            AND   C.DELT_FLG = 'N' " ).append("\n"); 
		query.append("	   	#if 	( ${tostatus} == 'R' )                        " ).append("\n"); 
		query.append("                            AND   A.RCC_CD IN ( @[tolocation] )" ).append("\n"); 
		query.append("	   	#elseif ( ${tostatus} == 'L' )" ).append("\n"); 
		query.append("                            AND   A.LCC_CD IN ( @[tolocation] )" ).append("\n"); 
		query.append("	   	#elseif ( ${tostatus} == 'E' ) " ).append("\n"); 
		query.append("                            AND   A.ECC_CD IN ( @[tolocation] )" ).append("\n"); 
		query.append("	   	#elseif ( ${tostatus} == 'S' )" ).append("\n"); 
		query.append("                            AND   A.SCC_CD IN ( @[tolocation] )" ).append("\n"); 
		query.append("	   	#else" ).append("\n"); 
		query.append("                            AND   C.YD_CD  IN ( @[tolocation] )      " ).append("\n"); 
		query.append("	   	#end                               " ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.MGST_NO" ).append("\n"); 
		query.append("        ,A.MGST_BARE_STS_SEQ" ).append("\n"); 

	}
}