/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqListDBDAOsearchBbHandlingCstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.06
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.05.06 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqListDBDAOsearchBbHandlingCstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Break Bulk Handling Cost & Rate
	  * </pre>
	  */
	public ScqListDBDAOsearchBbHandlingCstRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration").append("\n"); 
		query.append("FileName : ScqListDBDAOsearchBbHandlingCstRSQL").append("\n"); 
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
		query.append("SELECT SUM ( DECODE ( CST.ROUT_SEQ , 1, CST.COST_AMT, 0 ) ) POL_SUM ," ).append("\n"); 
		query.append("  SUM ( DECODE ( CST.ROUT_SEQ , 2, CST.COST_AMT, 0 ) ) POD_SUM ," ).append("\n"); 
		query.append("  MAX ( C.PROP_RT_AMT ) PROP_RT ," ).append("\n"); 
		query.append("  MAX ( C.APRO_RT_AMT ) APRO_RT" ).append("\n"); 
		query.append("FROM PRI_SCQ_BB_ROUT_COST CST ," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT SCQ_RQST_NO," ).append("\n"); 
		query.append("      SCQ_VER_NO," ).append("\n"); 
		query.append("      ROUT_SEQ ," ).append("\n"); 
		query.append("      MAX(ROUT_SEQ_VER_NO) MAX_ROUT_SEQ_VER_NO" ).append("\n"); 
		query.append("    FROM PRI_SCQ_BB_ROUT" ).append("\n"); 
		query.append("    WHERE SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("      and SCQ_VER_NO = @[scq_ver_no]" ).append("\n"); 
		query.append("    GROUP BY SCQ_RQST_NO, SCQ_VER_NO, ROUT_SEQ ) A," ).append("\n"); 
		query.append("  PRI_SCQ_BB_MN C" ).append("\n"); 
		query.append("WHERE CST.SCQ_RQST_NO = A.SCQ_RQST_NO" ).append("\n"); 
		query.append("  AND CST.SCQ_VER_NO = A.SCQ_VER_NO" ).append("\n"); 
		query.append("  AND CST.ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("  AND CST.ROUT_SEQ_VER_NO = A.MAX_ROUT_SEQ_VER_NO" ).append("\n"); 
		query.append("  AND CST.SCQ_RQST_NO = C.SCQ_RQST_NO" ).append("\n"); 
		query.append("  AND CST.SCQ_VER_NO = C.SCQ_VER_NO" ).append("\n"); 
		query.append("GROUP BY CST.SCQ_RQST_NO, CST.SCQ_VER_NO " ).append("\n"); 

	}
}