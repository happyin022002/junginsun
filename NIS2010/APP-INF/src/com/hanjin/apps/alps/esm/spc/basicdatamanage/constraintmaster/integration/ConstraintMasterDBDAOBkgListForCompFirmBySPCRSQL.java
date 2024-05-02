/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ConstraintMasterDBDAOBkgListForCompFirmBySPCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.12
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.07.12 최성민
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

public class ConstraintMasterDBDAOBkgListForCompFirmBySPCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO용
	  * </pre>
	  */
	public ConstraintMasterDBDAOBkgListForCompFirmBySPCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOBkgListForCompFirmBySPCRSQL").append("\n"); 
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
		query.append("SELECT  '' as A_CUST" ).append("\n"); 
		query.append("	, '' as ALOC_STS_CD" ).append("\n"); 
		query.append("	, '' as ALOC_SVC_CD" ).append("\n"); 
		query.append("	, '' as BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("	, '' as BKG_NO" ).append("\n"); 
		query.append("	, '' as BKG_STS_CD" ).append("\n"); 
		query.append("	, '' as BKG_VVD_CD" ).append("\n"); 
		query.append("	, '' as BL_NO" ).append("\n"); 
		query.append("	, '' as C_CUST" ).append("\n"); 
		query.append("	, '' as CFM_DT" ).append("\n"); 
		query.append("	, '' as CFM_RQST_FLG" ).append("\n"); 
		query.append("	, '' as CFM_USR_ID" ).append("\n"); 
		query.append("	, '' as CMDT_CD" ).append("\n"); 
		query.append("	, '' as CMDT_DESC" ).append("\n"); 
		query.append("	, '' as CNDDT_CFM_FLG" ).append("\n"); 
		query.append("	, '' as CNEE" ).append("\n"); 
		query.append("	, '' as CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	, '' as DEL_LOC_CD" ).append("\n"); 
		query.append("	, '' as DEL_NOD_CD" ).append("\n"); 
		query.append("	, '' as DEL_SCC_CD" ).append("\n"); 
		query.append("	, '' as DGRD" ).append("\n"); 
		query.append("	, '' as DIR_CD" ).append("\n"); 
		query.append("	, '' as DURATION" ).append("\n"); 
		query.append("	, '' as F_LEVEL" ).append("\n"); 
		query.append("	, '' as FEU" ).append("\n"); 
		query.append("	, '' as FWDR" ).append("\n"); 
		query.append("	, '' as LST_SB_RMK" ).append("\n"); 
		query.append("	, '' as LST_SB_RSN_TP_CD" ).append("\n"); 
		query.append("	, '' as OB_SLS_OFC_CD" ).append("\n"); 
		query.append("	, '' as POD_LOC_CD" ).append("\n"); 
		query.append("	, '' as POD_NOD_CD" ).append("\n"); 
		query.append("	, '' as POL_LOC_CD" ).append("\n"); 
		query.append("	, '' as POL_NOD_CD" ).append("\n"); 
		query.append("	, '' as POR_LOC_CD" ).append("\n"); 
		query.append("	, '' as POR_NOD_CD" ).append("\n"); 
		query.append("	, '' as POR_SCC_CD" ).append("\n"); 
		query.append("	, '' as RFA_NO" ).append("\n"); 
		query.append("	, '' as RLANE_CD" ).append("\n"); 
		query.append("	, '' as S_NAME" ).append("\n"); 
		query.append("	, '' as SC_NO" ).append("\n"); 
		query.append("	, '' as SLS_RHQ_CD" ).append("\n"); 
		query.append("	, '' as STANDBY_REASON" ).append("\n"); 
		query.append("	, '' as STANDBY_TYPE" ).append("\n"); 
		query.append("	, '' as SUB_TRD_CD" ).append("\n"); 
		query.append("	, '' as TEU" ).append("\n"); 
		query.append("	, '' as TON" ).append("\n"); 
		query.append("	, '' as TP_SZ" ).append("\n"); 
		query.append("	, '' as TRD_CD" ).append("\n"); 
		query.append("	, '' as TRNK_DIR_CD" ).append("\n"); 
		query.append("	, '' as TRNK_POD" ).append("\n"); 
		query.append("	, '' as TRNK_POL" ).append("\n"); 
		query.append("	, '' as TRNK_SLAN_CD" ).append("\n"); 
		query.append("	, '' as TS_DIR_CD" ).append("\n"); 
		query.append("	, '' as TS_POD_CD" ).append("\n"); 
		query.append("	, '' as TS_POL_CD" ).append("\n"); 
		query.append("	, '' as TS_SLAN_CD" ).append("\n"); 
		query.append("	, '' as USR_OFC_CD" ).append("\n"); 
		query.append("	, '' as WEEK" ).append("\n"); 
		query.append("	, '' as YEAR" ).append("\n"); 
		query.append("	, '' as YR_MON_WK" ).append("\n"); 
		query.append("	, '' AS cfm_flg" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}