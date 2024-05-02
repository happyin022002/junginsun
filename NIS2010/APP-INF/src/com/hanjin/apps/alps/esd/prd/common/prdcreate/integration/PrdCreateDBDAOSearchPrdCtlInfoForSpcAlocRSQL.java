/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdCreateDBDAOSearchPrdCtlInfoForSpcAlocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.09.17 정선용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcreate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateDBDAOSearchPrdCtlInfoForSpcAlocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPrdCtlInfoForSpcAloc
	  * </pre>
	  */
	public PrdCreateDBDAOSearchPrdCtlInfoForSpcAlocRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.common.prdcreate.integration ").append("\n"); 
		query.append("FileName : PrdCreateDBDAOSearchPrdCtlInfoForSpcAlocRSQL").append("\n"); 
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
		query.append("SELECT M.PCTL_NO," ).append("\n"); 
		query.append("D.PCTL_SEQ," ).append("\n"); 
		query.append("D.ORG_NOD_CD," ).append("\n"); 
		query.append("DEST_NOD_CD," ).append("\n"); 
		query.append("D.VSL_SLAN_CD," ).append("\n"); 
		query.append("D.VSL_CD," ).append("\n"); 
		query.append("D.SKD_VOY_NO," ).append("\n"); 
		query.append("D.SKD_DIR_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN M.TRNK_VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("AND M.TRNK_SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("AND M.TRNK_SKD_DIR_CD = D.SKD_DIR_CD THEN 'N'" ).append("\n"); 
		query.append("ELSE 'Y'" ).append("\n"); 
		query.append("END) TS_FLG," ).append("\n"); 
		query.append("COA_SLANE_RLANE_CONV_FNC(D.SKD_DIR_CD, D.VSL_SLAN_CD, SUBSTR(D.ORG_NOD_CD, 1, 5), SUBSTR(D.DEST_NOD_CD, 1, 5)) R_LANE_CD," ).append("\n"); 
		query.append("M.SLS_OFC_CD," ).append("\n"); 
		query.append("M.SC_CUST_CNT_CD," ).append("\n"); 
		query.append("M.SC_CUST_SEQ," ).append("\n"); 
		query.append("M.SHPR_CNT_CD," ).append("\n"); 
		query.append("M.SHPR_SEQ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT CONTI_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = SUBSTR(D.ORG_NOD_CD, 1, 5)) ORG_CONTI_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT CONTI_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = SUBSTR(D.DEST_NOD_CD, 1, 5)) DEST_CONTI_CD" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_MST M," ).append("\n"); 
		query.append("PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("WHERE M.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("AND M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("AND D.PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("AND D.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("AND D.VSL_SLAN_CD IS NOT NULL" ).append("\n"); 
		query.append("AND D.TRSP_MOD_CD IN ('WD','VD')" ).append("\n"); 

	}
}