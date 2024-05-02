/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OfficeMappingDBDAOSearchAddSectorOfcRelSetPfGrpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.11 
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

public class OfficeMappingDBDAOSearchAddSectorOfcRelSetPfGrpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sector-Office Relation Setting_Add Creation for IAS Sector List를 조회합니다.
	  * 
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 2016.05.11 CHM-201641591 Sector Office Relation Setting for IAS Sector 화면 및 P/F Skd Group 화면 로직 수정 요청
	  * -Sector Office Relation Setting for IAS Sector _ Add Creation : ADD CREATION에서 추가할 P/F Group의 Route를 보여줄 때, POL-POD Management for IAS Sector에 생성된 데이터의 바운드 데이터까지 참고하도록 로직을 수정
	  * </pre>
	  */
	public OfficeMappingDBDAOSearchAddSectorOfcRelSetPfGrpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ias_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration").append("\n"); 
		query.append("FileName : OfficeMappingDBDAOSearchAddSectorOfcRelSetPfGrpRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("      A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("		FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		WHERE INTG_CD_ID = 'CD03218'" ).append("\n"); 
		query.append("		AND INTG_CD_VAL_CTNT = A2.IAS_RGN_CD) IAS_RGN_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,@[f_dir_cd] DIR_CD" ).append("\n"); 
		query.append("      ,A1.PF_GRP_CD" ).append("\n"); 
		query.append("      ,A1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("      ,A1.PF_ROUT_DESC " ).append("\n"); 
		query.append("FROM SQM_SCTR_PF_GRP A1, MAS_LANE_RGST A2" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND A1.TRD_CD     = A2.TRD_CD" ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD = A2.SUB_TRD_CD" ).append("\n"); 
		query.append("AND A1.RLANE_CD   = A2.RLANE_CD" ).append("\n"); 
		query.append("AND A1.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("AND A1.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#if (${f_ias_rgn_cd} != '' && ${f_ias_rgn_cd} != 'All')" ).append("\n"); 
		query.append("AND A2.IAS_RGN_CD = @[f_ias_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A1.RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("AND A1.PF_GRP_CD NOT IN (SELECT DISTINCT PF_GRP_CD " ).append("\n"); 
		query.append("                FROM SQM_SCTR_LANE_OFC" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                AND RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("                AND OFC_VW_CD  = SUBSTR(@[f_ofc_vw_cd], 0 ,1)" ).append("\n"); 
		query.append("                AND DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("                AND SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("AND EXISTS ( SELECT * FROM SQM_SCTR_PAIR_MGMT B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND B.BSE_TP_CD = A1.BSE_TP_CD" ).append("\n"); 
		query.append("AND B.BSE_YR = A1.BSE_YR" ).append("\n"); 
		query.append("AND B.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("AND B.RLANE_CD = A1.RLANE_CD" ).append("\n"); 
		query.append("AND B.SUB_TRD_CD = A1.SUB_TRD_CD" ).append("\n"); 
		query.append("AND B.PF_GRP_CD = A1.PF_GRP_CD" ).append("\n"); 
		query.append("AND B.DIR_CD = @[f_dir_cd] )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY  A1.SUB_TRD_CD, IAS_RGN_CD, A1.RLANE_CD, DIR_CD, A1.PF_GRP_CD, A1.PF_SVC_TP_CD	" ).append("\n"); 

	}
}