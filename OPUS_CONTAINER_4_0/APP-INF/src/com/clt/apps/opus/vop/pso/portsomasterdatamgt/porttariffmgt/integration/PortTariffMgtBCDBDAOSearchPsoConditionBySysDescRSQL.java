/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchPsoConditionBySysDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.03.17 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOSearchPsoConditionBySysDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COND_SYS_DESC로 Condition조회하기
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchPsoConditionBySysDescRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_sys_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration ").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchPsoConditionBySysDescRSQL").append("\n"); 
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
		query.append("/**** COND_SYS_DESC로 Condition조회하기 ****/" ).append("\n"); 
		query.append("SELECT A.*" ).append("\n"); 
		query.append("FROM   PSO_CONDITION A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.COND_SYS_DESC = @[cond_sys_desc]" ).append("\n"); 

	}
}