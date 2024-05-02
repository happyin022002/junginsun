/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTransitFeeBalanceBCDBDAOremovePsoMsaDtlDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.05.22 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanalTransitFeeBalanceBCDBDAOremovePsoMsaDtlDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * removePsoMsaDtl
	  * </pre>
	  */
	public CanalTransitFeeBalanceBCDBDAOremovePsoMsaDtlDSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE FROM pso_msa_dtl" ).append("\n"); 
		query.append("WHERE	rev_yrmon = @[rev_yrmon]" ).append("\n"); 
		query.append("AND	vndr_seq = @[vndr_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.integration ").append("\n"); 
		query.append("FileName : CanalTransitFeeBalanceBCDBDAOremovePsoMsaDtlDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}