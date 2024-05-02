/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BangladeshCustomsTransmissionDBDAOsearchBlMarkDescRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.10
*@LastModifier :
*@LastVersion : 1.0
* 2014.12.10
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BangladeshCustomsTransmissionDBDAOsearchBlMarkDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 방글라데시 세관 신고용 Manifest B/L Marks Description 정보를 조회한다.
	  * </pre>
	  */
	public BangladeshCustomsTransmissionDBDAOsearchBlMarkDescRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.integration").append("\n");
		query.append("FileName : BangladeshCustomsTransmissionDBDAOsearchBlMarkDescRSQL").append("\n");
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
		query.append("SELECT   SUBSTR('{DESC'||CHR(10)||'DESC:' ||REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(DOC.PCK_CMDT_DESC||CHR(10)||'DESC:'||DOC.CNTR_CMDT_DESC||CHR(10)||'DESC:'||CMDT_DESC,'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'''',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)),CHR(10),CHR(10)||'DESC:') ||CHR(10)||'}DESC'||CHR(10), 1, 4000) CMDT_DESC," ).append("\n");
		query.append("         DECODE(LENGTH(MK_DESC),NULL,'',SUBSTR('{MARK'||CHR(10)||'MARKNO:' ||REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(BKG_SPCLCHAR_CONV_FNC(MK_DESC, 'M'),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'''',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)),CHR(10),CHR(10)||'MARKNO:') ||chr(10)||'}MARK'||CHR(10), 1, 4000)  ) MK_DESC" ).append("\n");
		query.append("        FROM   BKG_BL_MK_DESC MD, BKG_BL_DOC DOC" ).append("\n");
		query.append("        WHERE  DOC.BKG_NO        = @[bkg_no]" ).append("\n");
		query.append("		AND		DOC.BKG_NO		= MD.BKG_NO" ).append("\n");

	}
}