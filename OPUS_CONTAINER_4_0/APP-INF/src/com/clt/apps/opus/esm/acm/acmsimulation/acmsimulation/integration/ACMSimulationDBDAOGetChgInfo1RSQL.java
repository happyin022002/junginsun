/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ACMSimulationDBDAOGetChgInfo1RSQL.java
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

public class ACMSimulationDBDAOGetChgInfo1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetChgInfo1
	  * </pre>
	  */
	public ACMSimulationDBDAOGetChgInfo1RSQL(){
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
		query.append("FileName : ACMSimulationDBDAOGetChgInfo1RSQL").append("\n"); 
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
		query.append("    SUM(HO) AS HO," ).append("\n"); 
		query.append("    SUM(HD) AS HD," ).append("\n"); 
		query.append("    SUM(FO) AS FO," ).append("\n"); 
		query.append("    SUM(FD) AS FD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           CASE WHEN B.FRT_CHG_TP_CD = 'IH' AND B.CHG_APLY_AREA_CD = 'O' THEN 1 ELSE 0 END  AS HO," ).append("\n"); 
		query.append("           CASE WHEN B.FRT_CHG_TP_CD = 'IH' AND B.CHG_APLY_AREA_CD = 'D' THEN 1 ELSE 0 END  AS HD," ).append("\n"); 
		query.append("           CASE WHEN B.FRT_CHG_TP_CD = 'OP' AND B.CHG_APLY_AREA_CD = 'O' THEN 1 ELSE 0 END  AS FO," ).append("\n"); 
		query.append("           CASE WHEN B.FRT_CHG_TP_CD = 'OP' AND B.CHG_APLY_AREA_CD = 'D' THEN 1 ELSE 0 END  AS FD" ).append("\n"); 
		query.append("      FROM BKG_CHG_RT A, MDM_CHARGE B" ).append("\n"); 
		query.append("     WHERE A.BKG_NO               = @[bkg_no]" ).append("\n"); 
		query.append("       AND B.CHG_CD               = A.CHG_CD" ).append("\n"); 
		query.append("       AND A.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("       AND B.REP_CHG_CD           = 'TAC'" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}