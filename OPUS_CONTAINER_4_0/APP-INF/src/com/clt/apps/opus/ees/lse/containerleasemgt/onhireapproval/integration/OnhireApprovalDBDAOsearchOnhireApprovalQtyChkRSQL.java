/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OnhireApprovalDBDAOsearchOnhireApprovalQtyChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireApprovalDBDAOsearchOnhireApprovalQtyChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement 등록시 총 수량과 Total Qty와 비교
	  * </pre>
	  */
	public OnhireApprovalDBDAOsearchOnhireApprovalQtyChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration").append("\n"); 
		query.append("FileName : OnhireApprovalDBDAOsearchOnhireApprovalQtyChkRSQL").append("\n"); 
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
		query.append("SELECT SUM(ONH_QTY) ONH_QTY, TOTAL_ONH_QTY  " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT Q.AGMT_SEQ, Q.CNTR_TPSZ_CD, Q.ONH_QTY AS ONH_QTY, MAX(RT.AGMT_CHG_VAL) AS TOTAL_ONH_QTY" ).append("\n"); 
		query.append("FROM LSE_ONH_APRO_QTY  Q" ).append("\n"); 
		query.append("       , LSE_ONH_APRO A" ).append("\n"); 
		query.append("       , LSE_AGMT_RT RT" ).append("\n"); 
		query.append("WHERE 1=1 --Q.CNTR_ONH_AUTH_NO = A.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("AND  Q.AGMT_CTY_CD = RT.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND  Q.AGMT_SEQ     = RT.AGMT_SEQ" ).append("\n"); 
		query.append("AND  Q.CNTR_TPSZ_CD  = RT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND   RT.CNTR_RNTL_CHG_TP_CD = 'GENV'" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("        AND    Q.AGMT_SEQ IN( #foreach($key IN ${agmt_seq})" ).append("\n"); 
		query.append("                                       #if($velocityCount < $agmt_seq.size())" ).append("\n"); 
		query.append("                                          '$key'," ).append("\n"); 
		query.append("                                       #else" ).append("\n"); 
		query.append("                                          '$key' " ).append("\n"); 
		query.append("                                       #end" ).append("\n"); 
		query.append("                                   #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY Q.AGMT_SEQ,Q.CNTR_TPSZ_CD ,Q.ONH_QTY,Q.NEW_VAN_TP_CD" ).append("\n"); 
		query.append(") Z" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD,AGMT_SEQ,TOTAL_ONH_QTY" ).append("\n"); 

	}
}