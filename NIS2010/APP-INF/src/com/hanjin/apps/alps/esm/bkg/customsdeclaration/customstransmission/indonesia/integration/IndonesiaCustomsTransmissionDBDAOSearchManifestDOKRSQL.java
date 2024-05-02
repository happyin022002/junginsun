/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndonesiaCustomsTransmissionDBDAOSearchManifestDOKRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndonesiaCustomsTransmissionDBDAOSearchManifestDOKRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Indonesia 세관에 Manifest 신고할 내용을 download 받을 File로 생성하기 위해 DOK 정보를 조회한다.
	  * </pre>
	  */
	public IndonesiaCustomsTransmissionDBDAOSearchManifestDOKRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.integration").append("\n"); 
		query.append("FileName : IndonesiaCustomsTransmissionDBDAOSearchManifestDOKRSQL").append("\n"); 
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
		query.append("SELECT	DECODE(ID_DECL_CD, 'E', 'PEB', 'K', 'PKB', ' ')	||" ).append("\n"); 
		query.append("NVL(ID_OFC_ID, '      ')									||" ).append("\n"); 
		query.append("DECODE(ID_XPT_NO, NULL, '      ', TRIM(TO_CHAR(ID_XPT_NO, '000000')))	||" ).append("\n"); 
		query.append("TO_CHAR(ID_XPT_NO_ISS_DT, 'YYYYMMDD') DOK" ).append("\n"); 
		query.append("FROM	BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("WHERE   BKG_NO 			= @[bkg_no]" ).append("\n"); 
		query.append("AND IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND CNT_CD = 'ID'" ).append("\n"); 
		query.append("ORDER BY XPT_IMP_SEQ" ).append("\n"); 

	}
}