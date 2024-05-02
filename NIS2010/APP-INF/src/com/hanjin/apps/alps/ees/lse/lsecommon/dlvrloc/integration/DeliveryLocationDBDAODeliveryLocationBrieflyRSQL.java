/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DeliveryLocationDBDAODeliveryLocationBrieflyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.12.28 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.dlvrloc.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DeliveryLocationDBDAODeliveryLocationBrieflyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Delivery Location Search
	  * </pre>
	  */
	public DeliveryLocationDBDAODeliveryLocationBrieflyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.lsecommon.dlvrloc.integration").append("\n"); 
		query.append("FileName : DeliveryLocationDBDAODeliveryLocationBrieflyRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.LOC_CD" ).append("\n"); 
		query.append(", A.SCC_CD" ).append("\n"); 
		query.append(", A.LOC_NM" ).append("\n"); 
		query.append(", A.RGN_CD" ).append("\n"); 
		query.append(", A.CNT_CD" ).append("\n"); 
		query.append(", A.STE_CD" ).append("\n"); 
		query.append(", A.CONTI_CD" ).append("\n"); 
		query.append(", A.PORT_INLND_CD" ).append("\n"); 
		query.append(", A.LOC_CHR_CD" ).append("\n"); 
		query.append(", A.LOC_TP_CD" ).append("\n"); 
		query.append("FROM  MDM_LOCATION A" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.LOC_CD = @[loc_cd]" ).append("\n"); 

	}
}