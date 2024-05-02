/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : CargoReleaseOrderDBDAOSearchEdiIdDoCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.08
*@LastModifier : 
*@LastVersion : 1.0
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

public class CargoReleaseOrderDBDAOSearchEdiIdDoCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Container 정보를 조회한다
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdiIdDoCntrInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdiIdDoCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT   '{CNTR_INFO'   || CHR(10)" ).append("\n"); 
		query.append("      || 'CNTR_NO:'     || CNTR_NO || CHR(10)" ).append("\n"); 
		query.append("      || 'SIZE_TYPE:'   || CNTR_TPSZ_CD || CHR(10)" ).append("\n"); 
		query.append("      || 'DMIF_END_DT:' || FREE_TIME_END || CHR(10)" ).append("\n"); 
		query.append("      || 'DTIC_END_DT:' || CHR(10)" ).append("\n"); 
		query.append("      || 'DT_FT_DAYS:'  || CHR(10)" ).append("\n"); 
		query.append("      || '}CNTR_INFO'   || CHR(10)" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("      SELECT CNTR.CNTR_NO" ).append("\n"); 
		query.append("           , BCNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           , SEAL.CNTR_SEAL_NO" ).append("\n"); 
		query.append("           , NVL(DMFT.FREE_TIME_END" ).append("\n"); 
		query.append("                , DECODE(SUBSTR(BKGM.DEL_CD, 1,2)" ).append("\n"); 
		query.append("                         , 'KR', TO_CHAR(VSKD.VPS_ETA_DT + DECODE(SUBSTR(BCNTR.CNTR_TPSZ_CD,1,1),'R',5,8), 'YYYY.MM.DD')" ).append("\n"); 
		query.append("                         , NULL" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                ) AS FREE_TIME_END" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("              SELECT DCNT.BKG_NO, DCNT.CNTR_NO" ).append("\n"); 
		query.append("                FROM BKG_DO BKDO " ).append("\n"); 
		query.append("                   , BKG_DO_CNTR DCNT " ).append("\n"); 
		query.append("               WHERE BKDO.DO_NO = SUBSTR(@[do_no],1,10) " ).append("\n"); 
		query.append("                 AND BKDO.DO_NO_SPLIT = DECODE(NVL(SUBSTR(@[do_no],11,2), '00'), '00', 'X', NVL(SUBSTR(@[do_no],11,2), '00')) " ).append("\n"); 
		query.append("                 AND DCNT.BKG_NO = BKDO.BKG_NO " ).append("\n"); 
		query.append("                 AND DCNT.RLSE_SEQ = BKDO.RLSE_SEQ " ).append("\n"); 
		query.append("              UNION ALL " ).append("\n"); 
		query.append("              SELECT BCNT.BKG_NO, BCNT.CNTR_NO" ).append("\n"); 
		query.append("                FROM BKG_DO BKDO " ).append("\n"); 
		query.append("                   , BKG_CONTAINER BCNT " ).append("\n"); 
		query.append("               WHERE BKDO.DO_NO = SUBSTR(@[do_no],1,10) " ).append("\n"); 
		query.append("                 AND BKDO.DO_NO_SPLIT = DECODE(NVL(SUBSTR(@[do_no],11,2), '00'), '00', '00', 'X') " ).append("\n"); 
		query.append("                 AND BCNT.BKG_NO = BKDO.BKG_NO " ).append("\n"); 
		query.append("              ) CNTR" ).append("\n"); 
		query.append("           , BKG_CNTR_SEAL_NO SEAL" ).append("\n"); 
		query.append("           , BKG_BOOKING BKGM" ).append("\n"); 
		query.append("           , BKG_VVD BVVD" ).append("\n"); 
		query.append("           , VSK_VSL_PORT_SKD VSKD" ).append("\n"); 
		query.append("           , BKG_CONTAINER  BCNTR" ).append("\n"); 
		query.append("           , (SELECT C.CNTR_NO" ).append("\n"); 
		query.append("                   , MAX(DECODE(NVL(INVM1.DMDT_AR_IF_CD, 'N'),'Y', TO_CHAR(TO_MVMT_DT, 'YYYYMMDD')," ).append("\n"); 
		query.append("                                                              'N', TO_CHAR(FT_END_DT,  'YYYYMMDD')))   AS FREE_TIME_END" ).append("\n"); 
		query.append("              FROM    DMT_CHG_CALC    C," ).append("\n"); 
		query.append("                      DMT_INV_MN  INVM1" ).append("\n"); 
		query.append("              WHERE   (SYS_AREA_GRP_ID,CNTR_NO,CNTR_CYC_NO) IN" ).append("\n"); 
		query.append("                      ( SELECT SYS_AREA_GRP_ID,CNTR_NO,CNTR_CYC_NO " ).append("\n"); 
		query.append("                          FROM DMT_CHG_BKG_CNTR " ).append("\n"); 
		query.append("                         WHERE BKG_NO = (SELECT BKG_NO" ).append("\n"); 
		query.append("                                           FROM BKG_DO" ).append("\n"); 
		query.append("                                          WHERE DO_NO = SUBSTR(@[do_no], 1,10)" ).append("\n"); 
		query.append("                                            AND DO_NO_SPLIT = NVL(SUBSTR(@[do_no],11,2), '00'))" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("              AND     C.DMDT_INV_NO = INVM1.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               AND C.DMDT_CHG_STS_CD IN ('F', 'C', 'I', 'L', 'N', 'U')  " ).append("\n"); 
		query.append("               AND (    ( C.DMDT_TRF_CD = 'DMIF'  AND C.DMDT_CHG_LOC_DIV_CD = 'POD')" ).append("\n"); 
		query.append("                     OR ( C.DMDT_TRF_CD = 'CTIC'  AND C.DMDT_CHG_LOC_DIV_CD = 'DEL')" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("               AND NOT (C.DUL_TP_EXPT_FLG  = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'D')" ).append("\n"); 
		query.append("               AND C.DMDT_CHG_LOC_DIV_CD <> 'SZP'   " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("--              AND     C.SYS_AREA_GRP_ID = 'KOR'  -- 한국만 적용되는 것 아님" ).append("\n"); 
		query.append("              GROUP BY C.CNTR_NO, C.CNTR_CYC_NO, C.DMDT_TRF_CD " ).append("\n"); 
		query.append("             ) DMFT" ).append("\n"); 
		query.append("       WHERE BKGM.BKG_NO = (SELECT BKG_NO" ).append("\n"); 
		query.append("                              FROM BKG_DO" ).append("\n"); 
		query.append("                             WHERE DO_NO = SUBSTR(@[do_no], 1,10)" ).append("\n"); 
		query.append("                               AND DO_NO_SPLIT = NVL(SUBSTR(@[do_no],11,2), '00'))" ).append("\n"); 
		query.append("         AND BVVD.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("         AND BVVD.POD_CD = BKGM.POD_CD" ).append("\n"); 
		query.append("         AND VSKD.VSL_CD(+) = BVVD.VSL_CD" ).append("\n"); 
		query.append("         AND VSKD.SKD_VOY_NO(+) = BVVD.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND VSKD.SKD_DIR_CD(+) = BVVD.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND VSKD.VPS_PORT_CD(+) = BVVD.POD_CD" ).append("\n"); 
		query.append("         AND VSKD.CLPT_IND_SEQ(+) = BVVD.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("         AND SEAL.BKG_NO(+) = CNTR.BKG_NO" ).append("\n"); 
		query.append("         AND SEAL.CNTR_NO(+) = CNTR.CNTR_NO" ).append("\n"); 
		query.append("         AND DMFT.CNTR_NO(+) = SEAL.CNTR_NO" ).append("\n"); 
		query.append("         AND CNTR.BKG_NO  = BCNTR.BKG_NO" ).append("\n"); 
		query.append("         AND CNTR.CNTR_NO = BCNTR.CNTR_NO" ).append("\n"); 
		query.append("       ORDER BY CNTR_NO, CNTR_SEAL_SEQ" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}