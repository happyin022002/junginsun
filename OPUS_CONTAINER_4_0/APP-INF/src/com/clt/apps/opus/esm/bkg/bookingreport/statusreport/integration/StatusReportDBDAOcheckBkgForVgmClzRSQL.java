/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatusReportDBDAOcheckBkgForVgmClzRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOcheckBkgForVgmClzRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check Booking for VGM CLZ
	  * </pre>
	  */
	public StatusReportDBDAOcheckBkgForVgmClzRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOcheckBkgForVgmClzRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN CNTR_CNT = COP_CNT THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N' " ).append("\n"); 
		query.append("            END VGM_CLZ_YN" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(SELECT COUNT(1) CNTR_CNT" ).append("\n"); 
		query.append("   FROM BKG_CONTAINER BC" ).append("\n"); 
		query.append("  WHERE BC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND EXISTS (SELECT 'Y' " ).append("\n"); 
		query.append("                  FROM BKG_XTER_VGM VGM" ).append("\n"); 
		query.append("                 WHERE BC.BKG_NO = VGM.BKG_NO" ).append("\n"); 
		query.append("                   AND BC.CNTR_NO = VGM.CNTR_NO" ).append("\n"); 
		query.append("                   AND VGM.VGM_CRE_GDT = (SELECT MAX(VGM_CRE_GDT)" ).append("\n"); 
		query.append("                                            FROM BKG_XTER_VGM" ).append("\n"); 
		query.append("                                           WHERE BKG_NO = VGM.BKG_NO" ).append("\n"); 
		query.append("                                             AND CNTR_NO = VGM.CNTR_NO" ).append("\n"); 
		query.append("                                             AND ACT_TP_CD = 'I')" ).append("\n"); 
		query.append("                   AND VGM.VGM_WGT IS NOT NULL" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT 'Y'" ).append("\n"); 
		query.append("                  FROM BKG_XTER_VGM_REF_NO REFNO" ).append("\n"); 
		query.append("                 WHERE BC.BKG_NO = REFNO.REF_NO" ).append("\n"); 
		query.append("                   AND BC.CNTR_NO = REFNO.CNTR_NO" ).append("\n"); 
		query.append("                   AND NVL(REFNO.XTER_REF_SEQ, 0) = NVL((SELECT MAX(XTER_REF_SEQ)" ).append("\n"); 
		query.append("                                                           FROM BKG_XTER_VGM_REF_NO" ).append("\n"); 
		query.append("                                                          WHERE REFNO.XTER_SNDR_ID = XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                            AND REFNO.XTER_VGM_DOC_ID = XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                                                            AND REFNO.XTER_VGM_RQST_SEQ = XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                                                            AND REFNO.CNTR_NO = CNTR_NO), 0)" ).append("\n"); 
		query.append("                   AND EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("                                 FROM BKG_XTER_VGM_RQST" ).append("\n"); 
		query.append("                                WHERE REFNO.XTER_SNDR_ID = XTER_SNDR_ID" ).append("\n"); 
		query.append("                                  AND REFNO.XTER_VGM_DOC_ID = XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                                  AND REFNO.XTER_VGM_RQST_SEQ = XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                                  AND REFNO.CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("                                  AND VGM_WGT IS NOT NULL)" ).append("\n"); 
		query.append("                   )) CNTR_CNT," ).append("\n"); 
		query.append("(SELECT COUNT(1) COP_CNT" ).append("\n"); 
		query.append("   FROM SCE_COP_HDR" ).append("\n"); 
		query.append("  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND COP_STS_CD <> 'X') COP_CNT" ).append("\n"); 

	}
}