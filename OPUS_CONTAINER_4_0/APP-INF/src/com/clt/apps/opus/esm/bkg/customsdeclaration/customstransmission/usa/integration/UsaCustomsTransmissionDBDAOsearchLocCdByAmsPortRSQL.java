/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchLocCdByAmsPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.14
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.06.14 이영헌
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchLocCdByAmsPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신 outVO : UsaLocationVO
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchLocCdByAmsPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_ams_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchLocCdByAmsPortRSQL").append("\n"); 
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
		query.append("SELECT LOC_CD " ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	RTRIM(LOC_AMS_PORT_CD) = @[loc_ams_port_cd]" ).append("\n"); 
		query.append("	AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT SUBSTR(ATTR_CTNT1, 0,5) FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("WHERE CNT_cD='US'" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID='AMS_TML_CD_MAP'" ).append("\n"); 
		query.append("AND ATTR_CTNT2=@[loc_ams_port_cd]" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 

	}
}