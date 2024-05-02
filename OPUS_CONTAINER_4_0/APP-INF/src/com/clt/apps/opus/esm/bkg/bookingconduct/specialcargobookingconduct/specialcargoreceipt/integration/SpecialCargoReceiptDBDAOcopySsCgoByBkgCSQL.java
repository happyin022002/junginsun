/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOcopySsCgoByBkgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.12
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2015.01.12 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOcopySsCgoByBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * copySsCgoByBkg
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOcopySsCgoByBkgCSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOcopySsCgoByBkgCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_STWG_CGO(BKG_NO" ).append("\n"); 
		query.append("        , STWG_SEQ" ).append("\n"); 
		query.append("        , STWG_CD" ).append("\n"); 
		query.append("        , STWG_RMK" ).append("\n"); 
		query.append("#if(${copy_mode_cd} != 'C')" ).append("\n"); 
		query.append("        , RQST_DT" ).append("\n"); 
		query.append("        , RQST_USR_ID" ).append("\n"); 
		query.append("        , SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT)" ).append("\n"); 
		query.append("SELECT @[mst_bkg_no] BKG_NO" ).append("\n"); 
		query.append("        , STWG_SEQ" ).append("\n"); 
		query.append("        , STWG_CD" ).append("\n"); 
		query.append("        , STWG_RMK" ).append("\n"); 
		query.append("#if(${copy_mode_cd} != 'C')" ).append("\n"); 
		query.append("        , RQST_DT" ).append("\n"); 
		query.append("        , RQST_USR_ID" ).append("\n"); 
		query.append("        , SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , @[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("  FROM BKG_STWG_CGO " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no] " ).append("\n"); 

	}
}