/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetBowThurustPowerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetBowThurustPowerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2014.07.18 이윤정 CHM-201430973 [PSO] New Object (Bow Thrust Power)
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetBowThurustPowerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetBowThurustPowerRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append(",BWTHST_BHP_PWR AS HP" ).append("\n"); 
		query.append(",BWTHST_BHP_PWR * 0.7355 AS KW" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VSL_CD = SUBSTR(@[vvd], 1, 4) " ).append("\n"); 

	}
}