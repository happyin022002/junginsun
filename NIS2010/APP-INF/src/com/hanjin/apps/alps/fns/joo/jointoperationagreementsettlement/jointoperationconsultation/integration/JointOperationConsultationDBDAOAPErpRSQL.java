/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationConsultationDBDAOAPErpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.02
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.03.02 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOAPErpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP Data ERP Interface Inquiry
	  * </pre>
	  */
	public JointOperationConsultationDBDAOAPErpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("erp_if_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOAPErpRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("       a.csr_no," ).append("\n"); 
		query.append("       a.inv_dt," ).append("\n"); 
		query.append("       a.inv_term_dt," ).append("\n"); 
		query.append("       a.gl_dt," ).append("\n"); 
		query.append("       a.vndr_no," ).append("\n"); 
		query.append("       a.csr_amt," ).append("\n"); 
		query.append("       a.attr_ctnt7 as ftu_use_ctnt," ).append("\n"); 
		query.append("       a.apro_flg," ).append("\n"); 
		query.append("       decode(a.if_flg,'Y','Success','E','Fail','Sending...') as if_flg," ).append("\n"); 
		query.append("       a.if_err_rsn" ).append("\n"); 
		query.append("from   ap_inv_hdr a," ).append("\n"); 
		query.append("-- 2010.02.17 I/F error시 reject하면 Combined 단까지 삭제한다 => Error 리스트에 나오지 말아야 하므로 join을 건다. " ).append("\n"); 
		query.append("       joo_csr    b" ).append("\n"); 
		query.append("where  a.csr_no  = B.SLP_TP_CD||B.SLP_FUNC_CD||B.SLP_OFC_CD||TO_CHAR(TO_DATE(B.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||B.SLP_SER_NO" ).append("\n"); 
		query.append("and    a.csr_no like '06%'" ).append("\n"); 
		query.append("#if(${erp_if_flg}!= '')" ).append("\n"); 
		query.append("and    a.if_flg = @[erp_if_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${dt_flg} == '0')" ).append("\n"); 
		query.append("--2010.03.02 inv_dt는 세금계산서인 경우는 세금계산서발행일, 그외는 전표발행일이 되므로 csr의 slp_iss_dt로 변경한다." ).append("\n"); 
		query.append("and    b.slp_iss_dt >= @[iss_dt_fr]" ).append("\n"); 
		query.append("and    b.slp_iss_dt <= @[iss_dt_to]" ).append("\n"); 
		query.append("#elseif(${dt_flg} == '1')" ).append("\n"); 
		query.append("and    a.gl_dt >= @[iss_dt_fr]" ).append("\n"); 
		query.append("and    a.gl_dt <= @[iss_dt_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order  by 2" ).append("\n"); 

	}
}