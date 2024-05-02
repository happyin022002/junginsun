/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairRouteDBDAOSearchPortPairDetailsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.24
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.06.24 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairRouteDBDAOSearchPortPairDetailsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPortPairDetails
	  * </pre>
	  */
	public PortPairRouteDBDAOSearchPortPairDetailsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("partner_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("no_use_flag",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.integration").append("\n"); 
		query.append("FileName : PortPairRouteDBDAOSearchPortPairDetailsRSQL").append("\n"); 
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
		query.append(",org_loc_cd AS pol_cd" ).append("\n"); 
		query.append(",n1st_pol_cd" ).append("\n"); 
		query.append(",n1st_pod_cd" ).append("\n"); 
		query.append(",n2nd_pol_cd" ).append("\n"); 
		query.append(",n2nd_pod_cd" ).append("\n"); 
		query.append(",n3rd_pol_cd" ).append("\n"); 
		query.append(",n3rd_pod_cd" ).append("\n"); 
		query.append(",n4th_pol_cd" ).append("\n"); 
		query.append(",n4th_pod_cd" ).append("\n"); 
		query.append(",dest_loc_cd AS pod_cd" ).append("\n"); 
		query.append(",del_cd" ).append("\n"); 
		query.append(",UPD_IND_CD AS ocean_flag" ).append("\n"); 
		query.append(",use_flg" ).append("\n"); 
		query.append(",mnl_use_flg" ).append("\n"); 
		query.append(",'' as delt_flg" ).append("\n"); 
		query.append(",cre_usr_id" ).append("\n"); 
		query.append(",TO_CHAR(cre_dt, 'YYYYMMDDHH24MI') AS cre_dt" ).append("\n"); 
		query.append(",DECODE(mnl_use_flg,'N',upd_usr_id,'')AS upd_usr_id" ).append("\n"); 
		query.append(",DECODE(mnl_use_flg,'N',TO_CHAR(upd_dt, 'YYYYMMDDHH24MI'),'') AS upd_dt" ).append("\n"); 
		query.append("FROM sce_port_pair_dtl dtl" ).append("\n"); 
		query.append("WHERE cust_trd_prnr_id = @[partner_id]" ).append("\n"); 
		query.append("/* condition - POR */" ).append("\n"); 
		query.append("#if (${por_port_cd} != '')" ).append("\n"); 
		query.append("AND por_cd = @[por_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - POL */" ).append("\n"); 
		query.append("#if (${pol_port_cd} != '')" ).append("\n"); 
		query.append("AND n1st_pol_cd = @[pol_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - POD */" ).append("\n"); 
		query.append("#if (${pod_port_cd} != '')" ).append("\n"); 
		query.append("AND dest_loc_cd = @[pod_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - DEL */" ).append("\n"); 
		query.append("#if (${del_port_cd} != '')" ).append("\n"); 
		query.append("AND del_cd = @[del_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND CASE WHEN @[no_use_flag] = 'Y'" ).append("\n"); 
		query.append("AND NVL(mnl_use_flg,'Y') = 'Y' AND use_flg = 'Y'" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("WHEN @[no_use_flag] = 'N'" ).append("\n"); 
		query.append("--AND (mnl_use_flg = 'N' OR use_flg = 'N')" ).append("\n"); 
		query.append("AND mnl_use_flg = 'N'" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END = 'Y'" ).append("\n"); 
		query.append("AND CASE WHEN @[ts_type] = 'A'" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("WHEN @[ts_type] = 'D'" ).append("\n"); 
		query.append("AND n2nd_pod_cd IS NULL" ).append("\n"); 
		query.append("AND n3rd_pod_cd IS NULL" ).append("\n"); 
		query.append("AND n4th_pod_cd IS NULL" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("WHEN @[ts_type] = 'T'" ).append("\n"); 
		query.append("AND (n2nd_pod_cd IS NOT NULL" ).append("\n"); 
		query.append("OR n3rd_pod_cd IS NOT NULL)" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END = 'Y'" ).append("\n"); 

	}
}