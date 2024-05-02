/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairRouteDBDAOAddPortPairMasterCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2010.03.09 신한성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Shin Han Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairRouteDBDAOAddPortPairMasterCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PortPairMaster 정보 입력
	  * </pre>
	  */
	public PortPairRouteDBDAOAddPortPairMasterCSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.integration").append("\n"); 
		query.append("FileName : PortPairRouteDBDAOAddPortPairMasterCSQL").append("\n"); 
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
		query.append("INSERT INTO sce_port_pair_mst( cust_trd_prnr_id" ).append("\n"); 
		query.append(",por_cd" ).append("\n"); 
		query.append(",pol_cd" ).append("\n"); 
		query.append(",pod_cd" ).append("\n"); 
		query.append(",del_cd" ).append("\n"); 
		query.append(",use_flg" ).append("\n"); 
		query.append(",cre_usr_id" ).append("\n"); 
		query.append(",cre_dt" ).append("\n"); 
		query.append(",upd_usr_id" ).append("\n"); 
		query.append(",upd_dt" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES( @[cust_trd_prnr_id]" ).append("\n"); 
		query.append(",@[por_cd]" ).append("\n"); 
		query.append(",@[pol_cd]" ).append("\n"); 
		query.append(",@[pod_cd]" ).append("\n"); 
		query.append(",@[del_cd]" ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append("#if (${usr_id} != '')" ).append("\n"); 
		query.append(",'$usr_id'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append("#if (${usr_id} != '')" ).append("\n"); 
		query.append(",'$usr_id'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",SYSDATE)" ).append("\n"); 

	}
}