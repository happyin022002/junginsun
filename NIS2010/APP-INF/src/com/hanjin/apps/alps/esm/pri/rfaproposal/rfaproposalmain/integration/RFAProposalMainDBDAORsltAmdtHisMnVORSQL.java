/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltAmdtHisMnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAORsltAmdtHisMnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Amendment History Inquery list 조회
	  * 
	  * 2015.07.14 전지예 [CHM-201536753]Spot Guide RFA Artitrary Tab 추가 (BOMSC Only)
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltAmdtHisMnVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("term_type_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORsltAmdtHisMnVORSQL").append("\n"); 
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
		query.append("#if (${svc_scp_cd} == 'X' && (${term_type_cd} == '01' || ${term_type_cd} == '05' || ${term_type_cd} == '07' || ${term_type_cd} == '') )" ).append("\n"); 
		query.append("SELECT MN.PROP_NO" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("      ,'' SVC_SCP_CD" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(MN.PROP_APRO_DT, 'YYYYMMDD') APRO_DT" ).append("\n"); 
		query.append("	  ,MN.PROP_OFC_CD" ).append("\n"); 
		query.append("FROM   PRI_RP_MN MN" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ IN (SELECT AMDT_SEQ FROM PRI_RP_MN WHERE PROP_NO =@[prop_no] AND PROP_STS_CD ='A'  AND AMDT_SEQ <> 0)" ).append("\n"); 
		query.append("AND    1 =" ).append("\n"); 
		query.append("          (SELECT COUNT (1)" ).append("\n"); 
		query.append("           FROM   PRI_RP_AMDT_SMRY" ).append("\n"); 
		query.append("           WHERE  PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("           AND    AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("#if (${term_type_cd} != '')" ).append("\n"); 
		query.append("#if (${term_type_cd} == '07')" ).append("\n"); 
		query.append("		   AND    PROP_TERM_TP_CD = '08'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		   AND    PROP_TERM_TP_CD = @[term_type_cd]	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND    AMDT_FLG = 'Y'" ).append("\n"); 
		query.append("           AND    ROWNUM = 1)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT MN.PROP_NO" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("      ,SCP.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,TO_CHAR (SCP.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (SCP.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(MN.PROP_APRO_DT, 'YYYYMMDD') APRO_DT" ).append("\n"); 
		query.append("	  ,MN.PROP_OFC_CD" ).append("\n"); 
		query.append("FROM   PRI_RP_SCP_MN SCP" ).append("\n"); 
		query.append("      ,PRI_RP_MN MN" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = SCP.PROP_NO" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = SCP.AMDT_SEQ" ).append("\n"); 
		query.append("AND    MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != 'X')" ).append("\n"); 
		query.append("AND    SCP.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ IN (SELECT AMDT_SEQ FROM PRI_RP_MN WHERE PROP_NO =@[prop_no] AND PROP_STS_CD ='A'  AND AMDT_SEQ <> 0)" ).append("\n"); 
		query.append("AND    1 =" ).append("\n"); 
		query.append("          (SELECT COUNT (1)" ).append("\n"); 
		query.append("           FROM   PRI_RP_SCP_AMDT_SMRY" ).append("\n"); 
		query.append("           WHERE  PROP_NO = SCP.PROP_NO" ).append("\n"); 
		query.append("           AND    AMDT_SEQ = SCP.AMDT_SEQ" ).append("\n"); 
		query.append("           AND    SVC_SCP_CD = SCP.SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${term_type_cd} != '')" ).append("\n"); 
		query.append("#if (${term_type_cd} == '12')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('13')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '13')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('14')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '14')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD  IN ('51','52')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '15')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD  = '71'" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '16')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('32')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '01')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('11')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = @[term_type_cd]	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND    AMDT_FLG = 'Y'" ).append("\n"); 
		query.append("           AND    ROWNUM = 1)" ).append("\n"); 
		query.append("ORDER BY AMDT_SEQ DESC ,SVC_SCP_CD DESC" ).append("\n"); 

	}
}