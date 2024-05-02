/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchScheduleInformationByVpsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchScheduleInformationByVpsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchScheduleInformationByVps
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchScheduleInformationByVpsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration ").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchScheduleInformationByVpsRSQL").append("\n"); 
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
		query.append("SELECT vps_evnt_tp_cd skd_mapg_cd" ).append("\n"); 
		query.append(", vps_port_cd skd_nod_cd" ).append("\n"); 
		query.append(", '2' skd_rcv_tp_cd" ).append("\n"); 
		query.append(", vps_if_sts_cd call_yd_ind_seq" ).append("\n"); 
		query.append(", err_msg" ).append("\n"); 
		query.append("FROM   sce_vps_if" ).append("\n"); 
		query.append("WHERE  vps_rcv_dt = @[skd_rcv_dt]" ).append("\n"); 
		query.append("AND    vps_rcv_no = @[act_rcv_no]" ).append("\n"); 

	}
}