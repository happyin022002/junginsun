/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOAddBkgCustomerCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOAddBkgCustomerCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Customer 정보 저장
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOAddBkgCustomerCSQL(){
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
		params.put("end_usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("ib_cust_addr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_dp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eur_cstms_st_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOAddBkgCustomerCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CUST_HIS (" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_CUSTOMER (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append(",   CORR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",	CUST_CNT_CD" ).append("\n"); 
		query.append(",	CUST_SEQ" ).append("\n"); 
		query.append(",	CUST_NM" ).append("\n"); 
		query.append(",	CUST_ADDR" ).append("\n"); 
		query.append(",	CUST_CTY_NM" ).append("\n"); 
		query.append(",	CUST_STE_CD" ).append("\n"); 
		query.append(",	CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append(",	CUST_ZIP_ID" ).append("\n"); 
		query.append(",	CUST_FAX_NO" ).append("\n"); 
		query.append(",	CUST_EML" ).append("\n"); 
		query.append(",	CUST_TP_CD" ).append("\n"); 
		query.append(",	REF_NO" ).append("\n"); 
		query.append(",	ADDR_PRN_FLG" ).append("\n"); 
		query.append(",	VAL_NM" ).append("\n"); 
		query.append(",	VAL_FAX_NO" ).append("\n"); 
		query.append(",	VAL_CD" ).append("\n"); 
		query.append(",	VAL_USR_ID" ).append("\n"); 
		query.append(",	VAL_OFC_CD" ).append("\n"); 
		query.append(",	VAL_DT" ).append("\n"); 
		query.append(",	MTCH_FLG" ).append("\n"); 
		query.append(",	AN_SND_FLG" ).append("\n"); 
		query.append(",	CHG_DP_FLG" ).append("\n"); 
		query.append(",	IB_CUST_NM" ).append("\n"); 
		query.append(",	IB_CUST_ADDR" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(", 	EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append(", 	EORI_NO" ).append("\n"); 
		query.append(",   END_USR_NM" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append(",   'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	@[bkg_cust_tp_cd]" ).append("\n"); 
		query.append(",	@[cust_cnt_cd]" ).append("\n"); 
		query.append(",	@[cust_seq]" ).append("\n"); 
		query.append(",	NVL(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(@[cust_nm], chr(13)||chr(10), '▤') , chr(10),''), chr(13), '▤'), chr(9), ' '), '▤' ,chr(13)||chr(10))" ).append("\n"); 
		query.append("        ,(SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = @[cust_cnt_cd] AND CUST_SEQ = @[cust_seq]))" ).append("\n"); 
		query.append(",	(SELECT REPLACE(bzet_addr, '@*', CHR(13)||CHR(10))                " ).append("\n"); 
		query.append("	   FROM MDM_CUST_ADDR" ).append("\n"); 
		query.append("      WHERE CUST_CNT_CD   = @[cust_cnt_cd]" ).append("\n"); 
		query.append("        AND CUST_SEQ      = @[cust_seq]" ).append("\n"); 
		query.append("        AND PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("        AND ROWNUM        = 1)" ).append("\n"); 
		query.append(",	(SELECT CTY_NM                    " ).append("\n"); 
		query.append("	   FROM MDM_CUST_ADDR" ).append("\n"); 
		query.append("      WHERE CUST_CNT_CD   = @[cust_cnt_cd]" ).append("\n"); 
		query.append("        AND CUST_SEQ      = @[cust_seq]" ).append("\n"); 
		query.append("        AND PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("        AND ROWNUM        = 1)" ).append("\n"); 
		query.append(",	(SELECT STE_CD                    " ).append("\n"); 
		query.append("	   FROM MDM_CUST_ADDR" ).append("\n"); 
		query.append("      WHERE CUST_CNT_CD   = @[cust_cnt_cd]" ).append("\n"); 
		query.append("        AND CUST_SEQ      = @[cust_seq]" ).append("\n"); 
		query.append("        AND PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("        AND ROWNUM        = 1)" ).append("\n"); 
		query.append(",	@[cstms_decl_cnt_cd]" ).append("\n"); 
		query.append(",	(SELECT ZIP_CD                    " ).append("\n"); 
		query.append("	   FROM MDM_CUST_ADDR" ).append("\n"); 
		query.append("      WHERE CUST_CNT_CD   = @[cust_cnt_cd]" ).append("\n"); 
		query.append("        AND CUST_SEQ      = @[cust_seq]" ).append("\n"); 
		query.append("        AND PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("        AND ROWNUM        = 1)" ).append("\n"); 
		query.append(",	@[cust_fax_no]" ).append("\n"); 
		query.append(",	(SELECT CNTC_EML                   " ).append("\n"); 
		query.append("	   FROM MDM_CUST_ADDR" ).append("\n"); 
		query.append("      WHERE CUST_CNT_CD   = @[cust_cnt_cd]" ).append("\n"); 
		query.append("        AND CUST_SEQ      = @[cust_seq]" ).append("\n"); 
		query.append("        AND PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("        AND ROWNUM        = 1)" ).append("\n"); 
		query.append(",	@[cust_tp_cd]" ).append("\n"); 
		query.append(",	@[ref_no]" ).append("\n"); 
		query.append(",	NVL(@[addr_prn_flg],'Y')" ).append("\n"); 
		query.append(",	@[val_nm]" ).append("\n"); 
		query.append(",	@[val_fax_no]" ).append("\n"); 
		query.append(",	@[val_cd]" ).append("\n"); 
		query.append(",	@[val_usr_id]" ).append("\n"); 
		query.append(",	@[val_ofc_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[val_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	NVL(@[mtch_flg]  , 'N')" ).append("\n"); 
		query.append(",	NVL(@[an_snd_flg], 'N')" ).append("\n"); 
		query.append(",	NVL(@[chg_dp_flg], 'N')" ).append("\n"); 
		query.append(",	@[ib_cust_nm]" ).append("\n"); 
		query.append(",	@[ib_cust_addr]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(", 	@[eur_cstms_st_nm]" ).append("\n"); 
		query.append(", 	@[eori_no]" ).append("\n"); 
		query.append(",   @[end_usr_nm]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}