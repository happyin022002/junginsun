/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KeyAccountKpiDBDAOSearchKpiUploadCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KeyAccountKpiDBDAOSearchKpiUploadCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchKpiUploadCnt
	  * </pre>
	  */
	public KeyAccountKpiDBDAOSearchKpiUploadCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.integration").append("\n"); 
		query.append("FileName : KeyAccountKpiDBDAOSearchKpiUploadCntRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) AS CNT" ).append("\n"); 
		query.append("  FROM SQM_KEY_ACCT_CFM_QTA" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND BSE_TP_CD  = @[f_bse_tp_cd]   --Q, Y 필수" ).append("\n"); 
		query.append("   AND BSE_YR     = @[f_bse_yr]      --필수" ).append("\n"); 
		query.append("#if(${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("   AND BSE_QTR_CD = @[f_bse_qtr_cd]  --Quartely일때 필수" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}