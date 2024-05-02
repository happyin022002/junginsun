/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TESCommonDBDAOTesCommonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOTesCommonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO Object 생성용
	  * </pre>
	  */
	public TESCommonDBDAOTesCommonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOTesCommonRSQL").append("\n"); 
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
		query.append("SELECT '0' AS INV_NO " ).append("\n"); 
		query.append("     , '0' AS OFC_CD " ).append("\n"); 
		query.append("     , '0' AS CALC_COST_GRP_CD " ).append("\n"); 
		query.append("     , '0' AS VNDR_SEQ " ).append("\n"); 
		query.append("     , '0' AS INV_NO " ).append("\n"); 
		query.append("     , '0' AS TML_INV_TP_CD " ).append("\n"); 
		query.append("     , '0' AS YD_CD " ).append("\n"); 
		query.append("     , '0' AS ERR_INV_NO " ).append("\n"); 
		query.append("     , '0' AS CODE " ).append("\n"); 
		query.append("     , '0' AS TEXT " ).append("\n"); 
		query.append("     , '0' AS FLAG " ).append("\n"); 
		query.append("     , '0' AS ATB_DT " ).append("\n"); 
		query.append("     , '0' AS AGMT_FTR_INV_TP_CD " ).append("\n"); 
		query.append("     , '0' AS FM_PRD_DT " ).append("\n"); 
		query.append("     , '0' AS TO_PRD_DT " ).append("\n"); 
		query.append("     , '0' AS MIN_WRK_DT " ).append("\n"); 
		query.append("     , '0' AS VVD " ).append("\n"); 
		query.append("     , '0' AS COST_OFC_CD " ).append("\n"); 
		query.append("     , '0' AS FROM_DATE " ).append("\n"); 
		query.append("     , '0' AS TO_DATE " ).append("\n"); 
		query.append("     , '0' AS MAX_WRK_DT " ).append("\n"); 
		query.append("     , '0' AS EQ_NO " ).append("\n"); 
		query.append("     , '0' AS ACT_TP " ).append("\n"); 
		query.append("     , '0' AS NO_OFC_CD " ).append("\n"); 
		query.append("     , '0' AS NO_YD_CD " ).append("\n"); 
		query.append("     , '0' AS CRE_OFC_CD " ).append("\n"); 
		query.append("     , '0' AS INV_OFC_CD " ).append("\n"); 
		query.append("     , '0' AS LOC_CD " ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}