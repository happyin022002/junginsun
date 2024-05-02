/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchSCExceptionInfoRSQL.java
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

public class DMTCalculationDBDAOSearchSCExceptionInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SC Exception
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchSCExceptionInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_expt_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchSCExceptionInfoRSQL").append("\n"); 
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
		query.append("SELECT   " ).append("\n"); 
		query.append("D.PROP_NO			PROP_NO," ).append("\n"); 
		query.append("D.SC_EXPT_VER_SEQ	VER_SEQ," ).append("\n"); 
		query.append("D.SC_EXPT_GRP_SEQ  	GRP_SEQ," ).append("\n"); 
		query.append("D.FT_FLG		FTIME_MK,	" ).append("\n"); 
		query.append("D.XCLD_SAT_FLG	EXCL_SAT," ).append("\n"); 
		query.append("D.XCLD_SUN_FLG	EXCL_SUN,	" ).append("\n"); 
		query.append("D.XCLD_HOL_FLG	EXCL_HOLI," ).append("\n"); 
		query.append("D.FT_ADD_FLG	FT_ADD_MK,	" ).append("\n"); 
		query.append("D.FT_ADD_DYS	FT_ADD_DAY," ).append("\n"); 
		query.append("D.FT_ADJ_FLG	FT_ADJ_MK,	" ).append("\n"); 
		query.append("D.RT_ADJ_FLG	RT_ADJ_MK," ).append("\n"); 
		query.append("D.CURR_CD 		CUR_CD" ).append("\n"); 
		query.append("FROM  DMT_SC_EXPT_GRP D, " ).append("\n"); 
		query.append("      PRI_SP_HDR P" ).append("\n"); 
		query.append("WHERE D.PROP_NO = P.PROP_NO" ).append("\n"); 
		query.append("AND P.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("AND D.SC_EXPT_VER_SEQ =  @[sc_expt_ver_seq]" ).append("\n"); 
		query.append("AND D.SC_EXPT_GRP_SEQ =  @[sc_expt_grp_seq]" ).append("\n"); 

	}
}