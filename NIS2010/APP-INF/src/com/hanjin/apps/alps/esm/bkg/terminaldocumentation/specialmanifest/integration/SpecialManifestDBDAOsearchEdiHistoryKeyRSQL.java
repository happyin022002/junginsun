/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchEdiHistoryKeyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchEdiHistoryKeyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수신정보 키값(MSG_SND_NO) 조회
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchEdiHistoryKeyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msgTpId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("keyType",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchEdiHistoryKeyRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN @[keyType] = 'ANR' THEN" ).append("\n"); 
		query.append("@[msgTpId] || TO_CHAR(SYSDATE, 'YYMMDD') || LTRIM(TO_CHAR(BKG_CSTMS_EUR_DG_SEQ.NEXTVAL,'009'))" ).append("\n"); 
		query.append("|| '01'" ).append("\n"); 
		query.append("WHEN @[keyType] = 'CTA' THEN" ).append("\n"); 
		query.append("@[msgTpId] || TO_CHAR(SYSDATE, 'YYYYMMDD') || LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'000009'))" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("@[msgTpId] || LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'0000009'))" ).append("\n"); 
		query.append("END KEY_VAL" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}