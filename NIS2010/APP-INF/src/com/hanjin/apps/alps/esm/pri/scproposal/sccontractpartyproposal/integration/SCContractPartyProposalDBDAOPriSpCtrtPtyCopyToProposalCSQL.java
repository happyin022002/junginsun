/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SCContractPartyProposalDBDAOPriSpCtrtPtyCopyToProposalCSQL.java
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

public class SCContractPartyProposalDBDAOPriSpCtrtPtyCopyToProposalCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PriSpCtrtPtyCopyToProposal
	  * </pre>
	  */
	public SCContractPartyProposalDBDAOPriSpCtrtPtyCopyToProposalCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.integration").append("\n"); 
		query.append("FileName : SCContractPartyProposalDBDAOPriSpCtrtPtyCopyToProposalCSQL").append("\n"); 
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
		query.append("     PROP_NO" ).append("\n"); 
		query.append(",    AMDT_SEQ" ).append("\n"); 
		query.append(",    PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append(",    CUST_CNT_CD" ).append("\n"); 
		query.append(",    CUST_SEQ" ).append("\n"); 
		query.append(",    CTRT_PTY_NM" ).append("\n"); 
		query.append(",    CTRT_PTY_ADDR" ).append("\n"); 
		query.append(",    CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append(",    CTRT_CUST_SREP_CD" ).append("\n"); 
		query.append(",    CTRT_CUST_SLS_OFC_CD" ).append("\n"); 
		query.append(",    CTRT_PTY_SGN_NM" ).append("\n"); 
		query.append(",    CTRT_PTY_SGN_TIT_NM" ).append("\n"); 
		query.append(",    PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",    SRC_INFO_CD" ).append("\n"); 
		query.append(",    N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(",    CRE_USR_ID" ).append("\n"); 
		query.append(",    CRE_DT" ).append("\n"); 
		query.append(",    UPD_USR_ID" ).append("\n"); 
		query.append(",    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     @[new_prop_no]" ).append("\n"); 
		query.append(",    0 " ).append("\n"); 
		query.append(",    'H'" ).append("\n"); 
		query.append(",	 NULL" ).append("\n"); 
		query.append(",	 NULL" ).append("\n"); 
		query.append(",    DECODE(SUBSTR(@[qttn_srep_cd],1,2),'SG','SM Line Corporation(SG) PTE, LTD as Agent for SM Line Corporation.'," ).append("\n"); 
		query.append("                                        'ID','SM Line Corporation(India) Private Limited as Agent for SM Line Corporation.'," ).append("\n"); 
		query.append("                                        'SM Line Corporation')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",    (select NVL(MO.OFC_ADDR,'Please Input') from MDM_ORGANIZATION MO where   MO.OFC_CD =  DECODE(@[cnt_cd],'CN',DECODE( @[qttn_ofc_cd],'HKGSC',@[qttn_ofc_cd],'SELHO'),DECODE( @[qttn_ofc_cd],'LGBSC','PHXSA','NYCSC','PHXSA',@[qttn_ofc_cd]) )  ) as OFC_ADDR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",    NULL" ).append("\n"); 
		query.append(",    NULL" ).append("\n"); 
		query.append(",    NULL" ).append("\n"); 
		query.append(",    NVL(PTY.CTRT_PTY_SGN_NM, 'PLEASE INPUT') AS CTRT_PTY_SGN_NM" ).append("\n"); 
		query.append(",    NVL(PTY.CTRT_PTY_SGN_TIT_NM, 'PLEASE INPUT') AS CTRT_PTY_SGN_TIT_NM" ).append("\n"); 
		query.append(",    'I'" ).append("\n"); 
		query.append(",    'PC'" ).append("\n"); 
		query.append(",    0 AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(",    @[cre_usr_id]" ).append("\n"); 
		query.append(",    sysdate" ).append("\n"); 
		query.append(",    @[upd_usr_id]" ).append("\n"); 
		query.append(",    sysdate" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("   ,(" ).append("\n"); 
		query.append("    SELECT PTY.CTRT_PTY_SGN_NM" ).append("\n"); 
		query.append("          ,PTY.CTRT_PTY_SGN_TIT_NM" ).append("\n"); 
		query.append("          ,PROP_OFC_CD" ).append("\n"); 
		query.append("    FROM   PRI_SP_MN MN" ).append("\n"); 
		query.append("          ,PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("    WHERE  PROP_OFC_CD = @[qttn_ofc_cd]" ).append("\n"); 
		query.append("    AND    MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("    AND    MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("    AND    PTY.PRC_CTRT_PTY_TP_CD = 'H'" ).append("\n"); 
		query.append("    AND    PTY.UPD_DT = (SELECT MAX (PTY.UPD_DT)" ).append("\n"); 
		query.append("                        FROM   PRI_SP_MN MN" ).append("\n"); 
		query.append("                              ,PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("                        WHERE  PROP_OFC_CD = @[qttn_ofc_cd]" ).append("\n"); 
		query.append("                        AND    MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("                        AND    MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("                        AND    PTY.PRC_CTRT_PTY_TP_CD = 'H')" ).append("\n"); 
		query.append("    )PTY" ).append("\n"); 
		query.append("WHERE ORG.OFC_CD = @[qttn_ofc_cd]" ).append("\n"); 
		query.append("AND   PTY.PROP_OFC_CD (+) = ORG.OFC_CD" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  @[new_prop_no]" ).append("\n"); 
		query.append(",    0" ).append("\n"); 
		query.append(",    'C'" ).append("\n"); 
		query.append(",    CUST.CUST_CNT_CD                                					" ).append("\n"); 
		query.append("    ,CUST.CUST_SEQ                                   					" ).append("\n"); 
		query.append("    ,CUST.CUST_LGL_ENG_NM CTRT_PTY_NM                					" ).append("\n"); 
		query.append("    ,ADDR.BZET_ADDR CTRT_PTY_ADDR                    					" ).append("\n"); 
		query.append("    ,CUST.VBS_CLSS_CD CTRT_CUST_VAL_SGM_CD           					    					" ).append("\n"); 
		query.append("    ,CUST.SREP_CD CTRT_CUST_SREP_CD                  														" ).append("\n"); 
		query.append("    ,CUST.OFC_CD CTRT_CUST_SLS_OFC_CD    " ).append("\n"); 
		query.append(",    NVL(PTY.CTRT_PTY_SGN_NM, 'PLEASE INPUT') AS CTRT_PTY_SGN_NM" ).append("\n"); 
		query.append(",    NVL(PTY.CTRT_PTY_SGN_TIT_NM, 'PLEASE INPUT') AS CTRT_PTY_SGN_TIT_NM" ).append("\n"); 
		query.append(",    'I'" ).append("\n"); 
		query.append(",    'PC'" ).append("\n"); 
		query.append(",    0 AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(",    @[cre_usr_id]" ).append("\n"); 
		query.append(",    sysdate" ).append("\n"); 
		query.append(",    @[upd_usr_id]" ).append("\n"); 
		query.append(",    sysdate" ).append("\n"); 
		query.append("FROM PRI_SQ_MN MN	," ).append("\n"); 
		query.append("     MDM_CUSTOMER CUST   ," ).append("\n"); 
		query.append("     MDM_CUST_ADDR ADDR  ," ).append("\n"); 
		query.append("	 MDM_SLS_REP SREP    ," ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT PTY.CTRT_PTY_SGN_NM" ).append("\n"); 
		query.append("      			,PTY.CTRT_PTY_SGN_TIT_NM" ).append("\n"); 
		query.append("      			,PTY.CUST_CNT_CD, PTY.CUST_SEQ " ).append("\n"); 
		query.append("		FROM    PRI_SP_MN MN" ).append("\n"); 
		query.append("      			,PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("      			,PRI_SQ_MN  MN2" ).append("\n"); 
		query.append("		WHERE  MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("		AND    MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("		AND    MN.PROP_STS_CD IN ( 'A', 'F')" ).append("\n"); 
		query.append("		AND    MN.PROP_OFC_CD = @[qttn_ofc_cd]" ).append("\n"); 
		query.append("		AND    PTY.CUST_CNT_CD = MN2.CUST_CNT_CD" ).append("\n"); 
		query.append("		AND    PTY.CUST_SEQ = MN2.CUST_SEQ" ).append("\n"); 
		query.append("		AND	   MN2.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("		AND	   MN2.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("		AND    PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("		AND    PTY.UPD_DT =" ).append("\n"); 
		query.append("          		(SELECT MAX (PTY.UPD_DT)" ).append("\n"); 
		query.append("           		 FROM   PRI_SP_MN MN" ).append("\n"); 
		query.append("            		   ,PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("           		       ,PRI_SQ_MN  MN2" ).append("\n"); 
		query.append("          		 WHERE  MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("           		 AND    MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("		  		 AND    MN.PROP_STS_CD IN ( 'A', 'F')" ).append("\n"); 
		query.append("		  		 AND    MN.PROP_OFC_CD = @[qttn_ofc_cd]" ).append("\n"); 
		query.append("		  		 AND    PTY.CUST_CNT_CD = MN2.CUST_CNT_CD" ).append("\n"); 
		query.append("           		 AND    PTY.CUST_SEQ = MN2.CUST_SEQ" ).append("\n"); 
		query.append("          		 AND	MN2.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("           		 AND	MN2.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("           		 AND    PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("				) " ).append("\n"); 
		query.append("		AND   ROWNUM = 1" ).append("\n"); 
		query.append("	) PTY" ).append("\n"); 
		query.append("WHERE MN.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND	MN.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND MN.CUST_CNT_CD          = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("AND MN.CUST_SEQ             = CUST.CUST_SEQ" ).append("\n"); 
		query.append("AND CUST.DELT_FLG			= 'N'" ).append("\n"); 
		query.append("AND CUST.CNTR_DIV_FLG 		= 'Y'" ).append("\n"); 
		query.append("AND CUST.CUST_CNT_CD        = ADDR.CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST.CUST_SEQ           = ADDR.CUST_SEQ" ).append("\n"); 
		query.append("AND ADDR.PRMRY_CHK_FLG      = 'Y'" ).append("\n"); 
		query.append("AND CUST.SREP_CD 			= SREP.SREP_CD" ).append("\n"); 
		query.append("AND MN.CUST_CNT_CD          = PTY.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND MN.CUST_SEQ             = PTY.CUST_SEQ(+)" ).append("\n"); 

	}
}