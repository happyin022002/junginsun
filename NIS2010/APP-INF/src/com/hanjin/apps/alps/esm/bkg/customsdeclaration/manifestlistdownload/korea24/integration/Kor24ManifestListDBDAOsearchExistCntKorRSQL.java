/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Kor24ManifestListDBDAOsearchExistCntKorRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.30
*@LastModifier :
*@LastVersion : 1.0
* 2012.05.30
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOsearchExistCntKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 전송할 DATA 가 존재하는지 조회
	  * </pre>
	  */
	public Kor24ManifestListDBDAOsearchExistCntKorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_tml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOsearchExistCntKorRSQL").append("\n");
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
		query.append("SELECT COUNT(*) CNT" ).append("\n");
		query.append("FROM BKG_CSTMS_ADV_KR_BL" ).append("\n");
		query.append("WHERE VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("AND DMST_PORT_CD = @[port_cd]" ).append("\n");
		query.append("AND ((@[in_type] = 'D' AND DECODE(KR_CSTMS_BND_CD,NULL,'N',' ','N',KR_CSTMS_BND_CD) IN ('A','B','C','M')) OR" ).append("\n");
		query.append("(@[in_type] IN ('A','B','C','M') AND DECODE(KR_CSTMS_BND_CD,NULL,'N',' ','N',KR_CSTMS_BND_CD) = @[in_type]) OR" ).append("\n");
		query.append("(@[in_type] = 'N' AND DECODE(KR_CSTMS_BND_CD,NULL,'N',' ','N',KR_CSTMS_BND_CD) = @[in_type]))" ).append("\n");
		query.append("AND DECODE(@[io_bnd_cd],'I',CSTMS_DECL_TP_CD,'I') IN ('I','T')" ).append("\n");
		query.append("AND DECODE(@[io_bnd_cd],'O',CSTMS_DECL_TP_CD,'E') IN ('E','R')" ).append("\n");
		query.append("AND DECODE(@[io_bnd_cd],'I',TS_POD_CD,TS_POL_CD) = DECODE(@[io_bnd_cd], 'I', @[pod_cd], @[pol_cd])" ).append("\n");
		query.append("AND DECODE(@[io_bnd_cd],'I',DECODE(LENGTH(@[pod_tml]),7,PORT_TML_CD,' '),' ') = DECODE(@[io_bnd_cd],'I',DECODE(LENGTH(@[pod_tml]),7,@[pod_tml],' '),' ')" ).append("\n");

	}
}