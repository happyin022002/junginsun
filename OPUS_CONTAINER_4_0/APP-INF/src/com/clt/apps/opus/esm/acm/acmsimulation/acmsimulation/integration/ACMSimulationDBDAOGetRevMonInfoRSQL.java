/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ACMSimulationDBDAOGetRevMonInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOGetRevMonInfoRSQL implements ISQLTemplate{

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
	public ACMSimulationDBDAOGetRevMonInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOGetRevMonInfoRSQL").append("\n"); 
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
		query.append("FROM COA_MON_VVD M , COA_RGST_BKG R" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND R.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("AND M.TRD_CD     = R.TRD_CD" ).append("\n"); 
		query.append("AND M.RLANE_CD   = R.RLANE_CD          " ).append("\n"); 
		query.append("AND M.IOC_CD     = R.IOC_CD            " ).append("\n"); 
		query.append("AND M.VSL_CD     = R.VSL_CD            " ).append("\n"); 
		query.append("AND M.SKD_VOY_NO = R.SKD_VOY_NO        " ).append("\n"); 
		query.append("AND M.DIR_CD     = R.DIR_CD" ).append("\n"); 

	}
}