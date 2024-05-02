/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InlandCostManageDBDAOsearchCntDefaultCurrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.12
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.06.12 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandCostManageDBDAOsearchCntDefaultCurrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntDefaultCurr
	  * </pre>
	  */
	public InlandCostManageDBDAOsearchCntDefaultCurrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration").append("\n"); 
		query.append("FileName : InlandCostManageDBDAOsearchCntDefaultCurrRSQL").append("\n"); 
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
		query.append("SELECT A.CNT_CD" ).append("\n"); 
		query.append(",B.CNT_NM" ).append("\n"); 
		query.append(",D.CONTI_NM" ).append("\n"); 
		query.append(",C.SCONTI_NM" ).append("\n"); 
		query.append(",B.EU_CNT_FLG" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",(SELECT M.CURR_NM FROM MDM_CURRENCY M WHERE M.CURR_CD = A.CURR_CD) CURR_NM" ).append("\n"); 
		query.append(",A.RHQ_CD" ).append("\n"); 
		query.append(",(SELECT USR_NM FROM COM_USER" ).append("\n"); 
		query.append("WHERE USR_ID = A.UPD_USR_ID ) UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("FROM TRS_COST_TRF_CURR A" ).append("\n"); 
		query.append(",MDM_COUNTRY       B" ).append("\n"); 
		query.append(",MDM_SUBCONTINENT  C" ).append("\n"); 
		query.append(",MDM_CONTINENT     D" ).append("\n"); 
		query.append("WHERE A.CNT_CD = B.CNT_CD(+)" ).append("\n"); 
		query.append("AND B.SCONTI_CD = C.SCONTI_CD(+)" ).append("\n"); 
		query.append("AND C.CONTI_CD  = D.CONTI_CD(+)" ).append("\n"); 
		query.append("#if (${rhq_cd} != '')" ).append("\n"); 
		query.append("AND     A.RHQ_CD IN ($rhq_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("AND     A.CNT_CD IN ($cnt_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${curr_cd} != '')" ).append("\n"); 
		query.append("AND     A.CURR_CD IN ($curr_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}