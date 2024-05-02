/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchHandlingOfcRSQL.java
*@FileTitle : e-Booking & SI Process Detail(TRO/O)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.22 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Yong Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchHandlingOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchHandlingOfc
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchHandlingOfcRSQL(){
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
		query.append("SELECT OFC" ).append("\n");
		query.append("from" ).append("\n");
		query.append("(select rank, case when rank =  1 then ofc.ofc" ).append("\n");
		query.append("when rank <> 1 then nvl(CTRL_OFC_CD, ofc.ofc) end ofc" ).append("\n");
		query.append("from" ).append("\n");
		query.append("(SELECT 1 RANK, BK.BKG_OFC_CD OFC" ).append("\n");
		query.append("FROM BKG_BOOKING BK, BKG_XTER_RQST_MST MST" ).append("\n");
		query.append("WHERE MST.BKG_NO       = BK.BKG_NO" ).append("\n");
		query.append("AND MST.XTER_SNDR_ID = @[sender_id]" ).append("\n");
		query.append("and mst.xter_rqst_no = @[rqst_no]" ).append("\n");
		query.append("and mst.xter_rqst_seq= @[rqst_seq]" ).append("\n");
		query.append("AND MST.DOC_TP_CD = 'S'" ).append("\n");
		query.append("UNION" ).append("\n");
		query.append("select 2 rank, mdm_cust.OFC_CD ofc" ).append("\n");
		query.append("from bkg_xter_cust cust, mdm_customer mdm_cust" ).append("\n");
		query.append("where cust.XTER_SNDR_ID = @[sender_id]" ).append("\n");
		query.append("and cust.xter_rqst_no = @[rqst_no]" ).append("\n");
		query.append("and cust.xter_rqst_seq= @[rqst_seq]" ).append("\n");
		query.append("and cust.xter_cust_tp_cd = 'S'" ).append("\n");
		query.append("and cust.cnt_cd       = mdm_cust.cust_cnt_cd" ).append("\n");
		query.append("and cust.cust_seq     = mdm_cust.cust_seq" ).append("\n");
		query.append("union" ).append("\n");
		query.append("select 3 rank, nvl(por.SLS_OFC_CD, pol.sls_ofc_cd) ofc" ).append("\n");
		query.append("from bkg_xter_rqst_mst mst, mdm_location por, mdm_location pol" ).append("\n");
		query.append("where MST.XTER_SNDR_ID = @[sender_id]" ).append("\n");
		query.append("and mst.xter_rqst_no = @[rqst_no]" ).append("\n");
		query.append("and mst.xter_rqst_seq= @[rqst_seq]" ).append("\n");
		query.append("and mst.por_cd       = por.loc_cd(+)" ).append("\n");
		query.append("and mst.por_cd       = pol.loc_cd(+)" ).append("\n");
		query.append(") ofc, BKG_ESVC_CTRL_OFC ctrl" ).append("\n");
		query.append("where ofc.ofc = ctrl.CTRL_OFC_CD(+)" ).append("\n");
		query.append("order by rank" ).append("\n");
		query.append(")" ).append("\n");
		query.append("where rownum = 1" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n");
		query.append("FileName : EBookingReceiptDBDAOsearchHandlingOfcRSQL").append("\n");
		query.append("*/").append("\n");
	}
}