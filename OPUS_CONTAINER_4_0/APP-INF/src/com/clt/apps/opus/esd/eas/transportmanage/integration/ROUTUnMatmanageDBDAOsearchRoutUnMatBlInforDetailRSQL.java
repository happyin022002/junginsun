/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ROUTUnMatmanageDBDAOsearchRoutUnMatBlInforDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.11.26 양봉준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ROUTUnMatmanageDBDAOsearchRoutUnMatBlInforDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROUTUnMatmanageDBDAOsearchRoutUnMatBlInforDetailRSQL
	  * </pre>
	  */
	public ROUTUnMatmanageDBDAOsearchRoutUnMatBlInforDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : ROUTUnMatmanageDBDAOsearchRoutUnMatBlInforDetailRSQL").append("\n"); 
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
		query.append("BKG_NO bkg_no," ).append("\n"); 
		query.append("BL_NO bl_no," ).append("\n"); 
		query.append("RCV_TERM_CD rcv_term," ).append("\n"); 
		query.append("DE_TERM_CD del_term," ).append("\n"); 
		query.append("POR_CD bkg_por," ).append("\n"); 
		query.append("POL_CD bkg_pol," ).append("\n"); 
		query.append("POD_CD bkg_pod," ).append("\n"); 
		query.append("DEL_CD bkg_del" ).append("\n"); 
		query.append("FROM BKG_BOOKING" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkgNo]" ).append("\n"); 

	}
}