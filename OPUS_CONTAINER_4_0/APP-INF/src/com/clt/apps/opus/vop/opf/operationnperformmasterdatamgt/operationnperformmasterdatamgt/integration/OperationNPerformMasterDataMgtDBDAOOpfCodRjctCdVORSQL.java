/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OperationNPerformMasterDataMgtDBDAOOpfCodRjctCdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2010.03.09 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Suk Hyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OperationNPerformMasterDataMgtDBDAOOpfCodRjctCdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public OperationNPerformMasterDataMgtDBDAOOpfCodRjctCdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration").append("\n"); 
		query.append("FileName : OperationNPerformMasterDataMgtDBDAOOpfCodRjctCdVORSQL").append("\n"); 
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
		query.append("cod_rjct_cd" ).append("\n"); 
		query.append(",	cod_rjct_desc" ).append("\n"); 
		query.append(",	delt_flg" ).append("\n"); 
		query.append("FROM opf_cod_rjct_cd" ).append("\n"); 
		query.append("WHERE delt_flg = 'N'" ).append("\n"); 
		query.append("ORDER BY cod_rjct_cd ASC" ).append("\n"); 

	}
}