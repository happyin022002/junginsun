/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchOpusDgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.26
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2015.11.26 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchOpusDgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOpusDg
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchOpusDgRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchOpusDgRSQL").append("\n"); 
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
		query.append("SELECT DG.BKG_NO" ).append("\n"); 
		query.append("     , DG.DCGO_SEQ" ).append("\n"); 
		query.append("     , DG.DG_CNTR_SEQ" ).append("\n"); 
		query.append("     , DG.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("     , DG.CNTR_NO" ).append("\n"); 
		query.append("     , DG.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , DG.IMDG_UN_NO" ).append("\n"); 
		query.append("     , DG.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("     , DG.IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , DECODE(DG.SPCL_CGO_APRO_CD, 'Y', 'Approved', 'N', 'Rejected', 'R', 'Requested', 'New') STATUS" ).append("\n"); 
		query.append("     , DG.SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("     , DG.PRP_SHP_NM" ).append("\n"); 
		query.append("     , DG.HZD_DESC" ).append("\n"); 
		query.append("     , DG.FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("     , DG.IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("     , DG.MRN_POLUT_FLG" ).append("\n"); 
		query.append("     , DG.EMER_CNTC_PSON_NM AS EMER_CNTC_PNT_CTNT" ).append("\n"); 
		query.append("     , DG.DCGO_STS_CD" ).append("\n"); 
		query.append("     , DG.IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("     , DG.SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append("     , DG.GRS_WGT" ).append("\n"); 
		query.append("     , DG.NET_WGT" ).append("\n"); 
		query.append("     , DG.WGT_UT_CD" ).append("\n"); 
		query.append("     , DECODE(NVL(IMG_SEQ, 0), 0, 'N', 'Y') DG_RIDER --DG RIDER 색표시 여부" ).append("\n"); 
		query.append("     , MA.DG_CNTR_SEQ AS MAX_DG_CNTR_SEQ" ).append("\n"); 
		query.append("     , MA.CNTR_CGO_SEQ AS MAX_CNTR_CGO_SEQ" ).append("\n"); 
		query.append("     , DG.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("     , DG.EMER_CNTC_PHN_NO_CTNT" ).append("\n"); 
		query.append("     , DG.IMDG_AMDT_NO" ).append("\n"); 
		query.append("  FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("     ,(SELECT MAX(IMG_SEQ) IMG_SEQ, DG.BKG_NO, DG.DCGO_SEQ" ).append("\n"); 
		query.append("         FROM BKG_IMG_STO IMG, BKG_DG_CGO DG" ).append("\n"); 
		query.append("        WHERE DG.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("          AND DG.BKG_NO   = IMG.BKG_NO" ).append("\n"); 
		query.append("          AND 'D'         = IMG.RIDR_TP_CD" ).append("\n"); 
		query.append("          AND DG.DCGO_SEQ = IMG.DCGO_SEQ" ).append("\n"); 
		query.append("     GROUP BY DG.BKG_NO, DG.DCGO_SEQ" ).append("\n"); 
		query.append("       ) IMG" ).append("\n"); 
		query.append("     ,(SELECT MAX(DG_CNTR_SEQ) DG_CNTR_SEQ, MAX(CNTR_CGO_SEQ) CNTR_CGO_SEQ, CNTR_NO" ).append("\n"); 
		query.append("         FROM BKG_DG_CGO" ).append("\n"); 
		query.append("        WHERE BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("     GROUP BY CNTR_NO" ).append("\n"); 
		query.append("       ) MA" ).append("\n"); 
		query.append(" WHERE DG.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("   AND DG.BKG_NO = IMG.BKG_NO(+)" ).append("\n"); 
		query.append("   AND DG.DCGO_SEQ = IMG.DCGO_SEQ(+)" ).append("\n"); 
		query.append("   AND DG.CNTR_NO = MA.CNTR_NO(+)" ).append("\n"); 
		query.append("ORDER BY DG.DCGO_SEQ" ).append("\n"); 

	}
}