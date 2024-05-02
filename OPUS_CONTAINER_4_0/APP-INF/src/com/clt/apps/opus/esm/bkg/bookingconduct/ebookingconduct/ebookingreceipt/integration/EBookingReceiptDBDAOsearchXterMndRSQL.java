/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterMndRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterMndRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterMnd
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterMndRSQL(){
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
		params.put("usr_ofc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterMndRSQL").append("\n"); 
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
		query.append("SELECT NVL(( SELECT MK_DESC" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID = mst.XTER_SNDR_ID" ).append("\n"); 
		query.append("AND BKG_NO = mst.BKG_NO" ).append("\n"); 
		query.append("AND NVL(SNACCS_SPLIT_NO,'0') = NVL(mst.SNACCS_SPLIT_NO,'0')" ).append("\n"); 
		query.append("AND SNACCS_MSG_TP_CD IN ( 'SAT050', 'SAT054' )" ).append("\n"); 
		query.append("AND XTER_SNDR_ID = 'SEANACCS'" ).append("\n"); 
		query.append("AND ROWNUM = 1 )," ).append("\n"); 
		query.append("mst.MK_DESC ) AS MK_DESC" ).append("\n"); 
		query.append(", PCK_QTY" ).append("\n"); 
		query.append(", PCK_TP_CD" ).append("\n"); 
		query.append(", ESTM_WGT ACT_WGT" ).append("\n"); 
		query.append(", ESTM_WGT_UT_CD WGT_UT_CD" ).append("\n"); 
		query.append(", MEAS_QTY" ).append("\n"); 
		query.append(", MEAS_UT_CD" ).append("\n"); 
		query.append(", GDS_DESC CMDT_DESC" ).append("\n"); 
		query.append(", MISC_DESC" ).append("\n"); 
		query.append(", decode(nvl(misc_desc, 'N'), 'N', 'N', 'Y') misc--misc.information flag활성화 flag" ).append("\n"); 
		query.append(", decode((select 'Y'" ).append("\n"); 
		query.append("from bkg_xter_aes" ).append("\n"); 
		query.append("where xter_sndr_id  = mst.xter_sndr_id" ).append("\n"); 
		query.append("and xter_rqst_no  = mst.xter_rqst_no" ).append("\n"); 
		query.append("and xter_rqst_seq = mst.xter_rqst_seq" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select 'Y'" ).append("\n"); 
		query.append("from bkg_xter_caed" ).append("\n"); 
		query.append("where xter_sndr_id  = mst.xter_sndr_id" ).append("\n"); 
		query.append("and xter_rqst_no  = mst.xter_rqst_no" ).append("\n"); 
		query.append("and xter_rqst_seq = mst.xter_rqst_seq" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select 'Y'" ).append("\n"); 
		query.append("from bkg_xter_xpt_lic_no" ).append("\n"); 
		query.append("where xter_sndr_id  = mst.xter_sndr_id" ).append("\n"); 
		query.append("and xter_rqst_no  = mst.xter_rqst_no" ).append("\n"); 
		query.append("and xter_rqst_seq = mst.xter_rqst_seq" ).append("\n"); 
		query.append("and rownum = 1), 'Y', 'Y', 'N') xpt_imp --export import information 활성화 flag" ).append("\n"); 
		query.append(", PO_NO BKPO2" ).append("\n"); 
		query.append(", LC_NO LCNO2" ).append("\n"); 
		query.append(", INV_NO_CTNT HINV2" ).append("\n"); 
		query.append(", TO_CHAR(LC_EXP_DT, 'YYYY-MM-DD') LCDT2" ).append("\n"); 
		query.append(", decode(nvl(po_no||lc_no||inv_no_ctnt||to_char(lc_exp_dt), 'N'), 'N', 'N', 'Y') PO_No --P/O Other No 활성화 flag" ).append("\n"); 
		query.append(", 'N' rider --B/L Rider 활성화 flag" ).append("\n"); 
		query.append(", nvl(nvl(por_cd, pol_cd), (select loc_cd from mdm_organization where ofc_cd = @[usr_ofc])) pol_cd" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST mst" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 

	}
}