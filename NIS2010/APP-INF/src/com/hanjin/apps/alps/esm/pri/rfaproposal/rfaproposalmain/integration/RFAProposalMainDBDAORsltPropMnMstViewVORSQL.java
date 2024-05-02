/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltPropMnMstViewVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.26
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2016.05.26 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAORsltPropMnMstViewVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAProposalMainDBDAORsltPropMnMstViewVORSQL.Query
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltPropMnMstViewVORSQL(){
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
		params.put("org_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORsltPropMnMstViewVORSQL").append("\n"); 
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
		query.append("WITH INPUT_PARAMS AS (" ).append("\n"); 
		query.append("    SELECT MN.PROP_NO" ).append("\n"); 
		query.append("         , MN.AMDT_SEQ" ).append("\n"); 
		query.append("    FROM PRI_RP_MN MN" ).append("\n"); 
		query.append("       , PRI_RP_HDR HDR" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND   MN.RFA_CTRT_TP_CD = 'M'" ).append("\n"); 
		query.append("    AND   HDR.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("    AND   MN.AMDT_SEQ = @[org_amdt_seq]" ).append("\n"); 
		query.append("    AND   HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT HDR.RFA_NO" ).append("\n"); 
		query.append("      ,MN.PROP_NO" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ - 1 PRE_AMDT_SEQ" ).append("\n"); 
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
		query.append("       END EFF_DT -- Display" ).append("\n"); 
		query.append("      ,CASE WHEN MN.EFF_DT = TO_DATE('99991231','YYYYMMDD') AND MN.EXP_DT = TO_DATE('99991231','YYYYMMDD')" ).append("\n"); 
		query.append("            THEN ''" ).append("\n"); 
		query.append("            ELSE TO_CHAR(MN.EXP_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("       END EXP_DT" ).append("\n"); 
		query.append("      --,TO_CHAR (MN.EFF_DT - 1, 'YYYYMMDD') PRE_EXP_DT" ).append("\n"); 
		query.append("      ,NVL((SELECT CASE WHEN MN.EFF_DT <= N.EXP_DT THEN TO_CHAR(MN.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("               ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                END AS EXP_DT" ).append("\n"); 
		query.append("          FROM PRI_RP_MN N" ).append("\n"); 
		query.append("         WHERE PROP_NO = MN.PROP_NO AND AMDT_SEQ = MN.AMDT_SEQ-1 " ).append("\n"); 
		query.append("       ), TO_CHAR (MN.EFF_DT - 1, 'YYYYMMDD')) PRE_EXP_DT" ).append("\n"); 
		query.append("      ,NVL((    " ).append("\n"); 
		query.append("        SELECT CASE WHEN MN.EFF_DT <= N.EXP_DT THEN 'Y'" ).append("\n"); 
		query.append("               ELSE 'N'" ).append("\n"); 
		query.append("               END AS EXP_DT" ).append("\n"); 
		query.append("          FROM PRI_RP_MN N" ).append("\n"); 
		query.append("         WHERE PROP_NO = MN.PROP_NO AND AMDT_SEQ = MN.AMDT_SEQ-1" ).append("\n"); 
		query.append("        ),'N') DUR_DUP_FLG" ).append("\n"); 
		query.append("      ,TO_CHAR(MN.FILE_DT, 'YYYYMMDD') FILE_DT" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT SVC_SCP_CD FROM PRI_RP_SCP_MN" ).append("\n"); 
		query.append("         WHERE PROP_NO = INP.PROP_NO" ).append("\n"); 
		query.append("           AND AMDT_SEQ = INP.AMDT_SEQ" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("      ) AS SVC_SCP_CD" ).append("\n"); 
		query.append("      ,MN.PROP_STS_CD" ).append("\n"); 
		query.append("      ,STS_CD.INTG_CD_VAL_DP_DESC PROP_STS" ).append("\n"); 
		query.append("      ,MN.PROP_OFC_CD" ).append("\n"); 
		query.append("      ,MN.PROP_SREP_CD" ).append("\n"); 
		query.append("      ,REQ_USR.USR_NM AS REQ_USR_NM" ).append("\n"); 
		query.append("      ,REQ_USR.USR_ID AS REQ_USR_ID" ).append("\n"); 
		query.append("	  ,MN.PROP_USR_ID -- Request Staff" ).append("\n"); 
		query.append("      , (SELECT USR_NM FROM COM_USER WHERE USR_ID = MN.PROP_USR_ID AND USE_FLG = 'Y' AND ROWNUM = 1) PROP_USR_NM" ).append("\n"); 
		query.append("	  ,MN.PROP_APRO_OFC_CD" ).append("\n"); 
		query.append("      ,PROG_USR.USR_NM PROP_APRO_STAFF" ).append("\n"); 
		query.append("      ,TO_CHAR(MN.PROP_APRO_DT, 'YYYYMMDD') PROP_APRO_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("      ,DECODE(@[usr_id],'','N',DECODE(PROP_OFC_CD, @[ofc_cd],'Y','N')) REQ_USR_FLG" ).append("\n"); 
		query.append("      ,DECODE (SIGN(AUTH.CNT2), 1, 'Y', 'N') AS APRO_USR_FLG" ).append("\n"); 
		query.append("      ,DECODE (SIGN(AUTH.CNT2), 1, 'Y', 'N') AS ALL_USR_FLG" ).append("\n"); 
		query.append("      ,NVL((" ).append("\n"); 
		query.append("		   SELECT 'Y'" ).append("\n"); 
		query.append("			 FROM COM_USER A" ).append("\n"); 
		query.append("				, MDM_SLS_REP B" ).append("\n"); 
		query.append("				, COM_USR_ROLE_MTCH C" ).append("\n"); 
		query.append("			WHERE A.USR_ID = B.EMPE_CD" ).append("\n"); 
		query.append("			  AND A.USR_ID = C.USR_ID" ).append("\n"); 
		query.append("			  AND A.USE_FLG = 'Y'" ).append("\n"); 
		query.append("			  AND B.SREP_STS_CD = 'N'" ).append("\n"); 
		query.append("			  AND C.USR_ROLE_CD = 'PRI02'" ).append("\n"); 
		query.append("			  AND A.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("			AND ROWNUM = 1 " ).append("\n"); 
		query.append("        ), 'N') AS COPY_AUTH" ).append("\n"); 
		query.append("      ,(SELECT PRC_PROP_CRE_TP_CD FROM PRI_RP_HDR WHERE MN.PROP_NO= PROP_NO) CRE_TP" ).append("\n"); 
		query.append("      ,TO_CHAR(MN.UPD_DT,'YYYYMMDD-HH24MISS') UPD_DT" ).append("\n"); 
		query.append("      ,MN.RFA_CTRT_TP_CD" ).append("\n"); 
		query.append("FROM   PRI_RP_MN MN" ).append("\n"); 
		query.append("      ,PRI_RP_HDR HDR" ).append("\n"); 
		query.append("      ,PRI_RP_DUR DUR" ).append("\n"); 
		query.append("      ,COM_INTG_CD_DTL STS_CD" ).append("\n"); 
		query.append("      ,INPUT_PARAMS INP" ).append("\n"); 
		query.append("      , (SELECT   B.PROP_NO" ).append("\n"); 
		query.append("                 ,B.AMDT_SEQ" ).append("\n"); 
		query.append("                 ,COUNT (A.SVC_SCP_CD) CNT2" ).append("\n"); 
		query.append("         FROM     PRI_AUTHORIZATION A" ).append("\n"); 
		query.append("                 ,PRI_RP_SCP_MN B" ).append("\n"); 
		query.append("                 ,INPUT_PARAMS HDR" ).append("\n"); 
		query.append("         WHERE    A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("         AND      A.USR_ID =  @[usr_id]" ).append("\n"); 
		query.append("         AND      A.PRC_CTRT_TP_CD = 'R'" ).append("\n"); 
		query.append("         AND      A.EXP_DT > SYSDATE" ).append("\n"); 
		query.append("         AND      HDR.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("         GROUP BY B.PROP_NO" ).append("\n"); 
		query.append("                 ,B.AMDT_SEQ) AUTH" ).append("\n"); 
		query.append("	  ,(" ).append("\n"); 
		query.append("		SELECT A.PROP_NO" ).append("\n"); 
		query.append("    		  ,A.AMDT_SEQ" ).append("\n"); 
		query.append("      	  	  ,A.PROP_STS_CD" ).append("\n"); 
		query.append("      		  ,B.USR_NM" ).append("\n"); 
		query.append("		FROM   PRI_RP_PROG A" ).append("\n"); 
		query.append("		      ,COM_USER B" ).append("\n"); 
		query.append("		      ,INPUT_PARAMS INP" ).append("\n"); 
		query.append("        WHERE  INP.PROP_NO= A.PROP_NO     " ).append("\n"); 
		query.append("        AND    INP.AMDT_SEQ = A.AMDT_SEQ " ).append("\n"); 
		query.append("        AND    A.PROG_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("        AND    PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("        AND    USE_FLG = 'Y'" ).append("\n"); 
		query.append("        AND    PROP_PROG_SEQ =" ).append("\n"); 
		query.append("          				(SELECT  /*+ INDEX_DESC(A XPKPRI_RP_PROG) */ (PROP_PROG_SEQ)" ).append("\n"); 
		query.append("           				   FROM  PRI_RP_PROG" ).append("\n"); 
		query.append("           				  WHERE  PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("           					AND  AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("           					AND  PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("							AND ROWNUM = 1)" ).append("\n"); 
		query.append("		) PROG_USR" ).append("\n"); 
		query.append("	  ,(" ).append("\n"); 
		query.append("		SELECT A.PROP_NO" ).append("\n"); 
		query.append("    		  ,A.AMDT_SEQ" ).append("\n"); 
		query.append("      	  	  ,A.PROP_STS_CD" ).append("\n"); 
		query.append("      		  ,B.USR_NM" ).append("\n"); 
		query.append("              ,B.USR_ID" ).append("\n"); 
		query.append("		FROM   PRI_RP_PROG A" ).append("\n"); 
		query.append("		      ,COM_USER B" ).append("\n"); 
		query.append("		      ,INPUT_PARAMS INP" ).append("\n"); 
		query.append("        WHERE  INP.PROP_NO= A.PROP_NO     " ).append("\n"); 
		query.append("        AND    INP.AMDT_SEQ = A.AMDT_SEQ " ).append("\n"); 
		query.append("        AND    A.PROG_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("        AND    PROP_STS_CD = 'I'" ).append("\n"); 
		query.append("        AND    USE_FLG = 'Y'" ).append("\n"); 
		query.append("        AND    PROP_PROG_SEQ =" ).append("\n"); 
		query.append("          				(SELECT  /*+ INDEX_DESC(A XPKPRI_RP_PROG) */ (PROP_PROG_SEQ)" ).append("\n"); 
		query.append("           				   FROM  PRI_RP_PROG" ).append("\n"); 
		query.append("           				  WHERE  PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("           					AND  AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("           					AND  PROP_STS_CD = 'I'" ).append("\n"); 
		query.append("							AND ROWNUM = 1)" ).append("\n"); 
		query.append("		) REQ_USR" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = INP.PROP_NO" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = INP.AMDT_SEQ" ).append("\n"); 
		query.append("AND    HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND    DUR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND    DUR.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND    STS_CD.INTG_CD_ID = 'CD01722'" ).append("\n"); 
		query.append("AND    STS_CD.INTG_CD_VAL_CTNT = MN.PROP_STS_CD" ).append("\n"); 
		query.append("AND    AUTH.PROP_NO(+) = INP.PROP_NO" ).append("\n"); 
		query.append("AND    AUTH.AMDT_SEQ(+) = INP.AMDT_SEQ" ).append("\n"); 
		query.append("AND    MN.PROP_NO 			   = PROG_USR.PROP_NO(+)" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ             = PROG_USR.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND    MN.PROP_NO 			   = REQ_USR.PROP_NO(+)" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ             = REQ_USR.AMDT_SEQ(+)" ).append("\n"); 

	}
}