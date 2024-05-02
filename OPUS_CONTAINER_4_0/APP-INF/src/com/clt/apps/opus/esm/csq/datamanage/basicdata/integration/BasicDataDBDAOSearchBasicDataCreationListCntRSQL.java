/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BasicDataDBDAOSearchBasicDataCreationListCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.06
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.08.06 최윤성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOSearchBasicDataCreationListCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSQ_PERF_IF 의 Data Count
	  * </pre>
	  */
	public BasicDataDBDAOSearchBasicDataCreationListCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOSearchBasicDataCreationListCntRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) AS CNT" ).append("\n"); 
		query.append("#if (${flg} == 'Y')" ).append("\n"); 
		query.append("      ,MAX(APLY_FM_YRWK) AS APLY_FM_YRWK" ).append("\n"); 
		query.append("      ,MAX(APLY_TO_YRWK) AS APLY_TO_YRWK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM CSQ_PERF_IF" ).append("\n"); 
		query.append(" WHERE BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 

	}
}