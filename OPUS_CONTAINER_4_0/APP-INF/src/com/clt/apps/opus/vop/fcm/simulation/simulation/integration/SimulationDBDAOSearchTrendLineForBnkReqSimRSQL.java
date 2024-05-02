/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SimulationDBDAOSearchTrendLineForBnkReqSimRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.simulation.simulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SimulationDBDAOSearchTrendLineForBnkReqSimRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search trend line to simulate bunker request.
	  * 2014.04.16 [CHM-201429874] Standard FOC 생성 및 단계별 저장 기능 개발 - 조회 컬럼 추가 및 Where 수정
	  * 2014.05.28 [CHM-201430380] Standard FOC 칼럼 추가 및 조회 로직 수정
	  * </pre>
	  */
	public SimulationDBDAOSearchTrendLineForBnkReqSimRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.fcm.simulation.simulation.integration").append("\n"); 
		query.append("FileName : SimulationDBDAOSearchTrendLineForBnkReqSimRSQL").append("\n"); 
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
		query.append("SELECT T1.TRND_LINE_SEQ" ).append("\n"); 
		query.append("      ,T1.TRND_LINE_TP_CD" ).append("\n"); 
		query.append("      ,T1.N1ST_COEF_VAL" ).append("\n"); 
		query.append("      ,T1.N1ST_VAR_DGR_VAL" ).append("\n"); 
		query.append("      ,T1.N2ND_COEF_VAL" ).append("\n"); 
		query.append("      ,T1.N2ND_VAR_DGR_VAL" ).append("\n"); 
		query.append("      ,T1.TRND_LINE_CONS_VAL" ).append("\n"); 
		query.append("      ,TRND_LINE_USE_TP_CD || '-' || TRND_LINE_TP_CD || '-' || VSL_CLSS_CD || VSL_CLSS_SUB_CD || VSL_SLAN_CD || VSL_CD || SKD_DIR_CD || '-' || TO_CHAR(CRE_DT, 'YYMM') || TRND_LINE_TP_SUB_CD AS TRND_LINE_NO" ).append("\n"); 
		query.append("      ,T1.FOML_DESC" ).append("\n"); 
		query.append("      ,T1.AVG_SLP_RT" ).append("\n"); 
		query.append("      ,T1.AVG_GNR_CSM_WGT" ).append("\n"); 
		query.append("  FROM FCM_TRND_LINE T1 " ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND TRND_LINE_SEQ = ( SELECT MAX(TRND_LINE_SEQ)" ).append("\n"); 
		query.append("                           FROM (" ).append("\n"); 
		query.append("                                   SELECT MAX(TRND_LINE_SEQ) TRND_LINE_SEQ" ).append("\n"); 
		query.append("                                     FROM FCM_TRND_LINE" ).append("\n"); 
		query.append("                                    WHERE 1=1" ).append("\n"); 
		query.append("                                      AND VSL_CD              = @[vsl_cd]" ).append("\n"); 
		query.append("                                      AND TRND_LINE_TP_CD     = '3'" ).append("\n"); 
		query.append("                                      AND TRND_LINE_CHT_TP_CD = '01'" ).append("\n"); 
		query.append("                                      AND SKD_DIR_CD          = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                   UNION ALL" ).append("\n"); 
		query.append("                                   SELECT MAX(TRND_LINE_SEQ) TRND_LINE_SEQ" ).append("\n"); 
		query.append("                                     FROM FCM_TRND_LINE" ).append("\n"); 
		query.append("                                    WHERE 1=1" ).append("\n"); 
		query.append("                                      AND VSL_CD              = @[vsl_cd]" ).append("\n"); 
		query.append("                                      AND TRND_LINE_TP_CD     = '4'" ).append("\n"); 
		query.append("                                      AND TRND_LINE_CHT_TP_CD = '01'" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 

	}
}