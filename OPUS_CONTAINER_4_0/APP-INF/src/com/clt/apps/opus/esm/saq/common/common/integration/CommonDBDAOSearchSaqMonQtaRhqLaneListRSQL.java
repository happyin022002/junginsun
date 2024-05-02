/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchSaqMonQtaRhqLaneListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.03 
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

public class CommonDBDAOSearchSaqMonQtaRhqLaneListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * mqta_ver_no, bse_mon 에 해당하는 Lane List 조회 
	  * </pre>
	  */
	public CommonDBDAOSearchSaqMonQtaRhqLaneListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_step_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqMonQtaRhqLaneListRSQL").append("\n"); 
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
		query.append("SELECT CODE, TEXT                                                               " ).append("\n"); 
		query.append("FROM (                                                                          " ).append("\n"); 
		query.append("       SELECT '' AS CODE, 'ALL' AS TEXT, '00' AS SUB_TRD FROM DUAL              " ).append("\n"); 
		query.append("       UNION ALL                                                                " ).append("\n"); 
		query.append("       SELECT R.RLANE_CD AS CODE, R.RLANE_CD AS TEXT, R.SUB_TRD_CD AS SUB_TRD   " ).append("\n"); 
		query.append("       FROM  SAQ_MON_QTA_STEP_VER V,                                            " ).append("\n"); 
		query.append("             SAQ_MON_QTA_RHQ R                                                  " ).append("\n"); 
		query.append("       WHERE V.MQTA_STEP_CD = @[mqta_step_cd]                                                 " ).append("\n"); 
		query.append("       AND   V.BSE_YR = @[bse_yr]                                                       " ).append("\n"); 
		query.append("       AND   V.TRD_CD = @[trd_cd]                                                       " ).append("\n"); 
		query.append("       AND   V.DIR_CD = @[dir_cd]                                                       " ).append("\n"); 
		query.append("       AND   V.MQTA_VER_NO = @[mqta_ver_no]                                                  " ).append("\n"); 
		query.append("       AND   R.MQTA_STEP_CD = V.MQTA_STEP_CD                                    " ).append("\n"); 
		query.append("       AND   R.BSE_YR = V.BSE_YR                                                " ).append("\n"); 
		query.append("       AND   R.TRD_CD = V.TRD_CD                                                " ).append("\n"); 
		query.append("       AND   R.DIR_CD = V.DIR_CD                                                " ).append("\n"); 
		query.append("       AND   R.MQTA_VER_NO = V.MQTA_VER_NO                                      " ).append("\n"); 
		query.append("       AND   R.BSE_MON = @[bse_mon]                                                      " ).append("\n"); 
		query.append("       AND   R.SUB_TRD_CD = @[sub_trd_cd]                                                   " ).append("\n"); 
		query.append("       GROUP BY R.SUB_TRD_CD, R.RLANE_CD )                                      " ).append("\n"); 
		query.append("ORDER BY SUB_TRD, DECODE(TEXT,'RBCCO','ZZ',SUBSTR(TEXT,-2)), TEXT" ).append("\n"); 

	}
}