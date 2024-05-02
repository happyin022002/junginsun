/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ApprovalDBDAOSearchAsaNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOSearchAsaNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAsaNo
	  * </pre>
	  */
	public ApprovalDBDAOSearchAsaNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration ").append("\n"); 
		query.append("FileName : ApprovalDBDAOSearchAsaNoRSQL").append("\n"); 
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
		query.append("SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(ASA_NO,'|')),'|') ASA_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT ASA_NO, ROWNUM ROW_ID, asa_curr_cd" ).append("\n"); 
		query.append("    FROM   AR_AGN_STMT_AGMT" ).append("\n"); 
		query.append("    WHERE  EXPN_EFF_DT IS NULL" ).append("\n"); 
		query.append("    AND    AC_EFF_DT IS NULL" ).append("\n"); 
		query.append("    AND    ASA_CLZ_DT IS NULL" ).append("\n"); 
		query.append("    AND    ASA_APRO_DT IS NULL" ).append("\n"); 
		query.append("    AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("    AND    ASA_OFC_CD = @[asa_ofc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH ROW_ID = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 

	}
}