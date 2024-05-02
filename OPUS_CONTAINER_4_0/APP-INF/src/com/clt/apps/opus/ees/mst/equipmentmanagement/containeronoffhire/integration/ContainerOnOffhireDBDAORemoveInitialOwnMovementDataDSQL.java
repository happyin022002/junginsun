/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerOnOffhireDBDAORemoveInitialOwnMovementDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.24
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.11.24 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAORemoveInitialOwnMovementDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OWN으로 생성된 Initial Movement 정보를 삭제함.
	  * </pre>
	  */
	public ContainerOnOffhireDBDAORemoveInitialOwnMovementDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration ").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAORemoveInitialOwnMovementDataDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT CM" ).append("\n"); 
		query.append("WHERE CM.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND NOT EXISTS ( " ).append("\n"); 
		query.append("	SELECT 'X'" ).append("\n"); 
		query.append("    	FROM MST_CONTAINER MC" ).append("\n"); 
		query.append("        WHERE CM.CNTR_NO = MC.CNTR_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}