/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDAOSearchOneTimeSndHistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOSearchOneTimeSndHistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOneTimeSndHist
	  * </pre>
	  */
	public DwellNotificationDBDAOSearchOneTimeSndHistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subsc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOSearchOneTimeSndHistRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO" ).append("\n"); 
		query.append("    ,  BKG_NO" ).append("\n"); 
		query.append("    ,  EML_SND_DT" ).append("\n"); 
		query.append("FROM SCE_DWLL_NTFC_EML_SND_RSLT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND DWLL_CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND DWLL_CUST_SEQ = SUBSTR(@[cust_cd],3)" ).append("\n"); 
		query.append("AND SUBSC_EML = @[subsc_eml]" ).append("\n"); 
		query.append("AND SND_OPT_CD = 'OT'" ).append("\n"); 
		query.append("ORDER BY EML_SND_DT DESC, CNTR_NO, BKG_NO" ).append("\n"); 

	}
}