/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ArApprovalDBDAOSearchOfcCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.16
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.01.16 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArApprovalDBDAOSearchOfcCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR_NO로 OFC_CD 조회
	  * </pre>
	  */
	public ArApprovalDBDAOSearchOfcCdRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.integration").append("\n"); 
		query.append("FileName : ArApprovalDBDAOSearchOfcCdRSQL").append("\n"); 
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
		query.append("SELECT J.SLP_OFC_CD " ).append("\n"); 
		query.append("FROM FMS_CONSULTATION J" ).append("\n"); 
		query.append("WHERE J.SLP_TP_CD||J.SLP_FUNC_CD||J.SLP_OFC_CD||J.SLP_ISS_DT||J.SLP_SER_NO = @[csr_no] " ).append("\n"); 

	}
}