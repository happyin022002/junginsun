/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterRqstTabRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.18 
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

public class EBookingReceiptDBDAOsearchXterRqstTabRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterRqstTab
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
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
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
		query.append("SELECT OPUS_BKG, OPUS_CUST, OPUS_CNTR, DECODE(OPUS_CNTR,'Y','Y',DECODE(XTER_CNTR,'Y','Y',OPUS_CM)) OPUS_CM," ).append("\n"); 
		query.append("OPUS_MND, OPUS_TRO, OPUS_RF, OPUS_DG, OPUS_AWK, OPUS_HBL1, OPUS_HBL2," ).append("\n"); 
		query.append("XTER_BKG, XTER_CUST, XTER_CNTR, XTER_CM," ).append("\n"); 
		query.append("XTER_MND, XTER_TRO, XTER_RF, XTER_DG, XTER_AWK, XTER_HBL1, XTER_HBL2" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT    nvl((select 'Y' from bkg_booking bkg where bkg.bkg_no = bk.bkg_no and rownum = 1), 'N') OPUS_BKG" ).append("\n"); 
		query.append(", 'Y' XTER_BKG" ).append("\n"); 
		query.append(", nvl((select 'Y' from bkg_customer cust where cust.bkg_no = bk.bkg_no and rownum = 1), 'N') OPUS_CUST" ).append("\n"); 
		query.append(", nvl((select 'Y'" ).append("\n"); 
		query.append("from bkg_xter_cust" ).append("\n"); 
		query.append("where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("and rownum = 1), 'N') XTER_CUST" ).append("\n"); 
		query.append(", nvl((select 'Y' from bkg_container cntr where cntr.bkg_no = bk.bkg_no and rownum = 1), 'N') OPUS_CNTR" ).append("\n"); 
		query.append(", nvl((select 'Y'" ).append("\n"); 
		query.append("from bkg_xter_cntr" ).append("\n"); 
		query.append("where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("and rownum = 1), 'N') XTER_CNTR" ).append("\n"); 
		query.append(", nvl((select 'Y' from bkg_cntr_mf_desc cm where cm.bkg_no = bk.bkg_no and rownum = 1), 'N') OPUS_CM" ).append("\n"); 
		query.append(", nvl((select 'Y'" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append("from bkg_xter_cntr_mk_desc" ).append("\n"); 
		query.append("where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append("FROM bkg_xter_rqst_mst mst" ).append("\n"); 
		query.append(", bkg_xter_cntr_mk_desc cm" ).append("\n"); 
		query.append("WHERE CM.xter_rqst_no  = mst.xter_rqst_no" ).append("\n"); 
		query.append("AND CM.xter_rqst_seq = mst.xter_rqst_seq" ).append("\n"); 
		query.append("AND CM.xter_sndr_id  = mst.xter_sndr_id" ).append("\n"); 
		query.append("AND mst.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("and mst.xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("and mst.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("AND mst.xter_bl_tp_cd= 'H' )" ).append("\n"); 
		query.append("WHERE rownum = 1), 'N') XTER_CM" ).append("\n"); 
		query.append(", nvl((select 'Y' from bkg_bl_mk_desc mnd where mnd.bkg_no = bk.bkg_no and rownum = 1), 'N') OPUS_MND" ).append("\n"); 
		query.append(", 'Y' XTER_MND" ).append("\n"); 
		query.append(", nvl((select 'Y' from bkg_tro tro where tro.bkg_no = bk.bkg_no and rownum = 1" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select 'Y' from bkg_eur_tro tro where tro.bkg_no = bk.bkg_no and rownum = 1), 'N') OPUS_TRO" ).append("\n"); 
		query.append(", nvl((select 'Y'" ).append("\n"); 
		query.append("from bkg_xter_tro" ).append("\n"); 
		query.append("where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("and rownum = 1), 'N') XTER_TRO" ).append("\n"); 
		query.append(", nvl((select 'Y' from bkg_rf_cgo rf where rf.bkg_no = bk.bkg_no and rownum = 1), 'N') OPUS_RF" ).append("\n"); 
		query.append(", nvl((select 'Y'" ).append("\n"); 
		query.append("from bkg_xter_rf_cgo" ).append("\n"); 
		query.append("where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("and rownum = 1), 'N') XTER_RF" ).append("\n"); 
		query.append(", nvl((select 'Y' from bkg_dg_cgo dg where dg.bkg_no = bk.bkg_no and rownum = 1), 'N') OPUS_DG" ).append("\n"); 
		query.append(", nvl((select 'Y'" ).append("\n"); 
		query.append("from bkg_xter_dg_cgo" ).append("\n"); 
		query.append("where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("and rownum = 1), 'N') XTER_DG" ).append("\n"); 
		query.append(", nvl((select 'Y' from bkg_awk_cgo awk where awk.bkg_no = bk.bkg_no and rownum = 1), 'N') OPUS_AWK" ).append("\n"); 
		query.append(", nvl((select 'Y'" ).append("\n"); 
		query.append("from bkg_xter_awk_cgo" ).append("\n"); 
		query.append("where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("and rownum = 1), 'N') XTER_AWK" ).append("\n"); 
		query.append(", nvl((select 'Y' from bkg_hbl hbl1 where hbl1.bkg_no = bk.bkg_no and rownum = 1), 'N') OPUS_HBL1" ).append("\n"); 
		query.append(", nvl((select 'Y'" ).append("\n"); 
		query.append("from bkg_xter_rqst_mst xter" ).append("\n"); 
		query.append("where xter.bkg_no   = bk.bkg_no" ).append("\n"); 
		query.append("and xter_sndr_id  = @[sender_id]" ).append("\n"); 
		query.append("and xter_rqst_seq = @[rqst_seq]" ).append("\n"); 
		query.append("and nvl(xter_bl_tp_cd, 'X') = 'H'" ).append("\n"); 
		query.append("and xter_rqst_via_cd = (SELECT XTER_RQST_VIA_CD" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND xter_rqst_seq= @[rqst_seq])" ).append("\n"); 
		query.append("and rownum = 1), 'N') XTER_HBL1" ).append("\n"); 
		query.append(", nvl((select 'Y'" ).append("\n"); 
		query.append("from bkg_usa_cstms_file_no hbl2" ).append("\n"); 
		query.append("where hbl2.bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("AND USA_CSTMS_FILE_NO IS NOT NULL" ).append("\n"); 
		query.append("and rownum = 1), 'N') OPUS_HBL2" ).append("\n"); 
		query.append(", nvl((select 'Y'" ).append("\n"); 
		query.append("from bkg_xter_rqst_mst xter" ).append("\n"); 
		query.append("where xter.bkg_no   = bk.bkg_no" ).append("\n"); 
		query.append("and xter_rqst_seq = @[rqst_seq]" ).append("\n"); 
		query.append("AND USA_CSTMS_FILE_NO IS NOT NULL" ).append("\n"); 
		query.append("and nvl(xter_bl_tp_cd, 'N') = 'H'" ).append("\n"); 
		query.append("and rownum = 1), 'N') XTER_HBL2" ).append("\n"); 
		query.append("FROM DUAL, (select NVL(@[bkg_no],bkg_no) bkg_no" ).append("\n"); 
		query.append("from bkg_xter_rqst_mst" ).append("\n"); 
		query.append("where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("and xter_rqst_seq= @[rqst_seq]) bk" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}