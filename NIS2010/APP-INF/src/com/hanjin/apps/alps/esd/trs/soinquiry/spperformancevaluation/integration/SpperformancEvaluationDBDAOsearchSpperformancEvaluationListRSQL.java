/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpperformancEvaluationDBDAOsearchSpperformancEvaluationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.10
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.11.10 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpperformancEvaluationDBDAOsearchSpperformancEvaluationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Performance Evaluation 조회
	  * </pre>
	  */
	public SpperformancEvaluationDBDAOsearchSpperformancEvaluationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_provider",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.integration").append("\n"); 
		query.append("FileName : SpperformancEvaluationDBDAOsearchSpperformancEvaluationListRSQL").append("\n"); 
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
		query.append("SELECT WO.TRSP_WO_OFC_CTY_CD||WO.TRSP_WO_SEQ  AS TRS_WO_KEY" ).append("\n"); 
		query.append("      ,WO.TRSP_WO_OFC_CTY_CD AS TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,WO.TRSP_WO_SEQ AS TRSP_WO_SEQ" ).append("\n"); 
		query.append("      ,MAX(WO.WO_VNDR_SEQ) AS WO_VNDR_SEQ" ).append("\n"); 
		query.append("      ,MAX(MV.VNDR_LGL_ENG_NM) AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(MAX(WO.LOCL_CRE_DT),'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("      ,MAX(VE.WO_EV_GRD_CD) AS WO_EV_GRD_CD" ).append("\n"); 
		query.append("      ,MAX(VE.SHPR_EV_GRD_CD) AS SHPR_EV_GRD_CD" ).append("\n"); 
		query.append("      ,MAX(VE.EV_CTNT) AS EV_CTNT" ).append("\n"); 
		query.append("      ,TO_CHAR(MAX(VE.CRE_DT),'YYYYMMDD') CRE_DT_1" ).append("\n"); 
		query.append("      ,MAX(VE.CRE_USR_ID)  AS CRE_USR_ID" ).append("\n"); 
		query.append("  FROM TRS_TRSP_WRK_ORD      WO" ).append("\n"); 
		query.append("      ,TRS_TRSP_SVC_ORD      SO" ).append("\n"); 
		query.append("      ,TRS_TRSP_VNDR_PERF_EV VE" ).append("\n"); 
		query.append("      ,MDM_VENDOR            MV" ).append("\n"); 
		query.append("      ,TRS_TRSP_INV_WRK      INV" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND WO.TRSP_WO_OFC_CTY_CD   = SO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND WO.TRSP_WO_SEQ          = SO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("   AND SO.TRSP_SO_STS_CD      IN ('I' ,'E')" ).append("\n"); 
		query.append("   AND SO.INV_NO               = INV.INV_NO" ).append("\n"); 
		query.append("   AND SO.INV_VNDR_SEQ         = INV.INV_VNDR_SEQ" ).append("\n"); 
		query.append("   AND WO.WO_VNDR_SEQ          = MV.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND WO.TRSP_WO_OFC_CTY_CD   = VE.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND WO.TRSP_WO_SEQ          = VE.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("   AND INV.TRSP_INV_AUD_STS_CD = 'IF'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($tempWoNo.size() > 0)" ).append("\n"); 
		query.append("   AND   WO.TRSP_WO_OFC_CTY_CD||WO.TRSP_WO_SEQ  IN (" ).append("\n"); 
		query.append("#foreach($tempWoNokey IN ${tempWoNo})" ).append("\n"); 
		query.append("	#if($velocityCount < $tempWoNo.size())" ).append("\n"); 
		query.append("		'$tempWoNokey'," ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		'$tempWoNokey'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${r_period} == 'I')" ).append("\n"); 
		query.append("	#if ((${r_from_date} != '') && (${r_to_date} != ''))" ).append("\n"); 
		query.append("        AND WO.LOCL_CRE_DT BETWEEN TO_DATE(@[hid_from_date],'YYYYMMDD') AND TO_DATE(@[hid_to_date],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif(${r_period} == 'E')" ).append("\n"); 
		query.append("	#if ((${r_from_date} != '') && (${r_to_date} != ''))" ).append("\n"); 
		query.append("        AND VE.UPD_DT BETWEEN TO_DATE(@[hid_from_date],'YYYYMMDD') AND TO_DATE(@[hid_to_date],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ((${r_provider} != '') && (${r_to_date} != 'ALL'))" ).append("\n"); 
		query.append("		AND WO.WO_VNDR_SEQ = @[hid_provider]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY WO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,WO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT EDI.TRSP_SO_OFC_CTY_CD||EDI.TRSP_SO_SEQ AS TRS_WO_KEY" ).append("\n"); 
		query.append("      ,EDI.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,EDI.TRSP_SO_SEQ" ).append("\n"); 
		query.append("      ,EDI.VNDR_SEQ" ).append("\n"); 
		query.append("      ,MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(EDI.LOCL_CRE_DT,'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("      ,VE.WO_EV_GRD_CD" ).append("\n"); 
		query.append("      ,VE.SHPR_EV_GRD_CD" ).append("\n"); 
		query.append("      ,VE.EV_CTNT" ).append("\n"); 
		query.append("      ,TO_CHAR(VE.CRE_DT,'YYYYMMDD') CRE_DT_1" ).append("\n"); 
		query.append("      ,VE.CRE_USR_ID" ).append("\n"); 
		query.append("  FROM TRS_TRSP_VNDR_PERF_EV VE" ).append("\n"); 
		query.append("      ,MDM_VENDOR MV" ).append("\n"); 
		query.append("      ,TRS_TRSP_EDI_RAIL_ORD EDI          " ).append("\n"); 
		query.append("      ,(SELECT VNDR_S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("              ,VNDR_S.TRSP_SO_SEQ" ).append("\n"); 
		query.append("              ,MAX(EDI_S.BIL_ISS_KNT) BIL_ISS_KNT" ).append("\n"); 
		query.append("          FROM TRS_TRSP_EDI_RAIL_ORD       EDI_S" ).append("\n"); 
		query.append("              ,TRS_TRSP_RAIL_BIL_VNDR_SET  VNDR_S" ).append("\n"); 
		query.append("              ,TRS_TRSP_RAIL_BIL_ORD       ORD_S" ).append("\n"); 
		query.append("              ,TRS_TRSP_VNDR_PERF_EV       VE_S" ).append("\n"); 
		query.append("              ,TRS_TRSP_RAIL_INV_WRK       INV_S" ).append("\n"); 
		query.append("         WHERE EDI_S.TRSP_SO_OFC_CTY_CD    = VNDR_S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND EDI_S.TRSP_SO_SEQ           = VNDR_S.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND VNDR_S.TRSP_SO_OFC_CTY_CD   = ORD_S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND VNDR_S.TRSP_SO_SEQ          = ORD_S.TRSP_SO_SEQ    " ).append("\n"); 
		query.append("           AND VNDR_S.INV_NO               = INV_S.INV_NO" ).append("\n"); 
		query.append("           AND VNDR_S.INV_VNDR_SEQ         = INV_S.INV_VNDR_SEQ           " ).append("\n"); 
		query.append("           AND VNDR_S.TRSP_SO_OFC_CTY_CD   = VE_S.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("           AND VNDR_S.TRSP_SO_SEQ          = VE_S.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("           AND ORD_S.TRSP_SO_STS_CD       IN ('I','E')" ).append("\n"); 
		query.append("           AND INV_S.TRSP_INV_AUD_STS_CD   = 'IF'" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${r_wonumber} != '')" ).append("\n"); 
		query.append("               AND  1 = 2" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${r_period} == 'I')" ).append("\n"); 
		query.append("               #if ((${r_from_date} != '') && (${r_to_date} != ''))" ).append("\n"); 
		query.append("                   AND EDI_S.LOCL_CRE_DT BETWEEN TO_DATE(@[hid_from_date],'YYYYMMDD') AND TO_DATE(@[hid_to_date],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("           #elseif(${r_period} == 'E')" ).append("\n"); 
		query.append("               #if ((${r_from_date} != '') && (${r_to_date} != ''))" ).append("\n"); 
		query.append("                   AND VE_S.UPD_DT BETWEEN TO_DATE(@[hid_from_date],'YYYYMMDD') AND TO_DATE(@[hid_to_date],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if ((${r_provider} != '') && (${r_to_date} != 'ALL'))" ).append("\n"); 
		query.append("               AND VNDR_S.VNDR_SEQ = @[hid_provider]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("         GROUP BY VNDR_S.TRSP_SO_OFC_CTY_CD, VNDR_S.TRSP_SO_SEQ " ).append("\n"); 
		query.append("       ) X" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND EDI.VNDR_SEQ             = MV.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND EDI.TRSP_SO_OFC_CTY_CD   = VE.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND EDI.TRSP_SO_SEQ          = VE.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("   AND EDI.TRSP_SO_OFC_CTY_CD   = X.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND EDI.TRSP_SO_SEQ          = X.TRSP_SO_SEQ" ).append("\n"); 
		query.append("   AND EDI.BIL_ISS_KNT          = X.BIL_ISS_KNT" ).append("\n"); 
		query.append("   #if (${r_wonumber} != '')" ).append("\n"); 
		query.append("      AND  1 = 2" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append(" ORDER BY TRSP_WO_OFC_CTY_CD, TRSP_WO_SEQ" ).append("\n"); 

	}
}