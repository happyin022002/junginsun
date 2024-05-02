/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UncollectedCargoDBDAOSearchUncollectedCargoFileRSQL.java
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

public class UncollectedCargoDBDAOSearchUncollectedCargoFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UC Activity 리스트 조회 
	  * </pre>
	  */
	public UncollectedCargoDBDAOSearchUncollectedCargoFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : UncollectedCargoDBDAOSearchUncollectedCargoFileRSQL").append("\n"); 
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
		query.append("SELECT UC_CS_NO" ).append("\n"); 
		query.append("        , UC_CGO_FILE_ID" ).append("\n"); 
		query.append("        , FILE_NO_SEQ" ).append("\n"); 
		query.append("        , FILE_DESC" ).append("\n"); 
		query.append("        , (SELECT OFC_CD FROM COM_USER WHERE USR_ID = A.UPD_USR_ID) AS OFC_CD" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , NVL2(UC_CGO_FILE_ID,'FILE ATTACH','') IMG_FILE_NO" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("        , (SELECT COUNT(*) FROM COM_UPLD_FILE B WHERE FILE_SAV_ID = A.FILE_SAV_ID AND PGM_SUB_SYS_CD = 'CIM') AS FILE_CNT" ).append("\n"); 
		query.append("        , FILE_SAV_ID" ).append("\n"); 
		query.append("		, '' as s_uc_cs_no" ).append("\n"); 
		query.append("		, '' as s_uc_cgo_file_id" ).append("\n"); 
		query.append("		, '' as cre_usr_id" ).append("\n"); 
		query.append("FROM CIM_UC_CGO_FILE A" ).append("\n"); 
		query.append("WHERE UC_CS_NO = @[s_uc_cs_no]" ).append("\n"); 
		query.append("AND   UC_CGO_FILE_ID = @[s_uc_cgo_file_id]" ).append("\n"); 
		query.append("ORDER BY FILE_NO_SEQ" ).append("\n"); 

	}
}