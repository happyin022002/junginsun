/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairRouteDBDAOAddPortPairDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.24
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.06.24 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairRouteDBDAOAddPortPairDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port Pair Detail 테이블에 사용자가 manual로 입력하는 경우
	  * </pre>
	  */
	public PortPairRouteDBDAOAddPortPairDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n4th_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3rd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rout_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.integration").append("\n"); 
		query.append("FileName : PortPairRouteDBDAOAddPortPairDetailCSQL").append("\n"); 
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
		query.append("INSERT INTO sce_port_pair_dtl( rout_rcv_dt" ).append("\n"); 
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
		query.append(",cre_usr_id" ).append("\n"); 
		query.append(",cre_dt" ).append("\n"); 
		query.append(",upd_usr_id" ).append("\n"); 
		query.append(",upd_dt" ).append("\n"); 
		query.append(",org_loc_cd" ).append("\n"); 
		query.append(",dest_loc_cd" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES( @[rout_rcv_dt]" ).append("\n"); 
		query.append(",@[rout_seq]" ).append("\n"); 
		query.append(",@[cust_trd_prnr_id]" ).append("\n"); 
		query.append(",@[por_cd]" ).append("\n"); 
		query.append(",@[n1st_pol_cd]" ).append("\n"); 
		query.append(",@[n1st_pod_cd]" ).append("\n"); 
		query.append(",@[n2nd_pol_cd]" ).append("\n"); 
		query.append(",@[n2nd_pod_cd]" ).append("\n"); 
		query.append(",@[n3rd_pol_cd]" ).append("\n"); 
		query.append(",@[n3rd_pod_cd]" ).append("\n"); 
		query.append(",@[n4th_pol_cd]" ).append("\n"); 
		query.append(",@[n4th_pod_cd]" ).append("\n"); 
		query.append(",@[del_cd]" ).append("\n"); 
		query.append(",'S'" ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append("#if (${usr_id} != '')" ).append("\n"); 
		query.append(",'$usr_id'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append("#if (${usr_id} != '')" ).append("\n"); 
		query.append(",'$usr_id'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[pol_cd]" ).append("\n"); 
		query.append(",@[pod_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}