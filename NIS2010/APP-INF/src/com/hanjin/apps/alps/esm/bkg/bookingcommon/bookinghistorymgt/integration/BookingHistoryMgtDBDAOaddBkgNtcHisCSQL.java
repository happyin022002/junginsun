/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOaddBkgNtcHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.20
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2016.06.20 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dongsun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOaddBkgNtcHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking의 Notice History를 기록한다.
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOaddBkgNtcHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ntc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_ppd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cntc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flt_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ntc_snd_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_chg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("esvc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cntc_amd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_edi_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_all_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgor_rcvr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_fom_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("frt_hdn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_arr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_via_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_ntc_snd_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgor_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_hdn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_rty_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("frt_clt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOaddBkgNtcHisCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_NTC_HIS (" ).append("\n"); 
		query.append("	BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	HIS_SEQ" ).append("\n"); 
		query.append(",	NTC_VIA_CD" ).append("\n"); 
		query.append(",	NTC_KND_CD" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	AGN_CD" ).append("\n"); 
		query.append(",	NTC_FOM_CD" ).append("\n"); 
		query.append(",	NTC_SEQ" ).append("\n"); 
		query.append(",	CUST_CNTC_TP_CD" ).append("\n"); 
		query.append(",	NTC_FAX_NO" ).append("\n"); 
		query.append(",	NTC_EML" ).append("\n"); 
		query.append(",	SND_ID" ).append("\n"); 
		query.append(",	EDI_ID" ).append("\n"); 
		query.append(",   DO_EDI_TP_CD" ).append("\n"); 
		query.append(",	ESVC_GRP_CD" ).append("\n"); 
		query.append(",	BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append(",	TML_NTC_SND_STS_CD" ).append("\n"); 
		query.append(",	CGOR_RCVR_TP_CD" ).append("\n"); 
		query.append(",	CGOR_STS_CD" ).append("\n"); 
		query.append(",	FRT_HDN_FLG" ).append("\n"); 
		query.append(",	FRT_ALL_FLG" ).append("\n"); 
		query.append(",	FRT_CLT_FLG" ).append("\n"); 
		query.append(",	FRT_PPD_FLG" ).append("\n"); 
		query.append(",	FRT_CHG_FLG" ).append("\n"); 
		query.append(",	FRT_ARR_FLG" ).append("\n"); 
		query.append(",	SND_OFC_CD" ).append("\n"); 
		query.append(",	SND_USR_ID" ).append("\n"); 
		query.append(",	SND_RQST_DT" ).append("\n"); 
		query.append(",	SND_RQST_GDT" ).append("\n"); 
		query.append(",	SND_RTY_KNT" ).append("\n"); 
		query.append(",	SND_DT" ).append("\n"); 
		query.append(",   SND_GDT" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	CUST_CNTC_AMD_FLG" ).append("\n"); 
		query.append(",	DP_HDN_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",   PHN_NO" ).append("\n"); 
		query.append(",   FLT_FILE_REF_NO" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[bkg_cust_tp_cd]" ).append("\n"); 
		query.append(",	@[bkg_no]" ).append("\n"); 
		query.append(",	BKG_NTC_HIS_SEQ.NEXTVAL" ).append("\n"); 
		query.append(",	@[ntc_via_cd]" ).append("\n"); 
		query.append(",	@[ntc_knd_cd]" ).append("\n"); 
		query.append(",	@[cntr_no]" ).append("\n"); 
		query.append(",	@[agn_cd]" ).append("\n"); 
		query.append(",	@[ntc_fom_cd]" ).append("\n"); 
		query.append(",	@[ntc_seq]" ).append("\n"); 
		query.append(",	@[cust_cntc_tp_cd]" ).append("\n"); 
		query.append(",	@[ntc_fax_no]" ).append("\n"); 
		query.append(",	@[ntc_eml]" ).append("\n"); 
		query.append(",	@[snd_id]" ).append("\n"); 
		query.append(",	@[edi_id]" ).append("\n"); 
		query.append(",   @[do_edi_tp_cd]" ).append("\n"); 
		query.append(",	@[esvc_grp_cd]" ).append("\n"); 
		query.append(",	@[bkg_ntc_snd_rslt_cd]" ).append("\n"); 
		query.append(",	@[tml_ntc_snd_sts_cd]" ).append("\n"); 
		query.append(",	@[cgor_rcvr_tp_cd]" ).append("\n"); 
		query.append(",	@[cgor_sts_cd]" ).append("\n"); 
		query.append(",	@[frt_hdn_flg]" ).append("\n"); 
		query.append(",	@[frt_all_flg]" ).append("\n"); 
		query.append(",	@[frt_clt_flg]" ).append("\n"); 
		query.append(",	@[frt_ppd_flg]" ).append("\n"); 
		query.append(",	@[frt_chg_flg]" ).append("\n"); 
		query.append(",	@[frt_arr_flg]" ).append("\n"); 
		query.append(",	@[snd_ofc_cd]" ).append("\n"); 
		query.append(",	@[snd_usr_id]" ).append("\n"); 
		query.append(",	CASE WHEN @[ntc_knd_cd] = 'BL' AND @[cre_usr_id] = 'SYSTEM' THEN SYSDATE" ).append("\n"); 
		query.append("		 WHEN @[ntc_knd_cd] IN ('BT','BK','BL','FC','CN','EX','SN','HO','WB','PS','TM','SS','SB','VM') THEN " ).append("\n"); 
		query.append("			DECODE(@[cre_usr_id],'ESM_BKG_B026',SYSDATE,'ESM_BKG_B032',SYSDATE,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, NVL(BKG_COM_USER_LOC_FNC(@[cre_usr_id]),(SELECT POR_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]))))" ).append("\n"); 
		query.append("		 ELSE 	" ).append("\n"); 
		query.append("			TO_DATE(@[snd_rqst_dt],'YYYYMMDD HH24MISS') END" ).append("\n"); 
		query.append(",   GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', sysdate, 'GMT')" ).append("\n"); 
		query.append(",	@[snd_rty_knt]" ).append("\n"); 
		query.append(",	CASE WHEN @[ntc_knd_cd] = 'BL' AND @[cre_usr_id] = 'SYSTEM' THEN SYSDATE" ).append("\n"); 
		query.append("		 WHEN @[ntc_knd_cd] IN ('BT','BK','BL','FC','CN','EX','SN','HO','WB','PS','TM','SS','SB','VM') THEN " ).append("\n"); 
		query.append("			DECODE(@[cre_usr_id],'ESM_BKG_B026',SYSDATE,'ESM_BKG_B032',SYSDATE,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, NVL(BKG_COM_USER_LOC_FNC(@[cre_usr_id]),(SELECT POR_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]))))" ).append("\n"); 
		query.append("		 ELSE 	" ).append("\n"); 
		query.append("			TO_DATE(@[snd_rqst_dt],'YYYYMMDD HH24MISS') END" ).append("\n"); 
		query.append(",   GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', sysdate, 'GMT')" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",	@[cust_cntc_amd_flg]" ).append("\n"); 
		query.append(",	@[dp_hdn_flg]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",   @[phn_no]" ).append("\n"); 
		query.append(",   @[flt_file_ref_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}