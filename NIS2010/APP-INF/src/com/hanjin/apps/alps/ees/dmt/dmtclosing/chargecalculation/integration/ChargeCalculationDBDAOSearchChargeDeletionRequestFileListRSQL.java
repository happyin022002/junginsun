/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchChargeDeletionRequestFileListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.10 
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

public class ChargeCalculationDBDAOSearchChargeDeletionRequestFileListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchChargeDeletionRequestFileListRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchChargeDeletionRequestFileListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sys_area_grp_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchChargeDeletionRequestFileListRSQL").append("\n"); 
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
		query.append("select  T1.FILE_SAV_ID" ).append("\n"); 
		query.append(",T2.FILE_UPLD_NM     				as FILE_NM" ).append("\n"); 
		query.append(",T2.FILE_SZ_CAPA     				as FILE_SIZE" ).append("\n"); 
		query.append(",T2.FILE_PATH_URL    				as FILE_PATH" ).append("\n"); 
		query.append(",to_char(T2.UPD_DT, 'YYYY-MM-DD')   	as UPD_DT" ).append("\n"); 
		query.append("from  DMT_CHG_DELT_RQST_APRO  T0" ).append("\n"); 
		query.append(",DMT_CHG_DELT_RQST_FILE  T1" ).append("\n"); 
		query.append(",COM_UPLD_FILE           T2" ).append("\n"); 
		query.append("where  T0.SYS_AREA_GRP_ID  	= @[sys_area_grp_id]" ).append("\n"); 
		query.append("and  T0.CNTR_NO 				= @[cntr_no]" ).append("\n"); 
		query.append("and  T0.CNTR_CYC_NO 			= to_number(@[cntr_cyc_no])" ).append("\n"); 
		query.append("and  T0.DMDT_TRF_CD 			= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("and  T0.DMDT_CHG_LOC_DIV_CD 	= @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("and  T0.CHG_SEQ 				= to_number(@[chg_seq])" ).append("\n"); 
		query.append("and  T0.CHG_OFC_CD 			= NVL(@[chg_ofc_cd],T0.CHG_OFC_CD)" ).append("\n"); 
		query.append("and  T0.DELT_SEQ 			= NVL(to_number(@[delt_seq]),T0.DELT_SEQ)" ).append("\n"); 
		query.append("AND  T0.DMDT_DELT_RQST_STS_CD = NVL(@[chg_delt_sts_cd],T0.DMDT_DELT_RQST_STS_CD)" ).append("\n"); 
		query.append("AND  T0.SYS_AREA_GRP_ID  	= T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("and  T0.CNTR_NO 				= T1.CNTR_NO" ).append("\n"); 
		query.append("and  T0.CNTR_CYC_NO 			= T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("and  T0.DMDT_TRF_CD 			= T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("and  T0.DMDT_CHG_LOC_DIV_CD 	= T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("and  T0.CHG_SEQ 				= T1.CHG_SEQ" ).append("\n"); 
		query.append("and  T0.CHG_OFC_CD 			= T1.CHG_OFC_CD" ).append("\n"); 
		query.append("and  T0.DELT_SEQ 			= T1.DELT_SEQ" ).append("\n"); 
		query.append("and  T1.FILE_SAV_ID          = T2.FILE_SAV_ID" ).append("\n"); 
		query.append("and  T2.DELT_FLG             = 'N'" ).append("\n"); 

	}
}