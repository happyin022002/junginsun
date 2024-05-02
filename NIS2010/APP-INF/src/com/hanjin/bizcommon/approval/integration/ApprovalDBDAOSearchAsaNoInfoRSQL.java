/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ApprovalDBDAOSearchAsaNoInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOSearchAsaNoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAsaNoInfo
	  * </pre>
	  */
	public ApprovalDBDAOSearchAsaNoInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOSearchAsaNoInfoRSQL").append("\n"); 
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
		query.append("SELECT DECODE(A.ASA_APRO_DT,NULL,'O','C') IS_OPEN " ).append("\n"); 
		query.append("	  ,ASA_OFC_CD " ).append("\n"); 
		query.append("FROM AP_INV_HDR H, AR_AGN_STMT_AGMT A" ).append("\n"); 
		query.append("WHERE CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("AND SUBSTR(H.ATTR_CTNT2,0,3)||SUBSTR(H.ATTR_CTNT2,8,3)||SUBSTR(H.ATTR_CTNT2,4,4) = A.ASA_NO" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 

	}
}