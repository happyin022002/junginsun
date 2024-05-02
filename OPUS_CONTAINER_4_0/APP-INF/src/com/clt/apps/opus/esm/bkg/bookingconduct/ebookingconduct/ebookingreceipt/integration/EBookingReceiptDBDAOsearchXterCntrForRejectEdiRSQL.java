/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterCntrForRejectEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.01
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.06.01 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE, do hyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterCntrForRejectEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterCntrForRejectEdi
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterCntrForRejectEdiRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterCntrForRejectEdiRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("    cntr.CNTR_NO	       a_cntr_no              " ).append("\n"); 
		query.append("    , cntr.CNTR_TPSZ_CD	   a_cntr_tpsz            " ).append("\n"); 
		query.append("    , seal.XTER_CNTR_SEAL_NO	   a_seal_no              " ).append("\n"); 
		query.append("    , NULL	               a_cntr_rind            " ).append("\n"); 
		query.append("    , NULL	               a_cntr_dind            " ).append("\n"); 
		query.append("    , NULL	               a_cntr_aind            " ).append("\n"); 
		query.append("    , NULL	               a_cntr_bind            " ).append("\n"); 
		query.append("    , TRIM(TO_CHAR(cntr.cntr_wgt,'99999999.999'))	a_cntr_wgt_qty         " ).append("\n"); 
		query.append("    , cntr.wgt_ut_cd       a_cntr_wgt_tp          " ).append("\n"); 
		query.append("    , NULL	               a_cntr_temp            " ).append("\n"); 
		query.append("    , NULL	               a_cntr_tun             " ).append("\n"); 
		query.append("    , NULL	               a_cntr_temp_c          " ).append("\n"); 
		query.append("    , NULL	               a_cntr_tun_c           " ).append("\n"); 
		query.append("    , NULL	               a_cntr_rf_voltage      " ).append("\n"); 
		query.append("    , NULL	               a_cntr_vent            " ).append("\n"); 
		query.append("    , NULL	               a_cntr_humid           " ).append("\n"); 
		query.append("    , NULL	               a_cntr_genset          " ).append("\n"); 
		query.append("    , NULL	               a_cntr_rf_remark       " ).append("\n"); 
		query.append("    , NULL	               a_cntr_rfdry_ind       " ).append("\n"); 
		query.append("    , NULL	               a_cntr_ovf             " ).append("\n"); 
		query.append("    , NULL	               a_cntr_ovr             " ).append("\n"); 
		query.append("    , NULL	               a_cntr_ovh             " ).append("\n"); 
		query.append("    , NULL	               a_cntr_ovlw            " ).append("\n"); 
		query.append("    , NULL	               a_cntr_ovrw            " ).append("\n"); 
		query.append("    , NULL	               a_cntr_ovwgt           " ).append("\n"); 
		query.append("    , NULL	               a_cntr_void_slot       " ).append("\n"); 
		query.append("    , NULL	               a_cntr_stwg_req        " ).append("\n"); 
		query.append("    , NULL	               a_cntr_ttl_dim_len     " ).append("\n"); 
		query.append("    , NULL	               a_cntr_ttl_dim_wdt     " ).append("\n"); 
		query.append("    , NULL	               a_cntr_ttl_dim_hgt     " ).append("\n"); 
		query.append("    , NULL	               a_cntr_trm_type        " ).append("\n"); 
		query.append("    , NULL	               a_cntr_trm_weight      " ).append("\n"); 
		query.append("    , NULL	               a_cntr_trm_haulage     " ).append("\n"); 
		query.append("    , NULL	               a_cntr_trm_hmode       " ).append("\n"); 
		query.append("    , NULL	               a_cntr_trm_pickup_cy   " ).append("\n"); 
		query.append("    , NULL	               a_cntr_trm_return_cy   " ).append("\n"); 
		query.append("    , NULL	               a_cntr_trm_instruction " ).append("\n"); 
		query.append("    , NULL	               a_cntr_trm_tran_dt     " ).append("\n"); 
		query.append("    , NULL	               a_cntr_trm_tran_office " ).append("\n"); 
		query.append("    , NULL	               a_cntr_trm_tran_no     " ).append("\n"); 
		query.append("    , NULL	               a_cntr_usr_id     " ).append("\n"); 
		query.append("    , cntr.ob_hlg_tp_cd" ).append("\n"); 
		query.append("    , cntr.ib_hlg_tp_cd    " ).append("\n"); 
		query.append("  from bkg_xter_cntr cntr, bkg_xter_cntr_seal_no seal" ).append("\n"); 
		query.append(" where cntr.xter_sndr_id  = @[sender_id]" ).append("\n"); 
		query.append("   and cntr.xter_rqst_no  = @[rqst_no]" ).append("\n"); 
		query.append("   and cntr.xter_rqst_seq = @[rqst_seq]" ).append("\n"); 
		query.append("   and cntr.cntr_seq      = 1" ).append("\n"); 
		query.append("   and cntr.xter_sndr_id  = seal.xter_sndr_id   (+)" ).append("\n"); 
		query.append("   and cntr.xter_rqst_no  = seal.xter_rqst_no   (+)" ).append("\n"); 
		query.append("   and cntr.xter_rqst_seq = seal.xter_rqst_seq  (+)" ).append("\n"); 
		query.append("   and cntr.cntr_no       = seal.cntr_no        (+)" ).append("\n"); 
		query.append("   and cntr.cntr_seq      = seal.cntr_seq       (+)" ).append("\n"); 
		query.append("   and 1                  = seal.cntr_seal_seq  (+)" ).append("\n"); 

	}
}