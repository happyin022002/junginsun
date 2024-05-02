/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SendEdiFromParnterLinesMgtDBDAOSearchTrsmHdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SendEdiFromParnterLinesMgtDBDAOSearchTrsmHdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 중복 체크 하기 위한 대상 조회 
	  * </pre>
	  */
	public SendEdiFromParnterLinesMgtDBDAOSearchTrsmHdrRSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.integration").append("\n"); 
		query.append("FileName : SendEdiFromParnterLinesMgtDBDAOSearchTrsmHdrRSQL").append("\n"); 
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
		query.append("       TRSM_BND_CD" ).append("\n"); 
		query.append("     , TRSM_DT" ).append("\n"); 
		query.append("     , SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("     , PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("     , TRSM_MZD_CD" ).append("\n"); 
		query.append("     , EDI_SNDR_ID" ).append("\n"); 
		query.append("     , EDI_RCVR_ID" ).append("\n"); 
		query.append("     , FLT_FILE_REF_NO" ).append("\n"); 
		query.append("     , EDI_MSG_ID" ).append("\n"); 
		query.append("     , EDI_IF_ID" ).append("\n"); 
		query.append("     , RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("     , CGO_OPR_CD" ).append("\n"); 
		query.append("     , EML_SND_NO" ).append("\n"); 
		query.append("     , SLAN_CD" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , EDI_HDR_MSG" ).append("\n"); 
		query.append("     , BKG_REF_NO" ).append("\n"); 
		query.append("     , BKG_CRE_LOCL_DT" ).append("\n"); 
		query.append("     , BKG_CRE_LOCL_DT_CTNT" ).append("\n"); 
		query.append("     , EDI_MSG_STS_CD" ).append("\n"); 
		query.append("     , EDI_MSG_REF_NO" ).append("\n"); 
		query.append("     , CALL_SGN_NO" ).append("\n"); 
		query.append("     , LLOYD_NO" ).append("\n"); 
		query.append("     , VSL_ENG_FULL_NM" ).append("\n"); 
		query.append("     , SHP_CALL_NO" ).append("\n"); 
		query.append("     , IN_BND_CSSM_VOY_NO" ).append("\n"); 
		query.append("     , OUT_BND_CSSM_VOY_NO" ).append("\n"); 
		query.append("     , POR_CD" ).append("\n"); 
		query.append("     , POR_YD_CD" ).append("\n"); 
		query.append("     , POR_NM" ).append("\n"); 
		query.append("     , POL_CD" ).append("\n"); 
		query.append("     , POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , POL_YD_CD" ).append("\n"); 
		query.append("     , POL_NM" ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , POD_YD_CD" ).append("\n"); 
		query.append("     , POD_NM" ).append("\n"); 
		query.append("     , DEL_CD" ).append("\n"); 
		query.append("     , DEL_YD_CD" ).append("\n"); 
		query.append("     , DEL_NM" ).append("\n"); 
		query.append("     , FLT_FILE_CONV_RSLT_CD" ).append("\n"); 
		query.append("     , AUTO_UPD_RSLT_CD" ).append("\n"); 
		query.append("     , APLY_RSLT_RMK" ).append("\n"); 
		query.append("     , LST_TRSM_STS_CD" ).append("\n"); 
		query.append("     , MAPG_CRR_CD" ).append("\n"); 
		query.append("     , MAPG_BKG_REF_NO" ).append("\n"); 
		query.append("     , MAPG_SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , CRE_OFC_CD" ).append("\n"); 
		query.append("     , UPD_OFC_CD" ).append("\n"); 
		query.append("     , ERR_KND_CD" ).append("\n"); 
		query.append("     , ERR_KND_CORR_CD" ).append("\n"); 
		query.append("     , CTRL_REF_NO" ).append("\n"); 
		query.append("  FROM SCG_PRNR_SPCL_CGO_TRSM_HDR" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append(" AND   TRSM_MZD_CD              = 'EDI'							--::EDI, EML::--" ).append("\n"); 
		query.append(" AND   BKG_REF_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}