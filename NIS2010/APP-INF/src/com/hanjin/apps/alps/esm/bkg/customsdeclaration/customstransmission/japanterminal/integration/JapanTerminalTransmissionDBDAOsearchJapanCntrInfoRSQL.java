/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchJapanCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.23
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2013.01.23 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchJapanCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchJapanCntrInfo 조회쿼리
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchJapanCntrInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchJapanCntrInfoRSQL").append("\n"); 
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
		query.append("--CNTR_SIZE" ).append("\n"); 
		query.append("--CNTR_TYPE" ).append("\n"); 
		query.append("--CNT             " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CNTR_TPSZ_CD, CNTR_TPSZ_ISO_CD, SUM(CNTR_VOL_QTY) COUNT" ).append("\n"); 
		query.append("--COUNT(CNTR_NO) COUNT" ).append("\n"); 
		query.append("FROM BKG_TML_EDI_JP_CNTR JC" ).append("\n"); 
		query.append("WHERE JC.BKG_NO LIKE SUBSTR(@[bkg_no], 1, 10)||'%'" ).append("\n"); 
		query.append("AND JC.BKG_SKD_SEQ = 0" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD, CNTR_TPSZ_ISO_CD" ).append("\n"); 
		query.append("ORDER BY CNTR_TPSZ_CD" ).append("\n"); 

	}
}