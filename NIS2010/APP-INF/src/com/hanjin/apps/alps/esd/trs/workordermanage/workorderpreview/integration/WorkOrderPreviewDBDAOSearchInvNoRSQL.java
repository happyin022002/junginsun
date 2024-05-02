/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchInvNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchInvNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvNo
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchInvNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchInvNoRSQL").append("\n"); 
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
		query.append("SELECT INV_NO												" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD							" ).append("\n"); 
		query.append("WHERE                               " ).append("\n"); 
		query.append("(TRSP_SO_OFC_CTY_CD,TRSP_SO_SEQ) IN	" ).append("\n"); 
		query.append("	(													        " ).append("\n"); 
		query.append("				SELECT											" ).append("\n"); 
		query.append("			TRSP_SO_OFC_CTY_CD,TRSP_SO_SEQ" ).append("\n"); 
		query.append("			FROM TRS_TRSP_WRK_ORD_PRV_TMP	" ).append("\n"); 
		query.append("			WHERE WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]			" ).append("\n"); 
		query.append("			AND WO_ISS_NO = @[wo_iss_no]							" ).append("\n"); 
		query.append("	)                                 " ).append("\n"); 

	}
}