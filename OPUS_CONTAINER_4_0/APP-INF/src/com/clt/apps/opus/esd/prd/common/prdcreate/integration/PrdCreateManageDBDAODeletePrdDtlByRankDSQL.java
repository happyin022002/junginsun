/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdCreateManageDBDAODeletePrdDtlByRankDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.09.09 정선용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAODeletePrdDtlByRankDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * deletePrdDtlbyRank
	  * </pre>
	  */
	public PrdCreateManageDBDAODeletePrdDtlByRankDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcreate.integration").append("\n"); 
		query.append("FileName : PrdCreateManageDBDAODeletePrdDtlByRankDSQL").append("\n"); 
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
		query.append("DELETE FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO NOT IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT PCTL_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT PCTL_NO, DENSE_RANK() OVER" ).append("\n"); 
		query.append("(PARTITION BY O_SEQ, T_SEQ, I_SEQ ORDER BY MIN_T_DT, MAX_T_DT ) RK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT PCTL_NO," ).append("\n"); 
		query.append("MIN(DECODE(PCTL_IO_BND_CD,'T',ARR_ST_DT)) MIN_T_DT," ).append("\n"); 
		query.append("MAX(DECODE(PCTL_IO_BND_CD,'T',DEP_FSH_DT)) MAX_T_DT," ).append("\n"); 
		query.append("MAX(DECODE(PCTL_IO_BND_CD,'O',ROUT_SEQ)) O_SEQ," ).append("\n"); 
		query.append("MAX(DECODE(PCTL_IO_BND_CD,'T',ROUT_SEQ)) T_SEQ," ).append("\n"); 
		query.append("MAX(DECODE(PCTL_IO_BND_CD,'I',ROUT_SEQ) )I_SEQ" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 
		query.append("GROUP BY PCTL_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RK =1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND PCTL_NO LIKE  @[hd_pctl_no]||'%'" ).append("\n"); 

	}
}