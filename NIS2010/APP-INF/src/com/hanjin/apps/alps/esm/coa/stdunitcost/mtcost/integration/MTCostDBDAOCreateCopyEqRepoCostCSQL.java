/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MTCostDBDAOCreateCopyEqRepoCostCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTCostDBDAOCreateCopyEqRepoCostCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.09.10 이석준 [CHM-201220070-01] EQ Repo Cost (PA) 화면에 Month Copy 기능 추가 
	  * </pre>
	  */
	public MTCostDBDAOCreateCopyEqRepoCostCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tar_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_src_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.integration").append("\n"); 
		query.append("FileName : MTCostDBDAOCreateCopyEqRepoCostCSQL").append("\n"); 
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
		query.append("#if(${table_name} =='COA_MTCH_BAK_INFO')" ).append("\n"); 
		query.append("INSERT INTO COA_MTCH_BAK_INFO" ).append("\n"); 
		query.append("(COST_YRMON,LOC_CD,CNTR_TPSZ_CD,FULL_IB_QTY,FULL_OB_QTY,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    @[f_tar_mon] AS COST_YRMON," ).append("\n"); 
		query.append("    LOC_CD," ).append("\n"); 
		query.append("    CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    FULL_IB_QTY," ).append("\n"); 
		query.append("    FULL_OB_QTY," ).append("\n"); 
		query.append("    @[user_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[user_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append("FROM COA_MTCH_BAK_INFO" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_src_mon]" ).append("\n"); 
		query.append("#elseif (${table_name} =='COA_FULL_ECC_IMBAL')" ).append("\n"); 
		query.append("INSERT INTO COA_FULL_ECC_IMBAL" ).append("\n"); 
		query.append("(COST_YRMON,COST_LOC_GRP_CD,FCNTR_ECC_CD,CNTR_TPSZ_CD,CNTR_IO_VOL_STS_CD," ).append("\n"); 
		query.append(" CNTR_IMBAL_RTO,CNTR_IMBAL_QTY,CNTR_IB_QTY,CNTR_OB_QTY," ).append("\n"); 
		query.append(" CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    @[f_tar_mon] AS COST_YRMON," ).append("\n"); 
		query.append("    COST_LOC_GRP_CD," ).append("\n"); 
		query.append("    FCNTR_ECC_CD," ).append("\n"); 
		query.append("    CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    CNTR_IO_VOL_STS_CD," ).append("\n"); 
		query.append("    CNTR_IMBAL_RTO," ).append("\n"); 
		query.append("    CNTR_IMBAL_QTY," ).append("\n"); 
		query.append("    CNTR_IB_QTY," ).append("\n"); 
		query.append("    CNTR_OB_QTY," ).append("\n"); 
		query.append("    @[user_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[user_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append("FROM COA_FULL_ECC_IMBAL" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_src_mon]" ).append("\n"); 
		query.append("#elseif (${table_name} =='COA_CNTR_MTY_MVMT')" ).append("\n"); 
		query.append("INSERT INTO COA_CNTR_MTY_MVMT" ).append("\n"); 
		query.append("(COST_YRMON,CNTR_NO,MON_MVMT_SEQ,MTY_COST_TP_CD,YD_CD,CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNTR_ROUT_SEQ,CNMV_STS_CD,CNMV_DT,ROUT_N1ST_YD_CD,ROUT_LST_YD_CD,ROUT_SEQ," ).append("\n"); 
		query.append("COST_CRE_STS_CD,MTY_STVG_TTL_AMT,MTY_TRSP_TTL_AMT,MTY_DUR_DYS,NXT_YD_CD,COST_CALC_RMK," ).append("\n"); 
		query.append("CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    @[f_tar_mon] AS COST_YRMON,CNTR_NO,MON_MVMT_SEQ,MTY_COST_TP_CD,YD_CD,CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    CNTR_ROUT_SEQ,CNMV_STS_CD,CNMV_DT,ROUT_N1ST_YD_CD,ROUT_LST_YD_CD,ROUT_SEQ," ).append("\n"); 
		query.append("    COST_CRE_STS_CD,MTY_STVG_TTL_AMT,MTY_TRSP_TTL_AMT,MTY_DUR_DYS,NXT_YD_CD,COST_CALC_RMK," ).append("\n"); 
		query.append("    @[user_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[user_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append("FROM COA_CNTR_MTY_MVMT" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_src_mon]       " ).append("\n"); 
		query.append("#elseif (${table_name} =='COA_MTY_CNTR_ROUT_PERF')" ).append("\n"); 
		query.append("INSERT INTO COA_MTY_CNTR_ROUT_PERF" ).append("\n"); 
		query.append("(COST_YRMON,CNTR_TPSZ_CD,ROUT_N1ST_YD_CD,ROUT_LST_YD_CD,ROUT_SEQ,CNTR_ORG_DEST_CD," ).append("\n"); 
		query.append("MTY_COST_TP_CD,ROUT_N1ST_ECC_CD,ROUT_LST_ECC_CD,MTY_STVG_TTL_AMT,MTY_TRSP_TTL_AMT,TTL_TZ_DYS," ).append("\n"); 
		query.append("TTL_TZTM_HRS,TTL_CNTR_QTY,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    @[f_tar_mon] AS COST_YRMON,CNTR_TPSZ_CD,ROUT_N1ST_YD_CD,ROUT_LST_YD_CD,ROUT_SEQ,CNTR_ORG_DEST_CD," ).append("\n"); 
		query.append("    MTY_COST_TP_CD,ROUT_N1ST_ECC_CD,ROUT_LST_ECC_CD,MTY_STVG_TTL_AMT,MTY_TRSP_TTL_AMT,TTL_TZ_DYS," ).append("\n"); 
		query.append("    TTL_TZTM_HRS,TTL_CNTR_QTY,   " ).append("\n"); 
		query.append("    @[user_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[user_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append("FROM COA_MTY_CNTR_ROUT_PERF" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_src_mon]  " ).append("\n"); 
		query.append("#elseif (${table_name} =='COA_MTY_ECC_CNTR_SMRY')" ).append("\n"); 
		query.append("INSERT INTO COA_MTY_ECC_CNTR_SMRY" ).append("\n"); 
		query.append("(COST_YRMON,COST_LOC_GRP_CD,CNTR_TPSZ_CD,ECC_CD,CNTR_IO_VOL_STS_CD," ).append("\n"); 
		query.append("CNTR_ORG_DEST_CD,MTY_REPO_SIM_CD,MTY_COST_TP_CD,MTY_QTY,MTY_STVG_UC_AMT," ).append("\n"); 
		query.append("MTY_STVG_TTL_AMT,MTY_TRSP_UC_AMT,MTY_TRSP_TTL_AMT,MTY_TZ_HRS,MTY_TZ_DYS," ).append("\n"); 
		query.append("CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("SELECT @[f_tar_mon] AS COST_YRMON,COST_LOC_GRP_CD,CNTR_TPSZ_CD,ECC_CD,CNTR_IO_VOL_STS_CD," ).append("\n"); 
		query.append("       CNTR_ORG_DEST_CD,MTY_REPO_SIM_CD,MTY_COST_TP_CD,MTY_QTY,MTY_STVG_UC_AMT," ).append("\n"); 
		query.append("       MTY_STVG_TTL_AMT,MTY_TRSP_UC_AMT,MTY_TRSP_TTL_AMT,MTY_TZ_HRS,MTY_TZ_DYS," ).append("\n"); 
		query.append("       @[user_id],SYSDATE,@[user_id],SYSDATE" ).append("\n"); 
		query.append("FROM COA_MTY_ECC_CNTR_SMRY" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_src_mon]        " ).append("\n"); 
		query.append("#elseif (${table_name} =='COA_MTY_ECC_UT_COST')" ).append("\n"); 
		query.append("INSERT INTO COA_MTY_ECC_UT_COST" ).append("\n"); 
		query.append("(COST_YRMON," ).append("\n"); 
		query.append("COST_LOC_GRP_CD,ECC_CD,CNTR_TPSZ_CD,CNTR_ORG_DEST_CD,CNTR_IO_VOL_STS_CD,IMBAL_RTO," ).append("\n"); 
		query.append("MCNTR_QTY,MTY_STVG_UC_AMT,MTY_TRSP_UC_AMT,MTY_TZ_DYS,MTY_TZ_HRS,SIM_CNTR_QTY," ).append("\n"); 
		query.append("SIM_STVG_UC_AMT,SIM_TRSP_UC_AMT,SIM_TZ_DYS,SIM_TZ_HRS,FCNTR_QTY,FULL_STVG_UC_AMT," ).append("\n"); 
		query.append("FULL_TRSP_UC_AMT,FULL_TZ_HRS,MNUS_CR_CNTR_QTY,MNUS_CR_TRSP_UC_AMT,MTY_USA_COST_CD," ).append("\n"); 
		query.append("CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT,ORG_SIM_STVG_UC_AMT,ORG_SIM_TRSP_UC_AMT)" ).append("\n"); 
		query.append("SELECT  @[f_tar_mon] AS COST_YRMON," ).append("\n"); 
		query.append("       COST_LOC_GRP_CD,ECC_CD,CNTR_TPSZ_CD,CNTR_ORG_DEST_CD,CNTR_IO_VOL_STS_CD,IMBAL_RTO," ).append("\n"); 
		query.append("       MCNTR_QTY,MTY_STVG_UC_AMT,MTY_TRSP_UC_AMT,MTY_TZ_DYS,MTY_TZ_HRS,SIM_CNTR_QTY," ).append("\n"); 
		query.append("       SIM_STVG_UC_AMT,SIM_TRSP_UC_AMT,SIM_TZ_DYS,SIM_TZ_HRS,FCNTR_QTY,FULL_STVG_UC_AMT," ).append("\n"); 
		query.append("       FULL_TRSP_UC_AMT,FULL_TZ_HRS,MNUS_CR_CNTR_QTY,MNUS_CR_TRSP_UC_AMT,MTY_USA_COST_CD," ).append("\n"); 
		query.append("       @[user_id],SYSDATE,@[user_id],SYSDATE,ORG_SIM_STVG_UC_AMT,ORG_SIM_TRSP_UC_AMT" ).append("\n"); 
		query.append("FROM COA_MTY_ECC_UT_COST" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_src_mon]     " ).append("\n"); 
		query.append("#elseif (${table_name} =='COA_MTY_DEST_COST')" ).append("\n"); 
		query.append("INSERT INTO COA_MTY_DEST_COST" ).append("\n"); 
		query.append("(COST_YRMON," ).append("\n"); 
		query.append("COST_LOC_GRP_CD,CNTR_ORG_DEST_CD,ECC_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD,SIM_STVG_UC_AMT,MTY_STVG_TTL_AMT,MTY_QTY," ).append("\n"); 
		query.append("CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("SELECT @[f_tar_mon] AS COST_YRMON," ).append("\n"); 
		query.append("       COST_LOC_GRP_CD,CNTR_ORG_DEST_CD,ECC_CD," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD,SIM_STVG_UC_AMT,MTY_STVG_TTL_AMT,MTY_QTY," ).append("\n"); 
		query.append("       @[user_id],SYSDATE,@[user_id],SYSDATE" ).append("\n"); 
		query.append("FROM COA_MTY_DEST_COST" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_src_mon]       " ).append("\n"); 
		query.append("#elseif (${table_name} =='COA_MTY_CNTR_ROUT_DTL')" ).append("\n"); 
		query.append("INSERT INTO COA_MTY_CNTR_ROUT_DTL" ).append("\n"); 
		query.append("(COST_YRMON, CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("ROUT_N1ST_YD_CD, ROUT_LST_YD_CD, ROUT_SEQ, MVMT_SEQ, " ).append("\n"); 
		query.append("CNTR_ORG_DEST_CD, YD_CD, LST_YD_CD, LST_YD_MVMT_STS_CD, " ).append("\n"); 
		query.append("ROUT_N1ST_ECC_CD, ROUT_LST_ECC_CD, " ).append("\n"); 
		query.append("MTY_STVG_TTL_AMT, MTY_TRSP_TTL_AMT, TTL_TZ_DYS, TTL_TZTM_HRS, TTL_CNTR_QTY, " ).append("\n"); 
		query.append("CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT @[f_tar_mon] AS COST_YRMON, CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("       ROUT_N1ST_YD_CD, ROUT_LST_YD_CD, ROUT_SEQ, MVMT_SEQ, " ).append("\n"); 
		query.append("       CNTR_ORG_DEST_CD, YD_CD, LST_YD_CD, LST_YD_MVMT_STS_CD, " ).append("\n"); 
		query.append("       ROUT_N1ST_ECC_CD, ROUT_LST_ECC_CD, " ).append("\n"); 
		query.append("       MTY_STVG_TTL_AMT, MTY_TRSP_TTL_AMT, TTL_TZ_DYS, TTL_TZTM_HRS, TTL_CNTR_QTY, " ).append("\n"); 
		query.append("       @[user_id],SYSDATE,@[user_id],SYSDATE" ).append("\n"); 
		query.append("FROM COA_MTY_CNTR_ROUT_DTL" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_src_mon]   " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}