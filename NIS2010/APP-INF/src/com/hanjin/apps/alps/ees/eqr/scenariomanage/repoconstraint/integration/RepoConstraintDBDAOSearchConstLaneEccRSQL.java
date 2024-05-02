/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoConstraintDBDAOSearchConstLaneEccRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepoConstraintDBDAOSearchConstLaneEccRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * <EES_EQR_0138 Constraint by Lane/ECC>
	  * EQR_SCNR_PORT_DCHG_CNST  테이블 데이터 조회
	  * 
	  * <Change History>
	  * 1	2009.08.12	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public RepoConstraintDBDAOSearchConstLaneEccRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnrId",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.integration").append("\n"); 
		query.append("FileName : RepoConstraintDBDAOSearchConstLaneEccRSQL").append("\n"); 
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
		query.append("VSL_LANE_CD LANE" ).append("\n"); 
		query.append(",VSL_LOC_CD POD" ).append("\n"); 
		query.append("#foreach( $key in ${arrCntrTpszCd})" ).append("\n"); 
		query.append(",MAX(DECODE(CNST_CNTR_TPSZ_CD, '$key',CNTR_VOL_QTY ))   ${key}_QTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",SCNR_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("VSL_LANE_CD" ).append("\n"); 
		query.append(",VSL_LOC_CD" ).append("\n"); 
		query.append(",A.CNST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",A.CNTR_VOL_QTY" ).append("\n"); 
		query.append(",A.SCNR_ID" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER (PARTITION BY SCNR_ID, VSL_LANE_CD,VSL_LOC_CD ,CNST_CNTR_TPSZ_CD ORDER BY ROWNUM) RUMM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_PORT_DCHG_CNST A" ).append("\n"); 
		query.append(", (SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${loc} != '' && $arrFmEccCd.size() > 0)" ).append("\n"); 
		query.append("#if (${loc} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD" ).append("\n"); 
		query.append("#elseif (${loc} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrFmEccCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrFmEccCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")) C" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.VSL_LOC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND SCNR_ID = @[scnrId]" ).append("\n"); 
		query.append("#if (${lane} != '' && $arrLane.size() > 0)" ).append("\n"); 
		query.append("AND A.VSL_LANE_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrLane})" ).append("\n"); 
		query.append("#if($velocityCount < $arrLane.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY SCNR_ID, VSL_LANE_CD , VSL_LOC_CD" ).append("\n"); 
		query.append("ORDER BY SCNR_ID, VSL_LANE_CD , VSL_LOC_CD   ASC" ).append("\n"); 

	}
}