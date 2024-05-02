/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOSearchChnAgtUseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.05 
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

public class BookingUtilDBDAOSearchChnAgtUseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 중국 agent code를 사용하는 지역의 user인지 조회한다
	  * </pre>
	  */
	public BookingUtilDBDAOSearchChnAgtUseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchChnAgtUseRSQL").append("\n"); 
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
		query.append("SELECT DECODE(NVL((SELECT USR.OFC_CD" ).append("\n"); 
		query.append("FROM COM_USER USR, BKG_CHN_AGN AGN" ).append("\n"); 
		query.append("WHERE USR.OFC_CD = AGN.OFC_CD" ).append("\n"); 
		query.append("AND USR.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND rownum = 1), 'N'), 'N', 'Normal', 'China') RECEIPT_TYPE_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}