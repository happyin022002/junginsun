/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchSaqMonQtaWeekListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchSaqMonQtaWeekListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CommonDBDAOSearchSaqMonQtaWeekListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_rlse_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqMonQtaWeekListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT C.BSE_WK  AS TEXT																			" ).append("\n"); 
		query.append("	, C.BSE_WK 																							" ).append("\n"); 
		query.append("	|| '|' 																								" ).append("\n"); 
		query.append("	|| SUBSTR(B.SLS_FM_DT,1,4) || '.' || SUBSTR(B.SLS_FM_DT,5,2)  || '.' ||  SUBSTR(B.SLS_FM_DT,7,2)		" ).append("\n"); 
		query.append("	|| '|' 																								" ).append("\n"); 
		query.append("	|| SUBSTR(B.SLS_TO_DT,1,4) || '.' || SUBSTR(B.SLS_TO_DT,5,2)  || '.' ||  SUBSTR(B.SLS_TO_DT,7,2)		" ).append("\n"); 
		query.append("	AS CODE																								" ).append("\n"); 
		query.append("FROM SAQ_MON_CFM_QTA A ,											" ).append("\n"); 
		query.append("   COA_WK_PRD B,													" ).append("\n"); 
		query.append("   SAQ_MON_CFM_TGT_VVD C											" ).append("\n"); 
		query.append("WHERE A.MQTA_RLSE_VER_NO = @[mqta_rlse_ver_no] 										" ).append("\n"); 
		query.append("AND A.BSE_YR = @[bse_yr] 													" ).append("\n"); 
		query.append("AND A.BSE_QTR_CD = @[bse_qtr_cd] 												" ).append("\n"); 
		query.append("AND A.TRD_CD = @[trd_cd]  													" ).append("\n"); 
		query.append("AND A.DIR_CD = @[dir_cd] 															" ).append("\n"); 
		query.append("AND A.BSE_YR = B.COST_YR											" ).append("\n"); 
		query.append("AND C.BSE_WK = B.COST_WK											" ).append("\n"); 
		query.append("AND A.MQTA_RLSE_VER_NO = C.MQTA_RLSE_VER_NO 								" ).append("\n"); 
		query.append("AND A.BSE_YR = C.BSE_YR 											" ).append("\n"); 
		query.append("AND A.BSE_QTR_CD = C.BSE_QTR_CD 										" ).append("\n"); 
		query.append("AND A.BSE_MON = C.BSE_MON 											" ).append("\n"); 
		query.append("AND A.TRD_CD = C.TRD_CD 											" ).append("\n"); 
		query.append("AND A.RLANE_CD = C.RLANE_CD 										" ).append("\n"); 
		query.append("AND A.DIR_CD = C.DIR_CD 											" ).append("\n"); 
		query.append("AND A.VSL_CD = C.VSL_CD 											" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = C.SKD_VOY_NO 										" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = C.SKD_DIR_CD	      									" ).append("\n"); 
		query.append("ORDER BY C.BSE_WK		" ).append("\n"); 

	}
}