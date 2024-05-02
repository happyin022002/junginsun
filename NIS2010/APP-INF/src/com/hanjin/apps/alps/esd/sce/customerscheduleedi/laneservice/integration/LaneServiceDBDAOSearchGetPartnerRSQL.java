/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneServiceDBDAOSearchGetPartnerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.12
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.04.12 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.laneservice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneServiceDBDAOSearchGetPartnerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public LaneServiceDBDAOSearchGetPartnerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.laneservice.integration").append("\n"); 
		query.append("FileName : LaneServiceDBDAOSearchGetPartnerRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT B.CUST_TRD_PRNR_ID," ).append("\n"); 
		query.append("A.CUST_TRD_PRNR_NM ," ).append("\n"); 
		query.append("B.EDI_SVC_TP_NM," ).append("\n"); 
		query.append("B.EDI_STUP_ID" ).append("\n"); 
		query.append("FROM SCE_EDI_PRNR A," ).append("\n"); 
		query.append("VSK_CUST_SKD_EDI_SET B" ).append("\n"); 
		query.append("WHERE A.CUST_TRD_PRNR_ID(+) = B.CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_trd_prnr_id} != '')" ).append("\n"); 
		query.append("AND B.CUST_TRD_PRNR_ID = @[cust_trd_prnr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}