/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SCProposalMainDBDAORsltHisAmdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltHisAmdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCProposalMainDBDAO
	  * 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
	  * </pre>
	  */
	public SCProposalMainDBDAORsltHisAmdVORSQL(){
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
		query.append("FileName : SCProposalMainDBDAORsltHisAmdVORSQL").append("\n"); 
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
		query.append("#if (${conv_flg} == '0')       " ).append("\n"); 
		query.append("        SELECT   PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("        #if (${term_type_cd} != '')" ).append("\n"); 
		query.append("        #if (${term_type_cd} == '03')" ).append("\n"); 
		query.append("        		,DECODE('04',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("        #elseif (${term_type_cd} == '04')" ).append("\n"); 
		query.append("        		,DECODE('07',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("        #elseif (${term_type_cd} == '11')" ).append("\n"); 
		query.append("        		,DECODE('41',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("        #elseif (${term_type_cd} == '12')" ).append("\n"); 
		query.append("        		,DECODE('13',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("        #elseif (${term_type_cd} == '13')" ).append("\n"); 
		query.append("        		,DECODE('14',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("        #elseif (${term_type_cd} == '14')" ).append("\n"); 
		query.append("        		,DECODE('51',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("        #elseif (${term_type_cd} == '15')" ).append("\n"); 
		query.append("        		,DECODE('71',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("        #elseif (${term_type_cd} == '16')" ).append("\n"); 
		query.append("        		,DECODE('32',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("        #elseif (${term_type_cd} == '17')" ).append("\n"); 
		query.append("        		,DECODE('15',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG " ).append("\n"); 
		query.append("        #elseif (${term_type_cd} == '18')" ).append("\n"); 
		query.append("        		,DECODE('61',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("        #elseif (${term_type_cd} == '19')" ).append("\n"); 
		query.append("        		,DECODE('16',PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("        		,DECODE(@[term_type_cd],PROP_SCP_TERM_TP_CD, MAX (AMDT_FLG) ,'0') AMDT_FLG" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("                ,MAX (AMDT_FLG)  AMDT_FLG" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        		,DAT_FLG" ).append("\n"); 
		query.append("        FROM     (SELECT DECODE(PROP_TERM_TP_CD,'03','02',PROP_TERM_TP_CD ) PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("        #if (${svc_scp_cd} == '')" ).append("\n"); 
		query.append("                        ,DECODE (AMDT_FLG, 'Y', 1, 0) AMDT_FLG" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("        				,0 AMDT_FLG" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        				, 0 DAT_FLG" ).append("\n"); 
		query.append("                  FROM   PRI_SP_AMDT_SMRY" ).append("\n"); 
		query.append("                  WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                  AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                  UNION ALL" ).append("\n"); 
		query.append("                  SELECT CASE PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                            WHEN '11'" ).append("\n"); 
		query.append("                               THEN '01'" ).append("\n"); 
		query.append("                            WHEN '12'" ).append("\n"); 
		query.append("                               THEN '02'" ).append("\n"); 
		query.append("                            WHEN '42'" ).append("\n"); 
		query.append("                               THEN '41'" ).append("\n"); 
		query.append("                            WHEN '52'" ).append("\n"); 
		query.append("                               THEN '51'" ).append("\n"); 
		query.append("                            WHEN '62'" ).append("\n"); 
		query.append("                               THEN '61'" ).append("\n"); 
		query.append("                            WHEN '72'" ).append("\n"); 
		query.append("                               THEN '71'" ).append("\n"); 
		query.append("                            ELSE PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("        #if (${svc_scp_cd} == '')" ).append("\n"); 
		query.append("        				,0 " ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("                        ,DECODE (AMDT_FLG, 'Y', 1, 0)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        				,DECODE (PROP_SCP_TERM_TP_CD ,'32'," ).append("\n"); 
		query.append("                				(SELECT  COUNT(*) FROM    PRI_SP_SCP_NOTE  " ).append("\n"); 
		query.append("        						 WHERE   PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("        					     AND     AMDT_SEQ   = A.AMDT_SEQ" ).append("\n"); 
		query.append("        				         AND     SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("        				         AND     NOTE_TP_CD = 'P'" ).append("\n"); 
		query.append("        				         AND     ROWNUM = 1)" ).append("\n"); 
		query.append("        						 , 0) " ).append("\n"); 
		query.append("                  FROM   PRI_SP_SCP_AMDT_SMRY A" ).append("\n"); 
		query.append("                  WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                  AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("        #if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("                  AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                  AND    PROP_SCP_TERM_TP_CD NOT IN ('31'))" ).append("\n"); 
		query.append("        GROUP BY PROP_SCP_TERM_TP_CD,DAT_FLG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT PROP_SCP_TERM_TP_CD," ).append("\n"); 
		query.append("       DECODE(DAT_FLG,1,DAT_FLG,0,AMDT_FLG) AMDT_FLG,DAT_FLG" ).append("\n"); 
		query.append("       --1 AMDT_FLG,1 DAT_FLG" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("                  SELECT CASE A.PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                              WHEN '72'" ).append("\n"); 
		query.append("                                 THEN '71'          " ).append("\n"); 
		query.append("                              WHEN '62'" ).append("\n"); 
		query.append("                                 THEN '61'" ).append("\n"); 
		query.append("                              WHEN '52'" ).append("\n"); 
		query.append("                                 THEN '51'" ).append("\n"); 
		query.append("                              WHEN '42'" ).append("\n"); 
		query.append("                                     THEN '41'" ).append("\n"); 
		query.append("                              ELSE A.PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                           END PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("                          , DECODE(AMDT_FLG,'N',0,'Y',1) AMDT_FLG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                            ,0 AMDT_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                          ,DECODE(DAT_CNT,'N',0,'Y',1) AS DAT_FLG" ).append("\n"); 
		query.append("                    FROM   PRI_SP_SCP_AMDT_SMRY A" ).append("\n"); 
		query.append("                          , (SELECT '13' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_SP_SCP_GRP_LOC_DTL" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             UNION ALL" ).append("\n"); 
		query.append("                             SELECT '14' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_SP_SCP_GRP_CMDT_DTL" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             UNION ALL" ).append("\n"); 
		query.append("                             SELECT '15' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_SP_SCP_LODG_AGN" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             UNION ALL" ).append("\n"); 
		query.append("                                 SELECT  '16' prop_scp_term_tp_cd, DECODE(count(1),0,'N','Y') dat_cnt" ).append("\n"); 
		query.append("                                 FROM    pri_sp_scp_goh_chg" ).append("\n"); 
		query.append("                                 WHERE   prop_no = @[prop_no]" ).append("\n"); 
		query.append("                                 AND     amdt_seq= @[amdt_seq]" ).append("\n"); 
		query.append("                                 AND     svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             UNION ALL   " ).append("\n"); 
		query.append("                             SELECT '31' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_SP_SCP_NOTE" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             AND    NOTE_TP_CD = 'T'" ).append("\n"); 
		query.append("                             UNION ALL                                                       " ).append("\n"); 
		query.append("                             SELECT '32' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_SP_SCP_NOTE" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             AND    NOTE_TP_CD = 'P'" ).append("\n"); 
		query.append("                             UNION ALL" ).append("\n"); 
		query.append("                             SELECT  '41' prop_scp_term_tp_cd, DECODE(count(1),0,'N','Y') dat_cnt" ).append("\n"); 
		query.append("                                FROM    pri_sp_scp_rout_pnt" ).append("\n"); 
		query.append("                               WHERE   prop_no = @[prop_no]" ).append("\n"); 
		query.append("                                 AND     amdt_seq= @[amdt_seq]" ).append("\n"); 
		query.append("                                 AND     svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("                                  AND     org_dest_tp_cd = 'O'" ).append("\n"); 
		query.append("                                  UNION ALL" ).append("\n"); 
		query.append("                                  SELECT  '42' prop_scp_term_tp_cd, DECODE(count(1),0,'N','Y') dat_cnt" ).append("\n"); 
		query.append("                                  FROM    pri_sp_scp_rout_pnt" ).append("\n"); 
		query.append("                                  WHERE   prop_no = @[prop_no]" ).append("\n"); 
		query.append("                                  AND     amdt_seq= @[amdt_seq]" ).append("\n"); 
		query.append("                                  AND     svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("                                  AND     org_dest_tp_cd = 'D'" ).append("\n"); 
		query.append("                                  UNION ALL" ).append("\n"); 
		query.append("                             SELECT '51' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             AND    ADD_CHG_TP_CD = 'A'" ).append("\n"); 
		query.append("                             AND    ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                             UNION ALL" ).append("\n"); 
		query.append("                             SELECT '52' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             AND    ADD_CHG_TP_CD = 'A'" ).append("\n"); 
		query.append("                             AND    ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                             UNION ALL" ).append("\n"); 
		query.append("                             SELECT '61' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             AND    ADD_CHG_TP_CD = 'I'" ).append("\n"); 
		query.append("                             AND    ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                             UNION ALL" ).append("\n"); 
		query.append("                             SELECT '62' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             AND    ADD_CHG_TP_CD = 'I'" ).append("\n"); 
		query.append("                             AND    ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                             UNION ALL                             " ).append("\n"); 
		query.append("                             SELECT '71' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_SP_SCP_RT_CMDT_HDR" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND    SVC_SCP_CD = @[svc_scp_cd]  " ).append("\n"); 
		query.append("                             AND    GEN_SPCL_RT_TP_CD = 'G'                           " ).append("\n"); 
		query.append("                             UNION ALL                             " ).append("\n"); 
		query.append("                             SELECT '72' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_SP_SCP_RT_CMDT_HDR" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             AND    GEN_SPCL_RT_TP_CD = 'S'  ) B" ).append("\n"); 
		query.append("                    WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                    AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                    AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                    AND    A.PROP_SCP_TERM_TP_CD = B.PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        SELECT DECODE(A.PROP_SCP_TERM_TP_CD,'11','01','02') TP_CD" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("                          ,DECODE(MAX(AMDT_FLG),'N',0,'Y',1) AMDT_FLG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                  ,0 AMDT_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                          ,DECODE(MAX(DAT_CNT),'N',0,'Y',1) DAT_CNT" ).append("\n"); 
		query.append("                    FROM   PRI_SP_SCP_AMDT_SMRY A" ).append("\n"); 
		query.append("                          , (SELECT '11' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                                                                                        ,SVC_SCP_CD" ).append("\n"); 
		query.append("                             FROM   PRI_SP_SCP_DUR" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                                                                          GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append("                                                                          UNION ALL" ).append("\n"); 
		query.append("                             SELECT '12' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                                                                                        ,SVC_SCP_CD" ).append("\n"); 
		query.append("                             FROM   PRI_SP_SCP_MQC" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                                                                          GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                                          ) B" ).append("\n"); 
		query.append("                    WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                    AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                                                     AND    A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND    A.PROP_SCP_TERM_TP_CD = B.PROP_SCP_TERM_TP_CD      " ).append("\n"); 
		query.append("                                                     GROUP BY A.PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                     UNION ALL" ).append("\n"); 
		query.append("                    SELECT TP_CD," ).append("\n"); 
		query.append("#if (${svc_scp_cd} == '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                           DECODE(MAX(AMDT_FLG),'N',0,'Y',1) AMND_FLG," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                           0 AMDT_FLG," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                           DECODE(MAX(DAT_CNT),'N',0,'Y',1) DAT_CNT" ).append("\n"); 
		query.append("                    FROM(                    " ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                        SELECT CASE C.PROP_TERM_TP_CD" ).append("\n"); 
		query.append("                                                 WHEN '03' THEN '02'" ).append("\n"); 
		query.append("                                                 ELSE    C.PROP_TERM_TP_CD" ).append("\n"); 
		query.append("                                                 END TP_CD" ).append("\n"); 
		query.append("                              ,AMDT_FLG" ).append("\n"); 
		query.append("                              ,ACPT_FLG" ).append("\n"); 
		query.append("                              ,DAT_CNT" ).append("\n"); 
		query.append("                        FROM   PRI_SP_AMDT_SMRY C" ).append("\n"); 
		query.append("                              , (SELECT '01' PROP_TERM_TP_CD" ).append("\n"); 
		query.append("                                       ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                                 FROM   PRI_SP_DUR" ).append("\n"); 
		query.append("                                 WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                 AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                 SELECT '02' PROP_TERM_TP_CD" ).append("\n"); 
		query.append("                                       ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                                 FROM   PRI_SP_MQC" ).append("\n"); 
		query.append("                                 WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                 AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                 SELECT '03' PROP_TERM_TP_CD" ).append("\n"); 
		query.append("                                       ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                                 FROM   PRI_SP_SUB_MQC" ).append("\n"); 
		query.append("                                 WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                 AND    AMDT_SEQ = @[amdt_seq]  " ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                 SELECT '04' PROP_TERM_TP_CD" ).append("\n"); 
		query.append("                                       ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                                 FROM   PRI_SP_CTRT_PTY " ).append("\n"); 
		query.append("                                 WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                 AND    AMDT_SEQ = @[amdt_seq]                                                        " ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                 SELECT '05' PROP_TERM_TP_CD" ).append("\n"); 
		query.append("                                       ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                                 FROM   PRI_SP_AFIL" ).append("\n"); 
		query.append("                                 WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                 AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                 SELECT '06' PROP_TERM_TP_CD" ).append("\n"); 
		query.append("                                       ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                                 FROM   PRI_SP_BLPL" ).append("\n"); 
		query.append("                                 WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                 AND    AMDT_SEQ = @[amdt_seq]                             " ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                 SELECT '07' PROP_TERM_TP_CD" ).append("\n"); 
		query.append("                                       ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                                 FROM   PRI_SP_CTRT_CUST_TP" ).append("\n"); 
		query.append("                                 WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                 AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                                                                         ) D" ).append("\n"); 
		query.append("                        WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                        AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                        AND    C.PROP_TERM_TP_CD = D.PROP_TERM_TP_CD" ).append("\n"); 
		query.append("                        ) GROUP BY TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}