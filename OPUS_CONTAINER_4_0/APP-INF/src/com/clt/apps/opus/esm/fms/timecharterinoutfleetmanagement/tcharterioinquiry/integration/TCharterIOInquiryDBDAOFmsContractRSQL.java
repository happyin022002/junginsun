/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInquiryDBDAOFmsContractRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInquiryDBDAOFmsContractRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Fleet Status Select
	  * </pre>
	  */
	public TCharterIOInquiryDBDAOFmsContractRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_size2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_size1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ownr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gr_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.integration").append("\n"); 
		query.append("FileName : TCharterIOInquiryDBDAOFmsContractRSQL").append("\n"); 
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
		query.append("SELECT BBB.FLET_CTRT_NO," ).append("\n"); 
		query.append("	   BBB.FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("	   BBB.VSL_CD," ).append("\n"); 
		query.append("	   CCC.VSL_ENG_NM," ).append("\n"); 
		query.append("	   BBB.OWNR_NM," ).append("\n"); 
		query.append("	   BBB.VSL_CNT_CD," ).append("\n"); 
		query.append("	   BBB.VSL_BLD_DT," ).append("\n"); 
		query.append("	   BBB.VSL_DZND_CAPA," ).append("\n"); 
		query.append("	   BBB.BSE_14TON_VSL_CAPA," ).append("\n"); 
		query.append("	   BBB.EFF_DT, " ).append("\n"); 
		query.append("	   BBB.EXP_DT," ).append("\n"); 
		query.append("	   DDD.HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("	   DDD.HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("	   DDD.HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("	   DDD.HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("	   AAA.SLAN_CD," ).append("\n"); 
		query.append("	   DECODE(BBB.GR_FLG,'N','G.Less','Geared') GR_FLG," ).append("\n"); 
		query.append("	   TO_CHAR(NVL(BBB.RF_CNTR_PLG_QTY,'0')) RF_CNTR_PLG_QTY," ).append("\n"); 
		query.append("	   TO_CHAR(NVL(BBB.SHP_SPD_QTY,'0')) SHP_SPD_QTY," ).append("\n"); 
		query.append("	   BBB.DDWT_CGO_CAPA_QTY," ).append("\n"); 
		query.append("	   BBB.GRS_WGT," ).append("\n"); 
		query.append("	   BBB.NRT_WGT," ).append("\n"); 
		query.append("	   BBB.CHTR_PRD_OPT_CTNT," ).append("\n"); 
		query.append("	   BBB.RDE_RNG_CTNT," ).append("\n"); 
		query.append("	   BBB.RDE_NTC_CTNT" ).append("\n"); 
		query.append("  FROM (SELECT VSL_CD,SLAN_CD " ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("            (SELECT VSL_CD,SLAN_CD,ROW_NUMBER() OVER(PARTITION BY VSL_CD ORDER BY VPS_ETD_DT DESC) RK" ).append("\n"); 
		query.append("                 FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                WHERE VPS_ETD_DT IS NOT NULL" ).append("\n"); 
		query.append("#if (${period_flag} == 'date')" ).append("\n"); 
		query.append("                        AND TO_CHAR(VPS_ETD_DT,'YYYYMMDD') <= @[sch_dt_to]" ).append("\n"); 
		query.append("#elseif (${period_flag} == 'month')" ).append("\n"); 
		query.append("                        AND TO_CHAR(VPS_ETD_DT,'YYYYMM') <= @[sch_dt_to]" ).append("\n"); 
		query.append("#elseif (${period_flag} == 'year')" ).append("\n"); 
		query.append("                        AND TO_CHAR(VPS_ETD_DT,'YYYY') <= @[sch_dt_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            ) " ).append("\n"); 
		query.append("         WHERE RK = 1" ).append("\n"); 
		query.append("       ) AAA," ).append("\n"); 
		query.append("       (SELECT AA.FLET_CTRT_NO," ).append("\n"); 
		query.append("	   		   AA.FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("	   		   AA.VSL_CD," ).append("\n"); 
		query.append("			   DECODE(BB.OWNR_NM,NULL,CC.OWNR_NM,BB.OWNR_NM) OWNR_NM," ).append("\n"); 
		query.append("			   DECODE(BB.OWNR_SEQ,NULL,CC.OWNR_SEQ,BB.OWNR_SEQ) OWNR_SEQ," ).append("\n"); 
		query.append("			   AA.VSL_CNT_CD," ).append("\n"); 
		query.append("			   AA.VSL_BLD_DT," ).append("\n"); 
		query.append("			   AA.VSL_DZND_CAPA," ).append("\n"); 
		query.append("			   AA.BSE_14TON_VSL_CAPA," ).append("\n"); 
		query.append("			   TO_CHAR(AA.EFF_DT,'yyyymmdd') EFF_DT, " ).append("\n"); 
		query.append("			   TO_CHAR(AA.EXP_DT,'yyyymmdd') EXP_DT," ).append("\n"); 
		query.append("			   AA.GR_FLG," ).append("\n"); 
		query.append("			   AA.RF_CNTR_PLG_QTY," ).append("\n"); 
		query.append("			   AA.SHP_SPD_QTY," ).append("\n"); 
		query.append("			   AA.DDWT_CGO_CAPA_QTY," ).append("\n"); 
		query.append("			   AA.GRS_WGT," ).append("\n"); 
		query.append("			   AA.NRT_WGT," ).append("\n"); 
		query.append("			   AA.CHTR_PRD_OPT_CTNT," ).append("\n"); 
		query.append("			   AA.RDE_RNG_CTNT," ).append("\n"); 
		query.append("			   AA.RDE_NTC_CTNT" ).append("\n"); 
		query.append("		  FROM FMS_CONTRACT AA," ).append("\n"); 
		query.append("			   (SELECT A.OWNR_SEQ, A.OWNR_NM, B.VNDR_SEQ" ).append("\n"); 
		query.append("				  FROM FMS_OWNER A," ).append("\n"); 
		query.append("				  	   MDM_VENDOR B" ).append("\n"); 
		query.append("				 WHERE A.OWNR_SEQ = B.FLET_MGMT_OWNR_VNDR_SEQ) BB," ).append("\n"); 
		query.append("			   (SELECT A.OWNR_SEQ, A.OWNR_NM, B.CUST_CNT_CD, B.CUST_SEQ" ).append("\n"); 
		query.append("				  FROM FMS_OWNER A," ).append("\n"); 
		query.append("				  	   MDM_CUSTOMER B" ).append("\n"); 
		query.append("				 WHERE A.OWNR_SEQ = B.FLET_MGMT_OWNR_CUST_SEQ) CC," ).append("\n"); 
		query.append("			   (SELECT FLET_CTRT_NO, VSL_CD, ROW_NUMBER() OVER(PARTITION BY FLET_CTRT_NO ORDER BY FLET_CTRT_NO DESC) ROW_NUM" ).append("\n"); 
		query.append("			      FROM FMS_ID_VSL " ).append("\n"); 
		query.append("			     WHERE FLET_RPT_FLG = 'Y') DD" ).append("\n"); 
		query.append("		 WHERE AA.VNDR_SEQ = BB.VNDR_SEQ(+)" ).append("\n"); 
		query.append("		   AND AA.CUST_CNT_CD = CC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("		   AND AA.CUST_SEQ = CC.CUST_SEQ(+)" ).append("\n"); 
		query.append("		   AND NVL(AA.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("		   AND AA.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("		   AND AA.FLET_CTRT_NO = DD.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("		   AND DD.ROW_NUM(+) = 1" ).append("\n"); 
		query.append("#if (${period_flag} == 'date')" ).append("\n"); 
		query.append("           AND (   @[sch_dt] BETWEEN TO_CHAR(AA.EFF_DT, 'yyyymmdd') AND TO_CHAR(AA.EXP_DT, 'yyyymmdd')" ).append("\n"); 
		query.append("                OR @[sch_dt_to] BETWEEN TO_CHAR(AA.EFF_DT, 'yyyymmdd') AND TO_CHAR(AA.EXP_DT, 'yyyymmdd')" ).append("\n"); 
		query.append("		        OR (    AA.EFF_DT >= TO_DATE(@[sch_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("                    AND AA.EXP_DT <= TO_DATE(@[sch_dt_to],'YYYYMMDD')))   " ).append("\n"); 
		query.append("#elseif (${period_flag} == 'month')" ).append("\n"); 
		query.append("           AND (   @[sch_dt] BETWEEN TO_CHAR(AA.EFF_DT, 'yyyymm') AND TO_CHAR(AA.EXP_DT, 'yyyymm')" ).append("\n"); 
		query.append("                OR @[sch_dt_to] BETWEEN TO_CHAR(AA.EFF_DT, 'yyyymm') AND TO_CHAR(AA.EXP_DT, 'yyyymm')" ).append("\n"); 
		query.append("                OR (    TO_CHAR(AA.EFF_DT,'YYYYMM') >= @[sch_dt]" ).append("\n"); 
		query.append("                    AND TO_CHAR(AA.EXP_DT,'YYYYMM') <= @[sch_dt_to]))" ).append("\n"); 
		query.append("#elseif (${period_flag} == 'year')" ).append("\n"); 
		query.append("           AND (   @[sch_dt] BETWEEN TO_CHAR(AA.EFF_DT, 'yyyy') AND TO_CHAR(AA.EXP_DT, 'yyyy')" ).append("\n"); 
		query.append("                OR @[sch_dt_to] BETWEEN TO_CHAR(AA.EFF_DT, 'yyyy') AND TO_CHAR(AA.EXP_DT, 'yyyy'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${flet_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("		   AND AA.FLET_CTRT_TP_CD = @[flet_ctrt_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_size_flag} == 'max')" ).append("\n"); 
		query.append("		   AND AA.VSL_DZND_CAPA BETWEEN @[vsl_size1] AND @[vsl_size2]" ).append("\n"); 
		query.append("#elseif (${vsl_size_flag} == '14ton')" ).append("\n"); 
		query.append("		   AND AA.BSE_14TON_VSL_CAPA BETWEEN @[vsl_size1] AND @[vsl_size2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gr_flg} != '')" ).append("\n"); 
		query.append("		   AND AA.GR_FLG = @[gr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	   ) BBB," ).append("\n"); 
		query.append("	   MDM_VSL_CNTR CCC," ).append("\n"); 
		query.append("	   (SELECT AA.FLET_CTRT_NO," ).append("\n"); 
		query.append("		  	   AA.HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("			   AA.HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("			   AA.HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("			   AA.HIR_RT_N2ND_AMT" ).append("\n"); 
		query.append("		  FROM (SELECT A.FLET_CTRT_NO," ).append("\n"); 
		query.append("		  			   A.HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("			   		   A.HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("			   		   A.HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("					   A.HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("			           RANK() OVER (PARTITION BY FLET_CTRT_NO ORDER BY (EXP_DT - EFF_DT) DESC, EFF_DT DESC) RK" ).append("\n"); 
		query.append("		          FROM FMS_HIRE A" ).append("\n"); 
		query.append("				 WHERE 1 = 1" ).append("\n"); 
		query.append("				#if (${period_flag} == 'date')" ).append("\n"); 
		query.append("				   AND (   @[sch_dt] BETWEEN TO_CHAR(A.EFF_DT, 'yyyymmdd') AND TO_CHAR(A.EXP_DT, 'yyyymmdd')" ).append("\n"); 
		query.append("						OR @[sch_dt_to] BETWEEN TO_CHAR(A.EFF_DT, 'yyyymmdd') AND TO_CHAR(A.EXP_DT, 'yyyymmdd')" ).append("\n"); 
		query.append("						OR (    A.EFF_DT >= TO_DATE(@[sch_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("							AND A.EXP_DT <= TO_DATE(@[sch_dt_to],'YYYYMMDD')))   " ).append("\n"); 
		query.append("				#elseif (${period_flag} == 'month')" ).append("\n"); 
		query.append("				   AND (   @[sch_dt] BETWEEN TO_CHAR(A.EFF_DT, 'yyyymm') AND TO_CHAR(A.EXP_DT, 'yyyymm')" ).append("\n"); 
		query.append("						OR @[sch_dt_to] BETWEEN TO_CHAR(A.EFF_DT, 'yyyymm') AND TO_CHAR(A.EXP_DT, 'yyyymm')" ).append("\n"); 
		query.append("						OR (    TO_CHAR(A.EFF_DT,'YYYYMM') >= @[sch_dt]" ).append("\n"); 
		query.append("							AND TO_CHAR(A.EXP_DT,'YYYYMM') <= @[sch_dt_to]))" ).append("\n"); 
		query.append("				#elseif (${period_flag} == 'year')" ).append("\n"); 
		query.append("				   AND (   @[sch_dt] BETWEEN TO_CHAR(A.EFF_DT, 'yyyy') AND TO_CHAR(A.EXP_DT, 'yyyy')" ).append("\n"); 
		query.append("						OR @[sch_dt_to] BETWEEN TO_CHAR(A.EFF_DT, 'yyyy') AND TO_CHAR(A.EXP_DT, 'yyyy'))" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("	           ) AA" ).append("\n"); 
		query.append("	     WHERE AA.RK = 1) DDD" ).append("\n"); 
		query.append(" WHERE BBB.VSL_CD = AAA.VSL_CD(+)" ).append("\n"); 
		query.append("   AND BBB.VSL_CD = CCC.VSL_CD(+)" ).append("\n"); 
		query.append("   AND BBB.FLET_CTRT_NO = DDD.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("   AND NVL(CCC.DELT_FLG(+),'N') = 'N'" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("   AND AAA.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ownr_seq} != '')" ).append("\n"); 
		query.append("   AND BBB.OWNR_SEQ = @[ownr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY DECODE(BBB.FLET_CTRT_TP_CD,'OW','TZ',BBB.FLET_CTRT_TP_CD) ASC, BBB.VSL_CD, BBB.EXP_DT DESC" ).append("\n"); 

	}
}