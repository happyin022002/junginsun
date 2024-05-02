/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RepairMgtDBDAOsearchRepairInquiryEDIErrorListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchRepairInquiryEDIErrorListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRepairInquiryEDIErrorListData
	  * </pre>
	  */
	public RepairMgtDBDAOsearchRepairInquiryEDIErrorListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_est_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_est_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchRepairInquiryEDIErrorListDataRSQL").append("\n"); 
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
		query.append("SELECT MRT.VNDR_SEQ," ).append("\n"); 
		query.append("       NVL((SELECT MVR.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("             FROM MDM_VENDOR MVR" ).append("\n"); 
		query.append("            WHERE MRT.VNDR_SEQ = MVR.VNDR_SEQ)," ).append("\n"); 
		query.append("           MRT.VNDR_SEQ) AS VNDR_NM," ).append("\n"); 
		query.append("       '' MNR_WO_TP_CD," ).append("\n"); 
		query.append("       '' AS WO_NO," ).append("\n"); 
		query.append("       '' AS ISS_DT," ).append("\n"); 
		query.append("       '' AS MNR_ORD_SND_DT," ).append("\n"); 
		query.append("       MRT.INV_NO," ).append("\n"); 
		query.append("       MRT.INV_AMT," ).append("\n"); 
		query.append("       MRT.MNR_RPR_RMK AS ORD_HDR_RMK," ).append("\n"); 
		query.append("       MRT.EQ_KND_CD," ).append("\n"); 
		query.append("       'E' AS TRSM_MOD_CD," ).append("\n"); 
		query.append("       MRT.MNR_ORD_OFC_CTY_CD," ).append("\n"); 
		query.append("       MRT.MNR_ORD_SEQ," ).append("\n"); 
		query.append("       '' AS COST_CD," ).append("\n"); 
		query.append("       (MRT.MNR_LBR_AMT + MRT.MNR_MTRL_AMT) AS MNR_WRK_AMT," ).append("\n"); 
		query.append("       '' AS VVD," ).append("\n"); 
		query.append("       '' AS SPR_PRT_SPL_YD_CD," ).append("\n"); 
		query.append("       '' AS COST_CD_NM," ).append("\n"); 
		query.append("       TO_CHAR(MRT.CRE_DT, 'YYYY-MM-DD') AS EST_DT," ).append("\n"); 
		query.append("       MRT.CURR_CD," ).append("\n"); 
		query.append("       MRT.N3PTY_FLG," ).append("\n"); 
		query.append("       (SELECT SUM(MRD.MNR_WRK_AMT)" ).append("\n"); 
		query.append("          FROM MNR_RPR_RQST_TMP_DTL MRD" ).append("\n"); 
		query.append("         WHERE MRD.RQST_EQ_NO = MRT.RQST_EQ_NO" ).append("\n"); 
		query.append("           AND MRD.RPR_RQST_TMP_SEQ = MRT.RPR_RQST_TMP_SEQ" ).append("\n"); 
		query.append("           AND MRD.RPR_RQST_TMP_VER_NO = MRT.RPR_RQST_TMP_VER_NO) TOTAL_AMT," ).append("\n"); 
		query.append("       NVL((SELECT MNR_CD_DESC" ).append("\n"); 
		query.append("             FROM MNR_GEN_CD" ).append("\n"); 
		query.append("            WHERE MNR_CD_ID = MRT.EDI_ERR_CD" ).append("\n"); 
		query.append("              AND PRNT_CD_ID = 'CD00076'" ).append("\n"); 
		query.append("              AND ROWNUM = 1)," ).append("\n"); 
		query.append("           'Error') AS MNR_VRFY_TP_CD," ).append("\n"); 
		query.append("       MRT.RQST_EQ_NO," ).append("\n"); 
		query.append("       MRT.RPR_RQST_TMP_SEQ AS RPR_RQST_SEQ," ).append("\n"); 
		query.append("       MRT.RPR_RQST_TMP_VER_NO AS RPR_RQST_VER_NO," ).append("\n"); 
		query.append("       MRT.RPR_RQST_LST_VER_FLG," ).append("\n"); 
		query.append("       MRT.EQ_TPSZ_CD," ).append("\n"); 
		query.append("       NVL((SELECT MNR_CD_DESC" ).append("\n"); 
		query.append("             FROM MNR_GEN_CD" ).append("\n"); 
		query.append("            WHERE MNR_CD_ID = MRT.EDI_ERR_CD" ).append("\n"); 
		query.append("              AND PRNT_CD_ID = 'CD00076'" ).append("\n"); 
		query.append("              AND ROWNUM = 1)," ).append("\n"); 
		query.append("           'Error') AS RPR_STS_CD," ).append("\n"); 
		query.append("       MRT.RQST_REF_NO," ).append("\n"); 
		query.append("       MRT.COST_OFC_CD," ).append("\n"); 
		query.append("       '' AS AGMT_OFC_CD," ).append("\n"); 
		query.append("       'N' AS DMG_FLAG," ).append("\n"); 
		query.append("       MRT.CRE_USR_ID" ).append("\n"); 
		query.append("  FROM MNR_RPR_RQST_TMP_HDR MRT" ).append("\n"); 
		query.append(" WHERE MRT.EDI_ERR_CD <> 'SS'" ).append("\n"); 
		query.append("#if (${rqst_ref_no} != '')" ).append("\n"); 
		query.append("   AND MRT.RQST_REF_NO IN (" ).append("\n"); 
		query.append("			#foreach ($user_ref_no IN ${rqstRefNos})" ).append("\n"); 
		query.append("            	#if($velocityCount < $rqstRefNos.size())" ).append("\n"); 
		query.append("                	'$user_ref_no'," ).append("\n"); 
		query.append("               	#else" ).append("\n"); 
		query.append("                	'$user_ref_no'" ).append("\n"); 
		query.append("               	#end" ).append("\n"); 
		query.append("           	#end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rqst_eq_no} != '')" ).append("\n"); 
		query.append("   AND MRT.RQST_EQ_NO IN (" ).append("\n"); 
		query.append("        #foreach ($user_eq_no IN ${eqNos})" ).append("\n"); 
		query.append("            #if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("                '$user_eq_no'," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                '$user_eq_no'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("   AND MRT.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_est_dt} != '' && ${to_est_dt} != '')" ).append("\n"); 
		query.append("   AND MRT.RQST_DT BETWEEN" ).append("\n"); 
		query.append("       TO_DATE(REPLACE(@[fm_est_dt], '-', ''), 'yyyymmdd') AND (TO_DATE(REPLACE(@[to_est_dt], '-', ''), 'yyyymmdd') + 0.99999)" ).append("\n"); 
		query.append("   #if (${rqst_eq_no} == '' && ${rqst_ref_no} == '' && ${vndr_seq} == '')" ).append("\n"); 
		query.append("   AND MRT.COST_OFC_CD = @[cost_ofc_cd] " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}