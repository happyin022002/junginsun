/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceManageDBDAOMultiIndiaTaxInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOMultiIndiaTaxInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiIndiaTaxInfo
	  * </pre>
	  */
	public InvoiceManageDBDAOMultiIndiaTaxInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edu_tax",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pmnt_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_tax_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_cate_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_tax",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("high_edu_tax",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOMultiIndiaTaxInfoUSQL").append("\n"); 
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
		query.append("MERGE INTO tpb_ida_tax a" ).append("\n"); 
		query.append("	USING (" ).append("\n"); 
		query.append("	  SELECT COUNT(0) cnt" ).append("\n"); 
		query.append("	  FROM tpb_ida_tax" ).append("\n"); 
		query.append("	  WHERE ida_tax_seq = TO_NUMBER(@[ida_tax_seq])" ).append("\n"); 
		query.append("	  	AND (delt_flg != 'Y' OR delt_flg IS NULL)" ).append("\n"); 
		query.append("	) b" ).append("\n"); 
		query.append("	ON ( a.ida_tax_seq = TO_NUMBER(@[ida_tax_seq]) )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("	UPDATE" ).append("\n"); 
		query.append("	SET ofc_cd     = '' /* 임의의 값으로 일괄 저장 --> 차후 오피스별 구분을 위함 */" ).append("\n"); 
		query.append("		,eff_dt       = TO_DATE(@[eff_dt], 'YYYY-MM-DD HH24:MI:SS') + 3.5/24" ).append("\n"); 
		query.append("		,expn_tax     = @[expn_tax]" ).append("\n"); 
		query.append("		,edu_tax      = @[edu_tax]" ).append("\n"); 
		query.append("		,high_edu_tax = @[high_edu_tax]" ).append("\n"); 
		query.append("		,tax_rgst_no  = @[tax_rgst_no]" ).append("\n"); 
		query.append("		,svc_cate_rmk = @[svc_cate_rmk]" ).append("\n"); 
		query.append("        ,pmnt_acct_no = @[pmnt_acct_no]" ).append("\n"); 
		query.append("		,upd_usr_id   = @[upd_usr_id]" ).append("\n"); 
		query.append("		,upd_dt       = SYSDATE" ).append("\n"); 
		query.append("	WHERE ida_tax_seq = TO_NUMBER(@[ida_tax_seq])" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT  (" ).append("\n"); 
		query.append("		ida_tax_seq," ).append("\n"); 
		query.append("		ofc_cd," ).append("\n"); 
		query.append("		eff_dt," ).append("\n"); 
		query.append("		expn_tax," ).append("\n"); 
		query.append("		edu_tax," ).append("\n"); 
		query.append("		high_edu_tax," ).append("\n"); 
		query.append("		tax_rgst_no," ).append("\n"); 
		query.append("		svc_cate_rmk," ).append("\n"); 
		query.append("        pmnt_acct_no," ).append("\n"); 
		query.append("		cre_usr_id," ).append("\n"); 
		query.append("		cre_dt," ).append("\n"); 
		query.append("		upd_usr_id," ).append("\n"); 
		query.append("		upd_dt" ).append("\n"); 
		query.append("	) VALUES (" ).append("\n"); 
		query.append("		TPB_IDA_TAX_SEQ1.NEXTVAL" ).append("\n"); 
		query.append("		,''" ).append("\n"); 
		query.append("		,TO_DATE(@[eff_dt], 'YYYY-MM-DD HH24:MI:SS') + 3.5/24" ).append("\n"); 
		query.append("		,@[expn_tax]" ).append("\n"); 
		query.append("		,@[edu_tax]" ).append("\n"); 
		query.append("		,@[high_edu_tax]" ).append("\n"); 
		query.append("		,@[tax_rgst_no]" ).append("\n"); 
		query.append("		,@[svc_cate_rmk]" ).append("\n"); 
		query.append("        ,@[pmnt_acct_no]" ).append("\n"); 
		query.append("		,@[cre_usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append("		,@[upd_usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append("	)  " ).append("\n"); 

	}
}