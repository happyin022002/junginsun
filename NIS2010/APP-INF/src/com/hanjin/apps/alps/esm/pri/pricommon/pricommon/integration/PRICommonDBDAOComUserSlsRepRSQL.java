/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PRICommonDBDAOComUserSlsRepRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.03.12 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOComUserSlsRepRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SREP CD 로 사용자정보 조회
	  * </pre>
	  */
	public PRICommonDBDAOComUserSlsRepRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOComUserSlsRepRSQL").append("\n"); 
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
		query.append("SELECT B.USR_ID" ).append("\n"); 
		query.append("     , B.USR_NM" ).append("\n"); 
		query.append("     , B.USR_PWD" ).append("\n"); 
		query.append("     , B.USE_FLG" ).append("\n"); 
		query.append("     , B.MPHN_NO" ).append("\n"); 
		query.append("     , B.USR_EML" ).append("\n"); 
		query.append("     , B.CNT_CD" ).append("\n"); 
		query.append("     , B.LANG_TP_CD" ).append("\n"); 
		query.append("     , B.GMT_TMZN_CD" ).append("\n"); 
		query.append("     , B.CNT_DT_FMT_CD" ).append("\n"); 
		query.append("     , B.CNT_NO_FMT_CD" ).append("\n"); 
		query.append("     , B.XTN_PHN_NO" ).append("\n"); 
		query.append("     , B.JB_ENG_NM" ).append("\n"); 
		query.append("     , B.PSN_ENG_NM" ).append("\n"); 
		query.append("     , B.GRD_ENG_NM" ).append("\n"); 
		query.append("     , B.FAX_NO" ).append("\n"); 
		query.append("     , B.OFC_CD" ).append("\n"); 
		query.append("     , A.SREP_CD" ).append("\n"); 
		query.append("     , B.USR_AUTH_TP_CD" ).append("\n"); 
		query.append("     , B.USR_LOCL_NM" ).append("\n"); 
		query.append("     , B.EP_ID" ).append("\n"); 
		query.append("     , B.CRE_USR_ID" ).append("\n"); 
		query.append("     , B.CRE_DT" ).append("\n"); 
		query.append("     , B.UPD_USR_ID" ).append("\n"); 
		query.append("     , B.UPD_DT" ).append("\n"); 
		query.append("     , B.LST_LGIN_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_SLS_REP A" ).append("\n"); 
		query.append("   , COM_USER B" ).append("\n"); 
		query.append("WHERE A.SREP_CD = @[srep_cd]" ).append("\n"); 
		query.append("AND   B.USR_ID = A.EMPE_CD" ).append("\n"); 

	}
}