/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBlDocCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.10
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchBlDocCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Information 을 조회한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchBlDocCustRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchBlDocCustRSQL").append("\n"); 
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
		query.append("select  SH.BKG_NO" ).append("\n"); 
		query.append("		, sh.CUST_CNT_CD 									SH_CUST_CNT_CD" ).append("\n"); 
		query.append("        , DECODE(sh.CUST_SEQ,0,'',LPAD(sh.CUST_SEQ,6,'0')) 	SH_CUST_SEQ" ).append("\n"); 
		query.append("	    , mdm_sh.CUST_LGL_ENG_NM 							SH_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , sh.CUST_NM 										SH_CUST_NM" ).append("\n"); 
		query.append("        , sh.ADDR_PRN_FLG 									SH_ADDR_PRN_FLG" ).append("\n"); 
		query.append("        , sh.CUST_ADDR 										SH_CUST_ADDR" ).append("\n"); 
		query.append("        , sh.CUST_CTY_NM 									SH_CUST_CTY_NM" ).append("\n"); 
		query.append("        , sh.CUST_STE_CD 									SH_CUST_STE_CD" ).append("\n"); 
		query.append("        , sh.CSTMS_DECL_CNT_CD 								SH_CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("        , sh.CUST_ZIP_ID 									SH_CUST_ZIP_ID" ).append("\n"); 
		query.append("		, sh.EUR_CSTMS_ST_NM 								SH_EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append("		, SH.EORI_NO 										SH_EORI_NO" ).append("\n"); 
		query.append("        , mdm_sh.CNTR_CUST_TP_CD 						    SH_CUST_TP" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("			select  REPLACE(bzet_addr, '@*', CHR(10))" ).append("\n"); 
		query.append("			from    mdm_cust_addr" ).append("\n"); 
		query.append("			where   cust_cnt_cd = sh.CUST_CNT_CD" ).append("\n"); 
		query.append("			and     cust_seq = sh.CUST_SEQ" ).append("\n"); 
		query.append("			and     prmry_chk_flg = 'Y'" ).append("\n"); 
		query.append("			and     rownum = 1	" ).append("\n"); 
		query.append("		) 													SH_MDM_ADDRESS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , cn.CUST_CNT_CD 									CN_CUST_CNT_CD" ).append("\n"); 
		query.append("        , DECODE(cn.CUST_SEQ,0,'',LPAD(cn.CUST_SEQ,6,'0')) 	CN_CUST_SEQ" ).append("\n"); 
		query.append("	    , mdm_cn.CUST_LGL_ENG_NM 							CN_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , cn.CUST_NM 										CN_CUST_NM" ).append("\n"); 
		query.append("        , cn.ADDR_PRN_FLG 									CN_ADDR_PRN_FLG" ).append("\n"); 
		query.append("        , cn.CUST_ADDR 										CN_CUST_ADDR" ).append("\n"); 
		query.append("        , cn.CUST_CTY_NM 									CN_CUST_CTY_NM" ).append("\n"); 
		query.append("        , cn.CUST_STE_CD 									CN_CUST_STE_CD" ).append("\n"); 
		query.append("        , cn.CSTMS_DECL_CNT_CD 								CN_CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("        , cn.CUST_ZIP_ID 									CN_CUST_ZIP_ID" ).append("\n"); 
		query.append("        , cn.CUST_FAX_NO 									CN_CUST_FAX_NO" ).append("\n"); 
		query.append("        , cn.CUST_EML 										CN_CUST_EML" ).append("\n"); 
		query.append("		, CN.EUR_CSTMS_ST_NM 								CN_EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append("		, CN.EORI_NO 										CN_EORI_NO" ).append("\n"); 
		query.append("        , mdm_cn.CNTR_CUST_TP_CD 						    CN_CUST_TP" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("			select  REPLACE(bzet_addr, '@*', CHR(10))" ).append("\n"); 
		query.append("			from    mdm_cust_addr" ).append("\n"); 
		query.append("			where   cust_cnt_cd = cn.CUST_CNT_CD" ).append("\n"); 
		query.append("			and     cust_seq = cn.CUST_SEQ" ).append("\n"); 
		query.append("			and     prmry_chk_flg = 'Y'" ).append("\n"); 
		query.append("			and     rownum = 1	" ).append("\n"); 
		query.append("		) 													CN_MDM_ADDRESS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , nf.CUST_CNT_CD 									NF_CUST_CNT_CD" ).append("\n"); 
		query.append("        , DECODE(nf.CUST_SEQ,0,'',LPAD(nf.CUST_SEQ,6,'0')) 	NF_CUST_SEQ" ).append("\n"); 
		query.append("	    , mdm_nf.CUST_LGL_ENG_NM 							NF_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , nf.CUST_NM 										NF_CUST_NM" ).append("\n"); 
		query.append("        , nf.ADDR_PRN_FLG 									NF_ADDR_PRN_FLG" ).append("\n"); 
		query.append("        , nf.CUST_ADDR 										NF_CUST_ADDR        " ).append("\n"); 
		query.append("        , nf.CUST_CTY_NM 									NF_CUST_CTY_NM" ).append("\n"); 
		query.append("        , nf.CUST_STE_CD 									NF_CUST_STE_CD" ).append("\n"); 
		query.append("        , nf.CSTMS_DECL_CNT_CD 								NF_CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("        , nf.CUST_ZIP_ID 									NF_CUST_ZIP_ID" ).append("\n"); 
		query.append("        , nf.CUST_FAX_NO 									NF_CUST_FAX_NO" ).append("\n"); 
		query.append("        , nf.CUST_EML 										NF_CUST_EML" ).append("\n"); 
		query.append("		, NF.EUR_CSTMS_ST_NM 								NF_EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append("		, NF.EORI_NO 										NF_EORI_NO" ).append("\n"); 
		query.append("        , mdm_nf.CNTR_CUST_TP_CD 						    NF_CUST_TP" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("			select  REPLACE(bzet_addr, '@*', CHR(10))" ).append("\n"); 
		query.append("			from    mdm_cust_addr" ).append("\n"); 
		query.append("			where   cust_cnt_cd = nf.CUST_CNT_CD" ).append("\n"); 
		query.append("			and     cust_seq = nf.CUST_SEQ" ).append("\n"); 
		query.append("			and     prmry_chk_flg = 'Y'" ).append("\n"); 
		query.append("			and     rownum = 1	" ).append("\n"); 
		query.append("		) 													NF_MDM_ADDRESS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , ff.CUST_CNT_CD 									FF_CUST_CNT_CD" ).append("\n"); 
		query.append("        , DECODE(ff.CUST_SEQ,0,'',LPAD(ff.CUST_SEQ,6,'0')) 	FF_CUST_SEQ" ).append("\n"); 
		query.append("	    , mdm_ff.CUST_LGL_ENG_NM 							FF_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , ff.CUST_NM || CHR(10) || FF.CUST_ADDR				FF_CUST_NM" ).append("\n"); 
		query.append("		, FF.CUST_ADDR 										FF_CUST_ADDR" ).append("\n"); 
		query.append("        , ff.ADDR_PRN_FLG 									FF_ADDR_PRN_FLG" ).append("\n"); 
		query.append("        , Ff.CUST_CTY_NM 									FF_CUST_CTY_NM" ).append("\n"); 
		query.append("        , Ff.CUST_STE_CD 									fF_CUST_STE_CD" ).append("\n"); 
		query.append("        , Ff.CSTMS_DECL_CNT_CD 								fF_CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("        , Ff.CUST_ZIP_ID 									fF_CUST_ZIP_ID" ).append("\n"); 
		query.append("        , ff.CUST_FAX_NO 									fF_CUST_FAX_NO" ).append("\n"); 
		query.append("        , FF.CUST_EML 										FF_CUST_EML" ).append("\n"); 
		query.append("        , mdm_ff.CNTR_CUST_TP_CD 						    FF_CUST_TP" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("			select  REPLACE(bzet_addr, '@*', CHR(10))" ).append("\n"); 
		query.append("			from    mdm_cust_addr" ).append("\n"); 
		query.append("			where   cust_cnt_cd = ff.CUST_CNT_CD" ).append("\n"); 
		query.append("			and     cust_seq = ff.CUST_SEQ" ).append("\n"); 
		query.append("			and     prmry_chk_flg = 'Y'" ).append("\n"); 
		query.append("			and     rownum = 1	" ).append("\n"); 
		query.append("		) 													FF_MDM_ADDRESS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , an.CUST_CNT_CD 									AN_CUST_CNT_CD" ).append("\n"); 
		query.append("        , DECODE(an.CUST_SEQ,0,'',LPAD(an.CUST_SEQ,6,'0')) 	AN_CUST_SEQ" ).append("\n"); 
		query.append("	    , mdm_An.CUST_LGL_ENG_NM  							AN_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , an.CUST_NM 										AN_CUST_NM" ).append("\n"); 
		query.append("		, AN.CUST_ADDR 										AN_CUST_ADDR" ).append("\n"); 
		query.append("        , an.ADDR_PRN_FLG 									AN_ADDR_PRN_FLG" ).append("\n"); 
		query.append("        , AN.CUST_STE_CD 									AN_CUST_STE_CD" ).append("\n"); 
		query.append("        , AN.CSTMS_DECL_CNT_CD 								AN_CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("        , AN.CUST_ZIP_ID 									AN_CUST_ZIP_ID" ).append("\n"); 
		query.append("        , AN.CUST_FAX_NO 									AN_CUST_FAX_NO" ).append("\n"); 
		query.append("        , AN.CUST_EML 										AN_CUST_EML" ).append("\n"); 
		query.append("        , mdm_an.CNTR_CUST_TP_CD 						    AN_CUST_TP" ).append("\n"); 
		query.append("        , an.CUST_FAX_NO 									AN_CUST_FAX_NO" ).append("\n"); 
		query.append("        , an.CUST_EML 										AN_CUST_EML" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("			select  REPLACE(bzet_addr, '@*', CHR(10))" ).append("\n"); 
		query.append("			from    mdm_cust_addr" ).append("\n"); 
		query.append("			where   cust_cnt_cd = an.CUST_CNT_CD" ).append("\n"); 
		query.append("			and     cust_seq = an.CUST_SEQ" ).append("\n"); 
		query.append("			and     prmry_chk_flg = 'Y'" ).append("\n"); 
		query.append("			and     rownum = 1	" ).append("\n"); 
		query.append("		) 													AN_MDM_ADDRESS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , ex.CUST_CNT_CD 									EX_CUST_CNT_CD" ).append("\n"); 
		query.append("        , DECODE(ex.CUST_SEQ,0,'',LPAD(ex.CUST_SEQ,6,'0')) 	EX_CUST_SEQ        " ).append("\n"); 
		query.append("        , ex.CUST_NM 										EX_CUST_NM" ).append("\n"); 
		query.append("        , ex.ADDR_PRN_FLG 									EX_ADDR_PRN_FLG        " ).append("\n"); 
		query.append("		--, br.cust_cnt_cd 									br_cust_cnt_cd" ).append("\n"); 
		query.append("		--, DECODE(br.CUST_SEQ,0,'',LPAD(br.CUST_SEQ,6,'0')) 	br_CUST_SEQ" ).append("\n"); 
		query.append("		, ( SELECT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("			  FROM BKG_REF_HIS" ).append("\n"); 
		query.append("			 WHERE CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("			   AND BKG_REF_TP_CD = 'BRKN'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("			  FROM BKG_REFERENCE" ).append("\n"); 
		query.append("			 WHERE BKG_REF_TP_CD = 'BRKN'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			   AND BKG_NO = BK.BKG_NO )						br_cust_cnt_cd" ).append("\n"); 
		query.append("		, br.cust_nm										br_cust_nm" ).append("\n"); 
		query.append("        , br.CUST_ADDR 										BR_CUST_ADDR        " ).append("\n"); 
		query.append("from      " ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("          BKG_BKG_HIS bk" ).append("\n"); 
		query.append("        , BKG_CUST_HIS sh" ).append("\n"); 
		query.append("        , BKG_CUST_HIS cn" ).append("\n"); 
		query.append("        , BKG_CUST_HIS ff" ).append("\n"); 
		query.append("        , BKG_CUST_HIS nf" ).append("\n"); 
		query.append("        , BKG_CUST_HIS an" ).append("\n"); 
		query.append("        , BKG_CUST_HIS ex" ).append("\n"); 
		query.append("		, BKG_CUST_HIS br" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          bkg_booking bk" ).append("\n"); 
		query.append("        , bkg_customer sh" ).append("\n"); 
		query.append("        , bkg_customer cn" ).append("\n"); 
		query.append("        , bkg_customer ff" ).append("\n"); 
		query.append("        , bkg_customer nf" ).append("\n"); 
		query.append("        , bkg_customer an" ).append("\n"); 
		query.append("        , bkg_customer ex" ).append("\n"); 
		query.append("		, bkg_customer br" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , mdm_customer mdm_sh" ).append("\n"); 
		query.append("        , mdm_customer mdm_cn" ).append("\n"); 
		query.append("        , mdm_customer mdm_ff" ).append("\n"); 
		query.append("        , mdm_customer mdm_nf" ).append("\n"); 
		query.append("        , mdm_customer mdm_an" ).append("\n"); 
		query.append("where " ).append("\n"); 
		query.append("      bk.bkg_no       = sh.bkg_no" ).append("\n"); 
		query.append("  and 'S'             = sh.bkg_cust_tp_cd" ).append("\n"); 
		query.append("  and bk.bkg_no       = cn.bkg_no(+)" ).append("\n"); 
		query.append("  and 'C'             = CN.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("  and bk.bkg_no       = ff.bkg_no(+)" ).append("\n"); 
		query.append("  and 'F'             = FF.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("  and bk.bkg_no       = nf.bkg_no(+)" ).append("\n"); 
		query.append("  and 'N'             = NF.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("  and bk.bkg_no       = an.bkg_no(+)" ).append("\n"); 
		query.append("  and 'A'             = AN.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("  and bk.bkg_no       = ex.bkg_no(+)" ).append("\n"); 
		query.append("  and 'E'             = EX.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("  and bk.bkg_no       = br.bkg_no(+)" ).append("\n"); 
		query.append("  and 'B'             = br.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("  and sh.cust_cnt_cd  = mdm_sh.cust_cnt_cd(+)" ).append("\n"); 
		query.append("  and sh.cust_seq     = mdm_sh.cust_seq(+)" ).append("\n"); 
		query.append("  and cn.cust_cnt_cd  = mdm_cn.cust_cnt_cd(+)" ).append("\n"); 
		query.append("  and cn.cust_seq     = mdm_cn.cust_seq(+)" ).append("\n"); 
		query.append("  and ff.cust_cnt_cd  = mdm_ff.cust_cnt_cd(+)" ).append("\n"); 
		query.append("  and ff.cust_seq     = mdm_ff.cust_seq(+)" ).append("\n"); 
		query.append("  and an.cust_cnt_cd  = mdm_an.cust_cnt_cd(+)" ).append("\n"); 
		query.append("  and an.cust_seq     = mdm_an.cust_seq(+)" ).append("\n"); 
		query.append("  and nf.cust_cnt_cd  = mdm_nf.cust_cnt_cd(+)" ).append("\n"); 
		query.append("  and nf.cust_seq     = mdm_nf.cust_seq(+)" ).append("\n"); 
		query.append("#if (${bkg_no}!= '')" ).append("\n"); 
		query.append("  and bk.bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  and bk.bl_no       = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("AND bk.corr_no      = sh.corr_no(+)" ).append("\n"); 
		query.append("AND bk.corr_no      = cn.corr_no(+)" ).append("\n"); 
		query.append("AND bk.corr_no      = ff.corr_no(+)" ).append("\n"); 
		query.append("AND bk.corr_no      = nf.corr_no(+)" ).append("\n"); 
		query.append("AND bk.corr_no      = an.corr_no(+)" ).append("\n"); 
		query.append("AND bk.corr_no      = ex.corr_no(+)" ).append("\n"); 
		query.append("AND   bk.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}