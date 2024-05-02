/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CostAccrualDBDAOSearchInvoiceAccrualNumberCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sac.costaccrual.costaccrual.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostAccrualDBDAOSearchInvoiceAccrualNumberCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cost Accrual 테이블의 Max Number 값 가져오기
	  * </pre>
	  */
	public CostAccrualDBDAOSearchInvoiceAccrualNumberCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_yymm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sac.costaccrual.costaccrual.integration ").append("\n"); 
		query.append("FileName : CostAccrualDBDAOSearchInvoiceAccrualNumberCheckRSQL").append("\n"); 
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
		query.append("SELECT  NVL(MAX(GEIE.ESTM_SEQ_NO), 0) AS ESTM_SEQ_NO" ).append("\n"); 
		query.append("FROM    GL_ESTM_IF_ERP GEIE " ).append("\n"); 
		query.append("WHERE   EXE_YRMON = @[gl_yymm]  -- AP Header의 G/L DAte의 년월.." ).append("\n"); 
		query.append("AND     SYS_SRC_ID = 'SAP'" ).append("\n"); 

	}
}