/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOcheckFormulaUsingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.03.16 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOcheckFormulaUsingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkFormulaUsing
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOcheckFormulaUsingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foml_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOcheckFormulaUsingRSQL").append("\n"); 
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
		query.append("/**** FORMULA 존재여부 및 UPD_MNU_NO 확인 ****/" ).append("\n"); 
		query.append("SELECT SUM(CNT)" ).append("\n"); 
		query.append(",MAX(UPD_MNU_NO)" ).append("\n"); 
		query.append("FROM   (SELECT COUNT(*) CNT" ).append("\n"); 
		query.append(",MAX(A.UPD_MNU_NO) UPD_MNU_NO" ).append("\n"); 
		query.append("FROM   PSO_FORMULA A" ).append("\n"); 
		query.append("WHERE  A.FOML_NO = @[foml_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append(",-1" ).append("\n"); 
		query.append("FROM   PSO_FORMULA Y" ).append("\n"); 
		query.append("WHERE  Y.FOML_NO = @[foml_no]" ).append("\n"); 
		query.append("AND    EXISTS (SELECT 1 FROM PSO_CHG_XPR_DTL X WHERE X.FOML_NO = Y.FOML_NO)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}