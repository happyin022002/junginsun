/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFARateQuotationDBDAOPriRqRtCmdtRoutEstmCostDetailVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.01.12 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateQuotationDBDAOPriRqRtCmdtRoutEstmCostDetailVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pri_rq_rt를 일괄 조정한다.
	  * </pre>
	  */
	public RFARateQuotationDBDAOPriRqRtCmdtRoutEstmCostDetailVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAOPriRqRtCmdtRoutEstmCostDetailVOUSQL").append("\n"); 
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
		query.append("MERGE INTO PRI_RQ_RT_CMDT_ROUT A " ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("        SELECT QTTN_NO, QTTN_VER_NO" ).append("\n"); 
		query.append("        ,CMDT_HDR_SEQ, ROUT_SEQ" ).append("\n"); 
		query.append("        ,PRC_CGO_TP_CD AS CGO_TP_CD" ).append("\n"); 
		query.append("        ,RAT_UT_CD" ).append("\n"); 
		query.append("        ,PRS_RESPB_CMPB_AMT" ).append("\n"); 
		query.append("        ,PRS_PFIT_CMPB_AMT" ).append("\n"); 
		query.append("        ,PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append("        FROM   (       " ).append("\n"); 
		query.append("        SELECT  A.QTTN_NO, A.QTTN_VER_NO" ).append("\n"); 
		query.append("              ,A.CMDT_HDR_SEQ, A.ROUT_SEQ" ).append("\n"); 
		query.append("              ,B.PRC_CGO_TP_CD, B.RAT_UT_CD" ).append("\n"); 
		query.append("              ,B.PRS_RESPB_CMPB_AMT, B.PRS_PFIT_CMPB_AMT, B.PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append("		      ,ROW_NUMBER() OVER(PARTITION BY A.QTTN_NO,A.QTTN_VER_NO,A.CMDT_HDR_SEQ,A.ROUT_SEQ " ).append("\n"); 
		query.append("	               ORDER BY DECODE(B.PRC_CGO_TP_CD,'DR','00','RF','01','DG','02','AK','03','04')" ).append("\n"); 
		query.append("	           || DECODE(B.RAT_UT_CD, 'D4','00', 'D5','01','02')   " ).append("\n"); 
		query.append("	           || DECODE(M.CNTR_SZ_CD,'4','00','2','01','3','02','5','03','6','04','7','05','8','06','9','07','W','08','X','09','10')" ).append("\n"); 
		query.append("	           ) RNK" ).append("\n"); 
		query.append("         FROM  PRI_RQ_RT_CMDT_ROUT A" ).append("\n"); 
		query.append("              ,PRI_RQ_RT B" ).append("\n"); 
		query.append("              ,PRI_RAT_UT M" ).append("\n"); 
		query.append("        WHERE  A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("          AND  A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("          AND  B.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("          AND  B.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("          AND  B.RT_SEQ = @[rt_seq]" ).append("\n"); 
		query.append("          AND  A.QTTN_NO = B.QTTN_NO" ).append("\n"); 
		query.append("          AND  A.QTTN_VER_NO = B.QTTN_VER_NO" ).append("\n"); 
		query.append("          AND  A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("          AND  A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("          AND  B.RAT_UT_CD = M.RAT_UT_CD" ).append("\n"); 
		query.append("          AND  B.PRS_RESPB_CMPB_AMT IS NOT NULL" ).append("\n"); 
		query.append("          )   " ).append("\n"); 
		query.append("          WHERE RNK = 1   " ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("   A.QTTN_NO = B.QTTN_NO" ).append("\n"); 
		query.append("   AND  A.QTTN_VER_NO = B.QTTN_VER_NO" ).append("\n"); 
		query.append("   AND  A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("   AND  A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET A.PRS_RAT_UT_CD = B.RAT_UT_CD" ).append("\n"); 
		query.append("        ,A.PRS_CGO_TP_CD = B.CGO_TP_CD" ).append("\n"); 
		query.append("        ,A.PRS_ESTM_RESPB_CMPB_AMT = B.PRS_RESPB_CMPB_AMT" ).append("\n"); 
		query.append("        ,A.PRS_ESTM_PFIT_CMPB_AMT = B.PRS_PFIT_CMPB_AMT" ).append("\n"); 
		query.append("        ,A.PRS_ESTM_RESPB_OPB_AMT = B.PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append("        ,PRS_UPD_DT = SYSDATE" ).append("\n"); 
		query.append("   " ).append("\n"); 

	}
}