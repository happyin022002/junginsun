/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UncollectedCargoDBDAOSearchUploadFileInfoRSQL.java
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

public class UncollectedCargoDBDAOSearchUploadFileInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchUploadFileInfo 
	  * </pre>
	  */
	public UncollectedCargoDBDAOSearchUploadFileInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("s_uc_cs_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_uc_cgo_file_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAOSearchUploadFileInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("--A.UC_CGO_FILE_ID AS FILE_NO," ).append("\n"); 
		query.append("A.UC_CGO_FILE_ID," ).append("\n"); 
		query.append("A.FILE_NO_SEQ," ).append("\n"); 
		query.append("A.FILE_NM AS FILE_UPLD_NM," ).append("\n"); 
		query.append("A.FILE_SAV_ID," ).append("\n"); 
		query.append("'NONE' AS FILE_PATH_URL," ).append("\n"); 
		query.append("A.CRE_USR_ID," ).append("\n"); 
		query.append("--TO_CHAR(TPB_GET_LCL_DATE_FNC(CRE_DT,'BOMBB'),'YYYY/MM/DD HH24:MI:SS') AS CRE_DT," ).append("\n"); 
		query.append("A.CRE_DT," ).append("\n"); 
		query.append("A.UPD_USR_ID," ).append("\n"); 
		query.append("--TO_CHAR(TPB_GET_LCL_DATE_FNC(UPD_DT,'BOMBB'),'YYYY/MM/DD HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append("A.UPD_DT" ).append("\n"); 
		query.append("FROM CIM_UC_CGO_FILE A" ).append("\n"); 
		query.append("	 , COM_UPLD_FILE B" ).append("\n"); 
		query.append("WHERE A.UC_CS_NO = @[s_uc_cs_no]" ).append("\n"); 
		query.append("AND A.UC_CGO_FILE_ID = @[s_uc_cgo_file_id]" ).append("\n"); 
		query.append("#if (${s_uc_cgo_file_id} == 'UCA')" ).append("\n"); 
		query.append("	AND   A.FILE_SAV_ID = @[s_file_sav_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   A.FILE_SAV_ID = B.FILE_SAV_ID" ).append("\n"); 
		query.append("AND   B.PGM_SUB_SYS_CD = 'CIM'" ).append("\n"); 
		query.append("ORDER BY A.FILE_NO_SEQ" ).append("\n"); 

	}
}