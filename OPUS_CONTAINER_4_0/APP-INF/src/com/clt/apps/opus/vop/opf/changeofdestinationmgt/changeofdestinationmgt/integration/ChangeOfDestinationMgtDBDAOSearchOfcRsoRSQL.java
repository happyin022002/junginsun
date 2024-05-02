/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOSearchOfcRsoRSQL.java
*@FileTitle : Multi Trade Account Group
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.27
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.07.27 이행지
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOSearchOfcRsoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History-------------------------------------
	  * 2010.07.26 LHJ [Ticket-ID:CHM-201004935] COD application 조회 기능 추가 요청 및 에러 수정건
	  *                                                            - 로그인사용자의 소속오피스에 해당되는 RSO 찾기
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOSearchOfcRsoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOSearchOfcRsoRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN ML.CONTI_CD = 'A' THEN 'ASR'" ).append("\n"); 
		query.append("             WHEN ML.CONTI_CD = 'M' THEN 'AMR'" ).append("\n"); 
		query.append("             WHEN ML.CONTI_CD IN ('E','F') THEN 'EUR' " ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END  RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("FROM    COM_USER            MST" ).append("\n"); 
		query.append("    ,   MDM_ORGANIZATION    MO" ).append("\n"); 
		query.append("    ,   MDM_LOCATION        ML" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("  AND     MST.OFC_CD          = MO.OFC_CD" ).append("\n"); 
		query.append("  AND     MO.LOC_CD           = ML.LOC_CD" ).append("\n"); 
		query.append("  AND     MST.USR_ID          = @[usr_id]" ).append("\n"); 

	}
}