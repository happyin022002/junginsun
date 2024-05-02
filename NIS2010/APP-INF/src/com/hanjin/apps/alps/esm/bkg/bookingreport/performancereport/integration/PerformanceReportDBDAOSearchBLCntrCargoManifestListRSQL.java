/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchBLCntrCargoManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchBLCntrCargoManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchBLCntrCargoManifestListRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchBLCntrCargoManifestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mode_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cargo_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cargo_route",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("br_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("br_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("br_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("br_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchBLCntrCargoManifestListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       BL_NO," ).append("\n"); 
		query.append("       BKG_NO, " ).append("\n"); 
		query.append("       BL_TP," ).append("\n"); 
		query.append("       CNTR_NO," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       SEAL_NO," ).append("\n"); 
		query.append("       PCK_QTY, PCK_TP_CD," ).append("\n"); 
		query.append("       CNTR_WGT," ).append("\n"); 
		query.append("       MEAS_QTY," ).append("\n"); 
		query.append("	   CSTMS_DESC," ).append("\n"); 
		query.append("       POR_CD," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       DEL_CD,  " ).append("\n"); 
		query.append("       S_CD,        " ).append("\n"); 
		query.append("       S_NM, " ).append("\n"); 
		query.append("       S_AD," ).append("\n"); 
		query.append("       C_CD,  " ).append("\n"); 
		query.append("       C_NM, " ).append("\n"); 
		query.append("       C_AD," ).append("\n"); 
		query.append("       N_NM, " ).append("\n"); 
		query.append("       N_AD," ).append("\n"); 
		query.append("       PRE_POST_VVD ," ).append("\n"); 
		query.append("       PRE_POST_POL_CD ," ).append("\n"); 
		query.append("       PRE_POST_POL_YD_CD ," ).append("\n"); 
		query.append("       PRE_POST_POD_CD ," ).append("\n"); 
		query.append("       PRE_POST_POD_YD_CD ," ).append("\n"); 
		query.append("       PRE_POST" ).append("\n"); 
		query.append("		/* ofc_cd가 CMBBA인 경우와  BOMBA & BOMSC인 경우에  MK_DESC, CMDT_DESC 컬럼을 추가함 2017.04.20 */" ).append("\n"); 
		query.append("	   , CASE WHEN @[ofc_cd] in('CMBBA', 'BOMBA','BOMSC') " ).append("\n"); 
		query.append("			THEN (SELECT BD.MK_DESC FROM BKG_BL_MK_DESC BD WHERE BD.BKG_NO = Y.BKG_NO)" ).append("\n"); 
		query.append("			ELSE TO_CLOB('') " ).append("\n"); 
		query.append("       END MK_DESC" ).append("\n"); 
		query.append("	   , CASE WHEN @[ofc_cd] in('CMBBA', 'BOMBA','BOMSC') " ).append("\n"); 
		query.append("			THEN (SELECT BD.CMDT_DESC FROM BKG_BL_MK_DESC BD WHERE BD.BKG_NO = Y.BKG_NO)" ).append("\n"); 
		query.append("			ELSE TO_CLOB('')" ).append("\n"); 
		query.append("       END CMDT_DESC " ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       X.BL_NO," ).append("\n"); 
		query.append("       X.BKG_NO, " ).append("\n"); 
		query.append("       X.BL_TP," ).append("\n"); 
		query.append("       BC.CNTR_NO," ).append("\n"); 
		query.append("       BC.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       BKG_JOIN_FNC(CURSOR( SELECT CNTR_SEAL_NO " ).append("\n"); 
		query.append("                            FROM BKG_CNTR_SEAL_NO " ).append("\n"); 
		query.append("                            WHERE BKG_NO = BC.BKG_NO " ).append("\n"); 
		query.append("                            AND CNTR_NO = BC.CNTR_NO)) SEAL_NO," ).append("\n"); 
		query.append("       BC.PCK_QTY, BC.PCK_TP_CD," ).append("\n"); 
		query.append("       BC.CNTR_WGT," ).append("\n"); 
		query.append("       BC.MEAS_QTY," ).append("\n"); 
		query.append("       BD.CSTMS_DESC, " ).append("\n"); 
		query.append("       X.POR_CD," ).append("\n"); 
		query.append("       X.POL_CD," ).append("\n"); 
		query.append("       X.POD_CD," ).append("\n"); 
		query.append("       X.DEL_CD,  " ).append("\n"); 
		query.append("       S.CUST_CNT_CD||LPAD(S.CUST_SEQ, 6, '0') S_CD,        " ).append("\n"); 
		query.append("       S.CUST_NM S_NM, " ).append("\n"); 
		query.append("       S.CUST_ADDR S_AD," ).append("\n"); 
		query.append("       C.CUST_CNT_CD||LPAD(C.CUST_SEQ, 6, '0') C_CD,  " ).append("\n"); 
		query.append("       C.CUST_NM C_NM, " ).append("\n"); 
		query.append("       C.CUST_ADDR C_AD," ).append("\n"); 
		query.append("       N.CUST_NM N_NM, " ).append("\n"); 
		query.append("       N.CUST_ADDR N_AD," ).append("\n"); 
		query.append("       BKG_GET_TOKEN_FNC(X.PRE_POST, 2) PRE_POST_VVD ," ).append("\n"); 
		query.append("       BKG_GET_TOKEN_FNC(X.PRE_POST, 3) PRE_POST_POL_CD ," ).append("\n"); 
		query.append("       BKG_GET_TOKEN_FNC(X.PRE_POST, 4) PRE_POST_POL_YD_CD ," ).append("\n"); 
		query.append("       BKG_GET_TOKEN_FNC(X.PRE_POST, 5) PRE_POST_POD_CD ," ).append("\n"); 
		query.append("       BKG_GET_TOKEN_FNC(X.PRE_POST, 6) PRE_POST_POD_YD_CD ," ).append("\n"); 
		query.append("       X.PRE_POST" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("      B.BL_NO," ).append("\n"); 
		query.append("      B.BKG_NO," ).append("\n"); 
		query.append("      B.POR_CD," ).append("\n"); 
		query.append("      B.POL_CD," ).append("\n"); 
		query.append("      B.POD_CD," ).append("\n"); 
		query.append("      B.DEL_CD," ).append("\n"); 
		query.append("      DECODE(B.BL_TP_CD, 'W', 'Sea Waybill', 'Original Bill') BL_TP," ).append("\n"); 
		query.append("      DECODE(@[mode_type], 'I', (" ).append("\n"); 
		query.append("            SELECT MIN('I'||VSL_PRE_PST_CD||VSL_SEQ||','||VSL_CD||SKD_VOY_NO||SKD_DIR_CD||','||POL_CD||','||SUBSTR(POL_YD_CD, 6)||','||POD_CD ||','||SUBSTR(POD_YD_CD, 6))" ).append("\n"); 
		query.append("                           FROM BKG_VVD" ).append("\n"); 
		query.append("                WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                  AND POL_cd = A.POD_CD" ).append("\n"); 
		query.append("                  AND VSL_PRE_PST_CD||VSL_SEQ > (" ).append("\n"); 
		query.append("                                                    SELECT VSL_PRE_PST_CD||VSL_SEQ" ).append("\n"); 
		query.append("                                                    FROM BKG_VVD" ).append("\n"); 
		query.append("                                                    WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                                      AND VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                                      AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                      AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                      AND POD_cd = A.POD_CD" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                GROUP BY VSL_CD||SKD_VOY_NO||SKD_DIR_CD, POL_CD, POD_CD) , " ).append("\n"); 
		query.append("                                                (" ).append("\n"); 
		query.append("                                                    SELECT 'O'||','||VSL_CD||SKD_VOY_NO||SKD_DIR_CD||','||POL_CD||','||SUBSTR(POL_YD_CD, 6)||','||POD_CD ||','||SUBSTR(POD_YD_CD, 6)" ).append("\n"); 
		query.append("                                                    FROM BKG_VVD" ).append("\n"); 
		query.append("                                                    WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                                      AND POD_CD = A.POL_CD" ).append("\n"); 
		query.append("                                                      AND VSL_PRE_PST_CD||VSL_SEQ < (" ).append("\n"); 
		query.append("                                                                                        SELECT VSL_PRE_PST_CD||VSL_SEQ" ).append("\n"); 
		query.append("                                                                                        FROM BKG_VVD" ).append("\n"); 
		query.append("                                                                                        WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                                                                          AND VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                                                                          AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                                          AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                          AND POL_cd = A.POL_CD) " ).append("\n"); 
		query.append("                                                   )" ).append("\n"); 
		query.append("             ) AS PRE_POST" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("    FROM BKG_VVD A, BKG_BOOKING B" ).append("\n"); 
		query.append("    WHERE A.bkg_no = B.bkg_no" ).append("\n"); 
		query.append("      AND B.BKG_STS_CD NOT IN ('X','S') " ).append("\n"); 
		query.append("       /* vvd_cd */" ).append("\n"); 
		query.append("      #if(${vvd_cd} != '' ) " ).append("\n"); 
		query.append("      AND    A.VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("      AND    A.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("      AND    A.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1) " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      /* pol_cd */" ).append("\n"); 
		query.append("      #if(${pol_cd} != '' )                       " ).append("\n"); 
		query.append("      AND    A.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      /* pol_yd_cd */" ).append("\n"); 
		query.append("      #if(${pol_yd_cd} != '' )                       " ).append("\n"); 
		query.append("      AND    SUBSTR(A.POL_YD_CD,6) = @[pol_yd_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("   	  /* pod_cd */" ).append("\n"); 
		query.append("      #if(${pod_cd} != '' ) " ).append("\n"); 
		query.append("      AND A.POD_CD = @[pod_cd] " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      /* pod_yd_cd */" ).append("\n"); 
		query.append("      #if(${pod_yd_cd} != '' ) " ).append("\n"); 
		query.append("      AND SUBSTR(A.POD_YD_CD,6) = @[pod_yd_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      /* CARGO TYPE */" ).append("\n"); 
		query.append("      #if(${cargo_type} != 'ALL' ) " ).append("\n"); 
		query.append("      AND    B.BKG_CGO_TP_CD = @[cargo_type] " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      /* CARGO_ROUTE */" ).append("\n"); 
		query.append("      #if(${cargo_route} != 'ALL' ) " ).append("\n"); 
		query.append("      AND DECODE(B.POL_CD,A.POL_CD,'L','T') = @[cargo_route] " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      /* br_por_cd */" ).append("\n"); 
		query.append("      #if(${br_por_cd} != '' ) " ).append("\n"); 
		query.append("      AND B.POR_CD LIKE @[br_por_cd] ||'%'" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      /* br_pol_cd */" ).append("\n"); 
		query.append("      #if(${br_pol_cd} != '' ) " ).append("\n"); 
		query.append("      AND B.POL_CD LIKE  @[br_pol_cd] ||'%'" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      /* br_pod_cd */" ).append("\n"); 
		query.append("      #if(${br_pod_cd} != '' ) " ).append("\n"); 
		query.append("      AND B.POD_CD LIKE  @[br_pod_cd] ||'%'" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      /* br_del_cd */" ).append("\n"); 
		query.append("      #if(${br_del_cd} != '' ) " ).append("\n"); 
		query.append("      AND B.DEL_CD LIKE  @[br_del_cd] ||'%'" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      ) X, " ).append("\n"); 
		query.append("      BKG_BL_DOC BD," ).append("\n"); 
		query.append("      BKG_CONTAINER  BC," ).append("\n"); 
		query.append("      BKG_CUSTOMER   S," ).append("\n"); 
		query.append("      BKG_CUSTOMER   C," ).append("\n"); 
		query.append("      BKG_CUSTOMER   N" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND S.BKG_NO(+) = X.BKG_NO" ).append("\n"); 
		query.append("AND S.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("AND C.BKG_NO(+) = X.BKG_NO" ).append("\n"); 
		query.append("AND C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("AND N.BKG_NO(+) = X.BKG_NO" ).append("\n"); 
		query.append("AND N.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("AND X.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND X.BKG_NO = BD.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* fdr_vvd_cd */" ).append("\n"); 
		query.append("#if(${fdr_vvd_cd} != '' ) " ).append("\n"); 
		query.append("AND BKG_GET_TOKEN_FNC(X.PRE_POST, 2) = @[fdr_vvd_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* fdr_pol_cd */" ).append("\n"); 
		query.append("#if(${fdr_pol_cd} != '' ) " ).append("\n"); 
		query.append("AND  BKG_GET_TOKEN_FNC(X.PRE_POST, 3)  = @[fdr_pol_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* fdr_pol_yd_cd */" ).append("\n"); 
		query.append("#if(${fdr_pol_yd_cd} != '' ) " ).append("\n"); 
		query.append("AND BKG_GET_TOKEN_FNC(X.PRE_POST, 4) = @[fdr_pol_yd_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* fdr_pod_cd */" ).append("\n"); 
		query.append("#if(${fdr_pod_cd} != '' ) " ).append("\n"); 
		query.append("AND BKG_GET_TOKEN_FNC(X.PRE_POST, 5) = @[fdr_pod_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* fdr_pod_yd_cd */" ).append("\n"); 
		query.append("#if(${fdr_pod_yd_cd} != '' ) " ).append("\n"); 
		query.append("AND BKG_GET_TOKEN_FNC(X.PRE_POST, 6) = @[fdr_pod_yd_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")Y" ).append("\n"); 

	}
}