/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSimulationDBDAOAddAcmSimInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.21
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.12.21 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOAddAcmSimInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddAcmSimInfo
	  * </pre>
	  */
	public ACMSimulationDBDAOAddAcmSimInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sim_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOAddAcmSimInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_SIM_INFO " ).append("\n"); 
		query.append(" ( SIM_NO ," ).append("\n"); 
		query.append("   SIM_BKG_KNT ," ).append("\n"); 
		query.append("   SIM_USR_OFC_CD ," ).append("\n"); 
		query.append("   SIM_RMK ," ).append("\n"); 
		query.append("   DELT_FLG ," ).append("\n"); 
		query.append("   CRE_USR_ID ," ).append("\n"); 
		query.append("   CRE_DT ," ).append("\n"); 
		query.append("   UPD_USR_ID ," ).append("\n"); 
		query.append("   UPD_DT)" ).append("\n"); 
		query.append("VALUES " ).append("\n"); 
		query.append(" ( @[sim_no]," ).append("\n"); 
		query.append("   (SELECT COUNT(SIM_NO) FROM ACM_SIM_BKG_INFO WHERE SIM_NO = @[sim_no])," ).append("\n"); 
		query.append("   @[sim_usr_ofc_cd]," ).append("\n"); 
		query.append("   @[sim_rmk]," ).append("\n"); 
		query.append("   'N'," ).append("\n"); 
		query.append("   @[usr_id]," ).append("\n"); 
		query.append("   SYSDATE," ).append("\n"); 
		query.append("   @[usr_id]," ).append("\n"); 
		query.append("   SYSDATE )" ).append("\n"); 

	}
}