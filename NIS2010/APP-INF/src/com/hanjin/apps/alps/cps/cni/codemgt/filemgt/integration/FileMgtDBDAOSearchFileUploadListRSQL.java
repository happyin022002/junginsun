/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FileMgtDBDAOSearchFileUploadListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.11.11 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.codemgt.filemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FileMgtDBDAOSearchFileUploadListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FileUpload 리스트 출력
	  * </pre>
	  */
	public FileMgtDBDAOSearchFileUploadListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_file_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.codemgt.filemgt.integration").append("\n"); 
		query.append("FileName : FileMgtDBDAOSearchFileUploadListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("CLM_FILE_SEQ" ).append("\n"); 
		query.append(", FILE_SAV_ID" ).append("\n"); 
		query.append(", FILE_NM" ).append("\n"); 
		query.append(", FILE_DESC" ).append("\n"); 
		query.append(", CLM_FILE_DP_SEQ" ).append("\n"); 
		query.append(", '0' FILE_DOWNLOAD" ).append("\n"); 
		query.append(", TO_CHAR (UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_ATCH_FILE" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND CLM_FILE_TP_CD  = @[clm_file_tp_cd]" ).append("\n"); 
		query.append("AND CGO_CLM_REF_NO  = @[cgo_clm_ref_no]" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("CLM_FILE_DP_SEQ" ).append("\n"); 

	}
}