/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceIssueDBDAOInvArUsaIssSndCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.02
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.02.02 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOInvArUsaIssSndCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvArUsaIssSnd
	  * </pre>
	  */
	public InvoiceIssueDBDAOInvArUsaIssSndCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_snd_cust_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_iss_snd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOInvArUsaIssSndCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_AR_USA_ISS_SND" ).append("\n"); 
		query.append("        (BL_SRC_NO" ).append("\n"); 
		query.append("        ,SND_SEQ" ).append("\n"); 
		query.append("        ,INV_ISS_SND_TP_CD" ).append("\n"); 
		query.append("        ,INV_SND_CUST_NO    " ).append("\n"); 
		query.append("        ,INV_SND_DT" ).append("\n"); 
		query.append("        ,INV_SND_NO" ).append("\n"); 
		query.append("        ,AR_OFC_CD" ).append("\n"); 
		query.append("        ,SAIL_ARR_DT" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT)" ).append("\n"); 
		query.append("VALUES (@[bl_src_no]" ).append("\n"); 
		query.append("		,(SELECT NVL(MAX(SND_SEQ) + 1, 1) FROM INV_AR_USA_ISS_SND WHERE BL_SRC_NO=@[bl_src_no])" ).append("\n"); 
		query.append("		,@[inv_iss_snd_tp_cd]" ).append("\n"); 
		query.append("		,@[inv_snd_cust_no]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append("		,@[inv_snd_no]" ).append("\n"); 
		query.append("		,@[ar_ofc_cd]" ).append("\n"); 
		query.append("		,@[sail_arr_dt]" ).append("\n"); 
		query.append("		,@[cre_usr_id]" ).append("\n"); 
		query.append("	    ,SYSDATE," ).append("\n"); 
		query.append("      @[upd_usr_id]," ).append("\n"); 
		query.append("      SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}