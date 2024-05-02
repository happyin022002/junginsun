/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOPortCdValidChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOPortCdValidChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PORT CODE의 VALIDATION을 체크하고 RHQ_OFC_CD를 조회한다.
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOPortCdValidChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOPortCdValidChkRSQL").append("\n"); 
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
		query.append("SELECT ML.LOC_CD AS PORT_CD," ).append("\n"); 
		query.append("       CASE WHEN NVL(ML.DELT_FLG,'N') <> 'N' OR ML.CALL_PORT_FLG <> 'Y' THEN" ).append("\n"); 
		query.append("            ''" ).append("\n"); 
		query.append("       ELSE	CASE WHEN ML.VSKD_PORT_RHQ_CD IS NOT NULL THEN ML.VSKD_PORT_RHQ_CD" ).append("\n"); 
		query.append("                 ELSE (SELECT MAX(XX.AR_HD_QTR_OFC_CD) FROM MDM_ORGANIZATION XX WHERE XX.LOC_CD = ML.LOC_CD)" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("       END 	AS RHQ_OFC_CD" ).append("\n"); 
		query.append("FROM   MDM_LOCATION ML" ).append("\n"); 
		query.append("WHERE  ML.LOC_CD = @[port_cd]" ).append("\n"); 

	}
}