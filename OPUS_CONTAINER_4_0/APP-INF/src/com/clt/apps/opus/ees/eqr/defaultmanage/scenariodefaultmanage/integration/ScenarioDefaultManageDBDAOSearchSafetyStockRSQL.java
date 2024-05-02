/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchSafetyStockRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.11.06 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOSearchSafetyStockRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSafetyStock
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchSafetyStockRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lvlcd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchSafetyStockRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("MAX(DECODE ( rumm , 1 ,ECC_CD)) ECC_CD" ).append("\n"); 
		query.append("#foreach( $key in ${perfix})" ).append("\n"); 
		query.append(",MAX(DECODE ( CNTR_TPSZ_CD , '$key' , SFSTK_LVL_CD ))   ${key}SFSTK_LVL_CD" ).append("\n"); 
		query.append(",MAX(DECODE ( CNTR_TPSZ_CD , '$key' , SFSTK_VOL_QTY))   ${key}SFSTK_VOL_QTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",MAX(DECODE(CRE_DT,UPD_DT, 'N', 'Y')) AS TIMEGAP" ).append("\n"); 
		query.append(",MAX(to_char(CRE_DT,'YYYYMMDD')) CRE_DT" ).append("\n"); 
		query.append(",MAX(to_char(UPD_DT,'YYYYMMDD')) UPD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT ECC_CD" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",SFSTK_LVL_CD" ).append("\n"); 
		query.append(",SFSTK_VOL_QTY" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER (PARTITION BY ECC_CD,CNTR_TPSZ_CD ORDER BY ROWNUM) rumm" ).append("\n"); 
		query.append("FROM  EQR_ECC_SFT_STK" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("#if(${lvlcd} != '')" ).append("\n"); 
		query.append("SFSTK_LVL_CD = @[lvlcd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SFSTK_LVL_CD IN ('1','2','3','4','5','M')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${loc} != '')" ).append("\n"); 
		query.append("AND ECC_CD IN ( SELECT DISTINCT(ECC_CD) ECC_CD" ).append("\n"); 
		query.append("FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("#if( ${loc} == 'L')" ).append("\n"); 
		query.append("WHERE LCC_CD IN ( ${loctype})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${loc} == 'R')" ).append("\n"); 
		query.append("WHERE RCC_CD IN ( ${loctype})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${loc} == 'E')" ).append("\n"); 
		query.append("WHERE ECC_CD IN ( ${loctype})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${tpsztype} != '')" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD IN (${tpszcd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY rumm , ECC_CD" ).append("\n"); 

	}
}