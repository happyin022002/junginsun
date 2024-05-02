/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOsearchPsoYdChgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.13
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.03.13 진마리아
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

public class GeneralInvoiceAuditDBDAOsearchPsoYdChgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search tariff information.
	  * =============================================================================
	  * 2012.03.14 CHM-201216319-01 진마리아 쿼리 정리 정돈
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOsearchPsoYdChgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOsearchPsoYdChgRSQL").append("\n"); 
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
		query.append("SELECT YD_CHG_NO" ).append("\n"); 
		query.append("      ,YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("      ,CURR_CD" ).append("\n"); 
		query.append("FROM   PSO_YD_CHG" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    LGS_COST_CD = @[lgs_cost_cd]" ).append("\n"); 
		query.append("AND    YD_CD       = @[yd_cd]" ).append("\n"); 
		query.append("AND    VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("AND    LST_FLG     = 'Y'" ).append("\n"); 
		query.append("AND    TO_DATE(@[iss_dt], 'YYYY-MM-DD') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 

	}
}