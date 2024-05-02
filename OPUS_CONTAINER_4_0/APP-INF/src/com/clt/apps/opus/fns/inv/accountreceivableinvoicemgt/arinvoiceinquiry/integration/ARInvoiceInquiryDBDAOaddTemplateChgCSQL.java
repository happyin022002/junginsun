/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOaddTemplateChgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOaddTemplateChgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addTemplateChg
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOaddTemplateChgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_itm_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cprt_val_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cprt_tp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cprt_chg_grp_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rpt_tmplt_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOaddTemplateChgCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_CPRT_TMPLT_CHG	(" ).append("\n"); 
		query.append("           AR_OFC_CD         " ).append("\n"); 
		query.append("          ,RPT_TMPLT_NM     " ).append("\n"); 
		query.append("          ,RPT_ITM_ID       " ).append("\n"); 
		query.append("          ,CPRT_TP_CTNT     " ).append("\n"); 
		query.append("          ,CPRT_VAL_CTNT    " ).append("\n"); 
		query.append("          ,DP_SEQ           " ).append("\n"); 
		query.append("          ,CHG_CD " ).append("\n"); 
		query.append("          ,CPRT_CHG_GRP_FLG           " ).append("\n"); 
		query.append("          ,CRE_USR_ID       " ).append("\n"); 
		query.append("          ,CRE_DT           " ).append("\n"); 
		query.append("          ,UPD_USR_ID       " ).append("\n"); 
		query.append("          ,UPD_DT           " ).append("\n"); 
		query.append(")VALUES( @[ar_ofc_cd]" ).append("\n"); 
		query.append("		,@[rpt_tmplt_nm]" ).append("\n"); 
		query.append("		,@[rpt_itm_id]" ).append("\n"); 
		query.append("		,@[cprt_tp_ctnt]     " ).append("\n"); 
		query.append("        ,@[cprt_val_ctnt]" ).append("\n"); 
		query.append("		,@[dp_seq]" ).append("\n"); 
		query.append("		,@[chg_cd]" ).append("\n"); 
		query.append("		,@[cprt_chg_grp_flg]" ).append("\n"); 
		query.append("		,NVL(@[cre_usr_id], @[upd_usr_id])" ).append("\n"); 
		query.append("		,NVL(TO_DATE(@[cre_dt],'YYYYMMDDHH24MISS'),SYSDATE)" ).append("\n"); 
		query.append("		,@[upd_usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append(") " ).append("\n"); 

	}
}