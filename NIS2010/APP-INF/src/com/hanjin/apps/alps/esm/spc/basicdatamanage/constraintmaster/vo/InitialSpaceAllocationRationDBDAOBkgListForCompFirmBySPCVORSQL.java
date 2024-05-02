/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InitialSpaceAllocationRationDBDAOBkgListForCompFirmBySPCVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InitialSpaceAllocationRationDBDAOBkgListForCompFirmBySPCVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2015.03.02 김성욱 0116 화면, Compulsory Firm 조회화면용 VO 생성
	  * </pre>
	  */
	public InitialSpaceAllocationRationDBDAOBkgListForCompFirmBySPCVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo").append("\n"); 
		query.append("FileName : InitialSpaceAllocationRationDBDAOBkgListForCompFirmBySPCVORSQL").append("\n"); 
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
		query.append("SELECT '' AS BL_NO" ).append("\n"); 
		query.append("	, '' AS BKG_NO" ).append("\n"); 
		query.append("	, '' AS BKG_STS_CD" ).append("\n"); 
		query.append("	, '' AS ALOC_STS_CD" ).append("\n"); 
		query.append("	, '' AS STANDBY_TYPE" ).append("\n"); 
		query.append("	, '' AS STANDBY_REASON" ).append("\n"); 
		query.append("	, '' AS ALOC_SVC_CD" ).append("\n"); 
		query.append("	, '' AS SLS_RHQ_CD" ).append("\n"); 
		query.append("	, '' AS BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("	, '' AS TRD_CD" ).append("\n"); 
		query.append("	, '' AS SUB_TRD_CD" ).append("\n"); 
		query.append("	, '' AS DIR_CD" ).append("\n"); 
		query.append("	, '' AS RLANE_CD" ).append("\n"); 
		query.append("	, '' AS TRNK_SLAN_CD" ).append("\n"); 
		query.append("	, '' AS TRNK_DIR_CD" ).append("\n"); 
		query.append("	, '' AS TRNK_POL" ).append("\n"); 
		query.append("	, '' AS TRNK_POD" ).append("\n"); 
		query.append("	, '' AS POR_LOC_CD" ).append("\n"); 
		query.append("	, '' AS POR_NOD_CD" ).append("\n"); 
		query.append("	, '' AS POR_SCC_CD" ).append("\n"); 
		query.append("	, '' AS POL_LOC_CD" ).append("\n"); 
		query.append("	, '' AS POL_NOD_CD" ).append("\n"); 
		query.append("	, '' AS TS_SLAN_CD" ).append("\n"); 
		query.append("	, '' AS TS_DIR_CD" ).append("\n"); 
		query.append("	, '' AS TS_POL_CD" ).append("\n"); 
		query.append("	, '' AS TS_POD_CD" ).append("\n"); 
		query.append("	, '' AS POD_LOC_CD" ).append("\n"); 
		query.append("	, '' AS POD_NOD_CD" ).append("\n"); 
		query.append("	, '' AS DEL_LOC_CD" ).append("\n"); 
		query.append("	, '' AS DEL_NOD_CD" ).append("\n"); 
		query.append("	, '' AS DEL_SCC_CD" ).append("\n"); 
		query.append("	, '' AS BKG_VVD_CD" ).append("\n"); 
		query.append("	, '' AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	, '' AS DGRD" ).append("\n"); 
		query.append("	, '' AS OB_SLS_OFC_CD" ).append("\n"); 
		query.append("	, '' AS SC_NO" ).append("\n"); 
		query.append("	, '' AS RFA_NO" ).append("\n"); 
		query.append("	, '' AS C_CUST" ).append("\n"); 
		query.append("	, '' AS A_CUST" ).append("\n"); 
		query.append("	, '' AS CMDT_CD" ).append("\n"); 
		query.append("	, '' AS CMDT_DESC" ).append("\n"); 
		query.append("	, '' AS CNEE" ).append("\n"); 
		query.append("	, '' AS FWDR" ).append("\n"); 
		query.append("	, '' AS YR_MON_WK" ).append("\n"); 
		query.append("	, '' AS YEAR" ).append("\n"); 
		query.append("	, '' AS WEEK" ).append("\n"); 
		query.append("	, '' AS DURATION" ).append("\n"); 
		query.append("	, '' AS FEU" ).append("\n"); 
		query.append("	, '' AS TEU" ).append("\n"); 
		query.append("	, '' AS TON" ).append("\n"); 
		query.append("    , '' AS S_NAME" ).append("\n"); 
		query.append("    , '' AS F_LEVEL" ).append("\n"); 
		query.append("    , '' AS USR_OFC_CD" ).append("\n"); 
		query.append("	, '' AS CNDDT_CFM_FLG" ).append("\n"); 
		query.append("	, '' AS CFM_RQST_FLG" ).append("\n"); 
		query.append("	, '' AS CFM_USR_ID" ).append("\n"); 
		query.append("	, '' AS CFM_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}