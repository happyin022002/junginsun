/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchTmlVslInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchTmlVslInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TmlVslInfoVO
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchTmlVslInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchTmlVslInfoRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(@[bl_type],'N','9','S','4','C','3') MSG_TYPE" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, 'CNYIT'),'YYYYMMDDHH24MI') SND_DT" ).append("\n"); 
		query.append(",SUBSTR(@[vvd],1,4)  VSL_CD" ).append("\n"); 
		query.append(",SUBSTR(@[vvd],5,4)  VSL_VOY" ).append("\n"); 
		query.append(",SUBSTR(@[vvd],9,1)  VSL_DIR" ).append("\n"); 
		query.append(",VSL.CALL_SGN_NO     CALL_SIGN" ).append("\n"); 
		query.append(",VSL.LLOYD_NO        IMO_NO" ).append("\n"); 
		query.append(",VSL.VSL_ENG_NM      VSL_FULL_NM" ).append("\n"); 
		query.append("FROM    MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("WHERE   VSL.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 

	}
}