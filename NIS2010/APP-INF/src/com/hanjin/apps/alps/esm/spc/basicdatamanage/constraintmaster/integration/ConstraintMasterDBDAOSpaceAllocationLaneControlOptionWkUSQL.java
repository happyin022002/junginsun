/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOSpaceAllocationLaneControlOptionWkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.10
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.07.10 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOSpaceAllocationLaneControlOptionWkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 노선별 Control Option의 적용 주차를 조정한다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * ConstraintMasterDBDAOSpaceAllocationLaneControlOptionWkUSQL.Query- 패키지 이동으로 신규 생성
	  * </pre>
	  */
	public ConstraintMasterDBDAOSpaceAllocationLaneControlOptionWkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_fm_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_to_yrwk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aply_fm_yrwk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOSpaceAllocationLaneControlOptionWkUSQL").append("\n"); 
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
		query.append("UPDATE SPC_ALOC_LANE_CTRL_OPT" ).append("\n"); 
		query.append("   SET APLY_TO_YRWK      = (SELECT /*+ INDEX_DESC (A XPKMAS_WK_PRD ) */" ).append("\n"); 
		query.append("                                   COST_YR||COST_WK" ).append("\n"); 
		query.append("                              FROM MAS_WK_PRD A" ).append("\n"); 
		query.append("                             WHERE COST_YR = SUBSTR(@[aply_fm_yrwk], 1, 4)" ).append("\n"); 
		query.append("                               AND COST_WK < SUBSTR(@[aply_fm_yrwk], 5)" ).append("\n"); 
		query.append("                               AND ROWNUM  = 1)," ).append("\n"); 
		query.append("       UPD_USR_ID        = @[upd_usr_id]       ," ).append("\n"); 
		query.append("       UPD_DT            = SYSDATE" ).append("\n"); 
		query.append(" WHERE TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("   AND SUB_TRD_CD   = @[sub_trd_cd] " ).append("\n"); 
		query.append("   AND RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("   AND DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append("   AND ((      @[aply_fm_yrwk] BETWEEN APLY_FM_YRWK AND APLY_TO_YRWK" ).append("\n"); 
		query.append("          AND (APLY_FM_YRWK <> @[tmp_fm_yrwk] OR APLY_TO_YRWK <> @[tmp_to_yrwk]))" ).append("\n"); 
		query.append("         OR" ).append("\n"); 
		query.append("         (     APLY_FM_YRWK = @[tmp_fm_yrwk] AND APLY_TO_YRWK = @[tmp_to_yrwk] )" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}