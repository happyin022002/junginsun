/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AgreementHisDBDAOSearchTypeSizeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.11
*@LastModifier : 민정호
*@LastVersion : 1.1
* 2011.04.07 민정호
* 1.0 Creation
* 
* 1.1 2011.05.11 민정호 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementHisDBDAOSearchTypeSizeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AgreementHisDBDAOSearchTypeSize
	  * </pre>
	  */
	public AgreementHisDBDAOSearchTypeSizeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration ").append("\n"); 
		query.append("FileName : AgreementHisDBDAOSearchTypeSizeRSQL").append("\n"); 
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
		query.append("SELECT TPSZ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE WHEN TRSP_AGMT_EQ_TP_CD||TRSP_AGMT_EQ_SZ_CD = 'ALAL' THEN 'A'" ).append("\n"); 
		query.append("WHEN TRSP_AGMT_EQ_TP_CD = 'AL' THEN 'B'" ).append("\n"); 
		query.append("WHEN TRSP_AGMT_EQ_SZ_CD = 'AL' THEN DECODE(LENGTH(TRSP_AGMT_EQ_TP_CD), 1, 'C', 'D')" ).append("\n"); 
		query.append("WHEN LENGTH(TRSP_AGMT_EQ_TP_CD) = 1 THEN 'E'" ).append("\n"); 
		query.append("END ORD" ).append("\n"); 
		query.append(", TRSP_AGMT_EQ_TP_CD||TRSP_AGMT_EQ_SZ_CD AS TPSZ" ).append("\n"); 
		query.append("FROM NISADM.TRS_AGMT_EQ_TP_RULE X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TRSP_AGMT_RULE_TP_CD = 'S'" ).append("\n"); 
		query.append("AND TRSP_AGMT_STEP_KNT = 6" ).append("\n"); 
		query.append("AND TRSP_AGMT_EQ_SZ_CD NOT IN ('X', 'W')" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("CASE WHEN TRSP_AGMT_EQ_TP_CD||TRSP_AGMT_EQ_SZ_CD = 'ALAL' THEN 'A'" ).append("\n"); 
		query.append("WHEN TRSP_AGMT_EQ_TP_CD = 'AL' THEN 'B'" ).append("\n"); 
		query.append("WHEN TRSP_AGMT_EQ_SZ_CD = 'AL' THEN DECODE(LENGTH(TRSP_AGMT_EQ_TP_CD), 1, 'C', 'D')" ).append("\n"); 
		query.append("WHEN LENGTH(TRSP_AGMT_EQ_TP_CD) = 1 THEN 'E'" ).append("\n"); 
		query.append("END, TRSP_AGMT_EQ_TP_CD, TRSP_AGMT_EQ_SZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}