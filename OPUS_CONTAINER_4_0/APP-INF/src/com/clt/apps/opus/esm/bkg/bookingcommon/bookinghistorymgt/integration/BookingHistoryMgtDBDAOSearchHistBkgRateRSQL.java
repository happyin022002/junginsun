/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistBkgRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgRateRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_rcv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_payr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_payr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_payr_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_payr_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rt_aply_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgRateRSQL").append("\n"); 
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
		query.append("     , DECODE(PRE_CTNT, '/0', NULL, PRE_CTNT) PRE_CTNT" ).append("\n"); 
		query.append("     , CRNT_CTNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT 'PPD' HIS_CATE_NM" ).append("\n"); 
		query.append("                , @[ppd_rcv_ofc_cd]||" ).append("\n"); 
		query.append("                  '/'||@[ppd_payr_cnt_cd]||@[ppd_payr_cust_seq] PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.PPD_RCV_OFC_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.PPD_PAYR_CNT_CD||NOW.PPD_PAYR_CUST_SEQ CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_RT_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO(+)  = @[bkg_no]" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO(+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_RATE NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO(+) = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'CCT' HIS_CATE_NM" ).append("\n"); 
		query.append("                , @[clt_ofc_cd]||" ).append("\n"); 
		query.append("                  '/'||@[clt_payr_cnt_cd]||@[clt_payr_cust_seq] PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CLT_OFC_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.CLT_PAYR_CNT_CD||NOW.CLT_PAYR_CUST_SEQ CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_RT_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO(+)  = @[bkg_no]" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO(+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_RATE NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO(+) = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'APPLICABLE DATE' HIS_CATE_NM" ).append("\n"); 
		query.append("                , REPLACE(SUBSTR(@[rt_aply_dt], 0, 10), '-', '') PRE_CTNT" ).append("\n"); 
		query.append("                , TO_CHAR(NOW.RT_APLY_DT, 'YYYYMMDD') CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_RT_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO(+)  = @[bkg_no]" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO(+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_RATE NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO(+) = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'FREIGHT TERM' HIS_CATE_NM" ).append("\n"); 
		query.append("                , DECODE(@[frt_term_cd], 'P', 'PPD', 'C', 'CCT') PRE_CTNT" ).append("\n"); 
		query.append("                , DECODE(NOW.FRT_TERM_CD, 'P', 'PPD', 'C', 'CCT') CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_RT_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO(+)  = @[bkg_no]" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO(+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_RATE NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO(+) = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'DOC Adjustment' HIS_CATE_NM" ).append("\n"); 
		query.append("                , @[doc_loc_cd] PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.DOC_LOC_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_RT_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO(+)  = @[bkg_no]" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO(+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_RATE NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO(+) = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    )    " ).append("\n"); 
		query.append(" WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}