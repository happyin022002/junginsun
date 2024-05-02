/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCProposalMainDBDAORsltExpChkVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.13
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.09.13 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHojin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltExpChkVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * main,scope의 exp_dt보다 filing date가 같거나 큰 데이터를 조회한다.
	  * * 2014.05.29 전윤주 [CHM-201430580] Filing 자동화 기능이 추가되어 비교하는 filing date 날짜 컬럼 변경
	  * * 2014.09.13 송호진 [CHM-201430558] 반영 포함 Check Out
	  * </pre>
	  */
	public SCProposalMainDBDAORsltExpChkVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("us_est_sys_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltExpChkVORSQL").append("\n"); 
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
		query.append("SELECT 'MAIN' SVC_SCP_CD" ).append("\n"); 
		query.append("      ,TO_CHAR (CTRT_EFF_DT, 'YYYY-MM-DD') CTRT_EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (CTRT_EXP_DT, 'YYYY-MM-DD') CTRT_EXP_DT" ).append("\n"); 
		query.append("	  ,1 CNT" ).append("\n"); 
		query.append("FROM   PRI_SP_DUR" ).append("\n"); 
		query.append("WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND    TO_CHAR (CTRT_EXP_DT, 'YYYYMMDD') < @[us_est_sys_dt]" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 

	}
}