/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementValidationDBDAOcheckServiceProviderRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.05.27 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KyungMin Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementValidationDBDAOcheckServiceProviderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * checkServiceProvider
	  * </pre>
	  */
	public ContainerMovementValidationDBDAOcheckServiceProviderRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_vender",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT VNDR_LGL_ENG_NM" ).append("\n");
		query.append("FROM   MDM_VENDOR" ).append("\n");
		query.append("WHERE  VNDR_SEQ = @[p_vender]" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.integration ").append("\n");
		query.append("FileName : ContainerMovementValidationDBDAOcheckServiceProviderRSQL").append("\n");
		query.append("*/").append("\n");
	}
}