/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGTOfficeInfoAgreementDBDAOAgentInfoForAgreementbyCountryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTOfficeInfoAgreementDBDAOAgentInfoForAgreementbyCountryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * (ESM_AGT_001) Vendor Info
	  * </pre>
	  */
	public AGTOfficeInfoAgreementDBDAOAgentInfoForAgreementbyCountryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_agn_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_agmt_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_agmt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.integration").append("\n"); 
		query.append("FileName : AGTOfficeInfoAgreementDBDAOAgentInfoForAgreementbyCountryRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("       LST.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("       LPAD(LST.AGN_AGMT_SEQ,6,'0') AGN_AGMT_SEQ," ).append("\n"); 
		query.append("       LST.VNDR_CNT_CD," ).append("\n"); 
		query.append("       LST.VNDR_SEQ," ).append("\n"); 
		query.append("       LST.AGMT_OFC_CD," ).append("\n"); 
		query.append("       LST.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("       LST.DELT_FLG," ).append("\n"); 
		query.append("       EFFE_FLG" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("           SELECT" ).append("\n"); 
		query.append("                  AAM.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("                  AAM.AGN_AGMT_SEQ," ).append("\n"); 
		query.append("                  OFC.AGMT_OFC_CD," ).append("\n"); 
		query.append("                  VDR.VNDR_CNT_CD," ).append("\n"); 
		query.append("                  VDR.VNDR_SEQ," ).append("\n"); 
		query.append("                  VDR.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("                  AAM.DELT_FLG," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                      SELECT" ).append("\n"); 
		query.append("                             1" ).append("\n"); 
		query.append("                        FROM AGT_AGN_AGMT AGM" ).append("\n"); 
		query.append("                       WHERE AGM.AGMT_OFC_CD     = AAM.AGMT_OFC_CD" ).append("\n"); 
		query.append("                         AND AGM.AGMT_OFC_CTY_CD = AAM.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                         AND AGM.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("                         AND AAM.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("                         AND TO_CHAR (SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("                     BETWEEN AGM.FM_EFF_DT" ).append("\n"); 
		query.append("                         AND AGM.TO_EFF_DT" ).append("\n"); 
		query.append("                         AND ROWNUM = 1" ).append("\n"); 
		query.append("                )                                AS EFFE_FLG," ).append("\n"); 
		query.append("                  @[s_agmt_sts]                  AS DISP_FLG                                 --:DISP_FLG" ).append("\n"); 
		query.append("             FROM AGT_AGN_AGMT_MST AAM," ).append("\n"); 
		query.append("                  MDM_VENDOR       VDR," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                      SELECT" ).append("\n"); 
		query.append("                             CHN.VNDR_CNT_CD                           AS VNDR_CNT_CD," ).append("\n"); 
		query.append("                             LTRIM (TO_CHAR (CHN.VNDR_SEQ, '000000'))  AS VNDR_SEQ," ).append("\n"); 
		query.append("                             SUBSTR (CHN.OFC_CD, 1, 3)||CHN.CHN_AGN_CD AS AGMT_OFC_CD" ).append("\n"); 
		query.append("                        FROM BKG_CHN_AGN                               CHN" ).append("\n"); 
		query.append("                       WHERE NVL (CHN.DELT_FLG, 'N')                 = 'N'" ).append("\n"); 
		query.append("                         AND CHN.VNDR_CNT_CD                         = @[vndr_cnt_cd]         --:VNDR_CNT_CD" ).append("\n"); 
		query.append("                   UNION ALL" ).append("\n"); 
		query.append("                      SELECT" ).append("\n"); 
		query.append("                             ORG.VNDR_CNT_CD                           AS VNDR_CNT_CD," ).append("\n"); 
		query.append("                             LTRIM (TO_CHAR (ORG.VNDR_SEQ, '000000'))  AS VNDR_SEQ," ).append("\n"); 
		query.append("                             ORG.OFC_CD                                AS AGMT_OFC_CD" ).append("\n"); 
		query.append("                        FROM MDM_ORGANIZATION                          ORG" ).append("\n"); 
		query.append("                       WHERE NVL (ORG.DELT_FLG, 'N')                 = 'N'" ).append("\n"); 
		query.append("                         AND ORG.VNDR_CNT_CD                         = @[vndr_cnt_cd]         --:VNDR_CNT_CD" ).append("\n"); 
		query.append("                ) OFC" ).append("\n"); 
		query.append("            WHERE AAM.AGMT_OFC_CD(+)      = OFC.AGMT_OFC_CD" ).append("\n"); 
		query.append("              AND AAM.VNDR_CNT_CD(+)      = OFC.VNDR_CNT_CD" ).append("\n"); 
		query.append("              AND AAM.VNDR_SEQ   (+)      = OFC.VNDR_SEQ" ).append("\n"); 
		query.append("              AND VDR.VNDR_CNT_CD(+)      = OFC.VNDR_CNT_CD" ).append("\n"); 
		query.append("              AND VDR.VNDR_SEQ   (+)      = OFC.VNDR_SEQ" ).append("\n"); 
		query.append("              AND NVL (VDR.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("     ) LST" ).append("\n"); 
		query.append("WHERE 1" ).append("\n"); 
		query.append("    IN" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("  CASE" ).append("\n"); 
		query.append("  WHEN NVL (DISP_FLG, 0) = 0     -- 0 : ALL" ).append("\n"); 
		query.append("  THEN 1" ).append("\n"); 
		query.append("  WHEN NVL (DISP_FLG, 0) = 1     -- 1 : Currently Effective" ).append("\n"); 
		query.append("   AND NVL (EFFE_FLG, 0) = 1" ).append("\n"); 
		query.append("  THEN 1" ).append("\n"); 
		query.append("  WHEN NVL (DISP_FLG, 0) = 2     -- 2 : Expired" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND EFFE_FLG IS NULL" ).append("\n"); 
		query.append("  THEN 1" ).append("\n"); 
		query.append("  WHEN NVL (DISP_FLG, 0) = 3     -- 3 : Deleted" ).append("\n"); 
		query.append("   AND DELT_FLG = 'Y'" ).append("\n"); 
		query.append("  THEN 1    " ).append("\n"); 
		query.append("  WHEN NVL (DISP_FLG, 0) = 4     -- 4 : No Aggrement" ).append("\n"); 
		query.append("   AND DELT_FLG IS NULL" ).append("\n"); 
		query.append("  THEN 1" ).append("\n"); 
		query.append("  ELSE 0" ).append("\n"); 
		query.append("   END" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("#if (${s_agmt_ofc_cty_cd} != '') " ).append("\n"); 
		query.append("AND LST.AGMT_OFC_CTY_CD = @[s_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_agn_agmt_seq} != '') " ).append("\n"); 
		query.append("AND LST.AGN_AGMT_SEQ = @[s_agn_agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_agmt_ofc_cd} != '') " ).append("\n"); 
		query.append("AND LST.AGMT_OFC_CD = @[s_agmt_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY DECODE(AGN_AGMT_SEQ, '', 0, AGN_AGMT_SEQ) DESC" ).append("\n"); 

	}
}