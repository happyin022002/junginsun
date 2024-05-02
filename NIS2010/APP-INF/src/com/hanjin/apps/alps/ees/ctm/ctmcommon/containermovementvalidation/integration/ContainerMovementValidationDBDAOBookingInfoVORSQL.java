/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementValidationDBDAOBookingInfoVORSQL.java
*@FileTitle : CTM Common Util
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.05.06 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KyungMin Woo
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class ContainerMovementValidationDBDAOBookingInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public ContainerMovementValidationDBDAOBookingInfoVORSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
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
		query.append("SELECT KEY_VALUE, TEXT_VALUE FROM (" ).append("\n");
		query.append("#if (${sql_data} != '')" ).append("\n");
		query.append("$sql_data" ).append("\n");
		query.append("#end" ).append("\n");
		query.append(")" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.integration").append("\n");
		query.append("FileName : ContainerMovementValidationDBDAOBookingInfoVORSQL").append("\n");
		query.append("*/").append("\n");
	}
}