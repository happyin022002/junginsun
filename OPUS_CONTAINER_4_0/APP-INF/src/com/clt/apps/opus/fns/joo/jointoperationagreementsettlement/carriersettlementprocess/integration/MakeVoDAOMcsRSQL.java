/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MakeVoDAOMcsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2011.03.18 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVoDAOMcsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MakeVoDAOMcsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : MakeVoDAOMcsRSQL").append("\n"); 
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
		query.append("SELECT ''ord," ).append("\n"); 
		query.append("       '' SUB_SUM_NM," ).append("\n"); 
		query.append("       ''TITLE_GB," ).append("\n"); 
		query.append("       ''  ACCT_YRMON                     ," ).append("\n"); 
		query.append("       ''  STL_VVD_SEQ                    ," ).append("\n"); 
		query.append("       ''  STL_SEQ                        ," ).append("\n"); 
		query.append("       ''  TRD_CD                         ," ).append("\n"); 
		query.append("       ''  JO_CRR_CD                      ," ).append("\n"); 
		query.append("       ''  RLANE_CD                       ," ).append("\n"); 
		query.append("       ''  RE_DIVR_CD                     ," ).append("\n"); 
		query.append("       ''  JO_STL_ITM_CD                  ," ).append("\n"); 
		query.append("       ''  JO_MNU_NM                      ," ).append("\n"); 
		query.append("       ''  VSL_CD                         ," ).append("\n"); 
		query.append("       ''  SKD_VOY_NO                     ," ).append("\n"); 
		query.append("       ''  SKD_DIR_CD                     ," ).append("\n"); 
		query.append("       ''  REV_DIR_CD                     ," ).append("\n"); 
		query.append("       ''  STL_BZC_PORT_CD                ," ).append("\n"); 
		query.append("       ''  ETA_DT                         ," ).append("\n"); 
		query.append("       ''  JO_STL_JB_CD                   ," ).append("\n"); 
		query.append("       ''  BSA_QTY                        ," ).append("\n"); 
		query.append("       ''  BSA_SLT_PRC                    ," ).append("\n"); 
		query.append("       ''  LOCL_CURR_CD                   ," ).append("\n"); 
		query.append("       ''  ADJ_BSA_QTY_LOCL_AMT           ," ).append("\n"); 
		query.append("       ''  ADJ_BSA_SLT_PRC_LOCL_AMT       ," ).append("\n"); 
		query.append("       ''  STL_LOCL_AMT                   ," ).append("\n"); 
		query.append("       ''  STL_USD_AMT                    ," ).append("\n"); 
		query.append("       ''  IOC_CD                         ," ).append("\n"); 
		query.append("       ''  SCONTI_CD                      ," ).append("\n"); 
		query.append("       ''  FNL_OWN_BSA_QTY                ," ).append("\n"); 
		query.append("       ''  FNL_BSA_WGT                    ," ).append("\n"); 
		query.append("       ''  USD_SLT_BSA_QTY                ," ).append("\n"); 
		query.append("       ''  USD_SLT_WGT                    ," ).append("\n"); 
		query.append("       ''  BSA_PER_WGT                    ," ).append("\n"); 
		query.append("       ''  FM_PORT_CD                     ," ).append("\n"); 
		query.append("       ''  TO_PORT_CD                     ," ).append("\n"); 
		query.append("       ''  RF_SCG_STL_TP_CD               ," ).append("\n"); 
		query.append("       ''  RF_SCG_PRC                     ," ).append("\n"); 
		query.append("       ''  STL_RMK                        ," ).append("\n"); 
		query.append("       ''  CMB_CFM_FLG                    ," ).append("\n"); 
		query.append("       ''  STL_CMB_SEQ                    ," ).append("\n"); 
		query.append("       ''  STL_TJ_NO                      ," ).append("\n"); 
		query.append("       ''  STL_ADJ_FLG                    ," ).append("\n"); 
		query.append("       ''  PRE_ACCT_YRMON                 ," ).append("\n"); 
		query.append("       ''  PRE_STL_VVD_SEQ                ," ).append("\n"); 
		query.append("       ''  PRE_STL_SEQ                    ," ).append("\n"); 
		query.append("       ''  STL_LST_FLG                    ," ).append("\n"); 
		query.append("       ''  CRE_DT                         ," ).append("\n"); 
		query.append("       ''  CRE_USR_ID                     ," ).append("\n"); 
		query.append("       ''  UPD_DT                         ," ).append("\n"); 
		query.append("       ''  UPD_USR_ID                     ," ).append("\n"); 
		query.append("       ''  UC_BSS_PORT_CD                 ," ).append("\n"); 
		query.append("       ''  UC_BSS_PORT_ETD_DT             ," ).append("\n"); 
		query.append("       ''  VVD," ).append("\n"); 
		query.append("       ''  JO_STL_ITM_CD_NM" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}