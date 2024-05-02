/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterCmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.15
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.02.15 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterCmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterCm
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterCmRSQL(){
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
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterCmRSQL").append("\n"); 
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
		query.append("SELECT CNTR_SEQ" ).append("\n"); 
		query.append("        , mk_desc_seq cntr_mf_seq" ).append("\n"); 
		query.append("        ,cntr_no" ).append("\n"); 
		query.append("        , pck_qty " ).append("\n"); 
		query.append("        , pck_tp_cd " ).append("\n"); 
		query.append("        , cntr_mf_wgt" ).append("\n"); 
		query.append("        , wgt_ut_cd" ).append("\n"); 
		query.append("        , meas_qty " ).append("\n"); 
		query.append("        , meas_ut_cd " ).append("\n"); 
		query.append("        , replace(nvl(hamo_trf_ctnt, ' '),'.','') hamo_trf_cd" ).append("\n"); 
		query.append("        , nvl(ncm_no, ' ') ncm_no" ).append("\n"); 
		query.append("        , '  ' po_no" ).append("\n"); 
		query.append("        , nvl(REPLACE(marks, '@@', CHR(10)), ' ') cntr_mf_mk_desc " ).append("\n"); 
		query.append("        , nvl(REPLACE(description, '@@', CHR(10)), ' ') cntr_mf_gds_desc" ).append("\n"); 
		query.append("        , nvl(REPLACE(dtl_desc, '@@', CHR(10)), '  ') cntr_mf_dtl_desc " ).append("\n"); 
		query.append("		, nvl(DCGO_SEQ,'') DCGO_SEQ" ).append("\n"); 
		query.append("		, nvl(CMDT_HS_CD,'   ') CMDT_HS_CD" ).append("\n"); 
		query.append("		, '   ' CNTR_MF_NO" ).append("\n"); 
		query.append("FROM ( /* for Master BKG */" ).append("\n"); 
		query.append("    SELECT xter_Rqst_No " ).append("\n"); 
		query.append("        , xter_Rqst_Seq " ).append("\n"); 
		query.append("        , cntr_no " ).append("\n"); 
		query.append("        , mk_desc_seq " ).append("\n"); 
		query.append("        , pck_qty" ).append("\n"); 
		query.append("        , pck_tp_cd " ).append("\n"); 
		query.append("        , cntr_mf_wgt " ).append("\n"); 
		query.append("        , wgt_ut_cd " ).append("\n"); 
		query.append("        , meas_qty" ).append("\n"); 
		query.append("        , meas_ut_cd" ).append("\n"); 
		query.append("        , cntr_mf_mk_desc marks" ).append("\n"); 
		query.append("        , cntr_mf_desc description" ).append("\n"); 
		query.append("        , cntr_mf_dtl_desc dtl_desc" ).append("\n"); 
		query.append("        , hamo_trf_ctnt" ).append("\n"); 
		query.append("        , ncm_no" ).append("\n"); 
		query.append("		, CMDT_HS_CD" ).append("\n"); 
		query.append("		, DCGO_SEQ" ).append("\n"); 
		query.append("		, CNTR_SEQ" ).append("\n"); 
		query.append("    FROM bkg_xter_cntr_mk_desc" ).append("\n"); 
		query.append("    where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("      and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("      and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("    UNION ALL /* for H/BL */" ).append("\n"); 
		query.append("    SELECT CM.xter_rqst_no " ).append("\n"); 
		query.append("        , CM.xter_rqst_seq " ).append("\n"); 
		query.append("        , cm.cntr_no" ).append("\n"); 
		query.append("        ,  cm.mk_desc_seq " ).append("\n"); 
		query.append("        , CM.pck_qty " ).append("\n"); 
		query.append("        , CM.Pck_tp_cd " ).append("\n"); 
		query.append("        , CM.cntr_mf_wgt" ).append("\n"); 
		query.append("        , CM.wgt_ut_cd " ).append("\n"); 
		query.append("        , CM.meas_QTY " ).append("\n"); 
		query.append("        , CM.meas_ut_cd " ).append("\n"); 
		query.append("        , CM.cntr_mf_mk_desc marks " ).append("\n"); 
		query.append("        , CM.cntr_mf_desc description " ).append("\n"); 
		query.append("        , CM.cntr_mf_dtl_desc dtl_desc " ).append("\n"); 
		query.append("        , CM.hamo_trf_ctnt" ).append("\n"); 
		query.append("        , CM.ncm_no" ).append("\n"); 
		query.append("		, cm.CMDT_HS_CD" ).append("\n"); 
		query.append("		, cm.DCGO_SEQ" ).append("\n"); 
		query.append("		, null CNTR_SEQ" ).append("\n"); 
		query.append("    FROM bkg_xter_rqst_mst mst" ).append("\n"); 
		query.append("        , bkg_xter_cntr_mk_desc cm" ).append("\n"); 
		query.append("    WHERE CM.xter_rqst_no  = mst.xter_rqst_no" ).append("\n"); 
		query.append("      AND CM.xter_rqst_seq = mst.xter_rqst_seq" ).append("\n"); 
		query.append("      AND CM.xter_sndr_id  = mst.xter_sndr_id" ).append("\n"); 
		query.append("      AND mst.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("      and mst.xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("      and mst.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("      AND mst.xter_bl_tp_cd= 'H' " ).append("\n"); 
		query.append("	  AND 0 = ( SELECT COUNT(*)    " ).append("\n"); 
		query.append("    			  FROM bkg_xter_cntr_mk_desc" ).append("\n"); 
		query.append("    			 where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("     			   and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("      			   and xter_rqst_seq= @[rqst_seq] )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY CNTR_SEQ, mk_desc_seq" ).append("\n"); 

	}
}