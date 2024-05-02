/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FileMgtDBDAOModifyFileUploadUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.11.30 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.filemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FileMgtDBDAOModifyFileUploadUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * File Upload  Contents 수정
	  * </pre>
	  */
	public FileMgtDBDAOModifyFileUploadUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_file_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.codemgt.filemgt.integration ").append("\n"); 
		query.append("FileName : FileMgtDBDAOModifyFileUploadUSQL").append("\n"); 
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
		query.append("UPDATE CNI_ATCH_FILE SET" ).append("\n"); 
		query.append("FILE_DESC = @[file_desc]" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append("WHERE	CLM_FILE_SEQ = @[clm_file_seq]" ).append("\n"); 

	}
}