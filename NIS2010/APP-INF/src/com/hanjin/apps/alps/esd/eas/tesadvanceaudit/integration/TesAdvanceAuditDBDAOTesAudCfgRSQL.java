/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOTesAudCfgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.24
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.07.24 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOTesAudCfgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TesAudCfg
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOTesAudCfgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_lgs_cost_subj_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_aud_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_expn_aud_tgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cost_calc_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOTesAudCfgRSQL").append("\n"); 
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
		query.append("SELECT ETAAC.AUD_OFC_CD" ).append("\n"); 
		query.append("     , TLC.LGS_COST_SUBJ_CD" ).append("\n"); 
		query.append("     , ETAAC.LGS_COST_CD" ).append("\n"); 
		query.append("     , TLC.LGS_COST_FULL_NM" ).append("\n"); 
		query.append("     , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00748' AND INTG_CD_VAL_CTNT = TTSC.CNTR_STY_CD) AS CNTR_STY_CD" ).append("\n"); 
		query.append("     , (SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01282' AND INTG_CD_VAL_CTNT = TTSC.COST_CALC_MZD_CD) AS COST_CALC_MZD_CD" ).append("\n"); 
		query.append("     , ETAAC.EXPN_AUD_TGT_FLG" ).append("\n"); 
		query.append("     , ETAAC.EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("     , DECODE(ETAAC.TS_FLG, 'Y', 'T/S Only', 'N', 'Local', 'All') AS TS_FLG" ).append("\n"); 
		query.append("     , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03424' AND INTG_CD_VAL_CTNT = ETAAC.SPCL_CGO_TP_CALC_CD) AS SPCL_CGO_TP_CALC_CD" ).append("\n"); 
		query.append("     , DECODE(ETAAC.TPSZ_GRP_FLG, 'Y', 'Yes', 'N', 'No', '') AS TPSZ_GRP_FLG" ).append("\n"); 
		query.append("     , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03423' AND INTG_CD_VAL_CTNT = ETAAC.ACT_VVD_CALC_CD) AS ACT_VVD_CALC_CD" ).append("\n"); 
		query.append("     , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03421' AND INTG_CD_VAL_CTNT = ETAAC.STO_PRD_CD) AS STO_PRD_CD" ).append("\n"); 
		query.append("     , ETAAC.AUD_RMK" ).append("\n"); 
		query.append("     , ETAAC.UPD_USR_ID" ).append("\n"); 
		query.append("  FROM EAS_TML_AUTO_AUD_CRTE ETAAC" ).append("\n"); 
		query.append("     , TES_TML_SO_COST TTSC" ).append("\n"); 
		query.append("     , TES_LGS_COST TLC" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND ETAAC.LGS_COST_CD      = TTSC.LGS_COST_CD " ).append("\n"); 
		query.append("   AND ETAAC.LGS_COST_CD      = TLC.LGS_COST_CD" ).append("\n"); 
		query.append("   AND TTSC.EAS_AUD_FLG       = 'Y'" ).append("\n"); 
		query.append("#if (${s_aud_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND ETAAC.AUD_OFC_CD       = @[s_aud_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_lgs_cost_subj_cd} != '')" ).append("\n"); 
		query.append("   AND TLC.LGS_COST_SUBJ_CD   = @[s_lgs_cost_subj_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_cost_calc_mzd_cd} != '')" ).append("\n"); 
		query.append("   AND TTSC.COST_CALC_MZD_CD  = @[s_cost_calc_mzd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_expn_aud_tgt_flg} != '')" ).append("\n"); 
		query.append("   AND ETAAC.EXPN_AUD_TGT_FLG = @[s_expn_aud_tgt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY AUD_OFC_CD, LGS_COST_SUBJ_CD, LGS_COST_CD" ).append("\n"); 

	}
}