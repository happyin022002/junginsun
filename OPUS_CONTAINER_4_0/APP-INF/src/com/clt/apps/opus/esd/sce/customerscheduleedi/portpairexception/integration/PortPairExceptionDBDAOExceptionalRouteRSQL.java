/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairExceptionDBDAOExceptionalRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.04.29 함대성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairExceptionDBDAOExceptionalRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PortPairExceptionDBDAOExceptionalRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.integration").append("\n"); 
		query.append("FileName : PortPairExceptionDBDAOExceptionalRouteRSQL").append("\n"); 
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
		query.append("SELECT rout_seq ," ).append("\n"); 
		query.append("cust_trd_prnr_id ," ).append("\n"); 
		query.append("lnk_knt ," ).append("\n"); 
		query.append("por_cd ," ).append("\n"); 
		query.append("org_loc_cd," ).append("\n"); 
		query.append("n1st_pol_cd ," ).append("\n"); 
		query.append("n1st_lane_cd," ).append("\n"); 
		query.append("n1st_pod_cd ," ).append("\n"); 
		query.append("n1st_skd_dir_cd ," ).append("\n"); 
		query.append("n2nd_pol_cd ," ).append("\n"); 
		query.append("n2nd_lane_cd," ).append("\n"); 
		query.append("n3rd_lane_cd," ).append("\n"); 
		query.append("n2nd_pod_cd," ).append("\n"); 
		query.append("n3rd_pol_cd," ).append("\n"); 
		query.append("n2nd_skd_dir_cd," ).append("\n"); 
		query.append("n3rd_skd_dir_cd," ).append("\n"); 
		query.append("dest_loc_cd," ).append("\n"); 
		query.append("del_cd ," ).append("\n"); 
		query.append("usr_rmk ," ).append("\n"); 
		query.append("delt_flg ," ).append("\n"); 
		query.append("cre_usr_id ," ).append("\n"); 
		query.append("TO_CHAR(cre_dt, 'YYYYMMDDHH24MI') AS cre_dt," ).append("\n"); 
		query.append("upd_usr_id AS upd_usr_id ," ).append("\n"); 
		query.append("TO_CHAR(upd_dt, 'YYYYMMDDHH24MI') AS upd_dt," ).append("\n"); 
		query.append("/* Condition */" ).append("\n"); 
		query.append("'' partner_name," ).append("\n"); 
		query.append("'' del_port_cd," ).append("\n"); 
		query.append("'' pol_port_cd," ).append("\n"); 
		query.append("'' partner_id," ).append("\n"); 
		query.append("'' por_port_cd," ).append("\n"); 
		query.append("'' pod_port_cd" ).append("\n"); 
		query.append("FROM SCE_PORT_PAIR_EXPT" ).append("\n"); 
		query.append("WHERE cust_trd_prnr_id = @[cust_trd_prnr_id]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("/* condition - POR */" ).append("\n"); 
		query.append("#if (${por_port_cd} != '')" ).append("\n"); 
		query.append("#foreach($key1 IN ${por_port_cd})" ).append("\n"); 
		query.append("AND por_cd IN ('$key1')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - POL */" ).append("\n"); 
		query.append("#if (${pol_port_cd} != '')" ).append("\n"); 
		query.append("#foreach($key2 IN ${pol_port_cd})" ).append("\n"); 
		query.append("AND n1st_pol_cd IN ('$key2')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - POD */" ).append("\n"); 
		query.append("#if (${pod_port_cd} != '')" ).append("\n"); 
		query.append("#foreach($key3 IN ${pod_port_cd})" ).append("\n"); 
		query.append("AND dest_loc_cd IN ('$key3')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - DEL */" ).append("\n"); 
		query.append("#if (${del_port_cd} != '')" ).append("\n"); 
		query.append("#foreach($key4 IN ${del_port_cd})" ).append("\n"); 
		query.append("AND del_cd IN ('$key4')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}