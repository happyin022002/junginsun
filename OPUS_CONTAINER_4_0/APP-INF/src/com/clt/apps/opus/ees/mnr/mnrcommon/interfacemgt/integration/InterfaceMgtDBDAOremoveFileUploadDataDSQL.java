/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InterfaceMgtDBDAOremoveFileUploadDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2009.06.10 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOremoveFileUploadDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * File Upload Data를 삭제하는 Operation이다.
	  * </pre>
	  */
	public InterfaceMgtDBDAOremoveFileUploadDataDSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE FROM MNR_FILE_ATCH A" ).append("\n"); 
		query.append("WHERE FILE_SEQ = @[file_seq]" ).append("\n"); 
		query.append("AND   FILE_DTL_SEQ = @[file_dtl_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration ").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOremoveFileUploadDataDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}