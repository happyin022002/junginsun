/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExceptionDataDBDAOSearchExpTypeDetailListForMultiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.12 이중환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExceptionDataDBDAOSearchExpTypeDetailListForMultiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select dtl multi
	  * </pre>
	  */
	public ExceptionDataDBDAOSearchExpTypeDetailListForMultiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration ").append("\n"); 
		query.append("FileName : ExceptionDataDBDAOSearchExpTypeDetailListForMultiRSQL").append("\n"); 
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
		query.append("SELECT TOA.EXPT_TP_CD F_COP_EXPT_TP_CD, TP.EXPT_CD_NM, TOA.EXPT_TP_DTL_CD||'00000' F_COP_EXPT_TP_DTL_CD, DTP.EXPT_TP_DTL_NM F_COP_EXPT_TP_DTL_NM, TOA.EXPT_TP_DTL_DESC F_COP_EXPT_TP_DTL_DESC" ).append("\n"); 
		query.append(",FMA.EXPT_CD F_FM_EXPT_CD" ).append("\n"); 
		query.append(",FMA.FM_ACT_CD F_FM_ACT, FMA.FM_ACT_NM F_FM_ACT_NM" ).append("\n"); 
		query.append(",TOA.EXPT_CD F_TO_EXPT_CD" ).append("\n"); 
		query.append(",(CASE WHEN TOA.TO_ACT_EXPT_CD<>'00' THEN TOA.TO_ACT_CD END) F_TO_ACT" ).append("\n"); 
		query.append(",(CASE WHEN TOA.TO_ACT_EXPT_CD<>'00' THEN TOA.TO_ACT_NM END) F_TO_ACT_NM" ).append("\n"); 
		query.append(",TOA.UPD_USR_ID F_USR_ID, TO_CHAR(TOA.UPD_DT,'YYYY/MM/DD HH24:MI:SS') F_UPD_DT, TOA.ACT_FLG F_ACT_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("( SELECT SUBSTR(EXPT_CD,1,1) EXPT_TP_CD, EXPT_CD_NM, EXPT_CD_DESC FROM SCE_EXPT_CD WHERE SUBSTR(EXPT_CD, 2, LENGTH(EXPT_CD) ) = '0000000' AND ACT_FLG = 'Y' ) TP," ).append("\n"); 
		query.append("( SELECT SUBSTR(EXPT_CD,1,1) EXPT_TP_CD, SUBSTR(EXPT_CD,1,3) EXPT_TP_DTL_CD, EXPT_CD_NM EXPT_TP_DTL_NM FROM SCE_EXPT_CD WHERE EXPT_CD LIKE '%00000' AND ACT_FLG = 'Y' AND EXPT_CD NOT LIKE '%0000000' ) DTP," ).append("\n"); 
		query.append("( SELECT SUBSTR(TOP.EXPT_CD,1,1) EXPT_TP_CD, SUBSTR(TOP.EXPT_CD,1,3) EXPT_TP_DTL_CD,TOP.COP_EXPT_TP_DTL_DESC EXPT_TP_DTL_DESC" ).append("\n"); 
		query.append(",SUBSTR(TOP.EXPT_CD,5,2) FM_ACT_EXPT_CD ,SUBSTR(TOP.EXPT_CD,7,2) TO_ACT_EXPT_CD" ).append("\n"); 
		query.append(",TOP.EXPT_CD_NM TO_ACT_CD, TOP.EXPT_CD_DESC TO_ACT_NM, TOP.UPD_USR_ID, TOP.UPD_DT, TOP.ACT_FLG, TOP.EXPT_CD" ).append("\n"); 
		query.append("FROM   SCE_EXPT_CD TOP" ).append("\n"); 
		query.append("WHERE  TOP.EXPT_CD NOT LIKE '%00000'" ).append("\n"); 
		query.append("AND    (SUBSTR(TOP.EXPT_CD,4,1) = '2' OR (SUBSTR(TOP.EXPT_CD,1,1) BETWEEN '2' AND '3'  AND SUBSTR(TOP.EXPT_CD,7,2) = '00')) ) TOA," ).append("\n"); 
		query.append("(SELECT SUBSTR(FMP.EXPT_CD,1,1) EXPT_TP_CD, SUBSTR(FMP.EXPT_CD,1,3) EXPT_TP_DTL_CD" ).append("\n"); 
		query.append(",SUBSTR(FMP.EXPT_CD,5,2) FM_ACT_EXPT_CD" ).append("\n"); 
		query.append(",FMP.EXPT_CD_NM FM_ACT_CD, FMP.EXPT_CD_DESC FM_ACT_NM, FMP.EXPT_CD" ).append("\n"); 
		query.append("FROM   SCE_EXPT_CD FMP" ).append("\n"); 
		query.append("WHERE  FMP.EXPT_CD NOT LIKE '%00000'" ).append("\n"); 
		query.append("AND    SUBSTR(FMP.EXPT_CD,4,1) = '1' ) FMA" ).append("\n"); 
		query.append("WHERE  TP.EXPT_TP_CD = TOA.EXPT_TP_CD" ).append("\n"); 
		query.append("AND    DTP.EXPT_TP_DTL_CD = TOA.EXPT_TP_DTL_CD" ).append("\n"); 
		query.append("AND    FMA.EXPT_TP_DTL_CD = TOA.EXPT_TP_DTL_CD" ).append("\n"); 
		query.append("AND    FMA.FM_ACT_EXPT_CD = TOA.FM_ACT_EXPT_CD" ).append("\n"); 

	}
}