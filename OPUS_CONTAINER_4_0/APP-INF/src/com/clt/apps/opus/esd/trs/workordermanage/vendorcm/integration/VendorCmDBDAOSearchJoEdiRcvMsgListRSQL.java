/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VendorCmDBDAOSearchJoEdiRcvMsgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.vendorcm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VendorCmDBDAOSearchJoEdiRcvMsgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VendorCmDBDAOSearchJoEdiRcvMsgList
	  * </pre>
	  */
	public VendorCmDBDAOSearchJoEdiRcvMsgListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("history",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_msg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.vendorcm.integration").append("\n"); 
		query.append("FileName : VendorCmDBDAOSearchJoEdiRcvMsgListRSQL").append("\n"); 
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
		query.append("WITH ENTY_MSG AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  SELECT 'EQ' CD ,'Equipment Number' NM FROM DUAL" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("  SELECT 'CNTCNM','Contact Name' FROM DUAL" ).append("\n"); 
		query.append("  UNION ALL " ).append("\n"); 
		query.append("  SELECT 'CNTCTE' ,'Contact Phone' FROM DUAL" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("  SELECT 'BKG','BKG' FROM DUAL" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("  SELECT 'BL' ,'BL' FROM DUAL" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("  SELECT 'CUTOFF','Cut off Date'FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT X.VND_CM_GROUP" ).append("\n"); 
		query.append("      ,X.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,X.TRSP_WO_SEQ" ).append("\n"); 
		query.append("      ,X.WO_NO" ).append("\n"); 
		query.append("      ,X.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,X.TRSP_SO_SEQ" ).append("\n"); 
		query.append("      ,X.SO_NO" ).append("\n"); 
		query.append("      ,X.EQ_COP_NO" ).append("\n"); 
		query.append("      ,X.RCV_MSG_SEQ" ).append("\n"); 
		query.append("      ,X.RCV_MSG_TP_CD" ).append("\n"); 
		query.append("      ,X.RCV_MSG_TP_CD_NM" ).append("\n"); 
		query.append("	  ,X.RCV_MSG" ).append("\n"); 
		query.append("      ,X.EDI_RJCT_RSN_CD" ).append("\n"); 
		query.append("      ,X.EDI_RJCT_RSN_CD_NM" ).append("\n"); 
		query.append("      ,X.N_LGS_COST_CD" ).append("\n"); 
		query.append("      ,X.N_LGS_COST_CD_NM" ).append("\n"); 
		query.append("      ,X.N_CURR_CD" ).append("\n"); 
		query.append("      ,DECODE(X.RCV_MSG, 'Charges',  TO_CHAR(X.N_RCV_AMT), X.RCV_MSG_DESC) N_RCV_AMT" ).append("\n"); 
		query.append("      ,X.N_FUEL_RTO" ).append("\n"); 
		query.append("      ,X.O_CURR_CD" ).append("\n"); 
		query.append("      ,CASE WHEN X.RCV_MSG = 'Charges' THEN TO_CHAR(X.O_RCV_AMT) ELSE X.OLD_RCV_MSG_DESC END  O_RCV_AMT   " ).append("\n"); 
		query.append("      ,X.O_FUEL_RTO" ).append("\n"); 
		query.append("      ,X.RCV_MSG_STS_CD" ).append("\n"); 
		query.append("      ,X.LOCL_CRE_DT" ).append("\n"); 
		query.append("      ,X.CRE_USR_ID" ).append("\n"); 
		query.append("      ,X.CRE_DT" ).append("\n"); 
		query.append("      ,X.UPD_USR_ID" ).append("\n"); 
		query.append("      ,X.UPD_DT" ).append("\n"); 
		query.append("      ,X.MAX_RCV_MSG_SEQ" ).append("\n"); 
		query.append("      ,Y.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("  FROM (SELECT H.TRSP_SO_OFC_CTY_CD || H.TRSP_SO_SEQ || '-' || H.EDI_MSG_SEQ VND_CM_GROUP" ).append("\n"); 
		query.append("              ,T.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("              ,T.TRSP_WO_SEQ" ).append("\n"); 
		query.append("              ,T.TRSP_WO_OFC_CTY_CD || T.TRSP_WO_SEQ AS WO_NO" ).append("\n"); 
		query.append("              ,T.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("              ,T.TRSP_SO_SEQ" ).append("\n"); 
		query.append("              ,T.TRSP_SO_OFC_CTY_CD || T.TRSP_SO_SEQ AS SO_NO" ).append("\n"); 
		query.append("              ,NVL(SO.EQ_NO, SO.COP_NO) AS EQ_COP_NO" ).append("\n"); 
		query.append("              ,T.RCV_MSG_SEQ" ).append("\n"); 
		query.append("              ,T.RCV_MSG_TP_CD" ).append("\n"); 
		query.append("              ,C.INTG_CD_VAL_DP_DESC AS RCV_MSG_TP_CD_NM" ).append("\n"); 
		query.append("			  ,T.RCV_MSG" ).append("\n"); 
		query.append("			  ,T.RCV_MSG_DESC" ).append("\n"); 
		query.append("              ,T.EDI_RJCT_RSN_CD" ).append("\n"); 
		query.append("              ,D.INTG_CD_VAL_DP_DESC AS EDI_RJCT_RSN_CD_NM" ).append("\n"); 
		query.append("              ,T.LGS_COST_CD AS N_LGS_COST_CD" ).append("\n"); 
		query.append("              ,CASE WHEN T.LGS_COST_CD = 'TRCOST' THEN 'Basic Cost'" ).append("\n"); 
		query.append("                    ELSE NVL((SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                            FROM COM_INTG_CD_DTL KK" ).append("\n"); 
		query.append("                           WHERE KK.INTG_CD_VAL_CTNT = DECODE(SUBSTR(T.LGS_COST_CD, 3, 2), 'FU', 'SCFAAL', T.LGS_COST_CD)" ).append("\n"); 
		query.append("                             AND INTG_CD_ID = 'CD30002'), NVL((SELECT NM FROM ENTY_MSG EM WHERE EM.CD = T.LGS_COST_CD), T.LGS_COST_CD))" ).append("\n"); 
		query.append("               END  N_LGS_COST_CD_NM" ).append("\n"); 
		query.append("              ,T.CURR_CD AS N_CURR_CD" ).append("\n"); 
		query.append("              ,T.RCV_AMT AS N_RCV_AMT" ).append("\n"); 
		query.append("              ,T.FUEL_RTO AS N_FUEL_RTO" ).append("\n"); 
		query.append("              ,CASE" ).append("\n"); 
		query.append("                 WHEN T.LGS_COST_CD = 'TRCOST' AND NVL(DTL.LGS_COST_CD, 'X') = 'X' THEN SO.CURR_CD" ).append("\n"); 
		query.append("				 WHEN SUBSTR(T.LGS_COST_CD, 3, 2) = 'FU' AND NVL(DTL.LGS_COST_CD, 'X') <> 'X' THEN SO.CURR_CD" ).append("\n"); 
		query.append("                 WHEN NVL(DTL.LGS_COST_CD, 'X') <> 'X' THEN SO.CURR_CD" ).append("\n"); 
		query.append("                 ELSE ''" ).append("\n"); 
		query.append("               END AS O_CURR_CD" ).append("\n"); 
		query.append("              ,NVL(T.OLD_RCV_AMT, 0) AS O_RCV_AMT" ).append("\n"); 
		query.append("              ,T.OLD_FUEL_RTO AS O_FUEL_RTO" ).append("\n"); 
		query.append("		      ,T.OLD_RCV_MSG_DESC " ).append("\n"); 
		query.append("              ,T.RCV_MSG_STS_CD" ).append("\n"); 
		query.append("              ,TO_CHAR(H.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') LOCL_CRE_DT" ).append("\n"); 
		query.append("              ,T.CRE_USR_ID" ).append("\n"); 
		query.append("              ,T.CRE_DT" ).append("\n"); 
		query.append("              ,T.UPD_USR_ID" ).append("\n"); 
		query.append("              ,T.UPD_DT" ).append("\n"); 
		query.append("              ,H.EDI_MSG_SEQ AS MAX_RCV_MSG_SEQ              " ).append("\n"); 
		query.append("          FROM TRS_EDI_USA_RCV_MSG T" ).append("\n"); 
		query.append("              ,TRS_EDI_WRK_ORD_HIS H" ).append("\n"); 
		query.append("              ,COM_INTG_CD_DTL     C" ).append("\n"); 
		query.append("              ,COM_INTG_CD_DTL     D" ).append("\n"); 
		query.append("              ,TRS_TRSP_SVC_ORD    SO" ).append("\n"); 
		query.append("              ,TRS_TRSP_SCG_DTL    DTL" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND (T.TRSP_SO_OFC_CTY_CD, T.TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("                #foreach($code IN ${soArrays})  " ).append("\n"); 
		query.append("                  #if($velocityCount == 1)  " ).append("\n"); 
		query.append("                    (SUBSTR('$code', 1, 3), SUBSTR('$code', 4))" ).append("\n"); 
		query.append("                  #else  " ).append("\n"); 
		query.append("                     ,(SUBSTR('$code', 1, 3), SUBSTR('$code', 4))" ).append("\n"); 
		query.append("                  #end " ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("		   AND DECODE(@[history], 'Y', T.RCV_MSG_SEQ, 0) = DECODE(@[history], 'Y', TO_NUMBER(NVL(@[rcv_msg_seq], '0')), 0)" ).append("\n"); 
		query.append("           AND T.TRSP_SO_OFC_CTY_CD = H.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND T.TRSP_SO_SEQ = H.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND T.RCV_MSG_SEQ = H.EDI_MSG_SEQ" ).append("\n"); 
		query.append("           AND T.TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND T.TRSP_SO_SEQ = SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("		   AND DECODE(@[history], 'Y', 'X', NVL(T.RCV_MSG_STS_CD, 'NULL')) = DECODE(@[history], 'Y', 'X', 'NULL')	" ).append("\n"); 
		query.append("           AND T.RCV_MSG_TP_CD = C.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("           AND C.INTG_CD_ID(+) = 'CD30028'" ).append("\n"); 
		query.append("           AND T.EDI_RJCT_RSN_CD = D.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("           AND D.INTG_CD_ID(+) = 'CD30025'" ).append("\n"); 
		query.append("           AND T.TRSP_SO_OFC_CTY_CD = DTL.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("           AND T.TRSP_SO_SEQ = DTL.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("           AND T.LGS_COST_CD = DTL.LGS_COST_CD(+)" ).append("\n"); 
		query.append("		   AND DTL.SCG_DTL_SEQ(+) = 1" ).append("\n"); 
		query.append("		) X" ).append("\n"); 
		query.append("      ,COM_INTG_CD_DTL Y" ).append("\n"); 
		query.append(" WHERE X.N_LGS_COST_CD = Y.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("   AND Y.INTG_CD_ID(+) = 'CD30002'" ).append("\n"); 
		query.append(" ORDER BY X.VND_CM_GROUP" ).append("\n"); 
		query.append("         ,X.WO_NO" ).append("\n"); 
		query.append("         ,X.EQ_COP_NO" ).append("\n"); 
		query.append("         ,X.RCV_MSG_SEQ" ).append("\n"); 
		query.append("         ,X.RCV_MSG_TP_CD" ).append("\n"); 
		query.append("         ,DECODE(X.N_LGS_COST_CD, 'TRCOST', 1, DECODE(SUBSTR(X.N_LGS_COST_CD, 3, 2), 'FU', 2, Y.INTG_CD_VAL_DP_SEQ + 2))" ).append("\n"); 

	}
}