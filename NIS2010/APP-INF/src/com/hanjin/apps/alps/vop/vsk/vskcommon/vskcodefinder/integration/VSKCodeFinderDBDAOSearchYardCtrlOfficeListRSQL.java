/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSearchYardCtrlOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOSearchYardCtrlOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQ 산하의 Yard Control Office List 를 조회한다.
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSearchYardCtrlOfficeListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSearchYardCtrlOfficeListRSQL").append("\n"); 
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
		query.append("SELECT 	VOP_PORT_CTRL_OFC_CD" ).append("\n"); 
		query.append("FROM 	(" ).append("\n"); 
		query.append("        SELECT		DISTINCT" ).append("\n"); 
		query.append("                  	OFC_CD AS VOP_PORT_CTRL_OFC_CD" ).append("\n"); 
		query.append("               ,  	(" ).append("\n"); 
		query.append("                    SELECT   DISTINCT" ).append("\n"); 
		query.append("                             X.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                    FROM     MDM_ORGANIZATION X" ).append("\n"); 
		query.append("                    WHERE    1 = 1" ).append("\n"); 
		query.append("                    AND      X.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("                    AND      X.OFC_CD       = Y.OFC_CD" ).append("\n"); 
		query.append("                  	) RHQ_CD" ).append("\n"); 
		query.append("        FROM 		MDM_YARD 				Y" ).append("\n"); 
		query.append("		WHERE 		1 = 1" ).append("\n"); 
		query.append("		AND 		Y.DELT_FLG 				= 'N'" ).append("\n"); 
		query.append("		AND 		Y.OFC_CD 				IS NOT NULL" ).append("\n"); 
		query.append("       ) XX" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${vskd_port_rhq_cd} != 'ALL' && ${vskd_port_rhq_cd} != '')" ).append("\n"); 
		query.append("AND     XX.RHQ_CD 	= @[vskd_port_rhq_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("ORDER BY XX.VOP_PORT_CTRL_OFC_CD" ).append("\n"); 

	}
}