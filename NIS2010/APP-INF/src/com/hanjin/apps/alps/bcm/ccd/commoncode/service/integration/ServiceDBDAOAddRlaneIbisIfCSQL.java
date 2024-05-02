/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : ServiceDBDAOAddRlaneIbisIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.service.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceDBDAOAddRlaneIbisIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ServiceDBDAOAddRlaneIbisIfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_mnpl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.service.integration").append("\n"); 
		query.append("FileName : ServiceDBDAOAddRlaneIbisIfCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_REV_LANE_IBIS_IF" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   RLANE_IBIS_IF_SEQ, " ).append("\n"); 
		query.append("   RLANE_CD, " ).append("\n"); 
		query.append("   RLANE_NM, " ).append("\n"); 
		query.append("   VSL_TP_CD, " ).append("\n"); 
		query.append("   REP_TRD_CD, " ).append("\n"); 
		query.append("   VSL_SLAN_CD, " ).append("\n"); 
		query.append("   MODI_RLANE_CD, " ).append("\n"); 
		query.append("   CRE_USR_ID, " ).append("\n"); 
		query.append("   CRE_DT, " ).append("\n"); 
		query.append("   UPD_USR_ID, " ).append("\n"); 
		query.append("   UPD_DT, " ).append("\n"); 
		query.append("   DELT_FLG, " ).append("\n"); 
		query.append("   IF_MNPL_CD " ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("   MDM_REV_LANE_IBIS_IF_SEQ.NEXTVAL," ).append("\n"); 
		query.append("   @[rlane_cd]," ).append("\n"); 
		query.append("   @[rlane_nm]," ).append("\n"); 
		query.append("   @[vsl_tp_cd]," ).append("\n"); 
		query.append("   @[rep_trd_cd]," ).append("\n"); 
		query.append("   @[vsl_slan_cd]," ).append("\n"); 
		query.append("   @[modi_rlane_cd]," ).append("\n"); 
		query.append("   @[user_id]," ).append("\n"); 
		query.append("   SYSDATE," ).append("\n"); 
		query.append("   @[user_id]," ).append("\n"); 
		query.append("   SYSDATE," ).append("\n"); 
		query.append("   @[delt_flg]," ).append("\n"); 
		query.append("   @[if_mnpl_cd]" ).append("\n"); 
		query.append(") " ).append("\n"); 

	}
}