/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlRatingDBDAOSearchApprovalRequestMailBodyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.06
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchApprovalRequestMailBodyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Approval Request 메일 내용을 조회합니다.(HTML형식으로 조회됨)
	  * !!!! 주의 !!!!!
	  * SQL 수정 후 반드시 java 파일 확인할것!
	  * "  는 \" 으로 변경되어야 정상적으로 SQL이 실행됩니다!!!!
	  * </pre>
	  */
	public BlRatingDBDAOSearchApprovalRequestMailBodyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchApprovalRequestMailBodyRSQL").append("\n"); 
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
		query.append("'<html>" ).append("\n"); 
		query.append("<head>" ).append("\n"); 
		query.append("<title></title>" ).append("\n"); 
		query.append("</head>" ).append("\n"); 
		query.append("'" ).append("\n"); 
		query.append("||" ).append("\n"); 
		query.append("#if (${mail_type} == 'Q') " ).append("\n"); 
		query.append("@[chg_cd]||' Charges for '||B.BKG_NO||' needs to be exempted as below reason.<br>" ).append("\n"); 
		query.append("Please, review and approve if reasonable.<p>'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${mail_type} == 'A')" ).append("\n"); 
		query.append("'Your request for '||@[chg_cd]||' exemption has been approved and '||@[chg_cd]||' deleted from ('||B.BKG_NO||') <p>'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${mail_type} == 'R')" ).append("\n"); 
		query.append("'Your request for '||@[chg_cd]||' exemption has been rejected. So '||@[chg_cd]||' will not be deleted from ('||B.BKG_NO||') <p>'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("||" ).append("\n"); 
		query.append("'Requestor : '||U.USR_NM ||' / '||U.OFC_CD||'<br>" ).append("\n"); 
		query.append("BKG No : '||B.BKG_NO||'<br>" ).append("\n"); 
		query.append("Shipper : '||S.CUST_CNT_CD||LPAD(S.CUST_SEQ,6,'0')||' '||MS.CUST_LGL_ENG_NM||'<br>" ).append("\n"); 
		query.append("Consignee : '||C.CUST_CNT_CD||LPAD(C.CUST_SEQ,6,'0')||' '||MC.CUST_LGL_ENG_NM||'<br>" ).append("\n"); 
		query.append("Contract No : '|| DECODE(R.BKG_CTRT_TP_CD,'S',B.SC_NO,'R',B.RFA_NO,'T',B.TAA_NO)||'<br>" ).append("\n"); 
		query.append("C.Rep : '||B.CTRT_SREP_CD||' '||CR.OFC_CD||' / '||CR.SREP_NM||'<br>" ).append("\n"); 
		query.append("L.Rep : '||B.OB_SREP_CD||' '||LR.OFC_CD||' / '||LR.SREP_NM||'<p>" ).append("\n"); 
		query.append("Exemption Reason : '||V.INTG_CD_VAL_DESC||'<p>" ).append("\n"); 
		query.append("Amend Amount<br>" ).append("\n"); 
		query.append("<table border=\"1\" cellspacing=\"0\">" ).append("\n"); 
		query.append("	<tr>" ).append("\n"); 
		query.append("		<td width=\"50\" align=\"center\">Charge</td>" ).append("\n"); 
		query.append("		<td width=\"50\" align=\"center\">Cur</td>" ).append("\n"); 
		query.append("		<td width=\"50\" align=\"center\">Per </td>" ).append("\n"); 
		query.append("		<td width=\"130\" align=\"center\">As-Is Amount</td>" ).append("\n"); 
		query.append("		<td width=\"130\" align=\"center\">To-Be Amount</td>" ).append("\n"); 
		query.append("		<td width=\"130\" align=\"center\">Diff</td>" ).append("\n"); 
		query.append("	</tr>" ).append("\n"); 
		query.append("' MAIL_BODY" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, BKG_RATE R," ).append("\n"); 
		query.append("     BKG_CHG_AMD_AUTH A, COM_INTG_CD_DTL V, " ).append("\n"); 
		query.append("     COM_USER U," ).append("\n"); 
		query.append("     BKG_CUSTOMER S, BKG_CUSTOMER C," ).append("\n"); 
		query.append("     MDM_CUSTOMER MS, MDM_CUSTOMER MC," ).append("\n"); 
		query.append("     MDM_SLS_REP CR, MDM_SLS_REP LR" ).append("\n"); 
		query.append("WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND A.CHG_AMD_SEQ = (SELECT MAX(CHG_AMD_SEQ) " ).append("\n"); 
		query.append("                     FROM BKG_CHG_AMD_AUTH " ).append("\n"); 
		query.append("                     WHERE BKG_NO = B.BKG_NO)" ).append("\n"); 
		query.append("AND V.INTG_CD_ID = 'CD03364'" ).append("\n"); 
		query.append("AND A.CHG_AMD_RSN_CD = V.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND A.RQST_USR_ID = U.USR_ID" ).append("\n"); 
		query.append("AND B.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("AND S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND B.BKG_NO = C.BKG_NO " ).append("\n"); 
		query.append("AND C.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("AND S.CUST_CNT_CD = MS.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND S.CUST_SEQ = MS.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND C.CUST_CNT_CD = MC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND C.CUST_SEQ = MC.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND B.CTRT_SREP_CD = CR.SREP_CD" ).append("\n"); 
		query.append("AND B.OB_SREP_CD = LR.SREP_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("(SELECT '" ).append("\n"); 
		query.append("    <tr>" ).append("\n"); 
		query.append("        <td align=\"center\">'||D.CHG_CD||'</td>" ).append("\n"); 
		query.append("        <td align=\"center\">'||D.CURR_CD||'</td>" ).append("\n"); 
		query.append("        <td align=\"center\">'||D.RAT_UT_CD||'</td>" ).append("\n"); 
		query.append("        <td align=\"right\">'||TRIM(TO_CHAR(D.CRNT_CHG_AMT,'999,999,999.99'))||'</td>" ).append("\n"); 
		query.append("        <td align=\"right\">'||TRIM(TO_CHAR(D.AMD_CHG_AMT,'999,999,999.99'))||'</td>" ).append("\n"); 
		query.append("        <td align=\"right\">'||TRIM(TO_CHAR(D.DIFF_CHG_AMT,'999,999,999.99'))||'</td>" ).append("\n"); 
		query.append("    </tr>' MAIL_BODY" ).append("\n"); 
		query.append("FROM BKG_CHG_AMD_AUTH_DTL D" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND D.CHG_AMD_SEQ = (SELECT MAX(CHG_AMD_SEQ) " ).append("\n"); 
		query.append("                     FROM BKG_CHG_AMD_AUTH " ).append("\n"); 
		query.append("                     WHERE BKG_NO = D.BKG_NO))" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'</table><p>" ).append("\n"); 
		query.append("Remarks : '||A.CHG_AMD_RMK||'" ).append("\n"); 
		query.append("</html>' MAIL_BODY" ).append("\n"); 
		query.append("FROM BKG_CHG_AMD_AUTH A" ).append("\n"); 
		query.append("WHERE a.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A.CHG_AMD_SEQ = (SELECT MAX(CHG_AMD_SEQ) " ).append("\n"); 
		query.append("                     FROM BKG_CHG_AMD_AUTH " ).append("\n"); 
		query.append("                     WHERE BKG_NO = A.BKG_NO)" ).append("\n"); 

	}
}