/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkDistributionDBDAOManageSPCHJSSalesAmountUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOManageSPCHJSSalesAmountUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_INCOME 컬럼 수정
	  * </pre>
	  */
	public NetworkDistributionDBDAOManageSPCHJSSalesAmountUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spc_income",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration ").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOManageSPCHJSSalesAmountUSQL").append("\n"); 
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
		query.append("UPDATE	BSA_VVD_MST" ).append("\n"); 
		query.append("SET		INCM_BZC_CHTR_AMT = @[spc_income]" ).append("\n"); 
		query.append("							- (SELECT	INCM_SUB_CHTR_AMT" ).append("\n"); 
		query.append("							   FROM		BSA_VVD_MST" ).append("\n"); 
		query.append("							   WHERE	1 = 1" ).append("\n"); 
		query.append("							   AND		TRD_CD		= @[trd_cd]" ).append("\n"); 
		query.append("							   AND		RLANE_CD	= @[rlane_cd]" ).append("\n"); 
		query.append("							   AND		VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("							   AND		SKD_VOY_NO	= @[skd_voy_no]" ).append("\n"); 
		query.append("							   AND		SKD_DIR_CD	= @[dir_cd])" ).append("\n"); 
		query.append("							- (SELECT	INCM_CRS_CHTR_AMT" ).append("\n"); 
		query.append("							   FROM		BSA_VVD_MST" ).append("\n"); 
		query.append("							   WHERE	1 = 1" ).append("\n"); 
		query.append("							   AND		TRD_CD		= @[trd_cd]" ).append("\n"); 
		query.append("							   AND		RLANE_CD	= @[rlane_cd]" ).append("\n"); 
		query.append("							   AND		VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("							   AND		SKD_VOY_NO	= @[skd_voy_no]" ).append("\n"); 
		query.append("							   AND		SKD_DIR_CD	= @[dir_cd])" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("AND		TRD_CD		= @[trd_cd]" ).append("\n"); 
		query.append("AND		RLANE_CD	= @[rlane_cd]" ).append("\n"); 
		query.append("AND		VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("AND		SKD_VOY_NO	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND		SKD_DIR_CD	= @[dir_cd]" ).append("\n"); 

	}
}