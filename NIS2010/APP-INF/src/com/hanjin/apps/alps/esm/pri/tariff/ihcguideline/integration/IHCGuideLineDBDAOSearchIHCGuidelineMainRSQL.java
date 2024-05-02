/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IHCGuideLineDBDAOSearchIHCGuidelineMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.31
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IHCGuideLineDBDAOSearchIHCGuidelineMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * retrieve IHC Guideline main
	  * 2013.02.04 전윤주 [CHM-201322884] confirm staff-team, Creation staff-team 보이도록 변경
	  * 2013.02.27 전윤주 [CHM-201323352] creation, confirm staff 이름이 보이도록 수정 
	  * 2013.04.24 전윤주 [CHM-201324375] Amend type code 추가
	  * 2013.07.30 전윤주 [CHM-201326002] Overweight, DG Service flag가 'Y' 인 경우에만 버튼 색을 파란색으로 표시
	  * </pre>
	  */
	public IHCGuideLineDBDAOSearchIHCGuidelineMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_scp_bnd_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOSearchIHCGuidelineMainRSQL").append("\n"); 
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
		query.append("WITH MAX_IHC AS (" ).append("\n"); 
		query.append("    SELECT HDR.IHC_TRF_NO" ).append("\n"); 
		query.append("         , HDR.COST_CNT_CD" ).append("\n"); 
		query.append("         , HDR.RHQ_CD " ).append("\n"); 
		query.append("         , MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("      FROM PRI_TRF_IHC_MN MN" ).append("\n"); 
		query.append("         , (    SELECT MAX(IHC_TRF_NO) IHC_TRF_NO" ).append("\n"); 
		query.append("                     , COST_CNT_CD" ).append("\n"); 
		query.append("                     , RHQ_CD" ).append("\n"); 
		query.append("                  FROM PRI_TRF_IHC_HDR" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD   = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND COST_CNT_CD  = @[cost_cnt_cd]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("                   GROUP BY COST_CNT_CD, RHQ_CD" ).append("\n"); 
		query.append("           ) HDR" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND MN.IHC_TRF_NO = HDR.IHC_TRF_NO" ).append("\n"); 
		query.append("  GROUP BY HDR.IHC_TRF_NO, HDR.COST_CNT_CD, HDR.RHQ_CD " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT MN.IHC_TRF_NO" ).append("\n"); 
		query.append("     , MN.AMDT_SEQ" ).append("\n"); 
		query.append("     , TO_CHAR(MN.CRE_DT,'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("     , TO_CHAR(MN.EFF_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(MN.CFM_DT,'YYYYMMDD') CFM_DT" ).append("\n"); 
		query.append("     , TO_CHAR(MN.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("     , MN.CRE_USR_ID" ).append("\n"); 
		query.append("     , MN.CRE_OFC_CD" ).append("\n"); 
		query.append("     , DECODE((SELECT USR_NM FROM COM_USER WHERE USR_ID = MN.CRE_USR_ID) || ' / ' || MN.CRE_OFC_CD,' / ', ''" ).append("\n"); 
		query.append("             ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = MN.CRE_USR_ID) || ' / ' || MN.CRE_OFC_CD )AS CRE_USR" ).append("\n"); 
		query.append("     , MN.FIC_PROP_STS_CD" ).append("\n"); 
		query.append("	 , (SELECT CASE WHEN" ).append("\n"); 
		query.append("               MN.SVC_SCP_CD IN ('TAW', 'TAE', 'ASW', 'ASE') AND MN.FIC_PROP_STS_CD = 'C' THEN 'Published'" ).append("\n"); 
		query.append("               ELSE INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD03045' " ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = MN.FIC_PROP_STS_CD) FIC_PROP_STS_NM" ).append("\n"); 
		query.append("     , MN.SVC_SCP_CD" ).append("\n"); 
		query.append("     , MN.IHC_TRF_AMDT_TP_CD" ).append("\n"); 
		query.append("     , MN.UPD_USR_ID" ).append("\n"); 
		query.append("     , MN.UPD_DT" ).append("\n"); 
		query.append("     , MN.TRF_CURR_CD" ).append("\n"); 
		query.append("     , MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , MN.CFM_USR_ID" ).append("\n"); 
		query.append("     , MN.CFM_OFC_CD   " ).append("\n"); 
		query.append("     , DECODE((SELECT USR_NM FROM COM_USER WHERE USR_ID = MN.CFM_USR_ID) || ' / ' || MN.CFM_OFC_CD,' / ', ''" ).append("\n"); 
		query.append("             ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = MN.CFM_USR_ID) || ' / ' || MN.CFM_OFC_CD ) AS CFM_USR     " ).append("\n"); 
		query.append("     , MN.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("	 , SUB.COST_CNT_CD  " ).append("\n"); 
		query.append("     , MN.USA_SCP_BND_FLG" ).append("\n"); 
		query.append("     , SUB.RHQ_CD" ).append("\n"); 
		query.append("	 , '' AMDT_EFF" ).append("\n"); 
		query.append("     , '' TOBE_AMDT_SEQ" ).append("\n"); 
		query.append("     , '' COST_TRF_NO" ).append("\n"); 
		query.append("     , (SELECT COUNT(*)" ).append("\n"); 
		query.append("          FROM PRI_TRF_IHC_SPCL_CGO_RT SPCL" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND SPCL.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND SPCL.IHC_TRF_NO = SUB.IHC_TRF_NO" ).append("\n"); 
		query.append("           AND (SPCL.DCGO_SVC_FLG = 'Y' OR SPCL.OVR_WGT_CGO_SVC_FLG = 'Y') -- service flag가 Y인 경우만 파란색으로 표시" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) SPCL_COUNT" ).append("\n"); 
		query.append("  FROM PRI_TRF_IHC_MN MN" ).append("\n"); 
		query.append("     , MAX_IHC SUB" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND MN.SVC_SCP_CD     = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND MN.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("   AND MN.IHC_TRF_NO = SUB.IHC_TRF_NO" ).append("\n"); 
		query.append("   AND MN.AMDT_SEQ   = SUB.AMDT_SEQ" ).append("\n"); 
		query.append("#if(${usa_scp_bnd_flg} != '')" ).append("\n"); 
		query.append("   AND MN.USA_SCP_BND_FLG = @[usa_scp_bnd_flg] " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}