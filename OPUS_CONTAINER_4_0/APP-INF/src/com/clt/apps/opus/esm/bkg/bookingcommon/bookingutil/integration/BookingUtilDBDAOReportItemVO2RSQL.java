/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingUtilDBDAOReportItemVO2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOReportItemVO2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public BookingUtilDBDAOReportItemVO2RSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOReportItemVO2RSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	TBL_NM" ).append("\n"); 
		query.append(",	COL_NM" ).append("\n"); 
		query.append(",	DP_NM ITEM_NM" ).append("\n"); 
		query.append(",	SQL_CTNT" ).append("\n"); 
		query.append("#if (${bkg_rpt_knd_cd} == 'V')" ).append("\n"); 
		query.append(",	VIP_RPT_ORD_SEQ AS ORD_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	STS_RPT_ORD_SEQ AS ORD_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM BKG_TBL_COL" ).append("\n"); 
		query.append("#if (${bkg_rpt_knd_cd} == 'B') " ).append("\n"); 
		query.append("WHERE STS_RPT_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER BY STS_RPT_ORD_SEQ ASC" ).append("\n"); 
		query.append("#elseif (${bkg_rpt_knd_cd} == 'C') " ).append("\n"); 
		query.append("WHERE CA_RPT_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER BY CA_RPT_ORD_SEQ ASC" ).append("\n"); 
		query.append("#elseif (${bkg_rpt_knd_cd} == 'V') " ).append("\n"); 
		query.append("WHERE VIP_RPT_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER BY VIP_RPT_ORD_SEQ ASC" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("WHERE TBL_NM = @[bkg_rpt_knd_cd]" ).append("\n"); 
		query.append("ORDER BY STS_RPT_ORD_SEQ ASC" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}