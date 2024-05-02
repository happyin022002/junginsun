/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOsearch02SingleTransportationSOManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.12.30 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOsearch02SingleTransportationSOManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * f_cmd : SEARCH02
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOsearch02SingleTransportationSOManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOsearch02SingleTransportationSOManageRSQL").append("\n"); 
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
		query.append("#set(${arrEqNo}=${arrEqNo})" ).append("\n"); 
		query.append("#set(${arrSize}=${arrSize})" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.CNTR_NO" ).append("\n"); 
		query.append(",   A.CNTR_TPSZ_CD EQ_TPSZ_CD" ).append("\n"); 
		query.append(",   A.AGMT_CTY_CD||A.AGMT_SEQ LESSOR" ).append("\n"); 
		query.append(",   A.LSTM_CD" ).append("\n"); 
		query.append(",   A.OWNR_CO_CD" ).append("\n"); 
		query.append(",   A.CNTR_USE_CO_CD EQ_USED" ).append("\n"); 
		query.append(",   A.CNMV_STS_CD MOVEMENT_STS" ).append("\n"); 
		query.append(",   A.CRNT_YD_CD CREATION_YARD" ).append("\n"); 
		query.append(",   TO_CHAR(A.CNMV_DT, 'YYYY-MM-DD') EVENT_DATE" ).append("\n"); 
		query.append(",	DECODE(B.OFFH_YD_CD, NULL,'',B.OFFH_YD_CD) OFFH_YD_CD" ).append("\n"); 
		query.append("FROM MST_CONTAINER A, (SELECT CNTR_NO, OFFH_YD_CD  FROM LSE_AVAL_OFFH" ).append("\n"); 
		query.append("WHERE OFFH_DUE_DT > TO_CHAR(LAST_DAY(ADD_MONTHS(SYSDATE, -1)), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND OFFH_STS_CD IN ('R','C') ) B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.CNTR_NO = B.CNTR_NO (+)" ).append("\n"); 
		query.append("AND A.CNTR_NO IN (" ).append("\n"); 
		query.append("#if (${arrSize} != '' )" ).append("\n"); 
		query.append("#foreach(${key} IN ${arrSize})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("${arrEqNo.get($key)}" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", ${arrEqNo.get($key)}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}