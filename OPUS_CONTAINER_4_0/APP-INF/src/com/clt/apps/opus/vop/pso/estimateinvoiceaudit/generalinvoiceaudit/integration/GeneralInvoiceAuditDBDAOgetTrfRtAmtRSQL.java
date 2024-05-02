/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetTrfRtAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2010.01.20 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetTrfRtAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getTrfRtAmt
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetTrfRtAmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obj_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetTrfRtAmtRSQL").append("\n"); 
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
		query.append("select nvl(sum(rt_val)||'', '0/*no-rate-found*/') rtval from " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("T1.TRF_RT_AMT/(DECODE(t2.pso_rt_tp_cd, 'R', 100, 1)) rt_val" ).append("\n"); 
		query.append("FROM PSO_TRF_DTL T1, PSO_TARIFF T2" ).append("\n"); 
		query.append("WHERE T1.PORT_TRF_NO = @[port_trf_no]" ).append("\n"); 
		query.append("AND T1.PORT_TRF_NO = T2.PORT_TRF_NO" ).append("\n"); 
		query.append("AND @[flag] = '2'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("T1.TRF_RT_AMT" ).append("\n"); 
		query.append("FROM PSO_TRF_DTL T1, PSO_TARIFF T2" ).append("\n"); 
		query.append("WHERE T1.PORT_TRF_NO = @[port_trf_no]" ).append("\n"); 
		query.append("AND T1.PORT_TRF_NO = T2.PORT_TRF_NO" ).append("\n"); 
		query.append("AND @[obj_val] between T1.FM_VAL and T1.TO_VAL" ).append("\n"); 
		query.append("AND @[flag] = '1'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}