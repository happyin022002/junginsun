/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGTAuditDBDAOCancelAgentActualINFListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOCancelAgentActualINFListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CancelAgentActualINFList
	  * </pre>
	  */
	public AGTAuditDBDAOCancelAgentActualINFListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_apro_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOCancelAgentActualINFListRSQL").append("\n"); 
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
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("A.AGN_CD," ).append("\n"); 
		query.append("A.IO_BND_CD," ).append("\n"); 
		query.append("A.AC_TP_CD," ).append("\n"); 
		query.append("A.AC_SEQ," ).append("\n"); 
		query.append("A.ACT_PRE_COMM_AMT," ).append("\n"); 
		query.append("A.ACT_COMM_AMT," ).append("\n"); 
		query.append("A.ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("A.ACT_PRE_LOCL_COMM_AMT," ).append("\n"); 
		query.append("A.ACT_LOCL_COMM_AMT," ).append("\n"); 
		query.append("A.ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("B.CSR_NO	-- 2012.03.05 권상준 추가" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM A," ).append("\n"); 
		query.append("AP_PAY_INV B -- 2012.03.05 권상준 추가" ).append("\n"); 
		query.append("WHERE A.COMM_APRO_NO = @[comm_apro_no]" ).append("\n"); 
		query.append("AND A.COMM_APRO_NO = B.INV_NO(+) -- 2012.03.05 권상준 추가" ).append("\n"); 
		query.append("AND B.DELT_FLG(+) = 'N' -- 2012.03.05 권상준 추가" ).append("\n"); 

	}
}