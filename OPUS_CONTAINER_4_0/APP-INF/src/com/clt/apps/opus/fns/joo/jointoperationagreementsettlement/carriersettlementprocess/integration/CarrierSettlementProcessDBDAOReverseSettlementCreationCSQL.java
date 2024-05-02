/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOReverseSettlementCreationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOReverseSettlementCreationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR REVERSE후에 SETTLEMENT삭제를 하려고 하면 FK 오류가 난다.
	  * 그러므로 REVERSE전표를 생성하면 새로운 SETTLEMENT데이터를 SELECT-INSERT로 강제생성해준다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOReverseSettlementCreationCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOReverseSettlementCreationCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_SETTLEMENT (" ).append("\n"); 
		query.append("        ACCT_YRMON" ).append("\n"); 
		query.append("       ,STL_VVD_SEQ" ).append("\n"); 
		query.append("       ,STL_SEQ" ).append("\n"); 
		query.append("       ,TRD_CD" ).append("\n"); 
		query.append("       ,RLANE_CD" ).append("\n"); 
		query.append("       ,JO_CRR_CD" ).append("\n"); 
		query.append("       ,RE_DIVR_CD" ).append("\n"); 
		query.append("       ,JO_STL_ITM_CD" ).append("\n"); 
		query.append("       ,JO_MNU_NM" ).append("\n"); 
		query.append("       ,VSL_CD" ).append("\n"); 
		query.append("       ,SKD_VOY_NO" ).append("\n"); 
		query.append("       ,SKD_DIR_CD" ).append("\n"); 
		query.append("       ,REV_DIR_CD" ).append("\n"); 
		query.append("       ,STL_BZC_PORT_CD" ).append("\n"); 
		query.append("       ,ETA_DT" ).append("\n"); 
		query.append("       ,JO_STL_JB_CD" ).append("\n"); 
		query.append("       ,BSA_QTY" ).append("\n"); 
		query.append("       ,BSA_SLT_PRC" ).append("\n"); 
		query.append("       ,LOCL_CURR_CD" ).append("\n"); 
		query.append("       ,ADJ_BSA_QTY_LOCL_AMT" ).append("\n"); 
		query.append("       ,ADJ_BSA_SLT_PRC_LOCL_AMT" ).append("\n"); 
		query.append("       ,STL_LOCL_AMT" ).append("\n"); 
		query.append("       ,STL_USD_AMT" ).append("\n"); 
		query.append("       ,IOC_CD" ).append("\n"); 
		query.append("       ,SCONTI_CD" ).append("\n"); 
		query.append("       ,FNL_OWN_BSA_QTY" ).append("\n"); 
		query.append("       ,FNL_BSA_WGT" ).append("\n"); 
		query.append("       ,USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("       ,USD_SLT_WGT" ).append("\n"); 
		query.append("       ,BSA_PER_WGT" ).append("\n"); 
		query.append("       ,FM_PORT_CD" ).append("\n"); 
		query.append("       ,TO_PORT_CD" ).append("\n"); 
		query.append("       ,RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("       ,RF_SCG_PRC" ).append("\n"); 
		query.append("       ,UC_BSS_PORT_CD" ).append("\n"); 
		query.append("       ,UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("       ,STL_RMK" ).append("\n"); 
		query.append("       ,CMB_CFM_FLG" ).append("\n"); 
		query.append("       ,STL_TJ_NO" ).append("\n"); 
		query.append("       ,STL_ADJ_FLG" ).append("\n"); 
		query.append("       ,PRE_ACCT_YRMON" ).append("\n"); 
		query.append("       ,PRE_STL_VVD_SEQ" ).append("\n"); 
		query.append("       ,PRE_STL_SEQ" ).append("\n"); 
		query.append("       ,STL_LST_FLG" ).append("\n"); 
		query.append("       ,STL_ADJ_IRR_FLG" ).append("\n"); 
		query.append("       ,STL_ADJ_IRR_RMK" ).append("\n"); 
		query.append("       ,STL_DUP_FLG" ).append("\n"); 
		query.append("       ,CRE_DT" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,UPD_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,SAIL_DYS " ).append("\n"); 
		query.append("       ,ST_DT " ).append("\n"); 
		query.append("       ,END_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("        A.ACCT_YRMON" ).append("\n"); 
		query.append("       ,A.STL_VVD_SEQ" ).append("\n"); 
		query.append("       ,TO_NUMBER(@[stl_cmb_seq]) AS STL_SEQ" ).append("\n"); 
		query.append("--       ,NVL((SELECT /*+INDEX_DESC(X XPKJOO_SETTLEMENT)*/ X.STL_SEQ + 1 FROM JOO_SETTLEMENT X WHERE X.ACCT_YRMON = A.ACCT_YRMON AND X.STL_VVD_SEQ = A.STL_VVD_SEQ AND ROWNUM = 1),1)" ).append("\n"); 
		query.append("       ,A.TRD_CD" ).append("\n"); 
		query.append("       ,A.RLANE_CD" ).append("\n"); 
		query.append("       ,A.JO_CRR_CD" ).append("\n"); 
		query.append("       ,A.RE_DIVR_CD" ).append("\n"); 
		query.append("       ,A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("       ,A.JO_MNU_NM" ).append("\n"); 
		query.append("       ,A.VSL_CD" ).append("\n"); 
		query.append("       ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,A.REV_DIR_CD" ).append("\n"); 
		query.append("       ,A.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("       ,A.ETA_DT" ).append("\n"); 
		query.append("       ,A.JO_STL_JB_CD" ).append("\n"); 
		query.append("       ,A.BSA_QTY" ).append("\n"); 
		query.append("       ,TO_NUMBER(A.BSA_SLT_PRC) * -1" ).append("\n"); 
		query.append("       ,A.LOCL_CURR_CD" ).append("\n"); 
		query.append("       ,A.ADJ_BSA_QTY_LOCL_AMT" ).append("\n"); 
		query.append("       ,A.ADJ_BSA_SLT_PRC_LOCL_AMT" ).append("\n"); 
		query.append("       ,TO_NUMBER(A.STL_LOCL_AMT) * -1 " ).append("\n"); 
		query.append("       ,A.STL_USD_AMT" ).append("\n"); 
		query.append("       ,A.IOC_CD" ).append("\n"); 
		query.append("       ,A.SCONTI_CD" ).append("\n"); 
		query.append("       ,A.FNL_OWN_BSA_QTY" ).append("\n"); 
		query.append("       ,A.FNL_BSA_WGT" ).append("\n"); 
		query.append("       ,A.USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("       ,A.USD_SLT_WGT" ).append("\n"); 
		query.append("       ,A.BSA_PER_WGT" ).append("\n"); 
		query.append("       ,A.FM_PORT_CD" ).append("\n"); 
		query.append("       ,A.TO_PORT_CD" ).append("\n"); 
		query.append("       ,A.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("       ,A.RF_SCG_PRC" ).append("\n"); 
		query.append("       ,A.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("       ,A.UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("       ,'REVERSE'||DECODE(A.STL_RMK,NULL,NULL,'('||A.STL_RMK||')') AS STL_RMK" ).append("\n"); 
		query.append("       ,'Y' AS CMB_CFM_FLG" ).append("\n"); 
		query.append("       ,A.STL_TJ_NO" ).append("\n"); 
		query.append("       ,A.STL_ADJ_FLG" ).append("\n"); 
		query.append("       ,A.PRE_ACCT_YRMON" ).append("\n"); 
		query.append("       ,A.PRE_STL_VVD_SEQ" ).append("\n"); 
		query.append("       ,A.PRE_STL_SEQ" ).append("\n"); 
		query.append("       ,A.STL_LST_FLG" ).append("\n"); 
		query.append("       ,A.STL_ADJ_IRR_FLG" ).append("\n"); 
		query.append("       ,A.STL_ADJ_IRR_RMK" ).append("\n"); 
		query.append("       ,'Y' AS STL_DUP_FLG --COPY하는 것이므로 DUP이다." ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("       ,@[upd_usr_id]" ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("       ,@[upd_usr_id]" ).append("\n"); 
		query.append("       ,A.SAIL_DYS " ).append("\n"); 
		query.append("       ,A.ST_DT " ).append("\n"); 
		query.append("       ,A.END_DT" ).append("\n"); 
		query.append("FROM   JOO_SETTLEMENT  A" ).append("\n"); 
		query.append("WHERE  A.ACCT_YRMON  = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ = TO_NUMBER(@[stl_vvd_seq])" ).append("\n"); 
		query.append("AND    A.STL_SEQ     = TO_NUMBER(@[stl_seq])" ).append("\n"); 

	}
}