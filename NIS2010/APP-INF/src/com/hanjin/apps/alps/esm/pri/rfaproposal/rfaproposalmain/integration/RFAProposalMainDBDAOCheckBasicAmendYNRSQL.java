/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : RFAProposalMainDBDAOCheckBasicAmendYNRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.28 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOCheckBasicAmendYNRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic RFA를 Amend할 수 있는가 확인하기 위한 체크
	  * parnet Master RFA가 복사 후 Amend가 일어난 경우가 Y, 아닌 경우가 N
	  * </pre>
	  */
	public RFAProposalMainDBDAOCheckBasicAmendYNRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOCheckBasicAmendYNRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN MST_AMDT_SEQ < MAX_AMDT_SEQ" ).append("\n"); 
		query.append("            THEN 'Y' -- 복사한 MST보다 Mst Amd가 보다 클경우 Amend 가능" ).append("\n"); 
		query.append("            ELSE 'N' -- 작을 경우 불가능" ).append("\n"); 
		query.append("       END AS NEED_TO_AMEND " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    -- Copyed Master RFA" ).append("\n"); 
		query.append("    SELECT SUBSTR(A.MST_RFA_ROUT_ID, 0, 10) AS MST_RFA_NO, TO_NUMBER(SUBSTR(A.MST_RFA_ROUT_ID, 12, 3)) AS MST_AMDT_SEQ" ).append("\n"); 
		query.append("      FROM PRI_RP_SCP_RT A" ).append("\n"); 
		query.append("     WHERE PROP_NO = @[prop_no] -- Basic" ).append("\n"); 
		query.append("       AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("       AND ROWNUM = 1" ).append("\n"); 
		query.append("    ) A," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    -- Present Master RFA" ).append("\n"); 
		query.append("    SELECT MST_RFA_NO, MAX_AMDT_SEQ" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("	    SELECT (SELECT MST_RFA_NO FROM PRI_RP_HDR WHERE PROP_NO = @[prop_no]) AS MST_RFA_NO, -1 AS MAX_AMDT_SEQ" ).append("\n"); 
		query.append("	      FROM DUAL" ).append("\n"); 
		query.append("	     UNION ALL" ).append("\n"); 
		query.append("	    SELECT RFA_NO AS MST_RFA_NO, MAX(AMDT_SEQ) AS MAX_AMDT_SEQ" ).append("\n"); 
		query.append("	      FROM PRI_RP_HDR A, PRI_RP_MN B" ).append("\n"); 
		query.append("	     WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("	       AND RFA_NO = (SELECT MST_RFA_NO FROM PRI_RP_HDR WHERE PROP_NO = @[prop_no])" ).append("\n"); 
		query.append("	       AND PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("           AND EXP_DT >= TRUNC(SYSDATE) -- 유효한 RFA" ).append("\n"); 
		query.append("           -- AND EFF_DT >= TRUNC(SYSDATE) -- 기간 복사해도 Retro가 아닌 RFA , 20170728 정하나 과장님 요청으로 조건 제거" ).append("\n"); 
		query.append("	     GROUP BY RFA_NO" ).append("\n"); 
		query.append("         ORDER BY MAX_AMDT_SEQ DESC" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("     WHERE ROWNUM = 1" ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("  WHERE A.MST_RFA_NO = B.MST_RFA_NO" ).append("\n"); 

	}
}