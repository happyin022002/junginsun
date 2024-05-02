/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchLocInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusCustomsTransmissionDBDAOsearchLocInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchLocInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration").append("\n"); 
		query.append("FileName : AusCustomsTransmissionDBDAOsearchLocInfoRSQL").append("\n"); 
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
		query.append("SELECT 'BKGPOR' AS LOC_TP," ).append("\n"); 
		query.append("       (SELECT UN_LOC_CD" ).append("\n"); 
		query.append("          FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE MDM.LOC_CD = BKG.POR_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS UN_LOC_CD," ).append("\n"); 
		query.append("       (SELECT LOC_NM" ).append("\n"); 
		query.append("          FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE MDM.LOC_CD = BKG.POR_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS LOC_NM" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'BKGPOL' AS LOC_TP," ).append("\n"); 
		query.append("       (SELECT UN_LOC_CD" ).append("\n"); 
		query.append("          FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE MDM.LOC_CD = BKG.POL_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS UN_LOC_CD," ).append("\n"); 
		query.append("       (SELECT LOC_NM" ).append("\n"); 
		query.append("          FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE MDM.LOC_CD = BKG.POL_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS LOC_NM" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'BKGPOD' AS LOC_TP," ).append("\n"); 
		query.append("       (SELECT UN_LOC_CD" ).append("\n"); 
		query.append("          FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE MDM.LOC_CD = BKG.POD_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS UN_LOC_CD," ).append("\n"); 
		query.append("       (SELECT LOC_NM" ).append("\n"); 
		query.append("          FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE MDM.LOC_CD = BKG.POD_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS LOC_NM" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'BKGDEL' AS LOC_TP," ).append("\n"); 
		query.append("       (SELECT UN_LOC_CD" ).append("\n"); 
		query.append("          FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE MDM.LOC_CD = BKG.DEL_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS UN_LOC_CD," ).append("\n"); 
		query.append("       (SELECT LOC_NM" ).append("\n"); 
		query.append("          FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE MDM.LOC_CD = BKG.DEL_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS LOC_NM" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'VVDPOL' AS LOC_TP," ).append("\n"); 
		query.append("       (SELECT UN_LOC_CD" ).append("\n"); 
		query.append("          FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE MDM.LOC_CD = VVD.POL_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS UN_LOC_CD," ).append("\n"); 
		query.append("       (SELECT LOC_NM" ).append("\n"); 
		query.append("          FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE MDM.LOC_CD = VVD.POL_CD" ).append("\n"); 
		query.append("         AND ROWNUM = 1) AS LOC_NM" ).append("\n"); 
		query.append("  FROM BKG_VVD VVD" ).append("\n"); 
		query.append(" WHERE VVD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND VVD.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'VVDPOD' AS LOC_TP," ).append("\n"); 
		query.append("       (SELECT UN_LOC_CD" ).append("\n"); 
		query.append("          FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE MDM.LOC_CD = VVD.POD_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS UN_LOC_CD," ).append("\n"); 
		query.append("       (SELECT LOC_NM" ).append("\n"); 
		query.append("          FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE MDM.LOC_CD = VVD.POD_CD" ).append("\n"); 
		query.append("         AND ROWNUM = 1) AS LOC_NM" ).append("\n"); 
		query.append("  FROM BKG_VVD VVD" ).append("\n"); 
		query.append(" WHERE VVD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND VVD.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}