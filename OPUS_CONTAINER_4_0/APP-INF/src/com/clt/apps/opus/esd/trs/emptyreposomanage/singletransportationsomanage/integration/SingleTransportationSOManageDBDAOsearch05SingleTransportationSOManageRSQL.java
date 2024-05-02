/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOsearch05SingleTransportationSOManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.05.20 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOsearch05SingleTransportationSOManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOsearch05SingleTransportationSOManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOsearch05SingleTransportationSOManageRSQL").append("\n"); 
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
		query.append("#set(${arr_eqno}=${arr_eqno})" ).append("\n"); 
		query.append("#set(${arr_frmnodecd}=${arr_frmnodecd})" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT EQ_NO," ).append("\n"); 
		query.append("	   MAX( DECODE( RK,1, VERIFY_RESULT ) )||" ).append("\n"); 
		query.append("	   MAX( DECODE( RK,2, ' / '||VERIFY_RESULT ) )||" ).append("\n"); 
		query.append("	   MAX( DECODE( RK,3, ' / '||VERIFY_RESULT ) )||" ).append("\n"); 
		query.append("	   MAX( DECODE( RK,4, ' / '||VERIFY_RESULT ) )||" ).append("\n"); 
		query.append("	   MAX( DECODE( RK,5, ' / '||VERIFY_RESULT ) )||" ).append("\n"); 
		query.append("	   MAX( DECODE( RK,6, ' / '||VERIFY_RESULT ) )  VERIFY_RESULT," ).append("\n"); 
		query.append("	   MAX(VERIFY_YN) VERIFY_YN" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	   SELECT /*+ USE_NL(A) INDEX(A XAK3TRS_TRSP_SVC_ORD) */" ).append("\n"); 
		query.append("	          EQ_NO," ).append("\n"); 
		query.append("	          RANK() OVER(ORDER BY A.CRE_DT DESC) RK," ).append("\n"); 
		query.append("	          DECODE( TRSP_SO_SEQ, NULL, '',  'SO_NO:'||TRSP_SO_OFC_CTY_CD||TRSP_SO_SEQ||' '|| TO_CHAR(A.LOCL_CRE_DT, 'RRRR-MM-DD') ||' '|| FM_NOD_CD || '->'|| TO_NOD_CD || ' '|| TRSP_CRR_MOD_CD || ' SO Created' || DECODE(B.CONTI_CD,'M',' (Dup within 30 days)',' (Dup within 2 days)') )  Verify_Result , " ).append("\n"); 
		query.append("	          DECODE( SIGN( (SYSDATE - A.CRE_DT) -  DECODE(B.CONTI_CD, 'M', 30, 2) ) , -1, 'Y', 'N') VERIFY_YN " ).append("\n"); 
		query.append("	     FROM TRS_TRSP_SVC_ORD A, MDM_LOCATION B " ).append("\n"); 
		query.append("	    WHERE A.TRSP_COST_DTL_MOD_CD IN ('ER', 'CF', 'CN' ) " ).append("\n"); 
		query.append("#if ($arrNo.size() > 0) " ).append("\n"); 
		query.append("          AND ( " ).append("\n"); 
		query.append("	#foreach($key IN ${arrNo}) " ).append("\n"); 
		query.append("		#if($velocityCount == 1) " ).append("\n"); 
		query.append("			    ( A.EQ_NO = '${arr_eqno.get($key)}' AND A.FM_NOD_CD = '${arr_frmnodecd.get($key)}')" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			    OR ( A.EQ_NO = '${arr_eqno.get($key)}' AND A.FM_NOD_CD = '${arr_frmnodecd.get($key)}')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("  			  )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("	      AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("	      AND A.CRE_DT BETWEEN (SYSDATE - DECODE(B.CONTI_CD, 'M', 30, 2) ) AND SYSDATE" ).append("\n"); 
		query.append("          AND SUBSTR(A.FM_NOD_CD, 1, 5) = B.LOC_CD" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("GROUP BY EQ_NO" ).append("\n"); 

	}
}