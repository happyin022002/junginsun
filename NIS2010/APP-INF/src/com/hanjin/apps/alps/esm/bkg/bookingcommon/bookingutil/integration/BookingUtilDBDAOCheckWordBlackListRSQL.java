/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAOCheckWordBlackListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOCheckWordBlackListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WORD_BLACK_LIST 에 있는 단어를 포함하는 지 CHECK
	  * </pre>
	  */
	public BookingUtilDBDAOCheckWordBlackListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("word",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("word_knd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOCheckWordBlackListRSQL").append("\n"); 
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
		query.append("SELECT BLCK_KW_NM" ).append("\n"); 
		query.append("   FROM BKG_BLCK_KW_LIST" ).append("\n"); 
		query.append("  WHERE BLCK_KW_TP_CD = 'YEL'" ).append("\n"); 
		query.append("    AND BLCK_KW_CTNT = @[word_knd]" ).append("\n"); 
		query.append("    AND ' '||REPLACE(REPLACE(REPLACE(UPPER(@[word]), CHR(13)||CHR(10),' '),CHR(13),' '),CHR(10),' ')||' ' " ).append("\n"); 
		query.append("        LIKE '% '||UPPER(BLCK_KW_NM)||' %'    " ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 

	}
}