/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCProposalMainDBDAOChkFmcConfirmDtRSQL.java
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

public class SCProposalMainDBDAOChkFmcConfirmDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2014.06.02 전윤주 [CHM-201430580] s/c 자동 filing 기능 추가
	  * * 2014.07.25 송호진 [CHM-201430558] Filed Cancel 로 인해 Approval 이 된 시점에서는 
	  *                                                         별도의 추가 Confirm No 발생된 Send or C/T 없이 
	  *                                                         기존의 경우가 있으면 Save Button Enable 되도록 로직 보완
	  * </pre>
	  */
	public SCProposalMainDBDAOChkFmcConfirmDtRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOChkFmcConfirmDtRSQL").append("\n"); 
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
		query.append("WITH PROGRESS AS (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  A.PROP_NO, A.AMDT_SEQ, A.PROP_PROG_SEQ, A.PROP_STS_CD, A.PROG_DT, LAG ( A.PROP_STS_CD, 1 ) OVER ( PARTITION BY PROP_NO, AMDT_SEQ ORDER BY PROP_PROG_SEQ ) AS PRE_STS_CD" ).append("\n"); 
		query.append("FROM    PRI_SP_PROG A" ).append("\n"); 
		query.append("WHERE   A.PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("AND     A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("), MAX_APRO_PROG AS (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  B.PROP_NO, B.AMDT_SEQ, B.PROP_PROG_SEQ, B.PROP_STS_CD, B.PROG_DT, B.PRE_STS_CD" ).append("\n"); 
		query.append("FROM    PROGRESS B" ).append("\n"); 
		query.append("WHERE   B.PROP_PROG_SEQ = ( SELECT MAX ( PROP_PROG_SEQ ) FROM PRI_SP_PROG X WHERE X.PROP_NO = B.PROP_NO AND X.AMDT_SEQ = B.AMDT_SEQ AND X.PROP_STS_CD = 'A' )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  NVL ( SUM ( CASE WHEN A1.PRE_STS_CD = 'Q' THEN DECODE ( SIGN ( A2.FILE_PROG_DT - A1.PROG_DT ), 1, 1, 0 )" ).append("\n"); 
		query.append("                   WHEN A1.PRE_STS_CD <> 'Q' THEN DECODE ( A2.FILE_PROG_DT, NULL, 0, 1 ) " ).append("\n"); 
		query.append("                   END " ).append("\n"); 
		query.append("            ), 0  ) ETC1" ).append("\n"); 
		query.append("FROM    PRI_SP_FILE_PROG A2" ).append("\n"); 
		query.append("    ,   MAX_APRO_PROG A1" ).append("\n"); 
		query.append("WHERE   A1.PROP_NO = A2.PROP_NO" ).append("\n"); 
		query.append("AND     A1.AMDT_SEQ = A2.AMDT_SEQ" ).append("\n"); 

	}
}