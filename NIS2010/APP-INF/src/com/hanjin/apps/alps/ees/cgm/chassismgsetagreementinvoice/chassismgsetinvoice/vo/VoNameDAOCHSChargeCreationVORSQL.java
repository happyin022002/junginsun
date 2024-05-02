/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VoNameDAOCHSChargeCreationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.12.23 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoNameDAOCHSChargeCreationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20091223 1029 charge creation 추가 사항.
	  * </pre>
	  */
	public VoNameDAOCHSChargeCreationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo").append("\n"); 
		query.append("FileName : VoNameDAOCHSChargeCreationVORSQL").append("\n"); 
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
		query.append("'' AS DEL_CHK," ).append("\n"); 
		query.append("'' AS EQ_KND_CD," ).append("\n"); 
		query.append("'' AS COST_YRMON," ).append("\n"); 
		query.append("'' AS AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("'' AS AGMT_SEQ," ).append("\n"); 
		query.append("'' AS AGMT_NO," ).append("\n"); 
		query.append("'' AS AGMT_EFF_DT," ).append("\n"); 
		query.append("'' AS AGMT_EXP_DT," ).append("\n"); 
		query.append("'' AS AGMT_LSTM_CD," ).append("\n"); 
		query.append("'' AS VNDR_SEQ," ).append("\n"); 
		query.append("'' AS VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("'' AS LSE_CHG_STS_CD," ).append("\n"); 
		query.append("'' AS CHG_CRE_SEQ," ).append("\n"); 
		query.append("'' AS CRE_USR_ID," ).append("\n"); 
		query.append("'' AS UPD_USR_ID," ).append("\n"); 
		query.append("'' AS AGMT_SEQS," ).append("\n"); 
		query.append("'' AS LSE_CHG_STS_DESC," ).append("\n"); 
		query.append("'' AS LSE_CHG_SMRY_AMT," ).append("\n"); 
		query.append("'' AS INV_SMRY_AMT," ).append("\n"); 
		query.append("'' AS PAY_LSE_CHG_AMT," ).append("\n"); 
		query.append("'' AS DEBIT_AMT," ).append("\n"); 
		query.append("'' AS CR_SMRY_AMT," ).append("\n"); 
		query.append("'' AS TAX_SMRY_AMT," ).append("\n"); 
		query.append("'' AS CRE_OFC_CD," ).append("\n"); 
		query.append("'' AS CRE_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}