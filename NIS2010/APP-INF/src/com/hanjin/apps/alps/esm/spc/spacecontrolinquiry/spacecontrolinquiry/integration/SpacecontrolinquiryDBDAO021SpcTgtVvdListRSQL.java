/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAO021SpcTgtVvdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.16
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAO021SpcTgtVvdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 한국지점에서 리포트에서 조회할 VVD List 조회
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAO021SpcTgtVvdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAO021SpcTgtVvdListRSQL").append("\n"); 
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
		query.append("SELECT TRD_CD," ).append("\n"); 
		query.append("       RLANE_CD," ).append("\n"); 
		query.append("       VVD," ).append("\n"); 
		query.append("       (SELECT MAX(BSE_DT)" ).append("\n"); 
		query.append("          FROM SPC_TGT_VVD" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("#if(${trade} != '')" ).append("\n"); 
		query.append("           AND TRD_CD = @[trade]" ).append("\n"); 
		query.append("#end                       ) AS BSE_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT  TRD_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("          FROM SPC_TGT_VVD" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("#if(${trade} != '')" ).append("\n"); 
		query.append("           AND TRD_CD = @[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT DISTINCT" ).append("\n"); 
		query.append("                 B.TRD_CD    ," ).append("\n"); 
		query.append("                 A.RLANE_CD  ," ).append("\n"); 
		query.append("                 NULL AS VVD " ).append("\n"); 
		query.append("            FROM MDM_REV_LANE     A," ).append("\n"); 
		query.append("                 MDM_DTL_REV_LANE B," ).append("\n"); 
		query.append("                 MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("                 , (SELECT DISTINCT P.VSL_SLAN_CD, P.SKD_DIR_CD" ).append("\n"); 
		query.append("                      FROM VSK_PF_SKD S," ).append("\n"); 
		query.append("                           VSK_PF_SKD_DTL P," ).append("\n"); 
		query.append("                           VSK_VSL_SKD V" ).append("\n"); 
		query.append("                     WHERE S.SLAN_STND_FLG = 'Y'" ).append("\n"); 
		query.append("                       AND S.VSL_SLAN_CD = P.VSL_SLAN_CD" ).append("\n"); 
		query.append("                       AND S.PF_SVC_TP_CD = P.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                       AND P.PORT_CD = 'KRPUS'" ).append("\n"); 
		query.append("                       AND TURN_PORT_IND_CD <> 'F'" ).append("\n"); 
		query.append("                       AND V.VSL_SLAN_CD = S.VSL_SLAN_CD" ).append("\n"); 
		query.append("                       AND V.PF_SKD_TP_CD = S.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                       AND V.SKD_STS_CD <> 'CLO') P" ).append("\n"); 
		query.append("           WHERE A.RLANE_CD     = B.RLANE_CD" ).append("\n"); 
		query.append("             AND A.VSL_TP_CD    = 'C'" ).append("\n"); 
		query.append("             AND A.REP_TRD_CD   = B.TRD_CD" ).append("\n"); 
		query.append("             AND B.DELT_FLG   IN ('N', NULL)" ).append("\n"); 
		query.append("             AND B.TRD_CD     <> 'COM'" ).append("\n"); 
		query.append("             AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("             AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("             AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("             AND A.VSL_SLAN_CD = P.VSL_SLAN_CD" ).append("\n"); 
		query.append("             AND B.VSL_SLAN_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND B.FM_CONTI_CD = 'A'" ).append("\n"); 
		query.append("             AND B.TO_CONTI_CD IN ('E', 'M')" ).append("\n"); 
		query.append("             AND EXISTS (SELECT 'A' " ).append("\n"); 
		query.append("                           FROM MAS_MON_VVD M" ).append("\n"); 
		query.append("                          WHERE SUBSTR(M.SLS_YRMON, 1, 4) = TO_CHAR(SYSDATE, 'YYYY')" ).append("\n"); 
		query.append("                            AND CEIL(TO_NUMBER(SUBSTR(M.SLS_YRMON, 5, 2)) / 3)||'Q' = CEIL(TO_NUMBER(TO_CHAR(SYSDATE, 'MM')) / 3)||'Q'" ).append("\n"); 
		query.append("                            AND M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND M.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("                            AND M.RLANE_CD = B.RLANE_CD)" ).append("\n"); 
		query.append("             AND NOT EXISTS (SELECT 'A'" ).append("\n"); 
		query.append("                               FROM SPC_TGT_VVD" ).append("\n"); 
		query.append("                              WHERE TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("                                AND RLANE_CD = B.RLANE_CD)" ).append("\n"); 
		query.append("#if(${trade} != '')" ).append("\n"); 
		query.append("             AND B.TRD_CD = @[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    )       " ).append("\n"); 
		query.append("ORDER BY TRD_CD," ).append("\n"); 
		query.append("         RLANE_CD" ).append("\n"); 

	}
}
