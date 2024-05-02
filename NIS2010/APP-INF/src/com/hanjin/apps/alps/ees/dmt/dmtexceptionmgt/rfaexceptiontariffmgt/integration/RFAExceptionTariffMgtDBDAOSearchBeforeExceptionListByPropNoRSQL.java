/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchBeforeExceptionListByPropNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOSearchBeforeExceptionListByPropNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal No. 에 해당되는 DAR History 를 조회하는 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchBeforeExceptionListByPropNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchBeforeExceptionListByPropNoRSQL").append("\n"); 
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
		query.append("SELECT	DAR_HIST.RFA_NO" ).append("\n"); 
		query.append(",	DAR_HIST.APRO_OFC_CD" ).append("\n"); 
		query.append(",	DAR_HIST.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	DAR_HIST.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",	DAR_HIST.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	DAR_HIST.RFA_EXPT_APRO_NO" ).append("\n"); 
		query.append(",	DAR_HIST.DMDT_EXPT_RQST_STS_DESC" ).append("\n"); 
		query.append(",	DAR_HIST.REQ_OFC_CD" ).append("\n"); 
		query.append(",	REQ_USER.USR_NM AS REQ_USR_NM" ).append("\n"); 
		query.append(",	DAR_HIST.REQ_DT" ).append("\n"); 
		query.append(",	DAR_HIST.APVL_OFC_CD" ).append("\n"); 
		query.append(",	ACCT_USER.USR_NM AS APVL_USR_NM" ).append("\n"); 
		query.append(",	DAR_HIST.APVL_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  RP_HDR.RFA_NO" ).append("\n"); 
		query.append(",   RFA_TRF.APRO_OFC_CD" ).append("\n"); 
		query.append(",   RFA_TRF.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	RFA_TRF.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",   LPAD(RFA_TRF.RFA_EXPT_VER_SEQ, 3, '0') RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",   RFA_TRF.RFA_EXPT_APRO_NO" ).append("\n"); 
		query.append(",   COM_DTL.INTG_CD_VAL_DP_DESC DMDT_EXPT_RQST_STS_DESC" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_DESC(DMT_RFA_EXPT_TRF_PROG XPKDMT_RFA_EXPT_TRF_PROG) */ PROG_OFC_CD" ).append("\n"); 
		query.append("FROM    DMT_RFA_EXPT_TRF_PROG" ).append("\n"); 
		query.append("WHERE   RFA_EXPT_DAR_NO = RFA_TRF.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND RFA_EXPT_MAPG_SEQ = RFA_TRF.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND RFA_EXPT_VER_SEQ = RFA_TRF.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND DMDT_EXPT_RQST_STS_CD = 'R'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") REQ_OFC_CD" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_DESC(DMT_RFA_EXPT_TRF_PROG XPKDMT_RFA_EXPT_TRF_PROG) */ PROG_USR_ID" ).append("\n"); 
		query.append("FROM    DMT_RFA_EXPT_TRF_PROG" ).append("\n"); 
		query.append("WHERE   RFA_EXPT_DAR_NO = RFA_TRF.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND RFA_EXPT_MAPG_SEQ = RFA_TRF.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND RFA_EXPT_VER_SEQ = RFA_TRF.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND DMDT_EXPT_RQST_STS_CD = 'R'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") REQ_USR_ID" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_DESC(DMT_RFA_EXPT_TRF_PROG XPKDMT_RFA_EXPT_TRF_PROG) */ TO_CHAR(PROG_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("FROM    DMT_RFA_EXPT_TRF_PROG" ).append("\n"); 
		query.append("WHERE   RFA_EXPT_DAR_NO = RFA_TRF.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND RFA_EXPT_MAPG_SEQ = RFA_TRF.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND RFA_EXPT_VER_SEQ = RFA_TRF.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND DMDT_EXPT_RQST_STS_CD = 'R'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") REQ_DT" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_DESC(DMT_RFA_EXPT_TRF_PROG XPKDMT_RFA_EXPT_TRF_PROG) */ PROG_OFC_CD" ).append("\n"); 
		query.append("FROM    DMT_RFA_EXPT_TRF_PROG" ).append("\n"); 
		query.append("WHERE   RFA_EXPT_DAR_NO = RFA_TRF.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND RFA_EXPT_MAPG_SEQ = RFA_TRF.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND RFA_EXPT_VER_SEQ = RFA_TRF.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND DMDT_EXPT_RQST_STS_CD IN ('A','O','J')" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") APVL_OFC_CD" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_DESC(DMT_RFA_EXPT_TRF_PROG XPKDMT_RFA_EXPT_TRF_PROG) */ PROG_USR_ID" ).append("\n"); 
		query.append("FROM    DMT_RFA_EXPT_TRF_PROG" ).append("\n"); 
		query.append("WHERE   RFA_EXPT_DAR_NO = RFA_TRF.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND RFA_EXPT_MAPG_SEQ = RFA_TRF.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND RFA_EXPT_VER_SEQ = RFA_TRF.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND DMDT_EXPT_RQST_STS_CD IN ('A','O','J')" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") APVL_USR_ID" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_DESC(DMT_RFA_EXPT_TRF_PROG XPKDMT_RFA_EXPT_TRF_PROG) */ TO_CHAR(PROG_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("FROM    DMT_RFA_EXPT_TRF_PROG" ).append("\n"); 
		query.append("WHERE   RFA_EXPT_DAR_NO = RFA_TRF.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND RFA_EXPT_MAPG_SEQ = RFA_TRF.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND RFA_EXPT_VER_SEQ = RFA_TRF.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND DMDT_EXPT_RQST_STS_CD IN ('A','O','J')" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") APVL_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    PRI_RP_HDR RP_HDR" ).append("\n"); 
		query.append(",   DMT_RFA_EXPT_TRF RFA_TRF" ).append("\n"); 
		query.append(",   COM_INTG_CD_DTL COM_DTL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   RP_HDR.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND RP_HDR.PROP_NO = RFA_TRF.PROP_NO" ).append("\n"); 
		query.append("#if(${is_temp} == 'N')" ).append("\n"); 
		query.append("AND RFA_TRF.DMDT_EXPT_RQST_STS_CD != 'T'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND RFA_TRF.DMDT_EXPT_RQST_STS_CD = COM_DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND COM_DTL.INTG_CD_ID = 'CD02069'" ).append("\n"); 
		query.append(")	DAR_HIST" ).append("\n"); 
		query.append(",	COM_USER REQ_USER" ).append("\n"); 
		query.append(",	COM_USER ACCT_USER" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	DAR_HIST.REQ_USR_ID = REQ_USER.USR_ID(+)" ).append("\n"); 
		query.append("AND	DAR_HIST.APVL_USR_ID = ACCT_USER.USR_ID(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY RFA_NO, APRO_OFC_CD, RFA_EXPT_DAR_NO ASC, RFA_EXPT_VER_SEQ DESC" ).append("\n"); 

	}
}