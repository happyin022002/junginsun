/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RailSoManageDBDAOSearch07RailSoManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.02
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2017.02.02 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearch07RailSoManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US Rail O/B Verify SQL
	  * </pre>
	  */
	public RailSoManageDBDAOSearch07RailSoManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sofficeCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearch07RailSoManageRSQL").append("\n"); 
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
		query.append("SELECT EQ_NO" ).append("\n"); 
		query.append("      ,MIN(VERIFY_RESULT) VERIFY_RESULT" ).append("\n"); 
		query.append("      ,MAX(VERIFY_YN) VERIFY_YN " ).append("\n"); 
		query.append("  FROM (SELECT EQ_NO" ).append("\n"); 
		query.append("              ,SUBSTR(  TO_CHAR(LOCL_CRE_DT, 'YYYYMMDD')|| 'SMLINE - CNTR_NO: ' ||EQ_NO||' S/O created( '" ).append("\n"); 
		query.append("                        ||TO_CHAR(LOCL_CRE_DT, 'YYYYMMDD') " ).append("\n"); 
		query.append("                        ||DECODE(TRSP_BND_CD,'O', ' : Full )', ' : Mty )'||' ROUTE : ' ||FM_NOD_CD||'-->'||TO_NOD_CD),9,100) VERIFY_RESULT" ).append("\n"); 
		query.append("              ,CASE WHEN SO.TRSP_BND_CD = 'O' THEN 'Y' " ).append("\n"); 
		query.append("          			WHEN SO.TRSP_BND_CD IS NULL THEN DECODE(SIGN(TRUNC(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sofficeCd]) - LOCL_CRE_DT )-3), -1, 'Y', 0, 'Y', 'N') " ).append("\n"); 
		query.append("				END VERIFY_YN " ).append("\n"); 
		query.append("	  	 FROM TRS_TRSP_RAIL_BIL_ORD SO " ).append("\n"); 
		query.append("		WHERE (TRSP_BND_CD = 'O' OR TRSP_BND_CD IS NULL) " ).append("\n"); 
		query.append("		  AND NVL(DELT_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("#if(${eqNoVerify} != '')" ).append("\n"); 
		query.append("		  AND EQ_NO IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${eqNoVerify})	" ).append("\n"); 
		query.append("		#if($velocityCount == 1)		" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			,'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end     " ).append("\n"); 
		query.append("		  AND LOCL_CRE_DT BETWEEN (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sofficeCd]) - 15) AND GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sofficeCd]) " ).append("\n"); 
		query.append("		UNION ALL " ).append("\n"); 
		query.append("	   SELECT EQ_NO" ).append("\n"); 
		query.append("             ,SUBSTR(  TO_CHAR(LOCL_CRE_DT, 'YYYYMMDD')|| 'SMLINE - CNTR_NO: ' " ).append("\n"); 
		query.append("						||EQ_NO||' S/O created( '||TO_CHAR(LOCL_CRE_DT, 'YYYYMMDD') " ).append("\n"); 
		query.append("						||DECODE(TRSP_BND_CD,'O', ' : Full )', ' : Mty )'||' ROUTE : ' " ).append("\n"); 
		query.append("						||FM_NOD_CD||'-->'||TO_NOD_CD),9,100) VERIFY_RESULT" ).append("\n"); 
		query.append("			,'Y' VERIFY_YN " ).append("\n"); 
		query.append("	    FROM TRS_TRSP_RAIL_BIL_ORD SO " ).append("\n"); 
		query.append("   	   WHERE SO.TRSP_BND_CD = 'I' " ).append("\n"); 
		query.append("	 	 AND NVL(DELT_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("#if(${eqNoVerify} != '')" ).append("\n"); 
		query.append("		 AND EQ_NO IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${eqNoVerify})	" ).append("\n"); 
		query.append("		#if($velocityCount == 1)		" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			,'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end     " ).append("\n"); 
		query.append("		   AND LOCL_CRE_DT BETWEEN (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sofficeCd]) - 5) AND GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sofficeCd]) " ).append("\n"); 
		query.append("	     UNION ALL " ).append("\n"); 
		query.append("	  	SELECT B.CNTR_NO EQ_NO" ).append("\n"); 
		query.append("		      ,DECODE(A.ALOC_STS_CD,'S','BKG status is Stand By','') VERIFY_RESULT --ALOC_STS_CD는 미주 OutBound에만 존재함." ).append("\n"); 
		query.append("		      ,DECODE(A.ALOC_STS_CD,'S','Y','N') VERIFY_YN" ).append("\n"); 
		query.append("		  FROM BKG_BOOKING A" ).append("\n"); 
		query.append("		      ,BKG_CONTAINER B" ).append("\n"); 
		query.append("		 WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND SUBSTR(A.POL_CD,1,2) IN ('CA','US')" ).append("\n"); 
		query.append("#if(${bkgNoVerify} != '')" ).append("\n"); 
		query.append("		  AND A.BKG_NO IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${bkgNoVerify})	" ).append("\n"); 
		query.append("		#if($velocityCount == 1)		" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			, '$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end     " ).append("\n"); 
		query.append("#if(${eqNoVerify} != '')" ).append("\n"); 
		query.append("		  AND B.CNTR_NO IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${eqNoVerify})	" ).append("\n"); 
		query.append("		#if($velocityCount == 1)		" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			, '$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end     " ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append("GROUP BY EQ_NO" ).append("\n"); 

	}
}