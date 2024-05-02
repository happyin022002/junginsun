/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchVGMOutboundCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.12
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.07.12 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchVGMOutboundCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVGMOutbound
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchVGMOutboundCntrRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchVGMOutboundCntrRSQL").append("\n"); 
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
		query.append("select CNTR FLAT_FILE from (" ).append("\n"); 
		query.append("       select ''" ).append("\n"); 
		query.append("        ||CHR(10)||'{CNTR'" ).append("\n"); 
		query.append("        ||CHR(10)||'VSL_CD:'        || bk.vsl_cd" ).append("\n"); 
		query.append("        ||CHR(10)||'VSL_VOY:'       || bk.skd_voy_no" ).append("\n"); 
		query.append("        ||CHR(10)||'VSL_DIR:'       || bk.skd_dir_cd" ).append("\n"); 
		query.append("        ||CHR(10)||'VSL_NAME:'      || vsl.vsl_eng_nm" ).append("\n"); 
		query.append("        ||CHR(10)||'VSL_LLOYD:'     || vsl.lloyd_no" ).append("\n"); 
		query.append("        ||CHR(10)||'CNTR_NO:'       || bc.cntr_no" ).append("\n"); 
		query.append("        ||CHR(10)||'CNTR_TP:'       || bc.cntr_tpsz_cd" ).append("\n"); 
		query.append("        ||CHR(10)||'BKG_NO:'        || bc.bkg_no" ).append("\n"); 
		query.append("        ||CHR(10)||'VGM_WGTQTY:'    || bc.VGM_WGT" ).append("\n"); 
		query.append("        ||CHR(10)||'VGM_WGTCD:'     || bc.VGM_WGT_UT_CD" ).append("\n"); 
		query.append("        ||CHR(10)||'VGM_METHOD:'    || bc.VGM_MZD_TP_CD" ).append("\n"); 
		query.append("        ||CHR(10)||'VGM_DMT_DT:'    || to_char(VGM_DTMN_DT,'RRRRMMDDHH24MI')" ).append("\n"); 
		query.append("        ||CHR(10)||'VGM_VERI_DT:'   || to_char(VGM_VRFY_DT,'RRRRMMDDHH24MI')" ).append("\n"); 
		query.append("        || (RTRIM (XMLAGG (XMLELEMENT (e, CNTR_SEAL || '')).EXTRACT ('//text()'),','))" ).append("\n"); 
		query.append("        || (RTRIM (XMLAGG (XMLELEMENT (e, CNTR_PARTY || '')).EXTRACT ('//text()'),','))" ).append("\n"); 
		query.append("        ||CHR(10)||'}CNTR' CNTR" ).append("\n"); 
		query.append("    from bkg_booking   bk," ).append("\n"); 
		query.append("         bkg_container bc, " ).append("\n"); 
		query.append("         mdm_vsl_cntr  vsl," ).append("\n"); 
		query.append("                (select ''" ).append("\n"); 
		query.append("                ||CHR(10)||'{CNTR_SEAL'" ).append("\n"); 
		query.append("                ||CHR(10)||'SEAL_NO:' || CNTR_SEAL_NO" ).append("\n"); 
		query.append("                ||CHR(10)||'}CNTR_SEAL' CNTR_SEAL, CNTR_NO, BKG_NO" ).append("\n"); 
		query.append("                from bkg_cntr_seal_no" ).append("\n"); 
		query.append("				where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("                ) cs," ).append("\n"); 
		query.append("                (select * from (select ''" ).append("\n"); 
		query.append("                ||CHR(10)||'{CNTR_PARTY'" ).append("\n"); 
		query.append("                ||CHR(10)||'PARTY_FUNC_CD:SPC' --I'm SPC" ).append("\n"); 
		query.append("                --||CHR(10)||'PARTY_NM:'      || VGM_PTY_ID" ).append("\n"); 
		query.append("                --||CHR(10)||'PARTY_ADDR:'    || VGM_PTY_ADDR" ).append("\n"); 
		query.append("                ||CHR(10)||'PARTY_PERSON:'  || REPLACE(REPLACE(REPLACE(VGM_VRFY_SIG_CTNT,CHR(13)||CHR(10),' '),CHR(13),' '),CHR(10),' ') " ).append("\n"); 
		query.append("                --||CHR(10)||'PARTY_TEL:'     || VGM_PTY_CNTC_PHN_NO" ).append("\n"); 
		query.append("                --||CHR(10)||'PARTY_EMAIL:'   || VGM_PTY_EML" ).append("\n"); 
		query.append("                --||CHR(10)||'PARTY_FAX:'     || VGM_PTY_FAX_NO" ).append("\n"); 
		query.append("                ||CHR(10)||'}CNTR_PARTY' CNTR_PARTY, a.CNTR_NO, a.BKG_NO, RANK() OVER (ORDER BY 1 DESC ) as rk" ).append("\n"); 
		query.append("                from bkg_container a" ).append("\n"); 
		query.append("                where 1=1" ).append("\n"); 
		query.append("                and a.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("                ) pty where pty.rk = 1 ) pty" ).append("\n"); 
		query.append("    where bk.bkg_no = bc.bkg_no" ).append("\n"); 
		query.append("    and bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("    and bc.bkg_no = cs.bkg_no(+)" ).append("\n"); 
		query.append("    and bc.cntr_no = cs.CNTR_NO(+) " ).append("\n"); 
		query.append("    and bc.bkg_no = pty.bkg_no(+)" ).append("\n"); 
		query.append("    and bc.cntr_no = pty.CNTR_NO(+)" ).append("\n"); 
		query.append("    and bc.vgm_wgt is not null" ).append("\n"); 
		query.append("    and bk.vsl_cd = vsl.vsl_cd(+)" ).append("\n"); 
		query.append("    group by bc.cntr_no," ).append("\n"); 
		query.append("             bc.cntr_tpsz_cd," ).append("\n"); 
		query.append("             bc.bkg_no," ).append("\n"); 
		query.append("             bc.VGM_WGT," ).append("\n"); 
		query.append("             bc.VGM_WGT_UT_CD," ).append("\n"); 
		query.append("             bc.VGM_MZD_TP_CD," ).append("\n"); 
		query.append("             to_char(VGM_DTMN_DT,'RRRRMMDDHH24MI')," ).append("\n"); 
		query.append("             to_char(VGM_VRFY_DT,'RRRRMMDDHH24MI')," ).append("\n"); 
		query.append("             bk.vsl_cd," ).append("\n"); 
		query.append("             bk.skd_voy_no," ).append("\n"); 
		query.append("             bk.skd_dir_cd," ).append("\n"); 
		query.append("             vsl.vsl_eng_nm," ).append("\n"); 
		query.append("             vsl.lloyd_no)" ).append("\n"); 

	}
}