/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchMultiDimension068ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2010.03.29 전윤주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Yun Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOSearchMultiDimension068ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ 회송기여도 RPT 조회
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchMultiDimension068ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOSearchMultiDimension068ListRSQL").append("\n"); 
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
		query.append("SELECT A1.PCTL_NO" ).append("\n"); 
		query.append("  ,A1.BKG_NO" ).append("\n"); 
		query.append("  ,A4.COST_ROUT_NO" ).append("\n"); 
		query.append("  ,A1.POR_CD POR" ).append("\n"); 
		query.append("  ,A1.POL_CD POL" ).append("\n"); 
		query.append("  ,A1.N1ST_TS_PORT_CD TS1" ).append("\n"); 
		query.append("  ,A1.N2ND_TS_PORT_CD TS2" ).append("\n"); 
		query.append("  ,A1.N3RD_TS_PORT_CD TS3" ).append("\n"); 
		query.append("  ,A1.POD_CD POD" ).append("\n"); 
		query.append("  ,A1.DEL_CD DEL" ).append("\n"); 
		query.append("  ,A1.OB_ITCHG_CTNT INTER1" ).append("\n"); 
		query.append("  ,A1.IB_ITCHG_CTNT INTER2" ).append("\n"); 
		query.append("  ,A1.DG_SPCL_FLG SPCL_DG" ).append("\n"); 
		query.append("  ,A1.RF_SPCL_FLG SPCL_RF" ).append("\n"); 
		query.append("  ,A1.SPCL_AWK_CGO_FLG SPCL_AK" ).append("\n"); 
		query.append("  ,A1.BB_SPCL_FLG SPCL_BB" ).append("\n"); 
		query.append("  ,A3.N1ST_RLANE_CD LANE1" ).append("\n"); 
		query.append("  ,A3.N2ND_RLANE_CD LANE2" ).append("\n"); 
		query.append("  ,A3.N3RD_RLANE_CD LANE3" ).append("\n"); 
		query.append("  ,A3.N4TH_RLANE_CD LANE4" ).append("\n"); 
		query.append("  ,A3.CLT_OFC_CD" ).append("\n"); 
		query.append("  ,A3.SLS_OFC_CD,A3.SHIPPER" ).append("\n"); 
		query.append("  ,A3.IOC_CD,A3.VVD" ).append("\n"); 
		query.append("  ,A3.DTERM" ).append("\n"); 
		query.append("  ,A3.RTERM" ).append("\n"); 
		query.append("  ,A3.RCMDT" ).append("\n"); 
		query.append("  ,A3.SHPR_NM" ).append("\n"); 
		query.append("  ,A3.RLANE_CD" ).append("\n"); 
		query.append("  , NVL(A1.TTL_TZTM_HRS, 0) / 24 HRS" ).append("\n"); 
		query.append("FROM (SELECT DISTINCT J.BKG_NO" ).append("\n"); 
		query.append("      	,J.PCTL_NO " ).append("\n"); 
		query.append("		,K.POR_CD" ).append("\n"); 
		query.append("      	,K.POL_CD " ).append("\n"); 
		query.append("		,K.N1ST_TS_PORT_CD" ).append("\n"); 
		query.append("      	,K.N2ND_TS_PORT_CD " ).append("\n"); 
		query.append("		,K.N3RD_TS_PORT_CD" ).append("\n"); 
		query.append("      	,K.POD_CD " ).append("\n"); 
		query.append("		,K.DEL_NOD_CD" ).append("\n"); 
		query.append("      	,K.OB_ITCHG_CTNT " ).append("\n"); 
		query.append("		,K.IB_ITCHG_CTNT" ).append("\n"); 
		query.append("      	,K.DEL_CD " ).append("\n"); 
		query.append("		,K.DG_SPCL_FLG" ).append("\n"); 
		query.append("      	,K.RF_SPCL_FLG " ).append("\n"); 
		query.append("		,K.SPCL_AWK_CGO_FLG" ).append("\n"); 
		query.append("      	,K.BB_SPCL_FLG " ).append("\n"); 
		query.append("		,K.TTL_TZTM_HRS" ).append("\n"); 
		query.append("    FROM SCE_COP_HDR J, PRD_PROD_CTL_MST K   " ).append("\n"); 
		query.append("    WHERE J.BKG_NO = @[f_bkg_no] " ).append("\n"); 
		query.append("        AND J.PCTL_NO = K.PCTL_NO ) A1," ).append("\n"); 
		query.append("    (SELECT BKG_NO" ).append("\n"); 
		query.append("      	,RLANE_CD" ).append("\n"); 
		query.append("		,N1ST_RLANE_CD" ).append("\n"); 
		query.append("      	,N2ND_RLANE_CD" ).append("\n"); 
		query.append("		,N3RD_RLANE_CD" ).append("\n"); 
		query.append("      	,N4TH_RLANE_CD,NVL(AGMT_SGN_OFC_CD, SLS_OFC_CD) CLT_OFC_CD" ).append("\n"); 
		query.append("      	,SLS_OFC_CD" ).append("\n"); 
		query.append("		,SHPR_CNT_CD || SHPR_CUST_SEQ SHIPPER" ).append("\n"); 
		query.append("      	,IOC_CD, VSL_CD || SKD_VOY_NO || DIR_CD VVD" ).append("\n"); 
		query.append("      	,BKG_DE_TERM_CD DTERM,BKG_RCV_TERM_CD RTERM" ).append("\n"); 
		query.append("      	,REP_CMDT_CD RCMDT" ).append("\n"); 
		query.append("      	,SHPR_NM" ).append("\n"); 
		query.append("    FROM COA_RGST_BKG   " ).append("\n"); 
		query.append("    WHERE BKG_NO = @[f_bkg_no] " ).append("\n"); 
		query.append("    /* Booking Info에 적용 (kevin.kim) */" ).append("\n"); 
		query.append("      AND BL_NO_TP IN ('M','0')      " ).append("\n"); 
		query.append("      AND BKG_STS_CD IN ('F','S') " ).append("\n"); 
		query.append("      AND BKG_CGO_TP_CD NOT IN ( 'P')) A3," ).append("\n"); 
		query.append("    (SELECT DISTINCT BKG_NO" ).append("\n"); 
		query.append("        ,COST_ROUT_NO" ).append("\n"); 
		query.append("    FROM COA_BKG_REV_DTL" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[f_bkg_no]) A4   " ).append("\n"); 
		query.append("WHERE A1.BKG_NO = A3.BKG_NO " ).append("\n"); 
		query.append("  AND A1.BKG_NO = A4.BKG_NO" ).append("\n"); 

	}
}