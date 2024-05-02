/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SCContractPartyProposalDBDAOPriSpCtrtPtyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCContractPartyProposalDBDAOPriSpCtrtPtyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History--------------------------------------
	  * 2011.03.30 이행지 [CHM-201109659-01] OTI Bond / Tariff Title page / OTI License Attach / Signing POA 기능 개발(Customer section)
	  *                          - PRI_SP_CTRT_PTY ( OTI_LIC_ATCH_FILE_ID, OTI_BD_ATCH_FILE_ID, TRF_TIT_ATCH_FILE_ID, POA_ATCH_FILE_ID) 컬럼추가에 따른 쿼리 수정
	  * </pre>
	  */
	public SCContractPartyProposalDBDAOPriSpCtrtPtyVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ctrt_pty_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.integration").append("\n"); 
		query.append("FileName : SCContractPartyProposalDBDAOPriSpCtrtPtyVORSQL").append("\n"); 
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
		query.append("    A.PROP_NO                       ," ).append("\n"); 
		query.append("    A.AMDT_SEQ                      ," ).append("\n"); 
		query.append("    A.PRC_CTRT_PTY_TP_CD            ," ).append("\n"); 
		query.append("    A.CUST_CNT_CD           ," ).append("\n"); 
		query.append("	A.CUST_SEQ ," ).append("\n"); 
		query.append("	A.CTRT_CUST_VAL_SGM_CD," ).append("\n"); 
		query.append("	A.CTRT_CUST_SREP_CD," ).append("\n"); 
		query.append("	A.CTRT_CUST_SLS_OFC_CD, " ).append("\n"); 
		query.append("	A.CTRT_PTY_NM, " ).append("\n"); 
		query.append("	A.CTRT_PTY_ADDR, " ).append("\n"); 
		query.append("	A.CTRT_PTY_SGN_NM, " ).append("\n"); 
		query.append("	A.CTRT_PTY_SGN_TIT_NM, " ).append("\n"); 
		query.append("    A.N1ST_CMNC_AMDT_SEQ ," ).append("\n"); 
		query.append("    (SELECT TO_CHAR(EFF_DT, 'YYYYMMDD') FROM PRI_SP_MN WHERE PROP_NO = A.PROP_NO " ).append("\n"); 
		query.append("										AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ  ) EFF_DT," ).append("\n"); 
		query.append("    CASE" ).append("\n"); 
		query.append("        WHEN A.AMDT_SEQ = @[amdt_seq] THEN TO_CHAR(M.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("        (    " ).append("\n"); 
		query.append("        SELECT CASE WHEN M.EFF_DT <= N.EXP_DT THEN TO_CHAR(M.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("               ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("               END AS EXP_DT" ).append("\n"); 
		query.append("        FROM PRI_SP_MN N" ).append("\n"); 
		query.append("        WHERE PROP_NO = M.PROP_NO AND AMDT_SEQ = M.AMDT_SEQ-1    " ).append("\n"); 
		query.append("        )    " ).append("\n"); 
		query.append("    END  EXP_DT,      " ).append("\n"); 
		query.append("    A.SRC_INFO_CD                   ," ).append("\n"); 
		query.append("    SRC.INTG_CD_VAL_DESC SRC_INFO_NM  ,       " ).append("\n"); 
		query.append("    A.PRC_PROG_STS_CD ," ).append("\n"); 
		query.append("    STS.INTG_CD_VAL_DESC PRC_PROG_STS_NM ," ).append("\n"); 
		query.append("    A.ACPT_USR_ID," ).append("\n"); 
		query.append("	A.ACPT_OFC_CD," ).append("\n"); 
		query.append("	TO_CHAR(A.ACPT_DT,'YYYYMMDD') ACPT_DT," ).append("\n"); 
		query.append("	NVOCC_BD_NO," ).append("\n"); 
		query.append("	NVOCC_LIC_NO," ).append("\n"); 
		query.append("	A.OTI_BD_ATCH_FILE_ID," ).append("\n"); 
		query.append("    CASE WHEN LENGTH(F1.FILE_UPLD_NM) > 10 " ).append("\n"); 
		query.append("        THEN SUBSTR(F1.FILE_UPLD_NM,1,10)||'...'" ).append("\n"); 
		query.append("        ELSE F1.FILE_UPLD_NM" ).append("\n"); 
		query.append("    END OTI_BD_ATCH_FILE_NM," ).append("\n"); 
		query.append("	F1.FILE_UPLD_NM AS OTI_BD_ATCH_FILE_NM_ORG," ).append("\n"); 
		query.append("	A.OTI_LIC_ATCH_FILE_ID," ).append("\n"); 
		query.append("    CASE WHEN LENGTH(F2.FILE_UPLD_NM) > 10 " ).append("\n"); 
		query.append("        THEN SUBSTR(F2.FILE_UPLD_NM,1,10)||'...'" ).append("\n"); 
		query.append("        ELSE F2.FILE_UPLD_NM" ).append("\n"); 
		query.append("    END OTI_LIC_ATCH_FILE_NM," ).append("\n"); 
		query.append("	F2.FILE_UPLD_NM AS OTI_LIC_ATCH_FILE_NM_ORG," ).append("\n"); 
		query.append("	A.TRF_TIT_ATCH_FILE_ID," ).append("\n"); 
		query.append("    CASE WHEN LENGTH(F3.FILE_UPLD_NM) > 10 " ).append("\n"); 
		query.append("        THEN SUBSTR(F3.FILE_UPLD_NM,1,10)||'...'" ).append("\n"); 
		query.append("        ELSE F3.FILE_UPLD_NM" ).append("\n"); 
		query.append("    END TRF_TIT_ATCH_FILE_NM," ).append("\n"); 
		query.append("	F3.FILE_UPLD_NM AS TRF_TIT_ATCH_FILE_NM_ORG," ).append("\n"); 
		query.append("	A.POA_ATCH_FILE_ID," ).append("\n"); 
		query.append("    CASE WHEN LENGTH(F4.FILE_UPLD_NM) > 10 " ).append("\n"); 
		query.append("        THEN SUBSTR(F4.FILE_UPLD_NM,1,10)||'...'" ).append("\n"); 
		query.append("        ELSE F4.FILE_UPLD_NM" ).append("\n"); 
		query.append("    END POA_ATCH_FILE_NM," ).append("\n"); 
		query.append("	F4.FILE_UPLD_NM AS POA_ATCH_FILE_NM_ORG," ).append("\n"); 
		query.append("	A.MOC_LIC_NO" ).append("\n"); 
		query.append("FROM   " ).append("\n"); 
		query.append("    PRI_SP_CTRT_PTY     A  ," ).append("\n"); 
		query.append("    PRI_SP_MN           M  ," ).append("\n"); 
		query.append("    COM_INTG_CD_DTL     SRC," ).append("\n"); 
		query.append("    COM_INTG_CD_DTL     STS," ).append("\n"); 
		query.append("	MDM_CUSTOMER		MDM," ).append("\n"); 
		query.append("	COM_UPLD_FILE		F1," ).append("\n"); 
		query.append("	COM_UPLD_FILE		F2," ).append("\n"); 
		query.append("	COM_UPLD_FILE		F3," ).append("\n"); 
		query.append("	COM_UPLD_FILE		F4" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("    M.PROP_NO                = A.PROP_NO" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD            = MDM.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ               = MDM.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.OTI_BD_ATCH_FILE_ID    = F1.FILE_SAV_ID(+)" ).append("\n"); 
		query.append("AND A.OTI_LIC_ATCH_FILE_ID   = F2.FILE_SAV_ID(+)" ).append("\n"); 
		query.append("AND A.TRF_TIT_ATCH_FILE_ID   = F3.FILE_SAV_ID(+)" ).append("\n"); 
		query.append("AND A.POA_ATCH_FILE_ID       = F4.FILE_SAV_ID(+) " ).append("\n"); 
		query.append("AND M.AMDT_SEQ          = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A.PRC_CTRT_PTY_TP_CD = @[prc_ctrt_pty_tp_cd]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ IN ( @[amdt_seq], DECODE((SELECT LGCY_IF_FLG FROM PRI_SP_MN TMP WHERE TMP.PROP_NO = @[prop_no] AND TMP.AMDT_SEQ = @[amdt_seq]), 'Y', @[amdt_seq], @[amdt_seq]-1))" ).append("\n"); 
		query.append("AND    (( A.AMDT_SEQ = @[amdt_seq] AND A.SRC_INFO_CD <> DECODE((SELECT LGCY_IF_FLG FROM PRI_SP_MN TMP WHERE TMP.PROP_NO = @[prop_no] AND TMP.AMDT_SEQ = @[amdt_seq]),'Y','AD','ZZ'))" ).append("\n"); 
		query.append("       OR ( A.AMDT_SEQ = @[amdt_seq]-1" ).append("\n"); 
		query.append("            AND  A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("            AND  NOT EXISTS ( SELECT 'X' FROM PRI_SP_CTRT_PTY B" ).append("\n"); 
		query.append("                               WHERE " ).append("\n"); 
		query.append("                                   B.PROP_NO            = A.PROP_NO " ).append("\n"); 
		query.append("                               AND B.AMDT_SEQ           = @[amdt_seq]" ).append("\n"); 
		query.append("                               AND B.PRC_CTRT_PTY_TP_CD = A.PRC_CTRT_PTY_TP_CD " ).append("\n"); 
		query.append("                               AND B.N1ST_CMNC_AMDT_SEQ    = A.N1ST_CMNC_AMDT_SEQ           " ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("AND SRC.INTG_CD_VAL_CTNT = A.SRC_INFO_CD" ).append("\n"); 
		query.append("AND SRC.INTG_CD_ID       = 'CD02064'" ).append("\n"); 
		query.append("AND STS.INTG_CD_VAL_CTNT = A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("AND STS.INTG_CD_ID       = 'CD01719'" ).append("\n"); 
		query.append("ORDER BY A.AMDT_SEQ" ).append("\n"); 

	}
}