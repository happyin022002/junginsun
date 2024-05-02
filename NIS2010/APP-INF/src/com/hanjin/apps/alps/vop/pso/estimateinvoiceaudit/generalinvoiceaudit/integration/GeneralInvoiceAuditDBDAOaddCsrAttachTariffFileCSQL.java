/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOaddCsrAttachTariffFileCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOaddCsrAttachTariffFileCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR 생성시 PSO TARIFF를 AUTO ATTACH하기 위함.
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOaddCsrAttachTariffFileCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOaddCsrAttachTariffFileCSQL").append("\n"); 
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
		query.append("INSERT INTO COM_AP_FILE_UPLD( ATCH_FILE_ID, AP_FILE_DIV_CD, CSR_NO, SUB_SYS_ID, INV_VNDR_SEQ, INV_NO, CSR_FILE_UPLD_TP_CD, FILE_SAV_ID, FILE_NM, FILE_RMK, ERR_RMK, DELT_FLG, DELT_USR_ID, DELT_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("    SELECT TO_CHAR(SYSDATE, 'YYYYMMDD')||LPAD(COM_AP_FILE_UPLD_SEQ.NEXTVAL, 12, '0'), " ).append("\n"); 
		query.append("           'C', " ).append("\n"); 
		query.append("           @[csr_no], " ).append("\n"); 
		query.append("           '', -- SUB_SYS_ID" ).append("\n"); 
		query.append("           '', -- INV_VNDR_SEQ" ).append("\n"); 
		query.append("           '', -- INV_NO FROM ( " ).append("\n"); 
		query.append("           'PF', -- CSR_FILE_UPLD_TP_CD" ).append("\n"); 
		query.append("            A.FILE_SAVE_ID, -- FILE_SAV_ID" ).append("\n"); 
		query.append("            A.FILE_UPLD_NM, -- FILE_NM" ).append("\n"); 
		query.append("            '', -- FILE_RMK" ).append("\n"); 
		query.append("            '',  -- ERR_RMK" ).append("\n"); 
		query.append("            'N', -- DELT_FLG" ).append("\n"); 
		query.append("            '', -- DELT_USR_ID" ).append("\n"); 
		query.append("            NULL, -- DELT_DT" ).append("\n"); 
		query.append("            @[cre_usr_id], -- CRE_USR_ID" ).append("\n"); 
		query.append("            SYSDATE,         -- CRE_DT" ).append("\n"); 
		query.append("            @[cre_usr_id], -- UPD_USR_ID" ).append("\n"); 
		query.append("            SYSDATE -- UPD_DT" ).append("\n"); 
		query.append("      FROM (  SELECT DISTINCT A.FILE_SAVE_ID ," ).append("\n"); 
		query.append("                              F.FILE_UPLD_NM " ).append("\n"); 
		query.append("                FROM PSO_TRF_ATCH_FILE A," ).append("\n"); 
		query.append("                     AP_PAY_INV C, " ).append("\n"); 
		query.append("                     PSO_CHARGE D," ).append("\n"); 
		query.append("                     PSO_CHG_DTL E," ).append("\n"); 
		query.append("                     COM_UPLD_FILE F" ).append("\n"); 
		query.append("               WHERE C.INV_RGST_NO    = D.INV_RGST_NO " ).append("\n"); 
		query.append("                 AND D.ISS_CTY_CD     = E.ISS_CTY_CD" ).append("\n"); 
		query.append("                 AND D.SO_SEQ         = E.SO_SEQ" ).append("\n"); 
		query.append("                 AND E.YD_CHG_NO      = A.YD_CHG_NO" ).append("\n"); 
		query.append("                 AND C.CSR_NO         = @[csr_no]" ).append("\n"); 
		query.append("                 AND C.INV_NO         = D.INV_NO" ).append("\n"); 
		query.append("                 AND C.INV_SUB_SYS_CD = 'PSO'" ).append("\n"); 
		query.append("                 AND C.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                 AND C.CSR_NO         IS NOT NULL" ).append("\n"); 
		query.append("                 AND E.YD_CHG_NO      IS NOT NULL" ).append("\n"); 
		query.append("                 AND F.FILE_SAV_ID    = A.FILE_SAVE_ID" ).append("\n"); 
		query.append("                 AND F.DELT_FLG       = 'N' ) A" ).append("\n"); 

	}
}