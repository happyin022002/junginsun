/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchContracSrepCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchContracSrepCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOSearchContracSrepCdRSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchContracSrepCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchContracSrepCdRSQL").append("\n"); 
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
		query.append("SELECT MAX(CTRT_SREP_CD) CTRT_SREP_CD" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("		SELECT DECODE(SUBSTR(CTRT_SREP_CD,1,2), 'US', CTRT_SREP_CD, 'CA', CTRT_SREP_CD, '') CTRT_SREP_CD" ).append("\n"); 
		query.append("		FROM   BKG_BOOKING" ).append("\n"); 
		query.append("		WHERE  BKG_NO = @[bl_src_no]" ).append("\n"); 
		query.append("		AND    @[ar_ofc_cd] IN  ( SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("		                          FROM   BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("		                          WHERE  HRD_CDG_ID = 'BKG_INV_IF_SREP_OFC' " ).append("\n"); 
		query.append("		                        ) " ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT '' CTRT_SREP_CD FROM DUAL" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}