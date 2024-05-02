/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UserSetupMgtDBDAOSearchCustChkPntAttachFileLinkIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.13
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.07.13 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOSearchCustChkPntAttachFileLinkIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Attach File Link ID를 조회한다
	  * </pre>
	  */
	public UserSetupMgtDBDAOSearchCustChkPntAttachFileLinkIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_pnt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_chk_pnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOSearchCustChkPntAttachFileLinkIdRSQL").append("\n"); 
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
		query.append("SELECT ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("        FROM BKG_CUST_CHK_PNT" ).append("\n"); 
		query.append("        WHERE CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("        AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("		AND CHK_PNT_TP_CD = @[chk_pnt_tp_cd]" ).append("\n"); 
		query.append("		AND CUST_CHK_PNT_SEQ = @[cust_chk_pnt_seq]" ).append("\n"); 
		query.append("        AND ATCH_FILE_LNK_ID IS NOT NULL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  TO_CHAR(SYSDATE,'YYMM')|| LPAD(NVL(SUBSTR(MAX(ATCH_FILE_LNK_ID),5,10), 0) + 1, 6, '0') ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("        FROM    BKG_ATCH_FILE" ).append("\n"); 
		query.append("        WHERE   ATCH_FILE_LNK_ID  LIKE TO_CHAR(SYSDATE, 'YYMM') || '%'" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}