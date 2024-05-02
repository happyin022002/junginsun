/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EQCOrgChartDBDAOaddEqrCtrlFcastLocCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.eqcorgchart.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQCOrgChartDBDAOaddEqrCtrlFcastLocCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_CTRL_FCAST_LOC 에 해당 USR 의 데이터를 생성함
	  * </pre>
	  */
	public EQCOrgChartDBDAOaddEqrCtrlFcastLocCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_dpth_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.eqcorgchart.integration").append("\n"); 
		query.append("FileName : EQCOrgChartDBDAOaddEqrCtrlFcastLocCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_CTRL_FCAST_LOC " ).append("\n"); 
		query.append("     ( USR_ID" ).append("\n"); 
		query.append("     , LOC_DPTH_CD" ).append("\n"); 
		query.append("     , LOC_CD" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT)" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("     ( @[cre_usr_id]" ).append("\n"); 
		query.append("     , @[loc_dpth_cd]" ).append("\n"); 
		query.append("     , @[loc_cd]" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE)" ).append("\n"); 

	}
}