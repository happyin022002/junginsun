/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OperationNPerformMasterDataMgtDBDAOOpfStvDmgCdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.06.11 우지석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ji Seok Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OperationNPerformMasterDataMgtDBDAOOpfStvDmgCdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select  opf_stv_dmg_cd
	  * </pre>
	  */
	public OperationNPerformMasterDataMgtDBDAOOpfStvDmgCdVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("DECODE(stv_dmg_cate_cd, 'HULL', 'HULL', 'MACH', 'MACH','MATL') as stv_dmg_cate_cd," ).append("\n"); 
		query.append("stv_dmg_cd," ).append("\n"); 
		query.append("stv_dmg_cd_desc," ).append("\n"); 
		query.append("stv_dmg_grp_cd," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("upd_dt" ).append("\n"); 
		query.append("from opf_stv_dmg_cd" ).append("\n"); 
		query.append("where	stv_dmg_grp_cd = 'P'" ).append("\n"); 
		query.append("order by stv_dmg_cd" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration").append("\n"); 
		query.append("FileName : OperationNPerformMasterDataMgtDBDAOOpfStvDmgCdVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}