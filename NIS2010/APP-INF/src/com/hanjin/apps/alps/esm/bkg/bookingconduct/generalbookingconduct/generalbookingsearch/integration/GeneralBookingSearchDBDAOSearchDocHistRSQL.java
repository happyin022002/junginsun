/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchDocHistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.02.23 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchDocHistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingSearchDBDAOSearchDocHistRSQL
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchDocHistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchDocHistRSQL").append("\n"); 
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
		query.append("SELECT (SELECT DOC_PROC_DESC" ).append("\n"); 
		query.append("FROM BKG_DOC_PROC_TP" ).append("\n"); 
		query.append("WHERE BKG_DOC_PROC_TP_CD = HIS.BKG_DOC_PROC_TP_CD) ITEM" ).append("\n"); 
		query.append(", TO_CHAR(HIS.EVNT_DT, 'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append(", TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(BKG_COM_USER_LOC_FNC(HIS.UPD_USR_ID), HIS.EVNT_DT, 'GMT'), 'YYYY-MM-DD HH24:MI') GMT_DT" ).append("\n"); 
		query.append(", USR.USR_NM CRE_USR_ID" ).append("\n"); 
		query.append(", USR.OFC_CD OFFICE" ).append("\n"); 
		query.append(", '' REMARK" ).append("\n"); 
		query.append(", '' REASON" ).append("\n"); 
		query.append("FROM BKG_DOC_PROC_SKD HIS" ).append("\n"); 
		query.append(", COM_USER USR" ).append("\n"); 
		query.append("WHERE HIS.UPD_USR_ID = USR.USR_ID(+)" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("ORDER BY EVNT_DT" ).append("\n"); 

	}
}