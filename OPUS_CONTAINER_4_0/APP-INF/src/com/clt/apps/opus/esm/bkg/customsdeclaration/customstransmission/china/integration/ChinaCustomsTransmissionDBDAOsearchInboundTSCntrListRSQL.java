/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchInboundTSCntrListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.12
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.11.12 김상수
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

public class ChinaCustomsTransmissionDBDAOsearchInboundTSCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchInboundTSCntrListRSQL(){
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
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchInboundTSCntrListRSQL").append("\n");
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
		query.append("SELECT CNTR_NO," ).append("\n");
		query.append("       CNTR_TPSZ_CD," ).append("\n");
		query.append("       CNTR_WGT," ).append("\n");
		query.append("       MEAS_QTY AS CNTR_MEAS," ).append("\n");
		query.append("       (SELECT SEAL.CNTR_SEAL_NO" ).append("\n");
		query.append("          FROM BKG_CNTR_SEAL_NO SEAL" ).append("\n");
		query.append("         WHERE CNTR.BKG_NO = SEAL.BKG_NO" ).append("\n");
		query.append("           AND CNTR.CNTR_NO = SEAL.CNTR_NO" ).append("\n");
		query.append("           AND ROWNUM = 1) AS CNTR_SEAL_NO," ).append("\n");
		query.append("       (SELECT HSCD.CMDT_HS_CD" ).append("\n");
		query.append("         FROM BKG_CNTR_MF_DESC HSCD" ).append("\n");
		query.append("        WHERE CNTR.BKG_NO = HSCD.BKG_NO" ).append("\n");
		query.append("          AND CNTR.CNTR_NO = HSCD.CNTR_NO" ).append("\n");
		query.append("          AND ROWNUM = 1) AS CMDT_HS_CD" ).append("\n");
		query.append("" ).append("\n");
		query.append("  FROM BKG_CONTAINER CNTR" ).append("\n");
		query.append("" ).append("\n");
		query.append(" WHERE CNTR.BKG_NO = @[bkg_no]" ).append("\n");

	}
}