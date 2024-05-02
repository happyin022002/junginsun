/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharteIOContractDAOFmsSearchContractNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharteIOContractDAOFmsSearchContractNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * aa
	  * </pre>
	  */
	public TCharteIOContractDAOFmsSearchContractNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration").append("\n"); 
		query.append("FileName : TCharteIOContractDAOFmsSearchContractNoRSQL").append("\n"); 
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
		query.append("SELECT MVC.VSL_CD," ).append("\n"); 
		query.append("	   FC.FLET_CTRT_NO, " ).append("\n"); 
		query.append(" 	   MVC.VSL_ENG_NM " ).append("\n"); 
		query.append("  FROM FMS_CONTRACT FC, MDM_VSL_CNTR MVC " ).append("\n"); 
		query.append(" WHERE FC.VSL_CD = MVC.VSL_CD" ).append("\n"); 
		query.append("   AND FC.FLET_CTRT_TP_CD = @[flet_ctrt_tp_cd]" ).append("\n"); 
		query.append("   AND FC.VSL_CD LIKE '%' || @[vsl_cd] || '%'" ).append("\n"); 
		query.append("   AND NVL(FC.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("   AND MVC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${ctrt_flag} != 'Y')" ).append("\n"); 
		query.append("   AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY FC.CRE_DT DESC" ).append("\n"); 

	}
}