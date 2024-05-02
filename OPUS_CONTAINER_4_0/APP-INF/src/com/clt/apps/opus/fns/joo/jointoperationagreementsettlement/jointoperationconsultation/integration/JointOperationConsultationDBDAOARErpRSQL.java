/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JointOperationConsultationDBDAOARErpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOARErpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR Data ERP Interface inquiry   
	  * </pre>
	  */
	public JointOperationConsultationDBDAOARErpRSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOARErpRSQL").append("\n"); 
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
		query.append("       a.slp_no," ).append("\n"); 
		query.append("       a.iss_dt," ).append("\n"); 
		query.append("       a.sail_dt," ).append("\n"); 
		query.append("       a.due_dt," ).append("\n"); 
		query.append("       a.rlane_cd," ).append("\n"); 
		query.append("       a.rev_vsl_cd||a.rev_skd_voy_no||a.rev_skd_dir_cd||a.rev_dir_cd as vvd," ).append("\n"); 
		query.append("       a.locl_amt," ).append("\n"); 
		query.append("       a.jo_bl_no as bl_no," ).append("\n"); 
		query.append("       a.act_cust_cnt_cd||lpad(act_cust_seq,6,'0') as cust_seq," ).append("\n"); 
		query.append("       a.por_cd," ).append("\n"); 
		query.append("       a.csr_offst_no," ).append("\n"); 
		query.append("       decode(a.erp_if_flg,'Y','Success','E','Fail','Sending...') as erp_if_flg" ).append("\n"); 
		query.append("from   joo_ar_mn a," ).append("\n"); 
		query.append("-- 2010.02.17 I/F error시 reject하면 Combined 단까지 삭제한다 => Error 리스트에 나오지 말아야 하므로 join을 건다. " ).append("\n"); 
		query.append("       joo_csr   b " ).append("\n"); 
		query.append("where  a.slp_no = B.SLP_TP_CD||B.SLP_FUNC_CD||B.SLP_OFC_CD||B.SLP_ISS_DT||B.SLP_SER_NO" ).append("\n"); 
		query.append("and    a.AR_IF_NO like 'JOO%'" ).append("\n"); 
		query.append("#if(${erp_if_flg} != '')" ).append("\n"); 
		query.append("and    a.erp_if_flg = @[erp_if_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${dt_flg}=='0')" ).append("\n"); 
		query.append("and    a.iss_dt >= @[iss_dt_fr]" ).append("\n"); 
		query.append("and    a.iss_dt <= @[iss_dt_to]" ).append("\n"); 
		query.append("#elseif(${dt_flg}=='1') " ).append("\n"); 
		query.append("and    a.gl_dt >= @[iss_dt_fr]" ).append("\n"); 
		query.append("and    a.gl_dt <= @[iss_dt_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by 2" ).append("\n"); 

	}
}