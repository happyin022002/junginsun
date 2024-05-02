/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : COPSearchDBDAOSearchDocumentationInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.03.10 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOSearchDocumentationInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDocumentationInfo
	  * </pre>
	  */
	public COPSearchDBDAOSearchDocumentationInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("niv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSearchDocumentationInfoRSQL").append("\n"); 
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
		query.append("SELECT act_cd" ).append("\n"); 
		query.append(",act_nm" ).append("\n"); 
		query.append(",replace(occ_date, '--', '') as occ_date" ).append("\n"); 
		query.append(",replace(occ_time, ':', '') as occ_time" ).append("\n"); 
		query.append(",NVL2(replace(occ_date, '--', ''), '1', '0') as except" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT act_cd" ).append("\n"); 
		query.append(", case when ACT_CD = 'NIV' then 'Last I/B Invoice Issued' else act_nm end act_nm" ).append("\n"); 
		query.append(", DECODE(act_cd, 'BCF', bcf_date," ).append("\n"); 
		query.append("'SIR', sir_date," ).append("\n"); 
		query.append("'CSP', csp_date," ).append("\n"); 
		query.append("'CSH', csh_date," ).append("\n"); 
		query.append("'OFC', ofc_date," ).append("\n"); 
		query.append("'NFC', nfc_date," ).append("\n"); 
		query.append("'OBL', obl_date," ).append("\n"); 
		query.append("'OBC', obc_date," ).append("\n"); 
		query.append("'DOI', doi_date," ).append("\n"); 
		query.append("'DBL', dbl_date," ).append("\n"); 
		query.append("'CAI', cai_date," ).append("\n"); 
		query.append("'ANI', ani_date," ).append("\n"); 
		query.append("'NIV', DECODE(SIGN(LENGTH(NVL(@[niv_dt], '')) -8), -1, '', SUBSTR(@[niv_dt], 1, 4)||'-'||SUBSTR(@[niv_dt], 5, 2)||'-'||SUBSTR(@[niv_dt], 7, 2))," ).append("\n"); 
		query.append("'OIV', '',    -- 미정" ).append("\n"); 
		query.append("'NCC', ncc_date," ).append("\n"); 
		query.append("'NCH', nch_date," ).append("\n"); 
		query.append("'') as occ_date" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", DECODE(act_cd, 'BCF', bcf_time," ).append("\n"); 
		query.append("'SIR', sir_time," ).append("\n"); 
		query.append("'CSP', csp_time," ).append("\n"); 
		query.append("'CSH', csh_time," ).append("\n"); 
		query.append("'OFC', ofc_time," ).append("\n"); 
		query.append("'NFC', nfc_time," ).append("\n"); 
		query.append("'OBL', obl_time," ).append("\n"); 
		query.append("'OBC', obc_time," ).append("\n"); 
		query.append("'DOI', doi_time," ).append("\n"); 
		query.append("'DBL', dbl_time," ).append("\n"); 
		query.append("'CAI', cai_time," ).append("\n"); 
		query.append("'ANI', ani_time," ).append("\n"); 
		query.append("'NIV', DECODE(SIGN(LENGTH(NVL(@[niv_dt], '')) -12), -1, '', SUBSTR(@[niv_dt], 9, 2)||':'||SUBSTR(@[niv_dt], 11, 2))," ).append("\n"); 
		query.append("'OIV', ''," ).append("\n"); 
		query.append("'NCC', ncc_time," ).append("\n"); 
		query.append("'NCH', nch_date," ).append("\n"); 
		query.append("'') AS occ_time" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT  act.act_cd, act.act_nm" ).append("\n"); 
		query.append(",dt.bcf_date, dt.bcf_time" ).append("\n"); 
		query.append(",TO_CHAR(csp_date, 'yyyy-mm-dd') AS csp_date, TO_CHAR(csp_date, 'hh24:mi') csp_time" ).append("\n"); 
		query.append(",TO_CHAR(csh_date, 'yyyy-mm-dd') AS csh_date, TO_CHAR(csh_date, 'hh24:mi') csh_time" ).append("\n"); 
		query.append(",TO_CHAR(ofc_date, 'yyyy-mm-dd') AS ofc_date, TO_CHAR(ofc_date, 'hh24:mi') ofc_time" ).append("\n"); 
		query.append(",TO_CHAR(obl_date, 'yyyy-mm-dd') AS obl_date, TO_CHAR(obl_date, 'hh24:mi') obl_time" ).append("\n"); 
		query.append(",TO_CHAR(sir_date, 'yyyy-mm-dd') AS sir_date, TO_CHAR(sir_date, 'hh24:mi') sir_time" ).append("\n"); 
		query.append(",TO_CHAR(cai_date, 'yyyy-mm-dd') AS cai_date, TO_CHAR(cai_date, 'hh24:mi') cai_time" ).append("\n"); 
		query.append(",TO_CHAR(ani_date, 'yyyy-mm-dd') AS ani_date, TO_CHAR(ani_date, 'hh24:mi') ani_time" ).append("\n"); 
		query.append(",TO_CHAR(ncc_date, 'yyyy-mm-dd') AS ncc_date, TO_CHAR(ncc_date, 'hh24:mi') ncc_time" ).append("\n"); 
		query.append(",TO_CHAR(nch_date, 'yyyy-mm-dd') AS nch_date, TO_CHAR(nch_date, 'hh24:mi') nhc_time" ).append("\n"); 
		query.append(",TO_CHAR(nfc_date, 'yyyy-mm-dd') AS nfc_date, TO_CHAR(nfc_date, 'hh24:mi') nfc_time" ).append("\n"); 
		query.append(",TO_CHAR(obc_date, 'yyyy-mm-dd') AS obc_date, TO_CHAR(obc_date, 'hh24:mi') obc_time" ).append("\n"); 
		query.append(",TO_CHAR(doi_date, 'yyyy-mm-dd') AS doi_date, TO_CHAR(doi_date, 'hh24:mi') doi_time" ).append("\n"); 
		query.append(",TO_CHAR(dbl_date, 'yyyy-mm-dd') AS dbl_date, TO_CHAR(dbl_date, 'hh24:mi') dbl_time" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT TO_CHAR(bb.bkg_cre_dt,'yyyy-MM-dd')      bcf_date" ).append("\n"); 
		query.append(", TO_CHAR(bb.bkg_cre_dt,'hh24:mi')           bcf_time" ).append("\n"); 
		query.append(", (SELECT max(MF_SND_DT) mt_snd_dt FROM BKG_CSTMS_ADV_BL where bkg_no = bb.bkg_no AND CSTMS_MF_TP_CD ='MI') csp_date" ).append("\n"); 
		query.append(", (SELECT max(CSTMS_CLR_LST_DT) from bkg_cgo_rlse  where bl_no = (select bl_no from bkg_booking where bkg_no = bb.bkg_no)  and  CSTMS_CLR_CD ='H') csh_date" ).append("\n"); 
		query.append(", (SELECT MIN(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', cre_dt, BKG_COM_USER_LOC_FNC(cre_usr_id)), cre_dt)) cre_dt FROM BKG_CHG_RT WHERE BKG_NO  = bb.bkg_no ) ofc_date" ).append("\n"); 
		query.append(", bbi.obl_iss_dt AS obl_date" ).append("\n"); 
		query.append(", (SELECT MAX(RQST_DT) rqst_dt FROM BKG_XTER_RQST_MST WHERE BKG_NO = bb.bkg_no) sir_date" ).append("\n"); 
		query.append(", (SELECT MAX(CORR_DT) corr_dt FROM BKG_CORRECTION WHERE BKG_NO = bb.bkg_no   AND CORR_NO != '0000000001') cai_date" ).append("\n"); 
		query.append(", (SELECT MAX(SND_RQST_DT) snd_rqst_dt FROM BKG_NTC_HIS WHERE BKG_NO = bb.bkg_no AND NTC_KND_CD ='AN') ani_date" ).append("\n"); 
		query.append(", (SELECT MAX(CSTMS_CLR_LST_DT) cstms_clr_lst_dt FROM  BKG_CGO_RLSE where bl_no = (select bl_no from bkg_booking where bkg_no =bb.bkg_no) ) ncc_date" ).append("\n"); 
		query.append(", (SELECT max(PRE_HLD_DT) pre_hld_dt  FROM  BKG_HLD_NTC where bkg_no = bb.bkg_no) nch_date" ).append("\n"); 
		query.append(", (SELECT  FRT_CLT_LST_DT  FROM  BKG_CGO_RLSE where bl_no = (select bl_no from bkg_booking where bkg_no = bb.bkg_no) ) nfc_date" ).append("\n"); 
		query.append(", (SELECT OBL_RDEM_LST_DT FROM  BKG_CGO_RLSE where bl_no = (select bl_no from bkg_booking where bkg_no = bb.bkg_no)) AS obc_date" ).append("\n"); 
		query.append(", (SELECT MAX(SND_RQST_DT) snd_rqst_dt FROM BKG_NTC_HIS WHERE BKG_NO = bb.bkg_no AND NTC_KND_CD ='DO') doi_date" ).append("\n"); 
		query.append(", (SELECT MAX(SND_RQST_DT) snd_rqst_dt FROM BKG_NTC_HIS WHERE BKG_NO = bb.bkg_no AND NTC_KND_CD ='BL') dbl_date" ).append("\n"); 
		query.append(", bl_no" ).append("\n"); 
		query.append("FROM    bkg_booking bb," ).append("\n"); 
		query.append("bkg_bl_iss bbi" ).append("\n"); 
		query.append("WHERE  bb.bkg_no       = bbi.bkg_no(+)" ).append("\n"); 
		query.append("AND  bb.bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append(") dt" ).append("\n"); 
		query.append(", mdm_activity act" ).append("\n"); 
		query.append("WHERE act_tp_cd = 'D'" ).append("\n"); 
		query.append("AND act_flg <> 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}