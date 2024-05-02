/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : WorkOrderManagementDBDAOsearchWorkOrderBFIManagementRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.05
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2017.01.05 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderManagementDBDAOsearchWorkOrderBFIManagementRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWorkOrderBFIManagement
	  * </pre>
	  */
	public WorkOrderManagementDBDAOsearchWorkOrderBFIManagementRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.integration").append("\n"); 
		query.append("FileName : WorkOrderManagementDBDAOsearchWorkOrderBFIManagementRSQL").append("\n"); 
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
		query.append("SELECT   DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(BFI.BZC_AMT_DESC,'','',MAX(BFI.CRE_OFC_CD)),'') AS CRE_OFC_CD" ).append("\n"); 
		query.append("       , DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(BFI.BZC_AMT_DESC,'','',MAX(BFI.FM_DT )),'') AS FM_DT" ).append("\n"); 
		query.append("       , DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(BFI.BZC_AMT_DESC,'','',MAX(BFI.TO_DT )),'') AS TO_DT" ).append("\n"); 
		query.append("       , DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(BFI.BZC_AMT_DESC,'','',MAX(BFI.WO_VNDR_SEQ )),'') AS WO_VNDR_SEQ" ).append("\n"); 
		query.append("       , DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(BFI.BZC_AMT_DESC,'','',MAX(BFI.VNDR_LGL_ENG_NM )),'') AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("       , DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(BFI.BZC_AMT_DESC,'','',MAX(BFI.VNDR_EML)),'') AS VNDR_EML" ).append("\n"); 
		query.append("       , DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(BFI.BZC_AMT_DESC,'','',MAX(BFI.TODAY_DT )),'') AS TODAY_DT" ).append("\n"); 
		query.append("       , DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(BFI.BZC_AMT_DESC,'','',MAX(BFI.CNTC_PSON_NM )),'') AS CNTC_PSON_NM" ).append("\n"); 
		query.append("       , TRSP_WO_NO" ).append("\n"); 
		query.append("       , DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(BFI.BZC_AMT_DESC,'','',MAX(BFI.EQ_TPSZ_CD )),'') AS EQ_TPSZ_CD" ).append("\n"); 
		query.append("       , DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(BFI.BZC_AMT_DESC,'','',MAX(BFI.FM_NOD_CD )),'') AS FM_NOD_CD" ).append("\n"); 
		query.append("       , DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(BFI.BZC_AMT_DESC,'','',MAX(BFI.VIA_NOD_CD )),'') AS VIA_NOD_CD" ).append("\n"); 
		query.append("       , DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(BFI.BZC_AMT_DESC,'','',MAX(BFI.TO_NOD_CD )),'') AS TO_NOD_CD" ).append("\n"); 
		query.append("       , DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(BFI.BZC_AMT_DESC,'','',MAX(BFI.DOR_NOD_CD )),'') AS DOR_NOD_CD" ).append("\n"); 
		query.append("       , DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(BFI.BZC_AMT_DESC,'','',MAX(BFI.DOR_NOD_PLN_DT )),'') AS  DOR_NOD_PLN_DT" ).append("\n"); 
		query.append("       , CURR_CD" ).append("\n"); 
		query.append("       , DECODE(GROUPING_ID(TRSP_WO_NO),0,NVL(BFI.BZC_AMT_DESC,'Total'),NVL(BFI.BZC_AMT_DESC,'Grand Total')) AS BZC_AMT_DESC" ).append("\n"); 
		query.append("       , TRIM(TO_CHAR(ROUND(SUM(BFI.BZC_AMT),2),'9999999990.00')) AS BZC_AMT" ).append("\n"); 
		query.append("       , DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(BFI.BZC_AMT_DESC,'','',MAX(BFI.EQ_NO )),'') AS EQ_NO" ).append("\n"); 
		query.append("       , DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(BFI.BZC_AMT_DESC,'','',MAX(BFI.CGO_TP_CD )),'') AS CGO_TP_CD" ).append("\n"); 
		query.append("       , DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(BFI.BZC_AMT_DESC,'','',MAX(BFI.TRS_SUB_STS_CD )),'') AS TRS_SUB_STS_CD" ).append("\n"); 
		query.append("       , MAX(BFI.CNT)" ).append("\n"); 
		query.append("       , DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(NVL(BFI.BZC_AMT_DESC,'Total'),'Total',MAX(BFI.CNT)+1,MAX(BFI.CNT)),DECODE(NVL(BFI.BZC_AMT_DESC,'Grand Total'),'Grand Total',MAX(BFI.CNT)+2))" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("    TSO.TRSP_SO_SEQ," ).append("\n"); 
		query.append("    TWO.CRE_OFC_CD	" ).append("\n"); 
		query.append("    ,NVL(TO_CHAR(TO_DATE(@[fm_dt],'YYYY-MM-DD'),'YYYY-MM-DD'),TO_CHAR(SYSDATE,'YYYY-MM-DD')) AS FM_DT	" ).append("\n"); 
		query.append("    ,NVL(TO_CHAR(TO_DATE(@[to_dt],'YYYY-MM-DD'),'YYYY-MM-DD'),TO_CHAR(SYSDATE,'YYYY-MM-DD')) AS TO_DT			" ).append("\n"); 
		query.append("    ,TWO.WO_VNDR_SEQ	" ).append("\n"); 
		query.append("    ,MVE.VNDR_LGL_ENG_NM	" ).append("\n"); 
		query.append("    ,VCP.VNDR_EML	" ).append("\n"); 
		query.append("    ,TO_CHAR(SYSDATE,'YYYY-MM-DD') AS TODAY_DT		" ).append("\n"); 
		query.append("    ,MVE.CNTC_PSON_NM" ).append("\n"); 
		query.append("    ,TWO.TRSP_WO_OFC_CTY_CD||TWO.TRSP_WO_SEQ  AS TRSP_WO_NO" ).append("\n"); 
		query.append("    ,TSO.EQ_TPSZ_CD" ).append("\n"); 
		query.append("    ,TSO.FM_NOD_CD	" ).append("\n"); 
		query.append("    ,TSO.VIA_NOD_CD	" ).append("\n"); 
		query.append("    ,TSO.TO_NOD_CD	" ).append("\n"); 
		query.append("    ,TSO.DOR_NOD_CD	" ).append("\n"); 
		query.append("    ,DECODE(TSO.TRSP_SO_TP_CD,'Y',DECODE(TSO.TRSP_COST_DTL_MOD_CD,'DR',TO_CHAR(TSO.DOR_NOD_PLN_DT,'YYYY-MM-DD'),DECODE(TSO.TRSP_COST_DTL_MOD_CD,'CY',TO_CHAR(TSO.LST_NOD_PLN_DT,'YYYY-MM-DD'),TO_CHAR(TWO.LOCL_CRE_DT,'YYYY-MM-DD'))),'') AS DOR_NOD_PLN_DT" ).append("\n"); 
		query.append("    ,TSO.CURR_CD		" ).append("\n"); 
		query.append("    ,DECODE(CNT.NO,1,'Basic Amount',2,'Negotiated  Amount',3,'Fuel Amount',4,'Additional Amount') BZC_AMT_DESC" ).append("\n"); 
		query.append("    ,DECODE(CNT.NO,1,BZC_AMT,2,NEGO_AMT,3,FUEL_SCG_AMT,4,ETC_ADD_AMT) BZC_AMT" ).append("\n"); 
		query.append("    ,TSO.EQ_NO			" ).append("\n"); 
		query.append("    ,DECODE(TSO.CGO_TP_CD,'F','Full','F','Empty', NVL(TSO.CGO_TP_CD,''))	CGO_TP_CD" ).append("\n"); 
		query.append("    ,DECODE(TSO.TRS_SUB_STS_CD,'DF','Draft','OR','Ordered','AC','Accepted','ST','Started','CM','Completed') AS TRS_SUB_STS_CD" ).append("\n"); 
		query.append("    ,CNT.NO CNT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("TRS_TRSP_WRK_ORD TWO," ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD TSO," ).append("\n"); 
		query.append("MDM_VENDOR MVE," ).append("\n"); 
		query.append("(SELECT  VCP.VNDR_SEQ,LISTAGG(VCP.VNDR_EML, '; ') " ).append("\n"); 
		query.append("        WITHIN GROUP " ).append("\n"); 
		query.append("        (ORDER BY VNDR_EML) VNDR_EML" ).append("\n"); 
		query.append(" FROM    MDM_VNDR_CNTC_PNT VCP" ).append("\n"); 
		query.append(" WHERE   VCP.CNTC_DIV_CD = 'EMAIL'" ).append("\n"); 
		query.append(" AND     DELT_FLG = 'N'" ).append("\n"); 
		query.append(" GROUP BY VCP.VNDR_SEQ " ).append("\n"); 
		query.append(" ) VCP," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   SELECT '1' AS NO FROM DUAL UNION SELECT '2' AS NO FROM DUAL UNION SELECT '3' AS NO FROM DUAL UNION SELECT '4' AS NO FROM DUAL" ).append("\n"); 
		query.append(") CNT" ).append("\n"); 
		query.append("WHERE   TWO.TRSP_WO_OFC_CTY_CD = TSO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND     TWO.TRSP_WO_SEQ = TSO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND     TSO.VNDR_SEQ = MVE.VNDR_SEQ" ).append("\n"); 
		query.append("AND     TSO.VNDR_SEQ = VCP.VNDR_SEQ(+) -- 2015.02.05    Hyungwook Choi - Requested by Chang-Hyun Jun" ).append("\n"); 
		query.append("AND     TWO.DELT_FLG = 'N'  " ).append("\n"); 
		query.append("AND     TSO.DELT_FLG = 'N'  " ).append("\n"); 
		query.append("AND     TSO.TRSP_SO_STS_CD = 'I'" ).append("\n"); 
		query.append("AND     TSO.INV_NO IS NULL" ).append("\n"); 
		query.append("AND     TSO.TRS_SUB_STS_CD IN ('ST', 'CM') " ).append("\n"); 
		query.append("AND     TWO.LOCL_CRE_DT BETWEEN TO_DATE(@[fm_dt]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[to_dt]||'235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cre_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND TWO.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("	#if (${temp_not_sp} == 'N')" ).append("\n"); 
		query.append("		AND	TWO.WO_VNDR_SEQ IN (" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND	TWO.WO_VNDR_SEQ NOT IN (" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		#foreach ($user_vndrSeqs IN ${vndrSeqs})" ).append("\n"); 
		query.append("			#if($velocityCount < $vndrSeqs.size())" ).append("\n"); 
		query.append("				'$user_vndrSeqs'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_vndrSeqs'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY TSO.TRSP_SO_OFC_CTY_CD,TSO.TRSP_SO_SEQ,CNT.NO" ).append("\n"); 
		query.append(") BFI" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE BFI.BZC_AMT > 0 -- 2015.02.05    Hyungwook Choi - Requested by Chang-Hyun Jun" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY ROLLUP(TRSP_WO_NO,DECODE(CNT,1,'Basic Amount',2,'Negotiated  Amount',3,'Fuel Amount',4,'Additional Amount')),CURR_CD,EQ_NO" ).append("\n"); 
		query.append("ORDER BY CURR_CD,EQ_NO,TRSP_WO_NO,DECODE(GROUPING_ID(TRSP_WO_NO),0,DECODE(NVL(BFI.BZC_AMT_DESC,'Total'),'Total',MAX(BFI.CNT)+1,MAX(BFI.CNT)),DECODE(NVL(BFI.BZC_AMT_DESC,'Grand Total'),'Grand Total',MAX(BFI.CNT)+2))" ).append("\n"); 

	}
}