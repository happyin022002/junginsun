/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchBkgQuantityVOInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchBkgQuantityVOInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 BkgQuantityVO 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchBkgQuantityVOInterfaceRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchBkgQuantityVOInterfaceRSQL").append("\n"); 
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
		query.append("SELECT @[bkg_no] BKG_NO," ).append("\n"); 
		query.append("       'U' IBFLAG," ).append("\n"); 
		query.append("        CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       SUM(TRO_QTY) OB_TRO_QTY" ).append("\n"); 
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
		query.append("		  AND GE_TRO.IO_BND_CD(+) = 'O'" ).append("\n"); 
		query.append("		  AND QTY.BKG_NO          = @[bkg_no] " ).append("\n"); 
		query.append("		GROUP BY QTY.CNTR_TPSZ_CD, QTY.OP_CNTR_QTY" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			 , NVL(QTY.OP_CNTR_QTY, 0) TOTAL_QTY" ).append("\n"); 
		query.append("			 , 0 TRO_QTY" ).append("\n"); 
		query.append("			 , SUM(DECODE(EU_TRO.HLG_TP_CD, 'C', 1, 0)) TRO_QTY_CH" ).append("\n"); 
		query.append("			 , SUM(DECODE(EU_TRO.HLG_TP_CD, 'M', 1, 0)) TRO_QTY_MH" ).append("\n"); 
		query.append("		FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("		   , BKG_EUR_TRO EU_TRO" ).append("\n"); 
		query.append("		WHERE QTY.BKG_NO       = EU_TRO.BKG_NO(+)" ).append("\n"); 
		query.append("		  AND QTY.CNTR_TPSZ_CD = EU_TRO.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("		  AND 'N'              = EU_TRO.CXL_FLG(+)" ).append("\n"); 
		query.append("		  AND EU_TRO.EUR_TRNS_TP_CD(+) IS NULL" ).append("\n"); 
		query.append("		  AND EU_TRO.IO_BND_CD(+) = 'O'" ).append("\n"); 
		query.append("		  AND QTY.BKG_NO          = @[bkg_no] " ).append("\n"); 
		query.append("		GROUP BY QTY.CNTR_TPSZ_CD, QTY.OP_CNTR_QTY" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT @[bkg_no] BKG_NO," ).append("\n"); 
		query.append("       'U' IBFLAG," ).append("\n"); 
		query.append("       GE_TRO.CNTR_TPSZ_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       NVL(SUM(GE_TRO.TRO_QTY), 0) OB_TRO_QTY" ).append("\n"); 
		query.append("  FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("		, BKG_TRO_DTL GE_TRO" ).append("\n"); 
		query.append("  WHERE GE_TRO.BKG_NO  = QTY.BKG_NO(+)" ).append("\n"); 
		query.append("   	AND GE_TRO.CNTR_TPSZ_CD NOT IN (SELECT CNTR_TPSZ_CD FROM BKG_QUANTITY WHERE BKG_NO = @[bkg_no] )" ).append("\n"); 
		query.append("	AND 'N'              = GE_TRO.RTN_TRO_FLG" ).append("\n"); 
		query.append("	AND 'N'              = GE_TRO.CXL_FLG" ).append("\n"); 
		query.append("	AND GE_TRO.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("	AND GE_TRO.BKG_NO    = @[bkg_no] " ).append("\n"); 
		query.append("	GROUP BY  GE_TRO.CNTR_TPSZ_CD, QTY.OP_CNTR_QTY" ).append("\n"); 
		query.append("	ORDER BY CNTR_TPSZ_CD" ).append("\n"); 

	}
}