/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchOffhireInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchOffhireInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchOffhireInvoiceListRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchOffhireInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchOffhireInvoiceListRSQL").append("\n"); 
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
		query.append("select fa.acct_itm_nm, " ).append("\n"); 
		query.append("       fd.acct_cd, " ).append("\n"); 
		query.append("       fd.acct_itm_seq, " ).append("\n"); 
		query.append("       decode(fd.flet_curr_chk_cd,'F',fd.curr_cd,null) curr_cd, " ).append("\n"); 
		query.append("       decode(fd.flet_curr_chk_cd,'F',TO_CHAR(fd.inv_amt,'999,999,999,999,999,990.00'),null) inv_amt," ).append("\n"); 
		query.append("       decode(fd.flet_curr_chk_cd,'F',TO_CHAR(fd.inv_amt,'999,999,999,999,999,990.00'),null) ori_inv_amt," ).append("\n"); 
		query.append("       decode(fd.flet_curr_chk_cd,'F',TO_CHAR(fd.inv_amt,'999,999,999,999,999,990.00'),null) fir_inv_amt," ).append("\n"); 
		query.append("       decode(fd.flet_curr_chk_cd,'S',fd.curr_cd,null) curr_cd2, " ).append("\n"); 
		query.append("       decode(fd.flet_curr_chk_cd,'S',TO_CHAR(fd.inv_amt,'999,999,999,999,999,990.00'),null) inv_amt2," ).append("\n"); 
		query.append("       decode(fd.flet_curr_chk_cd,'S',TO_CHAR(fd.inv_amt,'999,999,999,999,999,990.00'),null) ori_inv_amt2," ).append("\n"); 
		query.append("       decode(fd.flet_curr_chk_cd,'S',TO_CHAR(fd.inv_amt,'999,999,999,999,999,990.00'),null) fir_inv_amt2," ).append("\n"); 
		query.append("       decode(fd.slp_tp_cd, null, 'N', 'Y') slp_tp_cd, " ).append("\n"); 
		query.append("       fd.inv_desc," ).append("\n"); 
		query.append("       fd.flet_ctrt_no," ).append("\n"); 
		query.append("       fd.flet_iss_tp_cd," ).append("\n"); 
		query.append("       fd.inv_seq," ).append("\n"); 
		query.append("       fd.inv_dtl_seq," ).append("\n"); 
		query.append("	   fd.MODI_VNOR_ITM_UT_CD AS VNOR_ITM_UT_CD, " ).append("\n"); 
		query.append("       fd.MODI_VNOR_ITM_VAL AS VNOR_ITM_VAL, " ).append("\n"); 
		query.append("       fd.MODI_VNOR_ITM_PRC AS VNOR_ITM_PRC, " ).append("\n"); 
		query.append("       fd.VSL_CD, " ).append("\n"); 
		query.append("       fd.VNOR_SEQ, " ).append("\n"); 
		query.append("       fd.VNOR_ITM_SEQ" ).append("\n"); 
		query.append("  from fms_invoice fi, fms_inv_dtl fd, fms_acct_itm fa" ).append("\n"); 
		query.append(" where fi.flet_ctrt_no = fd.flet_ctrt_no" ).append("\n"); 
		query.append("   and fi.flet_ctrt_no = @[flet_ctrt_no]" ).append("\n"); 
		query.append("   and fi.inv_seq = decode(@[inv_seq],NULL,(select max(inv_seq) from fms_invoice where flet_ctrt_no = @[flet_ctrt_no] and flet_iss_tp_cd = 'OFF'),@[inv_seq])" ).append("\n"); 
		query.append("   and fi.flet_iss_tp_cd = 'OFF'" ).append("\n"); 
		query.append("   and fi.inv_seq = fd.inv_seq" ).append("\n"); 
		query.append("   and fi.flet_iss_tp_cd = fd.flet_iss_tp_cd" ).append("\n"); 
		query.append("   and fd.acct_cd = fa.acct_cd" ).append("\n"); 
		query.append("   and fd.acct_itm_seq = fa.acct_itm_seq" ).append("\n"); 
		query.append(" order by fd.inv_dtl_seq, fd.acct_cd" ).append("\n"); 

	}
}