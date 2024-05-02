/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BSAManageDBDAOCheckBSARateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOCheckBSARateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BSAManageDBDAOCheckBSARateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vop_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOCheckBSARateRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUM(CASE WHEN BSA_FM_DT = @[bsa_fm_dt] AND BSA_TO_DT = @[bsa_to_dt]" ).append("\n"); 
		query.append("                     AND DELT_FLG     = 'N' " ).append("\n"); 
		query.append("                    THEN 1 ELSE 0 END),0) AS CNT" ).append("\n"); 
		query.append("      ,NVL(SUM(CASE WHEN @[bsa_fm_dt] BETWEEN BSA_FM_DT AND BSA_TO_DT" ).append("\n"); 
		query.append("                     AND DELT_FLG     = 'N' " ).append("\n"); 
		query.append("                    THEN 1 " ).append("\n"); 
		query.append("                    WHEN @[bsa_to_dt] BETWEEN BSA_FM_DT AND BSA_TO_DT" ).append("\n"); 
		query.append("                     AND DELT_FLG     = 'N'                  " ).append("\n"); 
		query.append("                    THEN 1 ELSE 0 END),0) AS CNT" ).append("\n"); 
		query.append("   FROM BSA_HIGH_CUBIC_RT_MST " ).append("\n"); 
		query.append("  WHERE CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("    AND TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("    AND RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("    AND DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append("    AND VOP_CD       = @[vop_cd]" ).append("\n"); 

	}
}