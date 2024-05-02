/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSendMailAddrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2011.06.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOSendMailAddrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.06.15 김종준 [CHM-201110708-01]  F"cast 입력 요청 메세지 송부시 오피스별 멜주소 가져오기
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOSendMailAddrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slsOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSendMailAddrListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("	   U.USR_ID," ).append("\n"); 
		query.append("       U.USR_NM, " ).append("\n"); 
		query.append("	   U.USR_EML," ).append("\n"); 
		query.append("       U.OFC_CD" ).append("\n"); 
		query.append("FROM COM_PGM_ROLE P, COM_USR_ROLE_MTCH R, COM_USER U" ).append("\n"); 
		query.append("WHERE P.PGM_NO = 'ESM_SPC_0102'" ).append("\n"); 
		query.append("AND P.USR_ROLE_CD = R.USR_ROLE_CD" ).append("\n"); 
		query.append("AND R.USR_ID = U.USR_ID" ).append("\n"); 
		query.append("AND nvl(U.USE_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("AND USR_EML IS NOT NULL" ).append("\n"); 
		query.append("AND U.OFC_CD = @[slsOfcCd]" ).append("\n"); 

	}
}