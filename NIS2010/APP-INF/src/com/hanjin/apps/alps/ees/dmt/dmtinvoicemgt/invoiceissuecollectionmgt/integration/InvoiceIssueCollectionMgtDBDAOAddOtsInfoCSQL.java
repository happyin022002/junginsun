/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOAddOtsInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2015.08.12 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOAddOtsInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOAddOtsInfoCSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOAddOtsInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_pay_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_pay_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_pay_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bal_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_inv_pay_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_pay_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_pay_coff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOAddOtsInfoCSQL").append("\n"); 
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
		query.append("insert into DMT_INV_OTS_PAY_RCV" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    INV_PAY_RCV_SEQ" ).append("\n"); 
		query.append("   ,DMDT_INV_NO" ).append("\n"); 
		query.append("   ,BL_NO" ).append("\n"); 
		query.append("   ,DMDT_INV_PAY_TP_CD" ).append("\n"); 
		query.append("   ,IO_BND_CD" ).append("\n"); 
		query.append("   ,INV_PAY_DT" ).append("\n"); 
		query.append("   ,INV_PAY_AMT" ).append("\n"); 
		query.append("   ,INV_CURR_CD" ).append("\n"); 
		query.append("   ,INV_PAY_COFF_DT" ).append("\n"); 
		query.append("   ,CRE_USR_ID" ).append("\n"); 
		query.append("   ,CRE_DT" ).append("\n"); 
		query.append("   ,UPD_USR_ID" ).append("\n"); 
		query.append("   ,UPD_DT" ).append("\n"); 
		query.append("   ,INV_PAY_OFC_CD" ).append("\n"); 
		query.append("   ,EAI_IF_ID" ).append("\n"); 
		query.append("   ,BKG_NO" ).append("\n"); 
		query.append("   ,INV_BAL_AMT" ).append("\n"); 
		query.append("   ,INV_PAY_LOCL_DT" ).append("\n"); 
		query.append("   ,UPD_LOCL_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("values" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    @[inv_pay_rcv_seq]" ).append("\n"); 
		query.append("   ,@[dmdt_inv_no]" ).append("\n"); 
		query.append("   ,@[bl_no]" ).append("\n"); 
		query.append("   ,@[dmdt_inv_pay_tp_cd]" ).append("\n"); 
		query.append("   ,@[io_bnd_cd]" ).append("\n"); 
		query.append("   ,TO_DATE(@[inv_pay_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("   ,@[inv_pay_amt]" ).append("\n"); 
		query.append("   ,@[inv_curr_cd]" ).append("\n"); 
		query.append("   ,to_date(@[inv_pay_coff_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("   ,@[cre_usr_id]" ).append("\n"); 
		query.append("   ,sysdate" ).append("\n"); 
		query.append("   ,@[upd_usr_id]" ).append("\n"); 
		query.append("   ,sysdate" ).append("\n"); 
		query.append("   ,@[inv_pay_ofc_cd]" ).append("\n"); 
		query.append("   ,@[eai_if_id]" ).append("\n"); 
		query.append("   ,@[bkg_no]" ).append("\n"); 
		query.append("   ,@[inv_bal_amt]" ).append("\n"); 
		query.append("   ,NVL(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELSC', TO_DATE(@[inv_pay_dt], 'YYYYMMDDHH24MISS'), @[inv_pay_ofc_cd]), TO_DATE(@[inv_pay_dt], 'YYYYMMDDHH24MISS'))" ).append("\n"); 
		query.append("   ,NVL(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELSC', SYSDATE, @[inv_pay_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}