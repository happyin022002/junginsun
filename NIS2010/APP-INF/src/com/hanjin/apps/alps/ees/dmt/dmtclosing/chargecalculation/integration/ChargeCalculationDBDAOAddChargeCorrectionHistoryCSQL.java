/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOAddChargeCorrectionHistoryCSQL.java
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

public class ChargeCalculationDBDAOAddChargeCorrectionHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOAddChargeCorrectionHistoryCSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOAddChargeCorrectionHistoryCSQL(){
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
		query.append("FileName : ChargeCalculationDBDAOAddChargeCorrectionHistoryCSQL").append("\n"); 
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
		query.append("insert into DMT_CHG_CORR_HIS(" ).append("\n"); 
		query.append("		SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("	   ,CNTR_NO" ).append("\n"); 
		query.append("	   ,CNTR_CYC_NO" ).append("\n"); 
		query.append("	   ,DMDT_TRF_CD" ).append("\n"); 
		query.append("	   ,DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	   ,CHG_SEQ" ).append("\n"); 
		query.append("	   ,CORR_HIS_SEQ" ).append("\n"); 
		query.append("	   ,FM_MVMT_STS_CD" ).append("\n"); 
		query.append("	   ,FM_MVMT_DT" ).append("\n"); 
		query.append("	   ,FM_YD_CD" ).append("\n"); 
		query.append("	   ,TO_MVMT_STS_CD" ).append("\n"); 
		query.append("	   ,TO_MVMT_DT" ).append("\n"); 
		query.append("	   ,TO_YD_CD" ).append("\n"); 
		query.append("	   ,CHG_STS_CD" ).append("\n"); 
		query.append("	   ,BKG_NO" ).append("\n"); 
		query.append("	   ,WEB_CRE_USR_ID" ).append("\n"); 
		query.append("	   ,WEB_CRE_DT" ).append("\n"); 
		query.append("	   ,WEB_MTY_DT" ).append("\n"); 
		query.append("	   ,WEB_NTFY_PIC_NM" ).append("\n"); 
		query.append("	   ,CORR_HIS_RMK" ).append("\n"); 
		query.append("	   ,CRE_USR_ID" ).append("\n"); 
		query.append("	   ,CRE_DT" ).append("\n"); 
		query.append("	   ,CRE_OFC_CD" ).append("\n"); 
		query.append("	   ,UPD_USR_ID" ).append("\n"); 
		query.append("	   ,UPD_DT" ).append("\n"); 
		query.append("	   ,UPD_OFC_CD	" ).append("\n"); 
		query.append("	   ,UCLM_FLG	" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select  T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("       ,T1.CNTR_NO" ).append("\n"); 
		query.append("       ,T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("       ,T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("       ,T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("       ,T1.CHG_SEQ" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("			select  nvl(max(CORR_HIS_SEQ), 0) + 1" ).append("\n"); 
		query.append("			  from  DMT_CHG_CORR_HIS" ).append("\n"); 
		query.append("			 where  SYS_AREA_GRP_ID		= T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			   and  CNTR_NO				= T1.CNTR_NO" ).append("\n"); 
		query.append("			   and  CNTR_CYC_NO			= T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   and  DMDT_TRF_CD			= T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("			   and  DMDT_CHG_LOC_DIV_CD = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("			   and  CHG_SEQ				= T1.CHG_SEQ" ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append("       ,T1.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("       ,T1.FM_MVMT_DT" ).append("\n"); 
		query.append("       ,T1.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("       ,T1.TO_MVMT_STS_CD" ).append("\n"); 
		query.append("       ,T1.TO_MVMT_DT" ).append("\n"); 
		query.append("       ,T1.TO_MVMT_YD_CD" ).append("\n"); 
		query.append("       ,T1.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("       ,T2.BKG_NO" ).append("\n"); 
		query.append("       ,T1.WEB_CRE_USR_ID" ).append("\n"); 
		query.append("       ,T1.WEB_CRE_DT" ).append("\n"); 
		query.append("       ,T1.WEB_MTY_DT" ).append("\n"); 
		query.append("       ,T1.WEB_NTFY_PIC_NM" ).append("\n"); 
		query.append("       ,case" ).append("\n"); 
		query.append("			when (" ).append("\n"); 
		query.append("					select  count(1)" ).append("\n"); 
		query.append("					  from  DMT_CHG_CORR_HIS" ).append("\n"); 
		query.append("					 where  SYS_AREA_GRP_ID		= T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("					   and  CNTR_NO				= T1.CNTR_NO" ).append("\n"); 
		query.append("					   and  CNTR_CYC_NO			= T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("					   and  DMDT_TRF_CD			= T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("					   and  DMDT_CHG_LOC_DIV_CD = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("					   and  CHG_SEQ				= T1.CHG_SEQ" ).append("\n"); 
		query.append("				 ) = 0 " ).append("\n"); 
		query.append("			then T1.CORR_RMK " ).append("\n"); 
		query.append("			else 'Charge Deletion ' || decode(@[chg_delt_sts_cd], 'A', 'Approval', 'J', 'Reject')" ).append("\n"); 
		query.append("		end" ).append("\n"); 
		query.append("       ,case" ).append("\n"); 
		query.append("			when (" ).append("\n"); 
		query.append("					select  count(1)" ).append("\n"); 
		query.append("					  from  DMT_CHG_CORR_HIS" ).append("\n"); 
		query.append("					 where  SYS_AREA_GRP_ID		= T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("					   and  CNTR_NO				= T1.CNTR_NO" ).append("\n"); 
		query.append("					   and  CNTR_CYC_NO			= T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("					   and  DMDT_TRF_CD			= T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("					   and  DMDT_CHG_LOC_DIV_CD = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("					   and  CHG_SEQ				= T1.CHG_SEQ" ).append("\n"); 
		query.append("				 ) = 0 " ).append("\n"); 
		query.append("			then T1.CRE_USR_ID " ).append("\n"); 
		query.append("			else @[cre_usr_id]" ).append("\n"); 
		query.append("		end" ).append("\n"); 
		query.append("       ,case" ).append("\n"); 
		query.append("			when (" ).append("\n"); 
		query.append("					select  count(1)" ).append("\n"); 
		query.append("					  from  DMT_CHG_CORR_HIS" ).append("\n"); 
		query.append("					 where  SYS_AREA_GRP_ID		= T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("					   and  CNTR_NO				= T1.CNTR_NO" ).append("\n"); 
		query.append("					   and  CNTR_CYC_NO			= T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("					   and  DMDT_TRF_CD			= T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("					   and  DMDT_CHG_LOC_DIV_CD = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("					   and  CHG_SEQ				= T1.CHG_SEQ" ).append("\n"); 
		query.append("				 ) = 0 " ).append("\n"); 
		query.append("			then T1.CRE_DT" ).append("\n"); 
		query.append("			else nvl(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), sysdate)" ).append("\n"); 
		query.append("		end" ).append("\n"); 
		query.append("       ,case" ).append("\n"); 
		query.append("			when (" ).append("\n"); 
		query.append("					select  count(1)" ).append("\n"); 
		query.append("					  from  DMT_CHG_CORR_HIS" ).append("\n"); 
		query.append("					 where  SYS_AREA_GRP_ID		= T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("					   and  CNTR_NO				= T1.CNTR_NO" ).append("\n"); 
		query.append("					   and  CNTR_CYC_NO			= T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("					   and  DMDT_TRF_CD			= T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("					   and  DMDT_CHG_LOC_DIV_CD = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("					   and  CHG_SEQ				= T1.CHG_SEQ" ).append("\n"); 
		query.append("				 ) = 0 " ).append("\n"); 
		query.append("			then T1.CRE_OFC_CD" ).append("\n"); 
		query.append("			else @[cre_ofc_cd]" ).append("\n"); 
		query.append("		end" ).append("\n"); 
		query.append("       ,@[cre_usr_id]" ).append("\n"); 
		query.append("       ,nvl(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), sysdate)" ).append("\n"); 
		query.append("       ,@[cre_ofc_cd]" ).append("\n"); 
		query.append("       ,T1.UCLM_FLG" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("  from  DMT_CHG_CALC      T1" ).append("\n"); 
		query.append("	   ,DMT_CHG_BKG_CNTR  T2" ).append("\n"); 
		query.append(" where  T1.SYS_AREA_GRP_ID	   = @[svr_id]" ).append("\n"); 
		query.append("   and  T1.CNTR_NO			   = @[cntr_no]" ).append("\n"); 
		query.append("   and  T1.CNTR_CYC_NO		   = to_number(@[cntr_cyc_no])" ).append("\n"); 
		query.append("   and  T1.DMDT_TRF_CD		   = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("   and  T1.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("   and  T1.CHG_SEQ			   = to_number(@[chg_seq])" ).append("\n"); 
		query.append("   and  T1.SYS_AREA_GRP_ID	   = T2.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   and  T1.CNTR_NO			   = T2.CNTR_NO" ).append("\n"); 
		query.append("   and  T1.CNTR_CYC_NO		   = T2.CNTR_CYC_NO" ).append("\n"); 

	}
}