/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCNRUBlAtCanadaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCNRUBlAtCanadaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCNRUBlAtCanadaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_hjbl",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCNRUBlAtCanadaRSQL").append("\n"); 
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
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_BL " ).append("\n"); 
		query.append(" WHERE CNT_CD = 'CA'" ).append("\n"); 
		query.append("   AND BL_NO in( substr(@[in_hjbl], 5, 12) , substr(@[in_hjbl], 1, 12)  ) " ).append("\n"); 
		query.append("                 " ).append("\n"); 

	}
}