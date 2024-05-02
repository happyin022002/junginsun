/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CEDEXCodeMgtDBDAOsearchTariffCodeFindListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.10.28 함형석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 함형석
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CEDEXCodeMgtDBDAOsearchTariffCodeFindListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTariffCodeFindListData
	  * </pre>
	  */
	public CEDEXCodeMgtDBDAOsearchTariffCodeFindListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("typ",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.integration").append("\n"); 
		query.append("FileName : CEDEXCodeMgtDBDAOsearchTariffCodeFindListDataRSQL").append("\n"); 
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
		query.append("SELECT a.eq_cmpo_num_iso_cd  num_cd," ).append("\n"); 
		query.append("a.eq_cmpo_cd  cd," ).append("\n"); 
		query.append("a.eq_cmpo_nm  nm" ).append("\n"); 
		query.append("FROM MNR_EQ_CMPO_CD a" ).append("\n"); 
		query.append("WHERE 'COM' = nvl(@[typ], '')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT b.EQ_CEDEX_OTR_NUM_CD  num_cd," ).append("\n"); 
		query.append("b.EQ_CEDEX_OTR_TP_CD   cd," ).append("\n"); 
		query.append("b.EQ_CEDEX_OTR_CD_NM   nm" ).append("\n"); 
		query.append("FROM  MNR_CEDEX_OTR_CD b" ).append("\n"); 
		query.append("WHERE b.EQ_CEDEX_OTR_TP_CD = nvl(@[typ], '')" ).append("\n"); 

	}
}