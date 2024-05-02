/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOUpdateTrsTrspWrkOrdPreTmpByVendorCMUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.10 
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

public class WorkOrderPreviewDBDAOUpdateTrsTrspWrkOrdPreTmpByVendorCMUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderPreviewDBDAOUpdateTrsTrspWrkOrdPreTmpByVendorCM
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOUpdateTrsTrspWrkOrdPreTmpByVendorCMUSQL(){
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
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOUpdateTrsTrspWrkOrdPreTmpByVendorCMUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_WRK_ORD_PRV_TMP T" ).append("\n"); 
		query.append("   SET T.WO_CXL_FLG  = 'Y'" ).append("\n"); 
		query.append("	  ,T.TRSP_RJCT_RSN_CD = 'R'" ).append("\n"); 
		query.append("      ,T.LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(T.CRE_OFC_CD)" ).append("\n"); 
		query.append("      ,T.UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,T.UPD_DT      = SYSDATE" ).append("\n"); 
		query.append(" WHERE T.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND T.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND T.TRSP_WO_OFC_CTY_CD = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND T.TRSP_WO_SEQ = @[trsp_wo_seq]" ).append("\n"); 
		query.append("   AND T.WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 

	}
}