/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCommonDBDAOSearchAfterBKGOfficeCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.15
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.10.15 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM TAE KYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchAfterBKGOfficeCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 등록된 After Booking 를 통해서 Charge Calculation 의 Office Code 를 조회하는 쿼리(권한처리를 위해서 필요한 Office 코드를 조회한다.)
	  * </pre>
	  */
	public DMTCommonDBDAOSearchAfterBKGOfficeCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchAfterBKGOfficeCdRSQL").append("\n"); 
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
		query.append("SELECT	B.OFC_CD" ).append("\n"); 
		query.append("FROM	DMT_CHG_BKG_CNTR			A" ).append("\n"); 
		query.append(",		DMT_CHG_CALC				B" ).append("\n"); 
		query.append(",		DMT_AFT_BKG_ADJ_RQST		M" ).append("\n"); 
		query.append(",		DMT_AFT_BKG_ADJ_RQST_DTL	D" ).append("\n"); 
		query.append("WHERE	A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND	A.SYS_AREA_GRP_ID	= B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	AND A.CNTR_NO			= B.CNTR_NO" ).append("\n"); 
		query.append("	AND A.CNTR_CYC_NO		= B.CNTR_CYC_NO" ).append("\n"); 
		query.append("	AND B.DMDT_TRF_CD		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("	AND B.DMDT_CHG_LOC_DIV_CD NOT IN ('TSP', 'SZP')" ).append("\n"); 
		query.append("	AND B.DMDT_CHG_STS_CD NOT IN ('P', 'T')" ).append("\n"); 
		query.append("	AND M.AFT_EXPT_DAR_NO   = D.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("	AND M.DMDT_EXPT_RQST_STS_CD <> 'C'" ).append("\n"); 
		query.append("	AND A.BKG_NO		= D.BKG_NO" ).append("\n"); 
		query.append("	AND D.EACH_CNTR_FLG = 'N'" ).append("\n"); 
		query.append("	AND M.AFT_EXPT_DAR_NO   = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	B.OFC_CD" ).append("\n"); 
		query.append("FROM	DMT_CHG_BKG_CNTR			A" ).append("\n"); 
		query.append(",		DMT_CHG_CALC				B" ).append("\n"); 
		query.append(",		DMT_AFT_BKG_CNTR			C" ).append("\n"); 
		query.append(",       DMT_AFT_BKG_ADJ_RQST		M" ).append("\n"); 
		query.append(",		DMT_AFT_BKG_ADJ_RQST_DTL	D" ).append("\n"); 
		query.append("WHERE	A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND	A.SYS_AREA_GRP_ID	= B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	AND A.CNTR_NO			= B.CNTR_NO" ).append("\n"); 
		query.append("	AND A.CNTR_CYC_NO		= B.CNTR_CYC_NO" ).append("\n"); 
		query.append("	AND B.DMDT_TRF_CD		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("	AND B.DMDT_CHG_LOC_DIV_CD NOT IN ('TSP', 'SZP')" ).append("\n"); 
		query.append("	AND B.DMDT_CHG_STS_CD NOT IN ('P', 'T')" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	AND B.SYS_AREA_GRP_ID   = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	AND B.CNTR_NO           = C.CNTR_NO" ).append("\n"); 
		query.append("	AND B.CNTR_CYC_NO       = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("	AND B.DMDT_TRF_CD       = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("	AND B.DMDT_CHG_LOC_DIV_CD = C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	AND B.CHG_SEQ           = C.CHG_SEQ" ).append("\n"); 
		query.append("	AND M.AFT_EXPT_DAR_NO	= C.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("	AND M.DMDT_EXPT_RQST_STS_CD <> 'C'" ).append("\n"); 
		query.append("	AND (" ).append("\n"); 
		query.append("	        NVL(C.CNTR_CHG_DC_AMT,0) <> 0 OR NVL(C.CNTR_CHG_DC_RTO,0) <> 0 OR C.FT_ADJ_FLG = 'Y'" ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append("	AND A.BKG_NO		= D.BKG_NO" ).append("\n"); 
		query.append("	AND D.EACH_CNTR_FLG = 'Y'" ).append("\n"); 

	}
}