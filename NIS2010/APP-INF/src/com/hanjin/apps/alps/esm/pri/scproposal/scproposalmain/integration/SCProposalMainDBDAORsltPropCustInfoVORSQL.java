/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCProposalMainDBDAORsltPropCustInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.08
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2011.11.08 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltPropCustInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltPropCustInfoVO
	  * </pre>
	  */
	public SCProposalMainDBDAORsltPropCustInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltPropCustInfoVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    CUST.CUST_CNT_CD                                					" ).append("\n"); 
		query.append("    ,CUST.CUST_SEQ                                   					" ).append("\n"); 
		query.append("    ,DECODE(CUST.RVIS_CNTR_CUST_TP_CD,'N','N','I') PRC_CTRT_CUST_TP_CD 	" ).append("\n"); 
		query.append("    ,CUST.CUST_LGL_ENG_NM CTRT_PTY_NM                					" ).append("\n"); 
		query.append("    ,ADDR.BZET_ADDR ||' '||ADDR.CTY_NM||DECODE(ADDR.STE_CD||ADDR.ZIP_CD,'','',', '||ADDR.STE_CD||' '||ADDR.ZIP_CD) CTRT_PTY_ADDR                    					" ).append("\n"); 
		query.append("    ,CUST.VBS_CLSS_CD CTRT_CUST_VAL_SGM_CD           					" ).append("\n"); 
		query.append("    ,MDM.INTG_CD_VAL_DP_DESC CTRT_CUST_VAL_SGM       					" ).append("\n"); 
		query.append("    ,CUST.SREP_CD CTRT_CUST_SREP_CD                  					" ).append("\n"); 
		query.append("	,SREP.SREP_NM CTRT_CUST_SREP_NM										" ).append("\n"); 
		query.append("    ,CUST.OFC_CD CTRT_CUST_SLS_OFC_CD                					" ).append("\n"); 
		query.append("    ,DECODE(PTY.CTRT_PTY_SGN_NM, NULL,'Please Input',PTY.CTRT_PTY_SGN_NM) CTRT_PTY_SGN_NM                              					" ).append("\n"); 
		query.append("    ,DECODE(PTY.CTRT_PTY_SGN_TIT_NM, NULL,'Please Input',CTRT_PTY_SGN_TIT_NM) CTRT_PTY_SGN_TIT_NM" ).append("\n"); 
		query.append("	,CUST.OTI_ORZ_NO OTI_NO" ).append("\n"); 
		query.append("	,CUST.NVOCC_BD_ST_EFF_DT OTI_EFF_DT" ).append("\n"); 
		query.append("	,CUST.NVOCC_BD_END_EFF_DT OTI_EXP_DT" ).append("\n"); 
		query.append("	,CUST.NVOCC_BD_AMT OTI_AMT" ).append("\n"); 
		query.append("	,CUST.NVOCC_LIC_NO OTI_LIC_NO" ).append("\n"); 
		query.append("	,CUST.LOC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    MDM_CUSTOMER CUST   ," ).append("\n"); 
		query.append("    MDM_CUST_ADDR ADDR  ," ).append("\n"); 
		query.append("    COM_INTG_CD_DTL MDM ," ).append("\n"); 
		query.append("	MDM_SLS_REP SREP," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT PTY.CTRT_PTY_SGN_NM" ).append("\n"); 
		query.append("          ,PTY.CTRT_PTY_SGN_TIT_NM" ).append("\n"); 
		query.append("          ,PROP_OFC_CD" ).append("\n"); 
		query.append("		  ,CUST_CNT_CD" ).append("\n"); 
		query.append("    FROM   PRI_SP_MN MN" ).append("\n"); 
		query.append("          ,PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("    WHERE  MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("    AND    MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("    AND    MN.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("    AND    MN.PROP_OFC_CD = @[prop_ofc_cd]" ).append("\n"); 
		query.append("    AND    PTY.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("    AND    PTY.CUST_SEQ    = @[cust_seq]" ).append("\n"); 
		query.append("    AND    PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("    AND    PTY.UPD_DT =" ).append("\n"); 
		query.append("              (SELECT MAX (PTY.UPD_DT)" ).append("\n"); 
		query.append("               FROM   PRI_SP_MN MN" ).append("\n"); 
		query.append("                     ,PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("               WHERE  MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("               AND    MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("               AND    MN.PROP_STS_CD  = 'F'" ).append("\n"); 
		query.append("               AND    MN.PROP_OFC_CD  = @[prop_ofc_cd]" ).append("\n"); 
		query.append("               AND    PTY.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("               AND    PTY.CUST_SEQ    = @[cust_seq]" ).append("\n"); 
		query.append("               AND    PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("                ) " ).append("\n"); 
		query.append("	AND   ROWNUM = 1" ).append("\n"); 
		query.append("	)PTY  " ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    CUST.CUST_CNT_CD        = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND CUST.CUST_SEQ           = @[cust_seq]" ).append("\n"); 
		query.append("AND CUST.DELT_FLG			= 'N'" ).append("\n"); 
		query.append("AND CUST.CNTR_DIV_FLG 		= 'Y'" ).append("\n"); 
		query.append("AND (CUST.NMD_CUST_FLG       <> 'Y' OR CUST.NMD_CUST_FLG IS NULL)" ).append("\n"); 
		query.append("AND CUST.CUST_CNT_CD        = ADDR.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND CUST.CUST_SEQ           = ADDR.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND ADDR.PRMRY_CHK_FLG(+)   = 'Y'" ).append("\n"); 
		query.append("AND MDM.INTG_CD_ID(+)       = 'CD00698'" ).append("\n"); 
		query.append("AND MDM.INTG_CD_VAL_CTNT(+) = CUST.VBS_CLSS_CD" ).append("\n"); 
		query.append("AND CUST.SREP_CD 			= SREP.SREP_CD(+)" ).append("\n"); 
		query.append("AND (CUST.SLS_DELT_EFF_DT IS NULL OR CUST.SLS_DELT_EFF_DT > TO_CHAR(SYSDATE,'yyyy-MM-dd'))" ).append("\n"); 
		query.append("AND CUST.CUST_CNT_CD = PTY.CUST_CNT_CD(+)" ).append("\n"); 

	}
}