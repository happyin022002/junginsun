/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateProposalDBDAORsltFicRateByRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.11
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.10.11 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORsltFicRateByRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  FIC Rate값을 Route 정보를 이용해  조회한다.
	  * </pre>
	  */
	public RFARateProposalDBDAORsltFicRateByRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_out_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltFicRateByRouteRSQL").append("\n"); 
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
		query.append("SELECT  REGEXP_SUBSTR( FIC_RATE_RESULT, '[^|]+', 1, 1)  AS FIC_RT_USE_STS_CD" ).append("\n"); 
		query.append("	,REGEXP_SUBSTR( FIC_RATE_RESULT, '[^|]+', 1, 2) AS OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append("	,TRIM(REGEXP_SUBSTR( FIC_RATE_RESULT, '[^|]+', 1, 3)) AS DR_20FT_AMT" ).append("\n"); 
		query.append("	,TRIM(REGEXP_SUBSTR( FIC_RATE_RESULT, '[^|]+', 1, 4)) AS RF_20FT_AMT" ).append("\n"); 
		query.append("	,TRIM(REGEXP_SUBSTR( FIC_RATE_RESULT, '[^|]+', 1, 5)) AS DG_20FT_AMT" ).append("\n"); 
		query.append("	,TRIM(REGEXP_SUBSTR( FIC_RATE_RESULT, '[^|]+', 1, 6)) AS DR_40FT_AMT" ).append("\n"); 
		query.append("	,TRIM(REGEXP_SUBSTR( FIC_RATE_RESULT, '[^|]+', 1, 7)) AS RF_40FT_AMT" ).append("\n"); 
		query.append("	,TRIM(REGEXP_SUBSTR( FIC_RATE_RESULT, '[^|]+', 1, 8)) AS DG_40FT_AMT" ).append("\n"); 
		query.append("	,REGEXP_SUBSTR( FIC_RATE_RESULT, '[^|]+', 1, 9) AS LOCL_CURR_CD" ).append("\n"); 
		query.append("	,TRIM(REGEXP_SUBSTR( FIC_RATE_RESULT, '[^|]+', 1, 10)) AS DR_LOCL_20FT_AMT" ).append("\n"); 
		query.append("	,TRIM(REGEXP_SUBSTR( FIC_RATE_RESULT, '[^|]+', 1, 11)) AS RF_LOCL_20FT_AMT" ).append("\n"); 
		query.append("	,TRIM(REGEXP_SUBSTR( FIC_RATE_RESULT, '[^|]+', 1, 12)) AS DG_LOCL_20FT_AMT" ).append("\n"); 
		query.append("	,TRIM(REGEXP_SUBSTR( FIC_RATE_RESULT, '[^|]+', 1, 13)) AS DR_LOCL_40FT_AMT" ).append("\n"); 
		query.append("	,TRIM(REGEXP_SUBSTR( FIC_RATE_RESULT, '[^|]+', 1, 14)) AS RF_LOCL_40FT_AMT" ).append("\n"); 
		query.append("	,TRIM(REGEXP_SUBSTR( FIC_RATE_RESULT, '[^|]+', 1, 15)) AS DG_LOCL_40FT_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT ((" ).append("\n"); 
		query.append("				SELECT " ).append("\n"); 
		query.append("#if (${add_on_flag} == 'Y' )" ).append("\n"); 
		query.append("	PRI_ADDON_RATE_CALCULATE_PKG.PRI_getFICRateByRoute_FNC(@[prop_no],@[amdt_seq], @[svc_scp_cd], @[in_out_bound],@[cmdt_hdr_seq],@[rout_seq]) AS  FIC_RATE_RESULT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	PRI_FIC_RATE_CALCULATE_PKG.PRI_getFICRateByRoute_FNC(@[prop_no],@[amdt_seq], @[svc_scp_cd], @[cmdt_hdr_seq],@[rout_seq]) AS  FIC_RATE_RESULT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				FROM DUAL" ).append("\n"); 
		query.append("            )) AS FIC_RATE_RESULT" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}