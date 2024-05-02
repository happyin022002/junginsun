/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TPBFileUploadDBDAOSearchUploadFileInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.fileupload.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TPBFileUploadDBDAOSearchUploadFileInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchUploadFileInfo
	  * </pre>
	  */
	public TPBFileUploadDBDAOSearchUploadFileInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_file_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.common.fileupload.integration").append("\n"); 
		query.append("FileName : TPBFileUploadDBDAOSearchUploadFileInfoRSQL").append("\n"); 
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
		query.append("SELECT A.FILE_NO," ).append("\n"); 
		query.append("A.FILE_NO_SEQ," ).append("\n"); 
		query.append("B.FILE_UPLD_NM FILE_LGC_NM," ).append("\n"); 
		query.append("B.FILE_SAV_ID FILE_PHYS_NM," ).append("\n"); 
		query.append("B.FILE_PATH_URL," ).append("\n"); 
		query.append("B.CRE_USR_ID," ).append("\n"); 
		query.append("'0' FILE_DOWNLOAD," ).append("\n"); 
		query.append("TO_CHAR(TPB_GET_LCL_DATE_FNC(B.CRE_DT, @[s_user_ofc_cd]),'YYYY/MM/DD HH24:MI:SS') AS CRE_DT," ).append("\n"); 
		query.append("B.UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(TPB_GET_LCL_DATE_FNC(B.UPD_DT, @[s_user_ofc_cd]),'YYYY/MM/DD HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append("FROM TPB_TTL_FILE_MGMT A," ).append("\n"); 
		query.append("COM_UPLD_FILE B" ).append("\n"); 
		query.append("WHERE A.FILE_PHYS_NM = B.FILE_SAV_ID" ).append("\n"); 
		query.append("AND A.FILE_NO = @[s_file_no]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY A.FILE_NO_SEQ, B.CRE_DT DESC" ).append("\n"); 

	}
}