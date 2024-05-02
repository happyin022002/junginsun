/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAORsltAmdtHisMnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.02.24 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltAmdtHisMnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Amendment History Inquery list 조회
	  * </pre>
	  */
	public SCProposalMainDBDAORsltAmdtHisMnVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltAmdtHisMnVORSQL").append("\n"); 
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
		query.append("#if (${svc_scp_cd} == 'X' && (${term_type_cd} == '01' || ${term_type_cd} == '02' || ${term_type_cd} == '03' || ${term_type_cd} == '04' || ${term_type_cd} == '05' || ${term_type_cd} == '06' || ${term_type_cd} == '') )" ).append("\n"); 
		query.append("SELECT MN.PROP_NO" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("      ,'' SVC_SCP_CD" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.FILE_DT, 'YYYY-MM-DD') FILE_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("	  ,DECODE(MN.CONV_CFM_FLG,'Y','1','0') CONV_CFM_FLG" ).append("\n"); 
		query.append("	  ,(SELECT CONV_CFM_FLG FROM PRI_SP_MN WHERE PROP_NO = MN.PROP_NO AND AMDT_SEQ = MN.AMDT_SEQ - 1) PRE_CONV_CFM_FLG" ).append("\n"); 
		query.append("	  ,MN.LGCY_IF_FLG" ).append("\n"); 
		query.append("FROM   PRI_SP_MN MN" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ IN (SELECT AMDT_SEQ FROM PRI_SP_MN WHERE PROP_NO =@[prop_no] AND PROP_STS_CD ='F')" ).append("\n"); 
		query.append("#if (${conv_flg} == '0')" ).append("\n"); 
		query.append("AND    1 = CASE LGCY_IF_FLG " ).append("\n"); 
		query.append("		   WHEN 'N' THEN " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          (SELECT COUNT (1)" ).append("\n"); 
		query.append("           FROM   PRI_SP_AMDT_SMRY" ).append("\n"); 
		query.append("           WHERE  PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("           AND    AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("#if (${term_type_cd} != '')" ).append("\n"); 
		query.append("#if (${term_type_cd} == '02')" ).append("\n"); 
		query.append("		   AND    PROP_TERM_TP_CD IN ('02','03')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '03')" ).append("\n"); 
		query.append("		   AND    PROP_TERM_TP_CD = '04'" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '04')" ).append("\n"); 
		query.append("		   AND    PROP_TERM_TP_CD = '07'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		   AND    PROP_TERM_TP_CD = @[term_type_cd]	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND    AMDT_FLG = 'Y'" ).append("\n"); 
		query.append("           AND    ROWNUM = 1) " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		  WHEN 'Y' THEN" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("    SELECT SIGN(SUM(AMDT_FLG)) FROM " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("         SELECT '01' PROP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("			   ,AMDT_SEQ" ).append("\n"); 
		query.append("         FROM   PRI_SP_DUR" ).append("\n"); 
		query.append("         WHERE  PROP_NO =  @[prop_no]" ).append("\n"); 
		query.append("		 GROUP BY AMDT_SEQ" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '02' PROP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("			   ,AMDT_SEQ" ).append("\n"); 
		query.append("         FROM   PRI_SP_MQC" ).append("\n"); 
		query.append("         WHERE  PROP_NO =  @[prop_no]" ).append("\n"); 
		query.append("		 GROUP BY AMDT_SEQ" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '02' PROP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("			   ,AMDT_SEQ" ).append("\n"); 
		query.append("         FROM   PRI_SP_SUB_MQC" ).append("\n"); 
		query.append("         WHERE  PROP_NO =  @[prop_no]" ).append("\n"); 
		query.append("		 GROUP BY AMDT_SEQ" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '04' PROP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("			   ,AMDT_SEQ" ).append("\n"); 
		query.append("         FROM   PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("         WHERE  PROP_NO =  @[prop_no]" ).append("\n"); 
		query.append("		 GROUP BY AMDT_SEQ                                               " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '05' PROP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("			   ,AMDT_SEQ" ).append("\n"); 
		query.append("         FROM   PRI_SP_AFIL" ).append("\n"); 
		query.append("         WHERE  PROP_NO =  @[prop_no]" ).append("\n"); 
		query.append("		 GROUP BY AMDT_SEQ" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '06' PROP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("			   ,AMDT_SEQ" ).append("\n"); 
		query.append("         FROM   PRI_SP_BLPL" ).append("\n"); 
		query.append("         WHERE  PROP_NO =  @[prop_no] " ).append("\n"); 
		query.append("		 GROUP BY AMDT_SEQ                  " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '07' PROP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("			   ,AMDT_SEQ" ).append("\n"); 
		query.append("         FROM   PRI_SP_CTRT_CUST_TP" ).append("\n"); 
		query.append("         WHERE  PROP_NO =  @[prop_no]" ).append("\n"); 
		query.append("		 GROUP BY AMDT_SEQ" ).append("\n"); 
		query.append("        )MN_TERM" ).append("\n"); 
		query.append("	WHERE MN_TERM.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("#if (${term_type_cd} != '')" ).append("\n"); 
		query.append("#if (${term_type_cd} == '02')" ).append("\n"); 
		query.append("		   AND    PROP_TERM_TP_CD IN ('02','03')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '03')" ).append("\n"); 
		query.append("		   AND    PROP_TERM_TP_CD = '04'" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '04')" ).append("\n"); 
		query.append("		   AND    PROP_TERM_TP_CD = '07'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		   AND    PROP_TERM_TP_CD = @[term_type_cd]	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("		   END" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT MN.PROP_NO" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("      ,SCP.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.FILE_DT, 'YYYY-MM-DD') FILE_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (SCP.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (SCP.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("	  ,'2' CONV_CFM_FLG" ).append("\n"); 
		query.append("	  ,'N' PRE_CONV_CFM_FLG" ).append("\n"); 
		query.append("	  ,MN.LGCY_IF_FLG" ).append("\n"); 
		query.append("FROM   PRI_SP_SCP_MN SCP" ).append("\n"); 
		query.append("      ,PRI_SP_MN MN" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = SCP.PROP_NO" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = SCP.AMDT_SEQ" ).append("\n"); 
		query.append("AND    MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != 'X')" ).append("\n"); 
		query.append("AND    SCP.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ IN (SELECT AMDT_SEQ FROM PRI_SP_MN WHERE PROP_NO =@[prop_no] AND PROP_STS_CD ='F')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    1 = CASE LGCY_IF_FLG " ).append("\n"); 
		query.append("		   WHEN 'N' THEN " ).append("\n"); 
		query.append("          (SELECT COUNT (1)" ).append("\n"); 
		query.append("           FROM   PRI_SP_SCP_AMDT_SMRY" ).append("\n"); 
		query.append("           WHERE  PROP_NO = SCP.PROP_NO" ).append("\n"); 
		query.append("           AND    AMDT_SEQ = SCP.AMDT_SEQ" ).append("\n"); 
		query.append("           AND    SVC_SCP_CD = SCP.SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${term_type_cd} != '')" ).append("\n"); 
		query.append("#if (${term_type_cd} == '11')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD IN ('41','42')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '12')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('13')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '13')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('14')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '14')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD  IN ('51','52')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '15')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD  IN ('71','72')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '16')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('32')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '17')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('15')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '18')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD  IN ('61','62')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '19')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('16')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '01')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('11')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '02')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('12')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = @[term_type_cd]	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${conv_flg} == '0')" ).append("\n"); 
		query.append("           AND    AMDT_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND    ROWNUM = 1)" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		  WHEN 'Y' THEN" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		 SELECT SIGN(SUM(AMDT_FLG))" ).append("\n"); 
		query.append("		 FROM(" ).append("\n"); 
		query.append("         		SELECT '11' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               		,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               		,AMDT_SEQ" ).append("\n"); 
		query.append("					,SVC_SCP_CD" ).append("\n"); 
		query.append("         		FROM   PRI_SP_SCP_DUR" ).append("\n"); 
		query.append("         		WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("				 GROUP BY SVC_SCP_CD,AMDT_SEQ" ).append("\n"); 
		query.append("         		UNION ALL" ).append("\n"); 
		query.append("         		SELECT '12' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               		,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               		,AMDT_SEQ" ).append("\n"); 
		query.append("					,SVC_SCP_CD" ).append("\n"); 
		query.append("         		FROM   PRI_SP_SCP_MQC" ).append("\n"); 
		query.append("         		WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("				 GROUP BY SVC_SCP_CD,AMDT_SEQ" ).append("\n"); 
		query.append("         		UNION ALL" ).append("\n"); 
		query.append("         		SELECT '13' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               		,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               		,AMDT_SEQ" ).append("\n"); 
		query.append("					,SVC_SCP_CD" ).append("\n"); 
		query.append("         		FROM   PRI_SP_SCP_GRP_LOC_DTL" ).append("\n"); 
		query.append("        		 WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("				 GROUP BY SVC_SCP_CD,AMDT_SEQ" ).append("\n"); 
		query.append("         		UNION ALL" ).append("\n"); 
		query.append("         		SELECT '14' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               		,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               		,AMDT_SEQ" ).append("\n"); 
		query.append("					,SVC_SCP_CD" ).append("\n"); 
		query.append("        		 FROM   PRI_SP_SCP_GRP_CMDT_DTL" ).append("\n"); 
		query.append("        		 WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("				 GROUP BY SVC_SCP_CD,AMDT_SEQ" ).append("\n"); 
		query.append("         		UNION ALL" ).append("\n"); 
		query.append("         		SELECT '15' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               		,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               		,AMDT_SEQ" ).append("\n"); 
		query.append("					,SVC_SCP_CD" ).append("\n"); 
		query.append("         		FROM   PRI_SP_SCP_LODG_AGN" ).append("\n"); 
		query.append("         		WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("				 GROUP BY SVC_SCP_CD,AMDT_SEQ " ).append("\n"); 
		query.append("        		UNION ALL" ).append("\n"); 
		query.append("        		SELECT  '16' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("          		     ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("          		      ,AMDT_SEQ" ).append("\n"); 
		query.append("					,SVC_SCP_CD" ).append("\n"); 
		query.append("       		 	FROM    PRI_SP_SCP_GOH_CHG" ).append("\n"); 
		query.append("      		 	WHERE   PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("				 GROUP BY SVC_SCP_CD,AMDT_SEQ  " ).append("\n"); 
		query.append("         		UNION ALL                                                       " ).append("\n"); 
		query.append("         		SELECT '32' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               		  ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               		  ,AMDT_SEQ" ).append("\n"); 
		query.append("					  ,SVC_SCP_CD" ).append("\n"); 
		query.append("         		FROM   PRI_SP_SCP_NOTE" ).append("\n"); 
		query.append("         		WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         		AND    NOTE_TP_CD = 'P'" ).append("\n"); 
		query.append("				 GROUP BY SVC_SCP_CD,AMDT_SEQ" ).append("\n"); 
		query.append("        		UNION ALL" ).append("\n"); 
		query.append("        		SELECT  '41' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                		,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("                		,AMDT_SEQ" ).append("\n"); 
		query.append("						,SVC_SCP_CD" ).append("\n"); 
		query.append("        		FROM    PRI_SP_SCP_ROUT_PNT" ).append("\n"); 
		query.append("        		WHERE   PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        		AND     ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("				 GROUP BY SVC_SCP_CD,AMDT_SEQ" ).append("\n"); 
		query.append("        		UNION ALL" ).append("\n"); 
		query.append("        		SELECT  '41' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                		,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("                		,AMDT_SEQ" ).append("\n"); 
		query.append("					,SVC_SCP_CD" ).append("\n"); 
		query.append("        		FROM    PRI_SP_SCP_ROUT_PNT" ).append("\n"); 
		query.append("        		WHERE   PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        		AND     ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("				 GROUP BY SVC_SCP_CD,AMDT_SEQ" ).append("\n"); 
		query.append("        		UNION ALL" ).append("\n"); 
		query.append("         		SELECT '51' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               		,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               		,AMDT_SEQ" ).append("\n"); 
		query.append("					,SVC_SCP_CD" ).append("\n"); 
		query.append("         		FROM   PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("         		WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         		AND    ADD_CHG_TP_CD = 'A'" ).append("\n"); 
		query.append("         		AND    ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("				 GROUP BY SVC_SCP_CD,AMDT_SEQ" ).append("\n"); 
		query.append("         		UNION ALL" ).append("\n"); 
		query.append("         		SELECT '51' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               		,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               		,AMDT_SEQ" ).append("\n"); 
		query.append("					,SVC_SCP_CD" ).append("\n"); 
		query.append("         		FROM   PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("         		WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         		AND    ADD_CHG_TP_CD = 'A'" ).append("\n"); 
		query.append("         		AND    ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("				 GROUP BY SVC_SCP_CD,AMDT_SEQ" ).append("\n"); 
		query.append("         		UNION ALL" ).append("\n"); 
		query.append("         		SELECT '61' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               		,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               		,AMDT_SEQ" ).append("\n"); 
		query.append("					,SVC_SCP_CD" ).append("\n"); 
		query.append("         		FROM   PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("         		WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         		AND    ADD_CHG_TP_CD = 'I'" ).append("\n"); 
		query.append("         		AND    ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("				 GROUP BY SVC_SCP_CD,AMDT_SEQ" ).append("\n"); 
		query.append("         		UNION ALL" ).append("\n"); 
		query.append("         		SELECT '61' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               		,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               		,AMDT_SEQ" ).append("\n"); 
		query.append("					,SVC_SCP_CD" ).append("\n"); 
		query.append("         		FROM   PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("         		WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         		AND    ADD_CHG_TP_CD = 'I'" ).append("\n"); 
		query.append("         		AND    ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("				 GROUP BY SVC_SCP_CD,AMDT_SEQ" ).append("\n"); 
		query.append("         		UNION ALL                             " ).append("\n"); 
		query.append("         		SELECT '71' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               		,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               		,AMDT_SEQ" ).append("\n"); 
		query.append("					,SVC_SCP_CD" ).append("\n"); 
		query.append("         		FROM   PRI_SP_SCP_RT_CMDT_HDR" ).append("\n"); 
		query.append("         		WHERE  PROP_NO = @[prop_no] " ).append("\n"); 
		query.append("         		AND    GEN_SPCL_RT_TP_CD = 'G'    " ).append("\n"); 
		query.append("				 GROUP BY SVC_SCP_CD,AMDT_SEQ                        " ).append("\n"); 
		query.append("         		UNION ALL                             " ).append("\n"); 
		query.append("         		SELECT '71' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               		,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               		,AMDT_SEQ" ).append("\n"); 
		query.append("					,SVC_SCP_CD" ).append("\n"); 
		query.append("         		 FROM   PRI_SP_SCP_RT_CMDT_HDR" ).append("\n"); 
		query.append("         		 WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         		 AND    GEN_SPCL_RT_TP_CD = 'S'                                    " ).append("\n"); 
		query.append("				 GROUP BY SVC_SCP_CD,AMDT_SEQ" ).append("\n"); 
		query.append("				 ) SCP_TERM" ).append("\n"); 
		query.append("		   WHERE SCP_TERM.AMDT_SEQ = SCP.AMDT_SEQ" ).append("\n"); 
		query.append("           AND   SCP_TERM.SVC_SCP_CD = SCP.SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${term_type_cd} != '')" ).append("\n"); 
		query.append("#if (${term_type_cd} == '11')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD IN ('41','42')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '12')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('13')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '13')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('14')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '14')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD  IN ('51','52')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '15')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD  IN ('71','72')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '16')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('32')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '17')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('15')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '18')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD  IN ('61','62')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '19')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('16')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '01')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('11')" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '02')" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = ('12')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		   AND    PROP_SCP_TERM_TP_CD = @[term_type_cd]	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("		  END" ).append("\n"); 
		query.append("#if (${svc_scp_cd} == 'X' )" ).append("\n"); 
		query.append("UNION " ).append("\n"); 
		query.append("SELECT MN.PROP_NO" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("      ,'' SVC_SCP_CD" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.FILE_DT, 'YYYY-MM-DD') FILE_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("	  ,DECODE(MN.CONV_CFM_FLG,'Y','1','0') CONV_CFM_FLG" ).append("\n"); 
		query.append("	  ,(SELECT CONV_CFM_FLG FROM PRI_SP_MN WHERE PROP_NO = MN.PROP_NO AND AMDT_SEQ = MN.AMDT_SEQ -1) PRE_CONV_CFM_FLG" ).append("\n"); 
		query.append("	  ,MN.LGCY_IF_FLG" ).append("\n"); 
		query.append("FROM   PRI_SP_MN MN" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT MN.PROP_NO" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("      ,SCP.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.FILE_DT, 'YYYY-MM-DD') FILE_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (SCP.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (SCP.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("	  ,'2' CONV_CFM_FLG" ).append("\n"); 
		query.append("	  ,'N' PRE_CONV_CFM_FLG" ).append("\n"); 
		query.append("	  ,MN.LGCY_IF_FLG" ).append("\n"); 
		query.append("FROM   PRI_SP_SCP_MN SCP" ).append("\n"); 
		query.append("      ,PRI_SP_MN MN" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = SCP.PROP_NO" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = SCP.AMDT_SEQ" ).append("\n"); 
		query.append("AND    MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = 0" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != 'X')" ).append("\n"); 
		query.append("AND    SCP.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY AMDT_SEQ DESC ,SVC_SCP_CD DESC" ).append("\n"); 

	}
}