/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DeliveryLocationDBDAOOffHireYardRSQL.java
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

public class DeliveryLocationDBDAOOffHireYardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Off-Hire Yard 코드 조회
	  * </pre>
	  */
	public DeliveryLocationDBDAOOffHireYardRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.lsecommon.dlvrloc.integration").append("\n"); 
		query.append("FileName : DeliveryLocationDBDAOOffHireYardRSQL").append("\n"); 
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
		query.append("SELECT  A.YD_CD, A.YD_NM" ).append("\n"); 
		query.append("FROM   (SELECT  YD_CD, YD_NM" ).append("\n"); 
		query.append("FROM    MDM_YARD A," ).append("\n"); 
		query.append("MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE   A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND     NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND     NVL(B.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT  LSE_CO_YD_CD, LSE_CO_YD_NM" ).append("\n"); 
		query.append("FROM    MDM_LSE_CO_YD" ).append("\n"); 
		query.append("WHERE   DELT_FLG <> 'Y'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     A.YD_CD = @[yd_cd]" ).append("\n"); 

	}
}