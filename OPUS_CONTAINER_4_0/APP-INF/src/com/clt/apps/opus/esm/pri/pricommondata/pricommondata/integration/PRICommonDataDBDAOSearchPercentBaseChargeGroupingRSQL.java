/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PRICommonDataDBDAOSearchPercentBaseChargeGroupingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.08
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.10.08 송호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommondata.pricommondata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HojinSong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDataDBDAOSearchPercentBaseChargeGroupingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * retrieve CHG_CD about PCT_BSE_CD
	  * </pre>
	  */
	public PRICommonDataDBDAOSearchPercentBaseChargeGroupingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pct_bse_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommondata.pricommondata.integration").append("\n"); 
		query.append("FileName : PRICommonDataDBDAOSearchPercentBaseChargeGroupingRSQL").append("\n"); 
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
		query.append("SELECT A.PCT_BSE_CD" ).append("\n"); 
		query.append("     , A.CHG_CD" ).append("\n"); 
		query.append("	 , B.CHG_NM" ).append("\n"); 
		query.append("FROM   PRI_SCG_PCT_BSE_CHG A," ).append("\n"); 
		query.append("		MDM_CHARGE B" ).append("\n"); 
		query.append("WHERE A.CHG_CD = B.CHG_CD" ).append("\n"); 
		query.append("AND	NVL( B.DELT_FLG, 'N' ) != 'Y'" ).append("\n"); 
		query.append("AND A.PCT_BSE_CD = @[pct_bse_cd]" ).append("\n"); 

	}
}