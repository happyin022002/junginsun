/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOSearchRfaAvailableRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.05.06 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchRfaAvailableRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA의 가용성을 확인한다.
	  * </pre>
	  */
	public BookingUtilDBDAOSearchRfaAvailableRSQL(){
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
		params.put("application_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchRfaAvailableRSQL").append("\n"); 
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
		query.append("#if (${page_type}== 'ESM_BKG_0079_08')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT count(1) cnt        " ).append("\n"); 
		query.append("	FROM PRI_RP_HDR HDR" ).append("\n"); 
		query.append("	    , PRI_RP_MN MAIN" ).append("\n"); 
		query.append("	    , (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("				WHEN LENGTH(RT_APLY_DT) > 0   THEN  " ).append("\n"); 
		query.append("	#if (${application_date} != '')" ).append("\n"); 
		query.append("		(select to_date(@[application_date]||'0000','yyyymmddhh24mi') from dual) " ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		RT_APLY_DT" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		#if (${application_date} != '')" ).append("\n"); 
		query.append("					WHEN '1' > 0 THEN 		(select to_date(@[application_date]||'0000','yyyymmddhh24mi') from dual) " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("				WHEN LENGTH(VPS_ETD_DT) > 0   THEN  VPS_ETD_DT" ).append("\n"); 
		query.append("				WHEN LENGTH(BKG_CRE_DT) > 0   THEN  BKG_CRE_DT" ).append("\n"); 
		query.append("				ELSE sysdate" ).append("\n"); 
		query.append("			END	APPL_DT" ).append("\n"); 
		query.append("		FROM " ).append("\n"); 
		query.append("			#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("			    BKG_BKG_HIS  BKG, " ).append("\n"); 
		query.append("					BKG_RT_HIS  RATE,  " ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			    BKG_BOOKING  BKG, " ).append("\n"); 
		query.append("			    BKG_RATE  RATE, " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("		    BK.BKG_NO," ).append("\n"); 
		query.append("		    (SELECT VPS_ETD_DT " ).append("\n"); 
		query.append("		     FROM VSK_VSL_PORT_SKD S2" ).append("\n"); 
		query.append("		     WHERE S2.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("		       AND S2.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("		       AND S2.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("		       AND S2.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("		       AND S2.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ) VPS_ETD_DT," ).append("\n"); 
		query.append("		    VVD.VSL_CD," ).append("\n"); 
		query.append("		    VVD.SKD_VOY_NO," ).append("\n"); 
		query.append("		    VVD.SKD_DIR_CD," ).append("\n"); 
		query.append("		    VVD.POL_CD," ).append("\n"); 
		query.append("		    VVD.POL_CLPT_IND_SEQ " ).append("\n"); 
		query.append("		 FROM " ).append("\n"); 
		query.append("			#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("				BKG_BKG_HIS BK, BKG_VVD_HIS VVD" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				BKG_BOOKING BK, BKG_VVD VVD" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("		AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("		AND BK.BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("			#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("				AND BK.corr_no 		  = 'TMP0000001'" ).append("\n"); 
		query.append("				AND VVD.corr_no 		  = 'TMP0000001'	" ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("	)  VVD" ).append("\n"); 
		query.append("	WHERE	BKG.BKG_NO=RATE.BKG_NO" ).append("\n"); 
		query.append("	AND BKG.BKG_NO=VVD.BKG_NO(+)" ).append("\n"); 
		query.append("			#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("				AND BKG.corr_no 		  = 'TMP0000001'" ).append("\n"); 
		query.append("				AND RATE.corr_no 		  = 'TMP0000001'	" ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		AND BKG.BKG_NO=@[bkg_no]  	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") appl_dt" ).append("\n"); 
		query.append("	WHERE HDR.PROP_NO = MAIN.PROP_NO" ).append("\n"); 
		query.append("	and MAIN.eff_dt - 0.0001 < APPL_DT.APPL_DT" ).append("\n"); 
		query.append("	AND MAIN.exp_dt + 0.9999 > APPL_DT.APPL_DT" ).append("\n"); 
		query.append("	and main.prop_sts_cd = 'A'" ).append("\n"); 
		query.append("	and hdr.rfa_no = @[rfa_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT count(1) cnt        " ).append("\n"); 
		query.append("	FROM PRI_RP_HDR HDR" ).append("\n"); 
		query.append("	    , PRI_RP_MN MAIN" ).append("\n"); 
		query.append("	    , (select appl_dt" ).append("\n"); 
		query.append("         from " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("            select 1 rank, RT_APLY_DT appl_dt " ).append("\n"); 
		query.append("              from bkg_rt_his r" ).append("\n"); 
		query.append("             where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("			   and corr_no = 'TMP0000001'" ).append("\n"); 
		query.append("               and rt_aply_dt is not null" ).append("\n"); 
		query.append("			union all" ).append("\n"); 
		query.append("			select 2 rank, RT_APLY_DT appl_dt --rate applicable" ).append("\n"); 
		query.append("              from bkg_rate r" ).append("\n"); 
		query.append("             where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("               and rt_aply_dt is not null" ).append("\n"); 
		query.append("            union all" ).append("\n"); 
		query.append("            select 3 rank, skd.vps_etd_dt appl_dt --onboard date" ).append("\n"); 
		query.append("              from bkg_vvd_his vvd, vsk_vsl_port_skd skd, bkg_bkg_his bk" ).append("\n"); 
		query.append("             where bk.bkg_no          = @[bkg_no] " ).append("\n"); 
		query.append("			   and bk.corr_no 		  = 'TMP0000001'" ).append("\n"); 
		query.append("			   and vvd.corr_no 		  = 'TMP0000001'" ).append("\n"); 
		query.append("               and bk.bkg_no          = vvd.bkg_no" ).append("\n"); 
		query.append("               and vvd.vsl_pre_pst_cd in ('S', 'T')" ).append("\n"); 
		query.append("               and vvd.pol_cd         = bk.pol_cd" ).append("\n"); 
		query.append("               and vvd.vsl_cd         = skd.vsl_cd" ).append("\n"); 
		query.append("               and vvd.skd_voy_no     = skd.skd_voy_no" ).append("\n"); 
		query.append("               and vvd.skd_dir_cd     = skd.skd_dir_cd" ).append("\n"); 
		query.append("               and vvd.pol_cd         = skd.vps_port_cd" ).append("\n"); 
		query.append("               and vvd.pol_CLPT_IND_SEQ = skd.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            union all" ).append("\n"); 
		query.append("            select 4 rank, skd.vps_etd_dt appl_dt --onboard date" ).append("\n"); 
		query.append("              from bkg_vvd vvd, vsk_vsl_port_skd skd, bkg_booking bk" ).append("\n"); 
		query.append("             where bk.bkg_no          = @[bkg_no] " ).append("\n"); 
		query.append("               and bk.bkg_no          = vvd.bkg_no" ).append("\n"); 
		query.append("               and vvd.vsl_pre_pst_cd in ('S', 'T')" ).append("\n"); 
		query.append("               and vvd.pol_cd         = bk.pol_cd" ).append("\n"); 
		query.append("               and vvd.vsl_cd         = skd.vsl_cd" ).append("\n"); 
		query.append("               and vvd.skd_voy_no     = skd.skd_voy_no" ).append("\n"); 
		query.append("               and vvd.skd_dir_cd     = skd.skd_dir_cd" ).append("\n"); 
		query.append("               and vvd.pol_cd         = skd.vps_port_cd" ).append("\n"); 
		query.append("               and vvd.pol_CLPT_IND_SEQ = skd.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            union all " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            select 5 rank, sysdate appl_dt" ).append("\n"); 
		query.append("              from dual)   " ).append("\n"); 
		query.append("        where rownum = 1) appl" ).append("\n"); 
		query.append("	WHERE HDR.PROP_NO = MAIN.PROP_NO" ).append("\n"); 
		query.append("	and MAIN.eff_dt - 0.0001 < APPL.APPL_DT" ).append("\n"); 
		query.append("	AND MAIN.exp_dt + 0.9999 > APPL.APPL_DT" ).append("\n"); 
		query.append("	and main.prop_sts_cd ='A'" ).append("\n"); 
		query.append("	and hdr.rfa_no = @[rfa_no]			" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}