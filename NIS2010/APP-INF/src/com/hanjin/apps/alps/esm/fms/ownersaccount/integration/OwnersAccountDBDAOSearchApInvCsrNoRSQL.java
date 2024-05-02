/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOSearchApInvCsrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.24
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.03.24 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOSearchApInvCsrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnersAccount 전표 승인처리 후 자동생성된 AP_INV_HDR 데이터의 csr_no를 조회한다
	  * </pre>
	  */
	public OwnersAccountDBDAOSearchApInvCsrNoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOSearchApInvCsrNoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT SLP_TP_CD||SLP_FUNC_CD||SLP_OFC_CD||SLP_ISS_DT||SLP_SER_NO CSR_NO" ).append("\n"); 
		query.append("  FROM FMS_CSUL_SLP" ).append("\n"); 
		query.append(" WHERE ORG_SLP_TP_CD||ORG_SLP_FUNC_CD||ORG_SLP_OFC_CD||ORG_ISS_DT||ORG_SLP_SER_NO = @[csr_no]" ).append("\n"); 

	}
}