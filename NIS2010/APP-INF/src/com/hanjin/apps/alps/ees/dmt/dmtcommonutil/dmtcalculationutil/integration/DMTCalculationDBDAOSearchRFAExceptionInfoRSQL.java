/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchRFAExceptionInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.15
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.10.15 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchRFAExceptionInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Exception Info
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchRFAExceptionInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchRFAExceptionInfoRSQL").append("\n"); 
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
		query.append("SELECT D.ADD_DYS  AS ADD_DAY" ).append("\n"); 
		query.append("	  ,D.TTL_DYS  AS TTL_DAY" ).append("\n"); 
		query.append("	  ,D.XCLD_SAT_FLG  AS EXCL_SAT" ).append("\n"); 
		query.append("	  ,D.XCLD_SUN_FLG  AS EXCL_SUN" ).append("\n"); 
		query.append("	  ,D.XCLD_HOL_FLG  AS EXCL_HOLI" ).append("\n"); 
		query.append("      ,D.RT_USE_FLG    AS RATE_MK" ).append("\n"); 
		query.append("	  ,D.CURR_CD       AS CURR_CD" ).append("\n"); 
		query.append("      ,D.FT_USE_FLG    AS FTIME_MK" ).append("\n"); 
		query.append("      ,D.CVRG_CMB_SEQ  AS CMB_SEQ" ).append("\n"); 
		query.append(" FROM	DMT_RFA_EXPT_TRF_DTL D" ).append("\n"); 
		query.append("WHERE	D.RFA_EXPT_DAR_NO		= @[dar_no]" ).append("\n"); 
		query.append("AND		D.RFA_EXPT_MAPG_SEQ		= @[mapg_seq]" ).append("\n"); 
		query.append("AND		D.RFA_EXPT_VER_SEQ		= @[ver_seq]" ).append("\n"); 
		query.append("AND     D.RFA_RQST_DTL_SEQ		= @[dtl_seq]" ).append("\n"); 

	}
}