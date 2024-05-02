/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchChgXprDescByChgXprNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.10.06 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOSearchChgXprDescByChgXprNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_CHG_XPR의 각종 DESC를 만들어낸다.
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchChgXprDescByChgXprNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_xpr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchChgXprDescByChgXprNoRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(PSO_GET_XPR_DESC_FNC(@[chg_xpr_no], 1))    XPR_DESC" ).append("\n"); 
		query.append(",TO_CHAR(PSO_GET_XPR_DESC_FNC(@[chg_xpr_no], 2))    DFLT_XPR_DESC" ).append("\n"); 
		query.append(",TO_CHAR(PSO_GET_XPR_DESC_FNC(@[chg_xpr_no], 3))    SYS_XPR_DESC" ).append("\n"); 
		query.append(",TO_CHAR(PSO_GET_XPR_DESC_FNC(@[chg_xpr_no], 4))    DFLT_SYS_XPR_DESC" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}