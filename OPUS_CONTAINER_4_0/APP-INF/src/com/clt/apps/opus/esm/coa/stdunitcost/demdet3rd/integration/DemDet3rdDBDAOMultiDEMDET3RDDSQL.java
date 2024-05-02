/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DemDet3rdDBDAOMultiDEMDET3RDDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.29
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDet3rdDBDAOMultiDEMDET3RDDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * _TRNS_FDR_TERM 테이블의 데이터 삭제
	  * </pre>
	  */
	public DemDet3rdDBDAOMultiDEMDET3RDDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.integration").append("\n"); 
		query.append("FileName : DemDet3rdDBDAOMultiDEMDET3RDDSQL").append("\n"); 
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
		query.append("DELETE FROM COA_DMDT_N3RD_PTY " ).append("\n"); 
		query.append(" WHERE COST_YRMON  = @[cost_yrmon]		   " ).append("\n"); 
		query.append("   AND CNTR_TPSZ_CD = @[cntr_tpsz_cd]		  " ).append("\n"); 
		query.append("   AND STND_COST_CD = @[stnd_cost_cd]" ).append("\n"); 

	}
}