/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOSearchItemAttachFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOSearchItemAttachFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VNOR Item Attach File을 조회한다.
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOSearchItemAttachFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOSearchItemAttachFileRSQL").append("\n"); 
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
		query.append("SELECT	OPF.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("		,OPF.ATCH_FILE_LNK_SEQ" ).append("\n"); 
		query.append("		,OPF.FILE_SAV_ID" ).append("\n"); 
		query.append("		,COM.FILE_UPLD_NM" ).append("\n"); 
		query.append("		,COM.FILE_PATH_URL" ).append("\n"); 
		query.append("		,OPF.UPD_USR_ID" ).append("\n"); 
		query.append("		,TO_CHAR(OPF.UPD_DT, 'YYYY-MM-DD HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append("		,'0' AS FILE_DOWNLOAD" ).append("\n"); 
		query.append("FROM OPF_ATCH_FILE OPF, COM_UPLD_FILE COM" ).append("\n"); 
		query.append("WHERE OPF.FILE_SAV_ID = COM.FILE_SAV_ID" ).append("\n"); 
		query.append("AND ATCH_FILE_LNK_ID = @[atch_file_lnk_id]" ).append("\n"); 
		query.append("ORDER BY ATCH_FILE_LNK_SEQ" ).append("\n"); 

	}
}