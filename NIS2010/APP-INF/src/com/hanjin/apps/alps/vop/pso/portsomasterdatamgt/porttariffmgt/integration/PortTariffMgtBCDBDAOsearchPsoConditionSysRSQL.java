/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchPsoConditionSysRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.11.16 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOsearchPsoConditionSysRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPsoConditionSys
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchPsoConditionSysRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchPsoConditionSysRSQL").append("\n"); 
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
		query.append("SELECT   rwgrp," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 1, dpval2)) col1," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 2, dpval2)) col2," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 3, dpval2)) col3," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 4, dpval2)) col4," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 5, dpval2)) col5," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 6, dpval2)) col6," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 7, dpval2)) col7," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 8, dpval2)) col8," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 9, dpval2)) col9," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 10, dpval2)) col10," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 11, dpval2)) col11," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 12, dpval2)) col12," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 0, dpval2)) col13" ).append("\n"); 
		query.append("FROM   (SELECT   CEIL (ROWNUM / 13) rwgrp, MOD (ROWNUM, 13) colpos, z.*" ).append("\n"); 
		query.append("FROM   (  SELECT   T2.*," ).append("\n"); 
		query.append("NVL (T3.OBJ_LIST_NM," ).append("\n"); 
		query.append("T2.PSO_COND_OPR_CD || T2.COND_OPR_VAL_CTNT)" ).append("\n"); 
		query.append("dpval," ).append("\n"); 
		query.append("NVL (T3.OBJ_LIST_NO || DECODE(t2.rt_obj_list_no, null,null, '<'||t2.rt_obj_list_no||'>')||''," ).append("\n"); 
		query.append("T2.PSO_COND_OPR_CD || T2.COND_OPR_VAL_CTNT)||'@'||PSO_COND_DTL_TP_CD" ).append("\n"); 
		query.append("dpval2" ).append("\n"); 
		query.append("FROM   pso_condition T1, pso_cond_dtl T2, pso_obj_list T3" ).append("\n"); 
		query.append("--, (select rownum rn from dict where rownum <=6 ) T4" ).append("\n"); 
		query.append("WHERE       T1.cond_no = @[cond_no]" ).append("\n"); 
		query.append("AND T1.cond_no = T2.cond_no" ).append("\n"); 
		query.append("AND T2.OBJ_LIST_NO = T3.OBJ_LIST_NO(+)" ).append("\n"); 
		query.append("ORDER BY   T2.COND_SEQ) z)" ).append("\n"); 
		query.append("GROUP BY   rwgrp" ).append("\n"); 
		query.append("ORDER BY   rwgrp" ).append("\n"); 

	}
}