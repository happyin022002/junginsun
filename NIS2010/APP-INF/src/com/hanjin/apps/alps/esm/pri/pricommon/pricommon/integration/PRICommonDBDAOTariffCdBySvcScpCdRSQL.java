/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PRICommonDBDAOTariffCdBySvcScpCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.07 
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

public class PRICommonDBDAOTariffCdBySvcScpCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Service Scope Code에 해당하는 Tariff Prefix Code, Tariff Number, Tariff Code, Tariff Name 을 조회한다.
	  * </pre>
	  */
	public PRICommonDBDAOTariffCdBySvcScpCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOTariffCdBySvcScpCdRSQL").append("\n"); 
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
		query.append("SELECT TF.TRF_PFX_CD || '-' || TF.TRF_NO AS CD" ).append("\n"); 
		query.append("     , TF.TRF_NM AS NM" ).append("\n"); 
		query.append("     , TF.TRF_PFX_CD AS ETC1" ).append("\n"); 
		query.append("     , TF.TRF_NO AS ETC2" ).append("\n"); 
		query.append("FROM PRI_TARIFF TF" ).append("\n"); 
		query.append("   , PRI_SVC_SCP_TRF ST" ).append("\n"); 
		query.append("WHERE ST.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   TF.TRF_PFX_CD = ST.TRF_PFX_CD" ).append("\n"); 
		query.append("AND   TF.TRF_NO = ST.TRF_NO" ).append("\n"); 
		query.append("AND   TF.TRF_PFX_CD = 'SMLM'" ).append("\n"); 

	}
}