/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ApprovalDBDAOCheckUpdateRevVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.14
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.07.14 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOCheckUpdateRevVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rev VVD 업데이트 여부를 확인한다
	  * </pre>
	  */
	public ApprovalDBDAOCheckUpdateRevVVDRSQL(){
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
		query.append("FileName : ApprovalDBDAOCheckUpdateRevVVDRSQL").append("\n"); 
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
		query.append("SELECT NVL((" ).append("\n"); 
		query.append("SELECT MIN (EFF_YRMON)||'01' DT" ).append("\n"); 
		query.append("FROM AP_PERIOD" ).append("\n"); 
		query.append("WHERE SYS_DIV_CD = '15'" ).append("\n"); 
		query.append("AND EFF_YRMON >= SUBSTR(A.GL_DT,1,6)" ).append("\n"); 
		query.append("AND OFC_CD IN (A.TJ_OFC_CD,(SELECT M.AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = A.TJ_OFC_CD))" ).append("\n"); 
		query.append("AND AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("AND CLZ_STS_CD='O'),'N') AS NEW_GL_DT" ).append("\n"); 
		query.append("FROM AP_INV_HDR A" ).append("\n"); 
		query.append("WHERE A.CSR_NO = @[csr_no]" ).append("\n"); 

	}
}