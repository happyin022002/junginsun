/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingMasterMgtDBDAOAddRestrictCmdtFileCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOAddRestrictCmdtFileCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_IMP_IMG_STO 추가 (BkgImpImgStoVO)
	  * </pre>
	  */
	public BookingMasterMgtDBDAOAddRestrictCmdtFileCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_sav_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("file_path_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOAddRestrictCmdtFileCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_IMP_IMG_STO (" ).append("\n"); 
		query.append("   RGN_OFC_CD, LOC_CD, CNT_CD, DP_SEQ," ).append("\n"); 
		query.append("   IMG_SEQ, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   FILE_NM, FILE_PATH_RMK, " ).append("\n"); 
		query.append("   FILE_SAV_ID, FILE_DESC," ).append("\n"); 
		query.append("   CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT) " ).append("\n"); 
		query.append("VALUES " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[rgn_ofc_cd], DECODE(@[loc_cd],'ALL','*****',@[loc_cd]),@[cnt_cd],@[dp_seq]," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("NVL(MAX(IMG_SEQ),0)+1" ).append("\n"); 
		query.append("	FROM BKG_IMP_IMG_STO" ).append("\n"); 
		query.append("	WHERE " ).append("\n"); 
		query.append("	RGN_OFC_CD = @[rgn_ofc_cd]" ).append("\n"); 
		query.append("	AND CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("	AND LOC_CD = DECODE(@[loc_cd],'ALL','*****',@[loc_cd])" ).append("\n"); 
		query.append("	AND DP_SEQ = @[dp_seq]" ).append("\n"); 
		query.append("), " ).append("\n"); 
		query.append("@[file_nm], @[file_path_rmk], " ).append("\n"); 
		query.append("@[file_sav_id], @[file_desc]," ).append("\n"); 
		query.append("@[cre_usr_id], sysdate, @[upd_usr_id], sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}