/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchEdi301BlVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.29
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.03.29 정인선
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

public class GeneralBookingSearchDBDAOsearchEdi301BlVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi301BlVvd
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchEdi301BlVvdRSQL(){
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
		query.append("FileName : GeneralBookingSearchDBDAOsearchEdi301BlVvdRSQL").append("\n"); 
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
		query.append("SELECT '{BL_VVD'																          || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDCODE:'			|| VVD.VSL_CD										          || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDLOYD:'			|| VSL.LLOYD_NO	    								          || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDVSLNAME:'		|| VSL.VSL_ENG_NM									          || CHR(10)" ).append("\n"); 
		query.append("    || 'VVDVSL_CALL_SIGN:'	|| VSL.CALL_SGN_NO  								          || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDVOY:'			|| VVD.SKD_VOY_NO    								          || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDDIR:'			|| VVD.SKD_DIR_CD									          || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVD_CONSORTIUM_VOY_NO:' || VSK_COMMON_PKG.GET_CSSM_VOY_NO_FNC(VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD,VVD.POL_CD,'O') || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVD_SERVICE_LCD:'																  || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDPOLUNLC:'		|| VVD.POL_CD										          || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDPOLQUAL:'		|| DECODE(LENGTH(POL.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')   || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDPOLPORT:'		|| POL.LOC_AMS_PORT_CD										  || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDPOLNAME:'		|| POL.LOC_NM										          || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDPOL_CNT_NM:'		|| (SELECT MC.CNT_NM FROM MDM_COUNTRY MC WHERE MC.CNT_CD = SUBSTR(VVD.POL_CD,1,2) AND ROWNUM = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDPODUNLC:'		|| VVD.POD_CD										          || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDPODQUAL:'		|| DECODE(LENGTH(POD.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')   || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDPODPORT:'		|| POD.LOC_AMS_PORT_CD										  || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDPODNAME:'		|| POD.LOC_NM										          || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDPOD_CNT_NM:'		|| (SELECT MC.CNT_NM FROM MDM_COUNTRY MC WHERE MC.CNT_CD = SUBSTR(VVD.POD_CD,1,2) AND ROWNUM = 1) || CHR(10)" ).append("\n"); 
		query.append("    || 'REF1VVDVOY:'	                                                                  || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDPOLETA:'			|| TO_CHAR(POL_SKD.VPS_ETA_DT, 'RRRRMMDDHH24MI')	          || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDPOLETD:'			|| TO_CHAR(POL_SKD.VPS_ETD_DT, 'RRRRMMDDHH24MI')	          || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDPOLETD_GTM:'		|| TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(VVD.POL_CD,POL_SKD.VPS_ETD_DT,'GMT'), 'RRRRMMDDHH24MI')	          || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDPODETA:'			|| TO_CHAR(POD_SKD.VPS_ETA_DT, 'RRRRMMDDHH24MI')	          || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVDPODETA_GTM:'		|| TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(VVD.POD_CD,POD_SKD.VPS_ETA_DT,'GMT'), 'RRRRMMDDHH24MI')	          || CHR(10)" ).append("\n"); 
		query.append("	|| '}BL_VVD'																		  BL_VVD" ).append("\n"); 
		query.append("  FROM bkg_vvd VVD" ).append("\n"); 
		query.append("		, VSK_VSL_PORT_SKD POL_SKD" ).append("\n"); 
		query.append("		, VSK_VSL_PORT_SKD POD_SKD" ).append("\n"); 
		query.append("		, MDM_location POL, MDM_location POD" ).append("\n"); 
		query.append("		, MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append(" WHERE VVD.pol_cd		    = POL.loc_cd" ).append("\n"); 
		query.append("   AND VVD.pod_cd		    = POD.loc_cd" ).append("\n"); 
		query.append("   AND VVD.VSL_CD		    = VSL.VSL_CD(+)" ).append("\n"); 
		query.append("   AND VVD.VSL_CD		    = POL_SKD.VSL_CD(+)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO	    = POL_SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD		= POL_SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND VVD.POL_CD		    = POL_SKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND VVD.POL_CLPT_IND_SEQ = POL_SKD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("   AND VVD.VSL_CD		    = POD_SKD.VSL_CD(+)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO	    = POD_SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD		= POD_SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND VVD.POD_CD		    = POD_SKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND VVD.POD_CLPT_IND_SEQ = POD_SKD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("   AND VVD.bkg_no		    = @[bkg_no]" ).append("\n"); 
		query.append(" ORDER BY VVD.VSL_PRE_PST_CD, VVD.VSL_SEQ" ).append("\n"); 

	}
}