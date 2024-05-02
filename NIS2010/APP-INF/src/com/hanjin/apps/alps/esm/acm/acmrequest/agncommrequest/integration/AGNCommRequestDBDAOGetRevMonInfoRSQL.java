/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AGNCommRequestDBDAOGetRevMonInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOGetRevMonInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetRevMonInfo
	  * 부킹의 Revenue Month를 구함
	  * </pre>
	  */
	public AGNCommRequestDBDAOGetRevMonInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOGetRevMonInfoRSQL").append("\n"); 
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
		query.append("SELECT M.COST_YRMON AS REV_MON" ).append("\n"); 
		query.append("FROM MAS_MON_VVD M , MAS_RGST_BKG R" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("  AND R.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("  AND M.TRD_CD     = R.TRD_CD" ).append("\n"); 
		query.append("  AND M.RLANE_CD   = R.RLANE_CD          " ).append("\n"); 
		query.append("  AND M.IOC_CD     = R.IOC_CD            " ).append("\n"); 
		query.append("  AND M.VSL_CD     = R.VSL_CD            " ).append("\n"); 
		query.append("  AND M.SKD_VOY_NO = R.SKD_VOY_NO        " ).append("\n"); 
		query.append("  AND M.DIR_CD     = R.DIR_CD" ).append("\n"); 

	}
}