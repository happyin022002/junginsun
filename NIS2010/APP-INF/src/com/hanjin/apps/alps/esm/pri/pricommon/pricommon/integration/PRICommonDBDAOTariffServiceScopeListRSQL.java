/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PRICommonDBDAOTariffServiceScopeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOTariffServiceScopeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Code가 존재하는 Service Scope List 를 조회한다.
	  * </pre>
	  */
	public PRICommonDBDAOTariffServiceScopeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOTariffServiceScopeListRSQL").append("\n"); 
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
		query.append("SELECT SP.SVC_SCP_CD AS CD" ).append("\n"); 
		query.append("     , SP.SVC_SCP_NM AS NM" ).append("\n"); 
		query.append("     , '' AS ETC1" ).append("\n"); 
		query.append("     , '' AS ETC2" ).append("\n"); 
		query.append("     , '' AS ETC3" ).append("\n"); 
		query.append("     , TF.TRF_PFX_CD || ';' || TF.TRF_NO AS ETC4" ).append("\n"); 
		query.append("     , SP.SVC_SCP_CD || '|' || SP.SVC_SCP_NM AS ETC5" ).append("\n"); 
		query.append("FROM MDM_SVC_SCP SP" ).append("\n"); 
		query.append("   , PRI_TARIFF TF" ).append("\n"); 
		query.append("   , PRI_SVC_SCP_TRF ST" ).append("\n"); 
		query.append("WHERE SP.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND   ST.SVC_SCP_CD = SP.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   TF.TRF_PFX_CD = ST.TRF_PFX_CD" ).append("\n"); 
		query.append("AND   TF.TRF_PFX_CD = 'SMLM'" ).append("\n"); 
		query.append("AND   TF.TRF_NO = ST.TRF_NO" ).append("\n"); 
		query.append("ORDER BY SP.SVC_SCP_CD" ).append("\n"); 

	}
}