/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OfficeMappingDBDAOCreateAddSectorOfcRelSetPolPodCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.17 
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

public class OfficeMappingDBDAOCreateAddSectorOfcRelSetPolPodCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sector Office Relation Setting _ POL POD Pair Add for IAS Sector 추가생성합니다.
	  * *History
	  * 2014.06.23 이혜민 Act_flag를 N으로 수정
	  * 2014.07.09 이혜민 PAIR 추가시 L,C 둘다 생성되도록 조건 삭제
	  * </pre>
	  */
	public OfficeMappingDBDAOCreateAddSectorOfcRelSetPolPodCSQL(){
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : OfficeMappingDBDAOCreateAddSectorOfcRelSetPolPodCSQL").append("\n"); 
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
		query.append("                    'N' SQM_ACT_FLG," ).append("\n"); 
		query.append("                    A1.ADD_FLG," ).append("\n"); 
		query.append("                    @[cre_usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("                    SYSDATE CRE_DT," ).append("\n"); 
		query.append("                    @[upd_usr_id]UPD_USR_ID," ).append("\n"); 
		query.append("                    SYSDATE UPD_DT " ).append("\n"); 
		query.append("            FROM SQM_SCTR_PAIR_MGMT A1, SQM_QTA_LANE_OFC A2" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND A1.BSE_TP_CD  = @[bse_tp_cd]" ).append("\n"); 
		query.append("            AND A1.BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("            AND A1.BSE_QTR_CD = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("            AND A1.POL_CD     = @[pol_cd]" ).append("\n"); 
		query.append("            AND A1.POD_CD     = @[pod_cd]" ).append("\n"); 
		query.append("            AND A2.SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("            AND A2.DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("            AND A2.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("            AND A1.BSE_TP_CD  = A2.BSE_TP_CD" ).append("\n"); 
		query.append("            AND A1.BSE_YR     = A2.BSE_YR" ).append("\n"); 
		query.append("            AND A1.BSE_QTR_CD = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND A1.TRD_CD     = A2.TRD_CD" ).append("\n"); 
		query.append("            AND A1.RLANE_CD   = A2.RLANE_CD" ).append("\n"); 
		query.append("            AND A1.DIR_CD     = A2.DIR_CD" ).append("\n"); 

	}
}