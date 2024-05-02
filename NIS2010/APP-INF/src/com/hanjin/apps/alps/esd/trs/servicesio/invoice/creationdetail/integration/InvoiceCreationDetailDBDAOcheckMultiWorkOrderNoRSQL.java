/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceCreationDetailDBDAOcheckMultiWorkOrderNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.17
*@LastModifier : 박연진
*@LastVersion : 1.0
* 2011.05.17 박연진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceCreationDetailDBDAOcheckMultiWorkOrderNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Multi Work Order No 체크
	  * </pre>
	  */
	public InvoiceCreationDetailDBDAOcheckMultiWorkOrderNoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration").append("\n"); 
		query.append("FileName : InvoiceCreationDetailDBDAOcheckMultiWorkOrderNoRSQL").append("\n"); 
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
		query.append("select case" ).append("\n"); 
		query.append("when sum(case when b.eq_no is null then 1" ).append("\n"); 
		query.append("else 0" ).append("\n"); 
		query.append("end) > 0" ).append("\n"); 
		query.append("then 'Equipment not attatched'" ).append("\n"); 
		query.append("when sum(case when b.inv_no is not null then 1" ).append("\n"); 
		query.append("else 0" ).append("\n"); 
		query.append("end) > 0" ).append("\n"); 
		query.append("then 'Already invoiced W/O'" ).append("\n"); 
		query.append("#if($inv_code.size() > 0)" ).append("\n"); 
		query.append("when sum(case when b.trsp_cost_dtl_mod_cd in (" ).append("\n"); 
		query.append("#foreach($inv_no_key IN ${inv_code})" ).append("\n"); 
		query.append("#if($velocityCount < $inv_code.size())" ).append("\n"); 
		query.append("'$inv_no_key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$inv_no_key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") and b.trsp_so_tp_cd != 'O' then 1" ).append("\n"); 
		query.append("#foreach($inv_no_key IN ${inv_code})" ).append("\n"); 
		query.append("#if($velocityCount < $inv_code.size())" ).append("\n"); 
		query.append("when length('$inv_no_key') = 4 and '$inv_no_key' like b.trsp_cost_dtl_mod_cd || '%' and substr('$inv_no_key',-1,1) = b.trsp_so_tp_cd  then 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("else 0 end) < count(1)" ).append("\n"); 
		query.append("then 'Including unauthorized S/O type'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("else ''" ).append("\n"); 
		query.append("end err_msg" ).append("\n"); 
		query.append("from trs_trsp_wrk_ord a" ).append("\n"); 
		query.append(",trs_trsp_svc_ord b" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("#if($inv_code.size() <= 0)" ).append("\n"); 
		query.append("and 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and a.trsp_wo_ofc_cty_cd = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("and a.trsp_wo_seq = @[trsp_wo_seq]" ).append("\n"); 
		query.append("and a.wo_vndr_seq = @[wo_vndr_seq]" ).append("\n"); 
		query.append("and NVL(a.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("AND NVL(a.inter_use_flg, 'N') != 'Y'" ).append("\n"); 
		query.append("and b.trsp_wo_ofc_cty_cd = a.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("and b.trsp_wo_seq = a.trsp_wo_seq" ).append("\n"); 
		query.append("and NVL(b.delt_flg, 'N') = 'N'" ).append("\n"); 

	}
}