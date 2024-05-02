/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSpaceAllocationLaneControlOptionDetailUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSpaceAllocationLaneControlOptionDetailUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpaceAllocationManageDBDAOSpaceAllocationLaneControlOptionDetailUSQL
	  * 2014.12.08 신자영 [CHM-201433097] Control Option - A/C 및 CDMT추가 건 상세
	  * 2015.01.02 Arie [CHM-201433401]Control Option Registration - Upload기능 추가 요청
	  * 2015.01.30 신자영 [CHM-201533908] Control Option 보완
	  * 2015.06.24 이혜민 [CHM-201535810] [SPC] Fixed Rate 계약 정보의 SPC 적용 개발 요청
	  * 2015.07.03 이혜민 [CHM-201536633] Control Option management 보완요청 (Fixed Rate관련)
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSpaceAllocationLaneControlOptionDetailUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("aloc_ctrl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_loc_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_ctrl_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_fx_rt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSpaceAllocationLaneControlOptionDetailUSQL").append("\n"); 
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
		query.append("#if (${is_upload} == 'Y')" ).append("\n"); 
		query.append("MERGE INTO SPC_ALOC_LANE_CTRL_OPT_DTL D1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("    SELECT @[trd_cd] TRD_CD" ).append("\n"); 
		query.append("         , @[sub_trd_cd] SUB_TRD_CD" ).append("\n"); 
		query.append("         , @[rlane_cd] RLANE_CD" ).append("\n"); 
		query.append("         , @[dir_cd] DIR_CD" ).append("\n"); 
		query.append("         , @[aloc_ctrl_tp_cd] ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("         , @[ctrl_loc_acct_cd] CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("         , @[upd_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("         , SYSDATE CRE_DT" ).append("\n"); 
		query.append("         , @[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("         , SYSDATE UPD_DT" ).append("\n"); 
		query.append("         , NVL(@[sc_no], '*')  SC_NO" ).append("\n"); 
		query.append("         , NVL(@[rfa_no], '*') RFA_NO" ).append("\n"); 
		query.append("		 , NVL(DECODE(@[aloc_ctrl_tp_cd], 'F', @[ctrl_loc_acct_cd], @[aloc_ctrl_dtl_cd]), '*') ALOC_CTRL_DTL_CD" ).append("\n"); 
		query.append("		 , DECODE(@[ctrl_fx_rt_flg], '1', 'Y', 'N') CTRL_FX_RT_FLG" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(") D2" ).append("\n"); 
		query.append("ON (D1.TRD_CD = D2.TRD_CD" ).append("\n"); 
		query.append("    AND D1.SUB_TRD_CD = D2.SUB_TRD_CD" ).append("\n"); 
		query.append("    AND D1.RLANE_CD = D2.RLANE_CD" ).append("\n"); 
		query.append("    AND D1.DIR_CD = D2.DIR_CD" ).append("\n"); 
		query.append("    AND D1.ALOC_CTRL_TP_CD = D2.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("    AND D1.CTRL_LOC_ACCT_CD = D2.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("    AND D1.SC_NO = D2.SC_NO" ).append("\n"); 
		query.append("    AND D1.RFA_NO = D2.RFA_NO" ).append("\n"); 
		query.append("	AND D1.ALOC_CTRL_DTL_CD = D2.ALOC_CTRL_DTL_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN											" ).append("\n"); 
		query.append("    UPDATE SET   D1.UPD_USR_ID = D2.UPD_USR_ID" ).append("\n"); 
		query.append("                ,D1.UPD_DT = D2.UPD_DT" ).append("\n"); 
		query.append("                ,D1.CTRL_FX_RT_FLG = D2.CTRL_FX_RT_FLG" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT(" ).append("\n"); 
		query.append("    TRD_CD, " ).append("\n"); 
		query.append("    SUB_TRD_CD, " ).append("\n"); 
		query.append("    RLANE_CD, " ).append("\n"); 
		query.append("    DIR_CD, " ).append("\n"); 
		query.append("    ALOC_CTRL_TP_CD, " ).append("\n"); 
		query.append("    CTRL_LOC_ACCT_CD,     " ).append("\n"); 
		query.append("    CRE_USR_ID, " ).append("\n"); 
		query.append("    CRE_DT, " ).append("\n"); 
		query.append("    UPD_USR_ID, " ).append("\n"); 
		query.append("    UPD_DT," ).append("\n"); 
		query.append("	SC_NO," ).append("\n"); 
		query.append("	RFA_NO," ).append("\n"); 
		query.append("    ALOC_CTRL_DTL_CD," ).append("\n"); 
		query.append("	CTRL_FX_RT_FLG" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("VALUES " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    D2.TRD_CD, " ).append("\n"); 
		query.append("    D2.SUB_TRD_CD, " ).append("\n"); 
		query.append("    D2.RLANE_CD, " ).append("\n"); 
		query.append("    D2.DIR_CD, " ).append("\n"); 
		query.append("    D2.ALOC_CTRL_TP_CD, " ).append("\n"); 
		query.append("    D2.CTRL_LOC_ACCT_CD,     " ).append("\n"); 
		query.append("    D2.CRE_USR_ID, " ).append("\n"); 
		query.append("    D2.CRE_DT, " ).append("\n"); 
		query.append("    D2.UPD_USR_ID, " ).append("\n"); 
		query.append("    D2.UPD_DT," ).append("\n"); 
		query.append("	D2.SC_NO," ).append("\n"); 
		query.append("	D2.RFA_NO," ).append("\n"); 
		query.append("	D2.ALOC_CTRL_DTL_CD," ).append("\n"); 
		query.append("	D2.CTRL_FX_RT_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE SPC_ALOC_LANE_CTRL_OPT_DTL" ).append("\n"); 
		query.append("   SET   CTRL_FX_RT_FLG 	=  DECODE(@[ctrl_fx_rt_flg], '1', 'Y', 'N')," ).append("\n"); 
		query.append("--       CTRL_LOC_ACCT_CD     = @ [ctrl_loc_acct_cd] ," ).append("\n"); 
		query.append("--       UPD_USR_ID           = @ [upd_usr_id]       ," ).append("\n"); 
		query.append("       UPD_DT               = SYSDATE" ).append("\n"); 
		query.append(" WHERE TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("   AND SUB_TRD_CD       = @[sub_trd_cd] " ).append("\n"); 
		query.append("   AND RLANE_CD         = @[rlane_cd]" ).append("\n"); 
		query.append("   AND DIR_CD           = @[dir_cd]" ).append("\n"); 
		query.append("   AND ALOC_CTRL_TP_CD  = @[aloc_ctrl_tp_cd]" ).append("\n"); 
		query.append("   AND NVL(SC_NO, '*')  = NVL(@[sc_no], '*')" ).append("\n"); 
		query.append("   AND NVL(RFA_NO, '*') = NVL(@[rfa_no], '*')" ).append("\n"); 
		query.append("   AND NVL(ALOC_CTRL_DTL_CD, '*') = NVL(DECODE(@[aloc_ctrl_tp_cd], 'F', @[ctrl_loc_acct_cd], @[aloc_ctrl_dtl_cd]), '*')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}