/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchMaxSeqAtResultRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.02
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.02 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchMaxSeqAtResultRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신 outVO : None, 연관VO: UsaResultCntrVO
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchMaxSeqAtResultRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchMaxSeqAtResultRSQL").append("\n"); 
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
		query.append("SELECT R.ICR_SEQ" ).append("\n"); 
		query.append("      ,C.OLD_CNTR_CFLAG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT NVL(MAX(CSTMS_SEQ), 0) + 1 AS ICR_SEQ" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_RSLT R" ).append("\n"); 
		query.append("         WHERE R.CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND R.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       )R" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT NVL(MAX(CSTMS_CLR_CD), 'N') AS OLD_CNTR_CFLAG" ).append("\n"); 
		query.append("          FROM BKG_CGO_RLSE" ).append("\n"); 
		query.append("         WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       )C" ).append("\n"); 

	}
}