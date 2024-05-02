/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAOSearchOffdockCYInvoiceBasicInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OffdockCYInvoiceManageDBDAOSearchOffdockCYInvoiceBasicInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOffdockCYInvoiceBasicInfo
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAOSearchOffdockCYInvoiceBasicInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAOSearchOffdockCYInvoiceBasicInfoRSQL").append("\n"); 
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
		query.append("SELECT		" ).append("\n"); 
		query.append("  A.TML_SO_OFC_CTY_CD   ," ).append("\n"); 
		query.append("  A.TML_SO_SEQ          ," ).append("\n"); 
		query.append("  A.INV_OFC_CD          ," ).append("\n"); 
		query.append("  A.COST_OFC_CD         ," ).append("\n"); 
		query.append("  A.INV_NO              ," ).append("\n"); 
		query.append("--(SELECT VNDR_LGL_ENG_NM FROm MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_SEQ  AND DELT_FLG = 'N' GROUP BY VNDR_LGL_ENG_NM) AS VNDR_SEQ_NM," ).append("\n"); 
		query.append("  A.VNDR_SEQ            ," ).append("\n"); 
		query.append("  A.YD_CD             ,  " ).append("\n"); 
		query.append("  B.YD_NM             ,  " ).append("\n"); 
		query.append("  A.CURR_CD             ," ).append("\n"); 
		query.append("  A.TTL_INV_AMT         ," ).append("\n"); 
		query.append("  A.VAT_AMT             ," ).append("\n"); 
		query.append("  A.TTL_CALC_AMT        ," ).append("\n"); 
		query.append("  SUBSTR(A.FM_PRD_DT,0,4)||'-'||SUBSTR(A.FM_PRD_DT,5,2)||'-'||SUBSTR(A.FM_PRD_DT,7,2) FM_PRD_DT , " ).append("\n"); 
		query.append("  A.HLD_FLG             ," ).append("\n"); 
		query.append("  A.HLD_RMK             ," ).append("\n"); 
		query.append("  SUBSTR(A.TO_PRD_DT,0,4)||'-'||SUBSTR(A.TO_PRD_DT,5,2)||'-'||SUBSTR(A.TO_PRD_DT,7,2) TO_PRD_DT , " ).append("\n"); 
		query.append("  A.TML_INV_TP_CD       ," ).append("\n"); 
		query.append("  A.TML_COST_GRP_CD     ," ).append("\n"); 
		query.append("  A.TML_CALC_IND_CD     ," ).append("\n"); 
		query.append("  A.STO_DYS_IND_CD      ," ).append("\n"); 
		query.append("  TO_CHAR(A.ISS_DT,'YYYY-MM-DD') ISS_DT  ," ).append("\n"); 
		query.append("  TO_CHAR(A.RCV_DT,'YYYY-MM-DD') RCV_DT  ," ).append("\n"); 
		query.append("  TO_CHAR(A.EFF_DT,'YYYY-MM-DD') EFF_DT  ," ).append("\n"); 
		query.append("  TO_CHAR(A.PAY_DUE_DT,'YYYY-MM-DD') PAY_DUE_DT   , " ).append("\n"); 
		query.append("  A.PAY_FLG             ," ).append("\n"); 
		query.append("  A.TML_INV_STS_CD      ," ).append("\n"); 
		query.append("  A.TML_INV_RJCT_STS_CD ," ).append("\n"); 
		query.append("  TO_CHAR(A.INV_CFM_DT,'YYYY-MM-DD') INV_CFM_DT   , " ).append("\n"); 
		query.append("  TO_CHAR(A.INV_RJCT_DT,'YYYY-MM-DD') INV_RJCT_DT ," ).append("\n"); 
		query.append("  A.INV_RJCT_RMK        ," ).append("\n"); 
		query.append("  A.CRE_USR_ID          ," ).append("\n"); 
		query.append("  TO_CHAR(A.CRE_DT,'YYYY-MM-DD') CRE_DT   ,         " ).append("\n"); 
		query.append("  A.UPD_USR_ID          ," ).append("\n"); 
		query.append("  TO_CHAR(A.UPD_DT,'YYYY-MM-DD') UPD_DT   ,         " ).append("\n"); 
		query.append("  A.ERR_INV_NO," ).append("\n"); 
		query.append("  A.WHLD_TAX_AMT, " ).append("\n"); 
		query.append("  A.EDI_FLG," ).append("\n"); 
		query.append("  A.AP_RVS_CNG_FLG," ).append("\n"); 
		query.append("  (SELECT TO_CHAR(MIN(MVMT_GATE_IN_DT),'YYYY-MM-DD') --[CHM-201536553]ODCY, MR Storage관련 로직 및 UI 변경 요청건 " ).append("\n"); 
		query.append("        FROM TES_TML_SO_CNTR_LIST C" ).append("\n"); 
		query.append("        WHERE A.TML_SO_OFC_CTY_CD = C.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND A.TML_SO_SEQ = C.TML_SO_SEQ" ).append("\n"); 
		query.append("        AND C.VRFY_RSLT_IND_CD = 'CO') MVMT_GATE_IN_DT," ).append("\n"); 
		query.append("  (SELECT TO_CHAR(MAX(MVMT_GATE_OUT_DT),'YYYY-MM-DD') --[CHM-201536553]ODCY, MR Storage관련 로직 및 UI 변경 요청건 " ).append("\n"); 
		query.append("        FROM TES_TML_SO_CNTR_LIST D" ).append("\n"); 
		query.append("        WHERE A.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND A.TML_SO_SEQ = D.TML_SO_SEQ" ).append("\n"); 
		query.append("        AND D.VRFY_RSLT_IND_CD = 'CO')  MVMT_GATE_OUT_DT" ).append("\n"); 
		query.append("	, DBT_NOTE_NO  -- india " ).append("\n"); 
		query.append("	, IDA_CGST_AMT -- india   " ).append("\n"); 
		query.append("	, IDA_SGST_AMT -- india " ).append("\n"); 
		query.append("	, IDA_IGST_AMT -- india " ).append("\n"); 
		query.append("	, IDA_UGST_AMT -- india                     " ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR A, MDM_YARD B         " ).append("\n"); 
		query.append("WHERE 1=1                " ).append("\n"); 
		query.append("AND A.YD_CD = B.YD_CD(+) " ).append("\n"); 
		query.append("AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG,'N') <> 'Y'" ).append("\n"); 

	}
}