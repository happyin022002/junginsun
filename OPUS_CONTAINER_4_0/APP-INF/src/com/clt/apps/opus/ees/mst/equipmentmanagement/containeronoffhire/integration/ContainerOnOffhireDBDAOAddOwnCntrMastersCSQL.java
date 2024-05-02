/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOAddOwnCntrMastersCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.25
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.04.25 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOAddOwnCntrMastersCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Own Container 에 대해 S/N Range 만큼 마스터에 생성한다.
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOAddOwnCntrMastersCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mft_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plst_flr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_spec_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_cntr_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mft_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_hngr_rck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_cmpr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("range_count",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lot_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mft_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("unit_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mtrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_humid_ctrl_val_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOAddOwnCntrMastersCSQL").append("\n"); 
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
		query.append("INSERT INTO MST_CONTAINER" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  CNTR_NO           " ).append("\n"); 
		query.append(", SYS_AREA_GRP_ID           " ).append("\n"); 
		query.append(", AGMT_CTY_CD      " ).append("\n"); 
		query.append(", AGMT_SEQ        " ).append("\n"); 
		query.append(", VNDR_SEQ         " ).append("\n"); 
		query.append(", ONH_CNTR_STS_CD  " ).append("\n"); 
		query.append(", ONH_DT           " ).append("\n"); 
		query.append(", ONH_YD_CD        " ).append("\n"); 
		query.append(", CNTR_MTRL_CD     " ).append("\n"); 
		query.append(", FULL_FLG         " ).append("\n"); 
		query.append(", CNTR_STS_CD      " ).append("\n"); 
		query.append(", LST_STS_YD_CD    " ).append("\n"); 
		query.append(", LST_STS_SEQ      " ).append("\n"); 
		query.append(", CRNT_YD_CD       " ).append("\n"); 
		query.append(", LOC_CD           " ).append("\n"); 
		query.append(", SCC_CD           " ).append("\n"); 
		query.append(", LCC_CD           " ).append("\n"); 
		query.append(", ECC_CD           " ).append("\n"); 
		query.append(", RCC_CD           " ).append("\n"); 
		query.append(", CNMV_STS_CD      " ).append("\n"); 
		query.append(", ACIAC_DIV_CD     " ).append("\n"); 
		query.append(", CNTR_TPSZ_CD     " ).append("\n"); 
		query.append(", LSTM_CD          " ).append("\n"); 
		query.append(", MFTR_VNDR_SEQ    " ).append("\n"); 
		query.append(", MFT_DT           " ).append("\n"); 
		query.append(", CNTR_HNGR_RCK_CD " ).append("\n"); 
		query.append(", PLST_FLR_FLG  " ).append("\n"); 
		query.append(", CO_CRE_FLG   " ).append("\n"); 
		query.append(", OWNR_CO_CD       " ).append("\n"); 
		query.append(", CNTR_USE_CO_CD   " ).append("\n"); 
		query.append(", CRE_USR_ID       " ).append("\n"); 
		query.append(", CRE_DT           " ).append("\n"); 
		query.append(", UPD_USR_ID       " ).append("\n"); 
		query.append(", UPD_DT           " ).append("\n"); 
		query.append(", ONH_STS_SEQ" ).append("\n"); 
		query.append(", CNMV_DT" ).append("\n"); 
		query.append(", D2_PAYLD_FLG" ).append("\n"); 
		query.append(", RF_TP_CD" ).append("\n"); 
		query.append(", CNTR_SPEC_NO" ).append("\n"); 
		query.append(", CNMV_GDT" ).append("\n"); 
		query.append(", LOT_PLN_YR" ).append("\n"); 
		query.append(", LOT_LOC_CD" ).append("\n"); 
		query.append(", LOT_SEQ " ).append("\n"); 
		query.append(", RF_HUMID_CTRL_VAL_CD" ).append("\n"); 
		query.append(", RF_CMPR_CTNT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  MST_COMMON_PKG.MST_CNTR_CHK_DGT_FNC(@[lot_cntr_pfx_cd] ||ltrim(to_char(to_number(@[fm_ser_no])+level-1,'000000'))) AS CNTR_NO" ).append("\n"); 
		query.append(", B.AREA_CD		    AS SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(", @[agmt_cty_cd]	AS AGMT_CTY_CD" ).append("\n"); 
		query.append(", @[agmt_seq]		AS AGMT_SEQ" ).append("\n"); 
		query.append(", @[vndr_seq]		AS VNDR_SEQ" ).append("\n"); 
		query.append(", DECODE(@[lstm_cd],'OW','OWN','LSI') 		AS ONH_CNTR_STS_CD" ).append("\n"); 
		query.append(", TO_DATE(SUBSTR(@[de_dt], 1, 10),'YYYY-MM-DD')		    AS ONH_DT" ).append("\n"); 
		query.append(", B.YD_CD		    AS ONH_YD_CD" ).append("\n"); 
		query.append(", @[cntr_mtrl_cd]	AS CNTR_MTRL_CD" ).append("\n"); 
		query.append(", 'N'			    AS FULL_FLG" ).append("\n"); 
		query.append(", DECODE(@[lstm_cd],'OW','OWN','LSI')		AS CNTR_STS_CD" ).append("\n"); 
		query.append(", B.YD_CD		AS LST_STS_YD_CD" ).append("\n"); 
		query.append(", MST_CNTR_STS_HIS_SEQ.NEXTVAL			    AS LST_STS_SEQ		        " ).append("\n"); 
		query.append(", B.YD_CD		AS CRNT_YD_CD" ).append("\n"); 
		query.append(", B.LOC_CD		AS LOC_CD" ).append("\n"); 
		query.append(", B.SCC_CD		AS SCC_CD" ).append("\n"); 
		query.append(", B.LCC_CD		AS LCC_CD" ).append("\n"); 
		query.append(", B.ECC_CD		AS ECC_CD" ).append("\n"); 
		query.append(", B.RCC_CD		AS RCC_CD" ).append("\n"); 
		query.append(", 'MT'			AS CNMV_STS_CD" ).append("\n"); 
		query.append(", 'A'			AS ACIAC_DIV_CD" ).append("\n"); 
		query.append(", @[cntr_tpsz_cd]	AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", @[lstm_cd]		AS LSTM_CD" ).append("\n"); 
		query.append(", @[mft_vndr_seq]	AS MFTR_VNDR_SEQ" ).append("\n"); 
		query.append(", TO_DATE(SUBSTR(@[mft_dt], 1, 10),'YYYY-MM-DD')		    AS MFT_DT" ).append("\n"); 
		query.append(", @[cntr_hngr_rck_cd]	AS CNTR_HNGR_RCK_CD" ).append("\n"); 
		query.append(", @[plst_flr_flg]	AS PLST_FLR_FLG" ).append("\n"); 
		query.append(", 'Y'				AS CO_CRE_FLG" ).append("\n"); 
		query.append(", 'O'			    AS OWNR_CO_CD" ).append("\n"); 
		query.append(", 'O'			    AS CNTR_USE_CO_CD" ).append("\n"); 
		query.append(", @[cre_usr_id]		AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE		    AS CRE_DT" ).append("\n"); 
		query.append(", @[upd_usr_id]		AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE		    AS UPD_DT" ).append("\n"); 
		query.append(", MST_CNTR_STS_HIS_SEQ.NEXTVAL			    AS ONH_STS_SEQ" ).append("\n"); 
		query.append(", TO_DATE(@[de_dt],'YYYY-MM-DD HH24:MI')	AS CNMV_DT" ).append("\n"); 
		query.append(", DECODE(@[cntr_tpsz_cd],'D2','Y','N')      AS D2_PAYLD_FLG" ).append("\n"); 
		query.append(", @[unit_type]" ).append("\n"); 
		query.append(", @[cntr_spec_no]" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_CONV_FNC ( COM_CONSTANTMGR_PKG.COM_getBaseLocationCode_FNC(), TO_DATE(@[de_dt], 'YYYY-MM-DD HH24:MI'), 'GMT' )" ).append("\n"); 
		query.append(", @[lot_pln_yr]     AS LOT_PLN_YR" ).append("\n"); 
		query.append(", @[lot_loc_cd]	    AS LOT_LOC_CD" ).append("\n"); 
		query.append(", @[lot_seq]        AS LOT_SEQ" ).append("\n"); 
		query.append(", @[rf_humid_ctrl_val_cd]	AS RF_HUMID_CTRL_VAL_CD" ).append("\n"); 
		query.append(", @[rf_cmpr_ctnt]			AS RF_CMPR_CTNT" ).append("\n"); 
		query.append("FROM DUAL A," ).append("\n"); 
		query.append("     (        " ).append("\n"); 
		query.append("        SELECT  (SELECT CU.OFC_CD FROM COM_USER CU WHERE CU.USR_ID = @[cre_usr_id] AND ROWNUM = 1) AS OFC_CD" ).append("\n"); 
		query.append("                , ML.LOC_CD AS LOC_CD" ).append("\n"); 
		query.append("                , EC.RCC_CD AS RCC_CD" ).append("\n"); 
		query.append("                , EC.LCC_CD AS LCC_CD" ).append("\n"); 
		query.append("                , EC.ECC_CD AS ECC_CD" ).append("\n"); 
		query.append("                , EC.SCC_CD AS SCC_CD" ).append("\n"); 
		query.append("                , @[mft_yd_cd] AS YD_CD" ).append("\n"); 
		query.append("                , AR.SYS_AREA_GRP_ID AS AREA_CD" ).append("\n"); 
		query.append("         FROM MDM_EQ_ORZ_CHT EC, MDM_LOCATION ML, COM_SYS_AREA_GRP_ID AR" ).append("\n"); 
		query.append("        WHERE ML.LOC_CD               = SUBSTR(@[mft_yd_cd], 1, 5)" ).append("\n"); 
		query.append("          AND ML.SCC_CD               = EC.SCC_CD" ).append("\n"); 
		query.append("          AND SUBSTR(ML.LOC_CD, 1, 2) = AR.CNT_CD" ).append("\n"); 
		query.append("          AND AR.CO_IND_CD            = 'H'" ).append("\n"); 
		query.append("          AND ROWNUM                  = 1" ).append("\n"); 
		query.append("    )B" ).append("\n"); 
		query.append("CONNECT BY LEVEL <= @[range_count]" ).append("\n"); 

	}
}