/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxInfoDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.27
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.04.27 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxInfoDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxInfoDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_cy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxInfoDetailListRSQL").append("\n"); 
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
		query.append("SELECT MY.YD_NM AS YD_NM," ).append("\n"); 
		query.append("MY.YD_PIC_NM AS YD_PIC_NM," ).append("\n"); 
		query.append("MY.PHN_NO AS PHN_NO," ).append("\n"); 
		query.append("RTRIM (CU.USR_NM)||' ('||NVL (TRIM (CU.XTN_PHN_NO), '')||' / '||NVL (TRIM (CU.DFLT_EML), '')||')' AS USER_INFO," ).append("\n"); 
		query.append("SUBSTR (MT.CNTR_TPSZ_DESC, 1, 4) AS CNTR_TPSZ_DESC" ).append("\n"); 
		query.append("FROM MDM_YARD MY," ).append("\n"); 
		query.append("COM_USER CU," ).append("\n"); 
		query.append("MDM_CNTR_TP_SZ MT" ).append("\n"); 
		query.append("WHERE MY.YD_CD = @[empty_cy]" ).append("\n"); 
		query.append("AND CU.USR_ID = @[user_id]" ).append("\n"); 
		query.append("AND MT.CNTR_TPSZ_CD = @[tp]" ).append("\n"); 
		query.append("ORDER BY MY.YD_NM, MY.YD_PIC_NM" ).append("\n"); 

	}
}