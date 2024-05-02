/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCProposalMainDBDAORsltPropMnScpListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.24
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2015.07.24 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltPropMnScpListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltPropMnScpListVO
	  * </pre>
	  */
	public SCProposalMainDBDAORsltPropMnScpListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltPropMnScpListVORSQL").append("\n"); 
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
		query.append("SELECT MN.PROP_NO" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("      ,MN.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,MN.PROP_SCP_APRO_OFC_CD" ).append("\n"); 
		query.append("      ,MN.PROP_SCP_OFC_CD" ).append("\n"); 
		query.append("      ,MQC.PROP_SCP_MQC_QTY" ).append("\n"); 
		query.append("	  ,MQC.CNTR_LOD_UT_CD" ).append("\n"); 
		query.append("      ,MN.PROP_SCP_SREP_CD" ).append("\n"); 
		query.append("      ,CASE WHEN DUR.CTRT_EFF_DT = TO_DATE('99991231','YYYYMMDD') AND DUR.CTRT_EXP_DT = TO_DATE('99991231','YYYYMMDD')" ).append("\n"); 
		query.append("            THEN ''" ).append("\n"); 
		query.append("            ELSE TO_CHAR(DUR.CTRT_EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("       END CTRT_EFF_DT" ).append("\n"); 
		query.append("      ,CASE WHEN DUR.CTRT_EFF_DT = TO_DATE('99991231','YYYYMMDD') AND DUR.CTRT_EXP_DT = TO_DATE('99991231','YYYYMMDD')" ).append("\n"); 
		query.append("            THEN ''" ).append("\n"); 
		query.append("            ELSE TO_CHAR(DUR.CTRT_EXP_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("       END CTRT_EXP_DT" ).append("\n"); 
		query.append("      ,CASE WHEN MN.EFF_DT = TO_DATE('99991231','YYYYMMDD') AND MN.EXP_DT = TO_DATE('99991231','YYYYMMDD')" ).append("\n"); 
		query.append("            THEN ''" ).append("\n"); 
		query.append("            ELSE TO_CHAR(MN.EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("       END EFF_DT" ).append("\n"); 
		query.append("      ,CASE WHEN MN.EFF_DT = TO_DATE('99991231','YYYYMMDD') AND MN.EXP_DT = TO_DATE('99991231','YYYYMMDD')" ).append("\n"); 
		query.append("            THEN ''" ).append("\n"); 
		query.append("            ELSE TO_CHAR(MN.EXP_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("       END EXP_DT" ).append("\n"); 
		query.append("      ,NVL((SELECT CASE WHEN MN.EFF_DT <= N.EXP_DT THEN TO_CHAR(MN.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("               ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("               END AS EXP_DT" ).append("\n"); 
		query.append("         FROM PRI_SP_SCP_MN N" ).append("\n"); 
		query.append("        WHERE PROP_NO = MN.PROP_NO AND AMDT_SEQ = MN.AMDT_SEQ-1 AND SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("        ), TO_CHAR (MN.EFF_DT - 1, 'YYYYMMDD')) PRE_EXP_DT" ).append("\n"); 
		query.append("      ,NVL((    " ).append("\n"); 
		query.append("        SELECT CASE WHEN MN.EFF_DT <= N.EXP_DT THEN 'Y'" ).append("\n"); 
		query.append("               ELSE 'N'" ).append("\n"); 
		query.append("               END AS EXP_DT" ).append("\n"); 
		query.append("          FROM PRI_SP_SCP_MN N" ).append("\n"); 
		query.append("         WHERE PROP_NO = MN.PROP_NO AND AMDT_SEQ = MN.AMDT_SEQ-1 AND SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("       ),'N') DUR_DUP_FLG" ).append("\n"); 
		query.append("      ,MN.PROP_SCP_STS_CD" ).append("\n"); 
		query.append("      ,STS_CD.INTG_CD_VAL_DP_DESC PROP_SCP_STS" ).append("\n"); 
		query.append("      ,MN.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("      ,DECODE ((SELECT MIN (AMDT_SEQ)" ).append("\n"); 
		query.append("                FROM   PRI_SP_SCP_MN" ).append("\n"); 
		query.append("                WHERE  PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                AND    SVC_SCP_CD = MN.SVC_SCP_CD)" ).append("\n"); 
		query.append("              ,MN.AMDT_SEQ, 'Y'" ).append("\n"); 
		query.append("              ,'N'" ).append("\n"); 
		query.append("              ) AMD_SCP_FLG" ).append("\n"); 
		query.append("       ,NVL((SELECT 'Y' FROM PRI_SP_SCP_MN A " ).append("\n"); 
		query.append("			 WHERE MN.PROP_NO = A.PROP_NO " ).append("\n"); 
		query.append("			 AND MN.AMDT_SEQ = A.AMDT_SEQ + 1 " ).append("\n"); 
		query.append("		     AND MN.SVC_SCP_CD = A.SVC_SCP_CD),'N') PRE_EXT_SCP" ).append("\n"); 
		query.append("FROM   PRI_SP_SCP_MN MN" ).append("\n"); 
		query.append("      ,PRI_SP_HDR HDR" ).append("\n"); 
		query.append("      ,PRI_SP_SCP_DUR DUR" ).append("\n"); 
		query.append("      ,PRI_SP_SCP_MQC MQC" ).append("\n"); 
		query.append("      ,COM_INTG_CD_DTL STS_CD" ).append("\n"); 
		query.append("      ,PRI_AUTHORIZATION AUTH" ).append("\n"); 
		query.append("WHERE (MN.PROP_NO,MN.AMDT_SEQ) = ( SELECT MN.PROP_NO, MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("    FROM PRI_SP_MN MN" ).append("\n"); 
		query.append("       , PRI_SP_HDR HDR" ).append("\n"); 
		query.append("#if (${sc_no} != '')" ).append("\n"); 
		query.append("    WHERE HDR.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("    AND   MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    WHERE MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    GROUP BY MN.PROP_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND DUR.PROP_NO(+) = MN.PROP_NO " ).append("\n"); 
		query.append("AND DUR.AMDT_SEQ(+) = MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND DUR.SVC_SCP_CD(+) = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("AND STS_CD.INTG_CD_ID = 'CD01719'" ).append("\n"); 
		query.append("AND STS_CD.INTG_CD_VAL_CTNT = MN.PROP_SCP_STS_CD" ).append("\n"); 
		query.append("AND MQC.PROP_NO(+) = MN.PROP_NO" ).append("\n"); 
		query.append("AND MQC.AMDT_SEQ(+) = MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND MQC.SVC_SCP_CD(+) = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("AND AUTH.PRC_CTRT_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("AND AUTH.SVC_SCP_CD(+) = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("AND AUTH.USR_ID(+) = @[usr_id]" ).append("\n"); 
		query.append("ORDER BY MN.CRE_DT, MN.SVC_SCP_CD" ).append("\n"); 

	}
}