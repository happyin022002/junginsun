/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoRiderDBDAOsearchAttachFileListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoRiderDBDAOsearchAttachFileListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * B/L Rider & DG Rider 파일 업로드 현황 조회
	  * </pre>
	  */
	public SpecialCargoRiderDBDAOsearchAttachFileListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_post_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_rgst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rgst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ridr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.integration").append("\n"); 
		query.append("FileName : SpecialCargoRiderDBDAOsearchAttachFileListRSQL").append("\n"); 
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
		query.append("idx ," ).append("\n"); 
		query.append("CASE WHEN ridr_tp_cd ='D' THEN 'D/G Rider'" ).append("\n"); 
		query.append("     WHEN ridr_tp_cd ='A' THEN 'Awkward Rider'" ).append("\n"); 
		query.append("     WHEN ridr_tp_cd ='B' THEN 'Break Bulk Rider'" ).append("\n"); 
		query.append("     WHEN ridr_tp_cd ='G' THEN 'B/L Rider'" ).append("\n"); 
		query.append("     WHEN ridr_tp_cd ='C' THEN 'Certificate' END  AS ridr_tp_cd" ).append("\n"); 
		query.append(", BKG.bkg_no" ).append("\n"); 
		query.append(", bl_no" ).append("\n"); 
		query.append(", slan_cd" ).append("\n"); 
		query.append(", vsl_cd" ).append("\n"); 
		query.append(", pol_cd" ).append("\n"); 
		query.append(", pod_cd" ).append("\n"); 
		query.append(", file_nm" ).append("\n"); 
		query.append(", cntr_no" ).append("\n"); 
		query.append(", cntr_cgo_seq" ).append("\n"); 
		query.append(", bkg_ofc_cd" ).append("\n"); 
		query.append(", ob_sls_ofc_cd" ).append("\n"); 
		query.append(", rgst_usr_id" ).append("\n"); 
		query.append(", rgst_ofc_cd" ).append("\n"); 
		query.append(", TO_CHAR(rgst_dt, 'YYYY-MM-DD HH24:MI') rgst_dt" ).append("\n"); 
		query.append(", usr_nm" ).append("\n"); 
		query.append(", file_sav_id" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("	idx" ).append("\n"); 
		query.append("    , ridr_tp_cd" ).append("\n"); 
		query.append("    , BKG.bkg_no" ).append("\n"); 
		query.append("    , bl_no" ).append("\n"); 
		query.append("    , slan_cd" ).append("\n"); 
		query.append("    , vsl_cd" ).append("\n"); 
		query.append("    , pol_cd" ).append("\n"); 
		query.append("    , pod_cd" ).append("\n"); 
		query.append("    , file_nm" ).append("\n"); 
		query.append("#if (${ridr_tp_cd} == 'D') " ).append("\n"); 
		query.append("--D/G Rider   " ).append("\n"); 
		query.append("    , cntr_no" ).append("\n"); 
		query.append("    , cntr_cgo_seq" ).append("\n"); 
		query.append("#elseif (${ridr_tp_cd} == 'A') " ).append("\n"); 
		query.append("--Awkward Rider  " ).append("\n"); 
		query.append("    , cntr_no" ).append("\n"); 
		query.append("    , '' cntr_cgo_seq" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--Break Bulk Rider     B/L Rider    Certificate" ).append("\n"); 
		query.append("    , '' cntr_no" ).append("\n"); 
		query.append("    , '' cntr_cgo_seq" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    , bkg_ofc_cd" ).append("\n"); 
		query.append("    , ob_sls_ofc_cd" ).append("\n"); 
		query.append("    , rgst_usr_id" ).append("\n"); 
		query.append("    , rgst_ofc_cd" ).append("\n"); 
		query.append("    , rgst_dt" ).append("\n"); 
		query.append("    , file_sav_id" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("			 dense_Rank() Over ( Order By STO.bkg_no) idx," ).append("\n"); 
		query.append("             STO.bkg_no" ).append("\n"); 
		query.append("             , ridr_tp_cd" ).append("\n"); 
		query.append("            , bl_no" ).append("\n"); 
		query.append("            , slan_cd" ).append("\n"); 
		query.append("            , vsl_cd||skd_voy_no||skd_dir_cd as vsl_cd" ).append("\n"); 
		query.append("            , pol_cd" ).append("\n"); 
		query.append("            , pod_cd" ).append("\n"); 
		query.append("            , file_nm" ).append("\n"); 
		query.append("	#if (${ridr_tp_cd} == 'D') " ).append("\n"); 
		query.append("	--D/G Rider   " ).append("\n"); 
		query.append("	, DCGO_SEQ" ).append("\n"); 
		query.append("	#elseif (${ridr_tp_cd} == 'A') " ).append("\n"); 
		query.append("	--Awkward Rider  " ).append("\n"); 
		query.append("	, AWK_CGO_SEQ" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	--Break Bulk Rider     B/L Rider    Certificate" ).append("\n"); 
		query.append("    , ''" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("            , bkg_ofc_cd" ).append("\n"); 
		query.append("            , ob_sls_ofc_cd" ).append("\n"); 
		query.append("            , rgst_usr_id" ).append("\n"); 
		query.append("            , rgst_ofc_cd" ).append("\n"); 
		query.append("            , rgst_dt" ).append("\n"); 
		query.append("            , file_sav_id" ).append("\n"); 
		query.append("            FROM BKG_IMG_STO STO , BKG_BOOKING  BKG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${pre_post_vsl_cd} != '' )" ).append("\n"); 
		query.append("			,(  " ).append("\n"); 
		query.append("				SELECT BKG_NO, VSL_CD||SKD_VOY_NO||SKD_DIR_CD PRE_1_VVD" ).append("\n"); 
		query.append("				FROM BKG_VVD" ).append("\n"); 
		query.append("				WHERE VSL_PRE_PST_CD ='S'" ).append("\n"); 
		query.append("				AND VSL_SEQ ='1'" ).append("\n"); 
		query.append("				AND VSL_CD     = SUBSTR(@[pre_post_vsl_cd], 1, 4)" ).append("\n"); 
		query.append("				AND SKD_VOY_NO = SUBSTR(@[pre_post_vsl_cd], 5, 4)" ).append("\n"); 
		query.append("				AND SKD_DIR_CD = SUBSTR(@[pre_post_vsl_cd], 9, 1)" ).append("\n"); 
		query.append("				UNION" ).append("\n"); 
		query.append("				SELECT BKG_NO, VSL_CD||SKD_VOY_NO||SKD_DIR_CD PRE_1_VVD" ).append("\n"); 
		query.append("				FROM BKG_VVD" ).append("\n"); 
		query.append("				WHERE VSL_PRE_PST_CD ='S'" ).append("\n"); 
		query.append("				AND VSL_SEQ ='2'" ).append("\n"); 
		query.append("				AND VSL_CD     = SUBSTR(@[pre_post_vsl_cd], 1, 4)" ).append("\n"); 
		query.append("				AND SKD_VOY_NO = SUBSTR(@[pre_post_vsl_cd], 5, 4)" ).append("\n"); 
		query.append("				AND SKD_DIR_CD = SUBSTR(@[pre_post_vsl_cd], 9, 1)" ).append("\n"); 
		query.append("				UNION" ).append("\n"); 
		query.append("				SELECT BKG_NO, VSL_CD||SKD_VOY_NO||SKD_DIR_CD PRE_1_VVD" ).append("\n"); 
		query.append("				FROM BKG_VVD" ).append("\n"); 
		query.append("				WHERE VSL_PRE_PST_CD ='S'" ).append("\n"); 
		query.append("				AND VSL_SEQ ='3'" ).append("\n"); 
		query.append("				AND VSL_CD     = SUBSTR(@[pre_post_vsl_cd], 1, 4)" ).append("\n"); 
		query.append("				AND SKD_VOY_NO = SUBSTR(@[pre_post_vsl_cd], 5, 4)" ).append("\n"); 
		query.append("				AND SKD_DIR_CD = SUBSTR(@[pre_post_vsl_cd], 9, 1)" ).append("\n"); 
		query.append("				UNION" ).append("\n"); 
		query.append("				SELECT BKG_NO, VSL_CD||SKD_VOY_NO||SKD_DIR_CD PRE_1_VVD" ).append("\n"); 
		query.append("				FROM BKG_VVD" ).append("\n"); 
		query.append("				WHERE VSL_PRE_PST_CD ='S'" ).append("\n"); 
		query.append("				AND VSL_SEQ ='4'" ).append("\n"); 
		query.append("				AND VSL_CD     = SUBSTR(@[pre_post_vsl_cd], 1, 4)" ).append("\n"); 
		query.append("				AND SKD_VOY_NO = SUBSTR(@[pre_post_vsl_cd], 5, 4)" ).append("\n"); 
		query.append("				AND SKD_DIR_CD = SUBSTR(@[pre_post_vsl_cd], 9, 1)" ).append("\n"); 
		query.append("				UNION " ).append("\n"); 
		query.append("				SELECT BKG_NO, VSL_CD||SKD_VOY_NO||SKD_DIR_CD PRE_1_VVD" ).append("\n"); 
		query.append("				FROM BKG_VVD" ).append("\n"); 
		query.append("				WHERE VSL_PRE_PST_CD ='U'" ).append("\n"); 
		query.append("				AND VSL_SEQ ='1'" ).append("\n"); 
		query.append("				AND VSL_CD     = SUBSTR(@[pre_post_vsl_cd], 1, 4)" ).append("\n"); 
		query.append("				AND SKD_VOY_NO = SUBSTR(@[pre_post_vsl_cd], 5, 4)" ).append("\n"); 
		query.append("				AND SKD_DIR_CD = SUBSTR(@[pre_post_vsl_cd], 9, 1)" ).append("\n"); 
		query.append("				UNION" ).append("\n"); 
		query.append("				SELECT BKG_NO, VSL_CD||SKD_VOY_NO||SKD_DIR_CD PRE_1_VVD" ).append("\n"); 
		query.append("				FROM BKG_VVD" ).append("\n"); 
		query.append("				WHERE VSL_PRE_PST_CD ='U'" ).append("\n"); 
		query.append("				AND VSL_SEQ ='2'" ).append("\n"); 
		query.append("				AND VSL_CD     = SUBSTR(@[pre_post_vsl_cd], 1, 4)" ).append("\n"); 
		query.append("				AND SKD_VOY_NO = SUBSTR(@[pre_post_vsl_cd], 5, 4)" ).append("\n"); 
		query.append("				AND SKD_DIR_CD = SUBSTR(@[pre_post_vsl_cd], 9, 1)" ).append("\n"); 
		query.append("				UNION" ).append("\n"); 
		query.append("				SELECT BKG_NO, VSL_CD||SKD_VOY_NO||SKD_DIR_CD PRE_1_VVD" ).append("\n"); 
		query.append("				FROM BKG_VVD" ).append("\n"); 
		query.append("				WHERE VSL_PRE_PST_CD ='U'" ).append("\n"); 
		query.append("				AND VSL_SEQ ='3'" ).append("\n"); 
		query.append("				AND VSL_CD     = SUBSTR(@[pre_post_vsl_cd], 1, 4)" ).append("\n"); 
		query.append("				AND SKD_VOY_NO = SUBSTR(@[pre_post_vsl_cd], 5, 4)" ).append("\n"); 
		query.append("				AND SKD_DIR_CD = SUBSTR(@[pre_post_vsl_cd], 9, 1)" ).append("\n"); 
		query.append("				UNION" ).append("\n"); 
		query.append("				SELECT BKG_NO, VSL_CD||SKD_VOY_NO||SKD_DIR_CD PRE_1_VVD" ).append("\n"); 
		query.append("				FROM BKG_VVD" ).append("\n"); 
		query.append("				WHERE VSL_PRE_PST_CD ='U'" ).append("\n"); 
		query.append("				AND VSL_SEQ ='4'" ).append("\n"); 
		query.append("				AND VSL_CD     = SUBSTR(@[pre_post_vsl_cd], 1, 4)" ).append("\n"); 
		query.append("				AND SKD_VOY_NO = SUBSTR(@[pre_post_vsl_cd], 5, 4)" ).append("\n"); 
		query.append("				AND SKD_DIR_CD = SUBSTR(@[pre_post_vsl_cd], 9, 1)" ).append("\n"); 
		query.append("			 ) PR_PO_VB" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("            WHERE STO.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("		#if (${pre_post_vsl_cd} != '' )" ).append("\n"); 
		query.append("            AND BKG.BKG_NO= PR_PO_VB.BKG_NO" ).append("\n"); 
		query.append("		#end            " ).append("\n"); 
		query.append("		#if (${bkg_no} != '') " ).append("\n"); 
		query.append("            AND BKG.BKG_NO= @[bkg_no] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${bl_no} != '') " ).append("\n"); 
		query.append("            AND BKG.bl_no = @[bl_no] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("           AND BKG.VSL_CD     = SUBSTR(@[vsl_cd], 1, 4)" ).append("\n"); 
		query.append("           AND BKG.SKD_VOY_NO = SUBSTR(@[vsl_cd], 5, 4)" ).append("\n"); 
		query.append("           AND BKG.SKD_DIR_CD = SUBSTR(@[vsl_cd], 9, 1)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${ridr_tp_cd} != '') " ).append("\n"); 
		query.append("           AND STO.ridr_tp_cd =  @[ridr_tp_cd]" ).append("\n"); 
		query.append("		#end            " ).append("\n"); 
		query.append("		#if (${s_rgst_dt} != '000000') " ).append("\n"); 
		query.append("            AND STO.rgst_dt >= TO_DATE(@[s_rgst_dt], 'YYYYMMDDHH24MISS') " ).append("\n"); 
		query.append("		#end  " ).append("\n"); 
		query.append("		#if (${e_rgst_dt} != '235959') " ).append("\n"); 
		query.append("			AND STO.rgst_dt <= TO_DATE(@[e_rgst_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		#end  " ).append("\n"); 
		query.append("		#if (${pol_cd} != '')" ).append("\n"); 
		query.append("			AND BKG.pol_cd = @[pol_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${pod_cd} != '')		" ).append("\n"); 
		query.append("			AND BKG.pod_cd = @[pod_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("			AND BKG.bkg_ofc_cd = @[bkg_ofc_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${ob_sls_ofc_cd} != '') " ).append("\n"); 
		query.append("            AND BKG.ob_sls_ofc_cd = @[ob_sls_ofc_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${slan_cd} != '') " ).append("\n"); 
		query.append("            AND BKG.slan_cd = @[slan_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${rgst_ofc_cd} != '') " ).append("\n"); 
		query.append("            AND STO.rgst_ofc_cd = @[rgst_ofc_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${rgst_usr_id} != '') " ).append("\n"); 
		query.append("			AND UPPER(STO.rgst_usr_id) = UPPER(@[rgst_usr_id]) " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("            ) BKG " ).append("\n"); 
		query.append("	#if (${ridr_tp_cd} == 'D') " ).append("\n"); 
		query.append("	--D/G Rider   " ).append("\n"); 
		query.append("	    , BKG_DG_CGO SUB" ).append("\n"); 
		query.append("	      WHERE " ).append("\n"); 
		query.append("		BKG.BKG_NO = SUB.BKG_NO(+) " ).append("\n"); 
		query.append("		AND BKG.DCGO_SEQ = SUB.DCGO_SEQ(+)" ).append("\n"); 
		query.append("	#elseif (${ridr_tp_cd} == 'A') " ).append("\n"); 
		query.append("	--Awkward Rider  " ).append("\n"); 
		query.append("	    , BKG_AWK_CGO  SUB" ).append("\n"); 
		query.append("	      WHERE " ).append("\n"); 
		query.append("		BKG.BKG_NO = SUB.BKG_NO(+) " ).append("\n"); 
		query.append("		AND BKG.AWK_CGO_SEQ = SUB.AWK_CGO_SEQ(+)" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	--Break Bulk Rider     B/L Rider    Certificate" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(") BKG, COM_USER USR" ).append("\n"); 
		query.append("WHERE BKG.rgst_usr_id = USR.USR_ID(+)" ).append("\n"); 

	}
}