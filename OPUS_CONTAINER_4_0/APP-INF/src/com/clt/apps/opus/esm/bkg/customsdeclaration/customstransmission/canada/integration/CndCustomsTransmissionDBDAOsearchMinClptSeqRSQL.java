/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchMinClptSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchMinClptSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMinClptSeq
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchMinClptSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mbl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchMinClptSeqRSQL").append("\n"); 
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
		query.append("#if (${mbl_no} != '' || ${bkg_no} != '' || ${bl_no} != '')" ).append("\n"); 
		query.append("SELECT MAX(CLPT_SEQ) " ).append("\n"); 
		query.append("      ,MAX(VSL_SKD_FLG)" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT MIN(CLPT_SEQ) AS CLPT_SEQ" ).append("\n"); 
		query.append("          ,DECODE(NVL(MIN(VVD.VSL_CD), 'HJXX'), 'HJXX', 'N', 'HJYY', 'N', 'HJZZ', 'N', 'Y') AS VSL_SKD_FLG" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("          ,BKG_VVD VVD" ).append("\n"); 
		query.append("          ,VSK_VSL_PORT_SKD VSL" ).append("\n"); 
		query.append("     WHERE BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND VVD.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO = VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD = VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND NVL(VSL.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("       AND VSL.VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("    #if (${mbl_no} != '')" ).append("\n"); 
		query.append("       AND BKG.BL_NO = @[mbl_no]" ).append("\n"); 
		query.append("    #elseif (${bkg_no} != '')" ).append("\n"); 
		query.append("       AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    #elseif (${bl_no} != '')" ).append("\n"); 
		query.append("       AND BKG.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("   UNION " ).append("\n"); 
		query.append("    SELECT MIN(CLPT_SEQ) AS CLPT_SEQ" ).append("\n"); 
		query.append("          ,DECODE(NVL(MIN(VVD.VSL_CD), 'HJXX'), 'HJXX', 'N', 'HJYY', 'N', 'HJZZ', 'N', 'Y') AS VSL_SKD_FLG" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("          ,BKG_VVD VVD" ).append("\n"); 
		query.append("          ,BKG_HBL HBL" ).append("\n"); 
		query.append("          ,VSK_VSL_PORT_SKD VSL" ).append("\n"); 
		query.append("     WHERE BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND BKG.BKG_NO = HBL.BKG_NO" ).append("\n"); 
		query.append("       AND VVD.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO = VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD = VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND NVL(VSL.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("       AND VSL.VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("    #if (${mbl_no} != '')" ).append("\n"); 
		query.append("       AND BKG.BL_NO = @[mbl_no]" ).append("\n"); 
		query.append("    #elseif (${bkg_no} != '')" ).append("\n"); 
		query.append("       AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    #elseif (${bl_no} != '')" ).append("\n"); 
		query.append("       AND HBL.CNTR_MF_NO = @[bl_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#elseif (${vvd_cd} != '') " ).append("\n"); 
		query.append("SELECT MAX(CLPT_SEQ) " ).append("\n"); 
		query.append("      ,MAX(VSL_SKD_FLG)" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("    SELECT MIN(CLPT_SEQ) AS CLPT_SEQ" ).append("\n"); 
		query.append("          ,DECODE(SUBSTR(@[vvd_cd],1,4), 'HJXX', 'N', 'HJYY', 'N', 'HJZZ', 'N', 'Y') AS VSL_SKD_FLG" ).append("\n"); 
		query.append("      FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("     WHERE VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("       AND SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("       AND SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("       AND NVL(SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("       AND VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	SELECT 1 FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}