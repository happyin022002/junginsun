/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOAddOwnCntrMastersCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("range_count",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
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
		query.append("  CNTR_NO          " ).append("\n"); 
		query.append(", SYS_AREA_GRP_ID           " ).append("\n"); 
		query.append(", AGMT_CTY_CD      " ).append("\n"); 
		query.append(", AGMT_SEQ         " ).append("\n"); 
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
		query.append(", HJS_CRE_FLG   " ).append("\n"); 
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
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  MST_COMMON_PKG.MST_CNTR_CHK_DGT_FNC(@[lot_cntr_pfx_cd] ||ltrim(to_char(to_number(@[fm_ser_no])+level-1,'000000'))) AS CNTR_NO" ).append("\n"); 
		query.append(", 'KOR'			    AS SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(", @[agmt_cty_cd]	AS AGMT_CTY_CD" ).append("\n"); 
		query.append(", @[agmt_seq]		AS AGMT_SEQ" ).append("\n"); 
		query.append(", @[vndr_seq]		AS VNDR_SEQ" ).append("\n"); 
		query.append(", DECODE(@[lstm_cd],'OW','OWN','LSI') 		AS ONH_CNTR_STS_CD" ).append("\n"); 
		query.append(", TO_DATE(@[mft_dt],'YYYY-MM-DD')		    AS ONH_DT" ).append("\n"); 
		query.append(", 'KRSEL1H'		    AS ONH_YD_CD" ).append("\n"); 
		query.append(", @[cntr_mtrl_cd]	AS CNTR_MTRL_CD" ).append("\n"); 
		query.append(", 'N'			    AS FULL_FLG" ).append("\n"); 
		query.append(", DECODE(@[lstm_cd],'OW','OWN','LSI')		AS CNTR_STS_CD" ).append("\n"); 
		query.append(", 'KRSEL1H'		AS LST_STS_YD_CD" ).append("\n"); 
		query.append(", MST_CNTR_STS_HIS_SEQ.NEXTVAL			    AS LST_STS_SEQ		        " ).append("\n"); 
		query.append(", 'KRSEL1H'		AS CRNT_YD_CD" ).append("\n"); 
		query.append(", 'KRSEL'		AS LOC_CD" ).append("\n"); 
		query.append(", 'KRSEL'		AS SCC_CD" ).append("\n"); 
		query.append(", 'KRINC'		AS LCC_CD" ).append("\n"); 
		query.append(", 'KREIW'		AS ECC_CD" ).append("\n"); 
		query.append(", 'KRSEL'		AS RCC_CD" ).append("\n"); 
		query.append(", 'MT'			AS CNMV_STS_CD" ).append("\n"); 
		query.append(", 'I'			AS ACIAC_DIV_CD" ).append("\n"); 
		query.append(", @[cntr_tpsz_cd]	AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", @[lstm_cd]		AS LSTM_CD" ).append("\n"); 
		query.append(", @[mft_vndr_seq]	AS MFTR_VNDR_SEQ" ).append("\n"); 
		query.append(", TO_DATE(@[mft_dt],'YYYY-MM-DD')		    AS MFT_DT" ).append("\n"); 
		query.append(", @[cntr_hngr_rck_cd]	AS CNTR_HNGR_RCK_CD" ).append("\n"); 
		query.append(", @[plst_flr_flg]	AS PLST_FLR_FLG" ).append("\n"); 
		query.append(", 'Y'				AS HJS_CRE_FLG" ).append("\n"); 
		query.append(", 'H'			    AS OWNR_CO_CD" ).append("\n"); 
		query.append(", 'H'			    AS CNTR_USE_CO_CD" ).append("\n"); 
		query.append(", @[cre_usr_id]		AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE		    AS CRE_DT" ).append("\n"); 
		query.append(", @[upd_usr_id]		AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE		    AS UPD_DT" ).append("\n"); 
		query.append(", MST_CNTR_STS_HIS_SEQ.NEXTVAL			    AS ONH_STS_SEQ" ).append("\n"); 
		query.append(", TO_DATE(@[mft_dt],'YYYY-MM-DD')		    AS CNMV_DT" ).append("\n"); 
		query.append(", DECODE(@[cntr_tpsz_cd],'D2','N','N')      AS D2_PAYLD_FLG" ).append("\n"); 
		query.append(", @[unit_type]" ).append("\n"); 
		query.append(", @[cntr_spec_no]" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_CONV_FNC ( 'KRSEL', TO_DATE(@[mft_dt], 'YYYY-MM-DD HH24:MI'), 'GMT' )" ).append("\n"); 
		query.append("FROM DUAL A" ).append("\n"); 
		query.append("CONNECT BY LEVEL <= @[range_count]" ).append("\n"); 

	}
}