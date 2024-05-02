/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchKorCllListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchKorCllListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchKorCllList
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchKorCllListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchKorCllListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	ROWNUM SEQ," ).append("\n"); 
		query.append("	VSL_CD," ).append("\n"); 
		query.append("	SKD_VOY_NO," ).append("\n"); 
		query.append("	SKD_DIR_CD," ).append("\n"); 
		query.append("	POL_CD," ).append("\n"); 
		query.append("	BKG_POL_CD," ).append("\n"); 
		query.append("	CNTR_NO," ).append("\n"); 
		query.append("	BL_NO," ).append("\n"); 
		query.append("	BKG_NO," ).append("\n"); 
		query.append("	CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	MTY_BKG_CD," ).append("\n"); 
		query.append("	SEAL_NO," ).append("\n"); 
		query.append("	BL_WGT, " ).append("\n"); 
		query.append("	WGT_UT_CD," ).append("\n"); 
		query.append("	RCV_TERM_CD," ).append("\n"); 
		query.append("	TS_FLG," ).append("\n"); 
		query.append("	IMDG_CLSS_CD," ).append("\n"); 
		query.append("	IMDG_UN_NO," ).append("\n"); 
		query.append("	CDO_TEMP," ).append("\n"); 
		query.append("	CNTR_VENT_CD," ).append("\n"); 
		query.append("	HAMO_TRF_CD," ).append("\n"); 
		query.append("	CMDT_HS_CD," ).append("\n"); 
		query.append("	CLL_RMK1," ).append("\n"); 
		query.append("	CLL_RMK2," ).append("\n"); 
		query.append("	POD_CD," ).append("\n"); 
		query.append("	BLCK_STWG_CD," ).append("\n"); 
		query.append("	TS_VSL_CD||TS_SKD_VOY_NO||TS_SKD_DIR_CD TS_VVD_CD," ).append("\n"); 
		query.append("	OVR_LEN_QTY," ).append("\n"); 
		query.append("	OVR_WGT_QTY," ).append("\n"); 
		query.append("	OVR_HGT_QTY," ).append("\n"); 
		query.append("	MIN_TEMP," ).append("\n"); 
		query.append("	MAX_TEMP," ).append("\n"); 
		query.append("	KR_TML_PRCT_ID," ).append("\n"); 
		query.append("	POD_YD_CD," ).append("\n"); 
		query.append("	POL_YD_CD," ).append("\n"); 
		query.append("	MRN_POLUT_FLG," ).append("\n"); 
		query.append("	STWG_CD," ).append("\n"); 
		query.append("	XTER_RMK," ).append("\n"); 
		query.append("	A_POD_CD," ).append("\n"); 
		query.append("	T_VSL_CD," ).append("\n"); 
		query.append("	BKG_POL_CD," ).append("\n"); 
		query.append("	BC_CD," ).append("\n"); 
		query.append("	VGM_WGT," ).append("\n"); 
		query.append("	VGM_WGT_UT_CD ," ).append("\n"); 
		query.append("	VGM_VRFY_SIG_CTNT," ).append("\n"); 
		query.append("    VGM_MZD_TP_CD" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	(	" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	--CNTR_LIST_NO," ).append("\n"); 
		query.append("	A.VSL_CD," ).append("\n"); 
		query.append("	A.SKD_VOY_NO," ).append("\n"); 
		query.append("	A.SKD_DIR_CD," ).append("\n"); 
		query.append("	NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = A.POL_CD),A.POL_CD) POL_CD," ).append("\n"); 
		query.append("	--A.POL_CD," ).append("\n"); 
		query.append("	NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = A.BKG_POL_CD),A.POL_CD) BKG_POL_CD," ).append("\n"); 
		query.append("	--A.BKG_POL_CD," ).append("\n"); 
		query.append("	A.CNTR_NO," ).append("\n"); 
		query.append("	A.BL_NO," ).append("\n"); 
		query.append("	A.BKG_NO," ).append("\n"); 
		query.append("	A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	A.MTY_BKG_CD," ).append("\n"); 
		query.append("	A.SEAL_NO," ).append("\n"); 
		query.append("	A.BL_WGT," ).append("\n"); 
		query.append("	A.WGT_UT_CD," ).append("\n"); 
		query.append("	SUBSTR(NVL(A.RCV_TERM_CD,' ')||NVL(A.DE_TERM_CD,' '),1,2) RCV_TERM_CD," ).append("\n"); 
		query.append("	A.KR_CLL_TS_CD TS_FLG," ).append("\n"); 
		query.append("	DECODE(A.MTY_BKG_CD,'M','2',DECODE(A.KR_CLL_TS_CD, 'TS', '3', 'TT', '4', '1')) AA," ).append("\n"); 
		query.append("	--UN_LOC_CD," ).append("\n"); 
		query.append("	A.IMDG_CLSS_ID IMDG_CLSS_CD ," ).append("\n"); 
		query.append("	A.TML_IMDG_ID IMDG_UN_NO," ).append("\n"); 
		query.append("	A.CDO_TEMP," ).append("\n"); 
		query.append("	A.CNTR_VENT_ID CNTR_VENT_CD," ).append("\n"); 
		query.append("	CM.HAMO_TRF_CD," ).append("\n"); 
		query.append("	CM.CMDT_HS_CD," ).append("\n"); 
		query.append("	A.CLL_RMK1," ).append("\n"); 
		query.append("	A.CLL_RMK2," ).append("\n"); 
		query.append("	NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = A.POD_CD),A.POD_CD) POD_CD," ).append("\n"); 
		query.append("	--A.POD_CD," ).append("\n"); 
		query.append("	A.BLCK_STWG_CD," ).append("\n"); 
		query.append("	--HOT_FLG," ).append("\n"); 
		query.append("	A.TS_VSL_CD," ).append("\n"); 
		query.append("	A.TS_SKD_VOY_NO," ).append("\n"); 
		query.append("	A.TS_SKD_DIR_CD," ).append("\n"); 
		query.append("	--CUST_CNT_CD," ).append("\n"); 
		query.append("	A.OVR_LEN_QTY," ).append("\n"); 
		query.append("	A.OVR_WGT_QTY," ).append("\n"); 
		query.append("	A.OVR_HGT_QTY," ).append("\n"); 
		query.append("	A.MIN_TEMP," ).append("\n"); 
		query.append("	A.MAX_TEMP," ).append("\n"); 
		query.append("	--UPD_DT," ).append("\n"); 
		query.append("	A.KR_TML_PRCT_ID," ).append("\n"); 
		query.append("	A.POD_YD_CD," ).append("\n"); 
		query.append("	A.POL_YD_CD," ).append("\n"); 
		query.append("	'' MRN_POLUT_FLG," ).append("\n"); 
		query.append("	--B.STWG_CD," ).append("\n"); 
		query.append("	--DECODE(A.CLL_RMK1, 'INGU' , '' , B.STWG_CD) STWG_CD," ).append("\n"); 
		query.append("	A.STWG_CD STWG_CD," ).append("\n"); 
		query.append("	'' XTER_RMK," ).append("\n"); 
		query.append("	NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = A.BKG_POD_CD),A.BKG_POD_CD) A_POD_CD," ).append("\n"); 
		query.append("	--A.BKG_POD_CD A_POD_CD," ).append("\n"); 
		query.append("	'' T_VSL_CD," ).append("\n"); 
		query.append("	'' VVD_CD_NM,	" ).append("\n"); 
		query.append("	'' POL_CD_PRINT," ).append("\n"); 
		query.append("	'' VPS_ETD," ).append("\n"); 
		query.append("	B.BLCK_STWG_CD AS BC_CD," ).append("\n"); 
		query.append("	A.VGM_WGT," ).append("\n"); 
		query.append("	'KGS' VGM_WGT_UT_CD ," ).append("\n"); 
		query.append("	A.VGM_VRFY_SIG_CTNT," ).append("\n"); 
		query.append("    A.VGM_MZD_TP_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	BKG_CSTMS_TML_KR_CLL A,BKG_BOOKING B, BKG_CNTR_MF_DESC CM" ).append("\n"); 
		query.append("#if (${in_cntr_cfm_flg}!= '') " ).append("\n"); 
		query.append("	,BKG_CONTAINER C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_pol_yd_cd} == '') " ).append("\n"); 
		query.append("WHERE A.CNTR_LIST_NO = @[in_vsl_cd]||SUBSTR(@[in_skd_voy_no],2,3)||@[in_skd_dir_cd]||SUBSTR(@[in_pol_cd],3,3)" ).append("\n"); 
		query.append("#elseif (${in_pol_yd_cd} != '') " ).append("\n"); 
		query.append("WHERE A.CNTR_LIST_NO = @[in_vsl_cd]||SUBSTR(@[in_skd_voy_no],2,3)||@[in_skd_dir_cd]||SUBSTR(@[in_pol_cd],3,3)" ).append("\n"); 
		query.append("AND A.POL_YD_CD = @[in_pol_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("#if (${in_bkg_sts_cd}!= '') 			" ).append("\n"); 
		query.append("AND B.BKG_STS_CD = @[in_bkg_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_cntr_cfm_flg}!= '') 	" ).append("\n"); 
		query.append("AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND A.CNTR_NO = C.CNTR_NO		" ).append("\n"); 
		query.append("AND C.CNTR_CFM_FLG = @[in_cntr_cfm_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.BKG_NO = CM.BKG_NO (+)" ).append("\n"); 
		query.append("AND A.CNTR_NO = CM.CNTR_NO (+)" ).append("\n"); 
		query.append("AND CM.CNTR_MF_SEQ (+) = 1" ).append("\n"); 
		query.append("#if (${in_sort_type} == '' ) " ).append("\n"); 
		query.append("order by AA, A.POL_CD, A.POD_CD, A.CNTR_NO" ).append("\n"); 
		query.append("#elseif (${in_sort_type} == '1' ) " ).append("\n"); 
		query.append("order by AA, A.POL_CD, A.POD_CD, A.CNTR_NO" ).append("\n"); 
		query.append("#elseif (${in_sort_type} == '2' ) " ).append("\n"); 
		query.append("order by AA, A.POL_CD, A.POD_CD, A.BKG_POD_CD" ).append("\n"); 
		query.append("#elseif (${in_sort_type} == '3' ) " ).append("\n"); 
		query.append("order by AA, A.TS_VSL_CD||A.TS_SKD_VOY_NO||A.TS_SKD_DIR_CD" ).append("\n"); 
		query.append("#elseif (${in_sort_type} == '4' ) " ).append("\n"); 
		query.append("order by AA, DECODE(A.BLCK_STWG_CD,'LOC','11','ONE','12','TWO','13','THR','14','FOR','15','FIV', '15.5','SEV', '15.7', 'HOT','16','TRS','17', '18')" ).append("\n"); 
		query.append("#elseif (${in_sort_type} == '5' ) " ).append("\n"); 
		query.append("order by AA, A.POD_CD, DECODE(A.BLCK_STWG_CD,'LOC','11','ONE','12','TWO','13','THR','14','FOR','15', 'FIV', '15.5','SEV', '15.7', 'HOT','16','TRS','17', '18'), A.CNTR_TPSZ_CD, A.CNTR_NO" ).append("\n"); 
		query.append("#elseif (${in_sort_type} == '6' ) " ).append("\n"); 
		query.append("order by A.CNTR_NO" ).append("\n"); 
		query.append("#elseif (${in_sort_type} == '7' ) " ).append("\n"); 
		query.append("order by TO_NUMBER(A.BL_WGT,'99990')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}