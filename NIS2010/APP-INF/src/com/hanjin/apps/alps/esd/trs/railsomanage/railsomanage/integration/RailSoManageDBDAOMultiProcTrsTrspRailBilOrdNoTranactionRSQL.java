/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RailSoManageDBDAOMultiProcTrsTrspRailBilOrdNoTranactionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.20
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.12.20 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOMultiProcTrsTrspRailBilOrdNoTranactionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 프로시저에 들어갈 파라미터를 대상 S/O만 조회 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOMultiProcTrsTrspRailBilOrdNoTranactionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOMultiProcTrsTrspRailBilOrdNoTranactionRSQL").append("\n"); 
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
		query.append("A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ, B.SUB_RAIL_SEQ, B.TRSP_AGMT_OFC_CTY_CD, B.TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("A.CRE_OFC_CD, B.VNDR_SEQ, A.LOCL_CRE_DT," ).append("\n"); 
		query.append("A.CRE_USR_ID, A.UPD_USR_ID," ).append("\n"); 
		query.append("A.EQ_KND_CD, A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("A.CGO_TP_CD, A.TRSP_BND_CD," ).append("\n"); 
		query.append("A.TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("A.CUST_CNT_CD, NVL(A.CUST_SEQ, 0) CUST_SEQ," ).append("\n"); 
		query.append("B.RAIL_CRR_TP_CD, A.CMDT_CD," ).append("\n"); 
		query.append("B.FM_NOD_CD, B.TO_NOD_CD, 0 BUNDLE_CNT," ).append("\n"); 
		query.append("A.WGT_MEAS_UT_CD, A.CNTR_WGT," ).append("\n"); 
		query.append("A.SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("A.RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("A.TO_NOD_CD AS AL_TO_NOD_CD" ).append("\n"); 
		query.append("FROM TRS_TRSP_RAIL_BIL_ORD A, TRS_TRSP_RAIL_BIL_VNDR_SET B, TRS_TRSP_EDI_RAIL_GLO_TMP C" ).append("\n"); 
		query.append("WHERE A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.TRSP_SO_SEQ = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND A.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.TRSP_SO_SEQ = C.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND C.TRSP_SO_OFC_CTY_CD = @[in_trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND C.TRSP_SO_SEQ = @[in_trsp_so_seq]" ).append("\n"); 

	}
}