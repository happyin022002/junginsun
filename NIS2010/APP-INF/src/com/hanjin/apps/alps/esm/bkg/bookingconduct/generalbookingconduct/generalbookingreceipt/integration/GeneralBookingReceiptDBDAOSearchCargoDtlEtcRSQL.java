/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchCargoDtlEtcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.18 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimByungKyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchCargoDtlEtcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cargo Detail 시 Booking Flag 조회
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchCargoDtlEtcRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOSearchCargoDtlEtcRSQL").append("\n"); 
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
		query.append("select    bkg_no" ).append("\n"); 
		query.append(", dcgo_flg" ).append("\n"); 
		query.append(", rc_flg" ).append("\n"); 
		query.append(", awk_cgo_flg" ).append("\n"); 
		query.append(", bb_cgo_flg" ).append("\n"); 
		query.append(", hngr_flg" ).append("\n"); 
		query.append(", eq_subst_flg" ).append("\n"); 
		query.append(", soc_flg" ).append("\n"); 
		query.append(", decode(decode(rcv_term_cd, 'M', 'M', 'X'), 'M', 'Y'" ).append("\n"); 
		query.append(",  decode(decode(de_term_cd,  'M', 'M', 'X'), 'M', 'Y', 'N')) mixed_flg" ).append("\n"); 
		query.append(", nvl((SELECT 'Y'" ).append("\n"); 
		query.append("FROM BKG_DOC_PROC_SKD skd" ).append("\n"); 
		query.append("WHERE skd.BKG_NO = bk.bkg_No" ).append("\n"); 
		query.append("and skd.BKG_DOC_PROC_TP_CD = 'CNTCFM'" ).append("\n"); 
		query.append("and skd.DOC_PERF_DELT_FLG = 'N'), 'N') cntr_cfrm_flg" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("from bkg_bkg_his bk" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("from bkg_booking bk" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}