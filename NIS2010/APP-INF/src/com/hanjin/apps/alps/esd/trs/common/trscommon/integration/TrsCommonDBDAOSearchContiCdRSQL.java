/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TrsCommonDBDAOSearchContiCdRSQL.java
*@FileTitle : SearchContiCd
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.10
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011.02.10 민정호
* 1.0 Creation
* 1.0 2011.02.10 민정호 [CHM-201108602] [TRS]미주지역 Appt./Deli. time update 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.trscommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsCommonDBDAOSearchContiCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TrsCommonDBDAOSearchContiCd
	  * </pre>
	  */
	public TrsCommonDBDAOSearchContiCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.common.trscommon.integration").append("\n"); 
		query.append("FileName : TrsCommonDBDAOSearchContiCdRSQL").append("\n"); 
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
		query.append("SELECT	DECODE(C.CNT_CD, 'HQ', 'KR', C.CNT_CD) CNT_CD /* COUNTRY CODE */" ).append("\n"); 
		query.append("FROM	MDM_ORGANIZATION B," ).append("\n"); 
		query.append("MDM_LOCATION C" ).append("\n"); 
		query.append("WHERE	B.OFC_CD = @[OFC_CD]" ).append("\n"); 
		query.append("AND B.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 

	}
}