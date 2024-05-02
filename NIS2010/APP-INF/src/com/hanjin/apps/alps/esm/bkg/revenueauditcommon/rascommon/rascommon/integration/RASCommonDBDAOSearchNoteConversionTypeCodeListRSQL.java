/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RASCommonDBDAOSearchNoteConversionTypeCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RASCommonDBDAOSearchNoteConversionTypeCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Note Conversion Type List 를 조회합니다.
	  * </pre>
	  */
	public RASCommonDBDAOSearchNoteConversionTypeCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.integration ").append("\n"); 
		query.append("FileName : RASCommonDBDAOSearchNoteConversionTypeCodeListRSQL").append("\n"); 
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
		query.append("SELECT NOTE_CONV_TP_CD AS CD," ).append("\n"); 
		query.append("       NOTE_CONV_TP_NM AS NM," ).append("\n"); 
		query.append("       '' AS ETC1," ).append("\n"); 
		query.append("       '' AS ETC2," ).append("\n"); 
		query.append("       '' AS ETC3," ).append("\n"); 
		query.append("       '' AS ETC4," ).append("\n"); 
		query.append("       (NOTE_CONV_TP_CD || '|' || NOTE_CONV_TP_NM) AS ETC5" ).append("\n"); 
		query.append("FROM PRI_NOTE_CONV_TP" ).append("\n"); 
		query.append("WHERE PRC_CTRT_TP_CD = 'S'" ).append("\n"); 
		query.append("AND NOTE_CONV_TP_CD <> 'T'" ).append("\n"); 

	}
}