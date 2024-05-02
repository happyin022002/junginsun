/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ArrivalNoticeDBDAOSearchBkgArrNtcAntfyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOSearchBkgArrNtcAntfyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_ARR_NTC_ANTFY_SETUP 조회
	  * </pre>
	  */
	public ArrivalNoticeDBDAOSearchBkgArrNtcAntfyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("antfy_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOSearchBkgArrNtcAntfyRSQL").append("\n"); 
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
		query.append("SELECT SC_NO" ).append("\n"); 
		query.append("     , ANTFY_CUST_CD" ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_CNTC_TP_CD,'A1',CNTC_EML)) AS A1_CNTC_EML" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_CNTC_TP_CD,'A1',FAX_NO))   AS A1_FAX_NO" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_CNTC_TP_CD,'A2',CNTC_EML)) AS A2_CNTC_EML" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_CNTC_TP_CD,'A2',FAX_NO))   AS A2_FAX_NO" ).append("\n"); 
		query.append("     , MAX(CRE_USR_ID)  AS CRE_USR_ID" ).append("\n"); 
		query.append("     , MAX(CRE_DT)      AS CRE_DT" ).append("\n"); 
		query.append("     , MAX(UPD_USR_ID)  AS UPD_USR_ID" ).append("\n"); 
		query.append("     , MAX(UPD_DT)      AS UPD_DT" ).append("\n"); 
		query.append("  FROM BKG_ARR_NTC_ANTFY_SETUP" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${sc_no} != '')" ).append("\n"); 
		query.append("   AND SC_NO  = @[sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${antfy_cust_cd} != '')" ).append("\n"); 
		query.append("   AND ANTFY_CUST_CD = @[antfy_cust_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("   AND POD_CD     = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY SC_NO, ANTFY_CUST_CD, POD_CD" ).append("\n"); 
		query.append("ORDER BY SC_NO, ANTFY_CUST_CD, POD_CD" ).append("\n"); 

	}
}