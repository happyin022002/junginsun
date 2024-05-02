/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSearchControlOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOSearchControlOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSearchControlOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vskd_port_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSearchControlOfficeListRSQL").append("\n"); 
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
		query.append("--SELECT  DISTINCT VOP_PORT_CTRL_OFC_CD" ).append("\n"); 
		query.append("--FROM    MDM_LOCATION" ).append("\n"); 
		query.append("--WHERE   VOP_PORT_CTRL_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("--AND     DELT_FLG        = 'N'" ).append("\n"); 
		query.append("--if ({vskd_port_rhq_cd} != 'ALL' && {vskd_port_rhq_cd} != '')" ).append("\n"); 
		query.append("--AND     VSKD_PORT_RHQ_CD = [vskd_port_rhq_cd]" ).append("\n"); 
		query.append("--end" ).append("\n"); 
		query.append("--ORDER BY VOP_PORT_CTRL_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT     DISTINCT" ).append("\n"); 
		query.append("           NVL(X.VOP_PORT_CTRL_OFC_CD,X.SLS_OFC_CD) AS VOP_PORT_CTRL_OFC_CD" ).append("\n"); 
		query.append("FROM       MDM_LOCATION           X" ).append("\n"); 
		query.append("        ,  MDM_ORGANIZATION       Y" ).append("\n"); 
		query.append("WHERE      1 = 1" ).append("\n"); 
		query.append("AND        X.LOC_CD               = Y.LOC_CD" ).append("\n"); 
		query.append("AND        X.DELT_FLG             = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vskd_port_rhq_cd} != 'ALL' && ${vskd_port_rhq_cd} != '')" ).append("\n"); 
		query.append("AND        @[vskd_port_rhq_cd]    = CASE WHEN X.VSKD_PORT_RHQ_CD IS NOT NULL THEN X.VSKD_PORT_RHQ_CD" ).append("\n"); 
		query.append("                                         ELSE Y.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                    END" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY   NVL(X.VOP_PORT_CTRL_OFC_CD,X.SLS_OFC_CD) ASC" ).append("\n"); 

	}
}