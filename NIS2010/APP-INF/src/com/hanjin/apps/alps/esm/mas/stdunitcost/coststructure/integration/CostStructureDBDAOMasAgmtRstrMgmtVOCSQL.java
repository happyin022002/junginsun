/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostStructureDBDAOMasAgmtRstrMgmtVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.11.05 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Yeong-seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOMasAgmtRstrMgmtVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * _AGMT_RSTR_MGMT 테이블의 데이터 업데이트
	  * 
	  * </pre>
	  */
	public CostStructureDBDAOMasAgmtRstrMgmtVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mas_cost_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_src_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOMasAgmtRstrMgmtVOCSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_AGMT_RSTR_MGMT B1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT  @[loc_delt_flg] LOC_DELT_FLG" ).append("\n"); 
		query.append(",@[loc_grp_tp_cd] LOC_GRP_TP_CD" ).append("\n"); 
		query.append(",DECODE(@[n1st_nod_cd],'', '  ', @[n1st_nod_cd]) N1ST_NOD_CD" ).append("\n"); 
		query.append(",DECODE(@[n2nd_nod_cd],'', '  ', @[n2nd_nod_cd]) N2ND_NOD_CD" ).append("\n"); 
		query.append(",DECODE(@[n3rd_nod_cd],'', '  ', @[n3rd_nod_cd]) N3RD_NOD_CD" ).append("\n"); 
		query.append(",DECODE(@[n4th_nod_cd],'', '  ', @[n4th_nod_cd]) N4TH_NOD_CD" ).append("\n"); 
		query.append(",@[mas_cost_src_cd] MAS_COST_SRC_CD" ).append("\n"); 
		query.append(",@[cost_src_use_flg] COST_SRC_USE_FLG" ).append("\n"); 
		query.append(",@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM  DUAL ) B2" ).append("\n"); 
		query.append("ON  (    	B1.LOC_GRP_TP_CD = B2.LOC_GRP_TP_CD" ).append("\n"); 
		query.append("AND B1.N1ST_NOD_CD = B2.N1ST_NOD_CD" ).append("\n"); 
		query.append("AND B1.N2ND_NOD_CD = B2.N2ND_NOD_CD" ).append("\n"); 
		query.append("AND B1.N3RD_NOD_CD = B2.N3RD_NOD_CD" ).append("\n"); 
		query.append("AND B1.N4TH_NOD_CD = B2.N4TH_NOD_CD" ).append("\n"); 
		query.append("AND B1.MAS_COST_SRC_CD = B2.MAS_COST_SRC_CD	)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET  B1.LOC_DELT_FLG      = @[loc_delt_flg]" ).append("\n"); 
		query.append(",B1.COST_SRC_USE_FLG  = B2.COST_SRC_USE_FLG" ).append("\n"); 
		query.append(",B1.UPD_USR_ID        = B2.UPD_USR_ID" ).append("\n"); 
		query.append(",B1.UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("B1.LOC_GRP_TP_CD" ).append("\n"); 
		query.append(",B1.N1ST_NOD_CD,B1.N2ND_NOD_CD" ).append("\n"); 
		query.append(",B1.N3RD_NOD_CD" ).append("\n"); 
		query.append(",B1.N4TH_NOD_CD" ).append("\n"); 
		query.append(",B1.MAS_COST_SRC_CD" ).append("\n"); 
		query.append(",B1.LOC_DELT_FLG" ).append("\n"); 
		query.append(",B1.COST_SRC_USE_FLG" ).append("\n"); 
		query.append(",B1.CRE_USR_ID" ).append("\n"); 
		query.append(",B1.CRE_DT" ).append("\n"); 
		query.append(",B1.UPD_USR_ID" ).append("\n"); 
		query.append(",B1.UPD_DT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("B2.LOC_GRP_TP_CD" ).append("\n"); 
		query.append(",B2.N1ST_NOD_CD" ).append("\n"); 
		query.append(",B2.N2ND_NOD_CD" ).append("\n"); 
		query.append(",B2.N3RD_NOD_CD" ).append("\n"); 
		query.append(",B2.N4TH_NOD_CD" ).append("\n"); 
		query.append(",B2.MAS_COST_SRC_CD" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",@[cost_src_use_flg]" ).append("\n"); 
		query.append(",B2.UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",B2.UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}