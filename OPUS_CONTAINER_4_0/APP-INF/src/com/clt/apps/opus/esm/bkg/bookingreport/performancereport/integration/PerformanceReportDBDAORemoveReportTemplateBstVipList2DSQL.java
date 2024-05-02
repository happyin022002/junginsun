/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAORemoveReportTemplateBstVipList2DSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.22
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.12.22 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAORemoveReportTemplateBstVipList2DSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Report Template Detail Remove
	  * </pre>
	  */
	public PerformanceReportDBDAORemoveReportTemplateBstVipList2DSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rpt_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAORemoveReportTemplateBstVipList2DSQL").append("\n"); 
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
		query.append("DELETE FROM BKG_RPT_DFLT_DTL" ).append("\n"); 
		query.append("WHERE TBL_NM         > ' '" ).append("\n"); 
		query.append("AND   COL_NM         > ' '" ).append("\n"); 
		query.append("AND   BKG_RPT_KND_CD = @[bkg_rpt_knd_cd]" ).append("\n"); 
		query.append("AND   RPT_ID         = @[rpt_id]" ).append("\n"); 

	}
}