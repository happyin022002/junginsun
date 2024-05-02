/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSpaceAllocationLaneControlOptionDetailDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.24 
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

public class SpaceAllocationManageDBDAOSpaceAllocationLaneControlOptionDetailDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpaceAllocationManageDBDAOSpaceAllocationLaneControlOptionDetailDSQL
	  * 2014.12.08 신자영 [CHM-201433097] Control Option - A/C 및 CDMT추가 건 상세
	  * 2015.01.02 Arie [CHM-201433401]Control Option Registration - Upload기능 추가 요청
	  * 2015.01.30 신자영 [CHM-201533908] Control Option 보완
	  * 2015.06.24 이혜민 [CHM-201535810] [SPC] Fixed Rate 계약 정보의 SPC 적용 개발 요청
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSpaceAllocationLaneControlOptionDetailDSQL(){
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
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSpaceAllocationLaneControlOptionDetailDSQL").append("\n"); 
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
		query.append("DELETE FROM SPC_ALOC_LANE_CTRL_OPT_DTL" ).append("\n"); 
		query.append(" WHERE TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("   AND SUB_TRD_CD       = @[sub_trd_cd]" ).append("\n"); 
		query.append("   AND RLANE_CD         = @[rlane_cd]  " ).append("\n"); 
		query.append("   AND DIR_CD           = @[dir_cd]" ).append("\n"); 
		query.append("   AND ALOC_CTRL_TP_CD  = @[aloc_ctrl_tp_cd]" ).append("\n"); 
		query.append("   AND CTRL_LOC_ACCT_CD = @[ctrl_loc_acct_cd]" ).append("\n"); 
		query.append("   AND SC_NO  = NVL(@[sc_no], '*')" ).append("\n"); 
		query.append("   AND RFA_NO = NVL(@[rfa_no], '*')" ).append("\n"); 
		query.append("   AND ALOC_CTRL_DTL_CD = NVL(DECODE(@[aloc_ctrl_tp_cd], 'F', @[ctrl_loc_acct_cd], @[aloc_ctrl_dtl_cd]), '*')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("DELETE FROM SPC_ALOC_LANE_CTRL_OPT_DTL" ).append("\n"); 
		query.append(" WHERE TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("   AND SUB_TRD_CD       = @[sub_trd_cd]" ).append("\n"); 
		query.append("   AND RLANE_CD         = @[rlane_cd]  " ).append("\n"); 
		query.append("   AND DIR_CD           = @[dir_cd]" ).append("\n"); 
		query.append("   AND ALOC_CTRL_TP_CD  = @[aloc_ctrl_tp_cd]" ).append("\n"); 
		query.append("   AND CTRL_LOC_ACCT_CD = @[ctrl_loc_acct_cd]" ).append("\n"); 
		query.append("   AND SC_NO  = NVL(@[sc_no], '*')" ).append("\n"); 
		query.append("   AND RFA_NO = NVL(@[rfa_no], '*')" ).append("\n"); 
		query.append("AND ALOC_CTRL_DTL_CD = NVL(DECODE(@[aloc_ctrl_tp_cd], 'F', @[ctrl_loc_acct_cd], @[aloc_ctrl_dtl_cd]), '*')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}