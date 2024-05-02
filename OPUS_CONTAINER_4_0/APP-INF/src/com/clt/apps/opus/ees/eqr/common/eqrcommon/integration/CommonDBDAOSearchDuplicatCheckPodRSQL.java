/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CommonDBDAOSearchDuplicatCheckPodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchDuplicatCheckPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_VSL_LODG_DCHG_PLN 테이블의 중복여부 확인
	  * </pre>
	  */
	public CommonDBDAOSearchDuplicatCheckPodRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_etb",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_etd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchDuplicatCheckPodRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("COUNT(*) CHECKCOUNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_VSL_LODG_DCHG_PLN" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("REPO_PLN_ID = @[pod_repo_pln_id]" ).append("\n"); 
		query.append("AND   PLN_YRWK    = @[pod_wk]" ).append("\n"); 
		query.append("AND   TRSP_MOD_CD ='V'" ).append("\n"); 
		query.append("AND   VSL_LANE_CD = @[pod_lane]" ).append("\n"); 
		query.append("AND   VSL_CD||SKD_VOY_NO||SKD_DIR_CD = @[pod_vvd]" ).append("\n"); 
		query.append("AND   FM_ECC_CD =   @[pod_pol]" ).append("\n"); 
		query.append("AND   FM_ETD_DT = TO_DATE( @[pod_etd] ,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("AND   TO_ECC_CD =  @[pod_pod]" ).append("\n"); 
		query.append("AND   TO_ETB_DT = TO_DATE( @[pod_etb] ,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 

	}
}