/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UncollectedCargoDBDAOCreateUploadFileInfoCOMCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UncollectedCargoDBDAOCreateUploadFileInfoCOMCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateUploadFileInfoCOM 
	  * </pre>
	  */
	public UncollectedCargoDBDAOCreateUploadFileInfoCOMCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_file_path_url",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_file_sav_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_file_upld_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAOCreateUploadFileInfoCOMCSQL").append("\n"); 
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
		query.append("INSERT INTO COM_UPLD_FILE (" ).append("\n"); 
		query.append("    FILE_SAV_ID," ).append("\n"); 
		query.append("    FILE_UPLD_NM," ).append("\n"); 
		query.append("    FILE_SZ_CAPA," ).append("\n"); 
		query.append("    FILE_PATH_URL," ).append("\n"); 
		query.append("    PGM_SUB_SYS_CD," ).append("\n"); 
		query.append("    DELT_FLG," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[s_file_sav_id]," ).append("\n"); 
		query.append("    REPLACE(@[s_file_upld_nm],'''','')," ).append("\n"); 
		query.append("    '100000'," ).append("\n"); 
		query.append("    @[s_file_path_url]," ).append("\n"); 
		query.append("    'CIM'," ).append("\n"); 
		query.append("    'N'," ).append("\n"); 
		query.append("    @[s_cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE, " ).append("\n"); 
		query.append("    @[s_cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}