/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EurOceanFeederCostManageDBDAORemoveFdrRfTrfDtlAcctDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurOceanFeederCostManageDBDAORemoveFdrRfTrfDtlAcctDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.11.21 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트 - AOC_EUR_FDR_RF_TRF_ACCT 삭제 처리
	  * </pre>
	  */
	public EurOceanFeederCostManageDBDAORemoveFdrRfTrfDtlAcctDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_trf_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.integration ").append("\n"); 
		query.append("FileName : EurOceanFeederCostManageDBDAORemoveFdrRfTrfDtlAcctDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("FROM    AOC_EUR_FDR_RF_TRF_ACCT" ).append("\n"); 
		query.append("WHERE   COST_TRF_NO = @[cost_trf_no]" ).append("\n"); 
		query.append("AND     COST_TRF_ROUT_SEQ = @[cost_trf_rout_seq]" ).append("\n"); 

	}
}