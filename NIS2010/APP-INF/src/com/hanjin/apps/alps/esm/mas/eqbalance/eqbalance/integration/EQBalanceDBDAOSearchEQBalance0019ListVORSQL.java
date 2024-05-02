/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQBalanceDBDAOSearchEQBalance0019ListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.10.13 박수훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SOO HOON PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQBalanceDBDAOSearchEQBalance0019ListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MT 회송비 조회   
	  * </pre>
	  */
	public EQBalanceDBDAOSearchEQBalance0019ListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_mty_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_mty_lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_mty_rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.integration").append("\n"); 
		query.append("FileName : EQBalanceDBDAOSearchEQBalance0019ListVORSQL").append("\n"); 
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
		query.append("SELECT  A.ECC_CD ECC_CD" ).append("\n"); 
		query.append(",A.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append(",A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",A.MTY_STVG_UC_AMT" ).append("\n"); 
		query.append(",A.MTY_TRSP_UC_AMT" ).append("\n"); 
		query.append(",A.MTY_TZ_DYS" ).append("\n"); 
		query.append("FROM MAS_MTY_ECC_CNTR_SMRY A, MAS_SPCL_REPO_CNTR_RGST C" ).append("\n"); 
		query.append("WHERE A.COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("AND NVL(C.REPO_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("AND A.MTY_REPO_SIM_CD = 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_cost_loc_grp_cd} == 'E')" ).append("\n"); 
		query.append("#if (${f_mty_ecc_cd} != '')" ).append("\n"); 
		query.append("AND A.ECC_CD = @[f_mty_ecc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${f_cost_loc_grp_cd} == 'L')" ).append("\n"); 
		query.append("#if (${f_mty_lcc_cd} != '')" ).append("\n"); 
		query.append("AND A.ECC_CD = @[f_mty_lcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${f_cost_loc_grp_cd} == 'R')" ).append("\n"); 
		query.append("#if (${f_mty_rcc_cd} != '')" ).append("\n"); 
		query.append("AND A.ECC_CD = @[f_mty_rcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_cost_loc_grp_cd} != '')" ).append("\n"); 
		query.append("AND A.COST_LOC_GRP_CD = @[f_cost_loc_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.ECC_CD, A.CNTR_ORG_DEST_CD, A.CNTR_TPSZ_CD" ).append("\n"); 

	}
}