/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SriLankaCustomsTransmissionDBDAOsearchBlMarkDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.06 
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

public class SriLankaCustomsTransmissionDBDAOsearchBlMarkDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 스리랑카 세관 신고용 Manifest B/L Marks Description 정보를 조회한다.
	  * </pre>
	  */
	public SriLankaCustomsTransmissionDBDAOsearchBlMarkDescRSQL(){
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
		query.append("FileName : SriLankaCustomsTransmissionDBDAOsearchBlMarkDescRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${edi_mt_removal} != 'M')" ).append("\n"); 
		query.append("'{DESC'||CHR(10)||'DESC:' ||REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(DOC.PCK_CMDT_DESC||CHR(10)||'DESC:'||DOC.CNTR_CMDT_DESC||CHR(10)||'DESC:'||CMDT_DESC,'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\\\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)),CHR(13)||CHR(10),CHR(10)||'DESC:') ||CHR(10)||'}DESC'||CHR(10) CMDT_DESC," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'{DESC'||CHR(10)||'DESC:'||'Empty containers'||CHR(10)||'}DESC'||CHR(10) CMDT_DESC," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("DECODE(LENGTH(MK_DESC),NULL,'','{MARK'||CHR(10)||'MARKNO:' ||REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SUBSTR(MK_DESC,1,2660),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\\\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)),CHR(13)||CHR(10),CHR(10)||'MARKNO:') ||chr(10)||'}MARK'||CHR(10)  ) MK_DESC" ).append("\n"); 
		query.append("FROM   BKG_BL_MK_DESC MD, BKG_BL_DOC DOC" ).append("\n"); 
		query.append("WHERE  DOC.BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("AND		DOC.BKG_NO		= MD.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT 	'{MARKS_INFO'||CHR(10)||" ).append("\n"); 
		query.append("'MARKS1:'||BKG_SPCLCHAR_CONV_FNC(SUBSTR(TRIM(MK_DESC), 1, 35),'J')||CHR(10)||" ).append("\n"); 
		query.append("'MARKS2:'||BKG_SPCLCHAR_CONV_FNC(SUBSTR(TRIM(MK_DESC), 36, 35),'J')||CHR(10)||" ).append("\n"); 
		query.append("'MARKS3:'||BKG_SPCLCHAR_CONV_FNC(SUBSTR(TRIM(MK_DESC), 71, 35),'J')||CHR(10)||" ).append("\n"); 
		query.append("'}MARKS_INFO'||CHR(10) MK_DESC" ).append("\n"); 
		query.append("FROM 	BKG_BL_MK_DESC" ).append("\n"); 
		query.append("WHERE 	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}