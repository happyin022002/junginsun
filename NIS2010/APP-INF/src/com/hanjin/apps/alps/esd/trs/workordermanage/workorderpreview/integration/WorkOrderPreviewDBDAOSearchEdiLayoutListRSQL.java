/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdiLayoutListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdiLayoutListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiLayoutList
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdiLayoutListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flt_file_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration ").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdiLayoutListRSQL").append("\n"); 
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
		query.append("A.EDI_VNDR_SEQ" ).append("\n"); 
		query.append(", A.FLT_FILE_NO" ).append("\n"); 
		query.append(", A.COL_NM" ).append("\n"); 
		query.append(", A.COL_SEQ" ).append("\n"); 
		query.append(", A.COL_LVL" ).append("\n"); 
		query.append(", A.COL_KND_CD" ).append("\n"); 
		query.append(", A.COL_LEN" ).append("\n"); 
		query.append(", A.COL_DESC" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_EDI_FLT_FILE_PRTP A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.EDI_VNDR_SEQ										= @[edi_vndr_seq]" ).append("\n"); 
		query.append("AND A.FLT_FILE_NO									= @[flt_file_no]" ).append("\n"); 
		query.append("AND A.HJL_NO IS NULL" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("A.COL_SEQ" ).append("\n"); 

	}
}