/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchDurationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.30
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.09.30 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOSearchDurationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vvd의 P/F Duration을 구한다.
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchDurationRSQL(){
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
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchDurationRSQL").append("\n"); 
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
		query.append("SELECT SVC_DUR_DYS" ).append("\n"); 
		query.append("FROM VSK_PF_SKD T1, VSK_VSL_SKD T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.VSL_SLAN_CD=T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND T1.PF_SVC_TP_CD=T2.PF_SKD_TP_CD" ).append("\n"); 
		query.append("AND T2.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND T2.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND T2.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 

	}
}