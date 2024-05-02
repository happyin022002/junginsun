/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearch04SingleTransportationSOManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.12.30 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSearch04SingleTransportationSOManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * f_cmd : SEARCH04
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearch04SingleTransportationSOManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearch04SingleTransportationSOManageRSQL").append("\n"); 
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
		query.append("SELECT A.CNTR_NO EQ_NO, A.CNTR_TPSZ_CD EQ_TPSZ_CD," ).append("\n"); 
		query.append("A.AGMT_CTY_CD||A.AGMT_SEQ LESSOR," ).append("\n"); 
		query.append("A.LSTM_CD, A.OWNR_CO_CD, A.CNTR_USE_CO_CD EQ_USED," ).append("\n"); 
		query.append("A.CNMV_STS_CD MOVEMENT_STS, A.CRNT_YD_CD CREATION_YARD," ).append("\n"); 
		query.append("TO_CHAR(A.CNMV_DT, 'YYYY-MM-DD') EVENT_DATE," ).append("\n"); 
		query.append("DECODE(B.OFFH_YD_CD, NULL,'',B.OFFH_YD_CD) OFFH_YD_CD" ).append("\n"); 
		query.append("FROM MST_CONTAINER A, (SELECT CNTR_NO, OFFH_YD_CD  FROM LSE_AVAL_OFFH" ).append("\n"); 
		query.append("WHERE OFFH_DUE_DT > TO_CHAR(LAST_DAY(ADD_MONTHS(SYSDATE, -1)), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND OFFH_STS_CD IN ('R','C') ) B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.CNTR_NO = B.CNTR_NO (+)" ).append("\n"); 
		query.append("AND A.CNTR_NO LIKE @[scntr_no]||'%'" ).append("\n"); 

	}
}