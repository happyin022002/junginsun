/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MakeVoDAOBlkVygSttsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVoDAOBlkVygSttsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Blank Voyate Status 관련.
	  * </pre>
	  */
	public MakeVoDAOBlkVygSttsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : MakeVoDAOBlkVygSttsRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	''	JO_CRR_CD," ).append("\n"); 
		query.append("	''	TRD_CD," ).append("\n"); 
		query.append("	''	RLANE_CD," ).append("\n"); 
		query.append("	''	RE_DIVR_CD," ).append("\n"); 
		query.append("	''	CMPN_AGMT_SEQ," ).append("\n"); 
		query.append("	''	OFC_CD," ).append("\n"); 
		query.append("	''	AGMT_OFC_CD," ).append("\n"); 
		query.append("	''	JO_CMPN_KND_CD," ).append("\n"); 
		query.append("	''	CMPN_AGMT_YRMON," ).append("\n"); 
		query.append("	''	CMPN_AGMT_YRWK," ).append("\n"); 
		query.append("	''	VSL_CD," ).append("\n"); 
		query.append("	''	SKD_VOY_NO,  " ).append("\n"); 
		query.append("	''	SKD_DIR_CD, " ).append("\n"); 
		query.append("	''	BSA_QTY, " ).append("\n"); 
		query.append("	''	BSA_SLT_PRC," ).append("\n"); 
		query.append("	''	AGMT_TTL_AMT," ).append("\n"); 
		query.append("	''  ATCH_FILE_FLAG," ).append("\n"); 
		query.append("	''	ATCH_FILE_ID," ).append("\n"); 
		query.append("	''	CMPN_AGMT_RMK," ).append("\n"); 
		query.append("	''	STL_FLG," ).append("\n"); 
		query.append("	''	STL_VSL_CD," ).append("\n"); 
		query.append("	''	STL_VOY_NO," ).append("\n"); 
		query.append("	''	STL_DIR_CD," ).append("\n"); 
		query.append("	''	STL_DT," ).append("\n"); 
		query.append("	''	DELT_FLG," ).append("\n"); 
		query.append("	''	CRE_DT," ).append("\n"); 
		query.append("	''	CRE_USR_ID," ).append("\n"); 
		query.append("	''	UPD_DT,   " ).append("\n"); 
		query.append("	''	UPD_USR_ID," ).append("\n"); 
		query.append("	''  FM_PRD1," ).append("\n"); 
		query.append("	''  TO_PRD2," ).append("\n"); 
		query.append("	''  STTL_CD," ).append("\n"); 
		query.append("	''  VVD_CD," ).append("\n"); 
		query.append("	''  STL_VVD_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}