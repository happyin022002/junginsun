/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.21 
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

public class BookingHistoryMgtDBDAOSearchHistBkgCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgCustomerRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eori_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_zip_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_cust_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cty_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_decl_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("addr_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("an_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtch_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_dp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eur_cstms_st_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgCustomerRSQL").append("\n"); 
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
		query.append("WITH OLD_CUST AS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[bkg_no] BKG_NO" ).append("\n"); 
		query.append(", @[bkg_cust_tp_cd] BKG_CUST_TP_CD" ).append("\n"); 
		query.append(", @[cust_cnt_cd] CUST_CNT_CD" ).append("\n"); 
		query.append(", @[cust_seq] CUST_SEQ" ).append("\n"); 
		query.append(", @[cust_nm] CUST_NM" ).append("\n"); 
		query.append(", @[cust_addr] CUST_ADDR" ).append("\n"); 
		query.append(", @[cust_cty_nm] CUST_CTY_NM" ).append("\n"); 
		query.append(", @[cust_ste_cd] CUST_STE_CD" ).append("\n"); 
		query.append(", @[cstms_decl_cnt_cd] CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append(", @[cust_zip_id] CUST_ZIP_ID" ).append("\n"); 
		query.append(", @[cust_fax_no] CUST_FAX_NO" ).append("\n"); 
		query.append(", @[cust_eml] CUST_EML" ).append("\n"); 
		query.append(", @[cust_tp_cd] CUST_TP_CD" ).append("\n"); 
		query.append(", @[ref_no] REF_NO" ).append("\n"); 
		query.append(", @[addr_prn_flg] ADDR_PRN_FLG" ).append("\n"); 
		query.append(", @[val_nm] VAL_NM" ).append("\n"); 
		query.append(", @[val_fax_no] VAL_FAX_NO" ).append("\n"); 
		query.append(", @[val_cd] VAL_CD" ).append("\n"); 
		query.append(", @[val_usr_id] VAL_USR_ID" ).append("\n"); 
		query.append(", @[val_ofc_cd] VAL_OFC_CD" ).append("\n"); 
		query.append(", @[val_dt] VAL_DT" ).append("\n"); 
		query.append(", @[mtch_flg] MTCH_FLG" ).append("\n"); 
		query.append(", @[an_snd_flg] AN_SND_FLG" ).append("\n"); 
		query.append(", @[chg_dp_flg] CHG_DP_FLG" ).append("\n"); 
		query.append(", @[org_cust_cnt_cd] ORG_CUST_CNT_CD" ).append("\n"); 
		query.append(", @[org_cust_seq] ORG_CUST_SEQ" ).append("\n"); 
		query.append(", @[ib_cust_nm] IB_CUST_NM" ).append("\n"); 
		query.append(", @[ib_cust_addr] IB_CUST_ADDR" ).append("\n"); 
		query.append(", @[cust_cd_upd_dt] CUST_CD_UPD_DT" ).append("\n"); 
		query.append(", @[eur_cstms_st_nm] EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append(", @[eori_no] EORI_NO" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT DECODE(NOW_CUST.BKG_CUST_TP_CD,'S','SHPR','C','CNEE','N','NTFY','A','ANTY','F','FWRD','E','EXPT','B','BROKER','CUST')" ).append("\n"); 
		query.append("||' CD' HIS_CATE_NM" ).append("\n"); 
		query.append(", OLD_CUST.CUST_CNT_CD||trim(to_char(OLD_CUST.CUST_SEQ, '000009')) PRE_CTNT" ).append("\n"); 
		query.append(", NOW_CUST.CUST_CNT_CD||trim(to_char(NOW_CUST.CUST_SEQ, '000009')) CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD_CUST" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", BKG_CUST_HIS NOW_CUST" ).append("\n"); 
		query.append("WHERE OLD_CUST.BKG_NO         = NOW_CUST.BKG_NO" ).append("\n"); 
		query.append("AND NOW_CUST.CORR_NO        = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", BKG_CUSTOMER NOW_CUST" ).append("\n"); 
		query.append("WHERE OLD_CUST.BKG_NO         = NOW_CUST.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND OLD_CUST.BKG_CUST_TP_CD = NOW_CUST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DECODE(NOW_CUST.BKG_CUST_TP_CD,'S','SHPR','C','CNEE','N','NTFY','A','ANTY','F','FWRD','E','EXPT','B','BROKER','CUST')" ).append("\n"); 
		query.append("||' NM' HIS_CATE_NM" ).append("\n"); 
		query.append(", TRIM(OLD_CUST.CUST_NM) PRE_CTNT" ).append("\n"); 
		query.append(", TRIM(NOW_CUST.CUST_NM) CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD_CUST" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", BKG_CUST_HIS NOW_CUST" ).append("\n"); 
		query.append("WHERE OLD_CUST.BKG_NO         = NOW_CUST.BKG_NO" ).append("\n"); 
		query.append("AND NOW_CUST.CORR_NO        = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", BKG_CUSTOMER NOW_CUST" ).append("\n"); 
		query.append("WHERE OLD_CUST.BKG_NO         = NOW_CUST.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND OLD_CUST.BKG_CUST_TP_CD = NOW_CUST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DECODE(NOW_CUST.BKG_CUST_TP_CD,'S','SHPR','C','CNEE','N','NTFY','A','ANTY','F','FWRD','E','EXPT','B','BROKER','CUST')" ).append("\n"); 
		query.append("||' ADDR' HIS_CATE_NM" ).append("\n"); 
		query.append(", TRIM(REPLACE(REPLACE(REPLACE(OLD_CUST.CUST_ADDR, '@*', ''),CHR(13),''),CHR(10),'')) PRE_CTNT" ).append("\n"); 
		query.append(", TRIM(REPLACE(REPLACE(REPLACE(NOW_CUST.CUST_ADDR, '@*', ''),CHR(13),''),CHR(10),'')) CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD_CUST" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", BKG_CUST_HIS NOW_CUST" ).append("\n"); 
		query.append("WHERE OLD_CUST.BKG_NO         = NOW_CUST.BKG_NO" ).append("\n"); 
		query.append("AND NOW_CUST.CORR_NO        = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", BKG_CUSTOMER NOW_CUST" ).append("\n"); 
		query.append("WHERE OLD_CUST.BKG_NO         = NOW_CUST.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND OLD_CUST.BKG_CUST_TP_CD = NOW_CUST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DECODE(NOW_CUST.BKG_CUST_TP_CD,'S','SHPR','C','CNEE','N','NTFY','A','ANTY','F','FWRD','E','EXPT','B','BROKER','CUST')" ).append("\n"); 
		query.append("||' CT/ST/CN/ZIP' HIS_CATE_NM" ).append("\n"); 
		query.append(", OLD_CUST.CUST_CTY_NM||'/'||OLD_CUST.CUST_STE_CD||'/'||OLD_CUST.CSTMS_DECL_CNT_CD||'/'||OLD_CUST.CUST_ZIP_ID PRE_CTNT" ).append("\n"); 
		query.append(", NOW_CUST.CUST_CTY_NM||'/'||NOW_CUST.CUST_STE_CD||'/'||NOW_CUST.CSTMS_DECL_CNT_CD||'/'||NOW_CUST.CUST_ZIP_ID CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD_CUST" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", BKG_CUST_HIS NOW_CUST" ).append("\n"); 
		query.append("WHERE OLD_CUST.BKG_NO         = NOW_CUST.BKG_NO" ).append("\n"); 
		query.append("AND NOW_CUST.CORR_NO        = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", BKG_CUSTOMER NOW_CUST" ).append("\n"); 
		query.append("WHERE OLD_CUST.BKG_NO         = NOW_CUST.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND OLD_CUST.BKG_CUST_TP_CD = NOW_CUST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DECODE(NOW_CUST.BKG_CUST_TP_CD,'S','SHPR','C','CNEE','N','NTFY','A','ANTY','F','FWRD','E','EXPT','B','BROKER','CUST')" ).append("\n"); 
		query.append("||' FAX' HIS_CATE_NM--FAX" ).append("\n"); 
		query.append(", OLD_CUST.CUST_FAX_NO PRE_CTNT" ).append("\n"); 
		query.append(", NOW_CUST.CUST_FAX_NO CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD_CUST" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", BKG_CUST_HIS NOW_CUST" ).append("\n"); 
		query.append("WHERE OLD_CUST.BKG_NO         = NOW_CUST.BKG_NO" ).append("\n"); 
		query.append("AND NOW_CUST.CORR_NO        = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", BKG_CUSTOMER NOW_CUST" ).append("\n"); 
		query.append("WHERE OLD_CUST.BKG_NO         = NOW_CUST.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND OLD_CUST.BKG_CUST_TP_CD = NOW_CUST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DECODE(NOW_CUST.BKG_CUST_TP_CD,'S','SHPR','C','CNEE','N','NTFY','A','ANTY','F','FWRD','E','EXPT','B','BROKER','CUST')" ).append("\n"); 
		query.append("||' EMAIL' HIS_CATE_NM--EMAIL" ).append("\n"); 
		query.append(", OLD_CUST.CUST_EML PRE_CTNT" ).append("\n"); 
		query.append(", NOW_CUST.CUST_EML CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD_CUST" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", BKG_CUST_HIS NOW_CUST" ).append("\n"); 
		query.append("WHERE OLD_CUST.BKG_NO         = NOW_CUST.BKG_NO" ).append("\n"); 
		query.append("AND NOW_CUST.CORR_NO        = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", BKG_CUSTOMER NOW_CUST" ).append("\n"); 
		query.append("WHERE OLD_CUST.BKG_NO         = NOW_CUST.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND OLD_CUST.BKG_CUST_TP_CD = NOW_CUST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DECODE(NOW_CUST.BKG_CUST_TP_CD,'S','SHPR','C','CNEE','N','NTFY','A','ANTY','F','FWRD','E','EXPT','B','BROKER','CUST')" ).append("\n"); 
		query.append("||' Street/P.O.Box' HIS_CATE_NM--STREET/P.O.BOX" ).append("\n"); 
		query.append(", OLD_CUST.EUR_CSTMS_ST_NM PRE_CTNT" ).append("\n"); 
		query.append(", NOW_CUST.EUR_CSTMS_ST_NM CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD_CUST" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", BKG_CUST_HIS NOW_CUST" ).append("\n"); 
		query.append("WHERE OLD_CUST.BKG_NO         = NOW_CUST.BKG_NO" ).append("\n"); 
		query.append("AND NOW_CUST.CORR_NO        = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", BKG_CUSTOMER NOW_CUST" ).append("\n"); 
		query.append("WHERE OLD_CUST.BKG_NO         = NOW_CUST.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND OLD_CUST.BKG_CUST_TP_CD = NOW_CUST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DECODE(NOW_CUST.BKG_CUST_TP_CD,'S','SHPR','C','CNEE','N','NTFY','A','ANTY','F','FWRD','E','EXPT','B','BROKER','CUST')" ).append("\n"); 
		query.append("||' EORI No' HIS_CATE_NM--EORI_NO" ).append("\n"); 
		query.append(", OLD_CUST.EORI_NO PRE_CTNT" ).append("\n"); 
		query.append(", NOW_CUST.EORI_NO CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD_CUST" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", BKG_CUST_HIS NOW_CUST" ).append("\n"); 
		query.append("WHERE OLD_CUST.BKG_NO         = NOW_CUST.BKG_NO" ).append("\n"); 
		query.append("AND NOW_CUST.CORR_NO        = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", BKG_CUSTOMER NOW_CUST" ).append("\n"); 
		query.append("WHERE OLD_CUST.BKG_NO         = NOW_CUST.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND OLD_CUST.BKG_CUST_TP_CD = NOW_CUST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(PRE_CTNT, ' ') <> NVL(CRNT_CTNT, ' ')" ).append("\n"); 

	}
}