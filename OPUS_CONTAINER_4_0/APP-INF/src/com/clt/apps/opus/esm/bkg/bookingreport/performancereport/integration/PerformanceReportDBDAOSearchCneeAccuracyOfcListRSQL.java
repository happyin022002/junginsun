/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchCneeAccuracyOfcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchCneeAccuracyOfcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Doc Performance Report-ESM_BKG_0214
	  * Documentation 실적 산출 기능
	  * Cnee Accuracy Office 조회
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchCneeAccuracyOfcListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gso",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchCneeAccuracyOfcListRSQL").append("\n"); 
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
		query.append("SELECT BK.RGN_OFC_CD REGION" ).append("\n"); 
		query.append("     , BK.GSO_OFC_CD GSO" ).append("\n"); 
		query.append("     , BK.BKG_OFC_CD BKG_OFC_CD" ).append("\n"); 
		query.append("     , TOTAL_BL CNT" ).append("\n"); 
		query.append("--     , BK.SUB_GRP_CTNT BDO_OFC1" ).append("\n"); 
		query.append("     , NVL(WRONG_BL,0) || '/' || NVL(VALIDATE_BL,0) OFC_CNT" ).append("\n"); 
		query.append("     , DECODE(VALIDATE_BL, 0, '0.00%', " ).append("\n"); 
		query.append("            TRIM(TO_CHAR(ROUND(WRONG_BL / VALIDATE_BL * 100, 2), '99990.99')) || '%') RATIO" ).append("\n"); 
		query.append("     , '' FR_DT" ).append("\n"); 
		query.append("     , '' TO_DT" ).append("\n"); 
		query.append("     , '' POL_CD" ).append("\n"); 
		query.append("     , '' SLAN_CD" ).append("\n"); 
		query.append("     , '' VVD_CD" ).append("\n"); 
		query.append("     , '' BKG_NO" ).append("\n"); 
		query.append("     , '' BL_NO" ).append("\n"); 
		query.append("     , '' OB_SLS_OFC_CD" ).append("\n"); 
		query.append("	 , '' CLASS_TYPE" ).append("\n"); 
		query.append("	 , '' BKG_NO" ).append("\n"); 
		query.append("     , '' BL_NO" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("        (SELECT " ).append("\n"); 
		query.append("               OFC_V.REGION AS RGN_OFC_CD" ).append("\n"); 
		query.append("             , OFC_V.GSO AS GSO_OFC_CD" ).append("\n"); 
		query.append("             , BK.BKG_OFC_CD" ).append("\n"); 
		query.append("--             , BD.SUB_GRP_CTNT" ).append("\n"); 
		query.append("             , COUNT(1) TOTAL_BL " ).append("\n"); 
		query.append("             , SUM(CASE WHEN BC.VAL_DT IS NULL THEN 0 ELSE 1 END) VALIDATE_BL" ).append("\n"); 
		query.append("             , SUM(CASE WHEN BC.VAL_DT IS NULL THEN 0 ELSE DECODE(NVL(BC.VAL_CD, 'X'), 'W', 1, 0) END) WRONG_BL" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("             , BKG_VVD VVD" ).append("\n"); 
		query.append("             , VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("             , BKG_CUSTOMER BC" ).append("\n"); 
		query.append("--             , BKG_DOC_PERF_OFC BD" ).append("\n"); 
		query.append("             , BKG_OFC_LVL_V OFC_V" ).append("\n"); 
		query.append("         WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("           AND BK.POD_CD = VVD.POD_CD" ).append("\n"); 
		query.append("           AND VVD.VSL_PRE_PST_CD IN ('T','U')" ).append("\n"); 
		query.append("           AND (VVD.VSL_PRE_PST_CD, VVD.VSL_SEQ) = (SELECT /*+ index_desc (v2 xpkbkg_vvd) */ " ).append("\n"); 
		query.append("                                                            V2.VSL_PRE_PST_CD, V2.VSL_SEQ" ).append("\n"); 
		query.append("                                                      FROM BKG_VVD V2" ).append("\n"); 
		query.append("                                                     WHERE V2.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                                       AND V2.VSL_PRE_PST_CD IN ('T','U')" ).append("\n"); 
		query.append("                                                       AND ROWNUM = 1)" ).append("\n"); 
		query.append("           AND VVD.VSL_CD     = SKD.VSL_CD" ).append("\n"); 
		query.append("           AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND VVD.POD_CD     = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND VVD.POD_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("           AND BK.BKG_NO      = BC.BKG_NO" ).append("\n"); 
		query.append("           AND BC.VAL_DT IS NOT NULL" ).append("\n"); 
		query.append("           AND BK.BKG_STS_CD  <> 'X'" ).append("\n"); 
		query.append("           AND BK.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("           AND BC.BKG_CUST_TP_CD = DECODE(BK.CUST_TO_ORD_FLG,'Y','N','C')" ).append("\n"); 
		query.append("                                             " ).append("\n"); 
		query.append("#if (${fr_dt} != '')                     " ).append("\n"); 
		query.append("           AND SKD.VPS_ETA_DT >= TO_DATE(@[fr_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_dt} != '')" ).append("\n"); 
		query.append("           AND SKD.VPS_ETA_DT <= TO_DATE(@[to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("		AND	   BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("		AND	   BK.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("		AND    BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ob_sls_ofc_cd} != '') " ).append("\n"); 
		query.append("		AND    BK.OB_SLS_OFC_CD = @[ob_sls_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("		AND    BK.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("		AND    BK.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end                " ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("		AND   BK.VSL_CD     = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("		AND   BK.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("		AND   BK.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND    OFC_V.OFC_CD(+) = BK.BKG_OFC_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("#if (${gso} != '') " ).append("\n"); 
		query.append("   AND OFC_V.GSO = @[gso]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${region} != '') " ).append("\n"); 
		query.append("   AND OFC_V.REGION= @[region]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        GROUP BY OFC_V.REGION" ).append("\n"); 
		query.append("             , OFC_V.GSO" ).append("\n"); 
		query.append("             , BK.BKG_OFC_CD" ).append("\n"); 
		query.append("--             , BD.SUB_GRP_CTNT" ).append("\n"); 
		query.append(") BK" ).append("\n"); 

	}
}