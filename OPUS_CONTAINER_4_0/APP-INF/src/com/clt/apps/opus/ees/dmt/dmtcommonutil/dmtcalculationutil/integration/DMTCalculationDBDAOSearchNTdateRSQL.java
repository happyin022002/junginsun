/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchNTdateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.20
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.03.20 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchNTdateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DMTCalculationDBDAOSearchNTdateRSQL
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchNTdateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchNTdateRSQL").append("\n"); 
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
		query.append("SELECT  TO_CHAR(E.EVNT_DT, 'YYYYMMDDHH24MI') EVNT_DT" ).append("\n"); 
		query.append("  FROM    EDI_322_MSG E," ).append("\n"); 
		query.append("          MDM_YARD    Y" ).append("\n"); 
		query.append("  WHERE E.EQ_NO = @[cntr_no]" ).append("\n"); 
		query.append("  AND E.EDI_322_STS_CD = 'NT'" ).append("\n"); 
		query.append("  AND E.EVNT_YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("  AND (E.BL_EDI_322_NO = @[bkg_no] or E.BKG_EDI_322_NO = @[bkg_no])" ).append("\n"); 
		query.append("  AND E.EVNT_YD_CD = Y.YD_CD" ).append("\n"); 
		query.append("  AND Y.RAIL_ARR_NTFC_FLG = 'Y'" ).append("\n"); 

	}
}