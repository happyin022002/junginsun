/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : MasterDataMgtDBDAOSearchMdmChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.28 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MasterDataMgtDBDAOSearchMdmChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_CHARGE 정보 조회
	  * </pre>
	  */
	public MasterDataMgtDBDAOSearchMdmChargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_sac_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.integration").append("\n"); 
		query.append("FileName : MasterDataMgtDBDAOSearchMdmChargeRSQL").append("\n"); 
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
		query.append("			A.CHG_CD" ).append("\n"); 
		query.append("			, A.CHG_NM" ).append("\n"); 
		query.append("			, A.FRT_CHG_TP_CD " ).append("\n"); 
		query.append("			, A.SEN_CHG_ACCT_CD" ).append("\n"); 
		query.append("			, A.HJS_CHG_ACCT_CD" ).append("\n"); 
		query.append("			, A.REP_CHG_CD" ).append("\n"); 
		query.append("			, A.CHG_REV_TP_CD" ).append("\n"); 
		query.append("			, A.CHG_APLY_TP_CD" ).append("\n"); 
		query.append("			, A.CHG_APLY_AREA_CD" ).append("\n"); 
		query.append("			, A.CY_RD_TERM_FLG" ).append("\n"); 
		query.append("			, A.CFS_RD_TERM_FLG" ).append("\n"); 
		query.append("			, A.DOR_RD_TERM_FLG" ).append("\n"); 
		query.append("			, A.NA_RD_TERM_FLG" ).append("\n"); 
		query.append("			, A.TKL_TML_FLG" ).append("\n"); 
		query.append("			, A.APLY_SVC_MOD_FLG" ).append("\n"); 
		query.append("			, A.USE_CO_TP_CD" ).append("\n"); 
		query.append("			, A.AUTO_RAT_FLG" ).append("\n"); 
		query.append("			, A.SEN_GRP_CHG_CD" ).append("\n"); 
		query.append("			, A.CHG_EDI_CD" ).append("\n"); 
		query.append("			, A.DP_SEQ" ).append("\n"); 
		query.append("			, A.CHG_STS_CD" ).append("\n"); 
		query.append("			, A.CRE_USR_ID" ).append("\n"); 
		query.append("			, A.CRE_DT" ).append("\n"); 
		query.append("			, A.UPD_USR_ID" ).append("\n"); 
		query.append("			, A.UPD_DT" ).append("\n"); 
		query.append("			, A.DELT_FLG" ).append("\n"); 
		query.append("			, A.EAI_EVNT_DT" ).append("\n"); 
		query.append("			, A.EAI_IF_ID" ).append("\n"); 
		query.append("			, A.MDT_RAT_FLG" ).append("\n"); 
		query.append("			, A.IDA_CHG_NM" ).append("\n"); 
		query.append("			, A.IDA_SAC_CD" ).append("\n"); 
		query.append("			, B.IDA_SAC_NM " ).append("\n"); 
		query.append("FROM MDM_CHARGE A, BKG_IDA_SAC_MST B" ).append("\n"); 
		query.append("WHERE	1 =1" ).append("\n"); 
		query.append("AND  A.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("	AND A.IDA_SAC_CD = B.IDA_SAC_CD(+)" ).append("\n"); 
		query.append("                #if (${chg_cd} != '' && ${chg_cd} != 'ALL')" ).append("\n"); 
		query.append("        	        AND     A.CHG_CD   = @[chg_cd]        " ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${ida_sac_cd} != '')" ).append("\n"); 
		query.append("        	        AND     A.IDA_SAC_CD   = @[ida_sac_cd]        " ).append("\n"); 
		query.append("                #end      " ).append("\n"); 
		query.append("ORDER BY A.CHG_CD" ).append("\n"); 

	}
}