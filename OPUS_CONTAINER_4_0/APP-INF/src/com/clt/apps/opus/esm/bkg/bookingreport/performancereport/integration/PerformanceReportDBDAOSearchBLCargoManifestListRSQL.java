/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchBLCargoManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.13
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.10.13 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchBLCargoManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchBLCargoManifestListRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchBLCargoManifestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cargo_route",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("br_por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cargo_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("br_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fdr_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fdr_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fdr_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchBLCargoManifestListRSQL").append("\n"); 
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
		query.append("/* For Select */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("ROWNUM SEQ_NO" ).append("\n"); 
		query.append(", '               '||DECODE(@[mode_type] ,'I', 'POL: '|| GROUP_POL_POD ||'    ETD:'|| GROUP_ETD_ETA" ).append("\n"); 
		query.append("                                             , 'POD: '|| GROUP_POL_POD ||'    ETA:'|| GROUP_ETD_ETA ) GROUP_TITLE" ).append("\n"); 
		query.append(", '        '||'Total Package: '|| TRIM(TO_CHAR(TOTAL_PKG,'9,999,990'))||'    Total Weight:'|| TRIM(TO_CHAR(TOTAL_KGS,'9,999,999,990.999'))||' KGS('|| TRIM(TO_CHAR(TOTAL_LBS,'9,999,999,990.999'))||' LBS)' AS GROUP_TOTAL" ).append("\n"); 
		query.append(", Z.*        " ).append("\n"); 
		query.append("FROM ( SELECT  SUM(PKG3) OVER( PARTITION BY GROUP_POL_POD, GROUP_ETD_ETA) TOTAL_PKG " ).append("\n"); 
		query.append("             , SUM(KGS) OVER( PARTITION BY GROUP_POL_POD, GROUP_ETD_ETA ) TOTAL_KGS " ).append("\n"); 
		query.append("             , SUM(LBS) OVER( PARTITION BY GROUP_POL_POD, GROUP_ETD_ETA ) TOTAL_LBS" ).append("\n"); 
		query.append("             , Y.*" ).append("\n"); 
		query.append("        FROM ( SELECT  BKG_GET_TOKEN_FNC(X.HEADER,1) HD_VVD_CD" ).append("\n"); 
		query.append("                     , BKG_GET_TOKEN_FNC(X.HEADER,2) HD_POL_POD" ).append("\n"); 
		query.append("                     , BKG_GET_TOKEN_FNC(X.HEADER,3) HD_POL_POD_CD" ).append("\n"); 
		query.append("                     , BKG_GET_TOKEN_FNC(X.HEADER,4) HD_ETA_ETD" ).append("\n"); 
		query.append("                     , BKG_GET_TOKEN_FNC(X.HEADER,5) HD_ETA_ETD_CD" ).append("\n"); 
		query.append("                     , DECODE(@[mode_type] ,'I','Inbound','Outbound') HD_MODE_TYPE" ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                     , BKG_GET_TOKEN_FNC(X.PRE_POST,2) PRE_POST_VVD" ).append("\n"); 
		query.append("                     , BKG_GET_TOKEN_FNC(X.PRE_POST,3) PRE_POST_POL_CD" ).append("\n"); 
		query.append("                     , BKG_GET_TOKEN_FNC(X.PRE_POST,4) PRE_POST_POL_YD_CD" ).append("\n"); 
		query.append("                     , BKG_GET_TOKEN_FNC(X.PRE_POST,5) PRE_POST_POD_CD" ).append("\n"); 
		query.append("                     , BKG_GET_TOKEN_FNC(X.PRE_POST,6) PRE_POST_POD_YD_CD" ).append("\n"); 
		query.append("                     , X.*" ).append("\n"); 
		query.append("                FROM ( SELECT  " ).append("\n"); 
		query.append("                           B.BKG_NO,b.bkg_cgo_tp_cd," ).append("\n"); 
		query.append("                           B.BL_NO," ).append("\n"); 
		query.append("                           B.POR_CD," ).append("\n"); 
		query.append("                           B.POL_CD," ).append("\n"); 
		query.append("                           SUBSTR(B.POL_NOD_CD,6) AS POL_YD_CD," ).append("\n"); 
		query.append("                           B.POD_CD," ).append("\n"); 
		query.append("                           SUBSTR(B.POD_NOD_CD,6) AS POD_YD_CD," ).append("\n"); 
		query.append("                           B.DEL_CD," ).append("\n"); 
		query.append("                           SUBSTR(B.DEL_NOD_CD,6) AS DEL_YD_CD," ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append("                           B.RCV_TERM_CD      AS  RD_CD1," ).append("\n"); 
		query.append("                           B.DE_TERM_CD       AS  RD_CD2," ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append("                           /* L/T cargo route  CHECK*/" ).append("\n"); 
		query.append("                           DECODE(B.POL_CD,A.POL_CD,'L','T')  AS LT," ).append("\n"); 
		query.append("                           B.BKG_CGO_TP_CD    AS EF," ).append("\n"); 
		query.append("						   TRIM(TO_CHAR(NVL(D.PCK_QTY, 0),'9,999,990')) AS PKG1," ).append("\n"); 
		query.append("                           D.PCK_TP_CD        AS PKG2, " ).append("\n"); 
		query.append("						   NVL(D.PCK_QTY, 0) AS PKG3," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						   TRIM(TO_CHAR(NVL(D.ACT_WGT, 0),'999,999,990.999')) AS WGT1," ).append("\n"); 
		query.append("                           D.WGT_UT_CD        AS WGT2," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                           B.TWN_SO_NO        AS SO_NO,                          " ).append("\n"); 
		query.append("                           B.REP_CMDT_CD      AS REP, " ).append("\n"); 
		query.append("                           DECODE(NVL(B.ADV_SHTG_CD,'N'),'1','Y','N') AS AS_CD," ).append("\n"); 
		query.append("                           B.DCGO_FLG     AS DG,                           " ).append("\n"); 
		query.append("                           B.RC_FLG       AS RF,   " ).append("\n"); 
		query.append("                           B.AWK_CGO_FLG  AS AW, " ).append("\n"); 
		query.append("                           B.BB_CGO_FLG   AS BB, " ).append("\n"); 
		query.append("                           D.BDR_FLG      AS BDR, " ).append("\n"); 
		query.append("                           D.BDR_CNG_FLG  AS CA, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                           NVL(D.MEAS_QTY, 0) AS MEAS_QTY," ).append("\n"); 
		query.append("                           D.MEAS_UT_CD, " ).append("\n"); 
		query.append("                                                                " ).append("\n"); 
		query.append("						   DECODE(NVL(D.WGT_UT_CD,' '),'LBS', ROUND(NVL(D.ACT_WGT,0)*0.4536,3),NVL(D.ACT_WGT,0))    AS KGS," ).append("\n"); 
		query.append("						   DECODE(NVL(D.WGT_UT_CD,' '),'KGS', ROUND(NVL(D.ACT_WGT,0)*2.2046,3),NVL(D.ACT_WGT,0))    AS LBS," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                           DECODE(NVL(D.MEAS_UT_CD,' '),'CBF', ROUND(NVL(D.MEAS_QTY,0)*0.0283,3),NVL(D.MEAS_QTY,0)) AS CBF," ).append("\n"); 
		query.append("                           DECODE(NVL(D.MEAS_UT_CD,' '),'CBM', ROUND(NVL(D.MEAS_QTY,0)*35.315,3),NVL(D.MEAS_QTY,0)) AS CBM," ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                           /* feeder vvd,pol,pod CHECK*/" ).append("\n"); 
		query.append("                           DECODE(@[mode_type], 'I', ( SELECT  MIN('I'||VSL_PRE_PST_CD||VSL_SEQ||','||VSL_CD||SKD_VOY_NO||SKD_DIR_CD||','||POL_CD||','||SUBSTR(POL_YD_CD,6)||','||POD_CD ||','||SUBSTR(POD_YD_CD,6))" ).append("\n"); 
		query.append("                                                        FROM    BKG_VVD" ).append("\n"); 
		query.append("                                                       WHERE   BKG_NO          = A.BKG_NO" ).append("\n"); 
		query.append("                                                         AND     POL_cd         = A.POD_CD" ).append("\n"); 
		query.append("                                                         AND     VSL_PRE_PST_CD||VSL_SEQ  > ( SELECT  VSL_PRE_PST_CD||VSL_SEQ" ).append("\n"); 
		query.append("                                                                                                FROM    BKG_VVD" ).append("\n"); 
		query.append("                                                                                                WHERE   BKG_NO          = A.BKG_NO" ).append("\n"); 
		query.append("                                                                                                AND     VSL_CD          = A.VSL_CD" ).append("\n"); 
		query.append("                                                                                                AND     SKD_VOY_NO      = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                                                AND     SKD_DIR_CD      = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                                AND     POD_cd         = A.POD_CD)" ).append("\n"); 
		query.append("                                                                GROUP BY VSL_CD||SKD_VOY_NO||SKD_DIR_CD,POL_CD,POD_CD)" ).append("\n"); 
		query.append("                                                   , ( SELECT 'O'||','||VSL_CD||SKD_VOY_NO||SKD_DIR_CD||','||POL_CD||','||SUBSTR(POL_YD_CD,6)||','||POD_CD ||','||SUBSTR(POD_YD_CD,6)" ).append("\n"); 
		query.append("                                                        FROM BKG_VVD" ).append("\n"); 
		query.append("                                                       WHERE BKG_NO        = A.BKG_NO " ).append("\n"); 
		query.append("                                                         AND POD_CD       = A.POL_CD)" ).append("\n"); 
		query.append("                                ) AS PRE_POST,                          " ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append("                           /* result Header */" ).append("\n"); 
		query.append("                           DECODE(@[mode_type],'I', ( SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD||',POD,'||VPS_PORT_CD||',ETA,'||TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                                        FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                       WHERE VSL_CD = A.VSL_CD " ).append("\n"); 
		query.append("                                                         AND SKD_VOY_NO = A.SKD_VOY_NO " ).append("\n"); 
		query.append("                                                         AND SKD_DIR_CD  =  A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                         AND VPS_PORT_CD =  A.POD_CD " ).append("\n"); 
		query.append("                                                         AND CLPT_IND_SEQ = (SELECT MIN(CLPT_IND_SEQ) " ).append("\n"); 
		query.append("                                                                               FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                                              WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                                                                AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                                AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                AND NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("                                                                                AND VPS_PORT_CD = A.POD_CD))" ).append("\n"); 
		query.append("                                                  , ( SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD||',POL,'||VPS_PORT_CD||',ETD,'||TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                                        FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                       WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                                         AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                         AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                         AND VPS_PORT_CD = A.POL_CD" ).append("\n"); 
		query.append("                                                         AND CLPT_IND_SEQ = (SELECT MAX(CLPT_IND_SEQ) " ).append("\n"); 
		query.append("                                                                               FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                                              WHERE  VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                                                                AND  SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                                AND  SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                AND  VPS_PORT_CD = A.POL_CD))" ).append("\n"); 
		query.append("                                  ) AS HEADER ," ).append("\n"); 
		query.append("                          /* GROUP TITLE ETD,ETA*/" ).append("\n"); 
		query.append("                         DECODE(@[mode_type], 'I', (SELECT TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                                     FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                    WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                                      AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                      AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                      AND VPS_PORT_CD = A.POL_CD" ).append("\n"); 
		query.append("                                                      AND CLPT_IND_SEQ = '1')" ).append("\n"); 
		query.append("                                               , (SELECT  TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                                    FROM  VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                   WHERE  VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                                     AND  SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                     AND  SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                     AND  VPS_PORT_CD = A.POD_CD" ).append("\n"); 
		query.append("                                                     AND  CLPT_IND_SEQ = '1')" ).append("\n"); 
		query.append("                                ) AS GROUP_ETD_ETA, " ).append("\n"); 
		query.append("                          /* Group Title POL & POD */" ).append("\n"); 
		query.append("                          DECODE(@[mode_type],'I',A.POL_CD,A.POD_CD)  AS GROUP_POL_POD" ).append("\n"); 
		query.append("                      FROM BKG_VVD A, BKG_BOOKING B,BKG_BL_DOC D" ).append("\n"); 
		query.append("                      WHERE  A.bkg_no = B.bkg_no" ).append("\n"); 
		query.append("                      AND    B.bkg_no = D.bkg_no" ).append("\n"); 
		query.append("                      AND    B.BKG_STS_CD NOT IN ('X','S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      /* vvd_cd */" ).append("\n"); 
		query.append("                      #if(${vvd_cd} != '' ) " ).append("\n"); 
		query.append("                      AND    A.VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                      AND    A.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                      AND    A.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1) " ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                      /* pol_cd */" ).append("\n"); 
		query.append("		              #if(${pol_cd} != '' )                       " ).append("\n"); 
		query.append("                      AND    A.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                      /* pol_yd_cd */" ).append("\n"); 
		query.append("		              #if(${pol_yd_cd} != '' )                       " ).append("\n"); 
		query.append("                      AND    SUBSTR(B.POL_NOD_CD,6) = @[pol_yd_cd]" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                 	  /* pod_cd */" ).append("\n"); 
		query.append("                      #if(${pod_cd} != '' ) " ).append("\n"); 
		query.append("                      AND A.POD_CD = @[pod_cd] " ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      /* pod_yd_cd */" ).append("\n"); 
		query.append("                      #if(${pod_yd_cd} != '' ) " ).append("\n"); 
		query.append("                      AND SUBSTR(B.POD_NOD_CD,6) = @[pod_yd_cd]" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                      /* CARGO TYPE */" ).append("\n"); 
		query.append("                     #if(${cargo_type} != 'ALL' ) " ).append("\n"); 
		query.append("                     AND    B.BKG_CGO_TP_CD = @[cargo_type] " ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      /* CARGO_ROUTE */" ).append("\n"); 
		query.append("                     #if(${cargo_route} != 'ALL' ) " ).append("\n"); 
		query.append("                     AND DECODE(B.POL_CD,A.POL_CD,'L','T') = @[cargo_route] " ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                     /* br_por_cd */" ).append("\n"); 
		query.append("                     #if(${br_por_cd} != '' ) " ).append("\n"); 
		query.append("                     AND B.POR_CD LIKE @[br_por_cd] ||'%'" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     /* br_pol_cd */" ).append("\n"); 
		query.append("                     #if(${br_pol_cd} != '' ) " ).append("\n"); 
		query.append("                     AND B.POL_CD LIKE  @[br_pol_cd] ||'%'" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                    /* br_pod_cd */" ).append("\n"); 
		query.append("                     #if(${br_pod_cd} != '' ) " ).append("\n"); 
		query.append("                     AND B.POD_CD LIKE  @[br_pod_cd] ||'%'" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     /* br_del_cd */" ).append("\n"); 
		query.append("                     #if(${br_del_cd} != '' ) " ).append("\n"); 
		query.append("                     AND B.DEL_CD LIKE  @[br_del_cd] ||'%'" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                ) X" ).append("\n"); 
		query.append("                 WHERE 1 = 1 " ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("          ) Y" ).append("\n"); 
		query.append("          WHERE 1 =1" ).append("\n"); 
		query.append("        /* fdr_vvd_cd */" ).append("\n"); 
		query.append("		#if(${fdr_vvd_cd} != '' ) " ).append("\n"); 
		query.append("		 AND PRE_POST_VVD = @[fdr_vvd_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		/* fdr_pol_cd */" ).append("\n"); 
		query.append("		#if(${fdr_pol_cd} != '' ) " ).append("\n"); 
		query.append("		 AND PRE_POST_POL_CD = @[fdr_pol_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		/* fdr_pol_yd_cd */" ).append("\n"); 
		query.append("		#if(${fdr_pol_yd_cd} != '' ) " ).append("\n"); 
		query.append("		 AND PRE_POST_POL_YD_CD = @[fdr_pol_yd_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		/* fdr_pod_cd */" ).append("\n"); 
		query.append("		#if(${fdr_pod_cd} != '' ) " ).append("\n"); 
		query.append("		 AND PRE_POST_POL_CD = @[fdr_pod_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		/* fdr_pod_yd_cd */" ).append("\n"); 
		query.append("		#if(${fdr_pod_yd_cd} != '' ) " ).append("\n"); 
		query.append("		 AND PRE_POST_POD_YD_CD = @[fdr_pod_yd_cd] " ).append("\n"); 
		query.append("		#end          " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ORDER BY GROUP_POL_POD, GROUP_ETD_ETA , ${order_by}" ).append("\n"); 
		query.append("  ) Z" ).append("\n"); 

	}
}