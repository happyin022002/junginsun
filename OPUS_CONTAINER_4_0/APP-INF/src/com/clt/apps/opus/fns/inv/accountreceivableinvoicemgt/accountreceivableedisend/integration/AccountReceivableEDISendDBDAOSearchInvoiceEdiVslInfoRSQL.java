/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchInvoiceEdiVslInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchInvoiceEdiVslInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceEdiVslInfo
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchInvoiceEdiVslInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchInvoiceEdiVslInfoRSQL").append("\n"); 
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
		query.append("SELECT '{VSL_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'VSL_NM:' ||MDM.VSL_ENG_NM|| CHR(10) " ).append("\n"); 
		query.append("       || 'VSL_CD:' || IAM.VSL_CD||CHR(10) " ).append("\n"); 
		query.append("       || 'VSL_VOY_NO:' ||IAM.SKD_VOY_NO|| CHR(10) " ).append("\n"); 
		query.append("       || 'EX_VOY_REF:' ||DECODE(IAM.IO_BND_CD, 'I', VPS.IB_CSSM_VOY_NO, 'O', VPS.OB_CSSM_VOY_NO)|| CHR(10) " ).append("\n"); 
		query.append("       || 'VSL_LOYD_CD:' ||MDM.LLOYD_NO|| CHR(10) " ).append("\n"); 
		query.append("       || '}VSL_INFO' || CHR(10)" ).append("\n"); 
		query.append("  FROM INV_AR_MN IAM, MDM_VSL_CNTR MDM, VSK_VSL_PORT_SKD VPS " ).append("\n"); 
		query.append(" WHERE IAM.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("   AND IAM.VSL_CD = MDM.VSL_CD(+)" ).append("\n"); 
		query.append("   AND VPS.VSL_CD = IAM.VSL_CD" ).append("\n"); 
		query.append("   AND VPS.SKD_VOY_NO = IAM.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VPS.SKD_DIR_CD = IAM.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VPS.VPS_PORT_CD = DECODE(IAM.IO_BND_CD, 'I', IAM.POD_CD, 'O', IAM.POL_CD)" ).append("\n"); 
		query.append("   AND VPS.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}