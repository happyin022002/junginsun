/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DropOffCreationDBDAOSearchDodDrpOffChgVOList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DropOffCreationDBDAOSearchDodDrpOffChgVOList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public DropOffCreationDBDAOSearchDodDrpOffChgVOList2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration").append("\n"); 
		query.append("FileName : DropOffCreationDBDAOSearchDodDrpOffChgVOList2RSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       BKG_NO" ).append("\n"); 
		query.append("      ,(SELECT B.BL_NO FROM BKG_BOOKING B WHERE B.BKG_NO = G.BKG_NO) BL_NO" ).append("\n"); 
		query.append("      ,CNTR_NO" ).append("\n"); 
		query.append("      ,DRP_OFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append("      ,DRP_OFF_CHG_MNL_FLG" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,TRO_IB_CFM_OFC_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(TRO_IB_CFM_DT, 'YYYY-MM-DD HH24:MI:SS') TRO_IB_CFM_DT" ).append("\n"); 
		query.append("      ,DEL_CD" ).append("\n"); 
		query.append("      ,CNTR_RTN_YD_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(CNTR_RTN_DT, 'YYYY-MM-DD HH24:MI:SS') CNTR_RTN_DT" ).append("\n"); 
		query.append("      ,CUST_CNT_CD|| LPAD(CUST_SEQ, 6, 0) CUST_CD_SEQ" ).append("\n"); 
		query.append("      ,CUST_CNT_CD" ).append("\n"); 
		query.append("      ,CUST_SEQ" ).append("\n"); 
		query.append("      ,SPCL_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,SPCL_CUST_SEQ" ).append("\n"); 
		query.append("      ,SPCL_CUST_CNT_CD|| LPAD(SPCL_CUST_SEQ, 6, 0) SPCL_CD_SEQ" ).append("\n"); 
		query.append("      ,CURR_CD" ).append("\n"); 
		query.append("      ,GEN_TRF_AMT" ).append("\n"); 
		query.append("      ,SPCL_TRF_AMT" ).append("\n"); 
		query.append("      ,DC_AMT" ).append("\n"); 
		query.append("      ,SVC_FEE_AMT" ).append("\n"); 
		query.append("      ,TTL_AMT" ).append("\n"); 
		query.append("      ,TRO_IB_CXL_FLG" ).append("\n"); 
		query.append("      ,DRP_OFF_CHG_TRF_SPCL_SEQ" ).append("\n"); 
		query.append("      ,DRP_OFF_XTER_RMK" ).append("\n"); 
		query.append("      ,DRP_OFF_CUST_REF_RMK" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND DELT_FLG = 'C'" ).append("\n"); 
		query.append("   " ).append("\n"); 

	}
}