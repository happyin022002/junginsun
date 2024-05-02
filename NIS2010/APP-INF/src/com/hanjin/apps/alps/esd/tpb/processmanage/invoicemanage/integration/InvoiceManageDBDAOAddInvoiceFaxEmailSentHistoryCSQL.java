/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceManageDBDAOAddInvoiceFaxEmailSentHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOAddInvoiceFaxEmailSentHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Fax Email 전송이력을 저장합니다.
	  * </pre>
	  */
	public InvoiceManageDBDAOAddInvoiceFaxEmailSentHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_eml_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_if_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cust_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_rvis_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOAddInvoiceFaxEmailSentHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO TPB_FAX_EML_SND_HIS" ).append("\n"); 
		query.append("(   N3PTY_INV_NO         " ).append("\n"); 
		query.append("   ,SND_SEQ" ).append("\n"); 
		query.append("   ,N3PTY_INV_RVIS_CD              " ).append("\n"); 
		query.append("   ,N3PTY_INV_SND_TP_CD  " ).append("\n"); 
		query.append("   ,SND_DT               " ).append("\n"); 
		query.append("   ,FAX_EML_SND_NO       " ).append("\n"); 
		query.append("   ,VNDR_CUST_EML        " ).append("\n"); 
		query.append("   ,FAX_NO               " ).append("\n"); 
		query.append("   ,CRE_USR_ID           " ).append("\n"); 
		query.append("   ,CRE_DT               " ).append("\n"); 
		query.append("   ,UPD_USR_ID           " ).append("\n"); 
		query.append("   ,UPD_DT " ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("     @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("    ,(  SELECT NVL(MAX(SND_SEQ),0)+1" ).append("\n"); 
		query.append("        FROM   TPB_FAX_EML_SND_HIS" ).append("\n"); 
		query.append("        WHERE  1 = 1" ).append("\n"); 
		query.append("        AND    N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("    ,@[s_n3pty_inv_rvis_cd]" ).append("\n"); 
		query.append("    ,@[s_n3pty_inv_if_tp_cd]" ).append("\n"); 
		query.append("    ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[user_ofc_cd])" ).append("\n"); 
		query.append("    ,@[fax_eml_snd_no]" ).append("\n"); 
		query.append("    ,@[vndr_cust_eml]" ).append("\n"); 
		query.append("    ,@[fax_no]" ).append("\n"); 
		query.append("    ,@[user_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[user_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}