/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchCustomTpIdRSQL.java
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

public class CustomerEdiDBDAOSearchCustomTpIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustomTpId
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchCustomTpIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration ").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchCustomTpIdRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT GRP.EDI_GRP_CD," ).append("\n"); 
		query.append("GRP.CUST_TRD_PRNR_ID," ).append("\n"); 
		query.append("GRP.EDI_GRP_DESC" ).append("\n"); 
		query.append("FROM EDI_GROUP GRP, EDI_GRP_CUST CUST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("GRP.EDI_GRP_CD = CUST.EDI_GRP_CD" ).append("\n"); 
		query.append("AND GRP.CO_DIV_CD = CUST.CO_DIV_CD" ).append("\n"); 
		query.append("#if(${tp_id} != '')" ).append("\n"); 
		query.append("AND GRP.CUST_TRD_PRNR_ID = @[tp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}