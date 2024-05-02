/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ACMSimulationDBDAORemoveAcmSimCommRevDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.04
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2013.01.04 김봉균
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

public class ACMSimulationDBDAORemoveAcmSimCommRevDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RemoveAcmSimCommRev
	  * </pre>
	  */
	public ACMSimulationDBDAORemoveAcmSimCommRevDSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAORemoveAcmSimCommRevDSQL").append("\n"); 
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
		query.append("DELETE ACM_SIM_COMM_REV" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND SIM_NO = @[sim_no]" ).append("\n"); 
		query.append("AND (BKG_NO,AGN_CD,IO_BND_CD,AC_TP_CD,AC_SEQ) NOT IN " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT BKG_NO,AGN_CD,IO_BND_CD,AC_TP_CD,AC_SEQ" ).append("\n"); 
		query.append("        FROM   ACM_AGN_COMM" ).append("\n"); 
		query.append("        WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		AND	   SIM_NO = @[sim_no]" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}