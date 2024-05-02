/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOCntrTypzQtyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.23
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2014.12.23 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOCntrTypzQtyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CntrTypzQtyVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOCntrTypzQtyVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOCntrTypzQtyVORSQL").append("\n"); 
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
		query.append("#if (${spcl_tp} == 'AWK')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT B1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		,B1.OP_CNTR_QTY" ).append("\n"); 
		query.append("		,B2.AWK_CGO_QTY		" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("	SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,SUM(A1.OP_CNTR_QTY) AS OP_CNTR_QTY" ).append("\n"); 
		query.append("	FROM BKG_QTY_HIS A1" ).append("\n"); 
		query.append("	WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("	GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	) B1," ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,SUM(A1.OP_CNTR_QTY) AS AWK_CGO_QTY" ).append("\n"); 
		query.append("	FROM BKG_QTY_DTL_HIS A1" ).append("\n"); 
		query.append("	WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	and CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("	AND  AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("	GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	) B2" ).append("\n"); 
		query.append("	WHERE B1.CNTR_TPSZ_CD = B2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT B1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    	  ,B1.OP_CNTR_QTY" ).append("\n"); 
		query.append("      	  ,B2.AWK_CGO_QTY		  " ).append("\n"); 
		query.append("  	FROM (" ).append("\n"); 
		query.append("        SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,SUM(A1.OP_CNTR_QTY) AS OP_CNTR_QTY" ).append("\n"); 
		query.append("          FROM BKG_QUANTITY A1" ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ) B1," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,SUM(A1.OP_CNTR_QTY) AS AWK_CGO_QTY" ).append("\n"); 
		query.append("          FROM BKG_QTY_DTL A1		  " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		 AND  AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("         GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ) B2" ).append("\n"); 
		query.append(" 	WHERE B1.CNTR_TPSZ_CD = B2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${spcl_tp} == 'DG')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT B1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			  ,B1.OP_CNTR_QTY" ).append("\n"); 
		query.append("			  ,B2.DCGO_QTY" ).append("\n"); 
		query.append("			  ,(select substr(CNTR_TPSZ_DESC, 1, 4) from mdm_cntr_tp_sz where cntr_tpsz_cd = B1.CNTR_TPSZ_CD) EQ_TPSZ" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("			SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				,SUM(A1.OP_CNTR_QTY) AS OP_CNTR_QTY" ).append("\n"); 
		query.append("			FROM BKG_QTY_HIS A1" ).append("\n"); 
		query.append("			WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("			AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("			GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			) B1," ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("			SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				,SUM(A1.OP_CNTR_QTY) AS DCGO_QTY" ).append("\n"); 
		query.append("			FROM BKG_QTY_DTL_HIS A1" ).append("\n"); 
		query.append("			WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("			AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("			AND  DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("			GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			) B2" ).append("\n"); 
		query.append("			WHERE B1.CNTR_TPSZ_CD = B2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT B1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    	  	  ,B1.OP_CNTR_QTY" ).append("\n"); 
		query.append("      	  	  ,B2.DCGO_QTY" ).append("\n"); 
		query.append("			  ,(select substr(CNTR_TPSZ_DESC, 1, 4) from mdm_cntr_tp_sz where cntr_tpsz_cd = B1.CNTR_TPSZ_CD) EQ_TPSZ" ).append("\n"); 
		query.append("  		FROM (" ).append("\n"); 
		query.append("        	SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            	  ,SUM(A1.OP_CNTR_QTY) AS OP_CNTR_QTY" ).append("\n"); 
		query.append("          	FROM BKG_QUANTITY A1" ).append("\n"); 
		query.append("         	WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         	GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       		) B1," ).append("\n"); 
		query.append("       		(" ).append("\n"); 
		query.append("        	SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            	  ,SUM(A1.OP_CNTR_QTY) AS DCGO_QTY" ).append("\n"); 
		query.append("          	FROM BKG_QTY_DTL A1" ).append("\n"); 
		query.append("         	WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		 	AND   DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("         	GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       		) B2" ).append("\n"); 
		query.append(" 			WHERE B1.CNTR_TPSZ_CD = B2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${spcl_tp} == 'RF')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT B1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			,B1.OP_CNTR_QTY" ).append("\n"); 
		query.append("			,B2.RF_CGO_QTY			" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("			SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			,SUM(A1.OP_CNTR_QTY) AS OP_CNTR_QTY" ).append("\n"); 
		query.append("		FROM BKG_QTY_HIS A1" ).append("\n"); 
		query.append("		WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("		GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		) B1," ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		,SUM(A1.OP_CNTR_QTY) AS RF_CGO_QTY" ).append("\n"); 
		query.append("		FROM BKG_QTY_DTL_HIS A1" ).append("\n"); 
		query.append("		WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		and CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("		AND  RC_FLG = 'Y'" ).append("\n"); 
		query.append("		GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		) B2" ).append("\n"); 
		query.append("		WHERE B1.CNTR_TPSZ_CD = B2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT B1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      	  ,B1.OP_CNTR_QTY" ).append("\n"); 
		query.append("      	  ,B2.RF_CGO_QTY		  " ).append("\n"); 
		query.append("  	FROM (" ).append("\n"); 
		query.append("    	SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,SUM(A1.OP_CNTR_QTY) AS OP_CNTR_QTY" ).append("\n"); 
		query.append("         FROM BKG_QUANTITY A1" ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ) B1," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,SUM(A1.OP_CNTR_QTY) AS RF_CGO_QTY" ).append("\n"); 
		query.append("         FROM BKG_QTY_DTL A1" ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		 AND   RC_FLG = 'Y'" ).append("\n"); 
		query.append("         GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ) B2" ).append("\n"); 
		query.append(" 		WHERE B1.CNTR_TPSZ_CD = B2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${spcl_tp} == 'BB')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT B1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			,B1.OP_CNTR_QTY" ).append("\n"); 
		query.append("			,B2.BB_CGO_QTY			" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("			SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			,SUM(A1.OP_CNTR_QTY) AS OP_CNTR_QTY" ).append("\n"); 
		query.append("		FROM BKG_QTY_HIS A1" ).append("\n"); 
		query.append("		WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("		GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		) B1," ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		,SUM(A1.OP_CNTR_QTY) AS BB_CGO_QTY" ).append("\n"); 
		query.append("		FROM BKG_QTY_DTL_HIS A1" ).append("\n"); 
		query.append("		WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		and CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("		AND  BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("		GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		) B2" ).append("\n"); 
		query.append("		WHERE B1.CNTR_TPSZ_CD = B2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT B1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    		  ,B1.OP_CNTR_QTY" ).append("\n"); 
		query.append("      	  	  ,B2.BB_CGO_QTY			  	" ).append("\n"); 
		query.append("  		FROM (" ).append("\n"); 
		query.append("        	SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            	,SUM(A1.OP_CNTR_QTY) AS OP_CNTR_QTY" ).append("\n"); 
		query.append("          	FROM BKG_QUANTITY A1" ).append("\n"); 
		query.append("         	WHERE BKG_NO = @[bkg_no]		" ).append("\n"); 
		query.append("         	GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       		) B1," ).append("\n"); 
		query.append("       		(" ).append("\n"); 
		query.append("        	SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            	,SUM(A1.OP_CNTR_QTY) AS BB_CGO_QTY" ).append("\n"); 
		query.append("          	FROM BKG_QTY_DTL A1" ).append("\n"); 
		query.append("         	WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		 	AND   BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("         	GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       		) B2" ).append("\n"); 
		query.append(" 		WHERE B1.CNTR_TPSZ_CD = B2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${spcl_tp} == 'SS')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT B1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			,B1.OP_CNTR_QTY		" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("			SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			,SUM(A1.OP_CNTR_QTY) AS OP_CNTR_QTY" ).append("\n"); 
		query.append("		FROM BKG_QTY_HIS A1" ).append("\n"); 
		query.append("		WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("		GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		) B1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT B1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    		  ,B1.OP_CNTR_QTY		  	" ).append("\n"); 
		query.append("  		FROM (" ).append("\n"); 
		query.append("        	SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            	,SUM(A1.OP_CNTR_QTY) AS OP_CNTR_QTY" ).append("\n"); 
		query.append("          	FROM BKG_QUANTITY A1" ).append("\n"); 
		query.append("         	WHERE BKG_NO = @[bkg_no]		" ).append("\n"); 
		query.append("         	GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       		) B1" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}