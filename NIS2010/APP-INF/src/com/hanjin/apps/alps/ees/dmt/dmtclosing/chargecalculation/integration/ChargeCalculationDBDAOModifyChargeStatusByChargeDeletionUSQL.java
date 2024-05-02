/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOModifyChargeStatusByChargeDeletionUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOModifyChargeStatusByChargeDeletionUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOModifyChargeStatusByChargeDeletionUSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOModifyChargeStatusByChargeDeletionUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_delt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOModifyChargeStatusByChargeDeletionUSQL").append("\n"); 
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
		query.append("update  DMT_CHG_CALC  T1 " ).append("\n"); 
		query.append("   set  DMDT_CHG_STS_CD = case " ).append("\n"); 
		query.append("							when @[chg_delt_sts_cd] = 'A' then 'D'" ).append("\n"); 
		query.append("							when @[chg_delt_sts_cd] = 'J' then " ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("									select  DMDT_PRE_CHG_STS_CD" ).append("\n"); 
		query.append("									  from  DMT_CHG_CALC" ).append("\n"); 
		query.append("									 where  SYS_AREA_GRP_ID     = @[svr_id] " ).append("\n"); 
		query.append("									   and  CNTR_NO				= @[cntr_no]" ).append("\n"); 
		query.append("									   and  CNTR_CYC_NO 		= to_number(@[cntr_cyc_no])" ).append("\n"); 
		query.append("									   and  DMDT_TRF_CD 		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("									   and  DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("									   and  CHG_SEQ				= to_number(@[chg_seq])" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("						 end" ).append("\n"); 
		query.append("#if (${chg_delt_sts_cd} == 'A')" ).append("\n"); 
		query.append("       ,DMDT_PRE_CHG_STS_CD = " ).append("\n"); 
		query.append("	    (" ).append("\n"); 
		query.append("			select  DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("			  from  DMT_CHG_CALC" ).append("\n"); 
		query.append("			 where  SYS_AREA_GRP_ID     = @[svr_id] " ).append("\n"); 
		query.append("			   and  CNTR_NO				= @[cntr_no]" ).append("\n"); 
		query.append("			   and  CNTR_CYC_NO 		= to_number(@[cntr_cyc_no])" ).append("\n"); 
		query.append("			   and  DMDT_TRF_CD 		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("			   and  DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("			   and  CHG_SEQ				= to_number(@[chg_seq])	   " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("       ,DMDT_CHG_DELT_RSN_CD = " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("			select  DMDT_CHG_DELT_RSN_CD" ).append("\n"); 
		query.append("			  from  DMT_CHG_DELT_RQST_APRO  SUB_T1" ).append("\n"); 
		query.append("			 where  SUB_T1.SYS_AREA_GRP_ID     = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			   and  SUB_T1.CNTR_NO             = T1.CNTR_NO" ).append("\n"); 
		query.append("			   and  SUB_T1.CNTR_CYC_NO         = T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   and  SUB_T1.DMDT_TRF_CD         = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("			   and  SUB_T1.DMDT_CHG_LOC_DIV_CD = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("			   and  SUB_T1.CHG_SEQ             = T1.CHG_SEQ" ).append("\n"); 
		query.append("			   and  SUB_T1.CHG_OFC_CD          = T1.OFC_CD" ).append("\n"); 
		query.append("			   and  SUB_T1.DELT_SEQ            =" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						select  max(DELT_SEQ)" ).append("\n"); 
		query.append("						  from  DMT_CHG_DELT_RQST_APRO" ).append("\n"); 
		query.append("						 where  SYS_AREA_GRP_ID     = SUB_T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   and  CNTR_NO             = SUB_T1.CNTR_NO" ).append("\n"); 
		query.append("						   and  CNTR_CYC_NO         = SUB_T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   and  DMDT_TRF_CD         = SUB_T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   and  DMDT_CHG_LOC_DIV_CD = SUB_T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("						   and  CHG_SEQ             = SUB_T1.CHG_SEQ" ).append("\n"); 
		query.append("						   and  CHG_OFC_CD          = SUB_T1.CHG_OFC_CD" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("       ,DMDT_CHG_DELT_SPEC_RSN_CD = " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("			select  DMDT_CHG_DELT_SPEC_RSN_CD" ).append("\n"); 
		query.append("			  from  DMT_CHG_DELT_RQST_APRO  SUB_T1" ).append("\n"); 
		query.append("			 where  SUB_T1.SYS_AREA_GRP_ID     = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			   and  SUB_T1.CNTR_NO             = T1.CNTR_NO" ).append("\n"); 
		query.append("			   and  SUB_T1.CNTR_CYC_NO         = T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   and  SUB_T1.DMDT_TRF_CD         = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("			   and  SUB_T1.DMDT_CHG_LOC_DIV_CD = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("			   and  SUB_T1.CHG_SEQ             = T1.CHG_SEQ" ).append("\n"); 
		query.append("			   and  SUB_T1.CHG_OFC_CD          = T1.OFC_CD" ).append("\n"); 
		query.append("			   and  SUB_T1.DELT_SEQ            =" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						select  max(DELT_SEQ)" ).append("\n"); 
		query.append("						  from  DMT_CHG_DELT_RQST_APRO" ).append("\n"); 
		query.append("						 where  SYS_AREA_GRP_ID     = SUB_T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   and  CNTR_NO             = SUB_T1.CNTR_NO" ).append("\n"); 
		query.append("						   and  CNTR_CYC_NO         = SUB_T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   and  DMDT_TRF_CD         = SUB_T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   and  DMDT_CHG_LOC_DIV_CD = SUB_T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("						   and  CHG_SEQ             = SUB_T1.CHG_SEQ" ).append("\n"); 
		query.append("						   and  CHG_OFC_CD          = SUB_T1.CHG_OFC_CD" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("       ,DELT_SPEC_RSN_RMK_SEQ = " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("			select  DELT_SPEC_RSN_RMK_SEQ" ).append("\n"); 
		query.append("			  from  DMT_CHG_DELT_RQST_APRO  SUB_T1" ).append("\n"); 
		query.append("			 where  SUB_T1.SYS_AREA_GRP_ID     = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			   and  SUB_T1.CNTR_NO             = T1.CNTR_NO" ).append("\n"); 
		query.append("			   and  SUB_T1.CNTR_CYC_NO         = T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   and  SUB_T1.DMDT_TRF_CD         = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("			   and  SUB_T1.DMDT_CHG_LOC_DIV_CD = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("			   and  SUB_T1.CHG_SEQ             = T1.CHG_SEQ" ).append("\n"); 
		query.append("			   and  SUB_T1.CHG_OFC_CD          = T1.OFC_CD" ).append("\n"); 
		query.append("			   and  SUB_T1.DELT_SEQ            =" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						select  max(DELT_SEQ)" ).append("\n"); 
		query.append("						  from  DMT_CHG_DELT_RQST_APRO" ).append("\n"); 
		query.append("						 where  SYS_AREA_GRP_ID     = SUB_T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   and  CNTR_NO             = SUB_T1.CNTR_NO" ).append("\n"); 
		query.append("						   and  CNTR_CYC_NO         = SUB_T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   and  DMDT_TRF_CD         = SUB_T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   and  DMDT_CHG_LOC_DIV_CD = SUB_T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("						   and  CHG_SEQ             = SUB_T1.CHG_SEQ" ).append("\n"); 
		query.append("						   and  CHG_OFC_CD          = SUB_T1.CHG_OFC_CD" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("       ,CORR_RMK = " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("			select  DELT_RMK" ).append("\n"); 
		query.append("			  from  DMT_CHG_DELT_RQST_APRO  SUB_T1" ).append("\n"); 
		query.append("			 where  SUB_T1.SYS_AREA_GRP_ID     = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			   and  SUB_T1.CNTR_NO             = T1.CNTR_NO" ).append("\n"); 
		query.append("			   and  SUB_T1.CNTR_CYC_NO         = T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   and  SUB_T1.DMDT_TRF_CD         = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("			   and  SUB_T1.DMDT_CHG_LOC_DIV_CD = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("			   and  SUB_T1.CHG_SEQ             = T1.CHG_SEQ" ).append("\n"); 
		query.append("			   and  SUB_T1.CHG_OFC_CD          = T1.OFC_CD" ).append("\n"); 
		query.append("			   and  SUB_T1.DELT_SEQ            =" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						select  max(DELT_SEQ)" ).append("\n"); 
		query.append("						  from  DMT_CHG_DELT_RQST_APRO" ).append("\n"); 
		query.append("						 where  SYS_AREA_GRP_ID     = SUB_T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   and  CNTR_NO             = SUB_T1.CNTR_NO" ).append("\n"); 
		query.append("						   and  CNTR_CYC_NO         = SUB_T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   and  DMDT_TRF_CD         = SUB_T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   and  DMDT_CHG_LOC_DIV_CD = SUB_T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("						   and  CHG_SEQ             = SUB_T1.CHG_SEQ" ).append("\n"); 
		query.append("						   and  CHG_OFC_CD          = SUB_T1.CHG_OFC_CD" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       ,DMDT_CHG_DELT_RSN_CD      = ''" ).append("\n"); 
		query.append("       ,CORR_RMK                  = ''" ).append("\n"); 
		query.append("       ,DMDT_CHG_DELT_SPEC_RSN_CD = ''" ).append("\n"); 
		query.append("       ,DELT_SPEC_RSN_RMK_SEQ     = null" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chg_delt_sts_cd} == 'J')" ).append("\n"); 
		query.append("       ,CALC_DT              = nvl(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), sysdate)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ,UPD_USR_ID	         = @[cre_usr_id]" ).append("\n"); 
		query.append("       ,UPD_DT		         = nvl(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), sysdate)" ).append("\n"); 
		query.append("       ,UPD_OFC_CD	         = @[cre_ofc_cd]" ).append("\n"); 
		query.append(" where  SYS_AREA_GRP_ID		= @[svr_id]" ).append("\n"); 
		query.append("   and  CNTR_NO				= @[cntr_no]" ).append("\n"); 
		query.append("   and  CNTR_CYC_NO 		= @[cntr_cyc_no]" ).append("\n"); 
		query.append("   and  DMDT_TRF_CD 		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("   and  DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("   and  CHG_SEQ				= @[chg_seq]" ).append("\n"); 
		query.append("#if (${chg_delt_sts_cd} == 'A')   " ).append("\n"); 
		query.append("   and  DMDT_CHG_STS_CD 	not in ('I', 'D')" ).append("\n"); 
		query.append("#elseif (${chg_delt_sts_cd} == 'J')      " ).append("\n"); 
		query.append("   and  DMDT_CHG_STS_CD 	= 'D'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}