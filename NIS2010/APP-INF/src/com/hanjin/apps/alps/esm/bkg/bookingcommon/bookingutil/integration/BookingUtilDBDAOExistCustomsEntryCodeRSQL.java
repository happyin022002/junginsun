/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BookingUtilDBDAOExistCustomsEntryCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.20
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2013.08.20 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOExistCustomsEntryCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingUtilDBDAOExistCustomsEntryCodeRSQL
	  * </pre>
	  */
	public BookingUtilDBDAOExistCustomsEntryCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_text",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOExistCustomsEntryCodeRSQL").append("\n"); 
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
		query.append("    CASE " ).append("\n"); 
		query.append("        WHEN COUNT(*)>0 THEN 'Y'" ).append("\n"); 
		query.append("        ELSE 'N'" ).append("\n"); 
		query.append("    END OUTPUT_TEXT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CLR_ENTR_TP" ).append("\n"); 
		query.append("WHERE CSTMS_ENTR_CD = @[input_text]" ).append("\n"); 

	}
}