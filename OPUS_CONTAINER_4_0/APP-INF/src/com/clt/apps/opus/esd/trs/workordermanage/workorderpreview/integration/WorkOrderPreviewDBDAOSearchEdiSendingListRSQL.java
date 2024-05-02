/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdiSendingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.02 
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

public class WorkOrderPreviewDBDAOSearchEdiSendingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiSendingList
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdiSendingListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdiSendingListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    B.COP_NO as cop_no," ).append("\n"); 
		query.append("    B.COST_ACT_GRP_SEQ as cost_act_grp_seq," ).append("\n"); 
		query.append("    B.VNDR_SEQ as vndr_seq" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_PRV_TMP A, TRS_TRSP_SVC_ORD B" ).append("\n"); 
		query.append("WHERE A.WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("    AND A.WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("	AND A.WO_CXL_FLG = 'N'" ).append("\n"); 
		query.append("	AND B.COP_NO IS NOT NULL" ).append("\n"); 
		query.append("    AND (B.TRSP_SO_OFC_CTY_CD, B.TRSP_SO_SEQ) IN ((A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ))" ).append("\n"); 

	}
}