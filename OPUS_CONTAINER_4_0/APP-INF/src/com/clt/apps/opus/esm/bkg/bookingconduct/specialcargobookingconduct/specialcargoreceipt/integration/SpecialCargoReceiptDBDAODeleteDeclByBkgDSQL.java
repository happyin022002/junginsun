/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAODeleteDeclByBkgDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.28
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.04.28 Maeda Atsushi
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

public class SpecialCargoReceiptDBDAODeleteDeclByBkgDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_DG_DECL 데이터를 삭제한다.
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAODeleteDeclByBkgDSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAODeleteDeclByBkgDSQL").append("\n"); 
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
		query.append("DELETE FROM BKG_DG_DECL DECL" ).append("\n"); 
		query.append("WHERE DECL.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("	SELECT *" ).append("\n"); 
		query.append("	FROM BKG_DG_CGO CGO" ).append("\n"); 
		query.append("	WHERE CGO.BKG_NO = DECL.BKG_NO" ).append("\n"); 
		query.append("	AND CGO.DG_CNTR_SEQ = DECL.DG_CNTR_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}