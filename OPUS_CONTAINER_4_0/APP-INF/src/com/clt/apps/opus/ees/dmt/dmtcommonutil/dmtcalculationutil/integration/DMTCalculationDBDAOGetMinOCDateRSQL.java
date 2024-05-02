/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCalculationDBDAOGetMinOCDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOGetMinOCDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetMinOCDate
	  * </pre>
	  */
	public DMTCalculationDBDAOGetMinOCDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_split_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOGetMinOCDateRSQL").append("\n"); 
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
		query.append("SELECT /*+ NO_EXPAND INDEX_DESC( M XFN1CTM_MOVEMENT ) */" ).append("\n"); 
		query.append("           M.CNMV_YR         CNMV_YR," ).append("\n"); 
		query.append("           M.CNMV_SEQ       CNMV_SEQ," ).append("\n"); 
		query.append("           M.CNMV_SPLIT_NO    CNMV_SPLIT_NO," ).append("\n"); 
		query.append("           M.MVMT_STS_CD      MVMT_STS_CD," ).append("\n"); 
		query.append("           M.ORG_YD_CD       ORG_YD_CD," ).append("\n"); 
		query.append("           TO_CHAR(M.CNMV_EVNT_DT, 'YYYYMMDD') AS CNMV_EVNT_DT" ).append("\n"); 
		query.append("   FROM    CTM_MOVEMENT M" ).append("\n"); 
		query.append("   WHERE   M.CNTR_NO    = @[cntr_no]" ).append("\n"); 
		query.append("   AND     M.CNMV_YR||TO_CHAR(M.CNMV_SEQ,'0000')||M.CNMV_SPLIT_NO < @[cnmv_yr]||TO_CHAR(TO_NUMBER(@[cnmv_seq]),'0000')||@[cnmv_split_no]" ).append("\n"); 
		query.append("#if (${seq} == 1) " ).append("\n"); 
		query.append("   AND M.MVMT_STS_CD    = 'OC'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND ROWNUM      = 1" ).append("\n"); 

	}
}