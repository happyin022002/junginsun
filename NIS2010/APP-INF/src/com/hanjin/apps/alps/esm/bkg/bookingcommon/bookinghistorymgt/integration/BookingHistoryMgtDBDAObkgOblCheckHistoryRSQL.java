/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingHistoryMgtDBDAObkgOblCheckHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAObkgOblCheckHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingHistoryMgtDBDAObkgOblCheckHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_inter_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_inter_ser_no_chk_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAObkgOblCheckHistoryRSQL").append("\n"); 
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
		query.append("WITH OLD_RDEM AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT @[bkg_no] AS BKG_NO," ).append("\n"); 
		query.append("         @[obl_inter_ser_no] AS OBL_INTER_SER_NO," ).append("\n"); 
		query.append("         @[obl_inter_ser_no_chk_usr_id] AS OBL_INTER_SER_NO_CHK_USR_ID" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append("     , CRNT_CTNT" ).append("\n"); 
		query.append("     , PRE_CTNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("SELECT 'OB/L Serial Number' HIS_CATE_NM" ).append("\n"); 
		query.append("  ,OLD_RDEM.OBL_INTER_SER_NO || '/' || DECODE(OLD_RDEM.OBL_INTER_SER_NO_CHK_USR_ID, NULL ,'N', 'Y') PRE_CTNT" ).append("\n"); 
		query.append("  ,NOW_RDEM.OBL_INTER_SER_NO || '/' || DECODE(NOW_RDEM.OBL_INTER_SER_NO_CHK_USR_ID, NULL ,'N', 'Y') CRNT_CTNT" ).append("\n"); 
		query.append("FROM BKG_INET_BL_PRN_AUTH NOW_RDEM ,OLD_RDEM" ).append("\n"); 
		query.append("WHERE OLD_RDEM.BKG_NO = NOW_RDEM.BKG_NO" ).append("\n"); 
		query.append("AND OLD_RDEM.OBL_INTER_SER_NO = NOW_RDEM.OBL_INTER_SER_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}