/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CsScreenDBDAOsearchCntrSoDtlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchCntrSoDtlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 고객 응대를 위한 Container별 S/O & W/O 발행 Status 상세 정보를 조회한다.
	  * </pre>
	  */
	public CsScreenDBDAOsearchCntrSoDtlInfoRSQL(){
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
		query.append("FileName : CsScreenDBDAOsearchCntrSoDtlInfoRSQL").append("\n"); 
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
		query.append("SELECT SORD.VNDR_SEQ             SP_CODE     -- S/P CODE  " ).append("\n"); 
		query.append("      ,SORD.EQ_NO                CNTR_NO" ).append("\n"); 
		query.append("      ,VD.VNDR_LGL_ENG_NM        SP_NAME   -- S/P NAME " ).append("\n"); 
		query.append("      ,VD_CNTC.PHN_NO            SP_TEL_NO  -- S/P TEL NO. " ).append("\n"); 
		query.append("      ,VD_CNTC.FAX_NO            SP_FAX_NO   -- FROM-TO  " ).append("\n"); 
		query.append("      ,(CASE WHEN SUBSTR(SORD.COST_ACT_GRP_CD,2,1) = 'D' THEN 'DOOR'     " ).append("\n"); 
		query.append("          WHEN SUBSTR(SORD.COST_ACT_GRP_CD,3,1) = 'W' THEN 'WATER'   " ).append("\n"); 
		query.append("          WHEN SUBSTR(SORD.COST_ACT_GRP_CD,3,1) = 'R' THEN 'RAIL'   " ).append("\n"); 
		query.append("          WHEN SUBSTR(SORD.COST_ACT_GRP_CD,3,1) = 'T' THEN   " ).append("\n"); 
		query.append("          ( CASE WHEN TRSP_BND_CD = 'T' THEN 'SHUTTLE'   " ).append("\n"); 
		query.append("                 WHEN SUBSTR(FM_NOD_CD,1,5) = SUBSTR(TO_NOD_CD,1,5) AND    " ).append("\n"); 
		query.append("                     (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = DECODE(SORD.TRSP_BND_CD,'O',TO_NOD_CD,'I',FM_NOD_CD)) IN ('M','B') THEN   " ).append("\n"); 
		query.append("                      'SHUTTLE'   " ).append("\n"); 
		query.append("                 ELSE 'ADDITIONAL'      " ).append("\n"); 
		query.append("            END)   " ).append("\n"); 
		query.append("         ELSE 'NULL'            " ).append("\n"); 
		query.append("      END ) COST_MODE                    -- COST MODE" ).append("\n"); 
		query.append("   ,CASE WHEN SORD.TRSP_BND_CD = 'O'  " ).append("\n"); 
		query.append("         THEN SORD.FM_NOD_CD||' - ' ||DECODE(NVL(SORD.DOR_NOD_CD, ''), '', '', SORD.DOR_NOD_CD||' - ')||DECODE(NVL(SORD.VIA_NOD_CD, ''), '', '', SORD.VIA_NOD_CD||' - ')||SORD.TO_NOD_CD  " ).append("\n"); 
		query.append("         ELSE SORD.FM_NOD_CD||' - ' ||DECODE(NVL(SORD.VIA_NOD_CD, ''), '', '', SORD.VIA_NOD_CD||' - ')||DECODE(NVL(SORD.DOR_NOD_CD, ''), '', '', SORD.DOR_NOD_CD||' - ')||SORD.TO_NOD_CD  " ).append("\n"); 
		query.append("    END       NOD_CD                     -- FROM-TO                                                      " ).append("\n"); 
		query.append("  ,DECODE(TRSP_SO_STS_CD,'P','SO PLANNED' " ).append("\n"); 
		query.append("                                ,'C','S/O ISSUE'  " ).append("\n"); 
		query.append("                                ,'I','W/O ISSUE'  " ).append("\n"); 
		query.append("                                ,'EXCUTED')     STS_CD       -- S/O STATUS  " ).append("\n"); 
		query.append("  ,SORD.CRE_OFC_CD                              OFC_CD       -- OFFICE                                 " ).append("\n"); 
		query.append("  ,SORD.CRE_USR_ID                              USR_ID       -- USER ID                             " ).append("\n"); 
		query.append("  ,SORD.TRSP_SO_OFC_CTY_CD||SORD.TRSP_SO_SEQ    SO_NO        -- S/O NO                                 " ).append("\n"); 
		query.append("  ,TO_CHAR(SORD.LOCL_CRE_DT, 'YYYYMMDD HH24:MI:SS')  SO_DATE      -- S/O DATE " ).append("\n"); 
		query.append("  ,SORD.TRSP_WO_OFC_CTY_CD||SORD.TRSP_WO_SEQ    WO_NO        -- W/O NO                       " ).append("\n"); 
		query.append("  ,TO_CHAR(WORD.LOCL_CRE_DT, 'YYYYMMDD HH24:MI:SS')  WO_DATE      -- W/O DATE    " ).append("\n"); 
		query.append("  ,USR.USR_NM                                   USR_NM" ).append("\n"); 
		query.append("FROM BKG_CONTAINER BCNTR" ).append("\n"); 
		query.append("    ,TRS_TRSP_SVC_ORD  SORD  " ).append("\n"); 
		query.append("    ,TRS_TRSP_WRK_ORD  WORD  " ).append("\n"); 
		query.append("    ,MDM_VENDOR        VD  " ).append("\n"); 
		query.append("    ,MDM_VNDR_CNTC_PNT VD_CNTC  " ).append("\n"); 
		query.append("    ,COM_USER          USR" ).append("\n"); 
		query.append("WHERE BCNTR.BKG_NO            = @[bkg_no]" ).append("\n"); 
		query.append("  AND SORD.BKG_NO             = BCNTR.BKG_NO" ).append("\n"); 
		query.append("  AND SORD.EQ_NO              = BCNTR.CNTR_NO  " ).append("\n"); 
		query.append("  AND SORD.TRSP_BND_CD        = 'I'  " ).append("\n"); 
		query.append("  AND SORD.TRSP_WO_OFC_CTY_CD = WORD.TRSP_WO_OFC_CTY_CD  " ).append("\n"); 
		query.append("  AND SORD.TRSP_WO_SEQ        = WORD.TRSP_WO_SEQ  " ).append("\n"); 
		query.append("  AND SORD.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("  AND VD.VNDR_SEQ(+)          = SORD.VNDR_SEQ" ).append("\n"); 
		query.append("  AND VD.DELT_FLG (+)         = 'N'           " ).append("\n"); 
		query.append("  AND VD_CNTC.VNDR_SEQ(+)     = SORD.VNDR_SEQ" ).append("\n"); 
		query.append("  AND VD_CNTC.PHN_NO      IS NOT NULL            " ).append("\n"); 
		query.append("  AND VD_CNTC.DELT_FLG (+)    = 'N' " ).append("\n"); 
		query.append("  AND SORD.CRE_USR_ID         = USR.USR_ID (+)" ).append("\n"); 
		query.append("ORDER BY SORD.VNDR_SEQ, SORD.CRE_DT DESC" ).append("\n"); 

	}
}