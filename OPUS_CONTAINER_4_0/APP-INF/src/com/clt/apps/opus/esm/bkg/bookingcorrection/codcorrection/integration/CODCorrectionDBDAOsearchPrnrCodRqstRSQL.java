/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CODCorrectionDBDAOsearchPrnrCodRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOsearchPrnrCodRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * mail 제목 조회
	  * </pre>
	  */
	public CODCorrectionDBDAOsearchPrnrCodRqstRSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOsearchPrnrCodRqstRSQL").append("\n"); 
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
		query.append("select ''||(case when cod.cod_sts_cd = 'R' then ' COD Application '" ).append("\n"); 
		query.append("when cod.cod_sts_Cd = 'C' then ' COD Cancel Notice '" ).append("\n"); 
		query.append("when cod.cod_sts_Cd = 'F' then ' COD Confirm Notice '" ).append("\n"); 
		query.append("when cod.cod_sts_cd = 'M' then ' COD Application '    --manual request case" ).append("\n"); 
		query.append("when cod.cod_sts_cd = 'Y' then ' COD Approval Notice ' --manual approval case" ).append("\n"); 
		query.append("else ' COD Application ' end)" ).append("\n"); 
		query.append("||'- '||chr(91)" ).append("\n"); 
		query.append("||(select vsl_slan_cd" ).append("\n"); 
		query.append("from vsk_vsl_skd skd" ).append("\n"); 
		query.append("where rhnd_vvd.vsl_cd     = skd.vsl_cd" ).append("\n"); 
		query.append("and rhnd_vvd.skd_voy_no = skd.skd_voy_no" ).append("\n"); 
		query.append("and rhnd_vvd.skd_dir_cd = skd.skd_dir_cd)||chr(93)||' '" ).append("\n"); 
		query.append("||(select vsl_eng_nm from mdm_vsl_cntr vsl where vsl.vsl_cd = rhnd_vvd.vsl_cd)||' '||rhnd_vvd.skd_voy_no||rhnd_vvd.skd_dir_cd" ).append("\n"); 
		query.append("||'(BKG No. : '||cod.bkg_no||')' header" ).append("\n"); 
		query.append(", to_char(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(), SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC(cod.cod_rqst_ofc_cd)), 'yyyy/mm/dd') rqst_dt" ).append("\n"); 
		query.append(", (select CRR_CD from mdm_vsl_cntr vsl where vsl.vsl_cd = rhnd_vvd.vsl_cd) carrier_cd" ).append("\n"); 
		query.append(", (SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("WHERE HRD_CDG_ID = 'CND_CSTMS_CRR_CD'" ).append("\n"); 
		query.append("AND HRD_CDG_ID_SEQ = 1) AS operation_team" ).append("\n"); 
		query.append(", cod.bkg_no ref_no" ).append("\n"); 
		query.append(", (select vsl_eng_nm from mdm_vsl_cntr vsl where vsl.vsl_cd = rhnd_vvd.vsl_cd) vsl_nm" ).append("\n"); 
		query.append(", rhnd_vvd.skd_voy_no||rhnd_vvd.skd_dir_cd voyage_no" ).append("\n"); 
		query.append(", old_vvd.pol_yd_cd old_pol" ).append("\n"); 
		query.append(", old_vvd.pod_yd_cd old_pod" ).append("\n"); 
		query.append(", new_vvd.pod_yd_cd new_pod" ).append("\n"); 
		query.append(", cod.cod_iss_dt" ).append("\n"); 
		query.append(", rhnd_vvd.vsl_cd||rhnd_vvd.skd_voy_no||rhnd_vvd.skd_dir_cd rhnd_vvd" ).append("\n"); 
		query.append(", (select loc_nm from mdm_location where loc_cd =substr(old_vvd.pol_yd_cd, 1, 5)) old_pol_nm" ).append("\n"); 
		query.append(", (select loc_nm from mdm_location where loc_cd =substr(old_vvd.pod_yd_cd, 1, 5)) old_pod_nm" ).append("\n"); 
		query.append(", (select loc_nm from mdm_location where loc_cd =substr(new_vvd.pod_yd_cd, 1, 5)) new_pod_nm" ).append("\n"); 
		query.append(", cod.cod_sts_cd" ).append("\n"); 
		query.append("from bkg_cod cod" ).append("\n"); 
		query.append(", bkg_cod_vvd old_vvd" ).append("\n"); 
		query.append(", bkg_cod_vvd new_vvd" ).append("\n"); 
		query.append(", bkg_cod_vvd rhnd_vvd" ).append("\n"); 
		query.append("where cod.bkg_no         = @[bkg_no]" ).append("\n"); 
		query.append("and cod.cod_rqst_seq   = @[cod_rqst_seq]" ).append("\n"); 
		query.append("and cod.bkg_no         = old_vvd.bkg_no" ).append("\n"); 
		query.append("and cod.cod_rqst_seq   = old_vvd.cod_rqst_seq" ).append("\n"); 
		query.append("and 'O'                = old_vvd.vvd_op_cd" ).append("\n"); 
		query.append("and rhnd_vvd.pol_yd_cd = old_vvd.pol_yd_cd" ).append("\n"); 
		query.append("and cod.bkg_no         = new_vvd.bkg_no        (+)" ).append("\n"); 
		query.append("and cod.cod_rqst_seq   = new_vvd.cod_rqst_seq  (+)" ).append("\n"); 
		query.append("and 'N'                = new_vvd.vvd_op_cd     (+)" ).append("\n"); 
		query.append("and rhnd_vvd.pol_yd_cd = new_vvd.pol_yd_cd" ).append("\n"); 
		query.append("and cod.bkg_no         = rhnd_vvd.bkg_no" ).append("\n"); 
		query.append("and cod.cod_rqst_seq   = rhnd_vvd.cod_rqst_seq" ).append("\n"); 
		query.append("and (cod.cod_rhnd_port_yd_cd  is not null or  cod.cod_rhnd_port_cd is not null)" ).append("\n"); 
		query.append("and ((cod.COD_RHND_PORT_YD_CD is null     and rhnd_vvd.pod_yd_cd like cod.COD_RHND_PORT_CD||'%')" ).append("\n"); 
		query.append("or" ).append("\n"); 
		query.append("(cod.COD_RHND_PORT_YD_CD is not null and cod.COD_RHND_PORT_YD_CD = rhnd_vvd.pod_yd_cd))" ).append("\n"); 

	}
}