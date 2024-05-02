/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairRouteDBDAOSearchPortPairDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2010.03.09 신한성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Shin Han Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairRouteDBDAOSearchPortPairDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PortPairDetail 정보 조회
	  * </pre>
	  */
	public PortPairRouteDBDAOSearchPortPairDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.integration").append("\n"); 
		query.append("FileName : PortPairRouteDBDAOSearchPortPairDetailRSQL").append("\n"); 
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
		query.append("SELECT rout_rcv_dt" ).append("\n"); 
		query.append(",rout_seq" ).append("\n"); 
		query.append(",cust_trd_prnr_id" ).append("\n"); 
		query.append(",por_cd" ).append("\n"); 
		query.append(",n1st_pol_cd" ).append("\n"); 
		query.append(",n1st_pod_cd" ).append("\n"); 
		query.append(",n2nd_pol_cd" ).append("\n"); 
		query.append(",n2nd_pod_cd" ).append("\n"); 
		query.append(",n3rd_pol_cd" ).append("\n"); 
		query.append(",n3rd_pod_cd" ).append("\n"); 
		query.append(",n4th_pol_cd" ).append("\n"); 
		query.append(",n4th_pod_cd" ).append("\n"); 
		query.append(",del_cd" ).append("\n"); 
		query.append(",upd_ind_cd" ).append("\n"); 
		query.append(",use_flg" ).append("\n"); 
		query.append(",mnl_use_flg" ).append("\n"); 
		query.append(",(CASE WHEN use_flg = 'N' OR mnl_use_flg = 'N'" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N' END) AS delt_flg" ).append("\n"); 
		query.append(",cre_usr_id" ).append("\n"); 
		query.append(",TO_CHAR(cre_dt, 'YYYYMMDDHH24MISS') AS cre_dt" ).append("\n"); 
		query.append(",upd_usr_id" ).append("\n"); 
		query.append(",TO_CHAR(upd_dt, 'YYYYMMDDHH24MISS') AS upd_dt" ).append("\n"); 
		query.append(",org_loc_cd" ).append("\n"); 
		query.append(",dest_loc_cd" ).append("\n"); 
		query.append("FROM sce_port_pair_dtl dtl" ).append("\n"); 
		query.append("WHERE cust_trd_prnr_id = @[cust_trd_prnr_id]" ).append("\n"); 
		query.append("AND por_cd = @[por_cd]" ).append("\n"); 
		query.append("AND n1st_pol_cd = @[pol_cd]" ).append("\n"); 
		query.append("AND dest_loc_cd = @[pod_cd]" ).append("\n"); 
		query.append("AND del_cd = @[del_cd]" ).append("\n"); 
		query.append("AND use_flg = 'Y'  AND (mnl_use_flg = 'Y' OR mnl_use_flg IS NULL)" ).append("\n"); 

	}
}