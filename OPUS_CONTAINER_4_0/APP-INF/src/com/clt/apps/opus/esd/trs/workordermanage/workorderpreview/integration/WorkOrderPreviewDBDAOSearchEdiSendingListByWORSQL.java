/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdiSendingListByWORSQL.java
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

public class WorkOrderPreviewDBDAOSearchEdiSendingListByWORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiSendingListByWO
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdiSendingListByWORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_knt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdiSendingListByWORSQL").append("\n"); 
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
		query.append("SELECT							" ).append("\n"); 
		query.append("		SO.TRSP_CRR_MOD_CD,			" ).append("\n"); 
		query.append("		SO.TRSP_COST_DTL_MOD_CD,		" ).append("\n"); 
		query.append("		SO.VNDR_SEQ				" ).append("\n"); 
		query.append("FROM							" ).append("\n"); 
		query.append("		TRS_TRSP_SVC_ORD SO,			" ).append("\n"); 
		query.append("		TRS_TRSP_WRK_ORD WO			" ).append("\n"); 
		query.append("WHERE							" ).append("\n"); 
		query.append("	WO.TRSP_WO_OFC_CTY_CD = @[trsp_wo_ofc_cty_cd]		" ).append("\n"); 
		query.append("AND 	WO.TRSP_WO_SEQ = @[trsp_wo_seq]					" ).append("\n"); 
		query.append("AND 	WO.WO_ISS_KNT = @[wo_iss_knt]					" ).append("\n"); 
		query.append("AND 	WO.TRSP_WO_OFC_CTY_CD = SO.TRSP_WO_OFC_CTY_CD	" ).append("\n"); 
		query.append("AND 	WO.TRSP_WO_SEQ = SO.TRSP_WO_SEQ			" ).append("\n"); 

	}
}