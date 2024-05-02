/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PrdCommonManageDBDAOSearchCntOfContiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.02
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2011.09.02 박만건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ParkMangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCommonManageDBDAOSearchCntOfContiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.06.16 변종건 [CHM-201111584-01] Inland Route Management상의 입력국가 추가 요청.
	  * </pre>
	  */
	public PrdCommonManageDBDAOSearchCntOfContiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcommon.integration").append("\n"); 
		query.append("FileName : PrdCommonManageDBDAOSearchCntOfContiRSQL").append("\n"); 
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
		query.append("SELECT  MCNT.CNT_CD" ).append("\n"); 
		query.append("FROM    MDM_SUBCONTINENT CONT" ).append("\n"); 
		query.append("      , MDM_COUNTRY MCNT" ).append("\n"); 
		query.append("WHERE   CONT.CONTI_CD = @[conti_cd]" ).append("\n"); 
		query.append("AND     MCNT.SCONTI_CD(+) = CONT.SCONTI_CD" ).append("\n"); 

	}
}