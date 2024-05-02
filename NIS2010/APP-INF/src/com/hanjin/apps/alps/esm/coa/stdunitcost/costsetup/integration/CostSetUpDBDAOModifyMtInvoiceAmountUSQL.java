/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostSetUpDBDAOModifyMtInvoiceAmountUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.24
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.12.24 최성민
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

public class CostSetUpDBDAOModifyMtInvoiceAmountUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 데이터 수정
	  * </pre>
	  */
	public CostSetUpDBDAOModifyMtInvoiceAmountUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_adj_pl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOModifyMtInvoiceAmountUSQL").append("\n"); 
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
		query.append("--================================" ).append("\n"); 
		query.append("-- SAVE - SEL 체크시 업데이트" ).append("\n"); 
		query.append("--================================" ).append("\n"); 
		query.append("UPDATE COA_MTY_REPO_COST_DTL" ).append("\n"); 
		query.append("   SET MTY_TML_MNL_AMT 	= MTY_TML_IF_AMT" ).append("\n"); 
		query.append("     , MTY_TRSP_MNL_AMT = MTY_TRSP_IF_AMT" ).append("\n"); 
		query.append("     , APLY_ADJ_PL_FLG 	= DECODE(@[aply_adj_pl_flg], '1', 'Y', APLY_ADJ_PL_FLG)" ).append("\n"); 
		query.append("     , UPD_USR_ID 		= @[user_id]" ).append("\n"); 
		query.append("     , UPD_DT 			= SYSDATE" ).append("\n"); 
		query.append(" WHERE COST_YRMON 		= @[cost_yrmon]" ).append("\n"); 
		query.append("   AND COST_WK 			= @[cost_wk]" ).append("\n"); 

	}
}