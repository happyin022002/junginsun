/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostSetUpDBDAOCreateManualCostStupCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.15
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.10.15 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOCreateManualCostStupCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CostSetUpDBDAOCreateManualCostStupCopyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tar_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_src_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOCreateManualCostStupCopyCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_MNL_COST_STUP" ).append("\n"); 
		query.append("(COST_YRMON,COST_WK,TRD_CD,RLANE_CD,IOC_CD,DIR_CD,SUB_TRD_CD,OTR_EXPN_AMT," ).append("\n"); 
		query.append("CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("SELECT @[f_tar_mon] AS COST_YRMON,COST_WK,TRD_CD,RLANE_CD,IOC_CD,DIR_CD,SUB_TRD_CD,OTR_EXPN_AMT," ).append("\n"); 
		query.append("       @[user_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("       SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("       @[user_id] AS UPD_USR_ID," ).append("\n"); 
		query.append("       SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("  FROM COA_MNL_COST_STUP" ).append("\n"); 
		query.append(" WHERE COST_YRMON     = @[f_src_mon]  " ).append("\n"); 
		query.append("   AND RLANE_CD = 'CNTTS'" ).append("\n"); 
		query.append("   AND COST_WK = 'XX'" ).append("\n"); 

	}
}