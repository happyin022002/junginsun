/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffCodeDBDAOSearchTariffCodeUsedRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.28
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2010.10.28 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffcode.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffCodeDBDAOSearchTariffCodeUsedRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTariffCodeUsed
	  * </pre>
	  */
	public TariffCodeDBDAOSearchTariffCodeUsedRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.tariff.tariffcode.integration").append("\n"); 
		query.append("FileName : TariffCodeDBDAOSearchTariffCodeUsedRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) AS USED_FLG" ).append("\n"); 
		query.append("FROM PRI_TRF_BZC" ).append("\n"); 
		query.append("WHERE TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("AND TRF_PFX_CD = SUBSTR(@[trf_pfx_cd],1,4) " ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}