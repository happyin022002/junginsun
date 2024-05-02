/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PoolChassisHistoryDBDAOaddPoolChsFileImportDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.01.18 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PoolChassisHistoryDBDAOaddPoolChsFileImportDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PoolChassisHistoryDBDAOaddPoolChsFileImportDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sav_file_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("save_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_file_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.integration").append("\n"); 
		query.append("FileName : PoolChassisHistoryDBDAOaddPoolChsFileImportDataCSQL").append("\n"); 
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
		query.append("INSERT INTO" ).append("\n"); 
		query.append("CGM_POOL_CHSS_IMP_FILE(" ).append("\n"); 
		query.append("FILE_SEQ" ).append("\n"); 
		query.append(",ORG_FILE_NM" ).append("\n"); 
		query.append(",SAV_FILE_NM" ).append("\n"); 
		query.append(",CHSS_POOL_CD" ).append("\n"); 
		query.append(",COST_YRMON" ).append("\n"); 
		query.append(",FILE_IMP_PROC_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",FILE_IMP_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") VALUES  (" ).append("\n"); 
		query.append("(select nvl(max(FILE_SEQ)+1,1) from CGM_POOL_CHSS_IMP_FILE)" ).append("\n"); 
		query.append(",@[org_file_nm]" ).append("\n"); 
		query.append(",@[sav_file_nm]" ).append("\n"); 
		query.append(",@[chss_pool_cd]" ).append("\n"); 
		query.append(",@[cost_yrmon]" ).append("\n"); 
		query.append(",'P'" ).append("\n"); 
		query.append(", (select  GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC( @[save_chk]) from dual)" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}