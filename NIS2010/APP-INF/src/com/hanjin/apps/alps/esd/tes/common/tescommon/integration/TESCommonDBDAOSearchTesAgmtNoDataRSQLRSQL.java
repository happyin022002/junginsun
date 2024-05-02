/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TESCommonDBDAOSearchTesAgmtNoDataRSQLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOSearchTesAgmtNoDataRSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement No validation check
	  * </pre>
	  */
	public TESCommonDBDAOSearchTesAgmtNoDataRSQLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration ").append("\n"); 
		query.append("FileName : TESCommonDBDAOSearchTesAgmtNoDataRSQLRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT TML_AGMT_OFC_CTY_CD || LPAD(TML_AGMT_SEQ, 5, '0' ) AS AGMT_NO" ).append("\n"); 
		query.append("FROM TES_TML_AGMT_HDR" ).append("\n"); 
		query.append("WHERE TML_AGMT_OFC_CTY_CD  = SUBSTR(@[agmt_no], 1, 3)" ).append("\n"); 
		query.append("AND   TML_AGMT_SEQ         = TO_NUMBER(SUBSTR(@[agmt_no], 4))" ).append("\n"); 
		query.append("AND   DELT_FLG         = 'N'" ).append("\n"); 

	}
}