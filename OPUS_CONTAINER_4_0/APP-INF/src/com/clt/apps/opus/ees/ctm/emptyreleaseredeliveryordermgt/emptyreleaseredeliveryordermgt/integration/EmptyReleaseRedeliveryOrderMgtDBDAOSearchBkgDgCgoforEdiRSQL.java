/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgDgCgoforEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.11
*@LastModifier : 강환
*@LastVersion : 1.0
* 2014.03.11 강환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwan, Kang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgDgCgoforEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_DG_CGO 테이블에서 EDI로 전송할 정보를 조회한다
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgDgCgoforEdiRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgDgCgoforEdiRSQL").append("\n"); 
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
		query.append("SELECT DG.IMDG_UN_NO" ).append("\n"); 
		query.append("      ,DG.IMDG_CLSS_CD" ).append("\n"); 
		query.append("      ,DG.EMER_CNTC_PHN_NO_CTNT" ).append("\n"); 
		query.append("      ,DG.FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("      ,REPLACE ( REPLACE (DG.DIFF_RMK, CHR(13), ' '), CHR(10),' ') AS DIFF_RMK" ).append("\n"); 
		query.append("      ,DG.EMS_NO" ).append("\n"); 
		query.append("      ,DG.PSA_NO" ).append("\n"); 
		query.append("      ,DG.IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("      ,DG.PRP_SHP_NM" ).append("\n"); 
		query.append("      ,DG.MRN_POLUT_FLG" ).append("\n"); 
		query.append("      ,DG.OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("      ,DG.HZD_DESC" ).append("\n"); 
		query.append("      ,DG.SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append("      ,DG.IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("      ,(SELECT IMDG.IMDG_SUBS_RSK_LBL_RMK" ).append("\n"); 
		query.append("          FROM SCG_IMDG_UN_NO IMDG" ).append("\n"); 
		query.append("         WHERE IMDG.IMDG_UN_NO = DG.IMDG_UN_NO" ).append("\n"); 
		query.append("           AND IMDG.IMDG_UN_NO_SEQ = 1" ).append("\n"); 
		query.append("       ) IMDG_SUBS_RSK_LBL_RMK" ).append("\n"); 
		query.append("  FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append(" WHERE DG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("   AND DG.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}