/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EccLinkInfoManageDBDAOSearchEccLinkInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EccLinkInfoManageDBDAOSearchEccLinkInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_ECC_LNK 테이블 데이터 조회
	  * </pre>
	  */
	public EccLinkInfoManageDBDAOSearchEccLinkInfoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("transit_time",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT FM_ECC_CD" ).append("\n"); 
		query.append(",TO_ECC_CD" ).append("\n"); 
		query.append(",TRSP_MOD_CD" ).append("\n"); 
		query.append(",TZ_DYS" ).append("\n"); 
		query.append(",TZ_20FT_COST_AMT" ).append("\n"); 
		query.append(",TZ_40FT_COST_AMT" ).append("\n"); 
		query.append(",TZ_45FT_COST_AMT" ).append("\n"); 
		query.append(",CNTR_MAX_CAPA_QTY" ).append("\n"); 
		query.append(",CNTR_VOL_UT_CD     -- BOX1" ).append("\n"); 
		query.append(",TRSP_FREQ_KNT" ).append("\n"); 
		query.append(",EXPT_FM_YRWK" ).append("\n"); 
		query.append(",EXPT_TO_YRWK" ).append("\n"); 
		query.append(",EXPT_MAX_CAPA_QTY" ).append("\n"); 
		query.append(",EXPT_VOL_UT_CD     -- BOX2" ).append("\n"); 
		query.append(",SCNR_ID            -- HIDDEN VALUE" ).append("\n"); 
		query.append("FROM EQR_SCNR_ECC_LNK" ).append("\n"); 
		query.append("WHERE SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("#if ($fromEccArr.size() > 0)" ).append("\n"); 
		query.append("AND FM_ECC_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${fromEccArr})" ).append("\n"); 
		query.append("#if($velocityCount < $fromEccArr.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($toEccArr.size() > 0)" ).append("\n"); 
		query.append("AND TO_ECC_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${toEccArr})" ).append("\n"); 
		query.append("#if($velocityCount < $toEccArr.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mode} != '')" ).append("\n"); 
		query.append("AND TRSP_MOD_CD = @[mode]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${transit_time} != '')" ).append("\n"); 
		query.append("AND TZ_DYS >= @[transit_time]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1,2,3" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.eqr.scenariomanage.ecclinkinfomanage.integration").append("\n"); 
		query.append("FileName : EccLinkInfoManageDBDAOSearchEccLinkInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}