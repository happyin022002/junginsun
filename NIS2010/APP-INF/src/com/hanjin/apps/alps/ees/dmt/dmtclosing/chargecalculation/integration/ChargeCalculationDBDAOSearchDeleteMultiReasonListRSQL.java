/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchDeleteMultiReasonListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchDeleteMultiReasonListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchDeleteMultiReasonListRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchDeleteMultiReasonListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchDeleteMultiReasonListRSQL").append("\n"); 
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
		query.append("select  ATTR_CTNT1              as RSN_CD" ).append("\n"); 
		query.append("       ,ATTR_CTNT2              as RSN_DESC" ).append("\n"); 
		query.append("       ,ATTR_CTNT3              as SPEC_RSN_CD" ).append("\n"); 
		query.append("       ,ATTR_CTNT4              as SPEC_RSN_DESC" ).append("\n"); 
		query.append("       ,ATTR_CTNT5              as FILE_ATCH_MDT_YN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  from  DMT_HRD_CDG_CTNT " ).append("\n"); 
		query.append(" where  HRD_CDG_ID = 'CHG_DELT_RSN_CD'" ).append("\n"); 
		query.append(" -- ATTR_CTNT10 DEL_FLG 로 사용" ).append("\n"); 
		query.append(" and    ATTR_CTNT10 != 'Y'" ).append("\n"); 
		query.append(" ORDER BY TO_NUMBER(ATTR_CTNT9) ASC -- 임의의 순서 변경을 위한 SEQ 추가" ).append("\n"); 

	}
}