/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationDBDAOgetSCEFreeTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.22 최성환
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

public class DMTCalculationDBDAOgetSCEFreeTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getSCEFreeTime
	  * </pre>
	  */
	public DMTCalculationDBDAOgetSCEFreeTimeRSQL(){
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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  FT_DYS ft_day" ).append("\n"); 
		query.append("FROM  DMT_SC_EXPT_FREE_TM" ).append("\n"); 
		query.append("WHERE  PROP_NO        			=    @[sc_no]" ).append("\n"); 
		query.append("AND  SC_EXPT_VER_SEQ        	=    @[ver_seq]" ).append("\n"); 
		query.append("AND  SC_EXPT_GRP_SEQ        	=    @[grp_seq]" ).append("\n"); 
		query.append("AND  (" ).append("\n"); 
		query.append("( CNTR_FM_QTY <= @[qty] AND CNTR_TO_QTY = 0 )" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("( CNTR_FM_QTY <= @[qty] AND CNTR_TO_QTY IS NULL )" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("( CNTR_FM_QTY <= @[qty] AND CNTR_TO_QTY >= @[qty] )" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOgetSCEFreeTimeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}