/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOModifyTpbIfFlgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.11.28 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOModifyTpbIfFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP에서 CSR 승인시 TPB 대상건의 IF_FLG를 Y로 변경한다.
	  * 
	  * 
	  * ===================================
	  * * 2012.11.26 진마리아 CHM-201220618-01 TPB 비용 정보 지정시 해당 정보를 TPB IF용 테이블에 저장하고 제어함
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOModifyTpbIfFlgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOModifyTpbIfFlgUSQL").append("\n"); 
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
		query.append("UPDATE PSO_N3RD_PTY_IF" ).append("\n"); 
		query.append("SET IF_fLG = 'Y'" ).append("\n"); 
		query.append("  , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE (ISS_CTY_CD, SO_SEQ) IN (" ).append("\n"); 
		query.append("                SELECT ISS_CTY_CD, SO_SEQ" ).append("\n"); 
		query.append("                FROM PSO_CHARGE" ).append("\n"); 
		query.append("                WHERE INV_RGST_NO IN (SELECT INV_RGST_NO" ).append("\n"); 
		query.append("                                      FROM AP_PAY_INV" ).append("\n"); 
		query.append("                                      WHERE CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("                                      AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                )" ).append("\n"); 

	}
}