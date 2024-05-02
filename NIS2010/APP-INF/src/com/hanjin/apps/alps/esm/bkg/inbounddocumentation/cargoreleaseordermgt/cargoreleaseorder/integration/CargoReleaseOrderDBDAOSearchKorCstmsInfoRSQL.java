/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchKorCstmsInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchKorCstmsInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 한국세관 신고를 위한 B/L INFO를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchKorCstmsInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchKorCstmsInfoRSQL").append("\n"); 
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
		query.append("SELECT NVL(CMST.MF_REF_NO,' ')||NVL(CMST.MRN_CHK_NO,' ') AS MF_REF_NO             -- MRN NO " ).append("\n"); 
		query.append("     , NVL(CMST.MF_SEQ_NO,' ')                           AS MF_SEQ_NO             -- MSN NO" ).append("\n"); 
		query.append("     , NVL(CMST.CSTMS_CLR_TP_CD,' ')                     AS CSTMS_CLR_TP_CD" ).append("\n"); 
		query.append("     , NVL(CMST.CSTMS_CLR_LOC_CD,' ')                    AS CSTMS_CLR_LOC_CD" ).append("\n"); 
		query.append("     , NVL(CMST.CSTMS_CLR_WH_CD,' ')                     AS CSTMS_CLR_WH_CD       -- MSN_CSTMCWH  (WAREHOUSE_CD 보세구역 설령 특허 번호)" ).append("\n"); 
		query.append("     , NVL(CMST.CSTMS_DCHG_LOC_WH_CD,' ')                AS CSTMS_DCHG_LOC_WH_CD  -- MSN_DISCLOC" ).append("\n"); 
		query.append("     , NVL(LOC.LOC_NM,' ')                               AS LOC_NM                " ).append("\n"); 
		query.append("     , NVL(WH.WH_NM,' ')                                 AS WH_NM              " ).append("\n"); 
		query.append("     , NVL(CMST.KR_CSTMS_BL_TP_CD,'')                    AS KR_CSTMS_BL_TP_CD          " ).append("\n"); 
		query.append("  FROM ( SELECT MSN.BKG_NO                     AS BKG_NO    " ).append("\n"); 
		query.append("              , MRN.PORT_CD                    AS PORT_CD            " ).append("\n"); 
		query.append("              , MSN.MF_REF_NO                  AS MF_REF_NO" ).append("\n"); 
		query.append("              , MSN.MRN_CHK_NO                 AS MRN_CHK_NO" ).append("\n"); 
		query.append("              , MSN.MF_SEQ_NO                  AS MF_SEQ_NO " ).append("\n"); 
		query.append("              , MSN.CSTMS_CLR_WH_CD            AS CSTMS_CLR_WH_CD " ).append("\n"); 
		query.append("              , MSN.CSTMS_DCHG_LOC_WH_CD       AS CSTMS_DCHG_LOC_WH_CD " ).append("\n"); 
		query.append("              , MSN.CSTMS_CLR_TP_CD            AS CSTMS_CLR_TP_CD" ).append("\n"); 
		query.append("              , MSN.CSTMS_CLR_LOC_CD           AS CSTMS_CLR_LOC_CD" ).append("\n"); 
		query.append("              , MSN.VSL_CD                     AS VSL_CD          " ).append("\n"); 
		query.append("              , MSN.SKD_VOY_NO                 AS SKD_VOY_NO   " ).append("\n"); 
		query.append("              , MSN.SKD_DIR_CD                 AS SKD_DIR_CD   " ).append("\n"); 
		query.append("              , BKG.SLAN_CD                    AS SLAN_CD" ).append("\n"); 
		query.append("              , MSN.KR_CSTMS_BL_TP_CD          AS KR_CSTMS_BL_TP_CD" ).append("\n"); 
		query.append("           FROM BKG_BOOKING            BKG" ).append("\n"); 
		query.append("              , BKG_CSTMS_KR_MF_REF_NO MRN" ).append("\n"); 
		query.append("              , BKG_CSTMS_KR_MF_SEQ_NO MSN" ).append("\n"); 
		query.append("          WHERE BKG.BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("            AND MSN.BKG_NO         = BKG.BKG_NO" ).append("\n"); 
		query.append("            AND MSN.MF_CFM_FLG     = 'Y'" ).append("\n"); 
		query.append("            AND MSN.MRN_BL_TS_CD  = 'I'" ).append("\n"); 
		query.append("            AND MSN.CFM_DT         = ( SELECT MAX(SEQ.CFM_DT) " ).append("\n"); 
		query.append("                                       FROM BKG_CSTMS_KR_MF_SEQ_NO SEQ" ).append("\n"); 
		query.append("                                       WHERE SEQ.BKG_NO     = @[bkg_no] " ).append("\n"); 
		query.append("                                       AND   SEQ.MF_CFM_FLG  = 'Y'" ).append("\n"); 
		query.append("                                       AND   SEQ.MRN_BL_TS_CD  = 'I' )          " ).append("\n"); 
		query.append("            AND MRN.VSL_CD         = MSN.VSL_CD" ).append("\n"); 
		query.append("            AND MRN.SKD_VOY_NO     = MSN.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND MRN.SKD_DIR_CD     = MSN.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND MRN.MRN_NO         = MSN.MF_REF_NO" ).append("\n"); 
		query.append("            AND MRN.MRN_CHK_NO     = MSN.MRN_CHK_NO" ).append("\n"); 
		query.append("       ) CMST" ).append("\n"); 
		query.append("     , BKG_DCHG_LOC LOC" ).append("\n"); 
		query.append("     , BKG_WAREHOUSE WH" ).append("\n"); 
		query.append(" WHERE LOC.OTR_DCHG_CD(+) = CMST.CSTMS_DCHG_LOC_WH_CD  " ).append("\n"); 
		query.append("   AND WH.CSTMS_CD(+)     = CMST.CSTMS_CLR_WH_CD  " ).append("\n"); 
		query.append("   AND WH.CNT_CD(+)      = 'KR'      " ).append("\n"); 
		query.append("   AND ROWNUM             = 1" ).append("\n"); 

	}
}