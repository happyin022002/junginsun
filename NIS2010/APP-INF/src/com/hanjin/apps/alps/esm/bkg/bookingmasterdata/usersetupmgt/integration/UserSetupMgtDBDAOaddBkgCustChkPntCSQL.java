/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UserSetupMgtDBDAOaddBkgCustChkPntCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.14
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.07.14 Do Soon Choi
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

public class UserSetupMgtDBDAOaddBkgCustChkPntCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgCustChkPnt
	  * </pre>
	  */
	public UserSetupMgtDBDAOaddBkgCustChkPntCSQL(){
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
		params.put("atch_file_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chk_pnt_itm_tp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_pnt_itm_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_pnt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pic_eml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOaddBkgCustChkPntCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CUST_CHK_PNT" ).append("\n"); 
		query.append("      (CUST_CNT_CD " ).append("\n"); 
		query.append("      ,CUST_SEQ " ).append("\n"); 
		query.append("      ,CHK_PNT_TP_CD " ).append("\n"); 
		query.append("      ,CUST_CHK_PNT_SEQ " ).append("\n"); 
		query.append("      ,BKG_OFC_CD " ).append("\n"); 
		query.append("      ,CHK_PNT_ITM_SEQ " ).append("\n"); 
		query.append("      ,CHK_PNT_ITM_TP_SEQ " ).append("\n"); 
		query.append("      ,CHK_PNT_RMK " ).append("\n"); 
		query.append("      ,PIC_EML " ).append("\n"); 
		query.append("      ,ATCH_FILE_LNK_ID " ).append("\n"); 
		query.append("      ,ATCH_FILE_KNT " ).append("\n"); 
		query.append("      ,DELT_FLG " ).append("\n"); 
		query.append("      ,CRE_USR_ID " ).append("\n"); 
		query.append("      ,CRE_DT " ).append("\n"); 
		query.append("      ,UPD_USR_ID " ).append("\n"); 
		query.append("      ,UPD_DT )" ).append("\n"); 
		query.append(" VALUES (" ).append("\n"); 
		query.append("      @[cust_cnt_cd]" ).append("\n"); 
		query.append("      ,@[cust_seq] " ).append("\n"); 
		query.append("      ,@[chk_pnt_tp_cd]" ).append("\n"); 
		query.append("      ,(SELECT NVL(MAX(CUST_CHK_PNT_SEQ),0)+1  AS SEQ FROM BKG_CUST_CHK_PNT" ).append("\n"); 
		query.append("    	WHERE CUST_CNT_CD = @[cust_cnt_cd] AND CUST_SEQ = @[cust_seq] AND CHK_PNT_TP_CD  = @[chk_pnt_tp_cd]) " ).append("\n"); 
		query.append("      ,@[bkg_ofc_cd] " ).append("\n"); 
		query.append("      ,@[chk_pnt_itm_seq] " ).append("\n"); 
		query.append("      ,@[chk_pnt_itm_tp_seq] " ).append("\n"); 
		query.append("      ,@[chk_pnt_rmk]" ).append("\n"); 
		query.append("      ,@[pic_eml] " ).append("\n"); 
		query.append("      ,@[atch_file_lnk_id] " ).append("\n"); 
		query.append("      ,NVL(@[atch_file_knt],0)" ).append("\n"); 
		query.append("      ,'N'" ).append("\n"); 
		query.append("      ,@[cre_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[upd_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE)" ).append("\n"); 

	}
}