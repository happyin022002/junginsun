/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOaddTmlEurForRecieveCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.11.13 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOaddTmlEurForRecieveCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addTmlEurForRecieve
	  * </pre>
	  */
	public CLLCDLManifestDBDAOaddTmlEurForRecieveCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seal_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_ldis_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seal_no2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_lodg_dchg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_rpt_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rpt_hdr_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_rpt_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_decl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_vvd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tare_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eur_tml_dmg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_cell_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_sts_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_msg_mtch_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOaddTmlEurForRecieveCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_TML_EUR" ).append("\n"); 
		query.append("(EDI_SNDR_ID," ).append("\n"); 
		query.append("EVNT_YD_CD," ).append("\n"); 
		query.append("TML_VVD_ID," ).append("\n"); 
		query.append("POL_CD," ).append("\n"); 
		query.append("POD_CD," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CO_RPT_ID," ).append("\n"); 
		query.append("CALL_SGN_NO," ).append("\n"); 
		query.append("VSL_NM," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNTR_SEAL_NO," ).append("\n"); 
		query.append("CNTR_LDIS_DT," ).append("\n"); 
		query.append("STWG_CELL_NO," ).append("\n"); 
		query.append("EDI_RPT_MSG_RCV_DT," ).append("\n"); 
		query.append("EDI_RPT_HDR_MSG," ).append("\n"); 
		query.append("EDI_RPT_MSG," ).append("\n"); 
		query.append("CRR_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNTR_SEAL_NO2," ).append("\n"); 
		query.append("CGO_STS_ID," ).append("\n"); 
		query.append("N1ST_POD_CD," ).append("\n"); 
		query.append("GRS_WGT," ).append("\n"); 
		query.append("CGO_TP_CD," ).append("\n"); 
		query.append("IMDG_CLSS_ID," ).append("\n"); 
		query.append("EUR_TML_DMG_ID," ).append("\n"); 
		query.append("TRSP_MOD_ID," ).append("\n"); 
		query.append("ORG_YD_CD," ).append("\n"); 
		query.append("EXP_DT," ).append("\n"); 
		query.append("CSTMS_DECL_NO," ).append("\n"); 
		query.append("CNTR_TARE_WGT," ).append("\n"); 
		query.append("TML_MSG_MTCH_ID," ).append("\n"); 
		query.append("CNTR_LODG_DCHG_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT)" ).append("\n"); 
		query.append("VALUES	(RTRIM(@[edi_sndr_id])," ).append("\n"); 
		query.append("RTRIM(@[evnt_yd_cd])," ).append("\n"); 
		query.append("RTRIM(@[tml_vvd_id])," ).append("\n"); 
		query.append("RTRIM(@[pol_cd])," ).append("\n"); 
		query.append("RTRIM(@[pod_cd])," ).append("\n"); 
		query.append("RTRIM(@[cntr_no])," ).append("\n"); 
		query.append("RTRIM(SUBSTR(@[co_rpt_id],1,5))," ).append("\n"); 
		query.append("RTRIM(@[call_sgn_no])," ).append("\n"); 
		query.append("RTRIM(@[vsl_nm])," ).append("\n"); 
		query.append("RTRIM(@[bkg_no])," ).append("\n"); 
		query.append("RTRIM(@[cntr_seal_no])," ).append("\n"); 
		query.append("TO_DATE(@[cntr_ldis_dt],'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("RTRIM(@[stwg_cell_no])," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("RTRIM(@[edi_rpt_hdr_msg])," ).append("\n"); 
		query.append("RTRIM(@[edi_rpt_msg])," ).append("\n"); 
		query.append("RTRIM(@[crr_cd])," ).append("\n"); 
		query.append("RTRIM(@[cntr_tpsz_cd])," ).append("\n"); 
		query.append("RTRIM(@[cntr_seal_no2])," ).append("\n"); 
		query.append("RTRIM(@[cgo_sts_id])," ).append("\n"); 
		query.append("RTRIM(@[n1st_pod_cd])," ).append("\n"); 
		query.append("NVL(RTRIM(@[grs_wgt]),0)," ).append("\n"); 
		query.append("RTRIM(@[cgo_tp_cd])," ).append("\n"); 
		query.append("RTRIM(@[imdg_clss_id])," ).append("\n"); 
		query.append("RTRIM(@[eur_tml_dmg_id])," ).append("\n"); 
		query.append("RTRIM(@[trsp_mod_id])," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("TO_DATE(@[exp_dt],'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("RTRIM(@[cstms_decl_no])," ).append("\n"); 
		query.append("NVL(RTRIM(@[cntr_tare_wgt]),0)," ).append("\n"); 
		query.append("NVL(RTRIM(@[tml_msg_mtch_id]),'')," ).append("\n"); 
		query.append("RTRIM(@[cntr_lodg_dchg_cd])," ).append("\n"); 
		query.append("RTRIM(@[cre_usr_id])," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("RTRIM(@[cre_usr_id])," ).append("\n"); 
		query.append("SYSDATE)" ).append("\n"); 

	}
}