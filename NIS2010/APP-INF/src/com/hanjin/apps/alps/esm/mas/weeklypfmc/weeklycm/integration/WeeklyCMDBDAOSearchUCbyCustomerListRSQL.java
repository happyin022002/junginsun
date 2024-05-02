/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchUCbyCustomerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.16
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchUCbyCustomerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CSR 1795] MAS chassis 비용 로직 추정 방식 변경 - 기초 데이터 조회
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchUCbyCustomerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchUCbyCustomerListRSQL").append("\n"); 
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
		query.append("SELECT COST_YRMON, CTRT_NO, SCC_CD, CTRT_SEQ" ).append("\n"); 
		query.append("     , USA_IO_BND_CD, BKG_RCV_DE_TERM_CD, STND_UC_AMT, DELT_FLG" ).append("\n"); 
		query.append("     , CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append("FROM   MAS_CHSS_EXPT_CUST_LIST" ).append("\n"); 
		query.append("WHERE  COST_YRMON  BETWEEN SUBSTR(@[f_fm_mon],1,6)" ).append("\n"); 
		query.append("                   AND     SUBSTR(@[f_to_mon],1,6)" ).append("\n"); 
		query.append("  AND  DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${f_sc_no} != '')" ).append("\n"); 
		query.append("	AND    CTRT_NO = NVL(@[f_sc_no], CTRT_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY COST_YRMON, CTRT_NO, SCC_CD" ).append("\n"); 

	}
}