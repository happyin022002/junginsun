/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MgsetMovementHistoryDBDAOsearchCtmMvmtSourceDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MgsetMovementHistoryDBDAOsearchCtmMvmtSourceDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MgsetMovementHistoryDBDAOsearchCtmMvmtSourceDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration").append("\n"); 
		query.append("FileName : MgsetMovementHistoryDBDAOsearchCtmMvmtSourceDataRSQL").append("\n"); 
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
		query.append("CNTR_NO,CNMV_YR,CNMV_ID_NO,MVMT_STS_CD,CNMV_EVNT_DT,DEST_YD_CD,ORG_YD_CD,CHSS_NO,MGST_NO,CRE_DT,UPD_DT,BKG_NO,UPD_USR_ID,IBFLAG,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append(" CNTR_NO" ).append("\n"); 
		query.append(",CNMV_YR" ).append("\n"); 
		query.append(",CNMV_ID_NO" ).append("\n"); 
		query.append(",MVMT_STS_CD" ).append("\n"); 
		query.append(",TO_CHAR(CNMV_EVNT_DT,'YYYYMMDDHH24MISS') CNMV_EVNT_DT" ).append("\n"); 
		query.append(",DEST_YD_CD" ).append("\n"); 
		query.append(",ORG_YD_CD" ).append("\n"); 
		query.append(",CHSS_NO" ).append("\n"); 
		query.append(",MGST_NO" ).append("\n"); 
		query.append(",TO_CHAR(CRE_DT,'YYYYMMDDHH24MISS') CRE_DT" ).append("\n"); 
		query.append(",TO_CHAR(UPD_DT,'YYYYMMDDHH24MISS') UPD_DT" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",CASE WHEN A.CRE_DT =  A.UPD_DT THEN 'I'" ).append("\n"); 
		query.append("      WHEN A.CRE_DT > I.LAST_DT THEN 'I'" ).append("\n"); 
		query.append(" ELSE 'U'" ).append("\n"); 
		query.append(" END IBFLAG" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append("--,'I' IBFLAG " ).append("\n"); 
		query.append(" FROM CTM_MOVEMENT A ,  ( SELECT /*+ INDEX_DESC(L XPKCGM_CNTR_MVMT_EXE_BAT_LOG) */" ).append("\n"); 
		query.append("                                            NVL( MAX(CNMV_EXE_TO_DT ) ,TO_DATE('20100401','YYYYMMDD') ) LAST_DT" ).append("\n"); 
		query.append("                                            FROM CGM_CNTR_MVMT_EXE_BAT_LOG L" ).append("\n"); 
		query.append("                                            WHERE CNMV_EXE_TO_DT IS NOT NULL " ).append("\n"); 
		query.append("                                              AND CRE_USR_ID = 'MGSBATCH' AND  ROWNUM=1) I" ).append("\n"); 
		query.append("WHERE (SYS_AREA_GRP_ID ='USA'" ).append("\n"); 
		query.append(" OR ( SYS_AREA_GRP_ID = 'SWA' AND  ORG_YD_CD ||'' LIKE 'PH%' ) )          -- USA 와 SWA,PH 지역만 조회대상임." ).append("\n"); 
		query.append("AND A.UPD_DT >=    I.LAST_DT                       " ).append("\n"); 
		query.append("--                                    " ).append("\n"); 
		query.append("AND NOT EXISTS ( SELECT /*+ USE_NL(B)  */     -- 건수가 시간당 3000 건 정도가 대략적인 MAX 이므로 NL 조인이 빠름." ).append("\n"); 
		query.append("                 'X' FROM CGM_MGST_MVMT_HIS  B" ).append("\n"); 
		query.append("                 WHERE B.MGST_NO = A.MGST_NO" ).append("\n"); 
		query.append("                   AND B.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                   AND B.MVMT_DT = A.CNMV_EVNT_DT" ).append("\n"); 
		query.append("                   AND B.MVMT_STS_CD = A.MVMT_STS_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--ORDER BY A.SYS_AREA_GRP_ID, A.UPD_DT" ).append("\n"); 
		query.append("--ORDER BY A.SYS_AREA_GRP_ID,A.CNMV_EVNT_DT ,A.CNTR_NO, A.CNMV_YR,A.CNMV_ID_NO" ).append("\n"); 
		query.append("ORDER BY A.UPD_DT, A.CNTR_NO, A.CNMV_EVNT_DT ,A.CNMV_YR, A.CNMV_ID_NO" ).append("\n"); 
		query.append(") WHERE ROWNUM < 10000" ).append("\n"); 

	}
}