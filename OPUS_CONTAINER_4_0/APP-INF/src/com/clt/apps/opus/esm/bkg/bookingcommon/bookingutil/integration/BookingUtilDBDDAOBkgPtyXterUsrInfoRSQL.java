/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDDAOBkgPtyXterUsrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.12
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.05.12 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDDAOBkgPtyXterUsrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public BookingUtilDBDDAOBkgPtyXterUsrInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDDAOBkgPtyXterUsrInfoRSQL").append("\n"); 
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
		query.append("	XUI.USR_ID," ).append("\n"); 
		query.append("	XUI.USR_N1ST_NM," ).append("\n"); 
		query.append("	XUI.USR_LST_NM," ).append("\n"); 
		query.append("	XUI.USR_STS_CD," ).append("\n"); 
		query.append("	XUI.CUST_CNT_CD," ).append("\n"); 
		query.append("	XUI.CUST_SEQ," ).append("\n"); 
		query.append("	XUI.RDY_FO_PRF_FLG," ).append("\n"); 
		query.append("	XUI.RDY_FO_PRN_FLG," ).append("\n"); 
		query.append("	XUI.SEA_WBL_EML_FLG" ).append("\n"); 
		query.append("FROM BKG_XTER_USR_INFO XUI" ).append("\n"); 
		query.append("     ,BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("WHERE XUI.USR_ID = MST.CUST_ID" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 

	}
}