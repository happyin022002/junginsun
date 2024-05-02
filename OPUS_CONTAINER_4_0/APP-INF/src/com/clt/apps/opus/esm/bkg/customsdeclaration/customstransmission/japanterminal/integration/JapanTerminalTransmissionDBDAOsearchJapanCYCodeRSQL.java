/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchJapanCYCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchJapanCYCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchJapanCYCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchJapanCYCodeRSQL").append("\n"); 
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
		query.append("SELECT ATTR_CTNT2 AS CY_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE CNT_CD = 'JP'" ).append("\n"); 
		query.append("  AND CSTMS_DIV_ID = 'JP_TEMINAL_CY_CD'" ).append("\n"); 
		query.append("  AND ATTR_CTNT1 = @[yd_cd]" ).append("\n"); 
		query.append("  AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CSTMS_DIV_ID_SEQ" ).append("\n"); 

	}
}