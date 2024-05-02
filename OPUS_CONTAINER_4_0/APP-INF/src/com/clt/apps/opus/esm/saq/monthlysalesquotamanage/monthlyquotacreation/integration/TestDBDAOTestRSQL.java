/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TestDBDAOTestRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TestDBDAOTestRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO 생성
	  * </pre>
	  */
	public TestDBDAOTestRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : TestDBDAOTestRSQL").append("\n"); 
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
		query.append("SELECT '0' AS FCAST_TRNS_STS_CD " ).append("\n"); 
		query.append("     , '0' AS TRD_CD " ).append("\n"); 
		query.append("     , '0' AS RLANE_CD " ).append("\n"); 
		query.append("     , '0' AS INIT_CM_AMT " ).append("\n"); 
		query.append("     , '0' AS CHNG_CM_UC_AMT " ).append("\n"); 
		query.append("     , '0' AS PAGEROWS " ).append("\n"); 
		query.append("     , '0' AS MTY_TRSP_UC_AMT " ).append("\n"); 
		query.append("     , '0' AS BSE_QTR_CD " ).append("\n"); 
		query.append("     , '0' AS LDF_RTO " ).append("\n"); 
		query.append("     , '0' AS CTRT_OFC_CD " ).append("\n"); 
		query.append("     , '0' AS SLS_OFC_CD " ).append("\n"); 
		query.append("     , '0' AS USER_ID " ).append("\n"); 
		query.append("     , '0' AS YEAR " ).append("\n"); 
		query.append("     , '0' AS FULL_TRSP_UC_AMT " ).append("\n"); 
		query.append("     , '0' AS LOD_QTY " ).append("\n"); 
		query.append("     , '0' AS SLS_AQ_CD " ).append("\n"); 
		query.append("     , '0' AS RHQ_CD " ).append("\n"); 
		query.append("     , '0' AS ST_DT " ).append("\n"); 
		query.append("     , '0' AS AGN_COMM_UT_AMT " ).append("\n"); 
		query.append("     , '0' AS CMPB " ).append("\n"); 
		query.append("     , '0' AS SLS_RHQ_CD " ).append("\n"); 
		query.append("     , '0' AS CHNG_OFC_CD " ).append("\n"); 
		query.append("     , '0' AS IOC " ).append("\n"); 
		query.append("     , '0' AS SUB_TRD_CD " ).append("\n"); 
		query.append("     , '0' AS ORG_RLANE_CD " ).append("\n"); 
		query.append("     , '0' AS CM_UC_AMT " ).append("\n"); 
		query.append("     , '0' AS TRADE " ).append("\n"); 
		query.append("     , '0' AS SPL_AMT " ).append("\n"); 
		query.append("     , '0' AS ORG_GRS_RPB_REV " ).append("\n"); 
		query.append("     , '0' AS GLINE_CM_AMT " ).append("\n"); 
		query.append("     , '0' AS YEAR_MON " ).append("\n"); 
		query.append("     , '0' AS CTRT_RHQ_CD " ).append("\n"); 
		query.append("     , '0' AS BSE_MON " ).append("\n"); 
		query.append("     , '0' AS IBFLAG " ).append("\n"); 
		query.append("     , '0' AS MTY_STVG_UC_AMT " ).append("\n"); 
		query.append("     , '0' AS SEARCH_LANE " ).append("\n"); 
		query.append("     , '0' AS GRS_RPB_REV " ).append("\n"); 
		query.append("     , '0' AS DIR_CD " ).append("\n"); 
		query.append("     , '0' AS MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("     , '0' AS IOC_CD " ).append("\n"); 
		query.append("     , '0' AS CTRT_AQ_CD " ).append("\n"); 
		query.append("     , '0' AS SAV_FLG " ).append("\n"); 
		query.append("     , '0' AS TML_VOL_INCNT_AMT " ).append("\n"); 
		query.append("     , '0' AS CTRT_RGN_OFC_CD " ).append("\n"); 
		query.append("     , '0' AS BSE_YR " ).append("\n"); 
		query.append("     , '0' AS CM_AMT " ).append("\n"); 
		query.append("     , '0' AS ORG_CM_UC_AMT " ).append("\n"); 
		query.append("     , '0' AS OFC_CD " ).append("\n"); 
		query.append("     , '0' AS BSE_MONTH " ).append("\n"); 
		query.append("     , '0' AS SLS_RGN_OFC_CD " ).append("\n"); 
		query.append("     , '0' AS FULL_STVG_UC_AMT " ).append("\n"); 
		query.append("     , '0' AS ORG_LOD_QTY " ).append("\n"); 
		query.append("     , '0' AS BOUND " ).append("\n"); 
		query.append("     , '0' AS GLINE_STS_FLG " ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}