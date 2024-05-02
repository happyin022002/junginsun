/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchChargeDeletionRequestRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.17 
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

public class ChargeCalculationDBDAOSearchChargeDeletionRequestRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request 된 Charge Deletion 정보를 수정한다.
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchChargeDeletionRequestRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_delt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_delt_proc_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_delt_path_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchChargeDeletionRequestRSQL").append("\n"); 
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
		query.append("select  distinct" ).append("\n"); 
		query.append("	    C.SYS_AREA_GRP_ID 										as SVR_ID" ).append("\n"); 
		query.append("       ,C.CNTR_CYC_NO" ).append("\n"); 
		query.append("       ,C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("       ,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("       ,B.BKG_NO" ).append("\n"); 
		query.append("       ,C.OFC_CD" ).append("\n"); 
		query.append("       ,C.CHG_SEQ" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("			select  INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("			  from  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("             where  INTG_CD_ID = 'CD03382'" ).append("\n"); 
		query.append("               and  INTG_CD_VAL_CTNT = DD.DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("        )														as CHG_DELT_PROC_STS		--// R:Request, B:BB Approval, E:BB Reject, Q:RHQ Approval, F:RHQ Reject, H:HO Approval, G:HO Reject" ).append("\n"); 
		query.append("	   ,case " ).append("\n"); 
		query.append("			when DD.DELT_SPEC_RSN_RMK_SEQ is null " ).append("\n"); 
		query.append("				then 'N'" ).append("\n"); 
		query.append("				else 'Y' " ).append("\n"); 
		query.append("        end														as DELT_SPEC_RSN_RMK_YN" ).append("\n"); 
		query.append("	   ,DD.DELT_SPEC_RSN_RMK_SEQ" ).append("\n"); 
		query.append("       ,C.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("       ,C.CNTR_NO" ).append("\n"); 
		query.append("       ,B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,DD.RQST_USR_ID" ).append("\n"); 
		query.append("       ,DD.RQST_OFC_CD" ).append("\n"); 
		query.append("       ,DD.RQST_DT" ).append("\n"); 
		query.append("       ,DD.DMDT_CHG_DELT_RSN_CD" ).append("\n"); 
		query.append("       ,DD.DMDT_CHG_DELT_SPEC_RSN_CD" ).append("\n"); 
		query.append("       ,DD.DELT_SPEC_RSN_RMK_SEQ" ).append("\n"); 
		query.append("	   ,( " ).append("\n"); 
		query.append("			select  INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("			  from  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("             where  INTG_CD_ID = 'CD01965'" ).append("\n"); 
		query.append("               and  INTG_CD_VAL_CTNT = DD.DMDT_CHG_DELT_RSN_CD" ).append("\n"); 
		query.append("        )  														as DELT_RSN_DESC" ).append("\n"); 
		query.append("       ,DD.DELT_SEQ" ).append("\n"); 
		query.append("       ,DD.DELT_RMK AS CORR_RMK" ).append("\n"); 
		query.append("       ,C.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("       ,C.TO_MVMT_YD_CD" ).append("\n"); 
		query.append("       ,C.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("       ,C.TO_MVMT_STS_CD	" ).append("\n"); 
		query.append("       ,C.FT_DYS" ).append("\n"); 
		query.append("       ,C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("       ,to_char(C.FM_MVMT_DT, 'YYYYMMDD') 						as FM_MVMT_DT" ).append("\n"); 
		query.append("       ,to_char(C.TO_MVMT_DT, 'YYYYMMDD') 						as TO_MVMT_DT" ).append("\n"); 
		query.append("       ,to_char(C.FT_CMNC_DT, 'YYYYMMDD') 						as FT_CMNC_DT" ).append("\n"); 
		query.append("       ,to_char(C.FT_END_DT, 'YYYYMMDD') 						as FT_END_DT	" ).append("\n"); 
		query.append("       ,C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("       ,C.ORG_CHG_AMT" ).append("\n"); 
		query.append("       ,C.SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("       ,C.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("       ,C.BIL_AMT	" ).append("\n"); 
		query.append("       ,decode(C.CHG_SEQ, 1, 'G', 'B') 							as GEN_BAL" ).append("\n"); 
		query.append("       ,nvl(B.SOC_FLG, 'N') AS SOC_FLG" ).append("\n"); 
		query.append("       ,case" ).append("\n"); 
		query.append("		when C.DMDT_TRF_CD='DMIF' and C.TO_MVMT_STS_CD = 'ID' then 'L'" ).append("\n"); 
		query.append("        when C.DMDT_TRF_CD='DMIF' and C.TO_MVMT_STS_CD not in ('ID','CS','DR') then 'I'" ).append("\n"); 
		query.append("        when C.DMDT_TRF_CD='DMOF' and C.DMDT_CHG_LOC_DIV_CD <> 'POL' then 'L'" ).append("\n"); 
		query.append("        when C.DMDT_TRF_CD='DMOF' and C.DMDT_CHG_LOC_DIV_CD = 'POL' then 'I'" ).append("\n"); 
		query.append("	    end 													as LI" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			select  nvl(HLG_TP_CD, 'N')      /* 'C'ARRIER, 'M'ERCHANT, 'N'ULL */" ).append("\n"); 
		query.append("			  from  BKG_EUR_TRO" ).append("\n"); 
		query.append("    	     where  BKG_NO	= B.BKG_NO" ).append("\n"); 
		query.append("    	       and  IO_BND_CD	= substr(C.DMDT_TRF_CD, 3, 1)    /* IN/OUT BOUND */" ).append("\n"); 
		query.append("    	       and  nvl(CXL_FLG, 'N')    = 'N'" ).append("\n"); 
		query.append("    	       and  CNTR_NO	= C.CNTR_NO" ).append("\n"); 
		query.append("    	       and	ROWNUM = 1" ).append("\n"); 
		query.append("        ) 														as CH" ).append("\n"); 
		query.append("	   ,(	" ).append("\n"); 
		query.append("			select  'Y' 	  " ).append("\n"); 
		query.append("			  from  DUAL" ).append("\n"); 
		query.append("			 where  exists" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						select  BDD.RLSE_STS_CD" ).append("\n"); 
		query.append("						  from  BKG_DO BDO" ).append("\n"); 
		query.append("            		           ,BKG_DO_DTL BDD" ).append("\n"); 
		query.append("    		             where  BDO.BKG_NO = BDD.BKG_NO" ).append("\n"); 
		query.append("    	                   and  BDO.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    		               and  BDD.RLSE_STS_CD in ('R', 'I')) " ).append("\n"); 
		query.append("        ) 														as D_O" ).append("\n"); 
		query.append("	   ,(	" ).append("\n"); 
		query.append("			select  BDD.EVNT_OFC_CD" ).append("\n"); 
		query.append("			  from  BKG_DO     BDO" ).append("\n"); 
		query.append("				   ,BKG_DO_DTL BDD" ).append("\n"); 
		query.append("			 where  BDO.BKG_NO = BDD.BKG_NO" ).append("\n"); 
		query.append("   		       and  BDO.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    	       and  BDD.RLSE_STS_CD in ('R', 'I')" ).append("\n"); 
		query.append("    	       and  ROWNUM = 1 " ).append("\n"); 
		query.append("        ) 														as RLSE_OFC" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			select  BR.CLT_OFC_CD   " ).append("\n"); 
		query.append("			  from  BKG_RATE BR " ).append("\n"); 
		query.append("			 where  BR.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("	    ) 														as CLT_OFC_CD	" ).append("\n"); 
		query.append("	   ,nvl(C.OFC_TRNS_FLG, 'N') 								as OFC_TRNS_FLG" ).append("\n"); 
		query.append("	   ,(	" ).append("\n"); 
		query.append("			select  'C'   " ).append("\n"); 
		query.append("			  from  DUAL" ).append("\n"); 
		query.append("			 where  exists" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						select  1" ).append("\n"); 
		query.append("    		              from  BKG_ROLL_OVR R" ).append("\n"); 
		query.append("						 where  R.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    		               and  R.ROLL_OVR_RSN_CD IN ( 'C','H' )" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("		) 														as ROLL_OVR" ).append("\n"); 
		query.append("	   ,C.DMDT_INV_NO" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			select  to_char(IM.CRE_DT, 'YYYYMMDD') " ).append("\n"); 
		query.append("			  from  DMT_INV_MN 	IM" ).append("\n"); 
		query.append("			       ,DMT_INV_DTL ID" ).append("\n"); 
		query.append("	         where  IM.BKG_NO	= B.BKG_NO " ).append("\n"); 
		query.append("	           and  IM.DMDT_INV_NO = ID.DMDT_INV_NO" ).append("\n"); 
		query.append("	           and  IM.CRE_OFC_CD  = ID.CRE_OFC_CD" ).append("\n"); 
		query.append("	           and  IM.DMDT_INV_STS_CD = 'I'   " ).append("\n"); 
		query.append("	           and  ID.CNTR_NO  = DD.CNTR_NO" ).append("\n"); 
		query.append("	           and  ID.CNTR_CYC_NO = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("	           and  ID.DMDT_TRF_CD = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("	           and  ID.DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	           and  ID.CHG_SEQ = DD.CHG_SEQ      " ).append("\n"); 
		query.append("		) 														as ISS_DT" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			select  IM.INV_CURR_CD    " ).append("\n"); 
		query.append("			  from  DMT_INV_MN 	IM" ).append("\n"); 
		query.append("			       ,DMT_INV_DTL ID" ).append("\n"); 
		query.append("		     where  IM.BKG_NO	= B.BKG_NO " ).append("\n"); 
		query.append("               and  IM.DMDT_INV_NO(+)= ID.DMDT_INV_NO" ).append("\n"); 
		query.append("	           and  IM.CRE_OFC_CD(+) = ID.CRE_OFC_CD" ).append("\n"); 
		query.append("	           and  IM.DMDT_INV_STS_CD = 'I' " ).append("\n"); 
		query.append("               and  ID.CNTR_NO  = DD.CNTR_NO" ).append("\n"); 
		query.append("               and  ID.CNTR_CYC_NO = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("               and  ID.DMDT_TRF_CD = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("               and  ID.DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("               and  ID.CHG_SEQ = DD.CHG_SEQ   " ).append("\n"); 
		query.append("		) 														as INV_CURR_CD" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			select  ID.CNTR_INV_AMT " ).append("\n"); 
		query.append("			  from  DMT_INV_MN 	IM" ).append("\n"); 
		query.append("			       ,DMT_INV_DTL ID" ).append("\n"); 
		query.append("			 where  IM.BKG_NO	= B.BKG_NO " ).append("\n"); 
		query.append("               and  IM.DMDT_INV_NO(+) = ID.DMDT_INV_NO" ).append("\n"); 
		query.append("	           and  IM.CRE_OFC_CD(+) = ID.CRE_OFC_CD" ).append("\n"); 
		query.append("	           and  IM.DMDT_INV_STS_CD = 'I'" ).append("\n"); 
		query.append("               and  ID.CNTR_NO  = DD.CNTR_NO" ).append("\n"); 
		query.append("               and  ID.CNTR_CYC_NO = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("               and  ID.DMDT_TRF_CD = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("               and  ID.DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("               and  ID.CHG_SEQ = DD.CHG_SEQ    " ).append("\n"); 
		query.append("		) 														as CNTR_INV_AMT" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			select IM.DMDT_AR_IF_CD" ).append("\n"); 
		query.append("			  from   DMT_INV_MN IM" ).append("\n"); 
		query.append("					,DMT_INV_DTL ID" ).append("\n"); 
		query.append("			 where  IM.BKG_NO	= B.BKG_NO " ).append("\n"); 
		query.append("               and  IM.DMDT_INV_NO(+) = ID.DMDT_INV_NO" ).append("\n"); 
		query.append("	           and  IM.CRE_OFC_CD(+) = ID.CRE_OFC_CD" ).append("\n"); 
		query.append("	           and  IM.DMDT_INV_STS_CD = 'I'" ).append("\n"); 
		query.append("               and  ID.CNTR_NO  = DD.CNTR_NO" ).append("\n"); 
		query.append("               and  ID.CNTR_CYC_NO = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("               and  ID.DMDT_TRF_CD = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("               and  ID.DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("               and  ID.CHG_SEQ = DD.CHG_SEQ    " ).append("\n"); 
		query.append("		)														as DMDT_AR_IF_CD" ).append("\n"); 
		query.append("	   ,case" ).append("\n"); 
		query.append("			when decode(@[chg_delt_path_cd], 'BBG', 1, 'RHQ', 2, 'HDO', 3, 0) >= " ).append("\n"); 
		query.append("				 (" ).append("\n"); 
		query.append("					select  max(CHG_DELT_PATH_LVL)" ).append("\n"); 
		query.append("					  from  DMT_CHG_DELT_PATH" ).append("\n"); 
		query.append("					 where  SYS_AREA_GRP_ID        = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("					   and  CNTR_NO                = DD.CNTR_NO" ).append("\n"); 
		query.append("					   and  CNTR_CYC_NO            = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("					   and  DMDT_TRF_CD            = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("					   and  DMDT_CHG_LOC_DIV_CD    = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("					   and  CHG_SEQ                = DD.CHG_SEQ" ).append("\n"); 
		query.append("					   and  CHG_OFC_CD             = DD.CHG_OFC_CD" ).append("\n"); 
		query.append("					   and  DELT_SEQ               = DD.DELT_SEQ" ).append("\n"); 
		query.append("					   and  (CHG_DELT_PATH_CPLS_FLG = 'Y' or CHG_DELT_STS_CD in ('A', 'J'))" ).append("\n"); 
		query.append("				 ) " ).append("\n"); 
		query.append("				 then " ).append("\n"); 
		query.append("				 (" ).append("\n"); 
		query.append("					case " ).append("\n"); 
		query.append("						when @[chg_delt_path_cd] = 'RHQ' and DD.RQST_OFC_CD in ('ATLSC', 'CHISC', 'HOUSC', 'LGBSC', 'SFOSO', 'NYCSC', 'OREBS', 'PDXSO', 'SEASC', 'PHXSA') then" ).append("\n"); 
		query.append("							case when @[chg_delt_usr_id] IN ( SELECT ATTR_CTNT1 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'USA_DELT_USER_LIST' ) then 'Y' else 'N' end" ).append("\n"); 
		query.append("						else" ).append("\n"); 
		query.append("							'Y'" ).append("\n"); 
		query.append("					end" ).append("\n"); 
		query.append("				 )" ).append("\n"); 
		query.append("			else" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				select  case" ).append("\n"); 
		query.append("							when count(1) > 0 then" ).append("\n"); 
		query.append("								case " ).append("\n"); 
		query.append("									when @[chg_delt_path_cd] = 'RHQ' and DD.RQST_OFC_CD in ('ATLSC', 'CHISC', 'HOUSC', 'LGBSC', 'SFOSO', 'NYCSC', 'OREBS', 'PDXSO', 'SEASC', 'PHXSA') then" ).append("\n"); 
		query.append("										case when @[chg_delt_usr_id] IN ( SELECT ATTR_CTNT1 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'USA_DELT_USER_LIST' ) then 'Y' else 'N' end" ).append("\n"); 
		query.append("									else" ).append("\n"); 
		query.append("										'Y'" ).append("\n"); 
		query.append("								end								" ).append("\n"); 
		query.append("							else" ).append("\n"); 
		query.append("								'N'" ).append("\n"); 
		query.append("						end" ).append("\n"); 
		query.append("				  from  DMT_CHG_DELT_PATH" ).append("\n"); 
		query.append("				 where  SYS_AREA_GRP_ID        = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("				   and  CNTR_NO                = DD.CNTR_NO" ).append("\n"); 
		query.append("				   and  CNTR_CYC_NO            = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("				   and  DMDT_TRF_CD            = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("				   and  DMDT_CHG_LOC_DIV_CD    = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("				   and  CHG_SEQ                = DD.CHG_SEQ" ).append("\n"); 
		query.append("				   and  CHG_OFC_CD             = DD.CHG_OFC_CD" ).append("\n"); 
		query.append("				   and  DELT_SEQ               = DD.DELT_SEQ" ).append("\n"); 
		query.append("				   and  CHG_DELT_PATH_CD       = @[chg_delt_path_cd]" ).append("\n"); 
		query.append("				   and  CHG_DELT_PATH_LVL     >= decode(DD.DMDT_DELT_RQST_STS_CD, 'R', 1, 'B', 1, 'E', 1, 'Q', 2, 'F', 2, 'H', 3, 'G', 3, 0)" ).append("\n"); 
		query.append("				   and  CHG_DELT_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		end													as CHG_DELT_USR_YN		--// Charge Deletion 요청에 대해 승인권한자인지 여부를 나타낸다." ).append("\n"); 
		query.append("       ,B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD			as VVD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  from  DMT_CHG_DELT_RQST_APRO 	DD" ).append("\n"); 
		query.append("       ,DMT_CHG_BKG_CNTR 		B" ).append("\n"); 
		query.append("       ,DMT_CHG_CALC 			C" ).append("\n"); 
		query.append(" where  DD.SYS_AREA_GRP_ID 		= C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   and  DD.CNTR_NO         		= C.CNTR_NO" ).append("\n"); 
		query.append("   and  DD.CNTR_CYC_NO     		= C.CNTR_CYC_NO" ).append("\n"); 
		query.append("   and  DD.DMDT_TRF_CD      	= C.DMDT_TRF_CD" ).append("\n"); 
		query.append("   and  DD.DMDT_CHG_LOC_DIV_CD 	= C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("   and  DD.CHG_SEQ 				= C.CHG_SEQ" ).append("\n"); 
		query.append("   and  DD.CHG_OFC_CD           = C.OFC_CD" ).append("\n"); 
		query.append("   and  DD.DELT_SEQ             = " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("			select  max(DELT_SEQ)" ).append("\n"); 
		query.append("              from  DMT_CHG_DELT_RQST_APRO" ).append("\n"); 
		query.append("			 where  SYS_AREA_GRP_ID 	= DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			   and  CNTR_NO         	= DD.CNTR_NO" ).append("\n"); 
		query.append("			   and  CNTR_CYC_NO     	= DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   and  DMDT_TRF_CD      	= DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("			   and  DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("			   and  CHG_SEQ 			= DD.CHG_SEQ" ).append("\n"); 
		query.append("			   and  CHG_OFC_CD          = DD.CHG_OFC_CD" ).append("\n"); 
		query.append("               AND  DMDT_DELT_RQST_STS_CD != 'C'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("   and  B.SYS_AREA_GRP_ID		= C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   and  B.CNTR_NO         		= C.CNTR_NO" ).append("\n"); 
		query.append("   and  B.CNTR_CYC_NO     		= C.CNTR_CYC_NO" ).append("\n"); 
		query.append("   and  C.DMDT_CHG_LOC_DIV_CD <> 'SZP'" ).append("\n"); 
		query.append("   and  not (C.DUL_TP_EXPT_FLG  = 'Y' AND substr(C.DMDT_TRF_CD, 1, 1) = 'D')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${dmdt_trf_cd} != '')   " ).append("\n"); 
		query.append("   and  DD.DMDT_TRF_CD           = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${chg_delt_proc_sts} != '')   " ).append("\n"); 
		query.append("   and  DD.DMDT_DELT_RQST_STS_CD = @[chg_delt_proc_sts]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("   and  DD.DMDT_DELT_RQST_STS_CD in ('R', 'B', 'E', 'Q', 'F', 'H', 'G')	--// R:Request, B:BB Approval, E:BB Reject, Q:RHQ Approval, F:RHQ Reject, H:HO Approval, G:HO Reject" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${apro_ofc_cd} != 'SELBB' && ${apro_ofc_cd} != 'TYOBB')" ).append("\n"); 
		query.append("	-- 2014.01.15 [CHM-201428544] Approval Office in ( SELBB/TYOBB 는 RHQ 레벨 ) 일 경우는 산하 Office를 Check 할 필요 없이  Approval Office만 확인하도록 한다." ).append("\n"); 
		query.append("   and  DD.CHG_OFC_CD in " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		  #foreach( $chg_ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $ofc_cd_list.size()) '$chg_ofc_cd', #else '$chg_ofc_cd' #end" ).append("\n"); 
		query.append("		  #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   and  DD.RQST_DT between to_date(replace(@[fm_dt],'-',''), 'yyyymmdd') AND to_date(replace(@[to_dt],'-',''), 'yyyymmdd') + 0.99999" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${bkg_no} != '')	" ).append("\n"); 
		query.append("   and  B.BKG_NO in " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		  #foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $bkg_no_list.size()) '$bkg_cd', #else '$bkg_cd' #end" ).append("\n"); 
		query.append("		  #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${vvd_cd} != '')	" ).append("\n"); 
		query.append("    and  B.VSL_CD     = substr(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("    and  B.SKD_VOY_NO = substr(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("    and  B.SKD_DIR_CD = substr(@[vvd_cd], 9)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("order by B.BKG_NO, C.CNTR_NO" ).append("\n"); 

	}
}