/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchBasicTariffGrpRSQL.java
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

public class DemDetTariffMgtDBDAOSearchBasicTariffGrpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic Tariff Creation
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchBasicTariffGrpRSQL(){
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
		query.append("FileName : DemDetTariffMgtDBDAOSearchBasicTariffGrpRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT B.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append(", B.DMDT_TRF_CD" ).append("\n"); 
		query.append(", B.TRF_SEQ" ).append("\n"); 
		query.append(", B.TRF_GRP_SEQ" ).append("\n"); 
		query.append(", B.DMDT_BZC_TRF_GRP_NM" ).append("\n"); 
		query.append(", TO_CHAR(B.EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append(", B.DMDT_TRF_GRP_TP_CD" ).append("\n"); 
		query.append(", NVL(TO_CHAR(B.EXP_DT,'YYYY-MM-DD'), ' ') AS EXP_DT" ).append("\n"); 
		query.append(", B.XCLD_SAT_FLG" ).append("\n"); 
		query.append(", B.XCLD_SUN_FLG" ).append("\n"); 
		query.append(", B.XCLD_HOL_FLG" ).append("\n"); 
		query.append(", B.DMDT_CHG_CMNC_TP_CD" ).append("\n"); 
		query.append(", B.CMNC_HR" ).append("\n"); 
		query.append(", B.CURR_CD" ).append("\n"); 
		query.append("FROM DMT_TRF_RGN A, DMT_TRF_GRP B, DMT_TRF_CMB C" ).append("\n"); 
		query.append("WHERE A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND A.DMDT_TRF_CD = B.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND A.TRF_SEQ = B.TRF_SEQ" ).append("\n"); 
		query.append("AND B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND B.DMDT_TRF_CD = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND B.TRF_SEQ = C.TRF_SEQ" ).append("\n"); 
		query.append("AND B.TRF_GRP_SEQ = C.TRF_GRP_SEQ" ).append("\n"); 
		query.append("AND A.DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND A.CVRG_CONTI_CD = @[cvrg_conti_cd]" ).append("\n"); 
		query.append("AND A.CVRG_CNT_CD = NVL(@[cvrg_cnt_cd],' ')" ).append("\n"); 
		query.append("AND A.CVRG_RGN_CD = NVL(@[cvrg_rgn_cd],' ')" ).append("\n"); 
		query.append("AND A.CVRG_STE_CD = NVL(@[cvrg_ste_cd],' ')" ).append("\n"); 
		query.append("AND A.CVRG_LOC_CD = NVL(@[cvrg_loc_cd],' ')" ).append("\n"); 
		query.append("AND A.CVRG_YD_CD = NVL(@[cvrg_yd_cd],' ')" ).append("\n"); 
		query.append("AND A.ORG_DEST_CONTI_CD = @[org_dest_conti_cd]" ).append("\n"); 
		query.append("AND A.ORG_DEST_CNT_CD = NVL(@[org_dest_cnt_cd],' ')" ).append("\n"); 
		query.append("AND A.ORG_DEST_RGN_CD = NVL(@[org_dest_rgn_cd],' ')" ).append("\n"); 
		query.append("AND A.ORG_DEST_STE_CD = NVL(@[org_dest_ste_cd],' ')" ).append("\n"); 
		query.append("AND A.ORG_DEST_LOC_CD = NVL(@[org_dest_loc_cd],' ')" ).append("\n"); 
		query.append("AND B.EXP_DT IS NULL" ).append("\n"); 
		query.append("AND C.TRF_GRP_SEQ = (SELECT MAX(TRF_GRP_SEQ) FROM DMT_TRF_CMB" ).append("\n"); 
		query.append("WHERE C.SYS_AREA_GRP_ID = SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD = DMDT_TRF_CD" ).append("\n"); 
		query.append("AND C.TRF_SEQ = TRF_SEQ" ).append("\n"); 
		query.append("AND C.DMDT_CNTR_TP_CD = DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("AND C.DMDT_CGO_TP_CD = DMDT_CGO_TP_CD)" ).append("\n"); 

	}
}