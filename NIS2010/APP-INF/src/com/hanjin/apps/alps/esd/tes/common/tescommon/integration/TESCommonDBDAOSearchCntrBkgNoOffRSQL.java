/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TESCommonDBDAOSearchCntrBkgNoOffRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.21
*@LastModifier : 윤태승
*@LastVersion : 1.0
* 2011.11.21 윤태승
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yuntaeseung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOSearchCntrBkgNoOffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2011.08.08 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완
	  * * 2011.11.21 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완
	  * </pre>
	  */
	public TESCommonDBDAOSearchCntrBkgNoOffRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOSearchCntrBkgNoOffRSQL").append("\n"); 
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
		query.append("SELECT NVL(" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN NVL(COUNT(C.CNTR_NO) OVER (), 0) > 0" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("|| '|' || C.CNTR_TPSZ_CD || '|' ||" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN NVL(COUNT(C.CNTR_NO) OVER (), 0) > 0" ).append("\n"); 
		query.append("THEN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.BKG_NO IS NOT NULL THEN X.BKG_NO" ).append("\n"); 
		query.append("WHEN Y.BKG_NO IS NOT NULL THEN Y.BKG_NO" ).append("\n"); 
		query.append("WHEN C.BKG_NO IS NOT NULL THEN C.BKG_NO" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END BKG_NO" ).append("\n"); 
		query.append("FROM MST_CONTAINER C," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISTINCT M.BKG_NO, M.CNTR_NO" ).append("\n"); 
		query.append("FROM   CTM_MOVEMENT M, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE  M.CNTR_NO   = @[cntr_no]" ).append("\n"); 
		query.append("AND    M.ORG_YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND    CNMV_EVNT_DT BETWEEN TO_DATE(REPLACE(@[fm_prd_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("AND    B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("AND    M.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND    NVL(M.MVMT_CRE_TP_CD,'N') <> 'C'" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 
		query.append(") X," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  DISTINCT B.BKG_NO, C.CNTR_NO" ).append("\n"); 
		query.append("FROM	BKG_BOOKING B, BKG_CONTAINER C" ).append("\n"); 
		query.append("WHERE	B.BKG_NO   = C.BKG_NO" ).append("\n"); 
		query.append("AND		C.CNTR_NO  = NVL(@[cntr_no],'')" ).append("\n"); 
		query.append("AND		B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("AND     C.CRE_DT BETWEEN TO_DATE(REPLACE(@[fm_prd_dt],'-',''),'YYYYMMDD') - 7 AND TO_DATE(REPLACE(@[to_prd_dt],'-',''),'YYYYMMDD') + 7" ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND C.CNTR_NO = X.CNTR_NO(+)" ).append("\n"); 
		query.append("AND C.CNTR_NO = Y.CNTR_NO(+)" ).append("\n"); 
		query.append("AND C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END CNTR_CHK" ).append("\n"); 
		query.append("FROM MST_CONTAINER C" ).append("\n"); 
		query.append("WHERE C.CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(",'N') CNTR_CHK FROM DUAL" ).append("\n"); 

	}
}