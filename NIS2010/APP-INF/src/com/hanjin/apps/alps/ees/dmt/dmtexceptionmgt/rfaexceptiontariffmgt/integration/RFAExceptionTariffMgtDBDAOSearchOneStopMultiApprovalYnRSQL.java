/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchOneStopMultiApprovalYnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2015.08.12 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOSearchOneStopMultiApprovalYnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAExceptionTariffMgtDBDAOSearchOneStopMultiApprovalYnRSQL
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchOneStopMultiApprovalYnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchOneStopMultiApprovalYnRSQL").append("\n"); 
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
		query.append("select  case when sum(MULTI_APRO_YN) = 3 then 'Y' else 'N' end as MULTI_APRO_YN" ).append("\n"); 
		query.append("  from  (" ).append("\n"); 
		query.append("			-- 요청자의 Branch Office 가 SELSC, TYOSC 여부체크" ).append("\n"); 
		query.append("			select  case when OFC_N4TH_LVL_CD in ('SELSC', 'TYOSC') then 1 else 0 end as MULTI_APRO_YN" ).append("\n"); 
		query.append("			  from  DMT_OFC_LVL_V" ).append("\n"); 
		query.append("			 where  OFC_N8TH_LVL_CD = " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						select  PROG_OFC_CD" ).append("\n"); 
		query.append("						  from  DMT_RFA_EXPT_TRF_PROG T" ).append("\n"); 
		query.append("						 where  RFA_EXPT_DAR_NO   =  @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("						   and  RFA_EXPT_MAPG_SEQ = to_number(@[rfa_expt_mapg_seq])" ).append("\n"); 
		query.append("						   and  RFA_EXPT_VER_SEQ  = to_number(@[rfa_expt_ver_seq])" ).append("\n"); 
		query.append("						   and  PROG_SEQ          = " ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									select  max(PROG_SEQ)" ).append("\n"); 
		query.append("									  from  DMT_RFA_EXPT_TRF_PROG" ).append("\n"); 
		query.append("									 where  RFA_EXPT_DAR_NO        = T.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("									   and  RFA_EXPT_VER_SEQ       = T.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("									   and  RFA_EXPT_MAPG_SEQ      = T.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("									   and  DMDT_EXPT_RQST_STS_CD in ('T', 'R')" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			union all		" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("			-- 승인경로에 미승인상태의 원스톱 대상 승인경로가 모두 존재하는지 체크" ).append("\n"); 
		query.append("			select  case when count(1) = 2 then 1 else 0 end as MULTI_APRO_YN" ).append("\n"); 
		query.append("			  from  DMT_RFA_EXPT_APRO_PATH" ).append("\n"); 
		query.append("			 where  RFA_EXPT_DAR_NO   =  @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("			   and  RFA_EXPT_MAPG_SEQ = to_number(@[rfa_expt_mapg_seq])" ).append("\n"); 
		query.append("			   and  RFA_EXPT_VER_SEQ  = to_number(@[rfa_expt_ver_seq])" ).append("\n"); 
		query.append("			   and  DMDT_EXPT_APRO_PATH_CD in ('BBG', 'V.P')" ).append("\n"); 
		query.append("			   and  APRO_FLG          = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			union all" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			-- 사용자가 원스톱 대상 승인경로의 승인권자인지 여부 체크" ).append("\n"); 
		query.append("			select  case when count(1) = 2 then 1 else 0 end as MULTI_APRO_YN" ).append("\n"); 
		query.append("			  from  DMT_RFA_EXPT_APRO_PATH_USR " ).append("\n"); 
		query.append("			 where  RFA_EXPT_DAR_NO   =  @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("			   and  RFA_EXPT_MAPG_SEQ = to_number(@[rfa_expt_mapg_seq])" ).append("\n"); 
		query.append("			   and  RFA_EXPT_VER_SEQ  = to_number(@[rfa_expt_ver_seq])" ).append("\n"); 
		query.append("			   and  DMDT_EXPT_APRO_PATH_CD in ('BBG', 'V.P')" ).append("\n"); 
		query.append("			   and  APRO_USR_ID       = @[apro_usr_id]" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}