/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MisUseApprovalDBDAOMisUseApprovalNumberRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.01.04 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MisUseApprovalDBDAOMisUseApprovalNumberRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Miss Use 최대 Approval No.를 조회한다.
	  * </pre>
	  */
	public MisUseApprovalDBDAOMisUseApprovalNumberRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.integration").append("\n"); 
		query.append("FileName : MisUseApprovalDBDAOMisUseApprovalNumberRSQL").append("\n"); 
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
		query.append("SELECT  RQST_FIX||TRIM(TO_CHAR(RQST_CNT,'000000')) APRO_NO" ).append("\n"); 
		query.append("FROM   (SELECT  @[ofc_cd]||TO_CHAR(SYSDATE, 'YYMMDD')||'H' AS RQST_FIX," ).append("\n"); 
		query.append("(SELECT  COUNT(APRO_NO) +1" ).append("\n"); 
		query.append("FROM 	LSE_MSS_USD_APRO) AS RQST_CNT" ).append("\n"); 
		query.append("FROM    DUAL)" ).append("\n"); 

	}
}