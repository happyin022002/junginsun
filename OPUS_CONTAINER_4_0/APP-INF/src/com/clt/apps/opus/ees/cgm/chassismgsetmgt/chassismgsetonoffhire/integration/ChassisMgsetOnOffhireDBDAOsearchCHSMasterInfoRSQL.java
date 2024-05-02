/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchCHSMasterInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.30
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2015.01.30 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOsearchCHSMasterInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchCHSMasterInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_als_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_chss_als_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchCHSMasterInfoRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX ( C XPKCGM_EQ_STS_HIS) */" ).append("\n"); 
		query.append("       A.EQ_NO," ).append("\n"); 
		query.append("       A.EQ_KND_CD," ).append("\n"); 
		query.append("       DECODE(A.ACIAC_DIV_CD, 'I', 'In-active', 'Active') AS ACIAC_DIV_CD," ).append("\n"); 
		query.append("       --TO_CHAR(A.ONH_DT, 'yyyy-mm-dd') AS ONH_DT," ).append("\n"); 
		query.append("       TO_CHAR(C.STS_EVNT_DT, 'yyyy-mm-dd') AS ONH_DT ," ).append("\n"); 
		query.append("       A.ONH_OFC_CD," ).append("\n"); 
		query.append("       A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.MFT_DT, 'yyyy-mm-dd') AS MFT_DT," ).append("\n"); 
		query.append("       A.CHSS_POOL_CD," ).append("\n"); 
		query.append("       A.DISP_FLG," ).append("\n"); 
		query.append("       A.EQ_SPEC_NO," ).append("\n"); 
		query.append("       A.CHSS_TARE_WGT," ).append("\n"); 
		query.append("       A.CHSS_MVMT_STS_CD," ).append("\n"); 
		query.append("       A.CRNT_YD_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.CHSS_MVMT_DT, 'yyyy-mm-dd hh24:mi')AS CHSS_MVMT_DT," ).append("\n"); 
		query.append("       D.CNTR_CHK AS CNTR_CHK," ).append("\n"); 
		query.append("       D.ATCH_CNTR AS ATCH_CNTR," ).append("\n"); 
		query.append("       NVL(D.BARE_CHK,'Y') AS BARE_CHK," ).append("\n"); 
		query.append("       E.MGS_CHK AS MGSET_CHK," ).append("\n"); 
		query.append("       E.ATCH_MGS AS ATCH_MGS," ).append("\n"); 
		query.append("       A.DMG_FLG AS DAMAGE_CHK," ).append("\n"); 
		query.append("       DECODE (SIGN (SYSDATE - A.CHSS_MVMT_DT - 30), 1, 'Y', 'N') AS LSTAY_CHK," ).append("\n"); 
		query.append("       A.AGMT_OFC_CTY_CD||LPAD(A.AGMT_SEQ, 6, '0') AS AGREEMENT_NO," ).append("\n"); 
		query.append("       A.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("       A.AGMT_SEQ," ).append("\n"); 
		query.append("       A.AGMT_LSTM_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.ONH_DT, 'yyyy-mm-dd') AS ACT_ONH_DT," ).append("\n"); 
		query.append("       B.AGMT_REF_NO," ).append("\n"); 
		query.append("       B.VNDR_SEQ," ).append("\n"); 
		query.append("       (SELECT C.VNDR_ABBR_NM" ).append("\n"); 
		query.append("          FROM MDM_VENDOR C" ).append("\n"); 
		query.append("         WHERE B.VNDR_SEQ = C.VNDR_SEQ) AS VNDR_ABBR_NM," ).append("\n"); 
		query.append("       A.CHSS_ALS_NO," ).append("\n"); 
		query.append("       A.N2ND_CHSS_ALS_NO," ).append("\n"); 
		query.append("       A.CHSS_RGST_STE_CD," ).append("\n"); 
		query.append("       A.CHSS_RGST_LIC_NO," ).append("\n"); 
		query.append("       A.CHSS_RGST_YR," ).append("\n"); 
		query.append("       A.CHSS_VEH_ID_NO," ).append("\n"); 
		query.append("       A.CHSS_TIT_NO," ).append("\n"); 
		query.append("       A.CHSS_RGST_PRD_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.CHSS_RGST_EXP_DT, 'yyyy-mm-dd') AS CHSS_RGST_EXP_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.CHSS_RGST_UPD_DT, 'yyyy-mm-dd') AS CHSS_RGST_UPD_DT," ).append("\n"); 
		query.append("       A.CHSS_RGST_UPD_ID," ).append("\n"); 
		query.append("       A.CRE_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') AS CRE_DT," ).append("\n"); 
		query.append("       A.UPD_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') AS UPD_DT" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A, CGM_AGREEMENT B, CGM_EQ_STS_HIS C," ).append("\n"); 
		query.append("        ( SELECT /*+ INDEX_DESC(E XPKCGM_EQ_ATCH_DTCH_HIS) */ " ).append("\n"); 
		query.append("        E.EQ_NO," ).append("\n"); 
		query.append("        DECODE(E.DTCH_YD_CD, NULL, 'Y', 'N') CNTR_CHK , " ).append("\n"); 
		query.append("        DECODE(E.DTCH_YD_CD, NULL, E.CNTR_NO ) ATCH_CNTR," ).append("\n"); 
		query.append("        DECODE(E.DTCH_YD_CD, NULL, 'N', 'Y') BARE_CHK" ).append("\n"); 
		query.append("        FROM CGM_EQ_ATCH_DTCH_HIS E " ).append("\n"); 
		query.append("        WHERE E.EQ_NO = @[eq_no] " ).append("\n"); 
		query.append("        AND E.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("        --AND E.DTCH_DT = TO_DATE('88881231','YYYYMMDD')" ).append("\n"); 
		query.append("        AND ROWNUM = 1 ) D ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC(E XAK2CGM_EQ_ATCH_DTCH_HIS) */ " ).append("\n"); 
		query.append("        E.CHSS_NO," ).append("\n"); 
		query.append("        DECODE(E.DTCH_YD_CD, NULL, 'Y', 'N') MGS_CHK," ).append("\n"); 
		query.append("        DECODE(E.DTCH_YD_CD, NULL, E.EQ_NO ) ATCH_MGS" ).append("\n"); 
		query.append("        FROM CGM_EQ_ATCH_DTCH_HIS E " ).append("\n"); 
		query.append("        WHERE E.CHSS_NO = @[eq_no]" ).append("\n"); 
		query.append("        AND E.EQ_KND_CD = 'G'" ).append("\n"); 
		query.append("        AND ROWNUM = 1" ).append("\n"); 
		query.append("        ) E" ).append("\n"); 
		query.append(" WHERE A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND A.EQ_NO = D.EQ_NO(+)" ).append("\n"); 
		query.append("   AND A.EQ_NO = E.CHSS_NO(+)   " ).append("\n"); 
		query.append("   AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("   AND A.AGMT_VER_NO = B.AGMT_VER_NO" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("#if (${eq_no} != '') " ).append("\n"); 
		query.append("   AND A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("#elseif (${chss_als_no} != '')" ).append("\n"); 
		query.append("   AND A.CHSS_ALS_NO = @[chss_als_no]" ).append("\n"); 
		query.append("#elseif (${n2nd_chss_als_no} != '')" ).append("\n"); 
		query.append("   AND A.N2ND_CHSS_ALS_NO = @[n2nd_chss_als_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND A.EQ_NO = C.EQ_NO(+)" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND C.EQ_ASET_STS_CD(+) ='LSI'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND ROWNUM =1" ).append("\n"); 

	}
}