/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationDBDAOChangePODTariffRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.24 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOChangePODTariffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChangePODTariff
	  * </pre>
	  */
	public DMTCalculationDBDAOChangePODTariffRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_rly",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("post_rly",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("" ).append("\n"); 
		query.append("SELECT NVL (CONTI_CD, ' ') 	CONTI_CD" ).append("\n"); 
		query.append(",NVL (CNT_CD, ' ') 	CNT_CD" ).append("\n"); 
		query.append(",NVL (RGN_CD, ' ') 	RGN_CD" ).append("\n"); 
		query.append(",NVL (STE_CD, ' ') 	STE_CD" ).append("\n"); 
		query.append(",NVL (LOC_CD, ' ') 	LOC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_type} == 'ORG')" ).append("\n"); 
		query.append("WHERE LOC_CD 	= @[del_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${type} == 'Y')" ).append("\n"); 
		query.append("WHERE	LOC_CD	= DECODE( @[io_bnd], 'I', @[post_rly], @[pre_rly] )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE LOC_CD 	= @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOChangePODTariffRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}