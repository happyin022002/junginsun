/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchDivBChrgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2010.01.04 최성환
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

public class DMTCalculationDBDAOSearchDivBChrgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDivBChrgList
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchDivBChrgListRSQL(){
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
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("over_day",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchDivBChrgListRSQL").append("\n"); 
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
		query.append("SELECT      FT_OVR_DYS 	ft_over," ).append("\n"); 
		query.append("FT_UND_DYS 	ft_under," ).append("\n"); 
		query.append("DECODE( SUBSTR(@[cntrts],2,1), '2', CNTR_20FT_RT_AMT," ).append("\n"); 
		query.append("'4', CNTR_40FT_RT_AMT," ).append("\n"); 
		query.append("'5', CNTR_HC_RT_AMT," ).append("\n"); 
		query.append("'7', CNTR_45FT_RT_AMT  ) rate" ).append("\n"); 
		query.append("FROM DMT_RFA_EXPT_RT" ).append("\n"); 
		query.append("WHERE RFA_EXPT_DAR_NO 	= @[dar_no]" ).append("\n"); 
		query.append("AND RFA_EXPT_MAPG_SEQ 	= @[mapg_seq]" ).append("\n"); 
		query.append("AND RFA_EXPT_VER_SEQ 	= @[ver_seq]" ).append("\n"); 
		query.append("AND RFA_RQST_DTL_SEQ 	= @[dtl_seq]" ).append("\n"); 
		query.append("AND CVRG_CMB_SEQ       = 1" ).append("\n"); 
		query.append("AND FT_OVR_DYS 		<= (@[over_day] + @[div_over_day])" ).append("\n"); 
		query.append("ORDER BY RFA_EXPT_RT_SEQ" ).append("\n"); 

	}
}