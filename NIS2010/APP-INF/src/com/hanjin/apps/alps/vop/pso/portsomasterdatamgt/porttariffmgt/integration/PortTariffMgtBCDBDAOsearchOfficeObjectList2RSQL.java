/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchOfficeObjectList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.06.05 박명종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author myoungjong park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOsearchOfficeObjectList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * object 조회
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchOfficeObjectList2RSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_obj_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  pso_obj_cd," ).append("\n"); 
		query.append("obj_list_nm," ).append("\n"); 
		query.append("obj_list_no," ).append("\n"); 
		query.append("intg_cd_val_dp_desc pso_meas_ut_cd" ).append("\n"); 
		query.append("FROM    pso_obj_list  t2, com_intg_cd_dtl t1" ).append("\n"); 
		query.append("WHERE   t2.pso_meas_ut_cd = t1.intg_cd_val_ctnt" ).append("\n"); 
		query.append("and    t1.intg_cd_id = 'CD01848'" ).append("\n"); 
		query.append("#if( ${pso_obj_cd}!='')" ).append("\n"); 
		query.append("AND pso_obj_cd = @[pso_obj_cd]--'BEM'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchOfficeObjectList2RSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}