/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoThresholdManageDBDAODeleteExecutionFeedBackExptDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.11.05 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepoThresholdManageDBDAODeleteExecutionFeedBackExptDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_REPO_EXE_PLN_FB_EXPT 테이블의 데이터 삭제
	  * </pre>
	  */
	public RepoThresholdManageDBDAODeleteExecutionFeedBackExptDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fb_itm_bse_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fb_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_bse_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.integration").append("\n"); 
		query.append("FileName : RepoThresholdManageDBDAODeleteExecutionFeedBackExptDSQL").append("\n"); 
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
		query.append("DELETE FROM" ).append("\n"); 
		query.append("EQR_REPO_EXE_PLN_FB_EXPT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("FB_ITM_CD      = @[fb_itm_cd]" ).append("\n"); 
		query.append("#if (${ismain} == 'N')" ).append("\n"); 
		query.append("AND   FB_ITM_BSE_CD  = @[fb_itm_bse_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND   FB_ITM_BSE_CD  = @[old_bse_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ismain} == 'N')" ).append("\n"); 
		query.append("AND   LOC_GRP_CD	 = @[loc_grp_cd]" ).append("\n"); 
		query.append("AND   LOC_CD         = @[loc_cd]" ).append("\n"); 
		query.append("AND   CNTR_TPSZ_CD   = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}