/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RevenueDebitNoteDBDAOSearchAttachmentListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAOSearchAttachmentListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDN 증빙 자료(첨부파일)를 조회한다.
	  * </pre>
	  */
	public RevenueDebitNoteDBDAOSearchAttachmentListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rvis_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAOSearchAttachmentListRSQL").append("\n"); 
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
		query.append("SELECT R.RDN_NO, " ).append("\n"); 
		query.append("       R.RVIS_SEQ, " ).append("\n"); 
		query.append("       R.ATCH_FILE_LNK_ID," ).append("\n"); 
		query.append("       F.ATCH_FILE_LNK_SEQ," ).append("\n"); 
		query.append("       C.FILE_SAV_ID," ).append("\n"); 
		query.append("       C.FILE_UPLD_NM," ).append("\n"); 
		query.append("       C.FILE_SZ_CAPA," ).append("\n"); 
		query.append("       C.FILE_PATH_URL," ).append("\n"); 
		query.append("       '' CRE_USR_ID," ).append("\n"); 
		query.append("       '' UPD_USR_ID" ).append("\n"); 
		query.append("FROM BKG_REV_DR_NOTE R, BKG_ATCH_FILE F, COM_UPLD_FILE C" ).append("\n"); 
		query.append("WHERE R.RDN_NO = @[rdn_no]" ).append("\n"); 
		query.append("AND R.RVIS_SEQ = @[rvis_seq]" ).append("\n"); 
		query.append("AND R.ATCH_FILE_LNK_ID = F.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("AND F.FILE_SAV_ID = C.FILE_SAV_ID" ).append("\n"); 

	}
}