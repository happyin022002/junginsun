/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpeckalCargoReceiptDBDAOsearchChnProhibitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpeckalCargoReceiptDBDAOsearchChnProhibitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpeckalCargoReceiptDBDAOsearchChnProhibitRSQL
	  * </pre>
	  */
	public SpeckalCargoReceiptDBDAOsearchChnProhibitRSQL(){
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
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpeckalCargoReceiptDBDAOsearchChnProhibitRSQL").append("\n"); 
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
		query.append("SELECT MAX(ATTR_CTNT6) FLAG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT VVD.ATTR_CTNT6" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("(SELECT VVD.BKG_NO, SKD3.YD_CD, ATTR_CTNT6" ).append("\n"); 
		query.append("FROM BKG_VVD VVD, VSK_VSL_PORT_SKD SKD1, VSK_VSL_PORT_SKD SKD2, VSK_VSL_PORT_SKD SKD3,BKG_HRD_CDG_CTNT UNNO" ).append("\n"); 
		query.append("WHERE VVD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND VVD.VSL_CD = SKD1.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.POL_CD = SKD1.VPS_PORT_CD" ).append("\n"); 
		query.append("AND VVD.VSL_CD = SKD2.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.POD_CD = SKD2.VPS_PORT_CD" ).append("\n"); 
		query.append("AND VVD.VSL_CD = SKD3.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = SKD3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = SKD3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND SKD3.CLPT_SEQ >= SKD1.CLPT_SEQ" ).append("\n"); 
		query.append("AND SKD3.CLPT_SEQ <= SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("AND SKD3.YD_CD IN ( SELECT ATTR_CTNT3 FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                                      WHERE HRD_CDG_ID ='DG_PRT' " ).append("\n"); 
		query.append("                                        AND ATTR_CTNT1 = 'YARD'      -- 포트별 " ).append("\n"); 
		query.append("                                        AND ATTR_CTNT2 ='PORT'" ).append("\n"); 
		query.append("                                        AND ATTR_CTNT10 ='Y'" ).append("\n"); 
		query.append("	               )" ).append("\n"); 
		query.append("AND SKD3.YD_CD = UNNO.ATTR_CTNT7" ).append("\n"); 
		query.append("AND SKD3.VPS_ETA_DT >= TO_DATE(UNNO.ATTR_CTNT4,'YYYY/MM/DD HH24:MI:SS') -- ETA FROM, BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("AND SKD3.VPS_ETA_DT <= TO_DATE(UNNO.ATTR_CTNT5,'YYYY/MM/DD HH24:MI:SS') -- ETA TO, BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("AND NVL(SKD3.SKD_CNG_STS_CD,'N') <> 'S'" ).append("\n"); 
		query.append("AND UNNO.HRD_CDG_ID ='DG_PRT' " ).append("\n"); 
		query.append("AND UNNO.ATTR_CTNT1 = 'UNNO'" ).append("\n"); 
		query.append("AND UNNO.ATTR_CTNT10 ='Y'" ).append("\n"); 
		query.append("AND @[imdg_un_no] = UNNO.ATTR_CTNT2" ).append("\n"); 
		query.append("AND @[imdg_clss_cd] = UNNO.ATTR_CTNT3" ).append("\n"); 
		query.append(") VVD" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL " ).append("\n"); 
		query.append("SELECT ATTR_CTNT6" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG, " ).append("\n"); 
		query.append("    BKG_VVD VVD1,  " ).append("\n"); 
		query.append("    VSK_VSL_PORT_SKD SKD1," ).append("\n"); 
		query.append("	BKG_HRD_CDG_CTNT DG" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND VVD1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND VVD1.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("AND VVD1.VSL_CD = SKD1.VSL_CD" ).append("\n"); 
		query.append("AND VVD1.SKD_VOY_NO = SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD1.SKD_DIR_CD = SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("AND BKG.POL_CD = VVD1.POL_CD" ).append("\n"); 
		query.append("AND VVD1.POL_YD_CD = SKD1.YD_CD -- 출발 SKD" ).append("\n"); 
		query.append("AND SKD1.YD_CD = DG.ATTR_CTNT3" ).append("\n"); 
		query.append("AND SKD1.VPS_ETA_DT >= TO_DATE(DG.ATTR_CTNT4,'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("AND SKD1.VPS_ETA_DT <=  TO_DATE(DG.ATTR_CTNT5,'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("AND @[imdg_clss_cd]  = ATTR_CTNT2" ).append("\n"); 
		query.append("AND 'DG_PRT' = DG.HRD_CDG_ID " ).append("\n"); 
		query.append("AND 'IMDG' = DG.ATTR_CTNT1" ).append("\n"); 
		query.append("AND 'Y' = DG.ATTR_CTNT10 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT ATTR_CTNT6" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG, " ).append("\n"); 
		query.append("    BKG_VVD VVD1,  " ).append("\n"); 
		query.append("    VSK_VSL_PORT_SKD SKD1," ).append("\n"); 
		query.append("	BKG_HRD_CDG_CTNT DG" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND VVD1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND VVD1.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("AND VVD1.VSL_CD = SKD1.VSL_CD" ).append("\n"); 
		query.append("AND VVD1.SKD_VOY_NO = SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD1.SKD_DIR_CD = SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("AND BKG.POD_CD = VVD1.POD_CD" ).append("\n"); 
		query.append("AND VVD1.POD_YD_CD = SKD1.YD_CD -- 출발 SKD" ).append("\n"); 
		query.append("AND SKD1.YD_CD = DG.ATTR_CTNT3" ).append("\n"); 
		query.append("AND SKD1.VPS_ETA_DT >= TO_DATE(DG.ATTR_CTNT4,'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("AND SKD1.VPS_ETA_DT <=  TO_DATE(DG.ATTR_CTNT5,'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("AND @[imdg_clss_cd]  = ATTR_CTNT2" ).append("\n"); 
		query.append("AND 'DG_PRT' = DG.HRD_CDG_ID " ).append("\n"); 
		query.append("AND 'IMDG' = DG.ATTR_CTNT1" ).append("\n"); 
		query.append("AND 'Y' = DG.ATTR_CTNT10 ) A" ).append("\n"); 

	}
}