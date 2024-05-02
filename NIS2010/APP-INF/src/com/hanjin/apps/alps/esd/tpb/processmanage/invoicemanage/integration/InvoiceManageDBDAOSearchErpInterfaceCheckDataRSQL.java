/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchErpInterfaceCheckDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.10.09 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchErpInterfaceCheckDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchErpInterfaceCheckData
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchErpInterfaceCheckDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration ").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchErpInterfaceCheckDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("--- Source" ).append("\n"); 
		query.append("COUNT(distinct a.n3pty_expn_tp_cd) n3pty_expn_tp_cd_cnt," ).append("\n"); 
		query.append("MAX(a.n3pty_expn_tp_cd) n3pty_expn_tp_cd_max," ).append("\n"); 
		query.append("--- Billing case" ).append("\n"); 
		query.append("COUNT(distinct z.n3pty_bil_tp_cd) n3pty_bil_tp_cd_cnt," ).append("\n"); 
		query.append("MAX(z.n3pty_bil_tp_cd) n3pty_bil_tp_cd_max," ).append("\n"); 
		query.append("--- 3rd Party" ).append("\n"); 
		query.append("COUNT( distinct DECODE(a.vndr_cust_div_cd, 'V',TO_CHAR(a.vndr_seq), 'C', a.cust_cnt_cd||a.cust_seq, 'S',a.n3pty_ofc_cd, NULL) ) trd_party_code_cnt," ).append("\n"); 
		query.append("MAX( DECODE(a.vndr_cust_div_cd, 'V',TO_CHAR(a.vndr_seq), 'C', a.cust_cnt_cd||a.cust_seq, 'S',a.n3pty_ofc_cd, NULL) ) trd_party_code_max," ).append("\n"); 
		query.append("--- Revenue VVD" ).append("\n"); 
		query.append("COUNT( distinct NVL( DECODE(a.n3pty_src_sub_sys_cd, 'MNR',NULL, a.vsl_cd||a.skd_voy_no||a.finc_dir_cd), '-') ) revenue_vvd_cnt," ).append("\n"); 
		query.append("MAX( DECODE(a.n3pty_src_sub_sys_cd, 'MNR',NULL, a.vsl_cd||a.skd_voy_no||a.finc_dir_cd) ) revenue_vvd_max," ).append("\n"); 
		query.append("--- Currency" ).append("\n"); 
		query.append("COUNT( distinct y.curr_cd ) curr_cd_cnt," ).append("\n"); 
		query.append("MAX( y.curr_cd ) curr_cd_max," ).append("\n"); 
		query.append("--- Actual VVD" ).append("\n"); 
		query.append("COUNT( distinct NVL(z.vvd_cd,'-' )) vvd_cd_cnt," ).append("\n"); 
		query.append("MAX( z.vvd_cd ) vvd_cd_max," ).append("\n"); 
		query.append("--- CSR No." ).append("\n"); 
		query.append("COUNT( distinct NVL(z.csr_no,'-' )) csr_no_cnt," ).append("\n"); 
		query.append("MAX( z.csr_no ) csr_no_max," ).append("\n"); 
		query.append("--- Month of GL Date" ).append("\n"); 
		query.append("COUNT( distinct NVL(SUBSTRB(z.gl_dt,1,6),'-') ) gl_month_cnt," ).append("\n"); 
		query.append("MAX( SUBSTRB(z.gl_dt,1,6) ) gl_month_max" ).append("\n"); 
		query.append("FROM tpb_ots_dtl a," ).append("\n"); 
		query.append("tpb_ots_grp b," ).append("\n"); 
		query.append("tpb_inv_rvis_dtl z," ).append("\n"); 
		query.append("tpb_inv_rvis y," ).append("\n"); 
		query.append("tpb_invoice x" ).append("\n"); 
		query.append("WHERE y.n3pty_inv_no = x.n3pty_inv_no" ).append("\n"); 
		query.append("AND y.n3pty_inv_no = z.n3pty_inv_no" ).append("\n"); 
		query.append("AND y.n3pty_inv_no = b.n3pty_inv_no" ).append("\n"); 
		query.append("AND b.n3pty_no = a.n3pty_no" ).append("\n"); 
		query.append("AND a.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("AND x.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("AND y.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("AND z.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("AND y.n3pty_inv_no = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("AND y.n3pty_inv_rvis_seq = @[s_n3pty_inv_his_seq]" ).append("\n"); 

	}
}