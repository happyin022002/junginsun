/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RuLabelManagementDBDAOsearchRuLabelInquiyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.27
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.07.27 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RuLabelManagementDBDAOsearchRuLabelInquiyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container별 RU Label의 정보를 조회한다.
	  * </pre>
	  */
	public RuLabelManagementDBDAOsearchRuLabelInquiyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration").append("\n"); 
		query.append("FileName : RuLabelManagementDBDAOsearchRuLabelInquiyRSQL").append("\n"); 
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
		query.append("SELECT RUC.RSTR_USG_DP_SEQ" ).append("\n"); 
		query.append("     , RUC.RU_LABEL_TYPE_DESC" ).append("\n"); 
		query.append("     , MCR.RSTR_USG_LBL_NM" ).append("\n"); 
		query.append("     , (SELECT MRU.RSTR_USG_LBL_DESC " ).append("\n"); 
		query.append("          FROM MST_RSTR_USG_CD MRU" ).append("\n"); 
		query.append("         WHERE 1=1 " ).append("\n"); 
		query.append("           AND MRU.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND MRU.RSTR_USG_TP_CD  = MCR.RSTR_USG_TP_CD" ).append("\n"); 
		query.append("           AND MRU.RSTR_USG_LBL_NM = MCR.RSTR_USG_LBL_NM" ).append("\n"); 
		query.append("           AND ROWNUM              = 1) AS RSTR_USG_LBL_DESC" ).append("\n"); 
		query.append("     , (SELECT MRU.USR_DEF_RMK " ).append("\n"); 
		query.append("          FROM MST_RSTR_USG_CD MRU" ).append("\n"); 
		query.append("         WHERE 1=1 " ).append("\n"); 
		query.append("           AND MRU.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND MRU.RSTR_USG_TP_CD  = MCR.RSTR_USG_TP_CD" ).append("\n"); 
		query.append("           AND MRU.RSTR_USG_LBL_NM = MCR.RSTR_USG_LBL_NM" ).append("\n"); 
		query.append("           AND ROWNUM              = 1) AS USR_DEF_RMK" ).append("\n"); 
		query.append("     , MCR.UPD_USR_ID, TO_CHAR(MCR.UPD_DT, 'YYYY-MM-DD HH24:MI:SS') AS UPD_DT " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       ( " ).append("\n"); 
		query.append("         SELECT INTG_CD_VAL_DP_SEQ AS RSTR_USG_DP_SEQ, INTG_CD_VAL_CTNT AS RSTR_USG_TP_CD, INTG_CD_VAL_DP_DESC AS RU_LABEL_TYPE_DESC" ).append("\n"); 
		query.append("           FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("            AND INTG_CD_ID = 'CD20097'" ).append("\n"); 
		query.append("          ORDER BY INTG_CD_VAL_DP_SEQ " ).append("\n"); 
		query.append("        ) RUC," ).append("\n"); 
		query.append("       ( " ).append("\n"); 
		query.append("         SELECT SMCR.CNTR_NO, SMCR.RSTR_USG_TP_CD, SSMCR.RSTR_USG_LBL_NM, SMCR.UPD_USR_ID, SMCR.UPD_DT" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                 SELECT SMCR.CNTR_NO, SMCR.RSTR_USG_TP_CD, SMCR.RSTR_USG_LBL_NM, " ).append("\n"); 
		query.append("                        SSMCR.MAX_HIS_SEQ, SMCR.RSTR_USG_UPD_TP_CD, SMCR.UPD_USR_ID, SMCR.UPD_DT" ).append("\n"); 
		query.append("                   FROM (" ).append("\n"); 
		query.append("                          SELECT CNTR_NO, RSTR_USG_TP_CD, MAX(RSTR_USG_HIS_SEQ) AS MAX_HIS_SEQ" ).append("\n"); 
		query.append("                            FROM MST_CNTR_RSTR_USG_HIS" ).append("\n"); 
		query.append("                           WHERE 1=1" ).append("\n"); 
		query.append("                             AND CNTR_NO = @[s_cntr_no]" ).append("\n"); 
		query.append("                           GROUP BY CNTR_NO, RSTR_USG_TP_CD" ).append("\n"); 
		query.append("                         ) SSMCR, MST_CNTR_RSTR_USG_HIS SMCR " ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                      AND SSMCR.CNTR_NO = SMCR.CNTR_NO" ).append("\n"); 
		query.append("                      AND SSMCR.MAX_HIS_SEQ = SMCR.RSTR_USG_HIS_SEQ" ).append("\n"); 
		query.append("                  ) SMCR, MST_CNTR_RSTR_USG_HIS SSMCR " ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND SMCR.CNTR_NO     = SSMCR.CNTR_NO" ).append("\n"); 
		query.append("               AND SMCR.MAX_HIS_SEQ = SSMCR.RSTR_USG_HIS_SEQ" ).append("\n"); 
		query.append("               AND SMCR.RSTR_USG_UPD_TP_CD != 'D'" ).append("\n"); 
		query.append("         ) MCR" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("        AND RUC.RSTR_USG_TP_CD = MCR.RSTR_USG_TP_CD (+)" ).append("\n"); 

	}
}