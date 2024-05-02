/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PanamaCustomsTransmissionDBDAOsearchVstNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.20
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.01.20 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM MINJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PanamaCustomsTransmissionDBDAOsearchVstNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVstNo
	  * </pre>
	  */
	public PanamaCustomsTransmissionDBDAOsearchVstNoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.integration").append("\n"); 
		query.append("FileName : PanamaCustomsTransmissionDBDAOsearchVstNoRSQL").append("\n"); 
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
		query.append("SELECT VST_NO" ).append("\n"); 
		query.append("      ,VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_PNM_SND_LOG" ).append("\n"); 
		query.append(" WHERE CRR_BAT_NO = @[crr_bat_no]" ).append("\n"); 

	}
}