/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewEmptyContainerRSQL.java
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

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewEmptyContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * empty container select
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewEmptyContainerRSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewEmptyContainerRSQL").append("\n"); 
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
		query.append("    A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    , A.TRSP_SO_SEQ " ).append("\n"); 
		query.append("    , A.WO_PRV_GRP_SEQ " ).append("\n"); 
		query.append("    , B.REPO_PLN_ID " ).append("\n"); 
		query.append("    , B.PLN_YRWK " ).append("\n"); 
		query.append("    , B.REF_ID " ).append("\n"); 
		query.append("    , B.REF_SEQ " ).append("\n"); 
		query.append("    , (" ).append("\n"); 
		query.append("        SELECT ROUND((TO_NUMBER( NVL(B.BZC_AMT, 0) + NVL(B.ETC_ADD_AMT, 0) + NVL(B.FUEL_SCG_AMT, 0) + NVL(B.SCG_VAT_AMT, 0) + NVL(B.NEGO_AMT, 0) + NVL(B.TOLL_FEE_AMT, 0)) " ).append("\n"); 
		query.append("            / RAT.USD_LOCL_XCH_RT), 2) OVR_USD" ).append("\n"); 
		query.append("        FROM GL_MON_XCH_RT RAT" ).append("\n"); 
		query.append("        WHERE RAT.CURR_CD = A.CURR_CD" ).append("\n"); 
		query.append("            AND RAT.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("            AND RAT.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE, 'YYYYMM') " ).append("\n"); 
		query.append("    ) AS TOT_AMT" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_PRV_TMP A," ).append("\n"); 
		query.append("    TRS_TRSP_SVC_ORD B" ).append("\n"); 
		query.append("WHERE A.WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("    AND A.WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("    AND A.WO_CXL_FLG = 'N'" ).append("\n"); 
		query.append("    AND A.CGO_TP_CD = 'M'" ).append("\n"); 
		query.append("    AND B.TRSP_SO_TP_CD = 'M'" ).append("\n"); 
		query.append("    AND A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND A.TRSP_SO_SEQ = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("    -- /* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("    AND B.HJL_NO IS NULL" ).append("\n"); 

	}
}