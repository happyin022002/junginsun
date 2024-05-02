/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OnhireApprovalDBDAOsearchOnhireApprovalNumberRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireApprovalDBDAOsearchOnhireApprovalNumberRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LSE_ONH_APRO를 조회한다.
	  *  Ref No. 추가
	  * </pre>
	  */
	public OnhireApprovalDBDAOsearchOnhireApprovalNumberRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_eddt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_stdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_onh_auth_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration").append("\n"); 
		query.append("FileName : OnhireApprovalDBDAOsearchOnhireApprovalNumberRSQL").append("\n"); 
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
		query.append("  SLST.AGMT_NO," ).append("\n"); 
		query.append("  SLST.AUTH_NO," ).append("\n"); 
		query.append("  SLST.LOC_CD," ).append("\n"); 
		query.append("  SLST.REF_NO," ).append("\n"); 
		query.append("  SLST.LSTM_CD," ).append("\n"); 
		query.append("  SLST.LESSOR," ).append("\n"); 
		query.append("  SLST.M_YEAR," ).append("\n"); 
		query.append("  SLST.FREE_DAY," ).append("\n"); 
		query.append("  SLST.P_UP_CHARGE ," ).append("\n"); 
		query.append("  SLST.P_UP_CREDIT ," ).append("\n"); 
		query.append("  SLST.MIN_ONH_DAYS ," ).append("\n"); 
		query.append("  SLST.DPP ," ).append("\n"); 
		query.append("  SLST.DPP_FREE_DAY ," ).append("\n"); 
		query.append("  SLST.APRO_RMK ,  " ).append("\n"); 
		query.append("  LTRIM(TO_CHAR((" ).append("\n"); 
		query.append("              #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("                 #set ($col_name= $key+'_OLD') " ).append("\n"); 
		query.append("                 #if($velocityCount < $tysz.size())                 " ).append("\n"); 
		query.append("                    $col_name +" ).append("\n"); 
		query.append("                 #else" ).append("\n"); 
		query.append("                    $col_name" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("                 ),'999,999,999,990')) DIV_TOTAL_OLD ,  " ).append("\n"); 
		query.append("  LTRIM(TO_CHAR((" ).append("\n"); 
		query.append("              #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("                 #set ($col_name= $key+'_NEW')" ).append("\n"); 
		query.append("                 #if($velocityCount < $tysz.size())                 " ).append("\n"); 
		query.append("                    $col_name +" ).append("\n"); 
		query.append("                 #else" ).append("\n"); 
		query.append("                    $col_name" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("                ),'999,999,999,990')) DIV_TOTAL_NEW ," ).append("\n"); 
		query.append(" #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("      #set ($col_name1= $key+'_OLD')" ).append("\n"); 
		query.append("      #set ($col_name2= $key+'_NEW')" ).append("\n"); 
		query.append("      #set ($col_name3= $key+'_LON')" ).append("\n"); 
		query.append("      LTRIM(TO_CHAR(SLST.$col_name1 ,'999,990')) $col_name1 ," ).append("\n"); 
		query.append("      LTRIM(TO_CHAR(SLST.$col_name2 ,'999,990')) $col_name2 ," ).append("\n"); 
		query.append("      LTRIM(TO_CHAR(SLST.$col_name3 ,'999,990')) $col_name3 ," ).append("\n"); 
		query.append(" #end      " ).append("\n"); 
		query.append("      TO_CHAR(SLST.PKUP_FM_DT, 'yyyy-mm-dd') PKUP_FM_DT  ," ).append("\n"); 
		query.append("      TO_CHAR(SLST.PKUP_DUE_DT, 'yyyy-mm-dd') PKUP_DUE_DT  ," ).append("\n"); 
		query.append("	  TO_CHAR(SLST.PKUP_FM_DT, 'yyyy-mm-dd')||' ~ '||TO_CHAR(SLST.PKUP_DUE_DT, 'yyyy-mm-dd') AS AUTH_PERIOD ,	" ).append("\n"); 
		query.append("      SLST.RETURN_LCC " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("      Z.AGMT_NO AGMT_NO ," ).append("\n"); 
		query.append("      Z.AUTH_NO AUTH_NO," ).append("\n"); 
		query.append("      Z.LOC_CD LOC_CD," ).append("\n"); 
		query.append("      Z.REF_NO  AS REF_NO," ).append("\n"); 
		query.append("      Z.LSTM_CD LSTM_CD," ).append("\n"); 
		query.append("      Z.LESSOR LESSOR ," ).append("\n"); 
		query.append("      Z.M_YEAR M_YEAR ," ).append("\n"); 
		query.append("      Z.FREE_DAY FREE_DAY ," ).append("\n"); 
		query.append("      Z.P_UP_CHARGE P_UP_CHARGE ," ).append("\n"); 
		query.append("      Z.P_UP_CREDIT P_UP_CREDIT ," ).append("\n"); 
		query.append("      Z.MIN_ONH_DAYS MIN_ONH_DAYS ," ).append("\n"); 
		query.append("      Z.DPP DPP ," ).append("\n"); 
		query.append("      Z.DPP_FREE_DAY DPP_FREE_DAY ," ).append("\n"); 
		query.append("      Z.APRO_RMK APRO_RMK ," ).append("\n"); 
		query.append(" #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("      #set ($col_name1= $key+'_OLD')" ).append("\n"); 
		query.append("      #set ($col_name2= $key+'_NEW')" ).append("\n"); 
		query.append("      #set ($col_name3= $key+'_LON')" ).append("\n"); 
		query.append("      SUM(DECODE(Z.TPSZ, '$key', OLD_VAN, 0)) $col_name1 ," ).append("\n"); 
		query.append("      SUM(DECODE(Z.TPSZ, '$key', NEW_VAN, 0)) $col_name2 ," ).append("\n"); 
		query.append("      SUM(DECODE(Z.TPSZ, '$key', L_ON,    0)) $col_name3 ," ).append("\n"); 
		query.append(" #end          " ).append("\n"); 
		query.append("      Z.PKUP_FM_DT PKUP_FM_DT," ).append("\n"); 
		query.append("      Z.PKUP_DUE_DT PKUP_DUE_DT," ).append("\n"); 
		query.append("      Z.RETURN_LCC RETURN_LCC " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("          A.AUTH_NO," ).append("\n"); 
		query.append("          A.TPSZ," ).append("\n"); 
		query.append("          A.AGMT_NO," ).append("\n"); 
		query.append("		  A.AGMT_SEQ," ).append("\n"); 
		query.append("          A.VNDR_SEQ," ).append("\n"); 
		query.append("          A.LOC_CD," ).append("\n"); 
		query.append("          B.REF_NO," ).append("\n"); 
		query.append("          A.LSTM_CD," ).append("\n"); 
		query.append("          A.LESSOR," ).append("\n"); 
		query.append("          A.M_YEAR," ).append("\n"); 
		query.append("          A.FREE_DAY," ).append("\n"); 
		query.append("          A.P_UP_CHARGE," ).append("\n"); 
		query.append("          A.P_UP_CREDIT," ).append("\n"); 
		query.append("          A.MIN_ONH_DAYS," ).append("\n"); 
		query.append("          A.DPP," ).append("\n"); 
		query.append("          A.DPP_FREE_DAY," ).append("\n"); 
		query.append("          A.OLD_NEW_VAN NEW_VAN," ).append("\n"); 
		query.append("          B.OLD_NEW_VAN OLD_VAN," ).append("\n"); 
		query.append("          B.LFT_CHG_AMT L_ON," ).append("\n"); 
		query.append("          A.APRO_RMK," ).append("\n"); 
		query.append("		  A.PKUP_FM_DT," ).append("\n"); 
		query.append("          A.PKUP_DUE_DT," ).append("\n"); 
		query.append("          A.RETURN_LCC " ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT B.CNTR_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("              A.AGMT_CTY_CD ||  LTRIM(To_CHAR(A.AGMT_SEQ,'000000')) AGMT_NO," ).append("\n"); 
		query.append("			  A.AGMT_SEQ AGMT_SEQ," ).append("\n"); 
		query.append("              C.VNDR_SEQ AS VNDR_SEQ," ).append("\n"); 
		query.append("              A.ONH_LOC_CD AS LOC_CD," ).append("\n"); 
		query.append("              A.LSTM_CD," ).append("\n"); 
		query.append("              D.VNDR_ABBR_NM LESSOR," ).append("\n"); 
		query.append("              A.MFT_YR M_YEAR," ).append("\n"); 
		query.append("              A.FREE_DYS FREE_DAY," ).append("\n"); 
		query.append("              A.PKUP_CHG_AMT P_UP_CHARGE," ).append("\n"); 
		query.append("              A.PKUP_CHG_CR_AMT P_UP_CREDIT," ).append("\n"); 
		query.append("              A.MIN_ONH_DYS MIN_ONH_DAYS," ).append("\n"); 
		query.append("              A.DPP_CHG_AMT DPP," ).append("\n"); 
		query.append("              A.AUTH_DPP_FREE_DYS DPP_FREE_DAY," ).append("\n"); 
		query.append("              B.ONH_QTY OLD_NEW_VAN," ).append("\n"); 
		query.append("              A.APRO_RMK," ).append("\n"); 
		query.append("              A.PKUP_FM_DT," ).append("\n"); 
		query.append("              A.PKUP_DUE_DT," ).append("\n"); 
		query.append("              B.CNTR_ONH_AUTH_NO AUTH_NO," ).append("\n"); 
		query.append("              A.LOC_CD RETURN_LCC " ).append("\n"); 
		query.append("            FROM LSE_ONH_APRO A," ).append("\n"); 
		query.append("              LSE_ONH_APRO_QTY B," ).append("\n"); 
		query.append("              LSE_AGREEMENT C," ).append("\n"); 
		query.append("              MDM_VENDOR D" ).append("\n"); 
		query.append("            WHERE A.CNTR_ONH_AUTH_NO = B.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("              AND A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("              AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("              AND A.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("              AND A.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("              AND C.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("              AND B.NEW_VAN_TP_CD = 'N' " ).append("\n"); 
		query.append("              AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${period_stdt} != '' && ${period_eddt} != '')" ).append("\n"); 
		query.append("              AND A.PKUP_DUE_DT >= TO_DATE(@[period_stdt], 'YYYY-MM')" ).append("\n"); 
		query.append("			  AND A.PKUP_DUE_DT < ADD_MONTHS(TO_DATE(@[period_eddt], 'YYYY-MM'), 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("          ( " ).append("\n"); 
		query.append("            SELECT B.CNTR_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("              A.AGMT_CTY_CD|| LTRIM(TO_CHAR(A.AGMT_SEQ, '000000')) AGMT_NO," ).append("\n"); 
		query.append("			  A.AGMT_SEQ AS AGMT_SEQ," ).append("\n"); 
		query.append("              C.VNDR_SEQ AS VNDR_SEQ," ).append("\n"); 
		query.append("              A.ONH_LOC_CD AS LOC_CD," ).append("\n"); 
		query.append("              C.REF_NO AS REF_NO," ).append("\n"); 
		query.append("              D.VNDR_ABBR_NM LESSOR," ).append("\n"); 
		query.append("              A.MFT_YR M_YEAR," ).append("\n"); 
		query.append("              A.FREE_DYS FREE_DAY," ).append("\n"); 
		query.append("              A.PKUP_CHG_AMT P_UP_CHARGE," ).append("\n"); 
		query.append("              A.PKUP_CHG_CR_AMT P_UP_CREDIT," ).append("\n"); 
		query.append("              A.MIN_ONH_DYS MIN_ONH_DAYS," ).append("\n"); 
		query.append("              A.DPP_CHG_AMT DPP," ).append("\n"); 
		query.append("              A.AUTH_DPP_FREE_DYS DPP_FREE_DAY," ).append("\n"); 
		query.append("              B.ONH_QTY OLD_NEW_VAN," ).append("\n"); 
		query.append("              B.LFT_CHG_AMT," ).append("\n"); 
		query.append("              APRO_RMK," ).append("\n"); 
		query.append("              B.CNTR_ONH_AUTH_NO AUTH_NO," ).append("\n"); 
		query.append("              A.LOC_CD RETURN_LCC " ).append("\n"); 
		query.append("            FROM LSE_ONH_APRO A," ).append("\n"); 
		query.append("              LSE_ONH_APRO_QTY B," ).append("\n"); 
		query.append("              LSE_AGREEMENT C," ).append("\n"); 
		query.append("              MDM_VENDOR D" ).append("\n"); 
		query.append("            WHERE A.CNTR_ONH_AUTH_NO = B.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("              AND A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("              AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("              AND A.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("              AND A.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("              AND C.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("              AND B.NEW_VAN_TP_CD = 'O'" ).append("\n"); 
		query.append("              AND A.DELT_FLG = 'N') B" ).append("\n"); 
		query.append("        WHERE A.TPSZ    = B.TPSZ" ).append("\n"); 
		query.append("          AND A.AGMT_NO = B.AGMT_NO" ).append("\n"); 
		query.append("          AND A.AUTH_NO = B.AUTH_NO" ).append("\n"); 
		query.append("#if (${cntr_onh_auth_no} != '')" ).append("\n"); 
		query.append(" 	AND A.AUTH_NO = @[cntr_onh_auth_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd} != '')" ).append("\n"); 
		query.append(" 	AND A.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append(" 	AND B.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tpsz_cd} != '' )" ).append("\n"); 
		query.append("        AND    A.TPSZ IN ( #foreach($key IN ${stpsz_cd})" ).append("\n"); 
		query.append("            #if($velocityCount < $stpsz_cd.size())" ).append("\n"); 
		query.append("                  '$key'," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                   '$key'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("         #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append(" 	AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${type_chk} == 'O')" ).append("\n"); 
		query.append("	#if (${usr_ofc_cd} != 'HQ')" ).append("\n"); 
		query.append("		AND A.LSTM_CD IN ('OL','LT','ST','OF','SI','MI')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("        AND A.LSTM_CD = 'MI'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${usr_ofc_cd} != 'HQ')" ).append("\n"); 
		query.append("		AND A.LSTM_CD IN ('SO','MO')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("        AND A.LSTM_CD = 'MO'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") Z" ).append("\n"); 
		query.append("    GROUP BY Z.AUTH_NO , Z.AGMT_NO , Z.LOC_CD, Z.REF_NO , Z.LSTM_CD , Z.LESSOR , Z.M_YEAR , Z.FREE_DAY , Z.P_UP_CHARGE , Z.P_UP_CREDIT , Z.MIN_ONH_DAYS , Z.DPP , Z.DPP_FREE_DAY , Z.APRO_RMK , Z.PKUP_FM_DT, Z.PKUP_DUE_DT, Z.RETURN_LCC ) SLST" ).append("\n"); 

	}
}