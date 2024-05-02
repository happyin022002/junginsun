/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MaxLoadFactorDBDAOMultiSpcMaxLodFctrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.02.03 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.maxloadfactor.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MaxLoadFactorDBDAOMultiSpcMaxLodFctrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MAX  L/F INSERT
	  * </pre>
	  */
	public MaxLoadFactorDBDAOMultiSpcMaxLodFctrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_diff_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_ldf_rto",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelconstraintmanage.maxloadfactor.integration").append("\n"); 
		query.append("FileName : MaxLoadFactorDBDAOMultiSpcMaxLodFctrCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_MAX_LOD_FCTR (" ).append("\n"); 
		query.append("    BSE_YR     ," ).append("\n"); 
		query.append("    VOY_DIFF_WK," ).append("\n"); 
		query.append("    RLANE_CD   ," ).append("\n"); 
		query.append("    DIR_CD     ," ).append("\n"); 
		query.append("    TRD_CD     ," ).append("\n"); 
		query.append("    SUB_TRD_CD ," ).append("\n"); 
		query.append("    MAX_LDF_RTO," ).append("\n"); 
		query.append("    CRE_USR_ID ," ).append("\n"); 
		query.append("    CRE_DT     ," ).append("\n"); 
		query.append("    UPD_USR_ID ," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[bse_yr]             ," ).append("\n"); 
		query.append("    @[voy_diff_wk]        ," ).append("\n"); 
		query.append("    @[rlane_cd]           ," ).append("\n"); 
		query.append("    @[dir_cd]             ," ).append("\n"); 
		query.append("    @[trd_cd]             ," ).append("\n"); 
		query.append("    @[sub_trd_cd]         ," ).append("\n"); 
		query.append("    NVL(@[max_ldf_rto], 0)," ).append("\n"); 
		query.append("    @[cre_usr_id]         ," ).append("\n"); 
		query.append("    SYSDATE               ," ).append("\n"); 
		query.append("    @[upd_usr_id]         ," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}