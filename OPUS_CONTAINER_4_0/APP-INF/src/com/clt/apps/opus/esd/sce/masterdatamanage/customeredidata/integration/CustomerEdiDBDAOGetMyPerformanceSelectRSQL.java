/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerEdiDBDAOGetMyPerformanceSelectRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.01.28 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee YounJung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOGetMyPerformanceSelectRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetMyPerformanceSelect
	  * </pre>
	  */
	public CustomerEdiDBDAOGetMyPerformanceSelectRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration ").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOGetMyPerformanceSelectRSQL").append("\n"); 
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
		query.append("SELECT EDI_GRP_CD A," ).append("\n"); 
		query.append("CUST_TRD_PRNR_ID B," ).append("\n"); 
		query.append("EDI_GRP_DESC C,EDI_CGO_RMK D" ).append("\n"); 
		query.append("FROM( SELECT CUST.EDI_GRP_CD ," ).append("\n"); 
		query.append("CUST.CUST_TRD_PRNR_ID ," ).append("\n"); 
		query.append("CUST.EDI_GRP_DESC ," ).append("\n"); 
		query.append("CUST.EDI_CGO_RMK ," ).append("\n"); 
		query.append("STS.EDI_STND_STS_CD," ).append("\n"); 
		query.append("STS.CUST_EDI_STS_CD ," ).append("\n"); 
		query.append("ROWNUM RNUM FROM EDI_USR_CUST CUST, EDI_USR_STS STS" ).append("\n"); 
		query.append("WHERE CUST.CRE_USR_ID = STS.CRE_USR_ID" ).append("\n"); 
		query.append("AND CUST.EDI_GRP_CD = STS.EDI_GRP_CD" ).append("\n"); 
		query.append("AND CUST.EDI_STS_SEQ = STS.EDI_STS_SEQ" ).append("\n"); 
		query.append("#if(${user_id} != '')" ).append("\n"); 
		query.append("AND CUST.CRE_USR_ID = @[user_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CUST.EDI_STS_SEQ = 2 )" ).append("\n"); 
		query.append("GROUP BY EDI_GRP_CD, CUST_TRD_PRNR_ID,EDI_GRP_DESC,EDI_CGO_RMK" ).append("\n"); 

	}
}