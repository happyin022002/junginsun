/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchLocalCurrencyByPortCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.09.29 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOSearchLocalCurrencyByPortCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PORT_CD를 입력받아 지역통화를 구한다. <단건조회>
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchLocalCurrencyByPortCdRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration ").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchLocalCurrencyByPortCdRSQL").append("\n"); 
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
		query.append("SELECT NVL(A.CURR_CD, B.AR_CURR_CD) CURRENCY" ).append("\n"); 
		query.append("FROM   MDM_CURRENCY     A" ).append("\n"); 
		query.append(",MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE  A.CNT_CD(+) = SUBSTR(B.LOC_CD, 1, 2)" ).append("\n"); 
		query.append("AND    B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 
		query.append("AND    B.LOC_CD = @[port_cd]" ).append("\n"); 

	}
}