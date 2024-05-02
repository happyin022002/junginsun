/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgCntcPsonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.26 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistBkgCntcPsonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgCntcPsonRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgCntcPsonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_mphn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntc_pson_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cntc_pson_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgCntcPsonRSQL").append("\n"); 
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
		query.append("WITH OLD_CNTC AS" ).append("\n"); 
		query.append("(SELECT @[bkg_no] BKG_NO" ).append("\n"); 
		query.append(", @[bkg_cntc_pson_tp_cd] BKG_CNTC_PSON_TP_CD" ).append("\n"); 
		query.append(", @[cntc_pson_nm] CNTC_PSON_NM" ).append("\n"); 
		query.append(", @[cntc_pson_phn_no] CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append(", @[cntc_pson_mphn_no] CNTC_PSON_MPHN_NO" ).append("\n"); 
		query.append(", @[cntc_pson_fax_no] CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append(", @[cntc_pson_eml] CNTC_PSON_EML" ).append("\n"); 
		query.append(", @[diff_rmk] DIFF_RMK" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append(", PRE_CTNT" ).append("\n"); 
		query.append(", CRNT_CTNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DECODE(NOW_CNTC.BKG_CNTC_PSON_TP_CD, 'BK', 'BOOKING ', 'S/I ')||'CONTACT' HIS_CATE_NM" ).append("\n"); 
		query.append(", OLD_CNTC.CNTC_PSON_NM||" ).append("\n"); 
		query.append("'/'||OLD_CNTC.CNTC_PSON_PHN_NO||" ).append("\n"); 
		query.append("'/'||OLD_CNTC.CNTC_PSON_MPHN_NO||" ).append("\n"); 
		query.append("'/'||OLD_CNTC.CNTC_PSON_FAX_NO||" ).append("\n"); 
		query.append("'/'||OLD_CNTC.CNTC_PSON_EML PRE_CTNT" ).append("\n"); 
		query.append(", NOW_CNTC.CNTC_PSON_NM||" ).append("\n"); 
		query.append("'/'||NOW_CNTC.CNTC_PSON_PHN_NO||" ).append("\n"); 
		query.append("'/'||NOW_CNTC.CNTC_PSON_MPHN_NO||" ).append("\n"); 
		query.append("'/'||NOW_CNTC.CNTC_PSON_FAX_NO||" ).append("\n"); 
		query.append("'/'||NOW_CNTC.CNTC_PSON_EML CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD_CNTC" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", BKG_CNTC_PSON_HIS NOW_CNTC" ).append("\n"); 
		query.append("WHERE NOW_CNTC.BKG_NO              = OLD_CNTC.BKG_NO" ).append("\n"); 
		query.append("AND NOW_CNTC.CORR_NO             = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", BKG_CNTC_PSON NOW_CNTC" ).append("\n"); 
		query.append("WHERE NOW_CNTC.BKG_NO              = OLD_CNTC.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NOW_CNTC.BKG_CNTC_PSON_TP_CD = OLD_CNTC.BKG_CNTC_PSON_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}