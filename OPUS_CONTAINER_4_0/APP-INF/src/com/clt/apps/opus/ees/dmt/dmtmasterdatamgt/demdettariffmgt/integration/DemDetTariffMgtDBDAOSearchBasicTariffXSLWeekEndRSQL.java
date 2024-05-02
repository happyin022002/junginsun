/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchBasicTariffXSLWeekEndRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2010.01.05 문중철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mun Jung Cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOSearchBasicTariffXSLWeekEndRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 111
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchBasicTariffXSLWeekEndRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration ").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchBasicTariffXSLWeekEndRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN WKND_TP_CD = 'TF' THEN 'THU'" ).append("\n"); 
		query.append("WHEN WKND_TP_CD = 'FS' THEN 'FRI'" ).append("\n"); 
		query.append("ELSE 'SAT' END WKND1" ).append("\n"); 
		query.append(",CASE WHEN WKND_TP_CD = 'TF' THEN 'FRI'" ).append("\n"); 
		query.append("WHEN WKND_TP_CD = 'FS' THEN 'SAT'" ).append("\n"); 
		query.append("ELSE 'SAT' END WKND2" ).append("\n"); 
		query.append("FROM DMT_WEEKEND" ).append("\n"); 
		query.append("WHERE CNT_CD = @[cnt_cd]" ).append("\n"); 

	}
}