/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchWeekEndRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.06.23 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOSearchWeekEndRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DMT_WEEKEND - Country
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchWeekEndRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration ").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchWeekEndRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}