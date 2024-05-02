/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SriLankaCustomsTransmissionDBDAOsearchCargoInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SriLankaCustomsTransmissionDBDAOsearchCargoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCargoInfo
	  * </pre>
	  */
	public SriLankaCustomsTransmissionDBDAOsearchCargoInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.integration").append("\n"); 
		query.append("FileName : SriLankaCustomsTransmissionDBDAOsearchCargoInfoRSQL").append("\n"); 
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
		query.append("SELECT  '{CARGO_INFO'||CHR(10)||" ).append("\n"); 
		query.append("        'CARGO_PKG:'||PCK_QTY||CHR(10)||" ).append("\n"); 
		query.append("        'PKG_TYPE:'||PCK_TP_CD||CHR(10)||" ).append("\n"); 
		query.append("		'CARGO_TEXT1:'||(SELECT	BKG_SPCLCHAR_CONV_FNC(SUBSTR(CMDT_DESC,1,512),'J') MK_DESC" ).append("\n"); 
		query.append("                                   	FROM    BKG_BL_MK_DESC" ).append("\n"); 
		query.append("                                    WHERE   BKG_NO = DOC.BKG_NO)||CHR(10)||" ).append("\n"); 
		query.append("       	'CARGO_TEXT2:'|| 'SMLM'||BKG_NO||CHR(10)||" ).append("\n"); 
		query.append("      	'CARGO_VOL:'||MEAS_QTY||CHR(10)||" ).append("\n"); 
		query.append("        'CARGO_VOL_UNIT:'||MEAS_UT_CD||CHR(10)||" ).append("\n"); 
		query.append("        'CARGO_WGT:'||ACT_WGT||CHR(10)||" ).append("\n"); 
		query.append("        'CARGO_WGT_UNIT:'||WGT_UT_CD||CHR(10)||" ).append("\n"); 
		query.append("        'HS_CD:'||( SELECT  CMDT_HS_CD" ).append("\n"); 
		query.append("        	        FROM    BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("                    WHERE   BKG_NO  = DOC.BKG_NO" ).append("\n"); 
		query.append("                    AND     CMDT_HS_CD IS NOT NULL" ).append("\n"); 
		query.append("                    AND     ROWNUM = 1)||CHR(10)||" ).append("\n"); 
		query.append("        (	SELECT	SUBSTR(XMLAGG(XMLELEMENT( CNTR_NO ,CHR(10)||'{SPLIT_INFO'||CHR(10)||'CNTR_REF:'||CNTR_NO||CHR(10)||'CNTR_PKG:'||PCK_QTY||CHR(10)||'}SPLIT_INFO') ORDER BY CNTR_NO).EXTRACT('//text()'),1) SPLIT_INFO" ).append("\n"); 
		query.append("            FROM    BKG_CONTAINER" ).append("\n"); 
		query.append("            WHERE  	BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("                        )||CHR(10) CARGO_DESC" ).append("\n"); 
		query.append("FROM   BKG_BL_DOC DOC" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}