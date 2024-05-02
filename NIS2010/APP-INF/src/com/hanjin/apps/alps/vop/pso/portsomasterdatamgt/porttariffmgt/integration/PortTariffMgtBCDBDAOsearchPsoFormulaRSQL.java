/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchPsoFormulaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.03.19 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOsearchPsoFormulaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPsoFormula
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchPsoFormulaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foml_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchPsoFormulaRSQL").append("\n"); 
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
		query.append("MAX (DECODE (colpos, 1, dpval)) col1," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 2, dpval)) col2," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 3, dpval)) col3," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 4, dpval)) col4," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 5, dpval)) col5," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 6, dpval)) col6," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 7, dpval)) col7," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 8, dpval)) col8," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 9, dpval)) col9," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 10, dpval)) col10," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 11, dpval)) col11," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 12, dpval)) col12," ).append("\n"); 
		query.append("MAX (DECODE (colpos, 0, dpval)) col13" ).append("\n"); 
		query.append("FROM   (SELECT   CEIL (ROWNUM / 13) rwgrp, MOD (ROWNUM, 13) colpos, z.*" ).append("\n"); 
		query.append("FROM   (  SELECT   T2.*," ).append("\n"); 
		query.append("decode(T2.rt_obj_list_no, null, null , (select x.obj_list_nm from pso_obj_list x where x.obj_list_no = t2.rt_obj_list_no)||' ')" ).append("\n"); 
		query.append("||NVL (T3.OBJ_LIST_NM," ).append("\n"); 
		query.append("T2.PSO_FOML_OPR_CD || T2.foml_prt_ctnt || DECODE(T2.CONS_NM,'GREATEST','MAX',T2.CONS_NM) /*TOBE REMOVED*/)" ).append("\n"); 
		query.append("dpval," ).append("\n"); 
		query.append("NVL (T3.OBJ_LIST_NO || ''," ).append("\n"); 
		query.append("T2.PSO_FOML_OPR_CD || T2.foml_prt_ctnt)" ).append("\n"); 
		query.append("dpval2" ).append("\n"); 
		query.append("FROM   pso_formula T1, pso_foml_dtl T2, pso_obj_list T3" ).append("\n"); 
		query.append("--, (select rownum rn from dict where rownum <=6 ) T4" ).append("\n"); 
		query.append("WHERE       T1.foml_no = @[foml_no]" ).append("\n"); 
		query.append("--AND T1.UPD_MNU_NO IN (1, 2)  --jmh추가, 0은 제외" ).append("\n"); 
		query.append("AND T1.foml_no = T2.foml_no" ).append("\n"); 
		query.append("AND T2.OBJ_LIST_NO = T3.OBJ_LIST_NO(+)" ).append("\n"); 
		query.append("ORDER BY   T2.FOML_SEQ) z)" ).append("\n"); 
		query.append("GROUP BY   rwgrp" ).append("\n"); 
		query.append("ORDER BY   rwgrp" ).append("\n"); 

	}
}