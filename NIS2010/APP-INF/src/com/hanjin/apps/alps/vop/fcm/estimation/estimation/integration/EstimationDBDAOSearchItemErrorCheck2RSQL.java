/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EstimationDBDAOSearchItemErrorCheck2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.04.03 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EstimationDBDAOSearchItemErrorCheck2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search item error check No. 2
	  * </pre>
	  */
	public EstimationDBDAOSearchItemErrorCheck2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration").append("\n"); 
		query.append("FileName : EstimationDBDAOSearchItemErrorCheck2RSQL").append("\n"); 
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
		query.append("SELECT MAX( CASE WHEN T1.CSM_OIL_TP_CD='HFO' THEN" ).append("\n"); 
		query.append("                SIGN(T1.VOY_END_RMN_WGT-T2.FOIL_RMN_WGT)" ).append("\n"); 
		query.append("            WHEN T1.CSM_OIL_TP_CD='MDO' THEN" ).append("\n"); 
		query.append("                SIGN(T1.VOY_END_RMN_WGT-T2.DOIL_RMN_WGT)" ).append("\n"); 
		query.append("            END) ERR_CHK" ).append("\n"); 
		query.append("FROM FCM_ESTM_MON_CSM_IF T1, FCM_RMN_OIL_MON_END_RPT T2" ).append("\n"); 
		query.append("WHERE T1.BSE_YRMON = T2.REV_YRMON" ).append("\n"); 
		query.append("AND T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND T1.BSE_YRMON  = @[bse_yrmon]" ).append("\n"); 
		query.append("AND T1.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND T1.REV_DIR_CD = @[rev_dir_cd]" ).append("\n"); 

	}
}