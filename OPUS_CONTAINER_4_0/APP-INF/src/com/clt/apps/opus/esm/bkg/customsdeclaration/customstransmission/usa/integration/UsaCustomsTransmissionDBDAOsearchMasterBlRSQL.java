/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchMasterBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.11 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchMasterBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신 outVO : None, 연관VO: UsaResultCntrVO
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchMasterBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_nvobl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_hjbl",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchMasterBlRSQL").append("\n"); 
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
		query.append("SELECT BL_NO in_bl" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append(" WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		BL_NO = SUBSTR(@[in_hjbl], 1, 12)" ).append("\n"); 
		query.append("		OR" ).append("\n"); 
		query.append("		BL_NO = SUBSTR(@[in_hjbl], 5, 12)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT BL_NO" ).append("\n"); 
		query.append("  FROM BKG_BOOKING I" ).append("\n"); 
		query.append("      ,BKG_USA_CSTMS_FILE_NO N" ).append("\n"); 
		query.append(" WHERE I.BKG_NO = N.BKG_NO" ).append("\n"); 
		query.append("   AND I.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("   AND N.USA_CSTMS_FILE_NO = @[in_nvobl]" ).append("\n"); 

	}
}