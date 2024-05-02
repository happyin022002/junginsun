/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchBlMarkDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusCustomsTransmissionDBDAOsearchBlMarkDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 호주세관 및 항만청으로 전송할 Manifest B/L Mark Description 정보를 조회한다.
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchBlMarkDescRSQL(){
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
		params.put("SELECT	REPLACE(REGEXP_REPLACE(REPLACE(DOC.PCK_CMDT_DESC,CHR(13)||CHR(10),'$$$$$'),'[^ a-zA-Z0-9~!@#$%^&*()-_+={}|:;,<.>/",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.integration").append("\n"); 
		query.append("FileName : AusCustomsTransmissionDBDAOsearchBlMarkDescRSQL").append("\n"); 
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
		query.append("SELECT	REPLACE(REGEXP_REPLACE(REPLACE(DOC.PCK_CMDT_DESC,CHR(13)||CHR(10),'$$$$$'),'[^ a-zA-Z0-9~!@#$%^&*()-_+={}|:;,<.>/]',' ', 1, 0, 'im'),'$$$$$',CHR(13)||CHR(10))||CHR(10)||" ).append("\n"); 
		query.append("        REPLACE(REGEXP_REPLACE(REPLACE(DOC.CNTR_CMDT_DESC,CHR(13)||CHR(10),'$$$$$'),'[^ a-zA-Z0-9~!@#$%^&*()-_+={}|:;,<.>/]',' ', 1, 0, 'im'),'$$$$$',CHR(13)||CHR(10))||CHR(10)||" ).append("\n"); 
		query.append("        REPLACE(REGEXP_REPLACE(REPLACE(BMD.CMDT_DESC,CHR(13)||CHR(10),'$$$$$'),'[^ a-zA-Z0-9~!@#$%^&*()-_+={}|:;,<.>/]',' ', 1, 0, 'im'),'$$$$$',CHR(13)||CHR(10)) CMDT_DESC," ).append("\n"); 
		query.append("        REPLACE(REGEXP_REPLACE(REPLACE(BMD.MK_DESC,CHR(13)||CHR(10),'$$$$$'),'[^ a-zA-Z0-9~!@#$%^&*()-_+={}|:;,<.>/]',' ', 1, 0, 'im'),'$$$$$',CHR(13)||CHR(10)) MK_DESC" ).append("\n"); 
		query.append("FROM BKG_BL_MK_DESC BMD, BKG_BL_DOC DOC" ).append("\n"); 
		query.append("WHERE	DOC.BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("AND     DOC.BKG_NO = BMD.BKG_NO" ).append("\n"); 

	}
}