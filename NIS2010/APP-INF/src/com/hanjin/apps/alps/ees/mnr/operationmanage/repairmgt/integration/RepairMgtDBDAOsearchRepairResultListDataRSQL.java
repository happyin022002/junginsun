/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RepairMgtDBDAOsearchRepairResultListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchRepairResultListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRepairResultListData select
	  * 2015.05 Chang Young Kim Query Tuning -- Index Hint 를 삭제
	  * </pre>
	  */
	public RepairMgtDBDAOsearchRepairResultListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tocal",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromcal",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchRepairResultListDataRSQL").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append("         A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,A.MNR_ORD_OFC_CTY_CD || A.MNR_ORD_SEQ  AS MNR_ORD_SEQ " ).append("\n"); 
		query.append("        ,A.ORD_DTL_SEQ" ).append("\n"); 
		query.append("		,B.EQ_KND_CD" ).append("\n"); 
		query.append("        ,A.COST_CD" ).append("\n"); 
		query.append("        ,A.ACCT_CD" ).append("\n"); 
		query.append("        ,A.COST_DTL_CD" ).append("\n"); 
		query.append("        ,A.RPR_OFFH_FLG" ).append("\n"); 
		query.append("        ,A.MNR_RT_TP_CD" ).append("\n"); 
		query.append("        ,A.MNR_EXPN_DTL_NM" ).append("\n"); 
		query.append("        ,A.EQ_NO" ).append("\n"); 
		query.append("        ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("        ,A.RQST_REF_NO" ).append("\n"); 
		query.append("        ,A.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("        ,A.SPR_PRT_UT_TP_NM" ).append("\n"); 
		query.append("        ,A.SPR_PRT_NO" ).append("\n"); 
		query.append("        ,A.SPR_PRT_NM" ).append("\n"); 
		query.append("        ,A.YD_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(A.RPR_RSLT_DT,'yyyy-mm-dd') AS RPR_RSLT_DT" ).append("\n"); 
		query.append("        ,A.RPR_QTY" ).append("\n"); 
		query.append("        ,A.SPR_PRT_UC_AMT" ).append("\n"); 
		query.append("        ,A.BZC_AMT" ).append("\n"); 
		query.append("        ,A.COST_AMT" ).append("\n"); 
		query.append("        ,A.N3PTY_FLG" ).append("\n"); 
		query.append("        ,A.N3PTY_BIL_TTL_AMT" ).append("\n"); 
		query.append("        ,A.INV_AMT" ).append("\n"); 
		query.append("        ,A.MNR_VRFY_TP_CD" ).append("\n"); 
		query.append("        ,A.ORD_DTL_RMK" ).append("\n"); 
		query.append("        ,A.INV_NO" ).append("\n"); 
		query.append("        ,A.FILE_SEQ" ).append("\n"); 
		query.append("        ,A.RPR_RQST_SEQ" ).append("\n"); 
		query.append("        ,A.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("        ,NVL(A.PAY_INV_SEQ,0) AS PAY_INV_SEQ" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.CRE_DT, @[cost_ofc_cd]),'yyyy-mm-dd') AS CRE_DT" ).append("\n"); 
		query.append("        ,DECODE(NVL(A.RPR_RSLT_DT,''),'','',A.UPD_USR_ID) AS UPD_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.UPD_DT, @[cost_ofc_cd]), 'yyyy-mm-dd') AS UPD_DT" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("			   VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("		  	FROM MDM_VENDOR" ).append("\n"); 
		query.append("		  	WHERE VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("            AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("		) AS PIG_ENG_NM " ).append("\n"); 
		query.append("		,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),C.RQST_DT, @[cost_ofc_cd]),'yyyy-mm-dd') AS RQST_DT" ).append("\n"); 
		query.append("        ,(SELECT MNR_CD_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID ='CD00008' AND MNR_CD_ID = C.RPR_STS_CD) AS RPR_STS_CD_NM" ).append("\n"); 
		query.append("        ,(SELECT MNR_DMG_FLG FROM MNR_EQ_STS WHERE EQ_NO = A.EQ_NO AND EQ_KND_CD = B.EQ_KND_CD  AND EQ_TPSZ_CD = A.EQ_TPSZ_CD) AS MNR_DMG_FLG" ).append("\n"); 
		query.append("		,TRUNC(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.RPR_RSLT_DT, @[cost_ofc_cd]) - GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.CRE_DT, @[cost_ofc_cd])) AS RPR_RSLT_DAYS" ).append("\n"); 
		query.append("        ,B.MNR_WRK_AMT" ).append("\n"); 
		query.append("        ,C.RQST_REF_NO" ).append("\n"); 
		query.append("FROM MNR_ORD_DTL A, MNR_ORD_HDR B, MNR_RPR_RQST_HDR C" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("B.MNR_ORD_OFC_CTY_CD = A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND B.MNR_ORD_SEQ  = A.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND B.MNR_ORD_OFC_CTY_CD = C.MNR_ORD_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND B.MNR_ORD_SEQ = C.MNR_ORD_SEQ(+) " ).append("\n"); 
		query.append("AND B.COST_OFC_CD = @[cost_ofc_cd]" ).append("\n"); 
		query.append("AND B.MNR_WO_TP_CD = 'EST'" ).append("\n"); 
		query.append("AND B.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND B.CRE_DT BETWEEN (select GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cost_ofc_cd], TO_DATE(@[fromcal], 'YYYY-MM-DD'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) from dual)" ).append("\n"); 
		query.append("                 AND (select GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cost_ofc_cd], TO_DATE(@[tocal] || ' 23:59:59', 'YYYY-MM-DD HH24:MI:SS'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) from dual)" ).append("\n"); 
		query.append("#if (${rpr_rslt_sts} == 'NC') " ).append("\n"); 
		query.append("AND A.RPR_RSLT_DT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rpr_rslt_sts} == 'CR') " ).append("\n"); 
		query.append("AND A.RPR_RSLT_DT IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("AND B.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_ord_seq} != '') " ).append("\n"); 
		query.append("AND B.MNR_ORD_OFC_CTY_CD = @[mnr_ord_ofc_cty_cd]" ).append("\n"); 
		query.append("AND B.MNR_ORD_SEQ = @[mnr_ord_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rqst_ref_no} != '') " ).append("\n"); 
		query.append("AND A.RQST_REF_NO = @[rqst_ref_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_no} != '') " ).append("\n"); 
		query.append("AND A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY B.CRE_DT DESC" ).append("\n"); 

	}
}