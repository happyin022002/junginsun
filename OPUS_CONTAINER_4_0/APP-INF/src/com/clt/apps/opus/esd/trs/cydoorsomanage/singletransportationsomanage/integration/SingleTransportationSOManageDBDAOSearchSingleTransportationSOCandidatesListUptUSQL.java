/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUptUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.05.02 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUptUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer 자료 UPDATE
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUptUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ui_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUptUSQL").append("\n"); 
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
		query.append("UPDATE (SELECT C1.CUST_CNT_CD A_SHPR_CUST_CNT_CD" ).append("\n"); 
		query.append("              ,C1.CUST_SEQ A_SHPR_CUST_SEQ" ).append("\n"); 
		query.append("              ,REPLACE(NVL(C1.CUST_NM, ' '), CHR(13) || CHR(10), ' ') A_SHPR_CUST_NM" ).append("\n"); 
		query.append("              ,C2.CUST_CNT_CD A_CNEE_CUST_CNT_CD" ).append("\n"); 
		query.append("              ,C2.CUST_SEQ A_CNEE_CUST_SEQ" ).append("\n"); 
		query.append("              ,REPLACE(NVL(C2.CUST_NM, ' '), CHR(13) || CHR(10), ' ') A_CNEE_CUST_NM" ).append("\n"); 
		query.append("              ,REPLACE(NVL(C3.CUST_NM, ' '), CHR(13) || CHR(10), ' ') A_NTFY_CUST_NM" ).append("\n"); 
		query.append("			  ,CASE WHEN X.TRSP_BND_CD = 'O' AND @[ui_conti_cd] = 'M' AND NVL(X.TRSP_COST_DTL_MOD_CD, 'CY') = 'CY' THEN" ).append("\n"); 
		query.append("					(SELECT PKUP_EDI_322_NO || '^^^'" ).append("\n"); 
		query.append("					 FROM (SELECT  G.BKG_EDI_322_NO" ).append("\n"); 
		query.append("								  ,G.EQ_NO" ).append("\n"); 
		query.append("								  ,G.DEST_LOC_NM" ).append("\n"); 
		query.append("								  ,G.PKUP_EDI_322_NO" ).append("\n"); 
		query.append("								  ,ROW_NUMBER() OVER(partition BY G.EQ_NO, G.BKG_EDI_322_NO, G.DEST_LOC_NM order by G.EVNT_DT DESC, G.EQ_NO DESC, G.EDI_322_STS_CD DESC) RK" ).append("\n"); 
		query.append("							  FROM EDI_322_MSG G) P1" ).append("\n"); 
		query.append("					WHERE P1.EQ_NO = X.EQ_NO" ).append("\n"); 
		query.append("					  AND P1.BKG_EDI_322_NO = X.BKG_NO" ).append("\n"); 
		query.append("					  AND P1.DEST_LOC_NM = X.FM_NOD_CD || X.FM_NOD_YD_NO" ).append("\n"); 
		query.append("					  AND P1.RK = 1" ).append("\n"); 
		query.append("					  AND ROWNUM=1" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("					ELSE TRS_GET_PKUP_NO_FNC(X.BKG_NO, X.EQ_NO, '', X.DEL_CD, '', X.FM_NOD_CD || X.FM_NOD_YD_NO)" ).append("\n"); 
		query.append("			   END A_PKUP_INFO" ).append("\n"); 
		query.append("              ,X.SHPR_CUST_CNT_CD" ).append("\n"); 
		query.append("              ,X.SHPR_CUST_SEQ" ).append("\n"); 
		query.append("              ,X.SHPR_CUST_NM" ).append("\n"); 
		query.append("              ,X.CNEE_CUST_CNT_CD" ).append("\n"); 
		query.append("              ,X.CNEE_CUST_SEQ" ).append("\n"); 
		query.append("              ,X.CNEE_CUST_NM" ).append("\n"); 
		query.append("              ,X.NTFY_CUST_NM" ).append("\n"); 
		query.append("              #if (${ui_conti_cd} == 'M')" ).append("\n"); 
		query.append("              ,X.CNTR_PKUP_NO" ).append("\n"); 
		query.append("              ,X.AVAL_DT" ).append("\n"); 
		query.append("              ,X.LST_FREE_DT" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("         FROM TRS_TRSP_SVC_ORD_TMP X" ).append("\n"); 
		query.append("             ,BKG_CUSTOMER         C1" ).append("\n"); 
		query.append("             ,BKG_CUSTOMER         C2" ).append("\n"); 
		query.append("             ,BKG_CUSTOMER         C3" ).append("\n"); 
		query.append("        WHERE X.BKG_NO = C1.BKG_NO(+)" ).append("\n"); 
		query.append("          AND C1.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("          AND X.BKG_NO = C2.BKG_NO(+)" ).append("\n"); 
		query.append("          AND C2.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("          AND X.BKG_NO = C3.BKG_NO(+)" ).append("\n"); 
		query.append("          AND C3.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("          AND X.TRSP_TMP_SEQ = @[trsp_tmp_seq])" ).append("\n"); 
		query.append("SET SHPR_CUST_CNT_CD = A_SHPR_CUST_CNT_CD" ).append("\n"); 
		query.append("   ,SHPR_CUST_SEQ    = A_SHPR_CUST_SEQ" ).append("\n"); 
		query.append("   ,SHPR_CUST_NM     = A_SHPR_CUST_NM" ).append("\n"); 
		query.append("   ,CNEE_CUST_CNT_CD = A_CNEE_CUST_CNT_CD" ).append("\n"); 
		query.append("   ,CNEE_CUST_SEQ    = A_CNEE_CUST_SEQ" ).append("\n"); 
		query.append("   ,CNEE_CUST_NM     = A_CNEE_CUST_NM" ).append("\n"); 
		query.append("   ,NTFY_CUST_NM     = A_NTFY_CUST_NM" ).append("\n"); 
		query.append("#if (${ui_conti_cd} == 'M')" ).append("\n"); 
		query.append("   ,CNTR_PKUP_NO     = SUBSTR(A_PKUP_INFO, 1, INSTR(A_PKUP_INFO, '^', 1, 1) - 1)" ).append("\n"); 
		query.append("   ,AVAL_DT          = TO_DATE(SUBSTR(A_PKUP_INFO, INSTR(A_PKUP_INFO, '^', 1, 2) + 1, INSTR(A_PKUP_INFO, '^', 1, 3) - INSTR(A_PKUP_INFO, '^', 1, 2) - 1), 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("   ,LST_FREE_DT      = TO_DATE(SUBSTR(A_PKUP_INFO, INSTR(A_PKUP_INFO, '^', 1, 3) + 1, INSTR(A_PKUP_INFO, '^', 1, 4) - INSTR(A_PKUP_INFO, '^', 1, 3) - 1), 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}