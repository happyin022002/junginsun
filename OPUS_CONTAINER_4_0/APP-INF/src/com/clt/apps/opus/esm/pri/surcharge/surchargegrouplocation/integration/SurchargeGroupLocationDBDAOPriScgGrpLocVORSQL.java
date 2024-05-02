/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeGroupLocationDBDAOPriScgGrpLocVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.10 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung Jun Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeGroupLocationDBDAOPriScgGrpLocVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group Location select
	  * </pre>
	  */
	public SurchargeGroupLocationDBDAOPriScgGrpLocVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("select" ).append("\n"); 
		query.append("svc_scp_cd," ).append("\n"); 
		query.append("chg_cd," ).append("\n"); 
		query.append("grp_loc_seq," ).append("\n"); 
		query.append("scg_grp_loc_cd," ).append("\n"); 
		query.append("scg_grp_loc_desc," ).append("\n"); 
		query.append("delt_flg," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("to_char(cre_dt,'yyyy-mm-dd') as cre_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("to_char(upd_dt,'yyyy-mm-dd') as upd_dt" ).append("\n"); 
		query.append("from pri_scg_grp_loc" ).append("\n"); 
		query.append("where	svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("and	chg_cd = @[chg_cd]" ).append("\n"); 
		query.append("and delt_flg = 'N'" ).append("\n"); 
		query.append("ORDER BY scg_grp_loc_cd" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.integration").append("\n"); 
		query.append("FileName : SurchargeGroupLocationDBDAOPriScgGrpLocVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}