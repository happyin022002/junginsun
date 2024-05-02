/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCGExternalFinderDBDAOSearchOfcRsoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGExternalFinderDBDAOSearchOfcRsoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.04.09 [Ticket-ID:CHM-201109927-01] User 별 소속 Office 의 RSO 가져와 표시 하기
	  * </pre>
	  */
	public SCGExternalFinderDBDAOSearchOfcRsoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.integration").append("\n"); 
		query.append("FileName : SCGExternalFinderDBDAOSearchOfcRsoRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN ML.CONTI_CD = 'A' THEN 'ASR'" ).append("\n"); 
		query.append("             WHEN ML.CONTI_CD = 'M' THEN 'AMR'" ).append("\n"); 
		query.append("             WHEN ML.CONTI_CD IN ('E','F') THEN 'EUR' " ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END  RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("FROM    COM_USER            MST" ).append("\n"); 
		query.append("    ,   MDM_ORGANIZATION    MO" ).append("\n"); 
		query.append("    ,   MDM_LOCATION        ML" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("  AND     MST.OFC_CD          = MO.OFC_CD" ).append("\n"); 
		query.append("  AND     MO.LOC_CD           = ML.LOC_CD" ).append("\n"); 
		query.append("  AND     MST.USR_ID          = @[usr_id]" ).append("\n"); 

	}
}