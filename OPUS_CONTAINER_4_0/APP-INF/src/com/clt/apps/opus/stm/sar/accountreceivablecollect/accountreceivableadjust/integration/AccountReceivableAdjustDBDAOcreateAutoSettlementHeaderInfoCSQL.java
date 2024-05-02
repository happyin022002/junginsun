/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOcreateAutoSettlementHeaderInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOcreateAutoSettlementHeaderInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAR_ADJ_HDR 테이블에 insert
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOcreateAutoSettlementHeaderInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_key_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_adj_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOcreateAutoSettlementHeaderInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO  SAR_ADJ_HDR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     OTS_ADJ_SEQ" ).append("\n"); 
		query.append("	,ADJ_NO" ).append("\n"); 
		query.append("	,ADJ_DT" ).append("\n"); 
		query.append("	,BL_NO" ).append("\n"); 
		query.append("	,BKG_NO" ).append("\n"); 
		query.append("	,INV_NO" ).append("\n"); 
		query.append("	,INV_OFC_CD" ).append("\n"); 
		query.append("	,ADJ_TP_CD" ).append("\n"); 
		query.append("	,BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("	,BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("	,SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("	,SHP_TO_CUST_SEQ" ).append("\n"); 
		query.append("	,LOCL_VVD_CD" ).append("\n"); 
		query.append("	,TRNK_VVD_CD" ).append("\n"); 
		query.append("	,SAIL_DT" ).append("\n"); 
		query.append("	,SAIL_ARR_DT" ).append("\n"); 
		query.append("	,OBRD_DT" ).append("\n"); 
		query.append("	,IO_BND_CD" ).append("\n"); 
		query.append("	,DUE_DT" ).append("\n"); 
		query.append("	,SREP_CD" ).append("\n"); 
		query.append("	,ADJ_RMK" ).append("\n"); 
		query.append("	,XCH_RT_TP_CD" ).append("\n"); 
		query.append("	,XCH_RT_DT" ).append("\n"); 
		query.append("	,CR_FLG" ).append("\n"); 
		query.append("	,AR_TAX_IND_CD" ).append("\n"); 
		query.append("	,AR_TJ_TP_CD" ).append("\n"); 
		query.append("	,AR_FINC_SRC_CD" ).append("\n"); 
		query.append("	,MAX_AR_IF_NO" ).append("\n"); 
		query.append("	,AP_CURR_CD" ).append("\n"); 
		query.append("	,AP_CRS_CURR_AMT" ).append("\n"); 
		query.append("	,GAIN_AND_LSS_AMT" ).append("\n"); 
		query.append("	,AP_OFC_CD" ).append("\n"); 
		query.append("	,VNDR_NO" ).append("\n"); 
		query.append("	,AP_RMK" ).append("\n"); 
		query.append("	,RVS_FLG" ).append("\n"); 
		query.append("	,ASA_NO" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	,ADJ_KEY_NO" ).append("\n"); 
		query.append("	,ADJ_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[ots_adj_seq]," ).append("\n"); 
		query.append("       @[adj_no]," ).append("\n"); 
		query.append("       REPLACE(@[adj_dt], '-', '')," ).append("\n"); 
		query.append("       SOH.BL_NO," ).append("\n"); 
		query.append("       SOH.BKG_NO," ).append("\n"); 
		query.append("       SOH.INV_NO," ).append("\n"); 
		query.append("       SOH.CLT_OFC_CD," ).append("\n"); 
		query.append("       @[adj_tp_cd]," ).append("\n"); 
		query.append("       SOH.BIL_TO_CUST_CNT_CD," ).append("\n"); 
		query.append("       SOH.BIL_TO_CUST_SEQ," ).append("\n"); 
		query.append("       SOH.SHP_TO_CUST_CNT_CD," ).append("\n"); 
		query.append("       SOH.SHP_TO_CUST_SEQ," ).append("\n"); 
		query.append("       SOH.VSL_CD||SOH.SKD_VOY_NO||SOH.DIR_CD AS LOCL_VVD_CD," ).append("\n"); 
		query.append("	   SOH.TRNK_VVD_CD," ).append("\n"); 
		query.append("       NULL  SAIL_DT," ).append("\n"); 
		query.append("       SOH.SAIL_ARR_DT," ).append("\n"); 
		query.append("       NULL  OBRD_DT," ).append("\n"); 
		query.append("       SOH.BKG_IO_BND_CD," ).append("\n"); 
		query.append("       SOH.DUE_DT," ).append("\n"); 
		query.append("       SOH.cust_srep_cd ," ).append("\n"); 
		query.append("       NULL     ADJ_RMK," ).append("\n"); 
		query.append("       SOH.XCH_RT_TP_CD," ).append("\n"); 
		query.append("       SOH.XCH_RT_DT," ).append("\n"); 
		query.append("       SOH.CR_MK_FLG  CR_FLG," ).append("\n"); 
		query.append("       NULL    AR_TAX_IND_CD," ).append("\n"); 
		query.append("       NULL    TJ_SRC_NM," ).append("\n"); 
		query.append("       SOH.OTS_SRC_CD," ).append("\n"); 
		query.append("       SOH.MAX_AR_IF_NO," ).append("\n"); 
		query.append("       NULL    AP_CURR_CD," ).append("\n"); 
		query.append("       NULL    AP_CRS_CURR_AMT," ).append("\n"); 
		query.append("       NULL    GAIN_AND_LSS_AMT," ).append("\n"); 
		query.append("       NULL    AP_OFC_CD," ).append("\n"); 
		query.append("       NULL    VNDR_NO," ).append("\n"); 
		query.append("       NULL    AP_RMK," ).append("\n"); 
		query.append("       NULL    RVS_FLG," ).append("\n"); 
		query.append("       NULL    ASA_NO," ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       SYSDATE, " ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       SYSDATE," ).append("\n"); 
		query.append("	   @[adj_key_no]," ).append("\n"); 
		query.append("	   SOH.CLT_OFC_CD" ).append("\n"); 
		query.append("FROM   SAR_OTS_HDR  SOH," ).append("\n"); 
		query.append("       SAR_OTS_HIS  SOHI" ).append("\n"); 
		query.append("WHERE  SOH.MAX_AR_IF_NO||'1' = SOHI.IF_NO" ).append("\n"); 
		query.append("AND    SOH.RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("AND    SOH.OTS_OFC_CD = @[ots_ofc_cd]  " ).append("\n"); 
		query.append("AND    SOH.CLT_OFC_CD = @[clt_ofc_cd]" ).append("\n"); 
		query.append("AND    SOH.BL_NO = @[bl_no]  " ).append("\n"); 
		query.append("AND    SOH.INV_NO = @[inv_no] " ).append("\n"); 
		query.append("AND    SOHI.OTS_HIS_TP_CD = 'OTS' " ).append("\n"); 
		query.append("AND    SOH.STL_FLG = 'N'" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 

	}
}