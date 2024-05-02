/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RepairMgtDBDAOsearchHtmlCodeForThumbnailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.13
*@LastModifier : 이율규
*@LastVersion : 1.0
* 2015.10.13 이율규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yulkyu Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchHtmlCodeForThumbnailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 썸네일 코드 생성
	  * </pre>
	  */
	public RepairMgtDBDAOsearchHtmlCodeForThumbnailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration ").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchHtmlCodeForThumbnailRSQL").append("\n"); 
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
		query.append("SELECT FILE_PATH_NM," ).append("\n"); 
		query.append("       THM_FILE_PATH_NM" ).append("\n"); 
		query.append("  FROM MNR_FILE_ATCH_EXTR" ).append("\n"); 
		query.append(" WHERE FILE_SEQ = @[file_seq]" ).append("\n"); 

	}
}