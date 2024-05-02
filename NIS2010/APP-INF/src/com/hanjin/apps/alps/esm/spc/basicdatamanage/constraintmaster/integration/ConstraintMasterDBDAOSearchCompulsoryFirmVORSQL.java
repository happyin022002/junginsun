/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ConstraintMasterDBDAOSearchCompulsoryFirmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.06
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.01.06 최성민
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

public class ConstraintMasterDBDAOSearchCompulsoryFirmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Compulsory Firm 조회 리턴시 사용하는 VO
	  * </pre>
	  */
	public ConstraintMasterDBDAOSearchCompulsoryFirmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOSearchCompulsoryFirmVORSQL").append("\n"); 
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
		query.append("SELECT  '' TRD_CD" ).append("\n"); 
		query.append("      , '' RLANE_CD" ).append("\n"); 
		query.append("      , '' F_LEVEL" ).append("\n"); 
		query.append("      , '' BL_NO" ).append("\n"); 
		query.append("      , '' ALOC_STS_CD" ).append("\n"); 
		query.append("      , '' USR_OFC_CD" ).append("\n"); 
		query.append("      , '' SC_NO" ).append("\n"); 
		query.append("      , '' CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , '' TS_DIR_CD" ).append("\n"); 
		query.append("      , '' CFM_USR_ID" ).append("\n"); 
		query.append("      , '' DEL_NOD_CD" ).append("\n"); 
		query.append("      , '' OB_SLS_OFC_CD" ).append("\n"); 
		query.append("      , '' YEAR" ).append("\n"); 
		query.append("      , '' POD_LOC_CD" ).append("\n"); 
		query.append("      , '' TRNK_POL" ).append("\n"); 
		query.append("      , '' FEU" ).append("\n"); 
		query.append("      , '' DEL_LOC_CD" ).append("\n"); 
		query.append("      , '' CFM_DT" ).append("\n"); 
		query.append("      , '' TRNK_DIR_CD" ).append("\n"); 
		query.append("      , '' C_CUST" ).append("\n"); 
		query.append("      , '' SLS_RHQ_CD" ).append("\n"); 
		query.append("      , '' STANDBY_REASON" ).append("\n"); 
		query.append("      , '' DEL_SCC_CD" ).append("\n"); 
		query.append("      , '' BKG_NO" ).append("\n"); 
		query.append("      , '' POD_NOD_CD" ).append("\n"); 
		query.append("      , '' CMDT_DESC" ).append("\n"); 
		query.append("      , '' POR_SCC_CD" ).append("\n"); 
		query.append("      , '' TRNK_POD" ).append("\n"); 
		query.append("      , '' TEU" ).append("\n"); 
		query.append("      , '' TS_POD_CD" ).append("\n"); 
		query.append("      , '' SUB_TRD_CD" ).append("\n"); 
		query.append("      , '' BKG_STS_CD" ).append("\n"); 
		query.append("      , '' A_CUST" ).append("\n"); 
		query.append("      , '' RFA_NO" ).append("\n"); 
		query.append("      , '' CMDT_CD" ).append("\n"); 
		query.append("      , '' TRNK_SLAN_CD" ).append("\n"); 
		query.append("      , '' TON" ).append("\n"); 
		query.append("      , '' DIR_CD" ).append("\n"); 
		query.append("      , '' BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("      , '' TS_POL_CD" ).append("\n"); 
		query.append("      , '' POR_NOD_CD" ).append("\n"); 
		query.append("      , '' ALOC_SVC_CD" ).append("\n"); 
		query.append("      , '' POL_NOD_CD" ).append("\n"); 
		query.append("      , '' TS_SLAN_CD" ).append("\n"); 
		query.append("      , '' STANDBY_TYPE" ).append("\n"); 
		query.append("      , '' FWDR" ).append("\n"); 
		query.append("      , '' CFM_RQST_FLG" ).append("\n"); 
		query.append("      , '' POR_LOC_CD" ).append("\n"); 
		query.append("      , '' CNDDT_CFM_FLG" ).append("\n"); 
		query.append("      , '' POL_LOC_CD" ).append("\n"); 
		query.append("      , '' DURATION" ).append("\n"); 
		query.append("      , '' YR_MON_WK" ).append("\n"); 
		query.append("      , '' CNEE" ).append("\n"); 
		query.append("      , '' DGRD" ).append("\n"); 
		query.append("      , '' S_NAME" ).append("\n"); 
		query.append("      , '' BKG_VVD_CD" ).append("\n"); 
		query.append("      , '' WEEK" ).append("\n"); 
		query.append("      , '' CMPB" ).append("\n"); 
		query.append("      , '' VVD" ).append("\n"); 
		query.append("      , '' INIT_CMPB" ).append("\n"); 
		query.append("      , '' MAS_CMPB" ).append("\n"); 
		query.append("      , '' BKG_CRE_DT" ).append("\n"); 
		query.append("      , '' LST_SB_OTR_RSN" ).append("\n"); 
		query.append("      , '' C_CUST_NM" ).append("\n"); 
		query.append("      , '' A_CUST_NM" ).append("\n"); 
		query.append("      , '' SHRP_NM" ).append("\n"); 
		query.append("      , '' CNEE_NM" ).append("\n"); 
		query.append("      , '' FWDR_NM" ).append("\n"); 
		query.append("      , '' CUST_TP" ).append("\n"); 
		query.append("      , '' CUST_CTRL_CD" ).append("\n"); 
		query.append("      , '' ACCT_CD" ).append("\n"); 
		query.append("      , '' POL1" ).append("\n"); 
		query.append("      , '' POL2" ).append("\n"); 
		query.append("      , '' POL3" ).append("\n"); 
		query.append("      , '' POL4" ).append("\n"); 
		query.append("      , '' POL_ETB1" ).append("\n"); 
		query.append("      , '' POL_ETB2" ).append("\n"); 
		query.append("      , '' POL_ETB3" ).append("\n"); 
		query.append("      , '' POL_ETB4" ).append("\n"); 
		query.append("      , '' VVD1" ).append("\n"); 
		query.append("      , '' VVD2" ).append("\n"); 
		query.append("      , '' VVD3" ).append("\n"); 
		query.append("      , '' VVD4" ).append("\n"); 
		query.append("      , '' LST_SB_RMK" ).append("\n"); 
		query.append("      , '' USA_BKG_MOD_CD" ).append("\n"); 
		query.append("      , '' BL_OBRD_DT" ).append("\n"); 
		query.append("      , '' CGO_RCV_DT" ).append("\n"); 
		query.append("      , '' RFA_CTRT_TP_CD" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}