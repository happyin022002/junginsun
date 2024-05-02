/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoRiderDBDAOmanageBlRiderDSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.19 이진서
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

public class SpecialCargoRiderDBDAOmanageBlRiderDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * BKG_IMG_STO 삭제 (BkgImgStoVO)
	  * </pre>
	  */
	public SpecialCargoRiderDBDAOmanageBlRiderDSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("img_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE FROM BKG_IMG_STO" ).append("\n");
		query.append("WHERE" ).append("\n");
		query.append("BKG_NO = @[bkg_no]" ).append("\n");
		query.append("#if (${gubun} == 'SpclRider')" ).append("\n");
		query.append("AND FILE_SAV_ID = @[file_sav_id]" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("AND	IMG_SEQ = @[img_seq]" ).append("\n");
		query.append("#end" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.integration").append("\n");
		query.append("FileName : SpecialCargoRiderDBDAOmanageBlRiderDSQL").append("\n");
		query.append("*/").append("\n");
	}
}