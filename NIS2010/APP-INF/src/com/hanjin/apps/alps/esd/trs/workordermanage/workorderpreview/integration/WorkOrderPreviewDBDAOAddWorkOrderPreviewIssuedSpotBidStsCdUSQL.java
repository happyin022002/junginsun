/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSpotBidStsCdUSQL.java
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

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSpotBidStsCdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Spot Bid 건일경우 TRS_SPOT_BID 테이블의 해당 SPOT_BID_NO 건에 대해 Cancel 건에 대해서 P 로 변경한다.
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSpotBidStsCdUSQL(){
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
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSpotBidStsCdUSQL").append("\n"); 
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
		query.append("UPDATE TRS_SPOT_BID" ).append("\n"); 
		query.append("   SET SPOT_BID_STS_CD = 'P'," ).append("\n"); 
		query.append("       TRSP_WO_OFC_CTY_CD = NULL," ).append("\n"); 
		query.append("       TRSP_WO_SEQ = NULL," ).append("\n"); 
		query.append("       GLINE_VNDR_SEQ = NULL," ).append("\n"); 
		query.append("       GLINE_CURR_CD = NULL," ).append("\n"); 
		query.append("       GLINE_BZC_AMT = NULL," ).append("\n"); 
		query.append("       GLINE_FUEL_SCG_AMT = NULL," ).append("\n"); 
		query.append("       GLINE_TOLL_FEE_AMT = NULL," ).append("\n"); 
		query.append("       GLINE_SCG_VAT_AMT = NULL," ).append("\n"); 
		query.append("       GLINE_TTL_AMT = NULL," ).append("\n"); 
		query.append("       LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])," ).append("\n"); 
		query.append("       UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("       UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE (SPOT_BID_NO," ).append("\n"); 
		query.append("--               TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("--               TRSP_WO_SEQ," ).append("\n"); 
		query.append("               TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("               TRSP_SO_SEQ) IN (SELECT SPOT_BID_NO," ).append("\n"); 
		query.append("--               TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("--               TRSP_WO_SEQ," ).append("\n"); 
		query.append("               TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("               TRSP_SO_SEQ" ).append("\n"); 
		query.append("          FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("         WHERE (TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("                       TRSP_SO_SEQ) IN (SELECT TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("                       TRSP_SO_SEQ" ).append("\n"); 
		query.append("                  FROM TRS_TRSP_WRK_ORD_PRV_TMP" ).append("\n"); 
		query.append("                 WHERE WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("                   AND WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("                   AND WO_CXL_FLG = 'Y' )" ).append("\n"); 
		query.append("           AND HJL_NO IS NULL" ).append("\n"); 
		query.append("           AND SPOT_BID_FLG = 'Y')" ).append("\n"); 

	}
}