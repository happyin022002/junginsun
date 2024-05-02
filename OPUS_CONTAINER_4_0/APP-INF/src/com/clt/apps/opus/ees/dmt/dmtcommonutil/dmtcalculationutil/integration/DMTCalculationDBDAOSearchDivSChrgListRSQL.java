/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchDivSChrgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.12.01 최성환
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

public class DMTCalculationDBDAOSearchDivSChrgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDivSChrgList
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchDivSChrgListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("over_day",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchDivSChrgListRSQL").append("\n"); 
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
		query.append("SELECT	M.FT_FM_DYS ft_over," ).append("\n"); 
		query.append("M.FT_TO_DYS ft_under," ).append("\n"); 
		query.append("DECODE( SUBSTR(@[cntrts],2,1),   '2', M.CNTR_20FT_RT_AMT," ).append("\n"); 
		query.append("'4', M.CNTR_40FT_RT_AMT," ).append("\n"); 
		query.append("'5', M.CNTR_HC_RT_AMT," ).append("\n"); 
		query.append("'7', M.CNTR_45FT_RT_AMT  ) rate" ).append("\n"); 
		query.append("FROM	DMT_SC_EXPT_RT_ADJ M" ).append("\n"); 
		query.append(",PRI_SP_HDR         P" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	M.PROP_NO				=	P.PROP_NO" ).append("\n"); 
		query.append("AND     P.SC_NO					=   @[sc_no]" ).append("\n"); 
		query.append("AND		M.SC_EXPT_VER_SEQ		=	@[ver_seq]" ).append("\n"); 
		query.append("AND		M.SC_EXPT_GRP_SEQ		=	@[grp_seq]" ).append("\n"); 
		query.append("AND		M.FT_FM_DYS				<=	(@[over_day] + @[div_over_day])" ).append("\n"); 

	}
}