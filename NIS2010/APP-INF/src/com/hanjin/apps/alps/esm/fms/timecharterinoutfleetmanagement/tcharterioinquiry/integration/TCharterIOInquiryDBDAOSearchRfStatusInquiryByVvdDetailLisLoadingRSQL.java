/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInquiryDBDAOSearchRfStatusInquiryByVvdDetailLisLoadingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.02
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.01.02 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInquiryDBDAOSearchRfStatusInquiryByVvdDetailLisLoadingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD로 RF 상태를 상세 조회한다.
	  * Loading값 조회
	  * </pre>
	  */
	public TCharterIOInquiryDBDAOSearchRfStatusInquiryByVvdDetailLisLoadingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.integration").append("\n"); 
		query.append("FileName : TCharterIOInquiryDBDAOSearchRfStatusInquiryByVvdDetailLisLoadingRSQL").append("\n"); 
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
		query.append("        @[port] AS port" ).append("\n"); 
		query.append("		,A.POL AS loadingPort" ).append("\n"); 
		query.append("		,A.POD AS dischargingPort" ).append("\n"); 
		query.append("		,A.OPR_CD AS operator" ).append("\n"); 
		query.append("		,A.ID AS cntrNo" ).append("\n"); 
		query.append("		,'Loading' AS kind" ).append("\n"); 
		query.append("    FROM BAY_PLAN A" ).append("\n"); 
		query.append("    WHERE VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("      AND VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("      AND DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("      AND PORT_CD = @[port]" ).append("\n"); 
		query.append("      AND CALL_IND = '1'" ).append("\n"); 
		query.append("      AND PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("      AND TEMP IS NOT NULL" ).append("\n"); 
		query.append("      AND PORT_CD = POL " ).append("\n"); 

	}
}