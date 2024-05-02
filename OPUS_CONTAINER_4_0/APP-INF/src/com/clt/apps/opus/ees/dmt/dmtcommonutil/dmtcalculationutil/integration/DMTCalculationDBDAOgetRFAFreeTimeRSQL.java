/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCalculationDBDAOgetRFAFreeTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOgetRFAFreeTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Free Time Search
	  * </pre>
	  */
	public DMTCalculationDBDAOgetRFAFreeTimeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOgetRFAFreeTimeRSQL").append("\n"); 
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
		query.append("SELECT FT_DYS FT_DAY" ).append("\n"); 
		query.append("  FROM DMT_RFA_EXPT_FREE_TM" ).append("\n"); 
		query.append(" WHERE RFA_EXPT_DAR_NO 		= @[dar_no]" ).append("\n"); 
		query.append("   AND RFA_EXPT_MAPG_SEQ 	= @[mapg_seq]" ).append("\n"); 
		query.append("   AND RFA_EXPT_VER_SEQ 	= @[ver_seq]" ).append("\n"); 
		query.append("   AND RFA_RQST_DTL_SEQ 	= @[dtl_seq]" ).append("\n"); 
		query.append("   AND CVRG_CMB_SEQ 		= @[cmb_seq]" ).append("\n"); 
		query.append("   AND ( ( CNTR_FM_QTY <= @[qty] AND CNTR_TO_QTY = 0 )" ).append("\n"); 
		query.append("      OR ( CNTR_FM_QTY <= @[qty] AND CNTR_TO_QTY IS NULL )" ).append("\n"); 
		query.append("      OR ( CNTR_FM_QTY <= @[qty] AND CNTR_TO_QTY >= @[qty] ) )" ).append("\n"); 

	}
}