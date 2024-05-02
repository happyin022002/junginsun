/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchMissingDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.07
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.06.07 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchMissingDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * missing되거나 비정상적으로 입력된 data에 대해서 오류 message를 조회한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchMissingDataRSQL(){
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
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchMissingDataRSQL").append("\n"); 
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
		query.append("SELECT MESSAGE" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("	(SELECT 'Deleted commodity code.' MESSAGE" ).append("\n"); 
		query.append("	  FROM MDM_COMMODITY" ).append("\n"); 
		query.append("	 WHERE CMDT_CD = @[cmdt_cd] " ).append("\n"); 
		query.append("	   AND DELT_FLG = 'Y'" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	SELECT 'Invalid sales rep code.' MESSAGE" ).append("\n"); 
		query.append("	  FROM DUAL" ).append("\n"); 
		query.append("	 WHERE upper(@[ob_srep_cd]) NOT IN (SELECT UPPER(SREP_CD) FROM MDM_SLS_REP WHERE DELT_FLG = 'N')" ).append("\n"); 
		query.append("#if (${qty_modify_flag} == 'Y' || ${route_modify_flag} == 'Y')" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	SELECT 'TRO volume'" ).append("\n"); 
		query.append("	  FROM BKG_QUANTITY QTY, " ).append("\n"); 
		query.append("	        (SELECT BK.BKG_NO, TRO.CNTR_TPSZ_CD, COUNT(1) TRO_QTY" ).append("\n"); 
		query.append("	           FROM BKG_BOOKING BK, BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("	          WHERE BK.BKG_NO = TRO.BKG_NO" ).append("\n"); 
		query.append("	            AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				AND TRO.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("	            AND TRO.CXL_FLG = 'N'" ).append("\n"); 
		query.append("                AND TRO.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("				AND TRO.HLG_TP_CD = 'C'" ).append("\n"); 
		query.append("			    AND TRO.EUR_TRNS_TP_CD IS NULL " ).append("\n"); 
		query.append("				AND SUBSTR(BK.POL_CD, 1, 2) NOT IN ('CA','US')" ).append("\n"); 
		query.append("	          GROUP BY BK.BKG_NO, TRO.CNTR_TPSZ_CD) TRO" ).append("\n"); 
		query.append("	 WHERE QTY.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("	   AND QTY.BKG_NO       = TRO.BKG_NO" ).append("\n"); 
		query.append("	   AND QTY.CNTR_TPSZ_CD = TRO.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	   AND CEIL(QTY.OP_CNTR_QTY) < NVL(TRO_QTY, 0)" ).append("\n"); 
		query.append("	UNION ALL   " ).append("\n"); 
		query.append("	SELECT 'TRO volume'" ).append("\n"); 
		query.append("	  FROM BKG_BOOKING BK, BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("	 WHERE BK.BKG_NO = TRO.BKG_NO" ).append("\n"); 
		query.append("	   AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	   AND TRO.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("	   AND TRO.CXL_FLG = 'N'" ).append("\n"); 
		query.append("       AND TRO.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("	   AND TRO.HLG_TP_CD = 'C'" ).append("\n"); 
		query.append("	   AND TRO.EUR_TRNS_TP_CD IS NULL " ).append("\n"); 
		query.append("	   AND SUBSTR(BK.POL_CD, 1, 2) NOT IN ('CA','US')" ).append("\n"); 
		query.append("	   AND TRO.CNTR_TPSZ_CD NOT IN (SELECT CNTR_TPSZ_CD " ).append("\n"); 
		query.append("	                                  FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("	                                 WHERE QTY.BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	SELECT 'TRO volume'" ).append("\n"); 
		query.append("	  FROM BKG_QUANTITY QTY," ).append("\n"); 
		query.append("	        (SELECT BK.BKG_NO, TRO.CNTR_TPSZ_CD, COUNT(1) TRO_QTY" ).append("\n"); 
		query.append("	           FROM BKG_BOOKING BK, BKG_TRO_DTL TRO, BKG_TRO TRO_MST" ).append("\n"); 
		query.append("	          WHERE BK.BKG_NO = TRO.BKG_NO" ).append("\n"); 
		query.append("	            AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(" 				AND BK.BKG_NO           = TRO_MST.BKG_NO" ).append("\n"); 
		query.append("				AND TRO_MST.TRO_SEQ     = TRO.TRO_SEQ" ).append("\n"); 
		query.append("				AND TRO_MST.IO_BND_CD   = TRO.IO_BND_CD" ).append("\n"); 
		query.append("				AND TRO_MST.RTN_TRO_FLG = TRO.RTN_TRO_FLG" ).append("\n"); 
		query.append("				AND TRO_MST.IO_BND_CD   = 'O'" ).append("\n"); 
		query.append("       			AND TRO_MST.RTN_TRO_FLG = 'N'" ).append("\n"); 
		query.append("	            AND TRO_MST.CXL_FLG     = 'N'" ).append("\n"); 
		query.append("                AND TRO_MST.CFM_FLG     = 'Y'" ).append("\n"); 
		query.append("			    AND TRO.CXL_FLG         = 'N'" ).append("\n"); 
		query.append("				--AND SUBSTR(BK.POL_CD, 1, 2) NOT IN ('CA','US')" ).append("\n"); 
		query.append("	          GROUP BY BK.BKG_NO, TRO.CNTR_TPSZ_CD) TRO" ).append("\n"); 
		query.append("	 WHERE QTY.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("	   AND QTY.BKG_NO       = TRO.BKG_NO" ).append("\n"); 
		query.append("	   AND QTY.CNTR_TPSZ_CD = TRO.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	   AND CEIL(QTY.OP_CNTR_QTY) < NVL(TRO_QTY, 0)" ).append("\n"); 
		query.append("	UNION ALL   " ).append("\n"); 
		query.append("	SELECT 'TRO volume'" ).append("\n"); 
		query.append("	  FROM BKG_BOOKING BK, BKG_TRO_DTL TRO, BKG_TRO TRO_MST" ).append("\n"); 
		query.append("	 WHERE BK.BKG_NO = TRO.BKG_NO" ).append("\n"); 
		query.append("	   AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	   AND BK.BKG_NO           = TRO_MST.BKG_NO" ).append("\n"); 
		query.append("	   AND TRO_MST.TRO_SEQ     = TRO.TRO_SEQ" ).append("\n"); 
		query.append("	   AND TRO_MST.IO_BND_CD   = TRO.IO_BND_CD" ).append("\n"); 
		query.append("	   AND TRO_MST.RTN_TRO_FLG = TRO.RTN_TRO_FLG" ).append("\n"); 
		query.append("	   AND TRO_MST.IO_BND_CD   = 'O'" ).append("\n"); 
		query.append("       AND TRO_MST.RTN_TRO_FLG = 'N'" ).append("\n"); 
		query.append("	   AND TRO_MST.CXL_FLG     = 'N'" ).append("\n"); 
		query.append("       AND TRO_MST.CFM_FLG     = 'Y'" ).append("\n"); 
		query.append("	   AND TRO.CXL_FLG         = 'N'" ).append("\n"); 
		query.append("	   AND SUBSTR(BK.POL_CD, 1, 2) NOT IN ('CA','US')" ).append("\n"); 
		query.append("	   AND TRO.CNTR_TPSZ_CD NOT IN (SELECT CNTR_TPSZ_CD " ).append("\n"); 
		query.append("	                                  FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("	                                 WHERE QTY.BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("    SELECT 'Please, check S/O('|| MAX(SUB.CNTR_TPSZ_CD) || DECODE( MAX(SUB.CNTR_TPSZ_CD), MIN(SUB.CNTR_TPSZ_CD), '', '(' ||  MIN(SUB.CNTR_TPSZ_CD) || ') ') ||'X'||SUM(SUB.SO_COUNT)||')' AS MSG" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT BKG_NO" ).append("\n"); 
		query.append("                  ,EQ_TPSZ_CD    CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  ,0             OP_CNTR_QTY" ).append("\n"); 
		query.append("                  ,COUNT(*)      SO_COUNT" ).append("\n"); 
		query.append("                  , 0            CNTR_ADJ_QTY" ).append("\n"); 
		query.append("              FROM TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("             WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               AND A.TRSP_BND_CD = 'O'" ).append("\n"); 
		query.append("               AND NVL(A.TRSP_FRST_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("               AND A.TRSP_COST_DTL_MOD_CD = 'DR'" ).append("\n"); 
		query.append("               AND A.TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("             GROUP BY BKG_NO" ).append("\n"); 
		query.append("                  ,EQ_TPSZ_CD" ).append("\n"); 
		query.append("             UNION ALL" ).append("\n"); 
		query.append("            SELECT QTY.BKG_NO" ).append("\n"); 
		query.append("                  ,QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  ,QTY.OP_CNTR_QTY" ).append("\n"); 
		query.append("                  ,0 SO_COUNT" ).append("\n"); 
		query.append("                  , 0            CNTR_ADJ_QTY" ).append("\n"); 
		query.append("             FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("            WHERE QTY.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            select BKG_NO" ).append("\n"); 
		query.append("                  ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  , 0 OP_CNTR_QTY" ).append("\n"); 
		query.append("                  ,0 SO_COUNT" ).append("\n"); 
		query.append("                  , nvl(sum(CNTR_VOL_QTY),1) - count(1) CNTR_ADJ_QTY" ).append("\n"); 
		query.append("            from bkg_container" ).append("\n"); 
		query.append("            where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("            group by BKG_NO" ).append("\n"); 
		query.append("                    ,CNTR_TPSZ_CD            " ).append("\n"); 
		query.append("           ) SUB" ).append("\n"); 
		query.append("          ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("          ,SCE_COP_CNTR_REPO_RULE RUL -- SCE Rule Table" ).append("\n"); 
		query.append("     WHERE BKG.BKG_NO = SUB.BKG_NO" ).append("\n"); 
		query.append("       AND RUL.CNTR_TPSZ_CD(+) = SUB.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       AND RUL.ACT_FLG(+) = 'Y'" ).append("\n"); 
		query.append("       AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                     FROM BKG_HRD_CDG_CTNT ON_OFF" ).append("\n"); 
		query.append("                    WHERE ON_OFF.HRD_CDG_ID = 'BKG_VALIDATION'" ).append("\n"); 
		query.append("                      AND ON_OFF.ATTR_CTNT1 = 'SO_TPSZ_CD_COUNT_VALIDATION'" ).append("\n"); 
		query.append("                      AND ON_OFF.ATTR_CTNT2 = 'ON')" ).append("\n"); 
		query.append("     GROUP BY DECODE(BKG.FLEX_HGT_FLG, 'Y', GREATEST(SUB.CNTR_TPSZ_CD, NVL(RUL.PROV_CNTR_TPSZ_CD, ' ')), SUB.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("     HAVING NVL(SUM(OP_CNTR_QTY), 0) < (NVL(SUM(SO_COUNT), 0) + nvl(sum(CNTR_ADJ_QTY), 0))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	UNION ALL   " ).append("\n"); 
		query.append("	SELECT 'Please check AK or B/B column to proceed'" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BKG_HIS BB, BKG_QTY_HIS BQ, BKG_HRD_CDG_CTNT BHCC" ).append("\n"); 
		query.append("	 WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("       AND BB.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("	   AND BB.CORR_NO = BQ.CORR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BB, BKG_QUANTITY BQ, BKG_HRD_CDG_CTNT BHCC" ).append("\n"); 
		query.append("	 WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	   AND BB.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("       AND BHCC.HRD_CDG_ID = 'SPECIAL_CARGO'" ).append("\n"); 
		query.append("       AND BHCC.ATTR_CTNT1 = 'BKG_AWK_CGO'" ).append("\n"); 
		query.append("       AND BQ.CNTR_TPSZ_CD = BHCC.ATTR_CTNT2" ).append("\n"); 
		query.append("       AND DECODE(BB.AWK_CGO_FLG,'N', BB.BB_CGO_FLG, BB.AWK_CGO_FLG ) = 'N'" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT SPCL_TPSZ||' remains in Special Cargo Application. Please cancel and delete special cargo request for '''||SPCL_TPSZ||''' before deleting '''||SPCL_TPSZ||''' in BKG main'" ).append("\n"); 
		query.append("      FROM " ).append("\n"); 
		query.append("		   (SELECT SPCL.CNTR_TPSZ_CD SPCL_TPSZ, QTY.CNTR_TPSZ_CD QTY_TPSZ" ).append("\n"); 
		query.append("	     	  FROM (SELECT BKG_NO, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("	                  FROM BKG_DG_CGO_HIS" ).append("\n"); 
		query.append("	                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("					   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	                  FROM BKG_DG_CGO" ).append("\n"); 
		query.append("	                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					   AND CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("					   AND NVL(SPCL_CGO_APRO_CD, 'X') <> 'C'" ).append("\n"); 
		query.append("	                 UNION ALL" ).append("\n"); 
		query.append("	                SELECT BKG_NO, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("	                  FROM BKG_RF_CGO_HIS" ).append("\n"); 
		query.append("	                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("					   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	                  FROM BKG_RF_CGO" ).append("\n"); 
		query.append("	                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					   AND CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("					   AND NVL(SPCL_CGO_APRO_CD, 'X') <> 'C'" ).append("\n"); 
		query.append("	                 UNION ALL" ).append("\n"); 
		query.append("	                SELECT BKG_NO, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("	                  FROM BKG_AWK_CGO_HIS" ).append("\n"); 
		query.append("	                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("					   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	                  FROM BKG_AWK_CGO" ).append("\n"); 
		query.append("	                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					   AND CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("					   AND NVL(SPCL_CGO_APRO_CD, 'X') <> 'C'" ).append("\n"); 
		query.append("	                 UNION ALL" ).append("\n"); 
		query.append("	                SELECT BKG_NO, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("	                  FROM BKG_CNTR_HIS " ).append("\n"); 
		query.append("	                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("					 AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	                  FROM BKG_CONTAINER" ).append("\n"); 
		query.append("	                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	                   AND BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("					   AND CNTR_TPSZ_CD IS NOT NULL) SPCL" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("				 , BKG_QTY_HIS QTY" ).append("\n"); 
		query.append("			 WHERE SPCL.BKG_NO = QTY.BKG_NO(+)" ).append("\n"); 
		query.append("		       AND 'TMP0000001' = QTY.CORR_NO(+)" ).append("\n"); 
		query.append("			   AND NOT EXISTS (SELECT 'X' FROM BKG_QTY_HIS BQ WHERE SPCL.BKG_NO = BQ.BKG_NO AND 'TMP0000001' = BQ.CORR_NO AND BQ.FLEX_HGT_FLG = 'Y')" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("			     , BKG_QUANTITY QTY" ).append("\n"); 
		query.append("			 WHERE SPCL.BKG_NO = QTY.BKG_NO(+)" ).append("\n"); 
		query.append("			 AND NOT EXISTS (SELECT 'X' FROM BKG_QUANTITY BQ WHERE SPCL.BKG_NO = BQ.BKG_NO AND BQ.FLEX_HGT_FLG = 'Y')" ).append("\n"); 
		query.append("#end	   " ).append("\n"); 
		query.append("			   AND SPCL.CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("		  )" ).append("\n"); 
		query.append("	 WHERE QTY_TPSZ IS NULL" ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append(" WHERE ROWNUM = 1" ).append("\n"); 

	}
}