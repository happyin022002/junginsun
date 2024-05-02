/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoRiderDBDAOsearchBlRiderListRSQL.java
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

public class SpecialCargoRiderDBDAOsearchBlRiderListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * b/l의 rider image 정보 list를 조회함
	  * </pre>
	  */
	public SpecialCargoRiderDBDAOsearchBlRiderListRSQL(){
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
		query.append("SELECT" ).append("\n");
		query.append("IMG.BKG_NO" ).append("\n");
		query.append(",IMG.RIDR_TP_CD" ).append("\n");
		query.append(",IMG.FILE_NM" ).append("\n");
		query.append(",UPLD.FILE_SZ_CAPA AS FILE_SIZE" ).append("\n");
		query.append(",IMG.IMG_SEQ" ).append("\n");
		query.append(",IMG.FILE_PATH_RMK" ).append("\n");
		query.append(",IMG.FILE_SAV_ID" ).append("\n");
		query.append(",IMG.RGST_OFC_CD" ).append("\n");
		query.append(",IMG.RGST_DT" ).append("\n");
		query.append(",IMG.RGST_USR_ID" ).append("\n");
		query.append("FROM BKG_IMG_STO IMG, COM_UPLD_FILE UPLD" ).append("\n");
		query.append("WHERE IMG.FILE_SAV_ID = UPLD.FILE_SAV_ID" ).append("\n");
		query.append("AND IMG.BKG_NO = @[bkg_no]" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.integration").append("\n");
		query.append("FileName : SpecialCargoRiderDBDAOsearchBlRiderListRSQL").append("\n");
		query.append("*/").append("\n");
	}
}