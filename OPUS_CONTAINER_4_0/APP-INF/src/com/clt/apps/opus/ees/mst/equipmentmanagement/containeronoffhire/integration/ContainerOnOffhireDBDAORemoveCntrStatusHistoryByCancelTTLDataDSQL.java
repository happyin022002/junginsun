/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerOnOffhireDBDAORemoveCntrStatusHistoryByCancelTTLDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.28
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.08.28 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAORemoveCntrStatusHistoryByCancelTTLDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * To cancel total loss
	  * </pre>
	  */
	public ContainerOnOffhireDBDAORemoveCntrStatusHistoryByCancelTTLDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAORemoveCntrStatusHistoryByCancelTTLDataDSQL").append("\n"); 
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
		query.append("DELETE FROM MST_CNTR_STS_HIS HIS" ).append("\n"); 
		query.append("WHERE HIS.CNTR_STS_CD IN ('TLL', 'SCR', 'DON', 'SLD')" ).append("\n"); 
		query.append("AND   HIS.CNTR_STS_SEQ = (SELECT MC.LST_STS_SEQ" ).append("\n"); 
		query.append("                           FROM MST_CONTAINER MC" ).append("\n"); 
		query.append("                          WHERE MC.CNTR_NO     = @[eq_no]" ).append("\n"); 
		query.append("                            AND MC.CNTR_STS_CD IN ('TLL', 'SCR', 'DON', 'SLD')" ).append("\n"); 
		query.append("                            AND ROWNUM         = 1) " ).append("\n"); 

	}
}