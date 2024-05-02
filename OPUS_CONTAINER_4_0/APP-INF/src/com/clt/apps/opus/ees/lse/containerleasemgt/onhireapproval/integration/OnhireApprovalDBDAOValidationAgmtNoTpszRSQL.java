/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OnhireApprovalDBDAOValidationAgmtNoTpszRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireApprovalDBDAOValidationAgmtNoTpszRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AGMT 관련 tpsz 비교
	  * </pre>
	  */
	public OnhireApprovalDBDAOValidationAgmtNoTpszRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration ").append("\n"); 
		query.append("FileName : OnhireApprovalDBDAOValidationAgmtNoTpszRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(MAX(SYS_CONNECT_BY_PATH (CNTR_TPSZ_CD,'|')), 2) AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  FROM (SELECT  LAR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("               ,ROW_NUMBER() OVER(PARTITION BY LAR.AGMT_SEQ ORDER BY LAR.CNTR_TPSZ_CD) AS RN" ).append("\n"); 
		query.append("          FROM LSE_AGMT_RT LAR" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND LAR.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("           AND LAR.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("           AND LAR.CNTR_RNTL_CHG_TP_CD = 'GENV'    " ).append("\n"); 
		query.append("         ORDER BY LAR.CNTR_TPSZ_CD) SUB" ).append("\n"); 
		query.append(" START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR RN = RN - 1" ).append("\n"); 

	}
}