/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Kor24ManifestListDBDAOsearchCNTRCntInfoListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.02
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.02.02 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOsearchCNTRCntInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Download 된 컨테이너 목록조회
	  * </pre>
	  */
	public Kor24ManifestListDBDAOsearchCNTRCntInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOsearchCNTRCntInfoListRSQL").append("\n");
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
		query.append("SELECT KC.BKG_NO        BKG_NO" ).append("\n");
		query.append(", KC.CNTR_NO       CNTR_NO" ).append("\n");
		query.append(", KC.FULL_MTY_CD   TP_CD" ).append("\n");
		query.append(", KC.CSTMS_BL_NO   BL_NO" ).append("\n");
		query.append("FROM BKG_CSTMS_ADV_KR_CNTR KC" ).append("\n");
		query.append("WHERE KC.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND KC.CSTMS_DECL_TP_CD =   @[tp_cd]" ).append("\n");
		query.append("AND KC.DMST_PORT_CD     =   @[port_cd]" ).append("\n");
		query.append("AND KC.CSTMS_BL_NO  	=   @[c_bl_no]" ).append("\n");
		query.append("AND KC.TRNS_SEQ         =   (   SELECT MAX(TRNS_SEQ)" ).append("\n");
		query.append("FROM BKG_CSTMS_ADV_KR_BL" ).append("\n");
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND CSTMS_DECL_TP_CD = @[tp_cd]" ).append("\n");
		query.append("AND DMST_PORT_CD     = @[port_cd]" ).append("\n");
		query.append("AND VSL_CD           = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n");
		query.append("AND SKD_VOY_NO       = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n");
		query.append("AND SKD_DIR_CD       = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n");
		query.append("AND KC.CSTMS_BL_NO   = @[c_bl_no]" ).append("\n");
		query.append(")" ).append("\n");

	}
}