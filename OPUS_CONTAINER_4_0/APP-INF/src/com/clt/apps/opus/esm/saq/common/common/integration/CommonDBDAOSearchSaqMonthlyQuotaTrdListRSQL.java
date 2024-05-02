/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchSaqMonthlyQuotaTrdListRSQL.java
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

public class CommonDBDAOSearchSaqMonthlyQuotaTrdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trade 조회 
	  * </pre>
	  */
	public CommonDBDAOSearchSaqMonthlyQuotaTrdListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqMonthlyQuotaTrdListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT TRD.TRD_CD AS TEXT,                                                   " ).append("\n"); 
		query.append("               TRD.TRD_CD AS CODE                                                    " ).append("\n"); 
		query.append(" FROM SAQ_TGT_GRP     TGT,                                                           " ).append("\n"); 
		query.append("      SAQ_TGT_GRP_TRD TRD                                                            " ).append("\n"); 
		query.append("WHERE TGT.SAQ_TGT_GRP_CD = TRD.SAQ_TGT_GRP_CD                                        " ).append("\n"); 
		query.append("#if (${userChekc} != 'ALL' ) " ).append("\n"); 
		query.append("    AND TGT.OFC_CD = @[ofcCd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY TRD.TRD_CD  " ).append("\n"); 

	}
}