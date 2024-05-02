/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOsearchCustomerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.04
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.06.04 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCustomerMgtDBDAOsearchCustomerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOsearchCustomerVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_clt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOsearchCustomerVORSQL").append("\n"); 
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
		query.append("	decode(a.cust_cnt_cd,null,null,a.cust_cnt_cd||'-'||LPAD(a.cust_seq, 6, '0')) cust_cd," ).append("\n"); 
		query.append("	a.cust_cnt_cd cust_cnt_cd," ).append("\n"); 
		query.append("	a.cust_seq	cust_seq," ).append("\n"); 
		query.append("	a.cust_lgl_eng_nm cust_lgl_eng_nm ," ).append("\n"); 
		query.append("	a.cust_locl_lang_nm cust_locl_lang_nm, " ).append("\n"); 
		query.append("	a.ofc_cd||' ' ofc_cd," ).append("\n"); 
		query.append("	a.cust_rgst_no cust_rgst_no," ).append("\n"); 
		query.append("	b.cr_amt cr_amt," ).append("\n"); 
		query.append("	b.cr_amt cr_amt2," ).append("\n"); 
		query.append("	b.cr_clt_ofc_cd cr_clt_ofc_cd," ).append("\n"); 
		query.append("	decode(b.act_cust_cnt_cd,null,null,b.act_cust_cnt_cd||'-'||LPAD(b.act_cust_seq, 6, '0')) act_payer," ).append("\n"); 
		query.append("	b.act_cust_cnt_cd act_cust_cnt_cd," ).append("\n"); 
		query.append("	b.act_cust_seq act_cust_seq," ).append("\n"); 
		query.append("	b.ownr_nm ownr_nm," ).append("\n"); 
		query.append("	nvl(b.ib_cr_term_dys,0) ib_cr_term_dys," ).append("\n"); 
		query.append("	nvl(b.ob_cr_term_dys,0) ob_cr_term_dys," ).append("\n"); 
		query.append("	b.kr_ib_ofc_cd kr_ib_ofc_cd," ).append("\n"); 
		query.append("	nvl(b.locl_zip_cd,c.zip_cd) locl_zip_cd," ).append("\n"); 
		query.append("	b.cr_flg cr_flg," ).append("\n"); 
		query.append("	b.locl_nm locl_nm," ).append("\n"); 
		query.append("	b.cr_curr_cd," ).append("\n"); 
		query.append("	C.BZET_ADDR addr" ).append("\n"); 
		query.append("from mdm_customer a,mdm_cr_cust b, mdm_cust_addr c" ).append("\n"); 
		query.append("where a.cust_seq = b.cust_seq(+)	" ).append("\n"); 
		query.append("and a.cust_seq = c.cust_seq(+)" ).append("\n"); 
		query.append("and a.cust_cnt_cd = b.cust_cnt_cd(+)" ).append("\n"); 
		query.append("and a.cust_cnt_cd = c.cust_cnt_cd(+)" ).append("\n"); 
		query.append("and c.prmry_chk_flg(+) = 'Y'" ).append("\n"); 
		query.append("--AND NVL(a.BLK_DIV_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(a.CNTR_DIV_FLG,'N') ='Y' --2010-06-04 김현화수석" ).append("\n"); 
		query.append("#if (${cust_type} == 'CM')" ).append("\n"); 
		query.append("	#if (${chk_nm} == 'Y')" ).append("\n"); 
		query.append("		#if (${cust_nm1}!= '')" ).append("\n"); 
		query.append("		AND UPPER(a.cust_lgl_eng_nm) like '%' || UPPER(@[cust_nm1]) || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${cust_nm2}!= '')" ).append("\n"); 
		query.append("		AND UPPER(a.cust_lgl_eng_nm) like '%' || UPPER(@[cust_nm2]) || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${cust_nm3}!= '')" ).append("\n"); 
		query.append("		AND UPPER(a.cust_lgl_eng_nm) like '%' || UPPER(@[cust_nm3]) || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND	UPPER(a.cust_lgl_eng_nm) like UPPER(@[cust_nm])|| '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${cust_type} == 'LCL')" ).append("\n"); 
		query.append("	#if (${chk_nm} == 'Y')" ).append("\n"); 
		query.append("		#if (${cust_nm1}!= '')" ).append("\n"); 
		query.append("		AND UPPER(b.locl_nm) like '%' || UPPER(@[cust_nm1]) || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${cust_nm2}!= '')" ).append("\n"); 
		query.append("		AND UPPER(b.locl_nm) like '%' || UPPER(@[cust_nm2]) || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${cust_nm3}!= '')" ).append("\n"); 
		query.append("		AND UPPER(b.locl_nm) like '%' || UPPER(@[cust_nm3]) || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND	UPPER(b.locl_nm) like UPPER(@[cust_nm])|| '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cr_flg} != '')" ).append("\n"); 
		query.append("and NVL(b.cr_flg,'N') = @[cr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${credit_type} != '')" ).append("\n"); 
		query.append("#if (${credit_type}  ==  'I')" ).append("\n"); 
		query.append("and nvl(b.ib_cr_term_dys,0) > 0" ).append("\n"); 
		query.append("#elseif (${credit_type} == 'O') 	" ).append("\n"); 
		query.append("and nvl(b.ob_cr_term_dys,0) > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cr_clt_ofc_cd} != '')" ).append("\n"); 
		query.append("and b.cr_clt_ofc_cd like '%'|| @[cr_clt_ofc_cd]|| '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${locl_zip_cd} != '')" ).append("\n"); 
		query.append("and (b.locl_zip_cd like REPLACE(REPLACE(@[locl_zip_cd],' ',''),'-','') || '%' or c.zip_cd like  REPLACE(REPLACE(@[locl_zip_cd],' ',''),'-','') || '%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("and	a.cust_cnt_cd = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and a.delt_flg ='N'" ).append("\n"); 

	}
}