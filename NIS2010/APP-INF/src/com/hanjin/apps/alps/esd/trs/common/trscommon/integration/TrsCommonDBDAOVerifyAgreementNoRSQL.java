/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TrsCommonDBDAOVerifyAgreementNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.trscommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsCommonDBDAOVerifyAgreementNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2014.02.10 김상근 [] Verify Agreement No
	  * </pre>
	  */
	public TrsCommonDBDAOVerifyAgreementNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amtNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.common.trscommon.integration").append("\n"); 
		query.append("FileName : TrsCommonDBDAOVerifyAgreementNoRSQL").append("\n"); 
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
		query.append("	DISTINCT TRSP_AGMT_OFC_CTY_CD||TRSP_AGMT_SEQ AS ERR_FLG" ).append("\n"); 
		query.append("FROM TRS_AGMT_APLY_VNDR" ).append("\n"); 
		query.append("WHERE TRSP_AGMT_OFC_CTY_CD = SUBSTR(@[amtNo],1,3) " ).append("\n"); 
		query.append("	AND TRSP_AGMT_SEQ = TO_NUMBER(SUBSTR(@[amtNo],4))" ).append("\n"); 
		query.append("	AND DELT_FLG = 'N'" ).append("\n"); 

	}
}