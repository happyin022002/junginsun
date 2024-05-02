/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RussiaCustomsTransmissionDBDAOsearchCargoTotalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RussiaCustomsTransmissionDBDAOsearchCargoTotalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public RussiaCustomsTransmissionDBDAOsearchCargoTotalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration").append("\n"); 
		query.append("FileName : RussiaCustomsTransmissionDBDAOsearchCargoTotalRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN BKG_CGO_TP_CD != 'P' AND NVL(KR_CSTMS_CUST_TP_CD,'X') != 'C' THEN 1 END),0) SIMPLE_CNT," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN BKG_CGO_TP_CD != 'P' AND KR_CSTMS_CUST_TP_CD = 'C' THEN 1 END),0) CONSOLE_CNT," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN BKG_CGO_TP_CD = 'P' THEN 1 END),0) BL_EMPTY_CNT," ).append("\n"); 
		query.append("		SUM(1) TOTAL_BL_CNT" ).append("\n"); 
		query.append("	FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("	WHERE	1=1" ).append("\n"); 
		query.append("	AND ( #foreach($field_id in ${field_list})" ).append("\n"); 
		query.append("	      	#if($velocityCount > 1)" ).append("\n"); 
		query.append("	      	OR #end  BKG.BKG_NO IN ( $field_id )" ).append("\n"); 
		query.append("	      #end" ).append("\n"); 
		query.append("	     )" ).append("\n"); 
		query.append(") ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		NVL(SUM( CASE WHEN BKG_CGO_TP_CD != 'P' AND SUBSTR(CNTR_TPSZ_CD,-1) != '2' THEN 1 END),0) HC4_CNT," ).append("\n"); 
		query.append("		NVL(SUM( CASE WHEN BKG_CGO_TP_CD != 'P' AND SUBSTR(CNTR_TPSZ_CD,-1) = '2' THEN 1 END),0) ST20_CNT," ).append("\n"); 
		query.append("		NVL(SUM( CASE WHEN BKG_CGO_TP_CD != 'P' THEN 1 END),0) CNTR_FULL_CNT," ).append("\n"); 
		query.append("		NVL(SUM( CASE WHEN BKG_CGO_TP_CD = 'P' THEN 1 END),0) CNTR_EMPTY_CNT," ).append("\n"); 
		query.append("		SUM(1) TOTAL_CNTR_CNT" ).append("\n"); 
		query.append("	FROM BKG_BOOKING BKG, BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("	WHERE BKG.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("	AND	1=1" ).append("\n"); 
		query.append("	AND ( #foreach($field_id in ${field_list})" ).append("\n"); 
		query.append("	      	#if($velocityCount > 1)" ).append("\n"); 
		query.append("	      	OR #end  BKG.BKG_NO IN ( $field_id )" ).append("\n"); 
		query.append("	      #end" ).append("\n"); 
		query.append("	     )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}