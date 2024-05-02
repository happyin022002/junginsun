/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOManageTrsTrspWrkOrdByVendorCMUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.22 
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

public class WorkOrderPreviewDBDAOManageTrsTrspWrkOrdByVendorCMUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOManageTrsTrspWrkOrdByVendorCMUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOManageTrsTrspWrkOrdByVendorCMUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_WRK_ORD O" ).append("\n"); 
		query.append("   SET WO_ISS_STS_CD = (SELECT CASE WHEN COUNT(*) > 0 THEN 'C' ELSE 'N' END " ).append("\n"); 
		query.append("								FROM TRS_TRSP_SVC_ORD S " ).append("\n"); 
		query.append("							WHERE S.TRSP_WO_OFC_CTY_CD = O.TRSP_WO_OFC_CTY_CD " ).append("\n"); 
		query.append("							AND S.TRSP_WO_SEQ = O.TRSP_WO_SEQ " ).append("\n"); 
		query.append("							AND NVL(S.DELT_FLG, 'N') <> 'Y')" ).append("\n"); 
		query.append("       ,UPD_USR_ID    = @[upd_usr_id]" ).append("\n"); 
		query.append("       ,UPD_DT        = SYSDATE" ).append("\n"); 
		query.append("       ,LOCL_UPD_DT   = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD)" ).append("\n"); 
		query.append(" WHERE TRSP_WO_OFC_CTY_CD = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND TRSP_WO_SEQ = @[trsp_wo_seq]" ).append("\n"); 

	}
}