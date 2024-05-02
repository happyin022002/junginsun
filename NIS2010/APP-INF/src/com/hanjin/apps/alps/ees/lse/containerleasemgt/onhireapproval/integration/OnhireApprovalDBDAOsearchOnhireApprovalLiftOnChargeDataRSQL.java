/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OnhireApprovalDBDAOsearchOnhireApprovalLiftOnChargeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2010.03.17 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireApprovalDBDAOsearchOnhireApprovalLiftOnChargeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Onhire 될 장비의 Lift On Charge  내용을 조회
	  * </pre>
	  */
	public OnhireApprovalDBDAOsearchOnhireApprovalLiftOnChargeDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.integration").append("\n"); 
		query.append("FileName : OnhireApprovalDBDAOsearchOnhireApprovalLiftOnChargeDataRSQL").append("\n"); 
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
		query.append("   A.AGMT_SEQ " ).append("\n"); 
		query.append(" , LOWER(A.CNTR_TPSZ_CD) CNTR_TPSZ_CD1" ).append("\n"); 
		query.append(" , A.CNTR_TPSZ_CD CNTR_TPSZ_CD2" ).append("\n"); 
		query.append(" , A.N1ST_CHG_AMT " ).append("\n"); 
		query.append("FROM  LSE_AGMT_RT A" ).append("\n"); 
		query.append("    , MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("WHERE A.AGMT_CTY_CD         = 'HHO'    " ).append("\n"); 
		query.append("AND   A.CNTR_RNTL_CHG_TP_CD = 'LIFV'" ).append("\n"); 
		query.append("AND   A.LOC_CD              = B.SCC_CD" ).append("\n"); 
		query.append("AND   B.LCC_CD              = @[loc_cd]" ).append("\n"); 
		query.append("AND   A.AGMT_SEQ  IN ( #foreach($key IN ${agmt_seq})" ).append("\n"); 
		query.append("                       #if($velocityCount < $agmt_seq.size())" ).append("\n"); 
		query.append("                          '$key'," ).append("\n"); 
		query.append("                       #else" ).append("\n"); 
		query.append("                          '$key'" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                     #end )" ).append("\n"); 

	}
}