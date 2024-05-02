/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchOpusCmRSQL.java
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

public class EBookingReceiptDBDAOsearchOpusCmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOpusCm
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchOpusCmRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchOpusCmRSQL").append("\n"); 
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
		query.append("select cm.cntr_no" ).append("\n"); 
		query.append(", cm.pck_qty" ).append("\n"); 
		query.append(", cm.pck_tp_cd" ).append("\n"); 
		query.append(", cm.cntr_mf_wgt" ).append("\n"); 
		query.append(", cm.wgt_ut_cd" ).append("\n"); 
		query.append(", cm.meas_qty" ).append("\n"); 
		query.append(", cm.meas_ut_cd" ).append("\n"); 
		query.append(", cm.cntr_mf_seq cntr_mf_seq" ).append("\n"); 
		query.append(", nvl(cm.hamo_trf_cd, ' ') hamo_trf_cd" ).append("\n"); 
		query.append(", nvl(cm.ncm_no, '  ') ncm_no" ).append("\n"); 
		query.append(", nvl(ref.cust_ref_no_ctnt, '   ') po_no" ).append("\n"); 
		query.append(", '  ' cntr_mf_dtl_desc" ).append("\n"); 
		query.append(", cntr_mf_gds_desc" ).append("\n"); 
		query.append(", cntr_mf_mk_desc" ).append("\n"); 
		query.append(", cm.CNTR_MF_NO" ).append("\n"); 
		query.append(", cm.DCGO_SEQ" ).append("\n"); 
		query.append(", nvl(cm.CMDT_HS_CD, ' ') CMDT_HS_CD" ).append("\n"); 
		query.append("from bkg_cntr_mf_desc cm, bkg_reference ref" ).append("\n"); 
		query.append("where cm.bkg_no        = ref.bkg_no        (+)" ).append("\n"); 
		query.append("and cm.cntr_mf_seq   = ref.cntr_mf_seq   (+)" ).append("\n"); 
		query.append("and 'CMPO'           = ref.bkg_ref_tp_cd (+)" ).append("\n"); 
		query.append("and cm.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("order by cm.cntr_no, cm.cntr_mf_seq, cm.pck_qty, cm.cntr_mf_wgt, cm.meas_qty, cm.cntr_mf_mk_desc, cm.cntr_mf_gds_desc" ).append("\n"); 

	}
}