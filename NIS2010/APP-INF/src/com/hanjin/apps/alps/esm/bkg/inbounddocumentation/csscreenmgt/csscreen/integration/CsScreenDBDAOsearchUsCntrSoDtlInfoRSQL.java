/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CsScreenDBDAOsearchUsCntrSoDtlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.03
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2010.08.03 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchUsCntrSoDtlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 고객 응대를 위한 Container별 S/O & W/O 발행 Status 상세 정보를 조회한다.
	  * </pre>
	  */
	public CsScreenDBDAOsearchUsCntrSoDtlInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchUsCntrSoDtlInfoRSQL").append("\n"); 
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
		query.append("SELECT SUBQ.CNTR_NO" ).append("\n"); 
		query.append("      ,SUBQ.SP_CODE" ).append("\n"); 
		query.append("      ,SUBQ.SP_NAME" ).append("\n"); 
		query.append("      ,SUBQ.SP_TEL_NO" ).append("\n"); 
		query.append("      ,SUBQ.COST_MODE" ).append("\n"); 
		query.append("      ,SUBQ.NOD_CD" ).append("\n"); 
		query.append("      ,SUBQ.STS_CD" ).append("\n"); 
		query.append("      ,SUBQ.OFC_CD" ).append("\n"); 
		query.append("      ,SUBQ.USR_ID" ).append("\n"); 
		query.append("      ,USR.USR_NM" ).append("\n"); 
		query.append("      ,SUBQ.SO_NO" ).append("\n"); 
		query.append("      ,SUBQ.SO_DATE" ).append("\n"); 
		query.append("      ,SUBQ.WO_NO" ).append("\n"); 
		query.append("      ,SUBQ.WO_DATE" ).append("\n"); 
		query.append("FROM      " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT SORD.EQ_NO                              AS  CNTR_NO" ).append("\n"); 
		query.append("          ,SORD.TRSP_SO_OFC_CTY_CD                 AS  TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("          ,SORD.TRSP_SO_SEQ                        AS  TRSP_SO_SEQ" ).append("\n"); 
		query.append("          ,SORD.VNDR_SEQ                           AS  SP_CODE     -- S/P CODE  " ).append("\n"); 
		query.append("          ,VD.VNDR_ABBR_NM                         AS  SP_NAME   -- S/P NAME " ).append("\n"); 
		query.append("          ,VD_CNTC.PHN_NO                          AS  SP_TEL_NO  -- S/P TEL NO. " ).append("\n"); 
		query.append("          ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00744',TRSP_COST_DTL_MOD_CD) AS  COST_MODE  " ).append("\n"); 
		query.append("          ,CASE WHEN SORD.TRSP_BND_CD = 'O'  " ).append("\n"); 
		query.append("             THEN SORD.FM_NOD_CD||' - ' ||DECODE(NVL(SORD.DOR_NOD_CD, ''), '', '', SORD.DOR_NOD_CD||' - ')||DECODE(NVL(SORD.VIA_NOD_CD, ''), '', '', SORD.VIA_NOD_CD||' - ')||SORD.TO_NOD_CD  " ).append("\n"); 
		query.append("             ELSE SORD.FM_NOD_CD||' - ' ||DECODE(NVL(SORD.VIA_NOD_CD, ''), '', '', SORD.VIA_NOD_CD||' - ')||DECODE(NVL(SORD.DOR_NOD_CD, ''), '', '', SORD.DOR_NOD_CD||' - ')||SORD.TO_NOD_CD  " ).append("\n"); 
		query.append("           END      AS  NOD_CD                     -- FROM-TO                                                      " ).append("\n"); 
		query.append("          ,CID.INTG_CD_VAL_DP_DESC                     AS  STS_CD       -- S/O STATUS  " ).append("\n"); 
		query.append("          ,SORD.CRE_OFC_CD                             AS  OFC_CD       -- OFFICE                                 " ).append("\n"); 
		query.append("          ,SORD.CRE_USR_ID                             AS  USR_ID       -- USER ID                             " ).append("\n"); 
		query.append("          ,SORD.TRSP_SO_OFC_CTY_CD||SORD.TRSP_SO_SEQ   AS  SO_NO        -- S/O NO                                 " ).append("\n"); 
		query.append("          ,TO_CHAR(SORD.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI')    AS  SO_DATE      -- S/O DATE " ).append("\n"); 
		query.append("          ,SORD.TRSP_WO_OFC_CTY_CD||SORD.TRSP_WO_SEQ   AS  WO_NO        -- W/O NO                       " ).append("\n"); 
		query.append("          ,TO_CHAR(WORD.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') AS  WO_DATE      -- W/O DATE    " ).append("\n"); 
		query.append("    FROM BKG_CONTAINER     BCNTR" ).append("\n"); 
		query.append("        ,TRS_TRSP_SVC_ORD  SORD  " ).append("\n"); 
		query.append("        ,TRS_TRSP_WRK_ORD  WORD " ).append("\n"); 
		query.append("        ,MDM_VENDOR        VD  " ).append("\n"); 
		query.append("        ,MDM_VNDR_CNTC_PNT VD_CNTC  " ).append("\n"); 
		query.append("        ,COM_USER          USR" ).append("\n"); 
		query.append("        ,COM_INTG_CD_DTL   CID" ).append("\n"); 
		query.append("    WHERE BCNTR.BKG_NO              = @[bkg_no]" ).append("\n"); 
		query.append("      AND SORD.BKG_NO               = BCNTR.BKG_NO" ).append("\n"); 
		query.append("      AND SORD.EQ_NO                = BCNTR.CNTR_NO  " ).append("\n"); 
		query.append("      AND SORD.TRSP_BND_CD          = 'I'  " ).append("\n"); 
		query.append("      AND SORD.DELT_FLG             = 'N' " ).append("\n"); 
		query.append("      AND WORD.TRSP_WO_OFC_CTY_CD   = SORD.TRSP_WO_OFC_CTY_CD  " ).append("\n"); 
		query.append("      AND WORD.TRSP_WO_SEQ          = SORD.TRSP_WO_SEQ " ).append("\n"); 
		query.append("      AND VD.VNDR_SEQ (+)           = SORD.VNDR_SEQ       " ).append("\n"); 
		query.append("      AND VD_CNTC.VNDR_SEQ(+)       = SORD.VNDR_SEQ" ).append("\n"); 
		query.append("      AND VD.DELT_FLG (+)           = 'N'           " ).append("\n"); 
		query.append("      AND VD_CNTC.PRMRY_CHK_FLG (+) = 'Y'   " ).append("\n"); 
		query.append("      AND VD_CNTC.PHN_NO(+)        IS NOT NULL            " ).append("\n"); 
		query.append("      AND VD_CNTC.DELT_FLG (+)      = 'N'   " ).append("\n"); 
		query.append("      AND USR.USR_ID (+)            = SORD.CRE_USR_ID" ).append("\n"); 
		query.append("      AND CID.INTG_CD_VAL_CTNT(+)   = SORD.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("      AND CID.INTG_CD_ID(+)         = 'CD00275'" ).append("\n"); 
		query.append("    UNION " ).append("\n"); 
		query.append("    SELECT CNTR_NO                         " ).append("\n"); 
		query.append("          ,TRSP_SO_OFC_CTY_CD              " ).append("\n"); 
		query.append("          ,TRSP_SO_SEQ                     " ).append("\n"); 
		query.append("          ,SP_CODE             " ).append("\n"); 
		query.append("          ,SP_NAME            " ).append("\n"); 
		query.append("          ,SP_TEL_NO        " ).append("\n"); 
		query.append("          ,COST_MODE                       " ).append("\n"); 
		query.append("          ,NOD_CD                           " ).append("\n"); 
		query.append("          ,STS_CD          " ).append("\n"); 
		query.append("          ,OFC_CD              " ).append("\n"); 
		query.append("          ,USR_ID             " ).append("\n"); 
		query.append("          ,SO_NO                " ).append("\n"); 
		query.append("          ,SO_DATE           " ).append("\n"); 
		query.append("          ,WO_NO              " ).append("\n"); 
		query.append("          ,WO_DATE       " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("     	SELECT  TORD.EQ_NO                                                              AS  CNTR_NO" ).append("\n"); 
		query.append("    	       ,TORD.TRSP_SO_OFC_CTY_CD                                                 AS  TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    	       ,TORD.TRSP_SO_SEQ                                                        AS  TRSP_SO_SEQ" ).append("\n"); 
		query.append("    	       ,MAX(VD.VNDR_SEQ )                       				AS  SP_CODE     -- S/P CODE  " ).append("\n"); 
		query.append("    	       ,MAX(VD.VNDR_ABBR_NM)                    				AS  SP_NAME  -- S/P NAME " ).append("\n"); 
		query.append("    	       ,MAX(VD_CNT.PHN_NO )                     				AS  SP_TEL_NO -- S/P TEL NO. " ).append("\n"); 
		query.append("    	       ,MAX(COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00744',TRSP_COST_DTL_MOD_CD) )  AS  COST_MODE  " ).append("\n"); 
		query.append("    	       ,MAX(DECODE(TVDR.SUB_RAIL_SEQ, 1, TVDR.FM_NOD_CD))|| ' - '|| " ).append("\n"); 
		query.append("    	        MAX(DECODE(TVDR.SUB_RAIL_SEQ, 1, TVDR.TO_NOD_CD))|| " ).append("\n"); 
		query.append("    	        MAX(DECODE(TVDR.SUB_RAIL_SEQ, 2, ' - '||TVDR.TO_NOD_CD))|| " ).append("\n"); 
		query.append("    	        MAX(DECODE(TVDR.SUB_RAIL_SEQ, 3, ' - '||TVDR.TO_NOD_CD))      		AS NOD_CD      " ).append("\n"); 
		query.append("    	       ,MAX(CID.INTG_CD_VAL_DP_DESC)                       			AS  STS_CD       -- S/O STATUS                                  " ).append("\n"); 
		query.append("    	       ,MAX(TORD.CRE_OFC_CD )                              			AS  OFC_CD       -- OFFICE                                 " ).append("\n"); 
		query.append("    	       ,MAX(TORD.CRE_USR_ID  )                             			AS  USR_ID     -- USER ID    " ).append("\n"); 
		query.append("    	       ,MAX(TORD.TRSP_SO_OFC_CTY_CD||TORD.TRSP_SO_SEQ)     			AS  SO_NO        -- S/O NO                                 " ).append("\n"); 
		query.append("    	        ,TO_CHAR(MAX(TORD.LOCL_CRE_DT), 'YYYY-MM-DD HH24:MI')      		AS  SO_DATE       -- S/O DATE " ).append("\n"); 
		query.append("    	       ,''                                                 			AS  WO_NO        -- W/O NO                       " ).append("\n"); 
		query.append("    	       ,TO_CHAR (MAX(WO.LOCL_CRE_DT), 'YYYY-MM-DD HH24:MI:SS') 	AS  WO_DATE      -- W/O DATE  " ).append("\n"); 
		query.append("    	FROM  BKG_CONTAINER BCNTR" ).append("\n"); 
		query.append("    	     ,TRS_TRSP_RAIL_BIL_ORD TORD       " ).append("\n"); 
		query.append("             ,TRS_TRSP_EDI_RAIL_ORD WO             " ).append("\n"); 
		query.append("    	     ,TRS_TRSP_RAIL_BIL_VNDR_SET TVDR     " ).append("\n"); 
		query.append("    	     ,MDM_VNDR_CNTC_PNT VD_CNT                     " ).append("\n"); 
		query.append("    	     ,MDM_VENDOR  VD      " ).append("\n"); 
		query.append("    	     ,COM_INTG_CD_DTL   CID" ).append("\n"); 
		query.append("    	WHERE BCNTR.BKG_NO               = @[bkg_no]" ).append("\n"); 
		query.append("    	  AND TORD.BKG_NO                = BCNTR.BKG_NO" ).append("\n"); 
		query.append("    	  AND TORD.EQ_NO                 = BCNTR.CNTR_NO   " ).append("\n"); 
		query.append("    	  AND TORD.TRSP_BND_CD           = 'I'" ).append("\n"); 
		query.append("          AND TORD.EQ_KND_CD             = 'U'  " ).append("\n"); 
		query.append("          AND TORD.DELT_FLG              = 'N'   " ).append("\n"); 
		query.append("    	  AND WO.TRSP_SO_OFC_CTY_CD(+)   = TORD.TRSP_SO_OFC_CTY_CD " ).append("\n"); 
		query.append("          AND WO.TRSP_SO_SEQ(+)          = TORD.TRSP_SO_SEQ " ).append("\n"); 
		query.append("          AND WO.BIL_ISS_KNT(+)          = TORD.BIL_ISS_KNT " ).append("\n"); 
		query.append("          AND WO.DELT_FLG(+)             = 'N'" ).append("\n"); 
		query.append("    	  AND VD_CNT.PRMRY_CHK_FLG (+)   = 'Y'                            " ).append("\n"); 
		query.append("    	  AND VD_CNT.PHN_NO           IS NOT NULL                      " ).append("\n"); 
		query.append("    	  AND TVDR.TRSP_SO_OFC_CTY_CD(+) = TORD.TRSP_SO_OFC_CTY_CD                     " ).append("\n"); 
		query.append("    	  AND TVDR.TRSP_SO_SEQ(+)        = TORD.TRSP_SO_SEQ         " ).append("\n"); 
		query.append("    	  AND TVDR.TRSP_MOD_CD(+)        = 'RD'                      " ).append("\n"); 
		query.append("    	  AND VD.VNDR_SEQ (+)            = TVDR.VNDR_SEQ       " ).append("\n"); 
		query.append("    	  AND VD_CNT.VNDR_SEQ(+)         = TVDR.VNDR_SEQ" ).append("\n"); 
		query.append("    	  AND VD.DELT_FLG (+)            = 'N'           " ).append("\n"); 
		query.append("    	  AND VD_CNT.PRMRY_CHK_FLG (+)   = 'Y'   " ).append("\n"); 
		query.append("    	  AND VD_CNT.PHN_NO           IS NOT NULL            " ).append("\n"); 
		query.append("    	  AND VD_CNT.DELT_FLG (+)        = 'N'   	" ).append("\n"); 
		query.append("          AND CID.INTG_CD_VAL_CTNT(+)    = DECODE (WO.BIL_ISS_STS_CD   , 'X', 'N' , WO.BIL_ISS_STS_CD )" ).append("\n"); 
		query.append("    	  AND CID.INTG_CD_ID(+)          = 'CD00804'              " ).append("\n"); 
		query.append("    	  GROUP BY TORD.EQ_NO," ).append("\n"); 
		query.append("    	           TORD.TRSP_SO_OFC_CTY_CD,                            " ).append("\n"); 
		query.append("    	           TORD.TRSP_SO_SEQ" ).append("\n"); 
		query.append("     )	           " ).append("\n"); 
		query.append(")SUBQ" ).append("\n"); 
		query.append(" LEFT OUTER JOIN COM_USER USR " ).append("\n"); 
		query.append("    ON( USR.USR_ID  = SUBQ.USR_ID )" ).append("\n"); 
		query.append("ORDER BY 1,2 DESC" ).append("\n"); 

	}
}