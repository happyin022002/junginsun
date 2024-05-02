/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchInboundTSInfoBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.15
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.11.15 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchInboundTSInfoBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchInboundTSInfoBLRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchInboundTSInfoBLRSQL").append("\n"); 
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
		query.append("SELECT BL.BKG_NO," ).append("\n"); 
		query.append("       BL.POR_CD," ).append("\n"); 
		query.append("       BL.POL_CD," ).append("\n"); 
		query.append("       BL.DEL_CD," ).append("\n"); 
		query.append("       (SELECT COM.CMDT_NM" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("               MDM_COMMODITY COM" ).append("\n"); 
		query.append("         WHERE BKG.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("           AND COM.CMDT_CD = BKG.CMDT_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS CMDT_NM," ).append("\n"); 
		query.append("       BL.PCK_QTY," ).append("\n"); 
		query.append("       BL.ACT_WGT," ).append("\n"); 
		query.append("       BL.MEAS_QTY," ).append("\n"); 
		query.append("       DSC.MK_DESC," ).append("\n"); 
		query.append("       DSC.CMDT_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_BL_DOC BL," ).append("\n"); 
		query.append("       BKG_BL_MK_DESC DSC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BL.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BL.BKG_NO = DSC.BKG_NO" ).append("\n"); 

	}
}