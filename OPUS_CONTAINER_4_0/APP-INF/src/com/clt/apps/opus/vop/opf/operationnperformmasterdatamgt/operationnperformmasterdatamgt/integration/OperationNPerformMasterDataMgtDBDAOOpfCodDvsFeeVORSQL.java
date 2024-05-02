/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OperationNPerformMasterDataMgtDBDAOOpfCodDvsFeeVORSQL.java
*@FileTitle : COD Diversion Fee Cdoe
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 백승일
*@LastVersion : 1.0
* 2012.04.12 백승일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Baek Seungil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OperationNPerformMasterDataMgtDBDAOOpfCodDvsFeeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COD Reject Reason Code Search   
	  * </pre>
	  */
	public OperationNPerformMasterDataMgtDBDAOOpfCodDvsFeeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration").append("\n"); 
		query.append("FileName : OperationNPerformMasterDataMgtDBDAOOpfCodDvsFeeVORSQL").append("\n"); 
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
		query.append("	CONTI_CD" ).append("\n"); 
		query.append(",	DVS_FEE_TP_CD" ).append("\n"); 
		query.append(",	DVS_FEE_AMT" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append("FROM OPF_COD_DVS_FEE" ).append("\n"); 
		query.append("WHERE delt_flg = 'N'" ).append("\n"); 
		query.append("ORDER BY CONTI_CD,DVS_FEE_TP_CD ASC" ).append("\n"); 

	}
}