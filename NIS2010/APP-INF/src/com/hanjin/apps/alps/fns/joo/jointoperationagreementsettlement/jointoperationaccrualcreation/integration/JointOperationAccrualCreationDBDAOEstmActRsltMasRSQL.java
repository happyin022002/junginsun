/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOEstmActRsltMasRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.08.19 장강철
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

public class JointOperationAccrualCreationDBDAOEstmActRsltMasRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOEstmActRsltMasRSQL(){
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
		query.append("FileName : JointOperationAccrualCreationDBDAOEstmActRsltMasRSQL").append("\n"); 
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
		query.append("SELECT   DECODE(SUBSTR(ACCT_CD,1,1),'4','REV','5','EXP') ITEM ," ).append("\n"); 
		query.append("ESTM_VVD_TP_CD                                       ," ).append("\n"); 
		query.append("COUNT(ESTM_VVD_TP_CD) ESTM_VVD_TP_CD_CNT                                ," ).append("\n"); 
		query.append("SUM(ESTM_AMT) ESTM_AMT                                        ," ).append("\n"); 
		query.append("SUM(ACT_AMT) ACT_AMT                                         ," ).append("\n"); 
		query.append("SUM(ACCL_AMT) ACCL_AMT" ).append("\n"); 
		query.append("FROM     JOO_ESTM_ACT_RSLT" ).append("\n"); 
		query.append("WHERE    EXE_YRMON = @[exe_yrmon]" ).append("\n"); 
		query.append("GROUP BY DECODE(SUBSTR(ACCT_CD,1,1),'4','REV','5','EXP')," ).append("\n"); 
		query.append("ESTM_VVD_TP_CD" ).append("\n"); 

	}
}