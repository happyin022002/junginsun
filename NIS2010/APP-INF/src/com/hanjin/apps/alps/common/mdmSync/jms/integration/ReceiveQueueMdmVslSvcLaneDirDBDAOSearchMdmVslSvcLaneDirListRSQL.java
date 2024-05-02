/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceiveQueueMdmVslSvcLaneDirDBDAOSearchMdmVslSvcLaneDirListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmVslSvcLaneDirDBDAOSearchMdmVslSvcLaneDirListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMdmVslSvcLaneDirList
	  * </pre>
	  */
	public ReceiveQueueMdmVslSvcLaneDirDBDAOSearchMdmVslSvcLaneDirListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration ").append("\n"); 
		query.append("FileName : ReceiveQueueMdmVslSvcLaneDirDBDAOSearchMdmVslSvcLaneDirListRSQL").append("\n"); 
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
		query.append("SELECT vsl_slan_cd" ).append("\n"); 
		query.append("FROM mdm_vsl_svc_lane_dir" ).append("\n"); 
		query.append("WHERE vsl_slan_cd = @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND vsl_slan_dir_cd = @[vsl_slan_dir_cd]" ).append("\n"); 

	}
}