/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTClosingDBDAOGlEstmRevVvdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTClosingDBDAOGlEstmRevVvdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Monthly Target VVD Inquiry
	  * </pre>
	  */
	public AGTClosingDBDAOGlEstmRevVvdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.integration").append("\n"); 
		query.append("FileName : AGTClosingDBDAOGlEstmRevVvdVORSQL").append("\n"); 
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
		query.append("A.REV_YRMON," ).append("\n"); 
		query.append("A.VSL_CD" ).append("\n"); 
		query.append("|| A.SKD_VOY_NO" ).append("\n"); 
		query.append("|| A.SKD_DIR_CD" ).append("\n"); 
		query.append("|| A.REV_DIR_CD                           AS VSL_DIR_CD," ).append("\n"); 
		query.append("A.ESTM_IOC_DIV_CD," ).append("\n"); 
		query.append("RLANE_CD                               AS LANE," ).append("\n"); 
		query.append("A.ESTM_VVD_TP_CD," ).append("\n"); 
		query.append("NVL(" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("'Y'" ).append("\n"); 
		query.append("FROM AGT_ESTM_COMM_BKG_INFO" ).append("\n"); 
		query.append("WHERE ESTM_YRMON = A.EXE_YRMON" ).append("\n"); 
		query.append("AND ROWNUM     = 1" ).append("\n"); 
		query.append("), 'N'" ).append("\n"); 
		query.append(")                                  AS STATUS" ).append("\n"); 
		query.append("FROM GL_ESTM_REV_VVD A" ).append("\n"); 
		query.append("WHERE A.EXE_YRMON = @[exe_yrmon]" ).append("\n"); 
		query.append("AND A.ESTM_BC_DIV_CD = 'C'" ).append("\n"); 

	}
}