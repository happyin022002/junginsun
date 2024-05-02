/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAOModifyBkgCntrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOModifyBkgCntrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOModifyBkgCntrUSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOModifyBkgCntrUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOModifyBkgCntrUSQL").append("\n"); 
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
		query.append("UPDATE DMT_CHG_BKG_CNTR KKK" ).append("\n"); 
		query.append("    SET ( BL_NO,VSL_CD,SKD_VOY_NO,SKD_DIR_CD" ).append("\n"); 
		query.append("        , SC_NO,RFA_NO, CMDT_CD, REP_CMDT_CD, DMDT_CNTR_TP_CD, DMDT_BKG_CGO_TP_CD" ).append("\n"); 
		query.append("        , DCGO_FLG, RC_FLG, BB_CGO_FLG, AWK_CGO_FLG, RD_CGO_FLG, SOC_FLG" ).append("\n"); 
		query.append("        , POR_CD,POL_CD,POD_CD,DEL_CD,BKG_RCV_TERM_CD,BKG_DE_TERM_CD,BKG_CNTR_QTY,SLS_OFC_CD,RHQ_CD" ).append("\n"); 
		query.append("        , UPD_USR_ID,UPD_DT,UPD_OFC_CD )" ).append("\n"); 
		query.append("        = (" ).append("\n"); 
		query.append("        SELECT DISTINCT" ).append("\n"); 
		query.append("               BL_NO, SUBSTR(VVD_CD,1,4), SUBSTR(VVD_CD,5,4), SUBSTR(VVD_CD,9,1)" ).append("\n"); 
		query.append("             , SC_NO,RFA_NO, CMDT_CD, REP_CMDT_CD, CNTR_TPSZ, CGO_TP" ).append("\n"); 
		query.append("             , DCGO_FLG, RC_FLG, BB_CGO_FLG, AWK_CGO_FLG, RD_CGO_FLG, SOC_FLG" ).append("\n"); 
		query.append("             , POR_CD,POL_CD,POD_CD,DEL_CD,RCV_TERM_CD,DE_TERM_CD,BKG_CNTR_QTY,SLS_OFC_CD,RHQ_CD" ).append("\n"); 
		query.append("             , UPD_USR_ID,UPD_DT,UPD_OFC_CD" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT BB.BL_NO " ).append("\n"); 
		query.append("                        , DECODE(SUBSTR(T02.DMDT_TRF_CD,3,1),'I'," ).append("\n"); 
		query.append("                             ( SELECT /*+ ORDERED USE_NL( V K )" ).append("\n"); 
		query.append("                                                    INDEX    ( V XPKBKG_VVD )" ).append("\n"); 
		query.append("                                                    INDEX_DESC    ( K XPKVSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("                                       V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                  FROM BKG_VVD V" ).append("\n"); 
		query.append("                                      ,VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("                                 WHERE V.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                                   AND V.POD_CD = BB.POD_CD" ).append("\n"); 
		query.append("                                   AND (V.VSL_PRE_PST_CD, V.VSL_SEQ) =" ).append("\n"); 
		query.append("                                          (SELECT /*+ INDEX_DESC( VV XPKBKG_VVD) */" ).append("\n"); 
		query.append("                                                  VV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                                 ,VV.VSL_SEQ" ).append("\n"); 
		query.append("                                             FROM BKG_VVD VV" ).append("\n"); 
		query.append("                                            WHERE VV.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                                              AND VV.POD_CD = V.POD_CD" ).append("\n"); 
		query.append("                                              AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                   AND V.VSL_CD = K.VSL_CD(+)" ).append("\n"); 
		query.append("                                   AND V.SKD_VOY_NO = K.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                                   AND V.SKD_DIR_CD = K.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                                   AND V.POD_CD = K.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("                                   AND V.POD_CLPT_IND_SEQ = K.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("                                   AND NVL (K.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                           , ( SELECT /*+ ORDERED USE_NL( V K )" ).append("\n"); 
		query.append("                                       INDEX    ( V XPKBKG_VVD )" ).append("\n"); 
		query.append("                                       INDEX_DESC    ( K XPKVSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("                                   V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n"); 
		query.append("                              FROM BKG_VVD V" ).append("\n"); 
		query.append("                                  ,VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("                             WHERE V.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                               AND V.POL_CD = BB.POL_CD" ).append("\n"); 
		query.append("                               AND (V.VSL_PRE_PST_CD, V.VSL_SEQ) =" ).append("\n"); 
		query.append("                                      (SELECT /*+ INDEX( VV XPKBKG_VVD) */" ).append("\n"); 
		query.append("                                              VV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                             ,VV.VSL_SEQ" ).append("\n"); 
		query.append("                                         FROM BKG_VVD VV" ).append("\n"); 
		query.append("                                        WHERE VV.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                                          AND VV.POL_CD = V.POL_CD" ).append("\n"); 
		query.append("                                          AND ROWNUM = 1)" ).append("\n"); 
		query.append("                               AND V.VSL_CD = K.VSL_CD(+)" ).append("\n"); 
		query.append("                               AND V.SKD_VOY_NO = K.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                               AND V.SKD_DIR_CD = K.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                               AND V.POL_CD = K.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("                               AND V.POL_CLPT_IND_SEQ = K.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("                               AND NVL (K.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                               AND ROWNUM = 1 )) AS VVD_CD" ).append("\n"); 
		query.append("        , BB.SC_NO, BB.RFA_NO" ).append("\n"); 
		query.append("        , BB.CMDT_CD, BB.REP_CMDT_CD " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , BB.DCGO_FLG" ).append("\n"); 
		query.append("        , BB.RC_FLG" ).append("\n"); 
		query.append("        , BB.BB_CGO_FLG" ).append("\n"); 
		query.append("        , BB.AWK_CGO_FLG" ).append("\n"); 
		query.append("        , BB.RD_CGO_FLG" ).append("\n"); 
		query.append("        , BB.SOC_FLG" ).append("\n"); 
		query.append("        , BB.POR_CD" ).append("\n"); 
		query.append("        , BB.POL_CD" ).append("\n"); 
		query.append("        , BB.POD_CD" ).append("\n"); 
		query.append("        , BB.DEL_CD" ).append("\n"); 
		query.append("        , BB.RCV_TERM_CD" ).append("\n"); 
		query.append("        , BB.DE_TERM_CD" ).append("\n"); 
		query.append("        , ( SELECT COUNT(*) FROM BKG_CONTAINER WHERE BKG_NO = BB.BKG_NO ) BKG_CNTR_QTY" ).append("\n"); 
		query.append("        , T02.OFC_CD SLS_OFC_CD" ).append("\n"); 
		query.append("        , T02.OFC_RHQ_CD RHQ_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("        , NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]),SYSDATE) UPD_DT" ).append("\n"); 
		query.append("        , @[upd_ofc_cd] UPD_OFC_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , CASE" ).append("\n"); 
		query.append("            WHEN SUBSTR( T01.CNTR_TPSZ_CD, 1, 1)      = 'P' THEN 'F'" ).append("\n"); 
		query.append("            WHEN SUBSTR( T01.CNTR_TPSZ_CD, 1, 1)      = 'C' THEN 'O' " ).append("\n"); 
		query.append("            WHEN SUBSTR( T01.CNTR_TPSZ_CD, 1, 1)      = 'A' THEN 'F' " ).append("\n"); 
		query.append("            WHEN SUBSTR( T01.CNTR_TPSZ_CD, 1, 1)      = 'S' THEN 'O' " ).append("\n"); 
		query.append("            ELSE SUBSTR( T01.CNTR_TPSZ_CD, 1, 1)" ).append("\n"); 
		query.append("            END AS CNTR_TPSZ" ).append("\n"); 
		query.append("        , NVL(( SELECT CASE" ).append("\n"); 
		query.append("                    WHEN RC_FLG      = 'Y' THEN 'RFR' " ).append("\n"); 
		query.append("                    WHEN AWK_CGO_FLG = 'Y' THEN 'AWK' " ).append("\n"); 
		query.append("                    WHEN DCGO_FLG    = 'Y' THEN 'DGR' " ).append("\n"); 
		query.append("                    WHEN BB_CGO_FLG  = 'Y' THEN 'B/B' " ).append("\n"); 
		query.append("                    WHEN RD_CGO_FLG  = 'Y' THEN 'DRY' " ).append("\n"); 
		query.append("                    WHEN SOC_FLG     = 'Y' THEN 'SOC' " ).append("\n"); 
		query.append("                    ELSE                         'DRY'" ).append("\n"); 
		query.append("                    END  " ).append("\n"); 
		query.append("              FROM BKG_CONTAINER" ).append("\n"); 
		query.append("             WHERE BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("               AND CNTR_NO = T01.CNTR_NO ),'DRY')  AS CGO_TP" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        FROM BKG_BOOKING BB, DMT_CHG_BKG_CNTR T01, DMT_CHG_CALC T02" ).append("\n"); 
		query.append("        WHERE T02.SYS_AREA_GRP_ID = @[svr_id]" ).append("\n"); 
		query.append("        AND T02.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("        AND T02.CNTR_CYC_NO = @[cntr_cyc_no]" ).append("\n"); 
		query.append("        AND T02.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("        AND	T02.CHG_SEQ             = @[chg_seq]" ).append("\n"); 
		query.append("        AND T01.SYS_AREA_GRP_ID = T02.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        AND T01.CNTR_NO = T02.CNTR_NO" ).append("\n"); 
		query.append("        AND T01.CNTR_CYC_NO = T02.CNTR_CYC_NO" ).append("\n"); 
		query.append("        AND T01.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("        AND T01.SYS_AREA_GRP_ID = ( SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                    FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                   WHERE CNT_CD = SUBSTR(T02.FM_MVMT_YD_CD,1,2)" ).append("\n"); 
		query.append("                                     AND CO_IND_CD = 'H' )" ).append("\n"); 
		query.append("        AND ROWNUM = 1 ) " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    WHERE   SYS_AREA_GRP_ID	= @[svr_id]" ).append("\n"); 
		query.append("    AND     CNTR_NO     	= @[cntr_no]" ).append("\n"); 
		query.append("    AND     CNTR_CYC_NO 	= @[cntr_cyc_no]" ).append("\n"); 
		query.append("    AND     EXISTS ( SELECT 'Y'" ).append("\n"); 
		query.append("                       FROM DMT_CHG_CALC A" ).append("\n"); 
		query.append("                      WHERE A.SYS_AREA_GRP_ID 		= @[svr_id]" ).append("\n"); 
		query.append("                        AND A.CNTR_NO 				= @[cntr_no]" ).append("\n"); 
		query.append("                        AND A.CNTR_CYC_NO 			= @[cntr_cyc_no]" ).append("\n"); 
		query.append("                        AND A.DMDT_CHG_LOC_DIV_CD 	= @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("                        AND	A.CHG_SEQ             	= @[chg_seq]                " ).append("\n"); 
		query.append("                        AND A.SYS_AREA_GRP_ID = ( SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                                    FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                                   WHERE CNT_CD = SUBSTR(A.FM_MVMT_YD_CD,1,2)" ).append("\n"); 
		query.append("                                                     AND CO_IND_CD = 'H' ) )" ).append("\n"); 

	}
}