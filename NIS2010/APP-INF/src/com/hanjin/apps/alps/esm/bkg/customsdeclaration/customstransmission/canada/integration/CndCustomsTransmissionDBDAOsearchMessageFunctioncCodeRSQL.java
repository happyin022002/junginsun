/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchMessageFunctioncCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchMessageFunctioncCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CndCustomsTransmissionDBDAOsearchMessageFunctioncCodeRSQL
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchMessageFunctioncCodeRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchMessageFunctioncCodeRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("      /* 9 ORIGINAL, 4 CHANGE */" ).append("\n"); 
		query.append("      DECODE(MAX(SND_PROC_ID),NULL,'9','4') AS MSG_FUNC" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_STWG_SND_LOG L1" ).append("\n"); 
		query.append("WHERE L1.SND_PROC_ID LIKE 'STW_CA%'" ).append("\n"); 
		query.append("  AND L1.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("  AND L1.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("  AND L1.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("  AND L1.RCV_DT     IS NOT NULL " ).append("\n"); 

	}
}