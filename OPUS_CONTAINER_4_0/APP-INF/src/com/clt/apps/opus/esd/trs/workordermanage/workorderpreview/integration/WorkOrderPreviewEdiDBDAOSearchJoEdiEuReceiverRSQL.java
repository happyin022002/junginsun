/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOSearchJoEdiEuReceiverRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewEdiDBDAOSearchJoEdiEuReceiverRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderPreviewEdiDBDAOSearchJoEdiEuReceiver
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOSearchJoEdiEuReceiverRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewEdiDBDAOSearchJoEdiEuReceiverRSQL").append("\n"); 
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
		query.append("SELECT NVL((SELECT EDI_RCVR_NM" ).append("\n"); 
		query.append("              FROM TRS_EDI_USA_RCVR_DTL" ).append("\n"); 
		query.append("             WHERE VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("               AND EDI_RCVR_NM_USE_FLG = 'Y')" ).append("\n"); 
		query.append("      ,'NJ') EDI_RCVR_NM" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}