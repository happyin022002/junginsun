/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltPriRpInqVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAORsltPriRpInqVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RSQL.Query
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltPriRpInqVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sprop_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sprop_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sprop_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sprop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("strf_ctrt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ssvc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORsltPriRpInqVORSQL").append("\n"); 
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
		query.append("#if (${ssvc_scp_cd} != '')" ).append("\n"); 
		query.append("SELECT /*+ ORDERED USE_HASH(SCP MN CUST) */" ).append("\n"); 
		query.append("	   MN.RFA_NO" ).append("\n"); 
		query.append("	  ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("	  ,MN.PROP_NO " ).append("\n"); 
		query.append("	  ,CUST.CUST_LGL_ENG_NM CTRT_PTY_NM" ).append("\n"); 
		query.append("      ,(SELECT CUST_TP.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL CUST_TP" ).append("\n"); 
		query.append("        WHERE CUST_TP.INTG_CD_ID = 'CD00697'" ).append("\n"); 
		query.append("        AND CUST_TP.INTG_CD_VAL_CTNT = CUST.CNTR_CUST_TP_CD " ).append("\n"); 
		query.append("	   ) CUST_TP_NM" ).append("\n"); 
		query.append("	  ,MN.PROP_OFC_CD" ).append("\n"); 
		query.append("	  ,MN.PROP_SREP_CD" ).append("\n"); 
		query.append("	  ,TO_CHAR(MN.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(MN.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(MN.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("      ,(SELECT STS.INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL STS" ).append("\n"); 
		query.append("        WHERE STS.INTG_CD_ID = 'CD01722'" ).append("\n"); 
		query.append("        AND MN.PROP_STS_CD = STS.INTG_CD_VAL_CTNT ) PROP_STS_NM" ).append("\n"); 
		query.append("      , MN.TRF_CTRT_FLG " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("       ( SELECT ROWNUM, PROP_NO, AMDT_SEQ" ).append("\n"); 
		query.append("             FROM ( SELECT /*+ INDEX_FFS(SCP XPKPRI_RP_SCP_MN) */" ).append("\n"); 
		query.append("                            PROP_NO, AMDT_SEQ" ).append("\n"); 
		query.append("                           ,ROW_NUMBER() OVER(PARTITION BY PROP_NO ORDER BY AMDT_SEQ DESC) AMDT_SEQ_FILTER" ).append("\n"); 
		query.append("                      FROM PRI_RP_SCP_MN SCP" ).append("\n"); 
		query.append("                     WHERE SVC_SCP_CD = @[ssvc_scp_cd]" ).append("\n"); 
		query.append("#if (${sprop_no} != '')" ).append("\n"); 
		query.append("				     AND SCP.PROP_NO = @[sprop_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  ) SCP" ).append("\n"); 
		query.append("            WHERE SCP.AMDT_SEQ_FILTER = 1" ).append("\n"); 
		query.append("       ) SCP" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT  /*+ ORDERED USE_HASH(HDR MN) */" ).append("\n"); 
		query.append("                ROWNUM, HDR.RFA_NO, MN.AMDT_SEQ, MN.PROP_NO" ).append("\n"); 
		query.append("               ,MN.PROP_OFC_CD, MN.PROP_SREP_CD, PROP_STS_CD" ).append("\n"); 
		query.append("               ,MN.CTRT_CUST_CNT_CD, MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("               ,MN.CRE_DT" ).append("\n"); 
		query.append("               ,MN.EFF_DT" ).append("\n"); 
		query.append("               ,MN.EXP_DT" ).append("\n"); 
		query.append("               ,MN.TRF_CTRT_FLG" ).append("\n"); 
		query.append("          FROM PRI_RP_HDR HDR" ).append("\n"); 
		query.append("               , PRI_RP_MN MN" ).append("\n"); 
		query.append("         WHERE HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("#if (${srfa_no} != '')" ).append("\n"); 
		query.append("		 AND HDR.RFA_NO = @[srfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprop_no} != '')" ).append("\n"); 
		query.append("		AND MN.PROP_NO = @[sprop_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) MN" ).append("\n"); 
		query.append("	 ,MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    MN.PROP_NO = SCP.PROP_NO" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = SCP.AMDT_SEQ" ).append("\n"); 
		query.append("AND MN.CTRT_CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("AND MN.CTRT_CUST_SEQ    = CUST.CUST_SEQ" ).append("\n"); 
		query.append("AND CUST.DELT_FLG		= 'N'" ).append("\n"); 
		query.append("AND CNTR_DIV_FLG 		= 'Y' " ).append("\n"); 
		query.append("#if (${sprop_ofc_cd} != '')" ).append("\n"); 
		query.append("AND MN.PROP_OFC_CD = @[sprop_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprop_srep_cd} != '')" ).append("\n"); 
		query.append("AND MN.PROP_SREP_CD = @[sprop_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${seff_dt} != '')" ).append("\n"); 
		query.append("AND TO_DATE(@[seff_dt],'yyyy-MM-dd') BETWEEN MN.EFF_DT AND MN.EXP_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprop_sts_cd} != '')" ).append("\n"); 
		query.append("AND MN.PROP_STS_CD = @[sprop_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scust_cnt_cd} != '' && ${scust_seq} != '')" ).append("\n"); 
		query.append("AND MN.CTRT_CUST_CNT_CD = @[scust_cnt_cd]" ).append("\n"); 
		query.append("AND MN.CTRT_CUST_SEQ = @[scust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${strf_ctrt_flg} != '')" ).append("\n"); 
		query.append("AND MN.TRF_CTRT_FLG = @[strf_ctrt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY MN.RFA_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT HDR.RFA_NO" ).append("\n"); 
		query.append("	  ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("	  ,MN.PROP_NO " ).append("\n"); 
		query.append("	  ,CUST.CUST_LGL_ENG_NM CTRT_PTY_NM" ).append("\n"); 
		query.append("	  ,CUST_TP.INTG_CD_VAL_DP_DESC CUST_TP_NM" ).append("\n"); 
		query.append("	  ,MN.PROP_OFC_CD" ).append("\n"); 
		query.append("	  ,MN.PROP_SREP_CD" ).append("\n"); 
		query.append("	  ,TO_CHAR(MN.CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(MN.EFF_DT,'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(MN.EXP_DT,'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("	  ,STS.INTG_CD_VAL_DP_DESC PROP_STS_NM" ).append("\n"); 
		query.append("      ,MN.TRF_CTRT_FLG" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("	,COM_INTG_CD_DTL CUST_TP" ).append("\n"); 
		query.append("	,COM_INTG_CD_DTL STS" ).append("\n"); 
		query.append("	,PRI_RP_MN MN" ).append("\n"); 
		query.append("	,PRI_RP_HDR HDR" ).append("\n"); 
		query.append("WHERE MN.CTRT_CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("AND MN.CTRT_CUST_SEQ    = CUST.CUST_SEQ" ).append("\n"); 
		query.append("AND CUST.DELT_FLG		= 'N'" ).append("\n"); 
		query.append("AND CNTR_DIV_FLG 		= 'Y' " ).append("\n"); 
		query.append("AND CUST_TP.INTG_CD_ID  = 'CD00697'" ).append("\n"); 
		query.append("AND CUST_TP.INTG_CD_VAL_CTNT    = CUST.CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("AND MN.PROP_STS_CD 		= STS.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND STS.INTG_CD_ID 		= 'CD01722'" ).append("\n"); 
		query.append("AND HDR.PROP_NO 	 	= MN.PROP_NO" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = ( SELECT /*+ INDEX_DESC(A XPKPRI_RP_MN)*/ AMDT_SEQ FROM PRI_RP_MN A WHERE MN.PROP_NO = PROP_NO AND ROWNUM = 1)" ).append("\n"); 
		query.append("#if (${srfa_no} != '')" ).append("\n"); 
		query.append("AND HDR.RFA_NO = @[srfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprop_no} != '')" ).append("\n"); 
		query.append("AND HDR.PROP_NO = @[sprop_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprop_ofc_cd} != '')" ).append("\n"); 
		query.append("AND MN.PROP_OFC_CD = @[sprop_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprop_srep_cd} != '')" ).append("\n"); 
		query.append("AND MN.PROP_SREP_CD = @[sprop_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${seff_dt} != '')" ).append("\n"); 
		query.append("AND TO_DATE(@[seff_dt],'yyyy-MM-dd') BETWEEN MN.EFF_DT AND MN.EXP_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprop_sts_cd} != '')" ).append("\n"); 
		query.append("AND MN.PROP_STS_CD = @[sprop_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scust_cnt_cd} != '' && ${scust_seq} != '')" ).append("\n"); 
		query.append("AND MN.CTRT_CUST_CNT_CD = @[scust_cnt_cd]" ).append("\n"); 
		query.append("AND MN.CTRT_CUST_SEQ = @[scust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${strf_ctrt_flg} != '')" ).append("\n"); 
		query.append("AND MN.TRF_CTRT_FLG = @[strf_ctrt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY HDR.RFA_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}