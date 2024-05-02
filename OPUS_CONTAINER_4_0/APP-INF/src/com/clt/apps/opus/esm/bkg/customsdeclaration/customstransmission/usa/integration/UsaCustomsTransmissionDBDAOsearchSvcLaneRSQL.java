/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchSvcLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchSvcLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vvd의 service lane를 조회한다.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchSvcLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration ").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchSvcLaneRSQL").append("\n"); 
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
		query.append("SELECT  SLAN_CD" ).append("\n"); 
		query.append("FROM    BKG_BOOKING" ).append("\n"); 
		query.append("WHERE   VSL_CD       = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND     SKD_VOY_NO   = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND     SKD_DIR_CD   = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND     SLAN_CD IS NOT NULL" ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 

	}
}