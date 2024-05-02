/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairRouteDBDAOModifyPortPairDetailUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2010.03.10 신한성
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

public class PortPairRouteDBDAOModifyPortPairDetailUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port Pairt Mater 테이블 USE_FLG 'N'으로 변경하는 경우  DETAIL 테이블의 USE_FLG 'N'으로 설정
	  * </pre>
	  */
	public PortPairRouteDBDAOModifyPortPairDetailUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.integration").append("\n"); 
		query.append("FileName : PortPairRouteDBDAOModifyPortPairDetailUSQL").append("\n"); 
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
		query.append("UPDATE sce_port_pair_dtl" ).append("\n"); 
		query.append("SET mnl_use_flg = @[mnl_use_flg]" ).append("\n"); 
		query.append("#if (${usr_id} != '')" ).append("\n"); 
		query.append(", upd_usr_id = '$usr_id'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", upd_dt = SYSDATE" ).append("\n"); 
		query.append("WHERE rout_rcv_dt = @[rout_rcv_dt]" ).append("\n"); 
		query.append("AND rout_seq = @[rout_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}