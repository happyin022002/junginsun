/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOOpfCodDvsFeeViewVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOOpfCodDvsFeeViewVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOOpfCodDvsFeeViewVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOOpfCodDvsFeeViewVORSQL").append("\n"); 
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
		query.append("WITH V_CONTI AS (" ).append("\n"); 
		query.append("    SELECT 'A' AS CONTI_CD, 'Asia' AS CONTI_NM FROM DUAL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'E' AS CONTI_CD, 'Europe' AS CONTI_NM FROM DUAL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'M' AS CONTI_CD, 'America' AS CONTI_NM FROM DUAL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'F' AS CONTI_CD, 'Africa' AS CONTI_NM FROM DUAL )" ).append("\n"); 
		query.append("--SELECT * FROM V_LOC;" ).append("\n"); 
		query.append("SELECT V.CONTI_NM" ).append("\n"); 
		query.append("     , A.CONTI_CD" ).append("\n"); 
		query.append("     , MAX(DECODE(A.CONTI_CD, 'A', DECODE(A.DVS_FEE_TP_CD, '2', A.DVS_FEE_AMT, ''), 'E', DECODE(A.DVS_FEE_TP_CD, '2', A.DVS_FEE_AMT, ''),'')) T20FT" ).append("\n"); 
		query.append("     , MAX(DECODE(A.CONTI_CD, 'A', DECODE(A.DVS_FEE_TP_CD, '4', A.DVS_FEE_AMT, ''), 'E', DECODE(A.DVS_FEE_TP_CD, '4', A.DVS_FEE_AMT, ''),'')) T40FT" ).append("\n"); 
		query.append("     , MAX(DECODE(A.CONTI_CD, 'A', DECODE(A.DVS_FEE_TP_CD, 'I', A.DVS_FEE_AMT, ''), 'E', DECODE(A.DVS_FEE_TP_CD, 'I', A.DVS_FEE_AMT, ''),'')) TPORT" ).append("\n"); 
		query.append("     , MAX(DECODE(A.DVS_FEE_TP_CD, 'P', A.DVS_FEE_AMT, '')) TBL" ).append("\n"); 
		query.append("  FROM OPF_COD_DVS_FEE A" ).append("\n"); 
		query.append("     , V_CONTI V" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND A.CONTI_CD = V.CONTI_CD" ).append("\n"); 
		query.append(" GROUP BY V.CONTI_NM, A.CONTI_CD" ).append("\n"); 
		query.append(" ORDER BY A.CONTI_CD" ).append("\n"); 

	}
}