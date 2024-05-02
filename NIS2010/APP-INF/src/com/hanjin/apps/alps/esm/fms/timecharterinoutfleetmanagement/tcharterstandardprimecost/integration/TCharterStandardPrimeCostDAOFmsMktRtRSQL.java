/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterStandardPrimeCostDAOFmsMktRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.08.21 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterStandardPrimeCostDAOFmsMktRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Hire Base Input Select
	  * </pre>
	  */
	public TCharterStandardPrimeCostDAOFmsMktRtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mkt_rt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.integration").append("\n"); 
		query.append("FileName : TCharterStandardPrimeCostDAOFmsMktRtRSQL").append("\n"); 
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
		query.append("SELECT @[mkt_rt_yrmon] MKT_RT_YRMON," ).append("\n"); 
		query.append("MKT_RT_SEQ," ).append("\n"); 
		query.append("RNG_FM_QTY," ).append("\n"); 
		query.append("RNG_TO_QTY," ).append("\n"); 
		query.append("BLD_TP_NM," ).append("\n"); 
		query.append("MKT_RT_AMT," ).append("\n"); 
		query.append("MKT_RT_YRMON PREV_MKT_RT_YTMON" ).append("\n"); 
		query.append("FROM FMS_MKT_RT" ).append("\n"); 
		query.append("WHERE MKT_RT_YRMON = (CASE WHEN (SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM FMS_MKT_RT" ).append("\n"); 
		query.append("WHERE MKT_RT_YRMON = @[mkt_rt_yrmon]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N') > 0" ).append("\n"); 
		query.append("THEN @[mkt_rt_yrmon]" ).append("\n"); 
		query.append("ELSE (SELECT MAX(MKT_RT_YRMON)" ).append("\n"); 
		query.append("FROM FMS_MKT_RT" ).append("\n"); 
		query.append("WHERE MKT_RT_YRMON < @[mkt_rt_yrmon]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("END)" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY RNG_FM_QTY" ).append("\n"); 

	}
}