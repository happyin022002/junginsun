/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewChkDupleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.18 
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

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewChkDupleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * trs_trsp_svc_ord 에 데이터 존재 유무 체크
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewChkDupleRSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewChkDupleRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUM(TRSP_SO_STS_CD), 0) ISSUE_CNT, NVL(SUM(DELT_FLG), 0) DELETE_CNT, NVL(SUM(CR_CNT), 0) CR_CNT" ).append("\n"); 
		query.append("  FROM (SELECT DECODE(SO.TRSP_SO_STS_CD, 'I', 1, 0) TRSP_SO_STS_CD" ).append("\n"); 
		query.append("              ,DECODE(SO.DELT_FLG, 'Y', 1, 0) DELT_FLG" ).append("\n"); 
		query.append("              ,CASE WHEN SO.TRSP_SO_STS_CD IN ('C', 'R') THEN 1" ).append("\n"); 
		query.append("                    ELSE 0" ).append("\n"); 
		query.append("               END CR_CNT" ).append("\n"); 
		query.append("          FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("         WHERE (TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ) IN (SELECT TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ" ).append("\n"); 
		query.append("                                                       FROM TRS_TRSP_WRK_ORD_PRV_TMP" ).append("\n"); 
		query.append("                                                      WHERE WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("                                                        AND WO_ISS_NO = @[wo_iss_no]))			" ).append("\n"); 

	}
}