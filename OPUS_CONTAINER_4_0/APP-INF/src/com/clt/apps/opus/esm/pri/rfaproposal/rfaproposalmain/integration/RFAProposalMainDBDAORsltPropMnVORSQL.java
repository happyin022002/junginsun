/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltPropMnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.31
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2016.01.31 CHLOE MIJIN SEO
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

public class RFAProposalMainDBDAORsltPropMnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 승인권자, 대표 승인권자 같음
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltPropMnVORSQL(){
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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORsltPropMnVORSQL").append("\n"); 
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
		query.append("    FROM PRI_RP_MN MN" ).append("\n"); 
		query.append("       , PRI_RP_HDR HDR" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("#if (${rfa_no} != '')" ).append("\n"); 
		query.append("    AND   HDR.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("    AND   MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND   MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    GROUP BY MN.PROP_NO" ).append("\n"); 
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
		query.append("       END EFF_DT" ).append("\n"); 
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
		query.append("	  ,TO_CHAR (MN.FILE_DT, 'YYYYMMDD') FILE_DT" ).append("\n"); 
		query.append("      ,MN.PROP_STS_CD" ).append("\n"); 
		query.append("      ,STS_CD.INTG_CD_VAL_DP_DESC PROP_STS" ).append("\n"); 
		query.append("      ,MN.PROP_OFC_CD" ).append("\n"); 
		query.append("      ,MN.PROP_SREP_CD" ).append("\n"); 
		query.append("      ,SLS_REP1.SREP_NM PROP_SREP_NM" ).append("\n"); 
		query.append("      ,MN.PROP_APRO_OFC_CD" ).append("\n"); 
		query.append("      ,DECODE(MN.PROP_STS_CD,'A',PROG_USR.USR_NM,NULL) PROP_APRO_STAFF" ).append("\n"); 
		query.append("      ,TO_CHAR(MN.PROP_APRO_DT, 'YYYYMMDD') PROP_APRO_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("      ,MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("	  ,CUST.CUST_LGL_ENG_NM CTRT_PTY_NM " ).append("\n"); 
		query.append("      ,MN.PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("      ,CUST_TY.INTG_CD_VAL_DESC PRC_CTRT_CUST_TP_NM" ).append("\n"); 
		query.append("      ,CUST.VBS_CLSS_CD CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("      ,SGM1.INTG_CD_VAL_DP_DESC CTRT_CUST_VAL_SGM" ).append("\n"); 
		query.append("	  ,MN.RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("	  ,MN.RESPB_SREP_CD" ).append("\n"); 
		query.append("	  ,SLS_REP2.SREP_NM CTRT_CUST_SREP_NM" ).append("\n"); 
		query.append("      ,MN.TGT_MVC_QTY" ).append("\n"); 
		query.append("	  ,MN.CNTR_LOD_UT_CD" ).append("\n"); 
		query.append("      ,'' SLS_LD_NO" ).append("\n"); 
		query.append("	  ,DECODE(PROP_OFC_CD, @[ofc_cd],'Y','N') REQ_USR_FLG" ).append("\n"); 
		query.append("      --,DECODE (SIGN(AUTH.CNT2), 1, 'Y', 'N') APRO_USR_FLG" ).append("\n"); 
		query.append("      --,DECODE (SCP_MN.CNT1, AUTH.CNT2, 'Y', 'N') ALL_USR_FLG" ).append("\n"); 
		query.append("	  ,DMDT.DMDT_FT_TP_CD" ).append("\n"); 
		query.append("	,CASE MN.PROP_STS_CD" ).append("\n"); 
		query.append("		  WHEN 'I' THEN DECODE (SIGN(AUTH.CNT2), 1, 'Y', 'N')" ).append("\n"); 
		query.append("		  ELSE" ).append("\n"); 
		query.append("			  CASE NVL(PROG.SO_KUP,'N')" ).append("\n"); 
		query.append("				WHEN 'N' THEN DECODE (SIGN(AUTH.CNT2), 1, 'Y', 'N')" ).append("\n"); 
		query.append("				WHEN 'Y' THEN" ).append("\n"); 
		query.append("					CASE NVL(OFC_AUTH,'N')" ).append("\n"); 
		query.append("					WHEN 'Y' THEN DECODE (SIGN(AUTH.CNT2), 1, 'Y', 'N')" ).append("\n"); 
		query.append("					ELSE 'N'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				END " ).append("\n"); 
		query.append("		  END APRO_USR_FLG" ).append("\n"); 
		query.append("	,CASE MN.PROP_STS_CD" ).append("\n"); 
		query.append("		  WHEN 'I' THEN DECODE (SIGN(AUTH.CNT2),1, 'Y', 'N')" ).append("\n"); 
		query.append("		  ELSE" ).append("\n"); 
		query.append("			 CASE NVL(PROG.SO_KUP,'N')" ).append("\n"); 
		query.append("				WHEN 'N' THEN DECODE (SIGN(AUTH.CNT2),1, 'Y', 'N')" ).append("\n"); 
		query.append("				WHEN 'Y' THEN" ).append("\n"); 
		query.append("					CASE NVL(OFC_AUTH,'N')" ).append("\n"); 
		query.append("					WHEN 'Y' THEN DECODE (SIGN(AUTH.CNT2),1, 'Y', 'N')" ).append("\n"); 
		query.append("					ELSE 'N'" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("		     END" ).append("\n"); 
		query.append("		  END ALL_USR_FLG" ).append("\n"); 
		query.append("	,NVL(SO_KUP, 'N') SO_KUP" ).append("\n"); 
		query.append("	,DECODE(SIGN(AUTH.CNT2), 1, 'Y' , 'N') COPY_AUTH" ).append("\n"); 
		query.append("	,DECODE (SIGN(AUTH.CNT2), 1, 'Y', 'N') APRO_USR_FLG_ORI" ).append("\n"); 
		query.append("	,0 PRS_CRNT_CM_AMT" ).append("\n"); 
		query.append("	,0 PRS_ESTM_CM_AMT" ).append("\n"); 
		query.append("	,(SELECT PRC_PROP_CRE_TP_CD FROM PRI_RP_HDR WHERE MN.PROP_NO= PROP_NO) CRE_TP" ).append("\n"); 
		query.append("	, TO_CHAR(MN.UPD_DT,'YYYYMMDD-HH24MISS') UPD_DT" ).append("\n"); 
		query.append("    , MN.TRF_CTRT_FLG " ).append("\n"); 
		query.append("    , MN.CTRT_DUR_TP_CD" ).append("\n"); 
		query.append("FROM   PRI_RP_MN MN" ).append("\n"); 
		query.append("      ,PRI_RP_HDR HDR" ).append("\n"); 
		query.append("      ,PRI_RP_DUR DUR" ).append("\n"); 
		query.append("	  ,PRI_RP_DMDT DMDT" ).append("\n"); 
		query.append("      ,COM_INTG_CD_DTL STS_CD" ).append("\n"); 
		query.append("      ,COM_INTG_CD_DTL SGM1" ).append("\n"); 
		query.append("      ,MDM_SLS_REP SLS_REP1" ).append("\n"); 
		query.append("      ,MDM_SLS_REP SLS_REP2" ).append("\n"); 
		query.append("      ,COM_INTG_CD_DTL CUST_TY" ).append("\n"); 
		query.append("      ,MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("      ,INPUT_PARAMS INP" ).append("\n"); 
		query.append("      , (SELECT   B.PROP_NO" ).append("\n"); 
		query.append("                 ,B.AMDT_SEQ" ).append("\n"); 
		query.append("                 ,COUNT (A.SVC_SCP_CD) CNT2" ).append("\n"); 
		query.append("         FROM     PRI_AUTHORIZATION A" ).append("\n"); 
		query.append("                 ,PRI_RP_SCP_MN B" ).append("\n"); 
		query.append("				 ,INPUT_PARAMS HDR" ).append("\n"); 
		query.append("         WHERE    A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("         AND      A.USR_ID =  @[usr_id]" ).append("\n"); 
		query.append("         AND      A.PRC_CTRT_TP_CD = 'R'" ).append("\n"); 
		query.append("		 AND      A.EXP_DT > SYSDATE" ).append("\n"); 
		query.append("		 AND      HDR.PROP_NO = B.PROP_NO" ).append("\n"); 
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
		query.append("        WHERE INP.PROP_NO= A.PROP_NO     " ).append("\n"); 
		query.append("	    AND   INP.AMDT_SEQ = A.AMDT_SEQ " ).append("\n"); 
		query.append("        AND    A.PROG_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("		AND    PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("	    AND    USE_FLG = 'Y'" ).append("\n"); 
		query.append("		AND    PROP_PROG_SEQ =" ).append("\n"); 
		query.append("          				(SELECT  /*+ INDEX_DESC(A XPKPRI_RP_PROG) */ (PROP_PROG_SEQ)" ).append("\n"); 
		query.append("           				   FROM  PRI_RP_PROG" ).append("\n"); 
		query.append("           				  WHERE  PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("           					AND  AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("           					AND  PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("							AND ROWNUM = 1)" ).append("\n"); 
		query.append("		) PROG_USR" ).append("\n"); 
		query.append("   ,(" ).append("\n"); 
		query.append("	SELECT /*+ INDEX_DESC(A XPKPRI_RP_PROG) */ " ).append("\n"); 
		query.append("		   DECODE(AMDT.AMDT_FLG,'N','N',(" ).append("\n"); 
		query.append("		   DECODE(SIGN(TRUNC((SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC(COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC(), A.CRE_DT, @[ofc_cd] ) FROM DUAL)) - TRUNC(A.EFF_DT)),1,'Y','N'))) SO_KUP" ).append("\n"); 
		query.append("		  ,A.PROP_NO" ).append("\n"); 
		query.append("		  ,DECODE ( ( SELECT OFC_CD FROM TABLE( COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000002','PRI')) WHERE OFC_CD = @[ofc_cd] ), @[ofc_cd],'Y','N' ) AS OFC_AUTH" ).append("\n"); 
		query.append("/*		  " ).append("\n"); 
		query.append("		   특정 OFFICE 코드 에만 주어진 권한 설정 부분을 COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC 함수를 이용하여 변경" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("    FROM PRI_RP_MN A" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("		 SELECT INP.PROP_NO" ).append("\n"); 
		query.append("                ,INP.AMDT_SEQ" ).append("\n"); 
		query.append("                ,MAX(DECODE(RT.AMDT_SEQ,N1ST_CMNC_AMDT_SEQ,'Y','N')) AMDT_FLG" ).append("\n"); 
		query.append("          FROM  INPUT_PARAMS INP" ).append("\n"); 
		query.append("               ,PRI_RP_SCP_RT RT" ).append("\n"); 
		query.append("          WHERE INP.PROP_NO = RT.PROP_NO" ).append("\n"); 
		query.append("          AND   INP.AMDT_SEQ = RT.AMDT_SEQ" ).append("\n"); 
		query.append("          GROUP BY INP.PROP_NO,INP.AMDT_SEQ" ).append("\n"); 
		query.append("          ) AMDT" ).append("\n"); 
		query.append("    WHERE A.PROP_NO = AMDT.PROP_NO" ).append("\n"); 
		query.append("    AND A.AMDT_SEQ = AMDT.AMDT_SEQ" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("	)PROG" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = INP.PROP_NO" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = INP.AMDT_SEQ" ).append("\n"); 
		query.append("AND    HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND    DUR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND    DUR.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND    SLS_REP1.SREP_CD(+) = MN.PROP_SREP_CD" ).append("\n"); 
		query.append("AND    SLS_REP2.SREP_CD(+) = MN.RESPB_SREP_CD" ).append("\n"); 
		query.append("AND    STS_CD.INTG_CD_ID = 'CD01722'" ).append("\n"); 
		query.append("AND    STS_CD.INTG_CD_VAL_CTNT = MN.PROP_STS_CD" ).append("\n"); 
		query.append("AND    DMDT.PROP_NO(+) = MN.PROP_NO" ).append("\n"); 
		query.append("AND    DMDT.AMDT_SEQ(+) = MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND    SGM1.INTG_CD_ID(+) = 'CD00698'" ).append("\n"); 
		query.append("AND    SGM1.INTG_CD_VAL_CTNT(+) = CUST.VBS_CLSS_CD" ).append("\n"); 
		query.append("AND    AUTH.PROP_NO(+) = INP.PROP_NO" ).append("\n"); 
		query.append("AND    AUTH.AMDT_SEQ(+) = INP.AMDT_SEQ" ).append("\n"); 
		query.append("AND    CUST_TY.INTG_CD_ID(+)      = 'CD00697'" ).append("\n"); 
		query.append("AND    MN.PRC_CTRT_CUST_TP_CD = CUST_TY.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("AND    CUST.CUST_CNT_CD        = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("AND    CUST.CUST_SEQ           = MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("AND    CUST.CNTR_DIV_FLG 	   = 'Y' " ).append("\n"); 
		query.append("AND    MN.PROP_NO 			   = PROG_USR.PROP_NO(+)" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ             = PROG_USR.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND    MN.PROP_NO 			   = PROG.PROP_NO(+)" ).append("\n"); 

	}
}