/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FileMgtDBDAOSearchFileDwcInsuranceListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.26 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.filemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FileMgtDBDAOSearchFileDwcInsuranceListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * File attachment 조회
	  * </pre>
	  */
	public FileMgtDBDAOSearchFileDwcInsuranceListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.codemgt.filemgt.integration").append("\n"); 
		query.append("FileName : FileMgtDBDAOSearchFileDwcInsuranceListVORSQL").append("\n"); 
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
		query.append(",	CLM_FILE_TP_CD" ).append("\n"); 
		query.append(",	CLM_BZTP_CD" ).append("\n"); 
		query.append(",	FILE_SAV_ID" ).append("\n"); 
		query.append(",	FILE_NM" ).append("\n"); 
		query.append(",	FILE_DESC" ).append("\n"); 
		query.append(",	DW_CLM_NO" ).append("\n"); 
		query.append(",   0 FILE_DOWNLOAD" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("FROM CNI_ATCH_FILE" ).append("\n"); 
		query.append("WHERE	DW_CLM_NO = @[dw_clm_no]" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}