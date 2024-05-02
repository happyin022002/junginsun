/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi17536801CntrEurDetailsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.13
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2012.02.13 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdi17536801CntrEurDetailsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdi17536801CntrEurDetails
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi17536801CntrEurDetailsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi17536801CntrEurDetailsRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC (CRO XPKBKG_FULL_CGO_RLSE_ORD) */" ).append("\n"); 
		query.append("CRO.CO_BDG_ID 								EUR_BADGECODE," ).append("\n"); 
		query.append("CRO.CGO_CRR_ID 								EUR_ONCARRIAGE_ID," ).append("\n"); 
		query.append("TO_CHAR(CRO.RLSE_CRE_DT, 'YYYYMMDDHH24MI') 	EUR_RELEASE_DT," ).append("\n"); 
		query.append("TO_CHAR(CRO.RLSE_EXP_DT, 'YYYYMMDDHH24MI') 	EUR_EXPIRY_DT," ).append("\n"); 
		query.append("CRO.PIN_NO									EUR_PIN," ).append("\n"); 
		query.append("CRO.VEH_RGST_ID 								EUR_VEHICLE_ID," ).append("\n"); 
		query.append("CRO.ROAD_HLG_ID 								EUR_RHIDS," ).append("\n"); 
		query.append("CRO.UQ_VSL_ID_NO 							EUR_UVI" ).append("\n"); 
		query.append("FROM BKG_FULL_CGO_RLSE_ORD  CRO," ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND SO.HJL_NO IS NULL" ).append("\n"); 
		query.append("AND SO.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("AND CRO.BKG_NO = SO.BKG_NO" ).append("\n"); 
		query.append("AND CRO.CNTR_NO = SO.EQ_NO" ).append("\n"); 
		query.append("AND CRO.PIN_NO IS NOT NULL" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}