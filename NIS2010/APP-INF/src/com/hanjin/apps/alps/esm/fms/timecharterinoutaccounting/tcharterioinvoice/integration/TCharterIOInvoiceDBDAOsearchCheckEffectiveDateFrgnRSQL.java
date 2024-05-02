/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOsearchCheckEffectiveDateFrgnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDBDAOsearchCheckEffectiveDateFrgnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eff_dt 날짜를 조회를 한다.
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOsearchCheckEffectiveDateFrgnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOsearchCheckEffectiveDateFrgnRSQL").append("\n"); 
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
		query.append("SELECT 	EFF_YRMON" ).append("\n"); 
		query.append("FROM   	AP_PERIOD P" ).append("\n"); 
		query.append("WHERE 	P.SYS_DIV_CD = '17'" ).append("\n"); 
		query.append("AND   	P.AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("AND   	P.EFF_YRMON = @[eff_yrmon]" ).append("\n"); 
		query.append("AND   	OFC_CD =  (SELECT S.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("				   FROM   MDM_ORGANIZATION S" ).append("\n"); 
		query.append("				   WHERE  S.OFC_CD = @[slp_ofc_cd])" ).append("\n"); 
		query.append("AND   	P.CLZ_STS_CD = 'O'" ).append("\n"); 

	}
}