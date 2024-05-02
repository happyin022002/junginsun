/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActivityDataDBDAOMultiSKDLogicUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.10.30 오현경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Oh hyun-kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActivityDataDBDAOMultiSKDLogicUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multiSKDLogic
	  * </pre>
	  */
	public ActivityDataDBDAOMultiSKDLogicUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foml_tm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_skd_lgc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foml_pct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_foml_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.integration").append("\n"); 
		query.append("FileName : ActivityDataDBDAOMultiSKDLogicUSQL").append("\n"); 
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
		query.append("MERGE INTO  sce_cop_skd_lgc a" ).append("\n"); 
		query.append("USING ( SELECT COUNT(*) AS cnt" ).append("\n"); 
		query.append("FROM sce_cop_skd_lgc" ).append("\n"); 
		query.append("WHERE cop_skd_lgc_no = @[cop_skd_lgc_no]  ) b" ).append("\n"); 
		query.append("ON    ( b.cnt > 0)" ).append("\n"); 
		query.append("WHEN  MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET     act_cd      = @[act_cd]," ).append("\n"); 
		query.append("cop_foml_cd = @[cop_foml_cd]," ).append("\n"); 
		query.append("foml_tm_hrs = @[foml_tm_hrs]," ).append("\n"); 
		query.append("foml_pct_no = @[foml_pct_no]," ).append("\n"); 
		query.append("fm_eff_dt   = @[fm_eff_dt]," ).append("\n"); 
		query.append("to_eff_dt   = @[to_eff_dt]," ).append("\n"); 
		query.append("upd_usr_id  = @[upd_usr_id]," ).append("\n"); 
		query.append("upd_dt      = SYSDATE" ).append("\n"); 
		query.append("WHERE cop_skd_lgc_no = @[cop_skd_lgc_no]" ).append("\n"); 
		query.append("WHEN  NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT  ( cop_skd_lgc_no," ).append("\n"); 
		query.append("act_cd," ).append("\n"); 
		query.append("cop_foml_cd," ).append("\n"); 
		query.append("foml_tm_hrs," ).append("\n"); 
		query.append("foml_pct_no," ).append("\n"); 
		query.append("fm_eff_dt," ).append("\n"); 
		query.append("to_eff_dt," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("upd_dt)" ).append("\n"); 
		query.append("VALUES  ( @[cop_skd_lgc_no]," ).append("\n"); 
		query.append("@[act_cd]," ).append("\n"); 
		query.append("@[cop_foml_cd]," ).append("\n"); 
		query.append("@[foml_tm_hrs]," ).append("\n"); 
		query.append("@[foml_pct_no]," ).append("\n"); 
		query.append("@[fm_eff_dt]," ).append("\n"); 
		query.append("@[to_eff_dt]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE)" ).append("\n"); 

	}
}