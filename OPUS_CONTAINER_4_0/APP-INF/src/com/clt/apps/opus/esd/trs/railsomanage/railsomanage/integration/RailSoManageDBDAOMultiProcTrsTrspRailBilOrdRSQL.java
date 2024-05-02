/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RailSoManageDBDAOMultiProcTrsTrspRailBilOrdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOMultiProcTrsTrspRailBilOrdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 프로시저에 들어갈 파라미터를 대상 조회 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOMultiProcTrsTrspRailBilOrdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOMultiProcTrsTrspRailBilOrdRSQL").append("\n"); 
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
		query.append("SELECT A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("      ,B.SUB_RAIL_SEQ" ).append("\n"); 
		query.append("      ,B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("      ,A.CRE_OFC_CD" ).append("\n"); 
		query.append("      ,B.VNDR_SEQ" ).append("\n"); 
		query.append("      ,A.LOCL_CRE_DT" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.EQ_KND_CD" ).append("\n"); 
		query.append("      ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.CGO_TP_CD" ).append("\n"); 
		query.append("      ,A.TRSP_BND_CD" ).append("\n"); 
		query.append("      ,A.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("      ,A.CUST_CNT_CD" ).append("\n"); 
		query.append("      ,NVL(A.CUST_SEQ, 0) CUST_SEQ" ).append("\n"); 
		query.append("      ,B.RAIL_CRR_TP_CD" ).append("\n"); 
		query.append("      ,A.CMDT_CD" ).append("\n"); 
		query.append("      ,B.FM_NOD_CD" ).append("\n"); 
		query.append("      ,B.TO_NOD_CD" ).append("\n"); 
		query.append("      ,0 BUNDLE_CNT" ).append("\n"); 
		query.append("      ,A.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("      ,A.CNTR_WGT" ).append("\n"); 
		query.append("      ,A.SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("      ,A.RAIL_CMB_THRU_TP_CD" ).append("\n"); 
		query.append("      ,A.TO_NOD_CD AS AL_TO_NOD_CD" ).append("\n"); 
		query.append("      ,A.WGT_MEAS_UT_CD AS TARE_WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("      ,TO_NUMBER(NVL(TRIM(REGEXP_SUBSTR(TRS_GET_COM_SO_RAIL_WGT_FNC('R', A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ, null, A.BKG_NO, A.EQ_NO, A.EQ_TPSZ_CD, A.WGT_MEAS_UT_CD, A.COP_NO, 'N'), '[^|]+', 1, 2)), '0')) TARE_CNTR_WGT" ).append("\n"); 
		query.append("  FROM TRS_TRSP_RAIL_BIL_ORD A, TRS_TRSP_RAIL_BIL_VNDR_SET B, TRS_TRSP_EDI_RAIL_GLO_TMP C" ).append("\n"); 
		query.append(" WHERE A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND A.TRSP_SO_SEQ = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("   AND A.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND A.TRSP_SO_SEQ = C.TRSP_SO_SEQ" ).append("\n"); 

	}
}