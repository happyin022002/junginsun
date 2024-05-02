/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SPCManageDBDAOModifySpcSlotInfoByVvdOnVesselUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCManageDBDAOModifySpcSlotInfoByVvdOnVesselUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquiry by VVD에서 Manual 로 값 입력시 BSA_VVD_OTR_CRR 에 값 수정/입력
	  * 
	  * 2016.01.29 김성욱 [CHM-201539410] BSA System 개선의 건 / 동일 날짜에 서로 다른 항차 BSA 입력 가능 실현
	  * </pre>
	  */
	public SPCManageDBDAOModifySpcSlotInfoByVvdOnVesselUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_hjs_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("def_value",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_hjs_bsa_capa_sc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration").append("\n"); 
		query.append("FileName : SPCManageDBDAOModifySpcSlotInfoByVvdOnVesselUSQL").append("\n"); 
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
		query.append("MERGE INTO BSA_VVD_OTR_CRR A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("	 @[trd_cd] TRD_CD" ).append("\n"); 
		query.append("		 , @[lane_cd] RLANE_CD" ).append("\n"); 
		query.append("		 , @[dir_cd] SKD_DIR_CD" ).append("\n"); 
		query.append("		 , @[vsl_cd] VSL_CD" ).append("\n"); 
		query.append("		 , @[voy_no] SKD_VOY_NO " ).append("\n"); 
		query.append("		 , @[jb_cd] BSA_OP_JB_CD" ).append("\n"); 
		query.append("		 , @[crr_cd] CRR_CD" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("	    A.TRD_CD       = B.TRD_CD" ).append("\n"); 
		query.append("	AND A.RLANE_CD     = B.RLANE_CD" ).append("\n"); 
		query.append("	AND A.SKD_DIR_CD   = B.SKD_DIR_CD" ).append("\n"); 
		query.append("	AND A.VSL_CD       = B.VSL_CD" ).append("\n"); 
		query.append("	AND A.SKD_VOY_NO   = B.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND A.BSA_OP_JB_CD = B.BSA_OP_JB_CD" ).append("\n"); 
		query.append("	AND A.CRR_CD       = B.CRR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("	UPDATE" ).append("\n"); 
		query.append("#if (${crr_cd} != 'SML')" ).append("\n"); 
		query.append("	SET CRR_BSA_CAPA = CRR_BSA_CAPA + TO_NUMBER(@[def_value])" ).append("\n"); 
		query.append("	, SPC_CTRL_SLT_CAPA = SPC_CTRL_SLT_CAPA + TO_NUMBER(@[def_value])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${type} == 'SC')" ).append("\n"); 
		query.append("	SET CRR_BSA_CAPA = @[fnl_hjs_bsa_capa_sc]" ).append("\n"); 
		query.append("	, SPC_CTRL_SLT_CAPA = @[fnl_hjs_bsa_capa_sc]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	SET CRR_BSA_CAPA = @[fnl_hjs_bsa_capa]" ).append("\n"); 
		query.append("	, SPC_CTRL_SLT_CAPA = @[fnl_hjs_bsa_capa]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	, UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	, UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT (" ).append("\n"); 
		query.append("		TRD_CD, RLANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD," ).append("\n"); 
		query.append("		BSA_OP_JB_CD, CRR_CD, CRR_BSA_CAPA, SPC_CTRL_SLT_CAPA," ).append("\n"); 
		query.append("		CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append("	) VALUES (" ).append("\n"); 
		query.append("		@[trd_cd] , @[lane_cd] , @[vsl_cd] , @[voy_no] , @[dir_cd]" ).append("\n"); 
		query.append("		, @[jb_cd] , @[crr_cd] , @[crr_bsa_capa] , @[crr_bsa_capa]" ).append("\n"); 
		query.append("		, @[upd_usr_id] , SYSDATE , @[upd_usr_id] , SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}