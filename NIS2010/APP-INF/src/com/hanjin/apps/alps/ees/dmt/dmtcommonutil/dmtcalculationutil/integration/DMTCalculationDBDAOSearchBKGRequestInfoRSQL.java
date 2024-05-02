/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchBKGRequestInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.22
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.02.22 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchBKGRequestInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBKGRequestInfo
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchBKGRequestInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchBKGRequestInfoRSQL").append("\n"); 
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
		query.append("SELECT BB.BL_NO                 BL_NO" ).append("\n"); 
		query.append("      ,BB.POR_CD                POR_CD" ).append("\n"); 
		query.append("      ,NVL (RL.CONTI_CD, ' ')   POR_CONTI_CD" ).append("\n"); 
		query.append("      ,NVL (RL.CNT_CD, ' ')     POR_CNT_CD" ).append("\n"); 
		query.append("      ,NVL (RL.RGN_CD, ' ')     POR_RGN_CD" ).append("\n"); 
		query.append("      ,NVL (RL.STE_CD, ' ')     POR_STE_CD" ).append("\n"); 
		query.append("      ,BB.POD_CD                POD_CD" ).append("\n"); 
		query.append("      ,BB.POL_CD                POL_CD" ).append("\n"); 
		query.append("      ,NVL (LL.CONTI_CD, ' ')   POL_CONTI_CD" ).append("\n"); 
		query.append("      ,NVL (LL.CNT_CD, ' ') 	POL_CNT_CD" ).append("\n"); 
		query.append("      ,NVL (LL.RGN_CD, ' ') 	POL_RGN_CD" ).append("\n"); 
		query.append("      ,NVL (LL.STE_CD, ' ') 	POL_STE_CD" ).append("\n"); 
		query.append("      ,BB.DEL_CD 				DEL_CD" ).append("\n"); 
		query.append("      ,NVL (EL.CONTI_CD, ' ') 	DEL_CONTI_CD" ).append("\n"); 
		query.append("      ,NVL (EL.CNT_CD, ' ') 	DEL_CNT_CD" ).append("\n"); 
		query.append("      ,NVL (EL.RGN_CD, ' ') 	DEL_RGN_CD" ).append("\n"); 
		query.append("      ,NVL (EL.STE_CD, ' ') 	DEL_STE_CD" ).append("\n"); 
		query.append("      ,SUBSTR (@[fm_yd_cd] ,1 ,5) YRD_CD" ).append("\n"); 
		query.append("      ,NVL (ML.CONTI_CD, ' ') 	YRD_CONTI_CD" ).append("\n"); 
		query.append("      ,NVL (ML.CNT_CD, ' ') 	YRD_CNT_CD" ).append("\n"); 
		query.append("      ,NVL (ML.RGN_CD, ' ') 	YRD_RGN_CD" ).append("\n"); 
		query.append("      ,NVL (ML.STE_CD, ' ') 	YRD_STE_CD" ).append("\n"); 
		query.append("      ,CC.DCGO_FLG 				DCGO_FLG" ).append("\n"); 
		query.append("      ,CC.RC_FLG 				RC_FLG" ).append("\n"); 
		query.append("      ,CC.AWK_CGO_FLG 			AWK_CGO_FLG" ).append("\n"); 
		query.append("      ,CC.RD_CGO_FLG 			RD_CGO_FLG" ).append("\n"); 
		query.append("      ,CC.BB_CGO_FLG 			BB_CGO_FLG" ).append("\n"); 
		query.append("      ,CC.SOC_FLG 				SOC_FLG" ).append("\n"); 
		query.append("      ,CC.CNTR_PRT_FLG 			CNTR_PRT_FLG" ).append("\n"); 
		query.append("      ,CC.ADV_SHTG_CD 			ADV_SHTG_CD" ).append("\n"); 
		query.append("      ,BB.OB_SLS_OFC_CD 		OB_SLS_OFC_CD" ).append("\n"); 
		query.append("      ,TRIM (BB.SC_NO) 			SC_NO" ).append("\n"); 
		query.append("      ,BB.RFA_NO 				RFA_NO" ).append("\n"); 
		query.append("      ,BB.CMDT_CD 				CMDT_CD" ).append("\n"); 
		query.append("      ,BB.REP_CMDT_CD 			REP_CMDT_CD" ).append("\n"); 
		query.append("      ,BB.PST_RLY_PORT_CD 		PST_RLY_PORT_CD" ).append("\n"); 
		query.append("      ,CC.DE_TERM_CD 			DE_TERM_CD" ).append("\n"); 
		query.append("      ,CC.RCV_TERM_CD           RCV_TERM_CD" ).append("\n"); 
		query.append("      ,BB.PRE_RLY_PORT_CD 		PRE_RLY_PORT_CD" ).append("\n"); 
		query.append("      ,CC.BKG_NO                BKG_NO" ).append("\n"); 
		query.append("      ,CC.CNTR_NO               CNTR_NO" ).append("\n"); 
		query.append("      ,CC.CNTR_TPSZ_CD          CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,CC.CNMV_CYC_NO           CNMV_CYC_NO " ).append("\n"); 
		query.append("      ,'I'                      IO_BND_CD" ).append("\n"); 
		query.append("      , DECODE(( SELECT    /*+ INDEX_DESC( DMT_CALC_TP XPKDMT_CALC_TP) */" ).append("\n"); 
		query.append("                DMDT_CALC_TP_CD" ).append("\n"); 
		query.append("        FROM    DMT_CALC_TP" ).append("\n"); 
		query.append("        WHERE    ( CNT_CD    =    NVL (ML.CNT_CD, ' ')        OR    CNT_CD        =    ' ' )" ).append("\n"); 
		query.append("        AND      ( RGN_CD    =    NVL (ML.RGN_CD, ' ')        OR    RGN_CD        =    ' ' )" ).append("\n"); 
		query.append("        AND      ( STE_CD    =    NVL (ML.STE_CD, ' ')      OR    STE_CD        =    ' ' )" ).append("\n"); 
		query.append("        AND      ( LOC_CD    =    SUBSTR (@[fm_yd_cd] ,1 ,5)       OR    LOC_CD        =    ' ' )" ).append("\n"); 
		query.append("        AND      IO_BND_CD   =    'I'" ).append("\n"); 
		query.append("        AND      CALC_TP_SEQ            =    (" ).append("\n"); 
		query.append("                                        SELECT   /*+ INDEX_DESC( D XPKDMT_CALC_TP) */" ).append("\n"); 
		query.append("                                                D.CALC_TP_SEQ" ).append("\n"); 
		query.append("                                        FROM    DMT_CALC_TP    D" ).append("\n"); 
		query.append("                                        WHERE   ( D.CNT_CD   =    NVL (ML.CNT_CD, ' ')        OR    D.CNT_CD    =    ' ' )" ).append("\n"); 
		query.append("                                        AND     ( D.RGN_CD   =    NVL (ML.RGN_CD, ' ')        OR    D.RGN_CD    =    ' ' )" ).append("\n"); 
		query.append("                                        AND     ( D.STE_CD   =    NVL (ML.STE_CD, ' ')      OR    D.STE_CD    =    ' ' )" ).append("\n"); 
		query.append("                                        AND     ( D.LOC_CD   =    SUBSTR (@[fm_yd_cd] ,1 ,5)       OR    D.LOC_CD    =    ' ' )" ).append("\n"); 
		query.append("                                        AND     D.IO_BND_CD  =     'I'" ).append("\n"); 
		query.append("                                        AND        ROWNUM    =    1" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("        AND        ROWNUM            =    1 " ).append("\n"); 
		query.append("        ),'D','DMIF','C','CTIC') AS DMDT_TRF_CD" ).append("\n"); 
		query.append("  FROM BKG_CONTAINER CC" ).append("\n"); 
		query.append("      ,BKG_BOOKING BB" ).append("\n"); 
		query.append("	  ,MDM_LOCATION RL" ).append("\n"); 
		query.append("      ,MDM_LOCATION LL" ).append("\n"); 
		query.append("      ,MDM_LOCATION EL" ).append("\n"); 
		query.append("      ,MDM_LOCATION ML" ).append("\n"); 
		query.append(" WHERE CC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND BB.BKG_NO = CC.BKG_NO" ).append("\n"); 
		query.append("   AND BB.POR_CD = RL.LOC_CD" ).append("\n"); 
		query.append("   AND BB.POL_CD = LL.LOC_CD" ).append("\n"); 
		query.append("   AND BB.DEL_CD = EL.LOC_CD" ).append("\n"); 
		query.append("   AND BB.BKG_STS_CD <> 'S'" ).append("\n"); 
		query.append("   AND BB.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("   AND BB.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("   AND ML.LOC_CD = SUBSTR (@[fm_yd_cd],1,5)" ).append("\n"); 

	}
}