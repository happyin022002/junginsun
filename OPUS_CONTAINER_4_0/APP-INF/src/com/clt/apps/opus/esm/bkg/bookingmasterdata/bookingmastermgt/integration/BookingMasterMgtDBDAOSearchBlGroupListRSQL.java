/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchBlGroupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOSearchBlGroupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select BL Group List
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchBlGroupListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_pty_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchBlGroupListRSQL").append("\n"); 
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
		query.append("SELECT CTRL_PTY_SEQ," ).append("\n"); 
		query.append("       A.BL_GRP_SEQ," ).append("\n"); 
		query.append("	   A.BL_GRP_SEQ AS OLD_BL_GRP_SEQ," ).append("\n"); 
		query.append("       B.BL_GRP_NM  AS BL_GRP_NM," ).append("\n"); 
		query.append("       DECODE(BL_VW_RT_TP_CD,'U','Y','N') AS BL_VW_RT_TP_CD1," ).append("\n"); 
		query.append("       DECODE(BL_VW_RT_TP_CD,'F','Y','N') AS BL_VW_RT_TP_CD2," ).append("\n"); 
		query.append("       DECODE(BL_VW_RT_TP_CD,'P','Y','N') AS BL_VW_RT_TP_CD3," ).append("\n"); 
		query.append("       DECODE(BL_VW_RT_TP_CD,'C','Y','N') AS BL_VW_RT_TP_CD4," ).append("\n"); 
		query.append("	   BL_VW_RT_TP_CD," ).append("\n"); 
		query.append("       OBL_PRF_FLG," ).append("\n"); 
		query.append("       WBL_PRF_FLG," ).append("\n"); 
		query.append("       OBL_PRN_FLG," ).append("\n"); 
		query.append("       WBL_PRN_FLG," ).append("\n"); 
		query.append("       NON_NEGO_PRN_FLG," ).append("\n"); 
		query.append("       NTFY_PRF_FLG," ).append("\n"); 
		query.append("       NTFY_PRN_FLG," ).append("\n"); 
		query.append("       NTFY_AUTO_WBL_FLG," ).append("\n"); 
		query.append("	   A.UPD_USR_ID," ).append("\n"); 
		query.append("	   A.UPD_DT," ).append("\n"); 
		query.append("       FTP_SVR_NM," ).append("\n"); 
		query.append("       FTP_SVR_USR_NM," ).append("\n"); 
		query.append("       FTP_SVR_PWD," ).append("\n"); 
		query.append("       FTP_SVR_DIR_NM," ).append("\n"); 
		query.append("       RTY_KNT," ).append("\n"); 
		query.append("       RTY_ITVAL_NO," ).append("\n"); 
		query.append("       EML_CUST_FLG," ).append("\n"); 
		query.append("       EML_CUST_ADDR," ).append("\n"); 
		query.append("       EML_PDF_FLG," ).append("\n"); 
		query.append("       EML_PDF_ADDR," ).append("\n"); 
		query.append("       BL_TP_CD," ).append("\n"); 
		query.append("	   ALTN_DE_FLG," ).append("\n"); 
		query.append("	   XPT_FILE_NM," ).append("\n"); 
		query.append("	   FTP_DIR_CTNT," ).append("\n"); 
		query.append("       FTP_DIR_CTNT2," ).append("\n"); 
		query.append("       FTP_DIR_CTNT3," ).append("\n"); 
		query.append("       FTP_DIR_CTNT4," ).append("\n"); 
		query.append("	   ERR_NTC_FLG," ).append("\n"); 
		query.append("	   SCS_NTC_FLG" ).append("\n"); 
		query.append("FROM BKG_CTRL_PTY_BL_GRP A" ).append("\n"); 
		query.append("	 ,BKG_CTRL_BL_GRP B" ).append("\n"); 
		query.append("WHERE CTRL_PTY_SEQ = @[ctrl_pty_seq]" ).append("\n"); 
		query.append("AND B.BL_GRP_SEQ = A.BL_GRP_SEQ" ).append("\n"); 

	}
}