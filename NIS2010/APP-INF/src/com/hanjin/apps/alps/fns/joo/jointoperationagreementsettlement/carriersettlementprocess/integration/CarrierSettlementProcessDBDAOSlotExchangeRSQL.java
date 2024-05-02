/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSlotExchangeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.05 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSlotExchangeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSlotExchangeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSlotExchangeRSQL").append("\n"); 
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
		query.append("SELECT  A.ACCT_YRMON                      ," ).append("\n"); 
		query.append("A.STL_VVD_SEQ                     ," ).append("\n"); 
		query.append("A.STL_SEQ                         ," ).append("\n"); 
		query.append("A.TRD_CD                          ," ).append("\n"); 
		query.append("A.JO_CRR_CD                       ," ).append("\n"); 
		query.append("A.RLANE_CD                        ," ).append("\n"); 
		query.append("A.RE_DIVR_CD                      ," ).append("\n"); 
		query.append("A.JO_STL_ITM_CD                   ," ).append("\n"); 
		query.append("A.JO_MNU_NM                       ," ).append("\n"); 
		query.append("A.VSL_CD                          ," ).append("\n"); 
		query.append("A.SKD_VOY_NO                      ," ).append("\n"); 
		query.append("A.SKD_DIR_CD                      ," ).append("\n"); 
		query.append("A.REV_DIR_CD                      ," ).append("\n"); 
		query.append("A.STL_BZC_PORT_CD                 ," ).append("\n"); 
		query.append("A.ETA_DT                          ," ).append("\n"); 
		query.append("A.JO_STL_JB_CD                    ," ).append("\n"); 
		query.append("A.BSA_QTY                         ," ).append("\n"); 
		query.append("A.BSA_SLT_PRC                     ," ).append("\n"); 
		query.append("A.LOCL_CURR_CD                    ," ).append("\n"); 
		query.append("A.ADJ_BSA_QTY_LOCL_AMT            ," ).append("\n"); 
		query.append("A.ADJ_BSA_SLT_PRC_LOCL_AMT        ," ).append("\n"); 
		query.append("A.STL_LOCL_AMT                    ," ).append("\n"); 
		query.append("A.STL_USD_AMT                     ," ).append("\n"); 
		query.append("A.IOC_CD                          ," ).append("\n"); 
		query.append("A.SCONTI_CD                       ," ).append("\n"); 
		query.append("A.FNL_HJS_BSA_QTY                 ," ).append("\n"); 
		query.append("A.FNL_BSA_WGT                     ," ).append("\n"); 
		query.append("A.USD_SLT_BSA_QTY                 ," ).append("\n"); 
		query.append("A.USD_SLT_WGT                     ," ).append("\n"); 
		query.append("A.BSA_PER_WGT                     ," ).append("\n"); 
		query.append("A.FM_PORT_CD                      ," ).append("\n"); 
		query.append("A.TO_PORT_CD                      ," ).append("\n"); 
		query.append("A.RF_SCG_STL_TP_CD                ," ).append("\n"); 
		query.append("A.RF_SCG_PRC                      ," ).append("\n"); 
		query.append("A.STL_RMK                         ," ).append("\n"); 
		query.append("A.CMB_CFM_FLG                     ," ).append("\n"); 
		query.append("A.STL_CMB_SEQ                     ," ).append("\n"); 
		query.append("A.STL_TJ_NO                       ," ).append("\n"); 
		query.append("A.STL_ADJ_FLG                     ," ).append("\n"); 
		query.append("A.PRE_ACCT_YRMON                  ," ).append("\n"); 
		query.append("A.PRE_STL_VVD_SEQ                 ," ).append("\n"); 
		query.append("A.PRE_STL_SEQ                     ," ).append("\n"); 
		query.append("A.STL_LST_FLG                     ," ).append("\n"); 
		query.append("A.CRE_DT                          ," ).append("\n"); 
		query.append("A.CRE_USR_ID                      ," ).append("\n"); 
		query.append("A.UPD_DT                          ," ).append("\n"); 
		query.append("A.UPD_USR_ID                      ," ).append("\n"); 
		query.append("A.UC_BSS_PORT_CD                  ," ).append("\n"); 
		query.append("A.UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("FROM    JOO_SETTLEMENT A" ).append("\n"); 
		query.append("WHERE   A.ACCT_YRMON  =  @[acct_yrmon]" ).append("\n"); 
		query.append("AND     A.STL_VVD_SEQ =  @[stl_vvd_seq]" ).append("\n"); 
		query.append("AND     A.STL_SEQ     =  @[stl_seq]" ).append("\n"); 
		query.append("AND     A.STL_LOCL_AMT<>0" ).append("\n"); 

	}
}