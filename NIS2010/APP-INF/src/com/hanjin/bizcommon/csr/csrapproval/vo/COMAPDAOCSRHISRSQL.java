/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : COMAPDAOCSRHISRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrapproval.vo ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COMAPDAOCSRHISRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO MAKER
	  * </pre>
	  */
	public COMAPDAOCSRHISRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.csrapproval.vo ").append("\n"); 
		query.append("FileName : COMAPDAOCSRHISRSQL").append("\n"); 
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
		query.append("--ComApCsrHisVO.java" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("'' COM_AP_CSR_APRO_HIS_SEQ" ).append("\n"); 
		query.append(", '' CSR_NO" ).append("\n"); 
		query.append(", '' CSR_APRO_TP_CD" ).append("\n"); 
		query.append(", '' AUTO_MNL_FLG" ).append("\n"); 
		query.append(", '' INV_STS_CD" ).append("\n"); 
		query.append(", '' IO_BND_CD" ).append("\n"); 
		query.append(", '' IF_DT" ).append("\n"); 
		query.append(", '' GW_CSR_RQST_ID" ).append("\n"); 
		query.append(", '' GW_APRO_URL_CTNT" ).append("\n"); 
		query.append(", '' GW_APRO_RSLT_CD" ).append("\n"); 
		query.append(", '' CORR_HIS_RMK" ).append("\n"); 
		query.append(", '' CRE_USR_ID" ).append("\n"); 
		query.append(", '' CRE_DT" ).append("\n"); 
		query.append(", '' UPD_USR_ID" ).append("\n"); 
		query.append(", '' UPD_DT" ).append("\n"); 
		query.append(", '' APRO_USR_ID" ).append("\n"); 
		query.append(", '' APRO_USR_NM" ).append("\n"); 
		query.append(", '' APRO_USR_JB_TIT_NM" ).append("\n"); 
		query.append(", '' APRO_RMK" ).append("\n"); 
		query.append(", '' AP_CSR_IF_STS_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}