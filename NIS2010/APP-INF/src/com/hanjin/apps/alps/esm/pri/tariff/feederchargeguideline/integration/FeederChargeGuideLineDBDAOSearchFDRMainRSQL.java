/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : FeederChargeGuideLineDBDAOSearchFDRMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FeederChargeGuideLineDBDAOSearchFDRMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search FDR Main
	  * 2013.02.27 전윤주 [CHM-201323352] creation, confirm staff 이름이 보이도록 수정 
	  * </pre>
	  */
	public FeederChargeGuideLineDBDAOSearchFDRMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration").append("\n"); 
		query.append("FileName : FeederChargeGuideLineDBDAOSearchFDRMainRSQL").append("\n"); 
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
		query.append("WITH MAX_FDR AS (" ).append("\n"); 
		query.append("    SELECT HDR.FDR_TRF_NO" ).append("\n"); 
		query.append("         , MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("      FROM PRI_TRF_FDR_MN MN" ).append("\n"); 
		query.append("         , (    SELECT MAX(FDR_TRF_NO) FDR_TRF_NO" ).append("\n"); 
		query.append("                  FROM PRI_TRF_FDR_HDR" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD   = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("                   AND RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("           ) HDR" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND MN.FDR_TRF_NO = HDR.FDR_TRF_NO" ).append("\n"); 
		query.append("       AND MN.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("     GROUP BY HDR.FDR_TRF_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT MN.SVC_SCP_CD" ).append("\n"); 
		query.append("     , MN.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , MN.FDR_TRF_NO" ).append("\n"); 
		query.append("     , MN.AMDT_SEQ" ).append("\n"); 
		query.append("     , TO_CHAR(MN.CRE_DT,'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("     , TO_CHAR(MN.EFF_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(MN.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("     , TO_CHAR(MN.CFM_DT,'YYYYMMDD') CFM_DT" ).append("\n"); 
		query.append("     , MN.FIC_PROP_STS_CD" ).append("\n"); 
		query.append("	 , (SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD03045' " ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = MN.FIC_PROP_STS_CD) FIC_PROP_STS_NM" ).append("\n"); 
		query.append("     , MN.TRF_CURR_CD" ).append("\n"); 
		query.append("     , MN.LOCL_CURR_CD      " ).append("\n"); 
		query.append("     , DECODE((SELECT USR_NM FROM COM_USER WHERE USR_ID = MN.CFM_USR_ID) || ' / ' || MN.CFM_OFC_CD,' / ', ''" ).append("\n"); 
		query.append("             ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = MN.CFM_USR_ID) || ' / ' || MN.CFM_OFC_CD ) AS CFM_USR " ).append("\n"); 
		query.append("     , MN.CFM_OFC_CD" ).append("\n"); 
		query.append("     , MN.CFM_USR_ID" ).append("\n"); 
		query.append("     , DECODE((SELECT USR_NM FROM COM_USER WHERE USR_ID = MN.CRE_USR_ID) || ' / ' || MN.CRE_OFC_CD,' / ', ''" ).append("\n"); 
		query.append("             ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = MN.CRE_USR_ID) || ' / ' || MN.CRE_OFC_CD )AS CRE_USR" ).append("\n"); 
		query.append("     , MN.CRE_USR_ID" ).append("\n"); 
		query.append("     , MN.UPD_USR_ID" ).append("\n"); 
		query.append("     , MN.UPD_DT" ).append("\n"); 
		query.append("     , MN.PRC_IO_BND_CD" ).append("\n"); 
		query.append("     , (SELECT COUNT(*)" ).append("\n"); 
		query.append("          FROM TRS_FDR_DG_COST_TRF" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND COST_TRF_NO  = (SELECT FDR_COST_TRF_NO" ).append("\n"); 
		query.append("                                 FROM PRI_TRF_FDR_COST_VER_MAPG" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                  AND FDR_TRF_NO = SUB.FDR_TRF_NO" ).append("\n"); 
		query.append("                                  AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                                  AND ORG_DEST_TP_CD = @[org_dest_tp_cd] " ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) DG_COUNT" ).append("\n"); 
		query.append("	 , '' AMDT_EFF" ).append("\n"); 
		query.append("     , '' TOBE_AMDT_SEQ" ).append("\n"); 
		query.append("     , '' RHQ_CD" ).append("\n"); 
		query.append("     , '' MAX_COST_TRF_NO" ).append("\n"); 
		query.append("     , '' CHECK_COST_TRF_NO" ).append("\n"); 
		query.append("  FROM PRI_TRF_FDR_MN MN" ).append("\n"); 
		query.append("     , MAX_FDR SUB" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND MN.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND MN.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("   AND MN.AMDT_SEQ   = SUB.AMDT_SEQ" ).append("\n"); 
		query.append("   AND MN.FDR_TRF_NO = SUB.FDR_TRF_NO" ).append("\n"); 

	}
}