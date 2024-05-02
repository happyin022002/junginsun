/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ScenarioManageDBDAOSearchVesselScheduleInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioManageDBDAOSearchVesselScheduleInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_scnr_vsl_skd 테이블의 데이터 조회(port 정보 미포함)
	  * 
	  * Change History
	  * 1. 2013.01.16  CSR : CHM-201322501, 주차검색조건 제거, 신용찬         
	  * </pre>
	  */
	public ScenarioManageDBDAOSearchVesselScheduleInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.integration").append("\n"); 
		query.append("FileName : ScenarioManageDBDAOSearchVesselScheduleInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	DISTINCT(" ).append("\n"); 
		query.append("    CASE WHEN b.skd_usd_ind_cd IN('B','H') THEN 'SML'" ).append("\n"); 
		query.append("	ELSE " ).append("\n"); 
		query.append("         CASE WHEN b.skd_usd_ind_cd IN('B','D') THEN 'SEN'" ).append("\n"); 
		query.append("		                                        ELSE 'SML'" ).append("\n"); 
		query.append("		 END		" ).append("\n"); 
		query.append("    END ) company -- Company 구분 제거로 인해 조건별 표기함 ( 09.08.05 ) By ChungEunHo" ).append("\n"); 
		query.append("    , A.VSL_SLAN_CD" ).append("\n"); 
		query.append("    , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("    , A.SCNR_ID" ).append("\n"); 
		query.append("    , A.VSL_CD" ).append("\n"); 
		query.append("    , A.SKD_VOY_NO" ).append("\n"); 
		query.append("    , A.SKD_DIR_CD" ).append("\n"); 
		query.append("    , SKD_USD_IND_CD              " ).append("\n"); 
		query.append("FROM EQR_SCNR_VSL_SKD A" ).append("\n"); 
		query.append("    ,VSK_VSL_SKD B                                            " ).append("\n"); 
		query.append("WHERE A.VSL_CD      = B.VSL_CD                                                     " ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO  = B.SKD_VOY_NO                                                 " ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD  = B.SKD_DIR_CD  " ).append("\n"); 
		query.append("	## 불필요한 조인조건 제거" ).append("\n"); 
		query.append("	## ITM-200900128" ).append("\n"); 
		query.append("	## MODIFIED BY SHIN YONGCHAN - 20091009                                               " ).append("\n"); 
		query.append("    ##AND a.vsl_slan_cd = b.vsl_slan_cd    " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	##AND b.skd_usd_ind_cd IN ('B','H','D') -- Company 구분 제거로 인해 조건별 표기함 ( 09.08.05 ) By ChungEunHo                                              " ).append("\n"); 
		query.append("AND A.SCNR_ID = @[scnrId]    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- CSR : CHM-201322501, 주차검색조건 제거, 신용찬                                                            " ).append("\n"); 
		query.append("--AND TO_CHAR (A.VSL_ETB_DT, 'YYYYMMDD') BETWEEN (SELECT WK_ST_DT  FROM EQR_WK_PRD WHERE PLN_YR||PLN_WK = etbSYrWk )          " ).append("\n"); 
		query.append("--                                       AND (SELECT WK_END_DT FROM EQR_WK_PRD WHERE PLN_YR||PLN_WK = etbEYrWk )          " ).append("\n"); 
		query.append("#if(${vslSlanCd} != '' )" ).append("\n"); 
		query.append("AND A.VSL_SLAN_CD IN" ).append("\n"); 
		query.append("   (" ).append("\n"); 
		query.append("		#foreach($key IN ${arrVslSlanCd}) " ).append("\n"); 
		query.append("			#if($velocityCount < $arrVslSlanCd.size()) " ).append("\n"); 
		query.append("				'$key', " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("				'$key' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vvd} != '')" ).append("\n"); 
		query.append("AND A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD IN" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("		#foreach($key IN ${arrVvd}) " ).append("\n"); 
		query.append("			#if($velocityCount < $arrVvd.size()) " ).append("\n"); 
		query.append("				'$key', " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("				'$key' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}