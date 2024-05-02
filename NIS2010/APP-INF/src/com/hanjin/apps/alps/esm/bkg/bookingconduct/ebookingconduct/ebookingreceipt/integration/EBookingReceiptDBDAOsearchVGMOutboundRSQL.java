/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchVGMOutboundRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.08
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.07.08 윤용상
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

public class EBookingReceiptDBDAOsearchVGMOutboundRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVGMOutbound
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchVGMOutboundRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brac",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchVGMOutboundRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("'{VERMAS'" ).append("\n"); 
		query.append("||CHR(10)||'REF_NO:' || bk.BKG_NO" ).append("\n"); 
		query.append("||CHR(10)||'FUNC_CD:' || @[brac] --" ).append("\n"); 
		query.append("||CHR(10)||'ISSUE_DATE:' || to_char(sysdate,'RRRRMMDDHH24MI')" ).append("\n"); 
		query.append("||CHR(10)||'CUT_OFF_TIME:' || (SELECT NVL(TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), 'RRRRMMDDHH24MI'),SYS_SET_DT_DESC)" ).append("\n"); 
		query.append("				             FROM BKG_CLZ_TM CLZ" ).append("\n"); 
		query.append("				            WHERE CLZ.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				              AND NTC_FLG = 'Y'" ).append("\n"); 
		query.append("				              AND CLZ_TP_CD = 'V') " ).append("\n"); 
		query.append("||CHR(10)||'POR_NAME:' || (select LOC_NM from mdm_location where loc_cd = bk.por_cd)" ).append("\n"); 
		query.append("||CHR(10)||'POR_UNLC:' || bk.por_cd" ).append("\n"); 
		query.append("||CHR(10)||'POR_YDCD:' || bk.por_nod_cd" ).append("\n"); 
		query.append("||CHR(10)||'POL_NAME:' || (select LOC_NM from mdm_location where loc_cd = bk.pol_cd)" ).append("\n"); 
		query.append("||CHR(10)||'POL_UNLC:' || bk.pol_cd" ).append("\n"); 
		query.append("||CHR(10)||'POL_YDCD:' || bk.pol_nod_cd" ).append("\n"); 
		query.append("--||CHR(10)||'SUBMIT_NAME:' || ''" ).append("\n"); 
		query.append("--||CHR(10)||'SUBMIT_ADDR:' " ).append("\n"); 
		query.append("--||CHR(10)||'SUBMIT_DETAIL:' " ).append("\n"); 
		query.append("--||CHR(10)||'SUBMIT_EMAIL:' " ).append("\n"); 
		query.append("--||CHR(10)||'SUBMIT_TEL:' " ).append("\n"); 
		query.append("||('$VGM_BODY$')" ).append("\n"); 
		query.append("||CHR(10)||'}VERMAS' as FLAT_FILE" ).append("\n"); 
		query.append("from bkg_booking bk" ).append("\n"); 
		query.append("   , bkg_container bc" ).append("\n"); 
		query.append("where bk.bkg_no = bc.bkg_no" ).append("\n"); 
		query.append("and bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and bc.vgm_wgt is not null" ).append("\n"); 
		query.append("and bc.vgm_wgt > 0" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 

	}
}