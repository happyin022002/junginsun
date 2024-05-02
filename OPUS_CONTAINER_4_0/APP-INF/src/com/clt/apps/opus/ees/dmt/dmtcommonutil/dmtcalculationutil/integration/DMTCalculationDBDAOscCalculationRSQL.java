/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationDBDAOscCalculationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.25 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOscCalculationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * scCalculation
	  * </pre>
	  */
	public DMTCalculationDBDAOscCalculationRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("div_over_day",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dsm_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntrts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dsd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("over_day",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT	FT_FM_DYS dtr_ft_over," ).append("\n"); 
		query.append("FT_TO_DYS dtr_ft_under," ).append("\n"); 
		query.append("DECODE( SUBSTR(@[cntrts],2,1),   '2', CNTR_20FT_RT_AMT," ).append("\n"); 
		query.append("'4', CNTR_40FT_RT_AMT," ).append("\n"); 
		query.append("'5', CNTR_HC_RT_AMT," ).append("\n"); 
		query.append("'7', CNTR_45FT_RT_AMT  ) dtr_rate" ).append("\n"); 
		query.append("FROM	DMT_SC_EXPT_RT_ADJ" ).append("\n"); 
		query.append("WHERE	PROP_NO				=	@[sc_no]" ).append("\n"); 
		query.append("AND	SC_EXPT_VER_SEQ		=	@[dsm_seq]" ).append("\n"); 
		query.append("AND	SC_EXPT_GRP_SEQ		=	@[dsd_seq]" ).append("\n"); 
		query.append("AND	FT_FM_DYS			<=	(@[over_day] + @[div_over_day])" ).append("\n"); 
		query.append("ORDER BY RT_SEQ" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOscCalculationRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}