/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistNewBkgQtyDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.27
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.11.27 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistNewBkgQtyDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistNewBkgQtyDtlRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistNewBkgQtyDtlRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistNewBkgQtyDtlRSQL").append("\n"); 
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
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append("     , PRE_CTNT" ).append("\n"); 
		query.append("     , CRNT_CTNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT 'Volume Detail' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CNTR_TPSZ_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.OP_CNTR_QTY||" ).append("\n"); 
		query.append("                  '/'||NOW.RCV_TERM_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.DE_TERM_CD||" ).append("\n"); 
		query.append("                  '/D:'||NOW.DCGO_FLG||" ).append("\n"); 
		query.append("                  '/R:'||NOW.RC_FLG||" ).append("\n"); 
		query.append("                  '/A:'||NOW.AWK_CGO_FLG||" ).append("\n"); 
		query.append("                  '/B:'||NOW.BB_CGO_FLG||" ).append("\n"); 
		query.append("                  '/'||NOW.EQ_SUBST_CNTR_TPSZ_CD CRNT_CTNT           " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_QTY_DTL_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_QTY_DTL NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, CNTR_TPSZ_CD, SUBST_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end 		" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("        SELECT 'Hanger Vol' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CNTR_TPSZ_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.OP_CNTR_QTY||" ).append("\n"); 
		query.append("                  '/Merchant:'||NOW.MER_HNGR_FLG||" ).append("\n"); 
		query.append("                  '/Carrier:'||" ).append("\n"); 
		query.append("                  '(s:'||NOW.CRR_HNGR_SGL_BAR_USE_FLG||" ).append("\n"); 
		query.append("                  '/d:'||NOW.CRR_HNGR_DBL_BAR_USE_FLG||" ).append("\n"); 
		query.append("                  '/t:'||NOW.CRR_HNGR_TPL_BAR_USE_FLG||')' CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_QTY_DTL_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = @[bkg_no]" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO     (+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_QTY_DTL NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		   AND (NOW.CRR_HNGR_FLG = 'Y' OR NOW.MER_HNGR_FLG = 'Y' OR NOW.CRR_HNGR_SGL_BAR_USE_FLG = 'Y' OR NOW.CRR_HNGR_DBL_BAR_USE_FLG = 'Y' OR NOW.CRR_HNGR_TPL_BAR_USE_FLG = 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, CNTR_TPSZ_CD, SUBST_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end 		" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(" WHERE CRNT_CTNT IS NOT NULL" ).append("\n"); 

	}
}