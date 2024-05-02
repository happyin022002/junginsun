/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOmodifyBkgStwgInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2015.08.13 Maeda Atsushi
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

public class SpecialCargoReceiptDBDAOmodifyBkgStwgInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBkgStwgInfo
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOmodifyBkgStwgInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("stwg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOmodifyBkgStwgInfoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BOOKING SET " ).append("\n"); 
		query.append("#if (${apro_cd}== 'Y')" ).append("\n"); 
		query.append("	STWG_CD  = (SELECT STWG_CD " ).append("\n"); 
		query.append("				FROM BKG_STWG_CGO " ).append("\n"); 
		query.append("				WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				AND	  STWG_SEQ = @[stwg_seq])" ).append("\n"); 
		query.append(",	STWG_RMK = (SELECT STWG_RMK " ).append("\n"); 
		query.append("				FROM BKG_STWG_CGO " ).append("\n"); 
		query.append("				WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				AND	  STWG_SEQ = @[stwg_seq])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	STWG_CD = NULL" ).append("\n"); 
		query.append(",	STWG_RMK = NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}