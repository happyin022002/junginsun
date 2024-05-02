/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CgmCodeMgtDBDAOsearchChssExptVerStsCdOfBeforeSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.17
*@LastModifier : 한종희
*@LastVersion : 1.0
* 2014.06.17 한종희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Justin(Jonghee) HAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOsearchChssExptVerStsCdOfBeforeSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * -----------------------------------------------------------------------------------------------------------------------------------------------------------
	  * 2014-06-17 BY JUSTIN HAN NEW CSR ID : CHM-201430737, TITLE ALPS-CHSS-Invoice에서 chassis estimated Expense 로직 수정 요청
	  *                  Accept 상태 Exception에 대해서만 Effective Date를 수정하도록 Proproal no, Sequence별 최종 Status Check
	  * -----------------------------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public CgmCodeMgtDBDAOsearchChssExptVerStsCdOfBeforeSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOsearchChssExptVerStsCdOfBeforeSeqRSQL").append("\n"); 
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
		query.append("SELECT TRIM(UPPER(CHSS_EXPT_VER_STS_CD)) FROM CGM_SC_EXPT_VER_PROG" ).append("\n"); 
		query.append(" WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND PROG_SEQ = (" ).append("\n"); 
		query.append("                   SELECT NVL(MAX(PROG_SEQ), 0)" ).append("\n"); 
		query.append("                     FROM CGM_SC_EXPT_VER_PROG" ).append("\n"); 
		query.append("                    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                      AND SC_EXPT_VER_SEQ = @[sc_expt_ver_seq]" ).append("\n"); 
		query.append("                   )" ).append("\n"); 

	}
}