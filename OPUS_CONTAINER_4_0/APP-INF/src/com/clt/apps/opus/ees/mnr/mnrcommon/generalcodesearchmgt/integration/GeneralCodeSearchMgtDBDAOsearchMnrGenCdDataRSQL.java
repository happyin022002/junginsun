/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchMnrGenCdDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchMnrGenCdDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MNR 공통 코드 정보를 조회 한다.
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchMnrGenCdDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("searchkey",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchMnrGenCdDataRSQL").append("\n"); 
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
		query.append("#if (${searchcon} == 'CUSTOM3') " ).append("\n"); 
		query.append("		 A.EQ_KND_CD AS CD_ID" ).append("\n"); 
		query.append("		,A.MNR_CD_DP_DESC AS CD_DESC" ).append("\n"); 
		query.append("#elseif (${searchcon} == 'CUSTOM1' ||  ${searchcon} == 'CUSTOM8' )" ).append("\n"); 
		query.append("         A.MNR_CD_ID AS CD_ID" ).append("\n"); 
		query.append(" 		,A.MNR_CD_DESC AS CD_DESC" ).append("\n"); 
		query.append("#elseif (${searchcon} == 'CUSTOM6'||${searchcon} == 'CUSTOM7')" ).append("\n"); 
		query.append("         A.MNR_CD_ID AS CD_ID" ).append("\n"); 
		query.append(" 		,A.MNR_CD_DP_DESC AS CD_DESC" ).append("\n"); 
		query.append("        ,(SELECT MAX(COST_SHP_SRCH_PATT_NM)" ).append("\n"); 
		query.append("            FROM MNR_GEN_CD" ).append("\n"); 
		query.append("           WHERE PRNT_CD_ID = A.MNR_CD_ID) AS SHEET1_EV_DESC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${searchagmt} == 'A')" ).append("\n"); 
		query.append("         A.MNR_CD_ID AS CD_ID" ).append("\n"); 
		query.append(" 		,A.MNR_CD_ID||'-'||A.MNR_CD_DP_DESC AS CD_DESC		" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("         A.MNR_CD_ID AS CD_ID" ).append("\n"); 
		query.append(" 		,A.MNR_CD_DP_DESC AS CD_DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM MNR_GEN_CD A" ).append("\n"); 
		query.append("#if (${searchcon} == 'COMMON' || ${searchcon} == 'CUSTOM3' ||  ${searchcon} == 'CUSTOM8' ) " ).append("\n"); 
		query.append("	#if (${searchkey} == 'AG')" ).append("\n"); 
		query.append("	WHERE A.PRNT_CD_ID IN ('UG','GG','ZG')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	WHERE A.PRNT_CD_ID = @[searchkey]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${searchcon} == 'CUSTOM1') " ).append("\n"); 
		query.append("	WHERE A.MNR_CD_GRP_NO = @[searchkey]" ).append("\n"); 
		query.append("#elseif (${searchcon} == 'CUSTOM2') " ).append("\n"); 
		query.append("	WHERE A.PRNT_CD_ID||A.EQ_KND_CD = @[searchkey]" ).append("\n"); 
		query.append("#elseif (${searchcon} == 'CUSTOM4')   " ).append("\n"); 
		query.append("	WHERE A.PRNT_CD_ID IN " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("  		SELECT B.MNR_CD_ID" ).append("\n"); 
		query.append("  		FROM MNR_GEN_CD B" ).append("\n"); 
		query.append(" 		 WHERE " ).append("\n"); 
		query.append("  		B.PRNT_CD_ID = SUBSTRB(@[searchkey],0,2) " ).append("\n"); 
		query.append("  		AND SUBSTRB(B.MNR_CD_ID,LENGTH(B.MNR_CD_ID) - 2,LENGTH(B.MNR_CD_ID)) = SUBSTRB(@[searchkey],3,5) " ).append("\n"); 
		query.append(" 	)" ).append("\n"); 
		query.append("#elseif (${searchcon} == 'CUSTOM5')   " ).append("\n"); 
		query.append("WHERE A.PRNT_CD_ID = SUBSTRB(@[searchkey],0,2)" ).append("\n"); 
		query.append("AND SUBSTRB(A.MNR_CD_ID,5,6) = SUBSTRB(@[searchkey],3,4)" ).append("\n"); 
		query.append("#elseif (${searchcon} == 'CUSTOM6') " ).append("\n"); 
		query.append("WHERE MNR_ORD_TP_CD = 'QT'" ).append("\n"); 
		query.append("AND  DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND  PRNT_CD_ID = @[searchkey]||'G'" ).append("\n"); 
		query.append("#elseif (${searchcon} == 'CUSTOM7') " ).append("\n"); 
		query.append("WHERE MNR_ORD_TP_CD = 'TS'" ).append("\n"); 
		query.append("AND  DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND  PRNT_CD_ID = @[searchkey]||'G'" ).append("\n"); 
		query.append("#elseif (${searchcon} == 'CUSTOM9') " ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PRNT_CD_ID = 'CD00002' " ).append("\n"); 
		query.append("#elseif (${searchcon} == 'CUSTOM10')" ).append("\n"); 
		query.append("WHERE PRNT_CD_ID = 'CD00096'" ).append("\n"); 
		query.append("#if(${searchkey} != '')" ).append("\n"); 
		query.append("  AND SUBSTRB(MNR_CD_ID,0,1) = SUBSTRB(@[searchkey], 0, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.MNR_CD_DP_SEQ" ).append("\n"); 

	}
}