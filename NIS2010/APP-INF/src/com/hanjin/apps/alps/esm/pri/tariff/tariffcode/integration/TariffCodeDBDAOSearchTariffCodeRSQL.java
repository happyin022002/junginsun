/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffCodeDBDAOSearchTariffCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.17
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2010.11.17 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffcode.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffCodeDBDAOSearchTariffCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력한 Tariff Code에 해당하는 Tariff Scope 조회
	  * </pre>
	  */
	public TariffCodeDBDAOSearchTariffCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.tariffcode.integration").append("\n"); 
		query.append("FileName : TariffCodeDBDAOSearchTariffCodeRSQL").append("\n"); 
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
		query.append("SELECT P.SVC_SCP_CD, M.SVC_SCP_NM" ).append("\n"); 
		query.append("FROM MDM_SVC_SCP M," ).append("\n"); 
		query.append("     PRI_SVC_SCP_TRF P" ).append("\n"); 
		query.append("WHERE P.TRF_PFX_CD = SUBSTR(@[trf_pfx_cd],1,4)" ).append("\n"); 
		query.append("  AND P.SVC_SCP_CD = M.SVC_SCP_CD" ).append("\n"); 
		query.append("  AND P.TRF_NO 	   = @[trf_no]" ).append("\n"); 

	}
}