/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOPortTariffListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.28
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.07.28 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOPortTariffListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPortChargeList
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOPortTariffListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOPortTariffListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("  '' YD_CD" ).append("\n"); 
		query.append(", '' ACCT_CD" ).append("\n"); 
		query.append(", '' LGS_COST_CD" ).append("\n"); 
		query.append(", '' VNDR_SEQ" ).append("\n"); 
		query.append(", '' VNDR_ABBR_NM" ).append("\n"); 
		query.append(", '' YD_CHG_VER_SEQ" ).append("\n"); 
		query.append(", '' UPD_MNU_NO" ).append("\n"); 
		query.append(", '' YEAR" ).append("\n"); 
		query.append(", '' PORT_CD" ).append("\n"); 
		query.append(", '' EFF_DT" ).append("\n"); 
		query.append(", '' CURR_CD" ).append("\n"); 
		query.append(", '' YD_CHG_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}