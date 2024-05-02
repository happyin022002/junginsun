/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearch301EdiKindRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.07
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2015.09.07 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearch301EdiKindRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 301F 발송을 위해 Edi Kind(CF/BT)를 조회하는 SQL
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearch301EdiKindRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearch301EdiKindRSQL").append("\n"); 
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
		query.append("--BKG CONFIRM" ).append("\n"); 
		query.append("SELECT DISTINCT 'BT' EDI_KIND" ).append("\n"); 
		query.append("FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append("     , BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append("     , BKG_VVD VVD" ).append("\n"); 
		query.append("     , BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.BKG_NO   = VVD.BKG_NO" ).append("\n"); 
		query.append("AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("AND MSG.MSG_TP_DESC		  = '1'" ).append("\n"); 
		query.append("AND MSG.EDI_MSG_TP_ID      = '301'" ).append("\n"); 
		query.append("AND EY.TRD_PRNR_SUB_LNK_SEQ IN " ).append("\n"); 
		query.append("    (SELECT TRD_PRNR_SUB_LNK_SEQ FROM BKG_EDI_SUB_LNK_MSG WHERE EDI_MSG_IND_CD ='1') --1:AUTO" ).append("\n"); 
		query.append("     AND (   (EY.PRNR_SUB_LNK_CD = BK.POL_NOD_CD AND MSG.EDI_MSG_IND_CD IN ('1')) --입력된 찾아진 POL과 같거나" ).append("\n"); 
		query.append("          OR (EY.PRNR_SUB_LNK_CD = VVD.POL_YD_CD AND VVD.VSL_PRE_PST_CD <> 'U' AND MSG.EDI_MSG_IND_CD = '6') --PRE T/S PORT 지정 건이나" ).append("\n"); 
		query.append("          OR (EY.PRNR_SUB_LNK_CD = VVD.POL_YD_CD AND VVD.VSL_PRE_PST_CD =  'U' AND MSG.EDI_MSG_IND_CD = '7') --POST T/S PORT 지정 건" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("UNION ALL                                     " ).append("\n"); 
		query.append("--FULL RELEASE ORDER 대상   " ).append("\n"); 
		query.append("SELECT DISTINCT 'FC'" ).append("\n"); 
		query.append("FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append("    , BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append("    , BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.FULL_RTN_YD_CD = EY.PRNR_SUB_LNK_CD" ).append("\n"); 
		query.append("AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("AND MSG.EDI_MSG_TP_ID 	= '301'" ).append("\n"); 
		query.append("AND MSG.MSG_TP_DESC	 	= '1'" ).append("\n"); 
		query.append("AND EDI_MSG_IND_CD 	 = '4'     " ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("               FROM BKG_EDI_SUB_LNK_MSG MSG, BKG_EDI_TRD_PRNR_SUB_LNK LNK" ).append("\n"); 
		query.append("               WHERE EDI_MSG_IND_CD ='1' " ).append("\n"); 
		query.append("               AND MSG.TRD_PRNR_SUB_LNK_SEQ = LNK.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("               AND LNK.PRNR_SUB_LNK_CD = BK.POL_NOD_CD" ).append("\n"); 
		query.append("               AND BK.POL_NOD_CD = BK.FULL_RTN_YD_CD)" ).append("\n"); 

	}
}