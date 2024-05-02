/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingUtilDBDAOLoginOfcCdSearchCkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.22
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.22 
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

public class BookingUtilDBDAOLoginOfcCdSearchCkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingUtilDBDAOLoginOfcCdSearchCkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evn_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ui_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_src_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOLoginOfcCdSearchCkRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("  CASE WHEN (SELECT COUNT(HRD_CDG_ID) AS CNT FROM BKG_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'BKG_SRC_OFC' AND ATTR_CTNT2 = @[bkg_src_tp] AND ATTR_CTNT1 = @[usr_ofc_cd]) > 0 " ).append("\n"); 
		query.append("  	THEN (SELECT DECODE(COUNT(BKG.BKG_NO),0,'Y','N') AS BKG_SRC_FLG FROM BKG_BOOKING BKG, BKG_HRD_CDG_CTNT BHCC WHERE BKG.BKG_NO = @[bkg_no] AND BHCC.HRD_CDG_ID = 'BKG_SRC_LOC' AND (BKG.POL_CD = BHCC.ATTR_CTNT1 OR BKG.POD_CD = BHCC.ATTR_CTNT2))" ).append("\n"); 
		query.append("  ELSE 'N' " ).append("\n"); 
		query.append("  END AS BKG_SRC_FLG" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_CTNT CTNT" ).append("\n"); 
		query.append("WHERE CTNT.HRD_CDG_ID = 'BKG_SRC_TYPE'" ).append("\n"); 
		query.append("AND CTNT.ATTR_CTNT1 = @[bkg_src_tp]" ).append("\n"); 
		query.append("AND CTNT.ATTR_CTNT2 = @[ui_id]" ).append("\n"); 
		query.append("AND CTNT.ATTR_CTNT3 = @[evn_tp]" ).append("\n"); 

	}
}