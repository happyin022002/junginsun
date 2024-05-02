/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCGOHChargeProposalDBDAOGuidelineGOHChargeExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2010.01.08 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgohchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGOHChargeProposalDBDAOGuidelineGOHChargeExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GOH Guideline Copy 대상 존재 여부를 조회한다
	  * </pre>
	  */
	public SCGOHChargeProposalDBDAOGuidelineGOHChargeExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scgohchargeproposal.integration").append("\n"); 
		query.append("FileName : SCGOHChargeProposalDBDAOGuidelineGOHChargeExistRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) AS CNT" ).append("\n"); 
		query.append("FROM PRI_SG_GOH_CHG" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = (SELECT MAX(GLINE_SEQ)" ).append("\n"); 
		query.append("FROM PRI_SG_MN" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND TO_DATE(REPLACE(@[eff_dt],'-',''),'YYYYMMDD') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("AND CFM_FLG = 'Y')" ).append("\n"); 

	}
}