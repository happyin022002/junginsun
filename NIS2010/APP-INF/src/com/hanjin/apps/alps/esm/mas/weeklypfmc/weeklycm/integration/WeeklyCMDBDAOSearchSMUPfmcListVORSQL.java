/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchSMUPfmcListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.10.14 박수훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SOO HOON PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchSMUPfmcListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SMU 단가 조회   
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchSMUPfmcListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchSMUPfmcListVORSQL").append("\n"); 
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
		query.append("SELECT B2.COST_YRMON" ).append("\n"); 
		query.append(",B2.TRD_CD" ).append("\n"); 
		query.append(",B2.SUB_TRD_CD" ).append("\n"); 
		query.append(",B2.RLANE_CD" ).append("\n"); 
		query.append(",B2.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append(",B2.COST_LANE_TP_CD" ).append("\n"); 
		query.append(",DECODE(B2.COST_LANE_TP_CD, 'L', 'Local', 'T/S') AS COST_LANE_TP_NM" ).append("\n"); 
		query.append(",B1.BSE_UC_AMT" ).append("\n"); 
		query.append(",B1.PLCY_PRC_UT_AMT" ).append("\n"); 
		query.append("FROM MAS_SLT_MGMT_UT B1" ).append("\n"); 
		query.append(",(SELECT DISTINCT A2.COST_YRMON" ).append("\n"); 
		query.append(",A1.TRD_CD" ).append("\n"); 
		query.append(",A1.SUB_TRD_CD" ).append("\n"); 
		query.append(",A1.RLANE_CD" ).append("\n"); 
		query.append(",A1.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append(",A3.COST_LANE_TP_CD" ).append("\n"); 
		query.append("FROM MDM_DTL_REV_LANE A1" ).append("\n"); 
		query.append(",MAS_MON_VVD A2" ).append("\n"); 
		query.append(",( SELECT DECODE(LEVEL, 1, 'L', 'T') COST_LANE_TP_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("CONNECT BY ROWNUM < 3) A3" ).append("\n"); 
		query.append("WHERE A1.SUB_TRD_CD <> 'IP'" ).append("\n"); 
		query.append("AND A1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A1.RLANE_CD = A2.RLANE_CD" ).append("\n"); 
		query.append("AND A1.IOC_CD = A2.IOC_CD" ).append("\n"); 
		query.append("AND A1.TRD_CD = A2.TRD_CD" ).append("\n"); 
		query.append("AND A1.VSL_SLAN_DIR_CD = A2.DIR_CD" ).append("\n"); 
		query.append("AND A2.COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("AND A1.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("AND A1.TRD_CD = NVL(@[f_trd_cd], A1.TRD_CD)" ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD = NVL(@[f_sub_trd_cd], A1.SUB_TRD_CD)" ).append("\n"); 
		query.append("AND A1.RLANE_CD = NVL(@[f_rlane_cd], A1.RLANE_CD)" ).append("\n"); 
		query.append("AND A1.VSL_SLAN_DIR_CD = NVL(@[f_dir_cd], A1.VSL_SLAN_DIR_CD)" ).append("\n"); 
		query.append(") B2" ).append("\n"); 
		query.append("WHERE B2.TRD_CD = B1.TRD_CD(+)" ).append("\n"); 
		query.append("AND B2.RLANE_CD = B1.RLANE_CD(+)" ).append("\n"); 
		query.append("AND B2.VSL_SLAN_DIR_CD = B1.VSL_SLAN_DIR_CD(+)" ).append("\n"); 
		query.append("AND B2.COST_LANE_TP_CD = B1.COST_LANE_TP_CD(+)" ).append("\n"); 
		query.append("AND B1.COST_YRMON(+) = @[f_cost_yrmon]" ).append("\n"); 
		query.append("ORDER BY 1, 2, 3, 4, 5, 6" ).append("\n"); 

	}
}