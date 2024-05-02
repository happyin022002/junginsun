/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VslResidualSpaceManageDBDAOSearchBSInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.11.06 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VslResidualSpaceManageDBDAOSearchBSInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_BSA_VVD + EQR_SCNR_BSA_PORT 테이블에서 scnr bsa 정보 조회
	  * </pre>
	  */
	public VslResidualSpaceManageDBDAOSearchBSInfoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toPln",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toToPln",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmPln",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmToPln",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.integration").append("\n"); 
		query.append("FileName : VslResidualSpaceManageDBDAOSearchBSInfoRSQL").append("\n"); 
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
		query.append("A.FM_YRWK FROM_YEAR_WEEK ," ).append("\n"); 
		query.append("A.TO_YRWK TO_YEAR_WEEK ," ).append("\n"); 
		query.append("A.CO_CD  COMPANY_CODE ," ).append("\n"); 
		query.append("A.TRD_CD TRADE_CODE ," ).append("\n"); 
		query.append("-- 	    A.SUB_TRD_CD," ).append("\n"); 
		query.append("A.VSL_LANE_CD VESSL_LANE_CODE," ).append("\n"); 
		query.append("A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD  VVD," ).append("\n"); 
		query.append("A.VSL_SPC ," ).append("\n"); 
		query.append("A.VSL_WGT," ).append("\n"); 
		query.append("A.VSL_BSA_RF_SUB_SPC ," ).append("\n"); 
		query.append("A.VSL_BSA_DRY_SUB_SPC ," ).append("\n"); 
		query.append("A.SCNR_ID," ).append("\n"); 
		query.append("A.VSL_CD," ).append("\n"); 
		query.append("A.SKD_VOY_NO," ).append("\n"); 
		query.append("A.SKD_DIR_CD," ).append("\n"); 
		query.append("A.VSL_BSA_USD_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_BSA_VVD A ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("a.FM_YRWK" ).append("\n"); 
		query.append(", a.TO_YRWK" ).append("\n"); 
		query.append(", A.VVD" ).append("\n"); 
		query.append(", A.SCNR_ID" ).append("\n"); 
		query.append(", A.CO_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FM_YRWK," ).append("\n"); 
		query.append("TO_YRWK," ).append("\n"); 
		query.append("VSL_CD||SKD_VOY_NO||SKD_DIR_CD  VVD," ).append("\n"); 
		query.append("SCNR_ID," ).append("\n"); 
		query.append("CO_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_BSA_PORT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCNR_ID = @[scnrId]" ).append("\n"); 
		query.append("AND FM_YRWK BETWEEN @[fmPln]  AND @[toPln]" ).append("\n"); 
		query.append("#if(${fmEccCd} != '')" ).append("\n"); 
		query.append("AND VSL_PORT_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${arrFmEccCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrFmEccCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vvd} != '')" ).append("\n"); 
		query.append("AND VSL_CD||SKD_VOY_NO||SKD_DIR_CD IN(" ).append("\n"); 
		query.append("#foreach($key IN ${arrvvd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrvvd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cntrTpszCd} != '')" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD  IN(" ).append("\n"); 
		query.append("#foreach($key IN ${arrCntrTpszCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrCntrTpszCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("FM_YRWK" ).append("\n"); 
		query.append(",TO_YRWK" ).append("\n"); 
		query.append(",VSL_CD||SKD_VOY_NO||SKD_DIR_CD" ).append("\n"); 
		query.append(", SCNR_ID" ).append("\n"); 
		query.append(", CO_CD" ).append("\n"); 
		query.append(") a ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FM_YRWK," ).append("\n"); 
		query.append("TO_YRWK," ).append("\n"); 
		query.append("VSL_CD||SKD_VOY_NO||SKD_DIR_CD  VVD," ).append("\n"); 
		query.append("SCNR_ID," ).append("\n"); 
		query.append("CO_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_BSA_PORT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCNR_ID = @[scnrId]" ).append("\n"); 
		query.append("AND TO_YRWK BETWEEN @[fmToPln]  AND @[toToPln]" ).append("\n"); 
		query.append("#if(${toEccCd} != '')" ).append("\n"); 
		query.append("AND VSL_PORT_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${arrToEccCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrToEccCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vvd} != '')" ).append("\n"); 
		query.append("AND VSL_CD||SKD_VOY_NO||SKD_DIR_CD IN(" ).append("\n"); 
		query.append("#foreach($key IN ${arrvvd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrvvd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("FM_YRWK" ).append("\n"); 
		query.append(",TO_YRWK" ).append("\n"); 
		query.append(",VSL_CD||SKD_VOY_NO||SKD_DIR_CD" ).append("\n"); 
		query.append(", SCNR_ID" ).append("\n"); 
		query.append(", CO_CD" ).append("\n"); 
		query.append(") b" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.SCNR_ID = B.SCNR_ID" ).append("\n"); 
		query.append("AND     A.VVD = B.VVD" ).append("\n"); 
		query.append("AND     A.CO_CD = B.CO_CD" ).append("\n"); 
		query.append("AND     A.FM_YRWK = B.FM_YRWK" ).append("\n"); 
		query.append("AND     A.TO_YRWK = B.TO_YRWK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.SCNR_ID = B.SCNR_ID" ).append("\n"); 
		query.append("AND A.FM_YRWK = B.FM_YRWK" ).append("\n"); 
		query.append("AND A.TO_YRWK = B.TO_YRWK" ).append("\n"); 
		query.append("AND A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD =B.VVD" ).append("\n"); 
		query.append("AND A.CO_CD = B.CO_CD" ).append("\n"); 
		query.append("#if(${lane} != '')" ).append("\n"); 
		query.append("AND A.VSL_LANE_CD IN(" ).append("\n"); 
		query.append("#foreach($key IN ${arrlane})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlane.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}