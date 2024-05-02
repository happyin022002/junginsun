/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOSearchEstdVvdPrevRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.11 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOSearchEstdVvdPrevRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOSearchEstdVvdPrevRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDBDAOSearchEstdVvdPrevRSQL").append("\n"); 
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
		query.append("SELECT RLANE_CD, VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD  VVDCODE,JO_CRR_CD" ).append("\n"); 
		query.append("FROM JOO_ESTM_ACT_RSLT" ).append("\n"); 
		query.append("WHERE EXE_YRMON = TO_CHAR(ADD_MONTHS( TO_DATE( REPLACE( @[exe_yrmon],'-','') ||'01', 'YYYYMMDD'), -1),   'YYYYMM')" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("SELECT RLANE_CD, VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD VVDCODE,JO_CRR_CD" ).append("\n"); 
		query.append("FROM JOO_ESTM_ACT_RSLT" ).append("\n"); 
		query.append("WHERE EXE_YRMON = REPLACE( @[exe_yrmon],'-','')" ).append("\n"); 

	}
}