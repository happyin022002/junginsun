/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EurSoAckManageDBDAOsearchEurSoAckListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.eursoack.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurSoAckManageDBDAOsearchEurSoAckListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * USA RailBilling Cancel 관리
	  * </pre>
	  */
	public EurSoAckManageDBDAOsearchEurSoAckListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pk1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.eursoack.integration ").append("\n"); 
		query.append("FileName : EurSoAckManageDBDAOsearchEurSoAckListRSQL").append("\n"); 
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
		query.append("SELECT COUNT(TRSP_SO_SEQ) FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE	TRSP_SO_SEQ	 = TO_NUMBER(@[pk1])" ).append("\n"); 

	}
}