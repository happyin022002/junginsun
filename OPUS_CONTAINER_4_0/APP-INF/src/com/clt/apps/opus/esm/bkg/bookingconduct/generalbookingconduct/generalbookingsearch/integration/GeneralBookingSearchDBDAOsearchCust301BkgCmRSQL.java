/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchCust301BkgCmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.23
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.05.23 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchCust301BkgCmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCust301BkgCm
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchCust301BkgCmRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchCust301BkgCmRSQL").append("\n"); 
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
		query.append("SELECT '{CM_MARK_DESC'                             ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_SEQ:'     ||ROWNUM               ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_CNTR_NO:' ||NVL(MF.CNTR_NO, '')          ||CHR(10)||        " ).append("\n"); 
		query.append("        'CMD_HTS_CD:'  ||NVL(MF.HAMO_TRF_CD, '')      ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_PKG_CD:'  ||NVL(MF.PCK_TP_CD, '')        ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_PKG_QTY:' ||NVL(MF.Pck_QTY, 0)           ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_WGT_TP:'  ||NVL(MF.WGT_ut_cd, '')        ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_WGT_QTY:' ||NVL(MF.Cntr_mf_WGT, 0)       ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_NET_WGT_TP:'  ||NVL(MF.WGT_ut_cd, '')        ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_NET_WGT_QTY:' ||NVL(MF.Cntr_mf_WGT, 0)       ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_MEA_TP:'  ||NVL(MF.MEAs_ut_cd, '')       ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_MEA_QTY:' ||NVL(MF.MEAs_QTY, 0)          ||CHR(10)||" ).append("\n"); 
		query.append("		'CMD_DESC:'    ||REPLACE(NVL(CNTR_MF_GDS_DESC, ''),CHR(10),' ') ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_MARK:'    ||REPLACE(NVL(CNTR_MF_MK_DESC, ' '),CHR(10),' ') ||CHR(10)||" ).append("\n"); 
		query.append("		'CMD_CD:'      ||CHR(10)||" ).append("\n"); 
		query.append("		'CMD_OB_HAUL_TP:' ||  CASE WHEN POL.CONTI_CD <> 'E' THEN DECODE(BC.RCV_TERM_CD,'D','C','M')" ).append("\n"); 
		query.append("                                            ELSE NVL((SELECT ETRO.HLG_TP_CD FROM BKG_EUR_TRO ETRO WHERE ETRO.BKG_NO = BK.BKG_NO AND ETRO.IO_BND_CD = 'O' AND ETRO.CXL_FLG = 'N' AND ROWNUM = 1),DECODE(BC.RCV_TERM_CD,'D','C','M'))" ).append("\n"); 
		query.append("                                   END   ||CHR(10)||" ).append("\n"); 
		query.append("		'CMD_IB_HAUL_TP:' ||  CASE WHEN POD.CONTI_CD <> 'E' THEN DECODE(BC.DE_TERM_CD,'D','C','M')" ).append("\n"); 
		query.append("                                            ELSE NVL((SELECT ETRO.HLG_TP_CD FROM BKG_EUR_TRO ETRO WHERE ETRO.BKG_NO = BK.BKG_NO AND ETRO.IO_BND_CD = 'I' AND ETRO.CXL_FLG = 'N' AND ROWNUM = 1),DECODE(BC.RCV_TERM_CD,'D','C','M'))" ).append("\n"); 
		query.append("                                   END   ||CHR(10)||" ).append("\n"); 
		query.append("        '}CM_MARK_DESC'                            ||CHR(10) CM_MARK_DESC" ).append("\n"); 
		query.append("  FROM bkg_cntr_mf_desc MF" ).append("\n"); 
		query.append("	   , BKG_BOOKING BK" ).append("\n"); 
		query.append("     , MDM_LOCATION POL" ).append("\n"); 
		query.append("     , MDM_LOCATION POD" ).append("\n"); 
		query.append("     , BKG_CONTAINER BC" ).append("\n"); 
		query.append(" WHERE MF.bkg_no   = @[bkg_no]" ).append("\n"); 
		query.append(" AND MF.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append(" AND MF.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append(" AND MF.CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append(" AND BK.POL_CD = POL.LOC_CD" ).append("\n"); 
		query.append(" AND BK.POD_CD = POD.LOC_CD" ).append("\n"); 
		query.append(" ORDER BY ROWNUM" ).append("\n"); 

	}
}