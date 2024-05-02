/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BRKGAuditDBDAOSearchAPActualInterfaceBRKGCsrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BRKGAuditDBDAOSearchAPActualInterfaceBRKGCsrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Brokerge의 CSR No search
	  * </pre>
	  */
	public BRKGAuditDBDAOSearchAPActualInterfaceBRKGCsrNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_gubun",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration").append("\n"); 
		query.append("FileName : BRKGAuditDBDAOSearchAPActualInterfaceBRKGCsrNoRSQL").append("\n"); 
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
		query.append("'08'||@[csr_gubun]||@[ap_ofc_cd]||SUBSTR(@[loc_dt],3,6)||TO_CHAR(SER,'FM00000') AS CSR_NO	--//:csr_part_no" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(MAX(TO_NUMBER(SUBSTR(CSR_NO,LENGTH(CSR_NO)-4)))+1,10001) SER" ).append("\n"); 
		query.append("FROM AP_CSR_NO" ).append("\n"); 
		query.append("WHERE CSR_NO LIKE '08'||@[csr_gubun]||@[ap_ofc_cd]||SUBSTR(@[loc_dt],3,6)||'%'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}