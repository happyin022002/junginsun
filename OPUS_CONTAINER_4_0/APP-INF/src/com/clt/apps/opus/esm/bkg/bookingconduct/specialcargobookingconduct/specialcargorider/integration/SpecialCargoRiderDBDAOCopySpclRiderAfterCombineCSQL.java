/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoRiderDBDAOCopySpclRiderAfterCombineCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoRiderDBDAOCopySpclRiderAfterCombineCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DG rider를 Master booking으로 이동
	  * </pre>
	  */
	public SpecialCargoRiderDBDAOCopySpclRiderAfterCombineCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mst_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.integration").append("\n"); 
		query.append("FileName : SpecialCargoRiderDBDAOCopySpclRiderAfterCombineCSQL").append("\n"); 
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
		query.append("INSERT " ).append("\n"); 
		query.append("INTO BKG_IMG_STO SRC" ).append("\n"); 
		query.append("(BKG_NO" ).append("\n"); 
		query.append(",IMG_SEQ" ).append("\n"); 
		query.append(",RIDR_TP_CD" ).append("\n"); 
		query.append(",DCGO_SEQ" ).append("\n"); 
		query.append(",AWK_CGO_SEQ" ).append("\n"); 
		query.append(",BB_CGO_SEQ" ).append("\n"); 
		query.append(",FILE_NM" ).append("\n"); 
		query.append(",FILE_PATH_RMK" ).append("\n"); 
		query.append(",FILE_SAV_ID" ).append("\n"); 
		query.append(",FILE_DESC" ).append("\n"); 
		query.append(",RGST_OFC_CD" ).append("\n"); 
		query.append(",RGST_DT" ).append("\n"); 
		query.append(",RGST_USR_ID" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT)" ).append("\n"); 
		query.append("SELECT @[mst_bkg_no] ," ).append("\n"); 
		query.append("  ( SELECT NVL(MAX(TGT.IMG_SEQ), 0) + NVL(SRC.IMG_SEQ, 1)" ).append("\n"); 
		query.append("    FROM BKG_IMG_STO TGT" ).append("\n"); 
		query.append("    WHERE TGT.BKG_NO = @[mst_bkg_no])," ).append("\n"); 
		query.append("  RIDR_TP_CD ," ).append("\n"); 
		query.append("  NULL DCGO_SEQ ," ).append("\n"); 
		query.append("  NULL AWK_CGO_SEQ ," ).append("\n"); 
		query.append("  NULL BB_CGO_SEQ ," ).append("\n"); 
		query.append("  FILE_NM ," ).append("\n"); 
		query.append("  FILE_PATH_RMK ," ).append("\n"); 
		query.append("  FILE_SAV_ID ," ).append("\n"); 
		query.append("  FILE_DESC ," ).append("\n"); 
		query.append("  RGST_OFC_CD ," ).append("\n"); 
		query.append("  RGST_DT ," ).append("\n"); 
		query.append("  RGST_USR_ID ," ).append("\n"); 
		query.append("  @[usr_id] CRE_USR_ID ," ).append("\n"); 
		query.append("  SYSDATE ," ).append("\n"); 
		query.append("  @[usr_id] UPD_USR_ID ," ).append("\n"); 
		query.append("  SYSDATE" ).append("\n"); 
		query.append("FROM BKG_IMG_STO SRC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND RIDR_TP_CD = 'D'" ).append("\n"); 

	}
}