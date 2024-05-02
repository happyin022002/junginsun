/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOsearchExpressionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.11.17 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOsearchExpressionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchExpression
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOsearchExpressionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOsearchExpressionRSQL").append("\n"); 
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
		query.append("/*ExpressionList VO*/" ).append("\n"); 
		query.append("SELECT PSO_CHG_TP_CD,DFLT_XPR_DESC,SYS_XPR_DESC,DFLT_SYS_XPR_DESC" ).append("\n"); 
		query.append(",YD_CHG_NO" ).append("\n"); 
		query.append(",YD_CHG_VER_SEQ" ).append("\n"); 
		query.append(",DFLT_SYS_XPR_USR_DESC" ).append("\n"); 
		query.append(",DFLT_SYS_XPR_VAL_DESC" ).append("\n"); 
		query.append(",PSO_STMT_CHK_FNC(DFLT_XPR_DESC, 3) valflg" ).append("\n"); 
		query.append(",T1.CHG_XPR_NO" ).append("\n"); 
		query.append("FROM PSO_YD_CHG_XPR T1, PSO_CHG_XPR T2" ).append("\n"); 
		query.append("WHERE T1.YD_CHG_NO = @[yd_chg_no]" ).append("\n"); 
		query.append("AND   T1.YD_CHG_VER_SEQ = @[yd_chg_ver_seq]" ).append("\n"); 
		query.append("AND   T1.CHG_XPR_NO = T2.CHG_XPR_NO" ).append("\n"); 
		query.append("ORDER BY DECODE(PSO_CHG_TP_CD, 'B', 1, 'S',2, 'D',3, 4)" ).append("\n"); 

	}
}