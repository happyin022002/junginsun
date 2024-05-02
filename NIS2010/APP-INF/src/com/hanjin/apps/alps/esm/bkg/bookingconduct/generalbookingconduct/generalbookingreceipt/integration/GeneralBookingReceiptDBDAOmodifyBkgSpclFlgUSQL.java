/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifyBkgSpclFlgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.20
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.06.20 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOmodifyBkgSpclFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBkgSpclFlg
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifyBkgSpclFlgUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifyBkgSpclFlgUSQL").append("\n"); 
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
		query.append("	UPDATE BKG_BKG_HIS SET " ).append("\n"); 
		query.append("	#if (${spcl_tp} == 'DG')" ).append("\n"); 
		query.append("		DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("		, STWG_CD = CASE WHEN (SELECT 'Y' " ).append("\n"); 
		query.append("                        		FROM BKG_DG_CGO_HIS DG, SCG_IMDG_UN_NO UN" ).append("\n"); 
		query.append("		                        WHERE DG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("								AND DG.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("		                        AND DG.IMDG_UN_NO = UN.IMDG_UN_NO" ).append("\n"); 
		query.append("		                        AND DG.IMDG_UN_NO_SEQ = UN.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("		                        AND UN.IMDG_STWG_CATE_CD IN ('C','D')" ).append("\n"); 
		query.append("		                        AND ROWNUM = 1) = 'Y' THEN 'OP'" ).append("\n"); 
		query.append("        	           ELSE STWG_CD END" ).append("\n"); 
		query.append("	#elseif (${spcl_tp} == 'RF')" ).append("\n"); 
		query.append("		RC_FLG = 'Y'" ).append("\n"); 
		query.append("	#elseif (${spcl_tp} == 'BB')" ).append("\n"); 
		query.append("		BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("	#elseif (${spcl_tp} == 'AWK')" ).append("\n"); 
		query.append("		AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UPDATE BKG_BOOKING SET " ).append("\n"); 
		query.append("	#if (${spcl_tp} == 'DG')" ).append("\n"); 
		query.append("		DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("		, STWG_CD = CASE WHEN (SELECT 'Y' " ).append("\n"); 
		query.append("                        		FROM BKG_DG_CGO DG, SCG_IMDG_UN_NO UN" ).append("\n"); 
		query.append("		                        WHERE DG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		                        AND DG.IMDG_UN_NO = UN.IMDG_UN_NO" ).append("\n"); 
		query.append("		                        AND DG.IMDG_UN_NO_SEQ = UN.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("		                        AND UN.IMDG_STWG_CATE_CD IN ('C','D')" ).append("\n"); 
		query.append("		                        AND ROWNUM = 1) = 'Y' THEN 'OP'" ).append("\n"); 
		query.append("        	           ELSE STWG_CD END" ).append("\n"); 
		query.append("	#elseif (${spcl_tp} == 'RF')" ).append("\n"); 
		query.append("		RC_FLG = 'Y'" ).append("\n"); 
		query.append("	#elseif (${spcl_tp} == 'BB')" ).append("\n"); 
		query.append("		BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("	#elseif (${spcl_tp} == 'AWK')" ).append("\n"); 
		query.append("		AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}