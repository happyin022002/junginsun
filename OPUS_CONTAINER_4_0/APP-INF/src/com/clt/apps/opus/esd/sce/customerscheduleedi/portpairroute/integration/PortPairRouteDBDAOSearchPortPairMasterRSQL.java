/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairRouteDBDAOSearchPortPairMasterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.07
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2010.03.07 신한성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Shin Han Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairRouteDBDAOSearchPortPairMasterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * port pair master table을 조회한다
	  * </pre>
	  */
	public PortPairRouteDBDAOSearchPortPairMasterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("use_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.integration ").append("\n"); 
		query.append("FileName : PortPairRouteDBDAOSearchPortPairMasterRSQL").append("\n"); 
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
		query.append("SELECT cust_trd_prnr_id" ).append("\n"); 
		query.append(",por_cd" ).append("\n"); 
		query.append(",pol_cd" ).append("\n"); 
		query.append(",pod_cd" ).append("\n"); 
		query.append(",del_cd" ).append("\n"); 
		query.append(",use_flg" ).append("\n"); 
		query.append(",TO_CHAR(cre_dt, 'YYYYMMDDHH24MI') AS cre_dt" ).append("\n"); 
		query.append(",upd_usr_id" ).append("\n"); 
		query.append(",TO_CHAR(upd_dt, 'YYYYMMDDHH24MI') AS upd_dt" ).append("\n"); 
		query.append("FROM sce_port_pair_mst" ).append("\n"); 
		query.append("WHERE cust_trd_prnr_id = @[cust_trd_prnr_id]" ).append("\n"); 
		query.append("AND por_cd = @[por_cd]" ).append("\n"); 
		query.append("AND pol_cd = @[pol_cd]" ).append("\n"); 
		query.append("AND pod_cd = @[pod_cd]" ).append("\n"); 
		query.append("AND del_cd = @[del_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - USE FLAG */" ).append("\n"); 
		query.append("#if (${use_flg} != '')" ).append("\n"); 
		query.append("AND use_flg = @[use_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}