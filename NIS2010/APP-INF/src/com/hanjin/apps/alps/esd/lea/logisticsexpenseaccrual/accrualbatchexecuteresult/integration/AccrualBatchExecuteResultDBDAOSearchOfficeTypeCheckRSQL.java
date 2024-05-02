/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchOfficeTypeCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOSearchOfficeTypeCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOfficeTypeCheck
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchOfficeTypeCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchOfficeTypeCheckRSQL").append("\n"); 
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
		query.append("SELECT   X.OFC_CD" ).append("\n"); 
		query.append(", CASE WHEN X.OFC_TP_CD   = 'HT' THEN 'HT'  /* 본사 */" ).append("\n"); 
		query.append("WHEN X.OFC_KND_CD  = '2'  THEN 'HQ'  /* 지역본부 또는 지역본부직속 */" ).append("\n"); 
		query.append("ELSE 'OTH'" ).append("\n"); 
		query.append("END                            AS OFC_TP_CD" ).append("\n"); 
		query.append("--      ,  CASE WHEN X.OFC_TP_CD   = 'HT' THEN 'HT'  /* 본사 */" ).append("\n"); 
		query.append("--              WHEN X.OFC_KND_CD  = '2'  THEN X.AR_HD_QTR_OFC_CD  /* 지역본부 또는 지역본부직속 */" ).append("\n"); 
		query.append("--              ELSE ''" ).append("\n"); 
		query.append("--         END                            AS RHQ_CD" ).append("\n"); 
		query.append("FROM     MDM_ORGANIZATION   X" ).append("\n"); 
		query.append("WHERE    X.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("AND       X.OFC_CD          = @[ofc_cd]  /* Login or changed office binding */" ).append("\n"); 

	}
}