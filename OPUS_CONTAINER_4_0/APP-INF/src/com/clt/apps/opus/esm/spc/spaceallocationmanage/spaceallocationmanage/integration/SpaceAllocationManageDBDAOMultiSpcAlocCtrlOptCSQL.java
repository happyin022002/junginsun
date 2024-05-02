/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOMultiSpcAlocCtrlOptCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOMultiSpcAlocCtrlOptCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_ALOC_POL_POD의 지정된 ibflag 값에 따라 DB에 반영한다. (추가).
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOMultiSpcAlocCtrlOptCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_wgt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_53ft_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_lvl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_port_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_40ft_hc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_spc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_45ft_hc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_rf_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOMultiSpcAlocCtrlOptCSQL").append("\n"); 
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
		query.append("MERGE INTO SPC_ALOC_CTRL_OPT A USING  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    (SELECT @[rlane_cd] AS RLANE_CD " ).append("\n"); 
		query.append("         , @[dir_cd] AS DIR_CD " ).append("\n"); 
		query.append("         , @[vsl_cd] AS VSL_CD " ).append("\n"); 
		query.append("         , @[skd_voy_no] AS SKD_VOY_NO " ).append("\n"); 
		query.append("         , @[skd_dir_cd] AS SKD_DIR_CD " ).append("\n"); 
		query.append("         , SAQ_GET_REP_TRD_FNC(@[rlane_cd]) AS REP_TRD_CD " ).append("\n"); 
		query.append("         , SAQ_GET_REP_SUB_TRD_FNC(@[rlane_cd]) AS REP_SUB_TRD_CD " ).append("\n"); 
		query.append("         , @[ctrl_port_flg] AS CTRL_PORT_FLG " ).append("\n"); 
		query.append("         , @[ctrl_wgt_flg] AS CTRL_WGT_FLG " ).append("\n"); 
		query.append("         , @[ctrl_spc_flg] AS CTRL_SPC_FLG " ).append("\n"); 
		query.append("         , @[ctrl_40ft_hc_flg] AS CTRL_40FT_HC_FLG " ).append("\n"); 
		query.append("         , @[ctrl_45ft_hc_flg] AS CTRL_45FT_HC_FLG " ).append("\n"); 
		query.append("         , @[ctrl_53ft_flg] AS CTRL_53FT_FLG " ).append("\n"); 
		query.append("         , @[ctrl_rf_flg] AS CTRL_RF_FLG " ).append("\n"); 
		query.append("         , 'N' AS CTRL_TS_FLG " ).append("\n"); 
		query.append("         , @[ctrl_lvl_cd] AS CTRL_LVL_CD " ).append("\n"); 
		query.append("         , @[upd_usr_id] AS CRE_USR_ID " ).append("\n"); 
		query.append("         , SYSDATE AS CRE_DT " ).append("\n"); 
		query.append("         , @[upd_usr_id] AS UPD_USR_ID " ).append("\n"); 
		query.append("         , SYSDATE AS UPD_DT " ).append("\n"); 
		query.append("      FROM DUAL " ).append("\n"); 
		query.append("    ) B " ).append("\n"); 
		query.append("    ON ( A.SKD_DIR_CD = B.SKD_DIR_CD " ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = B.SKD_VOY_NO " ).append("\n"); 
		query.append("           AND A.VSL_CD = B.VSL_CD " ).append("\n"); 
		query.append("           AND A.DIR_CD = B.DIR_CD " ).append("\n"); 
		query.append("           AND A.RLANE_CD = B.RLANE_CD ) " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("       UPDATE " ).append("\n"); 
		query.append("              SET A.CTRL_PORT_FLG = B.CTRL_PORT_FLG " ).append("\n"); 
		query.append("            , A.CTRL_WGT_FLG = B.CTRL_WGT_FLG " ).append("\n"); 
		query.append("            , A.CTRL_SPC_FLG = B.CTRL_SPC_FLG " ).append("\n"); 
		query.append("            , A.CTRL_40FT_HC_FLG = B.CTRL_40FT_HC_FLG " ).append("\n"); 
		query.append("            , A.CTRL_45FT_HC_FLG = B.CTRL_45FT_HC_FLG " ).append("\n"); 
		query.append("            , A.CTRL_53FT_FLG = B.CTRL_53FT_FLG " ).append("\n"); 
		query.append("            , A.CTRL_RF_FLG = B.CTRL_RF_FLG " ).append("\n"); 
		query.append("            , A.CTRL_LVL_CD = B.CTRL_LVL_CD " ).append("\n"); 
		query.append("            , A.UPD_USR_ID = B.UPD_USR_ID " ).append("\n"); 
		query.append("            , A.UPD_DT = B.UPD_DT " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("       INSERT " ).append("\n"); 
		query.append("              ( " ).append("\n"); 
		query.append("                  A.RLANE_CD " ).append("\n"); 
		query.append("                , A.DIR_CD " ).append("\n"); 
		query.append("                , A.VSL_CD " ).append("\n"); 
		query.append("                , A.SKD_VOY_NO " ).append("\n"); 
		query.append("                , A.SKD_DIR_CD " ).append("\n"); 
		query.append("                , A.REP_TRD_CD " ).append("\n"); 
		query.append("                , A.REP_SUB_TRD_CD " ).append("\n"); 
		query.append("                , A.CTRL_PORT_FLG " ).append("\n"); 
		query.append("                , A.CTRL_WGT_FLG " ).append("\n"); 
		query.append("                , A.CTRL_SPC_FLG " ).append("\n"); 
		query.append("                , A.CTRL_40FT_HC_FLG " ).append("\n"); 
		query.append("                , A.CTRL_45FT_HC_FLG " ).append("\n"); 
		query.append("                , A.CTRL_53FT_FLG " ).append("\n"); 
		query.append("                , A.CTRL_RF_FLG " ).append("\n"); 
		query.append("                , A.CTRL_TS_FLG " ).append("\n"); 
		query.append("                , A.CTRL_LVL_CD " ).append("\n"); 
		query.append("                , A.CRE_USR_ID " ).append("\n"); 
		query.append("                , A.CRE_DT " ).append("\n"); 
		query.append("                , A.UPD_USR_ID " ).append("\n"); 
		query.append("                , A.UPD_DT " ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("              VALUES " ).append("\n"); 
		query.append("              ( " ).append("\n"); 
		query.append("                  B.RLANE_CD " ).append("\n"); 
		query.append("                , B.DIR_CD " ).append("\n"); 
		query.append("                , B.VSL_CD " ).append("\n"); 
		query.append("                , B.SKD_VOY_NO " ).append("\n"); 
		query.append("                , B.SKD_DIR_CD " ).append("\n"); 
		query.append("                , B.REP_TRD_CD " ).append("\n"); 
		query.append("                , B.REP_SUB_TRD_CD " ).append("\n"); 
		query.append("                , B.CTRL_PORT_FLG " ).append("\n"); 
		query.append("                , B.CTRL_WGT_FLG " ).append("\n"); 
		query.append("                , B.CTRL_SPC_FLG " ).append("\n"); 
		query.append("                , B.CTRL_40FT_HC_FLG " ).append("\n"); 
		query.append("                , B.CTRL_45FT_HC_FLG " ).append("\n"); 
		query.append("                , B.CTRL_53FT_FLG " ).append("\n"); 
		query.append("                , B.CTRL_RF_FLG " ).append("\n"); 
		query.append("                , B.CTRL_TS_FLG " ).append("\n"); 
		query.append("                , B.CTRL_LVL_CD " ).append("\n"); 
		query.append("                , B.CRE_USR_ID " ).append("\n"); 
		query.append("                , B.CRE_DT " ).append("\n"); 
		query.append("                , B.UPD_USR_ID " ).append("\n"); 
		query.append("                , B.UPD_DT " ).append("\n"); 
		query.append("              )" ).append("\n"); 

	}
}