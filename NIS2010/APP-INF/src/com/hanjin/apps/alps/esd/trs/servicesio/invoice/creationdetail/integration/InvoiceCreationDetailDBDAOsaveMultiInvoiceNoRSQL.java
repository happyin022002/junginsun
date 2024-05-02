/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceCreationDetailDBDAOsaveMultiInvoiceNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2015.03.19 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceCreationDetailDBDAOsaveMultiInvoiceNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Multi Invoice No 데이터 조회
	  * </pre>
	  */
	public InvoiceCreationDetailDBDAOsaveMultiInvoiceNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration").append("\n"); 
		query.append("FileName : InvoiceCreationDetailDBDAOsaveMultiInvoiceNoRSQL").append("\n"); 
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
		query.append("select nvl(sum(ROUND((nvl(b.bzc_amt,0) + nvl(b.nego_amt,0) + nvl(b.fuel_scg_amt,0) + nvl(b.scg_vat_amt,0)" ).append("\n"); 
		query.append("       + nvl(b.ovr_wgt_scg_amt,0) + nvl(b.etc_add_amt,0) + nvl(b.toll_fee_amt,0)) * @[inv_xch_rt],decode(@[inv_curr_cd],'KRW',0,'JPY',0,'TWD',0,2))),0) inv_bzc_amt" ).append("\n"); 
		query.append(" 	  ,nvl(max((select 'Y' from trs_trsp_inv_wrk where inv_no = @[inv_no] and inv_vndr_seq = @[inv_vndr_seq])),'N') dvsn" ).append("\n"); 
		query.append("	  ,max((select x.cre_ofc_cd from trs_trsp_wrk_ord x where x.trsp_wo_ofc_cty_cd = b.trsp_wo_ofc_cty_cd and x.trsp_wo_seq = b.trsp_wo_seq)) cre_ofc_cd" ).append("\n"); 
		query.append(" from trs_trsp_svc_ord b" ).append("\n"); 
		query.append("where (b.trsp_wo_ofc_cty_cd,b.trsp_wo_seq) in (select" ).append("\n"); 
		query.append("                                                       trsp_wo_ofc_cty_cd,trsp_wo_seq" ).append("\n"); 
		query.append("                                                 from trs_trsp_wrk_ord a" ).append("\n"); 
		query.append("                                           	    where 1=1" ).append("\n"); 
		query.append("#if ($wo_no.size() > 0) " ).append("\n"); 
		query.append("    AND (a.trsp_wo_ofc_cty_cd,a.trsp_wo_seq) in (" ).append("\n"); 
		query.append("	#foreach($wonoKey in ${wo_no}) " ).append("\n"); 
		query.append("		#if($velocityCount < $wo_no.size()) " ).append("\n"); 
		query.append("			(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))," ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND 1=2" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("                                                       	   and a.wo_vndr_seq = @[wo_vndr_seq]" ).append("\n"); 
		query.append("                                                       	   and NVL(a.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("                                                       	   AND NVL(a.inter_use_flg, 'N') != 'Y')" ).append("\n"); 
		query.append("  and b.eq_no is not null" ).append("\n"); 
		query.append("  and NVL(b.delt_flg, 'N') = 'N'" ).append("\n"); 

	}
}