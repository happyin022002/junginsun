/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SPCManageDBDAOModifySpcSlotInfoByVvdOnVesselWeightUSQL.java
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

public class SPCManageDBDAOModifySpcSlotInfoByVvdOnVesselWeightUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPCManageDBDAOModifySpcSlotInfoByVvdOnVesselWeight
	  * </pre>
	  */
	public SPCManageDBDAOModifySpcSlotInfoByVvdOnVesselWeightUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration").append("\n"); 
		query.append("FileName : SPCManageDBDAOModifySpcSlotInfoByVvdOnVesselWeightUSQL").append("\n"); 
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
		query.append("		 , '009' BSA_OP_JB_CD" ).append("\n"); 
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
		query.append("	SET CRR_BSA_CAPA = (SELECT CRR_BSA_CAPA " ).append("\n"); 
		query.append("                            FROM BSA_VVD_OTR_CRR " ).append("\n"); 
		query.append("                            WHERE TRD_CD = @[trd_cd] " ).append("\n"); 
		query.append("                                AND RLANE_CD = @[lane_cd]" ).append("\n"); 
		query.append("                                AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                AND SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("                                AND SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("                                AND BSA_OP_JB_CD = '007' --앞 쿼리에서 이미 변경된 CRR_BSA_CAPA가 007에 반영되었으므로 여기서는 그대로 불러서 씀" ).append("\n"); 
		query.append("                                AND CRR_CD = @[crr_cd])*(SELECT CRR_BSA_CAPA " ).append("\n"); 
		query.append("                                                            FROM BSA_VVD_OTR_CRR " ).append("\n"); 
		query.append("                                                            WHERE TRD_CD = @[trd_cd] " ).append("\n"); 
		query.append("                                                                AND RLANE_CD = @[lane_cd]" ).append("\n"); 
		query.append("                                                                AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                                                AND SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("                                                                AND SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("                                                                AND BSA_OP_JB_CD = '008'" ).append("\n"); 
		query.append("                                                                AND CRR_CD = @[crr_cd])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${type} == 'SC')" ).append("\n"); 
		query.append("	SET CRR_BSA_CAPA = @[fnl_hjs_bsa_capa_sc]*(SELECT CRR_BSA_CAPA " ).append("\n"); 
		query.append("                                                FROM BSA_VVD_OTR_CRR " ).append("\n"); 
		query.append("                                                WHERE TRD_CD = @[trd_cd] " ).append("\n"); 
		query.append("                                                    AND RLANE_CD = @[lane_cd]" ).append("\n"); 
		query.append("                                                    AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                                    AND SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("                                                    AND SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("                                                    AND BSA_OP_JB_CD = '008'" ).append("\n"); 
		query.append("                                                    AND CRR_CD = @[crr_cd])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	SET CRR_BSA_CAPA = @[fnl_hjs_bsa_capa]*(SELECT CRR_BSA_CAPA " ).append("\n"); 
		query.append("                                            FROM BSA_VVD_OTR_CRR " ).append("\n"); 
		query.append("                                            WHERE TRD_CD = @[trd_cd] " ).append("\n"); 
		query.append("                                                AND RLANE_CD = @[lane_cd]" ).append("\n"); 
		query.append("                                                AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                                AND SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("                                                AND SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("                                                AND BSA_OP_JB_CD = '008'" ).append("\n"); 
		query.append("                                                AND CRR_CD = @[crr_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	, UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	, UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 

	}
}