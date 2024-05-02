/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOCusBzcAgmtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOCusBzcAgmtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic Information for Loading Summary 조회 query
	  * 2012.06.01 : 김상근[CHM-201218057-01]
	  * Title : [ALPS JOO] Basic Info 조건 추가에 따른 Integrated Loading Summary logic 변경 
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOCusBzcAgmtVORSQL(){
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
		params.put("jo_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_eff_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_eff_year",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOCusBzcAgmtVORSQL").append("\n"); 
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
		query.append("        A.JO_REF_NO  " ).append("\n"); 
		query.append("       ,A.JO_REF_SEQ " ).append("\n"); 
		query.append("       ,A.OFC_CD     " ).append("\n"); 
		query.append("       ,A.RE_DIVR_CD " ).append("\n"); 
		query.append("       ,A.JO_CRR_CD  " ).append("\n"); 
		query.append("       ,A.TRD_CD     " ).append("\n"); 
		query.append("       ,A.RLANE_CD   " ).append("\n"); 
		query.append("       ,A.JO_SRC_CD  " ).append("\n"); 
		query.append("       ,A.BSA_CAPA   " ).append("\n"); 
		query.append("       ,A.JO_TON_TEU_QTY" ).append("\n"); 
		query.append("       ,A.CGO_TON_WGT" ).append("\n"); 
		query.append("       ,A.JO_TON_WGT_RND_RT" ).append("\n"); 
		query.append("       ,A.JO_40FT_GNTE_QTY" ).append("\n"); 
		query.append("       ,A.JO_40FT_TEU_QTY" ).append("\n"); 
		query.append("       ,A.JO_40FT_RND_RT" ).append("\n"); 
		query.append("       ,A.JO_20FT_GNTE_QTY" ).append("\n"); 
		query.append("       ,A.JO_20FT_TEU_QTY" ).append("\n"); 
		query.append("       ,A.JO_20FT_RND_RT" ).append("\n"); 
		query.append("       ,A.JO_45FT_GNTE_QTY" ).append("\n"); 
		query.append("       ,A.JO_45FT_OVR_TEU_QTY" ).append("\n"); 
		query.append("       ,A.JO_45FT_UND_TEU_QTY" ).append("\n"); 
		query.append("       ,A.JO_45FT_RND_RT" ).append("\n"); 
		query.append("       ,A.JO_RF_GNTE_OCN_QTY" ).append("\n"); 
		query.append("       ,A.JO_RF_GNTE_INTER_QTY" ).append("\n"); 
		query.append("       ,A.JO_BKG_TP_CD" ).append("\n"); 
		query.append("       ,A.AGMT_EFF_DT" ).append("\n"); 
		query.append("       ,A.AGMT_EXP_DT" ).append("\n"); 
		query.append("       ,A.DELT_FLG   " ).append("\n"); 
		query.append("       ,TO_CHAR(A.CRE_DT,'YYYYMMDDHH24MISS') AS CRE_DT" ).append("\n"); 
		query.append("       ,A.CRE_USR_ID " ).append("\n"); 
		query.append("       ,TO_CHAR(A.UPD_DT,'YYYYMMDDHH24MISS') AS UPD_DT     " ).append("\n"); 
		query.append("       ,A.UPD_USR_ID" ).append("\n"); 
		query.append("       ,B.USR_LOCL_NM AS CRE_USR_NM" ).append("\n"); 
		query.append("	   ,A.JO_ALOC_ADJ_TEU_QTY" ).append("\n"); 
		query.append("	   ,A.JO_ALOC_ADJ_WGT" ).append("\n"); 
		query.append("	   ,A.JO_ALOC_ADJ_RMK" ).append("\n"); 
		query.append("	   ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("	   ,(SELECT CASE WHEN COUNT(JO_CRR_CD) > 1 THEN 'Y' ELSE 'N' END " ).append("\n"); 
		query.append("		   FROM JOO_BZC_AGMT_CRR " ).append("\n"); 
		query.append("          WHERE JO_REF_NO = A.JO_REF_NO) AS JO_CRR_FLAG" ).append("\n"); 
		query.append("	   ,A.JO_CRR_CD AS JO_REF_CRR_CD" ).append("\n"); 
		query.append("FROM   JOO_BZC_AGMT A," ).append("\n"); 
		query.append("       COM_USER B" ).append("\n"); 
		query.append("WHERE  A.CRE_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("#if (${jo_ref_no} != '')" ).append("\n"); 
		query.append("AND    A.JO_REF_NO  = @[jo_ref_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND    A.OFC_CD  = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("AND    A.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD  = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("AND    A.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("AND    A.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_eff_year} != '' && ${agmt_eff_mon} != '')" ).append("\n"); 
		query.append("AND    @[agmt_eff_year]||@[agmt_eff_mon] BETWEEN SUBSTR(A.AGMT_EFF_DT, 1, 6) AND SUBSTR(A.AGMT_EXP_DT, 1, 6)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${agmt_eff_year} != '')" ).append("\n"); 
		query.append("	AND    @[agmt_eff_year] BETWEEN SUBSTR(A.AGMT_EFF_DT, 1, 4) AND SUBSTR(A.AGMT_EXP_DT, 1, 4)" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		#if (${agmt_eff_mon} != '')" ).append("\n"); 
		query.append("		AND    @[agmt_eff_mon] BETWEEN SUBSTR(A.AGMT_EFF_DT, 5, 2) AND SUBSTR(A.AGMT_EXP_DT, 5, 2)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '')" ).append("\n"); 
		query.append("AND    A.DELT_FLG  = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER  BY A.JO_REF_NO, A.JO_REF_SEQ" ).append("\n"); 

	}
}