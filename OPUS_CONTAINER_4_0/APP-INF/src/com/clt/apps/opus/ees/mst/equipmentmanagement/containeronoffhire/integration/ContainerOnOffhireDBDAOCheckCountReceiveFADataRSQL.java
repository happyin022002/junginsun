/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOCheckCountReceiveFADataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.27
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2013.09.27 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOCheckCountReceiveFADataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckCountReceiveFAData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOCheckCountReceiveFADataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fa_if_grp_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOCheckCountReceiveFADataRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("FROM MST_CONTAINER" ).append("\n"); 
		query.append("WHERE FA_IF_GRP_SEQ_NO = @[fa_if_grp_seq_no]" ).append("\n"); 
		query.append("AND   FA_IF_STS_CD = 'C'" ).append("\n"); 

	}
}