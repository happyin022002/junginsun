/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.14
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiVvdRSQL(){
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
		params.put("edi_receive_id_old",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiVvdRSQL").append("\n"); 
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
		query.append("SELECT '{BKGVVD' || CHR(10)" ).append("\n"); 
		query.append("       || 'BVVD1:' || BV.VSL_CD || BV.SKD_VOY_NO || BV.SKD_DIR_CD || CHR(10)" ).append("\n"); 
		query.append("       || 'VSL_CALLSIGN1:' || V.CALL_SGN_NO || CHR(10)" ).append("\n"); 
		query.append("       || 'VSL_LLOYDCODE1:'|| V.LLOYD_NO || CHR(10)" ).append("\n"); 
		query.append("       || 'VSL_FULLNAME1:' || V.VSL_ENG_NM || CHR(10)" ).append("\n"); 
		query.append("       || 'BLPOL1:' ||" ).append("\n"); 
		query.append("                       CASE" ).append("\n"); 
		query.append("                          WHEN SUBSTR(@[edi_receive_id_old], 1, 8) = 'KTNETPCS' THEN" ).append("\n"); 
		query.append("                            DECODE(BV.POL_CD, 'KRPUS', DECODE(BV.POL_YD_CD, 'HN', 'KRPNC', 'YN', 'KRPNC', BV.POL_CD), BV.POL_CD)" ).append("\n"); 
		query.append("                          ELSE" ).append("\n"); 
		query.append("                            BV.POL_CD" ).append("\n"); 
		query.append("                       END || CHR(10)" ).append("\n"); 
		query.append("       || 'POL_FULLNAME1:' || POL.LOC_NM || CHR(10)" ).append("\n"); 
		query.append("       || 'BLPOD1:' ||" ).append("\n"); 
		query.append("                       CASE" ).append("\n"); 
		query.append("                          WHEN SUBSTR(@[edi_receive_id_old], 1, 8) = 'KTNETPCS' THEN" ).append("\n"); 
		query.append("                            DECODE(BV.POD_CD, 'KRPUS', DECODE(BV.POD_YD_CD, 'KRPUSHN', 'KRPNC', 'KRPUSYN', 'KRPNC', BV.POD_CD), BV.POD_CD)" ).append("\n"); 
		query.append("                          ELSE" ).append("\n"); 
		query.append("                            BV.POD_CD" ).append("\n"); 
		query.append("                       END || CHR(10)" ).append("\n"); 
		query.append("       || 'POD_FULLNAME1:' || POD.LOC_NM || CHR(10)" ).append("\n"); 
		query.append("       || 'POLETA1:' || TO_CHAR(VPS1.VPS_ETA_DT, 'RRRRMMDDHH24MI') || CHR(10)" ).append("\n"); 
		query.append("       || 'POLETD1:' || TO_CHAR(VPS1.VPS_ETD_DT, 'RRRRMMDDHH24MI') || CHR(10)" ).append("\n"); 
		query.append("       || 'PODETA1:' || TO_CHAR(VPS2.VPS_ETA_DT, 'RRRRMMDDHH24MI') || CHR(10)" ).append("\n"); 
		query.append("       || 'PODETD1:' || TO_CHAR(VPS2.VPS_ETD_DT, 'RRRRMMDDHH24MI') || CHR(10)" ).append("\n"); 
		query.append("       || 'VSLFLAG1:' || V.VSL_RGST_CNT_CD || CHR(10)" ).append("\n"); 
		query.append("       || '}BKGVVD' || CHR(10)" ).append("\n"); 
		query.append("FROM  BKG_VVD BV, MDM_VSL_CNTR V, MDM_LOCATION POL, MDM_LOCATION POD, VSK_VSL_PORT_SKD VPS1, VSK_VSL_PORT_SKD VPS2" ).append("\n"); 
		query.append("WHERE BV.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND BV.POL_CD = POL.LOC_CD" ).append("\n"); 
		query.append("  AND BV.POD_CD = POD.LOC_CD" ).append("\n"); 
		query.append("  AND BV.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("  AND BV.VSL_CD = VPS1.VSL_CD" ).append("\n"); 
		query.append("  AND BV.SKD_VOY_NO = VPS1.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND BV.SKD_DIR_CD = VPS1.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND BV.POL_CD = VPS1.VPS_PORT_CD" ).append("\n"); 
		query.append("  AND VPS1.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("  AND BV.VSL_CD = VPS2.VSL_CD" ).append("\n"); 
		query.append("  AND BV.SKD_VOY_NO = VPS2.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND BV.SKD_DIR_CD = VPS2.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND BV.POD_CD = VPS2.VPS_PORT_CD" ).append("\n"); 
		query.append("  AND VPS2.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("ORDER BY BV.VSL_PRE_PST_CD || BV.VSL_SEQ" ).append("\n"); 

	}
}