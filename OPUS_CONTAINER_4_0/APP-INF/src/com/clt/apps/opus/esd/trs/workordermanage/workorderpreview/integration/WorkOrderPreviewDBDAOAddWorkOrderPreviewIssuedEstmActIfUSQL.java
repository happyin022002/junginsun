/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedEstmActIfUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.09
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.03.09 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedEstmActIfUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAC_TRSP_ESTM_ACT_IF 테이블에 업데이트 처리
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedEstmActIfUSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedEstmActIfUSQL").append("\n"); 
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
		query.append("UPDATE SAC_TRSP_ESTM_ACT_IF" ).append("\n"); 
		query.append("   SET CXL_FLG = 'Y'" ).append("\n"); 
		query.append("     , CXL_DT = SYSDATE" ).append("\n"); 
		query.append("     , UPD_USR_ID = 'TRS'" ).append("\n"); 
		query.append("     , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE WO_NO IN (" ).append("\n"); 
		query.append("        SELECT TRSP_WO_OFC_CTY_CD||TRSP_WO_SEQ" ).append("\n"); 
		query.append("          FROM TRS_TRSP_WRK_ORD_PRV_TMP" ).append("\n"); 
		query.append("         WHERE WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("           AND WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("		   AND (WO_CXL_FLG = 'Y' OR WO_ISS_STS_CD = 'R')" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("--  AND ESTM_ACT_DIV_CD = 'E'" ).append("\n"); 

	}
}