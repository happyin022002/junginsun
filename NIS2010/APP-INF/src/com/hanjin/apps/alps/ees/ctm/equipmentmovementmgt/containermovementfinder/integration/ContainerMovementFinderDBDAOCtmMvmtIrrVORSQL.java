/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOCtmMvmtIrrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.03.08 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOCtmMvmtIrrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOCtmMvmtIrrVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_irrtype",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_settled",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOCtmMvmtIrrVORSQL").append("\n"); 
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
		query.append("SELECT LOC.LOC_CD," ).append("\n"); 
		query.append("IRR.ORG_YD_CD," ).append("\n"); 
		query.append("CNTR_BKG_ATCH_CD," ).append("\n"); 
		query.append("CNMV_IRR_STL_FLG," ).append("\n"); 
		query.append("IRR.CNTR_NO," ).append("\n"); 
		query.append("IRR.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNTR_BKG_ATCH_CD," ).append("\n"); 
		query.append("CNMV_IRR_STL_FLG," ).append("\n"); 
		query.append("IRR.CNMV_STS_CD," ).append("\n"); 
		query.append("IRR.ORG_YD_CD," ).append("\n"); 
		query.append("IRR.BKG_NO BKG_NO1," ).append("\n"); 
		query.append("'' BKG_SPLIT1," ).append("\n"); 
		query.append("TO_CHAR (IRR.CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI') AS CNMV_EVNT_DT," ).append("\n"); 
		query.append("PRE_CNMV_STS_CD," ).append("\n"); 
		query.append("PRE_ORG_YD_CD," ).append("\n"); 
		query.append("IRR.PRE_BKG_NO AS BKG_NO2," ).append("\n"); 
		query.append("'' BKG_SPLIT2," ).append("\n"); 
		query.append("TO_CHAR (PRE_CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI') AS PRE_CNMV_EVNT_DT" ).append("\n"); 
		query.append("FROM CTM_MVMT_IRR IRR," ).append("\n"); 
		query.append("MDM_LOCATION LOC," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT CHT" ).append("\n"); 
		query.append("WHERE SUBSTR (IRR.ORG_YD_CD, 0, 5) = LOC.LOC_CD" ).append("\n"); 
		query.append("AND CHT.SCC_CD = LOC.SCC_CD" ).append("\n"); 
		query.append("#if (${p_office} != '')" ).append("\n"); 
		query.append("AND CHT.LCC_CD = @[p_office]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_yard1} != '')" ).append("\n"); 
		query.append("AND SUBSTR (IRR.ORG_YD_CD, 0, 5) = @[p_yard1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_yard2} != '')" ).append("\n"); 
		query.append("AND SUBSTR (IRR.ORG_YD_CD, 6, 2) = @[p_yard2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_date1} != '')" ).append("\n"); 
		query.append("AND IRR.CNMV_EVNT_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_irrtype} != '')" ).append("\n"); 
		query.append("AND CNTR_BKG_ATCH_CD = @[p_irrtype]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_settled} != '')" ).append("\n"); 
		query.append("AND CNMV_IRR_STL_FLG = @[p_settled]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}