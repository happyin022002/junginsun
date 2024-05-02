/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceiveQueueMdmCarrierDBDAOSearchMdmCarrierRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.02
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.11.02 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO CHANG YUL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmCarrierDBDAOSearchMdmCarrierRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMdmCarrier
	  * </pre>
	  */
	public ReceiveQueueMdmCarrierDBDAOSearchMdmCarrierRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration ").append("\n"); 
		query.append("FileName : ReceiveQueueMdmCarrierDBDAOSearchMdmCarrierRSQL").append("\n"); 
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
		query.append("SELECT CRR_CD" ).append("\n"); 
		query.append("FROM MDM_CARRIER" ).append("\n"); 
		query.append("WHERE CRR_CD = @[crr_cd]" ).append("\n"); 

	}
}