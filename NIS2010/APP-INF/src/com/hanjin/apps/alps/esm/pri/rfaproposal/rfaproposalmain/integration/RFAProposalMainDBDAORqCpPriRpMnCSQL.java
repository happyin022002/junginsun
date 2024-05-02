/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAProposalMainDBDAORqCpPriRpMnCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.04.16 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAORqCpPriRpMnCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RqCpPriRpMn
	  * </pre>
	  */
	public RFAProposalMainDBDAORqCpPriRpMnCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORqCpPriRpMnCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_MN (" ).append("\n"); 
		query.append("    PROP_NO" ).append("\n"); 
		query.append("    ,AMDT_SEQ" ).append("\n"); 
		query.append("    ,EFF_DT" ).append("\n"); 
		query.append("    ,EXP_DT" ).append("\n"); 
		query.append("    ,CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("    ,CTRT_CUST_SEQ" ).append("\n"); 
		query.append("    ,PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("    ,CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("    ,PROP_SREP_CD" ).append("\n"); 
		query.append("    ,PROP_OFC_CD" ).append("\n"); 
		query.append("    ,PROP_APRO_OFC_CD" ).append("\n"); 
		query.append("    ,PROP_APRO_DT" ).append("\n"); 
		query.append("    ,PROP_STS_CD" ).append("\n"); 
		query.append("    ,RESPB_SREP_CD" ).append("\n"); 
		query.append("    ,RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("    ,CNTR_LOD_UT_CD" ).append("\n"); 
		query.append("    ,TGT_MVC_QTY" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT)" ).append("\n"); 
		query.append("WITH CUST AS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    CUST.CUST_CNT_CD ," ).append("\n"); 
		query.append("    CUST.CUST_SEQ    ," ).append("\n"); 
		query.append("    CUST.RVIS_CNTR_CUST_TP_CD	AS PRC_CTRT_CUST_TP_CD  ," ).append("\n"); 
		query.append("    CUST.VBS_CLSS_CD		AS CTRT_CUST_VAL_SGM_CD                ," ).append("\n"); 
		query.append("    MDM.INTG_CD_VAL_DP_DESC	AS CTRT_CUST_VAL_SGM            ," ).append("\n"); 
		query.append("    CUST.SREP_CD		AS RESPB_SREP_CD                       ," ).append("\n"); 
		query.append("    CUST.OFC_CD			AS RESPB_SLS_OFC_CD                   " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    MDM_CUSTOMER CUST   ," ).append("\n"); 
		query.append("    MDM_CUST_ADDR ADDR  ," ).append("\n"); 
		query.append("    COM_INTG_CD_DTL MDM ," ).append("\n"); 
		query.append("    MDM_SLS_REP SREP    ," ).append("\n"); 
		query.append("    COM_INTG_CD_DTL CUST_TY," ).append("\n"); 
		query.append("    PRI_RQ_MN MN" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CUST.CUST_CNT_CD    = MN.CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST.CUST_SEQ   = MN.CUST_SEQ" ).append("\n"); 
		query.append("AND CUST.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("AND CUST.CUST_CNT_CD        = ADDR.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND CUST.CUST_SEQ           = ADDR.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND ADDR.PRMRY_CHK_FLG      = 'Y'" ).append("\n"); 
		query.append("AND MDM.INTG_CD_ID(+)          = 'CD00698'" ).append("\n"); 
		query.append("AND MDM.INTG_CD_VAL_CTNT(+)    = CUST.VBS_CLSS_CD" ).append("\n"); 
		query.append("AND CUST.SREP_CD    = SREP.SREP_CD" ).append("\n"); 
		query.append("AND CUST_TY.INTG_CD_ID      = 'CD00697'" ).append("\n"); 
		query.append("AND CUST.RVIS_CNTR_CUST_TP_CD = CUST_TY.INTG_CD_VAL_CTNT " ).append("\n"); 
		query.append("AND MN.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND MN.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT   @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append("    ,0 AS AMDT_SEQ" ).append("\n"); 
		query.append("    ,B.EFF_DT" ).append("\n"); 
		query.append("    ,B.EXP_DT" ).append("\n"); 
		query.append("    ,B.CUST_CNT_CD" ).append("\n"); 
		query.append("    ,B.CUST_SEQ" ).append("\n"); 
		query.append("    ,B.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("    ,C.CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("    ,B.QTTN_SREP_CD" ).append("\n"); 
		query.append("    ,@[qttn_ofc_cd]" ).append("\n"); 
		query.append("    ,NULL" ).append("\n"); 
		query.append("    ,NULL" ).append("\n"); 
		query.append("    ,'I'" ).append("\n"); 
		query.append("    ,C.RESPB_SREP_CD" ).append("\n"); 
		query.append("    ,C.RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("    ,B.CNTR_LOD_UT_CD" ).append("\n"); 
		query.append("    ,B.ESTM_MQC_QTY" ).append("\n"); 
		query.append("    ,@[cre_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[upd_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("FROM	PRI_RQ_HDR A" ).append("\n"); 
		query.append("	,	PRI_RQ_MN B" ).append("\n"); 
		query.append("	,	CUST C" ).append("\n"); 
		query.append("WHERE	A.QTTN_NO = B.QTTN_NO" ).append("\n"); 
		query.append("AND	B.QTTN_NO = @[qttn_no] " ).append("\n"); 
		query.append("AND	B.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND	B.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("AND	B.CUST_SEQ = C.CUST_SEQ" ).append("\n"); 

	}
}