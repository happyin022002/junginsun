/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OperationNPerformMasterDataMgtDBDAOOpfStvDmgCdVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.15
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.05.15 우지석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ji Seok Woo
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class OperationNPerformMasterDataMgtDBDAOOpfStvDmgCdVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    update opf_stv_dmg_cd set
	  * </pre>
	  */
	public OperationNPerformMasterDataMgtDBDAOOpfStvDmgCdVOUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("stv_dmg_cd_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("update opf_stv_dmg_cd set" ).append("\n"); 
		query.append("stv_dmg_cate_cd = @[stv_dmg_cate_cd]," ).append("\n"); 
		query.append("stv_dmg_cd = @[stv_dmg_cd]," ).append("\n"); 
		query.append("stv_dmg_cd_desc = @[stv_dmg_cd_desc]," ).append("\n"); 
		query.append("stv_dmg_grp_cd = 'P'," ).append("\n"); 
		query.append("upd_usr_id = @[upd_usr_id]," ).append("\n"); 
		query.append("upd_dt = sysdate" ).append("\n"); 
		query.append("where	stv_dmg_cate_cd = @[stv_dmg_cate_cd]" ).append("\n"); 
		query.append("and	stv_dmg_cd = @[stv_dmg_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration").append("\n"); 
		query.append("FileName : OperationNPerformMasterDataMgtDBDAOOpfStvDmgCdVOUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}