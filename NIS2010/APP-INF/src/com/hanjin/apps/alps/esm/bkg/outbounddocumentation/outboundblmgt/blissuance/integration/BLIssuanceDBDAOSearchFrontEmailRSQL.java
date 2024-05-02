/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchFrontEmailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchFrontEmailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOSearchFrontEmailRSQL
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchFrontEmailRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchFrontEmailRSQL").append("\n"); 
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
		query.append("WITH TEMP_T AS(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--       1. OFC CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      SELECT EML.BKG_OFC_CD" ).append("\n"); 
		query.append("			,EML.VBS_CTNT AS TO_NAME" ).append("\n"); 
		query.append("			,EML.EML_CPY_TO_EML AS EML_ADDR" ).append("\n"); 
		query.append("            ,EML.DPCS_EML_STND_GRP_TP_CD" ).append("\n"); 
		query.append("			FROM   BKG_EML_ACCT_STUP EML" ).append("\n"); 
		query.append("			WHERE  1 = 1 " ).append("\n"); 
		query.append("      AND    EML.DPCS_EML_SVC_KND_CD = 'BL'" ).append("\n"); 
		query.append("      AND    EML.DPCS_EML_STND_GRP_TP_CD = 'O' " ).append("\n"); 
		query.append("      AND    EML.DELT_FLG = 'N'" ).append("\n"); 
		query.append("      AND    EXISTS (SELECT 1" ).append("\n"); 
		query.append("        			   FROM  BKG_OFC_LVL_V V" ).append("\n"); 
		query.append("        					,BKG_BOOKING   BK" ).append("\n"); 
		query.append("        			  WHERE  1 = 1 " ).append("\n"); 
		query.append("                        AND  BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                        AND  V.OFC_CD = BK.BKG_OFC_CD " ).append("\n"); 
		query.append("                        AND  DECODE(EML.INCL_SUB_OFC_FLG, 'Y', V.GSO, V.OFC_CD) = EML.VBS_CTNT)" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--         2. LANE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			SELECT EML.BKG_OFC_CD" ).append("\n"); 
		query.append("				  ,EML.VBS_CTNT AS TO_NAME" ).append("\n"); 
		query.append("				  ,EML.EML_CPY_TO_EML AS EML_ADDR" ).append("\n"); 
		query.append("                  ,EML.DPCS_EML_STND_GRP_TP_CD" ).append("\n"); 
		query.append("			FROM   BKG_EML_ACCT_STUP EML" ).append("\n"); 
		query.append("				  ,BKG_BOOKING       BK" ).append("\n"); 
		query.append("			WHERE  1 = 1 " ).append("\n"); 
		query.append("              AND    BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND    EML.DPCS_EML_SVC_KND_CD = 'BL'" ).append("\n"); 
		query.append("              AND    EML.VBS_CTNT = BK.SLAN_CD " ).append("\n"); 
		query.append("              AND    EML.BKG_OFC_CD = BK.BKG_OFC_CD" ).append("\n"); 
		query.append("              AND    EML.DPCS_EML_STND_GRP_TP_CD = 'L'" ).append("\n"); 
		query.append("              AND    EML.DELT_FLG = 'N'" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--       3. S/C No" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			SELECT EML.BKG_OFC_CD" ).append("\n"); 
		query.append("				  ,EML.VBS_CTNT AS TO_NAME" ).append("\n"); 
		query.append("				  ,EML.EML_CPY_TO_EML AS EML_ADDR" ).append("\n"); 
		query.append("                  ,EML.DPCS_EML_STND_GRP_TP_CD" ).append("\n"); 
		query.append("			 FROM  BKG_EML_ACCT_STUP EML" ).append("\n"); 
		query.append("				  ,BKG_BOOKING       BK" ).append("\n"); 
		query.append("			WHERE  1 = 1 " ).append("\n"); 
		query.append("              AND    BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND    EML.DPCS_EML_SVC_KND_CD = 'BL'" ).append("\n"); 
		query.append("              AND    EML.VBS_CTNT = BK.SC_NO " ).append("\n"); 
		query.append("              AND    EML.BKG_OFC_CD = BK.BKG_OFC_CD" ).append("\n"); 
		query.append("              AND    EML.DPCS_EML_STND_GRP_TP_CD = 'S'" ).append("\n"); 
		query.append("              AND    EML.DELT_FLG = 'N'" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- 4. Route - POL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			SELECT EML.BKG_OFC_CD" ).append("\n"); 
		query.append("				  ,EML.POL_CD AS TO_NAME" ).append("\n"); 
		query.append("				  ,EML.EML_CPY_TO_EML AS EML_ADDR" ).append("\n"); 
		query.append("                  ,EML.DPCS_EML_STND_GRP_TP_CD" ).append("\n"); 
		query.append("			FROM   BKG_EML_ACCT_STUP EML" ).append("\n"); 
		query.append("				  ,BKG_BOOKING       BK" ).append("\n"); 
		query.append("				  ,MDM_LOCATION      MDM" ).append("\n"); 
		query.append("			WHERE  1 = 1 " ).append("\n"); 
		query.append("              AND    BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND    EML.DPCS_EML_SVC_KND_CD = 'BL'" ).append("\n"); 
		query.append("              AND    BK.POL_CD = MDM.LOC_CD " ).append("\n"); 
		query.append("              AND    EML.BKG_OFC_CD = BK.BKG_OFC_CD" ).append("\n"); 
		query.append("              AND    EML.POL_CD =DECODE(EML.POL_DPCS_EML_LOC_GRP_TP_CD, 'C', MDM.CONTI_CD, 'S', (SELECT CN.SCONTI_CD" ).append("\n"); 
		query.append("                                                                                                  FROM   MDM_COUNTRY CN" ).append("\n"); 
		query.append("                                                                                                  WHERE  CN.CNT_CD = MDM.CNT_CD), 'T', MDM.CNT_CD, MDM.LOC_CD) " ).append("\n"); 
		query.append("              AND    EML.DPCS_EML_STND_GRP_TP_CD = 'R' -- Route" ).append("\n"); 
		query.append("              AND    EML.DELT_FLG = 'N'" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        -- 5. Route - DEL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			SELECT EML.BKG_OFC_CD" ).append("\n"); 
		query.append("				  ,EML.DEL_CD AS TO_NAME" ).append("\n"); 
		query.append("				  ,EML.EML_CPY_TO_EML AS EML_ADDR" ).append("\n"); 
		query.append("                  ,EML.DPCS_EML_STND_GRP_TP_CD" ).append("\n"); 
		query.append("			FROM   BKG_EML_ACCT_STUP EML" ).append("\n"); 
		query.append("				  ,BKG_BOOKING       BK" ).append("\n"); 
		query.append("				  ,MDM_LOCATION      MDM" ).append("\n"); 
		query.append("			WHERE  1 = 1 " ).append("\n"); 
		query.append("              AND    BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND    EML.DPCS_EML_SVC_KND_CD = 'BL'" ).append("\n"); 
		query.append("              AND    BK.DEL_CD = MDM.LOC_CD " ).append("\n"); 
		query.append("              AND    EML.BKG_OFC_CD = BK.BKG_OFC_CD" ).append("\n"); 
		query.append("              AND    EML.DEL_CD = DECODE(EML.DEL_DPCS_EML_LOC_GRP_TP_CD, 'C', MDM.CONTI_CD, 'S', (SELECT CN.SCONTI_CD " ).append("\n"); 
		query.append("                                                                                                    FROM   MDM_COUNTRY CN" ).append("\n"); 
		query.append("                                                                                                    WHERE  CN.CNT_CD = MDM.CNT_CD), 'T', MDM.CNT_CD, MDM.LOC_CD) " ).append("\n"); 
		query.append("              AND    EML.DPCS_EML_STND_GRP_TP_CD = 'R' -- Route" ).append("\n"); 
		query.append("              AND    EML.DELT_FLG = 'N'" ).append("\n"); 
		query.append("			 )" ).append("\n"); 
		query.append("			 " ).append("\n"); 
		query.append("      SELECT VAL AS EML	        " ).append("\n"); 
		query.append("      FROM (  SELECT EML_ADDR  VAL" ).append("\n"); 
		query.append("      				FROM   TEMP_T T" ).append("\n"); 
		query.append("              ,      COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("      				WHERE  C.INTG_CD_ID = 'CD02802'" ).append("\n"); 
		query.append("              AND    C.INTG_CD_VAL_CTNT = T.DPCS_EML_STND_GRP_TP_CD" ).append("\n"); 
		query.append("           --   AND    EXISTS (SELECT 1 FROM BKG_DPCS_USR_GRP WHERE USR_ID = IN_USR_ID AND DPCS_WRK_GRP_CD != 'F') " ).append("\n"); 
		query.append("              ORDER BY C.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("           -- 정렬기준에 따라 조회" ).append("\n"); 
		query.append("            )  " ).append("\n"); 
		query.append("      WHERE ROWNUM = 1" ).append("\n"); 

	}
}