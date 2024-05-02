/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairMgtDBDAOsearchRPRCreateFileListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.02.11 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchRPRCreateFileListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRPRCreateFileListData
	  * </pre>
	  */
	public RepairMgtDBDAOsearchRPRCreateFileListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("inp_msg3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchRPRCreateFileListDataRSQL").append("\n"); 
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
		query.append("SELECT   A.TMP_SEQ" ).append("\n"); 
		query.append(",A.TMP_DTL_SEQ" ).append("\n"); 
		query.append(",A.INP_MSG1" ).append("\n"); 
		query.append(",A.INP_MSG2" ).append("\n"); 
		query.append(",A.INP_MSG3" ).append("\n"); 
		query.append(",A.INP_MSG4" ).append("\n"); 
		query.append(",B.MNR_CD_DP_DESC AS INP_MSG5" ).append("\n"); 
		query.append(",C.MNR_ORD_OFC_CTY_CD AS INP_MSG6" ).append("\n"); 
		query.append(",C.MNR_ORD_OFC_CTY_CD || '' || C.MNR_ORD_SEQ  AS INP_MSG7" ).append("\n"); 
		query.append(",C.ORD_DTL_SEQ AS INP_MSG8" ).append("\n"); 
		query.append(",D.EQ_KND_CD AS INP_MSG9" ).append("\n"); 
		query.append(",C.COST_CD AS INP_MSG10" ).append("\n"); 
		query.append(",C.ACCT_CD AS INP_MSG11" ).append("\n"); 
		query.append(",C.COST_DTL_CD AS INP_MSG12" ).append("\n"); 
		query.append(",C.RPR_OFFH_FLG  AS INP_MSG13" ).append("\n"); 
		query.append(",C.MNR_RT_TP_CD AS INP_MSG14" ).append("\n"); 
		query.append(",C.MNR_EXPN_DTL_NM  AS INP_MSG15" ).append("\n"); 
		query.append(",C.EQ_NO AS INP_MSG16" ).append("\n"); 
		query.append(",A.INP_MSG1 AS INP_MSG17" ).append("\n"); 
		query.append(",C.EQ_TPSZ_CD AS INP_MSG18" ).append("\n"); 
		query.append(",C.RQST_REF_NO AS INP_MSG19" ).append("\n"); 
		query.append(",C.MNR_HNGR_BAR_TP_CD AS INP_MSG20" ).append("\n"); 
		query.append(",C.SPR_PRT_UT_TP_NM AS INP_MSG21" ).append("\n"); 
		query.append(",C.SPR_PRT_NO AS INP_MSG22" ).append("\n"); 
		query.append(",C.SPR_PRT_NM AS INP_MSG23" ).append("\n"); 
		query.append(",C.YD_CD AS INP_MSG24" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),C.RPR_RSLT_DT, @[cost_ofc_cd]),'yyyy-mm-dd') AS INP_MSG25" ).append("\n"); 
		query.append(",C.RPR_QTY AS INP_MSG26" ).append("\n"); 
		query.append(",C.SPR_PRT_UC_AMT AS INP_MSG27" ).append("\n"); 
		query.append(",C.BZC_AMT AS INP_MSG28" ).append("\n"); 
		query.append(",C.COST_AMT AS INP_MSG29" ).append("\n"); 
		query.append(",C.N3PTY_FLG AS INP_MSG30" ).append("\n"); 
		query.append(",C.N3PTY_BIL_TTL_AMT AS INP_MSG30" ).append("\n"); 
		query.append(",C.INV_AMT AS INP_MSG32" ).append("\n"); 
		query.append(",C.MNR_VRFY_TP_CD AS INP_MSG33" ).append("\n"); 
		query.append(",C.ORD_DTL_RMK AS INP_MSG34" ).append("\n"); 
		query.append(",C.INV_NO AS INP_MSG35" ).append("\n"); 
		query.append(",C.FILE_SEQ AS INP_MSG36" ).append("\n"); 
		query.append(",C.RPR_RQST_SEQ AS INP_MSG37" ).append("\n"); 
		query.append(",C.RPR_RQST_VER_NO AS INP_MSG38" ).append("\n"); 
		query.append(",NVL(C.PAY_INV_SEQ,0) AS INP_MSG39" ).append("\n"); 
		query.append(",C.CRE_USR_ID AS INP_MSG40" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), C.CRE_DT, @[cost_ofc_cd]),'yyyy-mm-dd')  AS INP_MSG40" ).append("\n"); 
		query.append(",CASE WHEN LENGTH(NVL(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),C.RPR_RSLT_DT, @[cost_ofc_cd]),'yyyy-mm-dd'),' ')) < 4" ).append("\n"); 
		query.append("THEN '' ELSE A.UPD_USR_ID END AS INP_MSG42" ).append("\n"); 
		query.append(",TO_CHAR(C.UPD_DT, 'yyyy-mm-dd') AS INP_MSG43" ).append("\n"); 
		query.append(",(SELECT" ).append("\n"); 
		query.append("VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM mdm_vendor" ).append("\n"); 
		query.append("WHERE VNDR_SEQ=D.VNDR_SEQ" ).append("\n"); 
		query.append("-- AND OFC_CD =B.COST_OFC_CD" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append(") AS INP_MSG44" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),E.RQST_DT, @[cost_ofc_cd]),'yyyy-mm-dd') AS INP_MSG45" ).append("\n"); 
		query.append(",(SELECT MNR_CD_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID ='CD00008' AND MNR_CD_ID=E.RPR_STS_CD) AS INP_MSG46" ).append("\n"); 
		query.append(",(SELECT MNR_DMG_FLG FROM MNR_EQ_STS WHERE EQ_NO = C.EQ_NO AND EQ_KND_CD=D.EQ_KND_CD  AND EQ_TPSZ_CD=C.EQ_TPSZ_CD) AS INP_MSG47" ).append("\n"); 
		query.append(",TRUNC(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),TO_DATE(@[inp_msg3],'YYYYMMDD'), @[cost_ofc_cd])  - GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),C.CRE_DT,  @[cost_ofc_cd])) AS INP_MSG47" ).append("\n"); 
		query.append(",DECODE(A.INP_MSG4,'SS',1,0) AS CHECKBOX" ).append("\n"); 
		query.append("FROM MNR_DAT_VRFY A," ).append("\n"); 
		query.append("(SELECT MNR_CD_ID, MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD" ).append("\n"); 
		query.append("WHERE PRNT_CD_ID = 'CD00004') B" ).append("\n"); 
		query.append(",MNR_ORD_DTL C, MNR_ORD_HDR D, MNR_RPR_RQST_HDR E" ).append("\n"); 
		query.append("WHERE A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND A.INP_MSG4 = B.MNR_CD_ID(+)" ).append("\n"); 
		query.append("AND A.INP_MSG1 = C.EQ_NO(+)" ).append("\n"); 
		query.append("AND A.INP_MSG2 = C.YD_CD(+)" ).append("\n"); 
		query.append("AND C.MNR_ORD_OFC_CTY_CD = D.MNR_ORD_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND C.MNR_ORD_SEQ = D.MNR_ORD_SEQ(+)" ).append("\n"); 
		query.append("AND C.EQ_NO=E.RQST_EQ_NO(+)" ).append("\n"); 
		query.append("AND C.RPR_RQST_SEQ=E.RPR_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND C.RPR_RQST_VER_NO=E.RPR_RQST_VER_NO(+)" ).append("\n"); 
		query.append("AND D.VNDR_SEQ(+) = @[vndr_seq]" ).append("\n"); 

	}
}