/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltPriRpSpotInqVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17 
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

public class RFAProposalMainDBDAORsltPriRpSpotInqVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2015.08.13 [CHM-201537109] Split19-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltPriRpSpotInqVORSQL(){
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
		params.put("srfa_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("retro_active",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORsltPriRpSpotInqVORSQL").append("\n"); 
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
		query.append("SELECT /*+ ORDERED USE_HASH(SCP MN) */" ).append("\n"); 
		query.append("	   MN.RFA_NO" ).append("\n"); 
		query.append("	  ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("	  ,MN.PROP_NO " ).append("\n"); 
		query.append("	  ,'' CTRT_PTY_NM" ).append("\n"); 
		query.append("      ,'' CUST_TP_NM" ).append("\n"); 
		query.append("	  ,MN.PROP_OFC_CD" ).append("\n"); 
		query.append("	  ,MN.PROP_SREP_CD" ).append("\n"); 
		query.append("	  ,TO_CHAR(MN.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(MN.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(MN.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("      ,(SELECT STS.INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL STS" ).append("\n"); 
		query.append("        WHERE STS.INTG_CD_ID = 'CD01722'" ).append("\n"); 
		query.append("        AND MN.PROP_STS_CD = STS.INTG_CD_VAL_CTNT ) PROP_STS_NM" ).append("\n"); 
		query.append("      ,'G' AS RFA_CTRT_TP_CD" ).append("\n"); 
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
		query.append("               ,MN.RFA_CTRT_TP_CD" ).append("\n"); 
		query.append("          FROM PRI_RP_HDR HDR" ).append("\n"); 
		query.append("               , PRI_RP_MN MN" ).append("\n"); 
		query.append("         WHERE HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("           AND MN.RFA_CTRT_TP_CD = 'G'" ).append("\n"); 
		query.append("#if (${srfa_no} != '')" ).append("\n"); 
		query.append("		 AND HDR.RFA_NO = @[srfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprop_no} != '')" ).append("\n"); 
		query.append("		AND MN.PROP_NO = @[sprop_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${srfa_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("        AND MN.RFA_CTRT_TP_CD = @[srfa_ctrt_tp_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("       ) MN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    MN.PROP_NO = SCP.PROP_NO" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = SCP.AMDT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${retro_active} != '')       " ).append("\n"); 
		query.append("AND (DECODE(SIGN(TRUNC((SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELSC', MN.CRE_DT,@[in_usr_ofc_cd]) FROM DUAL)) - TRUNC(MN.EFF_DT)),1," ).append("\n"); 
		query.append("        (   SELECT MAX(DECODE(RT.AMDT_SEQ,N1ST_CMNC_AMDT_SEQ,'Y','N'))" ).append("\n"); 
		query.append("            FROM PRI_RP_SCP_RT RT  " ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND MN.PROP_NO = RT.PROP_NO" ).append("\n"); 
		query.append("            AND MN.AMDT_SEQ = RT.AMDT_SEQ" ).append("\n"); 
		query.append("            GROUP BY MN.PROP_NO, MN.AMDT_SEQ        " ).append("\n"); 
		query.append("       ),'N') = @[retro_active]   )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("ORDER BY MN.RFA_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT /*+ DRIVING_SITE (MN) USE_NL(MN HDR CUST) */" ).append("\n"); 
		query.append("	   HDR.RFA_NO" ).append("\n"); 
		query.append("	  ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("	  ,MN.PROP_NO " ).append("\n"); 
		query.append("	  ,'' CTRT_PTY_NM" ).append("\n"); 
		query.append("	  ,'' CUST_TP_NM" ).append("\n"); 
		query.append("	  ,MN.PROP_OFC_CD" ).append("\n"); 
		query.append("	  ,MN.PROP_SREP_CD" ).append("\n"); 
		query.append("	  ,TO_CHAR(MN.CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(MN.EFF_DT,'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(MN.EXP_DT,'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("	  ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01722' AND INTG_CD_VAL_CTNT = MN.PROP_STS_CD) AS PROP_STS_NM" ).append("\n"); 
		query.append("      ,'G' AS RFA_CTRT_TP_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	 PRI_RP_MN MN" ).append("\n"); 
		query.append("	,PRI_RP_HDR HDR" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	HDR.PROP_NO 	 	= MN.PROP_NO" ).append("\n"); 
		query.append("AND MN.RFA_CTRT_TP_CD = 'G'" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${retro_active} != '')       " ).append("\n"); 
		query.append("AND (DECODE(SIGN(TRUNC((SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELSC', MN.CRE_DT,@[in_usr_ofc_cd]) FROM DUAL)) - TRUNC(MN.EFF_DT)),1," ).append("\n"); 
		query.append("        (   SELECT MAX(DECODE(RT.AMDT_SEQ,N1ST_CMNC_AMDT_SEQ,'Y','N'))" ).append("\n"); 
		query.append("            FROM PRI_RP_SCP_RT RT  " ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND MN.PROP_NO = RT.PROP_NO" ).append("\n"); 
		query.append("            AND MN.AMDT_SEQ = RT.AMDT_SEQ" ).append("\n"); 
		query.append("            GROUP BY MN.PROP_NO, MN.AMDT_SEQ        " ).append("\n"); 
		query.append("       ),'N') = @[retro_active]   ) " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${srfa_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("AND MN.RFA_CTRT_TP_CD = @[srfa_ctrt_tp_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("ORDER BY HDR.RFA_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}