/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BlRatingDBDAOSearchRateCheckNoticeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchRateCheckNoticeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate Check Notice 전송대상 판별을 위한 값과, 메일 전송시 사용할 제목, 본문 내용을 조회한다.
	  * </pre>
	  */
	public BlRatingDBDAOSearchRateCheckNoticeRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchRateCheckNoticeRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN 'Y' = (SELECT 'Y' " ).append("\n"); 
		query.append("                        FROM BKG_BOOKING " ).append("\n"); 
		query.append("                        WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                        AND NON_RT_STS_CD IS NULL) " ).append("\n"); 
		query.append("                 THEN ''  -- BKG 최초 접수시에는 메일을 전송하지 않음." ).append("\n"); 
		query.append("            ELSE OFT_MSS_FLG" ).append("\n"); 
		query.append("       END  OFT_MSS_FLG," ).append("\n"); 
		query.append("       (SELECT SUBSTR(MAX(SYS_CONNECT_BY_PATH(SREP_EML, ';')), 2) " ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT SREP_EML," ).append("\n"); 
		query.append("                       ROW_NUMBER() OVER (PARTITION BY 1 ORDER BY SREP_EML) RNUM" ).append("\n"); 
		query.append("                FROM (  SELECT SREP_EML" ).append("\n"); 
		query.append("                        FROM BKG_BOOKING B, MDM_SLS_REP M" ).append("\n"); 
		query.append("                        WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                        AND B.OB_SREP_CD = M.SREP_CD" ).append("\n"); 
		query.append("                        UNION " ).append("\n"); 
		query.append("                        SELECT SREP_EML" ).append("\n"); 
		query.append("                        FROM BKG_BOOKING B, MDM_SLS_REP M" ).append("\n"); 
		query.append("                        WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                        AND B.CTRT_SREP_CD = M.SREP_CD" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("        START WITH RNUM = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR RNUM = RNUM -1) SREP_EML," ).append("\n"); 
		query.append("       'Rate Check Notice (Booking No. '||BKG_NO||')' TITLE," ).append("\n"); 
		query.append("       'Dear Sales representative,<br><br>'||" ).append("\n"); 
		query.append("       'Please be informed that your booking(s) below does not have an applicable rate. <br>'||" ).append("\n"); 
		query.append("       'Pleaes make a RATE as soon as possible.<br>'||" ).append("\n"); 
		query.append("       '- Booking No. '||BKG_NO||'<br><br>'||" ).append("\n"); 
		query.append("       'SM Line Corporation' BODY," ).append("\n"); 
		query.append("--------------------------------------------" ).append("\n"); 
		query.append("       '' BKG_NO" ).append("\n"); 
		query.append("FROM BKG_RATE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}