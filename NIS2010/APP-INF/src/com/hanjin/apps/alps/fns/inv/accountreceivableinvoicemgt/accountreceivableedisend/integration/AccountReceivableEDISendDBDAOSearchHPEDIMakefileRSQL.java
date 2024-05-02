/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchHPEDIMakefileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchHPEDIMakefileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchHPEDIMakefileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchHPEDIMakefileRSQL").append("\n"); 
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
		query.append("SELECT RPAD('SMLM', 20, ' ')||RPAD('HP', 20, ' ')||RPAD('FREINV', 10, ' ')||'INV' AS HEADER" ).append("\n"); 
		query.append("       , 'N' AS INV_TYPE --??" ).append("\n"); 
		query.append("       , NVL(A.INV_NO, A.BL_SRC_NO) AS INV_NUM" ).append("\n"); 
		query.append("       , A.BL_SRC_NO AS BL_NUM" ).append("\n"); 
		query.append("       ,(SELECT DECODE(RATE.FRT_TERM_CD ,'P','PP','C','CC')" ).append("\n"); 
		query.append("         FROM BKG_RATE RATE " ).append("\n"); 
		query.append("         WHERE  RATE.BKG_NO = A.BKG_NO )AS INV_PAY" ).append("\n"); 
		query.append("        ,A.ISS_DT AS INV_DATE  --??" ).append("\n"); 
		query.append("		,ROUND(NVL(SUM(C.CHG_AMT*C.INV_XCH_RT),0),2) AS INV_AMT" ).append("\n"); 
		query.append("        ,NVL((SELECT NVL(MIN(TO_CHAR(MOV.CNMV_EVNT_DT,'YYYYMMDD')),'')  " ).append("\n"); 
		query.append("            FROM CTM_MOVEMENT MOV" ).append("\n"); 
		query.append("            WHERE MOV.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("         --   AND   MOV.CNTR_NO(+) = :CNTR_NO" ).append("\n"); 
		query.append("         --   AND   MOV.CNMV_CYC_NO(+) =:CNTR_MAX_CNMV_SEQ" ).append("\n"); 
		query.append("            AND   MOV.MVMT_STS_CD (+) = 'ID' )," ).append("\n"); 
		query.append("			(SELECT TO_CHAR(VPS_ETA_DT,'YYYYMMDD') " ).append("\n"); 
		query.append("			   FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("              WHERE VSL_CD = A.TRNK_VSL_CD" ).append("\n"); 
		query.append("  				AND SKD_VOY_NO = A.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("				AND SKD_DIR_CD = A.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("				AND VPS_PORT_CD = A.POD_CD" ).append("\n"); 
		query.append("				AND CLPT_IND_SEQ = 1)) AS FINAL_ETA   ----??내용수정필요함." ).append("\n"); 
		query.append("        , (SELECT SUBSTR(CUST_REF_NO_CTNT,1,50) " ).append("\n"); 
		query.append("  		     FROM BKG_REFERENCE " ).append("\n"); 
		query.append(" 			WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("   			  AND BKG_REF_TP_CD = 'INCO'" ).append("\n"); 
		query.append("			) AS INCO_TERM" ).append("\n"); 
		query.append("        ,'SMLM' AS SCAC_CD" ).append("\n"); 
		query.append("        ,'CO' AS COR_IND --??" ).append("\n"); 
		query.append("        ,(SELECT TO_CHAR(MAX(CNTR.CGO_RCV_DT), 'YYYYMMDD') " ).append("\n"); 
		query.append("            FROM BKG_CONTAINER CNTR " ).append("\n"); 
		query.append("           WHERE CNTR.BKG_NO = A.BKG_NO ) AS CGO_RCV_DT" ).append("\n"); 
		query.append("        ,(SELECT DECODE(BK.RCV_TERM_CD||BK.DE_TERM_CD, 'YY', 'PP', 'DY', 'DP', 'YD', 'PD', 'DD', 'DD') " ).append("\n"); 
		query.append("            FROM BKG_BOOKING BK WHERE BK.BKG_NO = A.BKG_NO)   AS TARIFF_SVC_CD" ).append("\n"); 
		query.append("        ,(SELECT BKV.VSL_CD||BKV.SKD_VOY_NO||BKV.SKD_DIR_CD  " ).append("\n"); 
		query.append("            FROM BKG_VVD BKV" ).append("\n"); 
		query.append("           WHERE BKV.BKG_NO = A.BKG_NO AND BKV.VSL_PRE_PST_CD ='T' )  AS VVD" ).append("\n"); 
		query.append("        ,( SELECT VC.LLOYD_NO " ).append("\n"); 
		query.append("          FROM  BKG_VVD BKV, MDM_VSL_CNTR VC" ).append("\n"); 
		query.append("          WHERE BKV.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("          AND BKV.VSL_PRE_PST_CD ='T'" ).append("\n"); 
		query.append("          AND BKV.VSL_CD =  VC.VSL_CD ) AS VSL_LLOYDCODE" ).append("\n"); 
		query.append("        ,A.LOCL_CURR_CD AS CURRENCY_BILL_CD    --?? CHARGE 인지 LOCAL인지 확인필요함." ).append("\n"); 
		query.append("        ,A.BKG_NO --다른 SQL  변수로 사용" ).append("\n"); 
		query.append("        ,A.AR_OFC_CD --다른 SQL  변수로 사용" ).append("\n"); 
		query.append("        ,(SELECT SUBSTR(MAX(DECODE(MN.REV_TP_CD,'M','A','B')||MN.AR_IF_NO),2,11)" ).append("\n"); 
		query.append("                       FROM INV_AR_MN MN" ).append("\n"); 
		query.append("                      WHERE MN.BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                        AND MN.AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                        AND MN.INV_NO    = A.INV_NO" ).append("\n"); 
		query.append("                        AND MN.INV_DELT_DIV_CD <> 'Y') AS MAX_IF_NO  --다른 SQL 변수로 사용" ).append("\n"); 
		query.append("	   , DECODE((SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = A.POR_CD),'E'," ).append("\n"); 
		query.append("	               DECODE(SUBSTR(A.POD_CD,1,2), 'CZ', 'CZ680523179', " ).append("\n"); 
		query.append("				            DECODE(SUBSTR(A.DEL_CD,1,2),'CZ','CZ680523179', " ).append("\n"); 
		query.append("				                    DECODE((SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = A.POL_CD),'E'," ).append("\n"); 
		query.append("	                                       DECODE(SUBSTR(A.POD_CD,1,2), 'CZ', 'CZ680523179', " ).append("\n"); 
		query.append("				                                    DECODE(SUBSTR(A.DEL_CD,1,2),'CZ','CZ680523179','103760')),'103760'))),'103760') AS REF_4G                       " ).append("\n"); 
		query.append("       ,'KR' AS REF_4L" ).append("\n"); 
		query.append("       ,--(SELECT DECODE(A.IO_BND_CD, 'O', BKG.ORG_TRNS_MOD_CD ,'I',BKG.DEST_TRNS_MOD_CD )" ).append("\n"); 
		query.append("         --FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("         --WHERE BKG.BKG_NO = A.BKG_NO) " ).append("\n"); 
		query.append("         'O' AS REF_4M" ).append("\n"); 
		query.append("	   , DECODE((SELECT ORG_TRNS_MOD_CD " ).append("\n"); 
		query.append("				   FROM BKG_BOOKING " ).append("\n"); 
		query.append("				  WHERE BKG_NO = A.BKG_NO), 'R', 'R', 'T', 'S', 'B','B','F','B','A','RS','U','BS','E','BS','') AS REF_V9_ORI" ).append("\n"); 
		query.append("        , DECODE((SELECT DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append("				   FROM BKG_BOOKING " ).append("\n"); 
		query.append("				  WHERE BKG_NO = A.BKG_NO), 'R', 'R', 'T', 'S', 'B','B','F','B','A','RS','U','BS','E','BS','') AS REF_V9_DES" ).append("\n"); 
		query.append("        ,DECODE(A.IO_BND_CD, 'O', 'O/B' ,'I','I/B' ) AS REF_8X" ).append("\n"); 
		query.append("		,A.BL_SRC_NO AS REF_BM" ).append("\n"); 
		query.append("        ,A.LOCL_CURR_CD AS REF_F2" ).append("\n"); 
		query.append("        ,A.BL_SRC_NO AS REF_FR" ).append("\n"); 
		query.append("		,MAX((SELECT DISTINCT 'SA' FROM INV_AR_CHG WHERE AR_IF_NO = A.AR_IF_NO AND CHG_CD IN ('DIV', 'ADF', 'DVC','BCC', 'BSF', 'MCF','ERC', 'EPS','DET','DMR','CLF','SOC', 'WTG', 'CUS', 'PRC'))) AS REF_PID " ).append("\n"); 
		query.append("        --,SUM(DECODE (C.TVA_FLG,'Y',C.CHG_AMT*C.INV_XCH_RT, 0)) AS REF_T2" ).append("\n"); 
		query.append("		,ROUND(NVL(SUM(C.CHG_AMT*C.INV_XCH_RT),0),2) AS REF_T2" ).append("\n"); 
		query.append("        ,(SELECT DECODE (CUST_CNT_CD||LPAD(TO_CHAR(CUST_SEQ),6,'0'),'NL004759','IPG' " ).append("\n"); 
		query.append("                                                                   ,'CZ002224','PSG'" ).append("\n"); 
		query.append("                                                                   ,'NL001591','TSG'" ).append("\n"); 
		query.append("                                                                   ,'GB018385','PSG'" ).append("\n"); 
		query.append("                                                                   ,'DE000231','PSG'" ).append("\n"); 
		query.append("                                                                   ,'CZ002340','PSG'" ).append("\n"); 
		query.append("                                                                   ,'CZ001522','TSG'" ).append("\n"); 
		query.append("                                                                   ,'NL005808','TSG'" ).append("\n"); 
		query.append("                                                                   ,'NL005590','TSG')" ).append("\n"); 
		query.append("                                                                   " ).append("\n"); 
		query.append(" 			FROM  BKG_CUSTOMER " ).append("\n"); 
		query.append("			WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("  			AND BKG_CUST_TP_CD = 'C') AS REF_VC" ).append("\n"); 
		query.append("        ,DECODE(A.SLS_OFC_CD, 'ANRSO', 'BE0877567908'," ).append("\n"); 
		query.append("                              'FXTSC', '539041354'," ).append("\n"); 
		query.append("                              'GOASC', '1680530993'," ).append("\n"); 
		query.append("                              'LEHSC', 'FR46378429377'," ).append("\n"); 
		query.append("                              'RTMSC', 'NL009634095B01'," ).append("\n"); 
		query.append("                              'VLCSC', 'A-97671010'," ).append("\n"); 
		query.append("							  'HAMSC', 'DE118623926'," ).append("\n"); 
		query.append("							  'BUDSC', 'DE118623926'," ).append("\n"); 
		query.append("							  'PRGSC', 'DE118623926'," ).append("\n"); 
		query.append("							  'WRPSC', 'DE118623926'," ).append("\n"); 
		query.append("                              'MXBBA', 'MEG050915FA0'," ).append("\n"); 
		query.append("                              'TORSC', '83271 0867 RT0001'," ).append("\n"); 
		query.append("                              'SELSC', '104-85-21890'," ).append("\n"); 
		query.append("                              'PUSBS', '602-85-16741'," ).append("\n"); 
		query.append("                              'PUSSC', '602-85-16741'," ).append("\n"); 
		query.append("                              'TYOSC', '106041'," ).append("\n"); 
		query.append("                              'OSASO', '106041'," ).append("\n"); 
		query.append("                              'SINSC', 'M90361370G'," ).append("\n"); 
		query.append("                              'BKKSC', '3032076159'," ).append("\n"); 
		query.append("                              'SYDSC', 'ABN 19527041098'," ).append("\n"); 
		query.append("                              'DACSC', '2011037128'," ).append("\n"); 
		query.append("                              'MNLBA', '16-813-254-000','') AS REF_VX" ).append("\n"); 
		query.append("        ,'ITEM OR CHARGE CHANGED' AS REF_8V" ).append("\n"); 
		query.append("		,'EMEA' AS REF_ACB   " ).append("\n"); 
		query.append("FROM INV_AR_ISS D," ).append("\n"); 
		query.append("     INV_AR_ISS_DTL B," ).append("\n"); 
		query.append("     INV_AR_CHG C," ).append("\n"); 
		query.append("     INV_AR_MN A" ).append("\n"); 
		query.append("WHERE D.INV_NO =  @[inv_no] ----( 'HM1456359' ,'HM1457061' ) " ).append("\n"); 
		query.append("  AND D.INV_SEQ  = 1" ).append("\n"); 
		query.append("  AND D.INV_NO  = B.INV_NO" ).append("\n"); 
		query.append("  AND B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("  AND B.CHG_SEQ  = C.CHG_SEQ" ).append("\n"); 
		query.append("  AND B.AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("GROUP BY A.INV_NO, A.BL_SRC_NO, A.BKG_NO, A.AR_OFC_CD, A.IO_BND_CD, A.SLS_OFC_CD, A.LOCL_CURR_CD, A.ISS_DT, A.POD_CD, A.DEL_CD, A.POR_CD, A.POL_CD" ).append("\n"); 
		query.append(", A.TRNK_VSL_CD,  A.TRNK_SKD_VOY_NO, A.TRNK_SKD_DIR_CD" ).append("\n"); 

	}
}