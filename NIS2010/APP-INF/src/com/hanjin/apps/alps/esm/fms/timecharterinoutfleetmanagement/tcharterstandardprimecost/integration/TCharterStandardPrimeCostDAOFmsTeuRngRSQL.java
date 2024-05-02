/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.17 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Woo-Seok
 * @see 
 * @since J2EE 1.4
 */

public class TCharterStandardPrimeCostDAOFmsTeuRngRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TEU Range Target Select
	  * </pre>
	  */
	public TCharterStandardPrimeCostDAOFmsTeuRngRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rng_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("select" ).append("\n"); 
		query.append("rng_yr," ).append("\n"); 
		query.append("rng_seq," ).append("\n"); 
		query.append("rng_fm_qty," ).append("\n"); 
		query.append("rng_to_qty," ).append("\n"); 
		query.append("hir_aply_flg," ).append("\n"); 
		query.append("mkt_rt_aply_flg" ).append("\n"); 
		query.append("from fms_teu_rng" ).append("\n"); 
		query.append("where	rng_yr = @[rng_yr]" ).append("\n"); 
		query.append("and delt_flg = 'N'" ).append("\n"); 
		query.append("order by rng_fm_qty" ).append("\n"); 

	}
}