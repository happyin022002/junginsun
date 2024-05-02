/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterBlDocCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.27 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterBlDocCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterBlDocCust
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterBlDocCustRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOsearchXterBlDocCustRSQL").append("\n"); 
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
		query.append("select BK.BKG_NO" ).append("\n"); 
		query.append(", sh.CUST_CNT_CD SH_CUST_CNT_CD" ).append("\n"); 
		query.append(", sh.CUST_SEQ SH_CUST_SEQ" ).append("\n"); 
		query.append(", sh.CUST_CNT_CD||sh.CUST_SEQ SH_CNT_SEQ" ).append("\n"); 
		query.append(", bk.kr_cstms_cust_tp_cd SH_kr_cstms_cust_tp_cd" ).append("\n"); 
		query.append(", TRIM(sh.CUST_NM) SH_CUST_NM" ).append("\n"); 
		query.append(", mdm_sh.CUST_LGL_ENG_NM SH_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",(select REPLACE(bzet_addr, '@*', CHR(13))" ).append("\n"); 
		query.append("from mdm_cust_addr" ).append("\n"); 
		query.append("where cust_cnt_cd = sh.CUST_CNT_CD" ).append("\n"); 
		query.append("and cust_seq = sh.CUST_SEQ" ).append("\n"); 
		query.append("and prmry_chk_flg = 'Y'" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 
		query.append(") SH_MDM_ADDRESS" ).append("\n"); 
		query.append(", sh.ADDR_PRN_FLG SH_ADDR_PRN_FLG, TRIM(sh.CUST_ADDR) SH_CUST_ADDR" ).append("\n"); 
		query.append(", sh.CUST_CTY_NM SH_CUST_CTY_NM" ).append("\n"); 
		query.append(", sh.CUST_STE_CD SH_CUST_STE_CD" ).append("\n"); 
		query.append(", sh.CSTMS_DECL_CNT_CD SH_CSTMS_DECL_CNT_CD, sh.CUST_ZIP_ID SH_CUST_ZIP_ID" ).append("\n"); 
		query.append(", mdm_sh.RVIS_CNTR_CUST_TP_CD SH_CUST_TP" ).append("\n"); 
		query.append(", cn.CUST_CNT_CD CN_CUST_CNT_CD" ).append("\n"); 
		query.append(", cn.CUST_SEQ CN_CUST_SEQ" ).append("\n"); 
		query.append(", cn.CUST_CNT_CD||cn.CUST_SEQ CN_CNT_SEQ" ).append("\n"); 
		query.append(", bk.cust_to_ord_flg CN_cust_to_ord_flg" ).append("\n"); 
		query.append(", TRIM(cn.CUST_NM) CN_CUST_NM, mdm_cn.CUST_LGL_ENG_NM CN_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",(select REPLACE(bzet_addr, '@*', CHR(13))" ).append("\n"); 
		query.append("from mdm_cust_addr" ).append("\n"); 
		query.append("where cust_cnt_cd = cn.CUST_CNT_CD" ).append("\n"); 
		query.append("and cust_seq = cn.CUST_SEQ" ).append("\n"); 
		query.append("and prmry_chk_flg = 'Y'" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 
		query.append(") CN_MDM_ADDRESS" ).append("\n"); 
		query.append(", cn.ADDR_PRN_FLG CN_ADDR_PRN_FLG, TRIM(cn.CUST_ADDR) CN_CUST_ADDR" ).append("\n"); 
		query.append(", cn.CUST_CTY_NM CN_CUST_CTY_NM, cn.CUST_STE_CD CN_CUST_STE_CD" ).append("\n"); 
		query.append(", cn.CSTMS_DECL_CNT_CD CN_CSTMS_DECL_CNT_CD, cn.CUST_ZIP_ID CN_CUST_ZIP_ID" ).append("\n"); 
		query.append(", cn.CUST_FAX_NO CN_CUST_FAX_NO, cn.CUST_EML CN_CUST_EML" ).append("\n"); 
		query.append(", nf.CUST_CNT_CD NF_CUST_CNT_CD" ).append("\n"); 
		query.append(", nf.CUST_SEQ NF_CUST_SEQ" ).append("\n"); 
		query.append(", nf.CUST_CNT_CD||nf.CUST_SEQ NF_CNT_SEQ" ).append("\n"); 
		query.append(", TRIM(nf.CUST_NM) NF_CUST_NM" ).append("\n"); 
		query.append(", mdm_nf.CUST_LGL_ENG_NM NF_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",(select REPLACE(bzet_addr, '@*', CHR(13))" ).append("\n"); 
		query.append("from mdm_cust_addr" ).append("\n"); 
		query.append("where cust_cnt_cd = nf.CUST_CNT_CD" ).append("\n"); 
		query.append("and cust_seq = nf.CUST_SEQ" ).append("\n"); 
		query.append("and prmry_chk_flg = 'Y'" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 
		query.append(") NF_MDM_ADDRESS" ).append("\n"); 
		query.append(", nf.ADDR_PRN_FLG NF_ADDR_PRN_FLG, TRIM(nf.CUST_ADDR) NF_CUST_ADDR" ).append("\n"); 
		query.append(", nf.CUST_CTY_NM NF_CUST_CTY_NM, nf.CUST_STE_CD NF_CUST_STE_CD" ).append("\n"); 
		query.append(", nf.CSTMS_DECL_CNT_CD NF_CSTMS_DECL_CNT_CD, nf.CUST_ZIP_ID NF_CUST_ZIP_ID" ).append("\n"); 
		query.append(", nf.CUST_FAX_NO NF_CUST_FAX_NO, nf.CUST_EML NF_CUST_EML" ).append("\n"); 
		query.append(", ff.CUST_CNT_CD FF_CUST_CNT_CD" ).append("\n"); 
		query.append(", ff.CUST_SEQ FF_CUST_SEQ" ).append("\n"); 
		query.append(", ff.CUST_CNT_CD||ff.CUST_SEQ FF_CNT_SEQ" ).append("\n"); 
		query.append(", TRIM(ff.CUST_NM) FF_CUST_NM, mdm_ff.CUST_LGL_ENG_NM FF_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",(select REPLACE(bzet_addr, '@*', CHR(13))" ).append("\n"); 
		query.append("from mdm_cust_addr" ).append("\n"); 
		query.append("where cust_cnt_cd = ff.CUST_CNT_CD" ).append("\n"); 
		query.append("and cust_seq = ff.CUST_SEQ" ).append("\n"); 
		query.append("and prmry_chk_flg = 'Y'" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 
		query.append(") FF_MDM_ADDRESS" ).append("\n"); 
		query.append(", ff.ADDR_PRN_FLG FF_ADDR_PRN_FLG, TRIM(ff.CUST_ADDR) FF_CUST_ADDR" ).append("\n"); 
		query.append(", ff.CUST_CTY_NM FF_CUST_CTY_NM, ff.CUST_STE_CD FF_CUST_STE_CD" ).append("\n"); 
		query.append(", ff.CSTMS_DECL_CNT_CD FF_CSTMS_DECL_CNT_CD, ff.CUST_ZIP_ID FF_CUST_ZIP_ID" ).append("\n"); 
		query.append(", ff.CUST_FAX_NO FF_CUST_FAX_NO, ff.CUST_EML FF_CUST_EML" ).append("\n"); 
		query.append(", an.CUST_CNT_CD AN_CUST_CNT_CD" ).append("\n"); 
		query.append(", an.CUST_SEQ AN_CUST_SEQ" ).append("\n"); 
		query.append(", an.CUST_CNT_CD||an.CUST_SEQ AN_CNT_SEQ" ).append("\n"); 
		query.append(", TRIM(an.CUST_NM) AN_CUST_NM" ).append("\n"); 
		query.append(", mdm_An.CUST_LGL_ENG_NM AN_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",(select REPLACE(bzet_addr, '@*', CHR(13))" ).append("\n"); 
		query.append("from mdm_cust_addr" ).append("\n"); 
		query.append("where cust_cnt_cd = an.CUST_CNT_CD" ).append("\n"); 
		query.append("and cust_seq = an.CUST_SEQ" ).append("\n"); 
		query.append("and prmry_chk_flg = 'Y'" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 
		query.append(") AN_MDM_ADDRESS" ).append("\n"); 
		query.append(", an.ADDR_PRN_FLG AN_ADDR_PRN_FLG, TRIM(an.CUST_ADDR) AN_CUST_ADDR" ).append("\n"); 
		query.append(", ex.CUST_SEQ EX_CUST_SEQ" ).append("\n"); 
		query.append(", ex.CUST_NM EX_CUST_NM" ).append("\n"); 
		query.append(", TRIM(ex.CUST_NM) EX_CUST_NM" ).append("\n"); 
		query.append(", ex.ADDR_PRN_FLG EX_ADDR_PRN_FLG" ).append("\n"); 
		query.append(", br.cust_cnt_cd BR_cust_cnt_cd" ).append("\n"); 
		query.append(", TRIM(br.cust_nm) BR_cust_nm" ).append("\n"); 
		query.append(", TRIM(br.cust_addr) BR_cust_addr" ).append("\n"); 
		query.append("from bkg_booking bk" ).append("\n"); 
		query.append(", bkg_customer sh" ).append("\n"); 
		query.append(", bkg_customer cn" ).append("\n"); 
		query.append(", bkg_customer nf" ).append("\n"); 
		query.append(", bkg_customer ff" ).append("\n"); 
		query.append(", bkg_customer an" ).append("\n"); 
		query.append(", bkg_customer ex" ).append("\n"); 
		query.append(", bkg_customer br" ).append("\n"); 
		query.append(", mdm_customer mdm_sh" ).append("\n"); 
		query.append(", mdm_customer mdm_cn" ).append("\n"); 
		query.append(", mdm_customer mdm_nf" ).append("\n"); 
		query.append(", mdm_customer mdm_ff" ).append("\n"); 
		query.append(", mdm_customer mdm_an" ).append("\n"); 
		query.append("where bk.bkg_no       = sh.bkg_no" ).append("\n"); 
		query.append("and 'S'             = sh.bkg_cust_tp_cd" ).append("\n"); 
		query.append("and bk.bkg_no       = cn.bkg_no(+)" ).append("\n"); 
		query.append("and 'C'             = CN.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("and bk.bkg_no       = nf.bkg_no(+)" ).append("\n"); 
		query.append("and 'N'             = NF.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("and bk.bkg_no       = ff.bkg_no(+)" ).append("\n"); 
		query.append("and 'F'             = FF.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("and bk.bkg_no       = an.bkg_no(+)" ).append("\n"); 
		query.append("and 'A'             = AN.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("and bk.bkg_no       = ex.bkg_no(+)" ).append("\n"); 
		query.append("and 'E'             = EX.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("and bk.bkg_no       = br.bkg_no(+)" ).append("\n"); 
		query.append("and 'B'             = BR.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("and sh.cust_cnt_cd  = mdm_sh.cust_cnt_cd(+)" ).append("\n"); 
		query.append("and sh.cust_seq     = mdm_sh.cust_seq(+)" ).append("\n"); 
		query.append("and cn.cust_cnt_cd  = mdm_cn.cust_cnt_cd(+)" ).append("\n"); 
		query.append("and cn.cust_seq     = mdm_cn.cust_seq(+)" ).append("\n"); 
		query.append("and nf.cust_cnt_cd  = mdm_nf.cust_cnt_cd(+)" ).append("\n"); 
		query.append("and nf.cust_seq     = mdm_nf.cust_seq(+)" ).append("\n"); 
		query.append("and ff.cust_cnt_cd  = mdm_ff.cust_cnt_cd(+)" ).append("\n"); 
		query.append("and ff.cust_seq     = mdm_ff.cust_seq(+)" ).append("\n"); 
		query.append("and an.cust_cnt_cd  = mdm_an.cust_cnt_cd(+)" ).append("\n"); 
		query.append("and an.cust_seq     = mdm_an.cust_seq(+)" ).append("\n"); 
		query.append("and bk.bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("and bk.bkg_sts_Cd   <> 'X'" ).append("\n"); 
		query.append("and bk.bkg_cgo_tp_cd <> 'P'" ).append("\n"); 

	}
}