/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : QtaAdjustmentDBDAOSearchApplyWeekRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.27
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.12.27 이혜민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOSearchApplyWeekRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Portion Adjustment by Head Office]에서 vvd의 주차를 [조회] 합니다.
	  * </pre>
	  */
	public QtaAdjustmentDBDAOSearchApplyWeekRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOSearchApplyWeekRSQL").append("\n"); 
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
		query.append("SELECT COST_WK AS BSE_WK " ).append("\n"); 
		query.append("  FROM COA_MON_VVD " ).append("\n"); 
		query.append("WHERE SLS_YRMON   LIKE @[f_bse_yr]||'%'" ).append("\n"); 
		query.append("  AND TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("  AND RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("  AND DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("  AND VSL_CD      = SUBSTR(@[vvd],0,4)" ).append("\n"); 
		query.append("  AND SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("  AND DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("  AND DELT_FLG    = 'N'" ).append("\n"); 

	}
}