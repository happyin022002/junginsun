/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetSdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.08
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2010.06.08 김진주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetSdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getSdr
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetSdrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetSdrRSQL").append("\n"); 
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
		query.append("SELECT -- 잘못된 큰수가 입력된 경우가 있으므로 일의자리 이하 숫자만 선택한다." ).append("\n"); 
		query.append("       CASE WHEN INSTR(SDR, '.') > 0 THEN SUBSTR(SDR, INSTR(SDR, '.') - 1)" ).append("\n"); 
		query.append("            ELSE SUBSTR(SDR, -1, 1)" ).append("\n"); 
		query.append("       END   " ).append("\n"); 
		query.append("From (" ).append("\n"); 
		query.append("    select NVL(Substr(Max(to_char(cre_dt,'YYYYMMDDHH24MI')||locl_xch_rt),13),1) SDR" ).append("\n"); 
		query.append("    from pso_cnl_tz_fee" ).append("\n"); 
		query.append("    where pso_bztp_cd = 5" ).append("\n"); 
		query.append("    and cnl_tz_bztp_cd = 'I'" ).append("\n"); 
		query.append("    and yd_cd like 'EGSUZ' || '%'" ).append("\n"); 
		query.append("	and locl_xch_rt is not null" ).append("\n"); 
		query.append("    ) X" ).append("\n"); 

	}
}