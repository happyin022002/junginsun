/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterRqstTabRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterRqstTabRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterRqstTab
	  * 2017.08.21 iylee Xter MnD Open 조건에 'Package 값이 있으면 열리도록' 추가
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterRqstTabRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterRqstTabRSQL").append("\n"); 
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
		query.append("SELECT ALPS_BKG, ALPS_CUST, ALPS_CNTR, DECODE(ALPS_CNTR,'Y','Y',DECODE(XTER_CNTR,'Y','Y',ALPS_CM)) ALPS_CM," ).append("\n"); 
		query.append("       ALPS_MND, ALPS_TRO, ALPS_RF, ALPS_DG, ALPS_AWK, ALPS_BB, ALPS_HBL1, ALPS_HBL2," ).append("\n"); 
		query.append("       XTER_BKG, XTER_CUST, XTER_CNTR, XTER_CM," ).append("\n"); 
		query.append("       XTER_MND, XTER_TRO, XTER_RF, XTER_DG, XTER_AWK, XTER_BB, XTER_HBL1, XTER_HBL2" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT    nvl((select 'Y' from bkg_booking bkg where bkg.bkg_no = bk.bkg_no and rownum = 1), 'N') ALPS_BKG" ).append("\n"); 
		query.append("            , 'Y' XTER_BKG" ).append("\n"); 
		query.append("            , nvl((select attr_ctnt3 -- customer tab" ).append("\n"); 
		query.append("                     from bkg_hrd_cdg_ctnt h" ).append("\n"); 
		query.append("                    where hrd_cdg_id = 'EBKG_TAB_BLOCK'" ).append("\n"); 
		query.append("                      and attr_ctnt3 = 'N'" ).append("\n"); 
		query.append("                      and 'B' = (select doc_tp_cd" ).append("\n"); 
		query.append("                                   from bkg_xter_rqst_mst " ).append("\n"); 
		query.append("                                  where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("                                    and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                                    and xter_rqst_seq= @[rqst_seq])" ).append("\n"); 
		query.append("                      and @[usr_ofc_cd] in (select ofc_cd" ).append("\n"); 
		query.append("                                             from mdm_organization" ).append("\n"); 
		query.append("                                            where rownum = decode(h.attr_ctnt2,'N',1,rownum)" ).append("\n"); 
		query.append("                                            start with ofc_cd = h.attr_ctnt1" ).append("\n"); 
		query.append("                                          connect by prior ofc_cd = prnt_ofc_cd))" ).append("\n"); 
		query.append("                   ,nvl((select 'Y' from bkg_customer cust where cust.bkg_no = bk.bkg_no and rownum = 1), 'N')) ALPS_CUST" ).append("\n"); 
		query.append("            , nvl((select attr_ctnt3 -- customer tab" ).append("\n"); 
		query.append("                     from bkg_hrd_cdg_ctnt h" ).append("\n"); 
		query.append("                    where hrd_cdg_id = 'EBKG_TAB_BLOCK'" ).append("\n"); 
		query.append("                      and attr_ctnt3 = 'N'" ).append("\n"); 
		query.append("                      and 'B' = (select doc_tp_cd" ).append("\n"); 
		query.append("                                   from bkg_xter_rqst_mst " ).append("\n"); 
		query.append("                                  where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("                                    and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                                    and xter_rqst_seq= @[rqst_seq])" ).append("\n"); 
		query.append("                      and @[usr_ofc_cd] in (select ofc_cd" ).append("\n"); 
		query.append("                                             from mdm_organization" ).append("\n"); 
		query.append("                                            where rownum = decode(h.attr_ctnt2,'N',1,rownum)" ).append("\n"); 
		query.append("                                            start with ofc_cd = h.attr_ctnt1" ).append("\n"); 
		query.append("                                          connect by prior ofc_cd = prnt_ofc_cd))" ).append("\n"); 
		query.append("                 ,nvl((select 'Y' " ).append("\n"); 
		query.append("                        from bkg_xter_cust " ).append("\n"); 
		query.append("                       where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("                         and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                         and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                         and rownum = 1), 'N')) XTER_CUST" ).append("\n"); 
		query.append("            , nvl((select attr_ctnt4 -- container tab" ).append("\n"); 
		query.append("                     from bkg_hrd_cdg_ctnt h" ).append("\n"); 
		query.append("                    where hrd_cdg_id = 'EBKG_TAB_BLOCK'" ).append("\n"); 
		query.append("                      and attr_ctnt4 = 'N'" ).append("\n"); 
		query.append("                      and 'B' = (select doc_tp_cd" ).append("\n"); 
		query.append("                                   from bkg_xter_rqst_mst " ).append("\n"); 
		query.append("                                  where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("                                    and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                                    and xter_rqst_seq= @[rqst_seq])" ).append("\n"); 
		query.append("                      and @[usr_ofc_cd] in (select ofc_cd" ).append("\n"); 
		query.append("                                             from mdm_organization" ).append("\n"); 
		query.append("                                            where rownum = decode(h.attr_ctnt2,'N',1,rownum)" ).append("\n"); 
		query.append("                                            start with ofc_cd = h.attr_ctnt1" ).append("\n"); 
		query.append("                                          connect by prior ofc_cd = prnt_ofc_cd))" ).append("\n"); 
		query.append("                   ,nvl((select 'Y' from bkg_container cntr where cntr.bkg_no = bk.bkg_no and rownum = 1), 'N')) ALPS_CNTR" ).append("\n"); 
		query.append("            , nvl((select attr_ctnt4 -- container tab" ).append("\n"); 
		query.append("                     from bkg_hrd_cdg_ctnt h" ).append("\n"); 
		query.append("                    where hrd_cdg_id = 'EBKG_TAB_BLOCK'" ).append("\n"); 
		query.append("                      and attr_ctnt4 = 'N'" ).append("\n"); 
		query.append("                      and 'B' = (select doc_tp_cd" ).append("\n"); 
		query.append("                                   from bkg_xter_rqst_mst " ).append("\n"); 
		query.append("                                  where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("                                    and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                                    and xter_rqst_seq= @[rqst_seq])" ).append("\n"); 
		query.append("                      and @[usr_ofc_cd] in (select ofc_cd" ).append("\n"); 
		query.append("                                             from mdm_organization" ).append("\n"); 
		query.append("                                            where rownum = decode(h.attr_ctnt2,'N',1,rownum)" ).append("\n"); 
		query.append("                                            start with ofc_cd = h.attr_ctnt1" ).append("\n"); 
		query.append("                                          connect by prior ofc_cd = prnt_ofc_cd))" ).append("\n"); 
		query.append("                  ,nvl((select 'Y' " ).append("\n"); 
		query.append("                          from bkg_xter_cntr" ).append("\n"); 
		query.append("                         where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("                           and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                           and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                           and rownum = 1), 'N')) XTER_CNTR" ).append("\n"); 
		query.append("            , nvl((select attr_ctnt6 -- cm tab" ).append("\n"); 
		query.append("                     from bkg_hrd_cdg_ctnt h" ).append("\n"); 
		query.append("                    where hrd_cdg_id = 'EBKG_TAB_BLOCK'" ).append("\n"); 
		query.append("                      and attr_ctnt6 = 'N'" ).append("\n"); 
		query.append("                      and 'B' = (select doc_tp_cd" ).append("\n"); 
		query.append("                                   from bkg_xter_rqst_mst " ).append("\n"); 
		query.append("                                  where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("                                    and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                                    and xter_rqst_seq= @[rqst_seq])" ).append("\n"); 
		query.append("                      and @[usr_ofc_cd] in (select ofc_cd" ).append("\n"); 
		query.append("                                             from mdm_organization" ).append("\n"); 
		query.append("                                            where rownum = decode(h.attr_ctnt2,'N',1,rownum)" ).append("\n"); 
		query.append("                                            start with ofc_cd = h.attr_ctnt1" ).append("\n"); 
		query.append("                                          connect by prior ofc_cd = prnt_ofc_cd))" ).append("\n"); 
		query.append("                   ,nvl((select 'Y' from bkg_cntr_mf_desc cm where cm.bkg_no = bk.bkg_no and rownum = 1), 'N')) ALPS_CM" ).append("\n"); 
		query.append("            , nvl((select attr_ctnt6 -- cm tab" ).append("\n"); 
		query.append("                     from bkg_hrd_cdg_ctnt h" ).append("\n"); 
		query.append("                    where hrd_cdg_id = 'EBKG_TAB_BLOCK'" ).append("\n"); 
		query.append("                      and attr_ctnt6 = 'N'" ).append("\n"); 
		query.append("                      and 'B' = (select doc_tp_cd" ).append("\n"); 
		query.append("                                   from bkg_xter_rqst_mst " ).append("\n"); 
		query.append("                                  where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("                                    and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                                    and xter_rqst_seq= @[rqst_seq])" ).append("\n"); 
		query.append("                      and @[usr_ofc_cd] in (select ofc_cd" ).append("\n"); 
		query.append("                                             from mdm_organization" ).append("\n"); 
		query.append("                                            where rownum = decode(h.attr_ctnt2,'N',1,rownum)" ).append("\n"); 
		query.append("                                            start with ofc_cd = h.attr_ctnt1" ).append("\n"); 
		query.append("                                          connect by prior ofc_cd = prnt_ofc_cd))" ).append("\n"); 
		query.append("                   ,nvl((select 'Y' " ).append("\n"); 
		query.append("    			        FROM (" ).append("\n"); 
		query.append("    				     SELECT 'Y'" ).append("\n"); 
		query.append("                          from bkg_xter_cntr_mk_desc" ).append("\n"); 
		query.append("                         where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("                           and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                           and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("    				     UNION ALL" ).append("\n"); 
		query.append("    				     SELECT 'Y'" ).append("\n"); 
		query.append("        			     FROM bkg_xter_rqst_mst mst" ).append("\n"); 
		query.append("       			            , bkg_xter_cntr_mk_desc cm" ).append("\n"); 
		query.append("        			     WHERE CM.xter_rqst_no  = mst.xter_rqst_no" ).append("\n"); 
		query.append("        			       AND CM.xter_rqst_seq = mst.xter_rqst_seq" ).append("\n"); 
		query.append("       				       AND CM.xter_sndr_id  = mst.xter_sndr_id" ).append("\n"); 
		query.append("        			       AND mst.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("         			       and mst.xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("        			       and mst.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("        			       AND mst.xter_bl_tp_cd= 'H' )" ).append("\n"); 
		query.append("                         WHERE rownum = 1), 'N')) XTER_CM" ).append("\n"); 
		query.append("            , nvl((select attr_ctnt5 -- mnd tab" ).append("\n"); 
		query.append("                     from bkg_hrd_cdg_ctnt h" ).append("\n"); 
		query.append("                    where hrd_cdg_id = 'EBKG_TAB_BLOCK'" ).append("\n"); 
		query.append("                      and attr_ctnt5 = 'N'" ).append("\n"); 
		query.append("                      and 'B' = (select doc_tp_cd" ).append("\n"); 
		query.append("                                   from bkg_xter_rqst_mst " ).append("\n"); 
		query.append("                                  where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("                                    and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                                    and xter_rqst_seq= @[rqst_seq])" ).append("\n"); 
		query.append("                      and @[usr_ofc_cd] in (select ofc_cd" ).append("\n"); 
		query.append("                                             from mdm_organization" ).append("\n"); 
		query.append("                                            where rownum = decode(h.attr_ctnt2,'N',1,rownum)" ).append("\n"); 
		query.append("                                            start with ofc_cd = h.attr_ctnt1" ).append("\n"); 
		query.append("                                          connect by prior ofc_cd = prnt_ofc_cd))" ).append("\n"); 
		query.append("                  ,nvl((select 'Y' from bkg_bl_mk_desc mnd where mnd.bkg_no = bk.bkg_no and rownum = 1), 'N')) ALPS_MND" ).append("\n"); 
		query.append("            , nvl(NVL((SELECT 'Y'" ).append("\n"); 
		query.append("      					FROM BKG_XTER_AES " ).append("\n"); 
		query.append("     					WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("       					AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("       					AND XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("       					AND ( AES_INLND_TRNS_NO IS NOT NULL OR AES_PTA_PFX_CTNT IS NOT NULL OR AES_PTA_NO1 IS NOT NULL OR AES_PTA_NO2 IS NOT NULL OR AES_PTA_DT IS NOT NULL OR" ).append("\n"); 
		query.append("             					AES_PTU_PFX_CTNT IS NOT NULL OR AES_PTU_NO IS NOT NULL OR AES_PTU_DT IS NOT NULL OR AES_DWN_PFX_CTNT IS NOT NULL OR AES_DWN_NO IS NOT NULL OR" ).append("\n"); 
		query.append("             					AES_DWN_DT IS NOT NULL OR AES_EXPT_CTNT IS NOT NULL OR ENTR_CLSS_TP_CD IS NOT NULL OR ENTR_CLSS_RMK IS NOT NULL OR AES_EXPT_ID IS NOT NULL OR" ).append("\n"); 
		query.append("             					VIN_CTNT IS NOT NULL )" ).append("\n"); 
		query.append("     					UNION" ).append("\n"); 
		query.append("    					SELECT 'Y'" ).append("\n"); 
		query.append("      					FROM BKG_XTER_CAED" ).append("\n"); 
		query.append("    					 WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("       					AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("       					AND XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("       					AND ( CAED_CTNT1 IS NOT NULL OR CAED_CTNT2 IS NOT NULL OR CAED_CTNT3 IS NOT NULL OR G7_EDI_CTNT1 IS NOT NULL OR G7_EDI_CTNT2 IS NOT NULL OR" ).append("\n"); 
		query.append("             				SMRY_RPT_CTNT1 IS NOT NULL OR SMRY_RPT_CTNT2 IS NOT NULL OR B13A_DT IS NOT NULL OR B13A_CTNT1 IS NOT NULL OR B13A_CTNT2 IS NOT NULL OR" ).append("\n"); 
		query.append("             					INLND_TZ_CGO_CTNT IS NOT NULL OR MNL_INP_CTNT IS NOT NULL OR NON_DECL_CTNT IS NOT NULL )" ).append("\n"); 
		query.append("     					UNION    " ).append("\n"); 
		query.append("    					SELECT 'Y'" ).append("\n"); 
		query.append("      					FROM BKG_XTER_XPT_LIC_NO WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("       					AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("       					AND XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("						AND ROWNUM =1 " ).append("\n"); 
		query.append("						UNION" ).append("\n"); 
		query.append("                        SELECT 'Y'" ).append("\n"); 
		query.append("                        FROM BKG_XTER_RQST_MST WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("                        AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("                        AND XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("                        AND DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("                        AND PCK_QTY IS NOT NULL" ).append("\n"); 
		query.append("                        AND ROWNUM = 1),(select attr_ctnt5 -- mnd tab" ).append("\n"); 
		query.append("                     from bkg_hrd_cdg_ctnt h" ).append("\n"); 
		query.append("                    where hrd_cdg_id = 'EBKG_TAB_BLOCK'" ).append("\n"); 
		query.append("                      and attr_ctnt5 = 'N'" ).append("\n"); 
		query.append("                      and 'B' = (select doc_tp_cd" ).append("\n"); 
		query.append("                                   from bkg_xter_rqst_mst " ).append("\n"); 
		query.append("                                  where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("                                    and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                                    and xter_rqst_seq= @[rqst_seq])" ).append("\n"); 
		query.append("                      and @[usr_ofc_cd] in (select ofc_cd" ).append("\n"); 
		query.append("                                             from mdm_organization" ).append("\n"); 
		query.append("                                            where rownum = decode(h.attr_ctnt2,'N',1,rownum)" ).append("\n"); 
		query.append("                                            start with ofc_cd = h.attr_ctnt1" ).append("\n"); 
		query.append("                                          connect by prior ofc_cd = prnt_ofc_cd))" ).append("\n"); 
		query.append("                  ),'Y') XTER_MND" ).append("\n"); 
		query.append("            , nvl((select 'Y' from bkg_tro tro where tro.bkg_no = bk.bkg_no and rownum = 1" ).append("\n"); 
		query.append("                    union" ).append("\n"); 
		query.append("                    select 'Y' from bkg_eur_tro tro where tro.bkg_no = bk.bkg_no and rownum = 1), 'N') ALPS_TRO" ).append("\n"); 
		query.append("            , nvl((select 'Y' " ).append("\n"); 
		query.append("                     from bkg_xter_tro t" ).append("\n"); 
		query.append("                    where t.xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("                      and t.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                      and t.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                      and (t.xter_sndr_id, t.xter_rqst_no, t.xter_rqst_seq) not in " ).append("\n"); 
		query.append("							(select m.xter_sndr_id, m.xter_rqst_no, m.xter_rqst_seq" ).append("\n"); 
		query.append("							  from bkg_xter_rqst_mst m" ).append("\n"); 
		query.append("							  where m.xter_sndr_id = t.xter_sndr_id" ).append("\n"); 
		query.append("							  and m.xter_rqst_no = t.xter_rqst_no" ).append("\n"); 
		query.append("							  and m.xter_rqst_seq = t.xter_rqst_seq" ).append("\n"); 
		query.append("							  and ( m.rcv_term_cd <> 'D'" ).append("\n"); 
		query.append("								and  (m.por_cd like 'US%' or m.pol_cd like 'US%')" ).append("\n"); 
		query.append("								   )" ).append("\n"); 
		query.append("						   )" ).append("\n"); 
		query.append("                      and rownum = 1), 'N') XTER_TRO" ).append("\n"); 
		query.append("            , nvl((select 'Y' from bkg_rf_cgo rf where rf.bkg_no = bk.bkg_no and rownum = 1), 'N') ALPS_RF" ).append("\n"); 
		query.append("            , nvl((select 'Y' " ).append("\n"); 
		query.append("                     from bkg_xter_rf_cgo" ).append("\n"); 
		query.append("                    where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("                      and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                      and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                      and rownum = 1), 'N') XTER_RF" ).append("\n"); 
		query.append("            , nvl((select 'Y' from bkg_dg_cgo dg where dg.bkg_no = bk.bkg_no and rownum = 1), 'N') ALPS_DG" ).append("\n"); 
		query.append("            , nvl((select 'Y' " ).append("\n"); 
		query.append("                     from bkg_xter_dg_cgo" ).append("\n"); 
		query.append("                    where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("                      and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                      and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                      and rownum = 1), 'N') XTER_DG" ).append("\n"); 
		query.append("            , nvl((select 'Y' from bkg_awk_cgo awk where awk.bkg_no = bk.bkg_no and rownum = 1), 'N') ALPS_AWK" ).append("\n"); 
		query.append("            , nvl((select 'Y' " ).append("\n"); 
		query.append("                     from bkg_xter_awk_cgo" ).append("\n"); 
		query.append("                    where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("                      and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                      and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                      and rownum = 1), 'N') XTER_AWK" ).append("\n"); 
		query.append("            , nvl((select 'Y' from bkg_bb_cgo bb where bb.bkg_no = bk.bkg_no and rownum = 1), 'N') ALPS_BB" ).append("\n"); 
		query.append("            , nvl((select 'Y' " ).append("\n"); 
		query.append("                     from bkg_xter_bb_cgo" ).append("\n"); 
		query.append("                    where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("                      and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                      and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                      and rownum = 1), 'N') XTER_BB" ).append("\n"); 
		query.append("            , nvl((select 'Y' from bkg_hbl hbl1 where hbl1.bkg_no = bk.bkg_no and rownum = 1), 'N') ALPS_HBL1" ).append("\n"); 
		query.append("            , nvl((select 'Y'" ).append("\n"); 
		query.append("                     from bkg_xter_rqst_mst xter" ).append("\n"); 
		query.append("                    where xter.bkg_no   = bk.bkg_no" ).append("\n"); 
		query.append("                      and xter_sndr_id  = @[sender_id]" ).append("\n"); 
		query.append("                      and xter_rqst_seq = @[rqst_seq]" ).append("\n"); 
		query.append("                      and nvl(xter_bl_tp_cd, 'X') = 'H'" ).append("\n"); 
		query.append("                      and xter_rqst_via_cd = (SELECT XTER_RQST_VIA_CD" ).append("\n"); 
		query.append("                                                FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("                                               WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("                                                 AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("                                                 AND xter_rqst_seq= @[rqst_seq])" ).append("\n"); 
		query.append("                      and rownum = 1), 'N') XTER_HBL1" ).append("\n"); 
		query.append("            , nvl((select 'Y' " ).append("\n"); 
		query.append("                     from bkg_usa_cstms_file_no hbl2 " ).append("\n"); 
		query.append("    				where hbl2.bkg_no = bk.bkg_no " ).append("\n"); 
		query.append("       				  AND USA_CSTMS_FILE_NO IS NOT NULL" ).append("\n"); 
		query.append("    				  and rownum = 1), 'N') ALPS_HBL2        " ).append("\n"); 
		query.append("            , nvl((select 'Y'" ).append("\n"); 
		query.append("                     from bkg_xter_rqst_mst xter" ).append("\n"); 
		query.append("                    where xter.bkg_no   = bk.bkg_no" ).append("\n"); 
		query.append("                      and xter_rqst_seq = @[rqst_seq]" ).append("\n"); 
		query.append("       				  AND USA_CSTMS_FILE_NO IS NOT NULL" ).append("\n"); 
		query.append("                      and nvl(xter_bl_tp_cd, 'N') = 'H'" ).append("\n"); 
		query.append("                      and rownum = 1), 'N') XTER_HBL2" ).append("\n"); 
		query.append("      FROM DUAL, (select NVL(@[bkg_no],bkg_no) bkg_no" ).append("\n"); 
		query.append("    			    from bkg_xter_rqst_mst" ).append("\n"); 
		query.append("    			   where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("    			     and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("    			     and xter_rqst_seq= @[rqst_seq]) bk" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}