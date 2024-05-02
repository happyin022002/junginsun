/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchNisTroDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.27
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.07.27 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchNisTroDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchNisTroDtl
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchNisTroDtlRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOsearchNisTroDtlRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT TRO_SEQ" ).append("\n"); 
		query.append("                , TRO_SUB_SEQ" ).append("\n"); 
		query.append("                , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                , TRO_QTY" ).append("\n"); 
		query.append("                , TO_CHAR(DTL.DOR_ARR_DT, 'YYYY-MM-DD HH24:MI') DOR_ARR_DT" ).append("\n"); 
		query.append("                , PKUP_LOC_CD" ).append("\n"); 
		query.append("                , SUBSTR(PKUP_YD_CD, 6, 2) PKUP_YD_CD" ).append("\n"); 
		query.append("                , RTN_LOC_CD" ).append("\n"); 
		query.append("                , SUBSTR(RTN_YD_CD, 6, 2) RTN_YD_CD" ).append("\n"); 
		query.append("                , NVL(DTL.CXL_FLG, 'N') CXL_FLG  " ).append("\n"); 
		query.append("			    , TO_CHAR(null, 'YYYY-MM-DD HH24:MI') RTN_DT" ).append("\n"); 
		query.append("				, '' DOR_ADDR_TP_CD" ).append("\n"); 
		query.append("                , '' BKG_TRSP_MZD_CD" ).append("\n"); 
		query.append("          FROM BKG_TRO_DTL DTL" ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND IO_BND_CD = 'O'" ).append("\n"); 
		query.append("           AND RTN_TRO_FLG = 'N'" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT DISTINCT MST.TRO_SEQ" ).append("\n"); 
		query.append("                , DTL.TRO_SUB_SEQ" ).append("\n"); 
		query.append("                , MST.CNTR_TPSZ_CD TPSZ" ).append("\n"); 
		query.append("                , 1 TRO_QTY " ).append("\n"); 
		query.append("                , TO_CHAR(DTL.ARR_DT, 'YYYY-MM-DD HH24:MI') ARR_DT" ).append("\n"); 
		query.append("                , SUBSTR(MST.CNTR_PKUP_YD_CD, 1, 5) PKUP_LOC" ).append("\n"); 
		query.append("                , SUBSTR(MST.CNTR_PKUP_YD_CD, 6, 2) PKUP_CY" ).append("\n"); 
		query.append("                , SUBSTR(MST.CNTR_RTN_YD_CD,  1, 5) RTN_LOC" ).append("\n"); 
		query.append("                , SUBSTR(MST.CNTR_RTN_YD_CD,  6, 2) RTN_CY" ).append("\n"); 
		query.append("                , 'N' CXL_FLG " ).append("\n"); 
		query.append("				, cntr_rtn_dt as RTN_DT" ).append("\n"); 
		query.append("                , DOR_ADDR_TP_CD" ).append("\n"); 
		query.append("                , BKG_TRSP_MZD_CD" ).append("\n"); 
		query.append("          FROM BKG_EUR_TRO     MST" ).append("\n"); 
		query.append("             , BKG_EUR_TRO_DTL DTL" ).append("\n"); 
		query.append("         WHERE MST.BKG_NO    = DTL.BKG_NO" ).append("\n"); 
		query.append("           AND MST.IO_BND_CD = DTL.IO_BND_CD" ).append("\n"); 
		query.append("           AND MST.TRO_SEQ   = DTL.TRO_SEQ" ).append("\n"); 
		query.append("           AND MST.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("           AND MST.BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" ORDER BY TRO_SEQ, TRO_SUB_SEQ" ).append("\n"); 

	}
}