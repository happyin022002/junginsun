/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoRiderDBDAOmanageBlRiderUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.18 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoRiderDBDAOmanageBlRiderUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * BKG_IMG_STO 수정 (BkgImgStoVO)
	  * </pre>
	  */
	public SpecialCargoRiderDBDAOmanageBlRiderUSQL(){
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
		query.append("UPDATE (" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("IMG.FILE_NM AS IMG_FILE_NM" ).append("\n");
		query.append(",IMG.FILE_PATH_RMK AS IMG_FILE_PATH" ).append("\n");
		query.append(",UPLD.FILE_UPLD_NM AS UPLD_FILE_NM" ).append("\n");
		query.append(",UPLD.FILE_PATH_URL AS UPLD_FILE_PATH" ).append("\n");
		query.append("FROM BKG_IMG_STO IMG, COM_UPLD_FILE UPLD" ).append("\n");
		query.append("WHERE IMG.FILE_SAV_ID = UPLD.FILE_SAV_ID" ).append("\n");
		query.append("AND IMG.BKG_NO = @[bkg_no]" ).append("\n");
		query.append(")" ).append("\n");
		query.append("SET" ).append("\n");
		query.append("IMG_FILE_NM = UPLD_FILE_NM," ).append("\n");
		query.append("IMG_FILE_PATH = UPLD_FILE_PATH" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.integration").append("\n");
		query.append("FileName : SpecialCargoRiderDBDAOmanageBlRiderUSQL").append("\n");
		query.append("*/").append("\n");
	}
}