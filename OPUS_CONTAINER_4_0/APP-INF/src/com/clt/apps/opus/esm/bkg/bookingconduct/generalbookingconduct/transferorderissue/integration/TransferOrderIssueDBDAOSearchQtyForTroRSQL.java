/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchQtyForTroRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchQtyForTroRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BKG_0079_02A sum_qty
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchQtyForTroRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchQtyForTroRSQL").append("\n"); 
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
		query.append("SELECT CNTR_TPSZ_CD " ).append("\n"); 
		query.append("     , MAX(TOTAL_QTY) TOTAL_QTY" ).append("\n"); 
		query.append("     , SUM(TRO_QTY) TRO_QTY" ).append("\n"); 
		query.append("     , SUM(TRO_QTY_CH) TRO_QTY_CH" ).append("\n"); 
		query.append("     , SUM(TRO_QTY_MH) TRO_QTY_MH" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			, NVL(CEIL(QTY.OP_CNTR_QTY), 0) TOTAL_QTY" ).append("\n"); 
		query.append("			, NVL(SUM(GE_TRO.TRO_QTY), 0) TRO_QTY" ).append("\n"); 
		query.append("			, 0 TRO_QTY_CH" ).append("\n"); 
		query.append("			, 0 TRO_QTY_MH" ).append("\n"); 
		query.append("		FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("		   , BKG_TRO_DTL GE_TRO" ).append("\n"); 
		query.append("		WHERE QTY.BKG_NO       = GE_TRO.BKG_NO(+)" ).append("\n"); 
		query.append("		  AND QTY.CNTR_TPSZ_CD = GE_TRO.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("		  AND 'N'              = GE_TRO.RTN_TRO_FLG(+)" ).append("\n"); 
		query.append("		  AND 'N'              = GE_TRO.CXL_FLG(+)" ).append("\n"); 
		query.append("		  AND GE_TRO.IO_BND_CD(+) = @[io_bnd_cd]" ).append("\n"); 
		query.append("		  AND QTY.BKG_NO          = @[bkg_no] " ).append("\n"); 
		query.append("	      AND NOT EXISTS (SELECT 'Y' FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("                		  WHERE 1=1" ).append("\n"); 
		query.append("		                  AND GE_TRO.BKG_NO      = SO.BKG_NO" ).append("\n"); 
		query.append("         		          AND GE_TRO.TRO_SEQ     = SO.TRO_SEQ" ).append("\n"); 
		query.append("                		  AND GE_TRO.TRO_SUB_SEQ = SO.TRO_SUB_SEQ" ).append("\n"); 
		query.append("	                      AND 'O'                = SO.TRSP_BND_CD" ).append("\n"); 
		query.append("						  AND 'N'                = SO.DELT_FLG" ).append("\n"); 
		query.append("						  AND 'Y'                = SO.TRSP_FRST_FLG" ).append("\n"); 
		query.append("						  AND 'DR'               = SO.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("						  AND ROWNUM =1 " ).append("\n"); 
		query.append("						 )" ).append("\n"); 
		query.append("		GROUP BY QTY.CNTR_TPSZ_CD, QTY.OP_CNTR_QTY" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT QTY.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("       		   NVL(QTY.OP_CNTR_QTY, 0) TOTAL_QTY ," ).append("\n"); 
		query.append("		       0 TRO_QTY ," ).append("\n"); 
		query.append("		       SUM(DECODE(EU_TRO.HLG_TP_CD, 'C', 1, 0)) TRO_QTY_CH ," ).append("\n"); 
		query.append("		       SUM(DECODE(EU_TRO.HLG_TP_CD, 'M', 1, 0)) TRO_QTY_MH" ).append("\n"); 
		query.append("			   FROM BKG_QUANTITY QTY ," ).append("\n"); 
		query.append("		       (SELECT EUR.BKG_NO," ).append("\n"); 
		query.append("		               EUR.HLG_TP_CD," ).append("\n"); 
		query.append("		               DECODE(FLX.CNT, 1, DECODE(SUBSTR(EUR.CNTR_TPSZ_CD,1,1), 'D', FLX.TPSZ, EUR.CNTR_TPSZ_CD), EUR.CNTR_TPSZ_CD) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			           FROM BKG_EUR_TRO EUR," ).append("\n"); 
		query.append("		               (SELECT BB.BKG_NO," ).append("\n"); 
		query.append("		                       BQ.CNTR_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("		                       COUNT(1) OVER(PARTITION BY BB.BKG_NO) CNT" ).append("\n"); 
		query.append("	  	                  FROM BKG_BOOKING BB," ).append("\n"); 
		query.append("		                       BKG_QUANTITY BQ" ).append("\n"); 
		query.append("		                 WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		                   AND BB.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("		                   AND BB.FLEX_HGT_FLG = 'Y'" ).append("\n"); 
		query.append("		                   AND BQ.CNTR_TPSZ_CD IN ('D4', 'D5')) FLX" ).append("\n"); 
		query.append("		         WHERE EUR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        		   AND EUR.BKG_NO = FLX.BKG_NO(+)" ).append("\n"); 
		query.append("           		   AND FLX.CNT(+) = 1 " ).append("\n"); 
		query.append("		           AND EUR.CXL_FLG = 'N'" ).append("\n"); 
		query.append("		           AND EUR.EUR_TRNS_TP_CD IS NULL" ).append("\n"); 
		query.append("		           AND EUR.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("	           ) EU_TRO" ).append("\n"); 
		query.append("		 WHERE QTY.BKG_NO = EU_TRO.BKG_NO(+)" ).append("\n"); 
		query.append("		   AND QTY.CNTR_TPSZ_CD = EU_TRO.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("		   AND QTY.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		 GROUP BY QTY.CNTR_TPSZ_CD, QTY.OP_CNTR_QTY" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append(" -- ORDER BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append(" -- KOR추가 요건에 따른 조회 로직 추가 " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT GE_TRO.CNTR_TPSZ_CD CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	, 0 TOTAL_QTY" ).append("\n"); 
		query.append("	, NVL(SUM(GE_TRO.TRO_QTY), 0) TRO_QTY" ).append("\n"); 
		query.append("	, 0 TRO_QTY_CH" ).append("\n"); 
		query.append("	, 0 TRO_QTY_MH" ).append("\n"); 
		query.append("  FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("		, BKG_TRO_DTL GE_TRO" ).append("\n"); 
		query.append("  WHERE GE_TRO.BKG_NO  = QTY.BKG_NO(+)" ).append("\n"); 
		query.append("   	AND GE_TRO.CNTR_TPSZ_CD NOT IN (SELECT CNTR_TPSZ_CD FROM BKG_QUANTITY WHERE BKG_NO = @[bkg_no] )" ).append("\n"); 
		query.append("	AND 'N'              = GE_TRO.RTN_TRO_FLG" ).append("\n"); 
		query.append("	AND 'N'              = GE_TRO.CXL_FLG" ).append("\n"); 
		query.append("	AND GE_TRO.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("	AND GE_TRO.BKG_NO    = @[bkg_no] " ).append("\n"); 
		query.append("	GROUP BY  GE_TRO.CNTR_TPSZ_CD, QTY.OP_CNTR_QTY" ).append("\n"); 
		query.append("	ORDER BY CNTR_TPSZ_CD" ).append("\n"); 

	}
}