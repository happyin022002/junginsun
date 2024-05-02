/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyCustomizedConditionDBDAOSearchLodTargetPreviousCheckKey0163Tab01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2010.03.29 김종호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ho Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyCustomizedConditionDBDAOSearchLodTargetPreviousCheckKey0163Tab01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * key조회
	  * </pre>
	  */
	public MonthlyCustomizedConditionDBDAOSearchLodTargetPreviousCheckKey0163Tab01RSQL(){
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
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.integration").append("\n"); 
		query.append("FileName : MonthlyCustomizedConditionDBDAOSearchLodTargetPreviousCheckKey0163Tab01RSQL").append("\n"); 
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
		query.append("SELECT DISTINCT BSE_YR, BSE_QTR_CD                   " ).append("\n"); 
		query.append("    FROM SAQ_MON_LOD_TGT_OFC                           " ).append("\n"); 
		query.append("   WHERE ROWNUM = 1                                    " ).append("\n"); 
		query.append("     AND BSE_YR||BSE_QTR_CD < @[bse_yr]||@[bse_qtr_cd] " ).append("\n"); 
		query.append("ORDER BY BSE_YR DESC, BSE_QTR_CD DESC" ).append("\n"); 

	}
}