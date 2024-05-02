/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchCommodityTariffListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOSearchCommodityTariffListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Commodity Exception Tariff Creation - Retrieve
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchCommodityTariffListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchCommodityTariffListRSQL").append("\n"); 
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
		query.append("SELECT A.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append(", A.DMDT_TRF_CD" ).append("\n"); 
		query.append(", A.TRF_SEQ" ).append("\n"); 
		query.append(", A.CMDT_CD" ).append("\n"); 
		query.append(", C.CMDT_NM" ).append("\n"); 
		query.append(", C.REP_CMDT_CD" ).append("\n"); 
		query.append(", A.CMDT_TRF_SEQ" ).append("\n"); 
		query.append(", TO_CHAR(A.EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.EXP_DT,'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append(", A.CMDT_ADD_DYS" ).append("\n"); 
		query.append(", A.CMDT_TTL_DYS" ).append("\n"); 
		query.append(", DECODE(A.XCLD_SAT_FLG,'Y','1','0') AS XCLD_SAT_FLG" ).append("\n"); 
		query.append(", DECODE(A.XCLD_SUN_FLG,'Y','1','0') AS XCLD_SUN_FLG" ).append("\n"); 
		query.append(", DECODE(A.XCLD_HOL_FLG,'Y','1','0') AS XCLD_HOL_FLG" ).append("\n"); 
		query.append(", TO_CHAR(A.UPD_DT,'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append(", A.UPD_OFC_CD" ).append("\n"); 
		query.append(", A.UPD_USR_ID" ).append("\n"); 
		query.append(", (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.UPD_USR_ID) AS UPD_NAME" ).append("\n"); 
		query.append(", A.CMDT_RMK" ).append("\n"); 
		query.append(", A.DELT_FLG" ).append("\n"); 
		query.append(", '' USR_ID" ).append("\n"); 
		query.append(", '' OFC_CD" ).append("\n"); 
		query.append(", '' RETURN_CD" ).append("\n"); 
		query.append(", '' RETURN_MSG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", A.TRF_RULE_NO" ).append("\n"); 
		query.append(", A.TRF_MNG_USR_ID" ).append("\n"); 
		query.append(", (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.TRF_MNG_USR_ID) AS TRF_MNG_USR_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NVL((" ).append("\n"); 
		query.append("SELECT TRF_EXP_NTC_OFC_CD" ).append("\n"); 
		query.append("FROM DMT_TRF_EXP_NTC_OFC" ).append("\n"); 
		query.append("WHERE IO_BND_CD = SUBSTR(B.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("AND CVRG_LOC_CD = B.CVRG_LOC_CD" ).append("\n"); 
		query.append("AND ORG_DEST_CONTI_CD = B.ORG_DEST_CONTI_CD ), NVL((" ).append("\n"); 
		query.append("SELECT TRF_EXP_NTC_OFC_CD" ).append("\n"); 
		query.append("FROM DMT_TRF_EXP_NTC_OFC" ).append("\n"); 
		query.append("WHERE IO_BND_CD = SUBSTR(B.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("AND CVRG_STE_CD = B.CVRG_STE_CD" ).append("\n"); 
		query.append("AND CVRG_LOC_CD IS NULL" ).append("\n"); 
		query.append("AND ORG_DEST_CONTI_CD = B.ORG_DEST_CONTI_CD ), NVL((" ).append("\n"); 
		query.append("SELECT TRF_EXP_NTC_OFC_CD" ).append("\n"); 
		query.append("FROM DMT_TRF_EXP_NTC_OFC" ).append("\n"); 
		query.append("WHERE IO_BND_CD = SUBSTR(B.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("AND CVRG_RGN_CD = B.CVRG_RGN_CD" ).append("\n"); 
		query.append("AND CVRG_STE_CD IS NULL" ).append("\n"); 
		query.append("AND CVRG_LOC_CD IS NULL" ).append("\n"); 
		query.append("AND ORG_DEST_CONTI_CD = B.ORG_DEST_CONTI_CD ), NVL((" ).append("\n"); 
		query.append("SELECT TRF_EXP_NTC_OFC_CD" ).append("\n"); 
		query.append("FROM DMT_TRF_EXP_NTC_OFC" ).append("\n"); 
		query.append("WHERE IO_BND_CD = SUBSTR(B.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("AND CVRG_CNT_CD = B.CVRG_CNT_CD" ).append("\n"); 
		query.append("AND CVRG_RGN_CD IS NULL" ).append("\n"); 
		query.append("AND CVRG_STE_CD IS NULL" ).append("\n"); 
		query.append("AND CVRG_LOC_CD IS NULL" ).append("\n"); 
		query.append("AND ORG_DEST_CONTI_CD = B.ORG_DEST_CONTI_CD ), NVL((" ).append("\n"); 
		query.append("SELECT TRF_EXP_NTC_OFC_CD" ).append("\n"); 
		query.append("FROM DMT_TRF_EXP_NTC_OFC" ).append("\n"); 
		query.append("WHERE IO_BND_CD = SUBSTR(B.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("AND CVRG_CONTI_CD = CASE WHEN B.CVRG_CNT_CD IN ('DJ','SD','TZ','ZA' ) THEN 'A'" ).append("\n"); 
		query.append("ELSE B.CVRG_CONTI_CD END" ).append("\n"); 
		query.append("AND CVRG_CNT_CD IS NULL" ).append("\n"); 
		query.append("AND CVRG_RGN_CD IS NULL" ).append("\n"); 
		query.append("AND CVRG_STE_CD IS NULL" ).append("\n"); 
		query.append("AND CVRG_LOC_CD IS NULL" ).append("\n"); 
		query.append("AND ORG_DEST_CONTI_CD = B.ORG_DEST_CONTI_CD ), 'ERROR') ) ) ) ) AS PIC_TEAM" ).append("\n"); 
		query.append("FROM DMT_CMDT_GRP A, DMT_TRF_RGN B, MDM_COMMODITY C" ).append("\n"); 
		query.append("WHERE A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND A.DMDT_TRF_CD = B.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND A.TRF_SEQ = B.TRF_SEQ" ).append("\n"); 
		query.append("AND A.CMDT_CD = C.CMDT_CD" ).append("\n"); 
		query.append("AND A.DELT_FLG ='N'" ).append("\n"); 
		query.append("AND B.DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND B.CVRG_CONTI_CD = @[cvrg_conti_cd]" ).append("\n"); 
		query.append("AND B.CVRG_CNT_CD = @[cvrg_cnt_cd]" ).append("\n"); 
		query.append("AND B.CVRG_RGN_CD = NVL(@[cvrg_rgn_cd],' ')" ).append("\n"); 
		query.append("AND B.CVRG_STE_CD = NVL(@[cvrg_ste_cd],' ')" ).append("\n"); 
		query.append("AND B.CVRG_LOC_CD = NVL(@[cvrg_loc_cd],' ')" ).append("\n"); 
		query.append("AND B.CVRG_YD_CD = NVL(@[cvrg_yd_cd], ' ')" ).append("\n"); 
		query.append("AND B.ORG_DEST_CONTI_CD = NVL(@[org_dest_conti_cd],' ')" ).append("\n"); 
		query.append("AND B.ORG_DEST_CNT_CD = NVL(@[org_dest_cnt_cd], ' ')" ).append("\n"); 
		query.append("AND B.ORG_DEST_RGN_CD = NVL(@[org_dest_rgn_cd], ' ')" ).append("\n"); 
		query.append("AND B.ORG_DEST_STE_CD = NVL(@[org_dest_ste_cd], ' ')" ).append("\n"); 
		query.append("AND B.ORG_Dest_LOC_Cd = NVL(@[org_dest_loc_cd], ' ')" ).append("\n"); 
		query.append("ORDER BY A.CMDT_CD, A.EFF_DT" ).append("\n"); 

	}
}