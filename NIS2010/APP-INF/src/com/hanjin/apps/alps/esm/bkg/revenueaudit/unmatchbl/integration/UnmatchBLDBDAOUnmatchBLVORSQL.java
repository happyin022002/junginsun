/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UnmatchBLDBDAOUnmatchBLVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.11.24 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOUnmatchBLVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UnmatchBLVO
	  * </pre>
	  */
	public UnmatchBLDBDAOUnmatchBLVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOUnmatchBLVORSQL").append("\n"); 
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
		query.append("NULL AS BL_NO" ).append("\n"); 
		query.append(",NULL AS BKG_NO" ).append("\n"); 
		query.append(",NULL AS BKG_CORR_NO" ).append("\n"); 
		query.append(",NULL AS BKG_ITM_LOG" ).append("\n"); 
		query.append(",NULL AS BKG_STS_CD" ).append("\n"); 
		query.append(",NULL AS CA_FLG" ).append("\n"); 
		query.append(",NULL AS CHG_CD" ).append("\n"); 
		query.append(",NULL AS CORR_NO" ).append("\n"); 
		query.append(",NULL AS CTRT_ITM_LOG" ).append("\n"); 
		query.append(",NULL AS CTRT_TP_CD" ).append("\n"); 
		query.append(",NULL AS CURR_CD" ).append("\n"); 
		query.append(",NULL AS FRT_RT_AMT" ).append("\n"); 
		query.append(",NULL AS INTER_RMK" ).append("\n"); 
		query.append(",NULL AS LST_UMCH_FND_DT" ).append("\n"); 
		query.append(",NULL AS MAX_UMCH_BKG_SEQ" ).append("\n"); 
		query.append(",NULL AS N1ST_UMCH_FND_DT" ).append("\n"); 
		query.append(",NULL AS REV_AUD_STS_CD" ).append("\n"); 
		query.append(",NULL AS REV_AUD_STL_KND_CD" ).append("\n"); 
		query.append(",NULL AS RAT_UT_CD" ).append("\n"); 
		query.append(",NULL AS RAT_UT_QTY" ).append("\n"); 
		query.append(",NULL AS RESULT" ).append("\n"); 
		query.append(",NULL AS REV_AUD_DT" ).append("\n"); 
		query.append(",NULL AS REV_AUD_TP_CD" ).append("\n"); 
		query.append(",NULL AS RGN_GRP_AVC_RMK" ).append("\n"); 
		query.append(",NULL AS STL_BKG_CORR_NO" ).append("\n"); 
		query.append(",NULL AS STL_DT" ).append("\n"); 
		query.append(",NULL AS STL_MNL_DIFF_AMT" ).append("\n"); 
		query.append(",NULL AS STL_SYS_DIFF_AMT" ).append("\n"); 
		query.append(",NULL AS STL_USR_ID" ).append("\n"); 
		query.append(",NULL AS SVC_SCP_CD" ).append("\n"); 
		query.append(",NULL AS UMCH_BKG_CTRT_TP_CD" ).append("\n"); 
		query.append(",NULL AS UMCH_BKG_SEQ" ).append("\n"); 
		query.append(",NULL AS UMCH_ITM_SEQ" ).append("\n"); 
		query.append(",NULL AS UMCH_TP_CD" ).append("\n"); 
		query.append(",NULL AS UMCH_TP_DESC" ).append("\n"); 
		query.append(",NULL AS MTCH_UMCH_TP_CD" ).append("\n"); 
		query.append(",NULL AS MTCH_UMCH_TP_DESC" ).append("\n"); 
		query.append(",NULL AS UMCH_RSN_RMK" ).append("\n"); 
		query.append(",NULL AS CRE_USR_ID" ).append("\n"); 
		query.append(",NULL AS CRE_DT" ).append("\n"); 
		query.append(",NULL AS UPD_USR_ID" ).append("\n"); 
		query.append(",NULL AS UPD_DT" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}