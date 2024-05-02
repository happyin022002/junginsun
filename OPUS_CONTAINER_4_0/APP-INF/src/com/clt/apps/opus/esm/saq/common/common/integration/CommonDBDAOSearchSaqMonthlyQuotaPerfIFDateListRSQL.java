/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchSaqMonthlyQuotaPerfIFDateListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchSaqMonthlyQuotaPerfIFDateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 월간 판매목표 조정 단계에서 Perfomance Data 의 IF 날짜를 조회 
	  * </pre>
	  */
	public CommonDBDAOSearchSaqMonthlyQuotaPerfIFDateListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofcCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqMonthlyQuotaPerfIFDateListRSQL").append("\n"); 
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
		query.append("SELECT																" ).append("\n"); 
		query.append("    TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('GMT', TO_DATE(SAQ_PPT_CTNT,'YYYYMMDDHH24MISS') , @[ofcCd] ),'yyyy/mm/dd hh24:mi') CODE,	" ).append("\n"); 
		query.append("    TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('GMT', TO_DATE(SAQ_PPT_CTNT,'YYYYMMDDHH24MISS') , @[ofcCd] ),'yyyy/mm/dd hh24:mi') TEXT	" ).append("\n"); 
		query.append("FROM																" ).append("\n"); 
		query.append("    SAQ_COM_PPT    														" ).append("\n"); 
		query.append("WHERE    															" ).append("\n"); 
		query.append("    SAQ_PPT_CD = '00001'	" ).append("\n"); 

	}
}