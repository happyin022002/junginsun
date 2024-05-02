/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAORsltHisAmdLgcyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.02.18 공백진
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

public class SCProposalMainDBDAORsltHisAmdLgcyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Amendment History 레거시 데이터인 경우
	  * </pre>
	  */
	public SCProposalMainDBDAORsltHisAmdLgcyVORSQL(){
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
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltHisAmdLgcyVORSQL").append("\n"); 
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
		query.append("SELECT   PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("#if (${term_type_cd} != '')" ).append("\n"); 
		query.append("#if (${term_type_cd} == '03')" ).append("\n"); 
		query.append("        ,DECODE('04',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '04')" ).append("\n"); 
		query.append("        ,DECODE('07',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '11')" ).append("\n"); 
		query.append("        ,DECODE('41',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '12')" ).append("\n"); 
		query.append("        ,DECODE('13',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '13')" ).append("\n"); 
		query.append("        ,DECODE('14',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '14')" ).append("\n"); 
		query.append("        ,DECODE('51',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '15')" ).append("\n"); 
		query.append("        ,DECODE('71',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '16')" ).append("\n"); 
		query.append("        ,DECODE('32',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '17')" ).append("\n"); 
		query.append("        ,DECODE('15',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '18')" ).append("\n"); 
		query.append("        ,DECODE('61',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#elseif (${term_type_cd} == '19')" ).append("\n"); 
		query.append("        ,DECODE('16',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        ,DECODE(@[term_type_cd],PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        ,MAX (AMDT_FLG)  AMDT_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ,DAT_FLG" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	SELECT PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("#if (${svc_scp_cd} == '')" ).append("\n"); 
		query.append("		, AMDT_FLG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	    ,0 AMDT_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		,DAT_FLG" ).append("\n"); 
		query.append("	FROM(" ).append("\n"); 
		query.append("         SELECT '01' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               , 0 DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_DUR" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("         AND    ROWNUM = 1" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '02' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               , 0 DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_MQC" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("         AND    ROWNUM = 1" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '02' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               , 0 DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_SUB_MQC" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]  " ).append("\n"); 
		query.append("         AND    ROWNUM = 1" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '04' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               , 0 DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]    " ).append("\n"); 
		query.append("         AND    ROWNUM = 1                                                    " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '05' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               , 0 DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_AFIL" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("         AND    ROWNUM = 1" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '06' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               , 0 DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_BLPL" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]      " ).append("\n"); 
		query.append("         AND    ROWNUM = 1                       " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '07' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               , 0 DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_CTRT_CUST_TP" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("         AND    ROWNUM = 1" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("	SELECT PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("#if (${svc_scp_cd} == '')" ).append("\n"); 
		query.append("		, 0 AMDT_FLG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	    , AMDT_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		, DAT_FLG" ).append("\n"); 
		query.append("	FROM(" ).append("\n"); 
		query.append("         SELECT '01' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               ,0 DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_SCP_DUR" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("         AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("         AND    ROWNUM = 1 " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '02' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               ,0 DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_SCP_MQC" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("         AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("         AND    ROWNUM = 1 " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '13' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               ,0 DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_SCP_GRP_LOC_DTL" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("         AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("         AND    ROWNUM = 1    " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '14' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               ,0 DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_SCP_GRP_CMDT_DTL" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("         AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("          AND    ROWNUM = 1    " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '15' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               ,0 DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_SCP_LODG_AGN" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("         AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("          AND    ROWNUM = 1    " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  '16' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("                ,0 DAT_FLG" ).append("\n"); 
		query.append("        FROM    PRI_SP_SCP_GOH_CHG" ).append("\n"); 
		query.append("        WHERE   PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        AND     AMDT_SEQ= @[amdt_seq]" ).append("\n"); 
		query.append("        AND     SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("         AND    ROWNUM = 1    " ).append("\n"); 
		query.append("         UNION ALL                                                       " ).append("\n"); 
		query.append("         SELECT '32' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               ,COUNT(*) DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_SCP_NOTE" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("         AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("         AND    NOTE_TP_CD = 'P'" ).append("\n"); 
		query.append("          AND    ROWNUM = 1    " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  '41' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("                ,0 DAT_FLG" ).append("\n"); 
		query.append("        FROM    PRI_SP_SCP_ROUT_PNT" ).append("\n"); 
		query.append("        WHERE   PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        AND     AMDT_SEQ= @[amdt_seq]" ).append("\n"); 
		query.append("        AND     SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("        AND     ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("         AND    ROWNUM = 1    " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  '41' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("                ,0 DAT_FLG" ).append("\n"); 
		query.append("        FROM    PRI_SP_SCP_ROUT_PNT" ).append("\n"); 
		query.append("        WHERE   PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        AND     AMDT_SEQ= @[amdt_seq]" ).append("\n"); 
		query.append("        AND     SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("        AND     ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("         AND    ROWNUM = 1    " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("         SELECT '51' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               ,0 DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("         AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("         AND    ADD_CHG_TP_CD = 'A'" ).append("\n"); 
		query.append("         AND    ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("          AND    ROWNUM = 1    " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '51' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               ,0 DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("         AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("         AND    ADD_CHG_TP_CD = 'A'" ).append("\n"); 
		query.append("         AND    ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("          AND    ROWNUM = 1    " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '61' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               ,0 DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("         AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("         AND    ADD_CHG_TP_CD = 'I'" ).append("\n"); 
		query.append("         AND    ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("          AND    ROWNUM = 1    " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT '61' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               ,0 DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("         AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("         AND    ADD_CHG_TP_CD = 'I'" ).append("\n"); 
		query.append("         AND    ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("         AND    ROWNUM = 1    " ).append("\n"); 
		query.append("         UNION ALL                             " ).append("\n"); 
		query.append("         SELECT '71' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               ,0 DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_SCP_RT_CMDT_HDR" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("         AND    SVC_SCP_CD = @[svc_scp_cd]  " ).append("\n"); 
		query.append("         AND    GEN_SPCL_RT_TP_CD = 'G'    " ).append("\n"); 
		query.append("         AND    ROWNUM = 1                           " ).append("\n"); 
		query.append("         UNION ALL                             " ).append("\n"); 
		query.append("         SELECT '71' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AMDT_FLG" ).append("\n"); 
		query.append("               ,0 DAT_FLG" ).append("\n"); 
		query.append("         FROM   PRI_SP_SCP_RT_CMDT_HDR" ).append("\n"); 
		query.append("         WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("         AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("         AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("         AND    GEN_SPCL_RT_TP_CD = 'S'                                    " ).append("\n"); 
		query.append("         AND    ROWNUM = 1   " ).append("\n"); 
		query.append("		) " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY PROP_SCP_TERM_TP_CD,DAT_FLG" ).append("\n"); 

	}
}