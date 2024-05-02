/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InlandRatesDBDAOTariffCdListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.17
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.11.17 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.inlandrates.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRatesDBDAOTariffCdListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Code List 정보를 조회한다.
	  * </pre>
	  */
	public InlandRatesDBDAOTariffCdListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.tariff.inlandrates.integration").append("\n"); 
		query.append("FileName : InlandRatesDBDAOTariffCdListVORSQL").append("\n"); 
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
		query.append("WITH USE_TARIFF AS (" ).append("\n"); 
		query.append("	SELECT TRF_PFX_CD" ).append("\n"); 
		query.append("		 , TRF_NO" ).append("\n"); 
		query.append("		 , MAX(AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("	  FROM PRI_TRF_BZC" ).append("\n"); 
		query.append("	 WHERE TRF_BZC_STS_CD = 'F'" ).append("\n"); 
		query.append("	 GROUP BY TRF_PFX_CD, TRF_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.TRF_PFX_CD ||'-'|| A.TRF_NO AS CD" ).append("\n"); 
		query.append("	 , A.TRF_NM NM" ).append("\n"); 
		query.append("  FROM PRI_TARIFF A, USE_TARIFF B" ).append("\n"); 
		query.append(" WHERE A.TRF_PFX_CD		= B.TRF_PFX_CD" ).append("\n"); 
		query.append("   AND A.TRF_NO			= B.TRF_NO" ).append("\n"); 
		query.append("   AND A.TRF_INLND_FLG	= 'Y'" ).append("\n"); 
		query.append("   AND A.DELT_FLG		= 'N'" ).append("\n"); 
		query.append(" ORDER BY A.TRF_NO" ).append("\n"); 

	}
}