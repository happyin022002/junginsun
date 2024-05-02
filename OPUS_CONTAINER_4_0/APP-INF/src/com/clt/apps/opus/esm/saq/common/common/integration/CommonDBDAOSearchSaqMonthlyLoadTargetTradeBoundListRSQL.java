/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchSaqMonthlyLoadTargetTradeBoundListRSQL.java
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

public class CommonDBDAOSearchSaqMonthlyLoadTargetTradeBoundListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 분기 냉동컨테이너 RHQ login Load Target 조회시 Trd_cd & Dir_cd 조회
	  * </pre>
	  */
	public CommonDBDAOSearchSaqMonthlyLoadTargetTradeBoundListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trdCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("quarter",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqMonthlyLoadTargetTradeBoundListRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT																			                      " ).append("\n"); 
		query.append("        DECODE(@[trdCd], '', TRD_CD, DIR_CD)    AS CODE ,                         " ).append("\n"); 
		query.append("        DECODE(@[trdCd], '', TRD_CD, dir_cd)    AS TEXT                           " ).append("\n"); 
		query.append("FROM    SAQ_MON_LOD_TGT_OFC A                                              " ).append("\n"); 
		query.append("WHERE   1 = 1                                                              " ).append("\n"); 
		query.append("AND     A.BSE_YR        = @[year]                                                " ).append("\n"); 
		query.append("AND     A.BSE_QTR_CD    = @[quarter]                                                " ).append("\n"); 
		query.append("AND     A.SLS_RHQ_CD    = (SELECT DISTINCT                                 " ).append("\n"); 
		query.append("							         N2ND_PRNT_OFC_CD                         " ).append("\n"); 
		query.append("							  FROM   SAQ_ORGANIZATION_V                       " ).append("\n"); 
		query.append("					          WHERE  1 = 1                                    " ).append("\n"); 
		query.append("					          AND    OFC_CD  = @[ofcCd]							  " ).append("\n"); 
		query.append("							 )                                                " ).append("\n"); 
		query.append("AND     TRD_CD          LIKE @[trdCd] || '%'  " ).append("\n"); 

	}
}