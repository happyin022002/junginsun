/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchObjectListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
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
		query.append("SELECT ROWNUM RN" ).append("\n"); 
		query.append("     , OBJ_LIST_NO" ).append("\n"); 
		query.append("     , PSO_OBJ_CD" ).append("\n"); 
		query.append("     , PSO_OBJ_CD_DSP" ).append("\n"); 
		query.append("     , OBJ_LIST_NM" ).append("\n"); 
		query.append("     , PSO_MEAS_UT_CD_DSP" ).append("\n"); 
		query.append("     , PSO_MEAS_UT_CD" ).append("\n"); 
		query.append("     , PSO_OFC_CD" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("  FROM (SELECT A.OBJ_LIST_NO" ).append("\n"); 
		query.append("             , A.PSO_OBJ_CD" ).append("\n"); 
		query.append("             , A.OBJ_LIST_ABBR_NM PSO_OBJ_CD_DSP" ).append("\n"); 
		query.append("             , A.OBJ_LIST_NM" ).append("\n"); 
		query.append("             , (SELECT Z.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                  FROM COM_INTG_CD_DTL Z" ).append("\n"); 
		query.append("                 WHERE Z.INTG_CD_ID = 'CD01848'" ).append("\n"); 
		query.append("                   AND A.PSO_MEAS_UT_CD = Z.INTG_CD_VAL_CTNT) PSO_MEAS_UT_CD_DSP" ).append("\n"); 
		query.append("             , PSO_MEAS_UT_CD" ).append("\n"); 
		query.append("             , @[pso_ofc_cd] PSO_OFC_CD" ).append("\n"); 
		query.append("             , CRE_USR_ID" ).append("\n"); 
		query.append("             , CRE_DT" ).append("\n"); 
		query.append("          FROM PSO_OBJ_LIST A" ).append("\n"); 
		query.append("         WHERE NOT EXISTS (SELECT 1" ).append("\n"); 
		query.append("                             FROM PSO_INV_OFC_OBJ_LIST C" ).append("\n"); 
		query.append("                            WHERE A.OBJ_LIST_NO = C.OBJ_LIST_NO" ).append("\n"); 
		query.append("#if(${pso_ofc_cd} != '')" ).append("\n"); 
		query.append("                              AND C.OFC_CD = @[pso_ofc_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("           --AND OBJ_LIST_NO NOT IN ('45') --Rate 제거 /*2015.12.09 주석처리함.*/" ).append("\n"); 
		query.append("         ORDER BY 3, 5" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}