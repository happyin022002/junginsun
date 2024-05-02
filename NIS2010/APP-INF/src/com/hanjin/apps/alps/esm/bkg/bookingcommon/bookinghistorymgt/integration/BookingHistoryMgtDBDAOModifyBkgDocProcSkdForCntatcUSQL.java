/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOModifyBkgDocProcSkdForCntatcUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOModifyBkgDocProcSkdForCntatcUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 BKG에 container가 Attach된 순서이자 Container구분자인 EQ ID개념 추가
	  * Container화면에서 A컨테이너를 B로 변경 후 저장 시 A의 EQ ID를 B가 갖도록 변경해야 함.
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOModifyBkgDocProcSkdForCntatcUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_doc_proc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOModifyBkgDocProcSkdForCntatcUSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y' && ${bkg_doc_proc_tp_cd} == 'CNTATC') " ).append("\n"); 
		query.append("UPDATE BKG_DOC_PROC_SKD_HIS" ).append("\n"); 
		query.append("SET DIFF_RMK = @[diff_rmk] " ).append("\n"); 
		query.append("   ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("   ,UPD_DT = sysdate" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("   AND BKG_DOC_PROC_TP_CD = @[bkg_doc_proc_tp_cd] " ).append("\n"); 
		query.append("   AND DIFF_RMK = @[old_diff_rmk]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("UPDATE BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("SET DIFF_RMK = @[diff_rmk] " ).append("\n"); 
		query.append("   ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("   ,UPD_DT = sysdate" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("   AND BKG_DOC_PROC_TP_CD = @[bkg_doc_proc_tp_cd] " ).append("\n"); 
		query.append("   AND DIFF_RMK = @[old_diff_rmk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}