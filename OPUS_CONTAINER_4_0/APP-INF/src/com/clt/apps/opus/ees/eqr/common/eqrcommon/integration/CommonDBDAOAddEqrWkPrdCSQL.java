/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CommonDBDAOAddEqrWkPrdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOAddEqrWkPrdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR의 주차 정보를 등록한다.
	  * </pre>
	  */
	public CommonDBDAOAddEqrWkPrdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wk_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pln_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wk_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ").append("\n"); 
		query.append("FileName : CommonDBDAOAddEqrWkPrdCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_WK_PRD" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    PLN_YR" ).append("\n"); 
		query.append("   ,PLN_WK" ).append("\n"); 
		query.append("   ,PLN_MON" ).append("\n"); 
		query.append("   ,WK_ST_DT" ).append("\n"); 
		query.append("   ,WK_END_DT" ).append("\n"); 
		query.append("   ,CRE_USR_ID" ).append("\n"); 
		query.append("   ,CRE_DT" ).append("\n"); 
		query.append("   ,UPD_USR_ID" ).append("\n"); 
		query.append("   ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    @[pln_yr]" ).append("\n"); 
		query.append("   ,@[pln_wk]" ).append("\n"); 
		query.append("   ,@[pln_mon]" ).append("\n"); 
		query.append("   ,@[wk_st_dt]" ).append("\n"); 
		query.append("   ,@[wk_end_dt]" ).append("\n"); 
		query.append("   ,@[cre_usr_id] -- 로그인한 유저 ID" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append("   ,@[upd_usr_id] -- 로그인한 유저 ID" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}