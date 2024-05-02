/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCalculationDBDAOBbsChargeCalculationRSQL.java
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

public class DMTCalculationDBDAOBbsChargeCalculationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BbsChargeCalculation
	  * </pre>
	  */
	public DMTCalculationDBDAOBbsChargeCalculationRSQL(){
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
		params.put("mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOBbsChargeCalculationRSQL").append("\n"); 
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
		query.append("#if (${dc_appl_rate} == 'B')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CURR_CD" ).append("\n"); 
		query.append("FROM DMT_RFA_EXPT_TRF_DTL" ).append("\n"); 
		query.append("WHERE RFA_EXPT_DAR_NO	 = @[dar_no]" ).append("\n"); 
		query.append("AND RFA_EXPT_MAPG_SEQ = @[mapg_seq]" ).append("\n"); 
		query.append("AND RFA_EXPT_VER_SEQ	 = @[ver_seq]" ).append("\n"); 
		query.append("AND RFA_RQST_DTL_SEQ	 = @[dtl_seq]" ).append("\n"); 
		query.append("AND CVRG_CMB_SEQ      = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${dc_appl_rate} == 'S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT G.CURR_CD CURR_CD" ).append("\n"); 
		query.append("FROM DMT_SC_EXPT_GRP G" ).append("\n"); 
		query.append(",PRI_SP_HDR      P" ).append("\n"); 
		query.append("WHERE G.PROP_NO		 	= P.PROP_NO" ).append("\n"); 
		query.append("AND P.SC_NO			 	= @[prop_no]" ).append("\n"); 
		query.append("AND G.SC_EXPT_VER_SEQ	= @[ver_seq]" ).append("\n"); 
		query.append("AND G.SC_EXPT_GRP_SEQ	= @[grp_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}