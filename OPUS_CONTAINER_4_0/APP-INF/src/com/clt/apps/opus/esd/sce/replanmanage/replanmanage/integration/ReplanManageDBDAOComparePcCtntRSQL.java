/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ReplanManageDBDAOComparePcCtntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOComparePcCtntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * P/C 의 주요 내역을 비교하여 diff 를 찾는다. diff 발생시에만 booking replan 이 수행된다.
	  * </pre>
	  */
	public ReplanManageDBDAOComparePcCtntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOComparePcCtntRSQL").append("\n"); 
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
		query.append("SELECT PCTL_SEQ," ).append("\n"); 
		query.append("  ORG_NOD_CD," ).append("\n"); 
		query.append("  DEST_NOD_CD," ).append("\n"); 
		query.append("  NOD_LNK_DIV_CD," ).append("\n"); 
		query.append("  PCTL_IO_BND_CD," ).append("\n"); 
		query.append("  TRSP_MOD_CD," ).append("\n"); 
		query.append("  ARR_ST_DT," ).append("\n"); 
		query.append("  DEP_FSH_DT" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO = @[old_pctl_no]" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("SELECT PCTL_SEQ," ).append("\n"); 
		query.append("  ORG_NOD_CD," ).append("\n"); 
		query.append("  DEST_NOD_CD," ).append("\n"); 
		query.append("  NOD_LNK_DIV_CD," ).append("\n"); 
		query.append("  PCTL_IO_BND_CD," ).append("\n"); 
		query.append("  TRSP_MOD_CD," ).append("\n"); 
		query.append("  ARR_ST_DT," ).append("\n"); 
		query.append("  DEP_FSH_DT" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO = @[crnt_pctl_no]" ).append("\n"); 

	}
}