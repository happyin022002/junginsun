/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchBDRBookingPfmcStatusList1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchBDRBookingPfmcStatusList1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchBDRBookingPfmcStatusList1RSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchBDRBookingPfmcStatusList1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchBDRBookingPfmcStatusList1RSQL").append("\n"); 
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
		query.append("SELECT  /*+ ORDERED *//* BDR인 경우*/" ).append("\n"); 
		query.append("       B.BKG_OFC_CD ," ).append("\n"); 
		query.append("       B.BKG_NO," ).append("\n"); 
		query.append("       B.BKG_STS_CD," ).append("\n"); 
		query.append("       B.VSL_CD, /*VVD1*/" ).append("\n"); 
		query.append("       B.SKD_VOY_NO,/*VVD2*/" ).append("\n"); 
		query.append("       B.SKD_DIR_CD,/*VVD3*/" ).append("\n"); 
		query.append("       B.POR_CD," ).append("\n"); 
		query.append("       B.POL_CD," ).append("\n"); 
		query.append("       B.POD_CD," ).append("\n"); 
		query.append("       B.DEL_CD," ).append("\n"); 
		query.append("       B.PRE_RLY_PORT_CD," ).append("\n"); 
		query.append("       B.PST_RLY_PORT_CD," ).append("\n"); 
		query.append("       B.BL_NO," ).append("\n"); 
		query.append("       TO_CHAR(X.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') ETD_DT," ).append("\n"); 
		query.append("       TO_CHAR(X.BDR_DT,'YYYY-MM-DD HH24:MI')     BDR_DT," ).append("\n"); 
		query.append("       TO_CHAR(X.EBDR_DT,'YYYY-MM-DD HH24:MI')    EBDR_DT," ).append("\n"); 
		query.append("       B.SLAN_CD" ).append("\n"); 
		query.append("FROM   ( SELECT  DISTINCT A.*" ).append("\n"); 
		query.append("		 FROM   (SELECT /*+ USE_NL(A C) */" ).append("\n"); 
		query.append("         	             A.VSL_CD," ).append("\n"); 
		query.append("            	         A.SKD_VOY_NO," ).append("\n"); 
		query.append("                	     A.SKD_DIR_CD," ).append("\n"); 
		query.append("                    	 A.POL_CD," ).append("\n"); 
		query.append("                      	 A.POD_CD," ).append("\n"); 
		query.append("	                     C.VPS_ETD_DT," ).append("\n"); 
		query.append("    	                 A.SLAN_CD," ).append("\n"); 
		query.append("        	             NVL( A.TRNK_MNL_BDR_DT, A.TRNK_AUTO_BDR_DT ) BDR_DT," ).append("\n"); 
		query.append("            	         A.TRNK_ESTM_BDR_DT EBDR_DT" ).append("\n"); 
		query.append("                 FROM BKG_VVD_BDR_LOG A," ).append("\n"); 
		query.append("                      VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("          WHERE 'BDR' = @[period_type]" ).append("\n"); 
		query.append("		  AND A.TRNK_MNL_BDR_DT IS NOT NULL" ).append("\n"); 
		query.append("          AND C.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("          AND C.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND C.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND C.VPS_PORT_CD = A.POL_CD" ).append("\n"); 
		query.append("          AND DECODE( A.TRNK_MNL_BDR_FLG, 'N', A.TRNK_BDR_FLG, A.TRNK_MNL_BDR_FLG ) = 'Y'" ).append("\n"); 
		query.append("          AND   A.TRNK_MNL_BDR_DT >= TO_DATE(@[from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("          AND   A.TRNK_MNL_BDR_DT <= TO_DATE(@[to_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("          AND   C.CALL_YD_IND_SEQ IN  ('1','2')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("          SELECT /*+ USE_NL(A C) */" ).append("\n"); 
		query.append("                 A.VSL_CD," ).append("\n"); 
		query.append("                 A.SKD_VOY_NO," ).append("\n"); 
		query.append("                 A.SKD_DIR_CD," ).append("\n"); 
		query.append("                 A.POL_CD," ).append("\n"); 
		query.append("                 A.POD_CD," ).append("\n"); 
		query.append("                 C.VPS_ETD_DT," ).append("\n"); 
		query.append("                 A.SLAN_CD," ).append("\n"); 
		query.append("                 NVL( A.TRNK_MNL_BDR_DT, A.TRNK_AUTO_BDR_DT ) BDR_DT," ).append("\n"); 
		query.append("                 A.TRNK_ESTM_BDR_DT EBDR_DT" ).append("\n"); 
		query.append("                 FROM BKG_VVD_BDR_LOG A," ).append("\n"); 
		query.append("                      VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("				 WHERE 'BDR' = @[period_type]" ).append("\n"); 
		query.append("				  AND A.TRNK_MNL_BDR_DT IS NULL" ).append("\n"); 
		query.append("                  AND C.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                  AND C.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND C.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND C.VPS_PORT_CD = A.POL_CD" ).append("\n"); 
		query.append("                  AND DECODE( A.TRNK_MNL_BDR_FLG, 'N', A.TRNK_BDR_FLG, A.TRNK_MNL_BDR_FLG ) = 'Y'" ).append("\n"); 
		query.append("                  AND A.TRNK_AUTO_BDR_DT >= TO_DATE(@[from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("                  AND A.TRNK_AUTO_BDR_DT <= TO_DATE(@[to_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("                  AND C.CALL_YD_IND_SEQ IN ( '1', '2' )" ).append("\n"); 
		query.append("		     ) A         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     ) X, " ).append("\n"); 
		query.append("     BKG_BOOKING B, BKG_BL_DOC D" ).append("\n"); 
		query.append("WHERE 'BDR' = @[period_type]" ).append("\n"); 
		query.append("  AND B.VSL_CD = X.VSL_CD" ).append("\n"); 
		query.append("  AND B.SKD_VOY_NO = X.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND B.SKD_DIR_CD = X.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND B.SLAN_CD = X.SLAN_CD" ).append("\n"); 
		query.append("  AND B.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("  AND D.BDR_DT IS NOT NULL" ).append("\n"); 
		query.append("  AND D.BDR_FLG = 'N'" ).append("\n"); 
		query.append("  AND B.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("  AND NVL( B.PRE_RLY_PORT_CD, B.POL_CD ) = X.POL_CD" ).append("\n"); 
		query.append("  AND NVL( B.PST_RLY_PORT_CD, B.POD_CD ) = X.POD_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   B.BKG_OFC_CD LIKE @[ofc_cd]||'%'" ).append("\n"); 
		query.append("AND   B.BKG_STS_CD = DECODE (@[status_cd], 'W', 'W', 'F', 'F', B.BKG_STS_CD)" ).append("\n"); 
		query.append("AND   B.BKG_STS_CD NOT IN('X','A','S')" ).append("\n"); 
		query.append("AND   B.BL_NO > ' ' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  /*+ ORDERED */" ).append("\n"); 
		query.append("		/* SAIL인경우 */" ).append("\n"); 
		query.append("	X.BKG_OFC_CD ," ).append("\n"); 
		query.append("	X.BKG_NO," ).append("\n"); 
		query.append("	X.BKG_STS_CD," ).append("\n"); 
		query.append("	X.VSL_CD, /*VVD1*/" ).append("\n"); 
		query.append("	X.SKD_VOY_NO,/*VVD2*/" ).append("\n"); 
		query.append("	X.SKD_DIR_CD,/*VVD3*/" ).append("\n"); 
		query.append("	X.POR_CD," ).append("\n"); 
		query.append("	X.POL_CD," ).append("\n"); 
		query.append("	X.POD_CD," ).append("\n"); 
		query.append("	X.DEL_CD," ).append("\n"); 
		query.append("	X.PRE_RLY_PORT_CD," ).append("\n"); 
		query.append("	X.PST_RLY_PORT_CD," ).append("\n"); 
		query.append("	X.BL_NO," ).append("\n"); 
		query.append("	TO_CHAR(X.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') ETD_DT," ).append("\n"); 
		query.append("	TO_CHAR(NVL(A.TRNK_MNL_BDR_DT,A.TRNK_AUTO_BDR_DT),'YYYY-MM-DD HH24:MI')     BDR_DT," ).append("\n"); 
		query.append("	TO_CHAR(A.TRNK_ESTM_BDR_DT,'YYYY-MM-DD HH24:MI')    EBDR_DT," ).append("\n"); 
		query.append("	X.SLAN_CD" ).append("\n"); 
		query.append("FROM   " ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       SELECT DISTINCT" ).append("\n"); 
		query.append("			B.BKG_OFC_CD ," ).append("\n"); 
		query.append("			B.BKG_NO," ).append("\n"); 
		query.append("			B.BKG_STS_CD," ).append("\n"); 
		query.append("			B.VSL_CD, " ).append("\n"); 
		query.append("			B.SKD_VOY_NO," ).append("\n"); 
		query.append("			B.SKD_DIR_CD," ).append("\n"); 
		query.append("			B.POR_CD," ).append("\n"); 
		query.append("			B.POL_CD," ).append("\n"); 
		query.append("			B.POD_CD," ).append("\n"); 
		query.append("			B.DEL_CD," ).append("\n"); 
		query.append("			B.PRE_RLY_PORT_CD," ).append("\n"); 
		query.append("			B.PST_RLY_PORT_CD," ).append("\n"); 
		query.append("			B.BL_NO," ).append("\n"); 
		query.append("			B.SLAN_CD," ).append("\n"); 
		query.append("			C.VPS_ETD_DT" ).append("\n"); 
		query.append("		FROM VSK_VSL_PORT_SKD C, BKG_BOOKING B" ).append("\n"); 
		query.append("          WHERE 'SAIL' = @[period_type]" ).append("\n"); 
		query.append("			AND   C.VPS_ETD_DT >= TO_DATE(@[from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("            AND   C.VPS_ETD_DT <= TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999			" ).append("\n"); 
		query.append("			AND   C.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("			AND C.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND C.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND ( C.VPS_PORT_CD = NVL( B.PRE_RLY_PORT_CD, B.POL_CD )" ).append("\n"); 
		query.append("           OR C.VPS_PORT_CD = NVL( B.PST_RLY_PORT_CD, B.POD_CD ) )" ).append("\n"); 
		query.append("          AND B.BKG_OFC_CD LIKE @[ofc_cd]||'%'" ).append("\n"); 
		query.append("          AND B.BKG_STS_CD = DECODE( @[status_cd], 'W', 'W', 'F', 'F', B.BKG_STS_CD )" ).append("\n"); 
		query.append("          AND B.BKG_STS_CD NOT IN ( 'X', 'A', 'S' )" ).append("\n"); 
		query.append("          AND B.BL_NO > ' '" ).append("\n"); 
		query.append("          AND B.BKG_CGO_TP_CD <> 'P' " ).append("\n"); 
		query.append("     ) X, " ).append("\n"); 
		query.append("      BKG_VVD_BDR_LOG A" ).append("\n"); 
		query.append("WHERE 'SAIL' = @[period_type]" ).append("\n"); 
		query.append(" AND X.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("  AND X.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND X.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND X.POL_CD = A.POL_CD" ).append("\n"); 
		query.append("  AND X.POD_CD = A.POD_CD" ).append("\n"); 
		query.append("  AND EXISTS ( SELECT /*+ INDEX(BKG_BL_DOC XPKBKG_BL_DOC) */" ).append("\n"); 
		query.append("                      'Y'" ).append("\n"); 
		query.append("               FROM BKG_BL_DOC " ).append("\n"); 
		query.append("               WHERE 1 = 1" ).append("\n"); 
		query.append("                 AND BDR_FLG = 'N'" ).append("\n"); 
		query.append("                 AND X.BKG_NO = BKG_NO " ).append("\n"); 
		query.append("                 AND ROWNUM = 1)" ).append("\n"); 

	}
}