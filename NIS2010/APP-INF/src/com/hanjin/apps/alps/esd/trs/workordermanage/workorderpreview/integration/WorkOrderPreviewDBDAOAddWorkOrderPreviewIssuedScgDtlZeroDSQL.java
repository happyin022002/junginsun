/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedScgDtlZeroDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.12.22 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedScgDtlZeroDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * trs_trsp_scg_dtl 에서 해당 금액정보가 0인 데이터 삭제
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedScgDtlZeroDSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedScgDtlZeroDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("FROM TRS_TRSP_SCG_DTL" ).append("\n"); 
		query.append("WHERE TRSP_SO_SEQ IN (" ).append("\n"); 
		query.append("        SELECT TRSP_SO_SEQ" ).append("\n"); 
		query.append("        FROM TRS_TRSP_WRK_ORD_PRV_TMP" ).append("\n"); 
		query.append("        WHERE WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("            AND WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("            AND NVL(FUEL_SCG_AMT, 0) = 0" ).append("\n"); 
		query.append("            AND NVL(SCG_VAT_AMT, 0) = 0 " ).append("\n"); 
		query.append("			AND NVL(ETC_ADD_AMT, 0) = 0" ).append("\n"); 
		query.append("			AND NVL(TOLL_FEE_AMT, 0) = 0" ).append("\n"); 
		query.append("			 )" ).append("\n"); 
		query.append("  -- /* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("  AND HJL_NO IS NULL" ).append("\n"); 

	}
}