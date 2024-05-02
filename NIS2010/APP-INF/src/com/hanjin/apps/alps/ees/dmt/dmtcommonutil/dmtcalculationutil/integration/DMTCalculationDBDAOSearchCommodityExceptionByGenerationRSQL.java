/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchCommodityExceptionByGenerationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.14 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchCommodityExceptionByGenerationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCommodityExceptionByGeneration
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchCommodityExceptionByGenerationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("efft_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtt_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtn_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchCommodityExceptionByGenerationRSQL").append("\n"); 
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
		query.append("SELECT 		A.CMDT_TRF_SEQ 		DCR_SEQ" ).append("\n"); 
		query.append(",A.XCLD_SAT_FLG 	EXCL_SAT" ).append("\n"); 
		query.append(",A.XCLD_SUN_FLG 	EXCL_SUN" ).append("\n"); 
		query.append(",A.XCLD_HOL_FLG 	EXCL_HOLI" ).append("\n"); 
		query.append(",A.CMDT_ADD_DYS 	ADD_DAY" ).append("\n"); 
		query.append(",A.CMDT_TTL_DYS 	TTL_DAY" ).append("\n"); 
		query.append("FROM	DMT_CMDT_GRP	A," ).append("\n"); 
		query.append("DMT_TRF_RGN		B" ).append("\n"); 
		query.append("WHERE	A.SYS_AREA_GRP_ID   =   B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND		A.DMDT_TRF_CD		=	B.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND		A.TRF_SEQ			=	B.TRF_SEQ" ).append("\n"); 
		query.append("AND		A.SYS_AREA_GRP_ID	=	@[svr_id]" ).append("\n"); 
		query.append("AND		A.DMDT_TRF_CD		=	@[dtt_code]" ).append("\n"); 
		query.append("AND		A.TRF_SEQ			=	@[dtn_seq]" ).append("\n"); 
		query.append("AND		A.CMDT_CD			=	@[cmdt_cd]" ).append("\n"); 
		query.append("AND		A.DELT_FLG			=	'N'" ).append("\n"); 
		query.append("AND		B.CFM_FLG			=	'Y'" ).append("\n"); 
		query.append("AND 	B.SUTH_CHN_USE_FLG 	= 	'N'" ).append("\n"); 
		query.append("AND		(" ).append("\n"); 
		query.append("( A.EFF_DT <= TO_DATE(@[efft_dt], 'YYYYMMDD') AND A.EXP_DT IS NULL )" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("( A.EFF_DT <= TO_DATE(@[efft_dt], 'YYYYMMDD') AND A.EXP_DT >= TO_DATE(@[efft_dt], 'YYYYMMDD') )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}