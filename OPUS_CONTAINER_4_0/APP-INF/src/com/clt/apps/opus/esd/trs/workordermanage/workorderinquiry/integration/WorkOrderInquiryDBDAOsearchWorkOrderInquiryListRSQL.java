/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderInquiryDBDAOsearchWorkOrderInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.25
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.04.25 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderInquiryDBDAOsearchWorkOrderInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWorkOrderInquiryList
	  * </pre>
	  */
	public WorkOrderInquiryDBDAOsearchWorkOrderInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_transmode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_issue_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("issue_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_issue_user",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_costmode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo_svc_provider",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderinquiry.integration").append("\n"); 
		query.append("FileName : WorkOrderInquiryDBDAOsearchWorkOrderInquiryListRSQL").append("\n"); 
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
		query.append("SELECT /*+ ORDERED  */" ).append("\n"); 
		query.append("	A.WO_VNDR_SEQ," ).append("\n"); 
		query.append("	NVL(MAX(H.WO_ISS_KNT) OVER (PARTITION BY A.TRSP_WO_OFC_CTY_CD, A.TRSP_WO_SEQ),1) MAX_KNT ," ).append("\n"); 
		query.append("	C.VNDR_LGL_ENG_NM AS VNDR_NM ," ).append("\n"); 
		query.append("	A.TRSP_WO_OFC_CTY_CD||A.TRSP_WO_SEQ AS TRSP_WO_OFC_CTY_CD ," ).append("\n"); 
		query.append("	A.TRSP_WO_SEQ ," ).append("\n"); 
		query.append("	H.WO_ISS_KNT ," ).append("\n"); 
		query.append("	H.CRE_OFC_CD ," ).append("\n"); 
		query.append("	A.CRE_USR_ID AS UPD_USR_ID ," ).append("\n"); 
		query.append("	H.INTER_USE_FLG ," ).append("\n"); 
		query.append("	D.USR_NM AS UPD_USR_NM ," ).append("\n"); 
		query.append("	B.TRSP_COST_DTL_MOD_CD ," ).append("\n"); 
		query.append("	COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00744',B.TRSP_COST_DTL_MOD_CD) AS TRSP_COST_DTL_MOD_NM ," ).append("\n"); 
		query.append("	B.TRSP_CRR_MOD_CD ," ).append("\n"); 
		query.append("	COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00283',B.TRSP_CRR_MOD_CD) AS TRSP_CRR_MOD_NM ," ).append("\n"); 
		query.append("	DECODE(A.WO_TRSP_STS_CD,'S','Started','P','Partially Completed','C','Completed') WO_TRSP_STS_CD ," ).append("\n"); 
		query.append("	H.WO_ISS_STS_CD AS WO_ISS_STS_CD," ).append("\n"); 
		query.append("	COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00804',H.WO_ISS_STS_CD) AS WO_ISS_STS_CD_NM," ).append("\n"); 
		query.append("	( (CASE WHEN H.WO_PRN_USE_FLG='Y' THEN 'PRN ' ELSE '' END) || " ).append("\n"); 
		query.append("	  (CASE WHEN H.WO_FAX_USE_FLG='Y' THEN 'FAX ' ELSE '' END)|| " ).append("\n"); 
		query.append("	  (CASE WHEN H.WO_EML_USE_FLG='Y' THEN 'EML ' ELSE '' END)|| " ).append("\n"); 
		query.append("	  (CASE WHEN H.WO_EDI_USE_FLG='Y' THEN 'EDI' ELSE '' END) " ).append("\n"); 
		query.append("	) AS WO_ISS_TP ," ).append("\n"); 
		query.append("	H.WO_PRN_USE_FLG ," ).append("\n"); 
		query.append("	H.WO_FAX_USE_FLG ," ).append("\n"); 
		query.append("	H.WO_EML_USE_FLG ," ).append("\n"); 
		query.append("	TO_CHAR(H.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') AS WO_ISS_DT ," ).append("\n"); 
		query.append("	H.WO_N1ST_FAX_NO ," ).append("\n"); 
		query.append("	H.WO_N2ND_FAX_NO ," ).append("\n"); 
		query.append("	H.WO_N3RD_FAX_NO ," ).append("\n"); 
		query.append("	H.WO_N1ST_EML ," ).append("\n"); 
		query.append("	H.WO_N2ND_EML ," ).append("\n"); 
		query.append("	H.WO_N3RD_EML ," ).append("\n"); 
		query.append("	DECODE(H.WO_N3RD_EML_RSLT_FLG, 'Y', 'Success', 'N', '') AS WO_EML3_STATUS ," ).append("\n"); 
		query.append("	CASE WHEN ( COUNT(B.EDI_RCV_RSLT_CD) OVER (PARTITION BY A.TRSP_WO_OFC_CTY_CD , A.TRSP_WO_SEQ , H.WO_ISS_KNT) ) <> ( COUNT(B.EDI_RCV_RSLT_CD) OVER (PARTITION BY A.TRSP_WO_OFC_CTY_CD , A.TRSP_WO_SEQ , H.WO_ISS_KNT , B.EDI_RCV_RSLT_CD) ) THEN 'N' " ).append("\n"); 
		query.append("		 ELSE B.EDI_RCV_RSLT_CD " ).append("\n"); 
		query.append("	END EDI_RCV_RSLT_CD ," ).append("\n"); 
		query.append("	TO_CHAR(B.EDI_RCV_RSLT_DT, 'YYYY-MM-DD HH24:MI:SS') AS EDI_RCV_RSLT_DT ," ).append("\n"); 
		query.append("	COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00959',FAX1.FAX_PROC_STS_CD) AS FAX1_STS_CD ," ).append("\n"); 
		query.append("	COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00959',FAX2.FAX_PROC_STS_CD) AS FAX2_STS_CD ," ).append("\n"); 
		query.append("	COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00959',FAX3.FAX_PROC_STS_CD) AS FAX3_STS_CD ," ).append("\n"); 
		query.append("	COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00960',EML1.EML_PROC_STS_CD) AS EML1_STS_CD ," ).append("\n"); 
		query.append("	COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00960',EML2.EML_PROC_STS_CD) AS EML2_STS_CD ," ).append("\n"); 
		query.append("	COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00960',EML3.EML_PROC_STS_CD) AS EML3_STS_CD ," ).append("\n"); 
		query.append("	B.FM_NOD_CD," ).append("\n"); 
		query.append("    DECODE(LENGTH(B.FM_NOD_CD), 7, TRS_COMMON_PKG.GET_YD_CD_NM_FNC(B.FM_NOD_CD), 5, (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = B.FM_NOD_CD))FM_NOD_CD_NM," ).append("\n"); 
		query.append("	B.TO_NOD_CD," ).append("\n"); 
		query.append("	DECODE(LENGTH(B.TO_NOD_CD), 7, TRS_COMMON_PKG.GET_YD_CD_NM_FNC(B.TO_NOD_CD), 5, (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = B.TO_NOD_CD))TO_NOD_CD_NM," ).append("\n"); 
		query.append("	B.VIA_NOD_CD," ).append("\n"); 
		query.append("	DECODE(LENGTH(B.VIA_NOD_CD), 7, TRS_COMMON_PKG.GET_YD_CD_NM_FNC(B.VIA_NOD_CD), 5, (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = B.VIA_NOD_CD))VIA_NOD_CD_NM," ).append("\n"); 
		query.append("	B.DOR_NOD_CD," ).append("\n"); 
		query.append("    DECODE(LENGTH(B.DOR_NOD_CD), 7, (SELECT ZN_NM FROM MDM_ZONE WHERE ZN_CD = B.DOR_NOD_CD), 5, (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = B.DOR_NOD_CD)) AS DOR_NOD_CD_NM,			" ).append("\n"); 
		query.append("	B.CURR_CD," ).append("\n"); 
		query.append("	SUM(NVL(B.BZC_AMT, 0)) BZC_AMT," ).append("\n"); 
		query.append("	SUM(NVL(B.ETC_ADD_AMT, 0)) ETC_ADD_AMT," ).append("\n"); 
		query.append("	SUM(NVL(B.FUEL_SCG_AMT, 0)) FUEL_SCG_AMT," ).append("\n"); 
		query.append("	SUM(NVL(B.NEGO_AMT, 0)) NEGO_AMT," ).append("\n"); 
		query.append("	SUM(NVL(B.BZC_AMT, 0) + NVL(B.ETC_ADD_AMT, 0) + NVL(B.FUEL_SCG_AMT, 0) + NVL(B.NEGO_AMT, 0)) TOTAL" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	TRS_TRSP_WRK_ORD A ," ).append("\n"); 
		query.append("	TRS_TRSP_WRK_ORD_HIS H ," ).append("\n"); 
		query.append("	COM_USER D ," ).append("\n"); 
		query.append("	COM_FAX_SND_INFO FAX1 ," ).append("\n"); 
		query.append("	COM_FAX_SND_INFO FAX2 ," ).append("\n"); 
		query.append("	COM_FAX_SND_INFO FAX3 ," ).append("\n"); 
		query.append("	COM_EML_SND_INFO EML1 ," ).append("\n"); 
		query.append("	COM_EML_SND_INFO EML2 ," ).append("\n"); 
		query.append("	COM_EML_SND_INFO EML3 ," ).append("\n"); 
		query.append("	MDM_VENDOR C ," ).append("\n"); 
		query.append("	TRS_TRSP_SVC_ORD B" ).append("\n"); 
		query.append("WHERE A.TRSP_WO_OFC_CTY_CD = B.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("	AND A.TRSP_WO_SEQ = B.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("	AND A.TRSP_WO_OFC_CTY_CD = H.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("	AND A.TRSP_WO_SEQ = H.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("	AND A.WO_VNDR_SEQ = C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("	AND NVL(B.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("	AND H.WO_N1ST_FAX_SND_NO = FAX1.FAX_SND_NO(+)" ).append("\n"); 
		query.append("	AND H.WO_N2ND_FAX_SND_NO = FAX2.FAX_SND_NO(+)" ).append("\n"); 
		query.append("	AND H.WO_N3RD_FAX_SND_NO = FAX3.FAX_SND_NO(+)" ).append("\n"); 
		query.append("	AND H.WO_N1ST_EML_SND_NO = EML1.EML_SND_NO(+)" ).append("\n"); 
		query.append("	AND H.WO_N2ND_EML_SND_NO = EML2.EML_SND_NO(+)" ).append("\n"); 
		query.append("	AND H.WO_N3RD_EML_SND_NO = EML3.EML_SND_NO(+)" ).append("\n"); 
		query.append("	AND A.CRE_USR_ID = D.USR_ID(+)" ).append("\n"); 
		query.append("	AND A.WO_ISS_STS_CD <> 'X'" ).append("\n"); 
		query.append("#if(${fmdate} != '' && ${todate} != '' )" ).append("\n"); 
		query.append("  AND A.LOCL_CRE_DT BETWEEN TO_DATE(@[fmdate]||'000001', 'YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959', 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${combo_svc_provider} != '')" ).append("\n"); 
		query.append("  AND A.WO_VNDR_SEQ = @[combo_svc_provider]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($wo_no.size() > 0)  " ).append("\n"); 
		query.append("AND (A.TRSP_WO_OFC_CTY_CD,A.TRSP_WO_SEQ) IN (" ).append("\n"); 
		query.append("	#foreach($code IN ${wo_no})  " ).append("\n"); 
		query.append("		#if($velocityCount == 1)  " ).append("\n"); 
		query.append(" 			(SUBSTR('$code', 1, 3),SUBSTR('$code', 4))" ).append("\n"); 
		query.append("		#else  " ).append("\n"); 
		query.append("		   ,(SUBSTR('$code', 1, 3),SUBSTR('$code', 4))  " ).append("\n"); 
		query.append("		#end  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${wo_issue_office} != '')" ).append("\n"); 
		query.append("  AND A.CRE_OFC_CD = @[wo_issue_office]" ).append("\n"); 
		query.append("  AND H.CRE_OFC_CD = @[wo_issue_office]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${wo_issue_user} != '')" ).append("\n"); 
		query.append("  AND A.CRE_USR_ID = @[wo_issue_user]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${wo_iss_sts} != '' && ${wo_iss_sts} != 'ALL')" ).append("\n"); 
		query.append("  AND H.WO_ISS_STS_CD = @[wo_iss_sts]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sel_costmode} != '' && ${sel_costmode} != 'ALL')" ).append("\n"); 
		query.append("  AND B.TRSP_COST_DTL_MOD_CD = @[sel_costmode]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${issue_type} != '' && ${issue_type} =='PR')" ).append("\n"); 
		query.append("  AND DECODE(H.WO_PRN_USE_FLG, 'Y', 'PR', '') = @[issue_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${issue_type} != '' && ${issue_type} =='FA')" ).append("\n"); 
		query.append("  AND DECODE(H.WO_FAX_USE_FLG, 'Y', 'FA', '') = @[issue_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${issue_type} != '' && ${issue_type} =='EM')" ).append("\n"); 
		query.append("  AND DECODE(H.WO_EML_USE_FLG, 'Y', 'EM', '') = @[issue_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${issue_type} != '' && ${issue_type} =='ED')" ).append("\n"); 
		query.append("  AND DECODE(H.WO_EDI_USE_FLG, 'Y', 'ED', '') = @[issue_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sel_transmode} != '' && ${sel_transmode} != 'ALL')" ).append("\n"); 
		query.append("  AND B.TRSP_CRR_MOD_CD = @[sel_transmode]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.WO_VNDR_SEQ, C.VNDR_LGL_ENG_NM, H.CRE_OFC_CD, A.CRE_USR_ID, H.INTER_USE_FLG, D.USR_NM, B.TRSP_COST_DTL_MOD_CD, B.TRSP_CRR_MOD_CD, H.WO_ISS_STS_CD, H.WO_PRN_USE_FLG, H.WO_FAX_USE_FLG, H.WO_EML_USE_FLG, H.WO_EDI_USE_FLG, H.LOCL_CRE_DT, H.WO_N1ST_FAX_NO, H.WO_N2ND_FAX_NO, H.WO_N3RD_FAX_NO, H.WO_N1ST_EML, H.WO_N2ND_EML, H.WO_N3RD_EML, H.WO_N3RD_EML_RSLT_FLG, B.EDI_RCV_RSLT_CD, B.EDI_RCV_RSLT_DT, FAX1.FAX_PROC_STS_CD, FAX2.FAX_PROC_STS_CD, FAX3.FAX_PROC_STS_CD, EML1.EML_PROC_STS_CD, EML2.EML_PROC_STS_CD, EML3.EML_PROC_STS_CD, B.FM_NOD_CD, B.TO_NOD_CD, B.VIA_NOD_CD, B.DOR_NOD_CD, B.CURR_CD, A.TRSP_WO_OFC_CTY_CD, A.TRSP_WO_SEQ, H.WO_ISS_KNT, A.WO_ISS_STS_CD,A.WO_TRSP_STS_CD" ).append("\n"); 
		query.append("ORDER BY TRSP_WO_OFC_CTY_CD, A.TRSP_WO_SEQ, H.WO_ISS_KNT" ).append("\n"); 

	}
}