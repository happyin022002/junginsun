/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsCommonDBDAOTrsComboDualRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.trscommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsCommonDBDAOTrsComboDualRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select
	  * </pre>
	  */
	public TrsCommonDBDAOTrsComboDualRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cm_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.trscommon.integration").append("\n"); 
		query.append("FileName : TrsCommonDBDAOTrsComboDualRSQL").append("\n"); 
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
		query.append("SELECT   @[cm_code] AS INTG_CD_ID" ).append("\n"); 
		query.append(",        'DG' AS INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(",        'DG' AS INTG_CD_VAL_DESC" ).append("\n"); 
		query.append(",        'DG' AS INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append(",        1 AS INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("FROM     DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   @[cm_code] AS INTG_CD_ID" ).append("\n"); 
		query.append(",        'RF' AS INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(",        'RF' AS INTG_CD_VAL_DESC" ).append("\n"); 
		query.append(",        'RF' AS INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append(",        2 AS INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("FROM     DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   @[cm_code] AS INTG_CD_ID" ).append("\n"); 
		query.append(",        'RG' AS INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(",        'RG' AS INTG_CD_VAL_DESC" ).append("\n"); 
		query.append(",        'RG' AS INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append(",        3 AS INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("FROM     DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   @[cm_code] AS INTG_CD_ID" ).append("\n"); 
		query.append(",        'AK' AS INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(",        'AK' AS INTG_CD_VAL_DESC" ).append("\n"); 
		query.append(",        'AK' AS INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append(",        4 AS INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("FROM     DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   @[cm_code] AS INTG_CD_ID" ).append("\n"); 
		query.append(",        'AD' AS INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(",        'AD' AS INTG_CD_VAL_DESC" ).append("\n"); 
		query.append(",        'AD' AS INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append(",        5 AS INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("FROM     DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   @[cm_code] AS INTG_CD_ID" ).append("\n"); 
		query.append(",        'RD' AS INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(",        'RD' AS INTG_CD_VAL_DESC" ).append("\n"); 
		query.append(",        'RD' AS INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append(",        6 AS INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("FROM     DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   @[cm_code] AS INTG_CD_ID" ).append("\n"); 
		query.append(",        'HG' AS INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(",        'HG' AS INTG_CD_VAL_DESC" ).append("\n"); 
		query.append(",        'HG' AS INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append(",        7 AS INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("FROM     DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   @[cm_code] AS INTG_CD_ID" ).append("\n"); 
		query.append(",        'BB' AS INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(",        'BB' AS INTG_CD_VAL_DESC" ).append("\n"); 
		query.append(",        'BB' AS INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append(",        8 AS INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("FROM     DUAL" ).append("\n"); 

	}
}