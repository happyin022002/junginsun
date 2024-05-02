/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CSRInvAgmtLnkDBDAOSelRqstAproStepFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRInvAgmtLnkDBDAOSelRqstAproStepFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RqstAproStepFlg
	  * </pre>
	  */
	public CSRInvAgmtLnkDBDAOSelRqstAproStepFlgRSQL(){
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
		query.append("Path : com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.integration ").append("\n"); 
		query.append("FileName : CSRInvAgmtLnkDBDAOSelRqstAproStepFlgRSQL").append("\n"); 
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
		query.append("SELECT NVL(RQST_APRO_STEP_FLG, 'N') AS RQST_APRO_STEP_FLG" ).append("\n"); 
		query.append("  FROM AP_INV_HDR" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND CSR_NO = @[csr_no]--'12STYOBB07050900006'" ).append("\n"); 

	}
}