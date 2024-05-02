/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEai72SendingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.28 
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

public class WorkOrderPreviewDBDAOSearchEai72SendingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEai72SendingList
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEai72SendingListRSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOSearchEai72SendingListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT B.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("B.TRSP_SO_SEQ," ).append("\n"); 
		query.append("B.TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("B.TRSP_WO_SEQ," ).append("\n"); 
		query.append("B.FM_NOD_CD," ).append("\n"); 
		query.append("B.TO_NOD_CD," ).append("\n"); 
		query.append("B.VIA_NOD_CD," ).append("\n"); 
		query.append("B.DOR_NOD_CD," ).append("\n"); 
		query.append("TO_CHAR(B.TRSP_MTY_RQST_DT, 'yyyymmddhh24miss') TRSP_MTY_RQST_DT ," ).append("\n"); 
		query.append("TO_CHAR(B.N1ST_NOD_PLN_DT, 'yyyymmddhh24miss') N1ST_NOD_PLN_DT ," ).append("\n"); 
		query.append("TO_CHAR(B.DOR_NOD_PLN_DT, 'yyyymmddhh24miss') DOR_NOD_PLN_DT ," ).append("\n"); 
		query.append("TO_CHAR(B.LST_NOD_PLN_DT, 'yyyymmddhh24miss') LST_NOD_PLN_DT ," ).append("\n"); 
		query.append("B.EQ_TPSZ_CD," ).append("\n"); 
		query.append("B.EQ_NO," ).append("\n"); 
		query.append("B.TRSP_BND_CD," ).append("\n"); 
		query.append("B.BKG_NO," ).append("\n"); 
		query.append("B.TRO_SEQ TRSP_RQST_ORD_SEQ," ).append("\n"); 
		query.append("B.TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("B.TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("B.TRSP_MTY_COST_MOD_CD," ).append("\n"); 
		query.append("B.VNDR_SEQ," ).append("\n"); 
		query.append("B.INV_VNDR_SEQ," ).append("\n"); 
		query.append("B.INV_NO," ).append("\n"); 
		query.append("B.MTY_RRO_ISS_FLG," ).append("\n"); 
		query.append("TO_CHAR(B.MTY_RRO_ISS_DT, 'yyyymmddhh24miss') MTY_RRO_ISS_DT," ).append("\n"); 
		query.append("B.MTY_RRO_ISS_USR_ID," ).append("\n"); 
		query.append("B.MTY_RDE_ORD_ISS_FLG," ).append("\n"); 
		query.append("TO_CHAR(B.MTY_RDE_ORD_ISS_DT, 'yyyymmddhh24miss') MTY_RDE_ORD_ISS_DT," ).append("\n"); 
		query.append("B.MTY_RDE_ORD_ISS_USR_ID," ).append("\n"); 
		query.append("B.CRE_OFC_CD," ).append("\n"); 
		query.append("B.CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(B.LOCL_CRE_DT, 'yyyymmddhh24miss') CRE_DT," ).append("\n"); 
		query.append("B.UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(B.LOCL_UPD_DT, 'yyyymmddhh24miss') UPD_DT," ).append("\n"); 
		query.append("B.DELT_FLG" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_PRV_TMP A," ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD B," ).append("\n"); 
		query.append("MDM_ORGANIZATION C," ).append("\n"); 
		query.append("MDM_LOCATION LOC" ).append("\n"); 
		query.append("WHERE A.WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("AND A.WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("AND B.TRSP_SO_OFC_CTY_CD||B.TRSP_SO_SEQ IN (A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ)" ).append("\n"); 
		query.append("AND ( B.TRSP_COST_DTL_MOD_CD IN ('ER', 'CN', 'CF')" ).append("\n"); 
		query.append("OR (B.TRSP_COST_DTL_MOD_CD = 'DR' AND NVL(B.TRSP_SO_CMB_TP_CD, 'N') NOT IN ('FF', 'FM')" ).append("\n"); 
		query.append("AND B.TRSP_SO_TP_CD = 'Y' ))" ).append("\n"); 
		query.append("AND B.CRE_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND C.LOC_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("AND LOC.CONTI_CD = 'E'" ).append("\n"); 

	}
}