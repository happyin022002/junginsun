/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOBkgInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.23
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2015.10.23 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOBkgInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO용
	  * </pre>
	  */
	public ConstraintMasterDBDAOBkgInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOBkgInfoListRSQL").append("\n"); 
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
		query.append("  SELECT '' AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append("	,'' AGMT_ACT_CUST_CODE" ).append("\n"); 
		query.append("	,'' AGMT_ACT_CUST_SEQ" ).append("\n"); 
		query.append("	,'' AGMT_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("	,'' AGMT_YN" ).append("\n"); 
		query.append("	,'' ALOC_LOD_QTY" ).append("\n"); 
		query.append("	,'' ALOC_LOD_QTY_RTO" ).append("\n"); 
		query.append("	,'' ALOC_LOD_YN" ).append("\n"); 
		query.append("	,'' ALOC_RTO_YN" ).append("\n"); 
		query.append("	,'' ALOC_SVC_CD" ).append("\n"); 
		query.append("	,'' ALOC_USE_FLG" ).append("\n"); 
		query.append("	,'' APLY_FM_YRWK" ).append("\n"); 
		query.append("	,'' APLY_TO_YRWK" ).append("\n"); 
		query.append("	,'' ASGN_TTL_WGT" ).append("\n"); 
		query.append("	,'' ASGN_TTL_WGT_YN" ).append("\n"); 
		query.append("	,'' ASGN_WGT_RTO" ).append("\n"); 
		query.append("	,'' ASGN_WGT_RTO_YN" ).append("\n"); 
		query.append("	,'' AWK_CGO_FLG" ).append("\n"); 
		query.append("	,'' BKG_ALOC_RMK" ).append("\n"); 
		query.append("	,'' BKG_ALOC_SEQ" ).append("\n"); 
		query.append("	,'' BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("	,'' BKG_CTRL_TP_CD" ).append("\n"); 
		query.append("	,'' BKG_DEL_CNT_CD" ).append("\n"); 
		query.append("	,'' BKG_DEL_CNT_YN" ).append("\n"); 
		query.append("	,'' BKG_DEL_SCC_CD" ).append("\n"); 
		query.append("	,'' BKG_DEL_SCC_YN" ).append("\n"); 
		query.append("	,'' BKG_NO" ).append("\n"); 
		query.append("	,'' BKG_POD_CNT_CD" ).append("\n"); 
		query.append("	,'' BKG_POD_CNT_YN" ).append("\n"); 
		query.append("	,'' BKG_POL_CNT_CD" ).append("\n"); 
		query.append("	,'' BKG_POL_CNT_YN" ).append("\n"); 
		query.append("	,'' BKG_POR_CNT_CD" ).append("\n"); 
		query.append("	,'' BKG_POR_CNT_YN" ).append("\n"); 
		query.append("	,'' BKG_POR_SCC_CD" ).append("\n"); 
		query.append("	,'' BKG_POR_SCC_YN" ).append("\n"); 
		query.append("	,'' BKG_TEU_QTY" ).append("\n"); 
		query.append("	,'' BL_NO" ).append("\n"); 
		query.append("	,'' CMDT_CD" ).append("\n"); 
		query.append("	,'' CMDT_NM" ).append("\n"); 
		query.append("	,'' CMDT_YN" ).append("\n"); 
		query.append("	,'' CMPB_AMT" ).append("\n"); 
		query.append("	,'' CMPB_YN" ).append("\n"); 
		query.append("	,'' CNEE_CUST_CNT_CD" ).append("\n"); 
		query.append("	,'' CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,'' CNTR_TPSZ_YN" ).append("\n"); 
		query.append("	,'' CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("	,'' CTRT_CUST_CODE" ).append("\n"); 
		query.append("	,'' CTRT_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("	,'' CTRT_CUST_SEQ" ).append("\n"); 
		query.append("	,'' CTRT_OFC_CD" ).append("\n"); 
		query.append("	,'' CTRT_YN" ).append("\n"); 
		query.append("	,'' DEL_CD" ).append("\n"); 
		query.append("	,'' DEL_NM" ).append("\n"); 
		query.append("	,'' DEL_NOD_CD" ).append("\n"); 
		query.append("	,'' DEL_NOD_YN" ).append("\n"); 
		query.append("	,'' DEL_YN" ).append("\n"); 
		query.append("	,'' DG_FLG" ).append("\n"); 
		query.append("	,'' DG_RD_YN" ).append("\n"); 
		query.append("	,'' F_HEADER" ).append("\n"); 
		query.append("	,'' F_HEADERNM" ).append("\n"); 
		query.append("	,'' FWDR_CUST_CNT_CD" ).append("\n"); 
		query.append("	,'' HNGR_FLG" ).append("\n"); 
		query.append("	,'' N1ST_TS_DIR_CD" ).append("\n"); 
		query.append("	,'' N1ST_TS_DIR_YN" ).append("\n"); 
		query.append("	,'' N1ST_TS_POD_CD" ).append("\n"); 
		query.append("	,'' N1ST_TS_POD_CNT_CD" ).append("\n"); 
		query.append("	,'' N1ST_TS_POD_CNT_YN" ).append("\n"); 
		query.append("	,'' N1ST_TS_POD_YN" ).append("\n"); 
		query.append("	,'' N1ST_TS_POL_CD" ).append("\n"); 
		query.append("	,'' N1ST_TS_POL_CNT_CD" ).append("\n"); 
		query.append("	,'' N1ST_TS_POL_CNT_YN" ).append("\n"); 
		query.append("	,'' N1ST_TS_POL_YN" ).append("\n"); 
		query.append("	,'' N1ST_TS_SLAN_CD" ).append("\n"); 
		query.append("	,'' N1ST_TS_SLAN_YN" ).append("\n"); 
		query.append("	,'' OB_SLS_OFC_CD" ).append("\n"); 
		query.append("	,'' OB_SLS_OFC_NM" ).append("\n"); 
		query.append("	,'' OB_SLS_OFC_YN" ).append("\n"); 
		query.append("	,'' OFT_CHG_AMT" ).append("\n"); 
		query.append("	,'' OFT_CHG_YN" ).append("\n"); 
		query.append("	,'' OP_CNTR_QTY" ).append("\n"); 
		query.append("	,'' ORG_DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append("	,'' PGM" ).append("\n"); 
		query.append("	,'' POD_CD" ).append("\n"); 
		query.append("	,'' POD_CD_YN" ).append("\n"); 
		query.append("	,'' POD_NM" ).append("\n"); 
		query.append("	,'' POD_NOD_CD" ).append("\n"); 
		query.append("	,'' POD_NOD_YN" ).append("\n"); 
		query.append("	,'' POL_CD" ).append("\n"); 
		query.append("	,'' POL_NM" ).append("\n"); 
		query.append("	,'' POL_NOD_CD" ).append("\n"); 
		query.append("	,'' POL_NOD_YN" ).append("\n"); 
		query.append("	,'' POL_YN" ).append("\n"); 
		query.append("	,'' POR_CD" ).append("\n"); 
		query.append("	,'' POR_NM" ).append("\n"); 
		query.append("	,'' POR_NOD_CD" ).append("\n"); 
		query.append("	,'' POR_NOD_YN" ).append("\n"); 
		query.append("	,'' POR_YN" ).append("\n"); 
		query.append("	,'' RC_FLG" ).append("\n"); 
		query.append("	,'' RCV_DE_TERM_CD" ).append("\n"); 
		query.append("	,'' RD_FLG" ).append("\n"); 
		query.append("	,'' REP_CMDT_CD" ).append("\n"); 
		query.append("	,'' RFA_NO" ).append("\n"); 
		query.append("	,'' RFA_YN" ).append("\n"); 
		query.append("	,'' RPT_FOM_NM" ).append("\n"); 
		query.append("	,'' SC_NO" ).append("\n"); 
		query.append("	,'' SC_YN" ).append("\n"); 
		query.append("	,'' SCG_GRP_CMDT_DESC" ).append("\n"); 
		query.append("	,'' SCG_GRP_CMDT_SEQ" ).append("\n"); 
		query.append("	,'' SCG_GRP_CMDT_YN" ).append("\n"); 
		query.append("	,'' SHPR_CUST_CNT_CD" ).append("\n"); 
		query.append("	,'' SHPR_CUST_CODE" ).append("\n"); 
		query.append("	,'' SHPR_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("	,'' SHPR_CUST_SEQ" ).append("\n"); 
		query.append("	,'' SHPR_YN" ).append("\n"); 
		query.append("	,'' SLS_RHQ_CD" ).append("\n"); 
		query.append("	,'' STWG_FLG" ).append("\n"); 
		query.append("	,'' SUB_TRD_CD" ).append("\n"); 
		query.append("	,'' SUB_TRD_YN" ).append("\n"); 
		query.append("	,'' TAA_NO" ).append("\n"); 
		query.append("	,'' TRNK_DIR_CD" ).append("\n"); 
		query.append("	,'' TRNK_DIR_YN" ).append("\n"); 
		query.append("	,'' TRNK_POD_YN" ).append("\n"); 
		query.append("	,'' TRNK_POL_YN" ).append("\n"); 
		query.append("	,'' TRNK_SLAN_CD" ).append("\n"); 
		query.append("	,'' TRNK_SLAN_YN" ).append("\n"); 
		query.append("	,'' TRUNK_POD_CD" ).append("\n"); 
		query.append("	,'' TRUNK_POL_CD" ).append("\n"); 
		query.append("	,'' UPD_DT" ).append("\n"); 
		query.append("	,'' UPD_USR_ID" ).append("\n"); 
		query.append("	,'' US_YN" ).append("\n"); 
		query.append("	,'' USA_BKG_MOD_CD" ).append("\n"); 
		query.append("	,'' VVD" ).append("\n"); 
		query.append("	,'' VVD_YN" ).append("\n"); 
		query.append("	,'' TS_NOD_CD" ).append("\n"); 
		query.append("	,'' TS_NOD_YN" ).append("\n"); 
		query.append("	,'' TS_POL_NOD_CD" ).append("\n"); 
		query.append("	,'' TS_POL_NOD_YN" ).append("\n"); 
		query.append("	,'' TS_POD_NOD_CD" ).append("\n"); 
		query.append("	,'' TS_POD_NOD_YN" ).append("\n"); 
		query.append("     FROM DUAL" ).append("\n"); 

	}
}