/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewDraftChkDupleRSQLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.19 
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

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewDraftChkDupleRSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddWorkOrderPreView 
	  * Draft 체크
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewDraftChkDupleRSQLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("group_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewDraftChkDupleRSQLRSQL").append("\n"); 
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
		query.append("SELECT COUNT(SO.TRSP_WO_OFC_CTY_CD) CNT" ).append("\n"); 
		query.append("  FROM (SELECT TRSP_WO_OFC_CTY_CD, TRSP_WO_SEQ,WO_ISS_STS_CD" ).append("\n"); 
		query.append("          FROM TRS_TRSP_WRK_ORD" ).append("\n"); 
		query.append("         WHERE (TRSP_WO_OFC_CTY_CD, TRSP_WO_SEQ) IN (SELECT TRSP_WO_OFC_CTY_CD, TRSP_WO_SEQ" ).append("\n"); 
		query.append("                                 FROM trs_trsp_wrk_ord_prv_tmp O" ).append("\n"); 
		query.append("                                                      WHERE wo_prv_grp_seq = @[group_seq]" ).append("\n"); 
		query.append("                                                        )) WRK" ).append("\n"); 
		query.append("      ,TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append(" WHERE WRK.TRSP_WO_OFC_CTY_CD = SO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND WRK.TRSP_WO_SEQ = SO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("   AND WRK.WO_ISS_STS_CD = 'I'" ).append("\n"); 
		query.append("   AND NVL(SO.TRS_SUB_STS_CD, 'DF') <> 'DF'" ).append("\n"); 

	}
}