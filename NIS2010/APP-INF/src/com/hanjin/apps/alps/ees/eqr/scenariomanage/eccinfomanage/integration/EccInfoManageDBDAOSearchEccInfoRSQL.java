/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EccInfoManageDBDAOSearchEccInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EccInfoManageDBDAOSearchEccInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_ECC 테이블 데이터 조회
	  * </pre>
	  */
	public EccInfoManageDBDAOSearchEccInfoRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("ECC_CD" ).append("\n"); 
		query.append(",STO_MAX_CAPA_QTY 	-- STORAGE MAX" ).append("\n"); 
		query.append(",STO_MIN_CAPA_QTY 	-- STORAGE MIN" ).append("\n"); 
		query.append(",STO_FREE_QTY     	-- STORAGE FREE" ).append("\n"); 
		query.append(",WKY_MAX_HNDL_QTY 	-- WEEKLY INFLOW MAX VOL" ).append("\n"); 
		query.append(",WKY_MIN_HNDL_QTY 	-- WEEKLY INFLOW MIN VOL" ).append("\n"); 
		query.append(",TS_DIV_FLG       	-- TS" ).append("\n"); 
		query.append(",STV_20FT_COST_AMT" ).append("\n"); 
		query.append(",STV_40FT_COST_AMT" ).append("\n"); 
		query.append(",STV_45FT_COST_AMT" ).append("\n"); 
		query.append(",STO_20FT_COST_AMT" ).append("\n"); 
		query.append(",STO_40FT_COST_AMT" ).append("\n"); 
		query.append(",STO_45FT_COST_AMT" ).append("\n"); 
		query.append(",HNDL_20FT_COST_AMT" ).append("\n"); 
		query.append(",HNDL_40FT_COST_AMT" ).append("\n"); 
		query.append(",HNDL_45FT_COST_AMT" ).append("\n"); 
		query.append(",STTL_20FT_COST_AMT" ).append("\n"); 
		query.append(",STTL_40FT_COST_AMT" ).append("\n"); 
		query.append(",STTL_45FT_COST_AMT" ).append("\n"); 
		query.append(",EXPT_FM_YRWK        	-- EXCEPTION FROM WEEK" ).append("\n"); 
		query.append(",EXPT_TO_YRWK        	-- EXCEPTION TO WEEK" ).append("\n"); 
		query.append(",EXPT_STO_QTY      	-- EXCEPTION STORAGE" ).append("\n"); 
		query.append(",EXPT_WKY_HNDL_QTY    -- EXCEPTION WEEKLY HANDLING" ).append("\n"); 
		query.append(",SCNR_ID              -- HIDDEN" ).append("\n"); 
		query.append("FROM EQR_SCNR_ECC" ).append("\n"); 
		query.append("WHERE SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("#if (${status} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${status} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${status} == 'E')" ).append("\n"); 
		query.append("AND ECC_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.eqr.scenariomanage.eccinfomanage.integration").append("\n"); 
		query.append("FileName : EccInfoManageDBDAOSearchEccInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}