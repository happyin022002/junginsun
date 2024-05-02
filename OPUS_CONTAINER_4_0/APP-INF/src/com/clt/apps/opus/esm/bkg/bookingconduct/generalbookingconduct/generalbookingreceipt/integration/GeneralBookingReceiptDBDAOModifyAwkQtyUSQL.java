/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyAwkQtyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyAwkQtyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyAwkQty
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyAwkQtyUSQL(){
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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyAwkQtyUSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UPDATE BKG_QTY_HIS SET" ).append("\n"); 
		query.append("	#if (${spcl_tp} == 'DG')" ).append("\n"); 
		query.append("		DCGO_QTY = NVL(( SELECT SUM(CNTR_VOL_QTY)" ).append("\n"); 
		query.append("   						FROM (" ).append("\n"); 
		query.append("								SELECT 	ROW_NUMBER() OVER (PARTITION BY BKG_NO, CNTR_TPSZ_CD, DG_CNTR_SEQ ORDER BY CNTR_CGO_SEQ) AS RN" ).append("\n"); 
		query.append("      									,CNTR_VOL_QTY" ).append("\n"); 
		query.append("								FROM 	BKG_DG_CGO_HIS" ).append("\n"); 
		query.append("								WHERE 	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("								AND		CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("								AND 	NVL(SPCL_CGO_APRO_CD, ' ') <>'C'" ).append("\n"); 
		query.append("								AND 	CORR_NO = 'TMP0000001') " ).append("\n"); 
		query.append("						WHERE RN = 1 ),0)" ).append("\n"); 
		query.append("	#elseif (${spcl_tp} == 'RF')" ).append("\n"); 
		query.append("		RC_QTY = NVL(( SELECT SUM(CNTR_VOL_QTY)" ).append("\n"); 
		query.append("				     FROM BKG_RF_CGO_HIS" ).append("\n"); 
		query.append("					WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                      AND CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("                      AND CORR_NO = 'TMP0000001' ),0)" ).append("\n"); 
		query.append("	#elseif (${spcl_tp} == 'BB')" ).append("\n"); 
		query.append("		BB_CGO_QTY = NVL(( SELECT SUM(CNTR_VOL_QTY)" ).append("\n"); 
		query.append("					     FROM BKG_BB_CGO_HIS" ).append("\n"); 
		query.append("					    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                          AND CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("                          AND CORR_NO = 'TMP0000001' ),0)" ).append("\n"); 
		query.append("	#elseif (${spcl_tp} == 'AWK')" ).append("\n"); 
		query.append("		AWK_CGO_QTY = NVL(( SELECT SUM(CNTR_VOL_QTY)" ).append("\n"); 
		query.append("					      FROM BKG_AWK_CGO_HIS" ).append("\n"); 
		query.append("					     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                           AND CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("                           AND CORR_NO = 'TMP0000001' ),0)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND	CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("	AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UPDATE BKG_QUANTITY SET " ).append("\n"); 
		query.append("	#if (${spcl_tp} == 'DG')" ).append("\n"); 
		query.append("		DCGO_QTY = NVL((SELECT SUM(CNTR_VOL_QTY)" ).append("\n"); 
		query.append("   						FROM (" ).append("\n"); 
		query.append("								SELECT 	ROW_NUMBER() OVER (PARTITION BY BKG_NO, CNTR_TPSZ_CD, DG_CNTR_SEQ ORDER BY CNTR_CGO_SEQ) AS RN" ).append("\n"); 
		query.append("      									,CNTR_VOL_QTY" ).append("\n"); 
		query.append("								FROM 	BKG_DG_CGO" ).append("\n"); 
		query.append("								WHERE 	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("								AND		CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("								AND 	NVL(SPCL_CGO_APRO_CD, ' ') <>'C')" ).append("\n"); 
		query.append("						WHERE RN = 1),0)" ).append("\n"); 
		query.append("	#elseif (${spcl_tp} == 'RF')" ).append("\n"); 
		query.append("	    RC_QTY = NVL(( SELECT SUM(CNTR_VOL_QTY)" ).append("\n"); 
		query.append("				     FROM BKG_RF_CGO" ).append("\n"); 
		query.append("					WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                      AND CNTR_TPSZ_CD = @[cntr_tpsz_cd]),0)" ).append("\n"); 
		query.append("	#elseif (${spcl_tp} == 'BB')" ).append("\n"); 
		query.append("		BB_CGO_QTY = NVL(( SELECT SUM(CNTR_VOL_QTY)" ).append("\n"); 
		query.append("					     FROM BKG_BB_CGO" ).append("\n"); 
		query.append("					    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                          AND CNTR_TPSZ_CD = @[cntr_tpsz_cd]),0)" ).append("\n"); 
		query.append("	#elseif (${spcl_tp} == 'AWK')" ).append("\n"); 
		query.append("		AWK_CGO_QTY = NVL(( SELECT SUM(CNTR_VOL_QTY)" ).append("\n"); 
		query.append("					      FROM BKG_AWK_CGO" ).append("\n"); 
		query.append("					     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                           AND CNTR_TPSZ_CD = @[cntr_tpsz_cd]),0)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND	CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}