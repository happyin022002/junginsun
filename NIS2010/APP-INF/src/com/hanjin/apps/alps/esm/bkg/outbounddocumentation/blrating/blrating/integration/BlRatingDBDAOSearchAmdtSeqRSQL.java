/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BlRatingDBDAOSearchAmdtSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.25 
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

public class BlRatingDBDAOSearchAmdtSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Freight & Charge 화면(ESM_BKG_0079_08)화면에서 SC No. or RFA No. or TAA No.옆 검색 버튼을 누를 때 팝업을 연결하기 위한 필수조건인 Amend Sequend를 조회한다
	  * </pre>
	  */
	public BlRatingDBDAOSearchAmdtSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("application_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchAmdtSeqRSQL").append("\n"); 
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
		query.append("-- BlRatingDBDAOSearchAmdtSeqRSQL.Query" ).append("\n"); 
		query.append("#if( ${ctrt_type} == 'sc' )" ).append("\n"); 
		query.append("SELECT AMDT_SEQ" ).append("\n"); 
		query.append("  FROM PRI_SP_MN" ).append("\n"); 
		query.append(" WHERE PROP_NO = (SELECT PROP_NO " ).append("\n"); 
		query.append("                    FROM PRI_SP_HDR" ).append("\n"); 
		query.append("                   WHERE SC_NO = @[ctrt_no])" ).append("\n"); 
		query.append("   AND TO_DATE(@[application_date],'YYYYMMDD') BETWEEN EFF_DT AND NVL(EXP_DT,TO_DATE('99991231','YYYYMMDD'))" ).append("\n"); 
		query.append("   AND PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("#elseif( ${ctrt_type} == 'rfa')" ).append("\n"); 
		query.append("SELECT AMDT_SEQ" ).append("\n"); 
		query.append("  FROM PRI_RP_MN" ).append("\n"); 
		query.append(" WHERE PROP_NO = (SELECT PROP_NO " ).append("\n"); 
		query.append("                    FROM PRI_RP_HDR" ).append("\n"); 
		query.append("                   WHERE RFA_NO = @[ctrt_no])" ).append("\n"); 
		query.append("   AND TO_DATE(@[application_date],'YYYYMMDD') BETWEEN EFF_DT AND NVL(EXP_DT,TO_DATE('99991231','YYYYMMDD'))" ).append("\n"); 
		query.append("   AND PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("#elseif( ${ctrt_type} == 'taa')" ).append("\n"); 
		query.append("SELECT AMDT_SEQ" ).append("\n"); 
		query.append("  FROM PRI_TAA_MN" ).append("\n"); 
		query.append(" WHERE TAA_PROP_NO = (SELECT TAA_PROP_NO " ).append("\n"); 
		query.append("                        FROM PRI_TAA_HDR" ).append("\n"); 
		query.append("                       WHERE TAA_NO = @[ctrt_no])" ).append("\n"); 
		query.append("   AND TO_DATE(@[application_date],'YYYYMMDD') BETWEEN EFF_DT AND NVL(EXP_DT,TO_DATE('99991231','YYYYMMDD'))" ).append("\n"); 
		query.append("   AND CFM_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}