/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ACMSimulationDBDAOAddMassSimInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.13 
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

public class ACMSimulationDBDAOAddMassSimInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddMassSimInfo
	  * </pre>
	  */
	public ACMSimulationDBDAOAddMassSimInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_bkg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sml_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOAddMassSimInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_SIM_INFO" ).append("\n"); 
		query.append(" ( SIM_NO ," ).append("\n"); 
		query.append("   SIM_BKG_KNT ," ).append("\n"); 
		query.append("--   SIM_USR_OFC_CD ," ).append("\n"); 
		query.append("   SIM_RMK ," ).append("\n"); 
		query.append("   DELT_FLG ," ).append("\n"); 
		query.append("   CRE_USR_ID ," ).append("\n"); 
		query.append("   CRE_DT ," ).append("\n"); 
		query.append("   UPD_USR_ID ," ).append("\n"); 
		query.append("   UPD_DT)" ).append("\n"); 
		query.append("VALUES " ).append("\n"); 
		query.append(" ( @[sml_no1]," ).append("\n"); 
		query.append("   @[ttl_bkg]," ).append("\n"); 
		query.append("   @[clc_rmk]," ).append("\n"); 
		query.append("   'N', " ).append("\n"); 
		query.append("   @[usr_id]," ).append("\n"); 
		query.append("   SYSDATE," ).append("\n"); 
		query.append("   @[usr_id]," ).append("\n"); 
		query.append("   SYSDATE )" ).append("\n"); 

	}
}