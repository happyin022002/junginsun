/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : SalesRPTDBDAOSearchSetForm059ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.18
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.10.18 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOSearchSetForm059ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSetForm059List SELECT
	  * </pre>
	  */
	public SalesRPTDBDAOSearchSetForm059ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOSearchSetForm059ListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("     LPAD(mst.SLCT_ITM_FOM_SEQ, 3, '0') AS SLCT_ITM_FOM_SEQ" ).append("\n"); 
		query.append("   , MST.SLCT_ITM_FOM_DESC              AS SLCT_ITM_FOM_DESC" ).append("\n"); 
		query.append("   , DTL.MAS_RPT_ITM_CD                 AS RPT_ITM_CD" ).append("\n"); 
		query.append("   , DTL.RPT_ITM_COL_NM                 AS RPT_ITM_COL_NM" ).append("\n"); 
		query.append("   , DTL.RPT_ITM_DESC                   AS RPT_ITM_DESC" ).append("\n"); 
		query.append("  FROM MAS_RPT_ITM_INFO_MST MST" ).append("\n"); 
		query.append("     , MAS_RPT_ITM_INFO_DTL DTL" ).append("\n"); 
		query.append("   WHERE MST.CRE_USR_ID = DTL.CRE_USR_ID(+)" ).append("\n"); 
		query.append("     AND MST.SLCT_ITM_FOM_SEQ = DTL.SLCT_ITM_FOM_SEQ(+)" ).append("\n"); 
		query.append("     AND MST.CRE_USR_ID = 'SYSTEM' AND DTL.RPT_ITM_COL_NM(+)  <> 'STWG_CD'" ).append("\n"); 

	}
}