/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PreAllocationDBDAOSearchPreAllocation0068List01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2010.01.21 주선영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ju Sun Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreAllocationDBDAOSearchPreAllocation0068List01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pre-allocation inquiry
	  * </pre>
	  */
	public PreAllocationDBDAOSearchPreAllocation0068List01RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toTrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.integration").append("\n"); 
		query.append("FileName : PreAllocationDBDAOSearchPreAllocation0068List01RSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.BSE_YR," ).append("\n"); 
		query.append("A.BSE_MON," ).append("\n"); 
		query.append("A.REP_TRD_CD," ).append("\n"); 
		query.append("A.RLANE_CD," ).append("\n"); 
		query.append("A.DIR_CD," ).append("\n"); 
		query.append("A.VSL_CLSS_CAPA," ).append("\n"); 
		query.append("TO_CHAR(A.VSL_CLSS_CAPA, 'FM9,990') VSL_CLSS_CAPA_TXT," ).append("\n"); 
		query.append("A.PORT_CD," ).append("\n"); 
		query.append("A.SPC_ALOC_QTY," ).append("\n"); 
		query.append("A.TO_TRD_CD," ).append("\n"); 
		query.append("A.TO_DIR_CD" ).append("\n"); 
		query.append("FROM SAQ_PRE_ALOC A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.BSE_YR = @[year]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${month} != \"\")" ).append("\n"); 
		query.append("AND A.BSE_MON = @[month]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trade} != \"\")" ).append("\n"); 
		query.append("AND A.REP_TRD_CD = @[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${toTrade} != \"\")" ).append("\n"); 
		query.append("AND A.TO_TRD_CD = @[toTrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bound} != \"\")" ).append("\n"); 
		query.append("AND A.DIR_CD = @[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}