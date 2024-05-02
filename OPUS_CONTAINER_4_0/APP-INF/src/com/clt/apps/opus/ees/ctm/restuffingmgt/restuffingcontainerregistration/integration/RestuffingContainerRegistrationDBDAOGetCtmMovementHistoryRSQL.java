/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RestuffingContainerRegistrationDBDAOGetCtmMovementHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RestuffingContainerRegistrationDBDAOGetCtmMovementHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 컨테이너 History정보를 조회한다
	  * </pre>
	  */
	public RestuffingContainerRegistrationDBDAOGetCtmMovementHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration").append("\n"); 
		query.append("FileName : RestuffingContainerRegistrationDBDAOGetCtmMovementHistoryRSQL").append("\n"); 
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
		query.append("#if (${flg} == '1')" ).append("\n"); 
		query.append("       /*+ INDEX_DESC(CTM_MOVEMENT XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       /*+ INDEX (CTM_MOVEMENT XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       CNMV_YR," ).append("\n"); 
		query.append("       CNMV_ID_NO," ).append("\n"); 
		query.append("       CNMV_CYC_NO," ).append("\n"); 
		query.append("       CNMV_SEQ," ).append("\n"); 
		query.append("       CNMV_SPLIT_NO," ).append("\n"); 
		query.append("       CNTR_NO," ).append("\n"); 
		query.append("       ORG_YD_CD," ).append("\n"); 
		query.append("       REPLACE (CNTR_SEAL_NO, CHR (13)||CHR (10), '') AS CNTR_SEAL_NO," ).append("\n"); 
		query.append("       CHSS_NO," ).append("\n"); 
		query.append("       MVMT_STS_CD," ).append("\n"); 
		query.append("       TRNK_VSL_CD," ).append("\n"); 
		query.append("       TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("       TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("       VNDR_SEQ," ).append("\n"); 
		query.append("       TRNK_VSL_CD||TRNK_SKD_VOY_NO||TRNK_SKD_DIR_CD VVD_CD," ).append("\n"); 
		query.append("       CNMV_EVNT_DT," ).append("\n"); 
		query.append("       '' XCH_RSN_CD," ).append("\n"); 
		query.append("       MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("       BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  FROM CTM_MOVEMENT" ).append("\n"); 
		query.append(" WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#if (${flg} == '1')" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND CNMV_CYC_NO >= ( /* DATA가 없는 경우에도 0을 취하도록 MAX 함수 사용 */" ).append("\n"); 
		query.append("                        SELECT /*+ INDEX_DESC (CTM_MOVEMENT XUK1CTM_MOVEMENT)*/" ).append("\n"); 
		query.append("                               NVL (MAX (CNMV_CYC_NO), 0)" ).append("\n"); 
		query.append("                          FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("                         WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                           AND MVMT_STS_CD = 'VD'" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) -5" ).append("\n"); 
		query.append("   AND ROWNUM <= 100" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}