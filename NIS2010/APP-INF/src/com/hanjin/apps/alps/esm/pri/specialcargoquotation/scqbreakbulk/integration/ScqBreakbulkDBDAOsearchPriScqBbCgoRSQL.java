/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ScqBreakbulkDBDAOsearchPriScqBbCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.04.23 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHojin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqBreakbulkDBDAOsearchPriScqBbCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPriScqBbCgo
	  * * 2015.04.23 송호진 [CHM-201533702] SCQ내에 Unit Dual (cm/Inch) System 개발 요청
	  * </pre>
	  */
	public ScqBreakbulkDBDAOsearchPriScqBbCgoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration").append("\n"); 
		query.append("FileName : ScqBreakbulkDBDAOsearchPriScqBbCgoRSQL").append("\n"); 
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
		query.append("SELECT SCQ_RQST_NO" ).append("\n"); 
		query.append("     , SCQ_VER_NO" ).append("\n"); 
		query.append("     , CGO_SEQ" ).append("\n"); 
		query.append("     , CMDT_CD" ).append("\n"); 
		query.append("     , TTL_DIM_LEN" ).append("\n"); 
		query.append("     , TTL_DIM_WDT" ).append("\n"); 
		query.append("     , TTL_DIM_HGT" ).append("\n"); 
		query.append("     , GRS_WGT" ).append("\n"); 
		query.append("     , TTL_DIM_LEN AS TTL_DIM_LEN_VW" ).append("\n"); 
		query.append("     , TTL_DIM_WDT AS TTL_DIM_WDT_VW" ).append("\n"); 
		query.append("     , TTL_DIM_HGT AS TTL_DIM_HGT_VW" ).append("\n"); 
		query.append("     , GRS_WGT AS GRS_WGT_VW" ).append("\n"); 
		query.append("     , WGT_UT_CD" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , (SELECT CMDT_NM " ).append("\n"); 
		query.append("          FROM MDM_COMMODITY MDM" ).append("\n"); 
		query.append("         WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND MDM.CMDT_CD = CGO.CMDT_CD" ).append("\n"); 
		query.append("           AND ROWNUM <= 1) CMDT_NM" ).append("\n"); 
		query.append("FROM PRI_SCQ_BB_CGO CGO" ).append("\n"); 
		query.append("WHERE SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("  AND SCQ_VER_NO  = @[scq_ver_no]" ).append("\n"); 

	}
}