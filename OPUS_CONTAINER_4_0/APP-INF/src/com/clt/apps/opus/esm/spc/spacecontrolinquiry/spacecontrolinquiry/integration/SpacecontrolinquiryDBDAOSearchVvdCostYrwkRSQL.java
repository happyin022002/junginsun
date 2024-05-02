/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSearchVvdCostYrwkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOSearchVvdCostYrwkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDR 실적 중 POL/POD 세부 Data 조회
	  * 2011.11.22 김종준 [CHM-201007116] Loading by POL/POD 화면 - 기능추가 개발
	  * 2011.12.08 김종준 AND IOC_CD='O'  VVD에 해당하는 주차 1개만 나오게 추가
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOSearchVvdCostYrwkRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSearchVvdCostYrwkRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(P.SLS_YRMON, 1, 4)||P.COST_WK COST_YRWK" ).append("\n"); 
		query.append("   FROM COA_MON_VVD P" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("   AND VSL_CD=SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO=SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND DIR_CD=SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("   AND DELT_FLG='N'" ).append("\n"); 
		query.append("   AND IOC_CD='O'" ).append("\n"); 
		query.append("   AND ROWNUM=1" ).append("\n"); 

	}
}