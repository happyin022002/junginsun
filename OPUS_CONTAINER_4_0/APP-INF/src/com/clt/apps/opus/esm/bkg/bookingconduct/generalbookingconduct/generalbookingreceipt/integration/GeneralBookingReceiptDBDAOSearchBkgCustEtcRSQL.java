/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBkgCustEtcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.24 
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

public class GeneralBookingReceiptDBDAOSearchBkgCustEtcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchBkgCustEtcRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchBkgCustEtcRSQL").append("\n"); 
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
		query.append("select bk.bkg_no" ).append("\n"); 
		query.append("    , BK.BL_NO||NVL(BK.BL_TP_CD, DECODE(ISS.OBL_SRND_FLG, 'Y', 'S', null)) BL_NO" ).append("\n"); 
		query.append("    , bk.bl_tp_cd " ).append("\n"); 
		query.append("    , bk.bl_no_tp" ).append("\n"); 
		query.append("    , bk.vsl_cd||bk.skd_voy_no||skd_dir_cd bkg_vvd" ).append("\n"); 
		query.append("    , bk.por_cd " ).append("\n"); 
		query.append("    , bk.pol_cd " ).append("\n"); 
		query.append("    , bk.pod_cd " ).append("\n"); 
		query.append("    , bk.del_cd " ).append("\n"); 
		query.append("    , bk.sc_no" ).append("\n"); 
		query.append("	, bk.rfa_no" ).append("\n"); 
		query.append("    , bk.svc_scp_cd" ).append("\n"); 
		query.append("    , bk.sam_cnee_ntfy_flg" ).append("\n"); 
		query.append("    , bk.agmt_act_cnt_cd  " ).append("\n"); 
		query.append("    , DECODE(bk.agmt_act_cust_seq,0,'',bk.agmt_act_cust_seq) agmt_act_cust_seq" ).append("\n"); 
		query.append("    , bk.kr_cstms_Cust_tp_cd kr_cstms_cust_tp_cd" ).append("\n"); 
		query.append("    , bk.cust_to_ord_flg cust_to_ord_flg" ).append("\n"); 
		query.append("    , bk.sam_cnee_ntfy_flg" ).append("\n"); 
		query.append("    , bl.org_cnt_nm" ).append("\n"); 
		query.append("    , ff.cust_ref_no_ctnt ff_ref_no" ).append("\n"); 
		query.append("    , fmc.cust_ref_no_ctnt fmc_cd" ).append("\n"); 
		query.append("    , '' frob_flag" ).append("\n"); 
		query.append("	, '' NL_FLAG" ).append("\n"); 
		query.append("    , bk.bkg_sts_cd" ).append("\n"); 
		query.append("    , DECODE(NVL(BL.CORR_NO, 'N'), 'N', 'N', 'Y') CA_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,(SELECT TO_CHAR(" ).append("\n"); 
		query.append("             NVL((" ).append("\n"); 
		query.append("                  SELECT RT_APLY_DT" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("                    FROM BKG_RT_HIS R" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                    FROM BKG_RATE R" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                     AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("					 AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 )," ).append("\n"); 
		query.append("             NVL((" ).append("\n"); 
		query.append("                  SELECT SKD.VPS_ETD_DT" ).append("\n"); 
		query.append("                    FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("                       , BKG_BKG_HIS BK, BKG_VVD_HIS VVD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                       , BKG_BOOKING BK, BKG_VVD VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   WHERE BK.BKG_NO          = @[bkg_no]   " ).append("\n"); 
		query.append("                     AND BK.BKG_NO          = VVD.BKG_NO" ).append("\n"); 
		query.append("                     AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("                     AND VVD.POL_CD         = BK.POL_CD" ).append("\n"); 
		query.append("                     AND VVD.VSL_CD         = SKD.VSL_CD" ).append("\n"); 
		query.append("                     AND VVD.SKD_VOY_NO     = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                     AND VVD.SKD_DIR_CD     = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                     AND VVD.POL_CD         = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                     AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("					 AND BK.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("					 AND BK.CORR_NO = VVD.CORR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					 AND ROWNUM = 1" ).append("\n"); 
		query.append("                 ),SYSDATE" ).append("\n"); 
		query.append("             )),'yyyy-mm-dd')" ).append("\n"); 
		query.append("        FROM DUAL)  AS APPL_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("  from BKG_BKG_HIS bk" ).append("\n"); 
		query.append("      , BKG_BL_DOC_HIS bl" ).append("\n"); 
		query.append("	  , BKG_BL_ISS iss" ).append("\n"); 
		query.append("      , BKG_REF_HIS ff" ).append("\n"); 
		query.append("      , BKG_REF_HIS fmc" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  from bkg_booking bk" ).append("\n"); 
		query.append("      , bkg_bl_doc bl" ).append("\n"); 
		query.append("	  , BKG_BL_ISS iss" ).append("\n"); 
		query.append("      , bkg_reference ff" ).append("\n"); 
		query.append("      , bkg_reference fmc" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" where bk.bkg_no = bl.bkg_no" ).append("\n"); 
		query.append("   and bk.bkg_no = iss.bkg_no(+)" ).append("\n"); 
		query.append("   and bk.bkg_no = ff.bkg_no(+)" ).append("\n"); 
		query.append("   and 'FFNO'    = ff.bkg_Ref_tp_cd(+)" ).append("\n"); 
		query.append("   and bk.bkg_no = fmc.bkg_no(+)" ).append("\n"); 
		query.append("   and 'FMCN'    = fmc.bkg_Ref_tp_cd(+)" ).append("\n"); 
		query.append("   and bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("AND   bk.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND   bl.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}