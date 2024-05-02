/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOBsaInformationEntryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.20
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.10.20 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOBsaInformationEntryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BsaInformationEntryList
	  * 1. 2013.01.28 이수진 [CHM-201322523] JO - BSA Entry 기능 수정관련 개발
	  *     - 조건 중 Version 항목에 Latest를 선택한 경우 Ref No 중 Version Flag ="Y"이면서 
	  *       Version 번호가 가장 큰 값만 조회되도록 쿼리 수정
	  * 
	  * 2. 2013.02.06 이수진 [CHM-201322641] BSA Enmtry 기능 추가
	  *    - Price Finish 항목 추가
	  *    - Add Carrier  Checkbox 구분에 따라 Main 화면을 조회할지 Add Carrier 화면을 조회할지 구분
	  *      : Uncheck시에는 Mian 화면 조회, Check시에는 Add Carrier 화면 조회
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOBsaInformationEntryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_fsh_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_prc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yr_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yr_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOBsaInformationEntryListRSQL").append("\n"); 
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
		query.append("#if (${add_carrier} == 'Y')" ).append("\n"); 
		query.append("SELECT C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD||C.PORT_CD||C.PORT_SEQ||C.JO_CRR_CD VVD_PORT" ).append("\n"); 
		query.append("     , C.JO_CRR_CD" ).append("\n"); 
		query.append("     , C.JO_BSA_TEU_QTY" ).append("\n"); 
		query.append("     , TO_CHAR(C.CRE_DT, 'YYYY-MM-DD')  CRE_DT               " ).append("\n"); 
		query.append("     , C.UPD_USR_ID           " ).append("\n"); 
		query.append("     , U.USR_NM " ).append("\n"); 
		query.append("     , C.JO_ADD_CRR_CD      " ).append("\n"); 
		query.append("  FROM JOO_BSA_AGMT A, JOO_ADD_BSA_CRR C, COM_USER U" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trd_cd}!= '')" ).append("\n"); 
		query.append("       AND   A.TRD_CD        =  @[trd_cd]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rlane_cd}!= '')" ).append("\n"); 
		query.append("       AND   A.RLANE_CD      =  @[rlane_cd]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_crr_cd}!= '')" ).append("\n"); 
		query.append("       AND   A.JO_CRR_CD     =  @[jo_crr_cd]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd}!= '')" ).append("\n"); 
		query.append("       AND   A.VSL_CD        LIKE @[vsl_cd]||'%'  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${skd_dir_cd}!= '')" ).append("\n"); 
		query.append("       AND   A.SKD_DIR_CD    =  @[skd_dir_cd]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_yr_wk}!= '')" ).append("\n"); 
		query.append("       AND   A.YRWK BETWEEN @[fm_yr_wk] AND @[to_yr_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${port_cd}!= '')" ).append("\n"); 
		query.append("       AND   A.PORT_CD       =  @[port_cd]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${jo_fsh_flg}!= '')" ).append("\n"); 
		query.append("       AND   A.JO_FSH_FLG    =  @[jo_fsh_flg]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${jo_prc_flg}!= '')" ).append("\n"); 
		query.append("       AND   A.JO_PRC_FSH_FLG    =  @[jo_prc_flg] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${delt_flg}!= '')" ).append("\n"); 
		query.append("       AND   A.DELT_FLG      =  @[delt_flg] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${re_divr_cd}!= '')" ).append("\n"); 
		query.append("       AND   A.RE_DIVR_CD    =  @[re_divr_cd]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_etd_dt}!= '')" ).append("\n"); 
		query.append("	   AND   A.REV_PORT_ETD_DT  BETWEEN  TO_DATE (REPLACE (@[fm_etd_dt], '-', ''), 'YYYYMMDD') AND TO_DATE (REPLACE (@[to_etd_dt], '-', ''), 'YYYYMMDD')  + 0.99999  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_cd}!= '')" ).append("\n"); 
		query.append("       AND   A.OFC_CD        =  @[ofc_cd]  -- 11번" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cre_dt_fr}!= '')" ).append("\n"); 
		query.append("	   AND   A.CRE_DT  BETWEEN  TO_DATE (REPLACE (@[cre_dt_fr], '-', ''), 'YYYYMMDD') AND TO_DATE (REPLACE (@[cre_dt_to], '-', ''), 'YYYYMMDD')  + 0.99999  -- 12번" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_cd}!= '')" ).append("\n"); 
		query.append("	   AND   A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD like @[vvd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND A.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND A.PORT_CD = C.PORT_CD" ).append("\n"); 
		query.append("  AND A.PORT_SEQ = C.PORT_SEQ" ).append("\n"); 
		query.append("  AND C.UPD_USR_ID    =  U.USR_ID" ).append("\n"); 
		query.append("ORDER BY C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD, C.PORT_CD, C.PORT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.YRWK" ).append("\n"); 
		query.append("     , A.OFC_CD" ).append("\n"); 
		query.append("     , DECODE(A.RE_DIVR_CD,'R','Rev','Exp') RE_DIVR_CD" ).append("\n"); 
		query.append("     , A.TRD_CD" ).append("\n"); 
		query.append("     , A.RLANE_CD" ).append("\n"); 
		query.append("     , A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.PORT_CD" ).append("\n"); 
		query.append("     , A.PORT_SEQ" ).append("\n"); 
		query.append("     , A.JO_CRR_CD" ).append("\n"); 
		query.append("     , A.JO_BSA_TEU_QTY" ).append("\n"); 
		query.append("     , A.JO_BSA_ADD_TEU_QTY" ).append("\n"); 
		query.append("     , A.JO_ADD_BSA_CRR_FLG" ).append("\n"); 
		query.append("     , A.JO_OVR_BSA_TEU_QTY" ).append("\n"); 
		query.append("     , A.JO_TON_TEU_QTY" ).append("\n"); 
		query.append("     , A.JO_OVR_TON_WGT" ).append("\n"); 
		query.append("     , A.JO_20FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("     , A.JO_20FT_OVR_RTO" ).append("\n"); 
		query.append("     , A.JO_40FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("     , A.JO_40FT_OVR_RTO" ).append("\n"); 
		query.append("     , A.JO_45FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("     , A.JO_45FT_OVR_RTO" ).append("\n"); 
		query.append("     , A.JO_45FT_UND_RTO" ).append("\n"); 
		query.append("     , A.JO_RND_KND_FLG" ).append("\n"); 
		query.append("     , A.JO_RND_RULE_LVL" ).append("\n"); 
		query.append("     , A.JO_RF_OCN_TEU_QTY" ).append("\n"); 
		query.append("     , A.JO_RF_INTER_TEU_QTY" ).append("\n"); 
		query.append("     , A.JO_INTER_OVR_FLG" ).append("\n"); 
		query.append("     , A.JO_RDR_PORT_CD" ).append("\n"); 
		query.append("     , A.JO_FSH_FLG" ).append("\n"); 
		query.append("     , A.JO_BSA_PRC" ).append("\n"); 
		query.append("     , A.JO_OVR_OCN_PRC" ).append("\n"); 
		query.append("     , A.JO_OVR_INTER_PRC" ).append("\n"); 
		query.append("     , A.JO_OVR_MT_OCN_PRC" ).append("\n"); 
		query.append("     , A.JO_OVR_MT_INTER_PRC" ).append("\n"); 
		query.append("     , A.JO_SCTR_PRC_FLG" ).append("\n"); 
		query.append("     , A.JO_RF_OCN_PRC" ).append("\n"); 
		query.append("     , A.JO_RF_INTER_PRC" ).append("\n"); 
		query.append("     , A.JO_PRC_FSH_FLG" ).append("\n"); 
		query.append("     , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.PORT_CD||A.PORT_SEQ||A.JO_CRR_CD VVD_PORT" ).append("\n"); 
		query.append("     , A.JO_BSA_ENTR_RDR_RMK" ).append("\n"); 
		query.append("     , A.JO_BSA_ENTR_RMK" ).append("\n"); 
		query.append("     , TO_CHAR(A.UPD_DT, 'YYYY-MM-DD')  UPD_DT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID " ).append("\n"); 
		query.append("     , U.USR_NM " ).append("\n"); 
		query.append("     , A.DELT_FLG  " ).append("\n"); 
		query.append("     , TO_CHAR(TO_DATE(A.REV_PORT_ETD_DT,'YYYY-MM-DD'),'YYYY-MM-DD') REV_PORT_ETD_DT" ).append("\n"); 
		query.append("  FROM JOO_BSA_AGMT A, COM_USER U" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${trd_cd}!= '')" ).append("\n"); 
		query.append("       AND   A.TRD_CD        =  @[trd_cd]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rlane_cd}!= '')" ).append("\n"); 
		query.append("       AND   A.RLANE_CD      =  @[rlane_cd]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_crr_cd}!= '')" ).append("\n"); 
		query.append("       AND   A.JO_CRR_CD     =  @[jo_crr_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd}!= '')" ).append("\n"); 
		query.append("       AND   A.VSL_CD        LIKE @[vsl_cd]||'%'  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${skd_dir_cd}!= '')" ).append("\n"); 
		query.append("       AND   A.SKD_DIR_CD    =  @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_yr_wk}!= '')" ).append("\n"); 
		query.append("       AND   A.YRWK BETWEEN @[fm_yr_wk] AND @[to_yr_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${port_cd}!= '')" ).append("\n"); 
		query.append("       AND   A.PORT_CD       =  @[port_cd]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${jo_fsh_flg}!= '')" ).append("\n"); 
		query.append("       AND   A.JO_FSH_FLG    =  @[jo_fsh_flg]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${jo_prc_flg}!= '')" ).append("\n"); 
		query.append("       AND   A.JO_PRC_FSH_FLG    =  @[jo_prc_flg]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${delt_flg}!= '')" ).append("\n"); 
		query.append("       AND   A.DELT_FLG      =  @[delt_flg]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${re_divr_cd}!= '')" ).append("\n"); 
		query.append("       AND   A.RE_DIVR_CD    =  @[re_divr_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_etd_dt}!= '')" ).append("\n"); 
		query.append("	   AND   A.REV_PORT_ETD_DT  BETWEEN  REPLACE (@[fm_etd_dt], '-', '') AND REPLACE (@[to_etd_dt], '-', '')  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_cd}!= '')" ).append("\n"); 
		query.append("       AND   A.OFC_CD        =  @[ofc_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cre_dt_fr}!= '')" ).append("\n"); 
		query.append("	   AND   A.CRE_DT  BETWEEN  TO_DATE (REPLACE (@[cre_dt_fr], '-', ''), 'YYYYMMDD') AND TO_DATE (REPLACE (@[cre_dt_to], '-', ''), 'YYYYMMDD')  + 0.99999  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_cd}!= '')" ).append("\n"); 
		query.append("	   AND   A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD like @[vvd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   A.UPD_USR_ID    =  U.USR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY YRWK, OFC_CD, RE_DIVR_CD, TRD_CD, RLANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, PORT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}