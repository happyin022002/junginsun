/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOsearchAmsAiDecisionInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
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
		query.append("SELECT AI_DEC_INFO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("      SELECT TO_CHAR(B.MF_SND_DT, 'YYYYMMDD') || ',' || USA_CSTMS_FILE_CD || ','|| CND_CSTMS_FILE_CD ||',@' AI_DEC_INFO" ).append("\n"); 
		query.append("      FROM BKG_BOOKING A, BKG_CSTMS_ADV_BL B" ).append("\n"); 
		query.append("      WHERE B.CNT_CD = 'US'" ).append("\n"); 
		query.append("      AND A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("      and A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      UNION ALL " ).append("\n"); 
		query.append("      SELECT EUR.MSG_SND_NO || ',' || '1' || ',' || ''  || ',@' AI_DEC_INFO" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BKG, BKG_CSTMS_EUR_BL EUR" ).append("\n"); 
		query.append("      WHERE BKG.BL_NO = EUR.BL_NO" ).append("\n"); 
		query.append("      AND BKG.BL_NO = @[bkg_no]" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHERE ROWNUM=1" ).append("\n"); 

	}
}