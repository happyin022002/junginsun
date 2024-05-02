/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OfficeMappingDBDAOCreateAddSectorOfcRelSetPfGrpCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeMappingDBDAOCreateAddSectorOfcRelSetPfGrpCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sector Office Relation Setting_Add Creation for IAS Sector 추가생성합니다.
	  * *History
	  * 2014.06.23 이혜민 Act_flag를 현재 분기에 존재하는 동일 pair의 act_flg로 넣어줌. 없으면 N으로 넣어줌.
	  * 2015.07.06 김용습 SQM_ACT_FLG 가져오는 서브쿼리에 A1.PF_GRP_CD  = A3.PF_GRP_CD 추가
	  * 2015.12.03 김용습 [CHM-201539213] Sector Office pair 중복 표시 로직 수정 관련 CSR
	  * </pre>
	  */
	public OfficeMappingDBDAOCreateAddSectorOfcRelSetPfGrpCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pf_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration").append("\n"); 
		query.append("FileName : OfficeMappingDBDAOCreateAddSectorOfcRelSetPfGrpCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_SCTR_LANE_OFC" ).append("\n"); 
		query.append("			(BSE_TP_CD," ).append("\n"); 
		query.append("			BSE_YR," ).append("\n"); 
		query.append("			BSE_QTR_CD," ).append("\n"); 
		query.append("			OFC_VW_CD," ).append("\n"); 
		query.append("			RLANE_CD," ).append("\n"); 
		query.append("			DIR_CD," ).append("\n"); 
		query.append("			PF_GRP_CD," ).append("\n"); 
		query.append("			RGN_OFC_CD," ).append("\n"); 
		query.append("			POL_CD," ).append("\n"); 
		query.append("			POD_CD," ).append("\n"); 
		query.append("			RHQ_CD," ).append("\n"); 
		query.append("			TRD_CD," ).append("\n"); 
		query.append("			SUB_TRD_CD," ).append("\n"); 
		query.append("			POL_CALL_SEQ," ).append("\n"); 
		query.append("			POD_CALL_SEQ," ).append("\n"); 
		query.append("			SQM_ACT_FLG," ).append("\n"); 
		query.append("			ADD_FLG," ).append("\n"); 
		query.append("			CRE_USR_ID," ).append("\n"); 
		query.append("			CRE_DT," ).append("\n"); 
		query.append("			UPD_USR_ID," ).append("\n"); 
		query.append("			UPD_DT)" ).append("\n"); 
		query.append("            SELECT  A2.BSE_TP_CD," ).append("\n"); 
		query.append("                    A2.BSE_YR," ).append("\n"); 
		query.append("                    A2.BSE_QTR_CD," ).append("\n"); 
		query.append("                    A2.OFC_VW_CD," ).append("\n"); 
		query.append("                    A2.RLANE_CD," ).append("\n"); 
		query.append("                    A2.DIR_CD," ).append("\n"); 
		query.append("                    A1.PF_GRP_CD," ).append("\n"); 
		query.append("                    A2.RGN_OFC_CD," ).append("\n"); 
		query.append("                    A1.POL_CD," ).append("\n"); 
		query.append("                    A1.POD_CD," ).append("\n"); 
		query.append("                    A2.RHQ_CD," ).append("\n"); 
		query.append("                    A2.TRD_CD," ).append("\n"); 
		query.append("                    A2.SUB_TRD_CD," ).append("\n"); 
		query.append("                    A1.POL_CALL_SEQ," ).append("\n"); 
		query.append("                    A1.POD_CALL_SEQ," ).append("\n"); 
		query.append("--                    'N' SQM_ACT_FLG," ).append("\n"); 
		query.append("                    NVL((SELECT DISTINCT A3.SQM_ACT_FLG " ).append("\n"); 
		query.append("                        FROM SQM_SCTR_LANE_OFC A3" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                        AND A3.BSE_TP_CD  = @[bse_tp_cd]" ).append("\n"); 
		query.append("                        AND A3.BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("                        AND A3.BSE_QTR_CD = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("                        AND A2.OFC_VW_CD  = A3.OFC_VW_CD" ).append("\n"); 
		query.append("                        AND A2.RLANE_CD   = A3.RLANE_CD" ).append("\n"); 
		query.append("                        AND A2.DIR_CD     = A3.DIR_CD" ).append("\n"); 
		query.append("                        AND A2.RGN_OFC_CD = A3.RGN_OFC_CD" ).append("\n"); 
		query.append("                        AND A1.POL_CD     = A3.POL_CD" ).append("\n"); 
		query.append("                        AND A1.POD_CD     = A3.POD_CD" ).append("\n"); 
		query.append("--                        AND A1.PF_GRP_CD  = A3.PF_GRP_CD -- dup이 발생하여 이 부분을 추가하였었으나, 이 부분으로 인해 002프로포마가 생길때 ACTIVE FLAG가 001프로포마의 ACTIVE여부를 가져가지 못하는 문제 발생(프로포마 002의 active flag는 무조건 N으로 생김)" ).append("\n"); 
		query.append("                        AND A2.RHQ_CD     = A3.RHQ_CD" ).append("\n"); 
		query.append("                        AND A2.TRD_CD     = A3.TRD_CD" ).append("\n"); 
		query.append("                        AND A2.SUB_TRD_CD = A3.SUB_TRD_CD" ).append("\n"); 
		query.append("                        AND A3.SQM_ACT_FLG = 'Y' -- 대신 dup 발생하지 않도록 이 부분 추가" ).append("\n"); 
		query.append("                      ), 'N') AS SQM_ACT_FLG," ).append("\n"); 
		query.append("                    A1.ADD_FLG," ).append("\n"); 
		query.append("                    @[cre_usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("                    SYSDATE CRE_DT," ).append("\n"); 
		query.append("                    @[upd_usr_id] UPD_USR_ID," ).append("\n"); 
		query.append("                    SYSDATE UPD_DT " ).append("\n"); 
		query.append("            FROM SQM_SCTR_PAIR_MGMT A1, SQM_QTA_LANE_OFC A2" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND A1.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("            AND A1.BSE_TP_CD = @[bse_tp_cd]" ).append("\n"); 
		query.append("            AND A1.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("            AND A1.BSE_QTR_CD = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("            AND A2.SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("            AND A2.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("            AND A2.OFC_VW_CD = SUBSTR(@[ofc_vw_cd], 0,1)" ).append("\n"); 
		query.append("            AND A2.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("            AND A1.PF_GRP_CD = @[pf_grp_cd]" ).append("\n"); 
		query.append("            AND A1.BSE_TP_CD = A2.BSE_TP_CD" ).append("\n"); 
		query.append("            AND A1.BSE_YR = A2.BSE_YR" ).append("\n"); 
		query.append("            AND A1.BSE_QTR_CD = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND A1.TRD_CD = A2.TRD_CD" ).append("\n"); 
		query.append("            AND A1.RLANE_CD = A2.RLANE_CD" ).append("\n"); 
		query.append("            AND A1.DIR_CD = A2.DIR_CD" ).append("\n"); 

	}
}