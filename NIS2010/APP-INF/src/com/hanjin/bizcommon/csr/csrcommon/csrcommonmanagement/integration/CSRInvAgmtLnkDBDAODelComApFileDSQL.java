/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSRInvAgmtLnkDBDAODelComApFileDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRInvAgmtLnkDBDAODelComApFileDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DELETE
	  * </pre>
	  */
	public CSRInvAgmtLnkDBDAODelComApFileDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.integration").append("\n"); 
		query.append("FileName : CSRInvAgmtLnkDBDAODelComApFileDSQL").append("\n"); 
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
		query.append("UPDATE COM_AP_FILE_UPLD F" ).append("\n"); 
		query.append("   SET F.DELT_FLG = 'Y'," ).append("\n"); 
		query.append("       F.DELT_USR_ID = @[cre_usr_id]," ).append("\n"); 
		query.append("       F.DELT_DT = SYSDATE," ).append("\n"); 
		query.append("       F.UPD_USR_ID = @[cre_usr_id]," ).append("\n"); 
		query.append("       F.UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND F.ATCH_FILE_ID = @[atch_file_id]" ).append("\n"); 
		query.append("   AND F.CSR_NO = @[csr_no]" ).append("\n"); 

	}
}