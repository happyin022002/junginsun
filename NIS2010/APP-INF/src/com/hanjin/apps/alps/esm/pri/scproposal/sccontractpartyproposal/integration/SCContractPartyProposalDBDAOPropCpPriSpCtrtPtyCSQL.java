/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SCContractPartyProposalDBDAOPropCpPriSpCtrtPtyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.24 
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

public class SCContractPartyProposalDBDAOPropCpPriSpCtrtPtyCSQL implements ISQLTemplate{

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
	public SCContractPartyProposalDBDAOPropCpPriSpCtrtPtyCSQL(){
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.integration").append("\n"); 
		query.append("FileName : SCContractPartyProposalDBDAOPropCpPriSpCtrtPtyCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_CTRT_PTY (" ).append("\n"); 
		query.append("      PROP_NO" ).append("\n"); 
		query.append("    , AMDT_SEQ" ).append("\n"); 
		query.append("    , PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("    , CUST_CNT_CD" ).append("\n"); 
		query.append("    , CUST_SEQ" ).append("\n"); 
		query.append("    , CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("    , CTRT_CUST_SREP_CD" ).append("\n"); 
		query.append("    , CTRT_CUST_SLS_OFC_CD" ).append("\n"); 
		query.append("    , CTRT_PTY_NM" ).append("\n"); 
		query.append("    , CTRT_PTY_ADDR" ).append("\n"); 
		query.append("    , CTRT_PTY_SGN_NM" ).append("\n"); 
		query.append("    , CTRT_PTY_SGN_TIT_NM" ).append("\n"); 
		query.append("    , PRC_PROG_STS_CD" ).append("\n"); 
		query.append("    , SRC_INFO_CD" ).append("\n"); 
		query.append("    , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("	, OTI_LIC_ATCH_FILE_ID" ).append("\n"); 
		query.append("	, OTI_BD_ATCH_FILE_ID" ).append("\n"); 
		query.append("	, TRF_TIT_ATCH_FILE_ID" ).append("\n"); 
		query.append("	, POA_ATCH_FILE_ID" ).append("\n"); 
		query.append("	, MOC_LIC_NO" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("SELECT PROP_NO" ).append("\n"); 
		query.append("     , AMDT_SEQ" ).append("\n"); 
		query.append("     , PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("     , CUST_CNT_CD" ).append("\n"); 
		query.append("     , CUST_SEQ" ).append("\n"); 
		query.append("     , CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("     , CTRT_CUST_SREP_CD" ).append("\n"); 
		query.append("     , CTRT_CUST_SLS_OFC_CD" ).append("\n"); 
		query.append("     , CTRT_PTY_NM" ).append("\n"); 
		query.append("     , CTRT_PTY_ADDR" ).append("\n"); 
		query.append("     , CTRT_PTY_SGN_NM" ).append("\n"); 
		query.append("     , CTRT_PTY_SGN_TIT_NM" ).append("\n"); 
		query.append("     , PRC_PROG_STS_CD" ).append("\n"); 
		query.append("     , SRC_INFO_CD" ).append("\n"); 
		query.append("     , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , OTI_LIC_ATCH_FILE_ID" ).append("\n"); 
		query.append("     , OTI_BD_ATCH_FILE_ID" ).append("\n"); 
		query.append("     , TRF_TIT_ATCH_FILE_ID" ).append("\n"); 
		query.append("     , POA_ATCH_FILE_ID" ).append("\n"); 
		query.append("	 , MOC_LIC_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append("         , 0 AS AMDT_SEQ" ).append("\n"); 
		query.append("         , PT.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("         , PT.CUST_CNT_CD" ).append("\n"); 
		query.append("         , PT.CUST_SEQ" ).append("\n"); 
		query.append("         , MD.VBS_CLSS_CD AS CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("         , MD.SREP_CD AS CTRT_CUST_SREP_CD" ).append("\n"); 
		query.append("         , MD.OFC_CD AS CTRT_CUST_SLS_OFC_CD" ).append("\n"); 
		query.append("         , PT.CTRT_PTY_NM" ).append("\n"); 
		query.append("         , PT.CTRT_PTY_ADDR" ).append("\n"); 
		query.append("         , PT.CTRT_PTY_SGN_NM" ).append("\n"); 
		query.append("         , PT.CTRT_PTY_SGN_TIT_NM" ).append("\n"); 
		query.append("         , 'I' AS PRC_PROG_STS_CD" ).append("\n"); 
		query.append("         , 'PC' AS SRC_INFO_CD" ).append("\n"); 
		query.append("         , 0 AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("         , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("         , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("         , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("         , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("         , OTI_LIC_ATCH_FILE_ID" ).append("\n"); 
		query.append("         , OTI_BD_ATCH_FILE_ID" ).append("\n"); 
		query.append("         , TRF_TIT_ATCH_FILE_ID" ).append("\n"); 
		query.append("         , POA_ATCH_FILE_ID" ).append("\n"); 
		query.append("		 , MOC_LIC_NO" ).append("\n"); 
		query.append("    FROM PRI_SP_CTRT_PTY PT" ).append("\n"); 
		query.append("       , MDM_CUSTOMER MD" ).append("\n"); 
		query.append("    WHERE PT.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   PT.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PT.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("    AND   PT.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("    AND   MD.CUST_CNT_CD = PT.CUST_CNT_CD" ).append("\n"); 
		query.append("    AND   MD.CUST_SEQ = PT.CUST_SEQ" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append("         , 0 AS AMDT_SEQ" ).append("\n"); 
		query.append("         , PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("         , CUST_CNT_CD" ).append("\n"); 
		query.append("         , CUST_SEQ" ).append("\n"); 
		query.append("         , CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("         , CTRT_CUST_SREP_CD" ).append("\n"); 
		query.append("         , CTRT_CUST_SLS_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,     DECODE(SUBSTR(@[srep_cd],1,2),'SG','SM Line Corporation(SG) PTE, LTD as Agent for SM Line Corporation.'," ).append("\n"); 
		query.append("                                        'ID','SM Line Corporation(India) Private Limited as Agent for SM Line Corporation.'," ).append("\n"); 
		query.append("                                        'SM Line Corporation')" ).append("\n"); 
		query.append("	  " ).append("\n"); 
		query.append("	,    (select NVL(OFC_ADDR,'Please Input') from MDM_ORGANIZATION where   OFC_CD =  DECODE(@[cnt_cd],'CN',DECODE( @[ofc_cd],'HKGSC',@[ofc_cd],'SELHO'),DECODE( @[ofc_cd],'LGBSC','PHXSA','NYCSC','PHXSA',@[ofc_cd]) )  ) as OFC_ADDR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,    DECODE(PTY.CTRT_PTY_SGN_NM, NULL,'Please Input',PTY.CTRT_PTY_SGN_NM)" ).append("\n"); 
		query.append("	,    DECODE(PTY.CTRT_PTY_SGN_TIT_NM, NULL,'Please Input',CTRT_PTY_SGN_TIT_NM)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("         , 'I' AS PRC_PROG_STS_CD" ).append("\n"); 
		query.append("         , 'PC' AS SRC_INFO_CD" ).append("\n"); 
		query.append("         , 0 AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("         , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("         , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("         , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("         , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("         , OTI_LIC_ATCH_FILE_ID" ).append("\n"); 
		query.append("         , OTI_BD_ATCH_FILE_ID" ).append("\n"); 
		query.append("         , TRF_TIT_ATCH_FILE_ID" ).append("\n"); 
		query.append("         , POA_ATCH_FILE_ID" ).append("\n"); 
		query.append("		 , MOC_LIC_NO" ).append("\n"); 
		query.append("    FROM PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_CTRT_PTY_TP_CD = 'H'" ).append("\n"); 
		query.append("    AND   SRC_INFO_CD <> 'AD' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}