/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingUtilDBDAOsearchOblSerialNumberRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOsearchOblSerialNumberRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingUtilDBDAOsearchOblSerialNumberRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOsearchOblSerialNumberRSQL").append("\n"); 
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
		query.append("	AUTH.OBL_INTER_SER_NO," ).append("\n"); 
		query.append("	AUTH.OBL_INTER_SER_NO || '|' || AUTH.OBL_INTER_SER_NO_CHK_USR_ID || '|' || TO_CHAR(AUTH.OBL_INTER_SER_NO_CHK_DT, 'YYYY-MM-DD') AS OBL_INTER_SER_NO_CHK_USR_ID" ).append("\n"); 
		query.append("#if (${search_type} != '') " ).append("\n"); 
		query.append("	,AUTH.BKG_NO" ).append("\n"); 
		query.append("	,AUTH.OBL_INTER_SER_NO_CHK_USR_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM BKG_INET_BL_PRN_AUTH AUTH, BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE AUTH.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND AUTH.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("AND AUTH.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND NVL(BKG.BL_TP_CD, 'B') <> 'W'" ).append("\n"); 
		query.append("AND AUTH.OBL_INTER_SER_NO IS NOT NULL" ).append("\n"); 
		query.append("#if (${checked} == 'Y') " ).append("\n"); 
		query.append("AND AUTH.OBL_INTER_SER_NO_CHK_USR_ID IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}