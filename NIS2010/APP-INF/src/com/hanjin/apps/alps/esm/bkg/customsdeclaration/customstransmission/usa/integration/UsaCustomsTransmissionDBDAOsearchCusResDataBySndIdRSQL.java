/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCusResDataBySndIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.25
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2011.10.25 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCusResDataBySndIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수신 msg 의 ORG_FF_REF_NO로 관련 데이터 구한다.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCusResDataBySndIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_bat_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCusResDataBySndIdRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append("       ,SKD_VOY_NO" ).append("\n"); 
		query.append("       ,SKD_DIR_CD" ).append("\n"); 
		query.append("       ,POL_CD" ).append("\n"); 
		query.append("       ,POD_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_STWG_SND_LOG" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("    AND SND_PROC_ID = 'STW'" ).append("\n"); 
		query.append("    AND STWG_SND_ID LIKE NVL(TO_CHAR( TO_DATE(SUBSTR(@[crr_bat_no],4,6) ,'YYMMDD'), 'YYYYMMDD'), ' ')||'%'||NVL(SUBSTR(@[crr_bat_no],10), ' ')" ).append("\n"); 

	}
}