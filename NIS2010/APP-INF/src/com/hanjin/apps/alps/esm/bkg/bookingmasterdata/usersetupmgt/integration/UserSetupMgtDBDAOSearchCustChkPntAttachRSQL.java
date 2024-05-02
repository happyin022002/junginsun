/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UserSetupMgtDBDAOSearchCustChkPntAttachRSQL.java
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

public class UserSetupMgtDBDAOSearchCustChkPntAttachRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustChkPntAttach
	  * </pre>
	  */
	public UserSetupMgtDBDAOSearchCustChkPntAttachRSQL(){
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
		query.append("FileName : UserSetupMgtDBDAOSearchCustChkPntAttachRSQL").append("\n"); 
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
		query.append("SELECT R.CUST_CNT_CD, " ).append("\n"); 
		query.append("       R.CUST_SEQ," ).append("\n"); 
		query.append("       R.CHK_PNT_TP_CD," ).append("\n"); 
		query.append("       R.CUST_CHK_PNT_SEQ," ).append("\n"); 
		query.append("       R.ATCH_FILE_LNK_ID," ).append("\n"); 
		query.append("       F.ATCH_FILE_LNK_SEQ," ).append("\n"); 
		query.append("       C.FILE_SAV_ID," ).append("\n"); 
		query.append("       C.FILE_UPLD_NM," ).append("\n"); 
		query.append("       C.FILE_SZ_CAPA," ).append("\n"); 
		query.append("       C.FILE_PATH_URL," ).append("\n"); 
		query.append("       '' CRE_USR_ID," ).append("\n"); 
		query.append("       '' UPD_USR_ID" ).append("\n"); 
		query.append("FROM BKG_CUST_CHK_PNT R, BKG_ATCH_FILE F, COM_UPLD_FILE C" ).append("\n"); 
		query.append("WHERE R.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND R.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("AND R.CHK_PNT_TP_CD = @[chk_pnt_tp_cd]" ).append("\n"); 
		query.append("AND R.CUST_CHK_PNT_SEQ = @[cust_chk_pnt_seq]" ).append("\n"); 
		query.append("AND R.ATCH_FILE_LNK_ID = F.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("AND F.FILE_SAV_ID = C.FILE_SAV_ID" ).append("\n"); 

	}
}