/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltPropMnSpotInqVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.26
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2014.09.26 최성환
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

public class RFAProposalMainDBDAORsltPropMnSpotInqVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal & Amendement Inquiry   
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltPropMnSpotInqVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORsltPropMnSpotInqVORSQL").append("\n"); 
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
		query.append("SELECT HDR.RFA_NO" ).append("\n"); 
		query.append("      ,MN.PROP_NO" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ - 1 PRE_AMDT_SEQ" ).append("\n"); 
		query.append("      ,DECODE (DUR.CTRT_EFF_DT ,DUR.CTRT_EXP_DT, '',TO_CHAR (DUR.CTRT_EFF_DT, 'YYYYMMDD') ) CTRT_EFF_DT" ).append("\n"); 
		query.append("      ,DECODE (DUR.CTRT_EFF_DT ,DUR.CTRT_EXP_DT, '',TO_CHAR (DUR.CTRT_EXP_DT, 'YYYYMMDD') ) CTRT_EXP_DT" ).append("\n"); 
		query.append("      ,DECODE (MN.EFF_DT, MN.EXP_DT, '', TO_CHAR (MN.EFF_DT, 'YYYYMMDD')) EFF_DT" ).append("\n"); 
		query.append("      ,DECODE (MN.EFF_DT, MN.EXP_DT, '', TO_CHAR (MN.EXP_DT, 'YYYYMMDD')) EXP_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR (MN.FILE_DT, 'YYYYMMDD') FILE_DT" ).append("\n"); 
		query.append("      ,MN.PROP_STS_CD" ).append("\n"); 
		query.append("      ,STS_CD.INTG_CD_VAL_DP_DESC PROP_STS" ).append("\n"); 
		query.append("      ,MN.PROP_OFC_CD" ).append("\n"); 
		query.append("      ,MN.PROP_SREP_CD" ).append("\n"); 
		query.append("      ,SLS_REP1.SREP_NM PROP_SREP_NM" ).append("\n"); 
		query.append("      ,MN.PROP_APRO_OFC_CD" ).append("\n"); 
		query.append("      ,PROG_USR.USR_NM PROP_APRO_STAFF" ).append("\n"); 
		query.append("      ,TO_CHAR(MN.PROP_APRO_DT, 'YYYYMMDD') PROP_APRO_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("      ,MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("	  ,CUST.CUST_LGL_ENG_NM CTRT_PTY_NM " ).append("\n"); 
		query.append("      ,MN.PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("      ,CUST_TY.INTG_CD_VAL_DESC PRC_CTRT_CUST_TP_NM" ).append("\n"); 
		query.append("      ,MN.CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("      ,SGM1.INTG_CD_VAL_DP_DESC CTRT_CUST_VAL_SGM" ).append("\n"); 
		query.append("	  ,MN.RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("	  ,MN.RESPB_SREP_CD" ).append("\n"); 
		query.append("	  ,SLS_REP2.SREP_NM CTRT_CUST_SREP_NM" ).append("\n"); 
		query.append("      ,MN.TGT_MVC_QTY" ).append("\n"); 
		query.append("	  ,MN.CNTR_LOD_UT_CD" ).append("\n"); 
		query.append("	  ,UT.INTG_CD_VAL_DP_DESC UNIT" ).append("\n"); 
		query.append("      ,MN.SLS_LD_NO" ).append("\n"); 
		query.append("	  ,FREE_TIME.INTG_CD_VAL_DP_DESC DMDT_FT_TP_CD" ).append("\n"); 
		query.append("	  ,PRS_CRNT_CM_AMT" ).append("\n"); 
		query.append("	  ,PRS_ESTM_CM_AMT" ).append("\n"); 
		query.append("      ,MN.RFA_CTRT_TP_CD AS RFA_CTRT_TP_CD" ).append("\n"); 
		query.append("FROM   PRI_RP_MN MN" ).append("\n"); 
		query.append("      ,PRI_RP_HDR HDR" ).append("\n"); 
		query.append("      ,PRI_RP_DUR DUR" ).append("\n"); 
		query.append("      ,COM_INTG_CD_DTL STS_CD" ).append("\n"); 
		query.append("      ,COM_INTG_CD_DTL SGM1" ).append("\n"); 
		query.append("	  ,COM_INTG_CD_DTL UT" ).append("\n"); 
		query.append("	  ,PRI_RP_DMDT DMDT" ).append("\n"); 
		query.append("	  ,COM_INTG_CD_DTL FREE_TIME" ).append("\n"); 
		query.append("      ,MDM_SLS_REP SLS_REP1" ).append("\n"); 
		query.append("      ,MDM_SLS_REP SLS_REP2" ).append("\n"); 
		query.append("      ,COM_INTG_CD_DTL CUST_TY" ).append("\n"); 
		query.append("      ,MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("	  ,(" ).append("\n"); 
		query.append("		SELECT A.PROP_NO" ).append("\n"); 
		query.append("    		  ,A.AMDT_SEQ" ).append("\n"); 
		query.append("      	  	  ,A.PROP_STS_CD" ).append("\n"); 
		query.append("      		  ,B.USR_NM" ).append("\n"); 
		query.append("		FROM   PRI_RP_PROG A" ).append("\n"); 
		query.append("		      ,COM_USER B" ).append("\n"); 
		query.append("		WHERE  A.PROG_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("		AND    PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("	    AND    USE_FLG = 'Y'" ).append("\n"); 
		query.append("		AND    PROP_PROG_SEQ =" ).append("\n"); 
		query.append("          				(SELECT /*+ INDEX_DESC(B XPKPRI_RP_PROG) */ PROP_PROG_SEQ" ).append("\n"); 
		query.append("           				   FROM  PRI_RP_PROG B" ).append("\n"); 
		query.append("           				  WHERE  PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("           					AND  AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("           					AND  PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("							AND  ROWNUM = 1)" ).append("\n"); 
		query.append("		) PROG_USR" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("  SELECT ROUND(" ).append("\n"); 
		query.append("		 SUM(" ).append("\n"); 
		query.append("         CASE" ).append("\n"); 
		query.append("         WHEN SS.AMDT_SEQ = 0 THEN NULL" ).append("\n"); 
		query.append("         ELSE SS.PRS_CRNT_CM_AMT" ).append("\n"); 
		query.append("         END" ).append("\n"); 
		query.append("         )) PRS_CRNT_CM_AMT   ," ).append("\n"); 
		query.append("         ROUND(" ).append("\n"); 
		query.append("		 SUM(" ).append("\n"); 
		query.append("         CASE" ).append("\n"); 
		query.append("    	 WHEN SS.AMDT_SEQ = 0 THEN SS.PRS_ESTM_CM_AMT" ).append("\n"); 
		query.append("    	 ELSE SS.PRS_RMN_CM_AMT" ).append("\n"); 
		query.append("    	 END" ).append("\n"); 
		query.append("    	 )) PRS_ESTM_CM_AMT" ).append("\n"); 
		query.append("FROM  PRI_RP_SCP_MN SS" ).append("\n"); 
		query.append("WHERE SS.PROP_NO   = @[prop_no]" ).append("\n"); 
		query.append("AND   SS.AMDT_SEQ  = @[amdt_seq]" ).append("\n"); 
		query.append(")PRS_CM" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND    HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND    DUR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND    DUR.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND    DMDT.PROP_NO(+) = MN.PROP_NO" ).append("\n"); 
		query.append("AND    DMDT.AMDT_SEQ(+) = MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND    SLS_REP1.SREP_CD(+) = MN.PROP_SREP_CD" ).append("\n"); 
		query.append("AND    SLS_REP2.SREP_CD(+) = MN.RESPB_SREP_CD" ).append("\n"); 
		query.append("AND    STS_CD.INTG_CD_ID = 'CD01722'" ).append("\n"); 
		query.append("AND    STS_CD.INTG_CD_VAL_CTNT = MN.PROP_STS_CD" ).append("\n"); 
		query.append("AND    FREE_TIME.INTG_CD_VAL_CTNT(+) = DMDT.DMDT_FT_TP_CD" ).append("\n"); 
		query.append("AND    FREE_TIME.INTG_CD_ID(+) = 'CD01704'" ).append("\n"); 
		query.append("AND    SGM1.INTG_CD_VAL_CTNT(+) = MN.CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("AND    SGM1.INTG_CD_ID(+) = 'CD00698'" ).append("\n"); 
		query.append("AND    CUST_TY.INTG_CD_ID(+)      = 'CD00697'" ).append("\n"); 
		query.append("AND    CUST.RVIS_CNTR_CUST_TP_CD = CUST_TY.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("AND    CUST.CUST_CNT_CD(+)         = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("AND    CUST.CUST_SEQ(+)            = MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("AND    CUST.DELT_FLG(+)            = 'N'" ).append("\n"); 
		query.append("AND    CUST.CNTR_DIV_FLG(+) 	   = 'Y'" ).append("\n"); 
		query.append("AND    MN.PROP_NO 				= PROG_USR.PROP_NO(+)" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ 				= PROG_USR.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND    UT.INTG_CD_ID(+)         = 'CD00897'" ).append("\n"); 
		query.append("AND UT.INTG_CD_VAL_CTNT(+)         = MN.CNTR_LOD_UT_CD" ).append("\n"); 

	}
}