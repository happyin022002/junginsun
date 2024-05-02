/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SalesRPTDBDAOSearchBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOSearchBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquiry by BKG (ABC/STP)
	  * </pre>
	  */
	public SalesRPTDBDAOSearchBkgInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOSearchBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("	 B2.CTRT_OFC_CD " ).append("\n"); 
		query.append("	,B2.SLS_OFC_CD " ).append("\n"); 
		query.append("	,B2.IOC_CD " ).append("\n"); 
		query.append("	,B2.RLANE_CD " ).append("\n"); 
		query.append("	,B2.VVD " ).append("\n"); 
		query.append("	,B2.SLS_YRMON " ).append("\n"); 
		query.append("	,B2.COST_WK " ).append("\n"); 
		query.append("	,B3.COST_ROUT_NO " ).append("\n"); 
		query.append("	,B1.POR_CD POR " ).append("\n"); 
		query.append("	,B1.OB_ITCHG_CTNT INTER1 " ).append("\n"); 
		query.append("	,B1.POL_CD POL " ).append("\n"); 
		query.append("	,B2.N1ST_RLANE_CD LANE1 " ).append("\n"); 
		query.append("	,B1.N1ST_TS_PORT_CD TS1 " ).append("\n"); 
		query.append("	,B2.N2ND_RLANE_CD LANE2 " ).append("\n"); 
		query.append("	,B1.N2ND_TS_PORT_CD TS2 " ).append("\n"); 
		query.append("	,B2.N3RD_RLANE_CD LANE3 " ).append("\n"); 
		query.append("	,B1.N3RD_TS_PORT_CD TS3 " ).append("\n"); 
		query.append("	,B2.N4TH_RLANE_CD LANE4 " ).append("\n"); 
		query.append("	,B1.POD_CD POD " ).append("\n"); 
		query.append("	,B1.IB_ITCHG_CTNT INTER2 " ).append("\n"); 
		query.append("	,B1.DEL_CD DEL " ).append("\n"); 
		query.append("	,NVL(B1.TTL_TZTM_HRS, 0) / 24 HRS " ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("		SELECT DISTINCT " ).append("\n"); 
		query.append("			 A1.BKG_NO " ).append("\n"); 
		query.append("			,A1.PCTL_NO " ).append("\n"); 
		query.append("			,A3.POR_CD " ).append("\n"); 
		query.append("			,A3.POL_CD " ).append("\n"); 
		query.append("			,A3.N1ST_TS_PORT_CD " ).append("\n"); 
		query.append("			,A3.N2ND_TS_PORT_CD " ).append("\n"); 
		query.append("			,A3.N3RD_TS_PORT_CD " ).append("\n"); 
		query.append("			,A3.POD_CD " ).append("\n"); 
		query.append("			,A3.DEL_NOD_CD " ).append("\n"); 
		query.append("			,A3.OB_ITCHG_CTNT " ).append("\n"); 
		query.append("			,A3.IB_ITCHG_CTNT " ).append("\n"); 
		query.append("			,A3.DEL_CD " ).append("\n"); 
		query.append("			,A3.TTL_TZTM_HRS " ).append("\n"); 
		query.append("		FROM SCE_COP_HDR A1 " ).append("\n"); 
		query.append("			,BKG_BOOKING A2 " ).append("\n"); 
		query.append("			,PRD_PROD_CTL_MST A3" ).append("\n"); 
		query.append("		WHERE 1=1 " ).append("\n"); 
		query.append("			AND A1.BKG_NO       = A2.BKG_NO " ).append("\n"); 
		query.append("			AND A1.PCTL_NO      = A3.PCTL_NO" ).append("\n"); 
		query.append("			AND A1.BKG_NO       = @[f_bkg_no] " ).append("\n"); 
		query.append("			AND A1.COP_STS_CD   <> DECODE(A2.BKG_STS_CD, 'S','Z','X') " ).append("\n"); 
		query.append("	) B1 " ).append("\n"); 
		query.append("	,( " ).append("\n"); 
		query.append("		SELECT A1.BKG_NO " ).append("\n"); 
		query.append("			,A1.RLANE_CD " ).append("\n"); 
		query.append("			,A1.IOC_CD " ).append("\n"); 
		query.append("			,A1.VSL_CD || A1.SKD_VOY_NO || A1.DIR_CD VVD " ).append("\n"); 
		query.append("			,A1.CTRT_OFC_CD " ).append("\n"); 
		query.append("			,A1.SLS_OFC_CD " ).append("\n"); 
		query.append("			,A1.N1ST_RLANE_CD " ).append("\n"); 
		query.append("			,A1.N2ND_RLANE_CD " ).append("\n"); 
		query.append("			,A1.N3RD_RLANE_CD " ).append("\n"); 
		query.append("			,A1.N4TH_RLANE_CD " ).append("\n"); 
		query.append("			,A2.SLS_YRMON " ).append("\n"); 
		query.append("			,A2.COST_WK " ).append("\n"); 
		query.append("		FROM COA_RGST_BKG A1 " ).append("\n"); 
		query.append("			,COA_MON_VVD A2 " ).append("\n"); 
		query.append("		WHERE A1.TRD_CD(+)     = A2.TRD_CD " ).append("\n"); 
		query.append("			AND A1.RLANE_CD(+)   = A2.RLANE_CD " ).append("\n"); 
		query.append("			AND A1.IOC_CD(+)     = A2.IOC_CD " ).append("\n"); 
		query.append("			AND A1.VSL_CD(+)     = A2.VSL_CD " ).append("\n"); 
		query.append("			AND A1.SKD_VOY_NO(+) = A2.SKD_VOY_NO " ).append("\n"); 
		query.append("			AND A1.DIR_CD(+)     = A2.DIR_CD " ).append("\n"); 
		query.append("			AND A1.BKG_NO        = @[f_bkg_no] " ).append("\n"); 
		query.append("			AND A1.BL_NO_TP      IN ('M','0') " ).append("\n"); 
		query.append("			AND A1.BKG_STS_CD    IN ('F','S','W') " ).append("\n"); 
		query.append("			AND A1.BKG_CGO_TP_CD <> 'P' " ).append("\n"); 
		query.append("	) B2 " ).append("\n"); 
		query.append("	,( " ).append("\n"); 
		query.append("		SELECT @[f_bkg_no] BKG_NO " ).append("\n"); 
		query.append("			,'All' COST_ROUT_NO " ).append("\n"); 
		query.append("		FROM DUAL" ).append("\n"); 
		query.append("	) B3 " ).append("\n"); 
		query.append("WHERE B1.BKG_NO   = B2.BKG_NO 	" ).append("\n"); 
		query.append("	AND B1.BKG_NO = B3.BKG_NO 	" ).append("\n"); 
		query.append("ORDER BY B3.COST_ROUT_NO" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}