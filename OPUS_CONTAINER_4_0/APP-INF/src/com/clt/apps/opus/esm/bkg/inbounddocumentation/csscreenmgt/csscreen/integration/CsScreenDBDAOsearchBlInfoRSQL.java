/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CsScreenDBDAOsearchBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 고객 응대를 위한 조회 화면 BL 정보를 조회한다.
	  * </pre>
	  */
	public CsScreenDBDAOsearchBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchBlInfoRSQL").append("\n"); 
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
		query.append("SELECT VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD                             AS ARRIVAL_VVD       -- VVD" ).append("\n"); 
		query.append("       ,VSL.VSL_ENG_NM                                                            AS ARRIVAL_VVD_NM    -- Vessel Name" ).append("\n"); 
		query.append("       ,(SELECT DECODE(COUNT(1), 1, 'Y', 'N')" ).append("\n"); 
		query.append("          FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("         WHERE CNTR.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND CNTR.CNTR_PRT_FLG = 'Y'" ).append("\n"); 
		query.append("           AND ROWNUM = 1)                                                        AS PARTIAL       -- Partial B/L 여부('Y','N')" ).append("\n"); 
		query.append("       ,TO_CHAR(SKD.VPS_ETA_DT,'YYYY/MM/DD HH24:MI')                              AS VPS_ETA_DT    -- POD ETA" ).append("\n"); 
		query.append("       ,TO_CHAR(ASKD.ACT_ARR_DT,'YYYY/MM/DD HH24:MI')                             AS VPS_ETB_DT    -- POD ATA" ).append("\n"); 
		query.append("       ,VVD.SLAN_CD                                                               AS SLAN_CD       -- 마지막 VVD의 LANE" ).append("\n"); 
		query.append("       ,BKG.RCV_TERM_CD                                                           AS RCV_TERM_CD   -- por에서 Receive Term" ).append("\n"); 
		query.append("       ,BKG.DE_TERM_CD                                                            AS DE_TERM_CD    -- POD에서 Delivery Term" ).append("\n"); 
		query.append("       ,BKG.POR_CD                                                                AS POR_CD           " ).append("\n"); 
		query.append("       ,BKG.POL_CD                                                                AS POL_CD" ).append("\n"); 
		query.append("       ,BKG.POD_CD                                                                AS POD_CD" ).append("\n"); 
		query.append("       ,SUBSTR(BKG.POD_NOD_CD, 6, 2)                                              AS POD_YD_CD     " ).append("\n"); 
		query.append("       ,POD.YD_NM                                                                AS POD_NM" ).append("\n"); 
		query.append("       ,BKG.DEL_CD                                                                AS DEL_CD" ).append("\n"); 
		query.append("       ,SUBSTR(BKG.DEL_NOD_CD, 6, 2)                                              AS DEL_YD_CD" ).append("\n"); 
		query.append("       ,DECODE(SUBSTR(BKG.DEL_NOD_CD, 6, 1),'Z',ZNE.ZN_NM,DEL.YD_NM)              AS DEL_NM" ).append("\n"); 
		query.append("       ,BKG.BKG_STS_CD                                                            AS BKG_STS_CD    -- 조회된 시점의 STS(W, A, F, X)" ).append("\n"); 
		query.append("       ,DOC.BDR_FLG                                                               AS BDR_FLG" ).append("\n"); 
		query.append("       ,DOC.CORR_USR_ID                                                           AS CORR_USR_ID" ).append("\n"); 
		query.append("       ,(SELECT DECODE(COUNT(1), 1, 'Y', 'N')" ).append("\n"); 
		query.append("          FROM BKG_CORRECTION CORR" ).append("\n"); 
		query.append("         WHERE CORR.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND ROWNUM = 1)                                                        AS CORR_USR_ID" ).append("\n"); 
		query.append("       ,DOC.PCK_QTY                                                               AS PCK_QTY" ).append("\n"); 
		query.append("       ,DOC.PCK_TP_CD                                                             AS PCK_TP_CD" ).append("\n"); 
		query.append("       ,DOC.ACT_WGT                                                               AS ACT_WGT" ).append("\n"); 
		query.append("       ,DOC.WGT_UT_CD                                                             AS WGT_UT_CD" ).append("\n"); 
		query.append("       ,BKG.SC_NO                                                                 AS SC_NO" ).append("\n"); 
		query.append("       ,BKG.RFA_NO                                                                AS RFA_NO" ).append("\n"); 
		query.append("       ,DOC.CSTMS_DESC                                                            AS CSTMS_DESC     " ).append("\n"); 
		query.append("       ,CASE WHEN  BKG.BL_TP_CD     ='W' " ).append("\n"); 
		query.append("                OR ISS.OBL_SRND_FLG ='Y'           " ).append("\n"); 
		query.append("                OR ISS.OBL_RDEM_FLG ='Y' THEN 'Y'" ).append("\n"); 
		query.append("             ELSE 'N' END                                                         AS OBL_RDEM_FLG             " ).append("\n"); 
		query.append("       ,NVL(CGO.OBL_RDEM_FLG,'N')                                                 AS US_OBL_RDEM_FLG      " ).append("\n"); 
		query.append("       , CASE WHEN  SUBSTR(BKG.POD_CD,1,2) = 'US' OR SUBSTR(BKG.POD_CD,1,2) = 'CA'" ).append("\n"); 
		query.append("              THEN TO_CHAR(CGO.OBL_RDEM_LST_DT,'YYYY-MM-DD HH24:MI') " ).append("\n"); 
		query.append("              ELSE TO_CHAR(DECODE( BKG.BL_TP_CD,'W',ISS.OBL_ISS_DT" ).append("\n"); 
		query.append("                                         ,ISS.OBL_RDEM_DT ),'YYYY-MM-DD HH24:MI') " ).append("\n"); 
		query.append("              END AS OBL_RDEM_DT       " ).append("\n"); 
		query.append("       ,DECODE(BKG.BL_TP_CD,'W',ISS.OBL_ISS_OFC_CD,ISS.OBL_RDEM_OFC_CD )          AS OBL_RDEM_OFC_CD     " ).append("\n"); 
		query.append("       ,SHP.CUST_CNT_CD || DECODE(SHP.CUST_SEQ,'0','',SHP.CUST_SEQ)               AS SHP_CUST_CD" ).append("\n"); 
		query.append("       ,SHP.CUST_NM                                                               AS SHP_CUST_NM" ).append("\n"); 
		query.append("       ,CSG.CUST_CNT_CD || DECODE(CSG.CUST_SEQ,'0','',CSG.CUST_SEQ)               AS CSG_CUST_CD" ).append("\n"); 
		query.append("       ,CSG.CUST_NM                                                               AS CSG_CUST_NM" ).append("\n"); 
		query.append("       ,NOY.CUST_CNT_CD || DECODE(NOY.CUST_SEQ,'0','',NOY.CUST_SEQ)               AS NOY_CUST_CD" ).append("\n"); 
		query.append("       ,NOY.CUST_NM                                            AS NOY_CUST_NM" ).append("\n"); 
		query.append("       ,AOY.CUST_CNT_CD || DECODE(AOY.CUST_SEQ,'0','',AOY.CUST_SEQ)               AS AOY_CUST_CD" ).append("\n"); 
		query.append("       ,AOY.CUST_NM                                                               AS AOY_CUST_NM" ).append("\n"); 
		query.append("       ,BKG.BL_NO                                                                 AS BL_NO" ).append("\n"); 
		query.append("       ,BKG.BKG_NO                                                                AS BKG_NO" ).append("\n"); 
		query.append("       --,DECODE(BKG.BKG_CRE_TP_CD,'S','Y',DECODE( NVL(BKG.FM_BKG_NO,'N'),'N','N','Y')) AS SPLIT_FLG" ).append("\n"); 
		query.append("       ,CASE WHEN (BKG.BKG_CRE_TP_CD = 'S' AND RTRIM(BKG.FM_BKG_NO) > ' ') THEN 'Y' ELSE 'N' END AS SPLIT_FLG" ).append("\n"); 
		query.append("       ,BKG.BKG_CRE_DT                                                            AS BKG_CRE_DT" ).append("\n"); 
		query.append("       ,BKG.BKG_OFC_CD                                                            AS BKG_OFC_CD" ).append("\n"); 
		query.append("       ,DECODE(ISS.OBL_SRND_FLG,'Y','S', BKG.BL_TP_CD)                            AS BL_TP_CD" ).append("\n"); 
		query.append("       ,DECODE(BKG.BB_CGO_FLG, 'Y', 'M','R','F', BKG.BKG_CGO_TP_CD)               AS BKG_CGO_TP_CD" ).append("\n"); 
		query.append("       ,BKG.BB_CGO_FLG                                                            AS BB_CGO_FLG " ).append("\n"); 
		query.append("       ,(SELECT DECODE(COUNT(1), 1, 'Y', 'N')" ).append("\n"); 
		query.append("          FROM BKG_USA_CUST_SVC_INSTR SVC_INSTR" ).append("\n"); 
		query.append("         WHERE SVC_INSTR.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND SVC_INSTR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND ROWNUM = 1)                                                        AS INSTRUCTION       -- Instruction 존재 여부('Y','N')" ).append("\n"); 
		query.append("  FROM BKG_BOOKING               BKG " ).append("\n"); 
		query.append("       JOIN BKG_VVD              VVD" ).append("\n"); 
		query.append("       ON ( VVD.BKG_NO             = BKG.BKG_NO         " ).append("\n"); 
		query.append("            AND VVD.POD_CD         = BKG.POD_CD         " ).append("\n"); 
		query.append("            AND VVD.VSL_PRE_PST_CD IN ( 'T','U' )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       LEFT OUTER JOIN VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("       ON ( SKD.VSL_CD           =  VVD.VSL_CD          " ).append("\n"); 
		query.append("            AND SKD.SKD_VOY_NO   = VVD.SKD_VOY_NO      " ).append("\n"); 
		query.append("            AND SKD.SKD_DIR_CD   = VVD.SKD_DIR_CD      " ).append("\n"); 
		query.append("            AND SKD.VPS_PORT_CD  = VVD.POD_CD            " ).append("\n"); 
		query.append("            AND SKD.CLPT_IND_SEQ = VVD.POD_CLPT_IND_SEQ " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       LEFT OUTER JOIN VSK_ACT_PORT_SKD ASKD" ).append("\n"); 
		query.append("         ON ( ASKD.VSL_CD          =  VVD.VSL_CD          " ).append("\n"); 
		query.append("            AND ASKD.SKD_VOY_NO   = VVD.SKD_VOY_NO      " ).append("\n"); 
		query.append("            AND ASKD.SKD_DIR_CD   = VVD.SKD_DIR_CD      " ).append("\n"); 
		query.append("            AND ASKD.VPS_PORT_CD  = VVD.POD_CD            " ).append("\n"); 
		query.append("            AND ASKD.CLPT_IND_SEQ = VVD.POD_CLPT_IND_SEQ " ).append("\n"); 
		query.append("       )         " ).append("\n"); 
		query.append("       LEFT OUTER JOIN  MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("       ON ( VVD.VSL_CD = VSL.VSL_CD )" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       JOIN BKG_BL_DOC DOC" ).append("\n"); 
		query.append("       ON ( DOC.BKG_NO  = BKG.BKG_NO )" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       LEFT OUTER JOIN MDM_YARD POD" ).append("\n"); 
		query.append("       ON ( POD.YD_CD = BKG.POD_NOD_CD )" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       LEFT OUTER JOIN MDM_YARD DEL" ).append("\n"); 
		query.append("       ON ( DEL.YD_CD = BKG.DEL_NOD_CD  )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       LEFT OUTER JOIN MDM_ZONE ZNE" ).append("\n"); 
		query.append("       ON ( ZNE.ZN_CD = BKG.DEL_NOD_CD  )" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       LEFT OUTER JOIN BKG_BL_ISS ISS" ).append("\n"); 
		query.append("       ON ( ISS.BKG_NO = BKG.BKG_NO )" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       LEFT OUTER JOIN BKG_CUSTOMER SHP" ).append("\n"); 
		query.append("       ON ( SHP.BKG_NO = BKG.BKG_NO " ).append("\n"); 
		query.append("       AND SHP.BKG_CUST_TP_CD = 'S' )" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       LEFT OUTER JOIN BKG_CUSTOMER CSG" ).append("\n"); 
		query.append("       ON ( CSG.BKG_NO = BKG.BKG_NO " ).append("\n"); 
		query.append("            AND CSG.BKG_CUST_TP_CD = 'C')" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       LEFT OUTER JOIN BKG_CUSTOMER NOY" ).append("\n"); 
		query.append("       ON ( NOY.BKG_NO = BKG.BKG_NO " ).append("\n"); 
		query.append("            AND NOY.BKG_CUST_TP_CD = 'N')" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       LEFT OUTER JOIN BKG_CUSTOMER  AOY" ).append("\n"); 
		query.append("       ON ( AOY.BKG_NO  = BKG.BKG_NO" ).append("\n"); 
		query.append("            AND AOY.BKG_CUST_TP_CD = 'A' )" ).append("\n"); 
		query.append("       LEFT OUTER JOIN BKG_CGO_RLSE CGO" ).append("\n"); 
		query.append("       ON ( CGO.BL_NO   = BKG.BL_NO)" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO =  @[bkg_no]" ).append("\n"); 

	}
}