/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOSearchEstdVvdEstmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 조병연
*@LastVersion : 1.0
* 2012.04.03 조병연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JO BYEANG YEAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOSearchEstdVvdEstmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Current Estm Cost가 0인 것들의 조회쿼리
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOSearchEstdVvdEstmRSQL(){
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
		query.append("FileName : JointOperationAccrualCreationDBDAOSearchEstdVvdEstmRSQL").append("\n"); 
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
		query.append("SELECT  J.RLANE_CD, J.VSL_CD||J.SKD_VOY_NO||J.SKD_DIR_CD||J.REV_DIR_CD VVDCODE" ).append("\n"); 
		query.append("FROM   JOO_ESTM_ACT_RSLT J" ).append("\n"); 
		query.append("WHERE J.EXE_YRMON = REPLACE( @[exe_yrmon], '-' , '')" ).append("\n"); 
		query.append("AND      J.ACCT_CD IN ('411221', '510921')" ).append("\n"); 
		query.append("GROUP BY J.RLANE_CD, J.VSL_CD||J.SKD_VOY_NO||J.SKD_DIR_CD||J.REV_DIR_CD" ).append("\n"); 
		query.append("HAVING  SUM(J.ESTM_AMT) = 0" ).append("\n"); 

	}
}