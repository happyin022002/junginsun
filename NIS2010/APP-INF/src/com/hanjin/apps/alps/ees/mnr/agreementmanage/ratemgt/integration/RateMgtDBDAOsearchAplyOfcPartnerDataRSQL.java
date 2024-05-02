/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RateMgtDBDAOsearchAplyOfcPartnerDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RateMgtDBDAOsearchAplyOfcPartnerDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAplyOfcPartnerData
	  * </pre>
	  */
	public RateMgtDBDAOsearchAplyOfcPartnerDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration").append("\n"); 
		query.append("FileName : RateMgtDBDAOsearchAplyOfcPartnerDataRSQL").append("\n"); 
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
		query.append("SELECT   D.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("       , D.AGMT_SEQ" ).append("\n"); 
		query.append("       , D.AGMT_VER_NO" ).append("\n"); 
		query.append("       , D.AGMT_OFC_TP_CD" ).append("\n"); 
		query.append("       , D.APLY_OFC_CD" ).append("\n"); 
		query.append("       , D.CRE_USR_ID" ).append("\n"); 
		query.append("       , D.CRE_DT" ).append("\n"); 
		query.append("       , D.UPD_USR_ID" ).append("\n"); 
		query.append("       , D.UPD_DT" ).append("\n"); 
		query.append("       , C.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("       , NVL(C.CTRL_OFC_CD,D.APLY_OFC_CD) AS CTRL_OFC_CD" ).append("\n"); 
		query.append("       , NVL(C.MNR_GRP_TP_CD,'RPR') AS MNR_GRP_TP_CD" ).append("\n"); 
		query.append("       , NVL(C.MNR_PRNR_TP_CD,'S') AS MNR_PRNR_TP_CD" ).append("\n"); 
		query.append("       , NVL(C.MNR_PRNR_KND_CD,'C') AS MNR_PRNR_KND_CD" ).append("\n"); 
		query.append("       , C.MNR_PRNR_KND_DTL_CD" ).append("\n"); 
		query.append("       , NVL(C.MNR_PRNR_STS_CD,'C') AS MNR_PRNR_STS_CD" ).append("\n"); 
		query.append("       , C.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(NVL(C.MNR_PRNR_SEQ,D.VNDR_SEQ)) AS MNR_PRNR_SEQ" ).append("\n"); 
		query.append("       , C.EDI_ID" ).append("\n"); 
		query.append("       , C.SP_PTAL_ID" ).append("\n"); 
		query.append("       , C.SP_PTAL_PWD" ).append("\n"); 
		query.append("       , C.MNR_PRNR_LGL_ENG_NM" ).append("\n"); 
		query.append("       , C.MNR_PRNR_LOCL_LANG_NM" ).append("\n"); 
		query.append("       , C.PAY_TERM_DYS" ).append("\n"); 
		query.append("       , C.TRSM_MOD_CD" ).append("\n"); 
		query.append("       , TO_CHAR(C.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("       , TO_CHAR(C.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("       , C.PHN_NO" ).append("\n"); 
		query.append("       , C.FAX_NO" ).append("\n"); 
		query.append("       , C.MNR_PRNR_EML" ).append("\n"); 
		query.append("FROM     MNR_PARTNER C" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                  , A.AGMT_SEQ" ).append("\n"); 
		query.append("                  , A.AGMT_VER_NO" ).append("\n"); 
		query.append("                  , A.AGMT_OFC_TP_CD" ).append("\n"); 
		query.append("                  , A.APLY_OFC_CD" ).append("\n"); 
		query.append("                  , A.CRE_USR_ID" ).append("\n"); 
		query.append("                  , A.CRE_DT" ).append("\n"); 
		query.append("                  , A.UPD_USR_ID" ).append("\n"); 
		query.append("                  , A.UPD_DT" ).append("\n"); 
		query.append("                  , B.VNDR_SEQ" ).append("\n"); 
		query.append("           FROM     MNR_AGMT_APLY_OFC A" ).append("\n"); 
		query.append("                  , MNR_AGMT_HDR B" ).append("\n"); 
		query.append("           WHERE    A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("           AND      A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("           AND      A.AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 
		query.append("           AND      A.AGMT_OFC_TP_CD = 'COST'" ).append("\n"); 
		query.append("           AND      A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND      A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("           AND      A.AGMT_VER_NO = B.AGMT_VER_NO" ).append("\n"); 
		query.append("         ) D" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      C.MNR_GRP_TP_CD(+) = 'RPR'" ).append("\n"); 
		query.append("AND      C.MNR_PRNR_SEQ(+)  = D.VNDR_SEQ" ).append("\n"); 
		query.append("AND      C.CTRL_OFC_CD(+)   = D.APLY_OFC_CD" ).append("\n"); 

	}
}