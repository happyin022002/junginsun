/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SriLankaCustomsTransmissionDBDAOsearchContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.22 
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

public class SriLankaCustomsTransmissionDBDAOsearchContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_TOKEN_NL_FNC
	  * </pre>
	  */
	public SriLankaCustomsTransmissionDBDAOsearchContainerRSQL(){
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
		params.put("cgo_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.integration").append("\n"); 
		query.append("FileName : SriLankaCustomsTransmissionDBDAOsearchContainerRSQL").append("\n"); 
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
		query.append("#if(${ver_flg}=='O')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT '{CNTR_INFO'||CHR(10)||" ).append("\n"); 
		query.append("        'CNTRNBR:'||NVL(CNTR.CNTR_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("        'CNTRTYPE:'||NVL(CNTR_TPSZ_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("        'FM_IND:'||@[cgo_tp]||CHR(10)||" ).append("\n"); 
		query.append("        'CNTRWGT:'||DECODE(NVL(CNTR.WGT_UT_CD,' '),'LBS', ROUND(NVL(CNTR.CNTR_WGT,0)*0.4536,3),NVL(CNTR.CNTR_WGT,0))||CHR(10)||" ).append("\n"); 
		query.append("#if (${edi_mt_removal} != 'M')" ).append("\n"); 
		query.append("'CNTR_PKG:'||NVL(CNTR.PCK_QTY, 0)||CHR(10)||" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	'CNTR_PKG:'||'1'||CHR(10)||" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        'MEASURE:'||DECODE(NVL(CNTR.MEAS_UT_CD,' '),'CBF', ROUND(NVL(CNTR.MEAS_QTY,0)*0.0283,3), NVL(CNTR.MEAS_QTY,0))||CHR(10)||" ).append("\n"); 
		query.append("        'SEALNBR:'||" ).append("\n"); 
		query.append("		(  SELECT NVL(MIN(CNTR_SEAL_NO),' ') " ).append("\n"); 
		query.append("		   FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("		   WHERE BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("		   AND CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("		   )||CHR(10)||" ).append("\n"); 
		query.append("        '}CNTR_INFO'||CHR(10) cntr_desc" ).append("\n"); 
		query.append("FROM   BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("WHERE  CNTR.BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("#if ('' != ${cntr_nos})" ).append("\n"); 
		query.append("                     AND CNTR.CNTR_NO IN (''" ).append("\n"); 
		query.append("                     #foreach($cntr_no IN ${cntr_nos})" ).append("\n"); 
		query.append("                                ,'$cntr_no'" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT '{CNTR_INFO'||CHR(10)||" ).append("\n"); 
		query.append("        'CNTRNBR:'||NVL(CNTR.CNTR_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("        'CNTRTYPE:'||NVL(CNTR_TPSZ_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("        'FM_IND:'||@[cgo_tp]||CHR(10)||" ).append("\n"); 
		query.append("		(  	SELECT	SUBSTR(XMLAGG(XMLELEMENT( CNTR_SEAL_NO ,CHR(10)||'{SEAL_INFO'||CHR(10)||'SEALNBR:'||CNTR_SEAL_NO||CHR(10)||'SEAL_PT:'||SEAL_PTY_TP_CD||CHR(10)||'}SEAL_INFO') ORDER BY CNTR_SEAL_SEQ).EXTRACT('//text()'),1) EMP_LIST" ).append("\n"); 
		query.append("			FROM    BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("			WHERE	BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("			AND		CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("		   )||CHR(10)||" ).append("\n"); 
		query.append("        '}CNTR_INFO'||CHR(10) cntr_desc" ).append("\n"); 
		query.append("FROM   BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("WHERE  CNTR.BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("#if ('' != ${cntr_nos})" ).append("\n"); 
		query.append("                     AND CNTR.CNTR_NO IN (''" ).append("\n"); 
		query.append("                     #foreach($cntr_no IN ${cntr_nos})" ).append("\n"); 
		query.append("                                ,'$cntr_no'" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}