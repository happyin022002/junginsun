/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOCheckBasicTariffRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.09.11 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOCheckBasicTariffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Commodity Exception Tariff Creation - TariffRgn 조회
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOCheckBasicTariffRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cvrg_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOCheckBasicTariffRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append(", DMDT_TRF_CD" ).append("\n"); 
		query.append(", TRF_SEQ" ).append("\n"); 
		query.append(", CVRG_CONTI_CD" ).append("\n"); 
		query.append(", CVRG_CNT_CD" ).append("\n"); 
		query.append(", CVRG_RGN_CD" ).append("\n"); 
		query.append(", CVRG_STE_CD" ).append("\n"); 
		query.append(", CVRG_LOC_CD" ).append("\n"); 
		query.append(", CVRG_YD_CD" ).append("\n"); 
		query.append(", ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append(", ORG_DEST_CNT_CD" ).append("\n"); 
		query.append(", ORG_DEST_RGN_CD" ).append("\n"); 
		query.append(", ORG_DEST_STE_CD" ).append("\n"); 
		query.append(", ORG_DEST_LOC_CD" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", SUTH_CHN_USE_FLG" ).append("\n"); 
		query.append(", CFM_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", CRE_OFC_CD" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", UPD_OFC_CD" ).append("\n"); 
		query.append("FROM DMT_TRF_RGN" ).append("\n"); 
		query.append("WHERE DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND CVRG_CONTI_CD = @[cvrg_conti_cd]" ).append("\n"); 
		query.append("AND CVRG_CNT_CD = @[cvrg_cnt_cd]" ).append("\n"); 
		query.append("AND CVRG_RGN_CD = NVL(@[cvrg_rgn_cd],' ')" ).append("\n"); 
		query.append("AND CVRG_STE_CD = NVL(@[cvrg_ste_cd],' ')" ).append("\n"); 
		query.append("AND CVRG_LOC_CD = NVL(@[cvrg_loc_cd],' ')" ).append("\n"); 
		query.append("AND CVRG_YD_CD = NVL(@[cvrg_yd_cd], ' ')" ).append("\n"); 
		query.append("AND ORG_DEST_CONTI_CD = NVL(@[org_dest_conti_cd],' ')" ).append("\n"); 
		query.append("AND ORG_DEST_CNT_CD = NVL(@[org_dest_cnt_cd], ' ')" ).append("\n"); 
		query.append("AND ORG_DEST_RGN_CD = NVL(@[org_dest_rgn_cd], ' ')" ).append("\n"); 
		query.append("AND ORG_DEST_STE_CD = NVL(@[org_dest_ste_cd], ' ')" ).append("\n"); 
		query.append("AND ORG_DEST_LOC_CD = NVL(@[org_dest_loc_cd], ' ')" ).append("\n"); 
		query.append("AND CFM_FLG = 'Y'" ).append("\n"); 

	}
}