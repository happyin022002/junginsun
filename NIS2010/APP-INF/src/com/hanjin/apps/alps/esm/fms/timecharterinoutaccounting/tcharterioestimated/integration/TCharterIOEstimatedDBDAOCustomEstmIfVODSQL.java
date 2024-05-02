/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOEstimatedDBDAOCustomEstmIfVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOEstimatedDBDAOCustomEstmIfVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharterIOEstimatedDBDAOCustomEstmIfVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration").append("\n"); 
		query.append("FileName : TCharterIOEstimatedDBDAOCustomEstmIfVODSQL").append("\n"); 
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
		query.append("DELETE FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append(" WHERE EXE_YRMON = @[exe_yrmon]" ).append("\n"); 
		query.append("   AND SYS_SRC_ID = 'CDA'" ).append("\n"); 
		query.append("#if (${est_type} == 'PV')" ).append("\n"); 
		query.append("   AND ESTM_VVD_TP_CD = 'PV'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND ESTM_VVD_TP_CD != 'PV'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}