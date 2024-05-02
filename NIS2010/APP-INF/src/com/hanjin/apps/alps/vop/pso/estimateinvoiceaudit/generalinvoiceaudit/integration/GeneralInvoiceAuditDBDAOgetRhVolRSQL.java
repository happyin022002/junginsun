/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetRhVolRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2010.01.26 김진주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim JinJoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetRhVolRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff 비용 계산을 위해 Rehandling Volume을 구한다.
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetRhVolRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration ").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetRhVolRSQL").append("\n"); 
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
		query.append("SELECT count(*)" ).append("\n"); 
		query.append("FROM TDR_CNTR_DETAIL" ).append("\n"); 
		query.append("WHERE  vsl_cd = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("and VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("and DIR_CD=  substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("and PORT_CD = substr(@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("and PRECELL IS NOT NULL" ).append("\n"); 
		query.append("and STATUS       = 'ST'" ).append("\n"); 

	}
}