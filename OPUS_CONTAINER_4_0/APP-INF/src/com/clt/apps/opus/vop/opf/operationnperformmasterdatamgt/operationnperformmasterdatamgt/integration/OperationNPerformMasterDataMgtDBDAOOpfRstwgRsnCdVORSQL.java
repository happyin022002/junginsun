/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OperationNPerformMasterDataMgtDBDAOOpfRstwgRsnCdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.10.21 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OperationNPerformMasterDataMgtDBDAOOpfRstwgRsnCdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public OperationNPerformMasterDataMgtDBDAOOpfRstwgRsnCdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration").append("\n"); 
		query.append("FileName : OperationNPerformMasterDataMgtDBDAOOpfRstwgRsnCdVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("rstwg_rsn_cd" ).append("\n"); 
		query.append(",	MAX(rstwg_rsn_cd_full_desc) AS rstwg_rsn_cd_full_desc" ).append("\n"); 
		query.append(",	delt_flg" ).append("\n"); 
		query.append("FROM opf_rstwg_rsn_cd" ).append("\n"); 
		query.append("WHERE delt_flg = 'N'" ).append("\n"); 
		query.append("AND   RSTWG_CD_TP_CD <> 'S'" ).append("\n"); 
		query.append("GROUP BY rstwg_rsn_cd, delt_flg" ).append("\n"); 
		query.append("ORDER BY rstwg_rsn_cd" ).append("\n"); 

	}
}