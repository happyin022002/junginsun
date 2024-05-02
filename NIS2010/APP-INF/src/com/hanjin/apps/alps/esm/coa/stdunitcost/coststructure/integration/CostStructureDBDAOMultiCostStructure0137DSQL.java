/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostStructureDBDAOMultiCostStructure0137DSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOMultiCostStructure0137DSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History---------------------------------
	  * 2011.06.34 이행지 [CHM-201111807-01] COA NODE 단가 화면 저장시 발생될 수 있는 문제 해결- R.Lane컬럼 PK추가로 인한 조건추가  
	  * 2014.08.27 박은주 [CHM-201431751] [COA] Link U/C Adjustment 조회/입력조건의 Vendor 추가요청
	  * 2014.10.06 박은주 [CHM-201432147] [COA] Node/Link U/C Adjustment 화면 : COST_ACT_GRP_CD 추가요청
	  * </pre>
	  */
	public CostStructureDBDAOMultiCostStructure0137DSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_cost_src_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOMultiCostStructure0137DSQL").append("\n"); 
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
		query.append("#if (${f_table_name} != 'COA_NOD_AVG_STND_COST') 				" ).append("\n"); 
		query.append("DELETE FROM COA_LNK_AVG_STND_COST" ).append("\n"); 
		query.append(" WHERE COST_YRMON      =  @[cost_yrmon]" ).append("\n"); 
		query.append("   AND LNK_FM_NOD_CD   =  @[lnk_fm_nod_cd]" ).append("\n"); 
		query.append("   AND LNK_TO_NOD_CD   =  @[lnk_to_nod_cd]" ).append("\n"); 
		query.append("   AND CO_CD           =  'H'" ).append("\n"); 
		query.append("   AND CNTR_TPSZ_CD    =  @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("   AND FULL_MTY_CD     =  @[full_mty_cd]" ).append("\n"); 
		query.append("   AND COA_COST_SRC_CD =  @[coa_cost_src_cd]" ).append("\n"); 
		query.append("   AND VNDR_SEQ        =  NVL(@[vndr_seq],0)" ).append("\n"); 
		query.append("   AND COST_ACT_GRP_CD = @[cost_act_grp_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("DELETE FROM COA_NOD_AVG_STND_COST" ).append("\n"); 
		query.append(" WHERE COST_YRMON      = @[cost_yrmon]" ).append("\n"); 
		query.append("   AND FULL_MTY_CD     = @[full_mty_cd]" ).append("\n"); 
		query.append("   AND CNTR_TPSZ_CD    = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("   AND COST_LOC_GRP_CD = @[cost_loc_grp_cd]" ).append("\n"); 
		query.append("   AND NOD_CD          = @[nod_cd]" ).append("\n"); 
		query.append("   AND TRD_CD          = @[trd_cd]" ).append("\n"); 
		query.append("   AND COST_ACT_GRP_CD = @[cost_act_grp_cd]" ).append("\n"); 
		query.append("   AND COA_COST_SRC_CD = @[coa_cost_src_cd]" ).append("\n"); 
		query.append("   AND SLAN_CD         = NVL(@[slan_cd],'NNN')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}