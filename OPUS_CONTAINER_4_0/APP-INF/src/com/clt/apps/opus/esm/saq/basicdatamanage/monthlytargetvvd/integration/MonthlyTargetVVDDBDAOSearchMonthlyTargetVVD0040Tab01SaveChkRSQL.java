/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MonthlyTargetVVDDBDAOSearchMonthlyTargetVVD0040Tab01SaveChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyTargetVVDDBDAOSearchMonthlyTargetVVD0040Tab01SaveChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMonthlyTargetVVD0040Tab01SaveChk
	  * </pre>
	  */
	public MonthlyTargetVVDDBDAOSearchMonthlyTargetVVD0040Tab01SaveChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.integration").append("\n"); 
		query.append("FileName : MonthlyTargetVVDDBDAOSearchMonthlyTargetVVD0040Tab01SaveChkRSQL").append("\n"); 
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
		query.append("select decode(cnt, 0, 'N', 'Y') CHK_YN" ).append("\n"); 
		query.append("from(" ).append("\n"); 
		query.append("    select count(*) cnt " ).append("\n"); 
		query.append("    from saq_mon_tgt_vvd" ).append("\n"); 
		query.append("    where 1=1" ).append("\n"); 
		query.append("    and BSE_YR = @[year]" ).append("\n"); 
		query.append("    and BSE_QTR_CD = @[quarter]" ).append("\n"); 
		query.append("    and TGT_VVD_STS_CD = 'N' " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}