/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusReportDBDAOSearchSelectColumnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchSelectColumnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Retrieving columns of selected report kind
	  * </pre>
	  */
	public StatusReportDBDAOSearchSelectColumnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchSelectColumnRSQL").append("\n"); 
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
		query.append("SELECT NVL(BKG_JOIN_FNC(CURSOR(SELECT COL_NM" ).append("\n"); 
		query.append("                                 FROM BKG_RPT_DFLT_DTL A" ).append("\n"); 
		query.append("                                WHERE TBL_NM = @[rpt_knd_cd]" ).append("\n"); 
		query.append("                                  AND RPT_ID = @[rpt_id]" ).append("\n"); 
		query.append("                                ORDER BY ORD_SEQ" ).append("\n"); 
		query.append("                              ),',')" ).append("\n"); 
		query.append("         , BKG_JOIN_FNC(CURSOR(SELECT COL_NM" ).append("\n"); 
		query.append("                                 FROM BKG_TBL_COL " ).append("\n"); 
		query.append("                                WHERE TBL_NM = @[rpt_knd_cd]" ).append("\n"); 
		query.append("                                ORDER BY STS_RPT_ORD_SEQ" ).append("\n"); 
		query.append("                              ),',')" ).append("\n"); 
		query.append("       ) AS COLS" ).append("\n"); 
		query.append("      ,NVL(BKG_JOIN_FNC(CURSOR(SELECT (SELECT STS_RPT_ORD_SEQ FROM BKG_TBL_COL WHERE TBL_NM = A.TBL_NM AND COL_NM = A.COL_NM)" ).append("\n"); 
		query.append("                                 FROM BKG_RPT_DFLT_DTL A" ).append("\n"); 
		query.append("                                WHERE TBL_NM = @[rpt_knd_cd]" ).append("\n"); 
		query.append("                                  AND RPT_ID = @[rpt_id]" ).append("\n"); 
		query.append("                                ORDER BY ORD_SEQ" ).append("\n"); 
		query.append("                              ),',')" ).append("\n"); 
		query.append("         , BKG_JOIN_FNC(CURSOR(SELECT STS_RPT_ORD_SEQ" ).append("\n"); 
		query.append("                                 FROM BKG_TBL_COL " ).append("\n"); 
		query.append("                                WHERE TBL_NM = @[rpt_knd_cd]" ).append("\n"); 
		query.append("                                ORDER BY STS_RPT_ORD_SEQ" ).append("\n"); 
		query.append("                              ),',')" ).append("\n"); 
		query.append("       ) AS COLS_SEQ" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}