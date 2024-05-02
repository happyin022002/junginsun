/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchCneeAccuracyBLListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchCneeAccuracyBLListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Doc Performance Report
	  * Documentation 실적 산출 기능
	  * Cnee Accuracy B/L 조회
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchCneeAccuracyBLListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_gso_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchCneeAccuracyBLListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    A.BKG_NO," ).append("\n"); 
		query.append("    A.BL_NO," ).append("\n"); 
		query.append("    A.CLASS_TYPE," ).append("\n"); 
		query.append("    A.BKG_DT," ).append("\n"); 
		query.append("    A.BKG_STF," ).append("\n"); 
		query.append("    A.BKG_OFC_CD," ).append("\n"); 
		query.append("    A.OB_SLS_OFC_CD," ).append("\n"); 
		query.append("	A.POR_CD," ).append("\n"); 
		query.append("    A.POL_CD," ).append("\n"); 
		query.append("    A.POD_CD," ).append("\n"); 
		query.append("    A.SLAN_CD," ).append("\n"); 
		query.append("    A.BKG_STS," ).append("\n"); 
		query.append("    A.VVD_CD," ).append("\n"); 
		query.append("    A.SKD_VOY_NO," ).append("\n"); 
		query.append("    A.VSL_CD," ).append("\n"); 
		query.append("    A.SKD_DIR_CD," ).append("\n"); 
		query.append("	A.POD_ETA_DT DOCP_DT," ).append("\n"); 
		query.append("    A.BKG_DOC_DT PORT_CLZ_DT," ).append("\n"); 
		query.append("	'' DPCS_SMRY_RMK," ).append("\n"); 
		query.append("    A.VAL_DT BATCH_DT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append("      ,BK.BL_NO" ).append("\n"); 
		query.append("      ,'10' CLASS_TYPE" ).append("\n"); 
		query.append("      ,BK.BKG_CRE_DT BKG_DT" ).append("\n"); 
		query.append("      ,BK.DOC_USR_ID BKG_STF" ).append("\n"); 
		query.append("      ,BK.BKG_OFC_CD" ).append("\n"); 
		query.append("      ,BK.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("	  ,BK.POR_CD" ).append("\n"); 
		query.append("      ,BK.POL_CD" ).append("\n"); 
		query.append("      ,BK.POD_CD" ).append("\n"); 
		query.append("      ,BK.SLAN_CD" ).append("\n"); 
		query.append("      ,	CASE WHEN BC.MTCH_FLG = 'Y' AND BC.VAL_CD IS NULL THEN 'Auto'" ).append("\n"); 
		query.append("			 ELSE (SELECT CD.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CD WHERE CD.INTG_CD_ID = 'CD01655' AND CD.INTG_CD_VAL_CTNT = BC.VAL_CD) " ).append("\n"); 
		query.append("		END BKG_STS			" ).append("\n"); 
		query.append("      ,BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append("      ,BK.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,BK.VSL_CD" ).append("\n"); 
		query.append("      ,BK.SKD_DIR_CD" ).append("\n"); 
		query.append("   	  ,TO_CHAR(SKD.VPS_ETA_DT,'YYYY-MM-DD') POD_ETA_DT" ).append("\n"); 
		query.append("      ,'10' DOC_KND_STS_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(BL.BDR_DT,'YYYYMMDD') BKG_DOC_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(BC.VAL_DT,'YYYY-MM-DD HH24:MI:SS') VAL_DT" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BK" ).append("\n"); 
		query.append("     , BKG_VVD VVD" ).append("\n"); 
		query.append("     , VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("     , BKG_CUSTOMER BC" ).append("\n"); 
		query.append("	 , BKG_BL_DOC BL" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("   AND BK.POD_CD = VVD.POD_CD" ).append("\n"); 
		query.append("   AND BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("   AND VVD.VSL_PRE_PST_CD IN ('T','U')" ).append("\n"); 
		query.append("   AND (VVD.VSL_PRE_PST_CD, VVD.VSL_SEQ) = (SELECT /*+ index_desc (v2 xpkbkg_vvd) */ " ).append("\n"); 
		query.append("                                                    V2.VSL_PRE_PST_CD, V2.VSL_SEQ" ).append("\n"); 
		query.append("                                              FROM BKG_VVD V2" ).append("\n"); 
		query.append("                                             WHERE V2.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                               AND V2.VSL_PRE_PST_CD IN ('T','U')" ).append("\n"); 
		query.append("                                               AND ROWNUM = 1)" ).append("\n"); 
		query.append("   AND VVD.VSL_CD     = SKD.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VVD.POD_CD     = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND VVD.POD_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("   AND BK.BKG_NO      = BC.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_STS_CD  <> 'X'" ).append("\n"); 
		query.append("   AND BK.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("   AND BC.BKG_CUST_TP_CD = DECODE(BK.CUST_TO_ORD_FLG,'Y','N','C')" ).append("\n"); 
		query.append("   AND BC.VAL_DT IS NOT NULL" ).append("\n"); 
		query.append("#if (${fr_dt} != '')                                             " ).append("\n"); 
		query.append("   AND SKD.VPS_ETA_DT >= TO_DATE(@[fr_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_dt} != '')" ).append("\n"); 
		query.append("   AND SKD.VPS_ETA_DT <= TO_DATE(@[to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("	AND    BK.VSL_CD     = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("	AND    BK.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("	AND    BK.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("	AND    BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("	AND    BK.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ob_sls_ofc_cd} != '') " ).append("\n"); 
		query.append("	AND	   BK.OB_SLS_OFC_CD = @[ob_sls_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("	AND	   BK.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end					" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("	AND	   BK.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end					" ).append("\n"); 
		query.append("#if (${sel_bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("	and    BK.BKG_OFC_CD = @[sel_bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_gso_cd} != '') " ).append("\n"); 
		query.append("AND    EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("				FROM BKG_DOC_PERF_OFC BDPO " ).append("\n"); 
		query.append("				WHERE DECODE(SUBSTR(BDPO.POR_CD,1,2),'JP',BK.BKG_OFC_CD,BDPO.BKG_OFC_CD) = BK.BKG_OFC_CD  " ).append("\n"); 
		query.append("				AND DECODE(SUBSTR(BDPO.POR_CD,1,2),'JP',BDPO.POR_CD,BK.POR_CD) = BK.POR_CD " ).append("\n"); 
		query.append("        		AND BDPO.GSO_OFC_CD <> 'SHADKJ' " ).append("\n"); 
		query.append("        		AND BDPO.BKG_OFC_CD <> 'SHADKJ'" ).append("\n"); 
		query.append("				AND BDPO.GSO_OFC_CD = @[sel_gso_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}