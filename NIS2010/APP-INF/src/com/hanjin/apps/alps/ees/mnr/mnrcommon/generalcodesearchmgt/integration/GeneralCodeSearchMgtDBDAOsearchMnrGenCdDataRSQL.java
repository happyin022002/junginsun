/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchMnrGenCdDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.15
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.03.15 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
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
	  * 
	  * 2011.08.30 나상보 [CHM-201113102] ALPS MNR-Disposal-Disposal Inquiry화면에 조회 Status 추가 개발 요청
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
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
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
		query.append(" 		,A.MNR_CD_DESC AS CD_DESC	" ).append("\n"); 
		query.append("#elseif (${searchcon} == 'CUSTOM10')" ).append("\n"); 
		query.append("         A.MNR_CD_DP_DESC AS CD_ID" ).append("\n"); 
		query.append(" 		,A.MNR_CD_DESC AS CD_DESC		" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         A.MNR_CD_ID AS CD_ID" ).append("\n"); 
		query.append(" 		,A.MNR_CD_DP_DESC AS CD_DESC		" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM MNR_GEN_CD A" ).append("\n"); 
		query.append("#if (${searchcon} == 'COMMON' || ${searchcon} == 'CUSTOM3' ||  ${searchcon} == 'CUSTOM8' ||  ${searchcon} == 'CUSTOM10' ||  ${searchcon} == 'CUSTOM11') " ).append("\n"); 
		query.append("	#if (${searchkey} == 'AG' || ${searchkey} == 'A,U,Z,GG')" ).append("\n"); 
		query.append("	WHERE A.PRNT_CD_ID IN ('UG','GG','ZG')" ).append("\n"); 
		query.append("	#elseif (${searchkey} == 'U,ZG')" ).append("\n"); 
		query.append("	WHERE A.PRNT_CD_ID IN ('UG','ZG')" ).append("\n"); 
		query.append("	#elseif (${searchkey} == 'U,GG')" ).append("\n"); 
		query.append("	WHERE A.PRNT_CD_ID IN ('UG','GG')" ).append("\n"); 
		query.append("	#elseif (${searchkey} == 'Z,GG')" ).append("\n"); 
		query.append("	WHERE A.PRNT_CD_ID IN ('ZG','GG')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	WHERE A.PRNT_CD_ID = @[searchkey]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${searchcon} == 'CUSTOM11')" ).append("\n"); 
		query.append("	AND A.MNR_CD_GRP_NO = '3'" ).append("\n"); 
		query.append("	AND A.MNR_CD_GRP_TP_CD = 'OT'" ).append("\n"); 
		query.append("	AND MNR_CD_ID <> 'HD'" ).append("\n"); 
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
		query.append("  		AND SUBSTRB(B.MNR_CD_ID,LENGTH(B.MNR_CD_ID) - 1,LENGTH(B.MNR_CD_ID)) = SUBSTRB(@[searchkey],3,4) " ).append("\n"); 
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
		query.append("#end" ).append("\n"); 
		query.append("#if (${searchkey} == 'CD00004') " ).append("\n"); 
		query.append("ORDER BY A.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY A.MNR_CD_DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}