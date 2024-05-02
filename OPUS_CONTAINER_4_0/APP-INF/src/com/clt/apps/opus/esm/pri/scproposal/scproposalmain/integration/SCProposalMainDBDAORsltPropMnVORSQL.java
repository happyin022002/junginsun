/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCProposalMainDBDAORsltPropMnVORSQL.java
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

public class SCProposalMainDBDAORsltPropMnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltPropMnVO
	  * </pre>
	  */
	public SCProposalMainDBDAORsltPropMnVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltPropMnVORSQL").append("\n"); 
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
		query.append("         , MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("    FROM PRI_SP_MN MN" ).append("\n"); 
		query.append("       , PRI_SP_HDR HDR" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("#if (${sc_no} != '')" ).append("\n"); 
		query.append("    AND   HDR.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("    AND   MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND   MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    GROUP BY MN.PROP_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("    HDR.SC_NO, " ).append("\n"); 
		query.append("    HDR.PRC_MST_PROP_TP_CD," ).append("\n"); 
		query.append("    MN.PROP_NO, " ).append("\n"); 
		query.append("    MN.AMDT_SEQ, " ).append("\n"); 
		query.append("    MN.AMDT_SEQ-1 PRE_AMDT_SEQ," ).append("\n"); 
		query.append("    CASE WHEN DUR.CTRT_EFF_DT = TO_DATE('99991231','YYYYMMDD') AND DUR.CTRT_EXP_DT = TO_DATE('99991231','YYYYMMDD')" ).append("\n"); 
		query.append("         THEN ''" ).append("\n"); 
		query.append("         ELSE TO_CHAR(DUR.CTRT_EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("    END CTRT_EFF_DT," ).append("\n"); 
		query.append("    CASE WHEN DUR.CTRT_EFF_DT = TO_DATE('99991231','YYYYMMDD') AND DUR.CTRT_EXP_DT = TO_DATE('99991231','YYYYMMDD')" ).append("\n"); 
		query.append("         THEN ''" ).append("\n"); 
		query.append("         ELSE TO_CHAR(DUR.CTRT_EXP_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("    END CTRT_EXP_DT," ).append("\n"); 
		query.append("    CASE WHEN MN.EFF_DT = TO_DATE('99991231','YYYYMMDD') AND MN.EXP_DT = TO_DATE('99991231','YYYYMMDD')" ).append("\n"); 
		query.append("         THEN ''" ).append("\n"); 
		query.append("         ELSE TO_CHAR(MN.EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("    END EFF_DT," ).append("\n"); 
		query.append("    CASE WHEN MN.EFF_DT = TO_DATE('99991231','YYYYMMDD') AND MN.EXP_DT = TO_DATE('99991231','YYYYMMDD')" ).append("\n"); 
		query.append("         THEN ''" ).append("\n"); 
		query.append("         ELSE TO_CHAR(MN.EXP_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("    END EXP_DT," ).append("\n"); 
		query.append("    NVL((SELECT CASE WHEN MN.EFF_DT <= N.EXP_DT THEN TO_CHAR(MN.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("                ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                END AS EXP_DT" ).append("\n"); 
		query.append("          FROM PRI_SP_MN N" ).append("\n"); 
		query.append("         WHERE PROP_NO = MN.PROP_NO AND AMDT_SEQ = MN.AMDT_SEQ-1 " ).append("\n"); 
		query.append("       ), TO_CHAR (MN.EFF_DT - 1, 'YYYYMMDD')) PRE_EXP_DT," ).append("\n"); 
		query.append("    NVL((    " ).append("\n"); 
		query.append("    SELECT CASE WHEN MN.EFF_DT <= N.EXP_DT THEN 'Y'" ).append("\n"); 
		query.append("           ELSE 'N'" ).append("\n"); 
		query.append("           END AS EXP_DT" ).append("\n"); 
		query.append("    FROM PRI_SP_MN N" ).append("\n"); 
		query.append("    WHERE PROP_NO = MN.PROP_NO AND AMDT_SEQ = MN.AMDT_SEQ-1" ).append("\n"); 
		query.append("    ),'N') DUR_DUP_FLG," ).append("\n"); 
		query.append("    MN.RF_FLG RF_FLG, " ).append("\n"); 
		query.append("    MN.GAMT_FLG GAMT_FLG, " ).append("\n"); 
		query.append("    MN.PROP_STS_CD, " ).append("\n"); 
		query.append("    STS_CD.INTG_CD_VAL_DP_DESC PROP_STS," ).append("\n"); 
		query.append("    MN.PROP_OFC_CD,  " ).append("\n"); 
		query.append("    MN.PROP_SREP_CD, " ).append("\n"); 
		query.append("    SLS_REP1.SREP_NM PROP_SREP_NM," ).append("\n"); 
		query.append("    MN.PROP_APRO_OFC_CD, " ).append("\n"); 
		query.append("    MN.PROP_APRO_DT, " ).append("\n"); 
		query.append("    TO_CHAR(MN.CRE_DT,'YYYYMMDD') CRE_DT," ).append("\n"); 
		query.append("    TO_CHAR(MN.FILE_DT,'YYYYMMDD') FILE_DT," ).append("\n"); 
		query.append("    PTY.CUST_CNT_CD CUST_CNT_CD, " ).append("\n"); 
		query.append("    PTY.CUST_SEQ CUST_SEQ, " ).append("\n"); 
		query.append("    PTY.CTRT_PTY_NM  CTRT_PTY_NM ," ).append("\n"); 
		query.append("    PTY.CTRT_CUST_VAL_SGM_CD," ).append("\n"); 
		query.append("    SGM1.INTG_CD_VAL_DP_DESC CTRT_CUST_VAL_SGM," ).append("\n"); 
		query.append("    CUST_TP.PRC_CTRT_CUST_TP_CD PRC_CTRT_CUST_TP_CD," ).append("\n"); 
		query.append("    PTY.CTRT_CUST_SLS_OFC_CD, " ).append("\n"); 
		query.append("    PTY.CTRT_CUST_SREP_CD, " ).append("\n"); 
		query.append("    SLS_REP2.SREP_NM CTRT_CUST_SREP_NM," ).append("\n"); 
		query.append("    MN.REAL_CUST_CNT_CD, " ).append("\n"); 
		query.append("    MN.REAL_CUST_SEQ, " ).append("\n"); 
		query.append("    CUST.CUST_LGL_ENG_NM REAL_CUST_NM," ).append("\n"); 
		query.append("    ( SELECT SGM2.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL SGM2, MDM_CUSTOMER M " ).append("\n"); 
		query.append("       WHERE SGM2.INTG_CD_ID = 'CD00698' AND SGM2.INTG_CD_VAL_CTNT = M.VBS_CLSS_CD    " ).append("\n"); 
		query.append("         AND M.CUST_CNT_CD = MN.REAL_CUST_CNT_CD AND M.CUST_SEQ = MN.REAL_CUST_SEQ ) AS REAL_CUST_VAL_SGM," ).append("\n"); 
		query.append("    MN.REAL_CUST_TP_CD, " ).append("\n"); 
		query.append("    MN.REAL_CUST_SLS_OFC_CD, " ).append("\n"); 
		query.append("    MN.REAL_CUST_SREP_CD, " ).append("\n"); 
		query.append("    SLS_REP3.SREP_NM REAL_CUST_SREP_NM," ).append("\n"); 
		query.append("    CASE MN.PROP_STS_CD " ).append("\n"); 
		query.append("        WHEN 'A' THEN MQC.FNL_MQC_QTY" ).append("\n"); 
		query.append("        WHEN 'F' THEN MQC.FNL_MQC_QTY" ).append("\n"); 
		query.append("    ELSE                        " ).append("\n"); 
		query.append("        MQC.PROP_MQC_QTY" ).append("\n"); 
		query.append("    END PROP_MQC_QTY,    " ).append("\n"); 
		query.append("    MQC.CNTR_LOD_UT_CD, " ).append("\n"); 
		query.append("    UT.INTG_CD_VAL_DP_DESC UNIT," ).append("\n"); 
		query.append("    MN.BLPL_HDR_SEQ," ).append("\n"); 
		query.append("    PTY.PRC_CTRT_PTY_TP_CD," ).append("\n"); 
		query.append("    PTY.CTRT_PTY_ADDR," ).append("\n"); 
		query.append("    PTY.CTRT_PTY_SGN_NM," ).append("\n"); 
		query.append("    PTY.CTRT_PTY_SGN_TIT_NM," ).append("\n"); 
		query.append("    DECODE(PROP_OFC_CD, @[ofc_cd],'Y','N')REQ_USR_FLG," ).append("\n"); 
		query.append("    DECODE (USR.USR_CNT, 0, 'N', DECODE(SIGN(AUTH.CNT2),1,'Y','N')) APRO_USR_FLG," ).append("\n"); 
		query.append("	DECODE (USR_MN.USR_CNT_MN, 0, 'N', DECODE(SIGN(AUTH.CNT2),1,'Y','N')) ALL_USR_FLG," ).append("\n"); 
		query.append("	CASE UPPER(M.NVOCC_BD_NO) WHEN 'N/A' THEN ''" ).append("\n"); 
		query.append("							  WHEN 'NONE' THEN ''" ).append("\n"); 
		query.append("	ELSE TRIM(M.NVOCC_BD_NO)" ).append("\n"); 
		query.append("	END OTI_NO," ).append("\n"); 
		query.append("	M.NVOCC_BD_ST_EFF_DT OTI_EFF_DT," ).append("\n"); 
		query.append("	M.NVOCC_BD_END_EFF_DT OTI_EXP_DT," ).append("\n"); 
		query.append("	M.NVOCC_BD_AMT OTI_AMT," ).append("\n"); 
		query.append("	CASE UPPER(M.NVOCC_LIC_NO) WHEN 'N/A' THEN ''" ).append("\n"); 
		query.append("							   WHEN 'NONE' THEN ''" ).append("\n"); 
		query.append("	ELSE TRIM(M.NVOCC_LIC_NO)" ).append("\n"); 
		query.append("	END OTI_LIC_NO," ).append("\n"); 
		query.append("	PROG_USR.USR_NM PROP_APRO_STAFF," ).append("\n"); 
		query.append("	MN.CONV_CFM_FLG," ).append("\n"); 
		query.append("	(SELECT CONV_CFM_FLG " ).append("\n"); 
		query.append("	 FROM PRI_SP_MN " ).append("\n"); 
		query.append("	 WHERE PROP_NO = MN.PROP_NO " ).append("\n"); 
		query.append("	 AND AMDT_SEQ + 1 = MN.AMDT_SEQ) N_CONV_CFM_FLG," ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	SELECT   'Y'" ).append("\n"); 
		query.append("	FROM     PRI_SP_SCP_MN SCP," ).append("\n"); 
		query.append("		     INPUT_PARAMS HDR" ).append("\n"); 
		query.append("	WHERE    SCP.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("    AND 	 SCP.AMDT_SEQ = HDR.AMDT_SEQ" ).append("\n"); 
		query.append("    AND EXISTS (SELECT   SVC_SCP_CD" ).append("\n"); 
		query.append("                 FROM     PRI_SVC_SCP_PPT_MAPG" ).append("\n"); 
		query.append("                 WHERE    SVC_SCP_PPT_CD = 'UFIL'" ).append("\n"); 
		query.append("                 AND SCP.SVC_SCP_CD = SVC_SCP_CD)" ).append("\n"); 
		query.append("	AND ROWNUM = 1" ).append("\n"); 
		query.append("	) OTI_MAP," ).append("\n"); 
		query.append("	TO_CHAR(MN.UPD_DT,'YYYYMMDD-HH24MISS') UPD_DT," ).append("\n"); 
		query.append("    NVL(MN.PRXY_FLG,'N') AS PRXY_FLG," ).append("\n"); 
		query.append("    CTRT_DUR_TP_CD" ).append("\n"); 
		query.append("FROM   PRI_SP_MN MN" ).append("\n"); 
		query.append("     , PRI_SP_HDR HDR" ).append("\n"); 
		query.append("     , PRI_SP_DUR DUR" ).append("\n"); 
		query.append("     , PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("     , PRI_SP_CTRT_CUST_TP CUST_TP" ).append("\n"); 
		query.append("     , PRI_SP_MQC MQC" ).append("\n"); 
		query.append("     , MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("     , COM_INTG_CD_DTL STS_CD" ).append("\n"); 
		query.append("     , COM_INTG_CD_DTL UT      " ).append("\n"); 
		query.append("     , COM_INTG_CD_DTL SGM1" ).append("\n"); 
		query.append("     , MDM_SLS_REP SLS_REP1" ).append("\n"); 
		query.append("     , MDM_SLS_REP SLS_REP2" ).append("\n"); 
		query.append("     , MDM_SLS_REP SLS_REP3" ).append("\n"); 
		query.append("     , INPUT_PARAMS INP" ).append("\n"); 
		query.append("     , MDM_CUSTOMER M" ).append("\n"); 
		query.append("     ,(SELECT B.PROP_NO,B.AMDT_SEQ," ).append("\n"); 
		query.append("           	  COUNT(A.SVC_SCP_CD) CNT2 " ).append("\n"); 
		query.append("       FROM   PRI_AUTHORIZATION A, " ).append("\n"); 
		query.append("           	  PRI_SP_SCP_MN B," ).append("\n"); 
		query.append("			  INPUT_PARAMS HDR " ).append("\n"); 
		query.append("       WHERE " ).append("\n"); 
		query.append("           A.SVC_SCP_CD        = B.SVC_SCP_CD" ).append("\n"); 
		query.append("       AND A.USR_ID            = @[usr_id]" ).append("\n"); 
		query.append("       AND A.PRC_CTRT_TP_CD    = 'S'" ).append("\n"); 
		query.append("	   AND A.EXP_DT > SYSDATE" ).append("\n"); 
		query.append("	   AND HDR.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("       GROUP BY B.PROP_NO,B.AMDT_SEQ" ).append("\n"); 
		query.append("      ) AUTH" ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("	SELECT COUNT (*) USR_CNT" ).append("\n"); 
		query.append("	FROM   DUAL" ).append("\n"); 
		query.append("	WHERE  " ).append("\n"); 
		query.append("#if (${rhq_yn} == 'Y')" ).append("\n"); 
		query.append("	    @[rhq_ofc_cd] IN (" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	    @[ofc_cd] IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        SELECT MN.PROP_APRO_OFC_CD OFC_CD" ).append("\n"); 
		query.append("        FROM   PRI_SP_MN MN, INPUT_PARAMS INP" ).append("\n"); 
		query.append("        WHERE MN.PROP_NO = INP.PROP_NO" ).append("\n"); 
		query.append("        AND MN.AMDT_SEQ = INP.AMDT_SEQ" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT MN.PROP_SCP_APRO_OFC_CD" ).append("\n"); 
		query.append("        FROM   PRI_SP_SCP_MN MN, INPUT_PARAMS INP" ).append("\n"); 
		query.append("        WHERE MN.PROP_NO = INP.PROP_NO" ).append("\n"); 
		query.append("        AND MN.AMDT_SEQ = INP.AMDT_SEQ  " ).append("\n"); 
		query.append("		)                " ).append("\n"); 
		query.append("	)USR " ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("	SELECT COUNT (*) USR_CNT_MN" ).append("\n"); 
		query.append("	FROM   DUAL" ).append("\n"); 
		query.append("	WHERE  " ).append("\n"); 
		query.append("#if (${rhq_yn} == 'Y')" ).append("\n"); 
		query.append("	    @[rhq_ofc_cd] IN (" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	    @[ofc_cd] IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        SELECT MN.PROP_APRO_OFC_CD OFC_CD" ).append("\n"); 
		query.append("        FROM   PRI_SP_MN MN, INPUT_PARAMS INP" ).append("\n"); 
		query.append("        WHERE MN.PROP_NO = INP.PROP_NO" ).append("\n"); 
		query.append("        AND MN.AMDT_SEQ = INP.AMDT_SEQ" ).append("\n"); 
		query.append("		)                " ).append("\n"); 
		query.append("	)USR_MN" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("	SELECT A.PROP_NO" ).append("\n"); 
		query.append("		  ,A.AMDT_SEQ" ).append("\n"); 
		query.append("		  ,A.PROP_STS_CD" ).append("\n"); 
		query.append("		  ,B.USR_NM" ).append("\n"); 
		query.append("	FROM   PRI_SP_PROG A" ).append("\n"); 
		query.append("		  ,COM_USER B" ).append("\n"); 
		query.append("	WHERE  A.PROG_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("	AND    PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("	AND    USE_FLG = 'Y'" ).append("\n"); 
		query.append("	AND    PROP_PROG_SEQ =" ).append("\n"); 
		query.append("						(SELECT /*+ INDEX_DESC(B XPKPRI_SP_PROG)*/ PROP_PROG_SEQ" ).append("\n"); 
		query.append("						 FROM  PRI_SP_PROG B" ).append("\n"); 
		query.append("						 WHERE PROP_NO     = A.PROP_NO" ).append("\n"); 
		query.append("						 AND   AMDT_SEQ    = A.AMDT_SEQ" ).append("\n"); 
		query.append("						 AND   PROP_STS_CD = A.PROP_STS_CD" ).append("\n"); 
		query.append("						 AND   ROWNUM = 1)   " ).append("\n"); 
		query.append(") PROG_USR" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    MN.PROP_NO                    = INP.PROP_NO" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ                   = INP.AMDT_SEQ" ).append("\n"); 
		query.append("AND HDR.PROP_NO                   = MN.PROP_NO" ).append("\n"); 
		query.append("AND DUR.PROP_NO                   = MN.PROP_NO" ).append("\n"); 
		query.append("AND DUR.AMDT_SEQ                  = MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND PTY.PROP_NO                   = MN.PROP_NO" ).append("\n"); 
		query.append("AND PTY.AMDT_SEQ                  = MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND PTY.PRC_CTRT_PTY_TP_CD        = 'C'" ).append("\n"); 
		query.append("AND PTY.CUST_CNT_CD               = M.CUST_CNT_CD" ).append("\n"); 
		query.append("AND PTY.CUST_SEQ                  = M.CUST_SEQ" ).append("\n"); 
		query.append("AND M.CNTR_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("AND CUST_TP.PROP_NO(+)            = PTY.PROP_NO" ).append("\n"); 
		query.append("AND CUST_TP.AMDT_SEQ(+)           = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("AND CUST_TP.PRC_CTRT_PTY_TP_CD(+) = PTY.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("AND SLS_REP1.SREP_CD(+)           = MN.PROP_SREP_CD" ).append("\n"); 
		query.append("AND SLS_REP2.SREP_CD(+)           = PTY.CTRT_CUST_SREP_CD" ).append("\n"); 
		query.append("AND SLS_REP3.SREP_CD(+)           = MN.REAL_CUST_SREP_CD" ).append("\n"); 
		query.append("AND CUST.CUST_CNT_CD(+)           = MN.REAL_CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST.CUST_SEQ(+)              = MN.REAL_CUST_SEQ " ).append("\n"); 
		query.append("AND CUST.CNTR_DIV_FLG(+) = 'Y' " ).append("\n"); 
		query.append("AND STS_CD.INTG_CD_ID             = 'CD01722'" ).append("\n"); 
		query.append("AND STS_CD.INTG_CD_VAL_CTNT       = MN.PROP_STS_CD" ).append("\n"); 
		query.append("AND MQC.PROP_NO                   = MN.PROP_NO" ).append("\n"); 
		query.append("AND MQC.AMDT_SEQ                  = MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND UT.INTG_CD_ID                 = 'CD00897'" ).append("\n"); 
		query.append("AND UT.INTG_CD_VAL_CTNT           = MQC.CNTR_LOD_UT_CD" ).append("\n"); 
		query.append("AND SGM1.INTG_CD_ID(+)            = 'CD00698'" ).append("\n"); 
		query.append("AND SGM1.INTG_CD_VAL_CTNT(+)      = PTY.CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("AND AUTH.PROP_NO(+)               = INP.PROP_NO" ).append("\n"); 
		query.append("AND AUTH.AMDT_SEQ(+)              = INP.AMDT_SEQ" ).append("\n"); 
		query.append("AND MN.PROP_NO 					  = PROG_USR.PROP_NO(+)" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ					  = PROG_USR.AMDT_SEQ(+)" ).append("\n"); 

	}
}