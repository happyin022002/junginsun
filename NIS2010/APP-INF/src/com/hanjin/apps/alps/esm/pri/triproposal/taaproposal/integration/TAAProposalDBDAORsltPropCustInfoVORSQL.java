/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TAAProposalDBDAORsltPropCustInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.12.11 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TAAProposalDBDAORsltPropCustInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltPropCustInfoVO
	  * </pre>
	  */
	public TAAProposalDBDAORsltPropCustInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration").append("\n"); 
		query.append("FileName : TAAProposalDBDAORsltPropCustInfoVORSQL").append("\n"); 
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
		query.append("SELECT CUST.CUST_CNT_CD" ).append("\n"); 
		query.append(", CUST.CUST_SEQ" ).append("\n"); 
		query.append(", CUST.RVIS_CNTR_CUST_TP_CD PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append(", CUST_TY.INTG_CD_VAL_DESC PRC_CTRT_CUST_TP_NM" ).append("\n"); 
		query.append(", CUST.CUST_LGL_ENG_NM CTRT_PTY_NM" ).append("\n"); 
		query.append(", ADDR.BZET_ADDR CTRT_PTY_ADDR" ).append("\n"); 
		query.append(", CUST.VBS_CLSS_CD CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append(", MDM.INTG_CD_VAL_DP_DESC CTRT_CUST_VAL_SGM" ).append("\n"); 
		query.append(", CUST.SREP_CD RESPB_SREP_CD" ).append("\n"); 
		query.append(", SREP.SREP_NM CTRT_CUST_SREP_NM" ).append("\n"); 
		query.append(", CUST.OFC_CD RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append(", '' CTRT_PTY_SGN_NM" ).append("\n"); 
		query.append(", '' CTRT_PTY_SGN_TIT_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER CUST" ).append("\n"); 
		query.append(", MDM_CUST_ADDR ADDR" ).append("\n"); 
		query.append(", COM_INTG_CD_DTL MDM" ).append("\n"); 
		query.append(", MDM_SLS_REP SREP" ).append("\n"); 
		query.append(", COM_INTG_CD_DTL CUST_TY" ).append("\n"); 
		query.append("WHERE CUST.CUST_CNT_CD        = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND   CUST.CUST_SEQ           = @[cust_seq]" ).append("\n"); 
		query.append("AND   CUST.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("AND   CUST.CNTR_DIV_FLG       = 'Y'" ).append("\n"); 
		query.append("AND   (CUST.NMD_CUST_FLG      <> 'Y' OR CUST.NMD_CUST_FLG IS NULL)" ).append("\n"); 
		query.append("AND   CUST.CUST_CNT_CD        = ADDR.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND   CUST.CUST_SEQ           = ADDR.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND   ADDR.PRMRY_CHK_FLG(+)   = 'Y'" ).append("\n"); 
		query.append("AND   MDM.INTG_CD_ID(+)       = 'CD00698'" ).append("\n"); 
		query.append("AND   MDM.INTG_CD_VAL_CTNT(+) = CUST.VBS_CLSS_CD" ).append("\n"); 
		query.append("AND   CUST.SREP_CD            = SREP.SREP_CD(+)" ).append("\n"); 
		query.append("AND   CUST_TY.INTG_CD_ID(+)   = 'CD00697'" ).append("\n"); 
		query.append("AND   CUST.RVIS_CNTR_CUST_TP_CD = CUST_TY.INTG_CD_VAL_CTNT(+)" ).append("\n"); 

	}
}