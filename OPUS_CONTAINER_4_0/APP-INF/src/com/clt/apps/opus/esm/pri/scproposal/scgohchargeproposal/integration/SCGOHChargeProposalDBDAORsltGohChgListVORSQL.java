/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCGOHChargeProposalDBDAORsltGohChgListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgohchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGOHChargeProposalDBDAORsltGohChgListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SC GOH List 조회
	  * </pre>
	  */
	public SCGOHChargeProposalDBDAORsltGohChgListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scgohchargeproposal.integration").append("\n"); 
		query.append("FileName : SCGOHChargeProposalDBDAORsltGohChgListVORSQL").append("\n"); 
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
		query.append("SELECT A.PROP_NO" ).append("\n"); 
		query.append("     , A.AMDT_SEQ" ).append("\n"); 
		query.append("     , A.SVC_SCP_CD" ).append("\n"); 
		query.append("     , A.GOH_CHG_SEQ" ).append("\n"); 
		query.append("     , A.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("     , A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , CASE ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("	   		WHEN 'L' THEN ( SELECT LOC_NM " ).append("\n"); 
		query.append("     				          FROM MDM_LOCATION " ).append("\n"); 
		query.append("     				         WHERE LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     				           AND DELT_FLG = 'N') " ).append("\n"); 
		query.append("     		WHEN 'C' THEN ( SELECT CNT_NM " ).append("\n"); 
		query.append("     				          FROM MDM_COUNTRY " ).append("\n"); 
		query.append("     				         WHERE CNT_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     				           AND DELT_FLG = 'N') " ).append("\n"); 
		query.append("       END ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("     , A.RAT_UT_CD" ).append("\n"); 
		query.append("     , A.PRC_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("     , CASE A.PRC_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("       		WHEN 'S' THEN 1" ).append("\n"); 
		query.append("         	WHEN 'D' THEN 2" ).append("\n"); 
		query.append("         	ELSE 3" ).append("\n"); 
		query.append("       END AS PRC_HNGR_BAR_TP_SEQ" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("     , A.COFFR_FRT_RT_AMT" ).append("\n"); 
		query.append("     , A.FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("     , A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("     , A.SRC_INFO_CD" ).append("\n"); 
		query.append("     , A.ACPT_USR_ID" ).append("\n"); 
		query.append("	 , (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.ACPT_USR_ID)||' / '||A.ACPT_OFC_CD ACPT_USR_NM" ).append("\n"); 
		query.append("     , A.ACPT_OFC_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.ACPT_DT, 'YYYYMMDD') ACPT_DT" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , (SELECT TO_CHAR(EFF_DT, 'YYYYMMDD') FROM PRI_SP_SCP_MN WHERE PROP_NO = A.PROP_NO " ).append("\n"); 
		query.append("                  AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ AND SVC_SCP_CD = A.SVC_SCP_CD) EFF_DT" ).append("\n"); 
		query.append("     , CASE WHEN A.AMDT_SEQ = @[amdt_seq] THEN TO_CHAR(B.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("     		ELSE (SELECT CASE WHEN A.AMDT_SEQ <= N.AMDT_SEQ THEN TO_CHAR(B.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("                              ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                         END AS EXP_DT" ).append("\n"); 
		query.append("                    FROM PRI_SP_SCP_MN N" ).append("\n"); 
		query.append("                   WHERE PROP_NO = B.PROP_NO AND AMDT_SEQ = B.AMDT_SEQ-1 AND SVC_SCP_CD = B.SVC_SCP_CD)    " ).append("\n"); 
		query.append("       END EXP_DT" ).append("\n"); 
		query.append("	,A.RAT_UT_CD PER_TYPE" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_GOH_CHG A" ).append("\n"); 
		query.append("     , PRI_SP_SCP_MN B" ).append("\n"); 
		query.append(" WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ IN (@[amdt_seq], @[amdt_seq]-1)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND B.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND ((A.AMDT_SEQ = @[amdt_seq] AND A.SRC_INFO_CD <> 'ZZ')" ).append("\n"); 
		query.append("		OR (A.AMDT_SEQ = @[amdt_seq]-1" ).append("\n"); 
		query.append("            AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("            AND NOT EXISTS (SELECT 'X' FROM PRI_SP_SCP_GOH_CHG C" ).append("\n"); 
		query.append("                             WHERE C.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                               AND C.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                               AND C.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("	                           AND C.GOH_CHG_SEQ = A.GOH_CHG_SEQ" ).append("\n"); 
		query.append("                               AND C.N1ST_CMNC_AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ)" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("ORDER BY FIRST_VALUE(A.ROUT_PNT_LOC_TP_CD) OVER ( PARTITION BY A.GOH_CHG_SEQ ORDER BY A.AMDT_SEQ )" ).append("\n"); 
		query.append(", FIRST_VALUE(A.ROUT_PNT_LOC_DEF_CD) OVER ( PARTITION BY A.GOH_CHG_SEQ ORDER BY A.AMDT_SEQ )" ).append("\n"); 
		query.append(", FIRST_VALUE(PRC_HNGR_BAR_TP_SEQ) OVER ( PARTITION BY A.GOH_CHG_SEQ ORDER BY A.AMDT_SEQ )" ).append("\n"); 
		query.append(", FIRST_VALUE(A.RAT_UT_CD) OVER ( PARTITION BY A.GOH_CHG_SEQ ORDER BY A.AMDT_SEQ )" ).append("\n"); 
		query.append(", FIRST_VALUE(A.CURR_CD) OVER ( PARTITION BY A.GOH_CHG_SEQ ORDER BY A.AMDT_SEQ )" ).append("\n"); 
		query.append(", A.AMDT_SEQ" ).append("\n"); 

	}
}