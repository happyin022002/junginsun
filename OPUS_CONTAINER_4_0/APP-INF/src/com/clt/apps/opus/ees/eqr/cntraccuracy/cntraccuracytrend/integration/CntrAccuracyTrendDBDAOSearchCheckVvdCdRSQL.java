/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrAccuracyTrendDBDAOSearchCheckVvdCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.28
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2014.03.28 신용찬
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YongChanShin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrAccuracyTrendDBDAOSearchCheckVvdCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check VVD CODE 
	  * </pre>
	  */
	public CntrAccuracyTrendDBDAOSearchCheckVvdCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.integration").append("\n"); 
		query.append("FileName : CntrAccuracyTrendDBDAOSearchCheckVvdCdRSQL").append("\n"); 
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
		query.append("-- VVD_CHECK : T, F" ).append("\n"); 
		query.append("SELECT CASE WHEN COUNT(1) >= 1 THEN 'T' " ).append("\n"); 
		query.append("            WHEN COUNT(1) =  0 THEN 'F'                   " ).append("\n"); 
		query.append("       END VVD_CHECK     " ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND VSL_CD     = SUBSTR(@[vvd_cd], 0, 4)  -- VVD " ).append("\n"); 
		query.append("   AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)  -- VVD " ).append("\n"); 
		query.append("   AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)  -- VVD " ).append("\n"); 

	}
}