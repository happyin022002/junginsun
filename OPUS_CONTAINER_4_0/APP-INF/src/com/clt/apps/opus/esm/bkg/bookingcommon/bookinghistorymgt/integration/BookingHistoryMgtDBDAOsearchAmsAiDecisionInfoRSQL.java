/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOsearchAmsAiDecisionInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.01
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.10.01 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOsearchAmsAiDecisionInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 미세관 AI 전송 FLAG 판단 정보 조회
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOsearchAmsAiDecisionInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOsearchAmsAiDecisionInfoRSQL").append("\n"); 
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
		query.append("SELECT B.MF_SND_DT" ).append("\n"); 
		query.append("      ,DECODE(B.CNT_CD, 'US', USA_CSTMS_FILE_CD, CND_CSTMS_FILE_CD) AS CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("      ,B.CNT_CD" ).append("\n"); 
		query.append("      ,B.MF_NO" ).append("\n"); 
		query.append("      ,B.BL_NO" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_BL B" ).append("\n"); 
		query.append("      ,BKG_BOOKING      A" ).append("\n"); 
		query.append(" WHERE B.CNT_CD IN ('US', 'CA')" ).append("\n"); 
		query.append("   AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND (B.MF_SND_DT IS NOT NULL OR B.AMDT_SND_DT IS NOT NULL)" ).append("\n"); 

	}
}