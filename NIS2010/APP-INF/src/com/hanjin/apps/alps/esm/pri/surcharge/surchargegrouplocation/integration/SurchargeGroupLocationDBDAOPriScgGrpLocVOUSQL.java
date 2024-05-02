/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeGroupLocationDBDAOPriScgGrpLocVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.15
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.15 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.core.layer.integration.DAO;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung Jun Lee
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class SurchargeGroupLocationDBDAOPriScgGrpLocVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group Location update
	  * </pre>
	  */
	public SurchargeGroupLocationDBDAOPriScgGrpLocVOUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_grp_loc_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_loc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_grp_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("update pri_scg_grp_loc set" ).append("\n"); 
		query.append("scg_grp_loc_cd = @[scg_grp_loc_cd]," ).append("\n"); 
		query.append("scg_grp_loc_desc = @[scg_grp_loc_desc]," ).append("\n"); 
		query.append("upd_usr_id = @[upd_usr_id]," ).append("\n"); 
		query.append("upd_dt = sysdate" ).append("\n"); 
		query.append("where	svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("and	chg_cd = @[chg_cd]" ).append("\n"); 
		query.append("and	grp_loc_seq = @[grp_loc_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.integration").append("\n"); 
		query.append("FileName : SurchargeGroupLocationDBDAOPriScgGrpLocVOUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}