/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BlRatingDBDAOSearchPpdChgRlsEmailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchPpdChgRlsEmailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDBDAOSearchPpdChgRlsEmailRSQL
	  * </pre>
	  */
	public BlRatingDBDAOSearchPpdChgRlsEmailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchPpdChgRlsEmailRSQL").append("\n"); 
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
		query.append("SELECT USR_EML" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("        SELECT BHD.CRE_USR_ID, BHD.CRE_DT, CU.USR_EML" ).append("\n"); 
		query.append("        FROM   BKG_HIS_DTL BHD," ).append("\n"); 
		query.append("               COM_USER    CU" ).append("\n"); 
		query.append("        WHERE  BHD.CRE_USR_ID = CU.USR_ID" ).append("\n"); 
		query.append("        AND    BHD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND    BHD.HIS_CATE_NM IN ('SWB RLS','O.B/L RLS')" ).append("\n"); 
		query.append("        ORDER BY BHD.CRE_DT DESC" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}