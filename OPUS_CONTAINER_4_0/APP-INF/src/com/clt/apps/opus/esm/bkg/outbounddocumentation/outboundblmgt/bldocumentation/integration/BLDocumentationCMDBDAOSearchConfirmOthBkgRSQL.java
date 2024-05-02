/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationCMDBDAOSearchConfirmOthBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.15
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.10.15 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOSearchConfirmOthBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container confirm 시 이전 cycle과 비교
	  * </pre>
	  */
	public BLDocumentationCMDBDAOSearchConfirmOthBkgRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOSearchConfirmOthBkgRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("SELECT CASE WHEN SUBSTR(PRE_POR_CD, 1, 2) = SUBSTR(POR_CD, 1, 2) THEN 'N' ELSE 'Y' END ||" ).append("\n"); 
		query.append("       CASE WHEN PRE_BKG_STS_CD IN ('A','X')  THEN 'Y' ELSE 'N' END ||" ).append("\n"); 
		query.append("       CASE WHEN PRE_VVD = VVD THEN 'Y'" ).append("\n"); 
		query.append("            ELSE CASE WHEN PRE_CNTR_PRT_FLG = 'N' THEN 'N'" ).append("\n"); 
		query.append("                 ELSE 'Y'" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("       END ||" ).append("\n"); 
		query.append("       CASE WHEN PRE_BKG_CGO_TP_CD = 'P' THEN 'Y' ELSE 'N' END ||" ).append("\n"); 
		query.append("       CASE WHEN PRE_CNMV_STS_CD IN ('MT','XX') THEN 'Y' ELSE 'N' END AS POR_STS_VVD" ).append("\n"); 
		query.append("      ,PRE_POR_CD" ).append("\n"); 
		query.append("      ,PRE_BKG_STS_CD" ).append("\n"); 
		query.append("      ,PRE_VVD" ).append("\n"); 
		query.append("      ,PRE_BKG_NO" ).append("\n"); 
		query.append("      ,POR_CD" ).append("\n"); 
		query.append("      ,VVD" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,PRE_CNTR_PRT_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC(CTM XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("               BKG.POR_CD AS PRE_POR_CD" ).append("\n"); 
		query.append("              ,BKG.BKG_STS_CD AS PRE_BKG_STS_CD" ).append("\n"); 
		query.append("              ,BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD AS PRE_VVD" ).append("\n"); 
		query.append("              ,BKG.BKG_CGO_TP_CD AS PRE_BKG_CGO_TP_CD" ).append("\n"); 
		query.append("              ,CNTR.PRE_BKG_NO" ).append("\n"); 
		query.append("              ,CNTR.POR_CD" ).append("\n"); 
		query.append("              ,CNTR.VVD" ).append("\n"); 
		query.append("              ,CNTR.BKG_NO" ).append("\n"); 
		query.append("              ,CNTR.PRE_CNTR_PRT_FLG" ).append("\n"); 
		query.append("              ,CTM.MVMT_STS_CD AS PRE_CNMV_STS_CD                 " ).append("\n"); 
		query.append("          FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("              ,(SELECT /*+ INDEX_DESC(CNTR XAK1BKG_CONTAINER) */" ).append("\n"); 
		query.append("                       CNTR.BKG_NO AS PRE_BKG_NO" ).append("\n"); 
		query.append("                      ,BCNTR.CNTR_PRT_FLG AS PRE_CNTR_PRT_FLG" ).append("\n"); 
		query.append("                      ,CNTR.CNMV_STS_CD AS PRE_CNMV_STS_CD" ).append("\n"); 
		query.append("                      ,CNTR.CNMV_CYC_NO" ).append("\n"); 
		query.append("                      ,CNTR.CNTR_NO" ).append("\n"); 
		query.append("                      ,BKG.POR_CD" ).append("\n"); 
		query.append("                      ,BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                      ,BKG.BKG_NO" ).append("\n"); 
		query.append("                  FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("                      ,BKG_CNTR_HIS BCNTR" ).append("\n"); 
		query.append("                      ,BKG_BKG_HIS BKG" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND CNTR.CNMV_CYC_NO < BCNTR.CNMV_CYC_NO" ).append("\n"); 
		query.append("                   AND CNTR.CNTR_NO = BCNTR.CNTR_NO" ).append("\n"); 
		query.append("                   AND BCNTR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BCNTR.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                   AND BKG.BKG_NO = BCNTR.BKG_NO" ).append("\n"); 
		query.append("                   AND BKG.CORR_NO = BCNTR.CORR_NO" ).append("\n"); 
		query.append("                   AND CNTR.CNTR_DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND CNTR.BKG_NO <> BCNTR.BKG_NO" ).append("\n"); 
		query.append("				   AND NOT EXISTS ( SELECT 'X' " ).append("\n"); 
		query.append("									FROM BKG_BKG_HIS BK, BKG_CNTR_HIS BC" ).append("\n"); 
		query.append("									WHERE BK.FM_BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("									  AND BK.BL_NO_TP = '9'" ).append("\n"); 
		query.append("									  AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("									  AND BK.CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append("									  AND BC.CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append("									  AND BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("								   )" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) CNTR" ).append("\n"); 
		query.append("              ,CTM_MOVEMENT CTM" ).append("\n"); 
		query.append("         WHERE BKG.BKG_NO = CNTR.PRE_BKG_NO" ).append("\n"); 
		query.append("           AND CNTR.CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("           AND CNTR.CNMV_CYC_NO = CTM.CNMV_CYC_NO" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT CASE WHEN SUBSTR(PRE_POR_CD, 1, 2) = SUBSTR(POR_CD, 1, 2) THEN 'N' ELSE 'Y' END ||" ).append("\n"); 
		query.append("       CASE WHEN PRE_BKG_STS_CD IN ('A','X')  THEN 'Y' ELSE 'N' END ||" ).append("\n"); 
		query.append("       CASE WHEN PRE_VVD = VVD THEN 'Y'" ).append("\n"); 
		query.append("            ELSE CASE WHEN PRE_CNTR_PRT_FLG = 'N' THEN 'N'" ).append("\n"); 
		query.append("                 ELSE 'Y'" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("       END ||" ).append("\n"); 
		query.append("       CASE WHEN PRE_BKG_CGO_TP_CD = 'P' THEN 'Y' ELSE 'N' END ||" ).append("\n"); 
		query.append("       CASE WHEN PRE_CNMV_STS_CD IN ('MT','XX') THEN 'Y' ELSE 'N' END AS POR_STS_VVD" ).append("\n"); 
		query.append("      ,PRE_POR_CD" ).append("\n"); 
		query.append("      ,PRE_BKG_STS_CD" ).append("\n"); 
		query.append("      ,PRE_VVD" ).append("\n"); 
		query.append("      ,PRE_BKG_NO" ).append("\n"); 
		query.append("      ,POR_CD" ).append("\n"); 
		query.append("      ,VVD" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,PRE_CNTR_PRT_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC(CTM XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("               BKG.POR_CD AS PRE_POR_CD" ).append("\n"); 
		query.append("              ,BKG.BKG_STS_CD AS PRE_BKG_STS_CD" ).append("\n"); 
		query.append("              ,BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD AS PRE_VVD " ).append("\n"); 
		query.append("              ,BKG.BKG_CGO_TP_CD AS PRE_BKG_CGO_TP_CD" ).append("\n"); 
		query.append("              ,CNTR.PRE_BKG_NO" ).append("\n"); 
		query.append("              ,CNTR.POR_CD" ).append("\n"); 
		query.append("              ,CNTR.VVD" ).append("\n"); 
		query.append("              ,CNTR.BKG_NO" ).append("\n"); 
		query.append("              ,CNTR.PRE_CNTR_PRT_FLG" ).append("\n"); 
		query.append("              ,CTM.MVMT_STS_CD AS PRE_CNMV_STS_CD            " ).append("\n"); 
		query.append("          FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("              ,(SELECT /*+ INDEX_DESC(CNTR XAK1BKG_CONTAINER) */" ).append("\n"); 
		query.append("                       CNTR.BKG_NO AS PRE_BKG_NO" ).append("\n"); 
		query.append("                      ,BCNTR.CNTR_PRT_FLG AS PRE_CNTR_PRT_FLG" ).append("\n"); 
		query.append("                      ,CNTR.CNMV_STS_CD AS PRE_CNMV_STS_CD" ).append("\n"); 
		query.append("                      ,CNTR.CNMV_CYC_NO" ).append("\n"); 
		query.append("                      ,CNTR.CNTR_NO" ).append("\n"); 
		query.append("                      ,BKG.POR_CD" ).append("\n"); 
		query.append("                      ,BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                      ,BKG.BKG_NO" ).append("\n"); 
		query.append("                  FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("                      ,BKG_CONTAINER BCNTR" ).append("\n"); 
		query.append("                      ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND CNTR.CNMV_CYC_NO < BCNTR.CNMV_CYC_NO" ).append("\n"); 
		query.append("                   AND CNTR.CNTR_NO = BCNTR.CNTR_NO" ).append("\n"); 
		query.append("                   AND BCNTR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BCNTR.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                   AND BKG.BKG_NO = BCNTR.BKG_NO" ).append("\n"); 
		query.append("                   AND CNTR.CNTR_DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND CNTR.BKG_NO <> BCNTR.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) CNTR" ).append("\n"); 
		query.append("              ,CTM_MOVEMENT CTM" ).append("\n"); 
		query.append("         WHERE BKG.BKG_NO = CNTR.PRE_BKG_NO" ).append("\n"); 
		query.append("           AND CNTR.CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("           AND CNTR.CNMV_CYC_NO = CTM.CNMV_CYC_NO" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}