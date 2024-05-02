/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSvcOrdCnclVndrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.10 
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

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSvcOrdCnclVndrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Spot Bid SO 건에 대해 Cancel 처리시 GuideLine Vndr Seq 를 Service Order Table 에 Update 처리한다.
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSvcOrdCnclVndrUSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSvcOrdCnclVndrUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("   SET VNDR_SEQ = (SELECT GLINE_VNDR_SEQ" ).append("\n"); 
		query.append("          FROM TRS_SPOT_BID" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND SPOT_BID_NO = SO.SPOT_BID_NO" ).append("\n"); 
		query.append("--           AND TRSP_WO_OFC_CTY_CD = SO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("--           AND TRSP_WO_SEQ = SO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("           AND TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND TRSP_SO_SEQ = SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND ROWNUM = 1)" ).append("\n"); 
		query.append(" WHERE (TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("               TRSP_SO_SEQ) IN (SELECT TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("               TRSP_SO_SEQ" ).append("\n"); 
		query.append("          FROM TRS_TRSP_WRK_ORD_PRV_TMP" ).append("\n"); 
		query.append("         WHERE WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("           AND WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("           AND WO_CXL_FLG = 'Y' )" ).append("\n"); 
		query.append("   AND HJL_NO IS NULL" ).append("\n"); 
		query.append("   AND SPOT_BID_FLG = 'Y'" ).append("\n"); 

	}
}