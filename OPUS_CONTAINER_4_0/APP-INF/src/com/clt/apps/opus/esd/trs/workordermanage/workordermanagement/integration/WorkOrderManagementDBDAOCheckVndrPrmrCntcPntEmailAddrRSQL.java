/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : WorkOrderManagementDBDAOCheckVndrPrmrCntcPntEmailAddrRSQL.java
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

public class WorkOrderManagementDBDAOCheckVndrPrmrCntcPntEmailAddrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check Vendor Primary Contact Point Email Address is empty
	  * </pre>
	  */
	public WorkOrderManagementDBDAOCheckVndrPrmrCntcPntEmailAddrRSQL(){
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
		query.append("FileName : WorkOrderManagementDBDAOCheckVndrPrmrCntcPntEmailAddrRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT W.CRE_OFC_CD" ).append("\n"); 
		query.append("      ,NVL(TO_CHAR(TO_DATE(@[fm_dt], 'YYYY-MM-DD'), 'YYYY-MM-DD'), TO_CHAR(SYSDATE, 'YYYY-MM-DD')) AS FM_DT" ).append("\n"); 
		query.append("      ,NVL(TO_CHAR(TO_DATE(@[to_dt], 'YYYY-MM-DD'), 'YYYY-MM-DD'), TO_CHAR(SYSDATE, 'YYYY-MM-DD')) AS TO_DT" ).append("\n"); 
		query.append("      ,W.WO_VNDR_SEQ" ).append("\n"); 
		query.append("      ,V.VNDR_LGL_ENG_NM || '(' || W.WO_VNDR_SEQ || ')' AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,VC.VNDR_EML" ).append("\n"); 
		query.append("      ,TO_CHAR(SYSDATE, 'YYYY-MM-DD') AS TODAY_DT" ).append("\n"); 
		query.append("      ,V.CNTC_PSON_NM" ).append("\n"); 
		query.append("      ,W.TRSP_WO_OFC_CTY_CD||W.TRSP_WO_SEQ AS TRSP_WO_NO" ).append("\n"); 
		query.append("      ,S.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,S.FM_NOD_CD" ).append("\n"); 
		query.append("      ,S.VIA_NOD_CD" ).append("\n"); 
		query.append("      ,S.TO_NOD_CD" ).append("\n"); 
		query.append("      ,S.DOR_NOD_CD" ).append("\n"); 
		query.append("      ,(SELECT ZN_NM FROM MDM_ZONE WHERE ZN_CD = S.DOR_NOD_CD AND DELT_FLG = 'N') DOR_NOD_NM" ).append("\n"); 
		query.append("      ,DECODE(S.TRSP_SO_TP_CD, 'Y', DECODE(S.TRSP_COST_DTL_MOD_CD, 'DR', TO_CHAR(S.DOR_NOD_PLN_DT, 'YYYY-MM-DD'), DECODE(S.TRSP_COST_DTL_MOD_CD, 'CY', TO_CHAR(S.N1ST_NOD_PLN_DT, 'YYYY-MM-DD'), TO_CHAR(W.LOCL_CRE_DT, 'YYYY-MM-DD'))), TO_CHAR(S.WO_EXE_DT, 'YYYY-MM-DD')) AS DOR_NOD_PLN_DT" ).append("\n"); 
		query.append("      ,S.CURR_CD" ).append("\n"); 
		query.append("      ,CD.AMT_DESC BZC_AMT_DESC" ).append("\n"); 
		query.append("      ,MAX( (CASE" ).append("\n"); 
		query.append("               WHEN CD.ORD = 1 THEN S.BZC_AMT" ).append("\n"); 
		query.append("               WHEN CD.ORD = 2 THEN S.NEGO_AMT" ).append("\n"); 
		query.append("               WHEN CD.ORD = 3 THEN S.FUEL_SCG_AMT" ).append("\n"); 
		query.append("               WHEN SUBSTR(CD.COST_CD,3,2) = SUBSTR(SC.LGS_COST_CD,3,2) THEN SC.SCG_AMT" ).append("\n"); 
		query.append("             END) ) BZC_AMT" ).append("\n"); 
		query.append("      ,CASE" ).append("\n"); 
		query.append("         WHEN S.EQ_NO IS NULL AND S.TRSP_SO_TP_CD || S.TRSP_COST_DTL_MOD_CD IN ('YCY','YLS','YTS')" ).append("\n"); 
		query.append("         THEN DECODE(SCE.CNTR_NO, 'COMU0000000', '', SCE.CNTR_NO)" ).append("\n"); 
		query.append("		 ELSE S.EQ_NO" ).append("\n"); 
		query.append("       END EQ_NO" ).append("\n"); 
		query.append("      ,DECODE(S.CGO_TP_CD, 'F', 'Full', 'M', 'Empty', NVL(S.CGO_TP_CD, '')) CGO_TP_CD" ).append("\n"); 
		query.append("      ,DECODE(S.TRS_SUB_STS_CD, 'DF', 'Draft', 'OR', 'Ordered', 'AC', 'Accepted', 'ST', 'Started', 'CM', 'Completed') AS TRS_SUB_STS_CD" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD S" ).append("\n"); 
		query.append("      ,TRS_TRSP_WRK_ORD W" ).append("\n"); 
		query.append("      ,(SELECT SUM(SCG_AMT) SCG_AMT" ).append("\n"); 
		query.append("              ,TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("              ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("              ,LGS_COST_CD" ).append("\n"); 
		query.append("         FROM TRS_TRSP_SCG_DTL X" ).append("\n"); 
		query.append("        WHERE SUBSTR(LGS_COST_CD, 3, 2) <> 'FU'" ).append("\n"); 
		query.append("        GROUP BY TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("                ,LGS_COST_CD) SC" ).append("\n"); 
		query.append("      ,MDM_VENDOR V" ).append("\n"); 
		query.append("      ,MDM_VNDR_CNTC_PNT VC" ).append("\n"); 
		query.append("      ,SCE_COP_HDR SCE" ).append("\n"); 
		query.append("      ,(SELECT 1 ORD" ).append("\n"); 
		query.append("              ,'BZC' COST_CD" ).append("\n"); 
		query.append("              ,'Basic Amount' AMT_DESC" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 2 ORD" ).append("\n"); 
		query.append("              ,'NEGO'" ).append("\n"); 
		query.append("              ,'Negotiated  Amount'" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 3 ORD" ).append("\n"); 
		query.append("              ,'FUEL'" ).append("\n"); 
		query.append("              ,'Fuel Amount'" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT RANK() OVER (ORDER BY INTG_CD_VAL_DP_SEQ) +3 ,INTG_CD_VAL_CTNT ,INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD30002'" ).append("\n"); 
		query.append("           AND UPPER(INTG_CD_VAL_DESC) NOT LIKE '%FUEL%' ) CD" ).append("\n"); 
		query.append(" WHERE S.TRSP_WO_OFC_CTY_CD = W.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND S.TRSP_WO_SEQ = W.TRSP_WO_SEQ" ).append("\n"); 
		query.append("   AND S.TRSP_SO_STS_CD = 'I'" ).append("\n"); 
		query.append("   AND S.TRSP_SO_OFC_CTY_CD = SC.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND S.TRSP_SO_SEQ = SC.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("   AND S.INV_NO IS NULL" ).append("\n"); 
		query.append("   AND S.TRS_SUB_STS_CD IN ('ST', 'CM') " ).append("\n"); 
		query.append("   AND NVL(S.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("   AND NVL(W.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("   AND DECODE(S.TRSP_SO_TP_CD,'Y',DECODE(S.TRSP_COST_DTL_MOD_CD,'DR',S.DOR_NOD_PLN_DT ,DECODE(S.TRSP_COST_DTL_MOD_CD,'CY',S.N1ST_NOD_PLN_DT,W.LOCL_CRE_DT)),S.WO_EXE_DT) BETWEEN TO_DATE(@[fm_dt]||'000000','YYYY-MM-DDHH24MISS') AND TO_DATE(@[to_dt]||'235959','YYYY-MM-DDHH24MISS')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cre_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND W.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("	#if (${temp_not_sp} == 'N')" ).append("\n"); 
		query.append("		AND	W.WO_VNDR_SEQ IN (" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND	W.WO_VNDR_SEQ NOT IN (" ).append("\n"); 
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
		query.append("   AND W.WO_VNDR_SEQ = V.VNDR_SEQ" ).append("\n"); 
		query.append("   AND NVL(V.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("   AND W.WO_VNDR_SEQ = VC.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND NVL(VC.DELT_FLG(+),'N') = 'N'" ).append("\n"); 
		query.append("   AND VC.PRMRY_CHK_FLG(+) ='Y'" ).append("\n"); 
		query.append("   AND S.COP_NO = SCE.COP_NO(+)" ).append("\n"); 
		query.append("   AND SCE.COP_STS_CD(+) IN ('C', 'T', 'F') " ).append("\n"); 
		query.append(" GROUP BY W.TRSP_WO_OFC_CTY_CD||W.TRSP_WO_SEQ" ).append("\n"); 
		query.append("         ,S.TRSP_SO_SEQ" ).append("\n"); 
		query.append("         ,W.CRE_OFC_CD" ).append("\n"); 
		query.append("         ,W.WO_VNDR_SEQ" ).append("\n"); 
		query.append("         ,V.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("         ,V.CNTC_PSON_NM" ).append("\n"); 
		query.append("         ,VC.VNDR_EML" ).append("\n"); 
		query.append("         ,S.EQ_TPSZ_CD" ).append("\n"); 
		query.append("         ,S.FM_NOD_CD" ).append("\n"); 
		query.append("         ,S.VIA_NOD_CD" ).append("\n"); 
		query.append("         ,S.TO_NOD_CD" ).append("\n"); 
		query.append("         ,S.DOR_NOD_CD" ).append("\n"); 
		query.append("         ,DECODE(S.TRSP_SO_TP_CD, 'Y', DECODE(S.TRSP_COST_DTL_MOD_CD, 'DR', TO_CHAR(S.DOR_NOD_PLN_DT, 'YYYY-MM-DD'), DECODE(S.TRSP_COST_DTL_MOD_CD, 'CY', TO_CHAR(S.N1ST_NOD_PLN_DT, 'YYYY-MM-DD'), TO_CHAR(W.LOCL_CRE_DT, 'YYYY-MM-DD'))), TO_CHAR(S.WO_EXE_DT, 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("         ,S.CURR_CD" ).append("\n"); 
		query.append("         ,S.EQ_NO" ).append("\n"); 
		query.append("         ,DECODE(S.CGO_TP_CD, 'F', 'Full', 'M', 'Empty', NVL(S.CGO_TP_CD, ''))" ).append("\n"); 
		query.append("         ,DECODE(S.TRS_SUB_STS_CD, 'DF', 'Draft', 'OR', 'Ordered', 'AC', 'Accepted', 'ST', 'Started', 'CM', 'Completed')" ).append("\n"); 
		query.append("         ,CD.AMT_DESC" ).append("\n"); 
		query.append("         ,CD.ORD" ).append("\n"); 
		query.append("         ,S.TRSP_SO_TP_CD" ).append("\n"); 
		query.append("         ,S.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("         ,SCE.CNTR_NO" ).append("\n"); 
		query.append("   HAVING MAX( (CASE" ).append("\n"); 
		query.append("                     WHEN CD.ORD = 1 THEN S.BZC_AMT" ).append("\n"); 
		query.append("                     WHEN CD.ORD = 2 THEN S.NEGO_AMT" ).append("\n"); 
		query.append("                     WHEN CD.ORD = 3 THEN S.FUEL_SCG_AMT" ).append("\n"); 
		query.append("                     WHEN SUBSTR(CD.COST_CD,3,2) = SUBSTR(SC.LGS_COST_CD,3,2) THEN SC.SCG_AMT" ).append("\n"); 
		query.append("                END) ) <> 0" ).append("\n"); 
		query.append("ORDER BY VNDR_LGL_ENG_NM, EQ_NO, TRSP_WO_NO, CD.ORD" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE VNDR_EML IS NULL" ).append("\n"); 

	}
}