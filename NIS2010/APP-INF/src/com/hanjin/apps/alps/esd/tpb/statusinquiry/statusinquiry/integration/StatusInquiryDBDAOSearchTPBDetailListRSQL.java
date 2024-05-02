/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : StatusInquiryDBDAOSearchTPBDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.29
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusInquiryDBDAOSearchTPBDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTPBDetailList
	  * </pre>
	  */
	public StatusInquiryDBDAOSearchTPBDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.integration").append("\n"); 
		query.append("FileName : StatusInquiryDBDAOSearchTPBDetailListRSQL").append("\n"); 
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
		query.append("SELECT   OD.N3PTY_NO" ).append("\n"); 
		query.append("       , OM.N3PTY_INV_NO" ).append("\n"); 
		query.append("       , OD.OTS_DTL_SEQ" ).append("\n"); 
		query.append("       , OD.N3PTY_NO_DP_SEQ" ).append("\n"); 
		query.append("       , OD.N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append("       , OD.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("       , TPB_GET_N3PTY_BIL_TP_NM_FNC(OD.N3PTY_BIL_TP_CD) AS N3PTY_BIL_TP_NM" ).append("\n"); 
		query.append("       , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01132',OD.EQ_KND_CD) AS EQ_KND_NM" ).append("\n"); 
		query.append("       , OD.EQ_NO" ).append("\n"); 
		query.append("       , OD.BKG_NO" ).append("\n"); 
		query.append("       , OD.BL_NO" ).append("\n"); 
		query.append("       , OM.VSL_CD||OM.SKD_VOY_NO||SUBSTR(OM.FINC_DIR_CD,1,1) AS REV_VVD" ).append("\n"); 
		query.append("       , OD.N3PTY_SRC_NO" ).append("\n"); 
		query.append("       , OD.IF_CURR_CD AS IF_CURR_CD" ).append("\n"); 
		query.append("       , OD.IF_AMT" ).append("\n"); 
		query.append("       , TPB_GET_INV_CURR_CHG_FNC(OD.IF_CURR_CD,'USD',OD.IF_AMT, OM.CFM_DT) AS IF_AMT_USD" ).append("\n"); 
		query.append("       , OD.CFM_CURR_CD AS CFM_CURR_CD" ).append("\n"); 
		query.append("       , OD.CFM_AMT" ).append("\n"); 
		query.append("       , NULL AS INV_CURR_CD" ).append("\n"); 
		query.append("       , OD.INV_AMT" ).append("\n"); 
		query.append("       , NULL AS CLT_CURR_CD" ).append("\n"); 
		query.append("       , OD.CLT_AMT" ).append("\n"); 
		query.append("       , OD.IF_OFC_CD" ).append("\n"); 
		query.append("       , OD.IF_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR( TPB_GET_LCL_DATE_FNC(OD.IF_DT, @[s_usr_ofc_cd]), 'YYYY-MM-DD HH24:MI') AS IF_DT" ).append("\n"); 
		query.append("       , OD.CFM_OFC_CD" ).append("\n"); 
		query.append("       , OD.CFM_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR( TPB_GET_LCL_DATE_FNC(OD.CFM_DT, @[s_usr_ofc_cd]), 'YYYY-MM-DD HH24:MI') AS CFM_DT" ).append("\n"); 
		query.append("       , CASE WHEN OS.OTS_STS_CD = 'E' THEN NULL" ).append("\n"); 
		query.append("              WHEN ( SELECT COUNT(1) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = OM.N3PTY_NO ) > 0 THEN TRUNC(SYSDATE - NVL((SELECT MAX(CRE_DT) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = OM.N3PTY_NO), OM.CFM_DT) )" ).append("\n"); 
		query.append("              ELSE TRUNC(SYSDATE - OM.CFM_DT)" ).append("\n"); 
		query.append("         END AS OVERDUE_DAYS" ).append("\n"); 
		query.append("       , OD.CFM_RMK" ).append("\n"); 
		query.append("FROM     TPB_OTS_GRP OM" ).append("\n"); 
		query.append("       , TPB_OTS_DTL OD" ).append("\n"); 
		query.append("       , TPB_OTS_GRP_STS OS" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      OD.N3PTY_NO = OM.N3PTY_NO AND OM.N3PTY_NO = OS.N3PTY_NO" ).append("\n"); 
		query.append("AND      OD.N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("AND      OD.N3PTY_BIL_TP_CD IN (SELECT N3PTY_BIL_TP_CD FROM TPB_N3RD_PTY_BIL_TP WHERE N3PTY_BIL_TP_CD <> 'JO')" ).append("\n"); 
		query.append("AND      OM.N3PTY_DELT_TP_CD IN ('N')" ).append("\n"); 
		query.append("AND      OS.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND      OM.N3PTY_INV_NO IS NULL" ).append("\n"); 
		query.append("AND      OS.OTS_STS_CD IN ('O','M','J','R','E')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_n3pty_no} != '') " ).append("\n"); 
		query.append("AND      OM.N3PTY_NO = @[s_n3pty_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_n3pty_inv_no} != '') " ).append("\n"); 
		query.append("AND      OM.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_n3pty_no} == '' && ${s_n3pty_inv_no} == '') " ).append("\n"); 
		query.append("AND      1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL                                                                                                           " ).append("\n"); 
		query.append("SELECT   OD.N3PTY_NO" ).append("\n"); 
		query.append("       , OM.N3PTY_INV_NO" ).append("\n"); 
		query.append("       , OD.OTS_DTL_SEQ" ).append("\n"); 
		query.append("       , OD.N3PTY_NO_DP_SEQ" ).append("\n"); 
		query.append("       , OD.N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append("       , OD.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("       , TPB_GET_N3PTY_BIL_TP_NM_FNC(OD.N3PTY_BIL_TP_CD) AS N3PTY_BIL_TP_NM" ).append("\n"); 
		query.append("       , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01132',OD.EQ_KND_CD) AS EQ_KND_NM" ).append("\n"); 
		query.append("       , OD.EQ_NO" ).append("\n"); 
		query.append("       , OD.BKG_NO" ).append("\n"); 
		query.append("       , OD.BL_NO" ).append("\n"); 
		query.append("       , OM.VSL_CD||OM.SKD_VOY_NO||SUBSTR(OM.FINC_DIR_CD,1,1) AS REV_VVD" ).append("\n"); 
		query.append("       , OD.N3PTY_SRC_NO" ).append("\n"); 
		query.append("       , OD.IF_CURR_CD AS IF_CURR_CD" ).append("\n"); 
		query.append("       , OD.IF_AMT" ).append("\n"); 
		query.append("       , TPB_GET_INV_CURR_CHG_FNC(OD.IF_CURR_CD,'USD',OD.IF_AMT, OM.CFM_DT) AS IF_AMT_USD" ).append("\n"); 
		query.append("       , OD.CFM_CURR_CD AS CFM_CURR_CD" ).append("\n"); 
		query.append("       , OD.CFM_AMT" ).append("\n"); 
		query.append("       , IM.CURR_CD AS INV_CURR_CD" ).append("\n"); 
		query.append("       , IM.INV_AMT AS INV_AMT" ).append("\n"); 
		query.append("       , DECODE(IM.N3PTY_INV_STS_CD,'A',IM.CURR_CD,NULL) AS CLT_CURR_CD" ).append("\n"); 
		query.append("       , DECODE(IM.N3PTY_INV_STS_CD,'A',IM.CLT_AMT,NULL) AS CLT_AMT" ).append("\n"); 
		query.append("       , OD.IF_OFC_CD" ).append("\n"); 
		query.append("       , OD.IF_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR( TPB_GET_LCL_DATE_FNC(OD.IF_DT, @[s_usr_ofc_cd]), 'YYYY-MM-DD HH24:MI') AS IF_DT" ).append("\n"); 
		query.append("       , OD.CFM_OFC_CD" ).append("\n"); 
		query.append("       , OD.CFM_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR( TPB_GET_LCL_DATE_FNC(OD.CFM_DT, @[s_usr_ofc_cd]), 'YYYY-MM-DD HH24:MI') AS CFM_DT" ).append("\n"); 
		query.append("       , CASE WHEN OS.OTS_STS_CD = 'E' THEN NULL" ).append("\n"); 
		query.append("              WHEN ( SELECT COUNT(1) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = OM.N3PTY_NO ) > 0 THEN TRUNC(SYSDATE - NVL((SELECT MAX(CRE_DT) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = OM.N3PTY_NO), OM.CFM_DT) ) --ROC해당경우 : ROC ACCEPTED DATE부터 현재일까지 계산" ).append("\n"); 
		query.append("              ELSE TRUNC(SYSDATE - OM.CFM_DT) --ROC아닌경우 : CONFIRMED DATE로 부터 현재일까지 계산" ).append("\n"); 
		query.append("         END AS OVERDUE_DAYS" ).append("\n"); 
		query.append("       , OD.CFM_RMK" ).append("\n"); 
		query.append("FROM     TPB_OTS_GRP OM" ).append("\n"); 
		query.append("       , TPB_OTS_DTL OD" ).append("\n"); 
		query.append("       , TPB_OTS_GRP_STS OS" ).append("\n"); 
		query.append("       , TPB_INVOICE IV" ).append("\n"); 
		query.append("       , TPB_INV_RVIS IM" ).append("\n"); 
		query.append("       , TPB_INV_RVIS_DTL ID" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      OM.N3PTY_NO = OD.N3PTY_NO" ).append("\n"); 
		query.append("AND      OM.N3PTY_NO = OS.N3PTY_NO" ).append("\n"); 
		query.append("AND      OM.N3PTY_INV_NO = IV.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND      IV.N3PTY_INV_NO = IM.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND      IV.LST_N3PTY_INV_RVIS_SEQ = IM.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("AND      IM.N3PTY_INV_NO = ID.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND      IM.N3PTY_INV_RVIS_SEQ = ID.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("AND      OD.N3PTY_NO = ID.N3PTY_NO" ).append("\n"); 
		query.append("AND      OD.OTS_DTL_SEQ = ID.OTS_DTL_SEQ" ).append("\n"); 
		query.append("AND      OD.N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("AND      OD.N3PTY_BIL_TP_CD IN (SELECT N3PTY_BIL_TP_CD FROM TPB_N3RD_PTY_BIL_TP WHERE N3PTY_BIL_TP_CD <> 'JO')" ).append("\n"); 
		query.append("AND      OM.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND      OS.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND      OS.OTS_STS_CD IN ('I','Y','A','L','N','E')" ).append("\n"); 
		query.append("AND      IV.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND      IM.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_n3pty_no} != '')" ).append("\n"); 
		query.append("AND      OM.N3PTY_NO = @[s_n3pty_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_n3pty_inv_no} != '') " ).append("\n"); 
		query.append("AND      OM.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_n3pty_no} == '' && ${s_n3pty_inv_no} == '') " ).append("\n"); 
		query.append("AND      1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY N3PTY_NO" ).append("\n"); 
		query.append("       , N3PTY_NO_DP_SEQ" ).append("\n"); 

	}
}