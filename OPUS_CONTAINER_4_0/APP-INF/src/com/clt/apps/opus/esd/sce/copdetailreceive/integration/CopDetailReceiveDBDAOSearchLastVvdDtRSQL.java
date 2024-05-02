/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchLastVvdDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchLastVvdDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLastVvdDt
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchLastVvdDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_rcv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_evnt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchLastVvdDtRSQL").append("\n"); 
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
		query.append("SELECT to_char(old_evnt_dt,'YYYYMMDD') last_vvd_dt" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT ROWNUM num, VPS_RCV_DT, LPAD(VPS_RCV_NO, 7, '0'), VPS_RCV_NO, VPS_EVNT_DT AS old_evnt_dt, VPS_RCV_DT||LPAD(VPS_RCV_NO, 7, '0') aaa" ).append("\n"); 
		query.append("        FROM sce_vps_if" ).append("\n"); 
		query.append("        where   vsl_cd          = @[vsl_cd]" ).append("\n"); 
		query.append("        and     skd_voy_no      = @[skd_voy_no]" ).append("\n"); 
		query.append("        and     skd_dir_cd      = @[skd_dir_cd]" ).append("\n"); 
		query.append("        and     vps_port_cd     = @[vps_port_cd]" ).append("\n"); 
		query.append("        and     vps_evnt_tp_cd  = @[vps_evnt_tp_cd]" ).append("\n"); 
		query.append("        and     vps_rcv_no      <> @[vps_rcv_no]" ).append("\n"); 
		query.append("        ORDER BY aaa DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}