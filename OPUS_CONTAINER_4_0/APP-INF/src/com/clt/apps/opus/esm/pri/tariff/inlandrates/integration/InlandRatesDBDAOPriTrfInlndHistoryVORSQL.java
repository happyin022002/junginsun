/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InlandRatesDBDAOPriTrfInlndHistoryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.inlandrates.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRatesDBDAOPriTrfInlndHistoryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inland 리스트를 조회합니다.
	  * </pre>
	  */
	public InlandRatesDBDAOPriTrfInlndHistoryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("access_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.pri.tariff.inlandrates.integration").append("\n"); 
		query.append("FileName : InlandRatesDBDAOPriTrfInlndHistoryVORSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("        TRF_PFX_CD" ).append("\n"); 
		query.append("       ,TRF_NO" ).append("\n"); 
		query.append("       ,TRF_INLND_SEQ" ).append("\n"); 
		query.append("       ,MAX(TRF_INLND_NM) AS TRF_INLND_NM" ).append("\n"); 
		query.append("  FROM  PRI_TRF_INLND" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("   AND  TRF_NO     = @[trf_no]" ).append("\n"); 
		query.append("   AND  TRF_INLND_STS_CD = 'F'" ).append("\n"); 
		query.append("#if (${access_dt} != '') " ).append("\n"); 
		query.append("   AND  EFF_DT     <= TO_DATE(@[access_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("   AND  NVL(EXP_DT, TO_DATE('9999-12-31', 'YYYY-MM-DD')) >= TO_DATE(@[access_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY TRF_PFX_CD, TRF_NO, TRF_INLND_SEQ" ).append("\n"); 
		query.append("ORDER BY TRF_INLND_NM" ).append("\n"); 

	}
}