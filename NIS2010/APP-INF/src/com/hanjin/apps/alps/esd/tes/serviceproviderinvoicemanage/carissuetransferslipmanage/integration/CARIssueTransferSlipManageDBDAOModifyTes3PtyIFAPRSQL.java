/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOModifyTes3PtyIFAPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.15
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.11.15 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOModifyTes3PtyIFAPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyTes3PtyIFAP
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOModifyTes3PtyIFAPRSQL(){
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOModifyTes3PtyIFAPRSQL").append("\n"); 
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
		query.append("SELECT TML_IF_OFC_CD     TML_IF_OFC_CD,    -- KEY DATA" ).append("\n"); 
		query.append("TML_IF_SEQ        TML_IF_SEQ,       -- KEY DATA" ).append("\n"); 
		query.append("INV_NO            INV_NO,      	 -- UPDATE DATA" ).append("\n"); 
		query.append("ACCT_CD           ACCT_CD,      	 -- UPDATE DATA" ).append("\n"); 
		query.append("FINC_VSL_CD       FINC_VSL_CD,      -- UPDATE DATA" ).append("\n"); 
		query.append("FINC_SKD_VOY_NO   FINC_SKD_VOY_NO,  -- UPDATE DATA" ).append("\n"); 
		query.append("FINC_SKD_DIR_CD   FINC_SKD_DIR_CD,  -- UPDATE DATA" ).append("\n"); 
		query.append("GL_DT             GL_DT,            -- UPDATE DATA" ).append("\n"); 
		query.append("VVD_CD            VVD_CD,           -- UPDATE DATA" ).append("\n"); 
		query.append("@[usr_id]		           UPD_USR_ID,       -- UPDATE DATA(LOGIN한 사용자 ID)" ).append("\n"); 
		query.append("UPD_DT            UPD_DT            -- UPDATE DATA" ).append("\n"); 
		query.append("FROM   ( SELECT P.TML_IF_OFC_CD, P.TML_IF_SEQ, H.INV_NO, D.ACCT_CD," ).append("\n"); 
		query.append("L.FINC_VSL_CD, L.FINC_SKD_VOY_NO, L.FINC_SKD_DIR_CD," ).append("\n"); 
		query.append("CASE WHEN D.LGS_COST_CD = 'SVXXJO' THEN L.VSL_CD||L.SKD_VOY_NO||L.SKD_DIR_CD" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END VVD_CD," ).append("\n"); 
		query.append("A.GL_DT," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(P.TML_IF_OFC_CD) UPD_DT" ).append("\n"); 
		query.append("FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L, TES_N3RD_PTY_IF P, AP_INV_HDR A" ).append("\n"); 
		query.append("WHERE  H.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND    H.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND    NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND    H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    H.TML_SO_SEQ = D.TML_SO_SEQ" ).append("\n"); 
		query.append("AND    D.N3PTY_FLG = 'Y'" ).append("\n"); 
		query.append("AND    D.CALC_COST_GRP_CD    NOT IN ('SD','SP')  --수정(20070111)" ).append("\n"); 
		query.append("AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("AND    D.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    D.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("AND    L.VRFY_RSLT_IND_CD  	= 'CO'" ).append("\n"); 
		query.append("AND    D.TML_SO_OFC_CTY_CD   = P.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    D.TML_SO_SEQ          = P.TML_SO_SEQ" ).append("\n"); 
		query.append("AND    D.TML_SO_DTL_SEQ      = P.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("AND    L.CNTR_NO             = P.CNTR_NO" ).append("\n"); 
		query.append("AND    H.CSR_NO              = A.CSR_NO(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT P.TML_IF_OFC_CD, P.TML_IF_SEQ, H.INV_NO, D.ACCT_CD," ).append("\n"); 
		query.append("D.FINC_VSL_CD, D.FINC_SKD_VOY_NO, D.FINC_SKD_DIR_CD," ).append("\n"); 
		query.append("CASE WHEN D.LGS_COST_CD = 'SVXXJO' THEN D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END VVD_CD," ).append("\n"); 
		query.append("A.GL_DT," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(P.TML_IF_OFC_CD) UPD_DT" ).append("\n"); 
		query.append("FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_N3RD_PTY_IF P, AP_INV_HDR A" ).append("\n"); 
		query.append("WHERE  H.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND    H.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND    NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND    H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    H.TML_SO_SEQ = D.TML_SO_SEQ" ).append("\n"); 
		query.append("AND    D.N3PTY_FLG = 'Y'" ).append("\n"); 
		query.append("AND    ( D.CALC_COST_GRP_CD    IN ('SD','SP')  --수정(20080111)" ).append("\n"); 
		query.append("OR       D.CALC_TP_CD          = 'M' )" ).append("\n"); 
		query.append("AND    D.TML_SO_OFC_CTY_CD   = P.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    D.TML_SO_SEQ          = P.TML_SO_SEQ" ).append("\n"); 
		query.append("AND    D.TML_SO_DTL_SEQ      = P.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("AND    H.CSR_NO              = A.CSR_NO(+) )" ).append("\n"); 

	}
}