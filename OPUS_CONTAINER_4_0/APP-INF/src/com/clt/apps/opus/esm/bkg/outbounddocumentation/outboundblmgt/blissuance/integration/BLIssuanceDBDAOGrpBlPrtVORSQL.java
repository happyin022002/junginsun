/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAOGrpBlPrtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOGrpBlPrtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GrpBlPrtVO
	  * </pre>
	  */
	public BLIssuanceDBDAOGrpBlPrtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOGrpBlPrtVORSQL").append("\n"); 
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
		query.append("SELECT  '' AS ORDERBY_TITLE" ).append("\n"); 
		query.append("       ,'' AS BKG_NO" ).append("\n"); 
		query.append("       ,'' AS POL_POD" ).append("\n"); 
		query.append("       ,'' AS BL_NO" ).append("\n"); 
		query.append("       ,'' AS POR" ).append("\n"); 
		query.append("       ,'' AS POL" ).append("\n"); 
		query.append("       ,'' AS POD" ).append("\n"); 
		query.append("       ,'' AS DEL" ).append("\n"); 
		query.append("       ,'' AS R_TERM" ).append("\n"); 
		query.append("       ,'' AS D_TERM" ).append("\n"); 
		query.append("       ,'' AS RLY_POL_CD" ).append("\n"); 
		query.append("       ,'' AS RLY_POD_CD" ).append("\n"); 
		query.append("       ,'' AS REP" ).append("\n"); 
		query.append("       ,'' AS COMMODITY" ).append("\n"); 
		query.append("       ,'' AS D_SC" ).append("\n"); 
		query.append("       ,'' AS R_SC" ).append("\n"); 
		query.append("       ,'' AS A_SC" ).append("\n"); 
		query.append("       ,'' AS B_SC" ).append("\n"); 
		query.append("       ,'' AS A_S" ).append("\n"); 
		query.append("       ,'' AS ST" ).append("\n"); 
		query.append("       ,'' AS BDR" ).append("\n"); 
		query.append("       ,'' AS CA" ).append("\n"); 
		query.append("       ,'' AS TWN_SO_NO" ).append("\n"); 
		query.append("       ,'' AS POR_EQ" ).append("\n"); 
		query.append("       ,'' AS DEL_EQ" ).append("\n"); 
		query.append("       ,'' AS SC_RFA_NO" ).append("\n"); 
		query.append("       ,'' AS AES" ).append("\n"); 
		query.append("       ,'' AS CAED" ).append("\n"); 
		query.append("       ,'' AS MANIFEST" ).append("\n"); 
		query.append("       ,'' AS RATE" ).append("\n"); 
		query.append("       ,'' AS SHIPPER" ).append("\n"); 
		query.append("       ,'' AS CONSIGNEE" ).append("\n"); 
		query.append("       ,'' AS ORDER_COL" ).append("\n"); 
		query.append("       ,'' AS BL_BKG_NO" ).append("\n"); 
		query.append("       ,'' AS BL_ACT_WGT" ).append("\n"); 
		query.append("       ,'' AS BL_MEAS_QTY" ).append("\n"); 
		query.append("       ,'' AS OBL_ISS_FLG" ).append("\n"); 
		query.append("       ,'' AS OBL_PRN_FLG" ).append("\n"); 
		query.append("       ,'' AS OBL_RLSE_FLG" ).append("\n"); 
		query.append("       ,'' BKG_CRE_DT" ).append("\n"); 
		query.append("       ,'' BKG_OFC_CD" ).append("\n"); 
		query.append("       ,'' OB_SLS_OFC_CD" ).append("\n"); 
		query.append("       ,'' DOC_USR_ID" ).append("\n"); 
		query.append("       ,'' OB_SREP_CD" ).append("\n"); 
		query.append("       ,'' BKG_STS_CD" ).append("\n"); 
		query.append("       ,'' FFDR" ).append("\n"); 
		query.append("       ,'' NTFY" ).append("\n"); 
		query.append("       ,'' RCV_TERM_CD" ).append("\n"); 
		query.append("       ,'' DE_TERM_CD" ).append("\n"); 
		query.append("       ,'' ORG_SVC" ).append("\n"); 
		query.append("       ,'' DST_SVC" ).append("\n"); 
		query.append("       ,'' BKG_ORG_ROUTE" ).append("\n"); 
		query.append("       ,'' BKG_DST_ROUTE" ).append("\n"); 
		query.append("       ,'' POR_CD" ).append("\n"); 
		query.append("       ,'' POL_CD" ).append("\n"); 
		query.append("       ,'' POD_CD" ).append("\n"); 
		query.append("       ,'' DEL_CD" ).append("\n"); 
		query.append("       ,'' SORT_PRE_POL" ).append("\n"); 
		query.append("       ,'' SORT_PRE_POD" ).append("\n"); 
		query.append("       ,'' SORT_POST_POL" ).append("\n"); 
		query.append("       ,'' SORT_POST_POD" ).append("\n"); 
		query.append("       ,'' TRUNK_VVD" ).append("\n"); 
		query.append("       ,'' SORT_PRE_VVD" ).append("\n"); 
		query.append("       ,'' SORT_POST_VVD" ).append("\n"); 
		query.append("       ,'' TRUNK_POL" ).append("\n"); 
		query.append("       ,'' TRUNK_POD" ).append("\n"); 
		query.append("       ,'' BKG_LANE" ).append("\n"); 
		query.append("       ,'' OBL_ISS_USR_ID" ).append("\n"); 
		query.append("       ,'' OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("       ,'' BKG_CGO_TP" ).append("\n"); 
		query.append("       ,'' CHINA_AGENT_CD" ).append("\n"); 
		query.append("       ,'' POR_EQ_OFC" ).append("\n"); 
		query.append("       ,'' DEL_EQ_OFC" ).append("\n"); 
		query.append("       ,'' SC_NO" ).append("\n"); 
		query.append("       ,'' SHPR_NAME" ).append("\n"); 
		query.append("       ,'' CNEE_NAME" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}