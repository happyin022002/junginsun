/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchInboundTSInfoSKDRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.15
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.11.15 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchInboundTSInfoSKDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchInboundTSInfoSKDRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n");
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchInboundTSInfoSKDRSQL").append("\n");
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
		query.append("SELECT SKD.VPS_PORT_CD," ).append("\n");
		query.append("       SKD.YD_CD," ).append("\n");
		query.append("       TO_CHAR(SKD.VPS_ETA_DT, 'YYYY-MM-DD') AS VPS_ETA_DT," ).append("\n");
		query.append("       YD.YD_NM," ).append("\n");
		query.append("       NM.VSL_ENG_NM" ).append("\n");
		query.append("" ).append("\n");
		query.append("  FROM VSK_VSL_PORT_SKD SKD," ).append("\n");
		query.append("       MDM_YARD YD," ).append("\n");
		query.append("       MDM_VSL_CNTR NM" ).append("\n");
		query.append("" ).append("\n");
		query.append(" WHERE (SKD.VSL_CD," ).append("\n");
		query.append("        SKD.SKD_VOY_NO," ).append("\n");
		query.append("        SKD.SKD_DIR_CD," ).append("\n");
		query.append("        SKD.VPS_PORT_CD) IN (SELECT /*+ INDEX_ASC(BKG_VVD XPKBKG_VVD) */" ).append("\n");
		query.append("                                VSL_CD," ).append("\n");
		query.append("                                SKD_VOY_NO," ).append("\n");
		query.append("                                SKD_DIR_CD," ).append("\n");
		query.append("                                POD_CD" ).append("\n");
		query.append("                           FROM BKG_VVD" ).append("\n");
		query.append("                          WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append("                            AND POD_CD LIKE 'CNSHA%'" ).append("\n");
		query.append("                            AND ROWNUM =1)" ).append("\n");
		query.append("   AND CLPT_IND_SEQ = '1'" ).append("\n");
		query.append("   AND SKD.YD_CD = YD.YD_CD" ).append("\n");
		query.append("   AND SKD.VSL_CD = NM.VSL_CD" ).append("\n");

	}
}