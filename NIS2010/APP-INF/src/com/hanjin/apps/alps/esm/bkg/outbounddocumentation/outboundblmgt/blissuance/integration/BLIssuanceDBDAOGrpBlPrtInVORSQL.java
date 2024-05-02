/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAOGrpBlPrtInVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOGrpBlPrtInVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GrpBlPrtInVO
	  * </pre>
	  */
	public BLIssuanceDBDAOGrpBlPrtInVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOGrpBlPrtInVORSQL").append("\n"); 
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
		query.append("SELECT  '' AS DESC_INLND_SVC_MOD_CD" ).append("\n"); 
		query.append("       ,'' AS BKG_CGO_TP_CD" ).append("\n"); 
		query.append("       ,'' AS BOOKING_POL_CD" ).append("\n"); 
		query.append("       ,'' AS ADV_SHTG_CD_S" ).append("\n"); 
		query.append("       ,'' AS BKG_CGO_TP_CD_F" ).append("\n"); 
		query.append("       ,'' AS VVD_PRE_POL" ).append("\n"); 
		query.append("       ,'' AS OB_SREP_CD" ).append("\n"); 
		query.append("       ,'' AS ADV_SHTG_CD_A" ).append("\n"); 
		query.append("       ,'' AS OBL_ISS_USR_ID" ).append("\n"); 
		query.append("       ,'' AS DOC_USR_CD" ).append("\n"); 
		query.append("       ,'' AS PRCT_FLG" ).append("\n"); 
		query.append("       ,'' AS OBL_ISS_FROM_DT" ).append("\n"); 
		query.append("       ,'' AS QUERY_SORT" ).append("\n"); 
		query.append("       ,'' AS STWG_CD" ).append("\n"); 
		query.append("       ,'' AS SHPR_OWNR_CNTR_FLG" ).append("\n"); 
		query.append("       ,'' AS OB_SLS_OFC_CD" ).append("\n"); 
		query.append("       ,'' AS AES_ITN_Y" ).append("\n"); 
		query.append("       ,'' AS BKG_STS_CD_W" ).append("\n"); 
		query.append("       ,'' AS CUST_CNT_CD" ).append("\n"); 
		query.append("       ,'' AS OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("       ,'' AS BKG_OFC_CD" ).append("\n"); 
		query.append("       ,'' AS CUST_REF_NO" ).append("\n"); 
		query.append("       ,'' AS AWK_CGO_FLG" ).append("\n"); 
		query.append("       ,'' AS VVD_POL_LOCAL" ).append("\n"); 
		query.append("       ,'' AS ORG_SCONTI_CD" ).append("\n"); 
		query.append("       ,'' AS BOOKING_RCV_TERM_CD" ).append("\n"); 
		query.append("       ,'' AS BOOKING_DEL_CD" ).append("\n"); 
		query.append("       ,'' AS BKG_STS_CD_F" ).append("\n"); 
		query.append("       ,'' AS VVD" ).append("\n"); 
		query.append("       ,'' AS MASTER_BL_NO" ).append("\n"); 
		query.append("       ,'' AS BOOKING_POD_CD" ).append("\n"); 
		query.append("       ,'' AS WT_RSN_HLD_FLG" ).append("\n"); 
		query.append("       ,'' AS STOP_CARGO" ).append("\n"); 
		query.append("       ,'' AS EQ_POR_CD" ).append("\n"); 
		query.append("       ,'' AS SPCL_HIDE_FLG" ).append("\n"); 
		query.append("       ,'' AS CAED_Y" ).append("\n"); 
		query.append("       ,'' AS OBL_ISS_TO_DT" ).append("\n"); 
		query.append("       ,'' AS CAED_N" ).append("\n"); 
		query.append("       ,'' AS RC_FLG" ).append("\n"); 
		query.append("       ,'' AS BKG_RSN_SPCL_CGO_FLG" ).append("\n"); 
		query.append("       ,'' AS VVD_POD_CD" ).append("\n"); 
		query.append("       ,'' AS BOOKING_POR_CD" ).append("\n"); 
		query.append("       ,'' AS REVENUE_R" ).append("\n"); 
		query.append("       ,'' AS CUST_NM" ).append("\n"); 
		query.append("       ,'' AS REVENUE_N" ).append("\n"); 
		query.append("       ,'' AS HOG_DE_FLG" ).append("\n"); 
		query.append("       ,'' AS RD_CGO_FLG" ).append("\n"); 
		query.append("       ,'' AS BKG_STS_CD" ).append("\n"); 
		query.append("       ,'' AS FD_GRD_FLG" ).append("\n"); 
		query.append("       ,'' AS EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("       ,'' AS EQ_DEL_CD" ).append("\n"); 
		query.append("       ,'' AS VVD_POST_POD" ).append("\n"); 
		query.append("       ,'' AS DESC_SCONTI_CD" ).append("\n"); 
		query.append("       ,'' AS ORG_SVC_MOD_CD" ).append("\n"); 
		query.append("       ,'' AS ADV_SHTG_CD" ).append("\n"); 
		query.append("       ,'' AS EQ_SUBST_FLG" ).append("\n"); 
		query.append("       ,'' AS SC_RFA_CHK" ).append("\n"); 
		query.append("       ,'' AS RAIL_BLK_CD" ).append("\n"); 
		query.append("       ,'' AS CMDT_CD" ).append("\n"); 
		query.append("       ,'' AS BB_CGO_FLG" ).append("\n"); 
		query.append("       ,'' AS DCGO_FLG" ).append("\n"); 
		query.append("       ,'' AS VSL_PRE_PST_CD" ).append("\n"); 
		query.append("       ,'' AS CUST_TP_CD" ).append("\n"); 
		query.append("       ,'' AS CUST_TP_CD_S" ).append("\n"); 
		query.append("       ,'' AS REVENUE" ).append("\n"); 
		query.append("       ,'' AS CUST_TP_CD_N" ).append("\n"); 
		query.append("       ,'' AS VVD_POD_LOCAL" ).append("\n"); 
		query.append("       ,'' AS VVD_POST_VVD" ).append("\n"); 
		query.append("       ,'' AS CUST_TP_CD_F" ).append("\n"); 
		query.append("       ,'' AS CUST_TP_CD_G" ).append("\n"); 
		query.append("       ,'' AS VVD_POL_TS" ).append("\n"); 
		query.append("       ,'' AS AES_ITN_N" ).append("\n"); 
		query.append("       ,'' AS CUST_SEQ" ).append("\n"); 
		query.append("       ,'' AS VVD_PRE_VVD" ).append("\n"); 
		query.append("       ,'' AS TWN_SO_NO" ).append("\n"); 
		query.append("       ,'' AS CUST_TP_CD_C" ).append("\n"); 
		query.append("       ,'' AS VVD_POL_CD" ).append("\n"); 
		query.append("       ,'' AS CMDT_NM" ).append("\n"); 
		query.append("       ,'' AS CUST_TP_CD_A" ).append("\n"); 
		query.append("       ,'' AS VVD_POD_TS" ).append("\n"); 
		query.append("       ,'' AS SC_RFA_NO" ).append("\n"); 
		query.append("       ,'' AS BKG_CGO_TP_CD_R" ).append("\n"); 
		query.append("       ,'' AS BOOKING_DE_TERM_CD" ).append("\n"); 
		query.append("       ,'' AS BKG_CGO_TP_CD_P" ).append("\n"); 
		query.append("       ,'' AS HNGR_FLG" ).append("\n"); 
		query.append("       ,'' AS REP_CMDT_CD" ).append("\n"); 
		query.append("       ,'' AS OBL_ISS_DATE" ).append("\n"); 
		query.append("       ,'' AS SORT_HEADER" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}