/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierRestrictionDBDAOVopScg0009ConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.21
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.21 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierRestrictionDBDAOVopScg0009ConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierRestrictionDBDAOVopScg0009ConditionRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("'' GRP_CD              ," ).append("\n"); 
		query.append("'' IMDG_UN_NO_SEQ      ," ).append("\n"); 
		query.append("'' IMDG_CLSS_CD_DESC   ," ).append("\n"); 
		query.append("'' PRP_SHP_NM          ," ).append("\n"); 
		query.append("'' CRR_FULL_NM         ," ).append("\n"); 
		query.append("'' IMDG_UN_NO          ," ).append("\n"); 
		query.append("'' CRR_CD              ," ).append("\n"); 
		query.append("'' OPTCLASS            ," ).append("\n"); 
		query.append("'' IMDG_CLSS_CD ," ).append("\n"); 
		query.append("'' IMDG_TEK_NM_CHECK" ).append("\n"); 
		query.append("FROM  DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.integration").append("\n"); 
		query.append("FileName : CarrierRestrictionDBDAOVopScg0009ConditionRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}