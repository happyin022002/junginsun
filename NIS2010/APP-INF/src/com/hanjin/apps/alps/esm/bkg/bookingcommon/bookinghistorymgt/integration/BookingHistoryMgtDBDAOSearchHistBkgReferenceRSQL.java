/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgReferenceRSQL.java
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

public class BookingHistoryMgtDBDAOSearchHistBkgReferenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgReferenceRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgReferenceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cpy_desc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ref_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgReferenceRSQL").append("\n"); 
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
		query.append("WITH OLD_REF AS" ).append("\n"); 
		query.append("(SELECT @[bkg_no] BKG_NO" ).append("\n"); 
		query.append(", @[ref_seq] REF_SEQ" ).append("\n"); 
		query.append(", @[bkg_ref_tp_cd] BKG_REF_TP_CD" ).append("\n"); 
		query.append(", @[cust_ref_no_ctnt] CUST_REF_NO_CTNT" ).append("\n"); 
		query.append(", @[cntr_no] CNTR_NO" ).append("\n"); 
		query.append(", @[cntr_mf_seq] CNTR_MF_SEQ" ).append("\n"); 
		query.append(", @[cpy_desc_flg] CPY_DESC_FLG" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append(", PRE_CTNT" ).append("\n"); 
		query.append(", CRNT_CTNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01658' AND NOW_REF.BKG_REF_TP_CD = INTG_CD_VAL_CTNT) HIS_CATE_NM" ).append("\n"); 
		query.append(", OLD_REF.CNTR_NO||" ).append("\n"); 
		query.append("'/'||OLD_REF.CUST_REF_NO_CTNT PRE_CTNT" ).append("\n"); 
		query.append(", NOW_REF.CNTR_NO||" ).append("\n"); 
		query.append("'/'||NOW_REF.CUST_REF_NO_CTNT CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD_REF" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", BKG_REF_HIS NOW_REF" ).append("\n"); 
		query.append("WHERE NOW_REF.BKG_NO (+) = OLD_REF.BKG_NO" ).append("\n"); 
		query.append("AND NOW_REF.CORR_NO(+) = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", BKG_REFERENCE NOW_REF" ).append("\n"); 
		query.append("WHERE NOW_REF.BKG_NO (+) = OLD_REF.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NOW_REF.REF_SEQ(+) = OLD_REF.REF_SEQ" ).append("\n"); 
		query.append("AND OLD_REF.CNTR_NO IS NOT NULL" ).append("\n"); 
		query.append("AND NOW_REF.CNTR_NO IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01658' AND NOW_REF.BKG_REF_TP_CD = INTG_CD_VAL_CTNT) HIS_CATE_NM" ).append("\n"); 
		query.append(", OLD_REF.CUST_REF_NO_CTNT PRE_CTNT" ).append("\n"); 
		query.append(", NOW_REF.CUST_REF_NO_CTNT CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD_REF" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", BKG_REF_HIS NOW_REF" ).append("\n"); 
		query.append("WHERE NOW_REF.BKG_NO (+) = OLD_REF.BKG_NO" ).append("\n"); 
		query.append("AND NOW_REF.CORR_NO(+) = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", BKG_REFERENCE NOW_REF" ).append("\n"); 
		query.append("WHERE NOW_REF.BKG_NO (+) = OLD_REF.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NOW_REF.REF_SEQ(+) = OLD_REF.REF_SEQ" ).append("\n"); 
		query.append("AND OLD_REF.CNTR_NO IS NULL" ).append("\n"); 
		query.append("AND NOW_REF.CNTR_NO IS NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}