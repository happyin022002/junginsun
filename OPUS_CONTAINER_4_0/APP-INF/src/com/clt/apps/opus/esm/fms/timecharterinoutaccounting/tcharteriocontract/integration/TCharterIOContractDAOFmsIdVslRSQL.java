/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TCharterIOContractDAOFmsIdVslRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2010.02.01 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOContractDAOFmsIdVslRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOContractDAOFmsIdVslRSQL
	  * </pre>
	  */
	public TCharterIOContractDAOFmsIdVslRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration").append("\n"); 
		query.append("FileName : TCharterIOContractDAOFmsIdVslRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("	  vsl_cd," ).append("\n"); 
		query.append("	  (select vsl_eng_nm" ).append("\n"); 
		query.append("		 from mdm_vsl_cntr" ).append("\n"); 
		query.append("		 where delt_flg = 'N'" ).append("\n"); 
		query.append("		   and vsl_cd = fi.vsl_cd" ).append("\n"); 
		query.append("		   and rownum = 1) vsl_eng_nm," ).append("\n"); 
		query.append("	  vsl_cd ori_vsl_cd," ).append("\n"); 
		query.append("	  (select vsl_eng_nm" ).append("\n"); 
		query.append("		 from mdm_vsl_cntr" ).append("\n"); 
		query.append("		 where delt_flg = 'N'" ).append("\n"); 
		query.append("		   and vsl_cd = fi.vsl_cd" ).append("\n"); 
		query.append("		   and rownum = 1) ori_vsl_eng_nm," ).append("\n"); 
		query.append("	  use_flg," ).append("\n"); 
		query.append("      flet_rpt_flg" ).append("\n"); 
		query.append(" from fms_id_vsl fi" ).append("\n"); 
		query.append("where flet_ctrt_no = @[flet_ctrt_no]" ).append("\n"); 
		query.append("order by cre_dt" ).append("\n"); 

	}
}