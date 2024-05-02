/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOEstdVvdRSQL.java
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

public class JointOperationAccrualCreationDBDAOEstdVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOEstdVvdRSQL(){
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
		query.append("FileName : JointOperationAccrualCreationDBDAOEstdVvdRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT G.RLANE_CD, G.VSL_CD||G.SKD_VOY_NO||G.SKD_DIR_CD||G.REV_DIR_CD vvdcode" ).append("\n"); 
		query.append("FROM GL_ESTM_REV_VVD G, AR_ROUT_RNK R" ).append("\n"); 
		query.append("WHERE G.RLANE_CD = R.RLANE_CD" ).append("\n"); 
		query.append("AND G.ESTM_IOC_DIV_CD = SUBSTR(ZN_IOC_CD,1,2)" ).append("\n"); 
		query.append("AND G.EXE_YRMON = REPLACE(@[exe_yrmon],'-','')" ).append("\n"); 
		query.append("AND ( ( G.REV_YRMON = REPLACE( @[exe_yrmon], '-', '')  AND    G.ESTM_IOC_DIV_CD IN ('OO', 'IA','IM', 'IE') )" ).append("\n"); 
		query.append("OR  ( G.REV_YRMON > REPLACE( @[exe_yrmon], '-', '')  AND ( G.ESTM_VVD_TP_CD = 'PV' AND R.ZN_IOC_CD NOT IN ('IA', 'IE', 'IM') ) ) )" ).append("\n"); 
		query.append("AND G.ESTM_BC_DIV_CD = 'C'" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("SELECT DISTINCT J.RLANE_CD, J.VSL_CD||J.SKD_VOY_NO||J.SKD_DIR_CD||J.REV_DIR_CD" ).append("\n"); 
		query.append("FROM JOO_ESTM_ACT_RSLT J" ).append("\n"); 
		query.append("WHERE EXE_YRMON = REPLACE( @[exe_yrmon], '-' , '')" ).append("\n"); 

	}
}