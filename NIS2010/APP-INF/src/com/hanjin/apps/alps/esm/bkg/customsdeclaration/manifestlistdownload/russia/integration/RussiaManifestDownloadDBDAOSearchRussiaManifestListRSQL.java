/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RussiaManifestDownloadDBDAOSearchRussiaManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RussiaManifestDownloadDBDAOSearchRussiaManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRussiaManifestList
	  * </pre>
	  */
	public RussiaManifestDownloadDBDAOSearchRussiaManifestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("br_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("br_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("br_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.integration").append("\n"); 
		query.append("FileName : RussiaManifestDownloadDBDAOSearchRussiaManifestListRSQL").append("\n"); 
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
		query.append("  ROWNUM SEQ_NO" ).append("\n"); 
		query.append(", '               '||DECODE(@[mode_type] ,'I', 'POL: '|| GROUP_POL_POD ||'    ETD:'|| GROUP_ETD_ETA" ).append("\n"); 
		query.append("                                             , 'POD: '|| GROUP_POL_POD ||'    ETA:'|| GROUP_ETD_ETA ) GROUP_TITLE" ).append("\n"); 
		query.append(", '        '||'Total Package: '|| TRIM(TO_CHAR(TOTAL_PKG,'9,999,990'))||'    Total Weight:'|| TRIM(TO_CHAR(TOTAL_KGS,'9,999,990.999'))||' KGS('|| TRIM(TO_CHAR(TOTAL_LBS,'9,999,990.999'))||' LBS)' AS GROUP_TOTAL" ).append("\n"); 
		query.append(", Z.*        " ).append("\n"); 
		query.append("FROM ( SELECT  SUM(PKG3) OVER( PARTITION BY GROUP_POL_POD, GROUP_ETD_ETA) TOTAL_PKG " ).append("\n"); 
		query.append("             , SUM(KGS) OVER( PARTITION BY GROUP_POL_POD, GROUP_ETD_ETA ) TOTAL_KGS " ).append("\n"); 
		query.append("             , SUM(LBS) OVER( PARTITION BY GROUP_POL_POD, GROUP_ETD_ETA ) TOTAL_LBS" ).append("\n"); 
		query.append("             , Y.*" ).append("\n"); 
		query.append("             , TO_CHAR(Y.WGT1 + Y.TARE_WGT, 'FM99999990.000') AS TOTAL_WGT" ).append("\n"); 
		query.append("        FROM ( SELECT  BKG_GET_TOKEN_FNC(X.HEADER,1) HD_VVD_CD" ).append("\n"); 
		query.append("                     , BKG_GET_TOKEN_FNC(X.HEADER,2) HD_POL_POD" ).append("\n"); 
		query.append("                     , BKG_GET_TOKEN_FNC(X.HEADER,3) HD_POL_POD_CD" ).append("\n"); 
		query.append("                     , BKG_GET_TOKEN_FNC(X.HEADER,4) HD_ETA_ETD" ).append("\n"); 
		query.append("                     , BKG_GET_TOKEN_FNC(X.HEADER,5) HD_ETA_ETD_CD" ).append("\n"); 
		query.append("                     , DECODE(@[mode_type] ,'I','Inbound','Outbound') HD_MODE_TYPE" ).append("\n"); 
		query.append("                     , X.*" ).append("\n"); 
		query.append("                     , TO_CHAR(DECODE(NVL(X.WGT2,' '),'LBS',ROUND(NVL(X.CGO_WGT,0)*0.4536,2),NVL(X.CGO_WGT,0)), 'FM99999990.000') AS WGT1" ).append("\n"); 
		query.append("                     , DECODE(NVL(X.WGT2,' '),'LBS', ROUND(NVL(X.CGO_WGT,0)*0.4536,3),NVL(X.CGO_WGT,0))   AS KGS" ).append("\n"); 
		query.append("                     , DECODE(NVL(X.WGT2,' '),'KGS', ROUND(NVL(X.CGO_WGT,0)*2.2046,3),NVL(X.CGO_WGT,0))   AS LBS" ).append("\n"); 
		query.append("                FROM ( SELECT B.BKG_NO,B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                            , B.BL_NO" ).append("\n"); 
		query.append("                            , B.POR_CD" ).append("\n"); 
		query.append("                            , B.POL_CD" ).append("\n"); 
		query.append("                            , SUBSTR(B.POL_NOD_CD,6) AS POL_YD_CD" ).append("\n"); 
		query.append("                            , B.POD_CD" ).append("\n"); 
		query.append("                            , SUBSTR(B.POD_NOD_CD,6) AS POD_YD_CD" ).append("\n"); 
		query.append("                            , B.DEL_CD" ).append("\n"); 
		query.append("                            , SUBSTR(B.DEL_NOD_CD,6) AS DEL_YD_CD" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                            , B.RCV_TERM_CD      AS  RD_CD1" ).append("\n"); 
		query.append("                            , B.DE_TERM_CD       AS  RD_CD2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            , CASE WHEN B.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("                                   THEN 'NLS SHIPPING 34,ROZENSHTEINA STR.,' ||CHR(10)||" ).append("\n"); 
		query.append("                                        'LITER A,POM.3H,198095,RUSSIA,' ||CHR(10)||" ).append("\n"); 
		query.append("                                        'ST. PETERSBURG RUSSIA'" ).append("\n"); 
		query.append("                                   ELSE NVL((SELECT CUST.CUST_NM FROM BKG_CSTMS_RU_CUST CUST WHERE 1=1 " ).append("\n"); 
		query.append("                                             AND CUST.BKG_CUST_TP_CD = 'S' AND CUST.BL_NO = B.BKG_NO)" ).append("\n"); 
		query.append("                                           ,(SELECT CUST.CUST_NM FROM BKG_CUSTOMER CUST WHERE 1=1 " ).append("\n"); 
		query.append("                                             AND CUST.BKG_CUST_TP_CD = 'S' AND CUST.BKG_NO = B.BKG_NO))" ).append("\n"); 
		query.append("                              END AS SH_NM" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                            , CASE WHEN B.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("                                   THEN 'SM LINE, EUROPE AM'||CHR(10)||" ).append("\n"); 
		query.append("                                        'SANDTORPARK,'||CHR(10)||" ).append("\n"); 
		query.append("                                        '6 D-20457 HAMBURG, GERMANY'" ).append("\n"); 
		query.append("                                   ELSE NVL((SELECT CUST.CUST_NM FROM BKG_CSTMS_RU_CUST CUST WHERE 1=1 " ).append("\n"); 
		query.append("                                             AND CUST.BKG_CUST_TP_CD = 'C' AND CUST.BL_NO = B.BKG_NO)" ).append("\n"); 
		query.append("                                           ,(SELECT CUST.CUST_NM FROM BKG_CUSTOMER CUST WHERE 1=1 " ).append("\n"); 
		query.append("                                             AND CUST.BKG_CUST_TP_CD = 'C' AND CUST.BKG_NO = B.BKG_NO))" ).append("\n"); 
		query.append("                              END AS CNEE_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("                            , D.CNTR_NO" ).append("\n"); 
		query.append("                            , E.CNTR_SEAL_NO" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                            , TRIM(TO_CHAR(NVL(D.PCK_QTY, 0),'9,999,990'))  AS PKG1" ).append("\n"); 
		query.append("                            , D.PCK_TP_CD                                   AS PKG2" ).append("\n"); 
		query.append("                            , NVL(D.PCK_QTY, 0)                             AS PKG3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            , NVL(NVL((SELECT RC.CGO_WGT FROM BKG_CSTMS_RU_CNTR RC WHERE 1=1 " ).append("\n"); 
		query.append("                                        AND RC.BKG_NO = B.BKG_NO AND RC.CNTR_NO = D.CNTR_NO)" ).append("\n"); 
		query.append("                                      , D.CNTR_WGT), 0) AS CGO_WGT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            , NVL((SELECT RC.WGT_UT_CD FROM BKG_CSTMS_RU_CNTR RC WHERE 1=1 " ).append("\n"); 
		query.append("                                  AND RC.BKG_NO = B.BKG_NO AND RC.CNTR_NO = D.CNTR_NO), D.WGT_UT_CD) AS WGT2" ).append("\n"); 
		query.append("                                  " ).append("\n"); 
		query.append("                                                        " ).append("\n"); 
		query.append("                            , TO_CHAR(NVL(NVL((SELECT RC.TARE_WGT FROM BKG_CSTMS_RU_CNTR RC WHERE 1=1 " ).append("\n"); 
		query.append("                                                  AND RC.BKG_NO = B.BKG_NO AND RC.CNTR_NO = D.CNTR_NO)" ).append("\n"); 
		query.append("                                             ,(SELECT DECODE(NVL(S.TARE_WGT, 0), 0" ).append("\n"); 
		query.append("                                                    , DECODE(NVL(MDM.CNTR_TPSZ_TARE_WGT, 0), 0" ).append("\n"); 
		query.append("                                                    , DECODE(M.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0) " ).append("\n"); 
		query.append("                                                    , MDM.CNTR_TPSZ_TARE_WGT)" ).append("\n"); 
		query.append("                                                    , S.TARE_WGT) " ).append("\n"); 
		query.append("                                                 FROM MST_CONTAINER M, MST_CNTR_SPEC S, MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("                                                WHERE M.CNTR_NO      = D.CNTR_NO" ).append("\n"); 
		query.append("                                                  AND M.CNTR_SPEC_NO = S.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("                                                  AND M.CNTR_TPSZ_CD = MDM.CNTR_TPSZ_CD)), 0), 'FM99999990.000') AS TARE_WGT" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                            , NVL(D.MEAS_QTY, 0) AS MEAS_QTY" ).append("\n"); 
		query.append("                            , D.MEAS_UT_CD" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                            , DECODE(NVL(D.MEAS_UT_CD,' '),'CBF', ROUND(NVL(D.MEAS_QTY,0)*0.0283,3),NVL(D.MEAS_QTY,0))  AS CBF" ).append("\n"); 
		query.append("                            , DECODE(NVL(D.MEAS_UT_CD,' '),'CBM', ROUND(NVL(D.MEAS_QTY,0)*35.315,3),NVL(D.MEAS_QTY,0))  AS CBM" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                            /* result Header */" ).append("\n"); 
		query.append("                            , DECODE(@[mode_type],'I', ( SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD||',POD,'||VPS_PORT_CD||',ETA,'||TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                                           FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                          WHERE VSL_CD = A.VSL_CD " ).append("\n"); 
		query.append("                                                            AND SKD_VOY_NO = A.SKD_VOY_NO " ).append("\n"); 
		query.append("                                                            AND SKD_DIR_CD  =  A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                            AND VPS_PORT_CD =  A.POD_CD " ).append("\n"); 
		query.append("                                                            AND YD_CD = A.POD_YD_CD" ).append("\n"); 
		query.append("                                                            AND NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("                                                            AND CLPT_IND_SEQ = A.POD_CLPT_IND_SEQ)" ).append("\n"); 
		query.append("                                                  , ( SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD||',POL,'||VPS_PORT_CD||',ETD,'||TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                                        FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                       WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                                         AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                         AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                         AND VPS_PORT_CD = A.POL_CD" ).append("\n"); 
		query.append("                                                         AND YD_CD = A.POL_YD_CD" ).append("\n"); 
		query.append("                                                         AND NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("                                                         AND CLPT_IND_SEQ = A.POL_CLPT_IND_SEQ)" ).append("\n"); 
		query.append("                                    ) AS HEADER " ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                            /* GROUP TITLE ETD,ETA*/" ).append("\n"); 
		query.append("                            , DECODE(@[mode_type], 'I', (SELECT TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                                           FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                          WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                                            AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                            AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                            AND VPS_PORT_CD = A.POL_CD" ).append("\n"); 
		query.append("                                                            AND CLPT_IND_SEQ = A.POL_CLPT_IND_SEQ)" ).append("\n"); 
		query.append("                                                 , (SELECT TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                                      FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                     WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                                       AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                       AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                       AND VPS_PORT_CD = A.POD_CD" ).append("\n"); 
		query.append("                                                       AND CLPT_IND_SEQ = A.POD_CLPT_IND_SEQ)" ).append("\n"); 
		query.append("                                    ) AS GROUP_ETD_ETA" ).append("\n"); 
		query.append("                                    " ).append("\n"); 
		query.append("                            /* Group Title POL & POD */" ).append("\n"); 
		query.append("                            , DECODE(@[mode_type],'I',A.POL_YD_CD,A.POD_YD_CD)  AS GROUP_POL_POD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 							, (NF.CUST_CNT_CD 	||	DECODE(nf.CUST_SEQ,0,'',LPAD(nf.CUST_SEQ,6,'0')) ) NF_CUST_CNT" ).append("\n"); 
		query.append("                            , NF.CUST_NM 										NF_CUST_NM" ).append("\n"); 
		query.append("                            , NF.CUST_ADDR 										NF_CUST_ADDR  " ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                            , D.PCK_QTY         CNTR_PCK" ).append("\n"); 
		query.append("                            , D.CNTR_WGT        CNTR_WGT" ).append("\n"); 
		query.append("                            , CD.CNTR_MF_SEQ    CNTR_MF_SEQ" ).append("\n"); 
		query.append("                            , CD.PCK_QTY         CARGO_PCK" ).append("\n"); 
		query.append("                            , CD.CNTR_MF_WGT         CARGO_WGT" ).append("\n"); 
		query.append("                            , CD.CNTR_MF_GDS_DESC    CARGO_DESC" ).append("\n"); 
		query.append("                            , B.CMDT_CD        BL_CMDT_CD" ).append("\n"); 
		query.append("                            , (SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD=B.CMDT_CD) BL_CMDT_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                         FROM BKG_VVD A, BKG_BOOKING B, BKG_CONTAINER D, BKG_CNTR_SEAL_NO E, BKG_CUSTOMER NF, BKG_CNTR_MF_DESC CD" ).append("\n"); 
		query.append("                         WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                          AND B.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("                          AND D.BKG_NO = CD.BKG_NO(+)" ).append("\n"); 
		query.append("                          AND B.BKG_NO = NF.BKG_NO(+)" ).append("\n"); 
		query.append("                          AND D.BKG_NO = E.BKG_NO(+)" ).append("\n"); 
		query.append("                          AND D.CNTR_NO = E.CNTR_NO(+)" ).append("\n"); 
		query.append("                          AND D.CNTR_NO = CD.CNTR_NO(+)" ).append("\n"); 
		query.append("                          AND B.BKG_STS_CD NOT IN ('X','S')" ).append("\n"); 
		query.append("                          AND NF.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                        /* vvd_cd */" ).append("\n"); 
		query.append("                        #if(${vvd_cd} != '' ) " ).append("\n"); 
		query.append("                          AND A.VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                          AND A.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                          AND A.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1) " ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                        /* pol_cd */" ).append("\n"); 
		query.append("		                #if(${pol_cd} != '' )                       " ).append("\n"); 
		query.append("                          AND A.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                        /* pol_yd_cd */" ).append("\n"); 
		query.append("		                #if(${pol_yd_cd} != '' )                       " ).append("\n"); 
		query.append("                          AND SUBSTR(A.POL_YD_CD,6) = @[pol_yd_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                   	    /* pod_cd */" ).append("\n"); 
		query.append("                        #if(${pod_cd} != '' ) " ).append("\n"); 
		query.append("                          AND A.POD_CD = @[pod_cd] " ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        /* pod_yd_cd */" ).append("\n"); 
		query.append("                        #if(${pod_yd_cd} != '' ) " ).append("\n"); 
		query.append("                          AND SUBSTR(A.POD_YD_CD,6) = @[pod_yd_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                        /* CARGO TYPE */" ).append("\n"); 
		query.append("                        #if(${cargo_type} != 'ALL' ) " ).append("\n"); 
		query.append("                          AND B.BKG_CGO_TP_CD = @[cargo_type] " ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        /* CARGO_ROUTE */" ).append("\n"); 
		query.append("                        #if(${cargo_route} != 'ALL' ) " ).append("\n"); 
		query.append("                          AND DECODE(B.POL_CD,A.POL_CD,'L','T') = @[cargo_route] " ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        /* br_por_cd */" ).append("\n"); 
		query.append("                        #if(${br_por_cd} != '' ) " ).append("\n"); 
		query.append("                          AND B.POR_CD LIKE @[br_por_cd] ||'%'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        /* br_pol_cd */" ).append("\n"); 
		query.append("                        #if(${br_pol_cd} != '' )" ).append("\n"); 
		query.append("                          AND B.POL_CD LIKE  @[br_pol_cd] ||'%'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        /* br_pod_cd */" ).append("\n"); 
		query.append("                        #if(${br_pod_cd} != '' )" ).append("\n"); 
		query.append("                          AND B.POD_CD LIKE  @[br_pod_cd] ||'%'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        /* br_del_cd */" ).append("\n"); 
		query.append("                        #if(${br_del_cd} != '' ) " ).append("\n"); 
		query.append("                          AND B.DEL_CD LIKE  @[br_del_cd] ||'%'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                     ) X" ).append("\n"); 
		query.append("               WHERE 1 = 1 " ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("             ) Y" ).append("\n"); 
		query.append("       WHERE 1 = 1" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       ORDER BY GROUP_POL_POD, GROUP_ETD_ETA , ${order_by}, BL_NO" ).append("\n"); 
		query.append("    ) Z" ).append("\n"); 

	}
}