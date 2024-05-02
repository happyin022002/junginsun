/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchObjectListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.09.18 김진일
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

public class PortTariffMgtBCDBDAOsearchObjectListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchObjectList
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchObjectListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchObjectListRSQL").append("\n"); 
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
		query.append("SELECT   ROWNUM rn," ).append("\n"); 
		query.append("a.obj_list_no," ).append("\n"); 
		query.append("--(SELECT   z.intg_cd_val_dp_desc" ).append("\n"); 
		query.append("--   FROM   com_intg_cd_dtl z" ).append("\n"); 
		query.append("--  WHERE   z.intg_cd_id = 'CD01846'" ).append("\n"); 
		query.append("--          AND a.pso_obj_cd = z.intg_cd_val_ctnt)" ).append("\n"); 
		query.append("a.OBJ_LIST_ABBR_NM   pso_obj_cd_dsp,                                         --scalar" ).append("\n"); 
		query.append("a.pso_obj_cd," ).append("\n"); 
		query.append("a.obj_list_nm," ).append("\n"); 
		query.append("(SELECT   z.intg_cd_val_dp_desc" ).append("\n"); 
		query.append("FROM   com_intg_cd_dtl z" ).append("\n"); 
		query.append("WHERE   z.intg_cd_id = 'CD01848'" ).append("\n"); 
		query.append("AND a.pso_meas_ut_cd = z.intg_cd_val_ctnt)" ).append("\n"); 
		query.append("pso_meas_ut_cd_dsp,                             --scalar CD01848" ).append("\n"); 
		query.append("pso_meas_ut_cd," ).append("\n"); 
		query.append("@[pso_ofc_cd] pso_ofc_cd ," ).append("\n"); 
		query.append("'' cre_usr_id," ).append("\n"); 
		query.append("'' row_no," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT" ).append("\n"); 
		query.append("FROM   pso_obj_list a" ).append("\n"); 
		query.append("WHERE   NOT EXISTS (SELECT   1" ).append("\n"); 
		query.append("FROM   PSO_INV_OFC_OBJ_LIST c" ).append("\n"); 
		query.append("WHERE   a.obj_list_no = c.obj_list_no" ).append("\n"); 
		query.append("#if(${pso_ofc_cd} != '')" ).append("\n"); 
		query.append("and c.ofc_cd        = @[pso_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY   3, 5" ).append("\n"); 

	}
}