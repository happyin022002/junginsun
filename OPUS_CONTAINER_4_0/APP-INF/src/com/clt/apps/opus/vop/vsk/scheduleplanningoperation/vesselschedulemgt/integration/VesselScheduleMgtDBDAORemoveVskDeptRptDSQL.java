/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselScheduleMgtDBDAORemoveVskDeptRptDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.03.09 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAORemoveVskDeptRptDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK_DEP_RPT <delete By PK>
	  * </pre>
	  */
	public VesselScheduleMgtDBDAORemoveVskDeptRptDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAORemoveVskDeptRptDSQL").append("\n"); 
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
		query.append("DELETE " ).append("\n"); 
		query.append("FROM   VSK_DEP_RPT A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.VSL_CD       = @[vsl_cd]	" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD   = @[skd_dir_cd]	" ).append("\n"); 
		query.append("AND    A.VPS_PORT_CD  = @[vps_port_cd]" ).append("\n"); 
		query.append("AND    A.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 

	}
}