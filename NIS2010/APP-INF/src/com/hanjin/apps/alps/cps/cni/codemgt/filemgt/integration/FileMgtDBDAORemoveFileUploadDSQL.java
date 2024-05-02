/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FileMgtDBDAORemoveFileUploadDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.10.27 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.codemgt.filemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FileMgtDBDAORemoveFileUploadDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FileUpload 삭제
	  * </pre>
	  */
	public FileMgtDBDAORemoveFileUploadDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_file_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.codemgt.filemgt.integration ").append("\n"); 
		query.append("FileName : FileMgtDBDAORemoveFileUploadDSQL").append("\n"); 
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
		query.append("DELETE FROM CNI_ATCH_FILE" ).append("\n"); 
		query.append("WHERE	CLM_FILE_SEQ = @[clm_file_seq]" ).append("\n"); 

	}
}