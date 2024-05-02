/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AsiaInlandCostManageDBDAOSearchShqOfcFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.11
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AsiaInlandCostManageDBDAOSearchShqOfcFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.06.13 변종건 [CHM-201217633] Cost & Guideline Tariff Status Monitoring 신규 개발
	  * </pre>
	  */
	public AsiaInlandCostManageDBDAOSearchShqOfcFlgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration").append("\n"); 
		query.append("FileName : AsiaInlandCostManageDBDAOSearchShqOfcFlgRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(SIGN(COUNT(1)),1,'Y','N') SHQ_FLG" ).append("\n"); 
		query.append("FROM    MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE   OFC_KND_CD = '1'" ).append("\n"); 
		query.append("AND     NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND     OFC_CD = @[usr_ofc_cd]" ).append("\n"); 

	}
}