/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RepairMgtDBDAOsearchExtraWODetailDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.25 
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

public class RepairMgtDBDAOsearchExtraWODetailDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchExtraWODetailData select
	  * </pre>
	  */
	public RepairMgtDBDAOsearchExtraWODetailDataRSQL(){
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
		params.put("mnr_ord_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchExtraWODetailDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("         A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,A.MNR_ORD_SEQ" ).append("\n"); 
		query.append("        ,A.ORD_DTL_SEQ" ).append("\n"); 
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
		query.append("        ,A.PAY_INV_SEQ" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.CRE_DT, @[cost_ofc_cd]), 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.UPD_DT, @[cost_ofc_cd]), 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("        , B.CRNT_YD_CD MNR_HNGR_FLG_YD_CD" ).append("\n"); 
		query.append("        , B.HNGR_RCK_CD MNR_HNGR_RCK_CD" ).append("\n"); 
		query.append("        , B.BAR_ATCH_KNT RECENT_RPR_QTY" ).append("\n"); 
		query.append("        ,A.MNR_HNGR_DTL_OFFR_DESC" ).append("\n"); 
		query.append("		,A.MNR_HNGR_TRF_CD" ).append("\n"); 
		query.append("		,A.MNR_HNGR_TRF_OTR_DESC" ).append("\n"); 
		query.append("		,A.MNR_HNGR_DMG_QTY" ).append("\n"); 
		query.append("		,A.ACT_INVT_QTY" ).append("\n"); 
		query.append("		,A.MNR_LOST_HNGR_QTY" ).append("\n"); 
		query.append("		,A.MNR_DISP_HNGR_QTY" ).append("\n"); 
		query.append("		,A.BKG_NO" ).append("\n"); 
		query.append("        ,A.TRD_CD" ).append("\n"); 
		query.append("        ,A.MNR_INP_TP_CD" ).append("\n"); 
		query.append("FROM  MNR_ORD_DTL A, MNR_EQ_STS_V B" ).append("\n"); 
		query.append("WHERE A.MNR_ORD_OFC_CTY_CD =  @[mnr_ord_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   A.MNR_ORD_SEQ = @[mnr_ord_seq]" ).append("\n"); 
		query.append("AND   A.EQ_NO = B.EQ_NO(+)" ).append("\n"); 

	}
}