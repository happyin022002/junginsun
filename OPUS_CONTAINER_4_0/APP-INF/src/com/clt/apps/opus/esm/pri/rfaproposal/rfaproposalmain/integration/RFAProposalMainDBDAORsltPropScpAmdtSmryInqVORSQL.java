/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltPropScpAmdtSmryInqVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.09
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2015.04.09 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAORsltPropScpAmdtSmryInqVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltPropScpAmdtSmryVORSQL.Query
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltPropScpAmdtSmryInqVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORsltPropScpAmdtSmryInqVORSQL").append("\n"); 
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
		query.append("SELECT   TP_CD PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("        ,CASE SUBSTR(FLAG, 1, 1)" ).append("\n"); 
		query.append("            WHEN 'Y' THEN '3'" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                CASE SUBSTR(FLAG,2,2)" ).append("\n"); 
		query.append("                    WHEN 'YY' THEN DECODE(@[amdt_seq],'0','1','2')" ).append("\n"); 
		query.append("                    WHEN 'NY' THEN '1'" ).append("\n"); 
		query.append("                    WHEN 'NN' THEN '0'" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("         END DAT_FLG" ).append("\n"); 
		query.append("FROM     (SELECT   TP_CD" ).append("\n"); 
		query.append("                  ,CASE TP_CD" ).append("\n"); 
		query.append("                      WHEN '52'" ).append("\n"); 
		query.append("                         THEN DECODE(MIN(AMDT_FLG),'N', MAX(ACPT_FLG), MIN(ACPT_FLG)) ||MAX(AMDT_FLG)||MAX(DAT_CNT)" ).append("\n"); 
		query.append("                      WHEN '01'" ).append("\n"); 
		query.append("                         THEN DECODE(MIN(AMDT_FLG),'N', MAX(ACPT_FLG), MIN(ACPT_FLG)) ||MAX(AMDT_FLG)||MAX(DAT_CNT)" ).append("\n"); 
		query.append("                      ELSE MAX (ACPT_FLG)||MAX(AMDT_FLG) || MAX(DAT_CNT)" ).append("\n"); 
		query.append("                   END FLAG" ).append("\n"); 
		query.append("          FROM     (SELECT CASE A.PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                              WHEN '51'" ).append("\n"); 
		query.append("                                 THEN '52'" ).append("\n"); 
		query.append("                              ELSE A.PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                           END TP_CD" ).append("\n"); 
		query.append("                          ,AMDT_FLG" ).append("\n"); 
		query.append("                          ,ACPT_FLG" ).append("\n"); 
		query.append("                          ,DAT_CNT" ).append("\n"); 
		query.append("                    FROM   PRI_RP_SCP_AMDT_SMRY A" ).append("\n"); 
		query.append("                          , (SELECT '13' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_RP_SCP_GRP_LOC_DTL" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             UNION ALL" ).append("\n"); 
		query.append("                             SELECT '14' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_RP_SCP_GRP_CMDT_DTL" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             UNION ALL" ).append("\n"); 
		query.append("                             SELECT '32' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_RP_SCP_NOTE" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             AND    NOTE_TP_CD = 'P'" ).append("\n"); 
		query.append("                             UNION ALL" ).append("\n"); 
		query.append("                             SELECT '51' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_RP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             AND    ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                             UNION ALL" ).append("\n"); 
		query.append("                             SELECT '52' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_RP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             AND    ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                             UNION ALL" ).append("\n"); 
		query.append("                             SELECT '71' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_RP_SCP_RT_CMDT_HDR" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND    SVC_SCP_CD = @[svc_scp_cd]) B" ).append("\n"); 
		query.append("                    WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                    AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                    AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                    AND    A.PROP_SCP_TERM_TP_CD = B.PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("					SELECT '01' TP_CD" ).append("\n"); 
		query.append("                          ,MAX(AMDT_FLG) AMDT_FLG" ).append("\n"); 
		query.append("                          ,DECODE(MIN(AMDT_FLG), 'N', MAX(ACPT_FLG), MIN(ACPT_FLG)) ACPT_FLG" ).append("\n"); 
		query.append("                          ,MAX(DAT_CNT) DAT_CNT" ).append("\n"); 
		query.append("                    FROM   PRI_RP_SCP_AMDT_SMRY A" ).append("\n"); 
		query.append("                          , (SELECT '11' PROP_SCP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("								   ,SVC_SCP_CD" ).append("\n"); 
		query.append("                             FROM   PRI_RP_SCP_DUR" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("							 GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append("							 ) B" ).append("\n"); 
		query.append("                    WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                    AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("					AND    A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND    A.PROP_SCP_TERM_TP_CD = B.PROP_SCP_TERM_TP_CD	" ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("                    SELECT C.PROP_TERM_TP_CD TP_CD" ).append("\n"); 
		query.append("                          ,AMDT_FLG" ).append("\n"); 
		query.append("                          ,ACPT_FLG" ).append("\n"); 
		query.append("                          ,DAT_CNT" ).append("\n"); 
		query.append("                    FROM   PRI_RP_AMDT_SMRY C" ).append("\n"); 
		query.append("                          , (SELECT '01' PROP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_RP_DUR" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             UNION ALL" ).append("\n"); 
		query.append("                             SELECT '05' PROP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_RP_AFIL" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             UNION ALL" ).append("\n"); 
		query.append("                             SELECT '08' PROP_TERM_TP_CD" ).append("\n"); 
		query.append("                                   ,DECODE (COUNT (1), 0, 'N', 'Y') DAT_CNT" ).append("\n"); 
		query.append("                             FROM   PRI_RP_DMDT" ).append("\n"); 
		query.append("                             WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("							) D" ).append("\n"); 
		query.append("                    WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                    AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                    AND    C.PROP_TERM_TP_CD = D.PROP_TERM_TP_CD)" ).append("\n"); 
		query.append("          GROUP BY TP_CD)" ).append("\n"); 

	}
}