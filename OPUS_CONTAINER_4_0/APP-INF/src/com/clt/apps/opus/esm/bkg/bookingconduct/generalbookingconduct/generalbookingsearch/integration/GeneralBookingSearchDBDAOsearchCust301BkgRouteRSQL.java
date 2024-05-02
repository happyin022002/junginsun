/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchCust301BkgRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchCust301BkgRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCust301BkgRoute
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchCust301BkgRouteRSQL(){
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
		query.append("FileName : GeneralBookingSearchDBDAOsearchCust301BkgRouteRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       '{I_BKG_ROUTE'							        ||CHR(10)||" ).append("\n"); 
		query.append("       'ROUTE_TP_CD:'		||DECODE(DTL.PCTL_IO_BND_CD,'O','OB'||CASE WHEN (SELECT MIN(INDTL.PCTL_SEQ)" ).append("\n"); 
		query.append("                                                                         FROM PRD_PROD_CTL_ROUT_DTL INDTL " ).append("\n"); 
		query.append("                                                                         WHERE INDTL.PCTL_NO = DTL.PCTL_NO" ).append("\n"); 
		query.append("                                                                         AND INDTL.TRSP_MOD_CD <> 'X') =  DTL.PCTL_SEQ" ).append("\n"); 
		query.append("                                                                          THEN 'DR' ELSE 'IM' END" ).append("\n"); 
		query.append("                                                   ,'I','IB'||CASE WHEN (SELECT MAX(INDTL.PCTL_SEQ)" ).append("\n"); 
		query.append("                                                                         FROM PRD_PROD_CTL_ROUT_DTL INDTL " ).append("\n"); 
		query.append("                                                                         WHERE INDTL.PCTL_NO = DTL.PCTL_NO" ).append("\n"); 
		query.append("                                                                         AND INDTL.TRSP_MOD_CD <> 'X') =  DTL.PCTL_SEQ" ).append("\n"); 
		query.append("                                                                          THEN 'DR' ELSE 'IM' END" ).append("\n"); 
		query.append("                                                   ,'T',CASE WHEN (SELECT MIN(INDTL.PCTL_SEQ)" ).append("\n"); 
		query.append("                                                                         FROM PRD_PROD_CTL_ROUT_DTL INDTL " ).append("\n"); 
		query.append("                                                                         WHERE INDTL.PCTL_NO = DTL.PCTL_NO" ).append("\n"); 
		query.append("                                                                         AND INDTL.TRSP_MOD_CD = 'VD') > DTL.PCTL_SEQ" ).append("\n"); 
		query.append("                                                                          THEN 'OBIM'" ).append("\n"); 
		query.append("                                                             WHEN (SELECT MAX(INDTL.PCTL_SEQ)" ).append("\n"); 
		query.append("                                                                         FROM PRD_PROD_CTL_ROUT_DTL INDTL " ).append("\n"); 
		query.append("                                                                         WHERE INDTL.PCTL_NO = DTL.PCTL_NO" ).append("\n"); 
		query.append("                                                                         AND INDTL.TRSP_MOD_CD = 'VD') < DTL.PCTL_SEQ" ).append("\n"); 
		query.append("                                                                          THEN 'IBIM'" ).append("\n"); 
		query.append("                                                        ELSE 'TRNK' END)				||CHR(10)||  " ).append("\n"); 
		query.append("       'ROUTE_SEQ:'		    ||RANK() OVER (ORDER BY DTL.PCTL_SEQ)				||CHR(10)||" ).append("\n"); 
		query.append("       'ORGFAC_CD:'		    ||DTL.ORG_NOD_CD			||CHR(10)||" ).append("\n"); 
		query.append("       'ORGFAC_NM:'		    ||NVL(MYO.YD_NM,MZO.ZN_NM)  ||CHR(10)||" ).append("\n"); 
		query.append("       'ORGFAC_ADDR1:'		||REPLACE(REPLACE(BKG_TOKEN_NL_FNC(MYO.YD_ADDR, 1, ''), '*', '-'), ':', '-')        		||CHR(10)||									" ).append("\n"); 
		query.append("       'ORGFAC_ADDR2:'		||REPLACE(REPLACE(BKG_TOKEN_NL_FNC(MYO.YD_ADDR, 2, ''), '*', '-'), ':', '-') 				||CHR(10)||" ).append("\n"); 
		query.append("       'ORGFAC_ADDR3:'		||REPLACE(REPLACE(BKG_TOKEN_NL_FNC(MYO.YD_ADDR, 3, ''), '*', '-'), ':', '-') 				||CHR(10)||" ).append("\n"); 
		query.append("       'ORGFAC_ADDR4:'		||REPLACE(REPLACE(BKG_TOKEN_NL_FNC(MYO.YD_ADDR, 4, ''), '*', '-'), ':', '-') 				||CHR(10)||" ).append("\n"); 
		query.append("       'ORGFAC_ADDR5:'		||REPLACE(REPLACE(BKG_TOKEN_NL_FNC(MYO.YD_ADDR, 5, ''), '*', '-'), ':', '-') 				||CHR(10)||" ).append("\n"); 
		query.append("       'ORGFAC_CITY_NM:'	||MLO.LOC_NM		        ||CHR(10)||" ).append("\n"); 
		query.append("       'ORGFAC_STAT_CD:'	||MLO.STE_CD				||CHR(10)||" ).append("\n"); 
		query.append("       'ORGFAC_STAT_NM:'	||(SELECT MS.STE_NM FROM MDM_STATE MS WHERE MS.STE_CD = MLO.STE_CD AND ROWNUM = 1)		||CHR(10)||" ).append("\n"); 
		query.append("       'ORGFAC_CON_NM:'		||MCO.CNT_NM				||CHR(10)||" ).append("\n"); 
		query.append("       'ORGFAC_UNLOC_CD:'	||MLO.UN_LOC_CD				||CHR(10)||" ).append("\n"); 
		query.append("       'ORGFAC_ZIP_CD:'		||MYO.ZIP_CD				||CHR(10)||" ).append("\n"); 
		query.append("       'DESFAC_CD:'		    ||DTL.DEST_NOD_CD			||CHR(10)||" ).append("\n"); 
		query.append("       'DESFAC_NM:'		    ||NVL(MYD.YD_NM,MZD.ZN_NM)  ||CHR(10)||" ).append("\n"); 
		query.append("       'DESFAC_ADDR1:'		||REPLACE(REPLACE(BKG_TOKEN_NL_FNC(MYD.YD_ADDR, 1, ''), '*', '-'), ':', '-')     			||CHR(10)||" ).append("\n"); 
		query.append("       'DESFAC_ADDR2:'		||REPLACE(REPLACE(BKG_TOKEN_NL_FNC(MYD.YD_ADDR, 2, ''), '*', '-'), ':', '-')				||CHR(10)||" ).append("\n"); 
		query.append("       'DESFAC_ADDR3:'		||REPLACE(REPLACE(BKG_TOKEN_NL_FNC(MYD.YD_ADDR, 3, ''), '*', '-'), ':', '-')				||CHR(10)||" ).append("\n"); 
		query.append("       'DESFAC_ADDR4:'		||REPLACE(REPLACE(BKG_TOKEN_NL_FNC(MYD.YD_ADDR, 4, ''), '*', '-'), ':', '-')				||CHR(10)||" ).append("\n"); 
		query.append("       'DESFAC_ADDR5:'		||REPLACE(REPLACE(BKG_TOKEN_NL_FNC(MYD.YD_ADDR, 5, ''), '*', '-'), ':', '-')				||CHR(10)||" ).append("\n"); 
		query.append("       'DESFAC_CITY_NM:'	||MLD.LOC_NM		        ||CHR(10)||" ).append("\n"); 
		query.append("       'DESFAC_STAT_CD:'	||MLD.STE_CD				||CHR(10)||" ).append("\n"); 
		query.append("       'DESFAC_STAT_NM:'	||(SELECT MS.STE_NM FROM MDM_STATE MS WHERE MS.STE_CD = MLD.STE_CD AND ROWNUM = 1)	    ||CHR(10)||" ).append("\n"); 
		query.append("       'DESFAC_CON_NM:'		||MCD.CNT_NM				||CHR(10)||" ).append("\n"); 
		query.append("       'DESFAC_UNLOC_CD:'	||MLD.UN_LOC_CD		  	    ||CHR(10)||" ).append("\n"); 
		query.append("       'DESFAC_ZIP_CD:'		||MYD.ZIP_CD				||CHR(10)||" ).append("\n"); 
		query.append("       CASE WHEN DTL.TRSP_MOD_CD = 'VD' OR (DTL.TRSP_MOD_CD = 'WD' AND DTL.VSL_CD IS NOT NULL) THEN" ).append("\n"); 
		query.append("       'LD_PORT_NM:'		||MLO.LOC_NM				||CHR(10)||" ).append("\n"); 
		query.append("       'DIS_PORT_NM:'		||MLD.LOC_NM				||CHR(10)" ).append("\n"); 
		query.append("       END ||" ).append("\n"); 
		query.append("       'TRANS_MODE_CD:'		||DECODE(SUBSTR(DTL.TRSP_MOD_CD,1,1),'W','F',SUBSTR(DTL.TRSP_MOD_CD,1,1))			    ||CHR(10)||" ).append("\n"); 
		query.append("       'MOTHER_VSL_IND:'	||DECODE(BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD,BV1.VSL_CD||BV1.SKD_VOY_NO||BV1.SKD_DIR_CD,'Y','N')				||CHR(10)||" ).append("\n"); 
		query.append("       CASE WHEN DTL.TRSP_MOD_CD = 'VD' OR (DTL.TRSP_MOD_CD = 'WD' AND DTL.VSL_CD IS NOT NULL) THEN" ).append("\n"); 
		query.append("       'LD_SVCLP_CD:'		||BV1.SLAN_CD				||CHR(10)||" ).append("\n"); 
		query.append("       'LD_VSL_CD:'		    ||BV1.VSL_CD				||CHR(10)||" ).append("\n"); 
		query.append("       'LD_VSL_NM:'		    ||MVC1.VSL_ENG_NM			||CHR(10)||" ).append("\n"); 
		query.append("       'LD_VSL_LOYD_CD:'	||MVC1.LLOYD_NO				||CHR(10)||" ).append("\n"); 
		query.append("       'LD_VSL_VOY_NO:'		||BV1.SKD_VOY_NO			||CHR(10)||" ).append("\n"); 
		query.append("       'LD_VSL_DIR:'		||BV1.SKD_DIR_CD			||CHR(10)||" ).append("\n"); 
		query.append("       'LD_VSL_CALL_SIGN:'	||MVC1.CALL_SGN_NO			||CHR(10)||" ).append("\n"); 
		query.append("       'LD_CONSORTIUM_VOY_NO:'		||VSK_COMMON_PKG.GET_CSSM_VOY_NO_FNC(BV1.vsl_cd,BV1.skd_voy_no,BV1.skd_dir_cd,BV1.POL_CD,'O')				||CHR(10)||" ).append("\n"); 
		query.append("       'DIS_SVCLP_CD:'		||BV1.SLAN_CD				||CHR(10)||" ).append("\n"); 
		query.append("       'DIS_VSL_CD:'		||BV1.VSL_CD				||CHR(10)||" ).append("\n"); 
		query.append("       'DIS_VSL_NM:'		||MVC1.VSL_ENG_NM		||CHR(10)||" ).append("\n"); 
		query.append("       'DIS_VSL_LOYD_CD:'	||MVC1.LLOYD_NO			||CHR(10)||" ).append("\n"); 
		query.append("       'DIS_VSL_VOY_NO:'	||BV1.SKD_VOY_NO		||CHR(10)||" ).append("\n"); 
		query.append("       'DIS_VSL_DIR:'		||BV1.SKD_DIR_CD		||CHR(10)||" ).append("\n"); 
		query.append("       'DIS_VSL_CALL_SIGN:'	||MVC1.CALL_SGN_NO	||CHR(10)||" ).append("\n"); 
		query.append("       'DIS_CONSORTIUM_VOY_NO:'		||VSK_COMMON_PKG.GET_CSSM_VOY_NO_FNC(BV1.vsl_cd,BV1.skd_voy_no,BV1.skd_dir_cd,BV1.POL_CD,'O')  				||CHR(10)" ).append("\n"); 
		query.append("        END ||" ).append("\n"); 
		query.append("       'ORG_ETD:'		    ||TO_CHAR(DTL.ARR_ST_DT, 'RRRRMMDDHH24MI')			    ||CHR(10)||" ).append("\n"); 
		query.append("       'ORG_ETD_GTM:'		||TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(MLO.LOC_CD,DTL.ARR_ST_DT,'GMT'), 'RRRRMMDDHH24MI')				||CHR(10)||" ).append("\n"); 
		query.append("       CASE WHEN DTL.TRSP_MOD_CD = 'VD' OR (DTL.TRSP_MOD_CD = 'WD' AND DTL.VSL_CD IS NOT NULL) THEN" ).append("\n"); 
		query.append("       (SELECT 'DEST_ETA:'		    ||TO_CHAR(SKD.VPS_ETA_DT, 'RRRRMMDDHH24MI')  ||CHR(10)||" ).append("\n"); 
		query.append("               'DEST_ETA_GTM:'		||TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(SKD.VPS_PORT_CD, SKD.VPS_ETA_DT,'GMT'), 'RRRRMMDDHH24MI')				||CHR(10)" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD SKD " ).append("\n"); 
		query.append("        WHERE SKD.VSL_CD = BV1.VSL_CD AND SKD.SKD_VOY_NO = BV1.SKD_VOY_NO AND SKD.SKD_DIR_CD = BV1.SKD_DIR_CD " ).append("\n"); 
		query.append("        AND SKD.VPS_PORT_CD = BV1.POD_CD AND SKD.CLPT_IND_SEQ = BV1.POD_CLPT_IND_SEQ AND ROWNUM = 1)" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("       'DEST_ETA:'		    ||TO_CHAR(DTL.DEP_FSH_DT, 'RRRRMMDDHH24MI')				||CHR(10)||" ).append("\n"); 
		query.append("       'DEST_ETA_GTM:'		||TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(MLD.LOC_CD, DTL.DEP_FSH_DT,'GMT'), 'RRRRMMDDHH24MI')				||CHR(10)" ).append("\n"); 
		query.append("       END ||" ).append("\n"); 
		query.append("       '}I_BKG_ROUTE'  I_BKG_ROUTE" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("     ,BKG_VVD BV1, MDM_VSL_CNTR MVC1" ).append("\n"); 
		query.append("     ,BKG_VVD BV2, MDM_VSL_CNTR MVC2" ).append("\n"); 
		query.append("     ,PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("     ,MDM_YARD MYO, MDM_LOCATION MLO, MDM_COUNTRY MCO" ).append("\n"); 
		query.append("     ,MDM_YARD MYD, MDM_LOCATION MLD, MDM_COUNTRY MCD" ).append("\n"); 
		query.append("     ,MDM_ZONE MZO, MDM_ZONE MZD" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.PCTL_NO = DTL.PCTL_NO" ).append("\n"); 
		query.append("AND DTL.ORG_NOD_CD = MYO.YD_CD(+)" ).append("\n"); 
		query.append("AND DTL.ORG_NOD_CD = MZO.ZN_CD(+)" ).append("\n"); 
		query.append("AND SUBSTR(DTL.ORG_NOD_CD,1,5) = MLO.LOC_CD" ).append("\n"); 
		query.append("AND SUBSTR(DTL.ORG_NOD_CD,1,2) = MCO.CNT_CD" ).append("\n"); 
		query.append("AND DTL.DEST_NOD_CD = MYD.YD_CD(+)" ).append("\n"); 
		query.append("AND DTL.DEST_NOD_CD = MZD.ZN_CD(+)" ).append("\n"); 
		query.append("AND SUBSTR(DTL.DEST_NOD_CD,1,5)= MLD.LOC_CD" ).append("\n"); 
		query.append("AND SUBSTR(DTL.DEST_NOD_CD,1,2) = MCD.CNT_CD" ).append("\n"); 
		query.append("AND DTL.TRSP_MOD_CD <> 'X'" ).append("\n"); 
		query.append("AND BV1.BKG_NO(+) = @[bkg_no]" ).append("\n"); 
		query.append("AND DTL.ORG_NOD_CD = BV1.POL_YD_CD(+)" ).append("\n"); 
		query.append("AND DTL.VSL_CD = BV1.VSL_CD(+)" ).append("\n"); 
		query.append("AND BV1.VSL_CD = MVC1.VSL_CD(+)" ).append("\n"); 
		query.append("AND BV2.BKG_NO(+) = @[bkg_no]" ).append("\n"); 
		query.append("AND DTL.DEST_NOD_CD = BV2.POL_YD_CD(+)" ).append("\n"); 
		query.append("AND BV2.VSL_CD = MVC2.VSL_CD(+)" ).append("\n"); 
		query.append("ORDER BY DTL.PCTL_SEQ" ).append("\n"); 

	}
}