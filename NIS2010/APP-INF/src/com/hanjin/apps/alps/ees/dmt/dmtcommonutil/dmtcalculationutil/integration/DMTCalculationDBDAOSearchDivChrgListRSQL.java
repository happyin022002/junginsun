/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchDivChrgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchDivChrgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDivChrgList
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchDivChrgListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("div_over_day",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntrts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("over_day",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_id",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchDivChrgListRSQL").append("\n"); 
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
		query.append("SELECT  FT_OVR_DYS FT_OVER ," ).append("\n"); 
		query.append("        FT_UND_DYS FT_UNDER," ).append("\n"); 
		query.append("		CASE WHEN @[cntrts] = 'DX' THEN CNTR_45FT_RT_AMT" ).append("\n"); 
		query.append("			-- 'DX' CNTR TYPE에 대한 Rating조건을 CNTR_45FT_RT_AMT로 추가" ).append("\n"); 
		query.append("             WHEN @[cntrts] = 'R8' THEN CNTR_HC_RT_AMT" ).append("\n"); 
		query.append("			 ELSE" ).append("\n"); 
		query.append("        DECODE( SUBSTR(@[cntrts],2,1), 	'2', CNTR_20FT_RT_AMT," ).append("\n"); 
		query.append("                                        '3', CNTR_20FT_RT_AMT," ).append("\n"); 
		query.append("                         				'4', CNTR_40FT_RT_AMT," ).append("\n"); 
		query.append("                         				'5', CNTR_HC_RT_AMT," ).append("\n"); 
		query.append("                         				'7', CNTR_45FT_RT_AMT," ).append("\n"); 
		query.append("                                        -- 1) D8는 RATE AMT를 CNTR_R9_RT_AMT로 유지" ).append("\n"); 
		query.append("										-- 2) R8 에 적용되는 RATE AMT는 R5 RATE AMT와 동일하게 변경" ).append("\n"); 
		query.append("										'8', CNTR_R9_RT_AMT," ).append("\n"); 
		query.append("                                        '9', CNTR_R9_RT_AMT                                    )  END RATE" ).append("\n"); 
		query.append("FROM    DMT_TRF_RT" ).append("\n"); 
		query.append("WHERE   SYS_AREA_GRP_ID = NVL(( SELECT SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("                				FROM COM_SYS_AREA_GRP_ID A" ).append("\n"); 
		query.append("                				WHERE A.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("                				AND A.CNT_CD = SUBSTR(@[fm_mvmt_yd_cd],1,2) ),@[svr_id])" ).append("\n"); 
		query.append("AND     DMDT_TRF_CD     = @[dtt_code]" ).append("\n"); 
		query.append("AND     TRF_SEQ         = @[dtn_seq]" ).append("\n"); 
		query.append("AND     DMDT_DE_TERM_CD = @[dmdt_de_term_cd]  " ).append("\n"); 
		query.append("AND     TRF_GRP_SEQ     = @[grp_id]" ).append("\n"); 
		query.append("AND     FT_OVR_DYS      <=(@[over_day] + NVL(@[div_over_day], 0))" ).append("\n"); 
		query.append("ORDER BY TRF_RT_SEQ" ).append("\n"); 

	}
}