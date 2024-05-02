/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PRICommonDBDAOSearchDurationDateForRateCopyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.08
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2013.01.08 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOSearchDurationDateForRateCopyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Proposal Copy후 Duration 저장시.. 원본 RFA Duration 이전의 날짜 체크
	  * </pre>
	  */
	public PRICommonDBDAOSearchDurationDateForRateCopyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOSearchDurationDateForRateCopyRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(MN.CTRT_EFF_DT, 'YYYY-MM-DD') ETC1," ).append("\n"); 
		query.append("       TO_CHAR(MN.CTRT_EXP_DT, 'YYYY-MM-DD') ETC2" ).append("\n"); 
		query.append("  FROM PRI_RP_HDR HDR, PRI_RP_DUR MN" ).append("\n"); 
		query.append(" WHERE HDR.ORG_PROP_NO = MN.PROP_NO(+)" ).append("\n"); 
		query.append("   AND HDR.ORG_AMDT_SEQ = MN.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND HDR.PROP_NO = @[prop_no]" ).append("\n"); 

	}
}