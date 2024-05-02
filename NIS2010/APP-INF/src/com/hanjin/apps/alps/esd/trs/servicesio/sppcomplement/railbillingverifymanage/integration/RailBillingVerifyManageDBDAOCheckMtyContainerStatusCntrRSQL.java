/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingVerifyManageDBDAOCheckMtyContainerStatusCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.10.21 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingVerifyManageDBDAOCheckMtyContainerStatusCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container 상태 정보 CHECK
	  * </pre>
	  */
	public RailBillingVerifyManageDBDAOCheckMtyContainerStatusCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eqNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration ").append("\n"); 
		query.append("FileName : RailBillingVerifyManageDBDAOCheckMtyContainerStatusCntrRSQL").append("\n"); 
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
		query.append("CNTR_NO CONTAINER_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD CONTAINER_TP_SZ," ).append("\n"); 
		query.append("DECODE(LSTM_CD, 'SH', 'Y', 'OF', 'Y', 'N') IS_SOC," ).append("\n"); 
		query.append("DECODE( NVL(ACIAC_DIV_CD , 'N') , 'A', 'Y', 'I', 'N') IS_ACTIVE," ).append("\n"); 
		query.append("DECODE(SYS_AREA_GRP_ID, 'USA', 'Y', 'DUS', 'Y', 'N') IS_US_REGION," ).append("\n"); 
		query.append("NVL(DMG_FLG, 'N') IS_DAMAGED," ).append("\n"); 
		query.append("NVL(DISP_FLG, 'N') IS_DISPOSAL," ).append("\n"); 
		query.append("DECODE(DECODE(LSTM_CD, 'OF', 1, 0), 1, 'Y', 'N') IS_LEASE_EXPIRED" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MST_CONTAINER" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[eqNo]" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("CNTR_NO" ).append("\n"); 

	}
}