/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrSafetyStockManageDBDAOSearchCntrSafetyStockRSQL.java
*@FileTitle : Safty Stock
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.11 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrSafetyStockManageDBDAOSearchCntrSafetyStockRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_EQR_0026 - Safty Stock 조회
	  * </pre>
	  */
	public CntrSafetyStockManageDBDAOSearchCntrSafetyStockRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("level_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.integration").append("\n"); 
		query.append("FileName : CntrSafetyStockManageDBDAOSearchCntrSafetyStockRSQL").append("\n"); 
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
		query.append("SELECT	MAX(DECODE ( rumm , 1 ,ECC_CD)) ECC_CD" ).append("\n"); 
		query.append("#foreach( $key in ${arrtpsz})" ).append("\n"); 
		query.append(",MAX(DECODE ( CNTR_TPSZ_CD , '$key' , SFSTK_LVL_CD ))    ${key}SFSTK_LVL_CD" ).append("\n"); 
		query.append(",MAX(DECODE ( CNTR_TPSZ_CD , '$key' , SFSTK_VOL_QTY))    ${key}SFSTK_VOL_QTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",SCNR_ID" ).append("\n"); 
		query.append(",MAX(DECODE(CRE_DT,UPD_DT,'N','Y')) AS TIMEGAP" ).append("\n"); 
		query.append(",MAX(TO_CHAR(CRE_DT,'YYYYMMDD')) AS CRE_DT" ).append("\n"); 
		query.append(",MAX(TO_CHAR(UPD_DT,'YYYYMMDD')) AS UPD_DT" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	SCNR_ID" ).append("\n"); 
		query.append(",ECC_CD" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",SFSTK_LVL_CD" ).append("\n"); 
		query.append(",SFSTK_VOL_QTY" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER (PARTITION BY ECC_CD,CNTR_TPSZ_CD ORDER BY ROWNUM) rumm" ).append("\n"); 
		query.append("FROM	EQR_SCNR_ECC_SFT_STK" ).append("\n"); 
		query.append("WHERE	SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("#if (${level_cd} != '')" ).append("\n"); 
		query.append("AND SFSTK_LVL_CD = @[level_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${status} != '')" ).append("\n"); 
		query.append("AND	ECC_CD IN (" ).append("\n"); 
		query.append("SELECT	DISTINCT(ECC_CD) ECC_CD" ).append("\n"); 
		query.append("FROM	MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE	${status} IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( $arrtpsz.size() > 0 )" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpsz})" ).append("\n"); 
		query.append("#if($velocityCount < $arrtpsz.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY	RUMM" ).append("\n"); 
		query.append(",	ECC_CD" ).append("\n"); 
		query.append(",	SCNR_ID" ).append("\n"); 

	}
}