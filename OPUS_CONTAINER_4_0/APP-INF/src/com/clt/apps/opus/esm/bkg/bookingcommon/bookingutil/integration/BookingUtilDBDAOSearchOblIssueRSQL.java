/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOSearchOblIssueRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.03
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.03 
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

public class BookingUtilDBDAOSearchOblIssueRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingUtilDBDAOSearchOblIssueRSQL
	  * </pre>
	  */
	public BookingUtilDBDAOSearchOblIssueRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchOblIssueRSQL").append("\n"); 
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
		query.append("select BKG.BL_NO," ).append("\n"); 
		query.append("CASE WHEN (BKG.BL_TP_CD||ISS.OBL_RLSE_FLG) = 'WY' THEN 'Y'" ).append("\n"); 
		query.append("WHEN ISS.OBL_SRND_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END OBL_RLSE_FLG," ).append("\n"); 
		query.append("CA.RDN_NO," ).append("\n"); 
		query.append("CA.RVIS_SEQ," ).append("\n"); 
		query.append("BKG.DEL_CD DEL_CD," ).append("\n"); 
		query.append("RDN_ACPT_FLG" ).append("\n"); 
		query.append("from BKG_BOOKING    BKG" ).append("\n"); 
		query.append(", BKG_BL_ISS     ISS" ).append("\n"); 
		query.append(", BKG_CORRECTION CA" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO    = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO    = CA.BKG_NO(+)" ).append("\n"); 
		query.append("AND CA.CORR_NO(+) = @[ca_no]" ).append("\n"); 
		query.append("AND BKG.BKG_NO    = @[bkg_no]" ).append("\n"); 

	}
}