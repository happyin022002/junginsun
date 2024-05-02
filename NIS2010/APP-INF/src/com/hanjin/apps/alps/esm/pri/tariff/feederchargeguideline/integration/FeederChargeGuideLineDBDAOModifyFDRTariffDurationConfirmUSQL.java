/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FeederChargeGuideLineDBDAOModifyFDRTariffDurationConfirmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.05
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.11.05 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FeederChargeGuideLineDBDAOModifyFDRTariffDurationConfirmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify FDR TariffDuration Confirm
	  * </pre>
	  */
	public FeederChargeGuideLineDBDAOModifyFDRTariffDurationConfirmUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration").append("\n"); 
		query.append("FileName : FeederChargeGuideLineDBDAOModifyFDRTariffDurationConfirmUSQL").append("\n"); 
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
		query.append("UPDATE PRI_TRF_FDR_DUR " ).append("\n"); 
		query.append("   SET EXP_DT     = TO_DATE(@[eff_dt], 'YYYY-MM-DD')-1" ).append("\n"); 
		query.append("     , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT     = SYSDATE" ).append("\n"); 
		query.append(" WHERE ( SVC_SCP_CD, FDR_TRF_NO, AMDT_SEQ, ORG_DEST_TP_CD ) IN      " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT MN.SVC_SCP_CD" ).append("\n"); 
		query.append("             , TRF.FDR_TRF_NO" ).append("\n"); 
		query.append("             , MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("             , MN.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("          FROM PRI_TRF_FDR_MN MN" ).append("\n"); 
		query.append("             , (SELECT MAX(MN.FDR_TRF_NO) FDR_TRF_NO" ).append("\n"); 
		query.append("                     , MN.SVC_SCP_CD" ).append("\n"); 
		query.append("                     , MN.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                  FROM PRI_TRF_FDR_HDR HDR" ).append("\n"); 
		query.append("                     , PRI_TRF_FDR_MN MN" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND MN.SVC_SCP_CD   = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND MN.ORG_DEST_TP_CD = @[org_dest_tp_cd] " ).append("\n"); 
		query.append("                   AND MN.FIC_PROP_STS_CD = 'C'" ).append("\n"); 
		query.append("                   AND MN.SVC_SCP_CD = HDR.SVC_SCP_CD" ).append("\n"); 
		query.append("                   AND MN.FDR_TRF_NO = HDR.FDR_TRF_NO     " ).append("\n"); 
		query.append("                   AND MN.ORG_DEST_TP_CD = HDR.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                   AND HDR.RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("              GROUP BY MN.SVC_SCP_CD, MN.ORG_DEST_TP_CD    " ).append("\n"); 
		query.append("               ) TRF" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND MN.FDR_TRF_NO = TRF.FDR_TRF_NO" ).append("\n"); 
		query.append("           AND MN.SVC_SCP_CD = TRF.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND MN.ORG_DEST_TP_CD = TRF.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("      GROUP BY MN.SVC_SCP_CD, TRF.FDR_TRF_NO, MN.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}